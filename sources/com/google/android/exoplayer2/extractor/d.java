package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.g.ae;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class d implements h {

    /* renamed from: a  reason: collision with root package name */
    public int f31754a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f31755b = new byte[4096];

    /* renamed from: c  reason: collision with root package name */
    private final i f31756c;

    /* renamed from: d  reason: collision with root package name */
    private final long f31757d;

    /* renamed from: e  reason: collision with root package name */
    private long f31758e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f31759f = new byte[65536];

    /* renamed from: g  reason: collision with root package name */
    private int f31760g;

    public d(i iVar, long j, long j2) {
        this.f31756c = iVar;
        this.f31758e = j;
        this.f31757d = j2;
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int d2 = d(bArr, i2, i3);
        if (d2 == 0) {
            d2 = a(bArr, i2, i3, 0, true);
        }
        g(d2);
        return d2;
    }

    public final boolean a(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        int d2 = d(bArr, i2, i3);
        while (d2 < i3 && d2 != -1) {
            d2 = a(bArr, i2, i3, d2, z);
        }
        g(d2);
        return d2 != -1;
    }

    public final void b(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        a(bArr, i2, i3, false);
    }

    public final int a(int i2) throws IOException, InterruptedException {
        int e2 = e(i2);
        if (e2 == 0) {
            byte[] bArr = this.f31755b;
            e2 = a(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        g(e2);
        return e2;
    }

    public final boolean b(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        if (!a(i3, z)) {
            return false;
        }
        System.arraycopy(this.f31759f, this.f31754a - i3, bArr, i2, i3);
        return true;
    }

    public final void c(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        b(bArr, i2, i3, false);
    }

    public final boolean a(int i2, boolean z) throws IOException, InterruptedException {
        d(i2);
        int i3 = this.f31760g - this.f31754a;
        while (i3 < i2) {
            i3 = a(this.f31759f, this.f31754a, i2, i3, z);
            if (i3 == -1) {
                return false;
            }
            this.f31760g = this.f31754a + i3;
        }
        this.f31754a += i2;
        return true;
    }

    public final void c(int i2) throws IOException, InterruptedException {
        a(i2, false);
    }

    public final void a() {
        this.f31754a = 0;
    }

    public final long b() {
        return this.f31758e + ((long) this.f31754a);
    }

    public final long c() {
        return this.f31758e;
    }

    public final long d() {
        return this.f31757d;
    }

    private void d(int i2) {
        int i3 = this.f31754a + i2;
        byte[] bArr = this.f31759f;
        if (i3 > bArr.length) {
            this.f31759f = Arrays.copyOf(this.f31759f, ae.a(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
    }

    private int e(int i2) {
        int min = Math.min(this.f31760g, i2);
        f(min);
        return min;
    }

    private int d(byte[] bArr, int i2, int i3) {
        int i4 = this.f31760g;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.f31759f, 0, bArr, i2, min);
        f(min);
        return min;
    }

    private void f(int i2) {
        this.f31760g -= i2;
        this.f31754a = 0;
        byte[] bArr = this.f31759f;
        int i3 = this.f31760g;
        if (i3 < bArr.length - 524288) {
            bArr = new byte[(i3 + 65536)];
        }
        System.arraycopy(this.f31759f, i2, bArr, 0, this.f31760g);
        this.f31759f = bArr;
    }

    private int a(byte[] bArr, int i2, int i3, int i4, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int a2 = this.f31756c.a(bArr, i2 + i4, i3 - i4);
            if (a2 != -1) {
                return i4 + a2;
            }
            if (i4 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private void g(int i2) {
        if (i2 != -1) {
            this.f31758e += (long) i2;
        }
    }

    public final void b(int i2) throws IOException, InterruptedException {
        int e2 = e(i2);
        while (e2 < i2 && e2 != -1) {
            e2 = a(this.f31755b, -e2, Math.min(i2, this.f31755b.length + e2), e2, false);
        }
        g(e2);
    }
}
