package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;
import java.io.IOException;
import java.util.Arrays;

public final class el {

    /* renamed from: f  reason: collision with root package name */
    private static final el f10203f = new el(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    int f10204a;

    /* renamed from: b  reason: collision with root package name */
    int[] f10205b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f10206c;

    /* renamed from: d  reason: collision with root package name */
    int f10207d;

    /* renamed from: e  reason: collision with root package name */
    boolean f10208e;

    public static el a() {
        return f10203f;
    }

    static el a(el elVar, el elVar2) {
        int i2 = elVar.f10204a + elVar2.f10204a;
        int[] copyOf = Arrays.copyOf(elVar.f10205b, i2);
        System.arraycopy(elVar2.f10205b, 0, copyOf, elVar.f10204a, elVar2.f10204a);
        Object[] copyOf2 = Arrays.copyOf(elVar.f10206c, i2);
        System.arraycopy(elVar2.f10206c, 0, copyOf2, elVar.f10204a, elVar2.f10204a);
        return new el(i2, copyOf, copyOf2, true);
    }

    private el() {
        this(0, new int[8], new Object[8], true);
    }

    private el(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f10207d = -1;
        this.f10204a = i2;
        this.f10205b = iArr;
        this.f10206c = objArr;
        this.f10208e = z;
    }

    public final void a(fc fcVar) throws IOException {
        if (this.f10204a != 0) {
            if (fcVar.a() == bv.c.j) {
                for (int i2 = 0; i2 < this.f10204a; i2++) {
                    a(this.f10205b[i2], this.f10206c[i2], fcVar);
                }
                return;
            }
            for (int i3 = this.f10204a - 1; i3 >= 0; i3--) {
                a(this.f10205b[i3], this.f10206c[i3], fcVar);
            }
        }
    }

    private static void a(int i2, Object obj, fc fcVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            fcVar.a(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            fcVar.d(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            fcVar.a(i3, (at) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                fcVar.d(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(cd.zzbz());
        } else if (fcVar.a() == bv.c.j) {
            fcVar.a(i3);
            ((el) obj).a(fcVar);
            fcVar.b(i3);
        } else {
            fcVar.b(i3);
            ((el) obj).a(fcVar);
            fcVar.a(i3);
        }
    }

    public final int b() {
        int i2;
        int i3 = this.f10207d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f10204a; i5++) {
            int i6 = this.f10205b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = bf.e(i7, ((Long) this.f10206c[i5]).longValue());
            } else if (i8 == 1) {
                ((Long) this.f10206c[i5]).longValue();
                i2 = bf.g(i7);
            } else if (i8 == 2) {
                i2 = bf.c(i7, (at) this.f10206c[i5]);
            } else if (i8 == 3) {
                i2 = (bf.l(i7) << 1) + ((el) this.f10206c[i5]).b();
            } else if (i8 == 5) {
                ((Integer) this.f10206c[i5]).intValue();
                i2 = bf.e(i7);
            } else {
                throw new IllegalStateException(cd.zzbz());
            }
            i4 += i2;
        }
        this.f10207d = i4;
        return i4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof el)) {
            return false;
        }
        el elVar = (el) obj;
        int i2 = this.f10204a;
        if (i2 == elVar.f10204a) {
            int[] iArr = this.f10205b;
            int[] iArr2 = elVar.f10205b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                } else if (iArr[i3] != iArr2[i3]) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                Object[] objArr = this.f10206c;
                Object[] objArr2 = elVar.f10206c;
                int i4 = this.f10204a;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    } else if (!objArr[i5].equals(objArr2[i5])) {
                        z2 = false;
                        break;
                    } else {
                        i5++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i2 = this.f10204a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f10205b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f10206c;
        int i8 = this.f10204a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f10204a; i3++) {
            de.a(sb, i2, String.valueOf(this.f10205b[i3] >>> 3), this.f10206c[i3]);
        }
    }
}
