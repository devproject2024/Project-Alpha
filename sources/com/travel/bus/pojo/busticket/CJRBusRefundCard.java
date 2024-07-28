package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusRefundCard implements IJRDataModel {
    @b(a = "display_data")
    private List<CJRBusDisplayRefundDetails> cjrBusDisplayRefundDetailsList = null;

    public List<CJRBusDisplayRefundDetails> getDisplayData() {
        return this.cjrBusDisplayRefundDetailsList;
    }

    public void setDisplayData(List<CJRBusDisplayRefundDetails> list) {
        this.cjrBusDisplayRefundDetailsList = list;
    }
}
