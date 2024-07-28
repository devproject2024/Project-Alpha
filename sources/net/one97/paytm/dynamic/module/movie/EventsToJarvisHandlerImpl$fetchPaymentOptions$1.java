package net.one97.paytm.dynamic.module.movie;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.o2o.events.b.b;

public final class EventsToJarvisHandlerImpl$fetchPaymentOptions$1 implements FetchPayOptionsListener {
    final /* synthetic */ b $fetchEventPayOptionsListener;

    public final void onPaymentOptionsError() {
    }

    public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
        k.c(cJPayMethodResponse, "cjPayMethodResponse");
    }

    public final void onRequestStart() {
    }

    public final void onVpaReceived(VpaFetch vpaFetch) {
        k.c(vpaFetch, "vpaFetch");
    }

    EventsToJarvisHandlerImpl$fetchPaymentOptions$1(b bVar) {
        this.$fetchEventPayOptionsListener = bVar;
    }

    public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
    }
}
