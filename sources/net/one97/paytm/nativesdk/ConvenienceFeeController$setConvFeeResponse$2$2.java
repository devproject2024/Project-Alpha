package net.one97.paytm.nativesdk;

import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;

final class ConvenienceFeeController$setConvFeeResponse$2$2 extends l implements b<String, x> {
    final /* synthetic */ PaymentIntent $paymentIntent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConvenienceFeeController$setConvFeeResponse$2$2(PaymentIntent paymentIntent) {
        super(1);
        this.$paymentIntent = paymentIntent;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f47997a;
    }

    public final void invoke(String str) {
        k.c(str, "it");
        this.$paymentIntent.setFeePercent(str);
    }
}
