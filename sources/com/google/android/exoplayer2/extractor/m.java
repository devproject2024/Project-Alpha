package com.google.android.exoplayer2.extractor;

public final class m {

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f32146h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f32147i = {44100, 48000, 32000};
    private static final int[] j = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] k = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] l = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] m = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] n = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* renamed from: a  reason: collision with root package name */
    public int f32148a;

    /* renamed from: b  reason: collision with root package name */
    public String f32149b;

    /* renamed from: c  reason: collision with root package name */
    public int f32150c;

    /* renamed from: d  reason: collision with root package name */
    public int f32151d;

    /* renamed from: e  reason: collision with root package name */
    public int f32152e;

    /* renamed from: f  reason: collision with root package name */
    public int f32153f;

    /* renamed from: g  reason: collision with root package name */
    public int f32154g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i2 & -2097152) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = f32147i[i6];
        if (i3 == 2) {
            i8 /= 2;
        } else if (i3 == 0) {
            i8 /= 4;
        }
        int i9 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? j[i5 - 1] : k[i5 - 1]) * 12) / i8) + i9) * 4;
        }
        if (i3 == 3) {
            i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
        } else {
            i7 = n[i5 - 1];
        }
        int i10 = 144;
        if (i3 == 3) {
            return ((i7 * 144) / i8) + i9;
        }
        if (i4 == 1) {
            i10 = 72;
        }
        return ((i10 * i7) / i8) + i9;
    }

    public static boolean a(int i2, m mVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        if ((i2 & -2097152) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i12 = f32147i[i6];
        int i13 = 2;
        if (i3 == 2) {
            i12 /= 2;
        } else if (i3 == 0) {
            i12 /= 4;
        }
        int i14 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            i9 = i3 == 3 ? j[i5 - 1] : k[i5 - 1];
            i8 = (((i9 * 12) / i12) + i14) * 4;
            i7 = 384;
        } else {
            i7 = 1152;
            if (i3 == 3) {
                i11 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
            } else {
                i11 = n[i5 - 1];
                if (i4 == 1) {
                    i7 = 576;
                }
                if (i4 == 1) {
                    i10 = 72;
                    i8 = i14 + ((i10 * i9) / i12);
                }
            }
            i10 = 144;
            i8 = i14 + ((i10 * i9) / i12);
        }
        String str = f32146h[3 - i4];
        if (((i2 >> 6) & 3) == 3) {
            i13 = 1;
        }
        mVar.f32148a = i3;
        mVar.f32149b = str;
        mVar.f32150c = i8;
        mVar.f32151d = i12;
        mVar.f32152e = i13;
        mVar.f32153f = i9;
        mVar.f32154g = i7;
        return true;
    }
}
