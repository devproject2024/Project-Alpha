package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.e;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class aa extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f7107b = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(f7264a);

    /* renamed from: c  reason: collision with root package name */
    private final int f7108c;

    public aa(int i2) {
        this.f7108c = i2;
    }

    /* access modifiers changed from: protected */
    public final Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        return ad.a(bitmap, this.f7108c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aa) || this.f7108c != ((aa) obj).f7108c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return k.b("com.bumptech.glide.load.resource.bitmap.Rotate".hashCode(), k.b(this.f7108c));
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f7107b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f7108c).array());
    }
}
