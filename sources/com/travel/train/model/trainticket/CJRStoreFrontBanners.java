package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStoreFrontBanners extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "page")
    private List<CJRStoreFrontItem> page;

    public List<CJRStoreFrontItem> getPage() {
        return this.page;
    }
}
