package com.google.android.exoplayer2.extractor.e;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

final class i {

    /* renamed from: a  reason: collision with root package name */
    int f31841a;

    /* renamed from: b  reason: collision with root package name */
    int f31842b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f31843c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31844d;

    public i(byte[] bArr) {
        this.f31843c = bArr;
        this.f31844d = bArr.length;
    }

    public final boolean a() {
        boolean z = (((this.f31843c[this.f31841a] & 255) >> this.f31842b) & 1) == 1;
        b(1);
        return z;
    }

    public final int a(int i2) {
        int i3 = this.f31841a;
        int min = Math.min(i2, 8 - this.f31842b);
        int i4 = i3 + 1;
        int i5 = ((this.f31843c[i3] & 255) >> this.f31842b) & (PriceRangeSeekBar.INVALID_POINTER_ID >> (8 - min));
        while (min < i2) {
            i5 |= (this.f31843c[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        b(i2);
        return i6;
    }

    public final void b(int i2) {
        int i3 = i2 / 8;
        this.f31841a += i3;
        this.f31842b += i2 - (i3 * 8);
        int i4 = this.f31842b;
        if (i4 > 7) {
            this.f31841a++;
            this.f31842b = i4 - 8;
        }
        b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f31844d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r2 = this;
            int r0 = r2.f31841a
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f31844d
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f31842b
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.exoplayer2.g.a.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.e.i.b():void");
    }
}
