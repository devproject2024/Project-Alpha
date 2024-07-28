package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJROSMetroSmartCard extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "avm_url")
    private String avmUrl;
    @b(a = "visibility")
    private int visibility = -1;

    public final String getAvmUrl() {
        return this.avmUrl;
    }

    public final void setAvmUrl(String str) {
        this.avmUrl = str;
    }

    public final int getVisibility() {
        return this.visibility;
    }

    public final void setVisibility(int i2) {
        this.visibility = i2;
    }
}
