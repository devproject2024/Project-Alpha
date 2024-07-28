package com.business.merchant_payments.utility;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "BackgroundTaskExecutor.kt", c = {25}, d = "invokeSuspend", e = "com.business.merchant_payments.utility.BackgroundTaskExecutor$execute$1$data$1")
public final class BackgroundTaskExecutor$execute$1$data$1 extends k implements m<CoroutineScope, d<? super T>, Object> {
    public Object L$0;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ BackgroundTaskExecutor$execute$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackgroundTaskExecutor$execute$1$data$1(BackgroundTaskExecutor$execute$1 backgroundTaskExecutor$execute$1, d dVar) {
        super(2, dVar);
        this.this$0 = backgroundTaskExecutor$execute$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        BackgroundTaskExecutor$execute$1$data$1 backgroundTaskExecutor$execute$1$data$1 = new BackgroundTaskExecutor$execute$1$data$1(this.this$0, dVar);
        backgroundTaskExecutor$execute$1$data$1.p$ = (CoroutineScope) obj;
        return backgroundTaskExecutor$execute$1$data$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BackgroundTaskExecutor$execute$1$data$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            BackgroundTaskExecutor$execute$1 backgroundTaskExecutor$execute$1 = this.this$0;
            BackgroundTaskExecutor backgroundTaskExecutor = backgroundTaskExecutor$execute$1.this$0;
            kotlin.g.a.a aVar2 = backgroundTaskExecutor$execute$1.$method;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = backgroundTaskExecutor.backgroundTask(aVar2, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
