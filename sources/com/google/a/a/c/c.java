package com.google.a.a.c;

import java.io.IOException;
import java.io.OutputStream;

final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    long f7563a;

    c() {
    }

    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        this.f7563a += (long) i3;
    }

    public final void write(int i2) throws IOException {
        this.f7563a++;
    }
}
