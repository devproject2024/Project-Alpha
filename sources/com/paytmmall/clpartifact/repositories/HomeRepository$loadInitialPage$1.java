package com.paytmmall.clpartifact.repositories;

import androidx.lifecycle.y;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.ISFPrewarmedResponseAvailableListener;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.x;

final class HomeRepository$loadInitialPage$1 implements ISFPrewarmedResponseAvailableListener {
    final /* synthetic */ y $liveData;
    final /* synthetic */ x.a $prewarmResponseReceived;
    final /* synthetic */ HomeRepository this$0;

    HomeRepository$loadInitialPage$1(HomeRepository homeRepository, x.a aVar, y yVar) {
        this.this$0 = homeRepository;
        this.$prewarmResponseReceived = aVar;
        this.$liveData = yVar;
    }

    public final void onPrewarmedResponseAvailable(HomeResponse homeResponse) {
        ICLPCommunicationListener communicationListener;
        HomeUtils.d("prewarmed data received after waiting... ", true);
        HomeUtils.d("rendering with prewarmed data", true);
        this.$prewarmResponseReceived.element = true;
        CLPArtifact instance = CLPArtifact.getInstance();
        if (!(instance == null || (communicationListener = instance.getCommunicationListener()) == null)) {
            communicationListener.setSFPrewarmedResponseAvailableListener((ISFPrewarmedResponseAvailableListener) null, false);
        }
        this.this$0.handleCacheResponse(homeResponse, this.$liveData, true);
    }
}
