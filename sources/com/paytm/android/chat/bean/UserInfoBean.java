package com.paytm.android.chat.bean;

import java.io.Serializable;

public class UserInfoBean implements Serializable {
    private String accessToken;
    private String nickname;
    private String phoneNumber;
    private String profileUrl;
    private String token;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public void setProfileUrl(String str) {
        this.profileUrl = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String toString() {
        return "UserInfoBean{userId='" + this.userId + '\'' + ", nickname='" + this.nickname + '\'' + ", profileUrl='" + this.profileUrl + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + ", token='" + this.token + '\'' + ", accessToken='" + this.accessToken + '\'' + '}';
    }
}
