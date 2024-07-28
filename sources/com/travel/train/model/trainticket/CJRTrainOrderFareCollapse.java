package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderFareCollapse extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isShowMoreClicked = false;
    @b(a = "enabled")
    private boolean mEnabled;
    @b(a = "text")
    private String mText;

    public boolean ismEnabled() {
        return this.mEnabled;
    }

    public String getmText() {
        return this.mText;
    }

    public boolean isShowMoreClicked() {
        return this.isShowMoreClicked;
    }

    public void setShowMoreClicked(boolean z) {
        this.isShowMoreClicked = z;
    }
}
