package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRStoreFrontBannersFlight extends IJRPaytmDataModel {
    @b(a = "page")
    private List<CJRStoreFrontItem> page;

    public List<CJRStoreFrontItem> getPage() {
        return this.page;
    }

    public void setPages(List<CJRStoreFrontItem> list) {
        this.page = list;
    }
}
