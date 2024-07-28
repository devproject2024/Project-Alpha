package net.one97.paytm.dynamic.module.creditcard.helper;

import com.google.gson.a.c;

public class UserInfo {
    @c(a = "authorization")
    private String authorization;
    @c(a = "deviceIP")
    private String deviceIP;
    @c(a = "dob")
    private String dob;
    @c(a = "email")
    private String email;
    @c(a = "firstName")
    private String firstName;
    @c(a = "lastName")
    private String lastName;
    @c(a = "mobileNo")
    private String mobileNo;
    @c(a = "sso_token")
    private String sso_token;
    @c(a = "userId")
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getSso_token() {
        return this.sso_token;
    }

    public void setSso_token(String str) {
        this.sso_token = str;
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

    public String getDob() {
        return this.dob;
    }

    public void setDob(String str) {
        this.dob = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public String getAuthorization() {
        return this.authorization;
    }

    public void setAuthorization(String str) {
        this.authorization = str;
    }

    public String getDeviceIP() {
        return this.deviceIP;
    }

    public void setDeviceIP(String str) {
        this.deviceIP = str;
    }
}
