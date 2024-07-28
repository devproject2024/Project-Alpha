package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCancellationItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "layout_type")
    private String layoutType;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLayoutType() {
        return this.layoutType;
    }
}
