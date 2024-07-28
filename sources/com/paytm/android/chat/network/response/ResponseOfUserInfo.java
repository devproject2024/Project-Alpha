package com.paytm.android.chat.network.response;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class ResponseOfUserInfo extends ResponseBase implements Serializable {
    private DataOfRegister data;

    public DataOfRegister getData() {
        return this.data;
    }

    public void setData(DataOfRegister dataOfRegister) {
        this.data = dataOfRegister;
    }

    public static class DataOfRegister {
        private String accessToken;
        private String avatar;
        private long birthday;
        @b(a = "id")
        private long id;
        private String sex;
        private String userName;

        public long getId() {
            return this.id;
        }

        public void setId(long j) {
            this.id = j;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public String getSex() {
            return this.sex;
        }

        public void setSex(String str) {
            this.sex = str;
        }

        public long getBirthday() {
            return this.birthday;
        }

        public void setBirthday(long j) {
            this.birthday = j;
        }

        public String getAccessToken() {
            return this.accessToken;
        }

        public void setAccessToken(String str) {
            this.accessToken = str;
        }

        public String toString() {
            return "DataOfRegister{id=" + this.id + ", avatar='" + this.avatar + '\'' + ", userName='" + this.userName + '\'' + ", sex='" + this.sex + '\'' + ", birthday=" + this.birthday + ", accessToken='" + this.accessToken + '\'' + '}';
        }
    }
}
