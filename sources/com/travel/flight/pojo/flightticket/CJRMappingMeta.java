package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMappingMeta implements IJRDataModel {
    @b(a = "price")
    private CJRFilterMinMaxItem mPrice;

    public CJRFilterMinMaxItem getmPrice() {
        return this.mPrice;
    }

    public void setmPrice(CJRFilterMinMaxItem cJRFilterMinMaxItem) {
        this.mPrice = cJRFilterMinMaxItem;
    }
}
