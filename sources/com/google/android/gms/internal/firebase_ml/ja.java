package com.google.android.gms.internal.firebase_ml;

import com.google.android.gms.internal.firebase_ml.gg;
import java.io.IOException;
import java.util.Arrays;

public final class ja {

    /* renamed from: f  reason: collision with root package name */
    private static final ja f10020f = new ja(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    int f10021a;

    /* renamed from: b  reason: collision with root package name */
    int[] f10022b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f10023c;

    /* renamed from: d  reason: collision with root package name */
    int f10024d;

    /* renamed from: e  reason: collision with root package name */
    boolean f10025e;

    public static ja a() {
        return f10020f;
    }

    static ja a(ja jaVar, ja jaVar2) {
        int i2 = jaVar.f10021a + jaVar2.f10021a;
        int[] copyOf = Arrays.copyOf(jaVar.f10022b, i2);
        System.arraycopy(jaVar2.f10022b, 0, copyOf, jaVar.f10021a, jaVar2.f10021a);
        Object[] copyOf2 = Arrays.copyOf(jaVar.f10023c, i2);
        System.arraycopy(jaVar2.f10023c, 0, copyOf2, jaVar.f10021a, jaVar2.f10021a);
        return new ja(i2, copyOf, copyOf2, true);
    }

    private ja() {
        this(0, new int[8], new Object[8], true);
    }

    private ja(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f10024d = -1;
        this.f10021a = i2;
        this.f10022b = iArr;
        this.f10023c = objArr;
        this.f10025e = z;
    }

    public final void a(s sVar) throws IOException {
        if (this.f10021a != 0) {
            if (sVar.a() == gg.e.j) {
                for (int i2 = 0; i2 < this.f10021a; i2++) {
                    a(this.f10022b[i2], this.f10023c[i2], sVar);
                }
                return;
            }
            for (int i3 = this.f10021a - 1; i3 >= 0; i3--) {
                a(this.f10022b[i3], this.f10023c[i3], sVar);
            }
        }
    }

    private static void a(int i2, Object obj, s sVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            sVar.a(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            sVar.d(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            sVar.a(i3, (fh) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                sVar.d(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(gp.zzvh());
        } else if (sVar.a() == gg.e.j) {
            sVar.a(i3);
            ((ja) obj).a(sVar);
            sVar.b(i3);
        } else {
            sVar.b(i3);
            ((ja) obj).a(sVar);
            sVar.a(i3);
        }
    }

    public final int b() {
        int i2;
        int i3 = this.f10024d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f10021a; i5++) {
            int i6 = this.f10022b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = ft.e(i7, ((Long) this.f10023c[i5]).longValue());
            } else if (i8 == 1) {
                ((Long) this.f10023c[i5]).longValue();
                i2 = ft.g(i7);
            } else if (i8 == 2) {
                i2 = ft.c(i7, (fh) this.f10023c[i5]);
            } else if (i8 == 3) {
                i2 = (ft.l(i7) << 1) + ((ja) this.f10023c[i5]).b();
            } else if (i8 == 5) {
                ((Integer) this.f10023c[i5]).intValue();
                i2 = ft.e(i7);
            } else {
                throw new IllegalStateException(gp.zzvh());
            }
            i4 += i2;
        }
        this.f10024d = i4;
        return i4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ja)) {
            return false;
        }
        ja jaVar = (ja) obj;
        int i2 = this.f10021a;
        if (i2 == jaVar.f10021a) {
            int[] iArr = this.f10022b;
            int[] iArr2 = jaVar.f10022b;
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
                Object[] objArr = this.f10023c;
                Object[] objArr2 = jaVar.f10023c;
                int i4 = this.f10021a;
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
        int i2 = this.f10021a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f10022b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f10023c;
        int i8 = this.f10021a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f10021a; i3++) {
            hs.a(sb, i2, String.valueOf(this.f10022b[i3] >>> 3), this.f10023c[i3]);
        }
    }
}
