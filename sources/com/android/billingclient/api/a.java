package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final Context f30907a;

    /* renamed from: b  reason: collision with root package name */
    final C0526a f30908b;

    a(Context context, h hVar) {
        this.f30907a = context;
        this.f30908b = new C0526a(this, hVar, (byte) 0);
    }

    /* renamed from: com.android.billingclient.api.a$a  reason: collision with other inner class name */
    class C0526a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        boolean f30909a;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final h f30911c;

        /* synthetic */ C0526a(a aVar, h hVar, byte b2) {
            this(hVar);
        }

        private C0526a(h hVar) {
            this.f30911c = hVar;
        }

        public final void onReceive(Context context, Intent intent) {
            this.f30911c.a(com.android.billingclient.a.a.a(intent, "BillingBroadcastManager"), com.android.billingclient.a.a.a(intent.getExtras()));
        }
    }
}
