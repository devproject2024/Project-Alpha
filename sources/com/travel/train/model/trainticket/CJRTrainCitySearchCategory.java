package com.travel.train.model.trainticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCitySearchCategory implements IJRDataModel {
    private String mCategoryTitle;

    public String getCategoryTitle() {
        return this.mCategoryTitle;
    }

    public void setmCategoryTitle(String str) {
        this.mCategoryTitle = str;
    }
}
