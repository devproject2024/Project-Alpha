package com.paytmmall.clpartifact.analytics;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import org.json.JSONException;
import org.json.JSONObject;

public class KibanaHelper {
    private static long API_DELAY_TIME = 0;
    private static final int ERROR_CODE_401 = 401;
    private static final int ERROR_CODE_403 = 403;
    private static final int ERROR_CODE_410 = 410;
    private static final String KEY_APP_RESPONSE_TIME = "appNetworkTime";
    private static final String KEY_EVENT_TYPE = "eventType";
    private static final String KEY_HTTP_CODE = "httpCode";
    private static final String KEY_MID = "mid";
    private static final String KEY_MSG = "msg";
    private static final String KEY_RESPONSE = "response";
    private static final String KEY_RESPONSE_CODE = "responseCode";
    private static final String KEY_RESPONSE_TIME = "responseTime";
    private static final String KEY_URI = "uri";
    private static final String KEY_USER_FACING = "userFacing";

    public static void logResponse(NetworkResponse networkResponse, String str, String str2, long j) {
        if (networkResponse != null && str != null && isDelayResponse(networkResponse.networkTimeMs)) {
            sendSuccessAnalyticsLogs(networkResponse, str, new JSONObject(), str2, j);
        }
    }

    public static void logErrorResponse(VolleyError volleyError, String str, long j) {
        sendErrorAnaltyicsLogs(volleyError, new JSONObject(), str, j);
    }

    private static boolean isDelayResponse(long j) {
        return j > API_DELAY_TIME;
    }

    private static JSONObject fillCommonData(JSONObject jSONObject, String str, long j, String str2, int i2, long j2, String str3) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put(KEY_HTTP_CODE, i2);
        jSONObject.put(KEY_RESPONSE_CODE, i2);
        jSONObject.put(KEY_URI, appendQueryParam(removeParams(str), KEY_APP_RESPONSE_TIME, elapsedRealtime));
        jSONObject.put(KEY_RESPONSE_TIME, j2);
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("mid", str2);
        }
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        if (communicationListener != null && communicationListener.isKibanaResponseNeeded()) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            jSONObject.put("response", str3);
        }
        if (!(i2 == 401 || i2 == 403 || i2 == 410 || !TextUtils.isEmpty(jSONObject.optString(KEY_USER_FACING)))) {
            jSONObject.put(KEY_USER_FACING, "None");
        }
        return jSONObject;
    }

    private static String removeParams(String str) {
        int indexOf = str.indexOf("?");
        return indexOf != -1 ? str.substring(0, indexOf) : str;
    }

    private static void sendErrorAnaltyicsLogs(VolleyError volleyError, JSONObject jSONObject, String str, long j) {
        if (volleyError != null) {
            if (volleyError.networkResponse != null) {
                jSONObject = fillCommonData(jSONObject, str, j, "", volleyError.networkResponse.statusCode, volleyError.networkResponse.networkTimeMs, getErrorResponse(volleyError.networkResponse.data));
            }
            ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
            if (communicationListener != null) {
                communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), false);
            }
        }
    }

    private static String getErrorResponse(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : new String(bArr);
    }

    private static String getStringyJson(JSONObject jSONObject) {
        return jSONObject.toString();
    }

    private static String appendQueryParam(String str, String str2, long j) {
        if (str == null) {
            return str;
        }
        return str + "?" + str2 + "=" + j;
    }

    private static void sendSuccessAnalyticsLogs(NetworkResponse networkResponse, String str, JSONObject jSONObject, String str2, long j) {
        if (networkResponse != null) {
            JSONObject fillCommonData = fillCommonData(jSONObject, str2, j, "", networkResponse.statusCode, networkResponse.networkTimeMs, str);
            ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
            if (communicationListener != null) {
                communicationListener.sendErrorAnalyticsLogs(getStringyJson(fillCommonData), true);
            }
        }
    }
}
