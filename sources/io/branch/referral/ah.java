package io.branch.referral;

import android.app.UiModeManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.sendbird.android.constant.StringSet;
import io.branch.referral.m;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import net.one97.paytm.upi.util.UpiContract;

abstract class ah {

    /* renamed from: b  reason: collision with root package name */
    String f46434b = null;

    /* renamed from: c  reason: collision with root package name */
    int f46435c = 0;

    /* renamed from: d  reason: collision with root package name */
    String f46436d;

    interface a {
        void e();
    }

    ah() {
    }

    static b a(Context context, boolean z) {
        return new b(context, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(android.content.Context r2) {
        /*
            if (r2 == 0) goto L_0x0017
            android.content.pm.PackageManager r0 = r2.getPackageManager()     // Catch:{ Exception -> 0x0012 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0012 }
            r1 = 0
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r2, r1)     // Catch:{ Exception -> 0x0012 }
            java.lang.String r2 = r2.versionName     // Catch:{ Exception -> 0x0012 }
            goto L_0x0019
        L_0x0012:
            java.lang.String r2 = "Error obtaining AppVersion"
            io.branch.referral.q.i(r2)
        L_0x0017:
            java.lang.String r2 = ""
        L_0x0019:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0021
            java.lang.String r2 = "bnc_no_value"
        L_0x0021:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ah.a(android.content.Context):java.lang.String");
    }

    static long b(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (Exception unused) {
                q.i("Error obtaining FirstInstallTime");
            }
        }
        return 0;
    }

    static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                return false;
            }
            return !packageManager.queryIntentActivities(launchIntentForPackage, 65536).isEmpty();
        } catch (Exception unused) {
            q.i("Error obtaining PackageInfo");
            return false;
        }
    }

    static long d(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            } catch (Exception unused) {
                q.i("Error obtaining LastUpdateTime");
            }
        }
        return 0;
    }

    static String e(Context context) {
        if (b()) {
            return context == null ? Build.MODEL.contains("AFT") ? "AMAZON_FIRE_TV" : "AMAZON_FIRE" : context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv") ? "AMAZON_FIRE_TV" : "AMAZON_FIRE";
        }
        return StringSet.Android;
    }

    static DisplayMetrics f(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (!(context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null)) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Context context, a aVar) {
        q.a(context);
        this.f46436d = q.d("bnc_session_id");
        if (!b()) {
            new o(context, aVar).a(new Void[0]);
            return true;
        } else if (context == null) {
            return false;
        } else {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                this.f46435c = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
                this.f46434b = Settings.Secure.getString(contentResolver, "advertising_id");
                if (TextUtils.isEmpty(this.f46434b) || this.f46434b.equals("00000000-0000-0000-0000-000000000000") || this.f46435c == 1) {
                    this.f46434b = null;
                }
                if (aVar != null) {
                    aVar.e();
                }
            } catch (Settings.SettingNotFoundException unused) {
            }
            return false;
        }
    }

    static String a() {
        String str = "";
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it2 = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.indexOf(58) < 0) {
                            str = hostAddress;
                            break;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    static String g(Context context) {
        UiModeManager uiModeManager;
        if (context != null) {
            try {
                uiModeManager = (UiModeManager) context.getSystemService("uimode");
            } catch (Exception unused) {
                return "UI_MODE_TYPE_UNDEFINED";
            }
        } else {
            uiModeManager = null;
        }
        if (uiModeManager == null) {
            return "UI_MODE_TYPE_UNDEFINED";
        }
        switch (uiModeManager.getCurrentModeType()) {
            case 1:
                return "UI_MODE_TYPE_NORMAL";
            case 2:
                return "UI_MODE_TYPE_DESK";
            case 3:
                return "UI_MODE_TYPE_CAR";
            case 4:
                return "UI_MODE_TYPE_TELEVISION";
            case 5:
                return "UI_MODE_TYPE_APPLIANCE";
            case 6:
                return "UI_MODE_TYPE_WATCH";
            default:
                return "UI_MODE_TYPE_UNDEFINED";
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        String f46437a = "bnc_no_value";

        /* renamed from: b  reason: collision with root package name */
        boolean f46438b;

        b(Context context, boolean z) {
            this.f46438b = !z;
            String str = null;
            if (context != null && !z && !c.k()) {
                str = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            }
            if (str == null) {
                str = UUID.randomUUID().toString();
                this.f46438b = false;
            }
            this.f46437a = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f46437a.equals(bVar.f46437a) && this.f46438b == bVar.f46438b;
        }

        public final int hashCode() {
            int i2 = ((this.f46438b ? 1 : 0) + true) * 31;
            String str = this.f46437a;
            return i2 + (str == null ? 0 : str.hashCode());
        }
    }

    static String h(Context context) {
        String g2 = q.a(context).g(m.c.imei.getKey());
        if (!TextUtils.isEmpty(g2)) {
            return g2;
        }
        return null;
    }

    private static boolean b() {
        return Build.MANUFACTURER.equalsIgnoreCase("amazon");
    }
}
