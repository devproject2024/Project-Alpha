package net.one97.paytm.nativesdk;

import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;

final class ConvenienceFeeController$setConvFeeResponse$$inlined$forEach$lambda$1 extends l implements b<String, x> {
    final /* synthetic */ PaytmSDKRequestClient.ConvFeeResponse $convFeeResponse$inlined;
    final /* synthetic */ PaymentIntent $paymentIntent;
    final /* synthetic */ ConvenienceFeeController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConvenienceFeeController$setConvFeeResponse$$inlined$forEach$lambda$1(PaymentIntent paymentIntent, ConvenienceFeeController convenienceFeeController, PaytmSDKRequestClient.ConvFeeResponse convFeeResponse) {
        super(1);
        this.$paymentIntent = paymentIntent;
        this.this$0 = convenienceFeeController;
        this.$convFeeResponse$inlined = convFeeResponse;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f47997a;
    }

    public final void invoke(String str) {
        k.c(str, "it");
        this.this$0.currentLabel = str;
        this.$paymentIntent.setNativeConvFeeText(str);
    }
}
