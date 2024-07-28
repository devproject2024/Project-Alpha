package net.one97.paytm.common.entity.p2p;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class NetworkResource {
    public static final Companion Companion = new Companion((g) null);
    private final IJRPaytmDataModel data;
    private final PaytmCommonError error;
    private final Status status;

    public static /* synthetic */ NetworkResource copy$default(NetworkResource networkResource, Status status2, IJRPaytmDataModel iJRPaytmDataModel, PaytmCommonError paytmCommonError, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            status2 = networkResource.status;
        }
        if ((i2 & 2) != 0) {
            iJRPaytmDataModel = networkResource.data;
        }
        if ((i2 & 4) != 0) {
            paytmCommonError = networkResource.error;
        }
        return networkResource.copy(status2, iJRPaytmDataModel, paytmCommonError);
    }

    public final Status component1() {
        return this.status;
    }

    public final IJRPaytmDataModel component2() {
        return this.data;
    }

    public final PaytmCommonError component3() {
        return this.error;
    }

    public final NetworkResource copy(Status status2, IJRPaytmDataModel iJRPaytmDataModel, PaytmCommonError paytmCommonError) {
        k.c(status2, "status");
        return new NetworkResource(status2, iJRPaytmDataModel, paytmCommonError);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkResource)) {
            return false;
        }
        NetworkResource networkResource = (NetworkResource) obj;
        return k.a((Object) this.status, (Object) networkResource.status) && k.a((Object) this.data, (Object) networkResource.data) && k.a((Object) this.error, (Object) networkResource.error);
    }

    public final int hashCode() {
        Status status2 = this.status;
        int i2 = 0;
        int hashCode = (status2 != null ? status2.hashCode() : 0) * 31;
        IJRPaytmDataModel iJRPaytmDataModel = this.data;
        int hashCode2 = (hashCode + (iJRPaytmDataModel != null ? iJRPaytmDataModel.hashCode() : 0)) * 31;
        PaytmCommonError paytmCommonError = this.error;
        if (paytmCommonError != null) {
            i2 = paytmCommonError.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "NetworkResource(status=" + this.status + ", data=" + this.data + ", error=" + this.error + ")";
    }

    public NetworkResource(Status status2, IJRPaytmDataModel iJRPaytmDataModel, PaytmCommonError paytmCommonError) {
        k.c(status2, "status");
        this.status = status2;
        this.data = iJRPaytmDataModel;
        this.error = paytmCommonError;
    }

    public final IJRPaytmDataModel getData() {
        return this.data;
    }

    public final PaytmCommonError getError() {
        return this.error;
    }

    public final Status getStatus() {
        return this.status;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final NetworkResource success(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "data");
            return new NetworkResource(Status.SUCCESS, iJRPaytmDataModel, (PaytmCommonError) null);
        }

        public final NetworkResource error(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            return new NetworkResource(Status.ERROR, (IJRPaytmDataModel) null, new PaytmCommonError(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final NetworkResource progress() {
            return new NetworkResource(Status.PROGRESS, (IJRPaytmDataModel) null, (PaytmCommonError) null);
        }

        public final NetworkResource cancel() {
            return new NetworkResource(Status.CANCELLED, (IJRPaytmDataModel) null, (PaytmCommonError) null);
        }
    }
}
