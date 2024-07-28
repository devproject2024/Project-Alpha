package com.google.firebase.crashlytics.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alipay.mobile.nebula.permission.H5PermissionManager;

final class e {

    /* renamed from: a  reason: collision with root package name */
    final Float f38178a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38179b;

    private e(Float f2, boolean z) {
        this.f38179b = z;
        this.f38178a = f2;
    }

    public final int a() {
        Float f2;
        if (!this.f38179b || (f2 = this.f38178a) == null) {
            return 1;
        }
        return ((double) f2.floatValue()) < 0.99d ? 2 : 3;
    }

    public static e a(Context context) {
        Float f2 = null;
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra != -1 && (intExtra == 2 || intExtra == 5)) {
                z = true;
            }
            int intExtra2 = registerReceiver.getIntExtra(H5PermissionManager.level, -1);
            int intExtra3 = registerReceiver.getIntExtra("scale", -1);
            if (!(intExtra2 == -1 || intExtra3 == -1)) {
                f2 = Float.valueOf(((float) intExtra2) / ((float) intExtra3));
            }
        }
        return new e(f2, z);
    }
}
