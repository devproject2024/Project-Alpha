package com.paytm.signal.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paytm.signal.schedulers.c;
import kotlin.g.b.k;

public final class TimeChangeReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        c cVar = c.f43662a;
        c.a(context);
    }
}
