package com.paytmmall.clpartifact.repositories;

import androidx.lifecycle.y;
import com.paytmmall.clpartifact.utils.HomeUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import kotlin.g.b.x;

final class HomeRepository$loadInitialPage$3 implements Runnable {
    final /* synthetic */ y $liveData;
    final /* synthetic */ x.e $response;
    final /* synthetic */ HomeRepository this$0;

    HomeRepository$loadInitialPage$3(HomeRepository homeRepository, x.e eVar, y yVar) {
        this.this$0 = homeRepository;
        this.$response = eVar;
        this.$liveData = yVar;
    }

    public final void run() {
        HomeUtils.d("pre-warm data not found, calling cache data ", true);
        this.$response.element = HomeUtils.INSTANCE.getCacheData(this.this$0.getContext());
        HomeUtils.d("Updating data on cache data basis ", true);
        HomeRepository.handleCacheResponse$default(this.this$0, (HomeResponse) this.$response.element, this.$liveData, false, 4, (Object) null);
    }
}
