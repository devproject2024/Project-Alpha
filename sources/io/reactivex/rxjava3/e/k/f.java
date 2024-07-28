package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.d.a;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.CountDownLatch;

public final class f extends CountDownLatch implements a, g<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    public Throwable f47735a;

    public final /* synthetic */ void accept(Object obj) throws Throwable {
        this.f47735a = (Throwable) obj;
        countDown();
    }

    public f() {
        super(1);
    }

    public final void run() {
        countDown();
    }
}
