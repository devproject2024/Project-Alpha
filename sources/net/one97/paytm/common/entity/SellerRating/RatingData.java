package net.one97.paytm.common.entity.SellerRating;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class RatingData implements IJRDataModel {
    @b(a = "rating")
    private String mIRatingData;
    @b(a = "text")
    private String mText;

    public String getmText() {
        return this.mText;
    }

    public void setmText(String str) {
        this.mText = str;
    }

    public String getmIRatingData() {
        return this.mIRatingData;
    }

    public void setmIRatingData(String str) {
        this.mIRatingData = str;
    }
}
