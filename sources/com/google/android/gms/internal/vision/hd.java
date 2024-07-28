package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;
import java.io.IOException;
import java.util.Arrays;

public final class hd {

    /* renamed from: f  reason: collision with root package name */
    private static final hd f11205f = new hd(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    int f11206a;

    /* renamed from: b  reason: collision with root package name */
    int[] f11207b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f11208c;

    /* renamed from: d  reason: collision with root package name */
    int f11209d;

    /* renamed from: e  reason: collision with root package name */
    boolean f11210e;

    public static hd a() {
        return f11205f;
    }

    static hd b() {
        return new hd();
    }

    static hd a(hd hdVar, hd hdVar2) {
        int i2 = hdVar.f11206a + hdVar2.f11206a;
        int[] copyOf = Arrays.copyOf(hdVar.f11207b, i2);
        System.arraycopy(hdVar2.f11207b, 0, copyOf, hdVar.f11206a, hdVar2.f11206a);
        Object[] copyOf2 = Arrays.copyOf(hdVar.f11208c, i2);
        System.arraycopy(hdVar2.f11208c, 0, copyOf2, hdVar.f11206a, hdVar2.f11206a);
        return new hd(i2, copyOf, copyOf2, true);
    }

    private hd() {
        this(0, new int[8], new Object[8], true);
    }

    private hd(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f11209d = -1;
        this.f11206a = i2;
        this.f11207b = iArr;
        this.f11208c = objArr;
        this.f11210e = z;
    }

    public final void a(hx hxVar) throws IOException {
        if (this.f11206a != 0) {
            if (hxVar.a() == ej.e.j) {
                for (int i2 = 0; i2 < this.f11206a; i2++) {
                    a(this.f11207b[i2], this.f11208c[i2], hxVar);
                }
                return;
            }
            for (int i3 = this.f11206a - 1; i3 >= 0; i3--) {
                a(this.f11207b[i3], this.f11208c[i3], hxVar);
            }
        }
    }

    private static void a(int i2, Object obj, hx hxVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            hxVar.a(i3, ((Long) obj).longValue());
        } else if (i4 == 1) {
            hxVar.d(i3, ((Long) obj).longValue());
        } else if (i4 == 2) {
            hxVar.a(i3, (cz) obj);
        } else if (i4 != 3) {
            if (i4 == 5) {
                hxVar.d(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(eu.zzgr());
        } else if (hxVar.a() == ej.e.j) {
            hxVar.a(i3);
            ((hd) obj).a(hxVar);
            hxVar.b(i3);
        } else {
            hxVar.b(i3);
            ((hd) obj).a(hxVar);
            hxVar.a(i3);
        }
    }

    public final int c() {
        int i2;
        int i3 = this.f11209d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f11206a; i5++) {
            int i6 = this.f11207b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 == 0) {
                i2 = dr.e(i7, ((Long) this.f11208c[i5]).longValue());
            } else if (i8 == 1) {
                ((Long) this.f11208c[i5]).longValue();
                i2 = dr.g(i7);
            } else if (i8 == 2) {
                i2 = dr.c(i7, (cz) this.f11208c[i5]);
            } else if (i8 == 3) {
                i2 = (dr.l(i7) << 1) + ((hd) this.f11208c[i5]).c();
            } else if (i8 == 5) {
                ((Integer) this.f11208c[i5]).intValue();
                i2 = dr.e(i7);
            } else {
                throw new IllegalStateException(eu.zzgr());
            }
            i4 += i2;
        }
        this.f11209d = i4;
        return i4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof hd)) {
            return false;
        }
        hd hdVar = (hd) obj;
        int i2 = this.f11206a;
        if (i2 == hdVar.f11206a) {
            int[] iArr = this.f11207b;
            int[] iArr2 = hdVar.f11207b;
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
                Object[] objArr = this.f11208c;
                Object[] objArr2 = hdVar.f11208c;
                int i4 = this.f11206a;
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
        int i2 = this.f11206a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f11207b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f11208c;
        int i8 = this.f11206a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f11206a; i3++) {
            fu.a(sb, i2, String.valueOf(this.f11207b[i3] >>> 3), this.f11208c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Object obj) {
        if (this.f11210e) {
            int i3 = this.f11206a;
            if (i3 == this.f11207b.length) {
                int i4 = this.f11206a + (i3 < 4 ? 8 : i3 >> 1);
                this.f11207b = Arrays.copyOf(this.f11207b, i4);
                this.f11208c = Arrays.copyOf(this.f11208c, i4);
            }
            int[] iArr = this.f11207b;
            int i5 = this.f11206a;
            iArr[i5] = i2;
            this.f11208c[i5] = obj;
            this.f11206a = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
