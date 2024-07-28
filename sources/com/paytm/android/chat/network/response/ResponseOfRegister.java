package com.paytm.android.chat.network.response;

import com.google.gson.a.c;
import java.io.Serializable;

public class ResponseOfRegister extends ResponseBase implements Serializable {
    private DataOfRegister data;

    public DataOfRegister getData() {
        return this.data;
    }

    public void setData(DataOfRegister dataOfRegister) {
        this.data = dataOfRegister;
    }

    public String getUserId() {
        if (getData() == null) {
            return null;
        }
        return getData().getUserId();
    }

    public String getAccessToken() {
        if (getData() != null) {
            return getData().getAccessToken();
        }
        return null;
    }

    public String toString() {
        return super.toString() + "->ResponseOfRegister{data=" + this.data + '}';
    }

    public static class DataOfRegister {
        @c(a = "accessToken")
        private String accessToken;
        @c(a = "isFirstTimeUser")
        private boolean isFirstTimeUser;
        @c(a = "siteIdFilter")
        private String siteIdFilter;
        @c(a = "userId")
        private String userId;
        @c(a = "userType")
        private String userType;

        public void setSiteIdFilter(String str) {
            this.siteIdFilter = str;
        }

        public String getSiteIdFilter() {
            return this.siteIdFilter;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setUserId(String str) {
            this.userId = str;
        }

        public String getAccessToken() {
            return this.accessToken;
        }

        public void setAccessToken(String str) {
            this.accessToken = str;
        }

        public String getUserType() {
            return this.userType;
        }

        public boolean isFirstTimeUser() {
            return this.isFirstTimeUser;
        }

        public String toString() {
            return "DataOfRegister{userId=" + this.userId + ", accessToken='" + this.accessToken + '\'' + ", userType='" + this.userType + '\'' + ", isFirstTimeUser='" + this.isFirstTimeUser + '\'' + '}';
        }
    }
}
