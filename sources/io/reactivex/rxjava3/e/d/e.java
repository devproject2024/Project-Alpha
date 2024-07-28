package io.reactivex.rxjava3.e.d;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.e.e.l;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

public final class e<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final CompletionStage<T> f46697a;

    public e(CompletionStage<T> completionStage) {
        this.f46697a = completionStage;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a();
        b bVar = new b(wVar, aVar);
        aVar.lazySet(bVar);
        wVar.onSubscribe(bVar);
        this.f46697a.whenComplete(aVar);
    }

    static final class b<T> extends l<T> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 4665335664328839859L;
        final a<T> whenReference;

        b(w<? super T> wVar, a<T> aVar) {
            super(wVar);
            this.whenReference = aVar;
        }

        public final void accept(T t, Throwable th) {
            if (th != null) {
                this.downstream.onError(th);
            } else if (t != null) {
                complete(t);
            } else {
                this.downstream.onError(new NullPointerException("The CompletionStage terminated with null."));
            }
        }

        public final void dispose() {
            super.dispose();
            this.whenReference.set((Object) null);
        }
    }

    static final class a<T> extends AtomicReference<BiConsumer<T, Throwable>> implements BiConsumer<T, Throwable> {
        private static final long serialVersionUID = 45838553147237545L;

        a() {
        }

        public final void accept(T t, Throwable th) {
            BiConsumer biConsumer = (BiConsumer) get();
            if (biConsumer != null) {
                biConsumer.accept(t, th);
            }
        }
    }
}
