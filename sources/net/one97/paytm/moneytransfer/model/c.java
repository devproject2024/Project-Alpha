package net.one97.paytm.moneytransfer.model;

import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiCustomVolleyError;

public final class c<ResultType> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f54031e = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public d f54032a;

    /* renamed from: b  reason: collision with root package name */
    public ResultType f54033b;

    /* renamed from: c  reason: collision with root package name */
    public UpiCustomVolleyError f54034c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f54035d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.a((Object) this.f54032a, (Object) cVar.f54032a) && k.a((Object) this.f54033b, (Object) cVar.f54033b) && k.a((Object) this.f54034c, (Object) cVar.f54034c) && this.f54035d == cVar.f54035d;
    }

    public final int hashCode() {
        d dVar = this.f54032a;
        int i2 = 0;
        int hashCode = (dVar != null ? dVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f54033b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        UpiCustomVolleyError upiCustomVolleyError = this.f54034c;
        if (upiCustomVolleyError != null) {
            i2 = upiCustomVolleyError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f54035d;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "Resource(status=" + this.f54032a + ", data=" + this.f54033b + ", error=" + this.f54034c + ", isPaginatedLoading=" + this.f54035d + ")";
    }

    private c(d dVar, ResultType resulttype, UpiCustomVolleyError upiCustomVolleyError) {
        k.c(dVar, "status");
        this.f54032a = dVar;
        this.f54033b = resulttype;
        this.f54034c = upiCustomVolleyError;
        this.f54035d = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(d dVar, Object obj, UpiCustomVolleyError upiCustomVolleyError, int i2) {
        this(dVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : upiCustomVolleyError);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <ResultType> c<ResultType> a(ResultType resulttype) {
            return new c<>(d.SUCCESS, resulttype, (UpiCustomVolleyError) null, 4);
        }

        public static <ResultType> c<ResultType> a() {
            return new c<>(d.LOADING, (Object) null, (UpiCustomVolleyError) null, 6);
        }

        public static <ResultType> c<ResultType> a(UpiCustomVolleyError upiCustomVolleyError) {
            return new c<>(d.ERROR, (Object) null, upiCustomVolleyError, 2);
        }

        public static <ResultType> c<ResultType> b() {
            return new c<>(d.AUTHENTICATION_FAILURE, (Object) null, (UpiCustomVolleyError) null, 14);
        }

        public static <ResultType> c<ResultType> c() {
            return new c<>(d.ABORTED, (Object) null, (UpiCustomVolleyError) null, 14);
        }
    }
}
