package com.paytmmall.clpartifact.view.viewmodel;

import com.paytmmall.clpartifact.listeners.IGAEnableListener;

public final class SFHomeVM$handleResponse$sanitizedResponse$1 implements IGAEnableListener {
    final /* synthetic */ SFHomeVM this$0;

    SFHomeVM$handleResponse$sanitizedResponse$1(SFHomeVM sFHomeVM) {
        this.this$0 = sFHomeVM;
    }

    public final boolean isGAEnabled() {
        return !this.this$0.isSFCacheResponse();
    }
}
