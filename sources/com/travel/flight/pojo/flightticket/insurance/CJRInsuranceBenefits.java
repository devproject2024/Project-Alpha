package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsuranceBenefits implements IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "img_url")
    private String imgUrl;
    @b(a = "text")
    private String text;
    @b(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getAmount() {
        return this.amount;
    }
}
