package com.google.zxing.client.a;

public final class w extends q {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f40077a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40078b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40079c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f40080d;

    public w(String str, String str2) {
        super(r.SMS);
        this.f40077a = new String[]{str};
        this.f40080d = new String[]{null};
        this.f40078b = null;
        this.f40079c = str2;
    }

    public w(String[] strArr, String[] strArr2, String str, String str2) {
        super(r.SMS);
        this.f40077a = strArr;
        this.f40080d = strArr2;
        this.f40078b = str;
        this.f40079c = str2;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f40077a, sb);
        a(this.f40078b, sb);
        a(this.f40079c, sb);
        return sb.toString();
    }
}
