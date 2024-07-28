package net.one97.paytm.nativesdk.instruments.giftVoucher;

import android.app.Application;
import android.view.View;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.Requester.TransactionProcessor;
import net.one97.paytm.nativesdk.common.model.PayChannelOptions;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.viewmodel.BaseNativeViewModel;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;

public final class GiftVoucherViewModel extends BaseNativeViewModel {
    private final Application context;
    private final PaymentModes paymentModes;
    private final TransactionProcessor transactionProcessor;

    public final void onInstrumentSelected() {
    }

    public GiftVoucherViewModel(PaymentModes paymentModes2, TransactionProcessor transactionProcessor2, Application application) {
        k.c(paymentModes2, "paymentModes");
        k.c(transactionProcessor2, "transactionProcessor");
        k.c(application, "context");
        this.paymentModes = paymentModes2;
        this.transactionProcessor = transactionProcessor2;
        this.context = application;
    }

    public final Application getContext() {
        return this.context;
    }

    public final PaymentModes getPaymentModes() {
        return this.paymentModes;
    }

    public final TransactionProcessor getTransactionProcessor() {
        return this.transactionProcessor;
    }

    public final void goForTransaction(View view) {
        k.c(view, "proceedButton");
        String paymentMode = this.paymentModes.getPaymentMode();
        ArrayList<PayChannelOptions> payChannelOptions = this.paymentModes.getPayChannelOptions();
        k.a((Object) payChannelOptions, "paymentModes.payChannelOptions");
        PayChannelOptions payChannelOptions2 = (PayChannelOptions) kotlin.a.k.e(payChannelOptions);
        HashMap<String, String> giftVoucherParam = PayUtility.getGiftVoucherParam(paymentMode, payChannelOptions2 != null ? payChannelOptions2.getTemplateId() : null);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String addAuthDefaultParams = SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(mid, merchantInstance2.getOrderId()));
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
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PAY_BUTTON_CLICKED, SDKConstants.AI_KEY_GV));
        }
        this.transactionProcessor.setPaymentInstruments(paymentInstrument);
        if (SDKUtility.isHybridCase() && this.paymentModes.getHybridPaymentOffer() != null) {
            this.transactionProcessor.setOfferBody(new f().b(this.paymentModes.getHybridPaymentOffer()));
        } else if (!SDKUtility.isHybridCase() && this.paymentModes.getPaymentOffer() != null) {
            this.transactionProcessor.setOfferBody(new f().b(this.paymentModes.getPaymentOffer()));
        }
        DirectPaymentBL.getInstance().setPromoCodeBankOfferAI("");
        this.transactionProcessor.startTransaction(view);
    }
}
