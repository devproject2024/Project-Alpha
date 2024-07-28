package net.one97.paytm.common.entity.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
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

    public void setmId(int i2) {
        this.mId = i2;
    }

    public String getmName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public int getmPriority() {
        return this.mPriority;
    }

    public void setmPriority(int i2) {
        this.mPriority = i2;
    }

    public int getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(int i2) {
        this.mStatus = i2;
    }

    public List<CJROfferItems> getmBannerItems() {
        return this.mBannerItems;
    }

    public void setmBannerItems(List<CJROfferItems> list) {
        this.mBannerItems = list;
    }

    public String getmType() {
        return this.mType;
    }

    public void setmType(String str) {
        this.mType = str;
    }
}
