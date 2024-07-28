package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.c.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class z implements k<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final e f7195a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.e f7196b;

    public final /* synthetic */ v a(Object obj, int i2, int i3, i iVar) throws IOException {
        v<Drawable> a2 = this.f7195a.a((Uri) obj);
        if (a2 == null) {
            return null;
        }
        return p.a(this.f7196b, a2.b(), i2, i3);
    }

    public final /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return "android.resource".equals(((Uri) obj).getScheme());
    }

    public z(e eVar, com.bumptech.glide.load.b.a.e eVar2) {
        this.f7195a = eVar;
        this.f7196b = eVar2;
    }
}
