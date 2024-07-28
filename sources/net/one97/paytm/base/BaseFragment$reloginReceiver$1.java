package net.one97.paytm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class BaseFragment$reloginReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f49494a;

    BaseFragment$reloginReceiver$1(b bVar) {
        this.f49494a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            intent.getBundleExtra("extra_data");
            this.f49494a.a(intent.getStringExtra("key_relogin_tag_for_relogin"));
        }
    }
}
