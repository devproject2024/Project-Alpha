package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuota extends IJRPaytmDataModel implements IJRDataModel {
    private boolean mIsSelected;
    private String mQuotaCode;
    private String mQuotaName;

    public String getQuotaCode() {
        return this.mQuotaCode;
    }

    public void setQuotaCode(String str) {
        this.mQuotaCode = str;
    }

    public String getQuotaName() {
        return this.mQuotaName;
    }

    public void setQuotaName(String str) {
        this.mQuotaName = str;
    }

    public boolean isIsSelected() {
        return this.mIsSelected;
    }

    public void setIsSelected(boolean z) {
        this.mIsSelected = z;
    }
}
