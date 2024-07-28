package com.squareup.okhttp.internal.framed;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import i.c;
import i.d;
import i.e;
import i.f;
import i.g;
import i.n;
import i.u;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;

public final class Spdy3 implements Variant {
    static final byte[] DICTIONARY;
    static final int FLAG_FIN = 1;
    static final int FLAG_UNIDIRECTIONAL = 2;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 8;
    static final int TYPE_PING = 6;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_SYN_REPLY = 2;
    static final int TYPE_SYN_STREAM = 1;
    static final int TYPE_WINDOW_UPDATE = 9;
    static final int VERSION = 3;

    public final Protocol getProtocol() {
        return Protocol.SPDY_3;
    }

    static {
        try {
            DICTIONARY = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }

    public final FrameReader newReader(e eVar, boolean z) {
        return new Reader(eVar, z);
    }

    public final FrameWriter newWriter(d dVar, boolean z) {
        return new Writer(dVar, z);
    }

    static final class Reader implements FrameReader {
        private final boolean client;
        private final NameValueBlockReader headerBlockReader = new NameValueBlockReader(this.source);
        private final e source;

        public final void readConnectionPreface() {
        }

        Reader(e eVar, boolean z) {
            this.source = eVar;
            this.client = z;
        }

        public final boolean nextFrame(FrameReader.Handler handler) throws IOException {
            boolean z = false;
            try {
                int i2 = this.source.i();
                int i3 = this.source.i();
                int i4 = (-16777216 & i3) >>> 24;
                int i5 = i3 & 16777215;
                if ((Integer.MIN_VALUE & i2) != 0) {
                    int i6 = (2147418112 & i2) >>> 16;
                    int i7 = i2 & 65535;
                    if (i6 == 3) {
                        switch (i7) {
                            case 1:
                                readSynStream(handler, i4, i5);
                                return true;
                            case 2:
                                readSynReply(handler, i4, i5);
                                return true;
                            case 3:
                                readRstStream(handler, i4, i5);
                                return true;
                            case 4:
                                readSettings(handler, i4, i5);
                                return true;
                            case 6:
                                readPing(handler, i4, i5);
                                return true;
                            case 7:
                                readGoAway(handler, i4, i5);
                                return true;
                            case 8:
                                readHeaders(handler, i4, i5);
                                return true;
                            case 9:
                                readWindowUpdate(handler, i4, i5);
                                return true;
                            default:
                                this.source.i((long) i5);
                                return true;
                        }
                    } else {
                        throw new ProtocolException("version != 3: ".concat(String.valueOf(i6)));
                    }
                } else {
                    int i8 = i2 & Integer.MAX_VALUE;
                    if ((i4 & 1) != 0) {
                        z = true;
                    }
                    handler.data(z, i8, this.source, i5);
                    return true;
                }
            } catch (IOException unused) {
                return false;
            }
        }

        private void readSynStream(FrameReader.Handler handler, int i2, int i3) throws IOException {
            int i4 = this.source.i() & Integer.MAX_VALUE;
            int i5 = this.source.i() & Integer.MAX_VALUE;
            this.source.h();
            List<Header> readNameValueBlock = this.headerBlockReader.readNameValueBlock(i3 - 10);
            handler.headers((i2 & 2) != 0, (i2 & 1) != 0, i4, i5, readNameValueBlock, HeadersMode.SPDY_SYN_STREAM);
        }

        private void readSynReply(FrameReader.Handler handler, int i2, int i3) throws IOException {
            handler.headers(false, (i2 & 1) != 0, this.source.i() & Integer.MAX_VALUE, -1, this.headerBlockReader.readNameValueBlock(i3 - 4), HeadersMode.SPDY_REPLY);
        }

        private void readRstStream(FrameReader.Handler handler, int i2, int i3) throws IOException {
            if (i3 == 8) {
                int i4 = this.source.i() & Integer.MAX_VALUE;
                int i5 = this.source.i();
                ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(i5);
                if (fromSpdy3Rst != null) {
                    handler.rstStream(i4, fromSpdy3Rst);
                } else {
                    throw ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i5));
                }
            } else {
                throw ioException("TYPE_RST_STREAM length: %d != 8", Integer.valueOf(i3));
            }
        }

