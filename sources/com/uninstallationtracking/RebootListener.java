package com.uninstallationtracking;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class RebootListener extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        b.a();
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 12345, new Intent(context, AlarmReceiver.class), 134217728);
        ((AlarmManager) context.getSystemService("alarm")).setInexactRepeating(0, System.currentTimeMillis(), b.f45709a, broadcast);
    }
}
