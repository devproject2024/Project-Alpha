package com.business.merchant_payments.mapqr.view;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.mapqr.model.VerifyQRResponse;

public final class ScanActivityZxing$setData$2<T> implements z<b<VerifyQRResponse>> {
    public final /* synthetic */ ScanActivityZxing this$0;

    public ScanActivityZxing$setData$2(ScanActivityZxing scanActivityZxing) {
        this.this$0 = scanActivityZxing;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        r5 = r5.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(com.business.common_module.utilities.a.b<com.business.merchant_payments.mapqr.model.VerifyQRResponse> r5) {
        /*
            r4 = this;
            com.business.common_module.utilities.a.e r0 = r5.f7357b
            com.business.common_module.utilities.a.e r1 = com.business.common_module.utilities.a.e.LOADING
            if (r0 != r1) goto L_0x0029
            com.business.merchant_payments.mapqr.view.ScanActivityZxing r5 = r4.this$0
            com.google.android.material.snackbar.Snackbar r5 = r5.errorSnackBar
            if (r5 == 0) goto L_0x0017
            boolean r0 = r5.e()
            if (r0 == 0) goto L_0x0017
            r5.d()
        L_0x0017:
            com.business.merchant_payments.mapqr.view.ScanActivityZxing r5 = r4.this$0
            com.google.android.material.snackbar.Snackbar r5 = r5.errorSnackBar
            if (r5 == 0) goto L_0x0028
            boolean r0 = r5.e()
            if (r0 == 0) goto L_0x0028
            r5.d()
        L_0x0028:
            return
        L_0x0029:
            retrofit2.Response<?> r0 = r5.f7356a
            java.lang.String r1 = "not_scannable"
            if (r0 == 0) goto L_0x008f
            T r0 = r5.f7358c
            com.business.merchant_payments.mapqr.model.VerifyQRResponse r0 = (com.business.merchant_payments.mapqr.model.VerifyQRResponse) r0
            if (r0 == 0) goto L_0x0089
            java.lang.String r2 = r0.getStatusMessage()
            java.lang.String r3 = "SUCCESS"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x006e
            T r2 = r5.f7358c
            com.business.merchant_payments.mapqr.model.VerifyQRResponse r2 = (com.business.merchant_payments.mapqr.model.VerifyQRResponse) r2
            java.util.List r2 = r2.getResponse()
            if (r2 == 0) goto L_0x006e
            com.business.merchant_payments.mapqr.view.ScanActivityZxing r0 = r4.this$0
            T r5 = r5.f7358c
            com.business.merchant_payments.mapqr.model.VerifyQRResponse r5 = (com.business.merchant_payments.mapqr.model.VerifyQRResponse) r5
            java.util.List r5 = r5.getResponse()
            if (r5 == 0) goto L_0x0065
            r1 = 0
            java.lang.Object r5 = r5.get(r1)
            com.business.merchant_payments.model.qrsummarymodel.QRSummaryListItem r5 = (com.business.merchant_payments.model.qrsummarymodel.QRSummaryListItem) r5
            if (r5 == 0) goto L_0x0065
            java.lang.String r5 = r5.getmQRType()
            goto L_0x0066
        L_0x0065:
            r5 = 0
        L_0x0066:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r0.openPostVerifyFlow(r5)
            return
        L_0x006e:
            java.lang.String r5 = r0.getStatusCode()
            r0 = 1
            java.lang.String r2 = "DQR_0050"
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r2, (boolean) r0)
            if (r5 == 0) goto L_0x0083
            com.business.merchant_payments.mapqr.view.ScanActivityZxing r5 = r4.this$0
            java.lang.String r0 = "not_paytm_qr"
            r5.openPostVerifyFlow(r0)
            return
        L_0x0083:
            com.business.merchant_payments.mapqr.view.ScanActivityZxing r5 = r4.this$0
            r5.openPostVerifyFlow(r1)
            return
        L_0x0089:
            com.business.merchant_payments.mapqr.view.ScanActivityZxing r5 = r4.this$0
            r5.openPostVerifyFlow(r1)
            return
        L_0x008f:
            com.business.merchant_payments.mapqr.view.ScanActivityZxing r5 = r4.this$0
            r5.openPostVerifyFlow(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.mapqr.view.ScanActivityZxing$setData$2.onChanged(com.business.common_module.utilities.a.b):void");
    }
}
