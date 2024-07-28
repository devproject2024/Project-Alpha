package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.bus.pojo.CJRStoreFrontItem;
import java.util.List;

public class CJRBusFrontBanners extends IJRPaytmDataModel {
    @b(a = "page")
    private List<CJRStoreFrontItem> page;

    public List<CJRStoreFrontItem> getPage() {
        return this.page;
    }

    public void setPages(List<CJRStoreFrontItem> list) {
        this.page = list;
    }
}
