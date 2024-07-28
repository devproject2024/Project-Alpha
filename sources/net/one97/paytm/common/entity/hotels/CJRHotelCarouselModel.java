package net.one97.paytm.common.entity.hotels;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRHotelCarouselModel extends IJRPaytmDataModel {
    @b(a = "data")
    private CJRCarouselData mCarouselData;
    @b(a = "code")
    private int mCode;
    @b(a = "message")
    private String mMessage;

    public String getMessage() {
        return this.mMessage;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public int getCode() {
        return this.mCode;
    }

    public void setCode(int i2) {
        this.mCode = i2;
    }

    public CJRCarouselData getCarouselData() {
        return this.mCarouselData;
    }

    public void setCarouselData(CJRCarouselData cJRCarouselData) {
        this.mCarouselData = cJRCarouselData;
    }
}
