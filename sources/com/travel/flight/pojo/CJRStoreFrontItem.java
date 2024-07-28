package com.travel.flight.pojo;

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

    public void setmBannerDetails(ArrayList<CJRTrainBannerDetails> arrayList) {
        this.mBannerDetails = arrayList;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }
}
