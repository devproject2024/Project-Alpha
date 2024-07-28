package com.bumptech.glide.load.c;

import com.bumptech.glide.g.j;
import java.net.URL;
import java.security.MessageDigest;

public class g implements com.bumptech.glide.load.g {

    /* renamed from: b  reason: collision with root package name */
    public final h f7025b;

    /* renamed from: c  reason: collision with root package name */
    public final URL f7026c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7027d;

    /* renamed from: e  reason: collision with root package name */
    public String f7028e;

    /* renamed from: f  reason: collision with root package name */
    public URL f7029f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f7030g;

    /* renamed from: h  reason: collision with root package name */
    private int f7031h;

    public g(URL url) {
        this(url, h.f7033b);
    }

    public g(String str) {
        this(str, h.f7033b);
    }

    private g(URL url, h hVar) {
        this.f7026c = (URL) j.a(url, "Argument must not be null");
        this.f7027d = null;
        this.f7025b = (h) j.a(hVar, "Argument must not be null");
    }

    private g(String str, h hVar) {
        this.f7026c = null;
        this.f7027d = j.a(str);
        this.f7025b = (h) j.a(hVar, "Argument must not be null");
    }

    private String a() {
        String str = this.f7027d;
        if (str != null) {
            return str;
        }
        return ((URL) j.a(this.f7026c, "Argument must not be null")).toString();
    }

    public String toString() {
        return a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (!a().equals(gVar.a()) || !this.f7025b.equals(gVar.f7025b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f7031h == 0) {
            this.f7031h = a().hashCode();
            this.f7031h = (this.f7031h * 31) + this.f7025b.hashCode();
        }
        return this.f7031h;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        if (this.f7030g == null) {
            this.f7030g = a().getBytes(f7264a);
        }
        messageDigest.update(this.f7030g);
    }
}
