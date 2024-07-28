package com.paytm.notification.models.request;

import com.google.gson.a.c;

public final class User {
    @c(a = "id")
    private String id;
    @c(a = "token")
    private String token;

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }
}
