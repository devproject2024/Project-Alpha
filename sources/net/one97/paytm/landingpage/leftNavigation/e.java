package net.one97.paytm.landingpage.leftNavigation;

import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;

public final class e extends StoreFrontGAHandler {

    /* renamed from: a  reason: collision with root package name */
    IGAEnableListener f52851a;

    public final int getClient() {
        return 1005;
    }

    public final String getScreenName() {
        return CLPConstants.GTM_SCREEN_NAME_FLYOUT;
    }

    public final String getVerticalID() {
        return "/";
    }

    public final void fireImpression(Item item, int i2) {
        IGAEnableListener iGAEnableListener = this.f52851a;
        if (iGAEnableListener != null && iGAEnableListener.isGAEnabled()) {
            h hVar = h.f52857a;
            if (h.a()) {
                super.fireImpression(item, i2);
            }
        }
    }

    public final void OnItemClick(Item item, int i2, boolean z) {
        IGAEnableListener iGAEnableListener = this.f52851a;
        if (iGAEnableListener != null && iGAEnableListener.isGAEnabled()) {
            h hVar = h.f52857a;
            if (h.a()) {
                super.OnItemClick(item, i2, z);
            }
        }
    }
}
