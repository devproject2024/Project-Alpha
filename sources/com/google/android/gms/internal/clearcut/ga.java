package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.fd;
import java.io.IOException;
import java.util.Arrays;

public final class ga extends es<ga> implements Cloneable {
    private fd.s A = null;

    /* renamed from: c  reason: collision with root package name */
    public long f9384c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f9385d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f9386e = 0;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f9387f = fa.f9364e;

    /* renamed from: g  reason: collision with root package name */
    public long f9388g = 180000;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f9389h = fa.f9364e;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9390i = false;
    private long j = 0;
    private String k = "";
    private String l = "";
    private int m = 0;
    private boolean n = false;
    private gb[] o = gb.e();
    private byte[] p = fa.f9364e;
    private fd.d q = null;
    private String r = "";
    private String s = "";
    private fx t = null;
    private String u = "";
    private fy v = null;
    private String w = "";
    private int x = 0;
    private int[] y = fa.f9360a;
    private long z = 0;

    public ga() {
        this.f9344a = null;
        this.f9357b = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final ga clone() {
        try {
            ga gaVar = (ga) super.clone();
            gb[] gbVarArr = this.o;
            if (gbVarArr != null && gbVarArr.length > 0) {
                gaVar.o = new gb[gbVarArr.length];
                int i2 = 0;
                while (true) {
                    gb[] gbVarArr2 = this.o;
                    if (i2 >= gbVarArr2.length) {
                        break;
                    }
                    if (gbVarArr2[i2] != null) {
                        gaVar.o[i2] = (gb) gbVarArr2[i2].clone();
                    }
                    i2++;
                }
            }
            fd.d dVar = this.q;
            if (dVar != null) {
                gaVar.q = dVar;
            }
            fx fxVar = this.t;
            if (fxVar != null) {
                gaVar.t = (fx) fxVar.clone();
            }
            fy fyVar = this.v;
            if (fyVar != null) {
                gaVar.v = (fy) fyVar.clone();
            }
            int[] iArr = this.y;
            if (iArr != null && iArr.length > 0) {
                gaVar.y = (int[]) iArr.clone();
            }
            fd.s sVar = this.A;
            if (sVar != null) {
                gaVar.A = sVar;
            }
            return gaVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final /* synthetic */ es b() throws CloneNotSupportedException {
        return (ga) clone();
    }

    public final /* synthetic */ ex c() throws CloneNotSupportedException {
        return (ga) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ga)) {
            return false;
        }
        ga gaVar = (ga) obj;
        if (this.f9384c != gaVar.f9384c || this.f9385d != gaVar.f9385d) {
            return false;
        }
        String str = this.k;
        if (str == null) {
            if (gaVar.k != null) {
                return false;
            }
        } else if (!str.equals(gaVar.k)) {
            return false;
        }
        if (this.f9386e != gaVar.f9386e) {
            return false;
        }
        String str2 = this.l;
        if (str2 == null) {
            if (gaVar.l != null) {
                return false;
            }
        } else if (!str2.equals(gaVar.l)) {
            return false;
        }
        if (!ew.a((Object[]) this.o, (Object[]) gaVar.o) || !Arrays.equals(this.p, gaVar.p)) {
            return false;
        }
        fd.d dVar = this.q;
        if (dVar == null) {
            if (gaVar.q != null) {
                return false;
            }
        } else if (!dVar.equals(gaVar.q)) {
            return false;
        }
        if (!Arrays.equals(this.f9387f, gaVar.f9387f)) {
            return false;
        }
        String str3 = this.r;
        if (str3 == null) {
            if (gaVar.r != null) {
                return false;
            }
        } else if (!str3.equals(gaVar.r)) {
            return false;
        }
        String str4 = this.s;
        if (str4 == null) {
            if (gaVar.s != null) {
                return false;
            }
        } else if (!str4.equals(gaVar.s)) {
            return false;
        }
        fx fxVar = this.t;
        if (fxVar == null) {
            if (gaVar.t != null) {
                return false;
            }
        } else if (!fxVar.equals(gaVar.t)) {
            return false;
        }
        String str5 = this.u;
        if (str5 == null) {
            if (gaVar.u != null) {
                return false;
            }
        } else if (!str5.equals(gaVar.u)) {
            return false;
        }
        if (this.f9388g != gaVar.f9388g) {
            return false;
        }
        fy fyVar = this.v;
        if (fyVar == null) {
            if (gaVar.v != null) {
                return false;
            }
        } else if (!fyVar.equals(gaVar.v)) {
            return false;
        }
        if (!Arrays.equals(this.f9389h, gaVar.f9389h)) {
            return false;
        }
        String str6 = this.w;
        if (str6 == null) {
            if (gaVar.w != null) {
                return false;
            }
        } else if (!str6.equals(gaVar.w)) {
            return false;
        }
        if (!ew.a(this.y, gaVar.y)) {
            return false;
        }
        fd.s sVar = this.A;
        if (sVar == null) {
            if (gaVar.A != null) {
                return false;
            }
        } else if (!sVar.equals(gaVar.A)) {
            return false;
        }
        if (this.f9390i != gaVar.f9390i) {
            return false;
        }
        return (this.f9344a == null || this.f9344a.a()) ? gaVar.f9344a == null || gaVar.f9344a.a() : this.f9344a.equals(gaVar.f9344a);
    }

    public final int hashCode() {
        long j2 = this.f9384c;
        long j3 = this.f9385d;
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31 * 31;
        String str = this.k;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f9386e) * 31;
        String str2 = this.l;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        int i3 = 1237;
        int a2 = ((((((hashCode2 + hashCode3) * 31 * 31) + 1237) * 31) + ew.a((Object[]) this.o)) * 31) + Arrays.hashCode(this.p);
        fd.d dVar = this.q;
        int hashCode4 = ((((a2 * 31) + (dVar == null ? 0 : dVar.hashCode())) * 31) + Arrays.hashCode(this.f9387f)) * 31;
        String str3 = this.r;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.s;
        int hashCode6 = hashCode5 + (str4 == null ? 0 : str4.hashCode());
        fx fxVar = this.t;
        int hashCode7 = ((hashCode6 * 31) + (fxVar == null ? 0 : fxVar.hashCode())) * 31;
        String str5 = this.u;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        long j4 = this.f9388g;
        fy fyVar = this.v;
        int hashCode9 = (((((((hashCode7 + hashCode8) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (fyVar == null ? 0 : fyVar.hashCode())) * 31) + Arrays.hashCode(this.f9389h)) * 31;
        String str6 = this.w;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        fd.s sVar = this.A;
        int a3 = (((((hashCode9 + hashCode10) * 31 * 31) + ew.a(this.y)) * 31 * 31) + (sVar == null ? 0 : sVar.hashCode())) * 31;
        if (this.f9390i) {
            i3 = 1231;
        }
        int i4 = (a3 + i3) * 31;
        if (this.f9344a != null && !this.f9344a.a()) {
            i2 = this.f9344a.hashCode();
        }
        return i4 + i2;
    }

    public final void a(eq eqVar) throws IOException {
        long j2 = this.f9384c;
        if (j2 != 0) {
            eqVar.a(1, j2);
        }
        String str = this.k;
        if (str != null && !str.equals("")) {
            eqVar.a(2, this.k);
        }
        gb[] gbVarArr = this.o;
        if (gbVarArr != null && gbVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                gb[] gbVarArr2 = this.o;
                if (i2 >= gbVarArr2.length) {
                    break;
                }
                gb gbVar = gbVarArr2[i2];
                if (gbVar != null) {
                    eqVar.a(3, (ex) gbVar);
                }
                i2++;
            }
        }
        if (!Arrays.equals(this.p, fa.f9364e)) {
            eqVar.a(4, this.p);
        }
        if (!Arrays.equals(this.f9387f, fa.f9364e)) {
            eqVar.a(6, this.f9387f);
        }
        fx fxVar = this.t;
        if (fxVar != null) {
            eqVar.a(7, (ex) fxVar);
        }
        String str2 = this.r;
        if (str2 != null && !str2.equals("")) {
            eqVar.a(8, this.r);
        }
        fd.d dVar = this.q;
        if (dVar != null) {
            eqVar.a(9, (cm) dVar);
        }
        int i3 = this.f9386e;
        if (i3 != 0) {
            eqVar.a(11, i3);
        }
        String str3 = this.s;
        if (str3 != null && !str3.equals("")) {
            eqVar.a(13, this.s);
        }
        String str4 = this.u;
        if (str4 != null && !str4.equals("")) {
            eqVar.a(14, this.u);
        }
        long j3 = this.f9388g;
        if (j3 != 180000) {
            eqVar.b(15, 0);
            eqVar.a(eq.c(j3));
        }
        fy fyVar = this.v;
        if (fyVar != null) {
            eqVar.a(16, (ex) fyVar);
        }
        long j4 = this.f9385d;
        if (j4 != 0) {
            eqVar.a(17, j4);
        }
        if (!Arrays.equals(this.f9389h, fa.f9364e)) {
            eqVar.a(18, this.f9389h);
        }
        int[] iArr = this.y;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.y;
                if (i4 >= iArr2.length) {
                    break;
                }
                eqVar.a(20, iArr2[i4]);
                i4++;
            }
        }
        fd.s sVar = this.A;
        if (sVar != null) {
            eqVar.a(23, (cm) sVar);
        }
        String str5 = this.w;
        if (str5 != null && !str5.equals("")) {
            eqVar.a(24, this.w);
        }
        boolean z2 = this.f9390i;
        if (z2) {
            eqVar.b(25, 0);
            byte b2 = z2 ? (byte) 1 : 0;
            if (eqVar.f9341a.hasRemaining()) {
                eqVar.f9341a.put(b2);
            } else {
                throw new er(eqVar.f9341a.position(), eqVar.f9341a.limit());
            }
        }
        String str6 = this.l;
        if (str6 != null && !str6.equals("")) {
            eqVar.a(26, this.l);
        }
        super.a(eqVar);
    }

