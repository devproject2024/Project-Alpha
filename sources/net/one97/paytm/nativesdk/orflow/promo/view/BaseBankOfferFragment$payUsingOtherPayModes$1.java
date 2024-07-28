package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.Context;
import android.widget.Toast;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.orflow.interfaces.OrFlowCallbackListener;

public final class BaseBankOfferFragment$payUsingOtherPayModes$1 implements PaytmSDKRequestClient.OtherPayOptionsListener {
    final /* synthetic */ BaseBankOfferFragment this$0;

    BaseBankOfferFragment$payUsingOtherPayModes$1(BaseBankOfferFragment baseBankOfferFragment) {
        this.this$0 = baseBankOfferFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r1 = r4.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setFetchPayOptionsResponse(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r4, double r5) {
        /*
            r3 = this;
            net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment r0 = r3.this$0
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            r0 = 0
            if (r4 == 0) goto L_0x0017
            net.one97.paytm.nativesdk.common.model.Body r1 = r4.getBody()
            if (r1 == 0) goto L_0x0017
            net.one97.paytm.nativesdk.common.model.MerchantPayOption r1 = r1.getMerchantPayOption()
            goto L_0x0018
        L_0x0017:
            r1 = r0
        L_0x0018:
            if (r1 == 0) goto L_0x0067
            java.util.ArrayList r2 = r1.getPaymentModes()
            if (r2 == 0) goto L_0x002a
            java.util.ArrayList r2 = r1.getPaymentModes()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x003b
        L_0x002a:
            java.util.ArrayList r2 = r1.getSavedInstruments()
            if (r2 == 0) goto L_0x0067
            java.util.ArrayList r1 = r1.getSavedInstruments()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x003b
            goto L_0x0067
        L_0x003b:
            net.one97.paytm.nativesdk.MerchantBL r1 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r1.setAmount(r5)
            net.one97.paytm.nativesdk.orflow.Utility r5 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            r5.updateTxnAmountPaymentIntent()
            net.one97.paytm.nativesdk.MerchantBL r5 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r6 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r5.setOrderId(r0)
            net.one97.paytm.nativesdk.MerchantBL r5 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            r5.setTxnToken(r0)
            net.one97.paytm.nativesdk.PaytmSDK.setResponse(r4, r0)
            net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment r4 = r3.this$0
            r4.startInstrumentActivity()
            return
        L_0x0067:
            net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment r4 = r3.this$0
            r4.hideOtherPayModeLoading()
            net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment r4 = r3.this$0
            r4.enableUiInteraction()
            net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment r4 = r3.this$0
            android.content.Context r4 = r4.getContext()
            net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment r5 = r3.this$0
            int r6 = net.one97.paytm.nativesdk.R.string.something_went_wrong
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r5, r6)
            r4.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment$payUsingOtherPayModes$1.setFetchPayOptionsResponse(net.one97.paytm.nativesdk.common.model.CJPayMethodResponse, double):void");
    }

    public final void onError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        CharSequence charSequence;
        String errorMsg;
        if (apiResponseError != null && apiResponseError.isShouldClosePG()) {
            this.this$0.dismiss();
            this.this$0.cancelOrder();
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            OrFlowCallbackListener orFlowCallbackListener = instance.getOrFlowCallbackListener();
            if (orFlowCallbackListener != null) {
                orFlowCallbackListener.finishActivity();
            }
        } else if (this.this$0.getContext() != null) {
            Context context = this.this$0.getContext();
            if (!(apiResponseError == null || (errorMsg = apiResponseError.getErrorMsg()) == null)) {
                if (!(true ^ (errorMsg.length() == 0))) {
                    errorMsg = null;
                }
                if (errorMsg != null) {
                    charSequence = errorMsg;
                    Toast.makeText(context, charSequence, 0).show();
                    this.this$0.hideOtherPayModeLoading();
                    this.this$0.enableUiInteraction();
                }
            }
            charSequence = this.this$0.getString(R.string.something_went_wrong);
            Toast.makeText(context, charSequence, 0).show();
            this.this$0.hideOtherPayModeLoading();
            this.this$0.enableUiInteraction();
        }
    }
}
