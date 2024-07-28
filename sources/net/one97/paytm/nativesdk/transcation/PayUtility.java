package net.one97.paytm.nativesdk.transcation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.google.gson.f;
import java.util.HashMap;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.bank_mandate.dataModel.BankMandatePTCModel;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.model.BaseVpaDetail;
import net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaDetail;
import net.one97.paytm.nativesdk.transactionsummary.TxnSummaryActivity;

public class PayUtility {
    public static final String ACCOUNT_NUMBER = "account_number";
    public static final String AUTH_MODE = "authMode";
    public static final String BANK_NAME = "bank_name";
    public static final String CARD_INFO = "cardInfo";
    public static final String CHANNEL_CODE = "channelCode";
    public static final String CHANNEL_ID = "channelId";
    public static final String CREDIT_BLOCK = "credit_block";
    public static final String DEVICE_ID = "device_id";
    public static final String EMI_TYPE = "EMI_TYPE";
    public static final String EMI_TYPE_NATIVE_PLUS = "emiType";
    public static final String INDUSTRY_TYPE_ID = "INDUSTRY_TYPE_ID";
    public static final String MID = "mid";
    public static final String MPIN = "mpin";
    public static final String ORDER_ID = "orderId";
    public static final String PAYER_ACCOUNT = "payerAccount";
    public static final String PAYMENT_FLOW = "paymentFlow";
    public static final String PAYMENT_MODE = "paymentMode";
    public static final String PLAN_ID = "planId";
    public static final String PROMO_CODE = "promo_code";
    public static final String REQUEST_TYPE = "REQUEST_TYPE";
    public static final String SEQ_NUMBER = "seq_number";
    public static final String STORE_INSTRUMENT = "storeInstrument";
    public static final String TEMPLATE_ID = "templateId";
    public static final String TXN_TOKEN = "txnToken";
    public static final String UPI_ACC_REF_IF = "upiAccRefId";
    public static final String WALLET_TYPE = "walletType";
    public static final String WEBSITE = "website";
    public static final String save_this_Card = "saveThisCard";

    public static HashMap<String, String> getGiftVoucherParam(String str, String str2) {
    }

    public static void startPayActivity(Context context) {
    }

    public static HashMap<String, String> getCardsTranscationParam(String str, String str2, String str3, String str4, String str5) {
        return getCardsTranscationParam((String) null, str, str2, str3, str4, str5);
    }

