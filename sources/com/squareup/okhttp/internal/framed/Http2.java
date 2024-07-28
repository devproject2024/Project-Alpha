package com.squareup.okhttp.internal.framed;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.framed.FrameReader;
import com.squareup.okhttp.internal.framed.Hpack;
import i.c;
import i.d;
import i.e;
import i.f;
import i.v;
import i.w;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.one97.paytm.upi.util.UpiConstants;

public final class Http2 implements Variant {
    /* access modifiers changed from: private */
    public static final f CONNECTION_PREFACE = f.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(FrameLogger.class.getName());

    public final Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public final FrameReader newReader(e eVar, boolean z) {
        return new Reader(eVar, 4096, z);
    }

    public final FrameWriter newWriter(d dVar, boolean z) {
        return new Writer(dVar, z);
    }

    static final class Reader implements FrameReader {
        private final boolean client;
        private final ContinuationSource continuation = new ContinuationSource(this.source);
        final Hpack.Reader hpackReader;
        private final e source;

        Reader(e eVar, int i2, boolean z) {
            this.source = eVar;
            this.client = z;
            this.hpackReader = new Hpack.Reader(i2, this.continuation);
        }

        public final void readConnectionPreface() throws IOException {
            if (!this.client) {
                f d2 = this.source.d((long) Http2.CONNECTION_PREFACE.size());
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(String.format("<< CONNECTION %s", new Object[]{d2.hex()}));
                }
                if (!Http2.CONNECTION_PREFACE.equals(d2)) {
                    throw Http2.ioException("Expected a connection header but was %s", d2.utf8());
                }
            }
        }

        public final boolean nextFrame(FrameReader.Handler handler) throws IOException {
            try {
                this.source.a(9);
                int access$300 = Http2.readMedium(this.source);
                if (access$300 < 0 || access$300 > Http2.INITIAL_MAX_FRAME_SIZE) {
                    throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(access$300));
                }
                byte g2 = (byte) (this.source.g() & 255);
                byte g3 = (byte) (this.source.g() & 255);
                int i2 = this.source.i() & Integer.MAX_VALUE;
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(FrameLogger.formatHeader(true, i2, access$300, g2, g3));
                }
                switch (g2) {
                    case 0:
                        readData(handler, access$300, g3, i2);
                        break;
                    case 1:
                        readHeaders(handler, access$300, g3, i2);
                        break;
                    case 2:
                        readPriority(handler, access$300, g3, i2);
                        break;
                    case 3:
                        readRstStream(handler, access$300, g3, i2);
                        break;
                    case 4:
                        readSettings(handler, access$300, g3, i2);
                        break;
                    case 5:
                        readPushPromise(handler, access$300, g3, i2);
                        break;
                    case 6:
                        readPing(handler, access$300, g3, i2);
                        break;
                    case 7:
                        readGoAway(handler, access$300, g3, i2);
                        break;
                    case 8:
                        readWindowUpdate(handler, access$300, g3, i2);
                        break;
                    default:
                        this.source.i((long) access$300);
                        break;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        private void readHeaders(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            short s = 0;
            if (i3 != 0) {
                boolean z = (b2 & 1) != 0;
                if ((b2 & 8) != 0) {
                    s = (short) (this.source.g() & 255);
                }
                if ((b2 & 32) != 0) {
                    readPriority(handler, i3);
                    i2 -= 5;
                }
                handler.headers(false, z, i3, -1, readHeaderBlock(Http2.lengthWithoutPadding(i2, b2, s), s, b2, i3), HeadersMode.HTTP_20_HEADERS);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }

        private List<Header> readHeaderBlock(int i2, short s, byte b2, int i3) throws IOException {
            ContinuationSource continuationSource = this.continuation;
            continuationSource.left = i2;
            continuationSource.length = i2;
            continuationSource.padding = s;
            continuationSource.flags = b2;
            continuationSource.streamId = i3;
            this.hpackReader.readHeaders();
            return this.hpackReader.getAndResetHeaderList();
        }

        private void readData(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            boolean z = true;
            short s = 0;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.source.g() & 255);
                }
                handler.data(z2, i3, this.source, Http2.lengthWithoutPadding(i2, b2, s));
                this.source.i((long) s);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }

