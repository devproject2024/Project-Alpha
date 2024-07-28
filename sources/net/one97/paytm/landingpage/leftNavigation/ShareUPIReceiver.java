package net.one97.paytm.landingpage.leftNavigation;

import android.content.BroadcastReceiver;

public final class ShareUPIReceiver extends BroadcastReceiver {
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r4 = r4.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r3, android.content.Intent r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x000f
            android.os.Bundle r4 = r4.getExtras()
            if (r4 == 0) goto L_0x000f
            java.lang.String r0 = "UPI_ID"
            java.lang.String r4 = r4.getString(r0)
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            boolean r0 = net.one97.paytm.nativesdk.ExtensionsKt.isNotNullNotBlank(r4)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = "Flyout"
            java.lang.String r1 = "Shared_UPI"
            net.one97.paytm.landingpage.utils.g.a(r3, r0, r1, r4)
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.leftNavigation.ShareUPIReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
