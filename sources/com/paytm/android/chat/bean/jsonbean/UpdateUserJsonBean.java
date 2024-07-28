package com.paytm.android.chat.bean.jsonbean;

import java.io.Serializable;

public class UpdateUserJsonBean implements Serializable {
    private String avatar;
    private String mobile;
    private String sex;
    private String userId;
    private String userName;

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setSex(String str) {
        this.sex = str;
    }
}
