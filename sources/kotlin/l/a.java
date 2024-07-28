package kotlin.l;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.k;

public final class a<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<d<T>> f47948a;

    public a(d<? extends T> dVar) {
        k.d(dVar, "sequence");
        this.f47948a = new AtomicReference<>(dVar);
    }

    public final Iterator<T> a() {
        d andSet = this.f47948a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.a();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
