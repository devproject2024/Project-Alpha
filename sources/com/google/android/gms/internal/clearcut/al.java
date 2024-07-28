package com.google.android.gms.internal.clearcut;

final class al extends ak {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9130a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9131b;

    /* renamed from: c  reason: collision with root package name */
    private int f9132c;

    /* renamed from: d  reason: collision with root package name */
    private int f9133d;

    /* renamed from: e  reason: collision with root package name */
    private int f9134e;

    /* renamed from: f  reason: collision with root package name */
    private int f9135f;

    /* renamed from: g  reason: collision with root package name */
    private int f9136g;

    private al(byte[] bArr, int i2) {
        super((byte) 0);
        this.f9136g = Integer.MAX_VALUE;
        this.f9130a = bArr;
        this.f9132c = i2 + 0;
        this.f9134e = 0;
        this.f9135f = this.f9134e;
        this.f9131b = false;
    }

    /* synthetic */ al(byte[] bArr, int i2, byte b2) {
        this(bArr, i2);
    }

    public final int a() {
        return this.f9134e - this.f9135f;
    }

    public final int a(int i2) throws bn {
        if (i2 >= 0) {
            int a2 = i2 + a();
            int i3 = this.f9136g;
            if (a2 <= i3) {
                this.f9136g = a2;
                this.f9132c += this.f9133d;
                int i4 = this.f9132c;
                int i5 = i4 - this.f9135f;
                int i6 = this.f9136g;
                if (i5 > i6) {
                    this.f9133d = i5 - i6;
                    this.f9132c = i4 - this.f9133d;
                } else {
                    this.f9133d = 0;
                }
                return i3;
            }
            throw bn.zzbl();
        }
        throw new bn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
