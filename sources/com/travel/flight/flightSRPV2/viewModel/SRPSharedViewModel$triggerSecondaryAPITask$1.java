package com.travel.flight.flightSRPV2.viewModel;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

@f(b = "SRPSharedViewModel.kt", c = {309, 311}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel$triggerSecondaryAPITask$1")
final class SRPSharedViewModel$triggerSecondaryAPITask$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SRPSharedViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SRPSharedViewModel$triggerSecondaryAPITask$1(SRPSharedViewModel sRPSharedViewModel, d dVar) {
        super(2, dVar);
        this.this$0 = sRPSharedViewModel;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        SRPSharedViewModel$triggerSecondaryAPITask$1 sRPSharedViewModel$triggerSecondaryAPITask$1 = new SRPSharedViewModel$triggerSecondaryAPITask$1(this.this$0, dVar);
        sRPSharedViewModel$triggerSecondaryAPITask$1.p$ = (CoroutineScope) obj;
        return sRPSharedViewModel$triggerSecondaryAPITask$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SRPSharedViewModel$triggerSecondaryAPITask$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    @f(b = "SRPSharedViewModel.kt", c = {}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel$triggerSecondaryAPITask$1$1")
    /* renamed from: com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel$triggerSecondaryAPITask$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ SRPSharedViewModel$triggerSecondaryAPITask$1 this$0;

        {
            this.this$0 = r1;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, dVar);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            a aVar = a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                this.this$0.this$0.callSecondaryAPI();
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            coroutineScope = this.p$;
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(12000, this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.a(obj);
        } else if (i2 == 2) {
            ResultKt.a(obj);
            return x.f47997a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = coroutineScope;
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this, (d) null), this) == aVar) {
            return aVar;
        }
        return x.f47997a;
    }
}
