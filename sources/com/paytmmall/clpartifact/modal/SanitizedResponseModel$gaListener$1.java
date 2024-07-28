package com.paytmmall.clpartifact.modal;

import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;

public final class SanitizedResponseModel$gaListener$1 extends StoreFrontGAHandler {
    final /* synthetic */ int $clientType;
    final /* synthetic */ SanitizedResponseModel this$0;

    SanitizedResponseModel$gaListener$1(SanitizedResponseModel sanitizedResponseModel, int i2) {
        this.this$0 = sanitizedResponseModel;
        this.$clientType = i2;
    }

    public final void fireImpression(Item item, int i2) {
        IGAEnableListener gaEnableListener = this.this$0.getGaEnableListener();
        if (gaEnableListener != null ? gaEnableListener.isGAEnabled() : true) {
            super.fireImpression(item, i2);
        }
    }

    public final void OnItemClick(Item item, int i2, boolean z) {
        IGAEnableListener gaEnableListener = this.this$0.getGaEnableListener();
        if (gaEnableListener != null ? gaEnableListener.isGAEnabled() : true) {
            super.OnItemClick(item, i2, z);
        }
    }

    public final String getScreenName() {
        String verticalName = this.this$0.getVerticalName();
        return verticalName == null ? "" : verticalName;
    }

    public final String getVerticalID() {
        String verticalName = this.this$0.getVerticalName();
        return verticalName == null ? "" : verticalName;
    }

    public final String getClientRequestID() {
        String adRequestId = this.this$0.getAdRequestId();
        return adRequestId == null ? "" : adRequestId;
    }

    public final int getClient() {
        return this.$clientType;
    }
}
