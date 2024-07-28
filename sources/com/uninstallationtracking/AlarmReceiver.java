package com.uninstallationtracking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        b.a();
        context.startService(new Intent(context, AliveService.class));
    }
}
