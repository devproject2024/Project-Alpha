package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import com.alipay.iap.android.webapp.sdk.provider.BaseJSApiPermissionProvider;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.permission.H5PermissionManager;
import com.appsflyer.AFFacebookDeferredDeeplink;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.Foreground;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.internal.aa;
import com.appsflyer.internal.ab;
import com.appsflyer.internal.ac;
import com.appsflyer.internal.ad;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.af;
import com.appsflyer.internal.ag;
import com.appsflyer.internal.ah;
import com.appsflyer.internal.ai;
import com.appsflyer.internal.j;
import com.appsflyer.internal.model.event.AdRevenue;
import com.appsflyer.internal.model.event.Attr;
import com.appsflyer.internal.model.event.BackgroundEvent;
import com.appsflyer.internal.model.event.BackgroundReferrerLaunch;
import com.appsflyer.internal.model.event.CachedEvent;
import com.appsflyer.internal.model.event.InAppEvent;
import com.appsflyer.internal.model.event.Launch;
import com.appsflyer.internal.model.event.ProxyEvent;
import com.appsflyer.internal.model.event.Stats;
import com.appsflyer.internal.model.event.UninstallTokenEvent;
import com.appsflyer.internal.referrer.GoogleReferrer;
import com.appsflyer.internal.referrer.HuaweiReferrer;
import com.appsflyer.internal.referrer.Payload;
import com.appsflyer.internal.s;
import com.appsflyer.internal.t;
import com.appsflyer.internal.v;
import com.appsflyer.internal.w;
import com.appsflyer.internal.x;
import com.appsflyer.internal.y;
import com.appsflyer.internal.z;
import com.appsflyer.share.Constants;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.UpiContract;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyerLibCore extends AppsFlyerLib {
    public static final String AF_PRE_INSTALL_PATH = "AF_PRE_INSTALL_PATH";
    public static String FIRST_LAUNCHES_URL = null;
    public static final String INSTALL_REFERRER_PREF = "rfr";
    public static final String IS_STOP_TRACKING_USED = "is_stop_tracking_used";
    public static final String LOG_TAG = "AppsFlyer_5.4.0";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";
    public static String REFERRER_TRACKING_URL = null;
    public static String REGISTER_URL = null;
    public static AppsFlyerLibCore instance = new AppsFlyerLibCore();

    /* renamed from: ı  reason: contains not printable characters */
    public static final String f58 = "5.4";

    /* renamed from: Ɩ  reason: contains not printable characters */
    private static final String f59;

    /* renamed from: ǃ  reason: contains not printable characters */
    public static AppsFlyerInAppPurchaseValidatorListener f60 = null;

    /* renamed from: ɩ  reason: contains not printable characters */
    public static final String f61 = "38";
    /* access modifiers changed from: private */

    /* renamed from: ɪ  reason: contains not printable characters */
    public static AppsFlyerConversionListener f62 = null;

    /* renamed from: ɹ  reason: contains not printable characters */
    private static String f63;

    /* renamed from: ɾ  reason: contains not printable characters */
    private static String f64;

    /* renamed from: І  reason: contains not printable characters */
    private static String f65;

    /* renamed from: і  reason: contains not printable characters */
    private static final String f66;

    /* renamed from: ӏ  reason: contains not printable characters */
    private static final List<String> f67 = Arrays.asList(new String[]{"is_cache"});
    protected Uri latestDeepLink = null;

    /* renamed from: ŀ  reason: contains not printable characters */
    private long f68 = -1;
    /* access modifiers changed from: private */

    /* renamed from: ł  reason: contains not printable characters */
    public ScheduledExecutorService f69 = null;
    /* access modifiers changed from: private */

    /* renamed from: ſ  reason: contains not printable characters */
    public long f70;

    /* renamed from: Ɨ  reason: contains not printable characters */
    private String f71;

    /* renamed from: ƚ  reason: contains not printable characters */
    private Map<Long, String> f72;

    /* renamed from: ǀ  reason: contains not printable characters */
    private boolean f73;

    /* renamed from: ȷ  reason: contains not printable characters */
    private long f74 = -1;

    /* renamed from: ɍ  reason: contains not printable characters */
    private boolean f75 = false;

    /* renamed from: ɔ  reason: contains not printable characters */
    private boolean f76 = false;

    /* renamed from: ɟ  reason: contains not printable characters */
    private ag f77 = new ag();

    /* renamed from: ɨ  reason: contains not printable characters */
    private String f78;

    /* renamed from: ɺ  reason: contains not printable characters */
    private boolean f79;

    /* renamed from: ɼ  reason: contains not printable characters */
    private boolean f80 = false;

    /* renamed from: ɿ  reason: contains not printable characters */
    private long f81 = TimeUnit.SECONDS.toMillis(5);
    /* access modifiers changed from: private */

    /* renamed from: ʅ  reason: contains not printable characters */
    public long f82;
    /* access modifiers changed from: private */

    /* renamed from: ʟ  reason: contains not printable characters */
    public GoogleReferrer f83;
    /* access modifiers changed from: private */

    /* renamed from: ͻ  reason: contains not printable characters */
    public Map<String, Object> f84;

    /* renamed from: Ι  reason: contains not printable characters */
    public String f85;

    /* renamed from: ι  reason: contains not printable characters */
    public String f86;
    /* access modifiers changed from: private */

    /* renamed from: ϲ  reason: contains not printable characters */
    public Map<String, Object> f87;

    /* renamed from: ϳ  reason: contains not printable characters */
    private Application f88;

    /* renamed from: Ј  reason: contains not printable characters */
    private boolean f89 = false;
    /* access modifiers changed from: private */

    /* renamed from: г  reason: contains not printable characters */
    public boolean f90 = false;
    /* access modifiers changed from: private */

    /* renamed from: с  reason: contains not printable characters */
    public boolean f91 = false;
    /* access modifiers changed from: private */

    /* renamed from: т  reason: contains not printable characters */
    public HuaweiReferrer f92;

    /* renamed from: х  reason: contains not printable characters */
    private String f93;

    /* renamed from: Ӏ  reason: contains not printable characters */
    long f94;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f58);
        sb.append("/androidevent?buildnumber=5.4.0&app_id=");
        f59 = sb.toString();
        StringBuilder sb2 = new StringBuilder("https://%sregister.%s/api/v");
        sb2.append(f59);
        REGISTER_URL = sb2.toString();
        StringBuilder sb3 = new StringBuilder("https://%sadrevenue.%s/api/v");
        sb3.append(f58);
        sb3.append("/android?buildnumber=5.4.0&app_id=");
        f65 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(f58);
        sb4.append("/androidevent?app_id=");
        f66 = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%sconversions.%s/api/v");
        sb5.append(f66);
        FIRST_LAUNCHES_URL = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%slaunches.%s/api/v");
        sb6.append(f66);
        f63 = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sinapps.%s/api/v");
        sb7.append(f66);
        f64 = sb7.toString();
        StringBuilder sb8 = new StringBuilder("https://%sattr.%s/api/v");
        sb8.append(f66);
        REFERRER_TRACKING_URL = sb8.toString();
    }

    public AppsFlyerLibCore() {
        AFVersionDeclaration.init();
    }

    public static AppsFlyerLibCore getInstance() {
        return instance;
    }

    public void performOnAppAttribution(Context context, URI uri) {
        if (uri == null || uri.toString().isEmpty()) {
            AppsFlyerConversionListener appsFlyerConversionListener = f62;
            if (appsFlyerConversionListener != null) {
                StringBuilder sb = new StringBuilder("Link is \"");
                sb.append(uri);
                sb.append("\"");
                appsFlyerConversionListener.onAttributionFailure(sb.toString());
            }
        } else if (context == null) {
            AppsFlyerConversionListener appsFlyerConversionListener2 = f62;
            if (appsFlyerConversionListener2 != null) {
                StringBuilder sb2 = new StringBuilder("Context is \"");
                sb2.append(context);
                sb2.append("\"");
                appsFlyerConversionListener2.onAttributionFailure(sb2.toString());
            }
        } else {
            AFDeepLinkManager.getInstance();
            AFDeepLinkManager.m3(context, new HashMap(), Uri.parse(uri.toString()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ǃ  reason: contains not printable characters */
    public final void m100(Context context, Intent intent) {
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            getInstance();
            String stringExtra = intent.getStringExtra("appsflyer_preinstall");
            try {
                if (new JSONObject(stringExtra).has(Constants.URL_MEDIA_SOURCE)) {
                    AppsFlyerProperties.getInstance().set("preInstallName", stringExtra);
                } else {
                    AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                }
            } catch (JSONException e2) {
                AFLogger.afErrorLog("Error parsing JSON for preinstall", e2);
            }
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String stringExtra2 = intent.getStringExtra(Payload.REFERRER);
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString(Payload.REFERRER, stringExtra2);
            edit.apply();
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                AFEvent weakContext = new BackgroundReferrerLaunch().context(context).m4().weakContext();
                weakContext.f8 = stringExtra2;
                weakContext.f9 = intent;
                if (stringExtra2 != null && stringExtra2.length() > 5 && m48(weakContext, getSharedPreferences(context))) {
                    m68(AFExecutor.getInstance().m8(), new e(this, weakContext, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static void m62(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i2)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    String str2 = str;
                    int i3 = 0;
                    while (i3 < jSONArray2.length()) {
                        try {
                            if (jSONArray2.getLong(i3) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i3) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i3) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                                i3++;
                                str2 = next;
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                    str = str2;
                } catch (JSONException unused3) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    static void m41(Context context, String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = getSharedPreferences(context).getString("extraReferrers", (String) null);
            if (string == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject = jSONObject2;
                jSONArray = new JSONArray();
            } else {
                jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                m62(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject3 = jSONObject.toString();
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString("extraReferrers", jSONObject3);
            edit.apply();
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    public void stopTracking(boolean z, Context context) {
        this.f80 = z;
        aa.m116();
        try {
            File r6 = aa.m119(context);
            if (!r6.exists()) {
                r6.mkdir();
            } else {
                for (File file : r6.listFiles()) {
                    new StringBuilder("Found cached request").append(file.getName());
                    aa.m118(aa.m115(file).f265, context);
                }
            }
        } catch (Exception unused) {
        }
        if (this.f80) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putBoolean(IS_STOP_TRACKING_USED, true);
            edit.apply();
        }
    }

    public void onPause(Context context) {
        if (Foreground.listener != null) {
            Foreground.listener.onBecameBackground(context);
        }
    }

    public void updateServerUninstallToken(Context context, String str) {
        af.m128(context, str);
    }

    public void setDebugLog(boolean z) {
        setLogLevel(z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE);
    }

    public AppsFlyerLib enableLocationCollection(boolean z) {
        this.f75 = z;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: ι  reason: contains not printable characters */
    public static void m85(Context context, String str, long j) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static boolean m91(String str) {
        return AppsFlyerProperties.getInstance().getBoolean(str, false);
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static boolean m89() {
        return m91(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null;
    }

    public void waitForCustomerUserId(boolean z) {
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    public void setCustomerIdAndTrack(String str, Context context) {
        Intent intent;
        if (context == null) {
            return;
        }
        if (m89()) {
            setCustomerUserId(str);
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
            StringBuilder sb = new StringBuilder("CustomerUserId set: ");
            sb.append(str);
            sb.append(" - Initializing AppsFlyer Tacking");
            AFLogger.afInfoLog(sb.toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (referrer == null) {
                referrer = "";
            }
            if (context instanceof Activity) {
                intent = ((Activity) context).getIntent();
            } else {
                intent = null;
            }
            m42(context, string, referrer, intent);
            if (AppsFlyerProperties.getInstance().getString("afUninstallToken") != null) {
                m103(context, AppsFlyerProperties.getInstance().getString("afUninstallToken"));
                return;
            }
            return;
        }
        setCustomerUserId(str);
        AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
    }

    public String getOutOfStore(Context context) {
        String str;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        if (context == null) {
            str = null;
        } else {
            str = m64("AF_STORE", context.getPackageManager(), context.getPackageName());
        }
        if (str != null) {
            return str;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.m22("Cannot set setOutOfStore with null");
    }

    @Deprecated
    public void sendDeepLinkData(Activity activity) {
        if (activity != null && activity.getIntent() != null) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai aiVar = ai.f183;
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            aiVar.m144("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), sb.toString());
        } else if (activity != null) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m144("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), "activity_intent_null");
        } else {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m144("public_api_call", "sendDeepLinkData", "activity_null");
        }
        try {
            startTracking(activity);
            StringBuilder sb2 = new StringBuilder("getDeepLinkData with activity ");
            sb2.append(activity.getIntent().getDataString());
            AFLogger.afInfoLog(sb2.toString());
        } catch (Exception e2) {
            AFLogger.afInfoLog("getDeepLinkData Exception: ".concat(String.valueOf(e2)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0194  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendPushNotificationData(android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "c"
            java.lang.String r3 = "pid"
            r4 = 1
            r5 = 0
            r6 = 2
            java.lang.String r7 = "public_api_call"
            java.lang.String r8 = "sendPushNotificationData"
            if (r2 == 0) goto L_0x0048
            android.content.Intent r9 = r17.getIntent()
            if (r9 == 0) goto L_0x0048
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.ai.f183
            if (r9 != 0) goto L_0x0022
            com.appsflyer.internal.ai r9 = new com.appsflyer.internal.ai
            r9.<init>()
            com.appsflyer.internal.ai.f183 = r9
        L_0x0022:
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.ai.f183
            java.lang.String[] r10 = new java.lang.String[r6]
            java.lang.String r11 = r17.getLocalClassName()
            r10[r5] = r11
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r11 = "activity_intent_"
            r5.<init>(r11)
            android.content.Intent r11 = r17.getIntent()
            java.lang.String r11 = r11.toString()
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            r10[r4] = r5
            r9.m144(r7, r8, r10)
            goto L_0x007d
        L_0x0048:
            if (r2 == 0) goto L_0x0067
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.ai.f183
            if (r9 != 0) goto L_0x0055
            com.appsflyer.internal.ai r9 = new com.appsflyer.internal.ai
            r9.<init>()
            com.appsflyer.internal.ai.f183 = r9
        L_0x0055:
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.ai.f183
            java.lang.String[] r10 = new java.lang.String[r6]
            java.lang.String r11 = r17.getLocalClassName()
            r10[r5] = r11
            java.lang.String r5 = "activity_intent_null"
            r10[r4] = r5
            r9.m144(r7, r8, r10)
            goto L_0x007d
        L_0x0067:
            com.appsflyer.internal.ai r4 = com.appsflyer.internal.ai.f183
            if (r4 != 0) goto L_0x0072
            com.appsflyer.internal.ai r4 = new com.appsflyer.internal.ai
            r4.<init>()
            com.appsflyer.internal.ai.f183 = r4
        L_0x0072:
            com.appsflyer.internal.ai r4 = com.appsflyer.internal.ai.f183
            java.lang.String r5 = "activity_null"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r4.m144(r7, r8, r5)
        L_0x007d:
            boolean r4 = r2 instanceof android.app.Activity
            if (r4 == 0) goto L_0x00b0
            r4 = r2
            android.app.Activity r4 = (android.app.Activity) r4
            android.content.Intent r7 = r4.getIntent()
            if (r7 == 0) goto L_0x00b0
            android.os.Bundle r8 = r7.getExtras()
            if (r8 == 0) goto L_0x00b0
            java.lang.String r9 = "af"
            java.lang.String r10 = r8.getString(r9)
            if (r10 == 0) goto L_0x00b1
            java.lang.String r11 = java.lang.String.valueOf(r10)
            java.lang.String r12 = "Push Notification received af payload = "
            java.lang.String r11 = r12.concat(r11)
            com.appsflyer.AFLogger.afInfoLog(r11)
            r8.remove(r9)
            android.content.Intent r7 = r7.putExtras(r8)
            r4.setIntent(r7)
            goto L_0x00b1
        L_0x00b0:
            r10 = 0
        L_0x00b1:
            r1.f71 = r10
            java.lang.String r4 = r1.f71
            if (r4 == 0) goto L_0x01bf
            long r7 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.f72
            java.lang.String r9 = ")"
            if (r4 != 0) goto L_0x00d0
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.f72 = r0
            r12 = r7
            goto L_0x0181
        L_0x00d0:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0166 }
            java.lang.String r10 = "pushPayloadMaxAging"
            r11 = 1800000(0x1b7740, double:8.89318E-318)
            long r10 = r4.getLong(r10, r11)     // Catch:{ all -> 0x0166 }
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.f72     // Catch:{ all -> 0x0166 }
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x0166 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0166 }
            r12 = r7
        L_0x00e8:
            boolean r14 = r4.hasNext()     // Catch:{ all -> 0x0164 }
            if (r14 == 0) goto L_0x0181
            java.lang.Object r14 = r4.next()     // Catch:{ all -> 0x0164 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x0164 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ all -> 0x0164 }
            java.lang.String r6 = r1.f71     // Catch:{ all -> 0x0164 }
            r15.<init>(r6)     // Catch:{ all -> 0x0164 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0164 }
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f72     // Catch:{ all -> 0x0164 }
            java.lang.Object r5 = r5.get(r14)     // Catch:{ all -> 0x0164 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0164 }
            r6.<init>(r5)     // Catch:{ all -> 0x0164 }
            java.lang.Object r5 = r15.get(r3)     // Catch:{ all -> 0x0164 }
            java.lang.Object r2 = r6.get(r3)     // Catch:{ all -> 0x0164 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0164 }
            if (r2 == 0) goto L_0x0144
            java.lang.Object r2 = r15.get(r0)     // Catch:{ all -> 0x0164 }
            java.lang.Object r5 = r6.get(r0)     // Catch:{ all -> 0x0164 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0164 }
            if (r2 == 0) goto L_0x0144
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0164 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0164 }
            r0.append(r6)     // Catch:{ all -> 0x0164 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0164 }
            r0.append(r15)     // Catch:{ all -> 0x0164 }
            r0.append(r9)     // Catch:{ all -> 0x0164 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0164 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0164 }
            r2 = 0
            r1.f71 = r2     // Catch:{ all -> 0x0164 }
            return
        L_0x0144:
            r2 = 0
            long r5 = r14.longValue()     // Catch:{ all -> 0x0164 }
            long r5 = r7 - r5
            int r15 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r15 <= 0) goto L_0x0154
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f72     // Catch:{ all -> 0x0164 }
            r5.remove(r14)     // Catch:{ all -> 0x0164 }
        L_0x0154:
            long r5 = r14.longValue()     // Catch:{ all -> 0x0164 }
            int r15 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r15 > 0) goto L_0x0160
            long r12 = r14.longValue()     // Catch:{ all -> 0x0164 }
        L_0x0160:
            r2 = r17
            r6 = 2
            goto L_0x00e8
        L_0x0164:
            r0 = move-exception
            goto L_0x0168
        L_0x0166:
            r0 = move-exception
            r12 = r7
        L_0x0168:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error while handling push notification measurement: "
            r2.<init>(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x0181:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r3 = 2
            int r0 = r0.getInt(r2, r3)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.f72
            int r2 = r2.size()
            if (r2 != r0) goto L_0x01b1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r12)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f72
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r0.remove(r2)
        L_0x01b1:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f72
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = r1.f71
            r0.put(r2, r3)
            r16.startTracking(r17)
        L_0x01bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.sendPushNotificationData(android.app.Activity):void");
    }

    public void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        String str = null;
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : strArr) {
            if (AnonymousClass10.f97[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(z.m212(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: ι  reason: contains not printable characters */
        static final /* synthetic */ int[] f97 = new int[AppsFlyerProperties.EmailsCryptType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f97 = r0
                int[] r0 = f97     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f97     // Catch:{ NoSuchFieldError -> 0x001f }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.AnonymousClass10.<clinit>():void");
        }
    }

    public void setResolveDeepLinkURLs(String... strArr) {
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        AFDeepLinkManager.f1 = strArr;
    }

    public void setOneLinkCustomDomain(String... strArr) {
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        AFDeepLinkManager.f0 = strArr;
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, final Context context) {
        if (context != null) {
            this.f88 = (Application) context.getApplicationContext();
            if (GoogleReferrer.allow(this, context)) {
                if (this.f83 == null) {
                    this.f83 = new GoogleReferrer();
                    AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                    this.f83.start(context, new Runnable() {
                        public final void run() {
                            try {
                                AFLogger.afDebugLog("Install Referrer collected locally");
                                AppsFlyerLibCore.m77(AppsFlyerLibCore.this);
                            } catch (Throwable th) {
                                AFLogger.afErrorLog(th.getMessage(), th);
                            }
                        }
                    });
                } else {
                    AFLogger.afWarnLog("GoogleReferrer instance already created");
                }
            }
            final SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (getLaunchCounter(sharedPreferences, false) < 2) {
                this.f92 = new HuaweiReferrer(new Runnable() {
                    public final void run() {
                        if (AppsFlyerLibCore.this.getLaunchCounter(sharedPreferences, false) != 1) {
                            return;
                        }
                        if (!GoogleReferrer.allow(AppsFlyerLibCore.this, context) || sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false)) {
                            AppsFlyerLibCore.this.m43(new Attr().context(context));
                        }
                    }
                }, context);
                this.f92.start();
            }
            this.f91 = m80(context);
        } else {
            AFLogger.afWarnLog("init :: context is null, Google Install Referrer will be not initialized!");
        }
        return init(str, appsFlyerConversionListener);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean m80(Context context) {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            this.f87 = new ConcurrentHashMap();
            AnonymousClass4 r4 = new t.d() {
                /* renamed from: ı  reason: contains not printable characters */
                public final void m105(String str, String str2) {
                    AppsFlyerLibCore.this.f87.put("signedData", str);
                    AppsFlyerLibCore.this.f87.put("signature", str2);
                    AppsFlyerLibCore.this.f87.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }

                /* renamed from: ǃ  reason: contains not printable characters */
                public final void m106(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = SDKConstants.UNKNOWN;
                    }
                    AppsFlyerLibCore.this.f87.put("error", message);
                    AFLogger.afErrorLog(str, exc, true);
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                t.AnonymousClass3 r7 = new InvocationHandler(r4) {

                    /* renamed from: ι */
                    private /* synthetic */ d f296;

                    public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.t.3.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.t.3.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r7)});
            } catch (ClassNotFoundException e2) {
                r4.m198(e2.getClass().getSimpleName(), e2);
            } catch (NoSuchMethodException e3) {
                r4.m198(e3.getClass().getSimpleName(), e3);
            } catch (IllegalAccessException e4) {
                r4.m198(e4.getClass().getSimpleName(), e4);
            } catch (InvocationTargetException e5) {
                r4.m198(e5.getClass().getSimpleName(), e5);
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void enableFacebookDeferredApplinks(boolean z) {
        this.f89 = z;
    }

    public void startTracking(Context context) {
        startTracking(context, (String) null);
    }

    public void startTracking(Context context, String str) {
        startTracking(context, str, (AppsFlyerTrackingRequestListener) null);
    }

    public void startTracking(Context context, String str, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        final String str2 = str;
        if (!this.f79) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'startTracking()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
            if (str2 == null) {
                return;
            }
        }
        if (Foreground.listener == null) {
            this.f88 = (Application) context.getApplicationContext();
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m144("public_api_call", "startTracking", str2);
            AFLogger.afInfoLog(String.format("Starting AppsFlyer Tracking: (v%s.%s)", new Object[]{"5.4.0", f61}));
            StringBuilder sb = new StringBuilder("Build Number: ");
            sb.append(f61);
            AFLogger.afInfoLog(sb.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.f88.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str2);
                ah.m136(str);
            } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY))) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the startTracking API method (should be called on Activity's onCreate).");
                return;
            }
            Context baseContext = this.f88.getBaseContext();
            try {
                if ((baseContext.getPackageManager().getPackageInfo(baseContext.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                    if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                        AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    } else {
                        AFLogger.m22("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                    }
                }
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder("checkBackupRules Exception: ");
                sb2.append(e2.toString());
                AFLogger.afRDLog(sb2.toString());
            }
            if (this.f89) {
                Context applicationContext = this.f88.getApplicationContext();
                this.f84 = new HashMap();
                final long currentTimeMillis = System.currentTimeMillis();
                AnonymousClass1 r8 = new AFFacebookDeferredDeeplink.AppLinkFetchEvents() {
                    public final void onAppLinkFetchFinished(String str, String str2, String str3) {
                        if (str != null) {
                            AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(String.valueOf(str)));
                            AppsFlyerLibCore.this.f84.put("link", str);
                            if (str2 != null) {
                                AppsFlyerLibCore.this.f84.put("target_url", str2);
                            }
                            if (str3 != null) {
                                HashMap hashMap = new HashMap();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(PayUtility.PROMO_CODE, str3);
                                hashMap.put("deeplink_context", hashMap2);
                                AppsFlyerLibCore.this.f84.put("extras", hashMap);
                            }
                        } else {
                            AppsFlyerLibCore.this.f84.put("link", "");
                        }
                        AppsFlyerLibCore.this.f84.put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }

                    public final void onAppLinkFetchFailed(String str) {
                        AppsFlyerLibCore.this.f84.put("error", str);
                    }
                };
                try {
                    Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{applicationContext});
                    Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
                    Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                    Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
                    AFFacebookDeferredDeeplink.AnonymousClass5 r12 = new InvocationHandler(cls, r8) {

                        /* renamed from: ı */
                        private /* synthetic */ Class f29;

                        /* renamed from: ɩ */
                        private /* synthetic */ AppLinkFetchEvents f30;

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.AFFacebookDeferredDeeplink.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.AFFacebookDeferredDeeplink.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    };
                    Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r12);
                    String string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", "string", applicationContext.getPackageName()));
                    if (TextUtils.isEmpty(string)) {
                        r8.onAppLinkFetchFailed("Facebook app id not defined in resources");
                    } else {
                        method.invoke((Object) null, new Object[]{applicationContext, string, newProxyInstance});
                    }
                } catch (NoSuchMethodException e3) {
                    r8.onAppLinkFetchFailed(e3.toString());
                } catch (InvocationTargetException e4) {
                    r8.onAppLinkFetchFailed(e4.toString());
                } catch (ClassNotFoundException e5) {
                    r8.onAppLinkFetchFailed(e5.toString());
                } catch (IllegalAccessException e6) {
                    r8.onAppLinkFetchFailed(e6.toString());
                }
            }
            final AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener2 = appsFlyerTrackingRequestListener;
            Foreground.m112(context, new Foreground.Listener() {
                public final void onBecameForeground(Activity activity) {
                    if (AppsFlyerLibCore.this.getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(activity), false) < 2) {
                        AFSensorManager r0 = AFSensorManager.m27((Context) activity);
                        r0.f41.post(r0.f50);
                        r0.f41.post(r0.f46);
                    }
                    AFLogger.afInfoLog("onBecameForeground");
                    long unused = AppsFlyerLibCore.this.f82 = System.currentTimeMillis();
                    AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                    AFEvent key = new Launch().context(activity).key(str2);
                    key.f12 = appsFlyerTrackingRequestListener2;
                    appsFlyerLibCore.m101(key);
                    AFLogger.resetDeltaTime();
                }

                public final void onBecameBackground(Context context) {
                    AFLogger.afInfoLog("onBecameBackground");
                    long unused = AppsFlyerLibCore.this.f70 = System.currentTimeMillis();
                    AFLogger.afInfoLog("callStatsBackground background call");
                    AppsFlyerLibCore.this.m104((WeakReference<Context>) new WeakReference(context));
                    if (ai.f183 == null) {
                        ai.f183 = new ai();
                    }
                    ai aiVar = ai.f183;
                    if (aiVar.m151()) {
                        aiVar.m150();
                        if (context != null) {
                            String packageName = context.getPackageName();
                            PackageManager packageManager = context.getPackageManager();
                            try {
                                if (ai.f183 == null) {
                                    ai.f183 = new ai();
                                }
                                ai.f183.m149(packageName, packageManager);
                                if (ai.f183 == null) {
                                    ai.f183 = new ai();
                                }
                                BackgroundEvent trackingStopped = new ProxyEvent().body(ai.f183.m148()).trackingStopped(AppsFlyerLib.getInstance().isTrackingStopped());
                                StringBuilder sb = new StringBuilder();
                                sb.append(ServerConfigHandler.getUrl("https://%smonitorsdk.%s/remote-debug?app_id="));
                                sb.append(packageName);
                                new Thread(new ad((BackgroundEvent) trackingStopped.urlString(sb.toString()))).start();
                            } catch (Throwable unused2) {
                            }
                        }
                        aiVar.m146();
                    } else {
                        AFLogger.afDebugLog("RD status is OFF");
                    }
                    AFExecutor instance = AFExecutor.getInstance();
                    try {
                        AFExecutor.m7(instance.f26);
                        if (instance.f27 instanceof ThreadPoolExecutor) {
                            AFExecutor.m7((ThreadPoolExecutor) instance.f27);
                        }
                    } catch (Throwable th) {
                        AFLogger.afErrorLog("failed to stop Executors", th);
                    }
                    AFSensorManager r7 = AFSensorManager.m27(context);
                    r7.f41.post(r7.f50);
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: ɩ  reason: contains not printable characters */
    private static void m67(android.content.Context r4) {
        /*
            boolean r0 = com.appsflyer.AndroidUtils.m33()
            if (r0 == 0) goto L_0x000e
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r1)
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00c1
            java.lang.String r0 = "keyPropDisableAFKeystore"
            boolean r0 = m91((java.lang.String) r0)
            if (r0 != 0) goto L_0x00c1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "OS SDK is="
            r0.<init>(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0.append(r1)
            java.lang.String r1 = "; use KeyStore"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r1 = r0.m13()
            if (r1 != 0) goto L_0x0055
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.ae.m127(r1)
            r0.f35 = r4
            r4 = 0
            r0.f33 = r4
            java.lang.String r4 = r0.m14()
            r0.m15(r4)
            goto L_0x009f
        L_0x0055:
            java.lang.String r4 = r0.m14()
            java.lang.Object r1 = r0.f31
            monitor-enter(r1)
            int r2 = r0.f33     // Catch:{ all -> 0x00be }
            int r2 = r2 + 1
            r0.f33 = r2     // Catch:{ all -> 0x00be }
            java.lang.String r2 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00be }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x00be }
            java.lang.Object r2 = r0.f31     // Catch:{ KeyStoreException -> 0x007c }
            monitor-enter(r2)     // Catch:{ KeyStoreException -> 0x007c }
            java.security.KeyStore r3 = r0.f34     // Catch:{ all -> 0x0079 }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x0079 }
            monitor-exit(r2)     // Catch:{ all -> 0x0079 }
            goto L_0x0097
        L_0x0079:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ KeyStoreException -> 0x007c }
            throw r4     // Catch:{ KeyStoreException -> 0x007c }
        L_0x007c:
            r4 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "Exception "
            r2.<init>(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x00be }
            r2.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = " occurred"
            r2.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00be }
            com.appsflyer.AFLogger.afErrorLog(r2, r4)     // Catch:{ all -> 0x00be }
        L_0x0097:
            monitor-exit(r1)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r0.m14()
            r0.m15(r4)
        L_0x009f:
            java.lang.String r4 = r0.m12()
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "KSAppsFlyerId"
            r1.set((java.lang.String) r2, (java.lang.String) r4)
            int r4 = r0.m16()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "KSAppsFlyerRICounter"
            r0.set((java.lang.String) r1, (java.lang.String) r4)
            return
        L_0x00be:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L_0x00c1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r4.append(r0)
            java.lang.String r0 = "; no KeyStore usage"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afRDLog(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m67(android.content.Context):void");
    }

    public void setPhoneNumber(String str) {
        this.f93 = z.m212(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final void m104(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences sharedPreferences = getSharedPreferences(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
            long j = this.f70 - this.f82;
            HashMap hashMap = new HashMap();
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (string == null) {
                AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            }
            w r6 = v.m203(weakReference.get().getContentResolver());
            if (r6 != null) {
                hashMap.put("amazon_aid", r6.f303);
                hashMap.put("amazon_aid_limit", String.valueOf(r6.m205()));
            }
            String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
            if (string3 != null) {
                hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put("devkey", string);
            hashMap.put("uid", ae.m127(weakReference));
            hashMap.put("time_in_app", String.valueOf(j / 1000));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", StringSet.Android);
            hashMap.put("launch_counter", Integer.toString(getLaunchCounter(sharedPreferences, false)));
            hashMap.put("channel", getConfiguredChannel(weakReference.get()));
            if (string2 == null) {
                string2 = "";
            }
            hashMap.put("originalAppsflyerId", string2);
            if (this.f76) {
                try {
                    AFLogger.afDebugLog("Running callStats task");
                    new Thread(new ad((BackgroundEvent) new Stats().trackingStopped(isTrackingStopped()).params(hashMap).urlString(ServerConfigHandler.getUrl("https://%sstats.%s/stats")))).start();
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Could not send callStats request", th);
                }
            } else {
                AFLogger.afDebugLog("Stats call is disabled, ignore ...");
            }
        }
    }

    @Deprecated
    public void trackAppLaunch(Context context, String str) {
        if (GoogleReferrer.allow(this, context)) {
            if (this.f83 == null) {
                this.f83 = new GoogleReferrer();
                AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                this.f83.start(context, new Runnable() {
                    public final void run() {
                        try {
                            AFLogger.afDebugLog("Install Referrer collected locally");
                            AppsFlyerLibCore.m77(AppsFlyerLibCore.this);
                        } catch (Throwable th) {
                            AFLogger.afErrorLog(th.getMessage(), th);
                        }
                    }
                });
            } else {
                AFLogger.afWarnLog("GoogleReferrer instance already created");
            }
        }
        m42(context, str, "", (Intent) null);
    }

    /* access modifiers changed from: protected */
    public void setDeepLinkData(Intent intent) {
        if (intent != null) {
            try {
                if ("android.intent.action.VIEW".equals(intent.getAction())) {
                    this.latestDeepLink = intent.getData();
                    StringBuilder sb = new StringBuilder("Unity setDeepLinkData = ");
                    sb.append(this.latestDeepLink);
                    AFLogger.afDebugLog(sb.toString());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while setting deeplink data (unity). ", th);
            }
        }
    }

    public void setPluginDeepLinkData(Intent intent) {
        setDeepLinkData(intent);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        HashMap hashMap;
        AFEvent context2 = new InAppEvent().context(context);
        context2.f21 = str;
        if (map == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(map);
        }
        context2.f17 = hashMap;
        context2.f12 = appsFlyerTrackingRequestListener;
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = new JSONObject(context2.f17 == null ? new HashMap() : context2.f17).toString();
        aiVar.m144("public_api_call", "trackEvent", strArr);
        if (str != null) {
            AFSensorManager r8 = AFSensorManager.m27(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (r8.f47 != 0) {
                r8.f42++;
                if (r8.f47 - currentTimeMillis < 500) {
                    r8.f41.removeCallbacks(r8.f51);
                    r8.f41.post(r8.f46);
                }
            } else {
                r8.f41.post(r8.f50);
                r8.f41.post(r8.f46);
            }
            r8.f47 = currentTimeMillis;
        }
        m101(context2);
    }

    public void sendAdRevenue(Context context, Map<String, Object> map) {
        AFEvent context2 = new AdRevenue().context(context);
        context2.f17 = map;
        Context context3 = context2.context();
        String url = ServerConfigHandler.getUrl(f65);
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(context3.getPackageName());
        String obj = sb.toString();
        SharedPreferences sharedPreferences = getSharedPreferences(context3);
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        int r4 = m51(sharedPreferences, "appsFlyerAdRevenueCount", true);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", context2.f17);
        hashMap.put("adrevenue_counter", Integer.valueOf(r4));
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        hashMap.put("af_key", string);
        hashMap.put("launch_counter", Integer.valueOf(launchCounter));
        hashMap.put("af_timestamp", Long.toString(new Date().getTime()));
        hashMap.put("uid", ae.m127(new WeakReference(context3)));
        String string2 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        hashMap.put("advertiserIdEnabled", AppsFlyerProperties.getInstance().getString("advertiserIdEnabled"));
        if (string2 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string2);
        }
        hashMap.put(AppConstants.TAG_DEVICE, Build.DEVICE);
        m60(context3, (Map<String, Object>) hashMap);
        try {
            PackageInfo packageInfo = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            long j = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("install_date", simpleDateFormat.format(new Date(j)));
            String string3 = sharedPreferences.getString("appsFlyerFirstInstall", (String) null);
            if (string3 == null) {
                string3 = m84(simpleDateFormat, context3);
            }
            hashMap.put("first_launch_date", string3);
        } catch (Throwable th) {
            AFLogger.afErrorLog("AdRevenue - Exception while collecting app version data ", th);
        }
        AFEvent r12 = context2.urlString(obj).params(hashMap).m4();
        r12.f11 = launchCounter;
        m68(AFExecutor.getInstance().m8(), new a(this, r12.key(string), (byte) 0), 1, TimeUnit.MILLISECONDS);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map) {
        trackEvent(context, str, map, (AppsFlyerTrackingRequestListener) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* renamed from: ǃ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m101(com.appsflyer.AFEvent r7) {
        /*
            r6 = this;
            android.content.Context r0 = r7.context()
            boolean r1 = r0 instanceof android.app.Activity
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x001c
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            android.content.Intent r3 = r1.getIntent()
            android.net.Uri r1 = com.appsflyer.internal.ActivityCompat.getReferrer(r1)
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = r1.toString()
            goto L_0x001e
        L_0x001c:
            r3 = 0
        L_0x001d:
            r1 = r2
        L_0x001e:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = "AppsFlyerKey"
            java.lang.String r4 = r4.getString(r5)
            if (r4 != 0) goto L_0x0030
            java.lang.String r7 = "[TrackEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r7)
            return
        L_0x0030:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r4.getReferrer(r0)
            if (r0 != 0) goto L_0x003b
            r0 = r2
        L_0x003b:
            r7.f8 = r0
            r7.f9 = r3
            r7.f19 = r1
            r6.m76((com.appsflyer.AFEvent) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m101(com.appsflyer.AFEvent):void");
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final void m103(Context context, String str) {
        if (m89()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string == null) {
            AFLogger.afWarnLog("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            hashMap.put("app_version_name", packageInfo.versionName);
            hashMap.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j = packageInfo.firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("installDate", simpleDateFormat.format(new Date(j)));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        m86(context, (Map<String, ? super String>) hashMap);
        String string2 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string2 != null) {
            hashMap.put("appUserId", string2);
        }
        try {
            hashMap.put("model", Build.MODEL);
            hashMap.put(CLPConstants.BRAND_PARAMS, Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        w r2 = v.m203(context.getContentResolver());
        if (r2 != null) {
            hashMap.put("amazon_aid", r2.f303);
            hashMap.put("amazon_aid_limit", String.valueOf(r2.m205()));
        }
        String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string3 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
        }
        hashMap.put("devkey", string);
        hashMap.put("uid", ae.m127(new WeakReference(context)));
        hashMap.put("af_gcm_token", str);
        hashMap.put("launch_counter", Integer.toString(getLaunchCounter(getSharedPreferences(context), false)));
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String configuredChannel = getConfiguredChannel(context);
        if (configuredChannel != null) {
            hashMap.put("channel", configuredChannel);
        }
        try {
            AFEvent context2 = new UninstallTokenEvent().trackingStopped(isTrackingStopped()).params(hashMap).context(context);
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(REGISTER_URL));
            sb.append(packageName);
            new Thread(new ad((BackgroundEvent) context2.urlString(sb.toString()))).start();
        } catch (Throwable th3) {
            AFLogger.afErrorLog(th3.getMessage(), th3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ı  reason: contains not printable characters */
    public static Map<String, Object> m39(Context context) throws y {
        String string = getSharedPreferences(context).getString("attributionId", (String) null);
        if (string != null && string.length() > 0) {
            return m66(string);
        }
        throw new y();
    }

    /* access modifiers changed from: protected */
    public void getConversionData(Context context, final ConversionDataListener conversionDataListener) {
        f62 = new AppsFlyerConversionListener() {
            public final void onAppOpenAttribution(Map<String, String> map) {
            }

            public final void onAttributionFailure(String str) {
            }

            public final void onConversionDataSuccess(Map<String, Object> map) {
                StringBuilder sb = new StringBuilder("Calling onConversionDataLoaded with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                ConversionDataListener.this.onConversionDataLoaded(map);
            }

            public final void onConversionDataFail(String str) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                ConversionDataListener.this.onConversionFailure(str);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static Map<String, Object> m66(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!f67.contains(next)) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e2) {
            AFLogger.afErrorLog(e2.getMessage(), e2);
            return null;
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    private void m42(Context context, String str, String str2, Intent intent) {
        AFEvent context2 = new Launch().context(context);
        context2.f21 = null;
        AFEvent key = context2.key(str);
        key.f17 = null;
        key.f8 = str2;
        key.f9 = intent;
        key.f19 = null;
        m76(key);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private void m76(AFEvent aFEvent) {
        aFEvent.m4();
        boolean z = aFEvent.f21 == null;
        if (m89()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        if (z) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            } else if (m79()) {
                return;
            }
            this.f74 = System.currentTimeMillis();
        }
        m68(AFExecutor.getInstance().m8(), new e(this, aFEvent.weakContext(), (byte) 0), 150, TimeUnit.MILLISECONDS);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean m79() {
        if (this.f74 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f74;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            long j = this.f74;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date(j));
            long j2 = this.f68;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format2 = simpleDateFormat.format(new Date(j2));
            if (currentTimeMillis < this.f81 && !isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.f81)}));
                return true;
            } else if (!isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isTrackingStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ı  reason: contains not printable characters */
    public void m43(AFEvent aFEvent) {
        String str;
        ScheduledExecutorService scheduledExecutorService;
        Context context = aFEvent.context();
        String str2 = aFEvent.f21;
        if (context == null) {
            AFLogger.afDebugLog("sendTrackingWithEvent - got null context. skipping event/launch.");
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("sendTrackingWithEvent from activity: ");
            sb.append(context.getClass().getName());
            AFLogger.afInfoLog(sb.toString());
        }
        boolean z = false;
        boolean z2 = str2 == null;
        boolean z3 = aFEvent instanceof BackgroundReferrerLaunch;
        boolean z4 = aFEvent instanceof Attr;
        aFEvent.f10 = z2;
        Map<String, Object> r7 = m102(aFEvent);
        String str3 = (String) r7.get("appsflyerKey");
        if (str3 == null || str3.length() == 0) {
            AFLogger.afDebugLog("Not sending data yet, waiting for dev key");
            return;
        }
        if (!isTrackingStopped()) {
            AFLogger.afInfoLog("AppsFlyerLib.sendTrackingWithEvent");
        }
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        if (z4 || z3) {
            str = ServerConfigHandler.getUrl(REFERRER_TRACKING_URL);
        } else if (!z2) {
            str = ServerConfigHandler.getUrl(f64);
        } else if (launchCounter < 2) {
            str = ServerConfigHandler.getUrl(FIRST_LAUNCHES_URL);
        } else {
            str = ServerConfigHandler.getUrl(f63);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(context.getPackageName());
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append("&buildnumber=5.4.0");
        String obj2 = sb3.toString();
        String configuredChannel = getConfiguredChannel(context);
        if (configuredChannel != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj2);
            sb4.append("&channel=");
            sb4.append(configuredChannel);
            obj2 = sb4.toString();
        }
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) && r7.get(ServerParameters.ADVERTISING_ID_PARAM) != null) {
            try {
                if (TextUtils.isEmpty(this.f86) && r7.remove(UpiContract.DeviceInfoColumns.ANDROID_ID) != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                }
                if (TextUtils.isEmpty(this.f85) && r7.remove("imei") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                }
            } catch (Exception e2) {
                AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e2);
            }
        }
        AFEvent r10 = aFEvent.urlString(obj2).params(r7).m4();
        r10.f11 = launchCounter;
        a aVar = new a(this, r10, (byte) 0);
        if (z2) {
            if (GoogleReferrer.allow(this, context) && !m69()) {
                AFLogger.afDebugLog("Failed to get new referrer, wait ...");
                z = true;
            }
            HuaweiReferrer huaweiReferrer = this.f92;
            if (huaweiReferrer != null && huaweiReferrer.valid()) {
                z = true;
            }
            if (this.f89 && !m46()) {
                AFLogger.afDebugLog("fetching Facebook deferred AppLink data, wait ...");
                z = true;
            }
            if (this.f91 && !m95()) {
                z = true;
            }
        }
        if (AFDeepLinkManager.f2) {
            AFLogger.afRDLog("ESP deeplink: execute launch on SerialExecutor");
            AFExecutor instance2 = AFExecutor.getInstance();
            if (instance2.f25 == null) {
                instance2.f25 = Executors.newSingleThreadScheduledExecutor(instance2.f24);
            }
            scheduledExecutorService = instance2.f25;
        } else {
            scheduledExecutorService = AFExecutor.getInstance().m8();
        }
        m68(scheduledExecutorService, aVar, z ? 500 : 0, TimeUnit.MILLISECONDS);
    }

    /* renamed from: ı  reason: contains not printable characters */
    private boolean m48(AFEvent aFEvent, SharedPreferences sharedPreferences) {
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        return (!sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false) && launchCounter == 1) || (launchCounter == 1 && !(aFEvent instanceof Attr));
    }

    /* access modifiers changed from: private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public boolean m69() {
        GoogleReferrer googleReferrer = this.f83;
        return googleReferrer != null && googleReferrer.oldMap.size() > 0;
    }

    /* renamed from: ı  reason: contains not printable characters */
    private boolean m46() {
        Map<String, Object> map = this.f84;
        return map != null && !map.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: і  reason: contains not printable characters */
    public boolean m95() {
        Map<String, Object> map = this.f87;
        return map != null && !map.isEmpty();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|8|(3:10|(1:12)(1:13)|14)(1:15)|16|17|18|(1:20)|21|22|(1:24)|25|(1:27)|28|(1:30)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x009f */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02e9 A[Catch:{ Exception -> 0x0302, all -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02fc A[Catch:{ Exception -> 0x0302, all -> 0x029d }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0343 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0349 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x037f A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0396 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0428 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x043d A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x043e A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0452 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x045f A[SYNTHETIC, Splitter:B:207:0x045f] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x047d A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x048c A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0499 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x049f A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x04b6 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x04ce A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x04e5 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0513 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x052f A[SYNTHETIC, Splitter:B:244:0x052f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bb A[Catch:{ Exception -> 0x00db, all -> 0x0b91 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x054e A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0561  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0568 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c8 A[Catch:{ Exception -> 0x00db, all -> 0x0b91 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x05f4 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x060a A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0627 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d5 A[Catch:{ Exception -> 0x00db, all -> 0x0b91 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0668 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x0672 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0688 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0696 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x0698 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x069b A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x069f A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x06d4 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:352:0x06f3 A[Catch:{ Exception -> 0x06f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0120 A[Catch:{ Exception -> 0x00db, all -> 0x0b91 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x07ad A[Catch:{ all -> 0x081a }] */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x084a A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0853 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x0882 A[SYNTHETIC, Splitter:B:419:0x0882] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x08c9 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x08ef A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x0926 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:441:0x0928 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0947 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0959 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x095a A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x0995 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:476:0x0b04 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:479:0x0b1e A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x0b83 A[Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d, all -> 0x0b8f }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0227 A[Catch:{ Exception -> 0x00db, all -> 0x0b91 }] */
    /* renamed from: ɩ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> m102(com.appsflyer.AFEvent r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            java.lang.String r3 = "appid"
            java.lang.String r4 = "INSTALL_STORE"
            java.lang.String r5 = "prev_event_name"
            java.lang.String r6 = "preInstallName"
            android.content.Context r7 = r26.context()
            java.lang.String r8 = r26.key()
            java.lang.String r9 = r2.f21
            org.json.JSONObject r10 = new org.json.JSONObject
            java.util.Map<java.lang.String, java.lang.Object> r11 = r2.f17
            if (r11 != 0) goto L_0x0022
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            goto L_0x0024
        L_0x0022:
            java.util.Map<java.lang.String, java.lang.Object> r11 = r2.f17
        L_0x0024:
            r10.<init>(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = r2.f8
            android.content.SharedPreferences r12 = getSharedPreferences(r7)
            boolean r13 = r26.m5()
            android.content.Intent r14 = r26.intent()
            java.lang.String r2 = r2.f19
            java.util.HashMap r15 = new java.util.HashMap
            r15.<init>()
            com.appsflyer.internal.v.m204(r7, r15)
            java.util.Date r16 = new java.util.Date
            r16.<init>()
            r26 = r2
            r17 = r3
            long r2 = r16.getTime()
            r16 = r14
            java.lang.String r14 = java.lang.Long.toString(r2)
            r18 = r8
            java.lang.String r8 = "af_timestamp"
            r15.put(r8, r14)
            java.lang.String r2 = com.appsflyer.internal.c.m161(r7, r2)
            if (r2 == 0) goto L_0x0068
            java.lang.String r3 = "cksm_v1"
            r15.put(r3, r2)
        L_0x0068:
            boolean r2 = r25.isTrackingStopped()     // Catch:{ all -> 0x0b91 }
            if (r2 != 0) goto L_0x0086
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b91 }
            java.lang.String r3 = "******* sendTrackingWithEvent: "
            r2.<init>(r3)     // Catch:{ all -> 0x0b91 }
            if (r13 == 0) goto L_0x007a
            java.lang.String r3 = "Launch"
            goto L_0x007b
        L_0x007a:
            r3 = r9
        L_0x007b:
            r2.append(r3)     // Catch:{ all -> 0x0b91 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0b91 }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x0b91 }
            goto L_0x008b
        L_0x0086:
            java.lang.String r2 = "SDK tracking has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x0b91 }
        L_0x008b:
            com.appsflyer.internal.aa.m116()     // Catch:{ all -> 0x0b91 }
            java.io.File r2 = com.appsflyer.internal.aa.m119(r7)     // Catch:{ Exception -> 0x009f }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x009f }
            if (r2 != 0) goto L_0x009f
            java.io.File r2 = com.appsflyer.internal.aa.m119(r7)     // Catch:{ Exception -> 0x009f }
            r2.mkdir()     // Catch:{ Exception -> 0x009f }
        L_0x009f:
            android.content.pm.PackageManager r2 = r7.getPackageManager()     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = r7.getPackageName()     // Catch:{ Exception -> 0x00db }
            r14 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r14)     // Catch:{ Exception -> 0x00db }
            java.lang.String[] r2 = r2.requestedPermissions     // Catch:{ Exception -> 0x00db }
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ Exception -> 0x00db }
            java.lang.String r3 = "android.permission.INTERNET"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x00db }
            if (r3 != 0) goto L_0x00c0
            java.lang.String r3 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r3)     // Catch:{ Exception -> 0x00db }
        L_0x00c0:
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x00db }
            if (r3 != 0) goto L_0x00cd
            java.lang.String r3 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r3)     // Catch:{ Exception -> 0x00db }
        L_0x00cd:
            java.lang.String r3 = "android.permission.ACCESS_WIFI_STATE"
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x00db }
            if (r2 != 0) goto L_0x00e2
            java.lang.String r2 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r2)     // Catch:{ Exception -> 0x00db }
            goto L_0x00e2
        L_0x00db:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ all -> 0x0b91 }
        L_0x00e2:
            java.lang.String r2 = "af_events_api"
            java.lang.String r3 = "1"
            r15.put(r2, r3)     // Catch:{ all -> 0x0b91 }
            java.lang.String r2 = "brand"
            java.lang.String r3 = android.os.Build.BRAND     // Catch:{ all -> 0x0b91 }
            r15.put(r2, r3)     // Catch:{ all -> 0x0b91 }
            java.lang.String r2 = "device"
            java.lang.String r3 = android.os.Build.DEVICE     // Catch:{ all -> 0x0b91 }
            r15.put(r2, r3)     // Catch:{ all -> 0x0b91 }
            java.lang.String r2 = "product"
            java.lang.String r3 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0b91 }
            r15.put(r2, r3)     // Catch:{ all -> 0x0b91 }
            java.lang.String r2 = "sdk"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0b91 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0b91 }
            r15.put(r2, r3)     // Catch:{ all -> 0x0b91 }
            java.lang.String r2 = "model"
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ all -> 0x0b91 }
            r15.put(r2, r3)     // Catch:{ all -> 0x0b91 }
            java.lang.String r2 = "deviceType"
            java.lang.String r3 = android.os.Build.TYPE     // Catch:{ all -> 0x0b91 }
            r15.put(r2, r3)     // Catch:{ all -> 0x0b91 }
            m60((android.content.Context) r7, (java.util.Map<java.lang.String, java.lang.Object>) r15)     // Catch:{ all -> 0x0b91 }
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b91 }
            if (r13 == 0) goto L_0x0227
            boolean r5 = m96((android.content.Context) r7)     // Catch:{ all -> 0x0b91 }
            if (r5 == 0) goto L_0x0170
            boolean r5 = r2.isOtherSdkStringDisabled()     // Catch:{ all -> 0x0b91 }
            if (r5 != 0) goto L_0x0139
            float r5 = m93((android.content.Context) r7)     // Catch:{ all -> 0x0b91 }
            java.lang.String r14 = "batteryLevel"
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0b91 }
            r15.put(r14, r5)     // Catch:{ all -> 0x0b91 }
        L_0x0139:
            m67((android.content.Context) r7)     // Catch:{ all -> 0x0b91 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0b91 }
            r14 = 23
            if (r5 < r14) goto L_0x014b
            java.lang.Class<android.app.UiModeManager> r5 = android.app.UiModeManager.class
            java.lang.Object r5 = r7.getSystemService(r5)     // Catch:{ all -> 0x0b91 }
            android.app.UiModeManager r5 = (android.app.UiModeManager) r5     // Catch:{ all -> 0x0b91 }
            goto L_0x0153
        L_0x014b:
            java.lang.String r5 = "uimode"
            java.lang.Object r5 = r7.getSystemService(r5)     // Catch:{ all -> 0x0b91 }
            android.app.UiModeManager r5 = (android.app.UiModeManager) r5     // Catch:{ all -> 0x0b91 }
        L_0x0153:
            if (r5 == 0) goto L_0x0163
            int r5 = r5.getCurrentModeType()     // Catch:{ all -> 0x0b91 }
            r14 = 4
            if (r5 != r14) goto L_0x0163
            java.lang.String r5 = "tv"
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0b91 }
            r15.put(r5, r14)     // Catch:{ all -> 0x0b91 }
        L_0x0163:
            boolean r5 = com.appsflyer.internal.instant.AFInstantApps.isInstantApp(r7)     // Catch:{ all -> 0x0b91 }
            if (r5 == 0) goto L_0x0170
            java.lang.String r5 = "inst_app"
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0b91 }
            r15.put(r5, r14)     // Catch:{ all -> 0x0b91 }
        L_0x0170:
            java.lang.String r5 = "timepassedsincelastlaunch"
            android.content.SharedPreferences r14 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b91 }
            java.lang.String r3 = "AppsFlyerTimePassedSincePrevLaunch"
            r20 = r8
            r19 = r9
            r8 = 0
            long r21 = r14.getLong(r3, r8)     // Catch:{ all -> 0x0b91 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0b91 }
            java.lang.String r3 = "AppsFlyerTimePassedSincePrevLaunch"
            m85(r7, r3, r8)     // Catch:{ all -> 0x0b91 }
            r23 = 0
            int r3 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r3 <= 0) goto L_0x0198
            long r8 = r8 - r21
            r21 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r21
            goto L_0x019a
        L_0x0198:
            r8 = -1
        L_0x019a:
            java.lang.String r3 = java.lang.Long.toString(r8)     // Catch:{ all -> 0x0b91 }
            r15.put(r5, r3)     // Catch:{ all -> 0x0b91 }
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b91 }
            java.lang.String r5 = "oneLinkSlug"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ all -> 0x0b91 }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b91 }
            java.lang.String r8 = "onelinkVersion"
            java.lang.String r5 = r5.getString(r8)     // Catch:{ all -> 0x0b91 }
            if (r3 == 0) goto L_0x01bc
            java.lang.String r8 = "onelink_id"
            r15.put(r8, r3)     // Catch:{ all -> 0x0b91 }
        L_0x01bc:
            if (r5 == 0) goto L_0x01c3
            java.lang.String r3 = "onelink_ver"
            r15.put(r3, r5)     // Catch:{ all -> 0x0b91 }
        L_0x01c3:
            java.lang.String r3 = "appsflyerGetConversionDataTiming"
            r8 = 0
            long r21 = r12.getLong(r3, r8)     // Catch:{ all -> 0x0b91 }
            int r3 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x01e6
            java.lang.String r3 = "gcd_timing"
            java.lang.String r5 = java.lang.Long.toString(r21)     // Catch:{ all -> 0x0b91 }
            r15.put(r3, r5)     // Catch:{ all -> 0x0b91 }
            java.lang.String r3 = "appsflyerGetConversionDataTiming"
            android.content.SharedPreferences$Editor r5 = r12.edit()     // Catch:{ all -> 0x0b91 }
            r8 = 0
            r5.putLong(r3, r8)     // Catch:{ all -> 0x0b91 }
            r5.apply()     // Catch:{ all -> 0x0b91 }
        L_0x01e6:
            java.lang.String r3 = r1.f93     // Catch:{ all -> 0x0b91 }
            if (r3 == 0) goto L_0x01f1
            java.lang.String r3 = "phone"
            java.lang.String r5 = r1.f93     // Catch:{ all -> 0x0b91 }
            r15.put(r3, r5)     // Catch:{ all -> 0x0b91 }
        L_0x01f1:
            boolean r3 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0b91 }
            java.lang.String r5 = "referrer"
            if (r3 != 0) goto L_0x01fc
            r15.put(r5, r11)     // Catch:{ all -> 0x0b91 }
        L_0x01fc:
            java.lang.String r3 = "extraReferrers"
            r8 = 0
            java.lang.String r3 = r12.getString(r3, r8)     // Catch:{ all -> 0x0b91 }
            if (r3 == 0) goto L_0x020a
            java.lang.String r8 = "extraReferrers"
            r15.put(r8, r3)     // Catch:{ all -> 0x0b91 }
        L_0x020a:
            java.lang.String r3 = r2.getReferrer(r7)     // Catch:{ all -> 0x0b91 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0b91 }
            if (r8 != 0) goto L_0x021d
            java.lang.Object r8 = r15.get(r5)     // Catch:{ all -> 0x0b91 }
            if (r8 != 0) goto L_0x021d
            r15.put(r5, r3)     // Catch:{ all -> 0x0b91 }
        L_0x021d:
            r23 = r2
            r22 = r12
            r21 = r13
            r1 = r19
            goto L_0x02b1
        L_0x0227:
            r20 = r8
            r19 = r9
            android.content.SharedPreferences r3 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b91 }
            android.content.SharedPreferences$Editor r8 = r3.edit()     // Catch:{ all -> 0x0b91 }
            r9 = 0
            java.lang.String r11 = r3.getString(r5, r9)     // Catch:{ Exception -> 0x02a2 }
            java.lang.String r9 = "prev_event_timestamp"
            java.lang.String r14 = "prev_event_value"
            if (r11 == 0) goto L_0x0282
            r21 = r13
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x0279 }
            r13.<init>()     // Catch:{ Exception -> 0x0279 }
            r22 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0275 }
            r12.<init>()     // Catch:{ Exception -> 0x0275 }
            r23 = r2
            r1 = -1
            long r1 = r3.getLong(r9, r1)     // Catch:{ Exception -> 0x0273 }
            r12.append(r1)     // Catch:{ Exception -> 0x0273 }
            java.lang.String r1 = r12.toString()     // Catch:{ Exception -> 0x0273 }
            r13.put(r9, r1)     // Catch:{ Exception -> 0x0273 }
            r1 = 0
            java.lang.String r2 = r3.getString(r14, r1)     // Catch:{ Exception -> 0x0273 }
            r13.put(r14, r2)     // Catch:{ Exception -> 0x0273 }
            r13.put(r5, r11)     // Catch:{ Exception -> 0x0273 }
            java.lang.String r1 = "prev_event"
            java.lang.String r2 = r13.toString()     // Catch:{ Exception -> 0x0273 }
            r15.put(r1, r2)     // Catch:{ Exception -> 0x0273 }
            goto L_0x0288
        L_0x0273:
            r0 = move-exception
            goto L_0x027e
        L_0x0275:
            r0 = move-exception
            r23 = r2
            goto L_0x027e
        L_0x0279:
            r0 = move-exception
            r23 = r2
            r22 = r12
        L_0x027e:
            r2 = r0
            r1 = r19
            goto L_0x02ac
        L_0x0282:
            r23 = r2
            r22 = r12
            r21 = r13
        L_0x0288:
            r1 = r19
            r8.putString(r5, r1)     // Catch:{ Exception -> 0x029b }
            r8.putString(r14, r10)     // Catch:{ Exception -> 0x029b }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x029b }
            r8.putLong(r9, r2)     // Catch:{ Exception -> 0x029b }
            r8.apply()     // Catch:{ Exception -> 0x029b }
            goto L_0x02b1
        L_0x029b:
            r0 = move-exception
            goto L_0x02ab
        L_0x029d:
            r0 = move-exception
            r2 = r25
            goto L_0x0b93
        L_0x02a2:
            r0 = move-exception
            r23 = r2
            r22 = r12
            r21 = r13
            r1 = r19
        L_0x02ab:
            r2 = r0
        L_0x02ac:
            java.lang.String r3 = "Error while processing previous event."
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ all -> 0x029d }
        L_0x02b1:
            java.lang.String r2 = "KSAppsFlyerId"
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x029d }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x029d }
            java.lang.String r3 = "KSAppsFlyerRICounter"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x029d }
            java.lang.String r3 = r5.getString(r3)     // Catch:{ all -> 0x029d }
            if (r2 == 0) goto L_0x02dd
            if (r3 == 0) goto L_0x02dd
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x029d }
            int r5 = r5.intValue()     // Catch:{ all -> 0x029d }
            if (r5 <= 0) goto L_0x02dd
            java.lang.String r5 = "reinstallCounter"
            r15.put(r5, r3)     // Catch:{ all -> 0x029d }
            java.lang.String r3 = "originalAppsflyerId"
            r15.put(r3, r2)     // Catch:{ all -> 0x029d }
        L_0x02dd:
            java.lang.String r2 = "additionalCustomData"
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x029d }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x029d }
            if (r2 == 0) goto L_0x02ee
            java.lang.String r3 = "customData"
            r15.put(r3, r2)     // Catch:{ all -> 0x029d }
        L_0x02ee:
            android.content.pm.PackageManager r2 = r7.getPackageManager()     // Catch:{ Exception -> 0x0302 }
            java.lang.String r3 = r7.getPackageName()     // Catch:{ Exception -> 0x0302 }
            java.lang.String r2 = r2.getInstallerPackageName(r3)     // Catch:{ Exception -> 0x0302 }
            if (r2 == 0) goto L_0x0309
            java.lang.String r3 = "installer_package"
            r15.put(r3, r2)     // Catch:{ Exception -> 0x0302 }
            goto L_0x0309
        L_0x0302:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r3, r2)     // Catch:{ all -> 0x029d }
        L_0x0309:
            java.lang.String r2 = "sdkExtension"
            r3 = r23
            java.lang.String r2 = r3.getString(r2)     // Catch:{ all -> 0x029d }
            if (r2 == 0) goto L_0x031e
            int r5 = r2.length()     // Catch:{ all -> 0x029d }
            if (r5 <= 0) goto L_0x031e
            java.lang.String r5 = "sdkExtension"
            r15.put(r5, r2)     // Catch:{ all -> 0x029d }
        L_0x031e:
            r2 = r25
            java.lang.String r5 = r2.getConfiguredChannel(r7)     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = m53((android.content.Context) r7, (java.lang.String) r5)     // Catch:{ all -> 0x0b8f }
            if (r8 == 0) goto L_0x0330
            boolean r9 = r8.equals(r5)     // Catch:{ all -> 0x0b8f }
            if (r9 == 0) goto L_0x0334
        L_0x0330:
            if (r8 != 0) goto L_0x0339
            if (r5 == 0) goto L_0x0339
        L_0x0334:
            java.lang.String r8 = "af_latestchannel"
            r15.put(r8, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0339:
            android.content.SharedPreferences r5 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b8f }
            boolean r8 = r5.contains(r4)     // Catch:{ all -> 0x0b8f }
            if (r8 == 0) goto L_0x0349
            r8 = 0
            java.lang.String r4 = r5.getString(r4, r8)     // Catch:{ all -> 0x0b8f }
            goto L_0x037d
        L_0x0349:
            boolean r5 = m96((android.content.Context) r7)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x036d
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = "api_store_value"
            java.lang.String r5 = r5.getString(r8)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x035c
            goto L_0x036e
        L_0x035c:
            java.lang.String r5 = "AF_STORE"
            if (r7 == 0) goto L_0x036d
            android.content.pm.PackageManager r8 = r7.getPackageManager()     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = r7.getPackageName()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = m64(r5, r8, r9)     // Catch:{ all -> 0x0b8f }
            goto L_0x036e
        L_0x036d:
            r5 = 0
        L_0x036e:
            android.content.SharedPreferences r8 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b8f }
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ all -> 0x0b8f }
            r8.putString(r4, r5)     // Catch:{ all -> 0x0b8f }
            r8.apply()     // Catch:{ all -> 0x0b8f }
            r4 = r5
        L_0x037d:
            if (r4 == 0) goto L_0x0388
            java.lang.String r5 = "af_installstore"
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x0b8f }
            r15.put(r5, r4)     // Catch:{ all -> 0x0b8f }
        L_0x0388:
            android.content.SharedPreferences r4 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0b8f }
            if (r5 != 0) goto L_0x0426
            boolean r8 = r4.contains(r6)     // Catch:{ all -> 0x0b8f }
            if (r8 == 0) goto L_0x03a4
            r5 = 0
            java.lang.String r4 = r4.getString(r6, r5)     // Catch:{ all -> 0x0b8f }
            r5 = r4
            goto L_0x041d
        L_0x03a4:
            boolean r4 = m96((android.content.Context) r7)     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x040d
            java.lang.String r4 = "ro.appsflyer.preinstall.path"
            java.lang.String r4 = m38((java.lang.String) r4)     // Catch:{ all -> 0x0b8f }
            java.io.File r4 = m71((java.lang.String) r4)     // Catch:{ all -> 0x0b8f }
            boolean r5 = m70((java.io.File) r4)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x03cc
            java.lang.String r4 = "AF_PRE_INSTALL_PATH"
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = r7.getPackageName()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = m64(r4, r5, r8)     // Catch:{ all -> 0x0b8f }
            java.io.File r4 = m71((java.lang.String) r4)     // Catch:{ all -> 0x0b8f }
        L_0x03cc:
            boolean r5 = m70((java.io.File) r4)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x03d8
            java.lang.String r4 = "/data/local/tmp/pre_install.appsflyer"
            java.io.File r4 = m71((java.lang.String) r4)     // Catch:{ all -> 0x0b8f }
        L_0x03d8:
            boolean r5 = m70((java.io.File) r4)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x03e4
            java.lang.String r4 = "/etc/pre_install.appsflyer"
            java.io.File r4 = m71((java.lang.String) r4)     // Catch:{ all -> 0x0b8f }
        L_0x03e4:
            boolean r5 = m70((java.io.File) r4)     // Catch:{ all -> 0x0b8f }
            if (r5 != 0) goto L_0x03f5
            java.lang.String r5 = r7.getPackageName()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = m54((java.io.File) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x03f5
            goto L_0x03f6
        L_0x03f5:
            r4 = 0
        L_0x03f6:
            if (r4 == 0) goto L_0x03fa
        L_0x03f8:
            r5 = r4
            goto L_0x040d
        L_0x03fa:
            java.lang.String r4 = "AF_PRE_INSTALL_NAME"
            if (r7 != 0) goto L_0x0400
            r5 = 0
            goto L_0x040d
        L_0x0400:
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = r7.getPackageName()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = m64(r4, r5, r8)     // Catch:{ all -> 0x0b8f }
            goto L_0x03f8
        L_0x040d:
            if (r5 == 0) goto L_0x041d
            android.content.SharedPreferences r4 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b8f }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x0b8f }
            r4.putString(r6, r5)     // Catch:{ all -> 0x0b8f }
            r4.apply()     // Catch:{ all -> 0x0b8f }
        L_0x041d:
            if (r5 == 0) goto L_0x0426
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            r4.set((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0b8f }
        L_0x0426:
            if (r5 == 0) goto L_0x0431
            java.lang.String r4 = "af_preinstall_name"
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x0b8f }
            r15.put(r4, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0431:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "api_store_value"
            java.lang.String r4 = r4.getString(r5)     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x043e
            goto L_0x0450
        L_0x043e:
            java.lang.String r4 = "AF_STORE"
            if (r7 != 0) goto L_0x0444
            r4 = 0
            goto L_0x0450
        L_0x0444:
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = r7.getPackageName()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = m64(r4, r5, r6)     // Catch:{ all -> 0x0b8f }
        L_0x0450:
            if (r4 == 0) goto L_0x045b
            java.lang.String r5 = "af_currentstore"
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x0b8f }
            r15.put(r5, r4)     // Catch:{ all -> 0x0b8f }
        L_0x045b:
            java.lang.String r4 = "appsflyerKey"
            if (r18 == 0) goto L_0x046b
            int r5 = r18.length()     // Catch:{ all -> 0x0b8f }
            if (r5 <= 0) goto L_0x046b
            r5 = r18
            r15.put(r4, r5)     // Catch:{ all -> 0x0b8f }
            goto L_0x0480
        L_0x046b:
            java.lang.String r5 = "AppsFlyerKey"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x0b83
            int r6 = r5.length()     // Catch:{ all -> 0x0b8f }
            if (r6 <= 0) goto L_0x0b83
            r15.put(r4, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0480:
            java.lang.String r5 = "AppUserId"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x0491
            java.lang.String r6 = "appUserId"
            r15.put(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0491:
            java.lang.String r5 = "userEmails"
            java.lang.String r5 = r3.getString(r5)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x049f
            java.lang.String r6 = "user_emails"
            r15.put(r6, r5)     // Catch:{ all -> 0x0b8f }
            goto L_0x04b4
        L_0x049f:
            java.lang.String r5 = "userEmail"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x04b4
            java.lang.String r6 = "sha1_el"
            java.lang.String r5 = com.appsflyer.internal.z.m213((java.lang.String) r5)     // Catch:{ all -> 0x0b8f }
            r15.put(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x04b4:
            if (r1 == 0) goto L_0x04c2
            java.lang.String r5 = "eventName"
            r15.put(r5, r1)     // Catch:{ all -> 0x0b8f }
            if (r10 == 0) goto L_0x04c2
            java.lang.String r5 = "eventValue"
            r15.put(r5, r10)     // Catch:{ all -> 0x0b8f }
        L_0x04c2:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            r6 = r17
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x04d9
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0b8f }
            r15.put(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x04d9:
            java.lang.String r5 = "currencyCode"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x0507
            int r6 = r5.length()     // Catch:{ all -> 0x0b8f }
            r8 = 3
            if (r6 == r8) goto L_0x0502
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = "WARNING: currency code should be 3 characters!!! '"
            r6.<init>(r8)     // Catch:{ all -> 0x0b8f }
            r6.append(r5)     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = "' is not a legal value."
            r6.append(r8)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ all -> 0x0b8f }
        L_0x0502:
            java.lang.String r6 = "currency"
            r15.put(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0507:
            java.lang.String r5 = "IS_UPDATE"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0b8f }
            if (r5 == 0) goto L_0x0518
            java.lang.String r6 = "isUpdate"
            r15.put(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0518:
            boolean r5 = r2.isPreInstalledApp(r7)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "af_preinstalled"
            java.lang.String r5 = java.lang.Boolean.toString(r5)     // Catch:{ all -> 0x0b8f }
            r15.put(r6, r5)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "collectFacebookAttrId"
            r6 = 1
            boolean r5 = r3.getBoolean(r5, r6)     // Catch:{ all -> 0x0b8f }
            r8 = 0
            if (r5 == 0) goto L_0x0553
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d }
            java.lang.String r9 = "com.facebook.katana"
            r5.getApplicationInfo(r9, r8)     // Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d }
            java.lang.String r5 = r2.getAttributionId(r7)     // Catch:{ NameNotFoundException -> 0x0546, all -> 0x053d }
            goto L_0x054c
        L_0x053d:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afErrorLog(r9, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0544:
            r5 = 0
            goto L_0x054c
        L_0x0546:
            java.lang.String r5 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afWarnLog(r5)     // Catch:{ all -> 0x0b8f }
            goto L_0x0544
        L_0x054c:
            if (r5 == 0) goto L_0x0553
            java.lang.String r9 = "fb"
            r15.put(r9, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0553:
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = "deviceTrackingDisabled"
            boolean r9 = r5.getBoolean(r9, r8)     // Catch:{ all -> 0x0b8f }
            java.lang.String r10 = "true"
            if (r9 == 0) goto L_0x0568
            java.lang.String r5 = "deviceTrackingDisabled"
            r15.put(r5, r10)     // Catch:{ all -> 0x0b8f }
            goto L_0x06e8
        L_0x0568:
            android.content.SharedPreferences r9 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b8f }
            java.lang.String r11 = "collectIMEI"
            boolean r11 = r5.getBoolean(r11, r6)     // Catch:{ all -> 0x0b8f }
            java.lang.String r12 = "imeiCached"
            r13 = 0
            java.lang.String r12 = r9.getString(r12, r13)     // Catch:{ all -> 0x0b8f }
            if (r11 == 0) goto L_0x05e9
            java.lang.String r11 = r2.f85     // Catch:{ all -> 0x0b8f }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0b8f }
            if (r11 == 0) goto L_0x05e9
            boolean r11 = m49((android.content.Context) r7)     // Catch:{ all -> 0x0b8f }
            if (r11 == 0) goto L_0x05f1
            java.lang.String r11 = "phone"
            java.lang.Object r11 = r7.getSystemService(r11)     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            android.telephony.TelephonyManager r11 = (android.telephony.TelephonyManager) r11     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            java.lang.Class r13 = r11.getClass()     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            java.lang.String r14 = "getDeviceId"
            java.lang.Class[] r6 = new java.lang.Class[r8]     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            java.lang.reflect.Method r6 = r13.getMethod(r14, r6)     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            java.lang.Object[] r13 = new java.lang.Object[r8]     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            java.lang.Object r6 = r6.invoke(r11, r13)     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            if (r6 == 0) goto L_0x05a8
            goto L_0x05ef
        L_0x05a8:
            if (r12 == 0) goto L_0x05f1
            java.lang.String r6 = "use cached IMEI: "
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            java.lang.String r6 = r6.concat(r11)     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ InvocationTargetException -> 0x05d1, Exception -> 0x05b8 }
            goto L_0x05f2
        L_0x05b8:
            r0 = move-exception
            r6 = r0
            if (r12 == 0) goto L_0x05ca
            java.lang.String r11 = "use cached IMEI: "
            java.lang.String r13 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0b8f }
            java.lang.String r11 = r11.concat(r13)     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afDebugLog(r11)     // Catch:{ all -> 0x0b8f }
            goto L_0x05cb
        L_0x05ca:
            r12 = 0
        L_0x05cb:
            java.lang.String r11 = "WARNING: other reason: "
            com.appsflyer.AFLogger.afErrorLog(r11, r6)     // Catch:{ all -> 0x0b8f }
            goto L_0x05f2
        L_0x05d1:
            if (r12 == 0) goto L_0x05e2
            java.lang.String r6 = "use cached IMEI: "
            java.lang.String r11 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = r6.concat(r11)     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ all -> 0x0b8f }
            goto L_0x05e3
        L_0x05e2:
            r12 = 0
        L_0x05e3:
            java.lang.String r6 = "WARNING: READ_PHONE_STATE is missing."
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ all -> 0x0b8f }
            goto L_0x05f2
        L_0x05e9:
            java.lang.String r6 = r2.f85     // Catch:{ all -> 0x0b8f }
            if (r6 == 0) goto L_0x05f1
            java.lang.String r6 = r2.f85     // Catch:{ all -> 0x0b8f }
        L_0x05ef:
            r12 = r6
            goto L_0x05f2
        L_0x05f1:
            r12 = 0
        L_0x05f2:
            if (r12 == 0) goto L_0x060a
            java.lang.String r6 = "imeiCached"
            android.content.SharedPreferences r11 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b8f }
            android.content.SharedPreferences$Editor r11 = r11.edit()     // Catch:{ all -> 0x0b8f }
            r11.putString(r6, r12)     // Catch:{ all -> 0x0b8f }
            r11.apply()     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "imei"
            r15.put(r6, r12)     // Catch:{ all -> 0x0b8f }
            goto L_0x060f
        L_0x060a:
            java.lang.String r6 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ all -> 0x0b8f }
        L_0x060f:
            java.lang.String r6 = "collectAndroidId"
            r11 = 1
            boolean r6 = r5.getBoolean(r6, r11)     // Catch:{ all -> 0x0b8f }
            java.lang.String r11 = "androidIdCached"
            r12 = 0
            java.lang.String r9 = r9.getString(r11, r12)     // Catch:{ all -> 0x0b8f }
            if (r6 == 0) goto L_0x0668
            java.lang.String r6 = r2.f86     // Catch:{ all -> 0x0b8f }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0b8f }
            if (r6 == 0) goto L_0x0668
            boolean r6 = m49((android.content.Context) r7)     // Catch:{ all -> 0x0b8f }
            if (r6 == 0) goto L_0x066f
            android.content.ContentResolver r6 = r7.getContentResolver()     // Catch:{ Exception -> 0x064c }
            java.lang.String r11 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r11)     // Catch:{ Exception -> 0x064c }
            if (r6 == 0) goto L_0x063a
            goto L_0x0670
        L_0x063a:
            if (r9 == 0) goto L_0x064a
            java.lang.String r6 = "use cached AndroidId: "
            java.lang.String r11 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x064c }
            java.lang.String r6 = r6.concat(r11)     // Catch:{ Exception -> 0x064c }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ Exception -> 0x064c }
            goto L_0x0666
        L_0x064a:
            r9 = 0
            goto L_0x0666
        L_0x064c:
            r0 = move-exception
            r6 = r0
            if (r9 == 0) goto L_0x065e
            java.lang.String r11 = "use cached AndroidId: "
            java.lang.String r12 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0b8f }
            java.lang.String r11 = r11.concat(r12)     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afDebugLog(r11)     // Catch:{ all -> 0x0b8f }
            goto L_0x065f
        L_0x065e:
            r9 = 0
        L_0x065f:
            java.lang.String r11 = r6.getMessage()     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afErrorLog(r11, r6)     // Catch:{ all -> 0x0b8f }
        L_0x0666:
            r6 = r9
            goto L_0x0670
        L_0x0668:
            java.lang.String r6 = r2.f86     // Catch:{ all -> 0x0b8f }
            if (r6 == 0) goto L_0x066f
            java.lang.String r6 = r2.f86     // Catch:{ all -> 0x0b8f }
            goto L_0x0670
        L_0x066f:
            r6 = 0
        L_0x0670:
            if (r6 == 0) goto L_0x0688
            java.lang.String r9 = "androidIdCached"
            android.content.SharedPreferences r11 = getSharedPreferences(r7)     // Catch:{ all -> 0x0b8f }
            android.content.SharedPreferences$Editor r11 = r11.edit()     // Catch:{ all -> 0x0b8f }
            r11.putString(r9, r6)     // Catch:{ all -> 0x0b8f }
            r11.apply()     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = "android_id"
            r15.put(r9, r6)     // Catch:{ all -> 0x0b8f }
            goto L_0x068d
        L_0x0688:
            java.lang.String r6 = "Android ID was not collected."
            com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ all -> 0x0b8f }
        L_0x068d:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0b8f }
            r6.<init>()     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = r2.f78     // Catch:{ all -> 0x0b8f }
            if (r9 == 0) goto L_0x0698
            r9 = 1
            goto L_0x0699
        L_0x0698:
            r9 = 0
        L_0x0699:
            if (r9 == 0) goto L_0x069f
            java.lang.String r5 = r2.f78     // Catch:{ all -> 0x0b8f }
            r11 = r5
            goto L_0x06d2
        L_0x069f:
            java.lang.String r11 = "collectOAID"
            r12 = 1
            boolean r11 = r5.getBoolean(r11, r12)     // Catch:{ all -> 0x0b8f }
            if (r11 == 0) goto L_0x06d1
            com.appsflyer.oaid.OaidClient r11 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x06ca }
            r11.<init>(r7)     // Catch:{ all -> 0x06ca }
            boolean r5 = r5.isEnableLog()     // Catch:{ all -> 0x06ca }
            r11.setLogging(r5)     // Catch:{ all -> 0x06ca }
            com.appsflyer.oaid.OaidClient$Info r5 = r11.fetch()     // Catch:{ all -> 0x06ca }
            if (r5 == 0) goto L_0x06d1
            java.lang.String r11 = r5.getId()     // Catch:{ all -> 0x06ca }
            java.lang.Boolean r5 = r5.getLat()     // Catch:{ all -> 0x06cb }
            if (r5 == 0) goto L_0x06d2
            java.lang.String r12 = "isLat"
            r6.put(r12, r5)     // Catch:{ all -> 0x06cb }
            goto L_0x06d2
        L_0x06ca:
            r11 = 0
        L_0x06cb:
            java.lang.String r5 = "No OAID library"
            com.appsflyer.AFLogger.afDebugLog(r5)     // Catch:{ all -> 0x0b8f }
            goto L_0x06d2
        L_0x06d1:
            r11 = 0
        L_0x06d2:
            if (r11 == 0) goto L_0x06e8
            java.lang.String r5 = "isManual"
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0b8f }
            r6.put(r5, r9)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "val"
            r6.put(r5, r11)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "oaid"
            r15.put(r5, r6)     // Catch:{ all -> 0x0b8f }
        L_0x06e8:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x06f9 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x06f9 }
            java.lang.String r5 = com.appsflyer.internal.ae.m127(r5)     // Catch:{ Exception -> 0x06f9 }
            if (r5 == 0) goto L_0x0710
            java.lang.String r6 = "uid"
            r15.put(r6, r5)     // Catch:{ Exception -> 0x06f9 }
            goto L_0x0710
        L_0x06f9:
            r0 = move-exception
            r5 = r0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = "ERROR: could not get uid "
            r6.<init>(r9)     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = r5.getMessage()     // Catch:{ all -> 0x0b8f }
            r6.append(r9)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afErrorLog(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0710:
            java.lang.String r5 = "lang"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x071e }
            java.lang.String r6 = r6.getDisplayLanguage()     // Catch:{ Exception -> 0x071e }
            r15.put(r5, r6)     // Catch:{ Exception -> 0x071e }
            goto L_0x0725
        L_0x071e:
            r0 = move-exception
            r5 = r0
            java.lang.String r6 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0725:
            java.lang.String r5 = "lang_code"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0733 }
            java.lang.String r6 = r6.getLanguage()     // Catch:{ Exception -> 0x0733 }
            r15.put(r5, r6)     // Catch:{ Exception -> 0x0733 }
            goto L_0x073a
        L_0x0733:
            r0 = move-exception
            r5 = r0
            java.lang.String r6 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x073a:
            java.lang.String r5 = "country"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0748 }
            java.lang.String r6 = r6.getCountry()     // Catch:{ Exception -> 0x0748 }
            r15.put(r5, r6)     // Catch:{ Exception -> 0x0748 }
            goto L_0x074f
        L_0x0748:
            r0 = move-exception
            r5 = r0
            java.lang.String r6 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r6, r5)     // Catch:{ all -> 0x0b8f }
        L_0x074f:
            java.lang.String r5 = "platformextension"
            com.appsflyer.internal.ag r6 = r2.f77     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = r6.m131()     // Catch:{ all -> 0x0b8f }
            r15.put(r5, r6)     // Catch:{ all -> 0x0b8f }
            m86((android.content.Context) r7, (java.util.Map<java.lang.String, ? super java.lang.String>) r15)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0b8f }
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0b8f }
            r6.<init>(r5, r9)     // Catch:{ all -> 0x0b8f }
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch:{ Exception -> 0x078d }
            java.lang.String r9 = r7.getPackageName()     // Catch:{ Exception -> 0x078d }
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r9, r8)     // Catch:{ Exception -> 0x078d }
            long r11 = r5.firstInstallTime     // Catch:{ Exception -> 0x078d }
            java.lang.String r5 = "installDate"
            java.lang.String r9 = "UTC"
            java.util.TimeZone r9 = java.util.TimeZone.getTimeZone(r9)     // Catch:{ Exception -> 0x078d }
            r6.setTimeZone(r9)     // Catch:{ Exception -> 0x078d }
            java.util.Date r9 = new java.util.Date     // Catch:{ Exception -> 0x078d }
            r9.<init>(r11)     // Catch:{ Exception -> 0x078d }
            java.lang.String r9 = r6.format(r9)     // Catch:{ Exception -> 0x078d }
            r15.put(r5, r9)     // Catch:{ Exception -> 0x078d }
            goto L_0x0794
        L_0x078d:
            r0 = move-exception
            r5 = r0
            java.lang.String r9 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r9, r5)     // Catch:{ all -> 0x0b8f }
        L_0x0794:
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch:{ all -> 0x0820 }
            java.lang.String r9 = r7.getPackageName()     // Catch:{ all -> 0x0820 }
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r9, r8)     // Catch:{ all -> 0x0820 }
            java.lang.String r9 = "versionCode"
            r11 = r22
            int r9 = r11.getInt(r9, r8)     // Catch:{ all -> 0x081a }
            int r12 = r5.versionCode     // Catch:{ all -> 0x081a }
            if (r12 <= r9) goto L_0x07c0
            java.lang.String r9 = "versionCode"
            int r12 = r5.versionCode     // Catch:{ all -> 0x081a }
            android.content.SharedPreferences r13 = getSharedPreferences(r7)     // Catch:{ all -> 0x081a }
            android.content.SharedPreferences$Editor r13 = r13.edit()     // Catch:{ all -> 0x081a }
            r13.putInt(r9, r12)     // Catch:{ all -> 0x081a }
            r13.apply()     // Catch:{ all -> 0x081a }
        L_0x07c0:
            java.lang.String r9 = "app_version_code"
            int r12 = r5.versionCode     // Catch:{ all -> 0x081a }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x081a }
            r15.put(r9, r12)     // Catch:{ all -> 0x081a }
            java.lang.String r9 = "app_version_name"
            java.lang.String r12 = r5.versionName     // Catch:{ all -> 0x081a }
            r15.put(r9, r12)     // Catch:{ all -> 0x081a }
            long r12 = r5.firstInstallTime     // Catch:{ all -> 0x081a }
            long r8 = r5.lastUpdateTime     // Catch:{ all -> 0x081a }
            java.lang.String r5 = "date1"
            java.lang.String r14 = "yyyy-MM-dd_HHmmssZ"
            r19 = r4
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0816 }
            r23 = r3
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ all -> 0x0814 }
            r4.<init>(r14, r3)     // Catch:{ all -> 0x0814 }
            java.util.Date r3 = new java.util.Date     // Catch:{ all -> 0x0814 }
            r3.<init>(r12)     // Catch:{ all -> 0x0814 }
            java.lang.String r3 = r4.format(r3)     // Catch:{ all -> 0x0814 }
            r15.put(r5, r3)     // Catch:{ all -> 0x0814 }
            java.lang.String r3 = "date2"
            java.lang.String r4 = "yyyy-MM-dd_HHmmssZ"
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0814 }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ all -> 0x0814 }
            r5.<init>(r4, r12)     // Catch:{ all -> 0x0814 }
            java.util.Date r4 = new java.util.Date     // Catch:{ all -> 0x0814 }
            r4.<init>(r8)     // Catch:{ all -> 0x0814 }
            java.lang.String r4 = r5.format(r4)     // Catch:{ all -> 0x0814 }
            r15.put(r3, r4)     // Catch:{ all -> 0x0814 }
            java.lang.String r3 = m84((java.text.SimpleDateFormat) r6, (android.content.Context) r7)     // Catch:{ all -> 0x0814 }
            java.lang.String r4 = "firstLaunchDate"
            r15.put(r4, r3)     // Catch:{ all -> 0x0814 }
            goto L_0x082d
        L_0x0814:
            r0 = move-exception
            goto L_0x0827
        L_0x0816:
            r0 = move-exception
            r23 = r3
            goto L_0x0827
        L_0x081a:
            r0 = move-exception
            r23 = r3
            r19 = r4
            goto L_0x0827
        L_0x0820:
            r0 = move-exception
            r23 = r3
            r19 = r4
            r11 = r22
        L_0x0827:
            r3 = r0
            java.lang.String r4 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.afErrorLog(r4, r3)     // Catch:{ all -> 0x0b8f }
        L_0x082d:
            boolean r3 = com.appsflyer.internal.af.m129(r7)     // Catch:{ all -> 0x0b8f }
            r2.f73 = r3     // Catch:{ all -> 0x0b8f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = "didConfigureTokenRefreshService="
            r3.<init>(r4)     // Catch:{ all -> 0x0b8f }
            boolean r4 = r2.f73     // Catch:{ all -> 0x0b8f }
            r3.append(r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ all -> 0x0b8f }
            boolean r3 = r2.f73     // Catch:{ all -> 0x0b8f }
            if (r3 != 0) goto L_0x0851
            java.lang.String r3 = "tokenRefreshConfigured"
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0b8f }
            r15.put(r3, r4)     // Catch:{ all -> 0x0b8f }
        L_0x0851:
            if (r21 == 0) goto L_0x087e
            com.appsflyer.AFDeepLinkManager.getInstance()     // Catch:{ all -> 0x0b8f }
            r3 = r16
            com.appsflyer.AFDeepLinkManager.m2(r3, r7, r15)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = r2.f71     // Catch:{ all -> 0x0b8f }
            if (r3 == 0) goto L_0x0874
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = r2.f71     // Catch:{ all -> 0x0b8f }
            r3.<init>(r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = "isPush"
            r3.put(r4, r10)     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = "af_deeplink"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0b8f }
            r15.put(r4, r3)     // Catch:{ all -> 0x0b8f }
        L_0x0874:
            r3 = 0
            r2.f71 = r3     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "open_referrer"
            r4 = r26
            r15.put(r3, r4)     // Catch:{ all -> 0x0b8f }
        L_0x087e:
            java.lang.String r3 = "sensors"
            if (r21 != 0) goto L_0x08bd
            com.appsflyer.AFSensorManager r4 = com.appsflyer.AFSensorManager.m27((android.content.Context) r7)     // Catch:{ Exception -> 0x08a6 }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x08a6 }
            r5.<init>()     // Catch:{ Exception -> 0x08a6 }
            java.util.List r4 = r4.m30()     // Catch:{ Exception -> 0x08a6 }
            boolean r6 = r4.isEmpty()     // Catch:{ Exception -> 0x08a6 }
            if (r6 != 0) goto L_0x089d
            java.util.Map r4 = com.appsflyer.internal.g.m183((java.util.List<java.util.Map<java.lang.String, java.lang.Object>>) r4)     // Catch:{ Exception -> 0x08a6 }
            r5.put(r3, r4)     // Catch:{ Exception -> 0x08a6 }
            goto L_0x08a2
        L_0x089d:
            java.lang.String r4 = "na"
            r5.put(r3, r4)     // Catch:{ Exception -> 0x08a6 }
        L_0x08a2:
            r15.putAll(r5)     // Catch:{ Exception -> 0x08a6 }
            goto L_0x08bd
        L_0x08a6:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "Unexpected exception from AFSensorManager: "
            r5.<init>(r6)     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0b8f }
            r5.append(r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0b8f }
            com.appsflyer.AFLogger.afRDLog(r4)     // Catch:{ all -> 0x0b8f }
        L_0x08bd:
            java.lang.String r4 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0b8f }
            if (r4 != 0) goto L_0x08e5
            com.appsflyer.internal.v.m204(r7, r15)     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x08de
            java.lang.String r4 = "GAID_retry"
            r15.put(r4, r10)     // Catch:{ all -> 0x0b8f }
            goto L_0x08e5
        L_0x08de:
            java.lang.String r4 = "GAID_retry"
            java.lang.String r5 = "false"
            r15.put(r4, r5)     // Catch:{ all -> 0x0b8f }
        L_0x08e5:
            android.content.ContentResolver r4 = r7.getContentResolver()     // Catch:{ all -> 0x0b8f }
            com.appsflyer.internal.w r4 = com.appsflyer.internal.v.m203(r4)     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x0903
            java.lang.String r5 = "amazon_aid"
            java.lang.String r6 = r4.f303     // Catch:{ all -> 0x0b8f }
            r15.put(r5, r6)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "amazon_aid_limit"
            boolean r4 = r4.m205()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0b8f }
            r15.put(r5, r4)     // Catch:{ all -> 0x0b8f }
        L_0x0903:
            java.lang.String r4 = "sentRegisterRequestToAF"
            r5 = 0
            boolean r4 = r11.getBoolean(r4, r5)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "registeredUninstall"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0b8f }
            r15.put(r5, r4)     // Catch:{ all -> 0x0b8f }
            r4 = r21
            int r5 = r2.getLaunchCounter(r11, r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "counter"
            java.lang.String r8 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0b8f }
            r15.put(r6, r8)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "iaecounter"
            if (r1 == 0) goto L_0x0928
            r1 = 1
            goto L_0x0929
        L_0x0928:
            r1 = 0
        L_0x0929:
            java.lang.String r8 = "appsFlyerInAppEventCount"
            int r1 = m51((android.content.SharedPreferences) r11, (java.lang.String) r8, (boolean) r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x0b8f }
            r15.put(r6, r1)     // Catch:{ all -> 0x0b8f }
            r1 = 1
            if (r4 == 0) goto L_0x0951
            if (r5 != r1) goto L_0x0951
            r23.setFirstLaunchCalled()     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "waitForCustomerId"
            boolean r6 = m91((java.lang.String) r6)     // Catch:{ all -> 0x0b8f }
            if (r6 == 0) goto L_0x0951
            java.lang.String r6 = "wait_cid"
            java.lang.String r8 = java.lang.Boolean.toString(r1)     // Catch:{ all -> 0x0b8f }
            r15.put(r6, r8)     // Catch:{ all -> 0x0b8f }
        L_0x0951:
            java.lang.String r6 = "isFirstCall"
            boolean r8 = m47((android.content.SharedPreferences) r11)     // Catch:{ all -> 0x0b8f }
            if (r8 != 0) goto L_0x095a
            goto L_0x095b
        L_0x095a:
            r1 = 0
        L_0x095b:
            java.lang.String r1 = java.lang.Boolean.toString(r1)     // Catch:{ all -> 0x0b8f }
            r15.put(r6, r1)     // Catch:{ all -> 0x0b8f }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0b8f }
            r1.<init>()     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "cpu_abi"
            java.lang.String r8 = "ro.product.cpu.abi"
            java.lang.String r8 = m38((java.lang.String) r8)     // Catch:{ all -> 0x0b8f }
            r1.put(r6, r8)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "cpu_abi2"
            java.lang.String r8 = "ro.product.cpu.abi2"
            java.lang.String r8 = m38((java.lang.String) r8)     // Catch:{ all -> 0x0b8f }
            r1.put(r6, r8)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "arch"
            java.lang.String r8 = "os.arch"
            java.lang.String r8 = m38((java.lang.String) r8)     // Catch:{ all -> 0x0b8f }
            r1.put(r6, r8)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "build_display_id"
            java.lang.String r8 = "ro.build.display.id"
            java.lang.String r8 = m38((java.lang.String) r8)     // Catch:{ all -> 0x0b8f }
            r1.put(r6, r8)     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x0a1f
            boolean r4 = r2.f75     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x09d9
            com.appsflyer.internal.p r4 = com.appsflyer.internal.p.a.f279     // Catch:{ all -> 0x0b8f }
            android.location.Location r4 = com.appsflyer.internal.p.m185(r7)     // Catch:{ all -> 0x0b8f }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0b8f }
            r8 = 3
            r6.<init>(r8)     // Catch:{ all -> 0x0b8f }
            if (r4 == 0) goto L_0x09ce
            java.lang.String r8 = "lat"
            double r9 = r4.getLatitude()     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0b8f }
            r6.put(r8, r9)     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = "lon"
            double r9 = r4.getLongitude()     // Catch:{ all -> 0x0b8f }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0b8f }
            r6.put(r8, r9)     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = "ts"
            long r9 = r4.getTime()     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0b8f }
            r6.put(r8, r4)     // Catch:{ all -> 0x0b8f }
        L_0x09ce:
            boolean r4 = r6.isEmpty()     // Catch:{ all -> 0x0b8f }
            if (r4 != 0) goto L_0x09d9
            java.lang.String r4 = "loc"
            r1.put(r4, r6)     // Catch:{ all -> 0x0b8f }
        L_0x09d9:
            com.appsflyer.internal.b r4 = com.appsflyer.internal.b.e.f223     // Catch:{ all -> 0x0b8f }
            com.appsflyer.internal.b$d r4 = r4.m159(r7)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "btl"
            float r8 = r4.f221     // Catch:{ all -> 0x0b8f }
            java.lang.String r8 = java.lang.Float.toString(r8)     // Catch:{ all -> 0x0b8f }
            r1.put(r6, r8)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = r4.f222     // Catch:{ all -> 0x0b8f }
            if (r6 == 0) goto L_0x09f5
            java.lang.String r6 = "btch"
            java.lang.String r4 = r4.f222     // Catch:{ all -> 0x0b8f }
            r1.put(r6, r4)     // Catch:{ all -> 0x0b8f }
        L_0x09f5:
            r4 = 2
            if (r5 > r4) goto L_0x0a1f
            com.appsflyer.AFSensorManager r4 = com.appsflyer.AFSensorManager.m27((android.content.Context) r7)     // Catch:{ all -> 0x0b8f }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0b8f }
            r5.<init>()     // Catch:{ all -> 0x0b8f }
            java.util.List r6 = r4.m32()     // Catch:{ all -> 0x0b8f }
            boolean r8 = r6.isEmpty()     // Catch:{ all -> 0x0b8f }
            if (r8 != 0) goto L_0x0a0f
            r5.put(r3, r6)     // Catch:{ all -> 0x0b8f }
            goto L_0x0a1c
        L_0x0a0f:
            java.util.List r4 = r4.m30()     // Catch:{ all -> 0x0b8f }
            boolean r6 = r4.isEmpty()     // Catch:{ all -> 0x0b8f }
            if (r6 != 0) goto L_0x0a1c
            r5.put(r3, r4)     // Catch:{ all -> 0x0b8f }
        L_0x0a1c:
            r1.putAll(r5)     // Catch:{ all -> 0x0b8f }
        L_0x0a1f:
            java.util.Map r3 = com.appsflyer.internal.q.m187(r7)     // Catch:{ all -> 0x0b8f }
            java.lang.String r4 = "dim"
            r1.put(r4, r3)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "deviceData"
            r15.put(r3, r1)     // Catch:{ all -> 0x0b8f }
            r1 = r19
            java.lang.Object r3 = r15.get(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0b8f }
            r4 = r20
            java.lang.Object r5 = r15.get(r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = "uid"
            java.lang.Object r6 = r15.get(r6)     // Catch:{ all -> 0x0b8f }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0b8f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            r8.<init>()     // Catch:{ all -> 0x0b8f }
            r9 = 7
            r10 = 0
            java.lang.String r3 = r3.substring(r10, r9)     // Catch:{ all -> 0x0b8f }
            r8.append(r3)     // Catch:{ all -> 0x0b8f }
            r3 = 7
            java.lang.String r3 = r6.substring(r10, r3)     // Catch:{ all -> 0x0b8f }
            r8.append(r3)     // Catch:{ all -> 0x0b8f }
            int r3 = r5.length()     // Catch:{ all -> 0x0b8f }
            int r3 = r3 + -7
            java.lang.String r3 = r5.substring(r3)     // Catch:{ all -> 0x0b8f }
            r8.append(r3)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = r8.toString()     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = com.appsflyer.internal.z.m213((java.lang.String) r3)     // Catch:{ all -> 0x0b8f }
            java.lang.String r5 = "af_v"
            r15.put(r5, r3)     // Catch:{ all -> 0x0b8f }
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0b8f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            r3.<init>()     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.Object r1 = r15.get(r4)     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0b8f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            r3.<init>()     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = "uid"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0b8f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            r3.<init>()     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = "installDate"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0b8f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            r3.<init>()     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = "counter"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0b8f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0b8f }
            r3.<init>()     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = "iaecounter"
            java.lang.Object r1 = r15.get(r1)     // Catch:{ all -> 0x0b8f }
            r3.append(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = com.appsflyer.internal.z.m211(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = com.appsflyer.internal.z.m213((java.lang.String) r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "af_v2"
            r15.put(r3, r1)     // Catch:{ all -> 0x0b8f }
            boolean r1 = m73((android.content.Context) r7)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "ivc"
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0b8f }
            r15.put(r3, r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = "is_stop_tracking_used"
            boolean r1 = r11.contains(r1)     // Catch:{ all -> 0x0b8f }
            if (r1 == 0) goto L_0x0b14
            java.lang.String r1 = "istu"
            java.lang.String r3 = "is_stop_tracking_used"
            r4 = 0
            boolean r3 = r11.getBoolean(r3, r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0b8f }
            r15.put(r1, r3)     // Catch:{ all -> 0x0b8f }
        L_0x0b14:
            java.lang.String r1 = "consumeAfDeepLink"
            r3 = r23
            java.lang.Object r1 = r3.getObject(r1)     // Catch:{ all -> 0x0b8f }
            if (r1 == 0) goto L_0x0b2e
            java.lang.String r1 = "consumeAfDeepLink"
            r4 = 0
            boolean r1 = r3.getBoolean(r1, r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "is_dp_api"
            r15.put(r3, r1)     // Catch:{ all -> 0x0b8f }
        L_0x0b2e:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0b8f }
            r1.<init>()     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "mcc"
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x0b8f }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0b8f }
            int r4 = r4.mcc     // Catch:{ all -> 0x0b8f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0b8f }
            r1.put(r3, r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "mnc"
            android.content.res.Resources r4 = r7.getResources()     // Catch:{ all -> 0x0b8f }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0b8f }
            int r4 = r4.mnc     // Catch:{ all -> 0x0b8f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0b8f }
            r1.put(r3, r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "cell"
            r15.put(r3, r1)     // Catch:{ all -> 0x0b8f }
            com.appsflyer.internal.EventDataCollector r1 = new com.appsflyer.internal.EventDataCollector     // Catch:{ all -> 0x0b8f }
            r1.<init>(r7)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "sig"
            java.lang.String r4 = r1.signature()     // Catch:{ all -> 0x0b8f }
            r15.put(r3, r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "last_boot_time"
            long r4 = r1.bootTime()     // Catch:{ all -> 0x0b8f }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0b8f }
            r15.put(r3, r4)     // Catch:{ all -> 0x0b8f }
            java.lang.String r3 = "disk"
            java.lang.String r1 = r1.disk()     // Catch:{ all -> 0x0b8f }
            r15.put(r3, r1)     // Catch:{ all -> 0x0b8f }
            goto L_0x0b9b
        L_0x0b83:
            java.lang.String r1 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ all -> 0x0b8f }
            java.lang.String r1 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ all -> 0x0b8f }
            r1 = 0
            return r1
        L_0x0b8f:
            r0 = move-exception
            goto L_0x0b93
        L_0x0b91:
            r0 = move-exception
            r2 = r1
        L_0x0b93:
            r1 = r0
            java.lang.String r3 = r1.getLocalizedMessage()
            com.appsflyer.AFLogger.afErrorLog(r3, r1)
        L_0x0b9b:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m102(com.appsflyer.AFEvent):java.util.Map");
    }

    /* renamed from: ı  reason: contains not printable characters */
    public static boolean m47(SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", (String) null));
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static void m60(Context context, Map<String, Object> map) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            map.put("sc_o", rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : H5Param.SHORT_LIMIT_REQ_RATE : "pr" : "l" : "p");
        }
    }

    public void setConsumeAFDeepLinks(boolean z) {
        AppsFlyerProperties.getInstance().set("consumeAfDeepLink", z);
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setConsumeAFDeepLinks: ".concat(String.valueOf(z)), new String[0]);
    }

    /* access modifiers changed from: protected */
    public void handleDeepLinkCallback(Context context, Map<String, Object> map, Uri uri) {
        String str;
        String obj = uri.toString();
        if (obj == null) {
            obj = null;
        } else if (obj.matches("fb\\d*?://authorize.*") && obj.contains("access_token")) {
            int indexOf = obj.indexOf(63);
            if (indexOf == -1) {
                str = "";
            } else {
                str = obj.substring(indexOf);
            }
            if (str.length() != 0) {
                ArrayList arrayList = new ArrayList();
                if (str.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN)) {
                    arrayList = new ArrayList(Arrays.asList(str.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN)));
                } else {
                    arrayList.add(str);
                }
                StringBuilder sb = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    if (str2.contains("access_token")) {
                        it2.remove();
                    } else {
                        if (sb.length() != 0) {
                            sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN);
                        } else if (!str2.startsWith("?")) {
                            sb.append("?");
                        }
                        sb.append(str2);
                    }
                }
                obj = obj.replace(str, sb.toString());
            }
        }
        if (!map.containsKey("af_deeplink")) {
            map.put("af_deeplink", obj);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        final WeakReference weakReference = new WeakReference(context);
        ab abVar = new ab(uri, this);
        abVar.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        if (abVar.m120()) {
            abVar.f166 = new ab.b() {
                /* renamed from: ı  reason: contains not printable characters */
                public final void m108(String str) {
                    if (AppsFlyerLibCore.f62 != null) {
                        m107(hashMap);
                        AFLogger.afDebugLog("Calling onAttributionFailure with:\n".concat(String.valueOf(str)));
                        AppsFlyerLibCore.f62.onAttributionFailure(str);
                    }
                }

                /* renamed from: ι  reason: contains not printable characters */
                private void m107(Map<String, String> map) {
                    if (weakReference.get() != null) {
                        AppsFlyerLibCore.m59((Context) weakReference.get(), "deeplinkAttribution", new JSONObject(map).toString());
                    }
                }

                /* renamed from: ɩ  reason: contains not printable characters */
                public final void m109(Map<String, String> map) {
                    for (String next : map.keySet()) {
                        hashMap.put(next, map.get(next));
                    }
                    m107(hashMap);
                    AppsFlyerLibCore.m78((Map<String, String>) hashMap);
                }
            };
            AFExecutor.getInstance().getThreadPoolExecutor().execute(abVar);
            return;
        }
        m78(AndroidUtils.m35(context, hashMap, uri));
    }

    /* access modifiers changed from: private */
    /* renamed from: Ι  reason: contains not printable characters */
    public static void m78(Map<String, String> map) {
        if (f62 != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                f62.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static boolean m90(Context context) {
        try {
            if (com.google.android.gms.common.c.a().a(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e2);
            return false;
        }
    }

    /* renamed from: Ɩ  reason: contains not printable characters */
    private static boolean m49(Context context) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !m90(context)) {
            return true;
        }
        return false;
    }

    /* renamed from: Ӏ  reason: contains not printable characters */
    private static boolean m96(Context context) {
        return !getSharedPreferences(context).contains("appsFlyerCount");
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static String m38(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static String m64(String str, PackageManager packageManager, String str2) {
        Object obj;
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            String obj2 = obj.toString();
            if (!obj2.replaceAll("\\p{C}", "").equals(obj2)) {
                StringBuilder sb = new StringBuilder("Manifest meta-data ");
                sb.append(str);
                sb.append(": ");
                sb.append(obj2);
                sb.append(" contains non-printing characters");
                AFLogger.afWarnLog(sb.toString());
            }
            return obj2;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Could not find ");
            sb2.append(str);
            sb2.append(" value in the manifest");
            AFLogger.afErrorLog(sb2.toString(), th);
            return null;
        }
    }

    public void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put(Constants.URL_MEDIA_SOURCE, str);
            } catch (JSONException e2) {
                AFLogger.afErrorLog(e2.getMessage(), e2);
            }
        }
        if (str2 != null) {
            jSONObject.put("c", str2);
        }
        if (str3 != null) {
            jSONObject.put(Constants.URL_SITE_ID, str3);
        }
        if (jSONObject.has(Constants.URL_MEDIA_SOURCE)) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0028=Splitter:B:13:0x0028, B:22:0x003f=Splitter:B:22:0x003f} */
    /* renamed from: ǃ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m54(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r0
        L_0x0028:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0059
        L_0x0035:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x0059
        L_0x003e:
            r2 = r0
        L_0x003f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x005a }
            r5.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
        L_0x0059:
            return r0
        L_0x005a:
            r4 = move-exception
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m54(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static boolean m70(File file) {
        return file == null || !file.exists();
    }

    /* renamed from: ɹ  reason: contains not printable characters */
    private static File m71(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.trim().length() > 0) {
                return new File(str.trim());
            }
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    public String getConfiguredChannel(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("channel");
        if (string == null) {
            string = context == null ? null : m64("CHANNEL", context.getPackageManager(), context.getPackageName());
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ǃ  reason: contains not printable characters */
    public static String m53(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences.contains("CACHED_CHANNEL")) {
            return sharedPreferences.getString("CACHED_CHANNEL", (String) null);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString("CACHED_CHANNEL", str);
        edit.apply();
        return str;
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static String m84(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = getSharedPreferences(context).getString("appsFlyerFirstInstall", (String) null);
        if (string == null) {
            if (m96(context)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                str = "";
            }
            string = str;
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString("appsFlyerFirstInstall", string);
            edit.apply();
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public String getAttributionId(Context context) {
        try {
            return new ac(context).m124();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
    }

    public final int getLaunchCounter(SharedPreferences sharedPreferences, boolean z) {
        return m51(sharedPreferences, "appsFlyerCount", z);
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static int m51(SharedPreferences sharedPreferences, String str, boolean z) {
        int i2 = sharedPreferences.getInt(str, 0);
        if (z) {
            i2++;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i2);
            edit.apply();
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        if (ai.f183.m151()) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m147(String.valueOf(i2));
        }
        return i2;
    }

    /* access modifiers changed from: private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static void m68(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e2) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e2);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.afWarnLog("scheduler is null, shut downed or terminated");
    }

    public boolean isTrackingStopped() {
        return this.f80;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r3 != null) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A[SYNTHETIC, Splitter:B:23:0x0054] */
    /* renamed from: ǃ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m99(java.net.HttpURLConnection r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r8.getErrorStream()     // Catch:{ all -> 0x0037 }
            if (r2 != 0) goto L_0x0010
            java.io.InputStream r2 = r8.getInputStream()     // Catch:{ all -> 0x0037 }
        L_0x0010:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0037 }
            r3.<init>(r2)     // Catch:{ all -> 0x0037 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0035 }
            r2.<init>(r3)     // Catch:{ all -> 0x0035 }
        L_0x001a:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0029
            r0.append(r1)     // Catch:{ all -> 0x0030 }
            r1 = 10
            r0.append(r1)     // Catch:{ all -> 0x0030 }
            goto L_0x001a
        L_0x0029:
            r2.close()     // Catch:{ all -> 0x005a }
        L_0x002c:
            r3.close()     // Catch:{ all -> 0x005a }
            goto L_0x005a
        L_0x0030:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            goto L_0x0039
        L_0x0037:
            r2 = move-exception
            r3 = r1
        L_0x0039:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch:{ all -> 0x007d }
            java.net.URL r8 = r8.getURL()     // Catch:{ all -> 0x007d }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x007d }
            r4.append(r8)     // Catch:{ all -> 0x007d }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x007d }
            com.appsflyer.AFLogger.afErrorLog(r8, r2)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ all -> 0x005a }
        L_0x0057:
            if (r3 == 0) goto L_0x005a
            goto L_0x002c
        L_0x005a:
            java.lang.String r8 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0064 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x0064 }
            return r8
        L_0x0064:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x0073 }
            return r8
        L_0x0073:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r8 = r8.toString()
            return r8
        L_0x007d:
            r8 = move-exception
            if (r1 == 0) goto L_0x0083
            r1.close()     // Catch:{ all -> 0x0088 }
        L_0x0083:
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ all -> 0x0088 }
        L_0x0088:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m99(java.net.HttpURLConnection):java.lang.String");
    }

    /* renamed from: і  reason: contains not printable characters */
    private static float m93(Context context) {
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra(H5PermissionManager.level, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            return (((float) intExtra) / ((float) intExtra2)) * 100.0f;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return 1.0f;
        }
    }

    /* renamed from: ɹ  reason: contains not printable characters */
    private static boolean m73(Context context) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e2);
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it2.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it2.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e3);
                }
            }
        }
        return false;
    }

    public void setLogLevel(AFLogger.LogLevel logLevel) {
        boolean z = logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel();
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "log", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("shouldLog", z);
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public void setMinTimeBetweenSessions(int i2) {
        this.f81 = TimeUnit.SECONDS.toMillis((long) i2);
    }

    class e implements Runnable {

        /* renamed from: ı  reason: contains not printable characters */
        private AFEvent f123;

        /* synthetic */ e(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b2) {
            this(aFEvent);
        }

        private e(AFEvent aFEvent) {
            this.f123 = aFEvent;
        }

        public final void run() {
            AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
            AFEvent aFEvent = this.f123;
            aFEvent.f18 = aFEvent.f7.get();
            appsFlyerLibCore.m43(aFEvent);
        }
    }

    class a implements Runnable {

        /* renamed from: ɩ  reason: contains not printable characters */
        private final AFEvent f111;

        /* synthetic */ a(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b2) {
            this(aFEvent);
        }

        private a(AFEvent aFEvent) {
            this.f111 = aFEvent.weakContext();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x0213, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0168, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0169, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0170, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0171, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0183, code lost:
            com.appsflyer.internal.aa.m116();
            r3 = new com.appsflyer.internal.j(r2, r6, "5.4.0");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            r2 = com.appsflyer.internal.aa.m119(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0195, code lost:
            if (r2.exists() == false) goto L_0x0197;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0197, code lost:
            r2.mkdir();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x019c, code lost:
            r2 = r2.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a0, code lost:
            if (r2 == null) goto L_0x01a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a8, code lost:
            r2 = new java.io.File(com.appsflyer.internal.aa.m119(r4), java.lang.Long.toString(java.lang.System.currentTimeMillis()));
            r2.createNewFile();
            r4 = new java.io.OutputStreamWriter(new java.io.FileOutputStream(r2.getPath(), true));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r4.write("version=");
            r4.write(r3.f266);
            r4.write(10);
            r4.write("url=");
            r4.write(r3.f264);
            r4.write(10);
            r4.write("data=");
            r4.write(android.util.Base64.encodeToString(r3.m184(), 2));
            r4.write(10);
            r4.flush();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0202, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0204, code lost:
            r1 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0206, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0207, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0208, code lost:
            if (r4 != null) goto L_0x020a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x020d, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x020e, code lost:
            if (r1 != null) goto L_0x0210;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x0210 A[SYNTHETIC, Splitter:B:101:0x0210] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0168 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:34:0x0107] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x020a A[SYNTHETIC, Splitter:B:95:0x020a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r13 = this;
                com.appsflyer.AFEvent r0 = r13.f111
                java.util.Map r0 = r0.params()
                com.appsflyer.AFEvent r1 = r13.f111
                boolean r1 = r1.m5()
                com.appsflyer.AFEvent r2 = r13.f111
                java.lang.String r2 = r2.urlString()
                com.appsflyer.AFEvent r3 = r13.f111
                int r3 = r3.f11
                com.appsflyer.AFEvent r4 = r13.f111
                android.content.Context r4 = r4.context()
                com.appsflyer.AppsFlyerLibCore r5 = com.appsflyer.AppsFlyerLibCore.this
                boolean r5 = r5.isTrackingStopped()
                if (r5 == 0) goto L_0x0025
                return
            L_0x0025:
                r5 = 0
                byte[] r6 = new byte[r5]
                r7 = 2
                r8 = 1
                if (r1 == 0) goto L_0x00f8
                if (r3 > r7) goto L_0x00f8
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                boolean r9 = r9.m69()
                if (r9 == 0) goto L_0x0064
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.GoogleReferrer r9 = r9.f83
                java.util.Map<java.lang.String, java.lang.Object> r9 = r9.oldMap
                java.lang.String r10 = "rfr"
                r0.put(r10, r9)
                android.content.SharedPreferences r9 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r4)
                android.content.SharedPreferences$Editor r9 = r9.edit()
                java.lang.String r10 = "newGPReferrerSent"
                android.content.SharedPreferences$Editor r9 = r9.putBoolean(r10, r8)
                r9.apply()
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.GoogleReferrer r9 = r9.f83
                java.util.Map<java.lang.String, java.lang.Object> r9 = r9.newMap
                r1.add(r9)
            L_0x0064:
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.HuaweiReferrer r9 = r9.f92
                if (r9 == 0) goto L_0x00a7
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.HuaweiReferrer r9 = r9.f92
                java.util.Map<java.lang.String, java.lang.Object> r9 = r9.map
                if (r9 == 0) goto L_0x007a
                r1.add(r9)
                goto L_0x00a7
            L_0x007a:
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.HuaweiReferrer r9 = r9.f92
                boolean r9 = r9.valid()
                if (r9 == 0) goto L_0x00a7
                if (r3 != r7) goto L_0x00a7
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.lang.String r9 = "source"
                java.lang.String r10 = "huawei"
                r3.put(r9, r10)
                java.lang.String r9 = "response"
                java.lang.String r10 = "TIMEOUT"
                r3.put(r9, r10)
                com.appsflyer.internal.referrer.MandatoryFields r9 = new com.appsflyer.internal.referrer.MandatoryFields
                r9.<init>()
                r3.putAll(r9)
                r1.add(r3)
            L_0x00a7:
                boolean r3 = r1.isEmpty()
                if (r3 != 0) goto L_0x00b2
                java.lang.String r3 = "referrers"
                r0.put(r3, r1)
            L_0x00b2:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f84
                if (r1 == 0) goto L_0x00c5
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f84
                java.lang.String r3 = "fb_ddl"
                r0.put(r3, r1)
            L_0x00c5:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = r1.m95()
                if (r1 == 0) goto L_0x00d9
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f87
                java.lang.String r3 = "lvl"
                r0.put(r3, r1)
                goto L_0x00f8
            L_0x00d9:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = r1.f91
                if (r1 == 0) goto L_0x00f8
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.util.Map unused = r1.f87 = r3
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f87
                java.lang.String r3 = "error"
                java.lang.String r9 = "operation timed out."
                r1.put(r3, r9)
            L_0x00f8:
                com.appsflyer.AFEvent r1 = r13.f111
                boolean r1 = r1 instanceof com.appsflyer.internal.model.event.AdRevenue
                if (r1 != 0) goto L_0x0106
                com.appsflyer.internal.c$a r1 = new com.appsflyer.internal.c$a
                r1.<init>(r0, r4)
                r0.putAll(r1)
            L_0x0106:
                r1 = 0
                com.appsflyer.AFEvent r3 = r13.f111     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                com.appsflyer.AFEvent r9 = r13.f111     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                boolean r9 = r9 instanceof com.appsflyer.internal.model.event.AdRevenue     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                if (r9 == 0) goto L_0x0118
                java.lang.String r9 = "af_key"
                java.lang.Object r9 = r0.get(r9)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                goto L_0x0120
            L_0x0118:
                java.lang.String r9 = "appsflyerKey"
                java.lang.Object r9 = r0.get(r9)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
            L_0x0120:
                r3.key(r9)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                monitor-enter(r0)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                com.appsflyer.AFEvent r3 = r13.f111     // Catch:{ all -> 0x0165 }
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x015c }
                r9[r5] = r3     // Catch:{ all -> 0x015c }
                r3 = 48
                r10 = 11758(0x2dee, float:1.6476E-41)
                r11 = 24
                java.lang.Object r3 = com.appsflyer.internal.d.m179(r3, r10, r11)     // Catch:{ all -> 0x015c }
                java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x015c }
                java.lang.String r10 = "ɩ"
                java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x015c }
                java.lang.Class<com.appsflyer.AFEvent> r12 = com.appsflyer.AFEvent.class
                r11[r5] = r12     // Catch:{ all -> 0x015c }
                java.lang.reflect.Method r3 = r3.getMethod(r10, r11)     // Catch:{ all -> 0x015c }
                java.lang.Object r3 = r3.invoke(r1, r9)     // Catch:{ all -> 0x015c }
                byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x015c }
                monitor-exit(r0)     // Catch:{ all -> 0x0159 }
                com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.this     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                com.appsflyer.AFEvent r5 = r13.f111     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                com.appsflyer.AFEvent r5 = r5.post(r3)     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                com.appsflyer.AppsFlyerLibCore.m44((com.appsflyer.AppsFlyerLibCore) r0, (com.appsflyer.AFEvent) r5)     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                return
            L_0x0156:
                r0 = move-exception
                r6 = r3
                goto L_0x0172
            L_0x0159:
                r5 = move-exception
                r6 = r3
                goto L_0x0166
            L_0x015c:
                r3 = move-exception
                java.lang.Throwable r5 = r3.getCause()     // Catch:{ all -> 0x0165 }
                if (r5 == 0) goto L_0x0164
                throw r5     // Catch:{ all -> 0x0165 }
            L_0x0164:
                throw r3     // Catch:{ all -> 0x0165 }
            L_0x0165:
                r5 = move-exception
            L_0x0166:
                monitor-exit(r0)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                throw r5     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
            L_0x0168:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
                return
            L_0x0171:
                r0 = move-exception
            L_0x0172:
                java.lang.String r3 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.afErrorLog(r3, r0)
                if (r6 == 0) goto L_0x021a
                if (r4 == 0) goto L_0x021a
                java.lang.String r3 = "&isCachedRequest=true&timeincache="
                boolean r3 = r2.contains(r3)
                if (r3 != 0) goto L_0x021a
                com.appsflyer.internal.aa.m116()
                com.appsflyer.internal.j r3 = new com.appsflyer.internal.j
                java.lang.String r5 = "5.4.0"
                r3.<init>(r2, r6, r5)
                java.io.File r2 = com.appsflyer.internal.aa.m119(r4)     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                boolean r5 = r2.exists()     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                if (r5 != 0) goto L_0x019c
                r2.mkdir()     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                goto L_0x0213
            L_0x019c:
                java.io.File[] r2 = r2.listFiles()     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                if (r2 == 0) goto L_0x01a8
                int r2 = r2.length     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                r5 = 40
                if (r2 <= r5) goto L_0x01a8
                goto L_0x0213
            L_0x01a8:
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                java.io.File r4 = com.appsflyer.internal.aa.m119(r4)     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                r2.<init>(r4, r5)     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                r2.createNewFile()     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                r5.<init>(r2, r8)     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x020e, all -> 0x0206 }
                java.lang.String r1 = "version="
                r4.write(r1)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                java.lang.String r1 = r3.f266     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r4.write(r1)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r1 = 10
                r4.write(r1)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                java.lang.String r2 = "url="
                r4.write(r2)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                java.lang.String r2 = r3.f264     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r4.write(r2)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r4.write(r1)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                java.lang.String r2 = "data="
                r4.write(r2)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                byte[] r2 = r3.m184()     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                java.lang.String r2 = android.util.Base64.encodeToString(r2, r7)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r4.write(r2)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r4.write(r1)     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r4.flush()     // Catch:{ Exception -> 0x0204, all -> 0x0202 }
                r4.close()     // Catch:{ IOException -> 0x0213 }
                goto L_0x0213
            L_0x0202:
                r0 = move-exception
                goto L_0x0208
            L_0x0204:
                r1 = r4
                goto L_0x020e
            L_0x0206:
                r0 = move-exception
                r4 = r1
            L_0x0208:
                if (r4 == 0) goto L_0x020d
                r4.close()     // Catch:{ IOException -> 0x020d }
            L_0x020d:
                throw r0
            L_0x020e:
                if (r1 == 0) goto L_0x0213
                r1.close()     // Catch:{ IOException -> 0x0213 }
            L_0x0213:
                java.lang.String r1 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
            L_0x021a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.a.run():void");
        }
    }

    static class b implements Runnable {

        /* renamed from: ı  reason: contains not printable characters */
        private static String f113 = "https://%sgcdsdk.%s/install_data/v4.0/";

        /* renamed from: ι  reason: contains not printable characters */
        private static final List<String> f114 = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});

        /* renamed from: ǃ  reason: contains not printable characters */
        private final String f115;

        /* renamed from: ɩ  reason: contains not printable characters */
        private final Application f116;

        /* renamed from: ɹ  reason: contains not printable characters */
        private AppsFlyerLibCore f117;

        /* renamed from: Ι  reason: contains not printable characters */
        final ScheduledExecutorService f118;

        /* renamed from: І  reason: contains not printable characters */
        private final AtomicInteger f119;

        /* renamed from: і  reason: contains not printable characters */
        private final int f120;

        /* synthetic */ b(AppsFlyerLibCore appsFlyerLibCore, Application application, String str, byte b2) {
            this(appsFlyerLibCore, application, str);
        }

        private b(AppsFlyerLibCore appsFlyerLibCore, Application application, String str) {
            this.f118 = AFExecutor.getInstance().m8();
            this.f119 = new AtomicInteger(0);
            this.f117 = appsFlyerLibCore;
            this.f116 = application;
            this.f115 = str;
            this.f120 = 0;
        }

        private b(b bVar) {
            this.f118 = AFExecutor.getInstance().m8();
            this.f119 = new AtomicInteger(0);
            this.f117 = bVar.f117;
            this.f116 = bVar.f116;
            this.f115 = bVar.f115;
            this.f120 = bVar.f120 + 1;
        }

        /* renamed from: Ι  reason: contains not printable characters */
        private void m110(String str, int i2) {
            if (500 > i2 || i2 >= 600) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                AppsFlyerLibCore.f62.onConversionDataFail(str);
            } else if (this.f120 == 2) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                AppsFlyerLibCore.f62.onConversionDataFail(str);
            } else {
                b bVar = new b(this);
                AppsFlyerLibCore.m68(bVar.f118, bVar, 10, TimeUnit.MILLISECONDS);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0274, code lost:
            if (r7 != null) goto L_0x0296;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0299, code lost:
            r14.f118.shutdown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x029e, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ all -> 0x0279 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f8 A[Catch:{ y -> 0x024c, all -> 0x0277 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0118 A[Catch:{ y -> 0x024c, all -> 0x0277 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0168 A[Catch:{ y -> 0x024c, all -> 0x0277 }] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0281 A[Catch:{ all -> 0x029f }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r14 = this;
                java.lang.String r0 = "is_first_launch"
                java.lang.String r1 = "af_siteid"
                java.lang.String r2 = r14.f115
                if (r2 == 0) goto L_0x02ab
                int r2 = r2.length()
                if (r2 != 0) goto L_0x0010
                goto L_0x02ab
            L_0x0010:
                com.appsflyer.AppsFlyerLibCore r2 = r14.f117
                boolean r2 = r2.isTrackingStopped()
                if (r2 == 0) goto L_0x0019
                return
            L_0x0019:
                java.util.concurrent.atomic.AtomicInteger r2 = r14.f119
                r2.incrementAndGet()
                r2 = 0
                r3 = 0
                android.app.Application r4 = r14.f116     // Catch:{ all -> 0x0279 }
                if (r4 != 0) goto L_0x002a
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f119
                r0.decrementAndGet()
                return
            L_0x002a:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0279 }
                android.app.Application r6 = r14.f116     // Catch:{ all -> 0x0279 }
                com.appsflyer.AppsFlyerLibCore r7 = r14.f117     // Catch:{ all -> 0x0279 }
                android.app.Application r8 = r14.f116     // Catch:{ all -> 0x0279 }
                java.lang.String r7 = r7.getConfiguredChannel(r8)     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = com.appsflyer.AppsFlyerLibCore.m53((android.content.Context) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0279 }
                java.lang.String r7 = ""
                r8 = 1
                if (r6 == 0) goto L_0x0065
                java.util.List<java.lang.String> r9 = f114     // Catch:{ all -> 0x0279 }
                java.lang.String r10 = r6.toLowerCase()     // Catch:{ all -> 0x0279 }
                boolean r9 = r9.contains(r10)     // Catch:{ all -> 0x0279 }
                if (r9 != 0) goto L_0x0058
                java.lang.String r9 = "-"
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = r9.concat(r6)     // Catch:{ all -> 0x0279 }
                goto L_0x0066
            L_0x0058:
                java.lang.String r9 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
                java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x0279 }
                r10[r3] = r6     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = java.lang.String.format(r9, r10)     // Catch:{ all -> 0x0279 }
                com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ all -> 0x0279 }
            L_0x0065:
                r6 = r7
            L_0x0066:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0279 }
                r9.<init>()     // Catch:{ all -> 0x0279 }
                java.lang.String r10 = f113     // Catch:{ all -> 0x0279 }
                java.lang.String r10 = com.appsflyer.ServerConfigHandler.getUrl(r10)     // Catch:{ all -> 0x0279 }
                r9.append(r10)     // Catch:{ all -> 0x0279 }
                android.app.Application r10 = r14.f116     // Catch:{ all -> 0x0279 }
                java.lang.String r10 = r10.getPackageName()     // Catch:{ all -> 0x0279 }
                r9.append(r10)     // Catch:{ all -> 0x0279 }
                r9.append(r6)     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = "?devkey="
                r9.append(r6)     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = r14.f115     // Catch:{ all -> 0x0279 }
                r9.append(r6)     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = "&device_id="
                r9.append(r6)     // Catch:{ all -> 0x0279 }
                java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0279 }
                android.app.Application r10 = r14.f116     // Catch:{ all -> 0x0279 }
                r6.<init>(r10)     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = com.appsflyer.internal.ae.m127(r6)     // Catch:{ all -> 0x0279 }
                r9.append(r6)     // Catch:{ all -> 0x0279 }
                java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0279 }
                com.appsflyer.internal.ai r9 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x0279 }
                if (r9 != 0) goto L_0x00ac
                com.appsflyer.internal.ai r9 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x0279 }
                r9.<init>()     // Catch:{ all -> 0x0279 }
                com.appsflyer.internal.ai.f183 = r9     // Catch:{ all -> 0x0279 }
            L_0x00ac:
                com.appsflyer.internal.ai r9 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x0279 }
                java.lang.String r10 = "server_request"
                java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ all -> 0x0279 }
                r9.m144(r10, r6, r7)     // Catch:{ all -> 0x0279 }
                java.lang.String r7 = "Calling server for attribution url: "
                java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0279 }
                java.lang.String r7 = r7.concat(r9)     // Catch:{ all -> 0x0279 }
                com.appsflyer.internal.ah.m137(r7)     // Catch:{ all -> 0x0279 }
                java.net.URL r7 = new java.net.URL     // Catch:{ all -> 0x0279 }
                r7.<init>(r6)     // Catch:{ all -> 0x0279 }
                java.net.URLConnection r7 = r7.openConnection()     // Catch:{ all -> 0x0279 }
                java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ all -> 0x0279 }
                java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ all -> 0x0279 }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x0279 }
                java.lang.String r2 = "GET"
                r7.setRequestMethod(r2)     // Catch:{ all -> 0x0277 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = "Connection"
                java.lang.String r9 = "close"
                r7.setRequestProperty(r2, r9)     // Catch:{ all -> 0x0277 }
                r7.connect()     // Catch:{ all -> 0x0277 }
                int r2 = r7.getResponseCode()     // Catch:{ all -> 0x0277 }
                com.appsflyer.AppsFlyerLibCore r9 = r14.f117     // Catch:{ all -> 0x0277 }
                java.lang.String r9 = r9.m99((java.net.HttpURLConnection) r7)     // Catch:{ all -> 0x0277 }
                com.appsflyer.internal.ai r10 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x0277 }
                if (r10 != 0) goto L_0x00ff
                com.appsflyer.internal.ai r10 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x0277 }
                r10.<init>()     // Catch:{ all -> 0x0277 }
                com.appsflyer.internal.ai.f183 = r10     // Catch:{ all -> 0x0277 }
            L_0x00ff:
                com.appsflyer.internal.ai r10 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x0277 }
                java.lang.String r11 = "server_response"
                r12 = 2
                java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ all -> 0x0277 }
                java.lang.String r13 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0277 }
                r12[r3] = r13     // Catch:{ all -> 0x0277 }
                r12[r8] = r9     // Catch:{ all -> 0x0277 }
                r10.m144(r11, r6, r12)     // Catch:{ all -> 0x0277 }
                r10 = 200(0xc8, float:2.8E-43)
                r11 = 404(0x194, float:5.66E-43)
                if (r2 == r10) goto L_0x0149
                if (r2 != r11) goto L_0x011b
                goto L_0x0149
            L_0x011b:
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f62     // Catch:{ all -> 0x0277 }
                if (r0 == 0) goto L_0x012e
                java.lang.String r0 = "Error connection to server: "
                java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x0277 }
                r14.m110(r0, r2)     // Catch:{ all -> 0x0277 }
            L_0x012e:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
                java.lang.String r1 = "AttributionIdFetcher response code: "
                r0.<init>(r1)     // Catch:{ all -> 0x0277 }
                r0.append(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r1 = "  url: "
                r0.append(r1)     // Catch:{ all -> 0x0277 }
                r0.append(r6)     // Catch:{ all -> 0x0277 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0277 }
                com.appsflyer.internal.ah.m137(r0)     // Catch:{ all -> 0x0277 }
                goto L_0x026f
            L_0x0149:
                long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0277 }
                android.app.Application r6 = r14.f116     // Catch:{ all -> 0x0277 }
                java.lang.String r10 = "appsflyerGetConversionDataTiming"
                long r12 = r12 - r4
                com.appsflyer.AppsFlyerLibCore.m85(r6, r10, r12)     // Catch:{ all -> 0x0277 }
                java.lang.String r4 = "Attribution data: "
                java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0277 }
                java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0277 }
                com.appsflyer.internal.ah.m137(r4)     // Catch:{ all -> 0x0277 }
                int r4 = r9.length()     // Catch:{ all -> 0x0277 }
                if (r4 <= 0) goto L_0x026f
                java.util.Map r4 = com.appsflyer.AppsFlyerLibCore.m66((java.lang.String) r9)     // Catch:{ all -> 0x0277 }
                java.lang.String r5 = "iscache"
                java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x0277 }
                java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0277 }
                if (r2 != r11) goto L_0x018f
                java.lang.String r2 = "error_reason"
                r4.remove(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = "status_code"
                r4.remove(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = "af_status"
                java.lang.String r6 = "Organic"
                r4.put(r2, r6)     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = "af_message"
                java.lang.String r6 = "organic install"
                r4.put(r2, r6)     // Catch:{ all -> 0x0277 }
            L_0x018f:
                if (r5 == 0) goto L_0x01a2
                boolean r2 = r5.booleanValue()     // Catch:{ all -> 0x0277 }
                if (r2 != 0) goto L_0x01a2
                android.app.Application r2 = r14.f116     // Catch:{ all -> 0x0277 }
                java.lang.String r6 = "appsflyerConversionDataCacheExpiration"
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0277 }
                com.appsflyer.AppsFlyerLibCore.m85(r2, r6, r10)     // Catch:{ all -> 0x0277 }
            L_0x01a2:
                boolean r2 = r4.containsKey(r1)     // Catch:{ all -> 0x0277 }
                java.lang.String r6 = "[Invite] Detected App-Invite via channel: "
                java.lang.String r10 = "af_channel"
                if (r2 == 0) goto L_0x01d7
                boolean r2 = r4.containsKey(r10)     // Catch:{ all -> 0x0277 }
                if (r2 == 0) goto L_0x01c6
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
                r2.<init>(r6)     // Catch:{ all -> 0x0277 }
                java.lang.Object r11 = r4.get(r10)     // Catch:{ all -> 0x0277 }
                r2.append(r11)     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0277 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0277 }
                goto L_0x01d7
            L_0x01c6:
                java.lang.String r2 = "[CrossPromotion] App was installed via %s's Cross Promotion"
                java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ all -> 0x0277 }
                java.lang.Object r12 = r4.get(r1)     // Catch:{ all -> 0x0277 }
                r11[r3] = r12     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = java.lang.String.format(r2, r11)     // Catch:{ all -> 0x0277 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0277 }
            L_0x01d7:
                boolean r1 = r4.containsKey(r1)     // Catch:{ all -> 0x0277 }
                if (r1 == 0) goto L_0x01f0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
                r1.<init>(r6)     // Catch:{ all -> 0x0277 }
                java.lang.Object r2 = r4.get(r10)     // Catch:{ all -> 0x0277 }
                r1.append(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0277 }
                com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0277 }
            L_0x01f0:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0277 }
                r4.put(r0, r1)     // Catch:{ all -> 0x0277 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0277 }
                r1.<init>(r4)     // Catch:{ all -> 0x0277 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = "attributionId"
                if (r1 == 0) goto L_0x0208
                android.app.Application r6 = r14.f116     // Catch:{ all -> 0x0277 }
                com.appsflyer.AppsFlyerLibCore.m59((android.content.Context) r6, (java.lang.String) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0277 }
                goto L_0x020d
            L_0x0208:
                android.app.Application r1 = r14.f116     // Catch:{ all -> 0x0277 }
                com.appsflyer.AppsFlyerLibCore.m59((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r9)     // Catch:{ all -> 0x0277 }
            L_0x020d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = "iscache="
                r1.<init>(r2)     // Catch:{ all -> 0x0277 }
                r1.append(r5)     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = " caching conversion data"
                r1.append(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0277 }
                com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0277 }
                com.appsflyer.AppsFlyerConversionListener r1 = com.appsflyer.AppsFlyerLibCore.f62     // Catch:{ all -> 0x0277 }
                if (r1 == 0) goto L_0x026f
                java.util.concurrent.atomic.AtomicInteger r1 = r14.f119     // Catch:{ all -> 0x0277 }
                int r1 = r1.intValue()     // Catch:{ all -> 0x0277 }
                if (r1 > r8) goto L_0x026f
                android.app.Application r1 = r14.f116     // Catch:{ y -> 0x024c }
                java.util.Map r1 = com.appsflyer.AppsFlyerLibCore.m39((android.content.Context) r1)     // Catch:{ y -> 0x024c }
                android.app.Application r2 = r14.f116     // Catch:{ y -> 0x024c }
                android.content.SharedPreferences r2 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r2)     // Catch:{ y -> 0x024c }
                java.lang.String r5 = "sixtyDayConversionData"
                boolean r2 = r2.getBoolean(r5, r3)     // Catch:{ y -> 0x024c }
                if (r2 != 0) goto L_0x0253
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ y -> 0x024c }
                r1.put(r0, r2)     // Catch:{ y -> 0x024c }
                goto L_0x0253
            L_0x024c:
                r0 = move-exception
                java.lang.String r1 = "Exception while trying to fetch attribution data. "
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ all -> 0x0277 }
                r1 = r4
            L_0x0253:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = "Calling onConversionDataSuccess with:\n"
                r0.<init>(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0277 }
                r0.append(r2)     // Catch:{ all -> 0x0277 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0277 }
                com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x0277 }
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f62     // Catch:{ all -> 0x0277 }
                r0.onConversionDataSuccess(r1)     // Catch:{ all -> 0x0277 }
            L_0x026f:
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f119
                r0.decrementAndGet()
                if (r7 == 0) goto L_0x0299
                goto L_0x0296
            L_0x0277:
                r0 = move-exception
                goto L_0x027b
            L_0x0279:
                r0 = move-exception
                r7 = r2
            L_0x027b:
                com.appsflyer.AppsFlyerConversionListener r1 = com.appsflyer.AppsFlyerLibCore.f62     // Catch:{ all -> 0x029f }
                if (r1 == 0) goto L_0x0288
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x029f }
                r14.m110(r1, r3)     // Catch:{ all -> 0x029f }
            L_0x0288:
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x029f }
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ all -> 0x029f }
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f119
                r0.decrementAndGet()
                if (r7 == 0) goto L_0x0299
            L_0x0296:
                r7.disconnect()
            L_0x0299:
                java.util.concurrent.ScheduledExecutorService r0 = r14.f118
                r0.shutdown()
                return
            L_0x029f:
                r0 = move-exception
                java.util.concurrent.atomic.AtomicInteger r1 = r14.f119
                r1.decrementAndGet()
                if (r7 == 0) goto L_0x02aa
                r7.disconnect()
            L_0x02aa:
                throw r0
            L_0x02ab:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.b.run():void");
        }
    }

    class c implements Runnable {

        /* renamed from: ι  reason: contains not printable characters */
        private WeakReference<Context> f122 = null;

        public c(Context context) {
            this.f122 = new WeakReference<>(context);
        }

        public final void run() {
            if (!AppsFlyerLibCore.this.f90) {
                AppsFlyerLibCore.this.f94 = System.currentTimeMillis();
                if (this.f122 != null) {
                    boolean unused = AppsFlyerLibCore.this.f90 = true;
                    try {
                        String r1 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                        synchronized (this.f122) {
                            aa.m116();
                            for (j next : aa.m117(this.f122.get())) {
                                StringBuilder sb = new StringBuilder("resending request: ");
                                sb.append(next.f264);
                                AFLogger.afInfoLog(sb.toString());
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long parseLong = Long.parseLong(next.f265, 10);
                                    AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                                    CachedEvent cachedEvent = new CachedEvent();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(next.f264);
                                    sb2.append("&isCachedRequest=true&timeincache=");
                                    sb2.append((currentTimeMillis - parseLong) / 1000);
                                    AFEvent key = cachedEvent.urlString(sb2.toString()).post(next.m184()).key(r1);
                                    key.f7 = this.f122;
                                    key.f14 = next.f265;
                                    key.f10 = false;
                                    AppsFlyerLibCore.m44(appsFlyerLibCore, key);
                                } catch (Exception e2) {
                                    AFLogger.afErrorLog("Failed to resend cached request", e2);
                                }
                            }
                        }
                    } catch (Exception e3) {
                        try {
                            AFLogger.afErrorLog("failed to check cache. ", e3);
                        } catch (Throwable th) {
                            boolean unused2 = AppsFlyerLibCore.this.f90 = false;
                            throw th;
                        }
                    }
                    boolean unused3 = AppsFlyerLibCore.this.f90 = false;
                    AppsFlyerLibCore.this.f69.shutdown();
                    ScheduledExecutorService unused4 = AppsFlyerLibCore.this.f69 = null;
                }
            }
        }
    }

    public String getSdkVersion() {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "getSdkVersion", new String[0]);
        StringBuilder sb = new StringBuilder("version: 5.4.0 (build ");
        sb.append(f61);
        sb.append(")");
        return sb.toString();
    }

    public void setImeiData(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setImeiData", str);
        this.f85 = str;
    }

    public void setOaidData(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setOaidData", str);
        this.f78 = str;
    }

    public void setAndroidIdData(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setAndroidIdData", str);
        this.f86 = str;
    }

    public void setAppInviteOneLink(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_ID, str);
    }

    public void setAdditionalData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m144("public_api_call", "setAdditionalData", hashMap.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(hashMap).toString());
        }
    }

    public void setUserEmails(String... strArr) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    public void setCollectAndroidID(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectIMEI(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectOaid(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setCollectOaid", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
    }

    @Deprecated
    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        aiVar.m144("public_api_call", "init", strArr);
        AFLogger.m19(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"5.4.0", f61}));
        this.f79 = true;
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        ah.m136(str);
        f62 = appsFlyerConversionListener;
        return this;
    }

    public void setCustomerUserId(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
    }

    public void setAppId(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setAppId", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_ID, str);
    }

    public void setExtension(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public void setIsUpdate(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    public void setCurrencyCode(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set("currencyCode", str);
    }

    public void trackLocation(Context context, double d2, double d3) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "trackLocation", String.valueOf(d2), String.valueOf(d3));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d3));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d2));
        AFEvent context2 = new InAppEvent().context(context);
        context2.f21 = AFInAppEventType.LOCATION_COORDINATES;
        context2.f17 = hashMap;
        m101(context2);
    }

    public void reportTrackSession(Context context) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "reportTrackSession", new String[0]);
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.f188 = false;
        AFEvent context2 = new InAppEvent().context(context);
        context2.f21 = null;
        context2.f17 = null;
        m101(context2);
    }

    public void setDeviceTrackingDisabled(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "setDeviceTrackingDisabled", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    public void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            f62 = appsFlyerConversionListener;
        }
    }

    public void unregisterConversionListener() {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "unregisterConversionListener", new String[0]);
        f62 = null;
    }

    public void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            f60 = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static void m86(Context context, Map<String, ? super String> map) {
        s sVar = s.d.f295;
        s.a r2 = s.m195(context);
        map.put(ContactsConstant.NETWORK, r2.f292);
        if (r2.f294 != null) {
            map.put(StringSet.operator, r2.f294);
        }
        if (r2.f293 != null) {
            map.put("carrier", r2.f293);
        }
    }

    public String getAppsFlyerUID(Context context) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("public_api_call", "getAppsFlyerUID", new String[0]);
        return ae.m127(new WeakReference(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0228 A[Catch:{ y -> 0x020c, all -> 0x022c }] */
    /* renamed from: ι  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m87(com.appsflyer.AFEvent r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "is_first_launch"
            java.lang.String r3 = "appsflyerConversionDataCacheExpiration"
            java.net.URL r4 = new java.net.URL
            java.lang.String r5 = r0.f20
            r4.<init>(r5)
            byte[] r5 = r21.m6()
            java.lang.String r6 = r21.key()
            java.lang.String r7 = r0.f14
            boolean r8 = r21.m5()
            android.content.Context r9 = r21.context()
            com.appsflyer.AppsFlyerTrackingRequestListener r10 = r0.f12
            r11 = 1
            if (r8 == 0) goto L_0x002c
            com.appsflyer.AppsFlyerConversionListener r13 = f62
            if (r13 == 0) goto L_0x002c
            r13 = 1
            goto L_0x002d
        L_0x002c:
            r13 = 0
        L_0x002d:
            java.net.URLConnection r15 = r4.openConnection()     // Catch:{ all -> 0x022e }
            java.lang.Object r15 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r15)     // Catch:{ all -> 0x022e }
            java.net.URLConnection r15 = (java.net.URLConnection) r15     // Catch:{ all -> 0x022e }
            java.net.HttpURLConnection r15 = (java.net.HttpURLConnection) r15     // Catch:{ all -> 0x022e }
            java.lang.String r14 = "POST"
            r15.setRequestMethod(r14)     // Catch:{ all -> 0x022c }
            int r14 = r5.length     // Catch:{ all -> 0x022c }
            java.lang.String r12 = "Content-Length"
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x022c }
            r15.setRequestProperty(r12, r14)     // Catch:{ all -> 0x022c }
            java.lang.String r12 = "Content-Type"
            boolean r0 = r21.isEncrypt()     // Catch:{ all -> 0x022c }
            if (r0 == 0) goto L_0x0053
            java.lang.String r0 = "application/octet-stream"
            goto L_0x0055
        L_0x0053:
            java.lang.String r0 = "application/json"
        L_0x0055:
            r15.setRequestProperty(r12, r0)     // Catch:{ all -> 0x022c }
            r0 = 10000(0x2710, float:1.4013E-41)
            r15.setConnectTimeout(r0)     // Catch:{ all -> 0x022c }
            r15.setDoOutput(r11)     // Catch:{ all -> 0x022c }
            java.io.DataOutputStream r14 = new java.io.DataOutputStream     // Catch:{ all -> 0x021c }
            java.io.OutputStream r0 = r15.getOutputStream()     // Catch:{ all -> 0x021c }
            r14.<init>(r0)     // Catch:{ all -> 0x021c }
            r14.write(r5)     // Catch:{ all -> 0x021a }
            r14.close()     // Catch:{ all -> 0x022c }
            int r0 = r15.getResponseCode()     // Catch:{ all -> 0x022c }
            java.lang.String r5 = r1.m99((java.net.HttpURLConnection) r15)     // Catch:{ all -> 0x022c }
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x022c }
            if (r12 != 0) goto L_0x0082
            com.appsflyer.internal.ai r12 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x022c }
            r12.<init>()     // Catch:{ all -> 0x022c }
            com.appsflyer.internal.ai.f183 = r12     // Catch:{ all -> 0x022c }
        L_0x0082:
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.ai.f183     // Catch:{ all -> 0x022c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x022c }
            java.lang.String r14 = "server_response"
            r11 = 2
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ all -> 0x022c }
            java.lang.String r18 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x022c }
            r16 = 0
            r11[r16] = r18     // Catch:{ all -> 0x022c }
            r17 = 1
            r11[r17] = r5     // Catch:{ all -> 0x022c }
            r12.m144(r14, r4, r11)     // Catch:{ all -> 0x022c }
            java.lang.String r4 = "response code: "
            java.lang.String r11 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x022c }
            java.lang.String r4 = r4.concat(r11)     // Catch:{ all -> 0x022c }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x022c }
            android.content.SharedPreferences r4 = getSharedPreferences(r9)     // Catch:{ all -> 0x022c }
            r11 = 200(0xc8, float:2.8E-43)
            if (r0 != r11) goto L_0x0150
            if (r9 == 0) goto L_0x00bb
            if (r8 == 0) goto L_0x00bb
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x022c }
            r1.f68 = r11     // Catch:{ all -> 0x022c }
        L_0x00bb:
            if (r10 == 0) goto L_0x00c0
            r10.onTrackingRequestSuccess()     // Catch:{ all -> 0x022c }
        L_0x00c0:
            if (r7 == 0) goto L_0x00c9
            com.appsflyer.internal.aa.m116()     // Catch:{ all -> 0x022c }
            com.appsflyer.internal.aa.m118(r7, r9)     // Catch:{ all -> 0x022c }
            goto L_0x0109
        L_0x00c9:
            java.lang.String r0 = "sentSuccessfully"
            java.lang.String r7 = "true"
            android.content.SharedPreferences r8 = getSharedPreferences(r9)     // Catch:{ all -> 0x022c }
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ all -> 0x022c }
            r8.putString(r0, r7)     // Catch:{ all -> 0x022c }
            r8.apply()     // Catch:{ all -> 0x022c }
            boolean r0 = r1.f90     // Catch:{ all -> 0x022c }
            if (r0 != 0) goto L_0x0109
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x022c }
            long r10 = r1.f94     // Catch:{ all -> 0x022c }
            long r7 = r7 - r10
            r10 = 15000(0x3a98, double:7.411E-320)
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ed
            goto L_0x0109
        L_0x00ed:
            java.util.concurrent.ScheduledExecutorService r0 = r1.f69     // Catch:{ all -> 0x022c }
            if (r0 != 0) goto L_0x0109
            com.appsflyer.AFExecutor r0 = com.appsflyer.AFExecutor.getInstance()     // Catch:{ all -> 0x022c }
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.m8()     // Catch:{ all -> 0x022c }
            r1.f69 = r0     // Catch:{ all -> 0x022c }
            com.appsflyer.AppsFlyerLibCore$c r0 = new com.appsflyer.AppsFlyerLibCore$c     // Catch:{ all -> 0x022c }
            r0.<init>(r9)     // Catch:{ all -> 0x022c }
            java.util.concurrent.ScheduledExecutorService r7 = r1.f69     // Catch:{ all -> 0x022c }
            r10 = 1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x022c }
            m68(r7, r0, r10, r8)     // Catch:{ all -> 0x022c }
        L_0x0109:
            java.lang.String r0 = "afUninstallToken"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x022c }
            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x022c }
            if (r0 == 0) goto L_0x013b
            java.lang.String r7 = "Uninstall Token exists: "
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x022c }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x022c }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ all -> 0x022c }
            java.lang.String r7 = "sentRegisterRequestToAF"
            r8 = 0
            boolean r7 = r4.getBoolean(r7, r8)     // Catch:{ all -> 0x022c }
            if (r7 != 0) goto L_0x013b
            java.lang.String r7 = "Resending Uninstall token to AF servers: "
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x022c }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x022c }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ all -> 0x022c }
            com.appsflyer.internal.af.m128(r9, r0)     // Catch:{ all -> 0x022c }
        L_0x013b:
            android.net.Uri r0 = r1.latestDeepLink     // Catch:{ all -> 0x022c }
            if (r0 == 0) goto L_0x0142
            r7 = 0
            r1.latestDeepLink = r7     // Catch:{ all -> 0x022c }
        L_0x0142:
            org.json.JSONObject r0 = com.appsflyer.ServerConfigHandler.m114(r5)     // Catch:{ all -> 0x022c }
            java.lang.String r5 = "send_background"
            r7 = 0
            boolean r0 = r0.optBoolean(r5, r7)     // Catch:{ all -> 0x022c }
            r1.f76 = r0     // Catch:{ all -> 0x022c }
            goto L_0x015f
        L_0x0150:
            if (r10 == 0) goto L_0x015f
            java.lang.String r5 = "Failure: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x022c }
            java.lang.String r0 = r5.concat(r0)     // Catch:{ all -> 0x022c }
            r10.onTrackingRequestFailure(r0)     // Catch:{ all -> 0x022c }
        L_0x015f:
            r7 = 0
            long r10 = r4.getLong(r3, r7)     // Catch:{ all -> 0x022c }
            java.lang.String r0 = "attributionId"
            int r5 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x019d
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x022c }
            long r18 = r18 - r10
            r10 = 5184000000(0x134fd9000, double:2.561236308E-314)
            int r5 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x019d
            java.lang.String r5 = "sixtyDayConversionData"
            android.content.SharedPreferences r10 = getSharedPreferences(r9)     // Catch:{ all -> 0x022c }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x022c }
            r11 = 1
            r10.putBoolean(r5, r11)     // Catch:{ all -> 0x022c }
            r10.apply()     // Catch:{ all -> 0x022c }
            android.content.SharedPreferences r5 = getSharedPreferences(r9)     // Catch:{ all -> 0x022c }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x022c }
            r10 = 0
            r5.putString(r0, r10)     // Catch:{ all -> 0x022c }
            r5.apply()     // Catch:{ all -> 0x022c }
            m85(r9, r3, r7)     // Catch:{ all -> 0x022c }
        L_0x019d:
            r3 = 0
            java.lang.String r5 = r4.getString(r0, r3)     // Catch:{ all -> 0x022c }
            if (r5 != 0) goto L_0x01be
            if (r6 == 0) goto L_0x01be
            if (r13 == 0) goto L_0x01be
            com.appsflyer.AppsFlyerLibCore$b r0 = new com.appsflyer.AppsFlyerLibCore$b     // Catch:{ all -> 0x022c }
            android.content.Context r2 = r9.getApplicationContext()     // Catch:{ all -> 0x022c }
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x022c }
            r3 = 0
            r0.<init>(r1, r2, r6, r3)     // Catch:{ all -> 0x022c }
            java.util.concurrent.ScheduledExecutorService r2 = r0.f118     // Catch:{ all -> 0x022c }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x022c }
            r4 = 10
            m68(r2, r0, r4, r3)     // Catch:{ all -> 0x022c }
            goto L_0x0214
        L_0x01be:
            if (r6 != 0) goto L_0x01c6
            java.lang.String r0 = "AppsFlyer dev key is missing."
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ all -> 0x022c }
            goto L_0x0214
        L_0x01c6:
            if (r13 == 0) goto L_0x0214
            r14 = 0
            java.lang.String r0 = r4.getString(r0, r14)     // Catch:{ all -> 0x022c }
            if (r0 == 0) goto L_0x0214
            r0 = 0
            int r0 = r1.getLaunchCounter(r4, r0)     // Catch:{ all -> 0x022c }
            r3 = 1
            if (r0 <= r3) goto L_0x0214
            java.util.Map r0 = m39((android.content.Context) r9)     // Catch:{ y -> 0x020c }
            if (r0 == 0) goto L_0x0214
            boolean r3 = r0.containsKey(r2)     // Catch:{ all -> 0x0203 }
            if (r3 != 0) goto L_0x01e8
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0203 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0203 }
        L_0x01e8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0203 }
            java.lang.String r3 = "Calling onConversionDataSuccess with:\n"
            r2.<init>(r3)     // Catch:{ all -> 0x0203 }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x0203 }
            r2.append(r3)     // Catch:{ all -> 0x0203 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0203 }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0203 }
            com.appsflyer.AppsFlyerConversionListener r2 = f62     // Catch:{ all -> 0x0203 }
            r2.onConversionDataSuccess(r0)     // Catch:{ all -> 0x0203 }
            goto L_0x0214
        L_0x0203:
            r0 = move-exception
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ y -> 0x020c }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ y -> 0x020c }
            goto L_0x0214
        L_0x020c:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x022c }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ all -> 0x022c }
        L_0x0214:
            if (r15 == 0) goto L_0x0219
            r15.disconnect()
        L_0x0219:
            return
        L_0x021a:
            r0 = move-exception
            goto L_0x021e
        L_0x021c:
            r0 = move-exception
            r14 = 0
        L_0x021e:
            if (r14 != 0) goto L_0x0228
            if (r10 == 0) goto L_0x022b
            java.lang.String r2 = "No Connectivity"
            r10.onTrackingRequestFailure(r2)     // Catch:{ all -> 0x022c }
            goto L_0x022b
        L_0x0228:
            r14.close()     // Catch:{ all -> 0x022c }
        L_0x022b:
            throw r0     // Catch:{ all -> 0x022c }
        L_0x022c:
            r0 = move-exception
            goto L_0x0231
        L_0x022e:
            r0 = move-exception
            r14 = 0
            r15 = r14
        L_0x0231:
            if (r15 == 0) goto L_0x0236
            r15.disconnect()
        L_0x0236:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m87(com.appsflyer.AFEvent):void");
    }

    public void validateAndTrackInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Intent intent;
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        aiVar.m144("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str6);
            sb.append(" ");
            sb.append(str7);
            sb.append(" ");
            sb.append(str8);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = f60;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (context2 instanceof Activity) {
            intent = ((Activity) context2).getIntent();
        } else {
            intent = null;
        }
        new Thread(new x(applicationContext, string, str, str2, str3, str4, str5, map, intent)).start();
    }

    public void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.afWarnLog("hostName cannot be null or empty");
        } else {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        }
    }

    public String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : ServerParameters.DEFAULT_HOST;
    }

    @Deprecated
    public void setHostName(String str) {
        AppsFlyerProperties.getInstance().set("custom_host", str);
    }

    public String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    /* renamed from: Ι  reason: contains not printable characters */
    static /* synthetic */ void m77(AppsFlyerLibCore appsFlyerLibCore) {
        AFEvent context = new Attr().context(appsFlyerLibCore.f88);
        if (appsFlyerLibCore.m69() && appsFlyerLibCore.m48(context, getSharedPreferences(appsFlyerLibCore.f88))) {
            appsFlyerLibCore.m43(context);
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    static /* synthetic */ void m59(Context context, String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: ı  reason: contains not printable characters */
    static /* synthetic */ void m44(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(aFEvent.urlString());
        AFLogger.afInfoLog(sb.toString());
        if (aFEvent.f14 != null) {
            str = Base64.encodeToString(aFEvent.m6(), 2);
            AFLogger.afInfoLog("cached data: ".concat(String.valueOf(str)));
        } else {
            str = new JSONObject(aFEvent.params()).toString();
            ah.m137("data: ".concat(String.valueOf(str)));
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m144("server_request", aFEvent.urlString(), str);
        try {
            appsFlyerLibCore.m87(aFEvent);
        } catch (IOException e2) {
            AFLogger.afErrorLog("Exception in sendRequestToServer. ", e2);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                appsFlyerLibCore.m87(aFEvent.urlString(aFEvent.urlString().replace(BaseJSApiPermissionProvider.PROTOCOL_HTTPS, BaseJSApiPermissionProvider.PROTOCOL_HTTP)));
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send requeset to server. ");
            sb2.append(e2.getLocalizedMessage());
            AFLogger.afInfoLog(sb2.toString());
            throw e2;
        }
    }
}
