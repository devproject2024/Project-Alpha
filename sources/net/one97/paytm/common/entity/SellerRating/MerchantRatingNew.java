package net.one97.paytm.common.entity.SellerRating;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class MerchantRatingNew implements IJRDataModel {
    @b(a = "data")
    private ArrayList<RatingData> mData;
    @b(a = "display_rating")
    private String mDipRating;
    @b(a = "merchant_id")
    private String mMerchantId;
    @b(a = "rating")
    private String mRating;
    @b(a = "sample_count")
    private String mSampleCount;

    public String getmRating() {
        return this.mRating;
    }

    public void setmRating(String str) {
        this.mRating = str;
    }

    public ArrayList<RatingData> getmData() {
        return this.mData;
    }

    public void setmData(ArrayList<RatingData> arrayList) {
        this.mData = arrayList;
    }

    public String getmMerchantId() {
        return this.mMerchantId;
    }

    public void setmMerchantId(String str) {
        this.mMerchantId = str;
    }

    public String getmDipRating() {
        return this.mDipRating;
    }

    public void setmDipRating(String str) {
        this.mDipRating = str;
    }

    public String getmSampleCount() {
        return this.mSampleCount;
    }

    public void setmSampleCount(String str) {
        this.mSampleCount = str;
    }
}
