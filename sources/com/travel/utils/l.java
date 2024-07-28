package com.travel.utils;

import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.k;

public final class l<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final AtomicBoolean f28537a = new AtomicBoolean(false);

    public final void observe(q qVar, z<? super T> zVar) {
        k.c(qVar, "owner");
        k.c(zVar, "observer");
        hasActiveObservers();
        super.observe(qVar, new a(this, zVar));
    }

    static final class a<T> implements z<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f28538a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f28539b;

        a(l lVar, z zVar) {
            this.f28538a = lVar;
            this.f28539b = zVar;
        }

        public final void onChanged(T t) {
            if (this.f28538a.f28537a.compareAndSet(true, false)) {
                this.f28539b.onChanged(t);
            }
        }
    }

    public final void setValue(T t) {
        this.f28537a.set(true);
        super.setValue(t);
    }

    public final void postValue(T t) {
        this.f28537a.set(true);
        super.postValue(t);
    }
}
