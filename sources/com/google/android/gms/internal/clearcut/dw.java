package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.bf;
import java.io.IOException;
import java.util.Arrays;

public final class dw {

    /* renamed from: f  reason: collision with root package name */
    private static final dw f9308f = new dw(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    int f9309a;

    /* renamed from: b  reason: collision with root package name */
    int[] f9310b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f9311c;

    /* renamed from: d  reason: collision with root package name */
    int f9312d;

    /* renamed from: e  reason: collision with root package name */
    boolean f9313e;

    private dw() {
        this(0, new int[8], new Object[8], true);
    }

    private dw(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f9312d = -1;
        this.f9309a = i2;
        this.f9310b = iArr;
        this.f9311c = objArr;
        this.f9313e = z;
    }

    public static dw a() {
        return f9308f;
    }

    static dw a(dw dwVar, dw dwVar2) {
        int i2 = dwVar.f9309a + dwVar2.f9309a;
        int[] copyOf = Arrays.copyOf(dwVar.f9310b, i2);
        System.arraycopy(dwVar2.f9310b, 0, copyOf, dwVar.f9309a, dwVar2.f9309a);
        Object[] copyOf2 = Arrays.copyOf(dwVar.f9311c, i2);
        System.arraycopy(dwVar2.f9311c, 0, copyOf2, dwVar.f9309a, dwVar2.f9309a);
        return new dw(i2, copyOf, copyOf2, true);
    }

    private static void a(int i2, Object obj, ep epVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            epVar.a(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            epVar.d(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            epVar.a(i3, (ab) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                epVar.d(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(bn.zzbn());
        } else if (epVar.a() == bf.g.j) {
            epVar.a(i3);
            ((dw) obj).a(epVar);
            epVar.b(i3);
        } else {
            epVar.b(i3);
            ((dw) obj).a(epVar);
            epVar.a(i3);
        }
    }

    static dw b() {
        return new dw();
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Object obj) {
        if (this.f9313e) {
            int i3 = this.f9309a;
            if (i3 == this.f9310b.length) {
                int i4 = this.f9309a + (i3 < 4 ? 8 : i3 >> 1);
                this.f9310b = Arrays.copyOf(this.f9310b, i4);
                this.f9311c = Arrays.copyOf(this.f9311c, i4);
            }
            int[] iArr = this.f9310b;
            int i5 = this.f9309a;
            iArr[i5] = i2;
            this.f9311c[i5] = obj;
            this.f9309a = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void a(ep epVar) throws IOException {
        if (this.f9309a != 0) {
            if (epVar.a() == bf.g.j) {
                for (int i2 = 0; i2 < this.f9309a; i2++) {
                    a(this.f9310b[i2], this.f9311c[i2], epVar);
                }
                return;
            }
            for (int i3 = this.f9309a - 1; i3 >= 0; i3--) {
                a(this.f9310b[i3], this.f9311c[i3], epVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f9309a; i3++) {
            cp.a(sb, i2, String.valueOf(this.f9310b[i3] >>> 3), this.f9311c[i3]);
        }
    }

    public final int c() {
        int i2;
        int i3 = this.f9312d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f9309a; i5++) {
            int i6 = this.f9310b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = am.e(i7, ((Long) this.f9311c[i5]).longValue());
            } else if (i8 == 1) {
                ((Long) this.f9311c[i5]).longValue();
                i2 = am.g(i7);
            } else if (i8 == 2) {
                i2 = am.c(i7, (ab) this.f9311c[i5]);
            } else if (i8 == 3) {
                i2 = (am.l(i7) << 1) + ((dw) this.f9311c[i5]).c();
            } else if (i8 == 5) {
                ((Integer) this.f9311c[i5]).intValue();
                i2 = am.e(i7);
            } else {
                throw new IllegalStateException(bn.zzbn());
            }
            i4 += i2;
        }
        this.f9312d = i4;
        return i4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof dw)) {
            return false;
        }
        dw dwVar = (dw) obj;
        int i2 = this.f9309a;
        if (i2 == dwVar.f9309a) {
            int[] iArr = this.f9310b;
            int[] iArr2 = dwVar.f9310b;
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
                Object[] objArr = this.f9311c;
                Object[] objArr2 = dwVar.f9311c;
                int i4 = this.f9309a;
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
        int i2 = this.f9309a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f9310b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f9311c;
        int i8 = this.f9309a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }
}
