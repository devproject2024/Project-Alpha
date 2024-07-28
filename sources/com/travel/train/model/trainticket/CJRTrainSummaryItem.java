package com.travel.train.model.trainticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainSummaryItem implements IJRDataModel {
    private boolean isFromPayment = true;
    private IJRDataModel item;
    private String layoutType;
    private IJRDataModel metaItem;

    public void setLayoutType(String str) {
        this.layoutType = str;
    }

    public void setItem(IJRDataModel iJRDataModel) {
        this.item = iJRDataModel;
    }

    public void setMetaItem(IJRDataModel iJRDataModel) {
        this.metaItem = iJRDataModel;
    }

    public String getLayoutType() {
        return this.layoutType;
    }

    public IJRDataModel getItem() {
        return this.item;
    }

    public IJRDataModel getMetaItem() {
        return this.metaItem;
    }

    public boolean isFromPayment() {
        return this.isFromPayment;
    }
}
