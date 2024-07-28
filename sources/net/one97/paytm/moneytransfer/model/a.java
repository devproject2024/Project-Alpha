package net.one97.paytm.moneytransfer.model;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class a<ResultType> {

    /* renamed from: d  reason: collision with root package name */
    public static final C0968a f54024d = new C0968a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public d f54025a;

    /* renamed from: b  reason: collision with root package name */
    public ResultType f54026b;

    /* renamed from: c  reason: collision with root package name */
    public NetworkCustomError f54027c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f54028e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f54025a, (Object) aVar.f54025a) && k.a((Object) this.f54026b, (Object) aVar.f54026b) && k.a((Object) this.f54027c, (Object) aVar.f54027c) && this.f54028e == aVar.f54028e;
    }

    public final int hashCode() {
        d dVar = this.f54025a;
        int i2 = 0;
        int hashCode = (dVar != null ? dVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f54026b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.f54027c;
        if (networkCustomError != null) {
            i2 = networkCustomError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f54028e;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "APIResource(status=" + this.f54025a + ", data=" + this.f54026b + ", error=" + this.f54027c + ", isPaginatedLoading=" + this.f54028e + ")";
    }

    private a(d dVar, ResultType resulttype, NetworkCustomError networkCustomError) {
        k.c(dVar, "status");
        this.f54025a = dVar;
        this.f54026b = resulttype;
        this.f54027c = networkCustomError;
        this.f54028e = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(d dVar, Object obj, NetworkCustomError networkCustomError, int i2) {
        this(dVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : networkCustomError);
    }

    /* renamed from: net.one97.paytm.moneytransfer.model.a$a  reason: collision with other inner class name */
    public static final class C0968a {
        private C0968a() {
        }

        public /* synthetic */ C0968a(byte b2) {
            this();
        }

        public static <ResultType> a<ResultType> b() {
            return new a<>(d.AUTHENTICATION_FAILURE, (Object) null, (NetworkCustomError) null, 14);
        }

        public static /* synthetic */ a a(Object obj) {
            return new a(d.SUCCESS, obj, (NetworkCustomError) null, 4);
        }

        public static /* synthetic */ a a() {
            return new a(d.LOADING, (Object) null, (NetworkCustomError) null, 6);
        }

        public static /* synthetic */ a a(NetworkCustomError networkCustomError) {
            return new a(d.ERROR, (Object) null, networkCustomError, 2);
        }
    }
}
