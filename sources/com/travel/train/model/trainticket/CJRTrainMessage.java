package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainMessage extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getMessage() {
        return this.message;
    }
}
