package net.one97.paytm.nativesdk.transactionsummary.request;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TxnSummaryRequestHelper {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static TxnSummaryRequestHelper INSTANCE;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TxnSummaryRequestHelper getInstance() {
            if (TxnSummaryRequestHelper.INSTANCE == null) {
                TxnSummaryRequestHelper.INSTANCE = new TxnSummaryRequestHelper();
            }
            TxnSummaryRequestHelper access$getINSTANCE$cp = TxnSummaryRequestHelper.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void destroy() {
            TxnSummaryRequestHelper.INSTANCE = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r4 = (r4 = r4.getBody()).getSubscriptionDetailsInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String createCheckStatusRequest() {
        /*
            r8 = this;
            java.lang.String r0 = "MerchantBL.getMerchantInstance()"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r5 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ JSONException -> 0x0084 }
            net.one97.paytm.nativesdk.common.model.CJPayMethodResponse r4 = r4.getCjPayMethodResponse()     // Catch:{ JSONException -> 0x0084 }
            if (r4 == 0) goto L_0x0031
            net.one97.paytm.nativesdk.common.model.Body r4 = r4.getBody()     // Catch:{ JSONException -> 0x0084 }
            if (r4 == 0) goto L_0x0031
            net.one97.paytm.nativesdk.common.model.SubscriptionDetailsInfo r4 = r4.getSubscriptionDetailsInfo()     // Catch:{ JSONException -> 0x0084 }
            if (r4 == 0) goto L_0x0031
            java.lang.String r4 = r4.getSubsId()     // Catch:{ JSONException -> 0x0084 }
            goto L_0x0032
        L_0x0031:
            r4 = 0
        L_0x0032:
            java.lang.String r5 = "token"
            net.one97.paytm.nativesdk.MerchantBL r6 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()     // Catch:{ JSONException -> 0x0084 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r6 = r6.getSsoToken()     // Catch:{ JSONException -> 0x0084 }
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r5 = net.one97.paytm.nativesdk.Constants.SDKConstants.VERSION     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r6 = "v1"
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r5 = "clientId"
            java.lang.String r6 = "C11"
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r5 = "timestamp"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0084 }
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r5 = net.one97.paytm.nativesdk.Constants.SDKConstants.TOKEN_TYPE     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r6 = "SSO"
            r2.put(r5, r6)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r5 = "subsId"
            r3.put(r5, r4)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r4 = net.one97.paytm.nativesdk.Constants.SDKConstants.MID     // Catch:{ JSONException -> 0x0084 }
            net.one97.paytm.nativesdk.MerchantBL r5 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()     // Catch:{ JSONException -> 0x0084 }
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r0 = r5.getMid()     // Catch:{ JSONException -> 0x0084 }
            r3.put(r4, r0)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r0 = net.one97.paytm.nativesdk.Constants.SDKConstants.HEAD     // Catch:{ JSONException -> 0x0084 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r0 = net.one97.paytm.nativesdk.Constants.SDKConstants.BODY     // Catch:{ JSONException -> 0x0084 }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x0084 }
            goto L_0x008a
        L_0x0084:
            r0 = move-exception
            java.lang.Exception r0 = (java.lang.Exception) r0
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r0)
        L_0x008a:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.transactionsummary.request.TxnSummaryRequestHelper.createCheckStatusRequest():java.lang.String");
    }
}
