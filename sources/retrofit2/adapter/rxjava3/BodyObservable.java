package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.h.a;
import retrofit2.Response;

final class BodyObservable<T> extends p<T> {
    private final p<Response<T>> upstream;

    BodyObservable(p<Response<T>> pVar) {
        this.upstream = pVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.upstream.subscribe(new BodyObserver(wVar));
    }

    static class BodyObserver<R> implements w<Response<R>> {
        private final w<? super R> observer;
        private boolean terminated;

        BodyObserver(w<? super R> wVar) {
            this.observer = wVar;
        }

        public void onSubscribe(c cVar) {
            this.observer.onSubscribe(cVar);
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th) {
                b.b(th);
                a.a((Throwable) new io.reactivex.rxjava3.c.a(httpException, th));
            }
        }

        public void onComplete() {
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.terminated) {
                this.observer.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            a.a((Throwable) assertionError);
        }
    }
}
