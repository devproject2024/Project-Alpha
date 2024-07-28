package net.one97.paytm.nativesdk.Utils;

import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SingleLiveEvent<T> extends y<T> {
    public static final Companion Companion = new Companion((g) null);
    private static final String TAG = TAG;
    /* access modifiers changed from: private */
    public final AtomicBoolean pending = new AtomicBoolean(false);

    public final void observe(q qVar, z<? super T> zVar) {
        k.c(qVar, "owner");
        k.c(zVar, "observer");
        super.observe(qVar, zVar);
        hasActiveObservers();
        super.observe(qVar, new SingleLiveEvent$observe$1(this, zVar));
    }

    public final void setValue(T t) {
        this.pending.set(true);
        super.setValue(t);
    }

    public final void call() {
        setValue((Object) null);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
