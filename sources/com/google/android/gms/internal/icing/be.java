package com.google.android.gms.internal.icing;

public abstract class be {

    /* renamed from: a  reason: collision with root package name */
    private int f10067a;

    /* renamed from: b  reason: collision with root package name */
    private int f10068b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10069c;

    static be a(byte[] bArr, int i2) {
        bg bgVar = new bg(bArr, i2, (byte) 0);
        try {
            bgVar.a(i2);
            return bgVar;
        } catch (cd e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int a();

    public abstract int a(int i2) throws cd;

    private be() {
        this.f10067a = 100;
        this.f10068b = Integer.MAX_VALUE;
        this.f10069c = false;
    }

    /* synthetic */ be(byte b2) {
        this();
    }
}
