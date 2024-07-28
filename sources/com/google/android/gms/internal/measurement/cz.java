package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class cz {

    /* renamed from: a  reason: collision with root package name */
    int f10538a;

    /* renamed from: b  reason: collision with root package name */
    int f10539b;

    /* renamed from: c  reason: collision with root package name */
    dd f10540c;

    /* renamed from: d  reason: collision with root package name */
    private int f10541d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10542e;

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static cz a(byte[] bArr, int i2) {
        db dbVar = new db(bArr, i2, (byte) 0);
        try {
            dbVar.c(i2);
            return dbVar;
        } catch (eg e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int e(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract int a() throws IOException;

    public abstract void a(int i2) throws eg;

    public abstract double b() throws IOException;

    public abstract boolean b(int i2) throws IOException;

    public abstract float c() throws IOException;

    public abstract int c(int i2) throws eg;

    public abstract long d() throws IOException;

    public abstract void d(int i2);

    public abstract long e() throws IOException;

    public abstract int f() throws IOException;

    public abstract long g() throws IOException;

    public abstract int h() throws IOException;

    public abstract boolean i() throws IOException;

    public abstract String j() throws IOException;

    public abstract String k() throws IOException;

    public abstract cm l() throws IOException;

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

    private cz() {
        this.f10539b = 100;
        this.f10541d = Integer.MAX_VALUE;
        this.f10542e = false;
    }

    /* synthetic */ cz(byte b2) {
        this();
    }
}
