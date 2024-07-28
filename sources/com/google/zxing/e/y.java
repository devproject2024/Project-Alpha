package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.d;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.q;
import com.google.zxing.r;
import com.google.zxing.s;
import com.google.zxing.t;
import com.google.zxing.u;
import java.util.Arrays;
import java.util.Map;

public abstract class y extends r {

    /* renamed from: b  reason: collision with root package name */
    static final int[] f40402b = {1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f40403c = {1, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f40404d = {1, 1, 1, 1, 1, 1};

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f40405e = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* renamed from: f  reason: collision with root package name */
    static final int[][] f40406f = new int[20][];

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f40407a = new StringBuilder(20);

    /* renamed from: g  reason: collision with root package name */
    private final x f40408g = new x();

    /* renamed from: h  reason: collision with root package name */
    private final m f40409h = new m();

    /* access modifiers changed from: protected */
    public abstract int a(a aVar, int[] iArr, StringBuilder sb) throws m;

    /* access modifiers changed from: package-private */
    public abstract com.google.zxing.a b();

    static {
        System.arraycopy(f40405e, 0, f40406f, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr = f40405e[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            f40406f[i2] = iArr2;
        }
    }

    protected y() {
    }

    static int[] a(a aVar) throws m {
        int[] iArr = new int[f40402b.length];
        int[] iArr2 = null;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f40402b.length, 0);
            iArr2 = a(aVar, i2, false, f40402b, iArr);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                z = aVar.a(i5, i3);
            }
            i2 = i4;
        }
        return iArr2;
    }

    public r a(int i2, a aVar, Map<e, ?> map) throws m, d, h {
        return a(i2, aVar, a(aVar), map);
    }

    public r a(int i2, a aVar, int[] iArr, Map<e, ?> map) throws m, d, h {
        u uVar;
        int i3;
        int[] iArr2;
        boolean z;
        String str = null;
        if (map == null) {
            uVar = null;
        } else {
            uVar = (u) map.get(e.NEED_RESULT_POINT_CALLBACK);
        }
        if (uVar != null) {
            uVar.a(new t(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i2));
        }
        StringBuilder sb = this.f40407a;
        sb.setLength(0);
        int a2 = a(aVar, iArr, sb);
        if (uVar != null) {
            uVar.a(new t((float) a2, (float) i2));
        }
        int[] a3 = a(aVar, a2);
        if (uVar != null) {
            uVar.a(new t(((float) (a3[0] + a3[1])) / 2.0f, (float) i2));
        }
        int i4 = a3[1];
        int i5 = (i4 - a3[0]) + i4;
        if (i5 >= aVar.f39881b || !aVar.a(i4, i5)) {
            throw m.getNotFoundInstance();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw h.getFormatInstance();
        } else if (a(sb2)) {
            com.google.zxing.a b2 = b();
            float f2 = (float) i2;
            r rVar = new r(sb2, (byte[]) null, new t[]{new t(((float) (iArr[1] + iArr[0])) / 2.0f, f2), new t(((float) (a3[1] + a3[0])) / 2.0f, f2)}, b2);
            try {
                r a4 = this.f40408g.a(i2, aVar, a3[1]);
                rVar.a(s.UPC_EAN_EXTENSION, a4.f40577a);
                rVar.a(a4.f40581e);
                t[] tVarArr = a4.f40579c;
                t[] tVarArr2 = rVar.f40579c;
                if (tVarArr2 == null) {
                    rVar.f40579c = tVarArr;
                } else if (tVarArr != null && tVarArr.length > 0) {
                    t[] tVarArr3 = new t[(tVarArr2.length + tVarArr.length)];
                    System.arraycopy(tVarArr2, 0, tVarArr3, 0, tVarArr2.length);
                    System.arraycopy(tVarArr, 0, tVarArr3, tVarArr2.length, tVarArr.length);
                    rVar.f40579c = tVarArr3;
                }
                i3 = a4.f40577a.length();
            } catch (q unused) {
                i3 = 0;
            }
            if (map == null) {
                iArr2 = null;
            } else {
                iArr2 = (int[]) map.get(e.ALLOWED_EAN_EXTENSIONS);
            }
            if (iArr2 != null) {
                int length = iArr2.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        z = false;
                        break;
                    } else if (i3 == iArr2[i6]) {
                        z = true;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (!z) {
                    throw m.getNotFoundInstance();
                }
            }
            if (b2 == com.google.zxing.a.EAN_13 || b2 == com.google.zxing.a.UPC_A) {
                m mVar = this.f40409h;
                mVar.a();
                int parseInt = Integer.parseInt(sb2.substring(0, 3));
                int size = mVar.f40380a.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size) {
                        break;
                    }
                    int[] iArr3 = mVar.f40380a.get(i7);
                    int i8 = iArr3[0];
                    if (parseInt < i8) {
                        break;
                    }
                    if (iArr3.length != 1) {
                        i8 = iArr3[1];
                    }
                    if (parseInt <= i8) {
                        str = mVar.f40381b.get(i7);
                        break;
                    }
                    i7++;
                }
                if (str != null) {
                    rVar.a(s.POSSIBLE_COUNTRY, str);
                }
            }
            return rVar;
        } else {
            throw d.getChecksumInstance();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) throws h {
        return a((CharSequence) str);
    }

    static boolean a(CharSequence charSequence) throws h {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return b(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    static int b(CharSequence charSequence) throws h {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw h.getFormatInstance();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw h.getFormatInstance();
            }
            i4 += charAt2;
        }
        return (1000 - i4) % 10;
    }

    /* access modifiers changed from: package-private */
    public int[] a(a aVar, int i2) throws m {
        return a(aVar, i2, false, f40402b);
    }

    static int[] a(a aVar, int i2, boolean z, int[] iArr) throws m {
        return a(aVar, i2, z, iArr, new int[iArr.length]);
    }

    static int a(a aVar, int[] iArr, int i2, int[][] iArr2) throws m {
        a(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float a2 = a(iArr, iArr2[i4], 0.7f);
            if (a2 < f2) {
                i3 = i4;
                f2 = a2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw m.getNotFoundInstance();
    }

    private static int[] a(a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws m {
        int i3 = aVar.f39881b;
        int d2 = z ? aVar.d(i2) : aVar.c(i2);
        int length = iArr.length;
        int i4 = d2;
        int i5 = 0;
        while (d2 < i3) {
            if (aVar.a(d2) != z) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (a(iArr2, iArr, 0.7f) < 0.48f) {
                    return new int[]{i4, d2};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                z = !z;
            }
            d2++;
        }
        throw m.getNotFoundInstance();
    }
}
