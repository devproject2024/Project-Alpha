package kotlin.l;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.k;

public final class c<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    final kotlin.g.a.a<T> f47956a;

    /* renamed from: b  reason: collision with root package name */
    final b<T, T> f47957b;

    public static final class a implements Iterator<T>, kotlin.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f47958a;

        /* renamed from: b  reason: collision with root package name */
        private T f47959b;

        /* renamed from: c  reason: collision with root package name */
        private int f47960c = -2;

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(c cVar) {
            this.f47958a = cVar;
        }

        private final void a() {
            T t;
            if (this.f47960c == -2) {
                t = this.f47958a.f47956a.invoke();
            } else {
                b<T, T> bVar = this.f47958a.f47957b;
                T t2 = this.f47959b;
                k.a((Object) t2);
                t = bVar.invoke(t2);
            }
            this.f47959b = t;
            this.f47960c = this.f47959b == null ? 0 : 1;
        }

        public final T next() {
            if (this.f47960c < 0) {
                a();
            }
            if (this.f47960c != 0) {
                T t = this.f47959b;
                if (t != null) {
                    this.f47960c = -1;
                    return t;
                }
                throw new NullPointerException("null cannot be cast to non-null type T");
            }
            throw new NoSuchElementException();
        }

        public final boolean hasNext() {
            if (this.f47960c < 0) {
                a();
            }
            return this.f47960c == 1;
        }
    }

    public c(kotlin.g.a.a<? extends T> aVar, b<? super T, ? extends T> bVar) {
        k.d(aVar, "getInitialValue");
        k.d(bVar, "getNextValue");
        this.f47956a = aVar;
        this.f47957b = bVar;
    }

    public final Iterator<T> a() {
        return new a(this);
    }
}
