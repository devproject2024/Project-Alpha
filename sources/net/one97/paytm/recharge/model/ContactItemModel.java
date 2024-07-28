package net.one97.paytm.recharge.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class ContactItemModel implements IJRDataModel {
    private boolean mIsHeading;
    private String mName;
    private String mPhnNo;
    private String mPhotoUri;

    public ContactItemModel(String str, String str2, String str3, boolean z) {
        this.mName = str;
        this.mPhnNo = str2;
        this.mPhotoUri = str3;
        this.mIsHeading = z;
    }

    public String getName() {
        return this.mName;
    }

    public void setmName(String str) {
        this.mName = str;
    }

    public String getPhnNo() {
        return this.mPhnNo;
    }

    public void setmPhnNo(String str) {
        this.mPhnNo = str;
    }

    public String getPhotoUri() {
        return this.mPhotoUri;
    }

    public void setmPhotoUri(String str) {
        this.mPhotoUri = str;
    }

    public boolean ismIsHeading() {
        return this.mIsHeading;
    }

    public void setmIsHeading(boolean z) {
        this.mIsHeading = z;
    }

    public String toString() {
        String str = this.mName;
        return str != null ? str : "";
    }
}
