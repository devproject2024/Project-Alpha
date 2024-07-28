package net.one97.paytm.upgradeKyc.kycV3.b;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class b<ResultType> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f66167d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public d f66168a;

    /* renamed from: b  reason: collision with root package name */
    public ResultType f66169b;

    /* renamed from: c  reason: collision with root package name */
    public NetworkCustomError f66170c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f66171e;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (k.a((Object) this.f66168a, (Object) bVar.f66168a) && k.a((Object) this.f66169b, (Object) bVar.f66169b) && k.a((Object) this.f66170c, (Object) bVar.f66170c)) {
                    if (this.f66171e == bVar.f66171e) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        d dVar = this.f66168a;
        int i2 = 0;
        int hashCode = (dVar != null ? dVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f66169b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.f66170c;
        if (networkCustomError != null) {
            i2 = networkCustomError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f66171e;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "KycResource(status=" + this.f66168a + ", data=" + this.f66169b + ", error=" + this.f66170c + ", isPaginatedLoading=" + this.f66171e + ")";
    }

    private b(d dVar, ResultType resulttype, NetworkCustomError networkCustomError) {
        k.c(dVar, "status");
        this.f66168a = dVar;
        this.f66169b = resulttype;
        this.f66170c = networkCustomError;
        this.f66171e = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(d dVar, Object obj, NetworkCustomError networkCustomError, int i2) {
        this(dVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : networkCustomError);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <ResultType> b<ResultType> a(ResultType resulttype) {
            return new b<>(d.SUCCESS, resulttype, (NetworkCustomError) null, 4);
        }

        public static <ResultType> b<ResultType> a() {
            return new b<>(d.LOADING, (Object) null, (NetworkCustomError) null, 6);
        }

        public static <ResultType> b<ResultType> a(NetworkCustomError networkCustomError) {
            return new b<>(d.ERROR, (Object) null, networkCustomError, 2);
        }
    }
}
