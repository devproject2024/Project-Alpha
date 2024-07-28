package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.j;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.e;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class ab extends f {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f7109b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(f7264a);

    /* renamed from: c  reason: collision with root package name */
    private final int f7110c;

    public ab(int i2) {
        j.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f7110c = i2;
    }

    /* access modifiers changed from: protected */
    public final Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3) {
        return ad.b(eVar, bitmap, this.f7110c);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ab) || this.f7110c != ((ab) obj).f7110c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return k.b("com.bumptech.glide.load.resource.bitmap.RoundedCorners".hashCode(), k.b(this.f7110c));
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f7109b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f7110c).array());
    }
}
