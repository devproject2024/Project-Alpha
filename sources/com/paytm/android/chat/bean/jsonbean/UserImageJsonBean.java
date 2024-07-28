package com.paytm.android.chat.bean.jsonbean;

import java.io.Serializable;

public class UserImageJsonBean implements Serializable {
    private int id;
    private String updateTime;
    private String url;
    private int userId;

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i2) {
        this.userId = i2;
    }
}
