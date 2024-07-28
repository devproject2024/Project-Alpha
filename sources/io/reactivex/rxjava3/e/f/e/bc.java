package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.e.c;
import java.util.Objects;

public final class bc<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f47035a;

    public bc(T[] tArr) {
        this.f47035a = tArr;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar, this.f47035a);
        wVar.onSubscribe(aVar);
        if (!aVar.f47039d) {
            T[] tArr = aVar.f47037b;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !aVar.isDisposed(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    w<? super T> wVar2 = aVar.f47036a;
                    wVar2.onError(new NullPointerException("The element at index " + i2 + " is null"));
                    return;
                }
                aVar.f47036a.onNext(t);
            }
            if (!aVar.isDisposed()) {
                aVar.f47036a.onComplete();
            }
        }
    }

    static final class a<T> extends c<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47036a;

        /* renamed from: b  reason: collision with root package name */
        final T[] f47037b;

        /* renamed from: c  reason: collision with root package name */
        int f47038c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47039d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f47040e;

        a(w<? super T> wVar, T[] tArr) {
            this.f47036a = wVar;
            this.f47037b = tArr;
        }

        public final int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f47039d = true;
            return 1;
        }

        public final T poll() {
            int i2 = this.f47038c;
            T[] tArr = this.f47037b;
            if (i2 == tArr.length) {
                return null;
            }
            this.f47038c = i2 + 1;
            return Objects.requireNonNull(tArr[i2], "The array element is null");
        }

        public final boolean isEmpty() {
            return this.f47038c == this.f47037b.length;
        }

        public final void clear() {
            this.f47038c = this.f47037b.length;
        }

        public final void dispose() {
            this.f47040e = true;
        }

        public final boolean isDisposed() {
            return this.f47040e;
        }
    }
}
