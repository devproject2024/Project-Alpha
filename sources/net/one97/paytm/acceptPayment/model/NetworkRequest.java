package net.one97.paytm.acceptPayment.model;

import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;

public final class NetworkRequest {
    private final a cjrCommonNetworkCall;
    private final IJRPaytmDataModel ijrPaytmDataModel;
    private final NetworkCustomError networkCustomError;
    private final kotlin.g.a.a<x> onError;
    private final b<NetworkRequest, x> onSuccess;
    private final RequestStatus status;

    public static /* synthetic */ NetworkRequest copy$default(NetworkRequest networkRequest, RequestStatus requestStatus, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError2, a aVar, b<NetworkRequest, x> bVar, kotlin.g.a.a<x> aVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            requestStatus = networkRequest.status;
        }
        if ((i2 & 2) != 0) {
            iJRPaytmDataModel = networkRequest.ijrPaytmDataModel;
        }
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        if ((i2 & 4) != 0) {
            networkCustomError2 = networkRequest.networkCustomError;
        }
        NetworkCustomError networkCustomError3 = networkCustomError2;
        if ((i2 & 8) != 0) {
            aVar = networkRequest.cjrCommonNetworkCall;
        }
        a aVar3 = aVar;
        if ((i2 & 16) != 0) {
            bVar = networkRequest.onSuccess;
        }
        b<NetworkRequest, x> bVar2 = bVar;
        if ((i2 & 32) != 0) {
            aVar2 = networkRequest.onError;
        }
        return networkRequest.copy(requestStatus, iJRPaytmDataModel2, networkCustomError3, aVar3, bVar2, aVar2);
    }

    public final RequestStatus component1() {
        return this.status;
    }

    public final IJRPaytmDataModel component2() {
        return this.ijrPaytmDataModel;
    }

    public final NetworkCustomError component3() {
        return this.networkCustomError;
    }

    public final a component4() {
        return this.cjrCommonNetworkCall;
    }

    public final b<NetworkRequest, x> component5() {
        return this.onSuccess;
    }

    public final kotlin.g.a.a<x> component6() {
        return this.onError;
    }

    public final NetworkRequest copy(RequestStatus requestStatus, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError2, a aVar, b<? super NetworkRequest, x> bVar, kotlin.g.a.a<x> aVar2) {
        k.d(requestStatus, "status");
        return new NetworkRequest(requestStatus, iJRPaytmDataModel, networkCustomError2, aVar, bVar, aVar2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkRequest)) {
            return false;
        }
        NetworkRequest networkRequest = (NetworkRequest) obj;
        return k.a((Object) this.status, (Object) networkRequest.status) && k.a((Object) this.ijrPaytmDataModel, (Object) networkRequest.ijrPaytmDataModel) && k.a((Object) this.networkCustomError, (Object) networkRequest.networkCustomError) && k.a((Object) this.cjrCommonNetworkCall, (Object) networkRequest.cjrCommonNetworkCall) && k.a((Object) this.onSuccess, (Object) networkRequest.onSuccess) && k.a((Object) this.onError, (Object) networkRequest.onError);
    }

    public final int hashCode() {
        RequestStatus requestStatus = this.status;
        int i2 = 0;
        int hashCode = (requestStatus != null ? requestStatus.hashCode() : 0) * 31;
        IJRPaytmDataModel iJRPaytmDataModel = this.ijrPaytmDataModel;
        int hashCode2 = (hashCode + (iJRPaytmDataModel != null ? iJRPaytmDataModel.hashCode() : 0)) * 31;
        NetworkCustomError networkCustomError2 = this.networkCustomError;
        int hashCode3 = (hashCode2 + (networkCustomError2 != null ? networkCustomError2.hashCode() : 0)) * 31;
        a aVar = this.cjrCommonNetworkCall;
        int hashCode4 = (hashCode3 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        b<NetworkRequest, x> bVar = this.onSuccess;
        int hashCode5 = (hashCode4 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        kotlin.g.a.a<x> aVar2 = this.onError;
        if (aVar2 != null) {
            i2 = aVar2.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "NetworkRequest(status=" + this.status + ", ijrPaytmDataModel=" + this.ijrPaytmDataModel + ", networkCustomError=" + this.networkCustomError + ", cjrCommonNetworkCall=" + this.cjrCommonNetworkCall + ", onSuccess=" + this.onSuccess + ", onError=" + this.onError + ")";
    }

    public NetworkRequest(RequestStatus requestStatus, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError2, a aVar, b<? super NetworkRequest, x> bVar, kotlin.g.a.a<x> aVar2) {
        k.d(requestStatus, "status");
        this.status = requestStatus;
        this.ijrPaytmDataModel = iJRPaytmDataModel;
        this.networkCustomError = networkCustomError2;
        this.cjrCommonNetworkCall = aVar;
        this.onSuccess = bVar;
        this.onError = aVar2;
    }

    public final RequestStatus getStatus() {
        return this.status;
    }

    public final IJRPaytmDataModel getIjrPaytmDataModel() {
        return this.ijrPaytmDataModel;
    }

    public final NetworkCustomError getNetworkCustomError() {
        return this.networkCustomError;
    }

    public final a getCjrCommonNetworkCall() {
        return this.cjrCommonNetworkCall;
    }

    public final b<NetworkRequest, x> getOnSuccess() {
        return this.onSuccess;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NetworkRequest(net.one97.paytm.acceptPayment.model.RequestStatus r7, com.paytm.network.model.IJRPaytmDataModel r8, com.paytm.network.model.NetworkCustomError r9, com.paytm.network.a r10, kotlin.g.a.b r11, kotlin.g.a.a r12, int r13, kotlin.g.b.g r14) {
        /*
            r6 = this;
            r0 = r13 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r13 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r13 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r13 & 32
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r12
        L_0x0023:
            r8 = r6
            r9 = r7
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.acceptPayment.model.NetworkRequest.<init>(net.one97.paytm.acceptPayment.model.RequestStatus, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError, com.paytm.network.a, kotlin.g.a.b, kotlin.g.a.a, int, kotlin.g.b.g):void");
    }

    public final kotlin.g.a.a<x> getOnError() {
        return this.onError;
    }
}
