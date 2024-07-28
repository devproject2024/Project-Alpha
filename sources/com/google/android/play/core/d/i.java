package com.google.android.play.core.d;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.b.b;
import com.google.android.play.core.c.c;

public final class i extends c<d> {

    /* renamed from: a  reason: collision with root package name */
    private static i f37423a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f37424b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final ad f37425c;

    private i(Context context, ad adVar) {
        super(new b("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f37425c = adVar;
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f37423a == null) {
                f37423a = new i(context, at.f37361a);
            }
            iVar = f37423a;
        }
        return iVar;
    }

    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            d a2 = d.a(bundleExtra);
            this.f37334d.a("ListenerRegistryBroadcastReceiver.onReceive: %s", a2);
            ae a3 = this.f37425c.a();
            if (a2.b() == 3 && a3 != null) {
                a3.a(a2.k(), new g(this, a2, intent, context));
            } else {
                a(a2);
            }
        }
    }
}
