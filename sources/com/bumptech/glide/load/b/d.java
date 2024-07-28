package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import java.security.MessageDigest;

final class d implements g {

    /* renamed from: b  reason: collision with root package name */
    private final g f6836b;

    /* renamed from: c  reason: collision with root package name */
    private final g f6837c;

    d(g gVar, g gVar2) {
        this.f6836b = gVar;
        this.f6837c = gVar2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (!this.f6836b.equals(dVar.f6836b) || !this.f6837c.equals(dVar.f6837c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f6836b.hashCode() * 31) + this.f6837c.hashCode();
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f6836b + ", signature=" + this.f6837c + '}';
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f6836b.updateDiskCacheKey(messageDigest);
        this.f6837c.updateDiskCacheKey(messageDigest);
    }
}
