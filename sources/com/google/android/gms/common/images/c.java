package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final b f8723a;

    /* renamed from: b  reason: collision with root package name */
    protected int f8724b;

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public final void a(Context context, Bitmap bitmap) {
        if (bitmap != null) {
            new BitmapDrawable(context.getResources(), bitmap);
            a();
            return;
        }
        throw new IllegalArgumentException("null reference");
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context) {
        int i2 = this.f8724b;
        if (i2 != 0) {
            context.getResources().getDrawable(i2);
        }
        a();
    }
}
