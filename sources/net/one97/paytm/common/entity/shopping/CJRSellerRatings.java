package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSellerRatings extends CJRDataModelItem {
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
