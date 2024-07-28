package com.travel.flight.flightSRPV2.viewModel;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@f(b = "IRTViewModel.kt", c = {76}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.IRTViewModel$updateSRPCopy$delayTask$1")
final class IRTViewModel$updateSRPCopy$delayTask$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;

    IRTViewModel$updateSRPCopy$delayTask$1(d dVar) {
        super(2, dVar);
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        IRTViewModel$updateSRPCopy$delayTask$1 iRTViewModel$updateSRPCopy$delayTask$1 = new IRTViewModel$updateSRPCopy$delayTask$1(dVar);
        iRTViewModel$updateSRPCopy$delayTask$1.p$ = (CoroutineScope) obj;
        return iRTViewModel$updateSRPCopy$delayTask$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((IRTViewModel$updateSRPCopy$delayTask$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            this.L$0 = this.p$;
            this.label = 1;
            if (DelayKt.delay(500, this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return x.f47997a;
    }
}
