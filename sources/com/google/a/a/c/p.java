package com.google.a.a.c;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class p extends FilterOutputStream {

    /* renamed from: a  reason: collision with root package name */
    final n f7611a;

    public p(OutputStream outputStream, Logger logger, Level level, int i2) {
        super(outputStream);
        this.f7611a = new n(logger, level, i2);
    }

    public final void write(int i2) throws IOException {
        this.out.write(i2);
        this.f7611a.write(i2);
    }

    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
        this.f7611a.write(bArr, i2, i3);
    }

    public final void close() throws IOException {
        this.f7611a.close();
        super.close();
    }
}
