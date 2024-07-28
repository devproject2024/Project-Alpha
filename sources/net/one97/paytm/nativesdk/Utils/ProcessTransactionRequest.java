package net.one97.paytm.nativesdk.Utils;

import android.content.Context;
import com.alipay.mobile.h5container.api.H5Event;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.google.gson.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.Gtm.NativeSdkGtmLoader;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyPostRequest;
import net.one97.paytm.nativesdk.NetworkHandler.VolleyRequestQueue;
import net.one97.paytm.nativesdk.instruments.upicollect.models.ExtendInfo;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.paymethods.model.processtransaction.ProcessTransactionInfo;
import org.json.JSONException;
import org.json.JSONObject;

public final class ProcessTransactionRequest {
    private final PaymentMethodDataSource.Callback<ProcessTransactionInfo> callback;
    private final Context context;
    private final String requestBodyJson;

    public ProcessTransactionRequest(Context context2, String str, PaymentMethodDataSource.Callback<ProcessTransactionInfo> callback2) {
        k.c(context2, "context");
        k.c(callback2, H5Event.TYPE_CALL_BACK);
        this.context = context2;
        this.requestBodyJson = str;
        this.callback = callback2;
    }

    public final PaymentMethodDataSource.Callback<ProcessTransactionInfo> getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getRequestBodyJson() {
        return this.requestBodyJson;
    }

    public final Request<ProcessTransactionInfo> getRequest(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        VolleyPostRequest volleyPostRequest = new VolleyPostRequest(1, SDKUtility.addAuthDefaultParams(this.context, NativeSdkGtmLoader.getProcessTranscationUrl(str2, str)), hashMap, (Map<String, String>) null, getRequestBody(str3), new ProcessTransactionRequest$getRequest$request$1(this), new ProcessTransactionRequest$getRequest$request$2(this), ProcessTransactionInfo.class);
        volleyPostRequest.setRequestPriority(Request.Priority.IMMEDIATE);
        volleyPostRequest.setRetryPolicy(new DefaultRetryPolicy(SDKUtility.getDefaultTimeout(), 0, 1.0f));
        return volleyPostRequest;
    }

    public final Request<ProcessTransactionInfo> getRequest() {
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        String orderId = merchantInstance.getOrderId();
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        String mid = merchantInstance2.getMid();
        MerchantBL merchantInstance3 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance3, "MerchantBL.getMerchantInstance()");
        return getRequest(orderId, mid, merchantInstance3.getToken());
    }

    private final String getRequestBody(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject(this.requestBodyJson);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        if (merchantInstance.isFromAllInOneSDK()) {
            ExtendInfo extendInfo = new ExtendInfo();
            extendInfo.setSdkType(SDKConstants.AIO_SDK_PG);
            jSONObject3.put(SDKConstants.EXTEND_INF0, new JSONObject(new f().b(extendInfo)));
        }
        try {
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject2.put("txnToken", str);
            jSONObject2.put(SDKConstants.VERSION, "1.0");
            jSONObject2.put("channelId", SDKConstants.WAP);
            String str2 = SDKConstants.orderId;
            MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
            jSONObject3.put(str2, merchantInstance2.getOrderId());
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            HashMap<String, Object> extraParamsPTC = instance.getExtraParamsPTC();
            if (extraParamsPTC != null && (!extraParamsPTC.isEmpty())) {
                for (Map.Entry entry : extraParamsPTC.entrySet()) {
                    jSONObject3.put((String) entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        return jSONObject.toString();
    }

    public final void executeRequest(Context context2, Request<?> request) {
        k.c(context2, "context");
        k.c(request, "request");
        if (SDKUtility.isNetworkAvailable(context2)) {
            VolleyRequestQueue.getInstance(context2).addToRequestQueue(request);
        }
    }
}
