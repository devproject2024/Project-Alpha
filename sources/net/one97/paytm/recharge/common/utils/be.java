package net.one97.paytm.recharge.common.utils;

import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.concurrent.atomic.AtomicBoolean;

public final class be<T> extends y<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f61589a = new AtomicBoolean(false);

    public final void observe(q qVar, final z<? super T> zVar) {
        hasActiveObservers();
        super.observe(qVar, new z<T>() {
            public final void onChanged(T t) {
                if (be.this.f61589a.compareAndSet(true, false)) {
                    zVar.onChanged(t);
                }
            }
        });
    }

    public final void setValue(T t) {
        this.f61589a.set(true);
        super.setValue(t);
    }
}
