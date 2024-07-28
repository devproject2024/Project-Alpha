package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.g.a;
import java.io.IOException;
import java.io.InputStream;

public final class k extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final i f32389a;

    /* renamed from: b  reason: collision with root package name */
    private final l f32390b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f32391c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32392d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32393e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f32394f;

    public k(i iVar, l lVar) {
        this.f32389a = iVar;
        this.f32390b = lVar;
        this.f32391c = new byte[1];
    }

    public final int read() throws IOException {
        if (read(this.f32391c) == -1) {
            return -1;
        }
        return this.f32391c[0] & 255;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        a.b(!this.f32393e);
        a();
        int a2 = this.f32389a.a(bArr, i2, i3);
        if (a2 == -1) {
            return -1;
        }
        this.f32394f += (long) a2;
        return a2;
    }

    public final void close() throws IOException {
        if (!this.f32393e) {
            this.f32389a.c();
            this.f32393e = true;
        }
    }

    public final void a() throws IOException {
        if (!this.f32392d) {
            this.f32389a.a(this.f32390b);
            this.f32392d = true;
        }
    }
}
