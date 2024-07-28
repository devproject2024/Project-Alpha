package com.google.c;

import com.google.c.ca;
import java.io.IOException;
import java.util.Arrays;

public final class bu {

    /* renamed from: f  reason: collision with root package name */
    private static final bu f37804f = new bu(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    int f37805a;

    /* renamed from: b  reason: collision with root package name */
    int[] f37806b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f37807c;

    /* renamed from: d  reason: collision with root package name */
    int f37808d;

    /* renamed from: e  reason: collision with root package name */
    boolean f37809e;

    public static bu a() {
        return f37804f;
    }

    static bu b() {
        return new bu();
    }

    static bu a(bu buVar, bu buVar2) {
        int i2 = buVar.f37805a + buVar2.f37805a;
        int[] copyOf = Arrays.copyOf(buVar.f37806b, i2);
        System.arraycopy(buVar2.f37806b, 0, copyOf, buVar.f37805a, buVar2.f37805a);
        Object[] copyOf2 = Arrays.copyOf(buVar.f37807c, i2);
        System.arraycopy(buVar2.f37807c, 0, copyOf2, buVar.f37805a, buVar2.f37805a);
        return new bu(i2, copyOf, copyOf2, true);
    }

    private bu() {
        this(0, new int[8], new Object[8], true);
    }

    private bu(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f37808d = -1;
        this.f37805a = i2;
        this.f37806b = iArr;
        this.f37807c = objArr;
        this.f37809e = z;
    }

    private void d() {
        if (!this.f37809e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void a(ca caVar) throws IOException {
        if (this.f37805a != 0) {
            if (caVar.a() == ca.a.ASCENDING) {
                for (int i2 = 0; i2 < this.f37805a; i2++) {
                    a(this.f37806b[i2], this.f37807c[i2], caVar);
                }
                return;
            }
            for (int i3 = this.f37805a - 1; i3 >= 0; i3--) {
                a(this.f37806b[i3], this.f37807c[i3], caVar);
            }
        }
    }

    private static void a(int i2, Object obj, ca caVar) throws IOException {
        int b2 = bz.b(i2);
        int a2 = bz.a(i2);
        if (a2 == 0) {
            caVar.a(b2, ((Long) obj).longValue());
        } else if (a2 == 1) {
            caVar.d(b2, ((Long) obj).longValue());
        } else if (a2 == 2) {
            caVar.a(b2, (j) obj);
        } else if (a2 != 3) {
            if (a2 == 5) {
                caVar.d(b2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(ad.invalidWireType());
        } else if (caVar.a() == ca.a.ASCENDING) {
            caVar.a(b2);
            ((bu) obj).a(caVar);
            caVar.b(b2);
        } else {
            caVar.b(b2);
            ((bu) obj).a(caVar);
            caVar.a(b2);
        }
    }

    public final int c() {
        int i2;
        int i3 = this.f37808d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f37805a; i5++) {
            int i6 = this.f37806b[i5];
            int b2 = bz.b(i6);
            int a2 = bz.a(i6);
            if (a2 == 0) {
                i2 = m.e(b2, ((Long) this.f37807c[i5]).longValue());
            } else if (a2 == 1) {
                ((Long) this.f37807c[i5]).longValue();
                i2 = m.g(b2);
            } else if (a2 == 2) {
                i2 = m.c(b2, (j) this.f37807c[i5]);
            } else if (a2 == 3) {
                i2 = (m.l(b2) * 2) + ((bu) this.f37807c[i5]).c();
            } else if (a2 == 5) {
                ((Integer) this.f37807c[i5]).intValue();
                i2 = m.e(b2);
            } else {
                throw new IllegalStateException(ad.invalidWireType());
            }
            i4 += i2;
        }
        this.f37808d = i4;
        return i4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bu)) {
            return false;
        }
        bu buVar = (bu) obj;
        int i2 = this.f37805a;
        if (i2 == buVar.f37805a) {
            int[] iArr = this.f37806b;
            int[] iArr2 = buVar.f37806b;
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
                Object[] objArr = this.f37807c;
                Object[] objArr2 = buVar.f37807c;
                int i4 = this.f37805a;
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
        int i2 = this.f37805a;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f37806b;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f37807c;
        int i8 = this.f37805a;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f37805a; i3++) {
            av.a(sb, i2, String.valueOf(bz.b(this.f37806b[i3])), this.f37807c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, Object obj) {
        d();
        e();
        int[] iArr = this.f37806b;
        int i3 = this.f37805a;
        iArr[i3] = i2;
        this.f37807c[i3] = obj;
        this.f37805a = i3 + 1;
    }

    private void e() {
        int i2 = this.f37805a;
        if (i2 == this.f37806b.length) {
            int i3 = this.f37805a + (i2 < 4 ? 8 : i2 >> 1);
            this.f37806b = Arrays.copyOf(this.f37806b, i3);
            this.f37807c = Arrays.copyOf(this.f37807c, i3);
        }
    }
}
