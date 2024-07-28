package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.w;

final class n extends a<ImageView> {
    e m;

    n(w wVar, ImageView imageView, z zVar, int i2, int i3, int i4, Drawable drawable, String str, Object obj, e eVar, boolean z) {
        super(wVar, imageView, zVar, i2, i3, i4, drawable, str, obj, z);
        this.m = eVar;
    }

    public final void a(Bitmap bitmap, w.d dVar) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f45343c.get();
            if (imageView != null) {
                Bitmap bitmap2 = bitmap;
                w.d dVar2 = dVar;
                x.a(imageView, this.f45341a.f45448e, bitmap2, dVar2, this.f45344d, this.f45341a.m);
                e eVar = this.m;
                if (eVar != null) {
                    eVar.onSuccess();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public final void a(Exception exc) {
        ImageView imageView = (ImageView) this.f45343c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            if (this.f45347g != 0) {
                imageView.setImageResource(this.f45347g);
            } else if (this.f45348h != null) {
                imageView.setImageDrawable(this.f45348h);
            }
            e eVar = this.m;
            if (eVar != null) {
                eVar.onError(exc);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        super.a();
        if (this.m != null) {
            this.m = null;
        }
    }
}
