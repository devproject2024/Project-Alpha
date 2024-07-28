package com.google.zxing.client.a;

import java.util.Map;

public final class k extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f40056a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40057b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40058c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40059d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40060e;

    /* renamed from: f  reason: collision with root package name */
    private final String f40061f;

    /* renamed from: g  reason: collision with root package name */
    private final String f40062g;

    /* renamed from: h  reason: collision with root package name */
    private final String f40063h;

    /* renamed from: i  reason: collision with root package name */
    private final String f40064i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final Map<String, String> o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(r.PRODUCT);
        this.f40056a = str;
        this.f40057b = str2;
        this.f40058c = str3;
        this.f40059d = str4;
        this.f40060e = str5;
        this.f40061f = str6;
        this.f40062g = str7;
        this.f40063h = str8;
        this.f40064i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.o = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!a(this.f40057b, kVar.f40057b) || !a(this.f40058c, kVar.f40058c) || !a(this.f40059d, kVar.f40059d) || !a(this.f40060e, kVar.f40060e) || !a(this.f40062g, kVar.f40062g) || !a(this.f40063h, kVar.f40063h) || !a(this.f40064i, kVar.f40064i) || !a(this.j, kVar.j) || !a(this.k, kVar.k) || !a(this.l, kVar.l) || !a(this.m, kVar.m) || !a(this.n, kVar.n) || !a(this.o, kVar.o)) {
            return false;
        }
        return true;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final int hashCode() {
        return ((((((((((((a(this.f40057b) ^ 0) ^ a(this.f40058c)) ^ a(this.f40059d)) ^ a(this.f40060e)) ^ a(this.f40062g)) ^ a(this.f40063h)) ^ a(this.f40064i)) ^ a(this.j)) ^ a(this.k)) ^ a(this.l)) ^ a(this.m)) ^ a(this.n)) ^ a(this.o);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String a() {
        return String.valueOf(this.f40056a);
    }
}
