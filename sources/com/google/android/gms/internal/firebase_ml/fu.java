package com.google.android.gms.internal.firebase_ml;

final class fu extends fs {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9894a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9895b;

    /* renamed from: c  reason: collision with root package name */
    private int f9896c;

    /* renamed from: d  reason: collision with root package name */
    private int f9897d;

    /* renamed from: e  reason: collision with root package name */
    private int f9898e;

    /* renamed from: f  reason: collision with root package name */
    private int f9899f;

    /* renamed from: g  reason: collision with root package name */
    private int f9900g;

    private fu(byte[] bArr, int i2) {
        super((byte) 0);
        this.f9900g = Integer.MAX_VALUE;
        this.f9894a = bArr;
        this.f9896c = i2 + 0;
        this.f9898e = 0;
        this.f9899f = this.f9898e;
        this.f9895b = false;
    }

    public final int a(int i2) throws gp {
        if (i2 >= 0) {
            int a2 = i2 + a();
            int i3 = this.f9900g;
            if (a2 <= i3) {
                this.f9900g = a2;
                this.f9896c += this.f9897d;
                int i4 = this.f9896c;
                int i5 = i4 - this.f9899f;
                int i6 = this.f9900g;
                if (i5 > i6) {
                    this.f9897d = i5 - i6;
                    this.f9896c = i4 - this.f9897d;
                } else {
                    this.f9897d = 0;
                }
                return i3;
            }
            throw gp.zzve();
        }
        throw gp.zzvf();
    }

    public final int a() {
        return this.f9898e - this.f9899f;
    }

    /* synthetic */ fu(byte[] bArr, int i2, byte b2) {
        this(bArr, i2);
    }
}
