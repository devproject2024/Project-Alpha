package net.one97.paytm.nativesdk.Utils;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;

final class ProcessTransactionRequest$getRequest$request$1<T> implements Response.Listener<ProcessTransactionInfo> {
    final /* synthetic */ ProcessTransactionRequest this$0;

    ProcessTransactionRequest$getRequest$request$1(ProcessTransactionRequest processTransactionRequest) {
        this.this$0 = processTransactionRequest;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) (r1 == null || (r1 = r1.getResultInfo()) == null) ? null : r1.getResultStatus(), (java.lang.Object) "S") != false) goto L_0x0045;
     */
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
            if (r1 == 0) goto L_0x004f
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r4.getBody()
            if (r1 == 0) goto L_0x0022
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = r1.getResultCode()
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            java.lang.String r2 = "0000"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0045
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r4.getBody()
            if (r1 == 0) goto L_0x003c
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = r1.getResultStatus()
            goto L_0x003d
        L_0x003c:
            r1 = r0
        L_0x003d:
            java.lang.String r2 = "S"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x004f
        L_0x0045:
            net.one97.paytm.nativesdk.Utils.ProcessTransactionRequest r0 = r3.this$0
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource$Callback r0 = r0.getCallback()
            r0.onResponse(r4)
            return
        L_0x004f:
            net.one97.paytm.nativesdk.Utils.ProcessTransactionRequest r1 = r3.this$0
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource$Callback r1 = r1.getCallback()
            r1.onErrorResponse(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.Utils.ProcessTransactionRequest$getRequest$request$1.onResponse(net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo):void");
    }
}
