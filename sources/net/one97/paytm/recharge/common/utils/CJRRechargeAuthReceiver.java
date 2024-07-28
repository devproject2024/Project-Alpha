package net.one97.paytm.recharge.common.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paytm.utility.d;

public final class CJRRechargeAuthReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null && action.hashCode() == 1785510325 && action.equals("action_update_login_status")) {
            d.c(context);
        }
    }
}
