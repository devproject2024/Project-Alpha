package com.google.zxing.client.a;

public final class aj extends q {

    /* renamed from: a  reason: collision with root package name */
    public final String f40023a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40024b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40025c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f40026d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40027e;

    /* renamed from: f  reason: collision with root package name */
    private final String f40028f;

    /* renamed from: g  reason: collision with root package name */
    private final String f40029g;

    /* renamed from: h  reason: collision with root package name */
    private final String f40030h;

    public aj(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        super(r.WIFI);
        this.f40023a = str2;
        this.f40024b = str;
        this.f40025c = str3;
        this.f40026d = z;
        this.f40027e = str4;
        this.f40028f = str5;
        this.f40029g = str6;
        this.f40030h = str7;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(80);
        a(this.f40023a, sb);
        a(this.f40024b, sb);
        a(this.f40025c, sb);
        a(Boolean.toString(this.f40026d), sb);
        return sb.toString();
    }
}
