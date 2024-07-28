package net.one97.paytm.nativesdk.common.helpers;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;

public final class PCFHelperAIO implements PaytmSDKRequestClient {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static PCFHelperAIO INSTANCE;

    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    public static final PCFHelperAIO getInstance() {
        return Companion.getInstance();
    }

    public final void applyAnotherOffer(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
    }

    public final void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
    }

    public final void doCheckout(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
    }

    public final void onOtherPayModeSelected(boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PCFHelperAIO getInstance() {
            if (PCFHelperAIO.INSTANCE == null) {
                PCFHelperAIO.INSTANCE = new PCFHelperAIO();
            }
            PCFHelperAIO access$getINSTANCE$cp = PCFHelperAIO.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void destroyInstance() {
            PCFHelperAIO.INSTANCE = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r8 = r8.getPaymentIntents();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void verifyCart(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.CallbackData r8, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.OnVerifyResponse r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x0011
            java.util.ArrayList r8 = r8.getPaymentIntents()
            if (r8 == 0) goto L_0x0011
            java.lang.Object r8 = r8.get(r0)
            net.one97.paytm.nativesdk.common.model.PaymentIntent r8 = (net.one97.paytm.nativesdk.common.model.PaymentIntent) r8
            goto L_0x0012
        L_0x0011:
            r8 = r1
        L_0x0012:
            if (r8 == 0) goto L_0x0019
            java.lang.String r2 = r8.getMode()
            goto L_0x001a
        L_0x0019:
            r2 = r1
        L_0x001a:
            net.one97.paytm.nativesdk.Utils.PayMethodType r3 = net.one97.paytm.nativesdk.Utils.PayMethodType.NET_BANKING
            java.lang.String r3 = r3.name()
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0037
            java.util.ArrayList r2 = r8.getBanks()
            if (r2 == 0) goto L_0x005c
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x006d
            goto L_0x005c
        L_0x0037:
            net.one97.paytm.nativesdk.Utils.PayMethodType r3 = net.one97.paytm.nativesdk.Utils.PayMethodType.DEBIT_CARD
            java.lang.String r3 = r3.name()
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x005e
            net.one97.paytm.nativesdk.Utils.PayMethodType r3 = net.one97.paytm.nativesdk.Utils.PayMethodType.CREDIT_CARD
            java.lang.String r3 = r3.name()
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x005e
            net.one97.paytm.nativesdk.Utils.PayMethodType r3 = net.one97.paytm.nativesdk.Utils.PayMethodType.EMI
            java.lang.String r3 = r3.name()
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r0 = r4
            goto L_0x006d
        L_0x005e:
            java.util.ArrayList r2 = r8.getChannels()
            if (r2 == 0) goto L_0x005c
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x006d
            goto L_0x005c
        L_0x006d:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            kotlin.g.b.x$e r3 = new kotlin.g.b.x$e
            r3.<init>()
            if (r8 == 0) goto L_0x007d
            java.lang.String r1 = r8.getMode()
        L_0x007d:
            r3.element = r1
            java.lang.String r1 = "payMethod"
            if (r8 == 0) goto L_0x00be
            java.lang.String r5 = r8.getMode()     // Catch:{ Exception -> 0x00bc }
            if (r5 == 0) goto L_0x00be
            net.one97.paytm.nativesdk.Utils.PayMethodType r6 = net.one97.paytm.nativesdk.Utils.PayMethodType.BALANCE     // Catch:{ Exception -> 0x00bc }
            java.lang.String r6 = r6.name()     // Catch:{ Exception -> 0x00bc }
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x00bc }
            if (r5 != 0) goto L_0x00be
            boolean r5 = net.one97.paytm.nativesdk.Utils.SDKUtility.isHybridCase()     // Catch:{ Exception -> 0x00bc }
            if (r5 == 0) goto L_0x00be
            net.one97.paytm.nativesdk.DirectPaymentBL r5 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r6 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x00bc }
            boolean r5 = r5.isPaytmWalletChecked()     // Catch:{ Exception -> 0x00bc }
            if (r5 == 0) goto L_0x00be
            net.one97.paytm.nativesdk.Utils.PayMethodType r8 = net.one97.paytm.nativesdk.Utils.PayMethodType.BALANCE     // Catch:{ Exception -> 0x00bc }
            java.lang.String r8 = r8.name()     // Catch:{ Exception -> 0x00bc }
            r3.element = r8     // Catch:{ Exception -> 0x00bc }
            net.one97.paytm.nativesdk.Utils.PayMethodType r8 = net.one97.paytm.nativesdk.Utils.PayMethodType.BALANCE     // Catch:{ Exception -> 0x00bc }
            java.lang.String r8 = r8.name()     // Catch:{ Exception -> 0x00bc }
            r2.put(r1, r8)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00d3
        L_0x00bc:
            r8 = move-exception
            goto L_0x00d0
        L_0x00be:
            if (r8 == 0) goto L_0x00c6
            java.lang.String r8 = r8.getMode()     // Catch:{ Exception -> 0x00bc }
            if (r8 != 0) goto L_0x00c7
        L_0x00c6:
            r8 = r4
        L_0x00c7:
            r2.put(r1, r8)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r8 = "instId"
            r2.put(r8, r0)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00d3
        L_0x00d0:
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r8)
        L_0x00d3:
            net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository r8 = net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository.getInstance()
            net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO$verifyCart$1 r0 = new net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO$verifyCart$1
            r0.<init>(r3, r9)
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource$Callback r0 = (net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource.Callback) r0
            r8.fetchPcfDetails(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.helpers.PCFHelperAIO.verifyCart(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$CallbackData, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnVerifyResponse):void");
    }

    public final boolean isConvFeeEnabled() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        CJPayMethodResponse cjPayMethodResponse = instance.getCjPayMethodResponse();
        Body body = cjPayMethodResponse != null ? cjPayMethodResponse.getBody() : null;
        if (body == null || !body.isPcfEnabled()) {
            return false;
        }
        String paymentFlow = body.getPaymentFlow();
        if (paymentFlow == null || paymentFlow.equals(SDKConstants.HYBRID)) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            return !instance2.isPaytmWalletChecked();
        }
    }
}