    /* access modifiers changed from: protected */
    public final int a() {
        int[] iArr;
        int a2 = super.a();
        long j2 = this.f9384c;
        if (j2 != 0) {
            a2 += eq.b(1, j2);
        }
        String str = this.k;
        if (str != null && !str.equals("")) {
            a2 += eq.b(2, this.k);
        }
        gb[] gbVarArr = this.o;
        int i2 = 0;
        if (gbVarArr != null && gbVarArr.length > 0) {
            int i3 = a2;
            int i4 = 0;
            while (true) {
                gb[] gbVarArr2 = this.o;
                if (i4 >= gbVarArr2.length) {
                    break;
                }
                gb gbVar = gbVarArr2[i4];
                if (gbVar != null) {
                    i3 += eq.b(3, (ex) gbVar);
                }
                i4++;
            }
            a2 = i3;
        }
        if (!Arrays.equals(this.p, fa.f9364e)) {
            a2 += eq.b(4, this.p);
        }
        if (!Arrays.equals(this.f9387f, fa.f9364e)) {
            a2 += eq.b(6, this.f9387f);
        }
        fx fxVar = this.t;
        if (fxVar != null) {
            a2 += eq.b(7, (ex) fxVar);
        }
        String str2 = this.r;
        if (str2 != null && !str2.equals("")) {
            a2 += eq.b(8, this.r);
        }
        fd.d dVar = this.q;
        if (dVar != null) {
            a2 += am.c(9, (cm) dVar);
        }
        int i5 = this.f9386e;
        if (i5 != 0) {
            a2 += eq.b(88) + eq.a(i5);
        }
        String str3 = this.s;
        if (str3 != null && !str3.equals("")) {
            a2 += eq.b(13, this.s);
        }
        String str4 = this.u;
        if (str4 != null && !str4.equals("")) {
            a2 += eq.b(14, this.u);
        }
        long j3 = this.f9388g;
        if (j3 != 180000) {
            a2 += eq.b(120) + eq.b(eq.c(j3));
        }
        fy fyVar = this.v;
        if (fyVar != null) {
            a2 += eq.b(16, (ex) fyVar);
        }
        long j4 = this.f9385d;
        if (j4 != 0) {
            a2 += eq.b(17, j4);
        }
        if (!Arrays.equals(this.f9389h, fa.f9364e)) {
            a2 += eq.b(18, this.f9389h);
        }
        int[] iArr2 = this.y;
        if (iArr2 != null && iArr2.length > 0) {
            int i6 = 0;
            while (true) {
                iArr = this.y;
                if (i2 >= iArr.length) {
                    break;
                }
                i6 += eq.a(iArr[i2]);
                i2++;
            }
            a2 = a2 + i6 + (iArr.length * 2);
        }
        fd.s sVar = this.A;
        if (sVar != null) {
            a2 += am.c(23, (cm) sVar);
        }
        String str5 = this.w;
        if (str5 != null && !str5.equals("")) {
            a2 += eq.b(24, this.w);
        }
        if (this.f9390i) {
            a2 += eq.b(200) + 1;
        }
        String str6 = this.l;
        return (str6 == null || str6.equals("")) ? a2 : a2 + eq.b(26, this.l);
    }
}
