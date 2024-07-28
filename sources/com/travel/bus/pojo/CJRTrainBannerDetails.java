package com.travel.bus.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainBannerDetails extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private List<CJROfferItems> mBannerItems;

    public List<CJROfferItems> getmBannerItems() {
        return this.mBannerItems;
    }
}
