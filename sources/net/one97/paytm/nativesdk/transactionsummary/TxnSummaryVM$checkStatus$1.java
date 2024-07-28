package net.one97.paytm.nativesdk.transactionsummary;

import androidx.lifecycle.y;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transactionsummary.model.Body;
import net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse;

public final class TxnSummaryVM$checkStatus$1 implements PaymentMethodDataSource.Callback<TxnSummaryResponse> {
    final /* synthetic */ TxnSummaryVM this$0;

    TxnSummaryVM$checkStatus$1(TxnSummaryVM txnSummaryVM) {
        this.this$0 = txnSummaryVM;
    }

    public final void onResponse(TxnSummaryResponse txnSummaryResponse) {
        Body body;
        if (!(txnSummaryResponse == null || (body = txnSummaryResponse.getBody()) == null || body.getResultInfo() == null)) {
            String status = txnSummaryResponse.getBody().getResultInfo().getStatus();
            if (status.hashCode() == -1149187101 && status.equals("SUCCESS")) {
                y<TxnSummaryResponse> responseTxnSummary = this.this$0.getResponseTxnSummary();
                if (responseTxnSummary != null) {
                    responseTxnSummary.postValue(txnSummaryResponse);
                }
            } else {
                this.this$0.retry();
            }
        }
        y<Boolean> loaderVisibilty = this.this$0.getLoaderVisibilty();
        if (loaderVisibilty != null) {
            loaderVisibilty.postValue(Boolean.FALSE);
        }
    }

    public final void onErrorResponse(VolleyError volleyError, TxnSummaryResponse txnSummaryResponse) {
        y<Boolean> hasErrorOccured = this.this$0.getHasErrorOccured();
        if (hasErrorOccured != null) {
            hasErrorOccured.postValue(Boolean.TRUE);
        }
        y<TxnSummaryResponse> responseTxnSummary = this.this$0.getResponseTxnSummary();
        if (responseTxnSummary != null) {
            responseTxnSummary.postValue(txnSummaryResponse);
        }
        y<Boolean> loaderVisibilty = this.this$0.getLoaderVisibilty();
        if (loaderVisibilty != null) {
            loaderVisibilty.postValue(Boolean.FALSE);
        }
    }
}
