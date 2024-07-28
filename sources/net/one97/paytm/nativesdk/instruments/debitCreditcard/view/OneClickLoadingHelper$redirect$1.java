package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.l;
import kotlin.x;

final class OneClickLoadingHelper$redirect$1 extends l implements b<Throwable, x> {
    final /* synthetic */ a $suspendFunction;
    final /* synthetic */ OneClickLoadingHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneClickLoadingHelper$redirect$1(OneClickLoadingHelper oneClickLoadingHelper, a aVar) {
        super(1);
        this.this$0 = oneClickLoadingHelper;
        this.$suspendFunction = aVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f47997a;
    }

    public final void invoke(Throwable th) {
        this.this$0.redirectToBankPage(this.$suspendFunction);
    }
}
