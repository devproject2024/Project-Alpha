package com.business.merchant_payments.utility;

import androidx.lifecycle.aa;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.b.g;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class BackgroundTaskExecutor implements p {
    public k lifecycle;
    public final Map<Long, Object> listeners;

    public interface BackgroundTaskListener<A> {
        void onError(Exception exc);

        void onSuccess(A a2);
    }

    public BackgroundTaskExecutor() {
        this((k) null, 1, (g) null);
    }

    public BackgroundTaskExecutor(k kVar) {
        this.lifecycle = kVar;
        this.listeners = new LinkedHashMap();
        k kVar2 = this.lifecycle;
        if (kVar2 != null) {
            kVar2.a(this);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BackgroundTaskExecutor(k kVar, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : kVar);
    }

    public final k getLifecycle() {
        return this.lifecycle;
    }

    public final void setLifecycle(k kVar) {
        this.lifecycle = kVar;
    }

    public final Map<Long, Object> getListeners() {
        return this.listeners;
    }

    public final <T> void execute(a<? extends T> aVar, BackgroundTaskListener<T> backgroundTaskListener) {
        kotlin.g.b.k.d(aVar, "method");
        kotlin.g.b.k.d(backgroundTaskListener, "listener");
        long currentTimeMillis = System.currentTimeMillis();
        this.listeners.put(Long.valueOf(currentTimeMillis), backgroundTaskListener);
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new BackgroundTaskExecutor$execute$1(this, aVar, currentTimeMillis, (d) null), 2, (Object) null);
    }

    public final /* synthetic */ <T> Object backgroundTask(a<? extends T> aVar, d<? super T> dVar) {
        return aVar.invoke();
    }

    @aa(a = k.a.ON_DESTROY)
    public final void destroy() {
        k kVar = this.lifecycle;
        if (kVar != null) {
            kVar.b(this);
        }
        this.lifecycle = null;
        this.listeners.clear();
    }
}
