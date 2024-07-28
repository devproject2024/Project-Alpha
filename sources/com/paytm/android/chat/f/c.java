package com.paytm.android.chat.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.b;
import com.bumptech.glide.e.h;
import com.bumptech.glide.f;
import com.bumptech.glide.f.d;
import com.bumptech.glide.load.g;
import com.zhihu.matisse.b.a;

public final class c implements a {
    public final void a(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri) {
        b.b(context).d().b((Object) uri).b((com.bumptech.glide.e.a<?>) ((h) ((h) new h().a(i2, i2)).b(drawable)).f()).a(imageView);
    }

    public final void b(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri) {
        b.b(context).d().b((Object) uri).b((com.bumptech.glide.e.a<?>) ((h) ((h) new h().a(i2, i2)).b(drawable)).f()).a(imageView);
    }

    public final void a(Context context, int i2, int i3, ImageView imageView, Uri uri) {
        b.b(context).a(uri).b((com.bumptech.glide.e.a<?>) ((h) ((h) new h().a(i2, i3)).a(f.HIGH)).g()).b((com.bumptech.glide.e.a<?>) new h().a((g) new d(Long.valueOf(System.currentTimeMillis())))).a(imageView);
    }

    public final void b(Context context, int i2, int i3, ImageView imageView, Uri uri) {
        b.b(context).e().b((Object) uri).b((com.bumptech.glide.e.a<?>) ((h) ((h) new h().a(i2, i3)).a(f.HIGH)).g()).a(imageView);
    }
}
