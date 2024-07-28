package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromoMessageModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "messages")
    private ArrayList<CJRTrainPromoMessage> promoMessages;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRTrainPromoMessage> getPromoMessages() {
        return this.promoMessages;
    }
}
