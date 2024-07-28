package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRProfilePic extends IJRPaytmDataModel {
    @b(a = "message")
    private String mMessage;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "status")
    private String mStatus;
    @b(a = "userId")
    private String mUserID;
    @b(a = "userPicture")
    private String mUserPicture;

    public String getUserID() {
        return this.mUserID;
    }

    public String getUserPicture() {
        return this.mUserPicture;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }
}
