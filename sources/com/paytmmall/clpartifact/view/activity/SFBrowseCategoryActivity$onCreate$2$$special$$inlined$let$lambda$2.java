package com.paytmmall.clpartifact.view.activity;

import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import kotlin.g.b.k;

public final class SFBrowseCategoryActivity$onCreate$2$$special$$inlined$let$lambda$2 implements IGAEnableListener {
    final /* synthetic */ Resource $response$inlined;
    final /* synthetic */ SFBrowseCategoryActivity$onCreate$2 this$0;

    SFBrowseCategoryActivity$onCreate$2$$special$$inlined$let$lambda$2(SFBrowseCategoryActivity$onCreate$2 sFBrowseCategoryActivity$onCreate$2, Resource resource) {
        this.this$0 = sFBrowseCategoryActivity$onCreate$2;
        this.$response$inlined = resource;
    }

    public final boolean isGAEnabled() {
        RequestType access$getNetworkRequestType$p = this.this$0.this$0.networkRequestType;
        return k.a((Object) access$getNetworkRequestType$p != null ? access$getNetworkRequestType$p.name() : null, (Object) RequestType.REFRESH.name());
    }
}
