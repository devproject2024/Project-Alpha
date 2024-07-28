package com.google.a.a.c;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class o extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final n f7610a;

    public o(InputStream inputStream, Logger logger, Level level, int i2) {
        super(inputStream);
        this.f7610a = new n(logger, level, i2);
    }

    public final int read() throws IOException {
        int read = super.read();
        this.f7610a.write(read);
        return read;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        if (read > 0) {
            this.f7610a.write(bArr, i2, read);
        }
        return read;
    }

    public final void close() throws IOException {
        this.f7610a.close();
        super.close();
    }
}
