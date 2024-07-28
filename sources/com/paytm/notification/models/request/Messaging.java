package com.paytm.notification.models.request;

import com.google.gson.a.c;

public final class Messaging {
    @c(a = "fcmToken")
    private String fcmToken;

    public final String getFcmToken() {
        return this.fcmToken;
    }

    public final void setFcmToken(String str) {
        this.fcmToken = str;
    }
}
