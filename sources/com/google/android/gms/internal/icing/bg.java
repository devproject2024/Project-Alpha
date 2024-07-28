package com.google.android.gms.internal.icing;

final class bg extends be {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f10077a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10078b;

    /* renamed from: c  reason: collision with root package name */
    private int f10079c;

    /* renamed from: d  reason: collision with root package name */
    private int f10080d;

    /* renamed from: e  reason: collision with root package name */
    private int f10081e;

    /* renamed from: f  reason: collision with root package name */
    private int f10082f;

    /* renamed from: g  reason: collision with root package name */
    private int f10083g;

    private bg(byte[] bArr, int i2) {
        super((byte) 0);
        this.f10083g = Integer.MAX_VALUE;
        this.f10077a = bArr;
        this.f10079c = i2 + 0;
        this.f10081e = 0;
        this.f10082f = this.f10081e;
        this.f10078b = false;
    }

    public final int a(int i2) throws cd {
        if (i2 >= 0) {
            int a2 = i2 + a();
            int i3 = this.f10083g;
            if (a2 <= i3) {
                this.f10083g = a2;
                this.f10079c += this.f10080d;
                int i4 = this.f10079c;
                int i5 = i4 - this.f10082f;
                int i6 = this.f10083g;
                if (i5 > i6) {
                    this.f10080d = i5 - i6;
                    this.f10079c = i4 - this.f10080d;
                } else {
                    this.f10080d = 0;
                }
                return i3;
            }
            throw new cd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new cd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int a() {
        return this.f10081e - this.f10082f;
    }

    /* synthetic */ bg(byte[] bArr, int i2, byte b2) {
        this(bArr, i2);
    }
}
