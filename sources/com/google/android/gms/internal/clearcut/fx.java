package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class fx extends es<fx> implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private String[] f9373c = fa.f9362c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f9374d = fa.f9362c;

    /* renamed from: e  reason: collision with root package name */
    private int[] f9375e = fa.f9360a;

    /* renamed from: f  reason: collision with root package name */
    private long[] f9376f = fa.f9361b;

    /* renamed from: g  reason: collision with root package name */
    private long[] f9377g = fa.f9361b;

    public fx() {
        this.f9344a = null;
        this.f9357b = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final fx clone() {
        try {
            fx fxVar = (fx) super.clone();
            String[] strArr = this.f9373c;
            if (strArr != null && strArr.length > 0) {
                fxVar.f9373c = (String[]) strArr.clone();
            }
            String[] strArr2 = this.f9374d;
            if (strArr2 != null && strArr2.length > 0) {
                fxVar.f9374d = (String[]) strArr2.clone();
            }
            int[] iArr = this.f9375e;
            if (iArr != null && iArr.length > 0) {
                fxVar.f9375e = (int[]) iArr.clone();
            }
            long[] jArr = this.f9376f;
            if (jArr != null && jArr.length > 0) {
                fxVar.f9376f = (long[]) jArr.clone();
            }
            long[] jArr2 = this.f9377g;
            if (jArr2 != null && jArr2.length > 0) {
                fxVar.f9377g = (long[]) jArr2.clone();
            }
            return fxVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: protected */
    public final int a() {
        long[] jArr;
        int[] iArr;
        int a2 = super.a();
        String[] strArr = this.f9373c;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.f9373c;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i5++;
                    i4 += eq.a(str);
                }
                i3++;
            }
            a2 = a2 + i4 + (i5 * 1);
        }
        String[] strArr3 = this.f9374d;
        if (strArr3 != null && strArr3.length > 0) {
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr4 = this.f9374d;
                if (i6 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i6];
                if (str2 != null) {
                    i8++;
                    i7 += eq.a(str2);
                }
                i6++;
            }
            a2 = a2 + i7 + (i8 * 1);
        }
        int[] iArr2 = this.f9375e;
        if (iArr2 != null && iArr2.length > 0) {
            int i9 = 0;
            int i10 = 0;
            while (true) {
                iArr = this.f9375e;
                if (i9 >= iArr.length) {
                    break;
                }
                i10 += eq.a(iArr[i9]);
                i9++;
            }
            a2 = a2 + i10 + (iArr.length * 1);
        }
        long[] jArr2 = this.f9376f;
        if (jArr2 != null && jArr2.length > 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                jArr = this.f9376f;
                if (i11 >= jArr.length) {
                    break;
                }
                i12 += eq.b(jArr[i11]);
                i11++;
            }
            a2 = a2 + i12 + (jArr.length * 1);
        }
        long[] jArr3 = this.f9377g;
        if (jArr3 == null || jArr3.length <= 0) {
            return a2;
        }
        int i13 = 0;
        while (true) {
            long[] jArr4 = this.f9377g;
            if (i2 >= jArr4.length) {
                return a2 + i13 + (jArr4.length * 1);
            }
            i13 += eq.b(jArr4[i2]);
            i2++;
        }
    }

    public final void a(eq eqVar) throws IOException {
        String[] strArr = this.f9373c;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f9373c;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    eqVar.a(1, str);
                }
                i3++;
            }
        }
        String[] strArr3 = this.f9374d;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.f9374d;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    eqVar.a(2, str2);
                }
                i4++;
            }
        }
        int[] iArr = this.f9375e;
        if (iArr != null && iArr.length > 0) {
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.f9375e;
                if (i5 >= iArr2.length) {
                    break;
                }
                eqVar.a(3, iArr2[i5]);
                i5++;
            }
        }
        long[] jArr = this.f9376f;
        if (jArr != null && jArr.length > 0) {
            int i6 = 0;
            while (true) {
                long[] jArr2 = this.f9376f;
                if (i6 >= jArr2.length) {
                    break;
                }
                eqVar.a(4, jArr2[i6]);
                i6++;
            }
        }
        long[] jArr3 = this.f9377g;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.f9377g;
                if (i2 >= jArr4.length) {
                    break;
                }
                eqVar.a(5, jArr4[i2]);
                i2++;
            }
        }
        super.a(eqVar);
    }

    public final /* synthetic */ es b() throws CloneNotSupportedException {
        return (fx) clone();
    }

    public final /* synthetic */ ex c() throws CloneNotSupportedException {
        return (fx) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fx)) {
            return false;
        }
        fx fxVar = (fx) obj;
        if (ew.a((Object[]) this.f9373c, (Object[]) fxVar.f9373c) && ew.a((Object[]) this.f9374d, (Object[]) fxVar.f9374d) && ew.a(this.f9375e, fxVar.f9375e) && ew.a(this.f9376f, fxVar.f9376f) && ew.a(this.f9377g, fxVar.f9377g)) {
            return (this.f9344a == null || this.f9344a.a()) ? fxVar.f9344a == null || fxVar.f9344a.a() : this.f9344a.equals(fxVar.f9344a);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((getClass().getName().hashCode() + 527) * 31) + ew.a((Object[]) this.f9373c)) * 31) + ew.a((Object[]) this.f9374d)) * 31) + ew.a(this.f9375e)) * 31) + ew.a(this.f9376f)) * 31) + ew.a(this.f9377g)) * 31) + ((this.f9344a == null || this.f9344a.a()) ? 0 : this.f9344a.hashCode());
    }
}
