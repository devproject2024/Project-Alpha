package com.google.zxing.g.b;

import com.google.zxing.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.zxing.b.b f40537a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f40538b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f40539c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f40540d = new int[5];

    /* renamed from: e  reason: collision with root package name */
    private final u f40541e;

    public e(com.google.zxing.b.b bVar, u uVar) {
        this.f40537a = bVar;
        this.f40541e = uVar;
    }

    private static float a(int[] iArr, int i2) {
        return ((float) ((i2 - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    public static boolean a(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = ((float) i2) / 7.0f;
        float f3 = f2 / 2.0f;
        if (Math.abs(f2 - ((float) iArr[0])) >= f3 || Math.abs(f2 - ((float) iArr[1])) >= f3 || Math.abs((f2 * 3.0f) - ((float) iArr[2])) >= 3.0f * f3 || Math.abs(f2 - ((float) iArr[3])) >= f3 || Math.abs(f2 - ((float) iArr[4])) >= f3) {
            return false;
        }
        return true;
    }

    private int[] b() {
        b(this.f40540d);
        return this.f40540d;
    }

    public static void b(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    public static void c(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] b2 = b();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.f40537a.a(i3 - i7, i2 - i7)) {
            b2[2] = b2[2] + 1;
            i7++;
        }
        if (b2[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.f40537a.a(i3 - i7, i2 - i7)) {
            b2[1] = b2[1] + 1;
            i7++;
        }
        if (b2[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.f40537a.a(i3 - i7, i2 - i7)) {
            b2[0] = b2[0] + 1;
            i7++;
        }
        if (b2[0] == 0) {
            return false;
        }
        int i8 = this.f40537a.f39890b;
        int i9 = this.f40537a.f39889a;
        int i10 = 1;
        while (true) {
            int i11 = i2 + i10;
            if (i11 < i8 && (i6 = i3 + i10) < i9 && this.f40537a.a(i6, i11)) {
                b2[2] = b2[2] + 1;
                i10++;
            }
        }
        while (true) {
            int i12 = i2 + i10;
            if (i12 < i8 && (i5 = i3 + i10) < i9 && !this.f40537a.a(i5, i12)) {
                b2[3] = b2[3] + 1;
                i10++;
            }
        }
        if (b2[3] == 0) {
            return false;
        }
        while (true) {
            int i13 = i2 + i10;
            if (i13 < i8 && (i4 = i3 + i10) < i9 && this.f40537a.a(i4, i13)) {
                b2[4] = b2[4] + 1;
                i10++;
            }
        }
        if (b2[4] == 0) {
            return false;
        }
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i14 < 5) {
                int i16 = b2[i14];
                if (i16 == 0) {
                    break;
                }
                i15 += i16;
                i14++;
            } else if (i15 >= 7) {
                float f2 = ((float) i15) / 7.0f;
                float f3 = f2 / 1.333f;
                return Math.abs(f2 - ((float) b2[0])) < f3 && Math.abs(f2 - ((float) b2[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) b2[2])) < 3.0f * f3 && Math.abs(f2 - ((float) b2[3])) < f3 && Math.abs(f2 - ((float) b2[4])) < f3;
            }
        }
    }

    private float a(int i2, int i3, int i4, int i5) {
        com.google.zxing.b.b bVar = this.f40537a;
        int i6 = bVar.f39890b;
        int[] b2 = b();
        int i7 = i2;
        while (i7 >= 0 && bVar.a(i3, i7)) {
            b2[2] = b2[2] + 1;
            i7--;
        }
        if (i7 < 0) {
            return Float.NaN;
        }
        while (i7 >= 0 && !bVar.a(i3, i7) && b2[1] <= i4) {
            b2[1] = b2[1] + 1;
            i7--;
        }
        if (i7 >= 0 && b2[1] <= i4) {
            while (i7 >= 0 && bVar.a(i3, i7) && b2[0] <= i4) {
                b2[0] = b2[0] + 1;
                i7--;
            }
            if (b2[0] > i4) {
                return Float.NaN;
            }
            int i8 = i2 + 1;
            while (i8 < i6 && bVar.a(i3, i8)) {
                b2[2] = b2[2] + 1;
                i8++;
            }
            if (i8 == i6) {
                return Float.NaN;
            }
            while (i8 < i6 && !bVar.a(i3, i8) && b2[3] < i4) {
                b2[3] = b2[3] + 1;
                i8++;
            }
            if (i8 != i6 && b2[3] < i4) {
                while (i8 < i6 && bVar.a(i3, i8) && b2[4] < i4) {
                    b2[4] = b2[4] + 1;
                    i8++;
                }
                if (b2[4] < i4 && Math.abs(((((b2[0] + b2[1]) + b2[2]) + b2[3]) + b2[4]) - i5) * 5 < i5 * 2 && a(b2)) {
                    return a(b2, i8);
                }
            }
        }
        return Float.NaN;
    }

    private float b(int i2, int i3, int i4, int i5) {
        com.google.zxing.b.b bVar = this.f40537a;
        int i6 = bVar.f39889a;
        int[] b2 = b();
        int i7 = i2;
        while (i7 >= 0 && bVar.a(i7, i3)) {
            b2[2] = b2[2] + 1;
            i7--;
        }
        if (i7 < 0) {
            return Float.NaN;
        }
        while (i7 >= 0 && !bVar.a(i7, i3) && b2[1] <= i4) {
            b2[1] = b2[1] + 1;
            i7--;
        }
        if (i7 >= 0 && b2[1] <= i4) {
            while (i7 >= 0 && bVar.a(i7, i3) && b2[0] <= i4) {
                b2[0] = b2[0] + 1;
                i7--;
            }
            if (b2[0] > i4) {
                return Float.NaN;
            }
            int i8 = i2 + 1;
            while (i8 < i6 && bVar.a(i8, i3)) {
                b2[2] = b2[2] + 1;
                i8++;
            }
            if (i8 == i6) {
                return Float.NaN;
            }
            while (i8 < i6 && !bVar.a(i8, i3) && b2[3] < i4) {
                b2[3] = b2[3] + 1;
                i8++;
            }
            if (i8 != i6 && b2[3] < i4) {
                while (i8 < i6 && bVar.a(i8, i3) && b2[4] < i4) {
                    b2[4] = b2[4] + 1;
                    i8++;
                }
                if (b2[4] < i4 && Math.abs(((((b2[0] + b2[1]) + b2[2]) + b2[3]) + b2[4]) - i5) * 5 < i5 && a(b2)) {
                    return a(b2, i8);
                }
            }
        }
        return Float.NaN;
    }

    public final boolean a(int[] iArr, int i2, int i3) {
        boolean z = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i3);
        float a3 = a(i2, a2, iArr[2], i4);
        if (!Float.isNaN(a3)) {
            int i5 = (int) a3;
            float b2 = b(a2, i5, iArr[2], i4);
            if (!Float.isNaN(b2) && a(i5, (int) b2)) {
                float f2 = ((float) i4) / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.f40538b.size()) {
                        break;
                    }
                    d dVar = this.f40538b.get(i6);
                    if (dVar.a(f2, a3, b2)) {
                        this.f40538b.set(i6, dVar.b(a3, b2, f2));
                        z = true;
                        break;
                    }
                    i6++;
                }
                if (!z) {
                    d dVar2 = new d(b2, a3, f2);
                    this.f40538b.add(dVar2);
                    u uVar = this.f40541e;
                    if (uVar != null) {
                        uVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean a() {
        int size = this.f40538b.size();
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        for (d next : this.f40538b) {
            if (next.f40536d >= 2) {
                i2++;
                f3 += next.f40535c;
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f4 = f3 / ((float) size);
        for (d dVar : this.f40538b) {
            f2 += Math.abs(dVar.f40535c - f4);
        }
        if (f2 <= f3 * 0.05f) {
            return true;
        }
        return false;
    }

    public static final class b implements Serializable, Comparator<d> {
        private final float average;

        private b(float f2) {
            this.average = f2;
        }

        public final int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.f40535c - this.average), Math.abs(dVar.f40535c - this.average));
        }
    }

    public static final class a implements Serializable, Comparator<d> {
        private final float average;

        private a(float f2) {
            this.average = f2;
        }

        public final int compare(d dVar, d dVar2) {
            int compare = Integer.compare(dVar2.f40536d, dVar.f40536d);
            return compare == 0 ? Float.compare(Math.abs(dVar.f40535c - this.average), Math.abs(dVar2.f40535c - this.average)) : compare;
        }
    }
}
