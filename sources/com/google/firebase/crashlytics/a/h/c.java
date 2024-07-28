package com.google.firebase.crashlytics.a.h;

import java.io.ByteArrayInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;

public final class c implements Flushable {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f38607a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38608b = 4096;

    /* renamed from: c  reason: collision with root package name */
    public int f38609c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final OutputStream f38610d;

    public static int e(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int f(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f38610d = outputStream;
        this.f38607a = bArr;
    }

    public final void a(int i2, long j) throws IOException {
        e(i2, 0);
        a(j);
    }

    public final void a(int i2, boolean z) throws IOException {
        e(i2, 0);
        a(z);
    }

    public final void a(int i2, a aVar) throws IOException {
        e(i2, 2);
        d(aVar.f38600a.length);
        int length = aVar.f38600a.length;
        int i3 = this.f38608b;
        int i4 = this.f38609c;
        if (i3 - i4 >= length) {
            aVar.a(this.f38607a, 0, i4, length);
            this.f38609c += length;
            return;
        }
        int i5 = i3 - i4;
        aVar.a(this.f38607a, 0, i4, i5);
        int i6 = i5 + 0;
        int i7 = length - i5;
        this.f38609c = this.f38608b;
        b();
        if (i7 <= this.f38608b) {
            aVar.a(this.f38607a, i6, 0, i7);
            this.f38609c = i7;
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(aVar.f38600a);
        long j = (long) i6;
        if (j == byteArrayInputStream.skip(j)) {
            while (i7 > 0) {
                int min = Math.min(i7, this.f38608b);
                int read = byteArrayInputStream.read(this.f38607a, 0, min);
                if (read == min) {
                    this.f38610d.write(this.f38607a, 0, read);
                    i7 -= read;
                } else {
                    throw new IllegalStateException("Read failed.");
                }
            }
            return;
        }
        throw new IllegalStateException("Skip failed.");
    }

    public final void a(int i2, int i3) throws IOException {
        e(i2, 0);
        d(i3);
    }

    public final void b(int i2, int i3) throws IOException {
        e(i2, 0);
        g(i3);
    }

    private void g(int i2) throws IOException {
        if (i2 >= 0) {
            d(i2);
        } else {
            a((long) i2);
        }
    }

    public static int a() {
        return c(1) + 4;
    }

    public static int b(int i2, long j) {
        return c(i2) + ((-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10);
    }

    public static int a(int i2) {
        return c(i2) + 1;
    }

    public static int b(int i2, a aVar) {
        return c(i2) + e(aVar.f38600a.length) + aVar.f38600a.length;
    }

    public static int c(int i2, int i3) {
        return c(i2) + e(i3);
    }

    public static int d(int i2, int i3) {
        return c(i2) + (i3 >= 0 ? e(i3) : 10);
    }

    public static int b(int i2) {
        return c(2) + e(f(i2));
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.f38610d;
        if (outputStream != null) {
            outputStream.write(this.f38607a, 0, this.f38609c);
            this.f38609c = 0;
            return;
        }
        throw new a();
    }

    public final void flush() throws IOException {
        if (this.f38610d != null) {
            b();
        }
    }

    static class a extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public final void a(byte b2) throws IOException {
        if (this.f38609c == this.f38608b) {
            b();
        }
        byte[] bArr = this.f38607a;
        int i2 = this.f38609c;
        this.f38609c = i2 + 1;
        bArr[i2] = b2;
    }

    public final void e(int i2, int i3) throws IOException {
        d(e.a(i2, i3));
    }

    public static int c(int i2) {
        return e(e.a(i2, 0));
    }

    public static c a(OutputStream outputStream) {
        return new c(outputStream, new byte[4096]);
    }

    private void a(boolean z) throws IOException {
        a(z ? (byte) 1 : 0);
    }

    public final void d(int i2) throws IOException {
        while ((i2 & -128) != 0) {
            a((byte) ((i2 & 127) | 128));
            i2 >>>= 7;
        }
        a((byte) i2);
    }

    private void a(long j) throws IOException {
        while ((-128 & j) != 0) {
            a((byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        a((byte) ((int) j));
    }
}
