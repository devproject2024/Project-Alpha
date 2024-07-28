package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.google.android.gms.common.c.b;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.stats.a;
import com.google.android.gms.internal.measurement.bs;
import java.util.List;

public final class em {

    /* renamed from: a  reason: collision with root package name */
    final fc f11884a;

    em(fc fcVar) {
        this.f11884a = fcVar;
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.f11884a.J_().f11834i.a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f11884a.K_().h();
        if (!a()) {
            this.f11884a.J_().f11834i.a("Install Referrer Reporter is not available");
            return;
        }
        this.f11884a.J_().f11834i.a("Install Referrer Reporter is initializing");
        ep epVar = new ep(this, str);
        this.f11884a.K_().h();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f11884a.k().getPackageManager();
        if (packageManager == null) {
            this.f11884a.J_().f11831f.a("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f11884a.J_().f11834i.a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str2 = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !a()) {
                this.f11884a.J_().f11834i.a("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            Intent intent2 = new Intent(intent);
            try {
                a.a();
                this.f11884a.J_().f11834i.a("Install Referrer Service is", a.b(this.f11884a.k(), intent2, epVar, 1) ? "available" : "not available");
            } catch (Exception e2) {
                this.f11884a.J_().f11828c.a("Exception occurred while binding to Install Referrer Service", e2.getMessage());
            }
        }
    }

    private final boolean a() {
        try {
            b a2 = c.a(this.f11884a.k());
            if (a2 == null) {
                this.f11884a.J_().f11834i.a("Failed to retrieve Package Manager to check Play Store compatibility");
                return false;
            } else if (a2.b("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            this.f11884a.J_().f11834i.a("Failed to retrieve Play Store version", e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle a(String str, bs bsVar) {
        this.f11884a.K_().h();
        if (bsVar == null) {
            this.f11884a.J_().f11831f.a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle a2 = bsVar.a(bundle);
            if (a2 != null) {
                return a2;
            }
            this.f11884a.J_().f11828c.a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e2) {
            this.f11884a.J_().f11828c.a("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }
}
