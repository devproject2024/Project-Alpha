package com.google.zxing.client.a;

public final class z extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f40081a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40082b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40083c = null;

    public z(String str, String str2) {
        super(r.TEL);
        this.f40081a = str;
        this.f40082b = str2;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(20);
        a(this.f40081a, sb);
        a(this.f40083c, sb);
        return sb.toString();
    }
}
