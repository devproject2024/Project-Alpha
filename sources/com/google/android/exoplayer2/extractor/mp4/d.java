package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.ae;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

final class d {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f32205a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f32206b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32207c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f32208d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f32209e;

        /* renamed from: f  reason: collision with root package name */
        public final long f32210f;

        /* synthetic */ a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j, byte b2) {
            this(jArr, iArr, i2, jArr2, iArr2, j);
        }

        private a(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j) {
            this.f32205a = jArr;
            this.f32206b = iArr;
            this.f32207c = i2;
            this.f32208d = jArr2;
            this.f32209e = iArr2;
            this.f32210f = j;
        }
    }

    public static a a(int i2, long[] jArr, int[] iArr, long j) {
        int[] iArr2 = iArr;
        int i3 = FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE / i2;
        int i4 = 0;
        for (int a2 : iArr2) {
            i4 += ae.a(a2, i3);
        }
        long[] jArr2 = new long[i4];
        int[] iArr3 = new int[i4];
        long[] jArr3 = new long[i4];
        int[] iArr4 = new int[i4];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < iArr2.length; i8++) {
            int i9 = iArr2[i8];
            long j2 = jArr[i8];
            while (i9 > 0) {
                int min = Math.min(i3, i9);
                jArr2[i6] = j2;
                iArr3[i6] = i2 * min;
                i7 = Math.max(i7, iArr3[i6]);
                jArr3[i6] = ((long) i5) * j;
                iArr4[i6] = 1;
                j2 += (long) iArr3[i6];
                i5 += min;
                i9 -= min;
                i6++;
            }
        }
        return new a(jArr2, iArr3, i7, jArr3, iArr4, j * ((long) i5), (byte) 0);
    }
}
