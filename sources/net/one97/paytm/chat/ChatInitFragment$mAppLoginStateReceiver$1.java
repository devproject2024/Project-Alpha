package net.one97.paytm.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.paytm.utility.a;
import kotlin.g.b.k;

public final class ChatInitFragment$mAppLoginStateReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatInitFragment f49573a;

    ChatInitFragment$mAppLoginStateReceiver$1(ChatInitFragment chatInitFragment) {
        this.f49573a = chatInitFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        if (!k.a((Object) "action_update_login_status", (Object) intent.getAction())) {
            return;
        }
        if (!a.p(context) || TextUtils.isEmpty(a.a((Context) this.f49573a.getActivity()))) {
            this.f49573a.b();
            this.f49573a.c();
            return;
        }
        this.f49573a.a();
        this.f49573a.b();
    }
}
