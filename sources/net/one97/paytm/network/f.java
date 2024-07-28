package net.one97.paytm.network;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static final a f55795d = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final h f55796a;

    /* renamed from: b  reason: collision with root package name */
    public final IJRPaytmDataModel f55797b;

    /* renamed from: c  reason: collision with root package name */
    public final g f55798c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return k.a((Object) this.f55796a, (Object) fVar.f55796a) && k.a((Object) this.f55797b, (Object) fVar.f55797b) && k.a((Object) this.f55798c, (Object) fVar.f55798c);
    }

    public final int hashCode() {
        h hVar = this.f55796a;
        int i2 = 0;
        int hashCode = (hVar != null ? hVar.hashCode() : 0) * 31;
        IJRPaytmDataModel iJRPaytmDataModel = this.f55797b;
        int hashCode2 = (hashCode + (iJRPaytmDataModel != null ? iJRPaytmDataModel.hashCode() : 0)) * 31;
        g gVar = this.f55798c;
        if (gVar != null) {
            i2 = gVar.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "NetworkResource(status=" + this.f55796a + ", data=" + this.f55797b + ", error=" + this.f55798c + ")";
    }

    public f(h hVar, IJRPaytmDataModel iJRPaytmDataModel, g gVar) {
        k.c(hVar, "status");
        this.f55796a = hVar;
        this.f55797b = iJRPaytmDataModel;
        this.f55798c = gVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static f a(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "data");
            return new f(h.SUCCESS, iJRPaytmDataModel, (g) null);
        }

        public static f a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            return new f(h.ERROR, (IJRPaytmDataModel) null, new g(i2, iJRPaytmDataModel, networkCustomError));
        }

        public static f a() {
            return new f(h.PROGRESS, (IJRPaytmDataModel) null, (g) null);
        }

        public static f b() {
            return new f(h.CANCELLED, (IJRPaytmDataModel) null, (g) null);
        }
    }
}
