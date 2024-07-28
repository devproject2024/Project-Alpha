package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alipay.mobile.nebula.permission.H5PermissionManager;

public final class b {

    /* renamed from: ı  reason: contains not printable characters */
    private IntentFilter f220 = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    public static final class e {

        /* renamed from: ı  reason: contains not printable characters */
        public static final b f223 = new b();
    }

    b() {
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public final d m159(Context context) {
        String str = null;
        float f2 = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, this.f220);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : "ac";
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra(H5PermissionManager.level, -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f2 = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable unused) {
        }
        return new d(f2, str);
    }

    public static final class d {

        /* renamed from: ı  reason: contains not printable characters */
        public final float f221;

        /* renamed from: Ι  reason: contains not printable characters */
        public final String f222;

        d(float f2, String str) {
            this.f221 = f2;
            this.f222 = str;
        }
    }
}
