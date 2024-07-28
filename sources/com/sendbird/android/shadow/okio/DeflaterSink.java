package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.util.zip.Deflater;

public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(Sink sink2, Deflater deflater2) {
        this(Okio.buffer(sink2), deflater2);
    }

    DeflaterSink(BufferedSink bufferedSink, Deflater deflater2) {
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater2 != null) {
            this.sink = bufferedSink;
            this.deflater = deflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final void write(Buffer buffer, long j) throws IOException {
        g.a(buffer.size, 0, j);
        while (j > 0) {
            d dVar = buffer.head;
            int min = (int) Math.min(j, (long) (dVar.f45275c - dVar.f45274b));
            this.deflater.setInput(dVar.f45273a, dVar.f45274b, min);
            deflate(false);
            long j2 = (long) min;
            buffer.size -= j2;
            dVar.f45274b += min;
            if (dVar.f45274b == dVar.f45275c) {
                buffer.head = dVar.c();
                e.a(dVar);
            }
            j -= j2;
        }
    }

    private void deflate(boolean z) throws IOException {
        d writableSegment;
        int i2;
        Buffer buffer = this.sink.buffer();
        while (true) {
            writableSegment = buffer.writableSegment(1);
            if (z) {
                i2 = this.deflater.deflate(writableSegment.f45273a, writableSegment.f45275c, 8192 - writableSegment.f45275c, 2);
            } else {
                i2 = this.deflater.deflate(writableSegment.f45273a, writableSegment.f45275c, 8192 - writableSegment.f45275c);
            }
            if (i2 > 0) {
                writableSegment.f45275c += i2;
                buffer.size += (long) i2;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment.f45274b == writableSegment.f45275c) {
            buffer.head = writableSegment.c();
            e.a(writableSegment);
        }
    }

    public final void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    /* access modifiers changed from: package-private */
    public final void finishDeflate() throws IOException {
        this.deflater.finish();
        deflate(false);
    }

    public final void close() throws IOException {
        if (!this.closed) {
            Throwable th = null;
            try {
                finishDeflate();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.deflater.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.closed = true;
            if (th != null) {
                g.a(th);
            }
        }
    }

    public final Timeout timeout() {
        return this.sink.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }
}
