package com.alipay.mobile.nebula.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.webkit.WebResourceResponse;
import com.alibaba.a.a;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.android.phone.androidannotations.utils.PermissionUtils;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.h5container.api.H5Bundle;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5ResInputListen;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.h5container.service.UcService;
import com.alipay.mobile.nebula.appcenter.api.H5ContentProvider;
import com.alipay.mobile.nebula.appcenter.listen.NebulaAppCallback;
import com.alipay.mobile.nebula.appcenter.listen.NebulaAppCallbackInfo;
import com.alipay.mobile.nebula.appcenter.listen.NebulaAppManager;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.io.PoolingByteArrayOutputStream;
import com.alipay.mobile.nebula.permission.H5PermissionCallback;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5ImageProvider;
import com.alipay.mobile.nebula.provider.H5LoginProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.providermanager.H5BaseProviderInfo;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.alipay.mobile.nebula.wallet.H5WalletWrapper;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class H5Utils {
    public static final String EGG_PAIN_IP = "0.0.0.0";
    public static final String KEY_APK_WHITE_LIST = "h5_ApkWhiteList";
    public static final String KEY_CLEAR_STATE = "h5_ssoLoginNeedClearState";
    public static final String KEY_ENABLE_EXTERNAL_WEBVIEW = "h5_enableExternalWebView";
    public static final String KEY_ENTRANCE_WHITELIST = "h5_entranceWhiteListSwitch";
    public static final String KEY_EXTERNAL_WEBVIEW_MODEL = "h5_externalWebViewModel";
    public static final String KEY_EXTERNAL_WEBVIEW_SDK_VERSION = "h5_externalWebViewSdkVersion";
    public static final String KEY_EXTERNAL_WEBVIEW_USAGE_RULE = "h5_externalWebViewUsageRule";
    public static final String KEY_H5_AUTO_LOGIN_SWITCH = "h5_autoLoginSwitch";
    public static final String KEY_H5_CDN_WEBP_CONFIG = "h5_cdnWebPConfig";
    public static final String KEY_H5_COMMON_CONFIG = "h5_commonConfig";
    public static final String KEY_H5_FORCE_UC = "h5_forceUc";
    public static final String KEY_H5_SHARE_TO_ALP_TIMELINE_SWITCH = "h5_share2ALPTimeLineSwitch";
    public static final String KEY_H5_WEBVIEW_CONFIG = "h5_webViewConfig";
    public static final String KEY_INPUT_WARNING_TEXT = "h5_inputWarningText";
    public static final String KEY_INPUT_WHITE_LIST_SWITCH = "inputWhiteListSwitch";
    public static final String KEY_JSAPI_SWITCH = "jsApiSwitch";
    public static final String KEY_MAIN_SWITCH = "mainSwitch";
    public static final String KEY_SHARE_CHANNELS = "h5_shareChannels";
    public static final String KEY_SSO_LOGIN = "h5_ssoLogin";
    public static final String KEY_SSO_LOGIN_SWITCH = "ssoLoginSwitch";
    public static final String KEY_TBSSO_TIMEOUT = "tbssoLoginTimeout";
    public static final String NETWORK_TYPE_2G = "2G";
    public static final String NETWORK_TYPE_3G = "3G";
    public static final String NETWORK_TYPE_4G = "4G";
    public static final String NETWORK_TYPE_NOTREACHABLE = "NotReachable";
    public static final String NETWORK_TYPE_UNKNOWN = "UNKNOWN";
    public static final String NETWORK_TYPE_WIFI = "WIFI";
    public static final String TAG = "H5Utils";
    private static String currentProcessName;
    private static Boolean isDebug;
    private static List<String> landingPrefixs = new ArrayList<String>() {
        {
            add("https://ds.alipay.com");
            add("https://d.alipay.com");
            add("https://render.alipay.com/p/s/i");
        }
    };
    public static String ldcLevel;

    public static PackageInfo getPackageInfo(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if (installedPackages == null) {
                return getPkInfo(context, str);
            }
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                PackageInfo packageInfo = installedPackages.get(i2);
                if (str.equals(packageInfo.packageName)) {
                    return packageInfo;
                }
            }
            return getPkInfo(context, str);
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail", e2);
            return null;
        }
    }

    public static PackageInfo getPkInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return null;
        }
    }

    public static String getString(Bundle bundle, String str) {
        return getString(bundle, str, "");
    }

    public static String getString(Bundle bundle, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return (String) getValue(bundle, str, str2);
    }

    public static boolean getBoolean(Bundle bundle, String str, boolean z) {
        return ((Boolean) getValue(bundle, str, Boolean.valueOf(z))).booleanValue();
    }

    public static int getInt(Bundle bundle, String str) {
        return getInt(bundle, str, 0);
    }

    public static int getInt(Bundle bundle, String str, int i2) {
        return ((Integer) getValue(bundle, str, Integer.valueOf(i2))).intValue();
    }

    public static long getLong(Bundle bundle, String str) {
        return getLong(bundle, str, 0);
    }

    public static long getLong(Bundle bundle, String str, long j) {
        return ((Long) getValue(bundle, str, Long.valueOf(j))).longValue();
    }

    public static double getDouble(Bundle bundle, String str) {
        return getDouble(bundle, str, 0.0d);
    }

    public static double getDouble(Bundle bundle, String str, double d2) {
        return ((Double) getValue(bundle, str, Double.valueOf(d2))).doubleValue();
    }

    public static boolean contains(Bundle bundle, String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return bundle.containsKey(str);
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return false;
    }

    public static <T> T getValue(Bundle bundle, String str, T t) {
        if (bundle != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (t == null || !bundle.containsKey(str)) {
                        return t;
                    }
                    T t2 = bundle.get(str);
                    if (t2 != null && t.getClass().isAssignableFrom(t2.getClass())) {
                        return t2;
                    }
                    H5Log.d(TAG, "[key] " + str + " [value] " + t2);
                    return t;
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return t;
    }

    public static e toJSONObject(Bundle bundle) {
        e eVar = new e();
        if (bundle == null) {
            return eVar;
        }
        for (String str : bundle.keySet()) {
            eVar.put(str, bundle.get(str));
        }
        return eVar;
    }

    public static String getString(e eVar, String str) {
        return getString(eVar, str, "");
    }

    public static String getString(e eVar, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return (String) getValue(eVar, str, str2);
    }

    public static boolean getBoolean(e eVar, String str, boolean z) {
        return ((Boolean) getValue(eVar, str, Boolean.valueOf(z))).booleanValue();
    }

    public static int getInt(e eVar, String str) {
        return getInt(eVar, str, 0);
    }

    public static int getInt(e eVar, String str, int i2) {
        return ((Integer) getValue(eVar, str, Integer.valueOf(i2))).intValue();
    }

    public static long getLong(e eVar, String str) {
        return getLong(eVar, str, 0);
    }

    public static long getLong(e eVar, String str, long j) {
        return ((Long) getValue(eVar, str, Long.valueOf(j))).longValue();
    }

    public static float getFloat(e eVar, String str) {
        return ((Float) getValue(eVar, str, Float.valueOf(0.0f))).floatValue();
    }

    public static float getFloat(e eVar, String str, float f2) {
        return ((Float) getValue(eVar, str, Float.valueOf(f2))).floatValue();
    }

    public static e getJSONObject(e eVar, String str, e eVar2) {
        if (eVar2 == null) {
            eVar2 = new e();
        }
        return (e) getValue(eVar, str, eVar2);
    }

    public static b getJSONArray(e eVar, String str, b bVar) {
        if (bVar == null) {
            bVar = new b();
        }
        return (b) getValue(eVar, str, bVar);
    }

    public static boolean contains(e eVar, String str) {
        if (eVar == null || eVar.isEmpty()) {
            return false;
        }
        return eVar.containsKey(str);
    }

    public static <T> T getValue(e eVar, String str, T t) {
        if (eVar == null || eVar.isEmpty() || t == null || !eVar.containsKey(str)) {
            return t;
        }
        T t2 = eVar.get(str);
        if (t2 != null && t.getClass().isAssignableFrom(t2.getClass())) {
            return t2;
        }
        H5Log.w(TAG, "[key] " + str + " [value] " + t2);
        return t;
    }

    public static String getConfigString(Context context, String str) {
        String str2 = null;
        try {
            Cursor query = context.getContentResolver().query(H5UrlHelper.parseUrl("content://com.alipay.setting/".concat(String.valueOf(str))), new String[]{""}, "", new String[0], "");
            while (query.moveToNext()) {
                str2 = query.getString(0);
            }
            query.close();
        } catch (Exception e2) {
            H5Log.e(TAG, "exception detail", e2);
        }
        return str2;
    }

    public static boolean getConfigBoolean(Context context, String str) {
        boolean z = false;
        try {
            Cursor query = context.getContentResolver().query(H5UrlHelper.parseUrl("content://com.alipay.setting/".concat(String.valueOf(str))), new String[]{""}, "", new String[0], "");
            if (query == null) {
                return false;
            }
            if (query.moveToNext() && query.getInt(0) == 1) {
                z = true;
            }
            query.close();
            return z;
        } catch (Exception e2) {
            H5Log.e(TAG, "Exception", e2);
        }
    }

    public static Bundle toBundle(e eVar) {
        return toBundle((Bundle) null, eVar);
    }

    public static Bundle toBundle(Bundle bundle, e eVar) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (eVar != null && !eVar.isEmpty()) {
            for (String next : eVar.keySet()) {
                try {
                    Object obj = eVar.get(next);
                    if (obj instanceof Integer) {
                        bundle.putInt(next, ((Integer) obj).intValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof String) {
                        bundle.putString(next, (String) obj);
                    } else if (obj instanceof Long) {
                        bundle.putLong(next, ((Long) obj).longValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(next, ((Double) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putDouble(next, new BigDecimal(Float.toString(((Float) obj).floatValue())).doubleValue());
                    } else if (obj instanceof a) {
                        bundle.putString(next, ((a) obj).toJSONString());
                    } else if (obj instanceof BigDecimal) {
                        bundle.putDouble(next, ((BigDecimal) obj).doubleValue());
                    }
                } catch (Exception e2) {
                    H5Log.e(TAG, "toBundle exception", e2);
                }
            }
        }
        return bundle;
    }

    public static e parseObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a.parseObject(str);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return null;
        }
    }

    public static b parseArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a.parseArray(str);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return null;
        }
    }

    public static String base64ToString(String str, int i2) {
        if (str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(str, i2));
    }

    public static boolean isMain() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void runOnMain(Runnable runnable) {
        if (runnable != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    public static String getAbsoluteUrl(String str, String str2, Bundle bundle) {
        Uri parseUrl = H5UrlHelper.parseUrl(str2);
        if (parseUrl == null || !TextUtils.isEmpty(parseUrl.getScheme())) {
            return str2;
        }
        String str3 = null;
        if (str2.startsWith("//")) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parseUrl2 = H5UrlHelper.parseUrl(str);
            if (parseUrl2 != null && !TextUtils.isEmpty(parseUrl2.getScheme())) {
                str3 = parseUrl2.getScheme() + AppConstants.COLON + str2;
            }
            H5Log.d(TAG, "getAbsoluteUrl // ".concat(String.valueOf(str3)));
            return str3;
        } else if (str2.startsWith("/")) {
            Uri parseUrl3 = H5UrlHelper.parseUrl(str);
            if (parseUrl3 == null) {
                return null;
            }
            String scheme = parseUrl3.getScheme();
            String authority = parseUrl3.getAuthority();
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority)) {
                str3 = scheme + "://" + authority + str2;
            }
            H5Log.d(TAG, "getAbsoluteUrl / ".concat(String.valueOf(str3)));
            return str3;
        } else if (TextUtils.isEmpty(str)) {
            return null;
        } else {
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) getProvider(H5ConfigProvider.class.getName());
            if (h5ConfigProvider != null && !H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO.equals(h5ConfigProvider.getConfigWithProcessCache("h5_getAbsoluteUrlRemoveQuery"))) {
                str = H5UrlHelper.purifyUrl(str);
            }
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                return null;
            }
            String str4 = str.substring(0, lastIndexOf) + "/" + str2;
            H5Log.d(TAG, "getAbsoluteUrl else ".concat(String.valueOf(str4)));
            return str4;
        }
    }

    public static String getAbsoluteUrlV2(String str, String str2, Bundle bundle) {
        String str3;
        Uri parseUrl = H5UrlHelper.parseUrl(str2);
        if (parseUrl == null || !TextUtils.isEmpty(parseUrl.getScheme())) {
            return str2;
        }
        String str4 = null;
        if (str2.startsWith("./")) {
            Uri parseUrl2 = H5UrlHelper.parseUrl(str);
            if (parseUrl2 == null) {
                return null;
            }
            String scheme = parseUrl2.getScheme();
            String authority = parseUrl2.getAuthority();
            String encodedPath = parseUrl2.getEncodedPath();
            if (!TextUtils.isEmpty(encodedPath)) {
                int lastIndexOf = encodedPath.lastIndexOf("/");
                str3 = scheme + "://" + authority + encodedPath.substring(0, lastIndexOf) + str2.substring(1);
            } else {
                str3 = scheme + "://" + authority + str2.substring(1);
            }
            H5Log.d(TAG, "getAbsoluteUrlV2 ./ ".concat(String.valueOf(str3)));
            return str3;
        }
        Uri parseUrl3 = H5UrlHelper.parseUrl(str);
        if (parseUrl3 == null) {
            return null;
        }
        String scheme2 = parseUrl3.getScheme();
        String authority2 = parseUrl3.getAuthority();
        if (!TextUtils.isEmpty(scheme2) && !TextUtils.isEmpty(authority2)) {
            if (str2.startsWith("/")) {
                str4 = scheme2 + "://" + authority2 + str2;
            } else {
                str4 = scheme2 + "://" + authority2 + "/" + str2;
            }
        }
        String str5 = str4;
        H5Log.d(TAG, "getAbsoluteUrlV2 / or else ".concat(String.valueOf(str5)));
        return str5;
    }

    public static boolean isStripLandingURLEnable(String str) {
        H5ConfigProvider h5ConfigProvider;
        if (!TextUtils.isEmpty(str) && (h5ConfigProvider = (H5ConfigProvider) getProvider(H5ConfigProvider.class.getName())) != null) {
            String config = h5ConfigProvider.getConfig("h5_stripLandingEnable");
            H5Log.d(TAG, "getStripLandingURL getSwitch value ".concat(String.valueOf(config)));
            if (TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, config)) {
                return true;
            }
        }
        return false;
    }

    public static String getStripLandingURL(String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && landingPrefixs != null) {
            Uri parseUrl = H5UrlHelper.parseUrl(str);
            String str3 = null;
            if (parseUrl != null) {
                str2 = parseUrl.getScheme() + "://" + parseUrl.getEncodedAuthority() + parseUrl.getEncodedPath();
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2) && ifMatchLandingURL(str2)) {
                String queryParameter = parseUrl != null ? parseUrl.getQueryParameter("scheme") : null;
                if (!TextUtils.isEmpty(queryParameter)) {
                    str3 = queryParameter;
                } else if (parseUrl != null) {
                    str3 = parseUrl.getQueryParameter("url");
                }
                if (!TextUtils.isEmpty(str3)) {
                    str = str3;
                }
            }
        }
        H5Log.d(TAG, "getStripLandingURL is ".concat(String.valueOf(str)));
        return str;
    }

    private static boolean ifMatchLandingURL(String str) {
        for (String indexOf : landingPrefixs) {
            if (str.indexOf(indexOf) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String deParameterizeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            new URL(str);
            int indexOf = str.indexOf("#");
            String substring = indexOf != -1 ? str.substring(0, indexOf) : str;
            int lastIndexOf = str.lastIndexOf("?");
            if (lastIndexOf != -1) {
                return substring.substring(0, lastIndexOf);
            }
            return substring;
        } catch (MalformedURLException e2) {
            H5Log.e(TAG, "exception detail", e2);
            return str;
        }
    }

    public static void runOnMain(Runnable runnable, long j) {
        if (runnable != null) {
            new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
        }
    }

    public static Handler runOnMainHandler(Runnable runnable, long j) {
        if (runnable == null) {
            return null;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(runnable, j);
        return handler;
    }

    public static int getUid(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 1).uid;
        } catch (PackageManager.NameNotFoundException e2) {
            H5Log.e(TAG, "exception detail", e2);
            return 0;
        } catch (RuntimeException e3) {
            H5Log.e(TAG, "exception detail", e3);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[SYNTHETIC, Splitter:B:19:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String read(java.lang.String r6) {
        /*
            java.lang.String r0 = "exception detail"
            java.lang.String r1 = "H5Utils"
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x003b }
            r3.<init>(r6)     // Catch:{ all -> 0x003b }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ all -> 0x0039 }
            r6.<init>(r3)     // Catch:{ all -> 0x0039 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0039 }
            r4.<init>(r6)     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r6.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x0039 }
        L_0x001d:
            if (r5 == 0) goto L_0x002c
            r6.append(r5)     // Catch:{ all -> 0x0039 }
            r5 = 10
            r6.append(r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = r4.readLine()     // Catch:{ all -> 0x0039 }
            goto L_0x001d
        L_0x002c:
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0039 }
            r3.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0047
        L_0x0034:
            r6 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r6)
            goto L_0x0047
        L_0x0039:
            r6 = move-exception
            goto L_0x003d
        L_0x003b:
            r6 = move-exception
            r3 = r2
        L_0x003d:
            java.lang.String r4 = "Exception"
            com.alipay.mobile.nebula.util.H5Log.e(r1, r4, r6)     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0047
            r3.close()     // Catch:{ all -> 0x0034 }
        L_0x0047:
            return r2
        L_0x0048:
            r6 = move-exception
            if (r3 == 0) goto L_0x0053
            r3.close()     // Catch:{ all -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r2 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r2)
        L_0x0053:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.util.H5Utils.read(java.lang.String):java.lang.String");
    }

    /* JADX INFO: finally extract failed */
    public static byte[] readBytes(InputStream inputStream) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream();
        byte[] buf = H5IOUtils.getBuf(TarConstants.EOF_BLOCK);
        while (true) {
            try {
                int read = inputStream.read(buf);
                if (read != -1) {
                    poolingByteArrayOutputStream.write(buf, 0, read);
                } else {
                    byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                    H5IOUtils.returnBuf(buf);
                    H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                    H5IOUtils.closeQuietly(inputStream);
                    return byteArray;
                }
            } catch (Throwable th) {
                H5IOUtils.returnBuf(buf);
                H5IOUtils.closeQuietly(poolingByteArrayOutputStream);
                H5IOUtils.closeQuietly(inputStream);
                throw th;
            }
        }
    }

    public static String getClassName(Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        return canonicalName == null ? obj.getClass().getName() : canonicalName;
    }

    public static int parseInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            H5Log.e(TAG, "parse int exception.", th);
            return 0;
        }
    }

    public static final long parseLong(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable th) {
            H5Log.e(TAG, "parse long exception.", th);
            return 0;
        }
    }

    public static final boolean isCss(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(".css");
    }

    public static final boolean isJavascript(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(".js");
    }

    public static final boolean isImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(".gif") || str.endsWith(".bmp") || str.endsWith(".tiff") || str.endsWith(".pcx") || str.endsWith(".tga") || str.endsWith(".exif") || str.endsWith(".fpx") || str.endsWith(".svg") || str.endsWith(".psd") || str.endsWith(".cdr") || str.endsWith(".pcd") || str.endsWith(".dxf") || str.endsWith(".ufo") || str.endsWith(".eps") || str.endsWith(".ai") || str.endsWith(".raw") || str.endsWith(".webp")) {
            return true;
        }
        return false;
    }

    public static boolean isInWifi() {
        String networkType = getNetworkType(getContext());
        H5Log.d(TAG, "getNetworkType ".concat(String.valueOf(networkType)));
        return NETWORK_TYPE_WIFI.equals(networkType);
    }

    public static String getNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            H5Log.e(TAG, "get network info exception.", th);
            networkInfo = null;
        }
        if (networkInfo == null) {
            return NETWORK_TYPE_NOTREACHABLE;
        }
        int type = networkInfo.getType();
        if (type == 1 || type == 9) {
            return NETWORK_TYPE_WIFI;
        }
        int networkType = ((TelephonyManager) context.getSystemService(ContactColumn.PHONE_NUMBER)).getNetworkType();
        if (networkType == 18) {
            return NETWORK_TYPE_3G;
        }
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NETWORK_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NETWORK_TYPE_3G;
            case 13:
                return NETWORK_TYPE_4G;
            default:
                return NETWORK_TYPE_UNKNOWN;
        }
    }

    public static int dip2px(Context context, int i2) {
        try {
            return H5DimensionUtil.dip2px(context, (float) i2);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return 0;
        }
    }

    public static int pt2px(Context context, int i2) {
        try {
            return Math.round(TypedValue.applyDimension(3, (float) i2, context.getResources().getDisplayMetrics()));
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return 0;
        }
    }

    public static Class<?> getClass(String str, String str2) {
        return H5WalletWrapper.getClass(str, str2);
    }

    public static Class<?> getClass(String str, String str2, boolean z) {
        return H5WalletWrapper.getClass(str, str2, z);
    }

    public static boolean isDebuggable(Context context) {
        Boolean bool = isDebug;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            H5Log.e(TAG, "exception detail", th);
            return false;
        }
    }

    public static boolean isDebug() {
        if (isDebug == null) {
            isDebug = Boolean.valueOf(isDebuggable(getContext()));
        }
        return isDebug.booleanValue();
    }

    public static String toJSONString(Object obj) {
        return obj == null ? "" : e.toJSONString(obj);
    }

    public static final <T> T findServiceByInterface(String str) {
        return H5WalletWrapper.findServiceByInterface(str);
    }

    public static Map<String, Object> jsonToMap(String str) {
        e parseObject = parseObject(str);
        if (parseObject == null || parseObject.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : parseObject.keySet()) {
            try {
                hashMap.put(next, parseObject.get(next).toString());
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return hashMap;
    }

    public static boolean isLogicIP(String str) {
        if (str == null) {
            return false;
        }
        if (EGG_PAIN_IP.equals(str.trim())) {
            return true;
        }
        return H5PatternHelper.matchRegex("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$", str);
    }

    public static byte[] ipToBytesByReg(String str) {
        byte[] bArr = new byte[4];
        try {
            String[] split = str.split("\\.");
            bArr[0] = (byte) (Integer.parseInt(split[0]) & PriceRangeSeekBar.INVALID_POINTER_ID);
            bArr[1] = (byte) (Integer.parseInt(split[1]) & PriceRangeSeekBar.INVALID_POINTER_ID);
            bArr[2] = (byte) (Integer.parseInt(split[2]) & PriceRangeSeekBar.INVALID_POINTER_ID);
            bArr[3] = (byte) (Integer.parseInt(split[3]) & PriceRangeSeekBar.INVALID_POINTER_ID);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Context getContext() {
        return H5WalletWrapper.getContext();
    }

    public static ThreadPoolExecutor getExecutor(String str) {
        return H5WalletWrapper.getExecutor(str);
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        return H5WalletWrapper.getScheduledExecutor();
    }

    public static void executeOrdered(String str, Runnable runnable) {
        H5WalletWrapper.executeOrdered(str, runnable);
    }

    public static Resources getNebulaResources() {
        return H5WalletWrapper.getNebulaResources();
    }

    public static Resources getNebulaBizResources() {
        return H5WalletWrapper.getNebulaBizResources();
    }

    public static Resources getNebulaCoreResources() {
        return H5WalletWrapper.getNebulaCoreResources();
    }

    public static H5ProviderManager getH5ProviderManager() {
        return H5WalletWrapper.getH5ProviderManager();
    }

    public static <T> T getProvider(String str) {
        H5ProviderManager h5ProviderManager = getH5ProviderManager();
        if (h5ProviderManager != null) {
            return h5ProviderManager.getProvider(str);
        }
        H5Log.e(TAG, "h5ProviderManager == null");
        return null;
    }

    public static void setProvider(String str, Object obj) {
        H5ProviderManager h5ProviderManager = getH5ProviderManager();
        if (h5ProviderManager != null) {
            h5ProviderManager.setProvider(str, obj);
        } else {
            H5Log.e(TAG, "h5ProviderManager == null");
        }
    }

    public static String getHpmFile(String str, String str2) {
        return H5WalletWrapper.getHpmFile(str, str2);
    }

    public static String getVersion() {
        try {
            return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return "";
        }
    }

    public static void openUrl(String str) {
        if (isInWallet()) {
            if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                try {
                    str = URLEncoder.encode(str, AppConstants.UTF_8);
                } catch (Exception e2) {
                    H5Log.e(TAG, (Throwable) e2);
                }
                str = "alipays://platformapi/startapp?appId=20000067&url=".concat(String.valueOf(str));
            }
            H5EnvProvider h5EnvProvider = (H5EnvProvider) getProvider(H5EnvProvider.class.getName());
            if (h5EnvProvider != null) {
                h5EnvProvider.goToSchemeService(str);
                return;
            }
            return;
        }
        H5Service h5Service = (H5Service) findServiceByInterface(H5Service.class.getName());
        if (h5Service != null) {
            H5Bundle h5Bundle = new H5Bundle();
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            h5Bundle.setParams(bundle);
            h5Service.startPage((f) null, h5Bundle);
        }
    }

    public static void openIntent(String str) {
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent((ComponentName) null);
            if (Build.VERSION.SDK_INT >= 15) {
                parseUri.setSelector((Intent) null);
            }
            Context context = getContext();
            parseUri.setFlags(268435456);
            context.startActivity(parseUri);
        } catch (Exception e2) {
            H5Log.e(TAG, "bad uri " + str + ": " + e2);
        }
    }

    public static boolean isInWallet() {
        Context context = getContext();
        if (context != null) {
            try {
                String packageName = context.getPackageName();
                if (packageName == null || !packageName.contains("AlipayGphone")) {
                    return false;
                }
                return true;
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return true;
    }

    public static void setNebulaAppCallback(int i2, List<String> list) {
        H5Service h5Service;
        NebulaAppManager nebulaAppManager;
        List<NebulaAppCallback> nebulaAppCallbackList;
        if (list != null && !list.isEmpty() && (h5Service = (H5Service) findServiceByInterface(H5Service.class.getName())) != null && (nebulaAppManager = h5Service.getNebulaAppManager()) != null && (nebulaAppCallbackList = nebulaAppManager.getNebulaAppCallbackList()) != null && !nebulaAppCallbackList.isEmpty()) {
            for (NebulaAppCallback next : nebulaAppCallbackList) {
                if (isDebuggable(getContext())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setNebulaAppCallback ");
                    sb.append(getClassName(next));
                    sb.append(" source:");
                    sb.append(i2);
                    sb.append(" appIdList:");
                    for (String append : list) {
                        sb.append(" ");
                        sb.append(append);
                    }
                    H5Log.d(TAG, sb.toString());
                }
                NebulaAppCallbackInfo nebulaAppCallbackInfo = new NebulaAppCallbackInfo();
                nebulaAppCallbackInfo.setAppIdList(list);
                nebulaAppCallbackInfo.setCallBackSource(i2);
                next.getCallback(nebulaAppCallbackInfo);
            }
        }
    }

    public static boolean isMainProcess() {
        try {
            String packageName = getContext().getPackageName();
            if (TextUtils.isEmpty(packageName) || !packageName.equalsIgnoreCase(getProcessName())) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return true;
        }
    }

    public static String getProcessName() {
        try {
            if (!TextUtils.isEmpty(currentProcessName)) {
                return currentProcessName;
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) getContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (next.pid == myPid) {
                    currentProcessName = next.processName;
                }
            }
            return currentProcessName;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public static boolean isInTinyProcess() {
        String processName = getProcessName();
        if (!TextUtils.isEmpty(processName)) {
            return processName.contains("lite");
        }
        return false;
    }

    public static e getAuthInfo() {
        H5LoginProvider h5LoginProvider = (H5LoginProvider) getProvider(H5LoginProvider.class.getName());
        if (h5LoginProvider == null) {
            return null;
        }
        e eVar = new e();
        eVar.put("nick", (Object) h5LoginProvider.getNick());
        eVar.put("userAvatar", (Object) h5LoginProvider.getUserAvatar());
        return eVar;
    }

    public static boolean eventFromTinyProcess(H5Event h5Event) {
        if (h5Event == null || h5Event.getExtra() == null || !(h5Event.getExtra() instanceof e)) {
            return false;
        }
        return getBoolean((e) h5Event.getExtra(), H5Param.isTinyApp, false);
    }

    public static void requestPermissions(Activity activity, String[] strArr, final H5PermissionCallback h5PermissionCallback) {
        if (!PermissionUtils.hasSelfPermissions(activity, strArr)) {
            if (Build.VERSION.SDK_INT < 23 && h5PermissionCallback != null) {
                h5PermissionCallback.onRequestPermissionsResult(false);
            }
            com.alipay.mobile.framework.b.a();
            new Object() {
                public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                    if (h5PermissionCallback != null) {
                        boolean verifyPermissions = PermissionUtils.verifyPermissions(iArr);
                        H5Log.d(H5Utils.TAG, "requestPermissions onRequestPermissionsResult ".concat(String.valueOf(verifyPermissions)));
                        h5PermissionCallback.onRequestPermissionsResult(verifyPermissions);
                    }
                }
            };
        } else if (h5PermissionCallback != null) {
            h5PermissionCallback.onRequestPermissionsResult(true);
            H5Log.d(TAG, "requestPermissions get true");
        }
    }

    public static void loadResInputFromH5App(final String str, final H5ResInputListen h5ResInputListen) {
        getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public final void run() {
                H5Page topH5Page;
                H5ContentProvider webProvider;
                WebResourceResponse content;
                UcService ucService = (UcService) H5Utils.findServiceByInterface(UcService.class.getName());
                WebResourceResponse response = (ucService == null || !H5Flag.ucReady) ? null : ucService.getResponse(str);
                if (response == null || response.getData() == null) {
                    H5Service h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName());
                    if (h5Service == null || (topH5Page = h5Service.getTopH5Page()) == null || topH5Page.getSession() == null || (webProvider = topH5Page.getSession().getWebProvider()) == null || (content = webProvider.getContent(str)) == null) {
                        try {
                            H5Log.d(H5Utils.TAG, "load response from net");
                            H5ImageProvider h5ImageProvider = (H5ImageProvider) H5Utils.getProvider(H5ImageProvider.class.getName());
                            if (h5ImageProvider != null) {
                                h5ImageProvider.getImageWithByte(str, h5ResInputListen);
                            } else {
                                h5ResInputListen.onGetInput((InputStream) null);
                            }
                        } catch (Throwable th) {
                            H5Log.e(H5Utils.TAG, "load response exception", th);
                            h5ResInputListen.onGetInput((InputStream) null);
                        }
                    } else {
                        H5Log.d(H5Utils.TAG, "get from H5pkg " + str);
                        h5ResInputListen.onGetInput(content.getData());
                    }
                } else {
                    H5Log.d(H5Utils.TAG, "load response from uc cache");
                    h5ResInputListen.onGetInput(response.getData());
                }
            }
        });
    }

    public static String getShareLoadingScheme(String str, String str2, H5Page h5Page) {
        if (h5Page == null || h5Page.getParams() == null) {
            return str;
        }
        if (str.startsWith("alipay")) {
            Uri parseUrl = H5UrlHelper.parseUrl(str);
            if (parseUrl == null) {
                return str;
            }
            String queryParameter = parseUrl.getQueryParameter("url");
            String queryParameter2 = parseUrl.getQueryParameter("enableTabBar");
            if (TextUtils.isEmpty(queryParameter) || !TextUtils.isEmpty(queryParameter2) || TextUtils.isEmpty(queryParameter)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            handleTabbarShareurl(H5TabbarUtils.getAbsoluteUrl(queryParameter, h5Page.getParams()), str2, h5Page, sb);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(str2)) {
            str2 = "20000067";
        }
        sb2.append("alipays://platformapi/startapp?appId=");
        sb2.append(str2);
        sb2.append("&url=");
        sb2.append(H5UrlHelper.encode(str));
        handleTabbarShareurl(str, str2, h5Page, sb2);
        return sb2.toString();
    }

    private static void handleTabbarShareurl(String str, String str2, H5Page h5Page, StringBuilder sb) {
        Bundle params = h5Page.getParams();
        String string = getString(params, "enableTabBar");
        H5Log.d(TAG, "generateAlipayScheme4Tabbar enableTabbar" + string + ", url " + str);
        if (TextUtils.equals(H5Param.DEFAULT_LONG_PRESSO_LOGIN, string) && !TextUtils.isEmpty(str) && !str.contains("enableTabBar") && -1 == H5TabbarUtils.ifUrlMatch(str2, str, params)) {
            sb.append("&enableTabBar=NO");
        }
    }

    public static void setLdcLevel(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.length() >= 11) {
                int parseInt = Integer.parseInt(str.substring(str.length() - 3, str.length() - 1));
                String str2 = "";
                if (parseInt == 0) {
                    str2 = "1";
                } else {
                    if (parseInt != 1) {
                        if (parseInt != 2) {
                            if (parseInt != 3) {
                                if (parseInt != 4) {
                                    if (parseInt >= 5 && parseInt <= 9) {
                                        str2 = "10";
                                    } else if (parseInt >= 10 && parseInt <= 19) {
                                        str2 = "20";
                                    } else if (parseInt >= 20 && parseInt <= 29) {
                                        str2 = "30";
                                    } else if (parseInt >= 30 && parseInt <= 49) {
                                        str2 = "50";
                                    }
                                }
                            }
                            str2 = "5";
                        }
                    }
                    str2 = "3";
                }
                ldcLevel = str2;
            }
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    public static boolean isTinyApp(AppInfo appInfo) {
        return appInfo != null && appInfo.app_channel == 4;
    }

    public static boolean isUCM57() {
        return getClass(H5BaseProviderInfo.nebulauc, "com.alipay.mobile.nebulauc.provider.H5UCM57ProviderImpl", true) != null;
    }

    public static boolean containNebulaAddcors(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf("nebula-addcors") > 0;
    }

    public static boolean enableCheckCrossOrigin() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_enableCheckCrossOrigin"));
    }

    public static String getStringConfig(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return null;
        }
        return h5ConfigProvider.getConfig(str);
    }
}