        private void readHeaders(FrameReader.Handler handler, int i2, int i3) throws IOException {
            handler.headers(false, false, this.source.i() & Integer.MAX_VALUE, -1, this.headerBlockReader.readNameValueBlock(i3 - 4), HeadersMode.SPDY_HEADERS);
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i2, int i3) throws IOException {
            if (i3 == 8) {
                int i4 = this.source.i() & Integer.MAX_VALUE;
                long i5 = (long) (this.source.i() & Integer.MAX_VALUE);
                if (i5 != 0) {
                    handler.windowUpdate(i4, i5);
                } else {
                    throw ioException("windowSizeIncrement was 0", Long.valueOf(i5));
                }
            } else {
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", Integer.valueOf(i3));
            }
        }

        private void readPing(FrameReader.Handler handler, int i2, int i3) throws IOException {
            boolean z = true;
            if (i3 == 4) {
                int i4 = this.source.i();
                if (this.client != ((i4 & 1) == 1)) {
                    z = false;
                }
                handler.ping(z, i4, 0);
                return;
            }
            throw ioException("TYPE_PING length: %d != 4", Integer.valueOf(i3));
        }

        private void readGoAway(FrameReader.Handler handler, int i2, int i3) throws IOException {
            if (i3 == 8) {
                int i4 = this.source.i() & Integer.MAX_VALUE;
                int i5 = this.source.i();
                ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(i5);
                if (fromSpdyGoAway != null) {
                    handler.goAway(i4, fromSpdyGoAway, f.EMPTY);
                } else {
                    throw ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i5));
                }
            } else {
                throw ioException("TYPE_GOAWAY length: %d != 8", Integer.valueOf(i3));
            }
        }

        private void readSettings(FrameReader.Handler handler, int i2, int i3) throws IOException {
            int i4 = this.source.i();
            boolean z = false;
            if (i3 == (i4 * 8) + 4) {
                Settings settings = new Settings();
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = this.source.i();
                    int i7 = (-16777216 & i6) >>> 24;
                    settings.set(i6 & 16777215, i7, this.source.i());
                }
                if ((i2 & 1) != 0) {
                    z = true;
                }
                handler.settings(z, settings);
                return;
            }
            throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", Integer.valueOf(i3), Integer.valueOf(i4));
        }

        private static IOException ioException(String str, Object... objArr) throws IOException {
            throw new IOException(String.format(str, objArr));
        }

        public final void close() throws IOException {
            this.headerBlockReader.close();
        }
    }

    static final class Writer implements FrameWriter {
        private final boolean client;
        private boolean closed;
        private final c headerBlockBuffer = new c();
        private final d headerBlockOut;
        private final d sink;

        public final void ackSettings(Settings settings) {
        }

        public final int maxDataLength() {
            return 16383;
        }

        public final void pushPromise(int i2, int i3, List<Header> list) throws IOException {
        }

        Writer(d dVar, boolean z) {
            this.sink = dVar;
            this.client = z;
            Deflater deflater = new Deflater();
            deflater.setDictionary(Spdy3.DICTIONARY);
            this.headerBlockOut = n.a((u) new g((u) this.headerBlockBuffer, deflater));
        }

        public final synchronized void connectionPreface() {
        }

        public final synchronized void flush() throws IOException {
            if (!this.closed) {
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void synStream(boolean z, boolean z2, int i2, int i3, List<Header> list) throws IOException {
            if (!this.closed) {
                writeNameValueBlockToBuffer(list);
                int i4 = (int) (this.headerBlockBuffer.f46277b + 10);
                boolean z3 = z | (z2 ? (char) 2 : 0);
                this.sink.h(-2147287039);
                this.sink.h(((z3 & true ? 1 : 0) << true) | (i4 & 16777215));
                this.sink.h(i2 & Integer.MAX_VALUE);
                this.sink.h(Integer.MAX_VALUE & i3);
                this.sink.i(0);
                this.sink.a(this.headerBlockBuffer);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void synReply(boolean z, int i2, List<Header> list) throws IOException {
            if (!this.closed) {
                writeNameValueBlockToBuffer(list);
                int i3 = z ? 1 : 0;
                int i4 = (int) (this.headerBlockBuffer.f46277b + 4);
                this.sink.h(-2147287038);
                this.sink.h(((i3 & PriceRangeSeekBar.INVALID_POINTER_ID) << 24) | (i4 & 16777215));
                this.sink.h(i2 & Integer.MAX_VALUE);
                this.sink.a(this.headerBlockBuffer);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void headers(int i2, List<Header> list) throws IOException {
            if (!this.closed) {
                writeNameValueBlockToBuffer(list);
                int i3 = (int) (this.headerBlockBuffer.f46277b + 4);
                this.sink.h(-2147287032);
                this.sink.h((i3 & 16777215) | 0);
                this.sink.h(i2 & Integer.MAX_VALUE);
                this.sink.a(this.headerBlockBuffer);
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void rstStream(int i2, ErrorCode errorCode) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyRstCode != -1) {
                this.sink.h(-2147287037);
                this.sink.h(8);
                this.sink.h(i2 & Integer.MAX_VALUE);
                this.sink.h(errorCode.spdyRstCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final synchronized void data(boolean z, int i2, c cVar, int i3) throws IOException {
            sendDataFrame(i2, z ? 1 : 0, cVar, i3);
        }

        /* access modifiers changed from: package-private */
        public final void sendDataFrame(int i2, int i3, c cVar, int i4) throws IOException {
            if (!this.closed) {
                long j = (long) i4;
                if (j <= 16777215) {
                    this.sink.h(i2 & Integer.MAX_VALUE);
                    this.sink.h(((i3 & PriceRangeSeekBar.INVALID_POINTER_ID) << 24) | (16777215 & i4));
                    if (i4 > 0) {
                        this.sink.write(cVar, j);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: ".concat(String.valueOf(i4)));
            }
            throw new IOException("closed");
        }

        private void writeNameValueBlockToBuffer(List<Header> list) throws IOException {
            this.headerBlockOut.h(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                f fVar = list.get(i2).name;
                this.headerBlockOut.h(fVar.size());
                this.headerBlockOut.d(fVar);
                f fVar2 = list.get(i2).value;
                this.headerBlockOut.h(fVar2.size());
                this.headerBlockOut.d(fVar2);
            }
            this.headerBlockOut.flush();
        }

        public final synchronized void settings(Settings settings) throws IOException {
            if (!this.closed) {
                int size = settings.size();
                this.sink.h(-2147287036);
                this.sink.h((((size * 8) + 4) & 16777215) | 0);
                this.sink.h(size);
                for (int i2 = 0; i2 <= 10; i2++) {
                    if (settings.isSet(i2)) {
                        this.sink.h(((settings.flags(i2) & PriceRangeSeekBar.INVALID_POINTER_ID) << 24) | (i2 & 16777215));
                        this.sink.h(settings.get(i2));
                    }
                }
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void ping(boolean z, int i2, int i3) throws IOException {
            if (!this.closed) {
                boolean z2 = false;
                if (this.client != ((i2 & 1) == 1)) {
                    z2 = true;
                }
                if (z == z2) {
                    this.sink.h(-2147287034);
                    this.sink.h(4);
                    this.sink.h(i2);
                    this.sink.flush();
                } else {
                    throw new IllegalArgumentException("payload != reply");
                }
            } else {
                throw new IOException("closed");
            }
        }

        public final synchronized void goAway(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.spdyGoAwayCode != -1) {
                this.sink.h(-2147287033);
                this.sink.h(8);
                this.sink.h(i2);
                this.sink.h(errorCode.spdyGoAwayCode);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
        }

        public final synchronized void windowUpdate(int i2, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            } else if (j == 0 || j > 2147483647L) {
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: ".concat(String.valueOf(j)));
            } else {
                this.sink.h(-2147287031);
                this.sink.h(8);
                this.sink.h(i2);
                this.sink.h((int) j);
                this.sink.flush();
            }
        }

        public final synchronized void close() throws IOException {
            this.closed = true;
            Util.closeAll(this.sink, this.headerBlockOut);
        }
    }
}
