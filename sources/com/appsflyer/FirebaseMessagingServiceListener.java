package com.appsflyer;

import com.appsflyer.internal.af;
import com.appsflyer.internal.c;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        super.onNewToken(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            c.a.C0085c r2 = c.a.C0085c.m175(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            c.a.C0085c cVar = new c.a.C0085c(currentTimeMillis, str);
            if (r2.m178(cVar)) {
                af.m128(getApplicationContext(), cVar.f235);
            }
        }
    }
}
