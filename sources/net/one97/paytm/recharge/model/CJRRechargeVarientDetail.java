package net.one97.paytm.recharge.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeVarientDetail implements IJRDataModel {
    private String mGroupName;
    private String mImageURL;

    public String getImageURL() {
        return this.mImageURL;
    }

    public void setImageURL(String str) {
        this.mImageURL = str;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }
}
