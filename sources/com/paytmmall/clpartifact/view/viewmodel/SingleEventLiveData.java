package com.paytmmall.clpartifact.view.viewmodel;

import androidx.lifecycle.q;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleEventLiveData<T> extends w<T> {
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    public void observe(q qVar, z<? super T> zVar) {
        super.observe(qVar, new z(zVar) {
            private final /* synthetic */ z f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                SingleEventLiveData.this.lambda$observe$0$SingleEventLiveData(this.f$1, obj);
            }
        });
    }

    public /* synthetic */ void lambda$observe$0$SingleEventLiveData(z zVar, Object obj) {
        if (this.mPending.compareAndSet(true, false)) {
            zVar.onChanged(obj);
        }
    }

    public void setValue(T t) {
        this.mPending.set(true);
        super.setValue(t);
    }
}
