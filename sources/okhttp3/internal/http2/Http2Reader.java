package okhttp3.internal.http2;

import i.c;
import i.e;
import i.f;
import i.v;
import i.w;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation = new ContinuationSource(this.source);
    final Hpack.Reader hpackReader = new Hpack.Reader(4096, this.continuation);
    private final e source;

    interface Handler {
        void ackSettings();

        void alternateService(int i2, String str, f fVar, String str2, int i3, long j);

        void data(boolean z, int i2, e eVar, int i3) throws IOException;

        void goAway(int i2, ErrorCode errorCode, f fVar);

        void headers(boolean z, int i2, int i3, List<Header> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<Header> list) throws IOException;

        void rstStream(int i2, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i2, long j);
    }

    Http2Reader(e eVar, boolean z) {
        this.source = eVar;
        this.client = z;
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        if (!this.client) {
            f d2 = this.source.d((long) Http2.CONNECTION_PREFACE.size());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", d2.hex()));
            }
            if (!Http2.CONNECTION_PREFACE.equals(d2)) {
                throw Http2.ioException("Expected a connection header but was %s", d2.utf8());
            }
        } else if (!nextFrame(true, handler)) {
            throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
        }
    }

    public final boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.a(9);
            int readMedium = readMedium(this.source);
            if (readMedium < 0 || readMedium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
            }
            byte g2 = (byte) (this.source.g() & 255);
            if (!z || g2 == 4) {
                byte g3 = (byte) (this.source.g() & 255);
                int i2 = this.source.i() & Integer.MAX_VALUE;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.frameLog(true, i2, readMedium, g2, g3));
                }
                switch (g2) {
                    case 0:
                        readData(handler, readMedium, g3, i2);
                        break;
                    case 1:
                        readHeaders(handler, readMedium, g3, i2);
                        break;
                    case 2:
                        readPriority(handler, readMedium, g3, i2);
                        break;
                    case 3:
                        readRstStream(handler, readMedium, g3, i2);
                        break;
                    case 4:
                        readSettings(handler, readMedium, g3, i2);
                        break;
                    case 5:
                        readPushPromise(handler, readMedium, g3, i2);
                        break;
                    case 6:
                        readPing(handler, readMedium, g3, i2);
                        break;
                    case 7:
                        readGoAway(handler, readMedium, g3, i2);
                        break;
                    case 8:
                        readWindowUpdate(handler, readMedium, g3, i2);
                        break;
                    default:
                        this.source.i((long) readMedium);
                        break;
                }
                return true;
            }
            throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(g2));
        } catch (IOException unused) {
            return false;
        }
    }

    private void readHeaders(Handler handler, int i2, byte b2, int i3) throws IOException {
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
            handler.headers(z, i3, -1, readHeaderBlock(lengthWithoutPadding(i2, b2, s), s, b2, i3));
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

    private void readData(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            boolean z = true;
            boolean z2 = (b2 & 1) != 0;
            if ((b2 & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b2 & 8) != 0) {
                    s = (short) (this.source.g() & 255);
                }
                handler.data(z2, i3, this.source, lengthWithoutPadding(i2, b2, s));
                this.source.i((long) s);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void readPriority(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
        } else if (i3 != 0) {
            readPriority(handler, i3);
        } else {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void readPriority(Handler handler, int i2) throws IOException {
        int i3 = this.source.i();
        handler.priority(i2, i3 & Integer.MAX_VALUE, (this.source.g() & 255) + 1, (Integer.MIN_VALUE & i3) != 0);
    }

    private void readRstStream(Handler handler, int i2, byte b2, int i3) throws IOException {
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

    private void readSettings(Handler handler, int i2, byte b2, int i3) throws IOException {
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
                short h2 = this.source.h() & 65535;
                int i5 = this.source.i();
                if (h2 != 1) {
                    if (h2 != 2) {
                        if (h2 == 3) {
                            h2 = 4;
                        } else if (h2 == 4) {
                            h2 = 7;
                            if (i5 < 0) {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        } else if (h2 == 5 && (i5 < 16384 || i5 > 16777215)) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                        }
                    } else if (!(i5 == 0 || i5 == 1)) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                }
                settings.set(h2, i5);
            }
            handler.settings(false, settings);
        } else {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
        }
    }

    private void readPushPromise(Handler handler, int i2, byte b2, int i3) throws IOException {
        short s = 0;
        if (i3 != 0) {
            if ((b2 & 8) != 0) {
                s = (short) (this.source.g() & 255);
            }
            handler.pushPromise(i3, this.source.i() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i2 - 4, b2, s), s, b2, i3));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void readPing(Handler handler, int i2, byte b2, int i3) throws IOException {
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

    private void readGoAway(Handler handler, int i2, byte b2, int i3) throws IOException {
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

    private void readWindowUpdate(Handler handler, int i2, byte b2, int i3) throws IOException {
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

    static final class ContinuationSource implements v {
        byte flags;
        int left;
        int length;
        short padding;
        private final e source;
        int streamId;

        public final void close() throws IOException {
        }

        ContinuationSource(e eVar) {
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
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte g2 = (byte) (this.source.g() & 255);
            this.flags = (byte) (this.source.g() & 255);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, g2, this.flags));
            }
            this.streamId = this.source.i() & Integer.MAX_VALUE;
            if (g2 != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(g2));
            } else if (this.streamId != i2) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int readMedium(e eVar) throws IOException {
        return (eVar.g() & 255) | ((eVar.g() & 255) << 16) | ((eVar.g() & 255) << 8);
    }

    static int lengthWithoutPadding(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }
}
