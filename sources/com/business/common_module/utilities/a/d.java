package com.business.common_module.utilities.a;

import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.business.common_module.utilities.LogUtility;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d<T> extends y<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f7362a = new AtomicBoolean(false);

    public final void observe(q qVar, final z<? super T> zVar) {
        if (hasActiveObservers()) {
            LogUtility.d("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(qVar, new z<T>() {
            public final void onChanged(T t) {
                if (d.this.f7362a.compareAndSet(true, false)) {
                    zVar.onChanged(t);
                }
            }
        });
    }

    public final void setValue(T t) {
        this.f7362a.set(true);
        super.setValue(t);
    }
}
