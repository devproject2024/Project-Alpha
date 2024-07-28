package com.google.android.gms.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import com.alipay.mobile.nebula.permission.H5PermissionManager;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final IntentFilter f8995a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b  reason: collision with root package name */
    private static long f8996b;

    /* renamed from: c  reason: collision with root package name */
    private static float f8997c = Float.NaN;

    public static int a(Context context) {
        int i2;
        boolean z;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f8995a);
        int i3 = 0;
        if (registerReceiver == null) {
            i2 = 0;
        } else {
            i2 = registerReceiver.getIntExtra("plugged", 0);
        }
        int i4 = 3;
        int i5 = 1;
        if (Build.VERSION.SDK_INT >= 17) {
            i4 = 7;
        }
        if ((i2 & i4) == 0) {
            i5 = 0;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (n.c()) {
            z = powerManager.isInteractive();
        } else {
            z = powerManager.isScreenOn();
        }
        if (z) {
            i3 = 2;
        }
        return i3 | i5;
    }

    public static synchronized float b(Context context) {
        synchronized (s.class) {
            if (SystemClock.elapsedRealtime() - f8996b >= 60000 || Float.isNaN(f8997c)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f8995a);
                if (registerReceiver != null) {
                    f8997c = ((float) registerReceiver.getIntExtra(H5PermissionManager.level, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                f8996b = SystemClock.elapsedRealtime();
                float f2 = f8997c;
                return f2;
            }
            float f3 = f8997c;
            return f3;
        }
    }
}
