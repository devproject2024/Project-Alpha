package okhttp3.internal.http2;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import i.c;
import i.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

final class Http2Writer implements Closeable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final c hpackBuffer = new c();
    final Hpack.Writer hpackWriter = new Hpack.Writer(this.hpackBuffer);
    private int maxFrameSize = 16384;
    private final d sink;

    Http2Writer(d dVar, boolean z) {
        this.sink = dVar;
        this.client = z;
    }

    public final synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (this.client) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
            }
            this.sink.c(Http2.CONNECTION_PREFACE.toByteArray());
            this.sink.flush();
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        if (!this.closed) {
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, (byte) 4, (byte) 1);
            this.sink.flush();
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
            frameHeader(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : 0);
            this.sink.h(i3 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j2);
            if (i4 > 0) {
                writeContinuationFrames(i2, j - j2);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void synStream(boolean z, int i2, int i3, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z, i2, list);
        } else {
            throw new IOException("closed");
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

    public final synchronized void rstStream(int i2, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(i2, 4, (byte) 3, (byte) 0);
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
            frameHeader(0, 8, (byte) 6, z ? (byte) 1 : 0);
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
            frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
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

    public final void frameHeader(int i2, int i3, byte b2, byte b3) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.frameLog(false, i2, i3, b2, b3));
        }
        int i4 = this.maxFrameSize;
        if (i3 > i4) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            writeMedium(this.sink, i3);
            this.sink.j(b2 & 255);
            this.sink.j(b3 & 255);
            this.sink.h(i2 & Integer.MAX_VALUE);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i2));
        }
    }

    public final synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    private static void writeMedium(d dVar, int i2) throws IOException {
        dVar.j((i2 >>> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        dVar.j((i2 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        dVar.j(i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
    }

    private void writeContinuationFrames(int i2, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j);
            long j2 = (long) min;
            j -= j2;
            frameHeader(i2, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.sink.write(this.hpackBuffer, j2);
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
}
