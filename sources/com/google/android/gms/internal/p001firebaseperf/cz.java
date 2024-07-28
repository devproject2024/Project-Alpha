package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.cz  reason: invalid package */
public abstract class cz {

    /* renamed from: a  reason: collision with root package name */
    private int f9530a;

    /* renamed from: b  reason: collision with root package name */
    private int f9531b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9532c;

    static cz a(byte[] bArr, int i2) {
        db dbVar = new db(bArr, i2, (byte) 0);
        try {
            dbVar.a(i2);
            return dbVar;
        } catch (dy e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int a();

    public abstract int a(int i2) throws dy;

    private cz() {
        this.f9530a = 100;
        this.f9531b = Integer.MAX_VALUE;
        this.f9532c = false;
    }

    /* synthetic */ cz(byte b2) {
        this();
    }
}
