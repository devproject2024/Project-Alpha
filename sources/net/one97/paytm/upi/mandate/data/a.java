package net.one97.paytm.upi.mandate.data;

import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiCustomVolleyError;

public final class a<ResultType> {

    /* renamed from: e  reason: collision with root package name */
    public static final C1355a f67116e = new C1355a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final b f67117a;

    /* renamed from: b  reason: collision with root package name */
    public final ResultType f67118b;

    /* renamed from: c  reason: collision with root package name */
    public final UpiCustomVolleyError f67119c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f67120d;

    public enum b {
        SUCCESS,
        ERROR,
        LOADING
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f67117a, (Object) aVar.f67117a) && k.a((Object) this.f67118b, (Object) aVar.f67118b) && k.a((Object) this.f67119c, (Object) aVar.f67119c) && this.f67120d == aVar.f67120d;
    }

    public final int hashCode() {
        b bVar = this.f67117a;
        int i2 = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f67118b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        UpiCustomVolleyError upiCustomVolleyError = this.f67119c;
        if (upiCustomVolleyError != null) {
            i2 = upiCustomVolleyError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f67120d;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "Resource(status=" + this.f67117a + ", data=" + this.f67118b + ", error=" + this.f67119c + ", isPaginatedLoading=" + this.f67120d + ")";
    }

    private a(b bVar, ResultType resulttype, UpiCustomVolleyError upiCustomVolleyError, boolean z) {
        k.c(bVar, "status");
        this.f67117a = bVar;
        this.f67118b = resulttype;
        this.f67119c = upiCustomVolleyError;
        this.f67120d = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b bVar, Object obj, UpiCustomVolleyError upiCustomVolleyError, boolean z, int i2) {
        this(bVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : upiCustomVolleyError, (i2 & 8) != 0 ? false : z);
    }

    /* renamed from: net.one97.paytm.upi.mandate.data.a$a  reason: collision with other inner class name */
    public static final class C1355a {
        private C1355a() {
        }

        public /* synthetic */ C1355a(byte b2) {
            this();
        }

        public static <ResultType> a<ResultType> a(ResultType resulttype, boolean z) {
            return new a(b.SUCCESS, resulttype, (UpiCustomVolleyError) null, z, 4);
        }

        public static <ResultType> a<ResultType> a(boolean z) {
            return new a(b.LOADING, (Object) null, (UpiCustomVolleyError) null, z, 6);
        }

        public static <ResultType> a<ResultType> a(UpiCustomVolleyError upiCustomVolleyError, boolean z) {
            return new a(b.ERROR, (Object) null, upiCustomVolleyError, z, 2);
        }
    }
}
