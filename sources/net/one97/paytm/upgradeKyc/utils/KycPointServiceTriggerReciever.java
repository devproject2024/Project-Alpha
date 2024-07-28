package net.one97.paytm.upgradeKyc.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.KycJobIntentService;
import kotlin.g.b.k;

public final class KycPointServiceTriggerReciever extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        if (intent != null && k.a((Object) intent.getAction(), (Object) "KycPointServiceTriggerReciever")) {
            String packageName = context != null ? context.getPackageName() : null;
            if (packageName == null) {
                k.a();
            }
            KycJobIntentService.a(context, new ComponentName(packageName, KycPointsNotifierService.class.getName()), 9999, intent);
        }
    }
}
