package net.one97.paytm.paymentsBank.slfd.createfd.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class SlfdLandingPageActivity$refreshDataBroadcast$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SlfdLandingPageActivity f19118a;

    SlfdLandingPageActivity$refreshDataBroadcast$1(SlfdLandingPageActivity slfdLandingPageActivity) {
        this.f19118a = slfdLandingPageActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("intent.action.updateSlfdLanding".equals(intent != null ? intent.getAction() : null)) {
            this.f19118a.p = true;
        }
    }
}
