package com.google.zxing.a.c;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import net.one97.paytm.upi.util.UpiConstants;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f39864a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: b  reason: collision with root package name */
    static final int[][] f39865b = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: c  reason: collision with root package name */
    static final int[][] f39866c;

    /* renamed from: e  reason: collision with root package name */
    private static final int[][] f39867e;

    /* renamed from: d  reason: collision with root package name */
    final byte[] f39868d;

    static {
        Class<int> cls = int.class;
        int[][] iArr = (int[][]) Array.newInstance(cls, new int[]{5, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS});
        f39867e = iArr;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            f39867e[0][i2] = (i2 - 65) + 2;
        }
        f39867e[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            f39867e[1][i3] = (i3 - 97) + 2;
        }
        f39867e[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            f39867e[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr2 = f39867e;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < 28; i5++) {
            f39867e[3][iArr3[i5]] = i5;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr4[i6] > 0) {
                f39867e[4][iArr4[i6]] = i6;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(cls, new int[]{6, 6});
        f39866c = iArr5;
        for (int[] fill : iArr5) {
            Arrays.fill(fill, -1);
        }
        int[][] iArr6 = f39866c;
        iArr6[0][4] = 0;
        iArr6[1][4] = 0;
        iArr6[1][0] = 28;
        iArr6[3][4] = 0;
        iArr6[2][4] = 0;
        iArr6[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.f39868d = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar, int i2, Collection<f> collection) {
        char c2 = (char) (this.f39868d[i2] & 255);
        boolean z = f39867e[fVar.f39873b][c2] > 0;
        f fVar2 = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = f39867e[i3][c2];
            if (i4 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.b(i2);
                }
                if (!z || i3 == fVar.f39873b || i3 == 2) {
                    collection.add(fVar2.a(i3, i4));
                }
                if (!z && f39866c[fVar.f39873b][i3] >= 0) {
                    collection.add(fVar2.b(i3, i4));
                }
            }
        }
        if (fVar.f39874c > 0 || f39867e[fVar.f39873b][c2] == 0) {
            collection.add(fVar.a(i2));
        }
    }

    static Collection<f> a(Iterable<f> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        for (f next : iterable) {
            f b2 = next.b(i2);
            linkedList.add(b2.a(4, i3));
            if (next.f39873b != 4) {
                linkedList.add(b2.b(4, i3));
            }
            if (i3 == 3 || i3 == 4) {
                linkedList.add(b2.a(2, 16 - i3).a(2, 1));
            }
            if (next.f39874c > 0) {
                linkedList.add(next.a(i2).a(i2 + 1));
            }
        }
        return a(linkedList);
    }

    static Collection<f> a(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f next : iterable) {
            boolean z = true;
            Iterator it2 = linkedList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                f fVar = (f) it2.next();
                if (fVar.a(next)) {
                    z = false;
                    break;
                } else if (next.a(fVar)) {
                    it2.remove();
                }
            }
            if (z) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }
}
