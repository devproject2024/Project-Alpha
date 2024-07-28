package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.extractor.h;
import java.io.IOException;

final class f {

    /* renamed from: b  reason: collision with root package name */
    private static final long[] f31750b = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    int f31751a;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f31752c = new byte[8];

    /* renamed from: d  reason: collision with root package name */
    private int f31753d;

    public final void a() {
        this.f31753d = 0;
        this.f31751a = 0;
    }

    public final long a(h hVar, boolean z, boolean z2, int i2) throws IOException, InterruptedException {
        if (this.f31753d == 0) {
            if (!hVar.a(this.f31752c, 0, 1, z)) {
                return -1;
            }
            this.f31751a = a(this.f31752c[0] & 255);
            if (this.f31751a != -1) {
                this.f31753d = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.f31751a;
        if (i3 > i2) {
            this.f31753d = 0;
            return -2;
        }
        if (i3 != 1) {
            hVar.b(this.f31752c, 1, i3 - 1);
        }
        this.f31753d = 0;
        return a(this.f31752c, this.f31751a, z2);
    }

    public static int a(int i2) {
        int i3 = 0;
        while (true) {
            long[] jArr = f31750b;
            if (i3 >= jArr.length) {
                return -1;
            }
            if ((jArr[i3] & ((long) i2)) != 0) {
                return i3 + 1;
            }
            i3++;
        }
    }

    public static long a(byte[] bArr, int i2, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~f31750b[i2 - 1];
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j = (j << 8) | (((long) bArr[i3]) & 255);
        }
        return j;
    }
}
