package com.alipay.mobile.nebula.wallet;

import com.alipay.iap.android.common.b.c;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5WalletLog {
    public static void debug(String str, String str2) {
        if (H5Utils.isDebuggable(H5Utils.getContext())) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(Thread.currentThread());
        }
    }

    public static void e(String str, String str2, Throwable th) {
        c.j();
    }

    public static void w(String str, String str2, Throwable th) {
        c.h();
    }

    public static void d(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(Thread.currentThread().getName());
        c.e();
    }
}
