package com.paytmmall.clpartifact.network;

import android.os.SystemClock;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.util.H5Utils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.StringRequest;
import com.business.merchant_payments.utility.StringUtility;
import com.paytmmall.clpartifact.analytics.KibanaHelper;
import com.paytmmall.clpartifact.common.TimeUtils;
import com.paytmmall.clpartifact.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class CommonNetworkRequest extends StringRequest {
    private static final String TAG = "Volley";
    private final String mBody;
    private Response.ErrorListener mErrorListener;
    private final HashMap<String, String> mHeaders;
    private Response.Listener<String> mResponseListener;
    private NetworkResponse networkResponse;
    private long startTime = SystemClock.elapsedRealtime();

    private String getMethodString(int i2) {
        switch (i2) {
            case 0:
                return H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD;
            case 1:
                return "POST";
            case 2:
                return "PUT";
            case 3:
                return "DELETE";
            case 4:
                return "HEAD";
            case 5:
                return "OPTIONS";
            case 6:
                return "TRACE";
            case 7:
                return HttpClientStack.HttpPatch.METHOD_NAME;
            default:
                return H5Utils.NETWORK_TYPE_UNKNOWN;
        }
    }

    CommonNetworkRequest(int i2, String str, HashMap<String, String> hashMap, String str2, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(i2, str, listener, errorListener);
        this.mHeaders = hashMap;
        this.mBody = str2;
        this.mResponseListener = listener;
        this.mErrorListener = errorListener;
    }

    public void deliverResponse(String str) {
        printResponse(str);
        KibanaHelper.logResponse(this.networkResponse, str, getUrl(), this.startTime);
        this.mResponseListener.onResponse(str);
    }

    public void deliverError(VolleyError volleyError) {
        printError(volleyError != null ? volleyError.getMessage() : "Unknown");
        KibanaHelper.logErrorResponse(volleyError, getUrl(), this.startTime);
        Response.ErrorListener errorListener = this.mErrorListener;
        if (errorListener != null) {
            errorListener.onErrorResponse(volleyError);
        }
    }

    public byte[] getBody() throws AuthFailureError {
        String str = this.mBody;
        if (str != null) {
            return str.getBytes();
        }
        return super.getBody();
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> hashMap = this.mHeaders;
        if (hashMap != null) {
            return hashMap;
        }
        return super.getHeaders();
    }

    private synchronized void printResponse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("URL: " + getUrl() + StringUtility.NEW_LINE);
        sb.append("METHOD: " + getMethodString(getMethod()) + StringUtility.NEW_LINE);
        StringBuilder sb2 = new StringBuilder("Request Header: ");
        sb2.append(this.mHeaders != null ? this.mHeaders : "");
        sb2.append(StringUtility.NEW_LINE);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder("Request Body: ");
        sb3.append(this.mBody != null ? this.mBody : "");
        sb3.append(StringUtility.NEW_LINE);
        sb.append(sb3.toString());
        sb.append("Response Body: ".concat(String.valueOf(str)));
        LogUtils.d(TAG, sb.toString());
    }

    private synchronized void printError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("URL: " + getUrl() + StringUtility.NEW_LINE);
        sb.append("METHOD: " + getMethodString(getMethod()) + StringUtility.NEW_LINE);
        StringBuilder sb2 = new StringBuilder("Request Header: ");
        sb2.append(this.mHeaders != null ? this.mHeaders : "");
        sb2.append(StringUtility.NEW_LINE);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder("Request Body: ");
        sb3.append(this.mBody != null ? this.mBody : "");
        sb3.append(StringUtility.NEW_LINE);
        sb.append(sb3.toString());
        sb.append("Error: ".concat(String.valueOf(str)));
        LogUtils.d(TAG, sb.toString());
    }

    public Response<String> parseNetworkResponse(NetworkResponse networkResponse2) {
        if (!(networkResponse2 == null || networkResponse2.headers == null || !networkResponse2.headers.containsKey(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR))) {
            TimeUtils.setServerTime(networkResponse2.headers.get(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR));
        }
        this.networkResponse = networkResponse2;
        return super.parseNetworkResponse(networkResponse2);
    }
}
