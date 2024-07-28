package com.bumptech.glide.load.c;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import java.util.Collections;
import java.util.List;

public interface n<Model, Data> {
    a<Data> a(Model model, int i2, int i3, i iVar);

    boolean a(Model model);

    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final g f7053a;

        /* renamed from: b  reason: collision with root package name */
        public final List<g> f7054b;

        /* renamed from: c  reason: collision with root package name */
        public final d<Data> f7055c;

        public a(g gVar, d<Data> dVar) {
            this(gVar, Collections.emptyList(), dVar);
        }

        private a(g gVar, List<g> list, d<Data> dVar) {
            this.f7053a = (g) j.a(gVar, "Argument must not be null");
            this.f7054b = (List) j.a(list, "Argument must not be null");
            this.f7055c = (d) j.a(dVar, "Argument must not be null");
        }
    }
}
