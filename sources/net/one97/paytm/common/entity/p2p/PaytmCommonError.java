package net.one97.paytm.common.entity.p2p;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class PaytmCommonError {
    private IJRPaytmDataModel ijrPaytmDataModel;
    private NetworkCustomError networkCustomError;
    private int statusCode;

    public static /* synthetic */ PaytmCommonError copy$default(PaytmCommonError paytmCommonError, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = paytmCommonError.statusCode;
        }
        if ((i3 & 2) != 0) {
            iJRPaytmDataModel = paytmCommonError.ijrPaytmDataModel;
        }
        if ((i3 & 4) != 0) {
            networkCustomError2 = paytmCommonError.networkCustomError;
        }
        return paytmCommonError.copy(i2, iJRPaytmDataModel, networkCustomError2);
    }

    public final int component1() {
        return this.statusCode;
    }

    public final IJRPaytmDataModel component2() {
        return this.ijrPaytmDataModel;
    }

    public final NetworkCustomError component3() {
        return this.networkCustomError;
    }

    public final PaytmCommonError copy(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError2) {
        return new PaytmCommonError(i2, iJRPaytmDataModel, networkCustomError2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PaytmCommonError) {
                PaytmCommonError paytmCommonError = (PaytmCommonError) obj;
                if (!(this.statusCode == paytmCommonError.statusCode) || !k.a((Object) this.ijrPaytmDataModel, (Object) paytmCommonError.ijrPaytmDataModel) || !k.a((Object) this.networkCustomError, (Object) paytmCommonError.networkCustomError)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.statusCode * 31;
        IJRPaytmDataModel iJRPaytmDataModel = this.ijrPaytmDataModel;
        int i3 = 0;
        int hashCode = (i2 + (iJRPaytmDataModel != null ? iJRPaytmDataModel.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError2 = this.networkCustomError;
        if (networkCustomError2 != null) {
            i3 = networkCustomError2.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "PaytmCommonError(statusCode=" + this.statusCode + ", ijrPaytmDataModel=" + this.ijrPaytmDataModel + ", networkCustomError=" + this.networkCustomError + ")";
    }

    public PaytmCommonError(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError2) {
        this.statusCode = i2;
        this.ijrPaytmDataModel = iJRPaytmDataModel;
        this.networkCustomError = networkCustomError2;
    }

    public final IJRPaytmDataModel getIjrPaytmDataModel() {
        return this.ijrPaytmDataModel;
    }

    public final NetworkCustomError getNetworkCustomError() {
        return this.networkCustomError;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setIjrPaytmDataModel(IJRPaytmDataModel iJRPaytmDataModel) {
        this.ijrPaytmDataModel = iJRPaytmDataModel;
    }

    public final void setNetworkCustomError(NetworkCustomError networkCustomError2) {
        this.networkCustomError = networkCustomError2;
    }

    public final void setStatusCode(int i2) {
        this.statusCode = i2;
    }
}
