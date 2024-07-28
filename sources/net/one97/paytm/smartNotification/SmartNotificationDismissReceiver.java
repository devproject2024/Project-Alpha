package net.one97.paytm.smartNotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmartNotificationDismissReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            intent.getExtras();
        }
    }
}
