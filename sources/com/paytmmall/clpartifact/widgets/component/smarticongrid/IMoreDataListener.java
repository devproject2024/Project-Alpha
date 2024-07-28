package com.paytmmall.clpartifact.widgets.component.smarticongrid;

import net.one97.paytm.common.entity.shopping.CJRHomePageV2;

public interface IMoreDataListener {
    void onError();

    void onMoreDataRecieved(CJRHomePageV2 cJRHomePageV2);
}
