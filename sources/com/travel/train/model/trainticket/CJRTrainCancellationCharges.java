package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCancellationCharges extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "charges")
    private String charges;
    @b(a = "enabled")
    private boolean enabled;
    @b(a = "label")
    private String label;

    public boolean getEnabled() {
        return this.enabled;
    }

    public String getLabel() {
        return this.label;
    }

    public String getCharges() {
        return this.charges;
    }
}
