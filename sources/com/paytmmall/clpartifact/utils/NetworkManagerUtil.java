package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.alipay.mobile.nebula.util.H5Utils;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.b.b.b;
import com.paytm.utility.b.b.c;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkManagerUtil {
    private static final String KEY_EVENT_TYPE = "eventType";
    private static final String KEY_HTTP_CODE = "httpCode";
    private static final String KEY_MSG = "msg";
    private static final String KEY_RESPONSE_CODE = "responseCode";
    private static final String KEY_RESPONSE_TIME = "responseTime";
    private static final String KEY_URI = "uri";
    private long resourceReadyTime;

    public static String getNetworkClass(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER);
        switch (telephonyManager != null ? telephonyManager.getNetworkType() : 0) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return H5Utils.NETWORK_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return H5Utils.NETWORK_TYPE_3G;
            case 13:
                return H5Utils.NETWORK_TYPE_4G;
            default:
                return "Unknown";
        }
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isConnectedToWIfi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static void logImageFetchingTime(long j, String str, int i2, Drawable drawable, b<Drawable> bVar, c cVar) {
        if (isNetworkConnected(CLPArtifact.getInstance().getContext())) {
            String networkClass = getNetworkClass(CLPArtifact.getInstance().getContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(KEY_RESPONSE_CODE, i2);
                jSONObject.put(KEY_URI, str);
                jSONObject.put(KEY_RESPONSE_TIME, j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
            if (communicationListener != null) {
                if (networkClass.equalsIgnoreCase(H5Utils.NETWORK_TYPE_4G)) {
                    if (cVar.name().equalsIgnoreCase("MEMORY_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Memory");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (cVar.name().equalsIgnoreCase("RESOURCE_DISK_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Resource");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    } else if (cVar.name().equalsIgnoreCase("REMOTE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Remote");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (networkClass.equalsIgnoreCase(H5Utils.NETWORK_TYPE_3G)) {
                    if (cVar.name().equalsIgnoreCase("MEMORY_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Memory");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (cVar.name().equalsIgnoreCase("RESOURCE_DISK_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Resource");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e7) {
                            e7.printStackTrace();
                        }
                    } else if (cVar.name().equalsIgnoreCase("REMOTE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Remote");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e8) {
                            e8.printStackTrace();
                        }
                    }
                }
                if (networkClass.equalsIgnoreCase(H5Utils.NETWORK_TYPE_2G)) {
                    if (cVar.name().equalsIgnoreCase("MEMORY_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Memory");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (cVar.name().equalsIgnoreCase("RESOURCE_DISK_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Resource");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e10) {
                            e10.printStackTrace();
                        }
                    } else if (cVar.name().equalsIgnoreCase("REMOTE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Remote");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e11) {
                            e11.printStackTrace();
                        }
                    }
                }
                if (isConnectedToWIfi(CLPArtifact.getInstance().getContext())) {
                    if (cVar.name().equalsIgnoreCase("MEMORY_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Memory");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (cVar.name().equalsIgnoreCase("RESOURCE_DISK_CACHE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from DISK");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e13) {
                            e13.printStackTrace();
                        }
                    } else if (cVar.name().equalsIgnoreCase("REMOTE")) {
                        String.valueOf(j);
                        try {
                            jSONObject.put(KEY_MSG, "4G from Remote");
                            communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), true);
                        } catch (JSONException e14) {
                            e14.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void logImageFetchingTime(long j, String str, int i2, b<Drawable> bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_RESPONSE_CODE, i2);
            jSONObject.put(KEY_URI, str);
            jSONObject.put(KEY_RESPONSE_TIME, j);
            ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
            if (communicationListener != null) {
                communicationListener.sendErrorAnalyticsLogs(getStringyJson(jSONObject), false);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private static String getStringyJson(JSONObject jSONObject) {
        return jSONObject.toString();
    }
}
