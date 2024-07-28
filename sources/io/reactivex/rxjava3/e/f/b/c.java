package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.d.d;
import io.reactivex.rxjava3.d.h;

public final class c<T, K> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final h<? super T, K> f46774c;

    /* renamed from: d  reason: collision with root package name */
    final d<? super K, ? super K> f46775d;

    public c(io.reactivex.rxjava3.a.h<T> hVar, h<? super T, K> hVar2, d<? super K, ? super K> dVar) {
        super(hVar);
        this.f46774c = hVar2;
        this.f46775d = dVar;
    }

    public final void b(org.a.b<? super T> bVar) {
        if (bVar instanceof io.reactivex.rxjava3.e.c.c) {
            this.f46770b.a(new a((io.reactivex.rxjava3.e.c.c) bVar, this.f46774c, this.f46775d));
        } else {
            this.f46770b.a(new b(bVar, this.f46774c, this.f46775d));
        }
    }

    static final class b<T, K> extends io.reactivex.rxjava3.e.i.b<T, T> implements io.reactivex.rxjava3.e.c.c<T> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T, K> f46780a;

        /* renamed from: b  reason: collision with root package name */
        final d<? super K, ? super K> f46781b;

        /* renamed from: c  reason: collision with root package name */
        K f46782c;

        /* renamed from: d  reason: collision with root package name */
        boolean f46783d;

        b(org.a.b<? super T> bVar, h<? super T, K> hVar, d<? super K, ? super K> dVar) {
            super(bVar);
            this.f46780a = hVar;
            this.f46781b = dVar;
        }

        public final void onNext(T t) {
            if (!a(t)) {
                this.f47723f.request(1);
            }
        }

        public final boolean a(T t) {
            if (this.f47725h) {
                return false;
            }
            if (this.f47726i != 0) {
                this.f47722e.onNext(t);
                return true;
            }
            try {
                K apply = this.f46780a.apply(t);
                if (this.f46783d) {
                    boolean a2 = this.f46781b.a(this.f46782c, apply);
                    this.f46782c = apply;
                    if (a2) {
                        return false;
                    }
                } else {
                    this.f46783d = true;
                    this.f46782c = apply;
                }
                this.f47722e.onNext(t);
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final T poll() throws Throwable {
            while (true) {
                T poll = this.f47724g.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f46780a.apply(poll);
                if (!this.f46783d) {
                    this.f46783d = true;
                    this.f46782c = apply;
                    return poll;
                } else if (!this.f46781b.a(this.f46782c, apply)) {
                    this.f46782c = apply;
                    return poll;
                } else {
                    this.f46782c = apply;
                    if (this.f47726i != 1) {
                        this.f47723f.request(1);
                    }
                }
            }
        }
    }

    static final class a<T, K> extends io.reactivex.rxjava3.e.i.a<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T, K> f46776a;

        /* renamed from: b  reason: collision with root package name */
        final d<? super K, ? super K> f46777b;

        /* renamed from: c  reason: collision with root package name */
        K f46778c;

        /* renamed from: d  reason: collision with root package name */
        boolean f46779d;

        a(io.reactivex.rxjava3.e.c.c<? super T> cVar, h<? super T, K> hVar, d<? super K, ? super K> dVar) {
            super(cVar);
            this.f46776a = hVar;
            this.f46777b = dVar;
        }

        public final void onNext(T t) {
            if (!a(t)) {
                this.f47718f.request(1);
            }
        }

        public final boolean a(T t) {
            if (this.f47720h) {
                return false;
            }
            if (this.f47721i != 0) {
                return this.f47717e.a(t);
            }
            try {
                K apply = this.f46776a.apply(t);
                if (this.f46779d) {
                    boolean a2 = this.f46777b.a(this.f46778c, apply);
                    this.f46778c = apply;
                    if (a2) {
                        return false;
                    }
                } else {
                    this.f46779d = true;
                    this.f46778c = apply;
                }
                this.f47717e.onNext(t);
                return true;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final T poll() throws Throwable {
            while (true) {
                T poll = this.f47719g.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f46776a.apply(poll);
                if (!this.f46779d) {
                    this.f46779d = true;
                    this.f46778c = apply;
                    return poll;
                } else if (!this.f46777b.a(this.f46778c, apply)) {
                    this.f46778c = apply;
                    return poll;
                } else {
                    this.f46778c = apply;
                    if (this.f47721i != 1) {
                        this.f47718f.request(1);
                    }
                }
            }
        }
    }
}
