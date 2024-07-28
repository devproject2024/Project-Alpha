package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromoMessage extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }
}
