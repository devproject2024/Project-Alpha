package net.one97.paytm.nativesdk.transactionsummary;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse;

final class TxnSummaryActivity$registerObserver$2<T> implements z<TxnSummaryResponse> {
    final /* synthetic */ TxnSummaryActivity this$0;

    TxnSummaryActivity$registerObserver$2(TxnSummaryActivity txnSummaryActivity) {
        this.this$0 = txnSummaryActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r0.equals("CLOSED") != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r0.equals("CONFIRMED") != false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r0.equals("ACTIVE") != false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r0.equals("INIT") != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r0.equals("AUTHORIZATION_FAILED") != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r0.equals("IN_AUTHORIZATION") != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        r2.this$0.handlePending(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r0.equals(com.paytm.android.chat.bean.jsonbean.TxNotifyData.UPI_STATUS_EXPIRED) != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        if (r0.equals("AUTHORIZED") != false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        r2.this$0.handleSuccess(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0070, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r3.getBody();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        if (r0.equals("REJECT") != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        r2.this$0.handleFailText(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse r3) {
        /*
            r2 = this;
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity r0 = r2.this$0
            r0.mTxnStatusResponse = r3
            if (r3 == 0) goto L_0x0012
            net.one97.paytm.nativesdk.transactionsummary.model.Body r0 = r3.getBody()
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getStatus()
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            if (r0 != 0) goto L_0x0017
            goto L_0x007f
        L_0x0017:
            int r1 = r0.hashCode()
            switch(r1) {
                case -1881380961: goto L_0x0071;
                case -1015619173: goto L_0x0063;
                case -591252731: goto L_0x005a;
                case -337088833: goto L_0x004c;
                case -330094877: goto L_0x0043;
                case 2252048: goto L_0x003a;
                case 1925346054: goto L_0x0031;
                case 1982485311: goto L_0x0028;
                case 1990776172: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x007f
        L_0x001f:
            java.lang.String r1 = "CLOSED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
            goto L_0x0079
        L_0x0028:
            java.lang.String r1 = "CONFIRMED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
            goto L_0x006b
        L_0x0031:
            java.lang.String r1 = "ACTIVE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
            goto L_0x006b
        L_0x003a:
            java.lang.String r1 = "INIT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
            goto L_0x0054
        L_0x0043:
            java.lang.String r1 = "AUTHORIZATION_FAILED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
            goto L_0x0079
        L_0x004c:
            java.lang.String r1 = "IN_AUTHORIZATION"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
        L_0x0054:
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity r0 = r2.this$0
            r0.handlePending(r3)
            return
        L_0x005a:
            java.lang.String r1 = "EXPIRED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
            goto L_0x0079
        L_0x0063:
            java.lang.String r1 = "AUTHORIZED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
        L_0x006b:
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity r0 = r2.this$0
            r0.handleSuccess(r3)
            return
        L_0x0071:
            java.lang.String r1 = "REJECT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007f
        L_0x0079:
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity r0 = r2.this$0
            r0.handleFailText(r3)
            return
        L_0x007f:
            net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity r0 = r2.this$0
            java.lang.String r1 = "response"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            r0.handlePending(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity$registerObserver$2.onChanged(net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse):void");
    }
}
