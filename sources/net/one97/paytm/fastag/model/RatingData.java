package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class RatingData extends IJRPaytmDataModel {
    @b(a = "rating")
    private String mIRatingData;
    @b(a = "text")
    private String mText;
}
