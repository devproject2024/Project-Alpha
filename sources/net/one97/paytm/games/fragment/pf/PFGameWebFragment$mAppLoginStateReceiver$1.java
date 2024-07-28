package net.one97.paytm.games.fragment.pf;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import net.one97.paytm.games.e.f;

public final class PFGameWebFragment$mAppLoginStateReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f35660a;

    PFGameWebFragment$mAppLoginStateReceiver$1(a aVar) {
        this.f35660a = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(intent, "intent");
        if (!f.a((Activity) this.f35660a.getActivity()) && "action_update_login_status".equals(intent.getAction())) {
            this.f35660a.c();
        }
    }
}
