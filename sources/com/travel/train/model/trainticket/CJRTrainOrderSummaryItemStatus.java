package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryItemStatus implements IJRDataModel {
    @b(a = "colour")
    private String colour;
    @b(a = "status")
    private int status;
    @b(a = "status_text")
    private String statusText;

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public String getColour() {
        return this.colour;
    }
}
