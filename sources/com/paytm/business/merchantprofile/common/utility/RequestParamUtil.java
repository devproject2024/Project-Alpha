package com.paytm.business.merchantprofile.common.utility;

import android.content.Context;
import android.text.TextUtils;
import com.business.common_module.utilities.c;
import com.business.common_module.utilities.i;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.b;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RequestParamUtil {
    public static HashMap<String, Object> getAuthCodeRequestBody(String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("response_type", "code");
        hashMap.put("client_id", AppConstants.KeyValues.CLIENT_ID);
        hashMap.put("do_not_redirect", Boolean.TRUE);
        hashMap.put("scope", "paytm");
        hashMap.put("username", str);
        hashMap.put("password", str2);
        return hashMap;
    }

    public static HashMap<String, Object> getAuthHeaders() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Authorization", AppConstants.KeyValues.AUTHORIZATION_VALUE);
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        addCommonHeaderParams(hashMap, ProfileConfig.getInstance().getAppContext());
        return hashMap;
    }

    public static HashMap<String, Object> getLoginSignUpHeaders() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Authorization", AppConstants.KeyValues.AUTHORIZATION_VALUE);
        hashMap.put("Content-Type", "application/json");
        addCommonHeaderParams(hashMap, ProfileConfig.getInstance().getAppContext());
        return hashMap;
    }

    public static HashMap<String, Object> getRequestHeaderParam(Context context) {
        String userToken = ProfileSharedPreferences.getInstance().getUserToken();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-auth-ump", AppConstants.KeyValues.HEADER_CLIENT_ID_VALUE);
        hashMap.put("x-user-token", userToken);
        hashMap.put("Content-Type", "application/json");
        addCommonHeaderParams(hashMap, context);
        return hashMap;
    }

    public static HashMap<String, Object> getRequestHeaderMidParam(Context context) {
        String userToken = ProfileSharedPreferences.getInstance().getUserToken();
        String merchantMid = ProfileSharedPreferences.getInstance().getMerchantMid();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-auth-ump", AppConstants.KeyValues.HEADER_CLIENT_ID_VALUE);
        hashMap.put("x-user-token", userToken);
        hashMap.put("Content-Type", "application/json");
        hashMap.put("x-user-mid", merchantMid);
        addCommonHeaderParams(hashMap, context);
        return hashMap;
    }

    public static HashMap<String, Object> getApplicationJsonHeader() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    public static HashMap<String, Object> getAuthDefaultHeaders(Context context) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("deviceManufacturer", AppUtility.getDeviceManufacturer());
        hashMap.put("deviceName", AppUtility.getDeviceName());
        c.a aVar = c.f7365a;
        hashMap.put("imei", c.a.a(context));
        c.a aVar2 = c.f7365a;
        hashMap.put("deviceIdentifier", c.a.b(context));
        hashMap.put("client", AppUtility.getClient());
        hashMap.put("osVersion", AppUtility.getOSReleaseVersion());
        hashMap.put("version", AppUtility.getVersion(context));
        if (AppUtility.getSimSerialNumber(context) != null) {
            hashMap.put("sim1", AppUtility.getSimSerialNumber(context));
        }
        if (ProfileSharedPreferences.getInstance().getLatitude(context) != null) {
            hashMap.put("lat", ProfileSharedPreferences.getInstance().getLatitude(context));
            hashMap.put("latitude", ProfileSharedPreferences.getInstance().getLatitude(context));
        }
        if (ProfileSharedPreferences.getInstance().getLongitude(context) != null) {
            hashMap.put("long", ProfileSharedPreferences.getInstance().getLongitude(context));
            hashMap.put("longitude", ProfileSharedPreferences.getInstance().getLongitude(context));
        }
        String a2 = i.a(context);
        if (a2 != null && a2.trim().length() > 0) {
            hashMap.put("networkType", a2);
        }
        hashMap.put("language", b.a((Context) ProfileConfig.getInstance().getApplication()));
        hashMap.put("applanguage", b.a((Context) ProfileConfig.getInstance().getApplication()));
        hashMap.put("playStore", Boolean.valueOf(AppUtility.isPlayStoreInstall(context)));
        return hashMap;
    }

    public static void addCommonHeaderParams(HashMap<String, Object> hashMap, Context context) {
        c.a aVar = c.f7365a;
        String b2 = c.a.b(context);
        if (b2 != null) {
            hashMap.put("deviceIdentifier", b2);
        }
        hashMap.put("client", AppUtility.getClient());
        hashMap.put("osVersion", AppUtility.getOSReleaseVersion());
        hashMap.put("appVersion", AppUtility.getVersion(context));
    }

    public static HashMap<String, Object> getMerchantServiceHeaders(Context context, boolean z) {
        HashMap<String, Object> hashMap;
        if (z) {
            hashMap = getAuthDefaultHeaders(context);
            hashMap.put("appVersion", hashMap.get("version"));
        } else {
            hashMap = new HashMap<>();
        }
        hashMap.put("session_token", ProfileSharedPreferences.getInstance().getUserToken());
        hashMap.put("Content-Type", "application/json");
        hashMap.remove("version");
        return hashMap;
    }

    public static RequestBody getRequestBody(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), str);
    }

    public static RequestBody getMultiPartFormRequestBody(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return RequestBody.create(MultipartBody.FORM, str);
    }

    public static HashMap<String, Object> getHeaders(Context context) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-auth-ump", AppConstants.KeyValues.HEADER_CLIENT_ID_VALUE);
        hashMap.put("x-user-token", ProfileSharedPreferences.getInstance().getUserToken());
        hashMap.put("x-user-mid", ProfileSharedPreferences.getInstance().getMerchantMid());
        hashMap.put("Content-Type", "application/json");
        addCommonHeaderParams(hashMap, context);
        return hashMap;
    }

    public static HashMap<String, Object> getEDCRentalPlansApiHeaders() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("x-auth-ump", AppConstants.KeyValues.HEADER_CLIENT_ID_VALUE);
        hashMap.put("x-user-token", ProfileSharedPreferences.getInstance().getUserToken());
        hashMap.put("x-user-mid", ProfileSharedPreferences.getInstance().getMerchantMid());
        return hashMap;
    }
}
