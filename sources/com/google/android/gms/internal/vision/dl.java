package com.google.android.gms.internal.vision;

import java.io.IOException;

public abstract class dl {

    /* renamed from: a  reason: collision with root package name */
    int f11038a;

    /* renamed from: b  reason: collision with root package name */
    int f11039b;

    /* renamed from: c  reason: collision with root package name */
    dp f11040c;

    /* renamed from: d  reason: collision with root package name */
    private int f11041d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11042e;

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static dl a(byte[] bArr, int i2) {
        dn dnVar = new dn(bArr, i2, (byte) 0);
        try {
            dnVar.c(i2);
            return dnVar;
        } catch (eu e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int e(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract int a() throws IOException;

    public abstract void a(int i2) throws eu;

    public abstract double b() throws IOException;

    public abstract boolean b(int i2) throws IOException;

    public abstract float c() throws IOException;

    public abstract int c(int i2) throws eu;

    public abstract long d() throws IOException;

    public abstract void d(int i2);

    public abstract long e() throws IOException;

    public abstract int f() throws IOException;

    public abstract long g() throws IOException;

    public abstract int h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract String j() throws IOException;

    public abstract String k() throws IOException;

    public abstract cz l() throws IOException;

    public abstract int m() throws IOException;

    public abstract int n() throws IOException;

    public abstract int o() throws IOException;

    public abstract long p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long s() throws IOException;

    public abstract boolean t() throws IOException;

    public abstract int u();

    private dl() {
        this.f11039b = 100;
        this.f11041d = Integer.MAX_VALUE;
        this.f11042e = false;
    }

    /* synthetic */ dl(byte b2) {
        this();
    }
}
