package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.d;
import io.reactivex.rxjava3.d.h;

public final class ak<T, K> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, K> f46963b;

    /* renamed from: c  reason: collision with root package name */
    final d<? super K, ? super K> f46964c;

    public ak(u<T> uVar, h<? super T, K> hVar, d<? super K, ? super K> dVar) {
        super(uVar);
        this.f46963b = hVar;
        this.f46964c = dVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f46963b, this.f46964c));
    }

    static final class a<T, K> extends io.reactivex.rxjava3.e.e.a<T, T> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T, K> f46965a;

        /* renamed from: g  reason: collision with root package name */
        final d<? super K, ? super K> f46966g;

        /* renamed from: h  reason: collision with root package name */
        K f46967h;

        /* renamed from: i  reason: collision with root package name */
        boolean f46968i;

        a(w<? super T> wVar, h<? super T, K> hVar, d<? super K, ? super K> dVar) {
            super(wVar);
            this.f46965a = hVar;
            this.f46966g = dVar;
        }

        public final void onNext(T t) {
            if (!this.f46717e) {
                if (this.f46718f != 0) {
                    this.f46714b.onNext(t);
                    return;
                }
                try {
                    K apply = this.f46965a.apply(t);
                    if (this.f46968i) {
                        boolean a2 = this.f46966g.a(this.f46967h, apply);
                        this.f46967h = apply;
                        if (a2) {
                            return;
                        }
                    } else {
                        this.f46968i = true;
                        this.f46967h = apply;
                    }
                    this.f46714b.onNext(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        public final int requestFusion(int i2) {
            return a(i2);
        }

        public final T poll() throws Throwable {
            while (true) {
                T poll = this.f46716d.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f46965a.apply(poll);
                if (!this.f46968i) {
                    this.f46968i = true;
                    this.f46967h = apply;
                    return poll;
                } else if (!this.f46966g.a(this.f46967h, apply)) {
                    this.f46967h = apply;
                    return poll;
                } else {
                    this.f46967h = apply;
                }
            }
        }
    }
}
