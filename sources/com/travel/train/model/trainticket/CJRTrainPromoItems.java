package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromoItems extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cashback")
    private String cashback;
    @b(a = "cashback_status")
    private int cashbackStatus;
    @b(a = "pax_name")
    private String paxName;
    @b(a = "text")
    private String text;

    public String getPaxName() {
        return this.paxName;
    }

    public String getCashback() {
        return this.cashback;
    }

    public String getText() {
        return this.text;
    }

    public int getCashbackStatus() {
        return this.cashbackStatus;
    }
}
