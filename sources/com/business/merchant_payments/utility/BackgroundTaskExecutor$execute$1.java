package com.business.merchant_payments.utility;

import com.business.merchant_payments.utility.BackgroundTaskExecutor;
import kotlin.ResultKt;
import kotlin.d.b.a.b;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@f(b = "BackgroundTaskExecutor.kt", c = {25}, d = "invokeSuspend", e = "com.business.merchant_payments.utility.BackgroundTaskExecutor$execute$1")
public final class BackgroundTaskExecutor$execute$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ long $id;
    public final /* synthetic */ a $method;
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ BackgroundTaskExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackgroundTaskExecutor$execute$1(BackgroundTaskExecutor backgroundTaskExecutor, a aVar, long j, d dVar) {
        super(2, dVar);
        this.this$0 = backgroundTaskExecutor;
        this.$method = aVar;
        this.$id = j;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        BackgroundTaskExecutor$execute$1 backgroundTaskExecutor$execute$1 = new BackgroundTaskExecutor$execute$1(this.this$0, this.$method, this.$id, dVar);
        backgroundTaskExecutor$execute$1.p$ = (CoroutineScope) obj;
        return backgroundTaskExecutor$execute$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BackgroundTaskExecutor$execute$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
            BackgroundTaskExecutor$execute$1$data$1 backgroundTaskExecutor$execute$1$data$1 = new BackgroundTaskExecutor$execute$1$data$1(this, (d) null);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = BuildersKt.withContext(coroutineDispatcher, backgroundTaskExecutor$execute$1$data$1, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.a(obj);
            } catch (Exception e2) {
                Object obj2 = this.this$0.getListeners().get(b.a(this.$id));
                if (!(obj2 instanceof BackgroundTaskExecutor.BackgroundTaskListener)) {
                    obj2 = null;
                }
                BackgroundTaskExecutor.BackgroundTaskListener backgroundTaskListener = (BackgroundTaskExecutor.BackgroundTaskListener) obj2;
                if (backgroundTaskListener != null) {
                    backgroundTaskListener.onError(e2);
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object obj3 = this.this$0.getListeners().get(b.a(this.$id));
        if (!(obj3 instanceof BackgroundTaskExecutor.BackgroundTaskListener)) {
            obj3 = null;
        }
        BackgroundTaskExecutor.BackgroundTaskListener backgroundTaskListener2 = (BackgroundTaskExecutor.BackgroundTaskListener) obj3;
        if (backgroundTaskListener2 != null) {
            backgroundTaskListener2.onSuccess(obj);
        }
        this.this$0.getListeners().remove(b.a(this.$id));
        return x.f47997a;
    }
}
