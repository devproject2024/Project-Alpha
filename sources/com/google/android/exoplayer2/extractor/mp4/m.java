package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;

final class m {

    /* renamed from: a  reason: collision with root package name */
    public final j f32280a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32281b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f32282c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f32283d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32284e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f32285f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f32286g;

    /* renamed from: h  reason: collision with root package name */
    public final long f32287h;

    public m(j jVar, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j) {
        boolean z = false;
        a.a(iArr.length == jArr2.length);
        a.a(jArr.length == jArr2.length);
        a.a(iArr2.length == jArr2.length ? true : z);
        this.f32280a = jVar;
        this.f32282c = jArr;
        this.f32283d = iArr;
        this.f32284e = i2;
        this.f32285f = jArr2;
        this.f32286g = iArr2;
        this.f32287h = j;
        this.f32281b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j) {
        for (int a2 = ae.a(this.f32285f, j, false); a2 >= 0; a2--) {
            if ((this.f32286g[a2] & 1) != 0) {
                return a2;
            }
        }
        return -1;
    }

    public final int b(long j) {
        for (int a2 = ae.a(this.f32285f, j, true, false); a2 < this.f32285f.length; a2++) {
            if ((this.f32286g[a2] & 1) != 0) {
                return a2;
            }
        }
        return -1;
    }
}
