package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.g;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;

public final class c extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public final boolean tryAddThrowable(Throwable th) {
        return j.a((AtomicReference<Throwable>) this, th);
    }

    public final boolean tryAddThrowableOrReport(Throwable th) {
        if (tryAddThrowable(th)) {
            return true;
        }
        a.a(th);
        return false;
    }

    public final Throwable terminate() {
        return j.a((AtomicReference<Throwable>) this);
    }

    public final boolean isTerminated() {
        return get() == j.f47736a;
    }

    public final void tryTerminateAndReport() {
        Throwable terminate = terminate();
        if (terminate != null && terminate != j.f47736a) {
            a.a(terminate);
        }
    }

    public final void tryTerminateConsumer(b<?> bVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            bVar.onComplete();
        } else if (terminate != j.f47736a) {
            bVar.onError(terminate);
        }
    }

    public final void tryTerminateConsumer(w<?> wVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            wVar.onComplete();
        } else if (terminate != j.f47736a) {
            wVar.onError(terminate);
        }
    }

    public final void tryTerminateConsumer(m<?> mVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            mVar.onComplete();
        } else if (terminate != j.f47736a) {
            mVar.onError(terminate);
        }
    }

    public final void tryTerminateConsumer(aa<?> aaVar) {
        Throwable terminate = terminate();
        if (terminate != null && terminate != j.f47736a) {
            aaVar.onError(terminate);
        }
    }

    public final void tryTerminateConsumer(d dVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            dVar.onComplete();
        } else if (terminate != j.f47736a) {
            dVar.onError(terminate);
        }
    }

    public final void tryTerminateConsumer(g<?> gVar) {
        Throwable terminate = terminate();
        if (terminate == null) {
            gVar.onComplete();
        } else if (terminate != j.f47736a) {
            gVar.onError(terminate);
        }
    }
}
