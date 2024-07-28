package retrofit2.adapter.rxjava3;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.h.a;
import retrofit2.Call;
import retrofit2.Response;

final class CallExecuteObservable<T> extends p<Response<T>> {
    private final Call<T> originalCall;

    CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    public final void subscribeActual(w<? super Response<T>> wVar) {
        boolean z;
        Call<T> clone = this.originalCall.clone();
        CallDisposable callDisposable = new CallDisposable(clone);
        wVar.onSubscribe(callDisposable);
        if (!callDisposable.isDisposed()) {
            try {
                Response<T> execute = clone.execute();
                if (!callDisposable.isDisposed()) {
                    wVar.onNext(execute);
                }
                if (!callDisposable.isDisposed()) {
                    try {
                        wVar.onComplete();
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
                b.b(th);
                if (z) {
                    a.a(th);
                } else if (!callDisposable.isDisposed()) {
                    try {
                        wVar.onError(th);
                    } catch (Throwable th3) {
                        b.b(th3);
                        a.a((Throwable) new io.reactivex.rxjava3.c.a(th, th3));
                    }
                }
            }
        }
    }

    static final class CallDisposable implements c {
        private final Call<?> call;
        private volatile boolean disposed;

        CallDisposable(Call<?> call2) {
            this.call = call2;
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
