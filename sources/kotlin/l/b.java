package kotlin.l;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.b.k;

public final class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    final d<T> f47949a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f47950b = true;

    /* renamed from: c  reason: collision with root package name */
    final kotlin.g.a.b<T, Boolean> f47951c;

    public b(d<? extends T> dVar, kotlin.g.a.b<? super T, Boolean> bVar) {
        k.d(dVar, "sequence");
        k.d(bVar, "predicate");
        this.f47949a = dVar;
        this.f47951c = bVar;
    }

    public static final class a implements Iterator<T>, kotlin.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f47952a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<T> f47953b;

        /* renamed from: c  reason: collision with root package name */
        private int f47954c = -1;

        /* renamed from: d  reason: collision with root package name */
        private T f47955d;

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(b bVar) {
            this.f47952a = bVar;
            this.f47953b = bVar.f47949a.a();
        }

        private final void a() {
            while (this.f47953b.hasNext()) {
                T next = this.f47953b.next();
                if (this.f47952a.f47951c.invoke(next).booleanValue() == this.f47952a.f47950b) {
                    this.f47955d = next;
                    this.f47954c = 1;
                    return;
                }
            }
            this.f47954c = 0;
        }

        public final T next() {
            if (this.f47954c == -1) {
                a();
            }
            if (this.f47954c != 0) {
                T t = this.f47955d;
                this.f47955d = null;
                this.f47954c = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        public final boolean hasNext() {
            if (this.f47954c == -1) {
                a();
            }
            return this.f47954c == 1;
        }
    }

    public final Iterator<T> a() {
        return new a(this);
    }
}
