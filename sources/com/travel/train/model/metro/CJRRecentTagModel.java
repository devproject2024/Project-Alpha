package com.travel.train.model.metro;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRRecentTagModel extends IJRPaytmDataModel implements IJRDataModel {
    private String clearString;
    private String recentString;

    public CJRRecentTagModel(String str, String str2) {
        k.c(str, "recentString");
        k.c(str2, "clearString");
        this.recentString = str;
        this.clearString = str2;
    }

    public final String getClearString() {
        return this.clearString;
    }

    public final String getRecentString() {
        return this.recentString;
    }

    public final void setClearString(String str) {
        k.c(str, "<set-?>");
        this.clearString = str;
    }

    public final void setRecentString(String str) {
        k.c(str, "<set-?>");
        this.recentString = str;
    }
}
