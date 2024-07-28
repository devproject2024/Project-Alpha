package io.reactivex.rxjava3.b;

import io.reactivex.rxjava3.e.k.j;

public final class a extends e<io.reactivex.rxjava3.d.a> {
    private static final long serialVersionUID = -8219729196779211169L;

    public a(io.reactivex.rxjava3.d.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public final void onDisposed(io.reactivex.rxjava3.d.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw j.a(th);
        }
    }

    public final String toString() {
        return "ActionDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
