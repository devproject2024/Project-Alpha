package com.squareup.a;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f33751a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33752b;

    public a(String str, String str2) {
        if (str.length() != 0) {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            this.f33751a = str;
            this.f33752b = str2;
            return;
        }
        throw new IllegalArgumentException("Host must not be blank.");
    }

    public final b a(String str) {
        if (str != null && str.length() != 0) {
            return new b(this.f33751a, this.f33752b, str);
        }
        throw new IllegalArgumentException("Invalid image.");
    }
}
