package com.google.zxing.client.a;

public final class ah extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f40012a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40013b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40014c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40015d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40016e;

    /* renamed from: f  reason: collision with root package name */
    private final String f40017f;

    /* renamed from: g  reason: collision with root package name */
    private final int f40018g;

    /* renamed from: h  reason: collision with root package name */
    private final char f40019h;

    /* renamed from: i  reason: collision with root package name */
    private final String f40020i;

    public ah(String str, String str2, String str3, String str4, String str5, String str6, int i2, char c2, String str7) {
        super(r.VIN);
        this.f40012a = str;
        this.f40013b = str2;
        this.f40014c = str3;
        this.f40015d = str4;
        this.f40016e = str5;
        this.f40017f = str6;
        this.f40018g = i2;
        this.f40019h = c2;
        this.f40020i = str7;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f40013b);
        sb.append(' ');
        sb.append(this.f40014c);
        sb.append(' ');
        sb.append(this.f40015d);
        sb.append(10);
        String str = this.f40016e;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f40018g);
        sb.append(' ');
        sb.append(this.f40019h);
        sb.append(' ');
        sb.append(this.f40020i);
        sb.append(10);
        return sb.toString();
    }
}
