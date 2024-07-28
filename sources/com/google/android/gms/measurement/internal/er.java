package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.zzv;

public final class er {

    /* renamed from: a  reason: collision with root package name */
    private final es f11897a;

    public er(es esVar) {
        s.a(esVar);
        this.f11897a = esVar;
    }

    public static boolean a(Context context) {
        ActivityInfo receiverInfo;
        s.a(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void a(Context context, Intent intent) {
        fc a2 = fc.a(context, (zzv) null);
        dy J_ = a2.J_();
        if (intent == null) {
            J_.f11831f.a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        J_.k.a("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            J_.k.a("Starting wakeful intent.");
            this.f11897a.a(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                a2.K_().a((Runnable) new eq(a2, J_));
            } catch (Exception e2) {
                J_.f11831f.a("Install Referrer Reporter encountered a problem", e2);
            }
            BroadcastReceiver.PendingResult a3 = this.f11897a.a();
            String stringExtra = intent.getStringExtra(Payload.REFERRER);
            if (stringExtra == null) {
                J_.k.a("Install referrer extras are null");
                if (a3 != null) {
                    a3.finish();
                    return;
                }
                return;
            }
            J_.f11834i.a("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            Bundle a4 = a2.e().a(Uri.parse(stringExtra));
            if (a4 == null) {
                J_.k.a("No campaign defined in install referrer broadcast");
                if (a3 != null) {
                    a3.finish();
                    return;
                }
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0) * 1000;
            if (longExtra == 0) {
                J_.f11831f.a("Install referrer is missing timestamp");
            }
            a2.K_().a((Runnable) new et(a2, longExtra, a4, context, J_, a3));
        }
    }
}
