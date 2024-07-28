package net.one97.paytm.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import kotlin.m.l;

public final class KycLocationUtility$getGpsReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f49590a;

    KycLocationUtility$getGpsReceiver$1(g gVar) {
        this.f49590a = gVar;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        String action = intent.getAction();
        if (action == null) {
            k.a();
        }
        if (!new l("android.location.PROVIDERS_CHANGED").matches(action)) {
            return;
        }
        if (this.f49590a.g() && this.f49590a.q && this.f49590a.s && this.f49590a.u) {
            this.f49590a.s = false;
            this.f49590a.i();
        } else if (!this.f49590a.g() && this.f49590a.u && this.f49590a.p == null) {
            this.f49590a.s = true;
            this.f49590a.f49608b.aG_();
        }
    }
}
