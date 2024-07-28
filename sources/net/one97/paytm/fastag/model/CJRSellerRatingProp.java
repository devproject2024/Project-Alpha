package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSellerRatingProp extends IJRPaytmDataModel {
    @b(a = "rating")
    private String mRating;
    @b(a = "text")
    private String mText;

    public String getName() {
        return null;
    }

    public CJRSellerRatingProp(String str, String str2) {
        this.mRating = str;
        this.mText = str2;
    }

    public String getmRating() {
        return this.mRating;
    }

    public String getmText() {
        return this.mText;
    }
}
