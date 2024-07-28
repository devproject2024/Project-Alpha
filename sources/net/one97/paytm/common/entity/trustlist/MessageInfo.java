package net.one97.paytm.common.entity.trustlist;

import java.io.Serializable;

public class MessageInfo implements Serializable {
    private String mBody;
    private String mSender;
    private String mTime;

    public MessageInfo(String str, String str2, String str3) {
        this.mTime = str;
        this.mBody = str2;
        this.mSender = str3;
    }

    public MessageInfo() {
    }

    public String getTime() {
        return this.mTime;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    public String getBody() {
        return this.mBody;
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public String getSender() {
        return this.mSender;
    }

    public void setSender(String str) {
        this.mSender = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MessageInfo) {
            return ((MessageInfo) obj).getBody().equals(this.mBody);
        }
        return false;
    }
}
