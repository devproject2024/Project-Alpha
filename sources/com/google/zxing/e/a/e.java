package com.google.zxing.e.a;

import com.google.zxing.b.a;
import com.google.zxing.m;
import com.google.zxing.r;
import com.google.zxing.t;
import com.google.zxing.u;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e extends a {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f40356g = {1, 10, 34, 70, 126};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f40357h = {4, 20, 48, 81};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f40358i = {0, Constants.ACTION_NB_WV_LOGIN_CLICKED, 961, 2015, 2715};
    private static final int[] j = {0, 336, 1036, 1516};
    private static final int[] k = {8, 6, 4, 3, 1};
    private static final int[] l = {2, 4, 6, 8};
    private static final int[][] m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> n = new ArrayList();
    private final List<d> o = new ArrayList();

    public final r a(int i2, a aVar, Map<com.google.zxing.e, ?> map) throws m {
        a((Collection<d>) this.n, a(aVar, false, i2, map));
        aVar.c();
        a((Collection<d>) this.o, a(aVar, true, i2, map));
        aVar.c();
        for (d next : this.n) {
            if (next.f40355d > 1) {
                for (d next2 : this.o) {
                    if (next2.f40355d > 1) {
                        int i3 = (next.f40350b + (next2.f40350b * 16)) % 79;
                        int i4 = (next.f40354c.f40351a * 9) + next2.f40354c.f40351a;
                        if (i4 > 72) {
                            i4--;
                        }
                        if (i4 > 8) {
                            i4--;
                        }
                        if (i3 == i4) {
                            String valueOf = String.valueOf((((long) next.f40349a) * 4537077) + ((long) next2.f40349a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - valueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(valueOf);
                            int i5 = 0;
                            for (int i6 = 0; i6 < 13; i6++) {
                                int charAt = sb.charAt(i6) - '0';
                                if ((i6 & 1) == 0) {
                                    charAt *= 3;
                                }
                                i5 += charAt;
                            }
                            int i7 = 10 - (i5 % 10);
                            if (i7 == 10) {
                                i7 = 0;
                            }
                            sb.append(i7);
                            t[] tVarArr = next.f40354c.f40353c;
                            t[] tVarArr2 = next2.f40354c.f40353c;
                            return new r(sb.toString(), (byte[]) null, new t[]{tVarArr[0], tVarArr[1], tVarArr2[0], tVarArr2[1]}, com.google.zxing.a.RSS_14);
                        }
                    }
                }
                continue;
            }
        }
        throw m.getNotFoundInstance();
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar != null) {
            boolean z = false;
            Iterator<d> it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                d next = it2.next();
                if (next.f40349a == dVar.f40349a) {
                    next.a();
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(dVar);
            }
        }
    }

    public final void a() {
        this.n.clear();
        this.o.clear();
    }

    private d a(a aVar, boolean z, int i2, Map<com.google.zxing.e, ?> map) {
        int i3;
        int i4;
        u uVar;
        a aVar2 = aVar;
        boolean z2 = z;
        Map<com.google.zxing.e, ?> map2 = map;
        try {
            int[] iArr = this.f40310a;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            int i5 = aVar2.f39881b;
            int i6 = 0;
            boolean z3 = false;
            while (i6 < i5) {
                z3 = !aVar2.a(i6);
                if (z2 == z3) {
                    break;
                }
                i6++;
            }
            int i7 = i6;
            int i8 = 0;
            while (i6 < i5) {
                if (aVar2.a(i6) != z3) {
                    iArr[i8] = iArr[i8] + 1;
                    int i9 = i2;
                } else {
                    if (i8 != 3) {
                        int i10 = i2;
                        i8++;
                    } else if (a(iArr)) {
                        int[] iArr2 = {i7, i6};
                        boolean a2 = aVar2.a(iArr2[0]);
                        int i11 = iArr2[0] - 1;
                        while (i11 >= 0 && a2 != aVar2.a(i11)) {
                            i11--;
                        }
                        int i12 = i11 + 1;
                        int[] iArr3 = this.f40310a;
                        System.arraycopy(iArr3, 0, iArr3, 1, iArr3.length - 1);
                        iArr3[0] = iArr2[0] - i12;
                        int a3 = a(iArr3, m);
                        int i13 = iArr2[1];
                        if (z2) {
                            i4 = (aVar2.f39881b - 1) - i12;
                            i3 = (aVar2.f39881b - 1) - i13;
                        } else {
                            i3 = i13;
                            i4 = i12;
                        }
                        c cVar = new c(a3, new int[]{i12, iArr2[1]}, i4, i3, i2);
                        if (map2 == null) {
                            uVar = null;
                        } else {
                            uVar = (u) map2.get(com.google.zxing.e.NEED_RESULT_POINT_CALLBACK);
                        }
                        if (uVar != null) {
                            float f2 = ((float) (iArr2[0] + iArr2[1])) / 2.0f;
                            if (z2) {
                                f2 = ((float) (aVar2.f39881b - 1)) - f2;
                            }
                            uVar.a(new t(f2, (float) i2));
                        }
                        b a4 = a(aVar2, cVar, true);
                        b a5 = a(aVar2, cVar, false);
                        return new d((a4.f40349a * 1597) + a5.f40349a, a4.f40350b + (a5.f40350b * 4), cVar);
                    } else {
                        int i14 = i2;
                        i7 += iArr[0] + iArr[1];
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = 0;
                        iArr[3] = 0;
                        i8--;
                    }
                    iArr[i8] = 1;
                    z3 = !z3;
                }
                i6++;
            }
            throw m.getNotFoundInstance();
        } catch (m unused) {
            return null;
        }
    }

    private b a(a aVar, c cVar, boolean z) throws m {
        int[] iArr = this.f40311b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        if (z) {
            b(aVar, cVar.f40352b[0], iArr);
        } else {
            a(aVar, cVar.f40352b[1] + 1, iArr);
            int i3 = 0;
            for (int length = iArr.length - 1; i3 < length; length--) {
                int i4 = iArr[i3];
                iArr[i3] = iArr[length];
                iArr[length] = i4;
                i3++;
            }
        }
        int i5 = z ? 16 : 15;
        float a2 = ((float) com.google.zxing.b.a.a.a(iArr)) / ((float) i5);
        int[] iArr2 = this.f40314e;
        int[] iArr3 = this.f40315f;
        float[] fArr = this.f40312c;
        float[] fArr2 = this.f40313d;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f2 = ((float) iArr[i6]) / a2;
            int i7 = (int) (0.5f + f2);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                iArr2[i8] = i7;
                fArr[i8] = f2 - ((float) i7);
            } else {
                iArr3[i8] = i7;
                fArr2[i8] = f2 - ((float) i7);
            }
        }
        a(z, i5);
        int i9 = 0;
        int i10 = 0;
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            i9 = (i9 * 9) + iArr2[length2];
            i10 += iArr2[length2];
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
            i11 = (i11 * 9) + iArr3[length3];
            i12 += iArr3[length3];
        }
        int i13 = i9 + (i11 * 3);
        if (z) {
            if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
                throw m.getNotFoundInstance();
            }
            int i14 = (12 - i10) / 2;
            int i15 = k[i14];
            return new b((f.a(iArr2, i15, false) * f40356g[i14]) + f.a(iArr3, 9 - i15, true) + f40358i[i14], i13);
        } else if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
            throw m.getNotFoundInstance();
        } else {
            int i16 = (10 - i12) / 2;
            int i17 = l[i16];
            return new b((f.a(iArr3, 9 - i17, false) * f40357h[i16]) + f.a(iArr2, i17, true) + j[i16], i13);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r1 < 4) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r1 < 4) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        r7 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r10, int r11) throws com.google.zxing.m {
        /*
            r9 = this;
            int[] r0 = r9.f40314e
            int r0 = com.google.zxing.b.a.a.a((int[]) r0)
            int[] r1 = r9.f40315f
            int r1 = com.google.zxing.b.a.a.a((int[]) r1)
            r2 = 4
            r3 = 0
            r4 = 1
            if (r10 == 0) goto L_0x0027
            r5 = 12
            if (r0 <= r5) goto L_0x0017
            r6 = 1
            goto L_0x001c
        L_0x0017:
            r6 = 0
            if (r0 >= r2) goto L_0x001c
            r7 = 1
            goto L_0x001d
        L_0x001c:
            r7 = 0
        L_0x001d:
            if (r1 <= r5) goto L_0x0022
            r5 = r6
            r6 = r7
            goto L_0x0039
        L_0x0022:
            r5 = r6
            r6 = r7
            if (r1 >= r2) goto L_0x0040
            goto L_0x003e
        L_0x0027:
            r5 = 11
            if (r0 <= r5) goto L_0x002d
            r5 = 1
            goto L_0x0034
        L_0x002d:
            r5 = 5
            if (r0 >= r5) goto L_0x0033
            r5 = 0
            r6 = 1
            goto L_0x0035
        L_0x0033:
            r5 = 0
        L_0x0034:
            r6 = 0
        L_0x0035:
            r7 = 10
            if (r1 <= r7) goto L_0x003c
        L_0x0039:
            r2 = 0
            r7 = 1
            goto L_0x0042
        L_0x003c:
            if (r1 >= r2) goto L_0x0040
        L_0x003e:
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            r7 = 0
        L_0x0042:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r10) goto L_0x004b
            r10 = 1
            goto L_0x004c
        L_0x004b:
            r10 = 0
        L_0x004c:
            r11 = r1 & 1
            if (r11 != r4) goto L_0x0051
            r3 = 1
        L_0x0051:
            if (r8 != r4) goto L_0x0067
            if (r10 == 0) goto L_0x005e
            if (r3 != 0) goto L_0x0059
        L_0x0057:
            r5 = 1
            goto L_0x0091
        L_0x0059:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x005e:
            if (r3 == 0) goto L_0x0062
        L_0x0060:
            r7 = 1
            goto L_0x0091
        L_0x0062:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x0067:
            r11 = -1
            if (r8 != r11) goto L_0x007e
            if (r10 == 0) goto L_0x0075
            if (r3 != 0) goto L_0x0070
            r6 = 1
            goto L_0x0091
        L_0x0070:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x0075:
            if (r3 == 0) goto L_0x0079
            r2 = 1
            goto L_0x0091
        L_0x0079:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x007e:
            if (r8 != 0) goto L_0x00cb
            if (r10 == 0) goto L_0x008f
            if (r3 == 0) goto L_0x008a
            if (r0 >= r1) goto L_0x0088
            r6 = 1
            goto L_0x0060
        L_0x0088:
            r2 = 1
            goto L_0x0057
        L_0x008a:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x008f:
            if (r3 != 0) goto L_0x00c6
        L_0x0091:
            if (r6 == 0) goto L_0x00a2
            if (r5 != 0) goto L_0x009d
            int[] r10 = r9.f40314e
            float[] r11 = r9.f40312c
            a((int[]) r10, (float[]) r11)
            goto L_0x00a2
        L_0x009d:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x00a2:
            if (r5 == 0) goto L_0x00ab
            int[] r10 = r9.f40314e
            float[] r11 = r9.f40312c
            b(r10, r11)
        L_0x00ab:
            if (r2 == 0) goto L_0x00bc
            if (r7 != 0) goto L_0x00b7
            int[] r10 = r9.f40315f
            float[] r11 = r9.f40312c
            a((int[]) r10, (float[]) r11)
            goto L_0x00bc
        L_0x00b7:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x00bc:
            if (r7 == 0) goto L_0x00c5
            int[] r10 = r9.f40315f
            float[] r11 = r9.f40313d
            b(r10, r11)
        L_0x00c5:
            return
        L_0x00c6:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        L_0x00cb:
            com.google.zxing.m r10 = com.google.zxing.m.getNotFoundInstance()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.a.e.a(boolean, int):void");
    }
}
