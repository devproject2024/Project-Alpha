package com.bumptech.glide.f;

import android.content.Context;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.g;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class a implements g {

    /* renamed from: b  reason: collision with root package name */
    private final int f6581b;

    /* renamed from: c  reason: collision with root package name */
    private final g f6582c;

    public static g a(Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.a(context));
    }

    private a(int i2, g gVar) {
        this.f6581b = i2;
        this.f6582c = gVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f6581b != aVar.f6581b || !this.f6582c.equals(aVar.f6582c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return k.a((Object) this.f6582c, this.f6581b);
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f6582c.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f6581b).array());
    }
}
