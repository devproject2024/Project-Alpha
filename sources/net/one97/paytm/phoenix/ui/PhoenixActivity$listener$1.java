package net.one97.paytm.phoenix.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class PhoenixActivity$listener$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PhoenixActivity f59612a;

    PhoenixActivity$listener$1(PhoenixActivity phoenixActivity) {
        this.f59612a = phoenixActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        this.f59612a.finish();
    }
}
