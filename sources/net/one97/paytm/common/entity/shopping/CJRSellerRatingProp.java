package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.CJRDataModelItem;

public class CJRSellerRatingProp extends CJRDataModelItem {
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
