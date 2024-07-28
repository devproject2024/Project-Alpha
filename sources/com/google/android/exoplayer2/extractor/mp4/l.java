package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.r;

final class l {

    /* renamed from: a  reason: collision with root package name */
    public c f32271a;

    /* renamed from: b  reason: collision with root package name */
    public long f32272b;

    /* renamed from: c  reason: collision with root package name */
    public long f32273c;

    /* renamed from: d  reason: collision with root package name */
    public long f32274d;

    /* renamed from: e  reason: collision with root package name */
    public int f32275e;

    /* renamed from: f  reason: collision with root package name */
    public int f32276f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f32277g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f32278h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f32279i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public k o;
    public int p;
    public r q;
    public boolean r;
    public long s;

    l() {
    }

    public final void a() {
        this.f32275e = 0;
        this.s = 0;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public final void a(int i2, int i3) {
        this.f32275e = i2;
        this.f32276f = i3;
        int[] iArr = this.f32278h;
        if (iArr == null || iArr.length < i2) {
            this.f32277g = new long[i2];
            this.f32278h = new int[i2];
        }
        int[] iArr2 = this.f32279i;
        if (iArr2 == null || iArr2.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f32279i = new int[i4];
            this.j = new int[i4];
            this.k = new long[i4];
            this.l = new boolean[i4];
            this.n = new boolean[i4];
        }
    }

    public final void a(int i2) {
        r rVar = this.q;
        if (rVar == null || rVar.f32568c < i2) {
            this.q = new r(i2);
        }
        this.p = i2;
        this.m = true;
        this.r = true;
    }

    public final void a(r rVar) {
        rVar.a(this.q.f32566a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public final long b(int i2) {
        return this.k[i2] + ((long) this.j[i2]);
    }

    public final boolean c(int i2) {
        return this.m && this.n[i2];
    }
}
