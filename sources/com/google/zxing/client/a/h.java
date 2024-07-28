package com.google.zxing.client.a;

public final class h extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f40049a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f40050b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f40051c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40052d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40053e;

    h(String str) {
        this(new String[]{str}, (String[]) null, (String[]) null, (String) null, (String) null);
    }

    h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(r.EMAIL_ADDRESS);
        this.f40049a = strArr;
        this.f40050b = strArr2;
        this.f40051c = strArr3;
        this.f40052d = str;
        this.f40053e = str2;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(30);
        a(this.f40049a, sb);
        a(this.f40050b, sb);
        a(this.f40051c, sb);
        a(this.f40052d, sb);
        a(this.f40053e, sb);
        return sb.toString();
    }
}
