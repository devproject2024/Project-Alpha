package com.google.zxing.a.c;

import com.google.zxing.b.a;
import com.j256.ormlite.stmt.query.SimpleComparison;

final class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f39870c;

    /* renamed from: d  reason: collision with root package name */
    private final short f39871d;

    e(g gVar, int i2, int i3) {
        super(gVar);
        this.f39870c = (short) i2;
        this.f39871d = (short) i3;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, byte[] bArr) {
        aVar.b(this.f39870c, this.f39871d);
    }

    public final String toString() {
        short s = this.f39870c;
        short s2 = this.f39871d;
        short s3 = (s & ((1 << s2) - 1)) | (1 << s2);
        return SimpleComparison.LESS_THAN_OPERATION + Integer.toBinaryString(s3 | (1 << this.f39871d)).substring(1) + '>';
    }
}
