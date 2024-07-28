package net.one97.paytm.wallet.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel;
import net.one97.paytm.contacts.activity.SearchActivityV2;
import net.one97.paytm.network.f;
import net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel;
import net.one97.paytm.postpayment.models.P2MPostPaymentDataModel;
import net.one97.paytm.utils.bd;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationListener;
import net.one97.paytm.wallet.chatintegration.ChatShimmerActivity;
import net.one97.paytm.wallet.chatintegration.b;
import net.one97.paytm.wallet.d.e;
import net.one97.paytm.wallet.f.g;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.universalp2p.a;
import net.one97.paytm.wallet.utility.a.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f72319a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static b f72320b;

    private d() {
    }

    public static void a(String str, Context context) throws IOException {
        k.c(str, "data");
        k.c(context, "context");
        if (a.v(str)) {
            Intent intent = new Intent(context, AJRQRActivity.class);
            intent.setFlags(268435456);
            Bundle bundle = new Bundle();
            bundle.putString("p2mUPIDeeplink", str);
            intent.putExtras(bundle);
            context.startActivity(intent);
            return;
        }
        throw new IOException("Mid and Order params are not present.");
    }

    public static void a(Context context, P2MPostPaymentDataModel p2MPostPaymentDataModel) throws IOException {
        Intent h2 = a.h(context);
        h2.putExtra("is_offline_pg", true);
        h2.putExtra("backpress_offline_pg", true);
        h2.putExtra("key_via", "via_qr");
        h2.putExtra("paymentMode", "p2m");
        h2.putExtra("paymentType", "pay");
        h2.putExtra("name", p2MPostPaymentDataModel.getName());
        h2.putExtra("phone_no", p2MPostPaymentDataModel.getPhoneNumber());
        h2.putExtra("bundle", p2MPostPaymentDataModel.getBundle());
        h2.putExtra("amount", p2MPostPaymentDataModel.getAmount());
        h2.putExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL, p2MPostPaymentDataModel.getComment());
        h2.putExtra("tagline", p2MPostPaymentDataModel.getTagline());
        h2.putExtra("order_id", p2MPostPaymentDataModel.getOrderId());
        h2.putExtra("mid", p2MPostPaymentDataModel.getMid());
        h2.putExtra("merchant_logo", p2MPostPaymentDataModel.getMerchantLogo());
        h2.putExtra("is_postpaid", p2MPostPaymentDataModel.isPostPaid());
        h2.putExtra("is_ppb_transaction", p2MPostPaymentDataModel.isPPBTxn());
        h2.putExtra("is_upi", p2MPostPaymentDataModel.isUpi());
        h2.putExtra("is_card_transaction", p2MPostPaymentDataModel.isCardTxn());
        h2.putExtra("is_net_banking_transaction", p2MPostPaymentDataModel.isNetBankingTxn());
        h2.putExtra("is_from_app_evoke", p2MPostPaymentDataModel.isFromAppEvoke());
        if (p2MPostPaymentDataModel.isFromAppEvoke()) {
            ((Activity) context).startActivityForResult(h2, 2002);
        } else {
            context.startActivity(h2);
        }
    }

    public static void a(Context context, ShowCodePushModel showCodePushModel) throws IOException {
        if (context == null) {
            throw new IOException("context cannot be null");
        } else if (showCodePushModel != null) {
            Intent h2 = a.h(context);
            h2.putExtra("is_wallet_transection", true);
            h2.putExtra("is_offline_pg", true);
            h2.putExtra("bundle", showCodePushModel);
            h2.putExtra("name", showCodePushModel.getMerchantName());
            h2.addFlags(335544320);
            context.startActivity(h2);
        } else {
            throw new IOException("model cannot be null");
        }
    }

    public static void a(Activity activity, Fragment fragment, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, WalletPaymentCallbackListener walletPaymentCallbackListener) throws IOException {
        Activity activity2 = activity;
        Fragment fragment2 = fragment;
        String str10 = str;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        String str17 = str9;
        WalletPaymentCallbackListener walletPaymentCallbackListener2 = walletPaymentCallbackListener;
        k.c(activity2, "activity");
        k.c(fragment2, "fragment");
        k.c(str10, "enteredBalance");
        k.c(str11, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        k.c(str12, AppConstants.KEY_EMAIL);
        k.c(str13, "receiverProfileURL");
        k.c(str14, "receiverMobileNumber");
        String str18 = "receiverMobileNumber";
        k.c(str15, "receiverName");
        String str19 = "receiverName";
        k.c(str16, "primaryVPA");
        String str20 = "primaryVPA";
        k.c(str17, "themeId");
        String str21 = "themeId";
        k.c(walletPaymentCallbackListener2, "walletPaymentCallbackListener");
        if (activity.isFinishing()) {
            throw new IOException("activity is null or finishing");
        } else if (fragment.isAdded()) {
            b bVar = new b(activity2, fragment2);
            f72320b = bVar;
            k.c(str10, "enteredBalance");
            k.c(str11, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
            k.c(str12, AppConstants.KEY_EMAIL);
            k.c(str13, "receiverProfileURL");
            k.c(str14, str18);
            k.c(str15, str19);
            k.c(str16, str20);
            k.c(str17, str21);
            k.c(walletPaymentCallbackListener2, "walletPaymentCallbackListener");
            if (bVar.f72294b != null && bVar.f72295c != null) {
                Activity activity3 = bVar.f72294b;
                if (activity3 == null) {
                    k.a();
                }
                if (!activity3.isFinishing()) {
                    Fragment fragment3 = bVar.f72295c;
                    if (fragment3 == null) {
                        k.a();
                    }
                    if (fragment3.isAdded()) {
                        x.e eVar = new x.e();
                        eVar.element = str11;
                        bVar.f72293a.b(bVar.f72296d);
                        b bVar2 = bVar;
                        WalletPaymentCallbackListener walletPaymentCallbackListener3 = walletPaymentCallbackListener2;
                        bVar.f72293a.a(bVar.f72294b, "P2P_TRANSFER", (g) new b.C1465b(bVar, eVar, walletPaymentCallbackListener, str, str5, str6, str7, str9, str8));
                        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str10)) {
                            boolean z3 = z2;
                            bVar2.a(walletPaymentCallbackListener, str4, str, str3, str9, str6, str7, z2);
                            return;
                        }
                        double parseDouble = Double.parseDouble(str);
                        if (str2 == null) {
                            k.a();
                        }
                        if (parseDouble <= Double.parseDouble(str2)) {
                            bVar2.a(walletPaymentCallbackListener, str4, str, str3, str9, str6, str7, z2);
                        } else if (z) {
                            String str22 = bVar2.f72296d;
                            e eVar2 = bVar2.f72293a;
                            if (eVar2 != null) {
                                eVar2.a(str4, str6, str, str3, "0", "0", str22, str9);
                            }
                            e eVar3 = bVar2.f72293a;
                            if (eVar3 != null) {
                                eVar3.a(str10, str14, z2, walletPaymentCallbackListener3);
                            }
                        } else {
                            walletPaymentCallbackListener.onAddMoneyStart();
                            Map hashMap = new HashMap();
                            hashMap.put("screen_name", "WalletPaymentHandler");
                            a aVar = new a(bVar2.f72294b);
                            String b2 = aVar.b(a.C1448a.WALLET_LIMITS, new Object[0]);
                            k.a((Object) b2, "universalP2PRequestCompo…ctory.Type.WALLET_LIMITS)");
                            String c2 = aVar.c(a.C1448a.WALLET_LIMITS, str10, str14, "ADD_MONEY", Double.valueOf(Double.parseDouble(str2)));
                            k.a((Object) c2, "universalP2PRequestCompo…walletBalance.toDouble())");
                            Map<String, String> a2 = aVar.a(a.C1448a.WALLET_LIMITS, new Object[0]);
                            k.a((Object) a2, "universalP2PRequestCompo…ctory.Type.WALLET_LIMITS)");
                            net.one97.paytm.network.b bVar3 = new net.one97.paytm.network.b(b2, new WalletLimitsResDataModel(), hashMap, a2, c2);
                            bVar3.e();
                            bVar3.a(a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) bVar2.f72294b, "walletLimitApiTimeout")));
                            LiveData<f> a3 = bVar3.a();
                            Activity activity4 = bVar2.f72294b;
                            if (activity4 != null) {
                                a3.observe((q) activity4, new b.a(bVar2, str7, str6, str, walletPaymentCallbackListener));
                                return;
                            }
                            throw new u("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                        }
                    }
                }
            }
        } else {
            throw new IOException("fragment is not added");
        }
    }

    public static void a(Intent intent, boolean z, WalletPaymentCallbackListener walletPaymentCallbackListener) {
        k.c(intent, "data");
        k.c(walletPaymentCallbackListener, "walletPaymentCallbackListener");
        b bVar = f72320b;
        if (bVar == null) {
            k.a("walletPaymentHandler");
        }
        if (bVar != null) {
            k.c(intent, "data");
            k.c(walletPaymentCallbackListener, "walletPaymentCallbackListener");
            walletPaymentCallbackListener.onAddMoneyStart();
            String stringExtra = intent.getStringExtra("intent_extra_wallet_order_id");
            String stringExtra2 = intent.getStringExtra("intent_extra_wallet_email");
            String stringExtra3 = intent.getStringExtra("intent_extra_wallet_phone_number");
            String stringExtra4 = intent.getStringExtra("intent_extra_wallet_payee_sso_id");
            String stringExtra5 = intent.getStringExtra("intent_extra_wallet_send_money_amount");
            String stringExtra6 = intent.getStringExtra("intent_extra_wallet_comment");
            intent.getStringExtra("intent_extra_wallet_request_code");
            String stringExtra7 = intent.getStringExtra("intent_extra_wallet_is_to_verify");
            String stringExtra8 = intent.getStringExtra("intent_extra_wallet_is_limit_applicable");
            boolean booleanExtra = intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false);
            if ((!TextUtils.isEmpty(stringExtra2) || !TextUtils.isEmpty(stringExtra3) || !TextUtils.isEmpty(stringExtra4)) && bVar.f72293a != null) {
                bVar.f72293a.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, stringExtra8, booleanExtra, z, walletPaymentCallbackListener);
            }
        }
    }

    public static void a(Context context, IJRDataModel iJRDataModel, String str, String str2, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        IJRDataModel iJRDataModel2 = iJRDataModel;
        String str3 = str;
        String str4 = str2;
        boolean z6 = z;
        k.c(context, "context");
        k.c(iJRDataModel2, Payload.RESPONSE);
        if (iJRDataModel2 instanceof PaymentCombinationAPIResponse) {
            net.one97.paytm.f.b.a().c();
            PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) iJRDataModel2;
            if (paymentCombinationAPIResponse.getExtraData() == null) {
                ExtraData extraData = new ExtraData((String) null, (String) null, false, false, false, false, 63, (kotlin.g.b.g) null);
                if (!TextUtils.isEmpty(str3)) {
                    extraData.setAmount(str3);
                    extraData.setAmountEditable(false);
                }
                if (!TextUtils.isEmpty(str4)) {
                    extraData.setComment(str4);
                    extraData.setCommentEditable(false);
                }
                extraData.setGalleryScan(z6);
                extraData.setMidScan(z2);
                paymentCombinationAPIResponse.setExtraData(extraData);
            }
            net.one97.paytm.f.b a2 = net.one97.paytm.f.b.a();
            k.a((Object) a2, "RiskInformationController.getInstance()");
            RiskExtendedInfo b2 = a2.b();
            k.a((Object) b2, "RiskInformationControlle…stance().riskExtendedInfo");
            b2.setGalleryScan(z6);
        }
        if (z3) {
            net.one97.paytm.wallet.communicator.b.a().startMoneyTransferFromPay(context, i2, iJRDataModel, str, str2);
        } else if (z5) {
            net.one97.paytm.wallet.communicator.b.a().startMTFromScan(context, i2, iJRDataModel, str, str2);
        } else if (z4) {
            net.one97.paytm.wallet.communicator.b.a().startMTFromDeeplink(context, i2, iJRDataModel, str, str2);
        } else {
            net.one97.paytm.wallet.communicator.b.a().startMoneyTransferActivity(context, i2, iJRDataModel, str, str2);
        }
    }

    public static void a(Activity activity, IJRDataModel iJRDataModel, int i2, int i3, boolean z) {
        IJRDataModel iJRDataModel2 = iJRDataModel;
        Activity activity2 = activity;
        k.c(activity, "activity");
        k.c(iJRDataModel, Payload.RESPONSE);
        if (iJRDataModel2 instanceof PaymentCombinationAPIResponse) {
            net.one97.paytm.f.b.a().c();
            PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) iJRDataModel2;
            if (paymentCombinationAPIResponse.getExtraData() == null) {
                ExtraData extraData = new ExtraData((String) null, (String) null, false, false, false, false, 63, (kotlin.g.b.g) null);
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    extraData.setAmount((String) null);
                    extraData.setAmountEditable(false);
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    extraData.setComment((String) null);
                    extraData.setCommentEditable(false);
                }
                extraData.setGalleryScan(false);
                extraData.setMidScan(false);
                paymentCombinationAPIResponse.setExtraData(extraData);
            }
            net.one97.paytm.f.b a2 = net.one97.paytm.f.b.a();
            k.a((Object) a2, "RiskInformationController.getInstance()");
            RiskExtendedInfo b2 = a2.b();
            k.a((Object) b2, "RiskInformationControlle…stance().riskExtendedInfo");
            b2.setGalleryScan(false);
        }
        if (z) {
            net.one97.paytm.wallet.communicator.b.a().startMoneyTransferActivityForPayResult(activity, i2, iJRDataModel, (String) null, (String) null, i3);
        } else {
            net.one97.paytm.wallet.communicator.b.a().startMoneyTransferActivityForResult(activity, i2, iJRDataModel, (String) null, (String) null, i3);
        }
    }

    public static Intent a(Activity activity) throws IOException {
        k.c(activity, "context");
        return new Intent(activity, SearchActivityV2.class);
    }

    public static void a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str2, "payeePhoneNo");
        net.one97.paytm.wallet.communicator.b.a().openPaytmInviteScreen(context, str, str2);
    }

    public static void a(Activity activity, IJRDataModel iJRDataModel, String str, String str2) {
        k.c(activity, "activity");
        k.c(iJRDataModel, "dataBean");
        if (iJRDataModel instanceof PaymentCombinationAPIResponse) {
            ExtraData extraData = new ExtraData((String) null, (String) null, false, false, false, false, 63, (kotlin.g.b.g) null);
            if (!TextUtils.isEmpty(str)) {
                extraData.setAmount(str);
                extraData.setAmountEditable(false);
            }
            if (!TextUtils.isEmpty(str2)) {
                extraData.setComment(str2);
                extraData.setCommentEditable(false);
            }
            ((PaymentCombinationAPIResponse) iJRDataModel).setExtraData(extraData);
        }
        net.one97.paytm.wallet.communicator.b.a().startMoneyTransferActivityForResult(activity, iJRDataModel, 2001);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, boolean r34, net.one97.paytm.common.entity.p2p.ExtraData r35, boolean r36, boolean r37, boolean r38) {
        /*
            r0 = r27
            r3 = r28
            r4 = r29
            r1 = r35
            java.lang.String r2 = "activity"
            kotlin.g.b.k.c(r0, r2)
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r2 = new net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 4095(0xfff, float:5.738E-42)
            r19 = 0
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            net.one97.paytm.common.entity.p2p.SenderInfo r5 = new net.one97.paytm.common.entity.p2p.SenderInfo
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 15
            r26 = 0
            r20 = r5
            r20.<init>(r21, r22, r23, r24, r25, r26)
            r6 = r30
            r5.setName(r6)
            r6 = r31
            r5.setPhoneNumber(r6)
            r2.setSenderInfo(r5)
            net.one97.paytm.common.entity.p2p.ReceiverInfo r5 = new net.one97.paytm.common.entity.p2p.ReceiverInfo
            r12 = 31
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r6 = r32
            r5.setName(r6)
            r6 = r33
            r5.setPhoneNumber(r6)
            r2.setReceiverInfo(r5)
            java.lang.String r5 = "P2P"
            r2.setCategory(r5)
            java.lang.String r5 = "SUCCESS"
            r2.setStatus(r5)
            java.lang.String r6 = "0000"
            r2.setRespCode(r6)
            r2.setRespMessage(r5)
            net.one97.paytm.common.entity.p2p.PaymentOptionItem r5 = new net.one97.paytm.common.entity.p2p.PaymentOptionItem
            r7 = r5
            r12 = 0
            r18 = 0
            r20 = 0
            r22 = 16383(0x3fff, float:2.2957E-41)
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            java.lang.String r6 = "WALLET-WALLET"
            r5.setCombinationName(r6)
            net.one97.paytm.common.entity.p2p.SourcePayment r6 = new net.one97.paytm.common.entity.p2p.SourcePayment
            r21 = 8191(0x1fff, float:1.1478E-41)
            r22 = 0
            r7 = r6
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r7 = "WALLET"
            r6.setPaymentType(r7)
            java.lang.String r8 = "ENABLED"
            r6.setPaymentInstrumentStatus(r8)
            net.one97.paytm.common.entity.p2p.DestinationPayment r8 = new net.one97.paytm.common.entity.p2p.DestinationPayment
            r16 = 63
            r9 = r8
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            r8.setPaymentType(r7)
            r5.setSourcePayment(r6)
            r5.setDestinationPayment(r8)
            r6 = 100000(0x186a0, float:1.4013E-40)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.setMaxLimit(r6)
            r6 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.setMinLimit(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r5)
            java.util.List r6 = (java.util.List) r6
            r2.setPaymentOptionList(r6)
            r5 = 0
            if (r1 != 0) goto L_0x00f6
            net.one97.paytm.common.entity.p2p.ExtraData r1 = new net.one97.paytm.common.entity.p2p.ExtraData
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 63
            r14 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14)
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00e3
            r1.setAmount(r3)
            r1.setAmountEditable(r5)
        L_0x00e3:
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00f2
            r1.setComment(r4)
            r1.setCommentEditable(r5)
        L_0x00f2:
            r2.setExtraData(r1)
            goto L_0x0105
        L_0x00f6:
            r2.setExtraData(r1)
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r2.getExtraData()
            if (r1 == 0) goto L_0x0105
            boolean r1 = r1.isGalleryScan()
            r6 = r1
            goto L_0x0106
        L_0x0105:
            r6 = 0
        L_0x0106:
            r1 = r0
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.common.entity.IJRDataModel r2 = (net.one97.paytm.common.entity.IJRDataModel) r2
            net.one97.paytm.contacts.utils.e$e r5 = net.one97.paytm.contacts.utils.e.C0905e.PAY
            int r5 = r5.getType()
            r7 = 0
            r3 = r28
            r4 = r29
            r8 = r36
            r9 = r37
            r10 = r38
            a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r34 == 0) goto L_0x0124
            r27.finish()
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.utility.d.a(android.app.Activity, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, net.one97.paytm.common.entity.p2p.ExtraData, boolean, boolean, boolean):void");
    }

    public static void a(Context context, String str, String str2, ChatPaymentIntegrationListener chatPaymentIntegrationListener) {
        k.c(context, "context");
        k.c(str, "payeePhoneNo");
        k.c(str2, "source");
        k.c(chatPaymentIntegrationListener, "chatPaymentIntegrationListener");
        net.one97.paytm.wallet.chatintegration.a aVar = net.one97.paytm.wallet.chatintegration.a.f70137f;
        net.one97.paytm.wallet.chatintegration.a.a(chatPaymentIntegrationListener);
        Intent intent = new Intent(context, ChatShimmerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("payeePhoneNo", str);
        bundle.putString("mode", str2);
        bundle.putString("contactName", (String) null);
        bundle.putString("amount", (String) null);
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, (String) null);
        bundle.putInt("amountStatus", b.a.NONE.getType());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static Intent b(Activity activity) {
        k.c(activity, "context");
        bd.f69715a.a("PAYSENDACTIVITYV2_TRACE");
        bd.f69715a.a("SCANNER_TRACE");
        return new Intent(activity, PaySendActivityV2.class);
    }
}
