package net.one97.paytm.nativesdk.paymethods.viewmodel;

import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "InstrumentSheetViewModel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.nativesdk.paymethods.viewmodel.InstrumentSheetViewModel$addPaymentViews$1$deferred$1")
final class InstrumentSheetViewModel$addPaymentViews$1$deferred$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    int label;
    private CoroutineScope p$;
    final /* synthetic */ InstrumentSheetViewModel$addPaymentViews$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstrumentSheetViewModel$addPaymentViews$1$deferred$1(InstrumentSheetViewModel$addPaymentViews$1 instrumentSheetViewModel$addPaymentViews$1, d dVar) {
        super(2, dVar);
        this.this$0 = instrumentSheetViewModel$addPaymentViews$1;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        InstrumentSheetViewModel$addPaymentViews$1$deferred$1 instrumentSheetViewModel$addPaymentViews$1$deferred$1 = new InstrumentSheetViewModel$addPaymentViews$1$deferred$1(this.this$0, dVar);
        instrumentSheetViewModel$addPaymentViews$1$deferred$1.p$ = (CoroutineScope) obj;
        return instrumentSheetViewModel$addPaymentViews$1$deferred$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((InstrumentSheetViewModel$addPaymentViews$1$deferred$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            this.this$0.this$0.getMInstrumentsList().clear();
            this.this$0.this$0.initialize(this.this$0.$addMoneyInstruments);
            this.this$0.this$0.addMGVInstrument();
            this.this$0.this$0.addWalletView();
            this.this$0.this$0.addVpas(this.this$0.$addMoneyInstruments);
            this.this$0.this$0.initializeEmiParameters(this.this$0.$addMoneyInstruments);
            this.this$0.this$0.addPaymentFlowSpecificViews(this.this$0.$addMoneyInstruments);
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
