package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainStripHomeModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "label")
    private String label;
    @b(a = "tip_colour")
    private String mTipColor;
    @b(a = "tip_text")
    private String mTipText;
    @b(a = "urlParams")
    private CJRTrainStripHomeModelURLParams urlParams;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public CJRTrainStripHomeModelURLParams getUrlParams() {
        return this.urlParams;
    }

    public void setUrlParams(CJRTrainStripHomeModelURLParams cJRTrainStripHomeModelURLParams) {
        this.urlParams = cJRTrainStripHomeModelURLParams;
    }

    public String getmTipText() {
        return this.mTipText;
    }

    public String getmTipColor() {
        return this.mTipColor;
    }
}
