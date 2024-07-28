package net.one97.paytm.nativesdk.dataSource.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appsflyer.internal.referrer.Payload;
import easypay.manager.Constants;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.dataSource.PaymentsDataImpl;
import net.one97.paytm.nativesdk.dataSource.models.CardRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.MGVRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.NetBankingRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.PaymentRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.PaytmDigitalRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.PaytmPaymentsBankModel;
import net.one97.paytm.nativesdk.dataSource.models.UPIRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.UpiCollectRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.UpiDataRequestModel;
import net.one97.paytm.nativesdk.dataSource.models.WalletRequestModel;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiDeeplinkResponse;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.DeeplinkInfo;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public final class PaymentUtility {
    private static final String ENABLE_PAYTM_TRANSPARENT_INVOKE = "paytm_invoke";
    public static final PaymentUtility INSTANCE = new PaymentUtility();
    private static final String MERCHANT_CODE = "merchant_code";
    private static final String PAYEE_NAME = "payee_name";
    private static final String PAYEE_VPA = "payee_vpa";
    private static final String PAYER_VPA = "payer_vpa";
    private static final String PAYTM_APP_PACKAGE = "net.one97.paytm";
    private static final String PAYTM_PAYMENT_ACTIVITY_PACKAGE = "net.one97.paytm.AJRRechargePaymentActivity";
    private static final int REQUEST_CODE_UPI_APP = 187;
    private static final String UPI_BANK_ACCOUNT_REQUEST_JSON = UPI_BANK_ACCOUNT_REQUEST_JSON;
    private static final String UPI_CHECK_BALANCE = "upi_check_balance";
    private static final String UPI_PUSH_TOKEN = "upi_push_native_token";
    private static final String UPI_SET_MPIN = "upi_set_mpin";

    public enum FlowType {
        COLLECT,
        INTENT,
        PUSH
    }

    private PaymentUtility() {
    }

    public final void startTransaction(Context context, PaymentRequestModel paymentRequestModel) {
        Context context2 = context;
        PaymentRequestModel paymentRequestModel2 = paymentRequestModel;
        k.c(context2, "context");
        k.c(paymentRequestModel2, "paymentRequestModel");
        if (paymentRequestModel2 instanceof CardRequestModel) {
            CardRequestModel cardRequestModel = (CardRequestModel) paymentRequestModel2;
            String paymentMode = cardRequestModel.getPaymentMode();
            if (!TextUtils.isEmpty(cardRequestModel.getEmiPlanId())) {
                paymentMode = PayMethodType.EMI.name();
            }
            String str = paymentMode;
            PayMethodType payMethodType = PayMethodType.CREDIT_CARD;
            if (p.a(PayMethodType.DEBIT_CARD.name(), cardRequestModel.getPaymentMode(), true)) {
                payMethodType = PayMethodType.DEBIT_CARD;
            }
            PayMethodType payMethodType2 = payMethodType;
            if (!TextUtils.isEmpty(cardRequestModel.getSavedCardId())) {
                PaymentsDataImpl paymentsDataImpl = PaymentsDataImpl.INSTANCE;
                String paymentFlow = paymentRequestModel.getPaymentFlow();
                String savedCardId = cardRequestModel.getSavedCardId();
                if (savedCardId == null) {
                    k.a();
                }
                paymentsDataImpl.doSavedCardTransaction(context, paymentFlow, savedCardId, cardRequestModel.getCardCvv(), cardRequestModel.getBankCode(), cardRequestModel.getChannelCode(), cardRequestModel.getAuthMode(), str, cardRequestModel.getEmiPlanId(), cardRequestModel.isSingleClickEnable(), payMethodType2);
                return;
            }
            PaymentsDataImpl paymentsDataImpl2 = PaymentsDataImpl.INSTANCE;
            String paymentFlow2 = paymentRequestModel.getPaymentFlow();
            String newCardNumber = cardRequestModel.getNewCardNumber();
            if (newCardNumber == null) {
                k.a();
            }
            String cardCvv = cardRequestModel.getCardCvv();
            String cardExpiry = cardRequestModel.getCardExpiry();
            if (cardExpiry == null) {
                k.a();
            }
            paymentsDataImpl2.doNewCardTransaction(context, paymentFlow2, newCardNumber, cardCvv, cardExpiry, cardRequestModel.getBankCode(), cardRequestModel.getChannelCode(), cardRequestModel.getAuthMode(), str, cardRequestModel.getEmiPlanId(), cardRequestModel.getShouldSaveCard(), cardRequestModel.isSingleClickEnable(), payMethodType2);
        } else if (paymentRequestModel2 instanceof NetBankingRequestModel) {
            PaymentsDataImpl.INSTANCE.doNBTransaction(context2, paymentRequestModel.getPaymentFlow(), ((NetBankingRequestModel) paymentRequestModel2).getBankCode());
        } else if (paymentRequestModel2 instanceof WalletRequestModel) {
            PaymentsDataImpl.INSTANCE.doPaytmWalletTransaction(context2);
        } else if (paymentRequestModel2 instanceof MGVRequestModel) {
            PaymentsDataImpl.INSTANCE.doMGVTransaction(context2, PayMethodType.GIFT_VOUCHER.name(), ((MGVRequestModel) paymentRequestModel2).getTemplateId(), paymentRequestModel.getPaymentFlow());
        } else if (paymentRequestModel2 instanceof PaytmDigitalRequestModel) {
            PaymentsDataImpl.INSTANCE.doPostPaidTransaction(context2, PayMethodType.PAYTM_DIGITAL_CREDIT.name(), ((PaytmDigitalRequestModel) paymentRequestModel2).getPin(), paymentRequestModel.getPaymentFlow());
        } else if (paymentRequestModel2 instanceof PaytmPaymentsBankModel) {
            PaymentsDataImpl.INSTANCE.doPaymentsBankTransaction(context2, PayMethodType.PPBL.name(), ((PaytmPaymentsBankModel) paymentRequestModel2).getPin(), paymentRequestModel.getPaymentFlow());
        } else if (paymentRequestModel2 instanceof UPIRequestModel) {
            UPIRequestModel uPIRequestModel = (UPIRequestModel) paymentRequestModel2;
            PaymentsDataImpl.INSTANCE.doUPITransaction(context, uPIRequestModel.getPin(), uPIRequestModel.getSequenceNo(), uPIRequestModel.getDeviceId(), uPIRequestModel.getFlowType().name(), uPIRequestModel.getVpaDetail());
        } else if (paymentRequestModel2 instanceof UpiCollectRequestModel) {
            PaymentsDataImpl.INSTANCE.doUpiCollectTransaction(context2, ((UpiCollectRequestModel) paymentRequestModel2).getUpiId(), paymentRequestModel.getPaymentFlow());
        } else {
            throw new IllegalArgumentException("Invalid PaymentRequestMode");
        }
    }

    public final void fetchUpiBalance(Context context, UpiDataRequestModel upiDataRequestModel) {
        k.c(context, "context");
        k.c(upiDataRequestModel, "upiDataRequestModel");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("net.one97.paytm", PAYTM_PAYMENT_ACTIVITY_PACKAGE));
        intent.putExtra(ENABLE_PAYTM_TRANSPARENT_INVOKE, true);
        intent.putExtra("nativeSdkEnabled", true);
        intent.putExtra(UPI_BANK_ACCOUNT_REQUEST_JSON, upiDataRequestModel.getBankAccountJson());
        intent.putExtra(PAYER_VPA, upiDataRequestModel.getUpiId());
        intent.putExtra(UPI_CHECK_BALANCE, true);
        ((Activity) context).startActivityForResult(intent, upiDataRequestModel.getRequestCode());
    }

    public final void setUpiPin(Context context, UpiDataRequestModel upiDataRequestModel) {
        k.c(context, "context");
        k.c(upiDataRequestModel, "upiDataRequestModel");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("net.one97.paytm", PAYTM_PAYMENT_ACTIVITY_PACKAGE));
        intent.putExtra(ENABLE_PAYTM_TRANSPARENT_INVOKE, true);
        intent.putExtra(UPI_BANK_ACCOUNT_REQUEST_JSON, upiDataRequestModel.getBankAccountJson());
        intent.putExtra(PAYER_VPA, upiDataRequestModel.getUpiId());
        intent.putExtra(UPI_SET_MPIN, true);
        ((Activity) context).startActivityForResult(intent, upiDataRequestModel.getRequestCode());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.nativesdk.transcation.PaymentInstrument getCardInstrument(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, boolean r27, boolean r28, net.one97.paytm.nativesdk.Utils.PayMethodType r29) {
        /*
            r16 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r12 = r24
            r8 = r25
            java.lang.String r6 = "context"
            kotlin.g.b.k.c(r0, r6)
            java.lang.String r6 = "paymentFlow"
            r7 = r18
            kotlin.g.b.k.c(r7, r6)
            java.lang.String r6 = "cardNumber"
            kotlin.g.b.k.c(r1, r6)
            java.lang.String r6 = "cardCvv"
            kotlin.g.b.k.c(r2, r6)
            java.lang.String r6 = "cardExpirylocal"
            kotlin.g.b.k.c(r3, r6)
            java.lang.String r6 = "authMode"
            kotlin.g.b.k.c(r12, r6)
            java.lang.String r6 = "paymentMode"
            kotlin.g.b.k.c(r8, r6)
            java.lang.String r6 = "payMethodType"
            r13 = r29
            kotlin.g.b.k.c(r13, r6)
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r9 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r10 = ""
            r14 = 1
            r11 = 0
            if (r9 != 0) goto L_0x00ce
            java.lang.String r9 = "MAESTRO"
            boolean r9 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r9, (boolean) r11)
            if (r9 != 0) goto L_0x00ce
            java.lang.String r9 = "BAJAJ"
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r5, (boolean) r14)
            if (r9 != 0) goto L_0x00ce
            kotlin.m.l r3 = new kotlin.m.l
            java.lang.String r9 = "/"
            r3.<init>((java.lang.String) r9)
            java.util.List r3 = r3.split(r6, r11)
            boolean r6 = r3.isEmpty()
            if (r6 != 0) goto L_0x0097
            int r6 = r3.size()
            java.util.ListIterator r6 = r3.listIterator(r6)
        L_0x0072:
            boolean r9 = r6.hasPrevious()
            if (r9 == 0) goto L_0x0097
            java.lang.Object r9 = r6.previous()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0088
            r9 = 1
            goto L_0x0089
        L_0x0088:
            r9 = 0
        L_0x0089:
            if (r9 != 0) goto L_0x0072
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            int r6 = r6.nextIndex()
            int r6 = r6 + r14
            java.util.List r3 = kotlin.a.k.b(r3, (int) r6)
            goto L_0x009b
        L_0x0097:
            kotlin.a.w r3 = kotlin.a.w.INSTANCE
            java.util.List r3 = (java.util.List) r3
        L_0x009b:
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.String[] r6 = new java.lang.String[r11]
            java.lang.Object[] r3 = r3.toArray(r6)
            if (r3 == 0) goto L_0x00c6
            java.lang.String[] r3 = (java.lang.String[]) r3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r9 = r3[r11]
            if (r9 != 0) goto L_0x00b1
            r9 = r10
        L_0x00b1:
            r6.append(r9)
            java.lang.String r9 = "20"
            r6.append(r9)
            r3 = r3[r14]
            if (r3 != 0) goto L_0x00be
            r3 = r10
        L_0x00be:
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            goto L_0x00ce
        L_0x00c6:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
            r0.<init>(r1)
            throw r0
        L_0x00ce:
            java.lang.String r6 = "-"
            java.lang.String r9 = "|"
            if (r27 == 0) goto L_0x00fb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = kotlin.m.p.a(r1, r6, r10, r11)
            r3.append(r1)
            java.lang.String r1 = "||"
            r3.append(r1)
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.m.p.b(r1)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
            r3.append(r9)
            java.lang.String r1 = r3.toString()
            goto L_0x0117
        L_0x00fb:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r9)
            java.lang.String r1 = kotlin.m.p.a(r1, r6, r10, r11)
            r15.append(r1)
            r15.append(r9)
            r15.append(r2)
            r15.append(r9)
            r15.append(r3)
            java.lang.String r1 = r15.toString()
        L_0x0117:
            r9 = r1
            net.one97.paytm.nativesdk.Utils.PayMethodType r1 = net.one97.paytm.nativesdk.Utils.PayMethodType.CREDIT_CARD
            java.lang.String r1 = r1.name()
            boolean r1 = r1.equals(r8)
            if (r28 == 0) goto L_0x0127
            java.lang.String r2 = "1"
            goto L_0x0129
        L_0x0127:
            java.lang.String r2 = "0"
        L_0x0129:
            r10 = r2
            r6 = r18
            r7 = r24
            r8 = r25
            r11 = r26
            java.util.HashMap r2 = net.one97.paytm.nativesdk.transcation.PayUtility.getCardsTranscationParam(r6, r7, r8, r9, r10, r11)
            r3 = r26
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0178
            net.one97.paytm.nativesdk.DirectPaymentBL r3 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r6 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            boolean r3 = r3.isNativeJsonRequestSupported()
            java.lang.String r6 = "pgParam"
            if (r3 == 0) goto L_0x0161
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r3 = r2
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r6 = r29.name()
            java.lang.String r7 = "emiType"
            r3.put(r7, r6)
            goto L_0x0170
        L_0x0161:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r3 = r2
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r6 = r29.name()
            java.lang.String r7 = "EMI_TYPE"
            r3.put(r7, r6)
        L_0x0170:
            r3 = r2
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r6 = "channelCode"
            r3.put(r6, r4)
        L_0x0178:
            net.one97.paytm.nativesdk.MerchantBL r3 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r6 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            java.lang.String r3 = r3.getMid()
            net.one97.paytm.nativesdk.MerchantBL r7 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            java.lang.String r7 = r7.getOrderId()
            java.lang.String r3 = net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader.getProcessTranscationUrl(r3, r7)
            java.lang.String r0 = net.one97.paytm.nativesdk.Utils.SDKUtility.addAuthDefaultParams(r0, r3)
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r3 = new net.one97.paytm.nativesdk.transcation.PaymentInstrument
            net.one97.paytm.nativesdk.MerchantBL r7 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            java.lang.String r7 = r7.getMid()
            net.one97.paytm.nativesdk.MerchantBL r8 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            java.lang.String r6 = r8.getOrderId()
            r3.<init>(r7, r6, r0, r2)
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01bf
            r3.setBankCode(r4)
        L_0x01bf:
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01da
            java.lang.String r0 = "otp"
            boolean r0 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r0, (boolean) r14)
            if (r0 == 0) goto L_0x01da
            if (r1 == 0) goto L_0x01d5
            java.lang.String r0 = "CC"
            goto L_0x01d7
        L_0x01d5:
            java.lang.String r0 = "DC"
        L_0x01d7:
            r3.setPayType(r0)
        L_0x01da:
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01e6
            r3.setCardType(r5)
        L_0x01e6:
            java.lang.String r0 = "Cod"
            r3.setGaPaymentMethod(r0)
            java.lang.String r0 = "New"
            r3.setGaPaymentMode(r0)
            boolean r0 = r16.isNativeJsonFlowEnabled()
            if (r0 == 0) goto L_0x01fc
            java.lang.String r0 = "Native_plus"
            r3.setGaFlowType(r0)
            goto L_0x0201
        L_0x01fc:
            java.lang.String r0 = "Native"
            r3.setGaFlowType(r0)
        L_0x0201:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility.getCardInstrument(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, net.one97.paytm.nativesdk.Utils.PayMethodType):net.one97.paytm.nativesdk.transcation.PaymentInstrument");
    }

    public final PaytmAssistParams getAssistParams(String str, String str2, PayMethodType payMethodType, String str3) {
        k.c(str2, PayUtility.AUTH_MODE);
        k.c(payMethodType, "selectedPaymentMode");
        PaytmAssistParams paytmAssistParams = new PaytmAssistParams();
        if (!TextUtils.isEmpty(str)) {
            paytmAssistParams.setBankCode(str);
        }
        if (!TextUtils.isEmpty(str2) && p.a(str2, "otp", true)) {
            paytmAssistParams.setPayType(payMethodType == PayMethodType.CREDIT_CARD ? Constants.EASYPAY_PAYTYPE_CREDIT_CARD : Constants.EASYPAY_PAYTYPE_DEBIT_CARD);
        }
        if (!TextUtils.isEmpty(str3)) {
            paytmAssistParams.setCardType(str3);
        }
        return paytmAssistParams;
    }

    public final void goForNBTransaction(Activity activity, String str, String str2, String str3) {
        k.c(activity, "mContext");
        k.c(str, "paymentMode");
        k.c(str2, "selectedChannelCode");
        k.c(str3, PayUtility.PAYMENT_FLOW);
        HashMap<String, String> nBTranscationParam = PayUtility.getNBTranscationParam(str, str2, str3);
        PaytmAssistParams paytmAssistParams = new PaytmAssistParams();
        CharSequence charSequence = str2;
        if (!TextUtils.isEmpty(charSequence)) {
            paytmAssistParams.setBankCode(str2);
        }
        paytmAssistParams.setPayType("NB");
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        Context context = activity;
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        String mid2 = merchantInstance3.getMid();
        MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
        PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, nBTranscationParam);
        if (!TextUtils.isEmpty(charSequence)) {
            paymentInstrument.setBankCode(str2);
        }
        paymentInstrument.setPayType("NB");
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_NETBANKING);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_NEW);
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_REDIRECTION);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context, "Net banking", paymentInstrument);
        transactionProcessor.setAssistParams(paytmAssistParams);
        transactionProcessor.startTransaction();
    }

    public final void goForWalletTranscation(Context context, String str) {
        k.c(context, "mContext");
        k.c(str, "paymentMode");
        HashMap<String, String> balanceParam = PayUtility.getBalanceParam(str);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        String mid2 = merchantInstance3.getMid();
        MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
        PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, balanceParam);
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_BALANCE);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        new TransactionProcessor(context, "wallet", paymentInstrument).startTransaction();
    }

    public final void goForPostpaidTransaction(Activity activity, String str, String str2) {
        String str3;
        k.c(activity, "mContext");
        k.c(str, "mPin");
        k.c(str2, "paymentMode");
        if (SDKUtility.isHybridCase()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_PPB, SDKConstants.GA_KEY_HYBRID, String.valueOf(System.currentTimeMillis()), "Accept_pay"));
        } else {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.GA_KEY_PPB, SDKConstants.GA_KEY_NEW, String.valueOf(System.currentTimeMillis()), "Accept_pay"));
        }
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        Context context = activity;
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
        HashMap<String, String> paymentsBankParam = PayUtility.getPaymentsBankParam(str2, str);
        boolean z = false;
        if (!isNativeJsonFlowEnabled()) {
            str3 = "";
        } else if (p.a(SDKConstants.AI_KEY_PPBL, str2, true)) {
            str3 = BaseViewModel.PaymentType.PPB;
        } else {
            str3 = BaseViewModel.PaymentType.POSTPAID;
            z = true;
        }
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        String mid2 = merchantInstance3.getMid();
        MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
        PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, paymentsBankParam);
        paymentInstrument.setGaPaymentMethod(z ? SDKConstants.GA_KEY_POSTPAID : SDKConstants.GA_KEY_PPB);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        if (isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        new TransactionProcessor(context, str3, paymentInstrument).startTransaction();
    }

    private final String getBinPaymentMode(BinResponse binResponse, boolean z, boolean z2) {
        Body body;
        if (z2) {
            return z ? PayMethodType.EMI.name() : SDKConstants.EMI_DC;
        }
        if (((binResponse == null || (body = binResponse.getBody()) == null) ? null : body.getBinDetail()) != null) {
            Body body2 = binResponse.getBody();
            k.a((Object) body2, "binResponse.body");
            BinDetail binDetail = body2.getBinDetail();
            k.a((Object) binDetail, "binResponse.body.binDetail");
            String paymentMode = binDetail.getPaymentMode();
            if (!TextUtils.isEmpty(paymentMode)) {
                k.a((Object) paymentMode, "binPaymentMode");
                return paymentMode;
            }
        }
        return z ? PayMethodType.CREDIT_CARD.name() : PayMethodType.DEBIT_CARD.name();
    }

    public final boolean isNativeJsonFlowEnabled() {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        return instance.isNativeJsonRequestSupported();
    }

    public final void fetchDeepLinkForIntentFlow(Context context, String str, String str2, ActivityInfo activityInfo) {
        k.c(context, "context");
        k.c(str, "selectedAppName");
        k.c(str2, "selectedPackageName");
        k.c(activityInfo, "activityInfo");
        if (!SDKUtility.isNetworkAvailable(context)) {
            Toast.makeText(context, context.getString(R.string.no_connection), 1).show();
            return;
        }
        try {
            if (!appInstalledOrNot(context, str2)) {
                Toast.makeText(context, context.getString(R.string.app_not_installed), 1).show();
                return;
            }
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance.getMid();
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            PaymentInstrument paymentInstrument = new PaymentInstrument(mid, merchantInstance2.getOrderId(), (String) null, (HashMap<String, String>) null);
            paymentInstrument.setRequestBody(getUpiIntentRequestBody(str));
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_INTENT);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
            if (isNativeJsonFlowEnabled()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            TransactionProcessor transactionProcessor = new TransactionProcessor(context, BaseViewModel.PaymentType.UPI_INTENT, paymentInstrument);
            transactionProcessor.setTransactionProcessorListener(new PaymentUtility$fetchDeepLinkForIntentFlow$1(context, activityInfo));
            transactionProcessor.startTransaction();
        } catch (Exception unused) {
            Toast.makeText(context, context.getString(R.string.app_not_installed), 1).show();
        }
    }

    public final void onResponse(Context context, Object obj, ActivityInfo activityInfo) {
        String str;
        k.c(context, "context");
        k.c(obj, Payload.RESPONSE);
        k.c(activityInfo, "activityInfo");
        if (obj instanceof DeeplinkInfo) {
            str = ((DeeplinkInfo) obj).getDeepLink();
        } else if (obj instanceof UpiDeeplinkResponse) {
            UpiDeeplinkResponse.Body body = ((UpiDeeplinkResponse) obj).getBody();
            k.a((Object) body, "response.body");
            str = body.getDeeplink();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            String builder = Uri.parse(str).buildUpon().toString();
            k.a((Object) builder, "upiDeepLink.toString()");
            openUpiApplication(context, activityInfo, builder);
        }
    }

    private final void openUpiApplication(Context context, ActivityInfo activityInfo, String str) {
        try {
            ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setComponent(componentName);
            if (context instanceof Activity) {
                ((AppCompatActivity) context).startActivityForResult(intent, 187);
            } else {
                context.startActivity(intent);
            }
        } catch (Exception e2) {
            LogUtility.e("UpiCollectViewModel", "Something went wrong when opening application".concat(String.valueOf(e2)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getUpiIntentRequestBody(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "appName"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.nativesdk.instruments.upicollect.models.Body r0 = new net.one97.paytm.nativesdk.instruments.upicollect.models.Body
            r0.<init>()
            net.one97.paytm.nativesdk.MerchantBL r1 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            java.lang.String r2 = "MerchantBL.getMerchantInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getMid()
            r0.setMid(r1)
            net.one97.paytm.nativesdk.MerchantBL r1 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.getOrderId()
            r0.setOrderId(r1)
            java.lang.String r1 = "UPI_INTENT"
            r0.setPaymentMode(r1)
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            java.lang.String r3 = "DirectPaymentBL.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            boolean r1 = r1.isPaytmWalletChecked()
            if (r1 == 0) goto L_0x005a
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            boolean r1 = r1.isWalletAmountSufficientToPay()
            if (r1 != 0) goto L_0x005a
            net.one97.paytm.nativesdk.DirectPaymentBL r1 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r1 = r1.getPaymentFlowAvailable()
            java.lang.String r3 = "DirectPaymentBL.getInstance().paymentFlowAvailable"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            goto L_0x005c
        L_0x005a:
            java.lang.String r1 = "NONE"
        L_0x005c:
            r0.setPaymentFlow(r1)
            java.lang.String r1 = "NATIVE"
            r0.setRequestType(r1)
            java.lang.String r1 = ""
            r0.setRefUrl(r1)
            r0.setTxnNote(r1)
            net.one97.paytm.nativesdk.instruments.upicollect.models.ExtendInfo r3 = new net.one97.paytm.nativesdk.instruments.upicollect.models.ExtendInfo
            r3.<init>()
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            boolean r2 = r4.isFromAllInOneSDK()
            if (r2 == 0) goto L_0x0081
            java.lang.String r2 = "AIO_SDK_PG"
            goto L_0x0082
        L_0x0081:
            r2 = r1
        L_0x0082:
            r3.setSdkType(r2)
            r3.setUdf1(r1)
            r3.setUdf2(r1)
            r3.setUdf3(r1)
            r3.setPayerPSPApp(r6)
            java.lang.String r6 = "NA"
            r3.setComments(r6)
            r3.setMercUnqRef(r1)
            r0.setExtendInfo(r3)
            com.google.gson.f r6 = new com.google.gson.f
            r6.<init>()
            java.lang.String r6 = r6.b(r0)
            java.lang.String r0 = "Gson().toJson(body)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility.getUpiIntentRequestBody(java.lang.String):java.lang.String");
    }

    public final boolean appInstalledOrNot(Context context, String str) {
        k.c(context, "context");
        k.c(str, "uri");
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void goForUPITrannscation(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "enteredVpa");
        k.c(str2, PayUtility.PAYMENT_FLOW);
        VpaBankAccountDetail registeredVpa = getRegisteredVpa(str);
        if (registeredVpa == null || !SDKUtility.isPaytmApp(context)) {
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            if (instance.isOpeningAuto()) {
                if (SDKUtility.isHybridCase()) {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.UPI_COLLECT, SDKConstants.GA_KEY_HYBRID, String.valueOf(System.currentTimeMillis()), ""));
                } else {
                    SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_clicked", SDKConstants.UPI_COLLECT, SDKConstants.GA_KEY_NEW, String.valueOf(System.currentTimeMillis()), ""));
                }
            }
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance.getMid();
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
            HashMap<String, String> upiCollectParam = PayUtility.getUpiCollectParam(str, str2);
            MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
            String mid2 = merchantInstance3.getMid();
            MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
            PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, upiCollectParam);
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_COllECT);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
            if (isNativeJsonFlowEnabled()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            new TransactionProcessor(context, BaseViewModel.PaymentType.UPI_COLLECT, paymentInstrument).startTransaction();
            return;
        }
        SDKUtility.startUpiPush(context, registeredVpa, SDKConstants.PUSH_FROM_COLLECT, "", str2);
    }

    public final VpaBankAccountDetail getRegisteredVpa(String str) {
        k.c(str, "enteredVpa");
        List<VpaBankAccountDetail> allUnFilteredVpas = SDKUtility.getAllUnFilteredVpas();
        if (allUnFilteredVpas != null && !allUnFilteredVpas.isEmpty()) {
            CharSequence charSequence = str;
            if (TextUtils.isEmpty(charSequence)) {
                return null;
            }
            int size = allUnFilteredVpas.size();
            for (int i2 = 0; i2 < size; i2++) {
                VpaAccountDetail vpaDetail = allUnFilteredVpas.get(i2).getVpaDetail();
                String name = vpaDetail != null ? vpaDetail.getName() : null;
                int length = charSequence.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length) {
                    boolean z2 = charSequence.charAt(!z ? i3 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i3++;
                    }
                }
                if (p.a(name, charSequence.subSequence(i3, length + 1).toString(), true)) {
                    return allUnFilteredVpas.get(i2);
                }
            }
        }
        return null;
    }

    public final boolean isPaytmAppInstalled$nativesdk_debug(Context context) {
        k.c(context, "context");
        try {
            context.getPackageManager().getPackageInfo("net.one97.paytm", 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final String getPaytmVersion$nativesdk_debug(Context context) {
        k.c(context, "context");
        try {
            return context.getPackageManager().getPackageInfo("net.one97.paytm", 1).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int versionCompare$nativesdk_debug(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "str1"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "str2"
            kotlin.g.b.k.c(r7, r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 1
            if (r0 != 0) goto L_0x0109
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x001d
            goto L_0x0109
        L_0x001d:
            kotlin.m.l r0 = new kotlin.m.l
            java.lang.String r2 = "\\."
            r0.<init>((java.lang.String) r2)
            r3 = 0
            java.util.List r6 = r0.split(r6, r3)
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x005c
            int r0 = r6.size()
            java.util.ListIterator r0 = r6.listIterator(r0)
        L_0x0037:
            boolean r4 = r0.hasPrevious()
            if (r4 == 0) goto L_0x005c
            java.lang.Object r4 = r0.previous()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x004d
            r4 = 1
            goto L_0x004e
        L_0x004d:
            r4 = 0
        L_0x004e:
            if (r4 != 0) goto L_0x0037
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            int r0 = r0.nextIndex()
            int r0 = r0 + r1
            java.util.List r6 = kotlin.a.k.b(r6, (int) r0)
            goto L_0x0060
        L_0x005c:
            kotlin.a.w r6 = kotlin.a.w.INSTANCE
            java.util.List r6 = (java.util.List) r6
        L_0x0060:
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.String[] r0 = new java.lang.String[r3]
            java.lang.Object[] r6 = r6.toArray(r0)
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            if (r6 == 0) goto L_0x0103
            java.lang.String[] r6 = (java.lang.String[]) r6
            kotlin.m.l r4 = new kotlin.m.l
            r4.<init>((java.lang.String) r2)
            java.util.List r7 = r4.split(r7, r3)
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L_0x00aa
            int r2 = r7.size()
            java.util.ListIterator r2 = r7.listIterator(r2)
        L_0x0085:
            boolean r4 = r2.hasPrevious()
            if (r4 == 0) goto L_0x00aa
            java.lang.Object r4 = r2.previous()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x009b
            r4 = 1
            goto L_0x009c
        L_0x009b:
            r4 = 0
        L_0x009c:
            if (r4 != 0) goto L_0x0085
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            int r2 = r2.nextIndex()
            int r2 = r2 + r1
            java.util.List r7 = kotlin.a.k.b(r7, (int) r2)
            goto L_0x00ae
        L_0x00aa:
            kotlin.a.w r7 = kotlin.a.w.INSTANCE
            java.util.List r7 = (java.util.List) r7
        L_0x00ae:
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.String[] r2 = new java.lang.String[r3]
            java.lang.Object[] r7 = r7.toArray(r2)
            if (r7 == 0) goto L_0x00fd
            java.lang.String[] r7 = (java.lang.String[]) r7
        L_0x00ba:
            int r0 = r6.length
            if (r3 >= r0) goto L_0x00cd
            int r0 = r7.length
            if (r3 >= r0) goto L_0x00cd
            r0 = r6[r3]
            r2 = r7[r3]
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 == 0) goto L_0x00cd
            int r3 = r3 + 1
            goto L_0x00ba
        L_0x00cd:
            int r0 = r6.length
            if (r3 >= r0) goto L_0x00f5
            int r0 = r7.length
            if (r3 >= r0) goto L_0x00f5
            r6 = r6[r3]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r6 = r6.intValue()
            r7 = r7[r3]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r0 = "Integer.valueOf(vals2[i])"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            int r7 = r7.intValue()
            int r6 = kotlin.g.b.k.a((int) r6, (int) r7)
            int r6 = java.lang.Integer.signum(r6)
            return r6
        L_0x00f5:
            int r6 = r6.length
            int r7 = r7.length
            int r6 = r6 - r7
            int r6 = java.lang.Integer.signum(r6)
            return r6
        L_0x00fd:
            kotlin.u r6 = new kotlin.u
            r6.<init>(r0)
            throw r6
        L_0x0103:
            kotlin.u r6 = new kotlin.u
            r6.<init>(r0)
            throw r6
        L_0x0109:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility.versionCompare$nativesdk_debug(java.lang.String, java.lang.String):int");
    }
}
