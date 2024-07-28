package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.w;

final class k extends a<Object> {
    private final Object m = new Object();
    private e n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(w wVar, z zVar, int i2, int i3, Object obj, String str, e eVar) {
        super(wVar, null, zVar, i2, i3, 0, (Drawable) null, str, obj, false);
        this.n = eVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(Bitmap bitmap, w.d dVar) {
        e eVar = this.n;
        if (eVar != null) {
            eVar.onSuccess();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Exception exc) {
        e eVar = this.n;
        if (eVar != null) {
            eVar.onError(exc);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        super.a();
        this.n = null;
    }

    /* access modifiers changed from: package-private */
    public final Object b() {
        return this.m;
    }
}
