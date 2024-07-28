package com.travel.travels.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferralGetCodeContentBody extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "book")
    private String book;
    @c(a = "cashback")
    private String cashback;
    @c(a = "copytext")
    private String copytext;
    @c(a = "invite")
    private String invite;

    public String getCopytext() {
        return this.copytext;
    }

    public void setCopytext(String str) {
        this.copytext = str;
    }

    public String getInvite() {
        return this.invite;
    }

    public void setInvite(String str) {
        this.invite = str;
    }

    public String getBook() {
        return this.book;
    }

    public void setBook(String str) {
        this.book = str;
    }

    public String getCashback() {
        return this.cashback;
    }

    public void setCashback(String str) {
        this.cashback = str;
    }
}
