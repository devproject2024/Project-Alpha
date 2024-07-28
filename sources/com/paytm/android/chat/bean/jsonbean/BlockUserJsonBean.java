package com.paytm.android.chat.bean.jsonbean;

public class BlockUserJsonBean {
    private String blockUserId;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getBlockUserId() {
        return this.blockUserId;
    }

    public void setBlockUserId(String str) {
        this.blockUserId = str;
    }

    public String toString() {
        return "BlockUserJsonBean{userId=" + this.userId + ", blockUserId=" + this.blockUserId + '}';
    }
}
