package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;

final class t {

    /* renamed from: a  reason: collision with root package name */
    final ab f32087a = new ab(0);

    /* renamed from: b  reason: collision with root package name */
    final r f32088b = new r();

    /* renamed from: c  reason: collision with root package name */
    boolean f32089c;

    /* renamed from: d  reason: collision with root package name */
    boolean f32090d;

    /* renamed from: e  reason: collision with root package name */
    boolean f32091e;

    /* renamed from: f  reason: collision with root package name */
    long f32092f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    long f32093g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    long f32094h = -9223372036854775807L;

    t() {
    }

    /* access modifiers changed from: package-private */
    public final int a(h hVar) {
        r rVar = this.f32088b;
        byte[] bArr = ae.f32504f;
        rVar.a(bArr, bArr.length);
        this.f32089c = true;
        hVar.a();
        return 0;
    }

    static int a(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    private static boolean a(byte[] bArr) {
        if ((bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            return true;
        }
        return false;
    }

    private static long b(byte[] bArr) {
        return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public static long a(r rVar) {
        int i2 = rVar.f32567b;
        if (rVar.b() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        rVar.a(bArr, 0, 9);
        rVar.c(i2);
        if (!a(bArr)) {
            return -9223372036854775807L;
        }
        return b(bArr);
    }
}
