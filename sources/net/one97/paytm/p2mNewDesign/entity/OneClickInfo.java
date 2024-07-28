package net.one97.paytm.p2mNewDesign.entity;

import net.one97.paytm.common.entity.IJRDataModel;

public class OneClickInfo implements IJRDataModel {
    private String cardAlias;
    private String oneClickToken;

    public String getOneClickToken() {
        return this.oneClickToken;
    }

    public void setOneClickToken(String str) {
        this.oneClickToken = str;
    }

    public String getCardAlias() {
        return this.cardAlias;
    }

    public void setCardAlias(String str) {
        this.cardAlias = str;
    }
}
