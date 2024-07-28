package net.one97.paytm.nativesdk.orflow.promo.view;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse;

public final class PromoPayOptionsBottomSheet$checkBalanceObserver$1 implements z<CJRFetchBalanceResponse> {
    final /* synthetic */ PromoPayOptionsBottomSheet this$0;

    PromoPayOptionsBottomSheet$checkBalanceObserver$1(PromoPayOptionsBottomSheet promoPayOptionsBottomSheet) {
        this.this$0 = promoPayOptionsBottomSheet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = (r0 = r2.getBody()).getBalanceInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0013
            net.one97.paytm.nativesdk.paymethods.model.fetchBalance.Body r0 = r2.getBody()
            if (r0 == 0) goto L_0x0013
            net.one97.paytm.nativesdk.paymethods.model.fetchBalance.BalanceInfo r0 = r0.getBalanceInfo()
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getValue()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x002d
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r2 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r2 = r2.getInstance()
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet$checkBalanceObserver$1$onChanged$1 r0 = new net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet$checkBalanceObserver$1$onChanged$1
            r0.<init>(r1)
            net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$ApplyAnotherOfferListener r0 = (net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.ApplyAnotherOfferListener) r0
            r2.clearPromo(r0)
            return
        L_0x002d:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r0 = r1.this$0
            net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam r0 = r0.selectedPayOption
            if (r0 == 0) goto L_0x0038
            r0.setFetchBalanceResponse(r2)
        L_0x0038:
            net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet r2 = r1.this$0
            r2.applyOfferPostPaid()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.PromoPayOptionsBottomSheet$checkBalanceObserver$1.onChanged(net.one97.paytm.nativesdk.paymethods.model.fetchBalance.CJRFetchBalanceResponse):void");
    }
}