    public static HashMap<String, String> getCardsTranscationParam(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        if (str2 != null) {
            hashMap.put(AUTH_MODE, str2);
        }
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", str3);
        hashMap.put(CARD_INFO, str4);
        hashMap.put(STORE_INSTRUMENT, str5);
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put(PLAN_ID, str6);
        }
        addPaymentFlowToBundle(hashMap, str);
        if (MerchantBL.getMerchantInstance().isAoaEnabled()) {
            hashMap.put("REQUEST_TYPE", SDKConstants.AOA_REQUEST_TYPE);
        }
        if (SDKUtility.isAppInvokeFlow() && !TextUtils.isEmpty(DirectPaymentBL.getInstance().getPromoCodeBankOfferAI())) {
            hashMap.put(PROMO_CODE, DirectPaymentBL.getInstance().getPromoCodeBankOfferAI());
        }
        return hashMap;
    }

    public static HashMap<String, String> getNBTranscationParam(String str, String str2) {
        return getNBTranscationParam(str, str2, (String) null);
    }

    public static HashMap<String, String> getNBTranscationParam(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", str);
        hashMap.put("channelCode", str2);
        addPaymentFlowToBundle(hashMap, str3);
        if (MerchantBL.getMerchantInstance().isAoaEnabled()) {
            hashMap.put("REQUEST_TYPE", SDKConstants.AOA_REQUEST_TYPE);
        }
        if (SDKUtility.isAppInvokeFlow() && !TextUtils.isEmpty(DirectPaymentBL.getInstance().getPromoCodeBankOfferAI())) {
            hashMap.put(PROMO_CODE, DirectPaymentBL.getInstance().getPromoCodeBankOfferAI());
        }
        return hashMap;
    }

    public static HashMap<String, String> getCashOnDeliveryParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", "COD");
        hashMap.put("channelCode", BaseViewModel.PaymentType.COD);
        addPaymentFlowToBundle(hashMap, (String) null);
        if (MerchantBL.getMerchantInstance().isAoaEnabled()) {
            hashMap.put("REQUEST_TYPE", SDKConstants.AOA_REQUEST_TYPE);
        }
        return hashMap;
    }

    public static HashMap<String, String> getUpiCollectParam(String str) {
        return getUpiCollectParam(str, (String) null);
    }

    public static HashMap<String, String> getUpiCollectParam(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", "UPI");
        hashMap.put("channelCode", SDKConstants.PUSH_FROM_COLLECT);
        hashMap.put(PAYER_ACCOUNT, str);
        addPaymentFlowToBundle(hashMap, str2);
        if (MerchantBL.getMerchantInstance().isAoaEnabled()) {
            hashMap.put("REQUEST_TYPE", SDKConstants.AOA_REQUEST_TYPE);
        }
        if (SDKUtility.isAppInvokeFlow() && !TextUtils.isEmpty(DirectPaymentBL.getInstance().getPromoCodeBankOfferAI())) {
            hashMap.put(PROMO_CODE, DirectPaymentBL.getInstance().getPromoCodeBankOfferAI());
        }
        return hashMap;
    }

    public static HashMap<String, String> getUpiCollectWithAppParam(String str, String str2) {
        return getUpiCollectWithAppParam(str, str2, (String) null);
    }

    public static HashMap<String, String> getUpiCollectWithAppParam(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put(SDKConstants.KEY_MERCHANT_ID, MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", "UPI");
        hashMap.put(SDKConstants.KEY_TRANS_ID, str);
        hashMap.put(SDKConstants.KEY_CASHIER_REQUEST_ID, str2);
        if (str3 != null) {
            hashMap.put(PAYMENT_FLOW, str3);
        }
        return hashMap;
    }

    public static HashMap<String, String> getUpiPushParam(BaseVpaDetail baseVpaDetail) {
        return getUpiPushParam(baseVpaDetail, (String) null);
    }

    public static HashMap<String, String> getUpiPushParam(BaseVpaDetail baseVpaDetail, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", "UPI");
        hashMap.put("channelCode", SDKConstants.PUSH_FROM_PUSH);
        if (baseVpaDetail instanceof VpaBankAccountDetail) {
            VpaBankAccountDetail vpaBankAccountDetail = (VpaBankAccountDetail) baseVpaDetail;
            hashMap.put(PAYER_ACCOUNT, vpaBankAccountDetail.getVpaDetail() != null ? vpaBankAccountDetail.getVpaDetail().getName() : "");
            hashMap.put("ifsc", vpaBankAccountDetail.getIfsc());
            hashMap.put(UPI_ACC_REF_IF, vpaBankAccountDetail.getAccRefId());
            hashMap.put(BANK_NAME, vpaBankAccountDetail.getBank());
            hashMap.put(CREDIT_BLOCK, new f().b(vpaBankAccountDetail));
        } else if (baseVpaDetail instanceof VpaDetail) {
            VpaDetail vpaDetail = (VpaDetail) baseVpaDetail;
            hashMap.put(PAYER_ACCOUNT, vpaDetail.getName());
            hashMap.put("ifsc", vpaDetail.getDefaultDebit().getIfsc());
            hashMap.put(ACCOUNT_NUMBER, vpaDetail.getDefaultDebit().getAccount());
            hashMap.put(BANK_NAME, vpaDetail.getDefaultDebit().getBank());
            hashMap.put(CREDIT_BLOCK, new f().b(vpaDetail));
        }
        if (SDKUtility.isAppInvokeFlow() && !TextUtils.isEmpty(DirectPaymentBL.getInstance().getPromoCodeBankOfferAI())) {
            hashMap.put(PROMO_CODE, DirectPaymentBL.getInstance().getPromoCodeBankOfferAI());
        }
        addPaymentFlowToBundle(hashMap, str);
        return hashMap;
    }

    public static HashMap<String, String> getPaymentsBankParam(String str, String str2) {
        return getPaymentsBankParam(str, str2, (String) null);
    }

    public static HashMap<String, String> getPaymentsBankParam(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", str);
        hashMap.put(MPIN, str2);
        if (SDKUtility.isAppInvokeFlow() && !TextUtils.isEmpty(DirectPaymentBL.getInstance().getPromoCodeBankOfferAI())) {
            hashMap.put(PROMO_CODE, DirectPaymentBL.getInstance().getPromoCodeBankOfferAI());
        }
        addPaymentFlowToBundle(hashMap, str3);
        return hashMap;
    }

    public static HashMap<String, String> getUPITransactionRequest(String str, String str2, String str3, String str4, BaseVpaDetail baseVpaDetail) {
        if (DirectPaymentBL.getInstance().isNativeJsonRequestSupported()) {
            return getUpiPushRequestParam(str, str2, str3, str4, baseVpaDetail);
        }
        return getUpiPushRequestParamWebRedirection(str, str2, str3, baseVpaDetail, str4);
    }

    public static HashMap<String, String> getDigitalCreditParam(String str, String str2) {
        return getDigitalCreditParam(str, str2, (String) null);
    }

    public static HashMap<String, String> getDigitalCreditParam(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", str);
        hashMap.put(MPIN, str2);
        addPaymentFlowToBundle(hashMap, (String) null);
        if (MerchantBL.getMerchantInstance().isAoaEnabled()) {
            hashMap.put("REQUEST_TYPE", SDKConstants.AOA_REQUEST_TYPE);
        }
        return hashMap;
    }

    public static HashMap<String, String> getBalanceParam(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("paymentMode", str);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        return hashMap;
    }

    public static HashMap<String, String> getGiftVoucherParam(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("paymentMode", str);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(TEMPLATE_ID, str2);
        }
        addPaymentFlowToBundle(hashMap, str3);
        return hashMap;
    }

    public static HashMap<String, String> getAoaWalletParams(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("paymentMode", str);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("REQUEST_TYPE", SDKConstants.AOA_REQUEST_TYPE);
        hashMap.put("INDUSTRY_TYPE_ID", "retail");
        hashMap.put(WALLET_TYPE, "PAYTMPG");
        hashMap.put(WEBSITE, "retail");
        return hashMap;
    }

    public static void finishSdk(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(SDKConstants.RESPONSE, str);
        if (PaytmSDK.getCallbackListener() == null) {
            return;
        }
        if (!SDKUtility.isPaytmApp(activity)) {
            PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
            killBroadcast(activity);
        } else if (isTxnStatusFlow(activity)) {
            openTxnSummaryActivity(activity);
        } else {
            if (MerchantBL.getMerchantInstance().isAppInvoke()) {
                PaytmSDK.getCallbackListener().onTransactionResponse(bundle);
            } else {
                PaytmSDK.getCallbackListener().onTransactionResponse((Bundle) null);
            }
            killBroadcast(activity);
        }
    }

    protected static void openTxnSummaryActivity(Context context) {
        if (context != null) {
            showTxnSummary(context);
        }
    }

    protected static boolean isTxnStatusFlow(Context context) {
        return DirectPaymentBL.getInstance().isSubsCriptionFlow() && SDKUtility.isPaytmApp(context) && DirectPaymentBL.getInstance().getCjPayMethodResponse() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAppInvokeDevice() != null && DirectPaymentBL.getInstance().getCjPayMethodResponse().getBody().getAppInvokeDevice().equals(SDKConstants.DEEP_LINK_QR);
    }

    public static HashMap<String, String> getUpiPushRequestParam(String str, String str2, String str3, String str4, BaseVpaDetail baseVpaDetail) {
        HashMap<String, String> upiPushParam = getUpiPushParam(baseVpaDetail, str4);
        upiPushParam.put(MPIN, str);
        upiPushParam.put("seqNumber", str2);
        upiPushParam.put("deviceId", str3);
        upiPushParam.put("requestType", "NATIVE");
        if (baseVpaDetail instanceof VpaDetail) {
            upiPushParam.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, upiPushParam.get(ACCOUNT_NUMBER));
            upiPushParam.remove(ACCOUNT_NUMBER);
        }
        upiPushParam.put("bankName", upiPushParam.get(BANK_NAME));
        upiPushParam.remove(BANK_NAME);
        upiPushParam.put("creditBlock", upiPushParam.get(CREDIT_BLOCK));
        upiPushParam.remove(CREDIT_BLOCK);
        upiPushParam.put("requestType", "NATIVE");
        return upiPushParam;
    }

    public static HashMap<String, String> getUpiPushRequestParam(String str, String str2, String str3, BaseVpaDetail baseVpaDetail) {
        return getUpiPushRequestParam(str, str2, str3, (String) null, baseVpaDetail);
    }

    public static HashMap<String, String> getUpiPushRequestParamWebRedirection(String str, String str2, String str3, BaseVpaDetail baseVpaDetail) {
        return getUpiPushRequestParamWebRedirection(str, str2, str3, baseVpaDetail, (String) null);
    }

    public static HashMap<String, String> getUpiPushRequestParamWebRedirection(String str, String str2, String str3, BaseVpaDetail baseVpaDetail, String str4) {
        HashMap<String, String> upiPushParam = getUpiPushParam(baseVpaDetail, str4);
        upiPushParam.put(MPIN, str);
        upiPushParam.put(SEQ_NUMBER, str2);
        upiPushParam.put("device_id", str3);
        return upiPushParam;
    }

    private static void addPaymentFlowToBundle(HashMap<String, String> hashMap, String str) {
        if (str != null) {
            hashMap.put(PAYMENT_FLOW, str);
        } else if (!DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            hashMap.put(PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
            hashMap.put(PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else {
            hashMap.put(PAYMENT_FLOW, DirectPaymentBL.getInstance().getPaymentFlowAvailable());
        }
    }

    public static void killPaytmSDK(Context context) {
        if (PaytmSDK.getCallbackListener() != null) {
            PaytmSDK.getCallbackListener().networkError();
        }
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(context.getApplicationContext()).a(intent);
    }

    public static void showTxnSummary(Context context) {
        context.startActivity(new Intent(context, TxnSummaryActivity.class));
    }

    public static void killBroadcast(Activity activity) {
        Intent intent = new Intent("kill");
        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
        a.a(activity.getApplicationContext()).a(intent);
        if (!MerchantBL.getMerchantInstance().isTransparentAppInvoke()) {
            activity.finish();
        }
    }

    public static HashMap<String, String> getBankMandatePtcParam(String str, BankMandatePTCModel bankMandatePTCModel) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", SDKConstants.TYPE_BANK_MANDATE);
        hashMap.put("REQUEST_TYPE", "NATIVE_SUBSCRIPTION");
        hashMap.put("appCallbackUrl", "1");
        hashMap.put("mandateAuthMode", bankMandatePTCModel.getMandateAuthMode());
        hashMap.put("bankIfsc", bankMandatePTCModel.getBankIfsc());
        hashMap.put("channelCode", bankMandatePTCModel.getChannelCode());
        hashMap.put(ACCOUNT_NUMBER, bankMandatePTCModel.getAccountNumber());
        hashMap.put("ACCOUNT_TYPE", "ISA");
        hashMap.put("USER_NAME", bankMandatePTCModel.getUserName());
        hashMap.put("ACCOUNT_HOLDER_NAME", bankMandatePTCModel.getAccountHolderName());
        hashMap.put(CJRPGTransactionRequestUtils.SUBSCRIPTION_ID, bankMandatePTCModel.getSubsId());
        hashMap.put("saveForFuture", "1");
        hashMap.put(STORE_INSTRUMENT, "1");
        if (!DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            hashMap.put(PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
            hashMap.put(PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else {
            hashMap.put(PAYMENT_FLOW, DirectPaymentBL.getInstance().getPaymentFlowAvailable());
        }
        return hashMap;
    }

    public static HashMap<String, String> getSavedMandatePtcParam(String str, BankMandatePTCModel bankMandatePTCModel) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mid", MerchantBL.getMerchantInstance().getMid());
        hashMap.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
        hashMap.put("channelId", SDKConstants.WAP);
        hashMap.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        hashMap.put("paymentMode", SDKConstants.TYPE_BANK_MANDATE);
        hashMap.put("REQUEST_TYPE", "NATIVE_SUBSCRIPTION");
        hashMap.put("appCallbackUrl", "1");
        hashMap.put("mandateAuthMode", bankMandatePTCModel.getMandateAuthMode());
        hashMap.put("bankIfsc", bankMandatePTCModel.getBankIfsc());
        hashMap.put("channelCode", bankMandatePTCModel.getChannelCode());
        hashMap.put("ACCOUNT_TYPE", "ISA");
        hashMap.put("USER_NAME", bankMandatePTCModel.getUserName());
        hashMap.put("ACCOUNT_HOLDER_NAME", bankMandatePTCModel.getAccountHolderName());
        hashMap.put(CJRPGTransactionRequestUtils.SUBSCRIPTION_ID, bankMandatePTCModel.getSubsId());
        hashMap.put("saveForFuture", "1");
        hashMap.put(UPI_ACC_REF_IF, bankMandatePTCModel.getUpiAccRefId());
        if (!DirectPaymentBL.getInstance().isPaytmWalletChecked()) {
            hashMap.put(PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else if (DirectPaymentBL.getInstance().isWalletAmountSufficientToPay()) {
            hashMap.put(PAYMENT_FLOW, SDKConstants.NATIVE_SDK_NONE);
        } else {
            hashMap.put(PAYMENT_FLOW, DirectPaymentBL.getInstance().getPaymentFlowAvailable());
        }
        return hashMap;
    }

    public static Boolean isTransparentWebivewPaymode(String str) {
        if (!DirectPaymentBL.getInstance().isTransparentWebviewEnabled() || str == null || (!str.equals("wallet") && !str.equals(BaseViewModel.PaymentType.PPB) && !str.equals(BaseViewModel.PaymentType.POSTPAID))) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
