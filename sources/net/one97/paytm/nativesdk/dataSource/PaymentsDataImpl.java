package net.one97.paytm.nativesdk.dataSource;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.alipay.mobile.h5container.api.H5Event;
import com.android.volley.DefaultRetryPolicy;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.PayMethodType;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.common.Requester.APIReqtGenerator;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.dataSource.models.CreateTransaction;
import net.one97.paytm.nativesdk.dataSource.models.CreateTranscationResponse;
import net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiResponse;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.BaseVpaDetail;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.transcation.PayActivityNew;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public final class PaymentsDataImpl implements PaymentDataSource {
    public static final PaymentsDataImpl INSTANCE = new PaymentsDataImpl();

    private PaymentsDataImpl() {
    }

    public final void doUPITransaction(Context context, String str, String str2, String str3, String str4, BaseVpaDetail baseVpaDetail) {
        PaymentInstrument paymentInstrument;
        k.c(context, "context");
        k.c(str, "mPin");
        k.c(str2, "sequenceNo");
        k.c(str3, "deviceId");
        k.c(baseVpaDetail, "vpaDetail");
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId()));
        HashMap<String, String> uPITransactionRequest = PayUtility.getUPITransactionRequest(str, str2, str3, str4, baseVpaDetail);
        if (p.a("intent", str4, true) || p.a(SDKConstants.PUSH_FROM_COLLECT, str4, true)) {
            new TransactionProcessor(context, "upi_push", new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), addAuthDefaultParams, uPITransactionRequest)).startTransaction((View) null);
            return;
        }
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), (String) null, PayUtility.getUpiPushRequestParam(str, str2, str3, baseVpaDetail));
        } else {
            paymentInstrument = new PaymentInstrument(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId(), SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())), PayUtility.getUpiPushRequestParamWebRedirection(str, str2, str3, baseVpaDetail));
        }
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        new TransactionProcessor(context, "upi_push", paymentInstrument).startTransaction((View) null);
    }

    public final void doPaymentsBankTransaction(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "paymentMode");
        k.c(str2, "pin");
        k.c(str3, PayUtility.PAYMENT_FLOW);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
        HashMap<String, String> paymentsBankParam = PayUtility.getPaymentsBankParam(str, str2, str3);
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        String mid2 = merchantInstance3.getMid();
        MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
        PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, paymentsBankParam);
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_PPB);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        if (PaymentUtility.INSTANCE.isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        new TransactionProcessor(context, BaseViewModel.PaymentType.PPB, paymentInstrument).startTransaction((View) null);
    }

    public final void doMGVTransaction(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "paymentMode");
        k.c(str2, PayUtility.TEMPLATE_ID);
        k.c(str3, PayUtility.PAYMENT_FLOW);
        HashMap<String, String> giftVoucherParam = PayUtility.getGiftVoucherParam(str, str2, str3);
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
        PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, giftVoucherParam);
        paymentInstrument.setGaPaymentMethod("Gift Voucher");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        new TransactionProcessor(context, "Gift Voucher", paymentInstrument).startTransaction((View) null);
    }

    public final void doPostPaidTransaction(Context context, String str, String str2, String str3) {
        k.c(context, "context");
        k.c(str, "paymentMode");
        k.c(str2, "pin");
        k.c(str3, PayUtility.PAYMENT_FLOW);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
        HashMap<String, String> digitalCreditParam = PayUtility.getDigitalCreditParam(str, str2, str3);
        Intent intent = new Intent(context, PayActivityNew.class);
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        String mid2 = merchantInstance3.getMid();
        MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
        intent.putExtra(SDKConstants.PAYMENT_INFO, new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, digitalCreditParam));
        intent.putExtra(SDKConstants.KEY_PAYMODE, BaseViewModel.PaymentType.POSTPAID);
        context.startActivity(intent);
        PayUtility.startPayActivity(context);
    }

    public final void doNewCardTransaction(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, boolean z2, PayMethodType payMethodType) {
        Context context2;
        OneClickLoadingHelper oneClickLoadingHelper;
        String str10 = str6;
        String str11 = str7;
        boolean z3 = z2;
        PayMethodType payMethodType2 = payMethodType;
        k.c(context, "context");
        String str12 = str;
        k.c(str12, PayUtility.PAYMENT_FLOW);
        String str13 = str2;
        k.c(str13, SDKConstants.CARD_NUMBER);
        String str14 = str3;
        k.c(str14, "cardCvv");
        String str15 = str4;
        k.c(str15, "cardExpiry");
        k.c(str11, PayUtility.AUTH_MODE);
        String str16 = str8;
        k.c(str16, "paymentMode");
        k.c(payMethodType2, "payMethodType");
        PayMethodType payMethodType3 = payMethodType2;
        PaymentInstrument cardInstrument = PaymentUtility.INSTANCE.getCardInstrument(context, str12, str13, str14, str15, str5, str6, str7, str16, str9, false, z, payMethodType);
        PaytmAssistParams assistParams = PaymentUtility.INSTANCE.getAssistParams(str5, str11, payMethodType, str10);
        boolean z4 = z2;
        if (z4) {
            context2 = context;
            oneClickLoadingHelper = SDKUtils.INSTANCE.getOneClickHelper(context2, str10);
        } else {
            context2 = context;
            oneClickLoadingHelper = null;
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context2, BaseViewModel.PaymentType.CARD, cardInstrument);
        transactionProcessor.setAssistParams(assistParams);
        transactionProcessor.startTransaction((View) null);
        transactionProcessor.setVisaSingleClickEnabled(z4);
        transactionProcessor.setTranscationListener(oneClickLoadingHelper);
    }

    public final void doSavedCardTransaction(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, PayMethodType payMethodType) {
        Context context2;
        OneClickLoadingHelper oneClickLoadingHelper;
        String str9 = str5;
        String str10 = str6;
        boolean z2 = z;
        PayMethodType payMethodType2 = payMethodType;
        k.c(context, "context");
        String str11 = str;
        k.c(str11, PayUtility.PAYMENT_FLOW);
        String str12 = str2;
        k.c(str12, "savedCardId");
        String str13 = str3;
        k.c(str13, "cardCvv");
        k.c(str10, PayUtility.AUTH_MODE);
        String str14 = str7;
        k.c(str14, "paymentMode");
        k.c(payMethodType2, "payMethodType");
        PayMethodType payMethodType3 = payMethodType2;
        PaymentInstrument cardInstrument = PaymentUtility.INSTANCE.getCardInstrument(context, str11, str12, str13, "", str4, str5, str6, str14, str8, true, false, payMethodType);
        PaytmAssistParams assistParams = PaymentUtility.INSTANCE.getAssistParams(str4, str10, payMethodType, str9);
        boolean z3 = z;
        if (z3) {
            context2 = context;
            oneClickLoadingHelper = SDKUtils.INSTANCE.getOneClickHelper(context2, str9);
        } else {
            context2 = context;
            oneClickLoadingHelper = null;
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context2, BaseViewModel.PaymentType.CARD, cardInstrument);
        transactionProcessor.setAssistParams(assistParams);
        transactionProcessor.startTransaction((View) null);
        transactionProcessor.setVisaSingleClickEnabled(z3);
        transactionProcessor.setTranscationListener(oneClickLoadingHelper);
    }

    public final void doNBTransaction(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, PayUtility.PAYMENT_FLOW);
        k.c(str2, "selectedChannelCode");
        HashMap<String, String> nBTranscationParam = PayUtility.getNBTranscationParam(PayMethodType.NET_BANKING.name(), str2, str);
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
        if (PaymentUtility.INSTANCE.isNativeJsonFlowEnabled()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_REDIRECTION);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context, "Net banking", paymentInstrument);
        transactionProcessor.setAssistParams(paytmAssistParams);
        transactionProcessor.startTransaction((View) null);
    }

    public final void doUpiCollectTransaction(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "upiId");
        k.c(str2, PayUtility.PAYMENT_FLOW);
        VpaBankAccountDetail registeredVpa = PaymentUtility.INSTANCE.getRegisteredVpa(str);
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
            if (PaymentUtility.INSTANCE.isNativeJsonFlowEnabled()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            new TransactionProcessor(context, BaseViewModel.PaymentType.UPI_COLLECT, paymentInstrument).startTransaction((View) null);
            return;
        }
        SDKUtility.startUpiPush(context, registeredVpa, SDKConstants.PUSH_FROM_COLLECT, "", str2);
    }

    public final void makeUPITransactionStatusRequest(Context context, String str) {
        k.c(context, "context");
        k.c(str, PayUtility.PAYMENT_FLOW);
        String transId = PaytmSDK.getTransId();
        CharSequence charSequence = transId;
        if (!(charSequence == null || p.a(charSequence))) {
            String upiTransactionStatus = NativeSdkGtmLoader.getUpiTransactionStatus();
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance.getMid();
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            PaymentInstrument paymentInstrument = new PaymentInstrument(mid, merchantInstance2.getOrderId(), upiTransactionStatus, PayUtility.getUpiCollectWithAppParam(transId, PaytmSDK.getCashierRequestId(), str));
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_INTENT);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            if (instance.isNativeJsonRequestSupported()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            new TransactionProcessor(context, BaseViewModel.PaymentType.UPI_INTENT, paymentInstrument).makeTransactionStatusRequest(transId, (View) null);
        }
    }

    public final void initiateTransaction(Context context, String str, String str2, CreateTransaction createTransaction, PaymentMethodDataSource.Callback<CreateTranscationResponse> callback) {
        k.c(context, "context");
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        k.c(str2, "orderId");
        k.c(createTransaction, "createTransactionRequest");
        k.c(callback, H5Event.TYPE_CALL_BACK);
        VolleyRequestQueue.getInstance(context.getApplicationContext()).addToRequestQueue(new VolleyPostRequest(1, getCreateTransactionUrl(str, str2), (Map<String, String>) null, (Map<String, String>) null, new f().b(createTransaction), new PaymentsDataImpl$initiateTransaction$createTranspRequest$1(callback), new PaymentsDataImpl$initiateTransaction$createTranspRequest$2(callback), CreateTranscationResponse.class));
    }

    private final String getCreateTransactionUrl(String str, String str2) {
        return NativeSdkGtmLoader.getBaseUrl() + "/api/v1/initiateTransaction?mid=" + str + "&orderId=" + str2;
    }

    public final void getNBList(PaymentMethodDataSource.Callback<NBResponse> callback) {
        k.c(callback, H5Event.TYPE_CALL_BACK);
        NativeSDKRepository.getInstance().fetchNBDetails("MERCHANT", new PaymentsDataImpl$getNBList$1(callback));
    }

    public final ArrayList<UpiOptionsModel> getUpiAppsInstalled(Context context) {
        k.c(context, "context");
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("upi").authority("pay");
        List<UpiOptionsModel> upiAppsInstalled = SDKUtility.getUpiAppsInstalled(context, builder.toString());
        if (upiAppsInstalled != null) {
            return (ArrayList) upiAppsInstalled;
        }
        throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.nativesdk.instruments.upicollect.models.UpiOptionsModel>");
    }

    public final void fetchEMIDetails(String str, String str2, PaymentMethodDataSource.Callback<EmiResponse> callback) {
        k.c(str, "channelCode");
        k.c(str2, "emiType");
        k.c(callback, H5Event.TYPE_CALL_BACK);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String ssoToken = merchantInstance.getSsoToken();
            k.a((Object) ssoToken, "MerchantBL.getMerchantInstance().ssoToken");
            hashMap.put("SSO_TOKEN", ssoToken);
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance2.getMid();
            MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
            VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.getEmiDetailsUrl(mid, merchantInstance3.getOrderId()), hashMap, (Map<String, String>) null, APIReqtGenerator.createJsonForEmiDetailsAPI(str, str2, false), new PaymentsDataImpl$fetchEMIDetails$request$1(callback), new PaymentsDataImpl$fetchEMIDetails$request$2(callback), EmiResponse.class);
            volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
            VolleyRequestQueue.getInstance(PaytmSDK.getAppContext()).addToRequestQueue(volleyPostRequest);
        } catch (Exception unused) {
            callback.onErrorResponse(new CustomVolleyError("error in initializing request data."), null);
        }
    }

    public final void doUpiIntentTransaction(Context context, String str, ActivityInfo activityInfo) {
        k.c(context, "context");
        k.c(str, "selectedAppName");
        k.c(activityInfo, "activityInfo");
        String str2 = activityInfo.packageName;
        PaytmSDK.setTransId((String) null);
        PaytmSDK.setCashierRequestId((String) null);
        if (!SDKUtility.isNetworkAvailable(context)) {
            Toast.makeText(context, context.getString(R.string.no_connection), 1).show();
            return;
        }
        try {
            PaymentUtility paymentUtility = PaymentUtility.INSTANCE;
            k.a((Object) str2, "selectedPackageName");
            if (!paymentUtility.appInstalledOrNot(context, str2)) {
                Toast.makeText(context, context.getString(R.string.app_not_installed), 1).show();
                return;
            }
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance.getMid();
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            PaymentInstrument paymentInstrument = new PaymentInstrument(mid, merchantInstance2.getOrderId(), (String) null, (HashMap<String, String>) null);
            paymentInstrument.setRequestBody(PaymentUtility.INSTANCE.getUpiIntentRequestBody(str));
            paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_INTENT);
            paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
            if (PaymentUtility.INSTANCE.isNativeJsonFlowEnabled()) {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
            } else {
                paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
            }
            TransactionProcessor transactionProcessor = new TransactionProcessor(context, BaseViewModel.PaymentType.UPI_INTENT, paymentInstrument);
            transactionProcessor.setTransactionProcessorListener(new PaymentsDataImpl$doUpiIntentTransaction$1(context, activityInfo));
            transactionProcessor.startTransaction((View) null);
        } catch (Exception unused) {
            Toast.makeText(context, context.getString(R.string.app_not_installed), 1).show();
        }
    }

    public final void doPaytmWalletTransaction(Context context) {
        k.c(context, "context");
        HashMap<String, String> balanceParam = PayUtility.getBalanceParam(PayMethodType.BALANCE.name());
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
        new TransactionProcessor(context, "wallet", paymentInstrument).startTransaction((View) null);
    }

    public final void fetchPaymentOptions(String str, String str2, String str3, PaymentMethodDataSource.Callback<CJPayMethodResponse> callback) {
        k.c(str, SDKConstants.KEY_MERCHANT_ID);
        k.c(str2, "orderId");
        k.c(str3, "txnToken");
        k.c(callback, H5Event.TYPE_CALL_BACK);
        NativeSDKRepository.getInstance().fetchPayOptions(str, str2, str3, callback);
    }

    public final void fetchBinDetails(String str, PaymentMethodDataSource.Callback<BinResponse> callback) {
        k.c(str, "cardSixDigits");
        k.c(callback, H5Event.TYPE_CALL_BACK);
        if (str.length() >= 6) {
            if (str.length() > 6) {
                str = str.substring(0, 6);
                k.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            NativeSDKRepository.getInstance().fetchBinDetails(str, callback);
            return;
        }
        throw new IllegalArgumentException("Card length expected 6 received " + str.length());
    }

    public final void hitCloseOrderApi() {
        NativeSDKRepository.getInstance().notifyServerAboutCloseOrder();
    }
}
