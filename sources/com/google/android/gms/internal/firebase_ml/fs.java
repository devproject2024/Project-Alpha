package com.google.android.gms.internal.firebase_ml;

public abstract class fs {

    /* renamed from: a  reason: collision with root package name */
    private int f9884a;

    /* renamed from: b  reason: collision with root package name */
    private int f9885b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9886c;

    static fs a(byte[] bArr, int i2) {
        fu fuVar = new fu(bArr, i2, (byte) 0);
        try {
            fuVar.a(i2);
            return fuVar;
        } catch (gp e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int a();

    public abstract int a(int i2) throws gp;

    private fs() {
        this.f9884a = 100;
        this.f9885b = Integer.MAX_VALUE;
        this.f9886c = false;
    }

    /* synthetic */ fs(byte b2) {
        this();
    }
}
