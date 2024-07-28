package net.one97.paytm.nativesdk.orflow.transaction.fragment;

import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.orflow.interfaces.OrFlowCallbackListener;

public final class TransactionErrorFragment$applyAnotherOffer$1 implements PaytmSDKRequestClient.ApplyAnotherOfferListener {
    final /* synthetic */ TransactionErrorFragment this$0;

    TransactionErrorFragment$applyAnotherOffer$1(TransactionErrorFragment transactionErrorFragment) {
        this.this$0 = transactionErrorFragment;
    }

    public final void onSuccess() {
        this.this$0.cancelOrder();
        this.this$0.dismiss();
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        OrFlowCallbackListener orFlowCallbackListener = instance.getOrFlowCallbackListener();
        if (orFlowCallbackListener != null) {
            orFlowCallbackListener.finishActivity();
        }
    }

    public final void onError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
        TextView textView = (TextView) this.this$0.getMView().findViewById(R.id.tvPromoError);
        k.a((Object) textView, "mView.tvPromoError");
        textView.setVisibility(0);
        this.this$0.hideOAnotherOfferLoading();
    }
}
