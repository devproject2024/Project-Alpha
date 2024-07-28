package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTicketStatusGuideTemplate extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "description")
    private String description;
    @a
    @b(a = "layout_type")
    private String layout_type;
    @a
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public String getLayout_type() {
        return this.layout_type;
    }

    public String getDescription() {
        return this.description;
    }
}
