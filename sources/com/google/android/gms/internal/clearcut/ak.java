package com.google.android.gms.internal.clearcut;

public abstract class ak {

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f9126d = true;

    /* renamed from: a  reason: collision with root package name */
    private int f9127a;

    /* renamed from: b  reason: collision with root package name */
    private int f9128b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9129c;

    private ak() {
        this.f9127a = 100;
        this.f9128b = Integer.MAX_VALUE;
        this.f9129c = false;
    }

    /* synthetic */ ak(byte b2) {
        this();
    }

    public static long a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static ak a(byte[] bArr, int i2) {
        al alVar = new al(bArr, i2, (byte) 0);
        try {
            alVar.a(i2);
            return alVar;
        } catch (bn e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public abstract int a();

    public abstract int a(int i2) throws bn;
}
