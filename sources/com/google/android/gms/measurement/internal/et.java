package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzv;

final class et implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fc f11898a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f11899b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f11900c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Context f11901d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ dy f11902e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ BroadcastReceiver.PendingResult f11903f;

    et(fc fcVar, long j, Bundle bundle, Context context, dy dyVar, BroadcastReceiver.PendingResult pendingResult) {
        this.f11898a = fcVar;
        this.f11899b = j;
        this.f11900c = bundle;
        this.f11901d = context;
        this.f11902e = dyVar;
        this.f11903f = pendingResult;
    }

    public final void run() {
        long a2 = this.f11898a.b().f11866i.a();
        long j = this.f11899b;
        if (a2 > 0 && (j >= a2 || j <= 0)) {
            j = a2 - 1;
        }
        if (j > 0) {
            this.f11900c.putLong("click_timestamp", j);
        }
        this.f11900c.putString("_cis", "referrer broadcast");
        fc.a(this.f11901d, (zzv) null).d().a("auto", "_cmp", this.f11900c);
        this.f11902e.k.a("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.f11903f;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
