package com.bumptech.glide.load;

import androidx.a.a;
import com.bumptech.glide.g.b;
import com.bumptech.glide.load.h;
import java.security.MessageDigest;

public final class i implements g {

    /* renamed from: b  reason: collision with root package name */
    private final a<h<?>, Object> f7270b = new b();

    public final void a(i iVar) {
        this.f7270b.a(iVar.f7270b);
    }

    public final <T> i a(h<T> hVar, T t) {
        this.f7270b.put(hVar, t);
        return this;
    }

    public final <T> T a(h<T> hVar) {
        return this.f7270b.containsKey(hVar) ? this.f7270b.get(hVar) : hVar.f7266a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f7270b.equals(((i) obj).f7270b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7270b.hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f7270b.size(); i2++) {
            h b2 = this.f7270b.b(i2);
            Object c2 = this.f7270b.c(i2);
            h.a<T> aVar = b2.f7267b;
            if (b2.f7269d == null) {
                b2.f7269d = b2.f7268c.getBytes(g.f7264a);
            }
            aVar.a(b2.f7269d, c2, messageDigest);
        }
    }

    public final String toString() {
        return "Options{values=" + this.f7270b + '}';
    }
}
