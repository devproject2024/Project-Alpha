package net.one97.paytm.wallet.chatintegration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.z;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.network.f;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.entity.CJRSendMoney;
import net.one97.paytm.wallet.entity.CJRSendMoneyResponse;
import net.one97.paytm.wallet.p2p.P2PLandingPageActivity;
import net.one97.paytm.wallet.utility.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static net.one97.paytm.network.a f70132a;

    /* renamed from: b  reason: collision with root package name */
    public static ChatPaymentIntegrationListener f70133b;

    /* renamed from: c  reason: collision with root package name */
    public static String f70134c;

    /* renamed from: d  reason: collision with root package name */
    static String f70135d;

    /* renamed from: e  reason: collision with root package name */
    static String f70136e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f70137f = new a();

    /* renamed from: net.one97.paytm.wallet.chatintegration.a$a  reason: collision with other inner class name */
    static final class C1414a<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f70138a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f70139b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f70140c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f70141d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f70142e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ x.a f70143f;

        C1414a(String str, Activity activity, String str2, String str3, String str4, x.a aVar) {
            this.f70138a = str;
            this.f70139b = activity;
            this.f70140c = str2;
            this.f70141d = str3;
            this.f70142e = str4;
            this.f70143f = aVar;
        }

        /* JADX WARNING: type inference failed for: r5v8, types: [com.paytm.network.model.IJRPaytmDataModel] */
        /* JADX WARNING: type inference failed for: r5v10, types: [com.paytm.network.model.IJRPaytmDataModel] */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
            r2 = (r2 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r1.f55797b).getReceiverInfo();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r34) {
            /*
                r33 = this;
                r0 = r33
                r1 = r34
                net.one97.paytm.network.f r1 = (net.one97.paytm.network.f) r1
                net.one97.paytm.network.h r2 = r1.f55796a
                net.one97.paytm.network.h r3 = net.one97.paytm.network.h.SUCCESS
                r4 = 1
                r5 = 0
                if (r2 != r3) goto L_0x0091
                if (r1 == 0) goto L_0x0013
                com.paytm.network.model.IJRPaytmDataModel r2 = r1.f55797b
                goto L_0x0014
            L_0x0013:
                r2 = r5
            L_0x0014:
                boolean r2 = r2 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r2 == 0) goto L_0x01f6
                if (r1 == 0) goto L_0x002b
                com.paytm.network.model.IJRPaytmDataModel r2 = r1.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r2
                if (r2 == 0) goto L_0x002b
                net.one97.paytm.common.entity.p2p.ReceiverInfo r2 = r2.getReceiverInfo()
                if (r2 == 0) goto L_0x002b
                java.lang.String r2 = r2.getName()
                goto L_0x002c
            L_0x002b:
                r2 = r5
            L_0x002c:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 == 0) goto L_0x0047
                if (r1 == 0) goto L_0x0047
                com.paytm.network.model.IJRPaytmDataModel r2 = r1.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r2
                if (r2 == 0) goto L_0x0047
                net.one97.paytm.common.entity.p2p.ReceiverInfo r2 = r2.getReceiverInfo()
                if (r2 == 0) goto L_0x0047
                java.lang.String r3 = r0.f70138a
                r2.setContactName(r3)
            L_0x0047:
                if (r1 == 0) goto L_0x0054
                com.paytm.network.model.IJRPaytmDataModel r2 = r1.f55797b
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r2
                if (r2 == 0) goto L_0x0054
                java.lang.String r2 = r2.getCategory()
                goto L_0x0055
            L_0x0054:
                r2 = r5
            L_0x0055:
                java.lang.String r3 = "P2M"
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)
                if (r2 == 0) goto L_0x007b
                net.one97.paytm.wallet.chatintegration.a r2 = net.one97.paytm.wallet.chatintegration.a.f70137f
                android.app.Activity r6 = r0.f70139b
                if (r1 == 0) goto L_0x0065
                com.paytm.network.model.IJRPaytmDataModel r5 = r1.f55797b
            L_0x0065:
                r7 = r5
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r7 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r7
                java.lang.String r8 = r0.f70140c
                java.lang.String r9 = r0.f70141d
                java.lang.String r10 = r0.f70142e
                kotlin.g.b.x$a r1 = r0.f70143f
                boolean r11 = r1.element
                net.one97.paytm.wallet.chatintegration.a.a(r6, r7, r8, r9, r10, r11)
                net.one97.paytm.wallet.chatintegration.a r1 = net.one97.paytm.wallet.chatintegration.a.f70137f
                net.one97.paytm.wallet.chatintegration.a.a()
                return
            L_0x007b:
                net.one97.paytm.wallet.chatintegration.a r2 = net.one97.paytm.wallet.chatintegration.a.f70137f
                android.app.Activity r2 = r0.f70139b
                if (r1 == 0) goto L_0x0083
                com.paytm.network.model.IJRPaytmDataModel r5 = r1.f55797b
            L_0x0083:
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r5 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r5
                java.lang.String r1 = r0.f70141d
                java.lang.String r3 = r0.f70142e
                kotlin.g.b.x$a r4 = r0.f70143f
                boolean r4 = r4.element
                net.one97.paytm.wallet.chatintegration.a.a(r2, r5, r1, r3, r4)
                return
            L_0x0091:
                net.one97.paytm.network.h r2 = r1.f55796a
                net.one97.paytm.network.h r3 = net.one97.paytm.network.h.ERROR
                if (r2 != r3) goto L_0x01f6
                net.one97.paytm.wallet.chatintegration.a r2 = net.one97.paytm.wallet.chatintegration.a.f70137f
                net.one97.paytm.wallet.chatintegration.a.a()
                if (r1 == 0) goto L_0x00a5
                net.one97.paytm.network.g r2 = r1.f55798c
                if (r2 == 0) goto L_0x00a5
                com.paytm.network.model.IJRPaytmDataModel r2 = r2.f55800b
                goto L_0x00a6
            L_0x00a5:
                r2 = r5
            L_0x00a6:
                boolean r2 = r2 instanceof net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                if (r2 == 0) goto L_0x00dd
                if (r1 == 0) goto L_0x00b3
                net.one97.paytm.network.g r2 = r1.f55798c
                if (r2 == 0) goto L_0x00b3
                com.paytm.network.model.IJRPaytmDataModel r2 = r2.f55800b
                goto L_0x00b4
            L_0x00b3:
                r2 = r5
            L_0x00b4:
                if (r2 == 0) goto L_0x00d5
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r2
                java.lang.String r2 = r2.getRespCode()
                if (r2 != 0) goto L_0x00c1
                kotlin.g.b.k.a()
            L_0x00c1:
                java.lang.String r3 = "BT_INV_435"
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)
                if (r2 == 0) goto L_0x00dd
                net.one97.paytm.wallet.chatintegration.a r1 = net.one97.paytm.wallet.chatintegration.a.f70137f
                android.app.Activity r1 = r0.f70139b
                java.lang.String r2 = r0.f70138a
                java.lang.String r3 = r0.f70140c
                net.one97.paytm.wallet.chatintegration.a.a(r1, r2, r3)
                return
            L_0x00d5:
                kotlin.u r1 = new kotlin.u
                java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse"
                r1.<init>(r2)
                throw r1
            L_0x00dd:
                net.one97.paytm.utils.ae r2 = net.one97.paytm.utils.ae.f69602a
                if (r1 == 0) goto L_0x00ec
                net.one97.paytm.network.g r2 = r1.f55798c
                if (r2 == 0) goto L_0x00ec
                int r2 = r2.f55799a
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x00ed
            L_0x00ec:
                r2 = r5
            L_0x00ed:
                if (r2 != 0) goto L_0x00f2
                kotlin.g.b.k.a()
            L_0x00f2:
                int r2 = r2.intValue()
                boolean r2 = net.one97.paytm.utils.ae.a((int) r2)
                if (r2 == 0) goto L_0x011c
                android.os.Bundle r2 = new android.os.Bundle
                r2.<init>()
                r3 = 0
                java.lang.String r4 = "key_is_from_fragment"
                r2.putBoolean(r4, r3)
                net.one97.paytm.utils.ae r3 = net.one97.paytm.utils.ae.f69602a
                android.app.Activity r3 = r0.f70139b
                if (r1 == 0) goto L_0x010f
                net.one97.paytm.network.g r5 = r1.f55798c
            L_0x010f:
                int r1 = r5.f55799a
                com.paytm.network.model.NetworkCustomError r4 = new com.paytm.network.model.NetworkCustomError
                r4.<init>()
                java.lang.String r5 = "generic_api_call_fail"
                net.one97.paytm.utils.ae.a(r3, r1, r4, r2, r5)
                return
            L_0x011c:
                net.one97.paytm.wallet.chatintegration.a r1 = net.one97.paytm.wallet.chatintegration.a.f70137f
                android.app.Activity r1 = r0.f70139b
                java.lang.String r2 = r0.f70141d
                java.lang.String r3 = r0.f70142e
                kotlin.g.b.x$a r5 = r0.f70143f
                boolean r5 = r5.element
                android.app.Activity r6 = r0.f70139b
                android.content.Context r6 = (android.content.Context) r6
                java.lang.String r6 = com.paytm.utility.b.j((android.content.Context) r6)
                android.app.Activity r7 = r0.f70139b
                android.content.Context r7 = (android.content.Context) r7
                java.lang.String r7 = com.paytm.utility.b.l((android.content.Context) r7)
                java.lang.String r8 = r0.f70138a
                java.lang.String r9 = r0.f70140c
                java.lang.String r10 = "activity"
                kotlin.g.b.k.c(r1, r10)
                net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r10 = new net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 4095(0xfff, float:5.738E-42)
                r25 = 0
                r11 = r10
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
                net.one97.paytm.common.entity.p2p.SenderInfo r11 = new net.one97.paytm.common.entity.p2p.SenderInfo
                r27 = 0
                r28 = 0
                r29 = 0
                r30 = 0
                r31 = 15
                r32 = 0
                r26 = r11
                r26.<init>(r27, r28, r29, r30, r31, r32)
                r11.setName(r6)
                r11.setPhoneNumber(r7)
                r10.setSenderInfo(r11)
                net.one97.paytm.common.entity.p2p.ReceiverInfo r6 = new net.one97.paytm.common.entity.p2p.ReceiverInfo
                r18 = 31
                r12 = r6
                r12.<init>(r13, r14, r15, r16, r17, r18, r19)
                r6.setName(r8)
                r6.setPhoneNumber(r9)
                r10.setReceiverInfo(r6)
                java.lang.String r6 = "P2P"
                r10.setCategory(r6)
                java.lang.String r6 = "SUCCESS"
                r10.setStatus(r6)
                java.lang.String r7 = "0000"
                r10.setRespCode(r7)
                r10.setRespMessage(r6)
                net.one97.paytm.common.entity.p2p.PaymentOptionItem r6 = new net.one97.paytm.common.entity.p2p.PaymentOptionItem
                r11 = r6
                r12 = 0
                r18 = 0
                r24 = 0
                r26 = 16383(0x3fff, float:2.2957E-41)
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
                java.lang.String r7 = "WALLET-WALLET"
                r6.setCombinationName(r7)
                net.one97.paytm.common.entity.p2p.SourcePayment r7 = new net.one97.paytm.common.entity.p2p.SourcePayment
                r25 = 8191(0x1fff, float:1.1478E-41)
                r26 = 0
                r11 = r7
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
                java.lang.String r8 = "WALLET"
                r7.setPaymentType(r8)
                java.lang.String r9 = "ENABLED"
                r7.setPaymentInstrumentStatus(r9)
                net.one97.paytm.common.entity.p2p.DestinationPayment r9 = new net.one97.paytm.common.entity.p2p.DestinationPayment
                r18 = 63
                r11 = r9
                r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
                r9.setPaymentType(r8)
                r6.setSourcePayment(r7)
                r6.setDestinationPayment(r9)
                r7 = 100000(0x186a0, float:1.4013E-40)
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                r6.setMaxLimit(r7)
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                r6.setMinLimit(r4)
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                r4.add(r6)
                java.util.List r4 = (java.util.List) r4
                r10.setPaymentOptionList(r4)
                net.one97.paytm.wallet.chatintegration.a.a(r1, r10, r2, r3, r5)
            L_0x01f6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.chatintegration.a.C1414a.onChanged(java.lang.Object):void");
        }
    }

    private a() {
    }

    public static void a() {
        f70132a = null;
    }

    public static ChatPaymentIntegrationListener b() {
        ChatPaymentIntegrationListener chatPaymentIntegrationListener = f70133b;
        if (chatPaymentIntegrationListener == null) {
            k.a("chatPaymentIntegrationListener");
        }
        return chatPaymentIntegrationListener;
    }

    public static void a(ChatPaymentIntegrationListener chatPaymentIntegrationListener) {
        k.c(chatPaymentIntegrationListener, "chatPaymentIntegrationListener");
        f70133b = chatPaymentIntegrationListener;
    }

    public static void a(Activity activity, PaymentCombinationAPIResponse paymentCombinationAPIResponse, String str, String str2, boolean z) {
        k.c(activity, "activity");
        k.c(paymentCombinationAPIResponse, "paymentCombinationAPIResponse");
        ExtraData extraData = new ExtraData((String) null, (String) null, false, false, false, false, 63, (g) null);
        if (!TextUtils.isEmpty(str)) {
            extraData.setAmount(str);
            extraData.setAmountEditable(z);
        }
        if (!TextUtils.isEmpty(str2)) {
            extraData.setComment(str2);
            extraData.setCommentEditable(false);
        }
        paymentCombinationAPIResponse.setExtraData(extraData);
        b.a().startMoneyTransferActivityForResult(activity, paymentCombinationAPIResponse, 2002);
    }

    public static void a(Activity activity, String str, String str2) {
        k.c(activity, "activity");
        k.c(str2, "payeePhoneNo");
        d dVar = d.f72319a;
        d.a((Context) activity, str, str2);
        if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static void a(Activity activity, PaymentCombinationAPIResponse paymentCombinationAPIResponse, String str, String str2, String str3, boolean z) {
        k.c(activity, "activity");
        k.c(paymentCombinationAPIResponse, "paymentCombinationAPIResponse");
        k.c(str, "payeePhoneNo");
        if (paymentCombinationAPIResponse.getMerchantInfo() != null) {
            ExtraData extraData = new ExtraData((String) null, (String) null, false, false, false, false, 63, (g) null);
            if (!TextUtils.isEmpty(str2)) {
                extraData.setAmount(str2);
            }
            extraData.setAmountEditable(z);
            if (!TextUtils.isEmpty(str3)) {
                extraData.setComment(str3);
                extraData.setCommentEditable(false);
            }
            paymentCombinationAPIResponse.setExtraData(extraData);
            Intent intent = new Intent(activity, AJRQRActivity.class);
            intent.putExtra("OPERATION", "contact");
            intent.putExtra("mobile", str);
            intent.putExtra("is_from_app_evoke", true);
            intent.putExtra("is_from_mobile_number", true);
            intent.putExtra("paysend_result", paymentCombinationAPIResponse);
            activity.startActivityForResult(intent, 2002);
        }
    }

    public static void a(Activity activity, IJRDataModel iJRDataModel) {
        k.c(activity, "activity");
        k.c(iJRDataModel, "sendMoneyObj");
        String str = f70134c;
        if (str == null) {
            k.a("payeePhoneNo");
        }
        String str2 = f70136e;
        Bundle bundle = new Bundle();
        Intent intent = new Intent(activity, P2PLandingPageActivity.class);
        CJRSendMoney cJRSendMoney = (CJRSendMoney) iJRDataModel;
        intent.putExtra("uni_p2p_landing_intent_extra_success", cJRSendMoney.getStatus());
        intent.putExtra("uni_p2p_landing_intent_extra_mobile_no", str);
        CJRSendMoneyResponse response = cJRSendMoney.getResponse();
        k.a((Object) response, "sendMoneyObj.response");
        intent.putExtra("uni_p2p_landing_intent_extra_name", response.getName());
        intent.putExtra("uni_p2p_landing_intent_extra_amount", cJRSendMoney.getAmount());
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra("uni_p2p_landing_intent_extra_comment", cJRSendMoney.getComment());
        } else {
            intent.putExtra("uni_p2p_landing_intent_extra_comment", str2);
        }
        intent.putExtra("uni_p2p_landing_intent_extra_transaction_id", cJRSendMoney.getResponse().getwalletSysTransactionID());
        intent.putExtra("bill", bundle);
        activity.startActivityForResult(intent, 1);
    }

    public static boolean c() {
        return f70133b != null;
    }
}
