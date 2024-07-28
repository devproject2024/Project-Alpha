package io.reactivex.rxjava3.e.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final io.reactivex.rxjava3.d.h<Object, Object> f46645a = new v();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f46646b = new q();

    /* renamed from: c  reason: collision with root package name */
    public static final io.reactivex.rxjava3.d.a f46647c = new n();

    /* renamed from: d  reason: collision with root package name */
    static final io.reactivex.rxjava3.d.g<Object> f46648d = new o();

    /* renamed from: e  reason: collision with root package name */
    public static final io.reactivex.rxjava3.d.g<Throwable> f46649e = new s();

    /* renamed from: f  reason: collision with root package name */
    public static final io.reactivex.rxjava3.d.g<Throwable> f46650f = new ae();

    /* renamed from: g  reason: collision with root package name */
    public static final io.reactivex.rxjava3.d.p f46651g = new p();

    /* renamed from: h  reason: collision with root package name */
    static final io.reactivex.rxjava3.d.q<Object> f46652h = new aj();

    /* renamed from: i  reason: collision with root package name */
    static final io.reactivex.rxjava3.d.q<Object> f46653i = new t();
    static final io.reactivex.rxjava3.d.r<Object> j = new ad();
    public static final io.reactivex.rxjava3.d.g<org.a.c> k = new y();

    public static <T1, T2, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.c<? super T1, ? super T2, ? extends R> cVar) {
        return new b(cVar);
    }

    public static <T1, T2, T3, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.i<T1, T2, T3, R> iVar) {
        return new c(iVar);
    }

    public static <T1, T2, T3, T4, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.j<T1, T2, T3, T4, R> jVar) {
        return new d(jVar);
    }

    public static <T1, T2, T3, T4, T5, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.k<T1, T2, T3, T4, T5, R> kVar) {
        return new e(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.l<T1, T2, T3, T4, T5, T6, R> lVar) {
        return new f(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.m<T1, T2, T3, T4, T5, T6, T7, R> mVar) {
        return new g(mVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.n<T1, T2, T3, T4, T5, T6, T7, T8, R> nVar) {
        return new h(nVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.rxjava3.d.h<Object[], R> a(io.reactivex.rxjava3.d.o<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> oVar) {
        return new i(oVar);
    }

    public static <T> io.reactivex.rxjava3.d.h<T, T> a() {
        return f46645a;
    }

    public static <T> io.reactivex.rxjava3.d.g<T> b() {
        return f46648d;
    }

    public static <T> io.reactivex.rxjava3.d.q<T> c() {
        return f46652h;
    }

    public static <T> io.reactivex.rxjava3.d.q<T> d() {
        return f46653i;
    }

    public static <T> io.reactivex.rxjava3.d.r<T> e() {
        return j;
    }

    static final class w<T, U> implements io.reactivex.rxjava3.d.h<T, U>, io.reactivex.rxjava3.d.r<U>, Callable<U> {

        /* renamed from: a  reason: collision with root package name */
        final U f46679a;

        w(U u) {
            this.f46679a = u;
        }

        public final U call() {
            return this.f46679a;
        }

        public final U apply(T t) {
            return this.f46679a;
        }

        public final U get() {
            return this.f46679a;
        }
    }

    public static <T> io.reactivex.rxjava3.d.r<T> a(T t2) {
        return new w(t2);
    }

    public static <T, U> io.reactivex.rxjava3.d.h<T, U> b(U u2) {
        return new w(u2);
    }

    static final class l<T, U> implements io.reactivex.rxjava3.d.h<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final Class<U> f46676a;

        l(Class<U> cls) {
            this.f46676a = cls;
        }

        public final U apply(T t) {
            return this.f46676a.cast(t);
        }
    }

    public static <T, U> io.reactivex.rxjava3.d.h<T, U> a(Class<U> cls) {
        return new l(cls);
    }

    static final class j<T> implements io.reactivex.rxjava3.d.r<List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final int f46674a;

        j(int i2) {
            this.f46674a = i2;
        }

        public final /* synthetic */ Object get() throws Throwable {
            return new ArrayList(this.f46674a);
        }
    }

    public static <T> io.reactivex.rxjava3.d.r<List<T>> a(int i2) {
        return new j(i2);
    }

    static final class r<T> implements io.reactivex.rxjava3.d.q<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f46678a;

        r(T t) {
            this.f46678a = t;
        }

        public final boolean test(T t) {
            return Objects.equals(t, this.f46678a);
        }
    }

    public static <T> io.reactivex.rxjava3.d.q<T> c(T t2) {
        return new r(t2);
    }

    enum u implements io.reactivex.rxjava3.d.r<Set<Object>> {
        INSTANCE;

        public final Set<Object> get() {
            return new HashSet();
        }
    }

    public static <T> io.reactivex.rxjava3.d.r<Set<T>> f() {
        return u.INSTANCE;
    }

    static final class ac<T> implements io.reactivex.rxjava3.d.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> f46657a;

        ac(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> gVar) {
            this.f46657a = gVar;
        }

        public final void accept(T t) throws Throwable {
            this.f46657a.accept(io.reactivex.rxjava3.a.o.a(t));
        }
    }

    static final class ab<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> f46656a;

        public final /* synthetic */ void accept(Object obj) throws Throwable {
            this.f46656a.accept(io.reactivex.rxjava3.a.o.a((Throwable) obj));
        }

        ab(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> gVar) {
            this.f46656a = gVar;
        }
    }

    static final class aa<T> implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> f46655a;

        aa(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> gVar) {
            this.f46655a = gVar;
        }

        public final void run() throws Throwable {
            this.f46655a.accept(io.reactivex.rxjava3.a.o.e());
        }
    }

    public static <T> io.reactivex.rxjava3.d.g<T> a(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> gVar) {
        return new ac(gVar);
    }

    public static <T> io.reactivex.rxjava3.d.g<Throwable> b(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> gVar) {
        return new ab(gVar);
    }

    public static <T> io.reactivex.rxjava3.d.a c(io.reactivex.rxjava3.d.g<? super io.reactivex.rxjava3.a.o<T>> gVar) {
        return new aa(gVar);
    }

    /* renamed from: io.reactivex.rxjava3.e.b.a$a  reason: collision with other inner class name */
    static final class C0786a<T> implements io.reactivex.rxjava3.d.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.a f46654a;

        C0786a(io.reactivex.rxjava3.d.a aVar) {
            this.f46654a = aVar;
        }

        public final void accept(T t) throws Throwable {
            this.f46654a.run();
        }
    }

    public static <T> io.reactivex.rxjava3.d.g<T> a(io.reactivex.rxjava3.d.a aVar) {
        return new C0786a(aVar);
    }

    static final class m<T, U> implements io.reactivex.rxjava3.d.q<T> {

        /* renamed from: a  reason: collision with root package name */
        final Class<U> f46677a;

        m(Class<U> cls) {
            this.f46677a = cls;
        }

        public final boolean test(T t) {
            return this.f46677a.isInstance(t);
        }
    }

    public static <T, U> io.reactivex.rxjava3.d.q<T> b(Class<U> cls) {
        return new m(cls);
    }

    static final class k<T> implements io.reactivex.rxjava3.d.q<T> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.e f46675a;

        k(io.reactivex.rxjava3.d.e eVar) {
            this.f46675a = eVar;
        }

        public final boolean test(T t) throws Throwable {
            return !this.f46675a.a();
        }
    }

    public static <T> io.reactivex.rxjava3.d.q<T> a(io.reactivex.rxjava3.d.e eVar) {
        return new k(eVar);
    }

    static final class af<T> implements io.reactivex.rxjava3.d.h<T, io.reactivex.rxjava3.i.b<T>> {

        /* renamed from: a  reason: collision with root package name */
        final TimeUnit f46658a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.rxjava3.a.x f46659b;

        af(TimeUnit timeUnit, io.reactivex.rxjava3.a.x xVar) {
            this.f46658a = timeUnit;
            this.f46659b = xVar;
        }

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            return new io.reactivex.rxjava3.i.b(obj, io.reactivex.rxjava3.a.x.a(this.f46658a), this.f46658a);
        }
    }

    public static <T> io.reactivex.rxjava3.d.h<T, io.reactivex.rxjava3.i.b<T>> a(TimeUnit timeUnit, io.reactivex.rxjava3.a.x xVar) {
        return new af(timeUnit, xVar);
    }

    static final class ag<K, T> implements io.reactivex.rxjava3.d.b<Map<K, T>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super T, ? extends K> f46660a;

        public final /* synthetic */ void accept(Object obj, Object obj2) throws Throwable {
            ((Map) obj).put(this.f46660a.apply(obj2), obj2);
        }

        ag(io.reactivex.rxjava3.d.h<? super T, ? extends K> hVar) {
            this.f46660a = hVar;
        }
    }

    public static <T, K> io.reactivex.rxjava3.d.b<Map<K, T>, T> a(io.reactivex.rxjava3.d.h<? super T, ? extends K> hVar) {
        return new ag(hVar);
    }

    static final class ah<K, V, T> implements io.reactivex.rxjava3.d.b<Map<K, V>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super T, ? extends V> f46661a;

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super T, ? extends K> f46662b;

        public final /* synthetic */ void accept(Object obj, Object obj2) throws Throwable {
            ((Map) obj).put(this.f46662b.apply(obj2), this.f46661a.apply(obj2));
        }

        ah(io.reactivex.rxjava3.d.h<? super T, ? extends V> hVar, io.reactivex.rxjava3.d.h<? super T, ? extends K> hVar2) {
            this.f46661a = hVar;
            this.f46662b = hVar2;
        }
    }

    public static <T, K, V> io.reactivex.rxjava3.d.b<Map<K, V>, T> a(io.reactivex.rxjava3.d.h<? super T, ? extends K> hVar, io.reactivex.rxjava3.d.h<? super T, ? extends V> hVar2) {
        return new ah(hVar2, hVar);
    }

    static final class ai<K, V, T> implements io.reactivex.rxjava3.d.b<Map<K, Collection<V>>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super K, ? extends Collection<? super V>> f46663a;

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super T, ? extends V> f46664b;

        /* renamed from: c  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.h<? super T, ? extends K> f46665c;

        public final /* synthetic */ void accept(Object obj, Object obj2) throws Throwable {
            Map map = (Map) obj;
            Object apply = this.f46665c.apply(obj2);
            Collection collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = (Collection) this.f46663a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f46664b.apply(obj2));
        }

        ai(io.reactivex.rxjava3.d.h<? super K, ? extends Collection<? super V>> hVar, io.reactivex.rxjava3.d.h<? super T, ? extends V> hVar2, io.reactivex.rxjava3.d.h<? super T, ? extends K> hVar3) {
            this.f46663a = hVar;
            this.f46664b = hVar2;
            this.f46665c = hVar3;
        }
    }

    public static <T, K, V> io.reactivex.rxjava3.d.b<Map<K, Collection<V>>, T> a(io.reactivex.rxjava3.d.h<? super T, ? extends K> hVar, io.reactivex.rxjava3.d.h<? super T, ? extends V> hVar2, io.reactivex.rxjava3.d.h<? super K, ? extends Collection<? super V>> hVar3) {
        return new ai(hVar3, hVar2, hVar);
    }

    enum z implements Comparator<Object> {
        INSTANCE;

        public final int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static <T> Comparator<T> g() {
        return z.INSTANCE;
    }

    static final class x<T> implements io.reactivex.rxjava3.d.h<List<T>, List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final Comparator<? super T> f46680a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            List list = (List) obj;
            Collections.sort(list, this.f46680a);
            return list;
        }

        x(Comparator<? super T> comparator) {
            this.f46680a = comparator;
        }
    }

    public static <T> io.reactivex.rxjava3.d.h<List<T>, List<T>> a(Comparator<? super T> comparator) {
        return new x(comparator);
    }

    static final class b<T1, T2, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.c<? super T1, ? super T2, ? extends R> f46666a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                return this.f46666a.a(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }

        b(io.reactivex.rxjava3.d.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f46666a = cVar;
        }
    }

    static final class c<T1, T2, T3, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.i<T1, T2, T3, R> f46667a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                return this.f46667a.a();
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }

        c(io.reactivex.rxjava3.d.i<T1, T2, T3, R> iVar) {
            this.f46667a = iVar;
        }
    }

    static final class d<T1, T2, T3, T4, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.j<T1, T2, T3, T4, R> f46668a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                return this.f46668a.a();
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }

        d(io.reactivex.rxjava3.d.j<T1, T2, T3, T4, R> jVar) {
            this.f46668a = jVar;
        }
    }

    static final class e<T1, T2, T3, T4, T5, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        private final io.reactivex.rxjava3.d.k<T1, T2, T3, T4, T5, R> f46669a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 5) {
                return this.f46669a.a();
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }

        e(io.reactivex.rxjava3.d.k<T1, T2, T3, T4, T5, R> kVar) {
            this.f46669a = kVar;
        }
    }

    static final class f<T1, T2, T3, T4, T5, T6, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.l<T1, T2, T3, T4, T5, T6, R> f46670a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 6) {
                return this.f46670a.a();
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }

        f(io.reactivex.rxjava3.d.l<T1, T2, T3, T4, T5, T6, R> lVar) {
            this.f46670a = lVar;
        }
    }

    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.m<T1, T2, T3, T4, T5, T6, T7, R> f46671a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 7) {
                return this.f46671a.a();
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }

        g(io.reactivex.rxjava3.d.m<T1, T2, T3, T4, T5, T6, T7, R> mVar) {
            this.f46671a = mVar;
        }
    }

    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.n<T1, T2, T3, T4, T5, T6, T7, T8, R> f46672a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 8) {
                return this.f46672a.a();
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }

        h(io.reactivex.rxjava3.d.n<T1, T2, T3, T4, T5, T6, T7, T8, R> nVar) {
            this.f46672a = nVar;
        }
    }

    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements io.reactivex.rxjava3.d.h<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.d.o<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f46673a;

        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 9) {
                return this.f46673a.a();
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }

        i(io.reactivex.rxjava3.d.o<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> oVar) {
            this.f46673a = oVar;
        }
    }

    static final class v implements io.reactivex.rxjava3.d.h<Object, Object> {
        public final Object apply(Object obj) {
            return obj;
        }

        public final String toString() {
            return "IdentityFunction";
        }

        v() {
        }
    }

    static final class q implements Runnable {
        public final void run() {
        }

        public final String toString() {
            return "EmptyRunnable";
        }

        q() {
        }
    }

    static final class n implements io.reactivex.rxjava3.d.a {
        public final void run() {
        }

        public final String toString() {
            return "EmptyAction";
        }

        n() {
        }
    }

    static final class o implements io.reactivex.rxjava3.d.g<Object> {
        public final void accept(Object obj) {
        }

        public final String toString() {
            return "EmptyConsumer";
        }

        o() {
        }
    }

    static final class s implements io.reactivex.rxjava3.d.g<Throwable> {
        s() {
        }

        public final /* synthetic */ void accept(Object obj) throws Throwable {
            io.reactivex.rxjava3.h.a.a((Throwable) obj);
        }
    }

    static final class ae implements io.reactivex.rxjava3.d.g<Throwable> {
        ae() {
        }

        public final /* synthetic */ void accept(Object obj) throws Throwable {
            io.reactivex.rxjava3.h.a.a((Throwable) new io.reactivex.rxjava3.c.d((Throwable) obj));
        }
    }

    static final class p implements io.reactivex.rxjava3.d.p {
        p() {
        }
    }

    static final class aj implements io.reactivex.rxjava3.d.q<Object> {
        public final boolean test(Object obj) {
            return true;
        }

        aj() {
        }
    }

    static final class t implements io.reactivex.rxjava3.d.q<Object> {
        public final boolean test(Object obj) {
            return false;
        }

        t() {
        }
    }

    static final class ad implements io.reactivex.rxjava3.d.r<Object> {
        public final Object get() {
            return null;
        }

        ad() {
        }
    }

    static final class y implements io.reactivex.rxjava3.d.g<org.a.c> {
        y() {
        }

        public final /* synthetic */ void accept(Object obj) throws Throwable {
            ((org.a.c) obj).request(Long.MAX_VALUE);
        }
    }
}
