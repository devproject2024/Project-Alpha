package com.bumptech.glide.load.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.b;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.e;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;

public final class f implements m<c> {

    /* renamed from: b  reason: collision with root package name */
    private final m<Bitmap> f7224b;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.m<android.graphics.Bitmap>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.bumptech.glide.load.m<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Argument must not be null"
            java.lang.Object r2 = com.bumptech.glide.g.j.a(r2, (java.lang.String) r0)
            com.bumptech.glide.load.m r2 = (com.bumptech.glide.load.m) r2
            r1.f7224b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.e.f.<init>(com.bumptech.glide.load.m):void");
    }

    public final v<c> transform(Context context, v<c> vVar, int i2, int i3) {
        c b2 = vVar.b();
        e eVar = new e(b2.a(), b.a(context).f6425a);
        v<Bitmap> transform = this.f7224b.transform(context, eVar, i2, i3);
        if (!eVar.equals(transform)) {
            eVar.d();
        }
        m<Bitmap> mVar = this.f7224b;
        b2.f7214a.f7223a.a(mVar, transform.b());
        return vVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f7224b.equals(((f) obj).f7224b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7224b.hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f7224b.updateDiskCacheKey(messageDigest);
    }
}
