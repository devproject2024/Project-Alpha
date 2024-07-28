package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-perf.gf  reason: invalid package */
public final class gf {

    /* renamed from: f  reason: collision with root package name */
    private static final gf f9663f = new gf(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    int f9664a;

    /* renamed from: b  reason: collision with root package name */
    int[] f9665b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f9666c;

    /* renamed from: d  reason: collision with root package name */
    int f9667d;

    /* renamed from: e  reason: collision with root package name */
    boolean f9668e;

    public static gf a() {
        return f9663f;
    }

    static gf a(gf gfVar, gf gfVar2) {
        int i2 = gfVar.f9664a + gfVar2.f9664a;
        int[] copyOf = Arrays.copyOf(gfVar.f9665b, i2);
        System.arraycopy(gfVar2.f9665b, 0, copyOf, gfVar.f9664a, gfVar2.f9664a);
        Object[] copyOf2 = Arrays.copyOf(gfVar.f9666c, i2);
        System.arraycopy(gfVar2.f9666c, 0, copyOf2, gfVar.f9664a, gfVar2.f9664a);
        return new gf(i2, copyOf, copyOf2, true);
    }

    private gf() {
        this(0, new int[8], new Object[8], true);
    }

    private gf(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f9667d = -1;
        this.f9664a = i2;
        this.f9665b = iArr;
        this.f9666c = objArr;
        this.f9668e = z;
    }

    public final void a(ha haVar) throws IOException {
        if (this.f9664a != 0) {
            if (haVar.a() == dq.d.j) {
                for (int i2 = 0; i2 < this.f9664a; i2++) {
                    a(this.f9665b[i2], this.f9666c[i2], haVar);
                }
                return;
            }
            for (int i3 = this.f9664a - 1; i3 >= 0; i3--) {
                a(this.f9665b[i3], this.f9666c[i3], haVar);
            }
        }
    }

    private static void a(int i2, Object obj, ha haVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            haVar.a(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            haVar.d(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            haVar.a(i3, (co) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                haVar.d(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(dy.zzhy());
        } else if (haVar.a() == dq.d.j) {
            haVar.a(i3);
            ((gf) obj).a(haVar);
            haVar.b(i3);
        } else {
            haVar.b(i3);
            ((gf) obj).a(haVar);
            haVar.a(i3);
        }
    }

    public final int b() {
        int i2;
        int i3 = this.f9667d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f9664a; i5++) {
            int i6 = this.f9665b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = da.e(i7, ((Long) this.f9666c[i5]).longValue());
            } else if (i8 == 1) {
                ((Long) this.f9666c[i5]).longValue();
                i2 = da.g(i7);
            } else if (i8 == 2) {
                i2 = da.c(i7, (co) this.f9666c[i5]);
            } else if (i8 == 3) {
                i2 = (da.l(i7) << 1) + ((gf) this.f9666c[i5]).b();
            } else if (i8 == 5) {
                ((Integer) this.f9666c[i5]).intValue();
                i2 = da.e(i7);
            } else {
                throw new IllegalStateException(dy.zzhy());
            }
            i4 += i2;
        }
        this.f9667d = i4;
        return i4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof gf)) {
            return false;
        }
        gf gfVar = (gf) obj;
        int i2 = this.f9664a;
        if (i2 == gfVar.f9664a) {
            int[] iArr = this.f9665b;
            int[] iArr2 = gfVar.f9665b;
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
                Object[] objArr = this.f9666c;
                Object[] objArr2 = gfVar.f9666c;
                int i4 = this.f9664a;
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
        int i2 = this.f9664a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f9665b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f9666c;
        int i8 = this.f9664a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f9664a; i3++) {
            fd.a(sb, i2, String.valueOf(this.f9665b[i3] >>> 3), this.f9666c[i3]);
        }
    }
}