        private void readPriority(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            if (i2 != 5) {
                throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            } else if (i3 != 0) {
                readPriority(handler, i3);
            } else {
                throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
        }

        private void readPriority(FrameReader.Handler handler, int i2) throws IOException {
            int i3 = this.source.i();
            handler.priority(i2, i3 & Integer.MAX_VALUE, (this.source.g() & 255) + 1, (Integer.MIN_VALUE & i3) != 0);
        }

        private void readRstStream(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            if (i2 != 4) {
                throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            } else if (i3 != 0) {
                int i4 = this.source.i();
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(i4);
                if (fromHttp2 != null) {
                    handler.rstStream(i3, fromHttp2);
                } else {
                    throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i4));
                }
            } else {
                throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
        }

        private void readSettings(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            if (i3 != 0) {
                throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            } else if ((b2 & 1) != 0) {
                if (i2 == 0) {
                    handler.ackSettings();
                    return;
                }
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            } else if (i2 % 6 == 0) {
                Settings settings = new Settings();
                for (int i4 = 0; i4 < i2; i4 += 6) {
                    short h2 = this.source.h();
                    int i5 = this.source.i();
                    switch (h2) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (!(i5 == 0 || i5 == 1)) {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                        case 3:
                            h2 = 4;
                            break;
                        case 4:
                            h2 = 7;
                            if (i5 >= 0) {
                                break;
                            } else {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        case 5:
                            if (i5 >= Http2.INITIAL_MAX_FRAME_SIZE && i5 <= 16777215) {
                                break;
                            } else {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                            }
                            break;
                        default:
                            throw Http2.ioException("PROTOCOL_ERROR invalid settings id: %s", Short.valueOf(h2));
                    }
                    settings.set(h2, 0, i5);
                }
                handler.settings(false, settings);
                if (settings.getHeaderTableSize() >= 0) {
                    this.hpackReader.headerTableSizeSetting(settings.getHeaderTableSize());
                }
            } else {
                throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            }
        }

        private void readPushPromise(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            short s = 0;
            if (i3 != 0) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.source.g() & 255);
                }
                handler.pushPromise(i3, this.source.i() & Integer.MAX_VALUE, readHeaderBlock(Http2.lengthWithoutPadding(i2 - 4, b2, s), s, b2, i3));
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }

        private void readPing(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            boolean z = false;
            if (i2 != 8) {
                throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            } else if (i3 == 0) {
                int i4 = this.source.i();
                int i5 = this.source.i();
                if ((b2 & 1) != 0) {
                    z = true;
                }
                handler.ping(z, i4, i5);
            } else {
                throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
            }
        }

        private void readGoAway(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            if (i2 < 8) {
                throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            } else if (i3 == 0) {
                int i4 = this.source.i();
                int i5 = this.source.i();
                int i6 = i2 - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(i5);
                if (fromHttp2 != null) {
                    f fVar = f.EMPTY;
                    if (i6 > 0) {
                        fVar = this.source.d((long) i6);
                    }
                    handler.goAway(i4, fromHttp2, fVar);
                    return;
                }
                throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i5));
            } else {
                throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i2, byte b2, int i3) throws IOException {
            if (i2 == 4) {
                long i4 = ((long) this.source.i()) & 2147483647L;
                if (i4 != 0) {
                    handler.windowUpdate(i3, i4);
                } else {
                    throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(i4));
                }
            } else {
                throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            }
        }

        public final void close() throws IOException {
            this.source.close();
        }
    }

    static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final c hpackBuffer = new c();
        private final Hpack.Writer hpackWriter = new Hpack.Writer(this.hpackBuffer);
        private int maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        private final d sink;

        Writer(d dVar, boolean z) {
            this.sink = dVar;
            this.client = z;
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void ackSettings(Settings settings) throws IOException {
            if (!this.closed) {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                frameHeader(0, 0, (byte) 4, (byte) 1);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void connectionPreface() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (this.client) {
                if (Http2.logger.isLoggable(Level.FINE)) {
                    Http2.logger.fine(String.format(">> CONNECTION %s", new Object[]{Http2.CONNECTION_PREFACE.hex()}));
                }
                this.sink.c(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
            }
        }

        public final synchronized void synStream(boolean z, boolean z2, int i2, int i3, List<Header> list) throws IOException {
            if (!z2) {
                try {
                    if (!this.closed) {
                        headers(z, i2, list);
                    } else {
                        throw new IOException("closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }

        public final synchronized void synReply(boolean z, int i2, List<Header> list) throws IOException {
            if (!this.closed) {
                headers(z, i2, list);
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void headers(int i2, List<Header> list) throws IOException {
            if (!this.closed) {
                headers(false, i2, list);
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void pushPromise(int i2, int i3, List<Header> list) throws IOException {
            if (!this.closed) {
                this.hpackWriter.writeHeaders(list);
                long j = this.hpackBuffer.f46277b;
                int min = (int) Math.min((long) (this.maxFrameSize - 4), j);
                long j2 = (long) min;
                int i4 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                frameHeader(i2, min + 4, Http2.TYPE_PUSH_PROMISE, i4 == 0 ? (byte) 4 : 0);
                this.sink.h(i3 & Integer.MAX_VALUE);
                this.sink.write(this.hpackBuffer, j2);
                if (i4 > 0) {
                    writeContinuationFrames(i2, j - j2);
                }
            } else {
                throw new IOException("closed");
            }
        }

        /* access modifiers changed from: package-private */
        public final void headers(boolean z, int i2, List<Header> list) throws IOException {
            if (!this.closed) {
                this.hpackWriter.writeHeaders(list);
                long j = this.hpackBuffer.f46277b;
                int min = (int) Math.min((long) this.maxFrameSize, j);
                long j2 = (long) min;
                int i3 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                byte b2 = i3 == 0 ? (byte) 4 : 0;
                if (z) {
                    b2 = (byte) (b2 | 1);
                }
                frameHeader(i2, min, (byte) 1, b2);
                this.sink.write(this.hpackBuffer, j2);
                if (i3 > 0) {
                    writeContinuationFrames(i2, j - j2);
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        private void writeContinuationFrames(int i2, long j) throws IOException {
            while (j > 0) {
                int min = (int) Math.min((long) this.maxFrameSize, j);
                long j2 = (long) min;
                j -= j2;
                frameHeader(i2, min, Http2.TYPE_CONTINUATION, j == 0 ? (byte) 4 : 0);
                this.sink.write(this.hpackBuffer, j2);
            }
        }

        public final synchronized void rstStream(int i2, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode != -1) {
                frameHeader(i2, 4, Http2.TYPE_RST_STREAM, (byte) 0);
                this.sink.h(errorCode.httpCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final int maxDataLength() {
            return this.maxFrameSize;
        }

        public final synchronized void data(boolean z, int i2, c cVar, int i3) throws IOException {
            if (!this.closed) {
                dataFrame(i2, z ? (byte) 1 : 0, cVar, i3);
            } else {
                throw new IOException("closed");
            }
        }

        /* access modifiers changed from: package-private */
        public final void dataFrame(int i2, byte b2, c cVar, int i3) throws IOException {
            frameHeader(i2, i3, (byte) 0, b2);
            if (i3 > 0) {
                this.sink.write(cVar, (long) i3);
            }
        }

        public final synchronized void settings(Settings settings) throws IOException {
            if (!this.closed) {
                int i2 = 0;
                frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
                while (i2 < 10) {
                    if (settings.isSet(i2)) {
                        this.sink.i(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                        this.sink.h(settings.get(i2));
                    }
                    i2++;
                }
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void ping(boolean z, int i2, int i3) throws IOException {
            if (!this.closed) {
                frameHeader(0, 8, Http2.TYPE_PING, z ? (byte) 1 : 0);
                this.sink.h(i2);
                this.sink.h(i3);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void goAway(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode != -1) {
                frameHeader(0, bArr.length + 8, Http2.TYPE_GOAWAY, (byte) 0);
                this.sink.h(i2);
                this.sink.h(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.sink.c(bArr);
                }
                this.sink.flush();
            } else {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
        }

        public final synchronized void windowUpdate(int i2, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            } else {
                frameHeader(i2, 4, (byte) 8, (byte) 0);
                this.sink.h((int) j);
                this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            this.closed = true;
            this.sink.close();
        }

        /* access modifiers changed from: package-private */
        public final void frameHeader(int i2, int i3, byte b2, byte b3) throws IOException {
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(false, i2, i3, b2, b3));
            }
            int i4 = this.maxFrameSize;
            if (i3 > i4) {
                throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            } else if ((Integer.MIN_VALUE & i2) == 0) {
                Http2.writeMedium(this.sink, i3);
                this.sink.j(b2 & 255);
                this.sink.j(b3 & 255);
                this.sink.h(i2 & Integer.MAX_VALUE);
            } else {
                throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i2));
            }
        }
    }

    /* access modifiers changed from: private */
    public static IllegalArgumentException illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* access modifiers changed from: private */
    public static IOException ioException(String str, Object... objArr) throws IOException {
        throw new IOException(String.format(str, objArr));
    }

    static final class ContinuationSource implements v {
        byte flags;
        int left;
        int length;
        short padding;
        private final e source;
        int streamId;

        public final void close() throws IOException {
        }

        public ContinuationSource(e eVar) {
            this.source = eVar;
        }

        public final long read(c cVar, long j) throws IOException {
            while (true) {
                int i2 = this.left;
                if (i2 == 0) {
                    this.source.i((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(cVar, Math.min(j, (long) i2));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            }
        }

        public final w timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws IOException {
            int i2 = this.streamId;
            int access$300 = Http2.readMedium(this.source);
            this.left = access$300;
            this.length = access$300;
            byte g2 = (byte) (this.source.g() & 255);
            this.flags = (byte) (this.source.g() & 255);
            if (Http2.logger.isLoggable(Level.FINE)) {
                Http2.logger.fine(FrameLogger.formatHeader(true, this.streamId, this.length, g2, this.flags));
            }
            this.streamId = this.source.i() & Integer.MAX_VALUE;
            if (g2 != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(g2));
            } else if (this.streamId != i2) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public static int lengthWithoutPadding(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }

    static final class FrameLogger {
        private static final String[] BINARY = new String[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
        private static final String[] FLAGS = new String[64];
        private static final String[] TYPES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        FrameLogger() {
        }

        static String formatHeader(boolean z, int i2, int i3, byte b2, byte b3) {
            String[] strArr = TYPES;
            String format = b2 < strArr.length ? strArr[b2] : String.format("0x%02x", new Object[]{Byte.valueOf(b2)});
            String formatFlags = formatFlags(b2, b3);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = format;
            objArr[4] = formatFlags;
            return String.format("%s 0x%08x %5d %-13s %s", objArr);
        }

        static String formatFlags(byte b2, byte b3) {
            if (b3 == 0) {
                return "";
            }
            if (!(b2 == 2 || b2 == 3)) {
                if (b2 == 4 || b2 == 6) {
                    return b3 == 1 ? "ACK" : BINARY[b3];
                }
                if (!(b2 == 7 || b2 == 8)) {
                    String[] strArr = FLAGS;
                    String str = b3 < strArr.length ? strArr[b3] : BINARY[b3];
                    if (b2 == 5 && (b3 & 4) != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b2 != 0 || (b3 & 32) == 0) {
                        return str;
                    }
                    return str.replace("PRIORITY", "COMPRESSED");
                }
            }
            return BINARY[b3];
        }

        static {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String[] strArr = BINARY;
                if (i3 >= strArr.length) {
                    break;
                }
                strArr[i3] = String.format("%8s", new Object[]{Integer.toBinaryString(i3)}).replace(' ', '0');
                i3++;
            }
            String[] strArr2 = FLAGS;
            strArr2[0] = "";
            strArr2[1] = "END_STREAM";
            int[] iArr = {1};
            strArr2[8] = "PADDED";
            for (int i4 = 0; i4 <= 0; i4++) {
                int i5 = iArr[i4];
                FLAGS[i5 | 8] = FLAGS[i5] + "|PADDED";
            }
            String[] strArr3 = FLAGS;
            strArr3[4] = "END_HEADERS";
            strArr3[32] = "PRIORITY";
            strArr3[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr2[i6];
                for (int i8 = 0; i8 <= 0; i8++) {
                    int i9 = iArr[i8];
                    String[] strArr4 = FLAGS;
                    int i10 = i9 | i7;
                    strArr4[i10] = FLAGS[i9] + '|' + FLAGS[i7];
                    FLAGS[i10 | 8] = FLAGS[i9] + '|' + FLAGS[i7] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr5 = FLAGS;
                if (i2 < strArr5.length) {
                    if (strArr5[i2] == null) {
                        strArr5[i2] = BINARY[i2];
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static int readMedium(e eVar) throws IOException {
        return (eVar.g() & 255) | ((eVar.g() & 255) << 16) | ((eVar.g() & 255) << 8);
    }

    /* access modifiers changed from: private */
    public static void writeMedium(d dVar, int i2) throws IOException {
        dVar.j((i2 >>> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        dVar.j((i2 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        dVar.j(i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
    }
}
