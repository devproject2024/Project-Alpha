package com.paytmmall.clpartifact.repositories;

import androidx.lifecycle.y;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.x;

final class HomeRepository$loadInitialPage$2 implements Runnable {
    final /* synthetic */ y $liveData;
    final /* synthetic */ x.a $prewarmResponseReceived;
    final /* synthetic */ x.e $response;
    final /* synthetic */ HomeRepository this$0;

    HomeRepository$loadInitialPage$2(HomeRepository homeRepository, x.a aVar, x.e eVar, y yVar) {
        this.this$0 = homeRepository;
        this.$prewarmResponseReceived = aVar;
        this.$response = eVar;
        this.$liveData = yVar;
    }

    public final void run() {
        ICLPCommunicationListener communicationListener;
        ICLPCommunicationListener communicationListener2;
        Thread.sleep(5000);
        if (!this.$prewarmResponseReceived.element) {
            HomeUtils.d("fetching prewarmed data after threshold waiting... ", true);
            CLPArtifact instance = CLPArtifact.getInstance();
            if (!(instance == null || (communicationListener2 = instance.getCommunicationListener()) == null)) {
                communicationListener2.setSFPrewarmedResponseAvailableListener((ISFPrewarmedResponseAvailableListener) null, false);
            }
            this.$response.element = HomeUtils.INSTANCE.getCacheData(this.this$0.getContext());
            HomeRepository.handleCacheResponse$default(this.this$0, (HomeResponse) this.$response.element, this.$liveData, false, 4, (Object) null);
            CLPArtifact instance2 = CLPArtifact.getInstance();
            if (instance2 != null && (communicationListener = instance2.getCommunicationListener()) != null) {
                communicationListener.logThresholdBreachOnKibana();
            }
        }
    }
}
