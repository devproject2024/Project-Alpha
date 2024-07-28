package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRUserSocialInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "authToken")
    private String mAuthToken;
    @b(a = "picture")
    private String mImageUrl;
    @b(a = "type")
    private String mType;
    @b(a = "userId")
    private String mUserId;
    @b(a = "username")
    private String mUserName;

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getType() {
        return this.mType;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getAuthToken() {
        return this.mAuthToken;
    }

    public String getUserId() {
        return this.mUserId;
    }
}
