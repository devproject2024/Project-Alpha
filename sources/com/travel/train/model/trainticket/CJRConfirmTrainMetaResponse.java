package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRConfirmTrainMetaResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "poweredByDisplay")
    String mDisplayIconVisible;
    @b(a = "poweredByImageUrl")
    String mDisplayImageUrl;

    public String getmDisplayIconVisible() {
        return this.mDisplayIconVisible;
    }

    public String getmDisplayImageUrl() {
        return this.mDisplayImageUrl;
    }
}
