package com.google.firebase.crashlytics.a.f;

import okhttp3.Headers;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public int f38580a;

    /* renamed from: b  reason: collision with root package name */
    public String f38581b;

    /* renamed from: c  reason: collision with root package name */
    private Headers f38582c;

    d(int i2, String str, Headers headers) {
        this.f38580a = i2;
        this.f38581b = str;
        this.f38582c = headers;
    }

    public final String a(String str) {
        return this.f38582c.get(str);
    }
}
