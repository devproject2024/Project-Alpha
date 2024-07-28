package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f32257a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32258b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32259c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32260d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32261e;

    /* renamed from: f  reason: collision with root package name */
    public final Format f32262f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32263g;

    /* renamed from: h  reason: collision with root package name */
    public final long[] f32264h;

    /* renamed from: i  reason: collision with root package name */
    public final long[] f32265i;
    public final int j;
    private final k[] k;

    public j(int i2, int i3, long j2, long j3, long j4, Format format, int i4, k[] kVarArr, int i5, long[] jArr, long[] jArr2) {
        this.f32257a = i2;
        this.f32258b = i3;
        this.f32259c = j2;
        this.f32260d = j3;
        this.f32261e = j4;
        this.f32262f = format;
        this.f32263g = i4;
        this.k = kVarArr;
        this.j = i5;
        this.f32264h = jArr;
        this.f32265i = jArr2;
    }

    public final k a(int i2) {
        k[] kVarArr = this.k;
        if (kVarArr == null) {
            return null;
        }
        return kVarArr[i2];
    }
}
