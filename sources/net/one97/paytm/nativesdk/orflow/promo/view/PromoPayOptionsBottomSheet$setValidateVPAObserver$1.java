package net.one97.paytm.nativesdk.orflow.promo.view;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse;

public final class PromoPayOptionsBottomSheet$setValidateVPAObserver$1 implements z<VerifyVpaResponse> {
    final /* synthetic */ PromoPayOptionsBottomSheet this$0;

    PromoPayOptionsBottomSheet$setValidateVPAObserver$1(PromoPayOptionsBottomSheet promoPayOptionsBottomSheet) {
        this.this$0 = promoPayOptionsBottomSheet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r5 = r5.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.instruments.upicollect.models.ResponseBody r5 = r5.getBody()
            if (r5 == 0) goto L_0x000e
            java.lang.Boolean r5 = r5.getValid()
            goto L_0x000f
        L_0x000e:
            r5 = r0
        L_0x000f:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r1)
            if (r5 == 0) goto L_0x0040
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r5 = r4.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r5 = r5.selectedPayOption
            if (r5 == 0) goto L_0x002a
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r0 = r4.this$0
            int r1 = net.one97.paytm.nativesdk.R.string.native_enter_valid_vpa_address
            java.lang.String r0 = r0.getString(r1)
            r5.setInputError(r0)
        L_0x002a:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r5 = r4.this$0
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionListAdapter r5 = r5.mPayOptionListAdapter
            if (r5 == 0) goto L_0x0035
            r5.notifyDataSetChanged()
        L_0x0035:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r5 = r4.this$0
            r5.scrollRecyclerView()
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r5 = r4.this$0
            r5.hideLoadingState()
            return
        L_0x0040:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            net.one97.paytm.nativesdk.common.model.PaymentIntent r1 = new net.one97.paytm.nativesdk.common.model.PaymentIntent
            r1.<init>()
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r2 = r4.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r2 = r2.selectedPayOption
            if (r2 == 0) goto L_0x0057
            java.lang.String r2 = r2.getMode()
            goto L_0x0058
        L_0x0057:
            r2 = r0
        L_0x0058:
            r1.setMode(r2)
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r2 = r4.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r2 = r2.selectedPayOption
            if (r2 == 0) goto L_0x0067
            java.lang.String r0 = r2.getUpiAddress()
        L_0x0067:
            r1.setVpa(r0)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            double r2 = r0.getAmount()
            r1.setTxnAmount(r2)
            r5.add(r1)
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r0 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r0 = r0.getInstance()
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r1 = r4.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r1 = r1.selectedPayOption
            if (r1 != 0) goto L_0x008b
            kotlin.g.b.k.a()
        L_0x008b:
            r0.onPaymentModeSelected(r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet$setValidateVPAObserver$1.onChanged(net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse):void");
    }
}
