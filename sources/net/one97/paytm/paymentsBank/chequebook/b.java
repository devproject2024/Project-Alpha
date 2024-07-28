package net.one97.paytm.paymentsBank.chequebook;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class b<ResultType> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f17485e = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public c f17486a;

    /* renamed from: b  reason: collision with root package name */
    public ResultType f17487b;

    /* renamed from: c  reason: collision with root package name */
    public NetworkCustomError f17488c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17489d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (k.a((Object) this.f17486a, (Object) bVar.f17486a) && k.a((Object) this.f17487b, (Object) bVar.f17487b) && k.a((Object) this.f17488c, (Object) bVar.f17488c)) {
                    if (this.f17489d == bVar.f17489d) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        c cVar = this.f17486a;
        int i2 = 0;
        int hashCode = (cVar != null ? cVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f17487b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.f17488c;
        if (networkCustomError != null) {
            i2 = networkCustomError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f17489d;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "CBResource(status=" + this.f17486a + ", data=" + this.f17487b + ", error=" + this.f17488c + ", isPaginatedLoading=" + this.f17489d + ")";
    }

    private b(c cVar, ResultType resulttype, NetworkCustomError networkCustomError, boolean z) {
        k.c(cVar, "status");
        this.f17486a = cVar;
        this.f17487b = resulttype;
        this.f17488c = networkCustomError;
        this.f17489d = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, Object obj, NetworkCustomError networkCustomError, boolean z, int i2) {
        this(cVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : networkCustomError, (i2 & 8) != 0 ? false : z);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <ResultType> b<ResultType> a(ResultType resulttype, boolean z) {
            return new b(c.SUCCESS, resulttype, (NetworkCustomError) null, z, 4);
        }

        public static /* synthetic */ b a() {
            return new b(c.LOADING, (Object) null, (NetworkCustomError) null, false, 6);
        }

        public static /* synthetic */ b a(NetworkCustomError networkCustomError) {
            return new b(c.ERROR, (Object) null, networkCustomError, false, 2);
        }
    }
}
