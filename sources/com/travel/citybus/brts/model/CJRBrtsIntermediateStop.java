package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrtsIntermediateStop implements IJRDataModel {
    @b(a = "name")
    private String mName;

    public String getName() {
        return this.mName;
    }
}
