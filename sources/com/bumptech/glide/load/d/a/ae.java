package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;

public final class ae implements k<Bitmap, Bitmap> {
    public final /* bridge */ /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return true;
    }

    public final /* synthetic */ v a(Object obj, int i2, int i3, i iVar) throws IOException {
        return new a((Bitmap) obj);
    }

    static final class a implements v<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f7121a;

        public final void d() {
        }

        a(Bitmap bitmap) {
            this.f7121a = bitmap;
        }

        public final Class<Bitmap> a() {
            return Bitmap.class;
        }

        public final int c() {
            return com.bumptech.glide.g.k.a(this.f7121a);
        }

        public final /* bridge */ /* synthetic */ Object b() {
            return this.f7121a;
        }
    }
}
