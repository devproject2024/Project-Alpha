package com.paytmmall.clpartifact.ga;

import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;

public final class ShowMoreGAHandler extends StoreFrontGAHandler {
    private IGAEnableListener igaEnableListener;

    public final int getClient() {
        return 1008;
    }

    public final String getScreenName() {
        return CLPConstants.GTM_SCREEN_NAME_SHOW_MORE;
    }

    public final String getVerticalID() {
        return CLPConstants.GTM_SCREEN_NAME_SHOW_MORE;
    }

    public final void setIgaEnableListener(IGAEnableListener iGAEnableListener) {
        k.c(iGAEnableListener, "listener");
        this.igaEnableListener = iGAEnableListener;
    }

    public final void fireImpression(Item item, int i2) {
        IGAEnableListener iGAEnableListener = this.igaEnableListener;
        if (iGAEnableListener != null && iGAEnableListener.isGAEnabled()) {
            super.fireImpression(item, i2);
        }
    }

    public final void fireImpression(View view, int i2) {
        k.c(view, "view");
        IGAEnableListener iGAEnableListener = this.igaEnableListener;
        if (iGAEnableListener != null && iGAEnableListener.isGAEnabled()) {
            super.fireImpression(view, i2);
        }
    }

    public final void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        IGAEnableListener iGAEnableListener = this.igaEnableListener;
        if (iGAEnableListener != null && iGAEnableListener.isGAEnabled()) {
            super.fireInfiniteGridProductImpression(cJRGridProduct, i2);
        }
    }
}
