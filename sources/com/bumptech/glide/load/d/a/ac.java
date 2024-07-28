package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.d;
import com.bumptech.glide.g.h;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.io.InputStream;

public final class ac implements k<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final o f7111a;

    /* renamed from: b  reason: collision with root package name */
    private final b f7112b;

    public final /* bridge */ /* synthetic */ boolean a(Object obj, i iVar) throws IOException {
        return true;
    }

    public ac(o oVar, b bVar) {
        this.f7111a = oVar;
        this.f7112b = bVar;
    }

    /* access modifiers changed from: private */
    public v<Bitmap> a(InputStream inputStream, int i2, int i3, i iVar) throws IOException {
        y yVar;
        boolean z;
        if (inputStream instanceof y) {
            yVar = (y) inputStream;
            z = false;
        } else {
            yVar = new y(inputStream, this.f7112b);
            z = true;
        }
        d a2 = d.a(yVar);
        try {
            return this.f7111a.a((InputStream) new h(a2), i2, i3, iVar, (o.a) new a(yVar, a2));
        } finally {
            a2.a();
            if (z) {
                yVar.b();
            }
        }
    }

    static class a implements o.a {

        /* renamed from: a  reason: collision with root package name */
        private final y f7113a;

        /* renamed from: b  reason: collision with root package name */
        private final d f7114b;

        a(y yVar, d dVar) {
            this.f7113a = yVar;
            this.f7114b = dVar;
        }

        public final void a() {
            this.f7113a.a();
        }

        public final void a(e eVar, Bitmap bitmap) throws IOException {
            IOException iOException = this.f7114b.f6610a;
            if (iOException != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw iOException;
            }
        }
    }
}
