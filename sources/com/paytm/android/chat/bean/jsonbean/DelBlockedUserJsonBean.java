package com.paytm.android.chat.bean.jsonbean;

import java.io.Serializable;

public class DelBlockedUserJsonBean implements Serializable {
    private String blockUserId;
    private String userId;

    public String getBlockUserId() {
        return this.blockUserId;
    }

    public void setBlockUserId(String str) {
        this.blockUserId = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "DelBlockedUserJsonBean{blockUserId=" + this.blockUserId + ", userId=" + this.userId + '}';
    }
}
