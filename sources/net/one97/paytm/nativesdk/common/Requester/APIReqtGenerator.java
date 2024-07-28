package net.one97.paytm.nativesdk.common.Requester;

import android.text.TextUtils;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.ApplyPromoRequest;
import net.one97.paytm.nativesdk.common.model.FetchCardDetailsRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APIReqtGenerator {
    public static String createJsonForFetchAPILogin(String str) {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject2.put(SDKConstants.VERSION, "1.0");
            jSONObject2.put("channelId", SDKConstants.WAP);
            jSONObject3.put(Constants.RISK_SDK_VERSION, "Android_" + PaytmSDK.getNativeSdkVersion());
            if (!TextUtils.isEmpty(PaytmSDK.getAppVersion())) {
                jSONObject3.put("appVersion", "Android_" + PaytmSDK.getAppVersion());
            }
            jSONObject3.put(SDKConstants.KEY_POSTPAID_ONBOARDING, true);
            new JSONArray().put(str);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForFetchAPI(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put("tokenType", SDKConstants.SSO);
            jSONObject2.put(SDKConstants.VERSION, "v3");
            jSONObject2.put("channelId", SDKConstants.WAP);
            jSONObject3.put("mid", str2);
            jSONObject3.put("orderAmount", str3);
            jSONObject3.put(SDKConstants.KEY_POSTPAID_ONBOARDING, true);
            jSONObject3.put(SDKConstants.ADDNPAY_UPI_PUSH, true);
            jSONObject3.put("applyPaymentOffer", String.valueOf(z2));
            jSONObject3.put("fetchAllPaymentOffers", String.valueOf(z));
            jSONObject3.put(Constants.RISK_SDK_VERSION, "Android_" + PaytmSDK.getNativeSdkVersion());
            if (!TextUtils.isEmpty(PaytmSDK.getAppVersion())) {
                jSONObject3.put("appVersion", "Android_" + PaytmSDK.getAppVersion());
            }
            new JSONArray().put(str);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForFetchAPI(String str, String str2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
        JSONObject jSONObject2;
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject4.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject4.put("tokenType", SDKConstants.SSO);
            jSONObject4.put(SDKConstants.VERSION, "v3");
            jSONObject4.put("channelId", SDKConstants.WAP);
            if (jSONObject == null) {
                jSONObject = jSONObject5;
            } else if (jSONObject.has("txnAmount") && (jSONObject2 = jSONObject.getJSONObject("txnAmount")) != null && jSONObject2.has("value")) {
                jSONObject.put("orderAmount", String.valueOf(jSONObject2.getInt("value")));
            }
            jSONObject.put(SDKConstants.KEY_POSTPAID_ONBOARDING, true);
            jSONObject.put(SDKConstants.ADDNPAY_UPI_PUSH, true);
            jSONObject.put("applyPaymentOffer", String.valueOf(z3));
            jSONObject.put("fetchAllPaymentOffers", String.valueOf(z2));
            if (z) {
                jSONObject.put(Constants.RISK_SDK_VERSION, "Android_" + PaytmSDK.getNativeSdkVersion());
                if (!TextUtils.isEmpty(PaytmSDK.getAppVersion())) {
                    jSONObject.put("appVersion", "Android_" + PaytmSDK.getAppVersion());
                }
            }
            new JSONArray().put(str);
            jSONObject3.put(SDKConstants.HEAD, jSONObject4);
            jSONObject3.put(SDKConstants.BODY, jSONObject);
        } catch (JSONException unused) {
        }
        return jSONObject3.toString();
    }

    public static String createJsonForFetchAPI(String str, String str2, boolean z, boolean z2) {
        if (DirectPaymentBL.getInstance().isSubsCriptionFlow()) {
            return createJsonForFetchAPISubs(str);
        }
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put("txnToken", str2);
            jSONObject2.put(SDKConstants.VERSION, "v3");
            jSONObject2.put("channelId", SDKConstants.WAP);
            jSONObject3.put(SDKConstants.KEY_POSTPAID_ONBOARDING, true);
            jSONObject3.put(SDKConstants.ADDNPAY_UPI_PUSH, true);
            jSONObject3.put(Constants.RISK_SDK_VERSION, "Android_" + PaytmSDK.getNativeSdkVersion());
            if (!TextUtils.isEmpty(PaytmSDK.getAppVersion())) {
                jSONObject3.put("appVersion", "Android_" + PaytmSDK.getAppVersion());
            }
            jSONObject3.put("upiRecurringSupport", true);
            jSONObject3.put("mid", MerchantBL.getMerchantInstance().getMid());
            jSONObject3.put("orderId", MerchantBL.getMerchantInstance().getOrderId());
            jSONObject3.put("fetchAllPaymentOffers", String.valueOf(z));
            jSONObject3.put("applyPaymentOffer", String.valueOf(z2));
            new JSONArray().put(str);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForFetchAPISubs(String str) {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject2.put(SDKConstants.VERSION, "v3");
            jSONObject2.put("channelId", SDKConstants.WAP);
            new JSONArray().put(str);
            jSONObject3.put(SDKConstants.ADDNPAY_UPI_PUSH, true);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForMerchantMapping(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject2.put(SDKConstants.VERSION, "v1");
            jSONObject2.put("channelId", SDKConstants.WAP);
            jSONObject2.put("ssoToken", MerchantBL.getMerchantInstance().getSsoToken());
            jSONObject3.put("orderId", str);
            jSONObject3.put("mid", str2);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForVpaAPI() {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            jSONObject2.put(SDKConstants.VERSION, "1.0");
            jSONObject2.put("channelId", SDKConstants.WAP);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForVpaAPI(String str) {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put("txnToken", str);
            jSONObject2.put(SDKConstants.VERSION, "1.0");
            jSONObject2.put("channelId", SDKConstants.WAP);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForEmiDetailsAPI(String str, String str2, boolean z) {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (z) {
            try {
                jSONObject3.put("mid", MerchantBL.getMerchantInstance().getMid());
            } catch (JSONException unused) {
            }
        }
        jSONObject3.put("channelCode", str);
        jSONObject3.put("emiType", str2);
        if (z) {
            jSONObject2.put("tokenType", SDKConstants.SSO);
        } else {
            jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
        jSONObject2.put(SDKConstants.VERSION, "1.0");
        jSONObject2.put("channelId", SDKConstants.WAP);
        jSONObject.put(SDKConstants.HEAD, jSONObject2);
        jSONObject.put(SDKConstants.BODY, jSONObject3);
        return jSONObject.toString();
    }

    public static String createJsonForNBAPI(String str, boolean z) {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            if (z) {
                jSONObject2.put("tokenType", SDKConstants.SSO);
            } else {
                jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            }
            jSONObject2.put(SDKConstants.VERSION, "1.0");
            jSONObject2.put("channelId", SDKConstants.WAP);
            if (z) {
                jSONObject3.put("mid", MerchantBL.getMerchantInstance().getMid());
            }
            jSONObject3.put("type", str);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String createJsonForFetchBalance(String str, boolean z) {
        new HashMap().put("Content-Type", "application/json");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            if (z) {
                jSONObject2.put("tokenType", SDKConstants.SSO);
            } else {
                jSONObject2.put("txnToken", MerchantBL.getMerchantInstance().getToken());
            }
            jSONObject2.put(SDKConstants.VERSION, "1.0");
            jSONObject2.put("channelId", SDKConstants.WAP);
            if (z) {
                jSONObject3.put("mid", MerchantBL.getMerchantInstance().getMid());
            }
            jSONObject3.put("paymentMode", str);
            jSONObject.put(SDKConstants.HEAD, jSONObject2);
            jSONObject.put(SDKConstants.BODY, jSONObject3);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static ApplyPromoRequest getApplyPromoRequestObj(boolean z, ApplyPromoRequest.PaymentOption paymentOption, String str) {
        ApplyPromoRequest applyPromoRequest = new ApplyPromoRequest();
        ApplyPromoRequest.Head head = new ApplyPromoRequest.Head();
        ApplyPromoRequest.Body body = new ApplyPromoRequest.Body();
        head.setChannelId(SDKConstants.WAP);
        head.setRequestId(DirectPaymentBL.getInstance().getRequestId());
        head.setVersion("1.0");
        if (!z || TextUtils.isEmpty(MerchantBL.getMerchantInstance().getSsoToken()) || SDKUtility.isAppInvokeFlow()) {
            head.setTokenType(SDKConstants.TXN_TOKEN);
            head.setToken(MerchantBL.getMerchantInstance().getToken());
            if (!TextUtils.isEmpty(DirectPaymentBL.getInstance().getCustomerId())) {
                body.setCustId(DirectPaymentBL.getInstance().getCustomerId());
            }
        } else {
            head.setTokenType(SDKConstants.SSO);
            head.setToken(MerchantBL.getMerchantInstance().getSsoToken());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        head.setRequestTimestamp(sb.toString());
        body.setMid(MerchantBL.getMerchantInstance().getMid());
        if (!TextUtils.isEmpty(MerchantBL.getMerchantInstance().getOrderId())) {
            body.setOrderId(MerchantBL.getMerchantInstance().getOrderId());
        }
        body.setTotalTransactionAmount(MerchantBL.getMerchantInstance().getAmount());
        if (!TextUtils.isEmpty(str)) {
            body.setPromocode(str);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(paymentOption);
        body.setPaymentOptions(arrayList);
        applyPromoRequest.setHead(head);
        applyPromoRequest.setBody(body);
        return applyPromoRequest;
    }

    public static String createJSONForFetchPromo(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject necessaryHeadersParams = SDKUtility.getNecessaryHeadersParams();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(SDKConstants.CARD_NUMBER, str);
            jSONObject2.put(SDKConstants.TXN_TYPE, str2);
            jSONObject.put(SDKConstants.HEAD, necessaryHeadersParams);
            jSONObject.put(SDKConstants.BODY, jSONObject2);
        } catch (JSONException e2) {
            LogUtility.printStackTrace(e2);
        }
        return jSONObject.toString();
    }

    public static FetchCardDetailsRequest getFetchCardDetailsRequestObject(boolean z, String str) {
        FetchCardDetailsRequest fetchCardDetailsRequest = new FetchCardDetailsRequest();
        FetchCardDetailsRequest.Head head = new FetchCardDetailsRequest.Head();
        FetchCardDetailsRequest.Body body = new FetchCardDetailsRequest.Body();
        head.setChannelId(SDKConstants.WAP);
        head.setRequestId(DirectPaymentBL.getInstance().getRequestId());
        head.setVersion("1.0");
        if (z) {
            head.setTokenType(SDKConstants.SSO);
            head.setToken(MerchantBL.getMerchantInstance().getSsoToken());
        } else {
            head.setToken(MerchantBL.getMerchantInstance().getToken());
        }
        body.setMid(MerchantBL.getMerchantInstance().getMid());
        body.setCardNumber(str.replace("-", ""));
        body.setEightDigitBinRequired("true");
        fetchCardDetailsRequest.setHead(head);
        fetchCardDetailsRequest.setBody(body);
        return fetchCardDetailsRequest;
    }
}
