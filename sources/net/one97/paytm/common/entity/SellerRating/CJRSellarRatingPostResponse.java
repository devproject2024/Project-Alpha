package net.one97.paytm.common.entity.SellerRating;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSellarRatingPostResponse extends IJRPaytmDataModel {
    @b(a = "message")
    private String mSuccessMessage;

    public String getSuccessMessage() {
        return this.mSuccessMessage;
    }

    public void setSuccessMessage(String str) {
        this.mSuccessMessage = str;
    }
}
