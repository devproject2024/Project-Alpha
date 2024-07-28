package com.bumptech.glide.f;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;
import java.security.MessageDigest;

public final class d implements g {

    /* renamed from: b  reason: collision with root package name */
    private final Object f6585b;

    public d(Object obj) {
        this.f6585b = j.a(obj, "Argument must not be null");
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f6585b + '}';
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f6585b.equals(((d) obj).f6585b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6585b.hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f6585b.toString().getBytes(f7264a));
    }
}
