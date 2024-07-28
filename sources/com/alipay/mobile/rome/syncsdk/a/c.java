package com.alipay.mobile.rome.syncsdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.e.a;
import com.alipay.mobile.rome.syncsdk.e.b;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.LongLinkService;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14997a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f14998b = "active";

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f14999c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f15000d = false;

    public static synchronized boolean a() {
        synchronized (c.class) {
            String str = f14997a;
            h.a(str, "  flowControlByServer=" + f15000d);
            if (a.a() == b.BACKGROUND) {
                return true;
            }
            if (a.f15085a == com.alipay.mobile.rome.syncsdk.e.c.SCREEN_OFF) {
                return true;
            }
            Context e2 = LongLinkService.a().e();
            String a2 = com.alipay.mobile.rome.syncsdk.b.a.a().a(e2, "flow_control");
            if (!TextUtils.isEmpty(a2)) {
                try {
                    h.a(f14997a, "checkFlowControl: fc=".concat(String.valueOf(a2)));
                    String[] split = a2.split(AppConstants.COMMA);
                    long parseLong = Long.parseLong(split[0]) - System.currentTimeMillis();
                    long parseLong2 = Long.parseLong(split[1]);
                    if (parseLong <= 0 || parseLong2 <= 0) {
                        a(false);
                        com.alipay.mobile.rome.syncsdk.b.a.a().b(e2, "flow_control");
                    } else {
                        com.alipay.mobile.rome.syncsdk.service.h.a().a(Math.min(parseLong, parseLong2));
                    }
                } catch (Exception e3) {
                    h.d(f14997a, "checkFlowControl: e=".concat(String.valueOf(e3)));
                }
            }
            boolean z = f15000d;
            return z;
        }
    }

    public static synchronized void b() {
        synchronized (c.class) {
            h.b(f14997a, "resetFailCount ");
            f14999c = 0;
        }
    }

    public static synchronized void c() {
        synchronized (c.class) {
            f14999c++;
            h.b(f14997a, "addFailCount [ failCount=" + f14999c + " ]");
        }
    }

    public static synchronized void d() {
        synchronized (c.class) {
            if (f14999c > 0) {
                f14999c--;
            }
            h.b(f14997a, "decreaseFailCount [ failCount=" + f14999c + " ]");
        }
    }

    public static synchronized void e() {
        synchronized (c.class) {
            f14999c = 9;
            String str = f14997a;
            h.b(str, "setFailCountForOnceEnable [ failCount=" + f14999c + " ]");
        }
    }

    public static synchronized boolean f() {
        boolean z;
        synchronized (c.class) {
            z = false;
            if (f14999c < 10) {
                z = true;
            }
            String str = f14997a;
            h.b(str, "[isReconnEnable =" + z + " ][ failCount=" + f14999c + " ][ MAX_FAIL_COUNT=10 ]");
        }
        return z;
    }

    public static synchronized void a(String str) {
        synchronized (c.class) {
            String str2 = f14997a;
            h.b(str2, "setConnAction [ connAction=" + str + " ]");
            f14998b = str;
        }
    }

    public static synchronized String g() {
        String str;
        synchronized (c.class) {
            String str2 = f14997a;
            h.b(str2, "getConnAction [ connAction=" + f14998b + " ]");
            str = f14998b;
        }
        return str;
    }

    public static synchronized void a(boolean z) {
        synchronized (c.class) {
            h.b(f14997a, "setFlowCotrol:".concat(String.valueOf(z)));
            f15000d = z;
        }
    }
}
