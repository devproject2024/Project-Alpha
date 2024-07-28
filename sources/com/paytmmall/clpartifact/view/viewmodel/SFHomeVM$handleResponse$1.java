package com.paytmmall.clpartifact.view.viewmodel;

import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.utils.HomeUtils;
import kotlin.g.b.k;

final class SFHomeVM$handleResponse$1 implements Runnable {
    final /* synthetic */ Resource $homeResponse;
    final /* synthetic */ boolean $isValidResponse;
    final /* synthetic */ SFHomeVM this$0;

    SFHomeVM$handleResponse$1(SFHomeVM sFHomeVM, boolean z, Resource resource) {
        this.this$0 = sFHomeVM;
        this.$isValidResponse = z;
        this.$homeResponse = resource;
    }

    public final void run() {
        ICLPCommunicationListener communicationListener;
        if (this.$isValidResponse && this.$homeResponse.getRequestType() == RequestType.REFRESH) {
            this.this$0.isHomeRefreshed = true;
            HomeUtils.d$default("Sanitization was valid and request type was from API, hence saving in file + controller of client", false, 2, (Object) null);
            CLPArtifact instance = CLPArtifact.getInstance();
            if (!(instance == null || (communicationListener = instance.getCommunicationListener()) == null)) {
                communicationListener.savePreHeatData((HomeResponse) this.$homeResponse.getData());
            }
            HomeUtils homeUtils = HomeUtils.INSTANCE;
            Object data = this.$homeResponse.getData();
            k.a(data, "homeResponse.data");
            homeUtils.saveInFile((HomeResponse) data);
            this.this$0.saveUserContextData((HomeResponse) this.$homeResponse.getData());
        }
    }
}
