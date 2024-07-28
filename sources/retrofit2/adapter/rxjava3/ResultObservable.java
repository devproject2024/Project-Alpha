package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.h.a;
import retrofit2.Response;

final class ResultObservable<T> extends p<Result<T>> {
    private final p<Response<T>> upstream;

    ResultObservable(p<Response<T>> pVar) {
        this.upstream = pVar;
    }

    public final void subscribeActual(w<? super Result<T>> wVar) {
        this.upstream.subscribe(new ResultObserver(wVar));
    }

    static class ResultObserver<R> implements w<Response<R>> {
        private final w<? super Result<R>> observer;

        ResultObserver(w<? super Result<R>> wVar) {
            this.observer = wVar;
        }

        public void onSubscribe(c cVar) {
            this.observer.onSubscribe(cVar);
        }

        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }

        public void onError(Throwable th) {
            try {
                this.observer.onNext(Result.error(th));
                this.observer.onComplete();
            } catch (Throwable th2) {
                b.b(th2);
                a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th2));
            }
        }

        public void onComplete() {
            this.observer.onComplete();
        }
    }
}
