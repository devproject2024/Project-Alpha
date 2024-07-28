package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

public final class fy extends es<fy> implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private byte[] f9378c = fa.f9364e;

    /* renamed from: d  reason: collision with root package name */
    private String f9379d = "";

    /* renamed from: e  reason: collision with root package name */
    private byte[][] f9380e = fa.f9363d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9381f = false;

    public fy() {
        this.f9344a = null;
        this.f9357b = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final fy clone() {
        try {
            fy fyVar = (fy) super.clone();
            byte[][] bArr = this.f9380e;
            if (bArr != null && bArr.length > 0) {
                fyVar.f9380e = (byte[][]) bArr.clone();
            }
            return fyVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: protected */
    public final int a() {
        int a2 = super.a();
        if (!Arrays.equals(this.f9378c, fa.f9364e)) {
            a2 += eq.b(1, this.f9378c);
        }
        byte[][] bArr = this.f9380e;
        if (bArr != null && bArr.length > 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte[][] bArr2 = this.f9380e;
                if (i2 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i2];
                if (bArr3 != null) {
                    i4++;
                    i3 += eq.a(bArr3);
                }
                i2++;
            }
            a2 = a2 + i3 + (i4 * 1);
        }
        String str = this.f9379d;
        return (str == null || str.equals("")) ? a2 : a2 + eq.b(4, this.f9379d);
    }

    public final void a(eq eqVar) throws IOException {
        if (!Arrays.equals(this.f9378c, fa.f9364e)) {
            eqVar.a(1, this.f9378c);
        }
        byte[][] bArr = this.f9380e;
        if (bArr != null && bArr.length > 0) {
            int i2 = 0;
            while (true) {
                byte[][] bArr2 = this.f9380e;
                if (i2 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i2];
                if (bArr3 != null) {
                    eqVar.a(2, bArr3);
                }
                i2++;
            }
        }
        String str = this.f9379d;
        if (str != null && !str.equals("")) {
            eqVar.a(4, this.f9379d);
        }
        super.a(eqVar);
    }

    public final /* synthetic */ es b() throws CloneNotSupportedException {
        return (fy) clone();
    }

    public final /* synthetic */ ex c() throws CloneNotSupportedException {
        return (fy) clone();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fy)) {
            return false;
        }
        fy fyVar = (fy) obj;
        if (!Arrays.equals(this.f9378c, fyVar.f9378c)) {
            return false;
        }
        String str = this.f9379d;
        if (str == null) {
            if (fyVar.f9379d != null) {
                return false;
            }
        } else if (!str.equals(fyVar.f9379d)) {
            return false;
        }
        if (!ew.a(this.f9380e, fyVar.f9380e)) {
            return false;
        }
        return (this.f9344a == null || this.f9344a.a()) ? fyVar.f9344a == null || fyVar.f9344a.a() : this.f9344a.equals(fyVar.f9344a);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.f9378c)) * 31;
        String str = this.f9379d;
        int i2 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + ew.a(this.f9380e)) * 31) + 1237) * 31;
        if (this.f9344a != null && !this.f9344a.a()) {
            i2 = this.f9344a.hashCode();
        }
        return hashCode2 + i2;
    }
}
