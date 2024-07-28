package com.travel.train.model.metro;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRClearRecentDataModel extends IJRPaytmDataModel implements IJRDataModel {
    public boolean type = false;

    public CJRClearRecentDataModel(boolean z) {
        this.type = z;
    }
}
