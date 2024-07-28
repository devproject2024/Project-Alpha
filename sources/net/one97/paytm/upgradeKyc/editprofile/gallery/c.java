package net.one97.paytm.upgradeKyc.editprofile.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;

public final class c {

    static final class a extends l implements b<T, b<? extends T>> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        public final b<T> invoke(T t) {
            return new b<>(t);
        }
    }

    public static final <T> LiveData<b<T>> a(LiveData<T> liveData) {
        k.c(liveData, "$this$event");
        return a(liveData, a.INSTANCE);
    }

    private static <X, Y> LiveData<Y> a(LiveData<X> liveData, b<? super X, ? extends Y> bVar) {
        k.c(liveData, "$this$map");
        k.c(bVar, "body");
        LiveData<Y> a2 = ah.a(liveData, new d(bVar));
        k.a((Object) a2, "Transformations.map(this, body)");
        return a2;
    }
}
