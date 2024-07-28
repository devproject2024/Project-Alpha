package com.bumptech.glide.load.d;

import android.content.Context;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.m;
import java.security.MessageDigest;

public final class c<T> implements m<T> {

    /* renamed from: b  reason: collision with root package name */
    private static final m<?> f7200b = new c();

    public final v<T> transform(Context context, v<T> vVar, int i2, int i3) {
        return vVar;
    }

    public final void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public static <T> c<T> a() {
        return (c) f7200b;
    }

    private c() {
    }
}
