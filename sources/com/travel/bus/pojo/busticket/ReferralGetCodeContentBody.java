package com.travel.bus.pojo.busticket;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferralGetCodeContentBody extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "book")
    private String book;
    @c(a = "cashback")
    private String cashback;
    @c(a = "invite")
    private String invite;

    public String getInvite() {
        return this.invite;
    }

    public String getBook() {
        return this.book;
    }

    public String getCashback() {
        return this.cashback;
    }
}
