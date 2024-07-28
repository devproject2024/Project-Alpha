package com.paytm.android.chat.contact;

import java.io.Serializable;

public final class a implements Serializable {
    private String mChannelUrl;
    private String mContactId;
    private boolean mIsHeading;
    private String mName;
    private String mPhnNo;
    private String mPhotoUri;

    public a(String str, String str2, String str3, String str4, boolean z) {
        this.mName = str;
        this.mPhnNo = str2;
        this.mPhotoUri = str3;
        this.mContactId = str4;
        this.mIsHeading = z;
    }

    public a(String str, String str2, String str3, String str4) {
        this.mName = str;
        this.mPhnNo = str2;
        this.mPhotoUri = str3;
        this.mChannelUrl = str4;
    }

    public a(String str, String str2, boolean z) {
        this.mName = str;
        this.mPhnNo = str2;
        this.mIsHeading = z;
    }

    public final String getmChannelUrl() {
        return this.mChannelUrl;
    }

    public final void setmChannelUrl(String str) {
        this.mChannelUrl = str;
    }

    public final String getName() {
        return this.mName;
    }

    public final void setmName(String str) {
        this.mName = str;
    }

    public final String getPhnNo() {
        return this.mPhnNo;
    }

    public final void setmPhnNo(String str) {
        this.mPhnNo = str;
    }

    public final String getPhotoUri() {
        return this.mPhotoUri;
    }

    public final void setmPhotoUri(String str) {
        this.mPhotoUri = str;
    }

    public final boolean ismIsHeading() {
        return this.mIsHeading;
    }

    public final void setmIsHeading(boolean z) {
        this.mIsHeading = z;
    }

    public final String getContactId() {
        return this.mContactId;
    }

    public final void setContactId(String str) {
        this.mContactId = str;
    }
}
