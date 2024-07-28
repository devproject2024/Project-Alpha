package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import i.c;
import i.u;
import i.w;
import java.io.IOException;
import java.net.ProtocolException;

public final class RetryableSink implements u {
    private boolean closed;
    private final c content;
    private final int limit;

    public final void flush() throws IOException {
    }

    public RetryableSink(int i2) {
        this.content = new c();
        this.limit = i2;
    }

    public RetryableSink() {
        this(-1);
    }

    public final void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (this.content.f46277b < ((long) this.limit)) {
                throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.f46277b);
            }
        }
    }

    public final void write(c cVar, long j) throws IOException {
        if (!this.closed) {
            Util.checkOffsetAndCount(cVar.f46277b, 0, j);
            if (this.limit == -1 || this.content.f46277b <= ((long) this.limit) - j) {
                this.content.write(cVar, j);
                return;
            }
            throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
        }
        throw new IllegalStateException("closed");
    }

    public final w timeout() {
        return w.NONE;
    }

    public final long contentLength() throws IOException {
        return this.content.f46277b;
    }

    public final void writeToSocket(u uVar) throws IOException {
        c cVar = new c();
        c cVar2 = this.content;
        cVar2.a(cVar, 0, cVar2.f46277b);
        uVar.write(cVar, cVar.f46277b);
    }
}
