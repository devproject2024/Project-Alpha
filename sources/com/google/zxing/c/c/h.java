package com.google.zxing.c.c;

import com.google.zxing.f;
import java.nio.charset.StandardCharsets;

final class h {

    /* renamed from: a  reason: collision with root package name */
    final String f39974a;

    /* renamed from: b  reason: collision with root package name */
    l f39975b;

    /* renamed from: c  reason: collision with root package name */
    f f39976c;

    /* renamed from: d  reason: collision with root package name */
    f f39977d;

    /* renamed from: e  reason: collision with root package name */
    final StringBuilder f39978e;

    /* renamed from: f  reason: collision with root package name */
    int f39979f;

    /* renamed from: g  reason: collision with root package name */
    int f39980g;

    /* renamed from: h  reason: collision with root package name */
    k f39981h;

    /* renamed from: i  reason: collision with root package name */
    int f39982i;

    h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i2 = 0;
        while (i2 < length) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 != '?' || str.charAt(i2) == '?') {
                sb.append(c2);
                i2++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.f39974a = sb.toString();
        this.f39975b = l.FORCE_NONE;
        this.f39978e = new StringBuilder(str.length());
        this.f39980g = -1;
    }

    public final char a() {
        return this.f39974a.charAt(this.f39979f);
    }

    public final void a(String str) {
        this.f39978e.append(str);
    }

    public final void a(char c2) {
        this.f39978e.append(c2);
    }

    public final boolean b() {
        return this.f39979f < e();
    }

    private int e() {
        return this.f39974a.length() - this.f39982i;
    }

    public final int c() {
        return e() - this.f39979f;
    }

    public final void a(int i2) {
        k kVar = this.f39981h;
        if (kVar == null || i2 > kVar.f39989b) {
            this.f39981h = k.a(i2, this.f39975b, this.f39976c, this.f39977d);
        }
    }

    public final void d() {
        a(this.f39978e.length());
    }
}
