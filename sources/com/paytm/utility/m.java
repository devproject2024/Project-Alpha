package com.paytm.utility;

import android.app.ActivityManager;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.alipay.mobile.nebula.util.H5Utils;
import com.paytm.contactsSdk.constant.ContactsConstant;
import com.paytm.contactsSdk.database.ContactColumn;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static String f43841a = "";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f43842b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f43843c;

    /* renamed from: d  reason: collision with root package name */
    public static final ConnectivityManager.NetworkCallback f43844d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final m f43845e = new m();

    /* renamed from: f  reason: collision with root package name */
    private static boolean f43846f;

    /* renamed from: g  reason: collision with root package name */
    private static String f43847g = "";

    public enum a {
        WIFI_AP_STATE_DISABLING,
        WIFI_AP_STATE_DISABLED,
        WIFI_AP_STATE_ENABLING,
        WIFI_AP_STATE_ENABLED,
        WIFI_AP_STATE_FAILED
    }

    private static String a(int i2) {
        if (i2 == 100) {
            return "STATE_FOREGROUND";
        }
        if (i2 == 125) {
            return "STATE_FOREGROUND_SERVICE";
        }
        if (i2 == 200) {
            return "STATE_VISIBLE";
        }
        if (i2 != 230) {
            if (i2 == 300) {
                return "STATE_SERVICE";
            }
            if (i2 == 325) {
                return "STATE_TOP_SLEEPING";
            }
            if (i2 != 350) {
                return i2 != 400 ? i2 != 1000 ? "STATE_GONE" : "STATE_GONE" : "STATE_CACHED";
            }
        }
    }

    private m() {
    }

    public static final /* synthetic */ Context f() {
        Context context = f43843c;
        if (context == null) {
            k.a("context");
        }
        return context;
    }

    public static boolean a(Context context) {
        k.c(context, "context");
        Integer num = null;
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            k.a();
        }
        if (registerReceiver != null) {
            num = Integer.valueOf(registerReceiver.getIntExtra("status", -1));
        }
        int intValue = num.intValue();
        return intValue == 2 || intValue == 5;
    }

    public static float b(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return (((float) memoryInfo.availMem) / ((float) memoryInfo.totalMem)) * 100.0f;
        }
        throw new u("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public static float c(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return ((float) memoryInfo.availMem) / 1000000.0f;
        }
        throw new u("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public static String a() {
        String str;
        if (f43846f) {
            return f43847g;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            if (Build.VERSION.SDK_INT >= 26) {
                DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z");
                Instant ofEpochMilli = Instant.ofEpochMilli(Build.TIME);
                TimeZone timeZone = TimeZone.getTimeZone("GMT");
                k.a((Object) timeZone, "TimeZone.getTimeZone(\"GMT\")");
                ZoneId of = ZoneId.of(timeZone.getID());
                k.a((Object) of, "ZoneId.of(TimeZone.getTimeZone(\"GMT\").id)");
                str = ofPattern.format(ZonedDateTime.ofInstant(ofEpochMilli, of));
                k.a((Object) str, "dateTimeFormatter.format(zonedDateTime)");
            } else {
                str = simpleDateFormat.format(new Date(Build.TIME));
                k.a((Object) str, "simpleDateFormat.format(Date(Build.TIME))");
            }
            f43847g = str;
        } catch (Exception unused) {
            f43847g = "";
        }
        f43846f = true;
        return f43847g;
    }

    public static int d(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService(ContactColumn.PHONE_NUMBER);
        if (systemService != null) {
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            if (Build.VERSION.SDK_INT >= 30) {
                return telephonyManager.getSupportedModemCount();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                return telephonyManager.getPhoneCount();
            }
            return -1;
        }
        throw new u("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    public static String e(Context context) {
        k.c(context, "context");
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            k.a((Object) runningAppProcesses, "service.runningAppProcesses");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return a(runningAppProcessInfo.importance);
                }
            }
            return a(1000);
        }
        throw new u("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public static int b() {
        return Thread.activeCount();
    }

    public static boolean f(Context context) {
        k.c(context, "context");
        try {
            Object systemService = context.getSystemService("wifi");
            if (systemService != null) {
                WifiManager wifiManager = (WifiManager) systemService;
                Method method = wifiManager.getClass().getMethod("getWifiApState", new Class[0]);
                k.a((Object) method, "mWifiManager.javaClass.getMethod(\"getWifiApState\")");
                Object invoke = method.invoke(wifiManager, new Object[0]);
                if (invoke != null) {
                    int intValue = ((Integer) invoke).intValue();
                    if (intValue > 10) {
                        intValue -= 10;
                    }
                    a[] aVarArr = (a[]) a.class.getEnumConstants();
                    a aVar = aVarArr != null ? aVarArr[intValue] : null;
                    if (aVar == null) {
                        k.a();
                    }
                    if (aVar == a.WIFI_AP_STATE_ENABLED) {
                        return true;
                    }
                    return false;
                }
                throw new u("null cannot be cast to non-null type kotlin.Int");
            }
            throw new u("null cannot be cast to non-null type android.net.wifi.WifiManager");
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<Double> g(Context context) {
        k.c(context, "context");
        String packageName = context.getPackageName();
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService("storagestats");
            if (systemService != null) {
                StorageStatsManager storageStatsManager = (StorageStatsManager) systemService;
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageName, 0);
                    StorageStats queryStatsForUid = storageStatsManager.queryStatsForUid(applicationInfo.storageUuid, applicationInfo.uid);
                    k.a((Object) queryStatsForUid, "storageStats");
                    return kotlin.a.k.b((T[]) new Double[]{Double.valueOf(((double) queryStatsForUid.getAppBytes()) / 1000000.0d), Double.valueOf((((double) queryStatsForUid.getDataBytes()) - ((double) queryStatsForUid.getCacheBytes())) / 1000000.0d), Double.valueOf(((double) queryStatsForUid.getCacheBytes()) / 1000000.0d)});
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                throw new u("null cannot be cast to non-null type android.app.usage.StorageStatsManager");
            }
        }
        return new ArrayList<>();
    }

    public static void a(String str) {
        k.c(str, "<set-?>");
        f43841a = str;
    }

    public static String c() {
        return f43841a;
    }

    public static final class b extends ConnectivityManager.NetworkCallback {
        public final void onLost(Network network) {
            k.c(network, ContactsConstant.NETWORK);
        }

        b() {
        }

        public final void onAvailable(Network network) {
            k.c(network, ContactsConstant.NETWORK);
            m mVar = m.f43845e;
            if (m.c().length() == 0) {
                m mVar2 = m.f43845e;
                m mVar3 = m.f43845e;
                m.a(m.h(m.f()));
                return;
            }
            m mVar4 = m.f43845e;
            String c2 = m.c();
            StringBuilder sb = new StringBuilder();
            sb.append(c2);
            sb.append("|");
            m mVar5 = m.f43845e;
            sb.append(m.h(m.f()));
            m.a(sb.toString());
        }
    }

    public static String h(Context context) {
        if (androidx.core.content.b.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            o oVar = o.f43848a;
            k.c(context, "context");
            NetworkInfo a2 = o.a(context);
            if (a2 != null && a2.isConnected()) {
                int type = a2.getType();
                if (type == 0) {
                    int a3 = o.a(o.b(context));
                    if (a3 != 0) {
                        if (a3 == 1) {
                            return H5Utils.NETWORK_TYPE_2G;
                        }
                        if (a3 == 2) {
                            return H5Utils.NETWORK_TYPE_3G;
                        }
                        if (a3 != 3) {
                            return H5Utils.NETWORK_TYPE_UNKNOWN;
                        }
                        return H5Utils.NETWORK_TYPE_4G;
                    }
                } else if (type == 1 || type == 9) {
                    return H5Utils.NETWORK_TYPE_WIFI;
                } else {
                    return H5Utils.NETWORK_TYPE_UNKNOWN;
                }
            }
        }
        return H5Utils.NETWORK_TYPE_UNKNOWN;
    }

    public static int d() {
        return p.a((CharSequence) f43841a, new String[]{"|"}).size();
    }

    public static int i(Context context) {
        k.c(context, "context");
        if (Build.VERSION.SDK_INT < 22) {
            return -1;
        }
        Object systemService = context.getSystemService("telephony_subscription_service");
        if (systemService != null) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) systemService;
            if (androidx.core.app.a.a(context, "android.permission.READ_PHONE_STATE") == 0) {
                return subscriptionManager.getActiveSubscriptionInfoCount();
            }
            return -1;
        }
        throw new u("null cannot be cast to non-null type android.telephony.SubscriptionManager");
    }

    public static int e() {
        return com.paytm.c.b.a();
    }

    public static String j(Context context) {
        k.c(context, "context");
        o oVar = o.f43848a;
        return o.c(context);
    }
}
