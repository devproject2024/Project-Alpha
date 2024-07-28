package net.one97.paytm.feed.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import com.alipay.mobile.nebula.permission.H5PermissionManager;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiContract;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f35397a = new j();

    /* renamed from: b  reason: collision with root package name */
    private static final String f35398b = f35398b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f35399c = "2G";

    /* renamed from: d  reason: collision with root package name */
    private static final String f35400d = "3G";

    /* renamed from: e  reason: collision with root package name */
    private static final String f35401e = "4G";

    /* renamed from: f  reason: collision with root package name */
    private static final String f35402f = "WIFI";

    /* renamed from: g  reason: collision with root package name */
    private static final int f35403g = 30000;

    /* renamed from: h  reason: collision with root package name */
    private static final int f35404h = f35404h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f35405i = FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT;
    private static final int j = FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT;

    private j() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r2 = (r2 = (r0 = r2.getPackageManager()).getPackageInfo(r2.getPackageName(), 0)).versionName;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r2) {
        /*
            if (r2 == 0) goto L_0x0017
            android.content.pm.PackageManager r0 = r2.getPackageManager()
            if (r0 == 0) goto L_0x0017
            java.lang.String r2 = r2.getPackageName()
            r1 = 0
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r2, r1)
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = r2.versionName
            if (r2 != 0) goto L_0x0019
        L_0x0017:
            java.lang.String r2 = ""
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.utility.j.a(android.content.Context):java.lang.String");
    }

    public static String a() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        k.a((Object) str2, "model");
        k.a((Object) str, "manufacturer");
        if (p.b(str2, str, false)) {
            return str2;
        }
        return str + ' ' + str2;
    }

    public static String b(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return f35398b;
            }
            if (activeNetworkInfo.getType() == 1) {
                return f35402f;
            }
            if (activeNetworkInfo.getType() != 0) {
                return f35398b;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return f35399c;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return f35400d;
                case 13:
                    return f35401e;
                default:
                    return f35398b;
            }
        } else {
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    public static int c(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return f35403g;
            }
            if (activeNetworkInfo.getType() == 1) {
                return j;
            }
            if (activeNetworkInfo.getType() != 0) {
                return f35403g;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return f35403g;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return f35404h;
                case 13:
                    return f35405i;
                default:
                    return f35403g;
            }
        } else {
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
    }

    public static int b() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        b bVar = b.f34268c;
        Float f2 = null;
        Intent registerReceiver = b.g().getApplicationContext().registerReceiver((BroadcastReceiver) null, intentFilter);
        if (registerReceiver != null) {
            f2 = Float.valueOf(((float) registerReceiver.getIntExtra(H5PermissionManager.level, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
        }
        if (f2 != null) {
            return (int) (f2.floatValue() * 100.0f);
        }
        return 0;
    }

    public static boolean c() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        b bVar = b.f34268c;
        Intent registerReceiver = b.g().getApplicationContext().registerReceiver((BroadcastReceiver) null, intentFilter);
        int i2 = -1;
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("status", -1);
        }
        return i2 == 2 || i2 == 5;
    }

    public static String d(Context context) {
        k.c(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
        return string == null ? "" : string;
    }

    public static boolean e(Context context) {
        k.c(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
