package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.google.gson.a.a;
import com.google.gson.a.c;
import org.parceler.Parcel;

@Parcel
public class UserSummary {
    @c(a = "user_app_invite_url")
    private String appShareUrl;
    @c(a = "email_id")
    @a
    private String emailId;
    @c(a = "first_name")
    @a
    private String firstName;
    @c(a = "last_name")
    @a
    private String lastName;
    @c(a = "mobile")
    @a
    private String mobile;
    @c(a = "photo_url")
    @a
    private String photoUrl;
    @c(a = "user_details")
    @a
    private UserBO userBO;
    @c(a = "user_id")
    @a
    private long userId;

    public String getAppShareUrl() {
        return this.appShareUrl;
    }

    public void setAppShareUrl(String str) {
        this.appShareUrl = str;
    }

    public Long getUserId() {
        return Long.valueOf(this.userId);
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String str) {
        this.emailId = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String str) {
        this.photoUrl = str;
    }

    public UserBO getUserBO() {
        return this.userBO;
    }

    public void setUserBO(UserBO userBO2) {
        this.userBO = userBO2;
    }
}
