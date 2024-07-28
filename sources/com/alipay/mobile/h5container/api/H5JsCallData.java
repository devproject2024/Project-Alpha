package com.alipay.mobile.h5container.api;

import android.text.TextUtils;

public class H5JsCallData {
    private String action;
    private long elapse;
    private String joMsg;

    private H5JsCallData(Builder builder) {
        this.action = builder.action;
        this.elapse = builder.elapse;
        this.joMsg = builder.joMsg;
    }

    public String getAction() {
        return this.action;
    }

    public long getElapse() {
        return this.elapse;
    }

    public String getJoMsg() {
        return this.joMsg;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String action = "";
        /* access modifiers changed from: private */
        public long elapse = 0;
        /* access modifiers changed from: private */
        public String joMsg = "";

        public Builder setAction(String str) {
            this.action = str;
            return this;
        }

        public Builder setElapse(long j) {
            this.elapse = j;
            return this;
        }

        public Builder setJoMsg(String str) {
            this.joMsg = H5JsCallData.getAvailableJoMsg(str);
            return this;
        }

        public H5JsCallData build() {
            return new H5JsCallData(this);
        }
    }

    /* access modifiers changed from: private */
    public static String getAvailableJoMsg(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 500) ? str : str.substring(0, 500);
    }
}
