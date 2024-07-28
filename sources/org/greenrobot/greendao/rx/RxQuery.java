package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.query.Query;
import rx.Observable;
import rx.Scheduler;

public class RxQuery<T> extends RxBase {
    /* access modifiers changed from: private */
    public final Query<T> query;

    public /* bridge */ /* synthetic */ Scheduler getScheduler() {
        return super.getScheduler();
    }

    public RxQuery(Query<T> query2) {
        this.query = query2;
    }

    public RxQuery(Query<T> query2, Scheduler scheduler) {
        super(scheduler);
        this.query = query2;
    }

    public Observable<List<T>> list() {
        return wrap(new Callable<List<T>>() {
            public List<T> call() throws Exception {
                return RxQuery.this.query.forCurrentThread().list();
            }
        });
    }

    public Observable<T> unique() {
        return wrap(new Callable<T>() {
            public T call() throws Exception {
                return RxQuery.this.query.forCurrentThread().unique();
            }
        });
    }

    public Observable<T> oneByOne() {
        return wrap(Observable.create(new Observable.OnSubscribe<T>() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void call(rx.Subscriber<? super T> r5) {
                /*
                    r4 = this;
                    org.greenrobot.greendao.rx.RxQuery r0 = org.greenrobot.greendao.rx.RxQuery.this     // Catch:{ all -> 0x0038 }
                    org.greenrobot.greendao.query.Query r0 = r0.query     // Catch:{ all -> 0x0038 }
                    org.greenrobot.greendao.query.Query r0 = r0.forCurrentThread()     // Catch:{ all -> 0x0038 }
                    org.greenrobot.greendao.query.LazyList r0 = r0.listLazyUncached()     // Catch:{ all -> 0x0038 }
                    java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x0033 }
                L_0x0012:
                    boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0033 }
                    if (r2 == 0) goto L_0x0026
                    java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0033 }
                    boolean r3 = r5.isUnsubscribed()     // Catch:{ all -> 0x0033 }
                    if (r3 != 0) goto L_0x0026
                    r5.onNext(r2)     // Catch:{ all -> 0x0033 }
                    goto L_0x0012
                L_0x0026:
                    r0.close()     // Catch:{ all -> 0x0038 }
                    boolean r0 = r5.isUnsubscribed()     // Catch:{ all -> 0x0038 }
                    if (r0 != 0) goto L_0x0032
                    r5.onCompleted()     // Catch:{ all -> 0x0038 }
                L_0x0032:
                    return
                L_0x0033:
                    r1 = move-exception
                    r0.close()     // Catch:{ all -> 0x0038 }
                    throw r1     // Catch:{ all -> 0x0038 }
                L_0x0038:
                    r0 = move-exception
                    rx.exceptions.Exceptions.throwIfFatal(r0)
                    r5.onError(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.rx.RxQuery.AnonymousClass3.call(rx.Subscriber):void");
            }
        }));
    }
}
