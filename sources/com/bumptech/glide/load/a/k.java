package com.bumptech.glide.load.a;

import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d.a.y;
import java.io.IOException;
import java.io.InputStream;

public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final y f6710a;

    public k(InputStream inputStream, b bVar) {
        this.f6710a = new y(inputStream, bVar);
        this.f6710a.mark(5242880);
    }

    /* renamed from: c */
    public final InputStream a() throws IOException {
        this.f6710a.reset();
        return this.f6710a;
    }

    public final void b() {
        this.f6710a.b();
    }

    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f6711a;

        public final /* synthetic */ e a(Object obj) {
            return new k((InputStream) obj, this.f6711a);
        }

        public a(b bVar) {
            this.f6711a = bVar;
        }

        public final Class<InputStream> a() {
            return InputStream.class;
        }
    }
}
