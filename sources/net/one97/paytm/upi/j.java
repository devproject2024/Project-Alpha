package net.one97.paytm.upi;

import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiCustomVolleyError;

public final class j<ResultType> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f67003d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public l f67004a;

    /* renamed from: b  reason: collision with root package name */
    public ResultType f67005b;

    /* renamed from: c  reason: collision with root package name */
    public UpiCustomVolleyError f67006c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f67007e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return k.a((Object) this.f67004a, (Object) jVar.f67004a) && k.a((Object) this.f67005b, (Object) jVar.f67005b) && k.a((Object) this.f67006c, (Object) jVar.f67006c) && this.f67007e == jVar.f67007e;
    }

    public final int hashCode() {
        l lVar = this.f67004a;
        int i2 = 0;
        int hashCode = (lVar != null ? lVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f67005b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        UpiCustomVolleyError upiCustomVolleyError = this.f67006c;
        if (upiCustomVolleyError != null) {
            i2 = upiCustomVolleyError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f67007e;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "Resource(status=" + this.f67004a + ", data=" + this.f67005b + ", error=" + this.f67006c + ", isPaginatedLoading=" + this.f67007e + ")";
    }

    private j(l lVar, ResultType resulttype, UpiCustomVolleyError upiCustomVolleyError) {
        k.c(lVar, "status");
        this.f67004a = lVar;
        this.f67005b = resulttype;
        this.f67006c = upiCustomVolleyError;
        this.f67007e = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(l lVar, Object obj, UpiCustomVolleyError upiCustomVolleyError, int i2) {
        this(lVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : upiCustomVolleyError);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ j a(Object obj) {
            return new j(l.SUCCESS, obj, (UpiCustomVolleyError) null, 4);
        }

        public static /* synthetic */ j a() {
            return new j(l.LOADING, (Object) null, (UpiCustomVolleyError) null, 6);
        }

        public static /* synthetic */ j a(UpiCustomVolleyError upiCustomVolleyError) {
            return new j(l.ERROR, (Object) null, upiCustomVolleyError, 2);
        }
    }
}
