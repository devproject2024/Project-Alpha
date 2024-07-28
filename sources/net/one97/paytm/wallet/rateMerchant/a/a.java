package net.one97.paytm.wallet.rateMerchant.a;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class a<ResultType> {

    /* renamed from: e  reason: collision with root package name */
    public static final C1455a f71610e = new C1455a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public b f71611a;

    /* renamed from: b  reason: collision with root package name */
    public ResultType f71612b;

    /* renamed from: c  reason: collision with root package name */
    public NetworkCustomError f71613c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71614d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (k.a((Object) this.f71611a, (Object) aVar.f71611a) && k.a((Object) this.f71612b, (Object) aVar.f71612b) && k.a((Object) this.f71613c, (Object) aVar.f71613c)) {
                    if (this.f71614d == aVar.f71614d) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        b bVar = this.f71611a;
        int i2 = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f71612b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.f71613c;
        if (networkCustomError != null) {
            i2 = networkCustomError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f71614d;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "Resource(status=" + this.f71611a + ", data=" + this.f71612b + ", error=" + this.f71613c + ", isPaginatedLoading=" + this.f71614d + ")";
    }

    private a(b bVar, ResultType resulttype, NetworkCustomError networkCustomError, boolean z) {
        k.c(bVar, "status");
        this.f71611a = bVar;
        this.f71612b = resulttype;
        this.f71613c = networkCustomError;
        this.f71614d = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b bVar, Object obj, NetworkCustomError networkCustomError, boolean z, int i2) {
        this(bVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : networkCustomError, (i2 & 8) != 0 ? false : z);
    }

    /* renamed from: net.one97.paytm.wallet.rateMerchant.a.a$a  reason: collision with other inner class name */
    public static final class C1455a {
        private C1455a() {
        }

        public /* synthetic */ C1455a(byte b2) {
            this();
        }

        public static <ResultType> a<ResultType> a(boolean z) {
            return new a(b.LOADING, (Object) null, (NetworkCustomError) null, z, 6);
        }

        public static <ResultType> a<ResultType> a(NetworkCustomError networkCustomError, boolean z) {
            return new a(b.ERROR, (Object) null, networkCustomError, z, 2);
        }

        public static /* synthetic */ a a(Object obj) {
            return new a(b.SUCCESS, obj, (NetworkCustomError) null, false, 4);
        }
    }
}
