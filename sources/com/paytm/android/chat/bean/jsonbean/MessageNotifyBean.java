package com.paytm.android.chat.bean.jsonbean;

public class MessageNotifyBean {
    public String channelUrl;
    public String contactMobile;

    public MessageNotifyBean(String str, String str2) {
        this.channelUrl = str;
        this.contactMobile = str2;
    }
}
