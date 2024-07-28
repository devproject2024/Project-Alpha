package com.travel.train.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRTrainResendTicketResponse extends IJRPaytmDataModel {
    @b(a = "message")
    private String message;
    @b(a = "title")
    public String title;

    public String getTitle() {
        return this.title;
    }

    public String getMessage() {
        return this.message;
    }
}
