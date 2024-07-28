package dagger.a;

import javax.a.a;

public final class b<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f45996a = (!b.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private static final Object f45997b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private volatile a<T> f45998c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Object f45999d = f45997b;

    private b(a<T> aVar) {
        if (f45996a || aVar != null) {
            this.f45998c = aVar;
            return;
        }
        throw new AssertionError();
    }

    public final T get() {
        T t = this.f45999d;
        if (t == f45997b) {
            synchronized (this) {
                t = this.f45999d;
                if (t == f45997b) {
                    t = this.f45998c.get();
                    T t2 = this.f45999d;
                    if (t2 != f45997b && !(t2 instanceof f)) {
                        if (t2 != t) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + t2 + " & " + t + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.f45999d = t;
                    this.f45998c = null;
                }
            }
        }
        return t;
    }

    public static <P extends a<T>, T> a<T> a(P p) {
        g.a(p);
        if (p instanceof b) {
            return p;
        }
        return new b(p);
    }
}
