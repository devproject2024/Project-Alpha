package com.paytm.location;

import android.content.BroadcastReceiver;

public final class RebootReceiver extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        r5 = (r5 = r5.f40913a).f40920a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "intent"
            kotlin.g.b.k.c(r5, r0)
            com.paytm.a.a.b$b r5 = com.paytm.a.a.b.f40832a
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "Device is Rebooted"
            r5.b(r2, r1)
            com.paytm.analytics.b$b r5 = com.paytm.analytics.b.f40911e
            boolean r5 = com.paytm.analytics.b.C0683b.a()
            if (r5 == 0) goto L_0x0096
            com.paytm.analytics.b$b r5 = com.paytm.analytics.b.f40911e
            com.paytm.analytics.b r5 = com.paytm.analytics.b.f40912i
            if (r5 == 0) goto L_0x0031
            com.paytm.analytics.b.a r5 = r5.f40913a
            if (r5 == 0) goto L_0x0031
            com.paytm.analytics.models.Config r5 = r5.f40920a
            if (r5 == 0) goto L_0x0031
            java.lang.Boolean r5 = r5.isLocationEnable()
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r1)
            r1 = 1
            r5 = r5 ^ r1
            if (r5 != 0) goto L_0x0096
            com.paytm.location.a r5 = com.paytm.location.a.f42839a
            boolean r5 = com.paytm.location.a.a(r4)
            if (r5 != 0) goto L_0x0045
            goto L_0x0096
        L_0x0045:
            com.paytm.location.a r5 = com.paytm.location.a.f42839a
            int r5 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r5 >= r2) goto L_0x0052
            boolean r4 = com.paytm.location.a.a(r4)
            goto L_0x0062
        L_0x0052:
            if (r4 != 0) goto L_0x0057
            kotlin.g.b.k.a()
        L_0x0057:
            java.lang.String r5 = "android.permission.ACCESS_BACKGROUND_LOCATION"
            int r4 = androidx.core.app.a.a((android.content.Context) r4, (java.lang.String) r5)
            if (r4 != 0) goto L_0x0061
            r4 = 1
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            if (r4 == 0) goto L_0x007d
            com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r0 = "Rebooted - Starting Location Job from RebootReceiver"
            r4.b(r0, r5)
            com.paytm.analytics.b$b r4 = com.paytm.analytics.b.f40911e
            com.paytm.analytics.b r4 = com.paytm.analytics.b.f40912i
            if (r4 == 0) goto L_0x007c
            com.paytm.location.a.a r4 = r4.f40914b
            if (r4 == 0) goto L_0x007c
            r4.c()
        L_0x007c:
            return
        L_0x007d:
            com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r0 = "Rebooted - no bg permission so stopping any Location Job "
            r4.b(r0, r5)
            com.paytm.analytics.b$b r4 = com.paytm.analytics.b.f40911e
            com.paytm.analytics.b r4 = com.paytm.analytics.b.f40912i
            if (r4 == 0) goto L_0x0095
            com.paytm.location.a.a r4 = r4.f40914b
            if (r4 == 0) goto L_0x0095
            r4.d()
        L_0x0095:
            return
        L_0x0096:
            com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r0 = "Location is disabled"
            r4.a(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.location.RebootReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
