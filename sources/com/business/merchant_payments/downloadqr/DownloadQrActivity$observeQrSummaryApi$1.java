package com.business.merchant_payments.downloadqr;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.qrsummarymodel.QRSummary;

public final class DownloadQrActivity$observeQrSummaryApi$1 implements z<b<QRSummary>> {
    public final /* synthetic */ DownloadQrActivity this$0;

    public DownloadQrActivity$observeQrSummaryApi$1(DownloadQrActivity downloadQrActivity) {
        this.this$0 = downloadQrActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        if (r0 == null) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(com.business.common_module.utilities.a.b<com.business.merchant_payments.model.qrsummarymodel.QRSummary> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "qrSummaryLiveDataWrapper"
            kotlin.g.b.k.d(r6, r0)
            com.business.common_module.utilities.a.e r0 = r6.f7357b
            com.business.common_module.utilities.a.e r1 = com.business.common_module.utilities.a.e.LOADING
            if (r0 != r1) goto L_0x000c
            return
        L_0x000c:
            com.business.common_module.utilities.a.e r1 = com.business.common_module.utilities.a.e.OFFLINE
            r2 = 1
            if (r0 != r1) goto L_0x0030
            java.lang.String r0 = r6.f7359d
            java.lang.String r1 = "NO NETWORK"
            boolean r0 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r0, (boolean) r2)
            if (r0 == 0) goto L_0x0030
            com.business.merchant_payments.downloadqr.DownloadQrActivity r6 = r5.this$0
            int r0 = com.business.merchant_payments.R.string.mp_fetch_QR_failed
            java.lang.String r0 = r6.getString(r0)
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r0, r2)
            r6.show()
            com.business.merchant_payments.downloadqr.DownloadQrActivity r6 = r5.this$0
            r6.finish()
            return
        L_0x0030:
            T r0 = r6.f7358c
            if (r0 == 0) goto L_0x00a7
            com.business.common_module.utilities.a.e r1 = r6.f7357b
            com.business.common_module.utilities.a.e r3 = com.business.common_module.utilities.a.e.SUCCESS
            if (r1 != r3) goto L_0x00a7
            com.business.merchant_payments.model.qrsummarymodel.QRSummary r0 = (com.business.merchant_payments.model.qrsummarymodel.QRSummary) r0
            java.lang.String r1 = "QR not found"
            if (r0 == 0) goto L_0x0099
            java.util.ArrayList r3 = r0.getmQRSummaryList()
            java.lang.String r4 = "it.getmQRSummaryList()"
            kotlin.g.b.k.b(r3, r4)
            if (r3 == 0) goto L_0x0087
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0076
            com.business.merchant_payments.downloadqr.DownloadQrActivity r3 = r5.this$0
            com.business.merchant_payments.newhome.ManageQrViewHandler r3 = com.business.merchant_payments.downloadqr.DownloadQrActivity.access$getManageQrViewHandler$p(r3)
            java.util.ArrayList r0 = r0.getmQRSummaryList()
            r4 = 0
            r3.updatePagerView(r0, r4)
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            com.business.merchant_payments.newhome.ManageQrViewHandler r0 = com.business.merchant_payments.downloadqr.DownloadQrActivity.access$getManageQrViewHandler$p(r0)
            if (r0 == 0) goto L_0x0074
            com.business.merchant_payments.newhome.ManageQrViewHandler$QrPageItemViewModelNew r0 = r0.getViewModel()
            if (r0 == 0) goto L_0x0074
            r0.onShareBtnClicked(r2)
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0097
        L_0x0074:
            r0 = 0
            goto L_0x0097
        L_0x0076:
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            r0.finish()
            kotlin.x r0 = kotlin.x.f47997a
            goto L_0x0097
        L_0x0087:
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            r0.finish()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x0097:
            if (r0 != 0) goto L_0x00a7
        L_0x0099:
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            r0.finish()
        L_0x00a7:
            com.business.common_module.utilities.a.e r0 = r6.f7357b
            com.business.common_module.utilities.a.e r1 = com.business.common_module.utilities.a.e.ERROR
            if (r0 != r1) goto L_0x00c1
            retrofit2.Response<?> r0 = r6.f7356a
            if (r0 == 0) goto L_0x00bc
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            com.business.merchant_payments.newhome.QrViewModel r0 = com.business.merchant_payments.downloadqr.DownloadQrActivity.access$getQrViewModel$p(r0)
            retrofit2.Response<?> r1 = r6.f7356a
            r0.handleErrorCondition(r1)
        L_0x00bc:
            com.business.merchant_payments.downloadqr.DownloadQrActivity r0 = r5.this$0
            r0.finish()
        L_0x00c1:
            com.business.common_module.utilities.a.e r6 = r6.f7357b
            com.business.common_module.utilities.a.e r0 = com.business.common_module.utilities.a.e.FAILURE
            if (r6 != r0) goto L_0x00db
            com.business.merchant_payments.downloadqr.DownloadQrActivity r6 = r5.this$0
            int r0 = com.business.merchant_payments.R.string.mp_fetch_QR_failed
            java.lang.String r0 = r6.getString(r0)
            android.widget.Toast r6 = android.widget.Toast.makeText(r6, r0, r2)
            r6.show()
            com.business.merchant_payments.downloadqr.DownloadQrActivity r6 = r5.this$0
            r6.finish()
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.downloadqr.DownloadQrActivity$observeQrSummaryApi$1.onChanged(com.business.common_module.utilities.a.b):void");
    }
}
