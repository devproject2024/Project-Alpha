package com.google.zxing.e.a.a;

import com.alipay.mobile.h5container.api.H5Param;
import com.google.zxing.e;
import com.google.zxing.e.a.a;
import com.google.zxing.e.a.a.a.j;
import com.google.zxing.e.a.b;
import com.google.zxing.e.a.c;
import com.google.zxing.e.a.f;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.r;
import com.google.zxing.t;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.instruments.upicollect.view.UpiCollectViewNew;

public final class d extends a {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f40346g = {7, 5, 4, 3, 1};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f40347h = {4, 20, 52, 104, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f40348i = {0, 348, 1388, 2948, 3988};
    private static final int[][] j = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] k = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, AppConstants.READ_TIME_OUT, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, Constants.ACTION_SAVE_CUST_ID, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{H5Param.WEBVIEW_FONT_SIZE_LARGER, 28, 84, 41, 123, Constants.ACTION_INCORRECT_OTP, 52, Constants.ACTION_DELAY_PASSWORD_FOUND}, new int[]{46, 138, 203, UpiCollectViewNew.REQUEST_CODE_UPI_APP, 139, 206, 196, 166}, new int[]{76, 17, 51, Constants.ACTION_REMOVE_NB_LAYOUT, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, Constants.ACTION_PASSWORD_VIEWER, 31, 93, 68, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, Constants.ACTION_PASSWORD_FOUND, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{Constants.ACTION_NB_WV_LOGIN_CLICKED, 61, 183, 127, 170, 88, 53, Constants.ACTION_NB_NEXT_BTN_CLICKED}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int[][] l = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List<b> m = new ArrayList(11);
    private final List<c> n = new ArrayList();
    private final int[] o = new int[2];
    private boolean p;

    public final r a(int i2, com.google.zxing.b.a aVar, Map<e, ?> map) throws m, h {
        this.m.clear();
        this.p = false;
        try {
            return a(a(i2, aVar));
        } catch (m unused) {
            this.m.clear();
            this.p = true;
            return a(a(i2, aVar));
        }
    }

    public final void a() {
        this.m.clear();
        this.n.clear();
    }

    private List<b> a(int i2, com.google.zxing.b.a aVar) throws m {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        while (!z7) {
            try {
                this.m.add(a(aVar, this.m, i2));
            } catch (m e2) {
                if (!this.m.isEmpty()) {
                    z7 = true;
                } else {
                    throw e2;
                }
            }
        }
        if (b()) {
            return this.m;
        }
        boolean z8 = !this.n.isEmpty();
        int i3 = 0;
        boolean z9 = false;
        while (true) {
            if (i3 >= this.n.size()) {
                z = false;
                break;
            }
            c cVar = this.n.get(i3);
            if (cVar.f40344b > i2) {
                z = cVar.a(this.m);
                break;
            }
            z9 = cVar.a(this.m);
            i3++;
        }
        if (!z && !z9) {
            List<b> list = this.m;
            Iterator<T> it2 = this.n.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                c cVar2 = (c) it2.next();
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z5 = true;
                        continue;
                        break;
                    }
                    b bVar = (b) it3.next();
                    Iterator<b> it4 = cVar2.f40343a.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            if (bVar.equals(it4.next())) {
                                z6 = true;
                                continue;
                                break;
                            }
                        } else {
                            z6 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z6) {
                        z5 = false;
                        continue;
                        break;
                    }
                }
                if (z5) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                this.n.add(i3, new c(this.m, i2));
                List<b> list2 = this.m;
                Iterator<c> it5 = this.n.iterator();
                while (it5.hasNext()) {
                    c next = it5.next();
                    if (next.f40343a.size() != list2.size()) {
                        Iterator<b> it6 = next.f40343a.iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                z3 = true;
                                break;
                            }
                            b next2 = it6.next();
                            Iterator<b> it7 = list2.iterator();
                            while (true) {
                                if (it7.hasNext()) {
                                    if (next2.equals(it7.next())) {
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z4 = false;
                                    continue;
                                    break;
                                }
                            }
                            if (!z4) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            it5.remove();
                        }
                    }
                }
            }
        }
        if (z8) {
            List<b> a2 = a(false);
            if (a2 != null) {
                return a2;
            }
            List<b> a3 = a(true);
            if (a3 != null) {
                return a3;
            }
        }
        throw m.getNotFoundInstance();
    }

    private List<b> a(boolean z) {
        List<b> list = null;
        if (this.n.size() > 25) {
            this.n.clear();
            return null;
        }
        this.m.clear();
        if (z) {
            Collections.reverse(this.n);
        }
        try {
            list = a((List<c>) new ArrayList(), 0);
        } catch (m unused) {
        }
        if (z) {
            Collections.reverse(this.n);
        }
        return list;
    }

    private List<b> a(List<c> list, int i2) throws m {
        boolean z;
        while (i2 < this.n.size()) {
            c cVar = this.n.get(i2);
            this.m.clear();
            for (c cVar2 : list) {
                this.m.addAll(cVar2.f40343a);
            }
            this.m.addAll(cVar.f40343a);
            List<b> list2 = this.m;
            int[][] iArr = l;
            int length = iArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i3];
                if (list2.size() <= iArr2.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list2.size()) {
                            z = true;
                            break;
                        } else if (list2.get(i4).f40341c.f40351a != iArr2[i4]) {
                            z = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
                i3++;
            }
            if (!z2) {
                i2++;
            } else if (b()) {
                return this.m;
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return a((List<c>) arrayList, i2 + 1);
                } catch (m unused) {
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    private static r a(List<b> list) throws m, h {
        String a2 = j.a(a.a(list)).a();
        t[] tVarArr = list.get(0).f40341c.f40353c;
        t[] tVarArr2 = list.get(list.size() - 1).f40341c.f40353c;
        return new r(a2, (byte[]) null, new t[]{tVarArr[0], tVarArr[1], tVarArr2[0], tVarArr2[1]}, com.google.zxing.a.RSS_EXPANDED);
    }

    private boolean b() {
        b bVar = this.m.get(0);
        b bVar2 = bVar.f40339a;
        b bVar3 = bVar.f40340b;
        if (bVar3 == null) {
            return false;
        }
        int i2 = bVar3.f40350b;
        int i3 = 2;
        for (int i4 = 1; i4 < this.m.size(); i4++) {
            b bVar4 = this.m.get(i4);
            i2 += bVar4.f40339a.f40350b;
            i3++;
            b bVar5 = bVar4.f40340b;
            if (bVar5 != null) {
                i2 += bVar5.f40350b;
                i3++;
            }
        }
        if (((i3 - 4) * 211) + (i2 % 211) == bVar2.f40349a) {
            return true;
        }
        return false;
    }

    private b a(com.google.zxing.b.a aVar, List<b> list, int i2) throws m {
        int i3;
        b bVar;
        com.google.zxing.b.a aVar2 = aVar;
        List<b> list2 = list;
        int i4 = 2;
        boolean z = true;
        boolean z2 = list.size() % 2 == 0;
        if (this.p) {
            z2 = !z2;
        }
        int i5 = -1;
        boolean z3 = true;
        while (true) {
            int[] iArr = this.f40310a;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[i4] = 0;
            iArr[3] = 0;
            int i6 = aVar2.f39881b;
            if (i5 < 0) {
                i3 = list.isEmpty() ? 0 : list2.get(list.size() - 1).f40341c.f40352b[1];
            } else {
                i3 = i5;
            }
            boolean z4 = list.size() % i4 != 0;
            if (this.p) {
                z4 = !z4;
            }
            boolean z5 = false;
            while (i3 < i6) {
                z5 = !aVar2.a(i3);
                if (!z5) {
                    break;
                }
                i3++;
            }
            int i7 = i3;
            int i8 = 0;
            while (i3 < i6) {
                if (aVar2.a(i3) != z5) {
                    iArr[i8] = iArr[i8] + 1;
                    int i9 = i2;
                } else {
                    if (i8 == 3) {
                        if (z4) {
                            b(iArr);
                        }
                        if (a(iArr)) {
                            int[] iArr2 = this.o;
                            iArr2[0] = i7;
                            iArr2[1] = i3;
                            c a2 = a(aVar2, i2, z2);
                            if (a2 == null) {
                                int i10 = this.o[0];
                                if (aVar2.a(i10)) {
                                    i5 = aVar2.c(aVar2.d(i10));
                                } else {
                                    i5 = aVar2.d(aVar2.c(i10));
                                }
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                b a3 = a(aVar2, a2, z2, true);
                                if (!list.isEmpty()) {
                                    if (list2.get(list.size() - 1).f40340b != null) {
                                        z = false;
                                    }
                                    if (z) {
                                        throw m.getNotFoundInstance();
                                    }
                                }
                                try {
                                    bVar = a(aVar2, a2, z2, false);
                                } catch (m unused) {
                                    bVar = null;
                                }
                                return new b(a3, bVar, a2);
                            }
                            i4 = 2;
                        } else {
                            int i11 = i2;
                            if (z4) {
                                b(iArr);
                            }
                            i7 += iArr[0] + iArr[1];
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = 0;
                            iArr[3] = 0;
                            i8--;
                        }
                    } else {
                        int i12 = i2;
                        i8++;
                    }
                    iArr[i8] = 1;
                    z5 = !z5;
                }
                i3++;
            }
            throw m.getNotFoundInstance();
        }
    }

    private static void b(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private c a(com.google.zxing.b.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.o[0] - 1;
            while (i6 >= 0 && !aVar.a(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.o;
            i4 = iArr[1];
            i5 = i7;
            i3 = iArr[0] - i7;
        } else {
            int[] iArr2 = this.o;
            int i8 = iArr2[0];
            int d2 = aVar.d(iArr2[1] + 1);
            i3 = d2 - this.o[1];
            i4 = d2;
            i5 = i8;
        }
        int[] iArr3 = this.f40310a;
        System.arraycopy(iArr3, 0, iArr3, 1, iArr3.length - 1);
        iArr3[0] = i3;
        try {
            return new c(a(iArr3, j), new int[]{i5, i4}, i5, i4, i2);
        } catch (m unused) {
            return null;
        }
    }

    private b a(com.google.zxing.b.a aVar, c cVar, boolean z, boolean z2) throws m {
        com.google.zxing.b.a aVar2 = aVar;
        c cVar2 = cVar;
        int[] iArr = this.f40311b;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        if (z2) {
            b(aVar2, cVar2.f40352b[0], iArr);
        } else {
            a(aVar2, cVar2.f40352b[1], iArr);
            int i3 = 0;
            for (int length = iArr.length - 1; i3 < length; length--) {
                int i4 = iArr[i3];
                iArr[i3] = iArr[length];
                iArr[length] = i4;
                i3++;
            }
        }
        float a2 = ((float) com.google.zxing.b.a.a.a(iArr)) / 17.0f;
        float f2 = ((float) (cVar2.f40352b[1] - cVar2.f40352b[0])) / 15.0f;
        if (Math.abs(a2 - f2) / f2 <= 0.3f) {
            int[] iArr2 = this.f40314e;
            int[] iArr3 = this.f40315f;
            float[] fArr = this.f40312c;
            float[] fArr2 = this.f40313d;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                float f3 = (((float) iArr[i5]) * 1.0f) / a2;
                int i6 = (int) (0.5f + f3);
                if (i6 <= 0) {
                    if (f3 >= 0.3f) {
                        i6 = 1;
                    } else {
                        throw m.getNotFoundInstance();
                    }
                } else if (i6 > 8) {
                    if (f3 <= 8.7f) {
                        i6 = 8;
                    } else {
                        throw m.getNotFoundInstance();
                    }
                }
                int i7 = i5 / 2;
                if ((i5 & 1) == 0) {
                    iArr2[i7] = i6;
                    fArr[i7] = f3 - ((float) i6);
                } else {
                    iArr3[i7] = i6;
                    fArr2[i7] = f3 - ((float) i6);
                }
            }
            c();
            int i8 = (((cVar2.f40351a * 4) + (z ? 0 : 2)) + (z2 ^ true ? 1 : 0)) - 1;
            int i9 = 0;
            int i10 = 0;
            for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
                if (a(cVar, z, z2)) {
                    i9 += iArr2[length2] * k[i8][length2 * 2];
                }
                i10 += iArr2[length2];
            }
            int i11 = 0;
            for (int length3 = iArr3.length - 1; length3 >= 0; length3--) {
                if (a(cVar, z, z2)) {
                    i11 += iArr3[length3] * k[i8][(length3 * 2) + 1];
                }
            }
            int i12 = i9 + i11;
            if ((i10 & 1) != 0 || i10 > 13 || i10 < 4) {
                throw m.getNotFoundInstance();
            }
            int i13 = (13 - i10) / 2;
            int i14 = f40346g[i13];
            return new b((f.a(iArr2, i14, true) * f40347h[i13]) + f.a(iArr3, 9 - i14, false) + f40348i[i13], i12);
        }
        throw m.getNotFoundInstance();
    }

    private static boolean a(c cVar, boolean z, boolean z2) {
        return cVar.f40351a != 0 || !z || !z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() throws com.google.zxing.m {
        /*
            r11 = this;
            int[] r0 = r11.f40314e
            int r0 = com.google.zxing.b.a.a.a((int[]) r0)
            int[] r1 = r11.f40315f
            int r1 = com.google.zxing.b.a.a.a((int[]) r1)
            r2 = 4
            r3 = 13
            r4 = 0
            r5 = 1
            if (r0 <= r3) goto L_0x0016
            r6 = 0
            r7 = 1
            goto L_0x001c
        L_0x0016:
            if (r0 >= r2) goto L_0x001a
            r6 = 1
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            r7 = 0
        L_0x001c:
            if (r1 <= r3) goto L_0x0021
            r2 = 0
            r3 = 1
            goto L_0x0027
        L_0x0021:
            if (r1 >= r2) goto L_0x0025
            r2 = 1
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r3 = 0
        L_0x0027:
            int r8 = r0 + r1
            int r8 = r8 + -17
            r9 = r0 & 1
            if (r9 != r5) goto L_0x0031
            r9 = 1
            goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            r10 = r1 & 1
            if (r10 != 0) goto L_0x0037
            r4 = 1
        L_0x0037:
            if (r8 != r5) goto L_0x004d
            if (r9 == 0) goto L_0x0044
            if (r4 != 0) goto L_0x003f
        L_0x003d:
            r7 = 1
            goto L_0x0077
        L_0x003f:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x0044:
            if (r4 == 0) goto L_0x0048
            r3 = 1
            goto L_0x0077
        L_0x0048:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x004d:
            r10 = -1
            if (r8 != r10) goto L_0x0064
            if (r9 == 0) goto L_0x005b
            if (r4 != 0) goto L_0x0056
        L_0x0054:
            r6 = 1
            goto L_0x0077
        L_0x0056:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x005b:
            if (r4 == 0) goto L_0x005f
            r2 = 1
            goto L_0x0077
        L_0x005f:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x0064:
            if (r8 != 0) goto L_0x00b1
            if (r9 == 0) goto L_0x0075
            if (r4 == 0) goto L_0x0070
            if (r0 >= r1) goto L_0x006e
            r3 = 1
            goto L_0x0054
        L_0x006e:
            r2 = 1
            goto L_0x003d
        L_0x0070:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x0075:
            if (r4 != 0) goto L_0x00ac
        L_0x0077:
            if (r6 == 0) goto L_0x0088
            if (r7 != 0) goto L_0x0083
            int[] r0 = r11.f40314e
            float[] r1 = r11.f40312c
            a((int[]) r0, (float[]) r1)
            goto L_0x0088
        L_0x0083:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x0088:
            if (r7 == 0) goto L_0x0091
            int[] r0 = r11.f40314e
            float[] r1 = r11.f40312c
            b(r0, r1)
        L_0x0091:
            if (r2 == 0) goto L_0x00a2
            if (r3 != 0) goto L_0x009d
            int[] r0 = r11.f40315f
            float[] r1 = r11.f40312c
            a((int[]) r0, (float[]) r1)
            goto L_0x00a2
        L_0x009d:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x00a2:
            if (r3 == 0) goto L_0x00ab
            int[] r0 = r11.f40315f
            float[] r1 = r11.f40313d
            b(r0, r1)
        L_0x00ab:
            return
        L_0x00ac:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        L_0x00b1:
            com.google.zxing.m r0 = com.google.zxing.m.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.a.a.d.c():void");
    }
}
