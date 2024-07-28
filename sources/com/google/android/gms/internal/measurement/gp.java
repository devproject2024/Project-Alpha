package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;
import java.io.IOException;
import java.util.Arrays;

public final class gp {

    /* renamed from: f  reason: collision with root package name */
    private static final gp f10699f = new gp(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    int f10700a;

    /* renamed from: b  reason: collision with root package name */
    int[] f10701b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f10702c;

    /* renamed from: d  reason: collision with root package name */
    int f10703d;

    /* renamed from: e  reason: collision with root package name */
    boolean f10704e;

    public static gp a() {
        return f10699f;
    }

    static gp b() {
        return new gp();
    }

    static gp a(gp gpVar, gp gpVar2) {
        int i2 = gpVar.f10700a + gpVar2.f10700a;
        int[] copyOf = Arrays.copyOf(gpVar.f10701b, i2);
        System.arraycopy(gpVar2.f10701b, 0, copyOf, gpVar.f10700a, gpVar2.f10700a);
        Object[] copyOf2 = Arrays.copyOf(gpVar.f10702c, i2);
        System.arraycopy(gpVar2.f10702c, 0, copyOf2, gpVar.f10700a, gpVar2.f10700a);
        return new gp(i2, copyOf, copyOf2, true);
    }

    private gp() {
        this(0, new int[8], new Object[8], true);
    }

    private gp(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f10703d = -1;
        this.f10700a = i2;
        this.f10701b = iArr;
        this.f10702c = objArr;
        this.f10704e = z;
    }

    public final void a(hk hkVar) throws IOException {
        if (this.f10700a != 0) {
            if (hkVar.a() == dv.d.j) {
                for (int i2 = 0; i2 < this.f10700a; i2++) {
                    a(this.f10701b[i2], this.f10702c[i2], hkVar);
                }
                return;
            }
            for (int i3 = this.f10700a - 1; i3 >= 0; i3--) {
                a(this.f10701b[i3], this.f10702c[i3], hkVar);
            }
        }
    }

    private static void a(int i2, Object obj, hk hkVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            hkVar.a(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            hkVar.d(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            hkVar.a(i3, (cm) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                hkVar.d(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(eg.zzf());
        } else if (hkVar.a() == dv.d.j) {
            hkVar.a(i3);
            ((gp) obj).a(hkVar);
            hkVar.b(i3);
        } else {
            hkVar.b(i3);
            ((gp) obj).a(hkVar);
            hkVar.a(i3);
        }
    }

    public final int c() {
        int i2;
        int i3 = this.f10703d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f10700a; i5++) {
            int i6 = this.f10701b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = de.e(i7, ((Long) this.f10702c[i5]).longValue());
            } else if (i8 == 1) {
                ((Long) this.f10702c[i5]).longValue();
                i2 = de.g(i7);
            } else if (i8 == 2) {
                i2 = de.c(i7, (cm) this.f10702c[i5]);
            } else if (i8 == 3) {
                i2 = (de.l(i7) << 1) + ((gp) this.f10702c[i5]).c();
            } else if (i8 == 5) {
                ((Integer) this.f10702c[i5]).intValue();
                i2 = de.e(i7);
            } else {
                throw new IllegalStateException(eg.zzf());
            }
            i4 += i2;
        }
        this.f10703d = i4;
        return i4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof gp)) {
            return false;
        }
        gp gpVar = (gp) obj;
        int i2 = this.f10700a;
        if (i2 == gpVar.f10700a) {
            int[] iArr = this.f10701b;
            int[] iArr2 = gpVar.f10701b;
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
                Object[] objArr = this.f10702c;
                Object[] objArr2 = gpVar.f10702c;
                int i4 = this.f10700a;
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
        int i2 = this.f10700a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f10701b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f10702c;
        int i8 = this.f10700a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f10700a; i3++) {
            fg.a(sb, i2, String.valueOf(this.f10701b[i3] >>> 3), this.f10702c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Object obj) {
        if (this.f10704e) {
            int i3 = this.f10700a;
            if (i3 == this.f10701b.length) {
                int i4 = this.f10700a + (i3 < 4 ? 8 : i3 >> 1);
                this.f10701b = Arrays.copyOf(this.f10701b, i4);
                this.f10702c = Arrays.copyOf(this.f10702c, i4);
            }
            int[] iArr = this.f10701b;
            int i5 = this.f10700a;
            iArr[i5] = i2;
            this.f10702c[i5] = obj;
            this.f10700a = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
