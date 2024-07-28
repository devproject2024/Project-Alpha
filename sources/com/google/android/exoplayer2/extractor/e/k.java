package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;

final class k {
    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    public static boolean a(int i2, r rVar, boolean z) throws v {
        if (rVar.b() < 7) {
            if (z) {
                return false;
            }
            throw new v("too short header: " + rVar.b());
        } else if (rVar.c() != i2) {
            if (z) {
                return false;
            }
            throw new v("expected header type " + Integer.toHexString(i2));
        } else if (rVar.c() == 118 && rVar.c() == 111 && rVar.c() == 114 && rVar.c() == 98 && rVar.c() == 105 && rVar.c() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new v("expected characters 'vorbis'");
        }
    }

    static c[] a(i iVar) {
        int a2 = iVar.a(6) + 1;
        c[] cVarArr = new c[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            cVarArr[i2] = new c(iVar.a(), iVar.a(16), iVar.a(16), iVar.a(8));
        }
        return cVarArr;
    }

    static void a(int i2, i iVar) throws v {
        int a2 = iVar.a(6) + 1;
        for (int i3 = 0; i3 < a2; i3++) {
            int a3 = iVar.a(16);
            if (a3 != 0) {
                "mapping type other than 0 not supported: ".concat(String.valueOf(a3));
                l.d();
            } else {
                int a4 = iVar.a() ? iVar.a(4) + 1 : 1;
                if (iVar.a()) {
                    int a5 = iVar.a(8) + 1;
                    for (int i4 = 0; i4 < a5; i4++) {
                        int i5 = i2 - 1;
                        iVar.b(a(i5));
                        iVar.b(a(i5));
                    }
                }
                if (iVar.a(2) == 0) {
                    if (a4 > 1) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            iVar.b(4);
                        }
                    }
                    for (int i7 = 0; i7 < a4; i7++) {
                        iVar.b(8);
                        iVar.b(8);
                        iVar.b(8);
                    }
                } else {
                    throw new v("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    static void b(i iVar) throws v {
        int a2 = iVar.a(6) + 1;
        int i2 = 0;
        while (i2 < a2) {
            if (iVar.a(16) <= 2) {
                iVar.b(24);
                iVar.b(24);
                iVar.b(24);
                int a3 = iVar.a(6) + 1;
                iVar.b(8);
                int[] iArr = new int[a3];
                for (int i3 = 0; i3 < a3; i3++) {
                    iArr[i3] = ((iVar.a() ? iVar.a(5) : 0) * 8) + iVar.a(3);
                }
                for (int i4 = 0; i4 < a3; i4++) {
                    for (int i5 = 0; i5 < 8; i5++) {
                        if ((iArr[i4] & (1 << i5)) != 0) {
                            iVar.b(8);
                        }
                    }
                }
                i2++;
            } else {
                throw new v("residueType greater than 2 is not decodable");
            }
        }
    }

    static void c(i iVar) throws v {
        int a2 = iVar.a(6) + 1;
        for (int i2 = 0; i2 < a2; i2++) {
            int a3 = iVar.a(16);
            if (a3 == 0) {
                iVar.b(8);
                iVar.b(16);
                iVar.b(16);
                iVar.b(6);
                iVar.b(8);
                int a4 = iVar.a(4) + 1;
                for (int i3 = 0; i3 < a4; i3++) {
                    iVar.b(8);
                }
            } else if (a3 == 1) {
                int a5 = iVar.a(5);
                int[] iArr = new int[a5];
                int i4 = -1;
                for (int i5 = 0; i5 < a5; i5++) {
                    iArr[i5] = iVar.a(4);
                    if (iArr[i5] > i4) {
                        i4 = iArr[i5];
                    }
                }
                int[] iArr2 = new int[(i4 + 1)];
                for (int i6 = 0; i6 < iArr2.length; i6++) {
                    iArr2[i6] = iVar.a(3) + 1;
                    int a6 = iVar.a(2);
                    if (a6 > 0) {
                        iVar.b(8);
                    }
                    for (int i7 = 0; i7 < (1 << a6); i7++) {
                        iVar.b(8);
                    }
                }
                iVar.b(2);
                int a7 = iVar.a(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < a5; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        iVar.b(a7);
                        i9++;
                    }
                }
            } else {
                throw new v("floor type greater than 1 not decodable: ".concat(String.valueOf(a3)));
            }
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f31855a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31856b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f31857c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31858d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f31859e;

        public a(int i2, int i3, long[] jArr, int i4, boolean z) {
            this.f31855a = i2;
            this.f31856b = i3;
            this.f31857c = jArr;
            this.f31858d = i4;
            this.f31859e = z;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f31860a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f31861b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31862c;

        public b(String str, String[] strArr, int i2) {
            this.f31860a = str;
            this.f31861b = strArr;
            this.f31862c = i2;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f31867a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31868b;

        /* renamed from: c  reason: collision with root package name */
        public final long f31869c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31870d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31871e;

        /* renamed from: f  reason: collision with root package name */
        public final int f31872f;

        /* renamed from: g  reason: collision with root package name */
        public final int f31873g;

        /* renamed from: h  reason: collision with root package name */
        public final int f31874h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f31875i;
        public final byte[] j;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            this.f31867a = j2;
            this.f31868b = i2;
            this.f31869c = j3;
            this.f31870d = i3;
            this.f31871e = i4;
            this.f31872f = i5;
            this.f31873g = i6;
            this.f31874h = i7;
            this.f31875i = z;
            this.j = bArr;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f31863a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31864b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31865c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31866d;

        public c(boolean z, int i2, int i3, int i4) {
            this.f31863a = z;
            this.f31864b = i2;
            this.f31865c = i3;
            this.f31866d = i4;
        }
    }
}
