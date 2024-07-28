package com.travel.flight.flightSRPV2.c;

import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.k;

public final class b<T> extends y<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f24152a = new AtomicBoolean(false);

    static final class a<T> implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f24153a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f24154b;

        a(b bVar, z zVar) {
            this.f24153a = bVar;
            this.f24154b = zVar;
        }

        public final void onChanged(T t) {
            if (this.f24153a.f24152a.compareAndSet(true, false)) {
                this.f24154b.onChanged(t);
            }
        }
    }

    public final void observe(q qVar, z<? super T> zVar) {
        k.c(qVar, "owner");
        k.c(zVar, "observer");
        super.observe(qVar, new a(this, zVar));
    }

    public final void setValue(T t) {
        this.f24152a.set(true);
        super.setValue(t);
    }

    public final void postValue(T t) {
        this.f24152a.set(true);
        super.postValue(t);
    }
}
