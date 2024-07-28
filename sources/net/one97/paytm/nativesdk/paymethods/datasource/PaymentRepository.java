package net.one97.paytm.nativesdk.paymethods.datasource;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Event;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.ProcessTransactionRequest;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.CreateOrderModel;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.BankFormItem;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.Body;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;
import net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse;
import net.one97.paytm.nativesdk.transactionsummary.request.TxnSummaryRequestHelper;
import net.one97.paytm.nativesdk.transcation.model.OtpApiResponse;
import net.one97.paytm.nativesdk.walletOtp.WalletOtpRequestHelper;
import net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentRepository implements PaymentMethodDataSource {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static PaymentRepository INSTANCE;
    private final Context context;

    private PaymentRepository(Context context2) {
        this.context = context2;
    }

    public /* synthetic */ PaymentRepository(Context context2, g gVar) {
        this(context2);
    }

    public final Context getContext() {
        return this.context;
    }

    public final void sendWalletOtpRequest(String str, PaymentMethodDataSource.Callback<WalletOtpResponse> callback) {
        k.c(callback, H5Event.TYPE_CALL_BACK);
        new HashMap().put(SDKConstants.MOBILE_NUMBER, "");
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String postSendOtp = NativeSdkGtmLoader.postSendOtp(mid, merchantInstance2.getOrderId());
        k.a((Object) postSendOtp, "NativeSdkGtmLoader.postS…rchantInstance().orderId)");
        WalletOtpRequestHelper instance = WalletOtpRequestHelper.Companion.getInstance();
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, postSendOtp, (Map<String, String>) null, (Map<String, String>) null, instance.createSenOtpRequest(merchantInstance3.getSsoMobileNumber()), new PaymentRepository$sendWalletOtpRequest$request$1(callback), new PaymentRepository$sendWalletOtpRequest$request$2(callback), WalletOtpResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        executeRequest(volleyPostRequest);
    }

    public final void validateWalletOtpRequest(String str, PaymentMethodDataSource.Callback<WalletOtpResponse> callback) {
        k.c(callback, H5Event.TYPE_CALL_BACK);
        if (str != null) {
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String mid = merchantInstance.getMid();
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.postValidateOtp(mid, merchantInstance2.getOrderId()), (Map<String, String>) null, (Map<String, String>) null, WalletOtpRequestHelper.Companion.getInstance().validateOtpRequest(str), new PaymentRepository$validateWalletOtpRequest$$inlined$let$lambda$1(this, str, callback), new PaymentRepository$validateWalletOtpRequest$$inlined$let$lambda$2(this, str, callback), WalletOtpResponse.class);
            volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
            executeRequest(volleyPostRequest);
            x xVar = x.f47997a;
            callback.onErrorResponse((VolleyError) null, null);
        }
    }

    public final void checkSubsPaymentStatus(PaymentMethodDataSource.Callback<TxnSummaryResponse> callback) {
        k.c(callback, H5Event.TYPE_CALL_BACK);
        new HashMap();
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, NativeSdkGtmLoader.postCheckStatus(merchantInstance.getMid()), (Map<String, String>) null, (Map<String, String>) null, TxnSummaryRequestHelper.Companion.getInstance().createCheckStatusRequest(), new PaymentRepository$checkSubsPaymentStatus$request$1(callback), new PaymentRepository$checkSubsPaymentStatus$request$2(callback), TxnSummaryResponse.class);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(2500, 2, 1.0f));
        executeRequest(volleyPostRequest);
    }

    public final void postDataOnCallBack(ProcessTransactionInfo processTransactionInfo, PaymentMethodDataSource.Callback<Object> callback) {
        k.c(processTransactionInfo, SDKConstants.EXTRA_PROCESSTRANSACTION_INFO);
        k.c(callback, H5Event.TYPE_CALL_BACK);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        HashMap hashMap2 = new HashMap();
        Body body = processTransactionInfo.getBody();
        String str = null;
        Object txnInfo = body != null ? body.getTxnInfo() : null;
        if (txnInfo != null) {
            hashMap2.putAll((Map) txnInfo);
            Body body2 = processTransactionInfo.getBody();
            String callBackUrl = body2 != null ? body2.getCallBackUrl() : null;
            if (callBackUrl == null) {
                Body body3 = processTransactionInfo.getBody();
                if (body3 != null) {
                    str = body3.getCallbackUrl();
                }
                callBackUrl = str;
            }
            executeRequest(new VolleyPostRequest(1, callBackUrl, hashMap, hashMap2, (String) null, new PaymentRepository$postDataOnCallBack$request$1(callback), new PaymentRepository$postDataOnCallBack$request$2(callback)));
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.Map<out kotlin.String, kotlin.String>");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PaymentRepository getInstance(Context context) {
            k.c(context, "context");
            if (PaymentRepository.INSTANCE == null) {
                PaymentRepository.INSTANCE = new PaymentRepository(context, (g) null);
            }
            PaymentRepository access$getINSTANCE$cp = PaymentRepository.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void destroy() {
            PaymentRepository.INSTANCE = null;
        }
    }

    public final void fetchProcessTransactionInfo(String str, PaymentMethodDataSource.Callback<ProcessTransactionInfo> callback) {
        k.c(callback, H5Event.TYPE_CALL_BACK);
        executeRequest(new ProcessTransactionRequest(this.context, str, callback).getRequest());
    }

    private final void executeRequest(Request<?> request) {
        if (SDKUtility.isNetworkAvailable(this.context)) {
            VolleyRequestQueue.getInstance(this.context).addToRequestQueue(request);
        }
    }

    public final void makeOtpSubmitRequest(String str, BankFormItem bankFormItem, PaymentMethodDataSource.Callback<OtpApiResponse> callback) {
        Map map;
        Object obj;
        BankFormItem bankFormItem2 = bankFormItem;
        PaymentMethodDataSource.Callback<OtpApiResponse> callback2 = callback;
        k.c(callback2, H5Event.TYPE_CALL_BACK);
        String actionUrl = bankFormItem2 != null ? bankFormItem.getActionUrl() : null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("otp", str);
            jSONObject.put("txnToken", getValueFromContent(bankFormItem2, "txnToken"));
            jSONObject.put("requestType", getValueFromContent(bankFormItem2, "requestType"));
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        if (bankFormItem2 != null) {
            try {
                obj = bankFormItem.getHeaders();
            } catch (Exception e3) {
                LogUtility.printStackTrace(e3);
                map = null;
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            map = (Map) obj;
            VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, actionUrl, map, (Map<String, String>) null, jSONObject.toString(), new PaymentRepository$makeOtpSubmitRequest$request$1(callback2), new PaymentRepository$makeOtpSubmitRequest$request$2(callback2), OtpApiResponse.class);
            volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            executeRequest(volleyPostRequest);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
    }

    public final void makeOtpCancelRequest(BankFormItem bankFormItem, PaymentMethodDataSource.Callback<OtpApiResponse> callback) {
        Map map;
        Object obj;
        k.c(callback, H5Event.TYPE_CALL_BACK);
        String actionUrl = bankFormItem != null ? bankFormItem.getActionUrl() : null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("txnToken", getValueFromContent(bankFormItem, "txnToken"));
            jSONObject.put("requestType", getValueFromContent(bankFormItem, "requestType"));
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        if (bankFormItem != null) {
            try {
                obj = bankFormItem.getHeaders();
            } catch (Exception e3) {
                LogUtility.printStackTrace(e3);
                map = null;
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            map = (Map) obj;
            VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, actionUrl, map, (Map<String, String>) null, jSONObject.toString(), new PaymentRepository$makeOtpCancelRequest$request$1(callback), new PaymentRepository$makeOtpCancelRequest$request$2(callback), OtpApiResponse.class);
            volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 2, 1.0f));
            executeRequest(volleyPostRequest);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
    }

    public final void makeOtpResendRequest(BankFormItem bankFormItem, PaymentMethodDataSource.Callback<OtpApiResponse> callback) {
        Map map;
        Object obj;
        k.c(callback, H5Event.TYPE_CALL_BACK);
        String actionUrl = bankFormItem != null ? bankFormItem.getActionUrl() : null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("txnToken", getValueFromContent(bankFormItem, "txnToken"));
            jSONObject.put("requestType", getValueFromContent(bankFormItem, "requestType"));
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        if (bankFormItem != null) {
            try {
                obj = bankFormItem.getHeaders();
            } catch (Exception e3) {
                LogUtility.printStackTrace(e3);
                map = null;
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            map = (Map) obj;
            VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, actionUrl, map, (Map<String, String>) null, jSONObject.toString(), new PaymentRepository$makeOtpResendRequest$request$1(callback), new PaymentRepository$makeOtpResendRequest$request$2(callback), OtpApiResponse.class);
            volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
            executeRequest(volleyPostRequest);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
    }

    private final String getValueFromContent(BankFormItem bankFormItem, String str) {
        try {
            Object obj = null;
            if (k.a((Object) str, (Object) "txnToken")) {
                if (bankFormItem != null) {
                    obj = bankFormItem.getContent();
                }
                if (obj != null) {
                    return (String) ((Map) obj).get("txnToken");
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            } else if (k.a((Object) str, (Object) SDKConstants.mbid)) {
                if (bankFormItem != null) {
                    obj = bankFormItem.getContent();
                }
                if (obj != null) {
                    return (String) ((Map) obj).get(SDKConstants.mbid);
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            } else if (k.a((Object) str, (Object) SDKConstants.orderId)) {
                if (bankFormItem != null) {
                    obj = bankFormItem.getContent();
                }
                if (obj != null) {
                    return (String) ((Map) obj).get(SDKConstants.orderId);
                }
                throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            } else {
                if (k.a((Object) str, (Object) SDKConstants.requestType)) {
                    if (bankFormItem != null) {
                        obj = bankFormItem.getContent();
                    }
                    if (obj != null) {
                        return (String) ((Map) obj).get(SDKConstants.requestType);
                    }
                    throw new u("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
                }
                return "";
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a3, code lost:
        if (r0.getOrderId() == null) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void validateVPA(java.lang.String r13, net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource.Callback<net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse> r14) {
        /*
            r12 = this;
            java.lang.String r0 = "DirectPaymentBL.getInstance()"
            java.lang.String r1 = "MerchantBL.getMerchantInstance()"
            java.lang.String r2 = "callback"
            kotlin.g.b.k.c(r14, r2)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            net.one97.paytm.nativesdk.DirectPaymentBL r4 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()     // Catch:{ JSONException -> 0x0066 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0066 }
            boolean r4 = r4.isToCreateOrderPaytmSdk()     // Catch:{ JSONException -> 0x0066 }
            if (r4 != 0) goto L_0x003d
            net.one97.paytm.nativesdk.MerchantBL r4 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()     // Catch:{ JSONException -> 0x0066 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r4 = r4.getOrderId()     // Catch:{ JSONException -> 0x0066 }
            if (r4 != 0) goto L_0x0033
            goto L_0x003d
        L_0x0033:
            org.json.JSONObject r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getNecessaryHeadersParams()     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r5 = "SDKUtility.getNecessaryHeadersParams()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ JSONException -> 0x0066 }
            goto L_0x0056
        L_0x003d:
            org.json.JSONObject r4 = net.one97.paytm.nativesdk.Utils.SDKUtility.getNecessaryHeadersParamsWithSSO()     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r5 = "SDKUtility.getNecessaryHeadersParamsWithSSO()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r5 = "mid"
            net.one97.paytm.nativesdk.MerchantBL r6 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()     // Catch:{ JSONException -> 0x0066 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r6 = r6.getMid()     // Catch:{ JSONException -> 0x0066 }
            r3.put(r5, r6)     // Catch:{ JSONException -> 0x0066 }
        L_0x0056:
            java.lang.String r5 = "vpa"
            r3.put(r5, r13)     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r13 = net.one97.paytm.nativesdk.Constants.SDKConstants.HEAD     // Catch:{ JSONException -> 0x0066 }
            r2.put(r13, r4)     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r13 = net.one97.paytm.nativesdk.Constants.SDKConstants.BODY     // Catch:{ JSONException -> 0x0066 }
            r2.put(r13, r3)     // Catch:{ JSONException -> 0x0066 }
            goto L_0x006c
        L_0x0066:
            r13 = move-exception
            java.lang.Exception r13 = (java.lang.Exception) r13
            net.one97.paytm.nativesdk.Utils.LogUtility.printStackTrace(r13)
        L_0x006c:
            net.one97.paytm.nativesdk.MerchantBL r13 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            java.lang.String r13 = r13.getMid()
            net.one97.paytm.nativesdk.MerchantBL r3 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            java.lang.String r3 = r3.getOrderId()
            java.lang.String r13 = net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader.getValidateVPAUrl(r13, r3)
            java.lang.String r3 = "NativeSdkGtmLoader.getVa…rchantInstance().orderId)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)
            net.one97.paytm.nativesdk.DirectPaymentBL r3 = net.one97.paytm.nativesdk.DirectPaymentBL.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            boolean r0 = r3.isToCreateOrderPaytmSdk()
            if (r0 != 0) goto L_0x00a5
            net.one97.paytm.nativesdk.MerchantBL r0 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getOrderId()
            if (r0 != 0) goto L_0x00b9
        L_0x00a5:
            net.one97.paytm.nativesdk.MerchantBL r13 = net.one97.paytm.nativesdk.MerchantBL.getMerchantInstance()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            java.lang.String r13 = r13.getMid()
            java.lang.String r13 = net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader.getValidateVPAUrl(r13)
            java.lang.String r0 = "NativeSdkGtmLoader.getVa…etMerchantInstance().mid)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
        L_0x00b9:
            android.content.Context r0 = r12.context
            java.lang.String r5 = net.one97.paytm.nativesdk.Utils.SDKUtility.addAuthDefaultParams(r0, r13)
            java.lang.String r13 = "SDKUtility.addAuthDefaultParams(context,url)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)
            net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest r13 = new net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest
            r4 = 1
            r6 = 0
            r7 = 0
            java.lang.String r8 = r2.toString()
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository$validateVPA$request$1 r0 = new net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository$validateVPA$request$1
            r0.<init>(r14)
            r9 = r0
            com.android.volley.Response$Listener r9 = (com.android.volley.Response.Listener) r9
            net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository$validateVPA$request$2 r0 = new net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository$validateVPA$request$2
            r0.<init>(r14)
            r10 = r0
            com.android.volley.Response$ErrorListener r10 = (com.android.volley.Response.ErrorListener) r10
            java.lang.Class<net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse> r11 = net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse.class
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            com.android.volley.DefaultRetryPolicy r14 = new com.android.volley.DefaultRetryPolicy
            r0 = 30000(0x7530, float:4.2039E-41)
            r1 = 2
            r2 = 1065353216(0x3f800000, float:1.0)
            r14.<init>(r0, r1, r2)
            com.android.volley.RetryPolicy r14 = (com.android.volley.RetryPolicy) r14
            r13.setRetryPolicy(r14)
            com.android.volley.Request r13 = (com.android.volley.Request) r13
            r12.executeRequest(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.paymethods.datasource.PaymentRepository.validateVPA(java.lang.String, net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource$Callback):void");
    }

    public final void makeUpiTransactionStatusRequest(String str, PaymentMethodDataSource.Callback<ProcessTransactionInfo> callback) {
        k.c(callback, H5Event.TYPE_CALL_BACK);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance.getMid();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String upiTransactionStatus = NativeSdkGtmLoader.getUpiTransactionStatus(mid, merchantInstance2.getOrderId(), str);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
            jSONObject2.put("txnToken", merchantInstance3.getToken());
            MerchantBL merchantInstance4 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance4, "MerchantBL.getMerchantInstance()");
            jSONObject3.put("mid", merchantInstance4.getMid());
            MerchantBL merchantInstance5 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance5, "MerchantBL.getMerchantInstance()");
            jSONObject3.put("orderId", merchantInstance5.getOrderId());
            jSONObject3.put("isCallbackUrlRequired", true);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, upiTransactionStatus, hashMap, (Map<String, String>) null, jSONObject.toString(), new PaymentRepository$makeUpiTransactionStatusRequest$request$1(callback), new PaymentRepository$makeUpiTransactionStatusRequest$request$2(callback), ProcessTransactionInfo.class);
        volleyPostRequest.setRequestPriority(Request.Priority.IMMEDIATE);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 0, 1.0f));
        executeRequest(volleyPostRequest);
    }

    public final void createOrder(CreateOrderModel createOrderModel, PaymentMethodDataSource.Callback<CreateOrderResponse> callback) {
        k.c(createOrderModel, "orderCreateOrderModel");
        k.c(callback, H5Event.TYPE_CALL_BACK);
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, createOrderModel.getUrl(), createOrderModel.getHeaders(), (Map<String, String>) null, createOrderModel.getBody().toString(), new PaymentRepository$createOrder$request$1(callback), new PaymentRepository$createOrder$request$2(callback), CreateOrderResponse.class);
        volleyPostRequest.setRequestPriority(Request.Priority.IMMEDIATE);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 2, 1.0f));
        executeRequest(volleyPostRequest);
    }

    public final void makeTransactionRequest(PaymentMethodDataSource.Callback<ProcessTransactionInfo> callback) {
        k.c(callback, H5Event.TYPE_CALL_BACK);
        String transactionStatus = NativeSdkGtmLoader.getTransactionStatus();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            jSONObject2.put("txnToken", merchantInstance.getToken());
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            jSONObject3.put("mid", merchantInstance2.getMid());
            MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
            jSONObject3.put("orderId", merchantInstance3.getOrderId());
            jSONObject3.put("isCallbackUrlRequired", true);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (Exception unused) {
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, transactionStatus, hashMap, (Map<String, String>) null, jSONObject.toString(), new PaymentRepository$makeTransactionRequest$request$1(callback), new PaymentRepository$makeTransactionRequest$request$2(callback), ProcessTransactionInfo.class);
        volleyPostRequest.setRequestPriority(Request.Priority.IMMEDIATE);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0f));
        executeRequest(volleyPostRequest);
    }
}
