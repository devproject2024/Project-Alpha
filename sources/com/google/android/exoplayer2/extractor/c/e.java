package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

final class e {

    /* renamed from: a  reason: collision with root package name */
    final r f31748a = new r(8);

    /* renamed from: b  reason: collision with root package name */
    int f31749b;

    /* access modifiers changed from: package-private */
    public final long a(h hVar) throws IOException, InterruptedException {
        int i2 = 0;
        hVar.c(this.f31748a.f32566a, 0, 1);
        byte b2 = this.f31748a.f32566a[0] & 255;
        if (b2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((b2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = b2 & (~i3);
        hVar.c(this.f31748a.f32566a, 1, i4);
        while (i2 < i4) {
            i2++;
            i5 = (this.f31748a.f32566a[i2] & 255) + (i5 << 8);
        }
        this.f31749b += i4 + 1;
        return (long) i5;
    }
}
