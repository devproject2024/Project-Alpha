package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.a.e;
import java.security.MessageDigest;

public final class k extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f7143b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(f7264a);

    /* access modifiers changed from: protected */
    public final Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        return ad.c(eVar, bitmap, i2, i3);
    }

    public final boolean equals(Object obj) {
        return obj instanceof k;
    }

    public final int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterInside".hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f7143b);
    }
}
