package com.business.common_module.c;

import com.google.gson.a.c;

public final class a {
    @c(a = "verticalName")
    @com.google.gson.a.a

    /* renamed from: a  reason: collision with root package name */
    public String f7327a;
    @c(a = "screenName")
    @com.google.gson.a.a

    /* renamed from: b  reason: collision with root package name */
    public String f7328b;
    @c(a = "uri")
    @com.google.gson.a.a

    /* renamed from: c  reason: collision with root package name */
    public String f7329c;
    @c(a = "requestSize")
    @com.google.gson.a.a

    /* renamed from: d  reason: collision with root package name */
    public long f7330d;
    @c(a = "responseCode")
    @com.google.gson.a.a

    /* renamed from: e  reason: collision with root package name */
    public int f7331e;
    @c(a = "responseTime")
    @com.google.gson.a.a

    /* renamed from: f  reason: collision with root package name */
    public long f7332f;
    @c(a = "responseSize")
    @com.google.gson.a.a

    /* renamed from: g  reason: collision with root package name */
    public long f7333g;
    @c(a = "errorCode")
    @com.google.gson.a.a

    /* renamed from: h  reason: collision with root package name */
    public int f7334h;
    @c(a = "errorMsg")
    @com.google.gson.a.a

    /* renamed from: i  reason: collision with root package name */
    public String f7335i;
    @c(a = "x-app-rid")
    @com.google.gson.a.a
    public String j;
    @c(a = "eventType")
    @com.google.gson.a.a
    private String k;
    @c(a = "customMessage")
    @com.google.gson.a.a
    private String l;

    public final void a(String str) {
        this.k = str;
    }

    public final void b(String str) {
        this.f7329c = str;
    }

    public final void c(String str) {
        this.f7335i = str;
    }

    public final void d(String str) {
        this.l = str.substring(0, Math.min(str.length(), 1023));
    }
}
