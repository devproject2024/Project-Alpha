package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.h.a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

final class CallEnqueueObservable<T> extends p<Response<T>> {
    private final Call<T> originalCall;

    CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    public final void subscribeActual(w<? super Response<T>> wVar) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, wVar);
        wVar.onSubscribe(callCallback);
        if (!callCallback.isDisposed()) {
            clone.enqueue(callCallback);
        }
    }

    static final class CallCallback<T> implements c, Callback<T> {
        private final Call<?> call;
        private volatile boolean disposed;
        private final w<? super Response<T>> observer;
        boolean terminated = false;

        CallCallback(Call<?> call2, w<? super Response<T>> wVar) {
            this.call = call2;
            this.observer = wVar;
        }

        public final void onResponse(Call<T> call2, Response<T> response) {
            if (!this.disposed) {
                try {
                    this.observer.onNext(response);
                    if (!this.disposed) {
                        this.terminated = true;
                        this.observer.onComplete();
                    }
                } catch (Throwable th) {
                    b.b(th);
                    a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th));
                }
            }
        }

        public final void onFailure(Call<T> call2, Throwable th) {
            if (!call2.isCanceled()) {
                try {
                    this.observer.onError(th);
                } catch (Throwable th2) {
                    b.b(th2);
                    a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th2));
                }
            }
        }

        public final void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        public final boolean isDisposed() {
            return this.disposed;
        }
    }
}
