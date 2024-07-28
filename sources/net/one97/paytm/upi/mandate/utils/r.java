package net.one97.paytm.upi.mandate.utils;

import kotlin.g.b.k;

public final class r<T> {

    /* renamed from: a  reason: collision with root package name */
    public final u f67411a;

    /* renamed from: b  reason: collision with root package name */
    public final T f67412b;

    /* renamed from: c  reason: collision with root package name */
    public final t f67413c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67414d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return k.a((Object) this.f67411a, (Object) rVar.f67411a) && k.a((Object) this.f67412b, (Object) rVar.f67412b) && k.a((Object) this.f67413c, (Object) rVar.f67413c) && this.f67414d == rVar.f67414d;
    }

    public final int hashCode() {
        u uVar = this.f67411a;
        int i2 = 0;
        int hashCode = (uVar != null ? uVar.hashCode() : 0) * 31;
        T t = this.f67412b;
        int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
        t tVar = this.f67413c;
        if (tVar != null) {
            i2 = tVar.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f67414d;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "PresentationModel(status=" + this.f67411a + ", data=" + this.f67412b + ", error=" + this.f67413c + ", isPaginatedLoading=" + this.f67414d + ")";
    }

    private r(u uVar, T t, t tVar, boolean z) {
        k.c(uVar, "status");
        this.f67411a = uVar;
        this.f67412b = t;
        this.f67413c = tVar;
        this.f67414d = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(u uVar, Object obj, t tVar, boolean z, int i2) {
        this(uVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : tVar, (i2 & 8) != 0 ? false : z);
    }
}
