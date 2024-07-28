package com.google.zxing.client.a;

public final class d extends q {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f40031a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f40032b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40033c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f40034d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f40035e;

    /* renamed from: f  reason: collision with root package name */
    public final String[] f40036f;

    /* renamed from: g  reason: collision with root package name */
    public final String[] f40037g;

    /* renamed from: h  reason: collision with root package name */
    public final String f40038h;

    /* renamed from: i  reason: collision with root package name */
    public final String f40039i;
    public final String[] j;
    public final String[] k;
    public final String l;
    public final String m;
    public final String n;
    public final String[] o;
    public final String[] p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(r.ADDRESSBOOK);
        String[] strArr11 = strArr3;
        String[] strArr12 = strArr4;
        String[] strArr13 = strArr5;
        String[] strArr14 = strArr6;
        String[] strArr15 = strArr7;
        String[] strArr16 = strArr8;
        if (strArr11 != null && strArr12 != null && strArr11.length != strArr12.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        } else if (strArr13 != null && strArr14 != null && strArr13.length != strArr14.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        } else if (strArr15 == null || strArr16 == null || strArr15.length == strArr16.length) {
            this.f40031a = strArr;
            this.f40032b = strArr2;
            this.f40033c = str;
            this.f40034d = strArr11;
            this.f40035e = strArr12;
            this.f40036f = strArr13;
            this.f40037g = strArr14;
            this.f40038h = str2;
            this.f40039i = str3;
            this.j = strArr15;
            this.k = strArr16;
            this.l = str4;
            this.m = str5;
            this.n = str6;
            this.o = strArr9;
            this.p = strArr10;
        } else {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f40031a, sb);
        a(this.f40032b, sb);
        a(this.f40033c, sb);
        a(this.n, sb);
        a(this.l, sb);
        a(this.j, sb);
        a(this.f40034d, sb);
        a(this.f40036f, sb);
        a(this.f40038h, sb);
        a(this.o, sb);
        a(this.m, sb);
        a(this.p, sb);
        a(this.f40039i, sb);
        return sb.toString();
    }
}
