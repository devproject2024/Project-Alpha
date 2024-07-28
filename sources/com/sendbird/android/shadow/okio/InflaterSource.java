package com.sendbird.android.shadow.okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(Source source2, Inflater inflater2) {
        this(Okio.buffer(source2), inflater2);
    }

    InflaterSource(BufferedSource bufferedSource, Inflater inflater2) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater2 != null) {
            this.source = bufferedSource;
            this.inflater = inflater2;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public final long read(Buffer buffer, long j) throws IOException {
        d writableSegment;
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (i2 == 0) {
            return 0;
        } else {
            while (true) {
                boolean refill = refill();
                try {
                    writableSegment = buffer.writableSegment(1);
                    int inflate = this.inflater.inflate(writableSegment.f45273a, writableSegment.f45275c, (int) Math.min(j, (long) (8192 - writableSegment.f45275c)));
                    if (inflate > 0) {
                        writableSegment.f45275c += inflate;
                        long j2 = (long) inflate;
                        buffer.size += j2;
                        return j2;
                    } else if (this.inflater.finished()) {
                        break;
                    } else if (this.inflater.needsDictionary()) {
                        break;
                    } else if (refill) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            releaseInflatedBytes();
            if (writableSegment.f45274b != writableSegment.f45275c) {
                return -1;
            }
            buffer.head = writableSegment.c();
            e.a(writableSegment);
            return -1;
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.source.exhausted()) {
            return true;
        } else {
            d dVar = this.source.buffer().head;
            this.bufferBytesHeldByInflater = dVar.f45275c - dVar.f45274b;
            this.inflater.setInput(dVar.f45273a, dVar.f45274b, this.bufferBytesHeldByInflater);
            return false;
        }
    }

    private void releaseInflatedBytes() throws IOException {
        int i2 = this.bufferBytesHeldByInflater;
        if (i2 != 0) {
            int remaining = i2 - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= remaining;
            this.source.skip((long) remaining);
        }
    }

    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final void close() throws IOException {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }
}
