package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryFooter extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "header")
    private String header;

    public String getHeader() {
        return this.header;
    }

    public String getDescription() {
        return this.description;
    }
}
