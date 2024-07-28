package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.a;
import com.google.android.gms.internal.measurement.bs;

final class eo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ bs f11890a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f11891b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ep f11892c;

    eo(ep epVar, bs bsVar, ServiceConnection serviceConnection) {
        this.f11892c = epVar;
        this.f11890a = bsVar;
        this.f11891b = serviceConnection;
    }

    public final void run() {
        em emVar = this.f11892c.f11893a;
        String a2 = this.f11892c.f11894b;
        bs bsVar = this.f11890a;
        ServiceConnection serviceConnection = this.f11891b;
        Bundle a3 = emVar.a(a2, bsVar);
        emVar.f11884a.K_().h();
        if (a3 != null) {
            long j = a3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                emVar.f11884a.J_().f11828c.a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    emVar.f11884a.J_().f11828c.a("No referrer defined in install referrer response");
                } else {
                    emVar.f11884a.J_().k.a("InstallReferrer API result", string);
                    jq e2 = emVar.f11884a.e();
                    String valueOf = String.valueOf(string);
                    Bundle a4 = e2.a(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (a4 == null) {
                        emVar.f11884a.J_().f11828c.a("No campaign params defined in install referrer result");
                    } else {
                        String string2 = a4.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = a3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                emVar.f11884a.J_().f11828c.a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                a4.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == emVar.f11884a.b().j.a()) {
                            emVar.f11884a.J_().k.a("Campaign has already been logged");
                        } else {
                            emVar.f11884a.b().j.a(j);
                            emVar.f11884a.J_().k.a("Logging Install Referrer campaign from sdk with ", "referrer API");
                            a4.putString("_cis", "referrer API");
                            emVar.f11884a.d().a("auto", "_cmp", a4);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            a.a();
            a.a(emVar.f11884a.k(), serviceConnection);
        }
    }
}
