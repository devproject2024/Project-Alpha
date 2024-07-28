package com.google.zxing.f.a.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f40421a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f40422b = new int[929];

    /* renamed from: c  reason: collision with root package name */
    public final int[] f40423c = new int[929];

    /* renamed from: d  reason: collision with root package name */
    public final c f40424d;

    /* renamed from: e  reason: collision with root package name */
    public final c f40425e;

    /* renamed from: f  reason: collision with root package name */
    final int f40426f = 929;

    private b() {
        int i2 = 1;
        for (int i3 = 0; i3 < 929; i3++) {
            this.f40422b[i3] = i2;
            i2 = (i2 * 3) % 929;
        }
        for (int i4 = 0; i4 < 928; i4++) {
            this.f40423c[this.f40422b[i4]] = i4;
        }
        this.f40424d = new c(this, new int[]{0});
        this.f40425e = new c(this, new int[]{1});
    }

    public final c a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f40424d;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new c(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2, int i3) {
        return (i2 + i3) % this.f40426f;
    }

    public final int c(int i2, int i3) {
        int i4 = this.f40426f;
        return ((i2 + i4) - i3) % i4;
    }

    public final int a(int i2) {
        if (i2 != 0) {
            return this.f40422b[(this.f40426f - this.f40423c[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public final int d(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f40422b;
        int[] iArr2 = this.f40423c;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f40426f - 1)];
    }
}
