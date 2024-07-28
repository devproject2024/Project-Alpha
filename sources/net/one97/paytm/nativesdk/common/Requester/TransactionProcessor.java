package net.one97.paytm.nativesdk.common.Requester;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.localbroadcastmanager.a.a;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.android.volley.VolleyError;
import com.google.gson.f;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.x;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.HawkEyeEvent;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.CardData;
import net.one97.paytm.nativesdk.Utils.DialogUtility;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtils;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.common.listeners.ActivityInteractor;
import net.one97.paytm.nativesdk.common.listeners.PayFragmentInteractor;
import net.one97.paytm.nativesdk.common.listeners.TransactionProcessorListener;
import net.one97.paytm.nativesdk.common.model.CreateOrderModel;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.common.model.OneClickResponse;
import net.one97.paytm.nativesdk.common.model.PaymentIntent;
import net.one97.paytm.nativesdk.common.mpassevent.MpassEventLogger;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.view.TranscationListener;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository;
import net.one97.paytm.nativesdk.paymethods.model.PaytmAssistParams;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankForm;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.OneClickInfo;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;
import net.one97.paytm.nativesdk.transcation.NativePlusPayActivity;
import net.one97.paytm.nativesdk.transcation.PayActivityNew;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.nativesdk.transcation.PaymentInstrument;
import net.one97.paytm.payments.visascp.VisaSCP;
import net.one97.paytm.payments.visascp.VisaSCPImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class TransactionProcessor {
    private PaytmAssistParams assistParams;
    private CardData cardDetails;
    /* access modifiers changed from: private */
    public Context context;
    private String emiPlanBody;
    /* access modifiers changed from: private */
    public int errorCode = 0;
    private boolean isEnrolled = false;
    private boolean isMandateNativeFlow = false;
    private boolean isVisaSingleClickEnabled;
    private TranscationListener listener;
    private String offerBody;
    /* access modifiers changed from: private */
    public PaymentInstrument paymentInstrument;
    private ArrayList<PaymentIntent> paymentIntent;
    /* access modifiers changed from: private */
    public String paymentType;
    private String riskConvenienveFee;
    private String riskExtendInfo;
    private boolean savedCardTransaction = false;
    private TransactionProcessorListener transactionProcessorListener;
    private long transactionStartTime = -1;

    public boolean isMandateNativeFlow() {
        return this.isMandateNativeFlow;
    }

    public void setMandateNativeFlow(boolean z) {
        this.isMandateNativeFlow = z;
    }

    /* access modifiers changed from: protected */
    public boolean isNativeJsonFlowEnabled() {
        return DirectPaymentBL.getInstance().isNativeJsonRequestSupported();
    }

    public TransactionProcessor(Context context2, String str, PaymentInstrument paymentInstrument2) {
        this.context = context2;
        this.paymentType = str;
        this.paymentInstrument = paymentInstrument2;
    }

    public void setAssistParams(PaytmAssistParams paytmAssistParams) {
        this.assistParams = paytmAssistParams;
    }

    public void setPaymentInstruments(PaymentInstrument paymentInstrument2) {
        this.paymentInstrument = paymentInstrument2;
    }

    public void setTransactionProcessorListener(TransactionProcessorListener transactionProcessorListener2) {
        this.transactionProcessorListener = transactionProcessorListener2;
    }

    public void startTransaction() {
        startTransaction((View) null);
    }

    public void startTransaction(View view) {
        ArrayList<PaymentIntent> arrayList;
        if (isSingleClickFlow()) {
            this.transactionStartTime = System.currentTimeMillis();
            this.paymentInstrument.setTransactionStartTime(this.transactionStartTime);
        }
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            hidePaymentProgressbar(view);
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        Context context2 = this.context;
        if (context2 instanceof ActivityInteractor) {
            ((ActivityInteractor) context2).disableUiInteraction();
        }
        if (!(!SDKUtility.isAppInvokeFlow() || (arrayList = this.paymentIntent) == null || arrayList.get(0) == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.paymentIntent.get(0).getTxnAmount());
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_TRANSACTION_AMOUNT, sb.toString()));
        }
        showPaymentProgressbar(view);
        if (DirectPaymentBL.getInstance().isToCreateOrderPaytmSdk()) {
            if (DirectPaymentBL.getInstance().getRequestClient() != null) {
                createOrderFromVertical(view);
                return;
            } else if (TextUtils.isEmpty(MerchantBL.getMerchantInstance().getOrderId()) || TextUtils.isEmpty(MerchantBL.getMerchantInstance().getToken())) {
                Context context3 = this.context;
                DialogUtility.showDialog(context3, context3.getString(R.string.generic_checkout_error_msg), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Intent intent = new Intent("kill");
                        intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                        a.a(TransactionProcessor.this.context).a(intent);
                        if (DirectPaymentBL.getInstance().getDeferredCheckoutCallbackListener() != null) {
                            DirectPaymentBL.getInstance().getDeferredCheckoutCallbackListener().finishActivity();
                        }
                    }
                });
                SDKUtility.dropBreadCrumbs("TransactionProcessor", MerchantBL.getMerchantInstance().getMid() + " Request client can't be null ");
                return;
            }
        }
        handleProcessTransaction(this.paymentType, view);
    }

    private boolean isSingleClickFlow() {
        return this.isVisaSingleClickEnabled && isNativeJsonFlowEnabled();
    }

    /* access modifiers changed from: private */
    public void handleProcessTransaction(String str, View view) {
        if (isSingleClickFlow()) {
            getVSCEnrollmentData(str, view);
        } else {
            handleProcessTransaction(str, view, (String) null);
        }
    }

    private void handleProcessTransaction(String str, View view, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        if (this.isMandateNativeFlow || !isNativeJsonFlowEnabled()) {
            openNativeFlow(str, view);
        } else {
            makeProcessTransactionRequest(str, getUpdatedRequestBody(this.paymentInstrument.getRequestBody(), str2), view);
        }
    }

    private void openNativeFlow(String str, View view) {
        Intent intent = new Intent(this.context, PayActivityNew.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, this.paymentInstrument);
        intent.putExtra(SDKConstants.KEY_PAYMODE, str);
        Context context2 = this.context;
        if (context2 instanceof Activity) {
            ((Activity) context2).startActivityForResult(intent, InstrumentActivity.PAYACTIVITY_REQUEST_CODE);
        } else {
            context2.startActivity(intent);
        }
        if (!PayUtility.isTransparentWebivewPaymode(str).booleanValue()) {
            enableUiInteraction();
            hidePaymentProgressbar(view);
        }
    }

    private void createOrderFromVertical(final View view) {
        PaytmSDKRequestClient.CallbackData callbackData = new PaytmSDKRequestClient.CallbackData();
        callbackData.setPaymentIntents(getPaymentIntent());
        callbackData.setRcf(SDKUtility.parseDouble(getRiskConvenienveFee()));
        try {
            if (!TextUtils.isEmpty(this.offerBody)) {
                callbackData.setOfferBody(new JSONObject(this.offerBody));
            }
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        try {
            if (!TextUtils.isEmpty(this.emiPlanBody)) {
                callbackData.setEmiOffers(new JSONObject(this.emiPlanBody));
            }
        } catch (JSONException e3) {
            LogUtility.printStackTrace(e3);
        }
        DirectPaymentBL.getInstance().getRequestClient().doCheckout(callbackData, new PaytmSDKRequestClient.OnCheckoutResponse() {
            public void onCheckoutSuccess(PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData) {
                if (checkoutResponseData == null || checkoutResponseData.getCreateOrderResponse() == null || checkoutResponseData.getCreateOrderResponse().getNative_withdraw_details() == null) {
                    Intent intent = new Intent("kill");
                    intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                    a.a(TransactionProcessor.this.context).a(intent);
                    if (TransactionProcessor.this.context instanceof Activity) {
                        ((Activity) TransactionProcessor.this.context).finish();
                    }
                    if (DirectPaymentBL.getInstance().getOrderCreatedListener() != null) {
                        DirectPaymentBL.getInstance().getOrderCreatedListener().onOrderCreationError(new CustomVolleyError("Native is disabled for the given mid."), (CreateOrderModel) null);
                        return;
                    }
                    return;
                }
                CreateOrderResponse createOrderResponse = checkoutResponseData.getCreateOrderResponse();
                MerchantBL.getMerchantInstance().setTxnToken(createOrderResponse.getNative_withdraw_details().getTxnToken());
                if (DirectPaymentBL.getInstance().getOrderCreatedListener() != null) {
                    DirectPaymentBL.getInstance().getOrderCreatedListener().onOrderCreated(createOrderResponse);
                }
                MerchantBL.getMerchantInstance().setMid(checkoutResponseData.getCreateOrderResponse().getMID());
                MerchantBL.getMerchantInstance().setOrderId(checkoutResponseData.getCreateOrderResponse().getORDER_ID());
                TransactionProcessor.this.paymentInstrument.setOrderId(MerchantBL.getMerchantInstance().getOrderId());
                TransactionProcessor.this.paymentInstrument.setmPGUrlToHit(SDKUtility.addAuthDefaultParams(TransactionProcessor.this.context, NativeSdkGtmLoader.getProcessTranscationUrl(MerchantBL.getMerchantInstance().getMid(), MerchantBL.getMerchantInstance().getOrderId())));
                TransactionProcessor.this.updatePGParamsAfterOrderCreation();
                TransactionProcessor transactionProcessor = TransactionProcessor.this;
                transactionProcessor.handleProcessTransaction(transactionProcessor.paymentType, view);
            }

            public void onCheckoutError(PaytmSDKRequestClient.ApiResponseError apiResponseError) {
                TransactionProcessor.this.hidePaymentProgressbar(view);
                TransactionProcessor.this.enableUiInteraction();
                if (TransactionProcessor.this.context instanceof PaytmSDKRequestClient.OnCheckoutResponse) {
                    ((PaytmSDKRequestClient.OnCheckoutResponse) TransactionProcessor.this.context).onCheckoutError(apiResponseError);
                } else {
                    SDKUtility.handleVerticalError(apiResponseError, TransactionProcessor.this.context);
                }
            }
        });
    }

    private void showAlertDialog(String str, final boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = this.context.getString(R.string.something_went_wrong);
        }
        DialogUtility.showDialog(this.context, str, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                if (z) {
                    Intent intent = new Intent("kill");
                    intent.putExtra(SDKConstants.SAVE_ACTIVITY, "none");
                    a.a(TransactionProcessor.this.context).a(intent);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updatePGParamsAfterOrderCreation() {
        if (this.paymentInstrument.getmPGParams() == null) {
            try {
                JSONObject jSONObject = new JSONObject(this.paymentInstrument.getRequestBody());
                jSONObject.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
                jSONObject.put("txnToken", MerchantBL.getMerchantInstance().getToken());
                jSONObject.put("mid", MerchantBL.getMerchantInstance().getMid());
                this.paymentInstrument.setRequestBody(jSONObject.toString());
            } catch (JSONException e2) {
                LogUtility.printStackTrace(e2);
            }
        } else {
            this.paymentInstrument.getmPGParams().put("mid", MerchantBL.getMerchantInstance().getMid());
            this.paymentInstrument.getmPGParams().put("orderId", MerchantBL.getMerchantInstance().getOrderId());
            this.paymentInstrument.getmPGParams().put("txnToken", MerchantBL.getMerchantInstance().getToken());
            if (!TextUtils.isEmpty(this.riskExtendInfo)) {
                this.paymentInstrument.setRiskExtendInfo(this.riskExtendInfo);
                this.paymentInstrument.getmPGParams().put("riskExtendInfo", this.riskExtendInfo);
            }
        }
    }

    private void getVSCEnrollmentData(final String str, final View view) {
        VisaSCP visaSDK = SDKUtils.getVisaSDK(this.context);
        this.paymentInstrument.setSingleClickTransaction(true);
        this.paymentInstrument.setCardDetails(this.cardDetails);
        LogUtility.d("vias", "initializing enrollment");
        visaSDK.getOneClickInfo(this.cardDetails.getFirstSixDigit(), this.cardDetails.getLastFourDigit(), this.cardDetails.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId(), new VisaSCPImpl.GetOneClickInfoListener() {
            public void onRequestStart() {
            }

            public void onRequestEnd(final String str) {
                LogUtility.d("vias", "on success enrollment");
                if (TransactionProcessor.this.context instanceof Activity) {
                    ((Activity) TransactionProcessor.this.context).runOnUiThread(new Runnable() {
                        public void run() {
                            TransactionProcessor.this.onSuccessVisaToken(str, str, view);
                        }
                    });
                } else {
                    TransactionProcessor.this.onSuccessVisaToken(str, str, view);
                }
            }

            public void onRequestError(final String str, String str2, String str3) {
                LogUtility.d("vias", "on error enrollment");
                if (TransactionProcessor.this.context instanceof Activity) {
                    ((Activity) TransactionProcessor.this.context).runOnUiThread(new Runnable() {
                        public void run() {
                            TransactionProcessor.this.onErrorVisaToken(str, str, view);
                        }
                    });
                } else {
                    TransactionProcessor.this.onErrorVisaToken(str, str, view);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void onSuccessVisaToken(String str, String str2, View view) {
        SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_ONECLICK_OBJECT_SUCCESS, this.isEnrolled ? SDKConstants.GA_REPEAT : SDKConstants.GA_ENROLLMENT, this.paymentInstrument.getGaVisaPaymentMode()));
        this.paymentInstrument.setOneClickInfo(str);
        handleProcessTransaction(str2, view, str);
    }

    /* access modifiers changed from: private */
    public void onErrorVisaToken(String str, String str2, View view) {
        SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_ONECLICK_OBJECT_ERROR, this.isEnrolled ? SDKConstants.GA_REPEAT : SDKConstants.GA_ENROLLMENT, str));
        if (!this.savedCardTransaction || !this.isEnrolled) {
            handleProcessTransaction(str2, view, (String) null);
            return;
        }
        String string = GTMLoader.getString(SDKConstants.KEY_SCP_PAYMENT_PROCESSING_ERROR);
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, this.paymentInstrument.getGaPaymentMethod(), !TextUtils.isEmpty(string) ? string : this.context.getString(R.string.one_click_error)));
        hidePaymentProgressbar(view);
        enableUiInteraction();
        Context context2 = this.context;
        if (context2 instanceof ActivityInteractor) {
            ActivityInteractor activityInteractor = (ActivityInteractor) context2;
            if (TextUtils.isEmpty(string)) {
                string = this.context.getString(R.string.one_click_error);
            }
            activityInteractor.onPaymentFailed(string, SDKConstants.VISA_GOOGLE_SAFTEY_NET_ERROR, this);
        }
    }

    public boolean isOnClickFlow() {
        return this.isVisaSingleClickEnabled;
    }

    private void makeProcessTransactionRequest(final String str, String str2, final View view) {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            hidePaymentProgressbar(view);
            Context context2 = this.context;
            if (context2 instanceof ActivityInteractor) {
                ((ActivityInteractor) context2).enableUiInteraction();
            }
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        showPaymentProgressbar(view);
        Context context3 = this.context;
        if (context3 instanceof ActivityInteractor) {
            ((ActivityInteractor) context3).disableUiInteraction();
        }
        PaymentInstrument paymentInstrument2 = this.paymentInstrument;
        if (!(paymentInstrument2 == null || paymentInstrument2.getmPGParams() == null || TextUtils.isEmpty(this.paymentInstrument.getmPGParams().get(PayUtility.PROMO_CODE)))) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_PTC_HIT, this.paymentInstrument.getmPGParams().get(PayUtility.PROMO_CODE)));
        }
        PaymentRepository.Companion.getInstance(this.context.getApplicationContext()).fetchProcessTransactionInfo(str2, new PaymentMethodDataSource.Callback<ProcessTransactionInfo>() {
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onErrorResponse(com.android.volley.VolleyError r2, net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo r3) {
                /*
                    r1 = this;
                    if (r3 == 0) goto L_0x003c
                    net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r0 = r3.getBody()     // Catch:{ NumberFormatException -> 0x003a }
                    if (r0 == 0) goto L_0x003c
                    net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r0 = r3.getBody()     // Catch:{ NumberFormatException -> 0x003a }
                    net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r0 = r0.getResultInfo()     // Catch:{ NumberFormatException -> 0x003a }
                    if (r0 == 0) goto L_0x003c
                    net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r0 = r3.getBody()     // Catch:{ NumberFormatException -> 0x003a }
                    net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r0 = r0.getResultInfo()     // Catch:{ NumberFormatException -> 0x003a }
                    java.lang.String r0 = r0.getResultCode()     // Catch:{ NumberFormatException -> 0x003a }
                    boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ NumberFormatException -> 0x003a }
                    if (r0 != 0) goto L_0x003c
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r2 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this     // Catch:{ NumberFormatException -> 0x003a }
                    net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r0 = r3.getBody()     // Catch:{ NumberFormatException -> 0x003a }
                    net.one97.paytm.nativesdk.paymethods.model.processtransaction.ResultInfo r0 = r0.getResultInfo()     // Catch:{ NumberFormatException -> 0x003a }
                    java.lang.String r0 = r0.getResultCode()     // Catch:{ NumberFormatException -> 0x003a }
                    int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x003a }
                    int unused = r2.errorCode = r0     // Catch:{ NumberFormatException -> 0x003a }
                    goto L_0x004f
                L_0x003a:
                    r2 = move-exception
                    goto L_0x004c
                L_0x003c:
                    if (r2 == 0) goto L_0x004f
                    com.android.volley.NetworkResponse r0 = r2.networkResponse     // Catch:{ NumberFormatException -> 0x003a }
                    if (r0 == 0) goto L_0x004f
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this     // Catch:{ NumberFormatException -> 0x003a }
                    com.android.volley.NetworkResponse r2 = r2.networkResponse     // Catch:{ NumberFormatException -> 0x003a }
                    int r2 = r2.statusCode     // Catch:{ NumberFormatException -> 0x003a }
                    int unused = r0.errorCode = r2     // Catch:{ NumberFormatException -> 0x003a }
                    goto L_0x004f
                L_0x004c:
                    net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r2)
                L_0x004f:
                    java.lang.String r2 = r3
                    java.lang.String r0 = "upi_push"
                    boolean r2 = r2.equalsIgnoreCase(r0)
                    if (r2 == 0) goto L_0x0061
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r2 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    android.view.View r0 = r5
                    r2.handleUpiPushErrorResponse(r3, r0)
                    return
                L_0x0061:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r2 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    android.view.View r0 = r5
                    r2.handleErrorResponse(r3, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.AnonymousClass7.onErrorResponse(com.android.volley.VolleyError, net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo):void");
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = r3
                    int r1 = r0.hashCode()
                    switch(r1) {
                        case -2116042983: goto L_0x0067;
                        case -795192327: goto L_0x005d;
                        case -709289853: goto L_0x0053;
                        case 98680: goto L_0x0049;
                        case 111202: goto L_0x003f;
                        case 3046160: goto L_0x0035;
                        case 757836652: goto L_0x002a;
                        case 1037979582: goto L_0x0020;
                        case 1463791499: goto L_0x0016;
                        case 2042486477: goto L_0x000b;
                        default: goto L_0x0009;
                    }
                L_0x0009:
                    goto L_0x0071
                L_0x000b:
                    java.lang.String r1 = "upi_intent"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 9
                    goto L_0x0072
                L_0x0016:
                    java.lang.String r1 = "upi_push"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 6
                    goto L_0x0072
                L_0x0020:
                    java.lang.String r1 = "Gift Voucher"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 5
                    goto L_0x0072
                L_0x002a:
                    java.lang.String r1 = "postpaid"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 8
                    goto L_0x0072
                L_0x0035:
                    java.lang.String r1 = "card"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 0
                    goto L_0x0072
                L_0x003f:
                    java.lang.String r1 = "ppb"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 3
                    goto L_0x0072
                L_0x0049:
                    java.lang.String r1 = "cod"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 7
                    goto L_0x0072
                L_0x0053:
                    java.lang.String r1 = "Net banking"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 1
                    goto L_0x0072
                L_0x005d:
                    java.lang.String r1 = "wallet"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 4
                    goto L_0x0072
                L_0x0067:
                    java.lang.String r1 = "upi_collect"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0071
                    r0 = 2
                    goto L_0x0072
                L_0x0071:
                    r0 = -1
                L_0x0072:
                    switch(r0) {
                        case 0: goto L_0x00b4;
                        case 1: goto L_0x00ac;
                        case 2: goto L_0x00a4;
                        case 3: goto L_0x009c;
                        case 4: goto L_0x0096;
                        case 5: goto L_0x0090;
                        case 6: goto L_0x008a;
                        case 7: goto L_0x0084;
                        case 8: goto L_0x007e;
                        case 9: goto L_0x0076;
                        default: goto L_0x0075;
                    }
                L_0x0075:
                    goto L_0x00bb
                L_0x0076:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    android.view.View r1 = r5
                    r0.handleUpiIntentTransaction(r3, r1)
                    goto L_0x00bb
                L_0x007e:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    r0.handlePaymentTransaction(r3)
                    return
                L_0x0084:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    r0.handlePaymentTransaction(r3)
                    return
                L_0x008a:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    r0.handlePaymentTransaction(r3)
                    return
                L_0x0090:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    r0.handlePaymentTransaction(r3)
                    return
                L_0x0096:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    r0.handlePaymentTransaction(r3)
                    return
                L_0x009c:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    android.view.View r1 = r5
                    r0.handleBankTypeTransaction(r3, r1)
                    return
                L_0x00a4:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    android.view.View r1 = r5
                    r0.handleBankTypeTransaction(r3, r1)
                    return
                L_0x00ac:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    android.view.View r1 = r5
                    r0.handleBankTypeTransaction(r3, r1)
                    return
                L_0x00b4:
                    net.one97.paytm.nativesdk.common.Requester.TransactionProcessor r0 = net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.this
                    android.view.View r1 = r5
                    r0.handleBankTypeTransaction(r3, r1)
                L_0x00bb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.AnonymousClass7.onResponse(net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo):void");
            }
        });
    }

    public void makeTransactionStatusRequest(String str, final View view) {
        if (!SDKUtility.isNetworkAvailable(this.context)) {
            hidePaymentProgressbar(view);
            Context context2 = this.context;
            if (context2 instanceof ActivityInteractor) {
                ((ActivityInteractor) context2).enableUiInteraction();
            }
            DialogUtility.showNoInternetDialog(this.context, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        showPaymentProgressbar(view);
        Context context3 = this.context;
        if (context3 instanceof ActivityInteractor) {
            ((ActivityInteractor) context3).disableUiInteraction();
        }
        PaymentRepository.Companion.getInstance(this.context).makeUpiTransactionStatusRequest(str, new PaymentMethodDataSource.Callback<ProcessTransactionInfo>() {
            public void onResponse(ProcessTransactionInfo processTransactionInfo) {
                TransactionProcessor.this.handlePaymentTransaction(processTransactionInfo);
            }

            public void onErrorResponse(VolleyError volleyError, ProcessTransactionInfo processTransactionInfo) {
                TransactionProcessor.this.handleErrorResponse(processTransactionInfo, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleUpiIntentTransaction(ProcessTransactionInfo processTransactionInfo, View view) {
        enableUiInteraction();
        hidePaymentProgressbar(view);
        if (processTransactionInfo == null || processTransactionInfo.getBody() == null || processTransactionInfo.getBody().getDeepLinkInfo() == null) {
            handleErrorResponse(processTransactionInfo, view);
            TransactionProcessorListener transactionProcessorListener2 = this.transactionProcessorListener;
            if (transactionProcessorListener2 != null) {
                transactionProcessorListener2.onIntentFlowComplete();
                return;
            }
            return;
        }
        TransactionProcessorListener transactionProcessorListener3 = this.transactionProcessorListener;
        if (transactionProcessorListener3 != null) {
            transactionProcessorListener3.onProcessTransactionResponse(processTransactionInfo.getBody().getDeepLinkInfo());
        }
    }

    /* access modifiers changed from: private */
    public void handlePaymentTransaction(ProcessTransactionInfo processTransactionInfo) {
        SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_complete", this.paymentInstrument.getGaPaymentMethod(), this.paymentInstrument.getGaPaymentMode(), this.paymentInstrument.getGaFlowType(), "Success"));
        if (processTransactionInfo == null || processTransactionInfo.getBody() == null || processTransactionInfo.getBody().getTxnInfo() == null) {
            finishSdk((Activity) this.context, (String) null, false);
        } else {
            postDataOnCallBack(processTransactionInfo, new f().b(processTransactionInfo.getBody().getTxnInfo()), false);
        }
    }

    private void postDataOnCallBack(ProcessTransactionInfo processTransactionInfo, final String str, final boolean z) {
        if (processTransactionInfo == null || processTransactionInfo.getBody() == null || (TextUtils.isEmpty(processTransactionInfo.getBody().getCallBackUrl()) && TextUtils.isEmpty(processTransactionInfo.getBody().getCallbackUrl()))) {
            finishSdk((Activity) this.context, str, z);
        } else if (MerchantBL.getMerchantInstance().ismWebAppInvoke()) {
            finishSdk((Activity) this.context, str, z);
        } else {
            PaymentRepository.Companion.getInstance(this.context.getApplicationContext()).postDataOnCallBack(processTransactionInfo, new PaymentMethodDataSource.Callback<Object>() {
                public void onErrorResponse(VolleyError volleyError, Object obj) {
                    TransactionProcessor transactionProcessor = TransactionProcessor.this;
                    transactionProcessor.finishSdk((Activity) transactionProcessor.context, str, z);
                }

                public void onResponse(Object obj) {
                    TransactionProcessor transactionProcessor = TransactionProcessor.this;
                    transactionProcessor.finishSdk((Activity) transactionProcessor.context, str, z);
                }
            });
        }
    }

    private void onSubscriptionPostTransaction() {
        PayUtility.showTxnSummary(this.context);
    }

    /* access modifiers changed from: private */
    public void handleBankTypeTransaction(final ProcessTransactionInfo processTransactionInfo, View view) {
        if (isVisaSingleClickFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PTC_SUCCESS, this.isEnrolled ? SDKConstants.GA_REPEAT : SDKConstants.GA_ENROLLMENT, this.paymentInstrument.getGaVisaPaymentMode()));
        }
        if (processTransactionInfo == null || processTransactionInfo.getBody() == null || processTransactionInfo.getBody().getBankForm() == null) {
            setEnrollmentToken(processTransactionInfo);
            handlePaymentTransaction(processTransactionInfo);
            return;
        }
        BankForm bankForm = processTransactionInfo.getBody().getBankForm();
        if (!(bankForm == null || bankForm.getDisplayField() == null || bankForm.getDisplayField().getAmount() == null || !SDKUtility.isAppInvokeFlow())) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_TRANSACTION_AMOUNT, bankForm.getDisplayField().getAmount()));
        }
        if ("direct".equalsIgnoreCase(bankForm.getPageType()) && bankForm.getDirectForms() != null && !bankForm.getDirectForms().isEmpty()) {
            hidePaymentProgressbar(view);
            enableUiInteraction();
            this.paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_DIRECT);
            Intent intent = new Intent(this.context, NativePlusPayActivity.class);
            intent.putExtra(SDKConstants.EXTRA_PROCESSTRANSACTION_INFO, processTransactionInfo);
            intent.putExtra(SDKConstants.KEY_PAYMODE, this.paymentType);
            intent.putExtra(SDKConstants.EXTRA_ASSIST_PARAMS, this.assistParams);
            intent.putExtra(SDKConstants.PAYMENT_INFO, this.paymentInstrument);
            ((Activity) this.context).startActivityForResult(intent, InstrumentActivity.PAYACTIVITY_REQUEST_CODE);
        } else if (processTransactionInfo.getBody().getBankForm().getRedirectForm() != null) {
            TranscationListener transcationListener = this.listener;
            if (transcationListener != null) {
                transcationListener.redirect(new kotlin.g.a.a<x>() {
                    public x invoke() {
                        TransactionProcessor.this.addPayFragment(processTransactionInfo);
                        return null;
                    }
                });
            } else {
                addPayFragment(processTransactionInfo);
            }
        } else {
            handleErrorResponse(processTransactionInfo, view);
        }
    }

    /* access modifiers changed from: private */
    public void addPayFragment(ProcessTransactionInfo processTransactionInfo) {
        if (processTransactionInfo.getBody().getBankForm().getOneClickInfo() != null) {
            setSingleClickToken(processTransactionInfo.getBody().getBankForm().getOneClickInfo());
        }
        Context context2 = this.context;
        if (context2 instanceof PayFragmentInteractor) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(SDKConstants.EXTRA_NEW_FLOW, true);
            bundle.putString(SDKConstants.KEY_PAYMODE, this.paymentType);
            this.paymentInstrument.setGaFlowType(SDKConstants.GA_NATIVE_PLUS_REDIRECTION);
            bundle.putSerializable(SDKConstants.PAYMENT_INFO, this.paymentInstrument);
            bundle.putSerializable(SDKConstants.EXTRA_BANK_FORM_ITEM, processTransactionInfo.getBody().getBankForm().getRedirectForm());
            PaytmAssistParams paytmAssistParams = this.assistParams;
            if (paytmAssistParams != null) {
                bundle.putString("BANK_CODE", paytmAssistParams.getBankCode());
                bundle.putString(SDKConstants.PAY_TYPE, this.assistParams.getPayType());
                bundle.putString("cardType", this.assistParams.getCardType());
            }
            if (!(processTransactionInfo.getBody() == null || processTransactionInfo.getBody().getRiskContent() == null)) {
                bundle.putString(SDKConstants.EVENT_LINK_ID, processTransactionInfo.getBody().getRiskContent().getEventLinkId());
            }
            ((PayFragmentInteractor) this.context).addPayFragment(bundle);
            return;
        }
        Intent intent = new Intent(context2, PayActivityNew.class);
        intent.putExtra(SDKConstants.PAYMENT_INFO, this.paymentInstrument);
        intent.putExtra(SDKConstants.EXTRA_ASSIST_PARAMS, this.assistParams);
        intent.putExtra(SDKConstants.EXTRA_NEW_FLOW, true);
        intent.putExtra(SDKConstants.KEY_PAYMODE, this.paymentType);
        intent.putExtra(SDKConstants.EXTRA_BANK_FORM_ITEM, processTransactionInfo.getBody().getBankForm().getRedirectForm());
        ((Activity) this.context).startActivityForResult(intent, SDKConstants.PAYACTIVITY_REQUEST_CODE);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleUpiPushErrorResponse(net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo r6, android.view.View r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r6.getBody()
            if (r1 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r6.getBody()
            java.lang.Object r1 = r1.getTxnInfo()
            if (r1 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r6.getBody()
            java.lang.Object r1 = r1.getTxnInfo()
            boolean r1 = r1 instanceof java.util.Map
            if (r1 == 0) goto L_0x0032
            net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body r1 = r6.getBody()     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r1 = r1.getTxnInfo()     // Catch:{ Exception -> 0x0032 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0032 }
            java.lang.String r2 = "RESPCODE"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r1 = r0
        L_0x0033:
            if (r1 == 0) goto L_0x005f
            java.lang.String r2 = "202"
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = "372"
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = "196"
            boolean r3 = r1.equalsIgnoreCase(r2)
            if (r3 != 0) goto L_0x0053
            boolean r2 = r1.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x005f
        L_0x0053:
            android.content.Context r0 = r5.context
            boolean r2 = r0 instanceof net.one97.paytm.nativesdk.common.listeners.ActivityInteractor
            if (r2 == 0) goto L_0x00a7
            net.one97.paytm.nativesdk.common.listeners.ActivityInteractor r0 = (net.one97.paytm.nativesdk.common.listeners.ActivityInteractor) r0
            r0.disableSelectedUpiPayOption(r1)
            goto L_0x00a7
        L_0x005f:
            java.lang.String r2 = "232"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = r5.offerBody
            if (r1 == 0) goto L_0x0080
            com.google.gson.f r1 = new com.google.gson.f     // Catch:{ Exception -> 0x007f }
            r1.<init>()     // Catch:{ Exception -> 0x007f }
            java.lang.String r2 = r5.offerBody     // Catch:{ Exception -> 0x007f }
            java.lang.Class<net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$PaymentOffer> r3 = net.one97.paytm.nativesdk.common.model.ApplyPromoResponse.PaymentOffer.class
            java.lang.Object r1 = r1.a((java.lang.String) r2, r3)     // Catch:{ Exception -> 0x007f }
            net.one97.paytm.nativesdk.common.model.ApplyPromoResponse$PaymentOffer r1 = (net.one97.paytm.nativesdk.common.model.ApplyPromoResponse.PaymentOffer) r1     // Catch:{ Exception -> 0x007f }
            java.lang.String r0 = r1.getTotalInstantDiscount()     // Catch:{ Exception -> 0x007f }
            goto L_0x0080
        L_0x007f:
        L_0x0080:
            net.one97.paytm.nativesdk.app.UpiPushCallbackListener r1 = net.one97.paytm.nativesdk.PaytmSDK.getUpiCallBackListener()
            if (r1 == 0) goto L_0x00a7
            net.one97.paytm.nativesdk.app.UpiPushCallbackListener r1 = net.one97.paytm.nativesdk.PaytmSDK.getUpiCallBackListener()
            net.one97.paytm.nativesdk.MerchantBL r2 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            double r3 = net.one97.paytm.nativesdk.Utils.SDKUtility.getEffectAfterOfferAmount(r0)
            java.lang.String r0 = r2.getWithoutDoubleAmount(r3)
            net.one97.paytm.nativesdk.common.model.CustomVolleyError r2 = new net.one97.paytm.nativesdk.common.model.CustomVolleyError
            com.google.gson.f r3 = new com.google.gson.f
            r3.<init>()
            java.lang.String r3 = r3.b(r6)
            r2.<init>(r3)
            r1.onUpiPushTxnFailure(r0, r2)
        L_0x00a7:
            r5.handleErrorResponse(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.handleUpiPushErrorResponse(net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public void handleErrorResponse(ProcessTransactionInfo processTransactionInfo, View view) {
        setEnrollmentToken(processTransactionInfo);
        String str = SDKConstants.GA_REPEAT;
        if (processTransactionInfo == null || processTransactionInfo.getBody() == null || processTransactionInfo.getBody().getResultInfo() == null) {
            hidePaymentProgressbar(view);
            enableUiInteraction();
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, this.paymentInstrument.getGaPaymentMethod(), H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT));
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PTC_ERROR, SDKConstants.API_TIME_OUT));
            }
            if (isVisaSingleClickFlow()) {
                if (!this.isEnrolled) {
                    str = SDKConstants.GA_ENROLLMENT;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PTC_ERROR, str, H5RpcPlugin.RpcRequest.RpcParam.TIMEOUT));
            }
            finishSdk((Activity) this.context, (String) null, true);
        } else if (processTransactionInfo.getBody().getResultInfo().getRetry() == null || !processTransactionInfo.getBody().getResultInfo().getRetry().booleanValue()) {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams("", "pay_complete", this.paymentInstrument.getGaPaymentMethod(), this.paymentInstrument.getGaPaymentMode(), this.paymentInstrument.getGaFlowType(), SDKConstants.GA_NATIVE_FAILED));
            if (isVisaSingleClickFlow()) {
                if (!this.isEnrolled) {
                    str = SDKConstants.GA_ENROLLMENT;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PTC_ERROR, str, SDKConstants.GA_NATIVE_FAILED));
            }
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PTC_ERROR, SDKConstants.GA_NATIVE_FAILED));
            }
            if (processTransactionInfo.getBody().getTxnInfo() == null) {
                hidePaymentProgressbar(view);
                enableUiInteraction();
                finishSdk((Activity) this.context, (String) null, true);
                return;
            }
            postDataOnCallBack(processTransactionInfo, new f().b(processTransactionInfo.getBody().getTxnInfo()), true);
        } else {
            SDKUtility.sendGaEvents(SDKUtility.getGenericEventParams(SDKConstants.NATIVESDK_PAY_CLICKED_ERROR, this.paymentInstrument.getGaPaymentMethod(), processTransactionInfo.getBody().getResultInfo().getResultMsg()));
            if (isVisaSingleClickFlow()) {
                if (!this.isEnrolled) {
                    str = SDKConstants.GA_ENROLLMENT;
                }
                SDKUtility.sendGaEvents(SDKUtility.getVisaEventParams(SDKConstants.GA_VISA_PTC_ERROR, str, processTransactionInfo.getBody().getResultInfo().getResultMsg()));
            }
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PTC_ERROR, processTransactionInfo.getBody().getResultInfo().getResultMsg()));
            }
            hidePaymentProgressbar(view);
            enableUiInteraction();
            Context context2 = this.context;
            if (context2 instanceof ActivityInteractor) {
                ((ActivityInteractor) context2).onPaymentFailed(processTransactionInfo.getBody().getResultInfo().getResultMsg(), processTransactionInfo.getBody().getResultInfo().getResultCode(), this);
            } else {
                finishSdk((Activity) context2, (String) null, true);
            }
        }
    }

    private void setEnrollmentToken(ProcessTransactionInfo processTransactionInfo) {
        if (processTransactionInfo == null || processTransactionInfo.getBody() == null || processTransactionInfo.getBody().getOneClickInfo() == null) {
            LogUtility.d("visa", "single click token not saved");
        } else {
            setSingleClickToken(processTransactionInfo.getBody().getOneClickInfo());
        }
    }

    private void setSingleClickToken(OneClickInfo oneClickInfo) {
        CardData cardDetails2 = this.paymentInstrument.getCardDetails();
        if (cardDetails2 != null) {
            boolean isEnrollmentSuccess = SDKUtils.getVisaSDK(this.context).isEnrollmentSuccess(cardDetails2.getFirstSixDigit(), cardDetails2.getLastFourDigit(), cardDetails2.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId());
            String b2 = new f().b(oneClickInfo);
            LogUtility.d("visa", b2);
            String oneClickToken = SDKUtility.setOneClickToken(this.context, this.cardDetails, b2);
            OneClickResponse oneClickInfoResponse = SDKUtility.getOneClickInfoResponse(isEnrollmentSuccess, SDKUtils.getVisaSDK(this.context).isEnrollmentSuccess(cardDetails2.getFirstSixDigit(), cardDetails2.getLastFourDigit(), cardDetails2.getExpiryDate(), DirectPaymentBL.getInstance().getCustomerId()), true, false);
            if (oneClickInfoResponse != null) {
                SDKUtility.sendEnrollmentGAEvent(oneClickInfoResponse, oneClickToken, this.paymentInstrument);
            }
        }
    }

    /* access modifiers changed from: private */
    public void enableUiInteraction() {
        Context context2 = this.context;
        if (context2 instanceof ActivityInteractor) {
            ((ActivityInteractor) context2).enableUiInteraction();
        }
    }

    private void showPaymentProgressbar(View view) {
        if (view != null) {
            try {
                if (view.findViewById(R.id.ltv_loading) != null || view.findViewById(R.id.ltv_loading1) != null) {
                    DirectPaymentBL.getInstance().setTransactionProcessing(true);
                    view.setBackgroundResource(R.drawable.native_button_onloading);
                    final LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading);
                    if (lottieAnimationView == null) {
                        lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading1);
                    }
                    if (lottieAnimationView != null && (this.context instanceof Activity)) {
                        ((Activity) this.context).runOnUiThread(new Runnable() {
                            public void run() {
                                lottieAnimationView.setVisibility(0);
                                lottieAnimationView.setAnimation("Payments-Loader.json");
                                lottieAnimationView.loop(true);
                                lottieAnimationView.playAnimation();
                            }
                        });
                    }
                    if (view.findViewById(R.id.ivPaysecurely) != null) {
                        view.findViewById(R.id.ivPaysecurely).setVisibility(8);
                    }
                    if (view.findViewById(R.id.paysecurely) != null) {
                        view.findViewById(R.id.paysecurely).setVisibility(4);
                    }
                    if (view.findViewById(R.id.tv_proceed_securely) != null) {
                        view.findViewById(R.id.tv_proceed_securely).setVisibility(4);
                    }
                    if (view.findViewById(R.id.paysecurely2) != null) {
                        view.findViewById(R.id.paysecurely2).setVisibility(4);
                    }
                }
            } catch (Exception e2) {
                LogUtility.printStackTrace(e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void hidePaymentProgressbar(View view) {
        try {
            dismissSheet();
            if (view == null) {
                return;
            }
            if (view.findViewById(R.id.ltv_loading) != null || view.findViewById(R.id.ltv_loading1) != null) {
                DirectPaymentBL.getInstance().setTransactionProcessing(false);
                view.setBackgroundResource(R.drawable.nativesdk_button_click);
                final LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading);
                if (lottieAnimationView == null) {
                    lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.ltv_loading1);
                }
                if (lottieAnimationView != null && (this.context instanceof Activity)) {
                    ((Activity) this.context).runOnUiThread(new Runnable() {
                        public void run() {
                            lottieAnimationView.setAnimation("Payments-Loader.json");
                            lottieAnimationView.loop(true);
                            lottieAnimationView.pauseAnimation();
                            lottieAnimationView.setVisibility(8);
                        }
                    });
                }
                if (view.findViewById(R.id.paysecurely) != null) {
                    view.findViewById(R.id.paysecurely).setVisibility(0);
                }
                if (view.findViewById(R.id.tv_proceed_securely) != null) {
                    view.findViewById(R.id.tv_proceed_securely).setVisibility(0);
                }
                if (view.findViewById(R.id.paysecurely2) == null) {
                    return;
                }
                if (view.findViewById(R.id.paysecurely2) instanceof TextView) {
                    TextView textView = (TextView) view.findViewById(R.id.paysecurely2);
                    if (TextUtils.isEmpty(textView.getText())) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                } else {
                    view.findViewById(R.id.paysecurely2).setVisibility(0);
                }
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public void setOfferBody(String str) {
        this.offerBody = str;
    }

    public String getOfferBody() {
        return this.offerBody;
    }

    public void setRiskExtendInfo(String str) {
        this.riskExtendInfo = str;
    }

    public void setPaymentIntent(ArrayList<PaymentIntent> arrayList) {
        this.paymentIntent = arrayList;
    }

    public ArrayList<PaymentIntent> getPaymentIntent() {
        return this.paymentIntent;
    }

    private String getRiskConvenienveFee() {
        return this.riskConvenienveFee;
    }

    public void setRiskConvenienveFee(String str) {
        this.riskConvenienveFee = str;
    }

    public void setEmiPlanData(String str) {
        this.emiPlanBody = str;
    }

    public boolean isVisaSingleClickEnabled() {
        return this.isVisaSingleClickEnabled;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.paymentInstrument;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isVisaSingleClickFlow() {
        /*
            r1 = this;
            boolean r0 = r1.isVisaSingleClickEnabled
            if (r0 == 0) goto L_0x0010
            net.one97.paytm.nativesdk.transcation.PaymentInstrument r0 = r1.paymentInstrument
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getOneClickInfo()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.common.Requester.TransactionProcessor.isVisaSingleClickFlow():boolean");
    }

    public void setVisaSingleClickEnabled(boolean z) {
        this.isVisaSingleClickEnabled = z;
    }

    public void setSavedCardTransaction(boolean z) {
        this.savedCardTransaction = z;
    }

    public void isEnrolled(boolean z) {
        this.isEnrolled = z;
    }

    public void setCardDetails(CardData cardData) {
        this.cardDetails = cardData;
    }

    public void setTranscationListener(TranscationListener transcationListener) {
        this.listener = transcationListener;
    }

    private void dismissSheet() {
        TranscationListener transcationListener = this.listener;
        if (transcationListener != null) {
            transcationListener.dismissSheet();
        }
    }

    /* access modifiers changed from: private */
    public void finishSdk(Activity activity, String str, boolean z) {
        if (isVisaSingleClickEnabled() && this.paymentInstrument.getOneClickInfo() != null) {
            if (z) {
                HawkEyeEvent.getInstance(PaytmSDK.getAppContext()).logApiEvent(false, SDKConstants.ONLINE_PG_TRANSACTION, this.transactionStartTime, String.valueOf(System.currentTimeMillis() - this.transactionStartTime), this.errorCode, "Failure");
            } else {
                HawkEyeEvent.getInstance(PaytmSDK.getAppContext()).logApiEvent(false, SDKConstants.ONLINE_PG_TRANSACTION, this.transactionStartTime, String.valueOf(System.currentTimeMillis() - this.transactionStartTime), 200, SDKConstants.REPEAT);
            }
        }
        if (DirectPaymentBL.getInstance().isCustSdkUpiPush()) {
            if (z) {
                sendMpassLogsCustomSDK(SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL);
            } else {
                sendMpassLogsCustomSDK("success");
            }
        }
        PayUtility.finishSdk(activity, str);
    }

    private void sendMpassLogsCustomSDK(String str) {
        MpassEventLogger mpassEventLogger = new MpassEventLogger(this.context, MerchantBL.getMerchantInstance().getOrderId(), MerchantBL.getMerchantInstance().getMid());
        mpassEventLogger.setCustSDKVersion(DirectPaymentBL.getInstance().getCustSdkVersion());
        mpassEventLogger.setSdkFlow(SDKConstants.CUI_EVENT_CATEGORY);
        mpassEventLogger.setEventAction("pay_clicked");
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.CUI_KEY_PAYMENT_OPTION_TYPE, "upi_push");
        hashMap.put(SDKConstants.CUI_KEY_PAYMENT_STATUS, str);
        mpassEventLogger.sendLog(hashMap);
    }

    private String getUpdatedRequestBody(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("oneClickInfo", new JSONObject(str2));
            return jSONObject.toString();
        } catch (Exception unused) {
            return str;
        }
    }
}
