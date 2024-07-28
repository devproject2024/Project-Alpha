package com.uninstallationtracking;

import android.app.IntentService;
import android.content.Intent;

public class AliveService extends IntentService {
    public AliveService() {
        super("TrackingService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        new a(getApplicationContext());
        String uuid = a.a().toString();
        b.a();
        b.a(getApplicationContext(), uuid, "alarm");
    }
}
