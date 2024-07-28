package com.bumptech.glide.load.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;
import java.util.Map;

final class n implements g {

    /* renamed from: b  reason: collision with root package name */
    private final Object f6922b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6923c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6924d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f6925e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f6926f;

    /* renamed from: g  reason: collision with root package name */
    private final g f6927g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, m<?>> f6928h;

    /* renamed from: i  reason: collision with root package name */
    private final i f6929i;
    private int j;

    n(Object obj, g gVar, int i2, int i3, Map<Class<?>, m<?>> map, Class<?> cls, Class<?> cls2, i iVar) {
        this.f6922b = j.a(obj, "Argument must not be null");
        this.f6927g = (g) j.a(gVar, "Signature must not be null");
        this.f6923c = i2;
        this.f6924d = i3;
        this.f6928h = (Map) j.a(map, "Argument must not be null");
        this.f6925e = (Class) j.a(cls, "Resource class must not be null");
        this.f6926f = (Class) j.a(cls2, "Transcode class must not be null");
        this.f6929i = (i) j.a(iVar, "Argument must not be null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (!this.f6922b.equals(nVar.f6922b) || !this.f6927g.equals(nVar.f6927g) || this.f6924d != nVar.f6924d || this.f6923c != nVar.f6923c || !this.f6928h.equals(nVar.f6928h) || !this.f6925e.equals(nVar.f6925e) || !this.f6926f.equals(nVar.f6926f) || !this.f6929i.equals(nVar.f6929i)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.j == 0) {
            this.j = this.f6922b.hashCode();
            this.j = (this.j * 31) + this.f6927g.hashCode();
            this.j = (this.j * 31) + this.f6923c;
            this.j = (this.j * 31) + this.f6924d;
            this.j = (this.j * 31) + this.f6928h.hashCode();
            this.j = (this.j * 31) + this.f6925e.hashCode();
            this.j = (this.j * 31) + this.f6926f.hashCode();
            this.j = (this.j * 31) + this.f6929i.hashCode();
        }
        return this.j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f6922b + ", width=" + this.f6923c + ", height=" + this.f6924d + ", resourceClass=" + this.f6925e + ", transcodeClass=" + this.f6926f + ", signature=" + this.f6927g + ", hashCode=" + this.j + ", transformations=" + this.f6928h + ", options=" + this.f6929i + '}';
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
