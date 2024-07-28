package com.alipay.mobile.rome.syncsdk.c;

import java.io.Serializable;

public final class a implements Serializable {
    private static final long serialVersionUID = 1;
    private String msgData;
    private String msgKey;
    private String msgTimestamp;
    private String perMsgId;
    private String userId;

    public a() {
        this.msgData = "";
        this.userId = "";
        this.userId = "";
        this.msgData = "";
        this.msgKey = "";
        this.msgTimestamp = "";
        this.perMsgId = "";
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final String getMsgData() {
        return this.msgData;
    }

    public final void setMsgData(String str) {
        this.msgData = str;
    }

    public final String getMsgKey() {
        return this.msgKey;
    }

    public final void setMsgKey(String str) {
        this.msgKey = str;
    }

    public final String getTimestamp() {
        return this.msgTimestamp;
    }

    public final void setTimestamp(String str) {
        this.msgTimestamp = str;
    }

    public final String getPerMsgId() {
        return this.perMsgId;
    }

    public final void setPerMsgId(String str) {
        this.perMsgId = str;
    }
}
