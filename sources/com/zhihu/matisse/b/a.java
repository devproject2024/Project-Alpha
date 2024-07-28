package com.zhihu.matisse.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

public interface a {
    void a(Context context, int i2, int i3, ImageView imageView, Uri uri);

    void a(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri);

    void b(Context context, int i2, int i3, ImageView imageView, Uri uri);

    void b(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri);
}
