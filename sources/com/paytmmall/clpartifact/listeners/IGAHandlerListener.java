package com.paytmmall.clpartifact.listeners;

import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;

public interface IGAHandlerListener extends IAdListener, IClientListener, IGAClickListener {

    /* renamed from: com.paytmmall.clpartifact.listeners.IGAHandlerListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$fireInfiniteGridProductImpression(IGAHandlerListener iGAHandlerListener, CJRGridProduct cJRGridProduct, int i2) {
        }
    }

    void fireImpression(Item item, int i2);

    void fireImpression(View view, int i2);

    void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2);
}
