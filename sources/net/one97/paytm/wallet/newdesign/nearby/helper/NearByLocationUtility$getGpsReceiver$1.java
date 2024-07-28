package net.one97.paytm.wallet.newdesign.nearby.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import kotlin.m.l;

public final class NearByLocationUtility$getGpsReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f71112a;

    NearByLocationUtility$getGpsReceiver$1(b bVar) {
        this.f71112a = bVar;
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
        if (this.f71112a.a() && this.f71112a.f71117a && this.f71112a.f71119c && this.f71112a.f71120d) {
            this.f71112a.f71119c = false;
            this.f71112a.e();
        } else if (!this.f71112a.a() && this.f71112a.f71120d && this.f71112a.t == null) {
            this.f71112a.f71119c = true;
            this.f71112a.f71122f.d();
        }
    }
}
