package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.d.r;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class br {

    public static final class l<T, S> implements io.reactivex.rxjava3.d.c<S, io.reactivex.rxjava3.a.g<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.g<io.reactivex.rxjava3.a.g<T>> f47107a;

        public final /* synthetic */ Object a(Object obj, Object obj2) throws Throwable {
            this.f47107a.accept((io.reactivex.rxjava3.a.g) obj2);
            return obj;
        }

        public l(io.reactivex.rxjava3.d.g<io.reactivex.rxjava3.a.g<T>> gVar) {
            this.f47107a = gVar;
        }
    }

    static final class k<T, S> implements io.reactivex.rxjava3.d.c<S, io.reactivex.rxjava3.a.g<T>, S> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.b<S, io.reactivex.rxjava3.a.g<T>> f47106a;

        public final /* synthetic */ Object a(Object obj, Object obj2) throws Throwable {
            this.f47106a.accept(obj, (io.reactivex.rxjava3.a.g) obj2);
            return obj;
        }

        k(io.reactivex.rxjava3.d.b<S, io.reactivex.rxjava3.a.g<T>> bVar) {
            this.f47106a = bVar;
        }
    }

    public static <T, S> io.reactivex.rxjava3.d.c<S, io.reactivex.rxjava3.a.g<T>, S> a(io.reactivex.rxjava3.d.b<S, io.reactivex.rxjava3.a.g<T>> bVar) {
        return new k(bVar);
    }

    public static final class f<T, U> implements io.reactivex.rxjava3.d.h<T, u<T>> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.h<? super T, ? extends u<U>> f47101a;

        public f(io.reactivex.rxjava3.d.h<? super T, ? extends u<U>> hVar) {
            this.f47101a = hVar;
        }

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            return new dr((u) Objects.requireNonNull(this.f47101a.apply(obj), "The itemDelay returned a null ObservableSource"), 1).map(io.reactivex.rxjava3.e.b.a.b(obj)).defaultIfEmpty(obj);
        }
    }

    public static final class i<T> implements io.reactivex.rxjava3.d.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<T> f47104a;

        public i(w<T> wVar) {
            this.f47104a = wVar;
        }

        public final void accept(T t) {
            this.f47104a.onNext(t);
        }
    }

    public static final class h<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final w<T> f47103a;

        public final /* synthetic */ void accept(Object obj) throws Throwable {
            this.f47103a.onError((Throwable) obj);
        }

        public h(w<T> wVar) {
            this.f47103a = wVar;
        }
    }

    public static final class g<T> implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        final w<T> f47102a;

        public g(w<T> wVar) {
            this.f47102a = wVar;
        }

        public final void run() {
            this.f47102a.onComplete();
        }
    }

    static final class d<U, R, T> implements io.reactivex.rxjava3.d.h<U, R> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.c<? super T, ? super U, ? extends R> f47097a;

        /* renamed from: b  reason: collision with root package name */
        private final T f47098b;

        d(io.reactivex.rxjava3.d.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.f47097a = cVar;
            this.f47098b = t;
        }

        public final R apply(U u) throws Throwable {
            return this.f47097a.a(this.f47098b, u);
        }
    }

    public static final class e<T, R, U> implements io.reactivex.rxjava3.d.h<T, u<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.c<? super T, ? super U, ? extends R> f47099a;

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super T, ? extends u<? extends U>> f47100b;

        public e(io.reactivex.rxjava3.d.c<? super T, ? super U, ? extends R> cVar, io.reactivex.rxjava3.d.h<? super T, ? extends u<? extends U>> hVar) {
            this.f47099a = cVar;
            this.f47100b = hVar;
        }

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            return new bz((u) Objects.requireNonNull(this.f47100b.apply(obj), "The mapper returned a null ObservableSource"), new d(this.f47099a, obj));
        }
    }

    public static final class c<T, U> implements io.reactivex.rxjava3.d.h<T, u<U>> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super T, ? extends Iterable<? extends U>> f47096a;

        public c(io.reactivex.rxjava3.d.h<? super T, ? extends Iterable<? extends U>> hVar) {
            this.f47096a = hVar;
        }

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            return new bg((Iterable) Objects.requireNonNull(this.f47096a.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    public static <T> r<io.reactivex.rxjava3.f.a<T>> a(p<T> pVar, int i2, boolean z) {
        return new a(pVar, i2, z);
    }

    public static <T> r<io.reactivex.rxjava3.f.a<T>> a(p<T> pVar, int i2, long j2, TimeUnit timeUnit, x xVar, boolean z) {
        return new b(pVar, i2, j2, timeUnit, xVar, z);
    }

    public static <T> r<io.reactivex.rxjava3.f.a<T>> a(p<T> pVar, long j2, TimeUnit timeUnit, x xVar, boolean z) {
        return new m(pVar, j2, timeUnit, xVar, z);
    }

    public static final class j<T> implements r<io.reactivex.rxjava3.f.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final p<T> f47105a;

        public j(p<T> pVar) {
            this.f47105a = pVar;
        }

        public final /* synthetic */ Object get() throws Throwable {
            return this.f47105a.replay();
        }
    }

    static final class a<T> implements r<io.reactivex.rxjava3.f.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        final p<T> f47087a;

        /* renamed from: b  reason: collision with root package name */
        final int f47088b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f47089c;

        a(p<T> pVar, int i2, boolean z) {
            this.f47087a = pVar;
            this.f47088b = i2;
            this.f47089c = z;
        }

        public final /* synthetic */ Object get() throws Throwable {
            return this.f47087a.replay(this.f47088b, this.f47089c);
        }
    }

    static final class b<T> implements r<io.reactivex.rxjava3.f.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        final p<T> f47090a;

        /* renamed from: b  reason: collision with root package name */
        final int f47091b;

        /* renamed from: c  reason: collision with root package name */
        final long f47092c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f47093d;

        /* renamed from: e  reason: collision with root package name */
        final x f47094e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f47095f;

        b(p<T> pVar, int i2, long j, TimeUnit timeUnit, x xVar, boolean z) {
            this.f47090a = pVar;
            this.f47091b = i2;
            this.f47092c = j;
            this.f47093d = timeUnit;
            this.f47094e = xVar;
            this.f47095f = z;
        }

        public final /* synthetic */ Object get() throws Throwable {
            return this.f47090a.replay(this.f47091b, this.f47092c, this.f47093d, this.f47094e, this.f47095f);
        }
    }

    static final class m<T> implements r<io.reactivex.rxjava3.f.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        final p<T> f47108a;

        /* renamed from: b  reason: collision with root package name */
        final long f47109b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f47110c;

        /* renamed from: d  reason: collision with root package name */
        final x f47111d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f47112e;

        m(p<T> pVar, long j, TimeUnit timeUnit, x xVar, boolean z) {
            this.f47108a = pVar;
            this.f47109b = j;
            this.f47110c = timeUnit;
            this.f47111d = xVar;
            this.f47112e = z;
        }

        public final /* synthetic */ Object get() throws Throwable {
            return this.f47108a.replay(this.f47109b, this.f47110c, this.f47111d, this.f47112e);
        }
    }
}
