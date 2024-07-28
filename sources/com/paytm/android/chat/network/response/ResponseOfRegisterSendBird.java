package com.paytm.android.chat.network.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.android.chat.data.models.users.payments.UserInfoByIdsData;
import java.io.Serializable;

public class ResponseOfRegisterSendBird extends ResponseBase implements Serializable {
    private DataOfRegisterSendBird data;

    public DataOfRegisterSendBird getData() {
        return this.data;
    }

    public void setData(DataOfRegisterSendBird dataOfRegisterSendBird) {
        this.data = dataOfRegisterSendBird;
    }

    public String toString() {
        return super.toString() + "->ResponseOfRegister{data=" + this.data + '}';
    }

    public static class DataOfRegisterSendBird {
        @b(a = "avatar")
        private String avatar;
        @b(a = "channelData")
        private String channelData;
        @b(a = "channelUrl")
        private String channelUrl;
        @b(a = "contactMobile")
        private String contactMobile;
        @b(a = "contactName")
        private String contactName;
        @b(a = "contactUserId")
        private String contactUserId;
        @b(a = "pfuser")
        private boolean pfuser;
        @b(a = "userInfoByUserIdResponse")
        private UserInfoByIdsData userInfoByUserIdResponse;

        public String getChannelUrl() {
            return this.channelUrl;
        }

        public void setChannelUrl(String str) {
            this.channelUrl = str;
        }

        public String getContactName() {
            return this.contactName;
        }

        public void setContactName(String str) {
            this.contactName = str;
        }

        public String getContactMobile() {
            return this.contactMobile;
        }

        public void setContactMobile(String str) {
            this.contactMobile = str;
        }

        public boolean isPfuser() {
            return this.pfuser;
        }

        public void setPfuser(boolean z) {
            this.pfuser = z;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public String getContactUserId() {
            return this.contactUserId;
        }

        public void setContactUserId(String str) {
            this.contactUserId = str;
        }

        public String getChannelData() {
            return this.channelData;
        }

        public UserInfoByIdsData getUserInfoByUserIdResponse() {
            return this.userInfoByUserIdResponse;
        }
    }
}
