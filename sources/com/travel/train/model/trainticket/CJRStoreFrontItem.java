package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRStoreFrontItem implements IJRDataModel {
    @b(a = "id")
    private String id;
    @b(a = "views")
    private ArrayList<CJRTrainBannerDetails> mBannerDetails;

    public ArrayList<CJRTrainBannerDetails> getmBannerDetails() {
        return this.mBannerDetails;
    }

    public String getId() {
        return this.id;
    }
}
