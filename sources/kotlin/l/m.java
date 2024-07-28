package kotlin.l;

import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.k;

public final class m<T, R> implements d<R> {

    /* renamed from: a  reason: collision with root package name */
    final d<T> f47967a;

    /* renamed from: b  reason: collision with root package name */
    final b<T, R> f47968b;

    public static final class a implements Iterator<R>, kotlin.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f47969a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<T> f47970b;

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(m mVar) {
            this.f47969a = mVar;
            this.f47970b = mVar.f47967a.a();
        }

        public final R next() {
            return this.f47969a.f47968b.invoke(this.f47970b.next());
        }

        public final boolean hasNext() {
            return this.f47970b.hasNext();
        }
    }

    public m(d<? extends T> dVar, b<? super T, ? extends R> bVar) {
        k.d(dVar, "sequence");
        k.d(bVar, "transformer");
        this.f47967a = dVar;
        this.f47968b = bVar;
    }

    public final Iterator<R> a() {
        return new a(this);
    }
}
