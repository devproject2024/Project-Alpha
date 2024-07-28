package net.one97.paytm.p2b.data;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class a<ResultType> {

    /* renamed from: d  reason: collision with root package name */
    public static final C0168a f12728d = new C0168a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public b f12729a;

    /* renamed from: b  reason: collision with root package name */
    public ResultType f12730b;

    /* renamed from: c  reason: collision with root package name */
    public NetworkCustomError f12731c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12732e;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (k.a((Object) this.f12729a, (Object) aVar.f12729a) && k.a((Object) this.f12730b, (Object) aVar.f12730b) && k.a((Object) this.f12731c, (Object) aVar.f12731c)) {
                    if (this.f12732e == aVar.f12732e) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        b bVar = this.f12729a;
        int i2 = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        ResultType resulttype = this.f12730b;
        int hashCode2 = (hashCode + (resulttype != null ? resulttype.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError = this.f12731c;
        if (networkCustomError != null) {
            i2 = networkCustomError.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.f12732e;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "P2BResource(status=" + this.f12729a + ", data=" + this.f12730b + ", error=" + this.f12731c + ", isPaginatedLoading=" + this.f12732e + ")";
    }

    private a(b bVar, ResultType resulttype, NetworkCustomError networkCustomError) {
        k.c(bVar, "status");
        this.f12729a = bVar;
        this.f12730b = resulttype;
        this.f12731c = networkCustomError;
        this.f12732e = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b bVar, Object obj, NetworkCustomError networkCustomError, int i2) {
        this(bVar, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? null : networkCustomError);
    }

    /* renamed from: net.one97.paytm.p2b.data.a$a  reason: collision with other inner class name */
    public static final class C0168a {
        private C0168a() {
        }

        public /* synthetic */ C0168a(byte b2) {
            this();
        }

        public static <ResultType> a<ResultType> a(NetworkCustomError networkCustomError) {
            return new a<>(b.ERROR, (Object) null, networkCustomError, 2);
        }

        public static /* synthetic */ a a(Object obj) {
            return new a(b.SUCCESS, obj, (NetworkCustomError) null, 4);
        }

        public static /* synthetic */ a a() {
            return new a(b.LOADING, (Object) null, (NetworkCustomError) null, 6);
        }
    }
}
