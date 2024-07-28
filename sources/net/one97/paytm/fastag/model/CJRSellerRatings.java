package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRSellerRatings extends IJRPaytmDataModel {
    @b(a = "data")
    private List<CJRSellerRatingProp> mData;
    @b(a = "display_rating")
    private String mDisplayRating;
    @b(a = "merchant_id")
    private String mMerchantId;
    @b(a = "rating")
    private String mRating;
    @b(a = "sample_count")
    private String mRatingCount;

    public String getName() {
        return null;
    }

    public String getRating() {
        return this.mRating;
    }

    public String getDisplayRating() {
        return this.mDisplayRating;
    }

    public String getmMerchantId() {
        return this.mMerchantId;
    }

    public String getRatingCount() {
        return this.mRatingCount;
    }

    public List<CJRSellerRatingProp> getData() {
        return this.mData;
    }
}
