package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.train.model.CJROfferItems;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainBannerDetails extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "items")
    private List<CJROfferItems> mBannerItems;
    @b(a = "id")
    private int mId;
    @b(a = "name")
    private String mName;
    @b(a = "priority")
    private int mPriority;
    @b(a = "status")
    private int mStatus;
    @b(a = "type")
    private String mType;

    public int getmId() {
        return this.mId;
    }

    public String getmName() {
        return this.mName;
    }

    public int getmPriority() {
        return this.mPriority;
    }

    public int getmStatus() {
        return this.mStatus;
    }

    public List<CJROfferItems> getmBannerItems() {
        return this.mBannerItems;
    }

    public String getmType() {
        return this.mType;
    }
}
