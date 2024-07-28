package net.one97.paytm.nativesdk.orflow.transaction.fragment;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.a;
import com.google.gson.f;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class BankOfferTransactionViewModel extends a {
    private final Application applicationContext;
    private VpaBankAccountDetail vpaDetailSelectedItem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankOfferTransactionViewModel(Application application) {
        super(application);
        k.c(application, "applicationContext");
        this.applicationContext = application;
    }

    public final void makeProcessTransactionRequest(Context context, View view) {
        PromoPayOptionAdapterParam selectedPaymentInstrument;
        PromoPayOptionAdapterParam selectedPaymentInstrument2 = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
        String str = null;
        Integer valueOf = selectedPaymentInstrument2 != null ? Integer.valueOf(selectedPaymentInstrument2.getVIEWTYPE()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            makeNetBankingRequest(context, view);
        } else if (valueOf != null && valueOf.intValue() == 3) {
            PromoPayOptionAdapterParam selectedPaymentInstrument3 = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
            BaseDataModel data = selectedPaymentInstrument3 != null ? selectedPaymentInstrument3.getData() : null;
            if (!(data instanceof VpaBankAccountDetail)) {
                data = null;
            }
            VpaBankAccountDetail vpaBankAccountDetail = (VpaBankAccountDetail) data;
            if (vpaBankAccountDetail != null) {
                this.vpaDetailSelectedItem = vpaBankAccountDetail;
                if (!SDKUtility.isPaytmApp(context) || !SDKUtility.isUpiPushEnabled() || this.vpaDetailSelectedItem == null) {
                    VpaBankAccountDetail vpaBankAccountDetail2 = this.vpaDetailSelectedItem;
                    if (vpaBankAccountDetail2 != null) {
                        str = vpaBankAccountDetail2.getName();
                    }
                    makeUpiCollectRequest(context, str, view);
                    return;
                }
                MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
                k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
                SDKUtility.startUpiPush(context, vpaBankAccountDetail, SDKConstants.PUSH_FROM_PUSH, merchantInstance.getAmount());
            }
        } else if (valueOf != null && valueOf.intValue() == 4) {
            PromoPayOptionAdapterParam selectedPaymentInstrument4 = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
            if (selectedPaymentInstrument4 != null) {
                VpaBankAccountDetail registeredVpa = SDKUtility.getRegisteredVpa(selectedPaymentInstrument4.getUpiAddress());
                if (registeredVpa == null || !SDKUtility.isPaytmApp(context) || !SDKUtility.isUpiPushEnabled()) {
                    makeUpiCollectRequest(context, selectedPaymentInstrument4.getUpiAddress(), view);
                    return;
                }
                this.vpaDetailSelectedItem = registeredVpa;
                MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
                k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
                SDKUtility.startUpiPush(context, registeredVpa, SDKConstants.PUSH_FROM_COLLECT, merchantInstance2.getAmount());
            }
        } else if (((valueOf != null && valueOf.intValue() == 6) || (valueOf != null && valueOf.intValue() == 5)) && (selectedPaymentInstrument = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument()) != null) {
            makePostpaidRequest(context, selectedPaymentInstrument.getMode(), view);
        }
    }

    private final void makePostpaidRequest(Context context, String str, View view) {
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
        HashMap<String, String> paymentsBankParam = PayUtility.getPaymentsBankParam(str, (String) null);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        String str2 = instance.isNativeJsonRequestSupported() ? p.a(SDKConstants.AI_KEY_PPBL, str, true) ? BaseViewModel.PaymentType.PPB : BaseViewModel.PaymentType.POSTPAID : "";
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        String mid2 = merchantInstance3.getMid();
        MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
        PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, paymentsBankParam);
        paymentInstrument.setGaPaymentMethod(p.a(SDKConstants.AI_KEY_PPBL, str, true) ? SDKConstants.GA_KEY_PPB : SDKConstants.GA_KEY_POSTPAID);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
        k.a((Object) instance2, "DirectPaymentBL.getInstance()");
        if (instance2.isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context, str2, paymentInstrument);
        transactionProcessor.setPaymentIntent(PromoHelper.Companion.getInstance().getPaymentIntent());
        transactionProcessor.startTransaction(view);
    }

    private final void makeUpiCollectRequest(Context context, String str, View view) {
        HashMap<String, String> upiCollectParam = PayUtility.getUpiCollectParam(str);
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
        PaymentInstrument paymentInstrument = new PaymentInstrument(mid2, merchantInstance4.getOrderId(), addAuthDefaultParams, upiCollectParam);
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI_COllECT);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_DEFAULT);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context, BaseViewModel.PaymentType.UPI_COLLECT, paymentInstrument);
        transactionProcessor.setPaymentIntent(PromoHelper.Companion.getInstance().getPaymentIntent());
        transactionProcessor.startTransaction(view);
    }

    private final void makeNetBankingRequest(Context context, View view) {
        String str;
        PromoPayOptionAdapterParam selectedPaymentInstrument = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
        Object obj = null;
        BaseDataModel data = selectedPaymentInstrument != null ? selectedPaymentInstrument.getData() : null;
        if (!(data instanceof PayChannelOptions)) {
            data = null;
        }
        PayChannelOptions payChannelOptions = (PayChannelOptions) data;
        if (payChannelOptions != null) {
            str = payChannelOptions.getChannelCode();
            k.a((Object) str, "it.channelCode");
        } else {
            str = "";
        }
        PromoPayOptionAdapterParam selectedPaymentInstrument2 = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
        Object data2 = selectedPaymentInstrument2 != null ? selectedPaymentInstrument2.getData() : null;
        if (data2 instanceof net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions) {
            obj = data2;
        }
        net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions payChannelOptions2 = (net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions) obj;
        if (payChannelOptions2 != null) {
            str = payChannelOptions2.getChannelCode();
            k.a((Object) str, "it.channelCode");
        }
        HashMap<String, String> nBTranscationParam = PayUtility.getNBTranscationParam("NET_BANKING", str);
        PaytmAssistParams paytmAssistParams = new PaytmAssistParams();
        if (!TextUtils.isEmpty(str)) {
            paytmAssistParams.setBankCode(str);
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
        paymentInstrument.setPayType("NB");
        paymentInstrument.setBankCode(str);
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_NETBANKING);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_NEW);
        paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_REDIRECTION);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_REDIRECTION);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context, "Net banking", paymentInstrument);
        transactionProcessor.setAssistParams(paytmAssistParams);
        transactionProcessor.setPaymentIntent(PromoHelper.Companion.getInstance().getPaymentIntent());
        transactionProcessor.startTransaction(view);
    }

    public final void makeUpiPushPayment(Context context, String str, String str2, String str3, View view) {
        PaymentInstrument paymentInstrument;
        k.c(str, "mPin");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "deviceId");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isNativeJsonRequestSupported()) {
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance.getMid();
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            paymentInstrument = new PaymentInstrument(mid, merchantInstance2.getOrderId(), (String) null, PayUtility.getUpiPushRequestParam(str, str2, str3, this.vpaDetailSelectedItem));
        } else {
            MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
            String mid2 = merchantInstance3.getMid();
            MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
            String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(context, NativeSdkGtmLoader.getProcessTranscationUrl(mid2, merchantInstance4.getOrderId()));
            MerchantBL merchantInstance5 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance5, "MerchantBL.getMerchantInstance()");
            String mid3 = merchantInstance5.getMid();
            MerchantBL merchantInstance6 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance6, "MerchantBL.getMerchantInstance()");
            paymentInstrument = new PaymentInstrument(mid3, merchantInstance6.getOrderId(), addAuthDefaultParams, PayUtility.getUpiPushRequestParamWebRedirection(str, str2, str3, this.vpaDetailSelectedItem));
        }
        paymentInstrument.setRequestBody(new f().b(PayUtility.getUpiPushRequestParam(str, str2, str3, this.vpaDetailSelectedItem)));
        paymentInstrument.setGaPaymentMethod(SDKConstants.GA_KEY_UPI);
        paymentInstrument.setGaPaymentMode(SDKConstants.GA_KEY_SAVED_CARDS);
        DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
        k.a((Object) instance2, "DirectPaymentBL.getInstance()");
        if (instance2.isNativeJsonRequestSupported()) {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS);
        } else {
            paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE);
        }
        TransactionProcessor transactionProcessor = new TransactionProcessor(context, "upi_push", paymentInstrument);
        transactionProcessor.setPaymentIntent(PromoHelper.Companion.getInstance().getPaymentIntent());
        transactionProcessor.startTransaction(view);
    }
}
