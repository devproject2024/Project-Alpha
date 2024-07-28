package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.a.e;
import java.security.MessageDigest;

public final class l extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f7144b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(f7264a);

    /* access modifiers changed from: protected */
    public final Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        return ad.d(eVar, bitmap, i2, i3);
    }

    public final boolean equals(Object obj) {
        return obj instanceof l;
    }

    public final int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f7144b);
    }
}
