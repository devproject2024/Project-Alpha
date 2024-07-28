package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.w;

final class ag extends a<af> {
    ag(w wVar, af afVar, z zVar, int i2, int i3, Drawable drawable, String str, Object obj, int i4) {
        super(wVar, afVar, zVar, i2, i3, i4, drawable, str, obj, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bitmap bitmap, w.d dVar) {
        if (bitmap != null) {
            af afVar = (af) b();
            if (afVar != null) {
                afVar.onBitmapLoaded(bitmap, dVar);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    /* access modifiers changed from: package-private */
    public final void a(Exception exc) {
        af afVar = (af) b();
        if (afVar == null) {
            return;
        }
        if (this.f45347g != 0) {
            afVar.onBitmapFailed(exc, this.f45341a.f45448e.getResources().getDrawable(this.f45347g));
        } else {
            afVar.onBitmapFailed(exc, this.f45348h);
        }
    }
}
