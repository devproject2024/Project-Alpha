package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;

public final class q implements m<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final m<Bitmap> f7169b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7170c;

    public q(m<Bitmap> mVar, boolean z) {
        this.f7169b = mVar;
        this.f7170c = z;
    }

    public final v<Drawable> transform(Context context, v<Drawable> vVar, int i2, int i3) {
        e eVar = b.a(context).f6425a;
        Drawable b2 = vVar.b();
        v<Bitmap> a2 = p.a(eVar, b2, i2, i3);
        if (a2 != null) {
            v<Bitmap> transform = this.f7169b.transform(context, a2, i2, i3);
            if (!transform.equals(a2)) {
                return w.a(context.getResources(), transform);
            }
            transform.d();
            return vVar;
        } else if (!this.f7170c) {
            return vVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + b2 + " to a Bitmap");
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            return this.f7169b.equals(((q) obj).f7169b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7169b.hashCode();
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f7169b.updateDiskCacheKey(messageDigest);
    }
}
