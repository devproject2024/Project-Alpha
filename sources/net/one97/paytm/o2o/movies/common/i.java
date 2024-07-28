package net.one97.paytm.o2o.movies.common;

import androidx.lifecycle.y;
import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import kotlin.g.b.k;

public final class i {

    public static final class a<T> implements g<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f75129a;

        public a(y yVar) {
            this.f75129a = yVar;
        }

        public final void accept(T t) {
            this.f75129a.setValue(t);
        }
    }

    public static final c a(c cVar, b bVar) {
        k.c(cVar, "$this$addTo");
        k.c(bVar, "compositeDisposable");
        bVar.a(cVar);
        return cVar;
    }
}
