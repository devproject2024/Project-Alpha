package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import org.parceler.Parcel;

@Parcel
public class LoginResponse extends BaseResponse {
    private String gcmId;
    @c(a = "is_app_contact_accessed")
    @a
    private boolean isAppContactAccessed;
    @c(a = "next_screen")
    @a
    private String nextScreen;
    @c(a = "is_she_user")
    @a
    private boolean sheUser;
    @c(a = "token")
    @a
    private String token;
    private long tokenTime;
    private String tokenType;
    @c(a = "user_summary")
    @a
    private UserSummary userSummary;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public UserSummary getUserSummary() {
        return this.userSummary;
    }

    public void setUserSummary(UserSummary userSummary2) {
        this.userSummary = userSummary2;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String str) {
        this.tokenType = str;
    }

    public long getTokenTime() {
        return this.tokenTime;
    }

    public void setTokenTime(long j) {
        this.tokenTime = j;
    }

    public String getNextScreen() {
        return this.nextScreen;
    }

    public void setNextScreen(String str) {
        this.nextScreen = str;
    }

    public String getGcmId() {
        return this.gcmId;
    }

    public void setGcmId(String str) {
        this.gcmId = str;
    }

    public boolean isSheUser() {
        return this.sheUser;
    }

    public void setSheUser(boolean z) {
        this.sheUser = z;
    }

    public boolean isAppContactAccessed() {
        return this.isAppContactAccessed;
    }

    public void setAppContactAccessed(boolean z) {
        this.isAppContactAccessed = z;
    }
}
