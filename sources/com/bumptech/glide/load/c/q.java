package com.bumptech.glide.load.c;

import androidx.core.g.e;
import com.bumptech.glide.f;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f7060a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a<List<Throwable>> f7061b;

    q(List<n<Model, Data>> list, e.a<List<Throwable>> aVar) {
        this.f7060a = list;
        this.f7061b = aVar;
    }

    public final n.a<Data> a(Model model, int i2, int i3, i iVar) {
        n.a a2;
        int size = this.f7060a.size();
        ArrayList arrayList = new ArrayList(size);
        g gVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            n nVar = this.f7060a.get(i4);
            if (nVar.a(model) && (a2 = nVar.a(model, i2, i3, iVar)) != null) {
                gVar = a2.f7053a;
                arrayList.add(a2.f7055c);
            }
        }
        if (arrayList.isEmpty() || gVar == null) {
            return null;
        }
        return new n.a<>(gVar, new a(arrayList, this.f7061b));
    }

    public final boolean a(Model model) {
        for (n<Model, Data> a2 : this.f7060a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f7060a.toArray()) + '}';
    }

    static class a<Data> implements d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d<Data>> f7062a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a<List<Throwable>> f7063b;

        /* renamed from: c  reason: collision with root package name */
        private int f7064c = 0;

        /* renamed from: d  reason: collision with root package name */
        private f f7065d;

        /* renamed from: e  reason: collision with root package name */
        private d.a<? super Data> f7066e;

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f7067f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f7068g;

        a(List<d<Data>> list, e.a<List<Throwable>> aVar) {
            this.f7063b = aVar;
            j.a(list);
            this.f7062a = list;
        }

        public final void a(f fVar, d.a<? super Data> aVar) {
            this.f7065d = fVar;
            this.f7066e = aVar;
            this.f7067f = this.f7063b.a();
            this.f7062a.get(this.f7064c).a(fVar, this);
            if (this.f7068g) {
                c();
            }
        }

        public final void b() {
            List<Throwable> list = this.f7067f;
            if (list != null) {
                this.f7063b.a(list);
            }
            this.f7067f = null;
            for (d<Data> b2 : this.f7062a) {
                b2.b();
            }
        }

        public final void c() {
            this.f7068g = true;
            for (d<Data> c2 : this.f7062a) {
                c2.c();
            }
        }

        public final Class<Data> a() {
            return this.f7062a.get(0).a();
        }

        public final com.bumptech.glide.load.a d() {
            return this.f7062a.get(0).d();
        }

        public final void a(Data data) {
            if (data != null) {
                this.f7066e.a(data);
            } else {
                e();
            }
        }

        public final void a(Exception exc) {
            ((List) j.a(this.f7067f, "Argument must not be null")).add(exc);
            e();
        }

        private void e() {
            if (!this.f7068g) {
                if (this.f7064c < this.f7062a.size() - 1) {
                    this.f7064c++;
                    a(this.f7065d, this.f7066e);
                    return;
                }
                j.a(this.f7067f, "Argument must not be null");
                this.f7066e.a((Exception) new com.bumptech.glide.load.b.q("Fetch failed", (List<Throwable>) new ArrayList(this.f7067f)));
            }
        }
    }
}
