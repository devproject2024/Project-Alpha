package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.a.e;
import java.security.MessageDigest;

public final class s extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f7171b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(f7264a);

    /* access modifiers changed from: protected */
    public final Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        return ad.b(eVar, bitmap, i2, i3);
    }

    public final boolean equals(Object obj) {
        return obj instanceof s;
    }

    public final int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f7171b);
    }
}
