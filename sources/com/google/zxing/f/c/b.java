package com.google.zxing.f.c;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f40476a;

    /* renamed from: b  reason: collision with root package name */
    private int f40477b = 0;

    b(int i2) {
        this.f40476a = new byte[i2];
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f40477b;
            this.f40477b = i4 + 1;
            this.f40476a[i4] = z ? (byte) 1 : 0;
        }
    }
}
