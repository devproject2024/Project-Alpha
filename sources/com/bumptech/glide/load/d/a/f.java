package com.bumptech.glide.load.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.b;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.m;

public abstract class f implements m<Bitmap> {
    /* access modifiers changed from: protected */
    public abstract Bitmap transform(e eVar, Bitmap bitmap, int i2, int i3);

    public final v<Bitmap> transform(Context context, v<Bitmap> vVar, int i2, int i3) {
        if (k.a(i2, i3)) {
            e eVar = b.a(context).f6425a;
            Bitmap b2 = vVar.b();
            if (i2 == Integer.MIN_VALUE) {
                i2 = b2.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = b2.getHeight();
            }
            Bitmap transform = transform(eVar, b2, i2, i3);
            if (b2.equals(transform)) {
                return vVar;
            }
            return e.a(transform, eVar);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
