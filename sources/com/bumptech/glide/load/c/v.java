package com.bumptech.glide.load.c;

import com.bumptech.glide.f;
import com.bumptech.glide.f.d;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.i;

public final class v<Model> implements n<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final v<?> f7086a = new v<>();

    public final boolean a(Model model) {
        return true;
    }

    public static <T> v<T> a() {
        return f7086a;
    }

    public final n.a<Model> a(Model model, int i2, int i3, i iVar) {
        return new n.a<>(new d(model), new b(model));
    }

    static class b<Model> implements com.bumptech.glide.load.a.d<Model> {

        /* renamed from: a  reason: collision with root package name */
        private final Model f7088a;

        public final void b() {
        }

        public final void c() {
        }

        b(Model model) {
            this.f7088a = model;
        }

        public final void a(f fVar, d.a<? super Model> aVar) {
            aVar.a(this.f7088a);
        }

        public final Class<Model> a() {
            return this.f7088a.getClass();
        }

        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static class a<Model> implements o<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final a<?> f7087a = new a<>();

        public static <T> a<T> a() {
            return f7087a;
        }

        public final n<Model, Model> a(r rVar) {
            return v.a();
        }
    }
}
