package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TravelPassPromoOffers extends IJRPaytmDataModel {
    @b(a = "code")
    private int code;
    @b(a = "body")
    private CJROffersData mOffersData;
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public CJROffersData getBody() {
        return this.mOffersData;
    }

    public void setmOffers(CJROffersData cJROffersData) {
        this.mOffersData = cJROffersData;
    }
}
