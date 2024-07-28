package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.db  reason: invalid package */
final class db extends cz {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9540a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9541b;

    /* renamed from: c  reason: collision with root package name */
    private int f9542c;

    /* renamed from: d  reason: collision with root package name */
    private int f9543d;

    /* renamed from: e  reason: collision with root package name */
    private int f9544e;

    /* renamed from: f  reason: collision with root package name */
    private int f9545f;

    /* renamed from: g  reason: collision with root package name */
    private int f9546g;

    private db(byte[] bArr, int i2) {
        super((byte) 0);
        this.f9546g = Integer.MAX_VALUE;
        this.f9540a = bArr;
        this.f9542c = i2 + 0;
        this.f9544e = 0;
        this.f9545f = this.f9544e;
        this.f9541b = false;
    }

    public final int a(int i2) throws dy {
        if (i2 >= 0) {
            int a2 = i2 + a();
            int i3 = this.f9546g;
            if (a2 <= i3) {
                this.f9546g = a2;
                this.f9542c += this.f9543d;
                int i4 = this.f9542c;
                int i5 = i4 - this.f9545f;
                int i6 = this.f9546g;
                if (i5 > i6) {
                    this.f9543d = i5 - i6;
                    this.f9542c = i4 - this.f9543d;
                } else {
                    this.f9543d = 0;
                }
                return i3;
            }
            throw new dy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new dy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int a() {
        return this.f9544e - this.f9545f;
    }

    /* synthetic */ db(byte[] bArr, int i2, byte b2) {
        this(bArr, i2);
    }
}
