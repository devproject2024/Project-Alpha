package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.s;

class ef extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11848a = ef.class.getName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final jj f11849b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11850c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11851d;

    ef(jj jjVar) {
        s.a(jjVar);
        this.f11849b = jjVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.f11849b.g();
        String action = intent.getAction();
        this.f11849b.J_().k.a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean b2 = this.f11849b.b().b();
            if (this.f11851d != b2) {
                this.f11851d = b2;
                this.f11849b.K_().a((Runnable) new ei(this, b2));
                return;
            }
            return;
        }
        this.f11849b.J_().f11831f.a("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void a() {
        this.f11849b.g();
        this.f11849b.K_().h();
        if (!this.f11850c) {
            this.f11849b.k().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f11851d = this.f11849b.b().b();
            this.f11849b.J_().k.a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f11851d));
            this.f11850c = true;
        }
    }

    public final void b() {
        this.f11849b.g();
        this.f11849b.K_().h();
        this.f11849b.K_().h();
        if (this.f11850c) {
            this.f11849b.J_().k.a("Unregistering connectivity change receiver");
            this.f11850c = false;
            this.f11851d = false;
            try {
                this.f11849b.k().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f11849b.J_().f11828c.a("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }
}
