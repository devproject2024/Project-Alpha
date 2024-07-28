package com.travel.bus.pojo.photos;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusBPPhotos implements IJRDataModel {
    @b(a = "Onward")
    private CJRBusBPOnward onward;

    public CJRBusBPOnward getOnward() {
        return this.onward;
    }
}
