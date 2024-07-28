package net.one97.paytm.nativesdk.paymethods.viewmodel;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@f(b = "InstrumentSheetViewModel.kt", c = {84}, d = "invokeSuspend", e = "net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel$addPaymentViews$1")
final class InstrumentSheetViewModel$addPaymentViews$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ boolean $addMoneyInstruments;
    Object L$0;
    Object L$1;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ InstrumentSheetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstrumentSheetViewModel$addPaymentViews$1(InstrumentSheetViewModel instrumentSheetViewModel, boolean z, d dVar) {
        super(2, dVar);
        this.this$0 = instrumentSheetViewModel;
        this.$addMoneyInstruments = z;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        InstrumentSheetViewModel$addPaymentViews$1 instrumentSheetViewModel$addPaymentViews$1 = new InstrumentSheetViewModel$addPaymentViews$1(this.this$0, this.$addMoneyInstruments, dVar);
        instrumentSheetViewModel$addPaymentViews$1.p$ = (CoroutineScope) obj;
        return instrumentSheetViewModel$addPaymentViews$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((InstrumentSheetViewModel$addPaymentViews$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (kotlin.d.f) null, (CoroutineStart) null, new InstrumentSheetViewModel$addPaymentViews$1$deferred$1(this, (d) null), 3, (Object) null);
            this.L$0 = coroutineScope;
            this.L$1 = async$default;
            this.label = 1;
            if (async$default.await(this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.postInstrumentsToUI();
        return x.f47997a;
    }
}
