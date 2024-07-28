package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;

final class PaymentRepository$makeTransactionRequest$request$1<T> implements Response.Listener<ProcessTransactionInfo> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentRepository$makeTransactionRequest$request$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r4.getBody();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r4.getBody()
            if (r1 == 0) goto L_0x000e
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r1 = r1.getResultInfo()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 == 0) goto L_0x0031
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r4.getBody()
            if (r1 == 0) goto L_0x0022
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = r1.getResultStatus()
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            java.lang.String r2 = "S"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0031
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource$Callback r0 = r3.$callback
            r0.onResponse(r4)
            return
        L_0x0031:
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource$Callback r1 = r3.$callback
            r1.onErrorResponse(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository$makeTransactionRequest$request$1.onResponse(net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo):void");
    }
}
