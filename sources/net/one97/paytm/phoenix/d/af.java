package net.one97.paytm.phoenix.d;

import com.alipay.mobile.h5container.api.H5Plugin;
import net.one97.paytm.phoenix.core.a;

public final class af extends a {
    public af() {
        super(H5Plugin.CommonEvents.EXIT_SESSION);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r5, net.one97.paytm.phoenix.api.b r6) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r6, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r5, (net.one97.paytm.phoenix.api.b) r6)
            android.app.Activity r6 = r5.getActivity()
            r0 = 0
            if (r6 == 0) goto L_0x0032
            android.app.Activity r6 = r5.getActivity()
            if (r6 != 0) goto L_0x001d
            kotlin.g.b.k.a()
        L_0x001d:
            boolean r6 = r6 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r6 == 0) goto L_0x0032
            android.app.Activity r6 = r5.getActivity()
            if (r6 == 0) goto L_0x002a
            net.one97.paytm.phoenix.ui.PhoenixActivity r6 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r6
            goto L_0x0033
        L_0x002a:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            r6 = r0
        L_0x0033:
            r1 = 0
            if (r6 != 0) goto L_0x0037
            return r1
        L_0x0037:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = "success"
            r4.a((java.lang.String) r3, (java.lang.Object) r2)
            r2 = 6
            net.one97.paytm.phoenix.core.a.a(r4, r5, r0, r1, r2)
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r0 = "PHOENIX_EXIT_SESSION_INTENT"
            r5.<init>(r0)
            android.content.Context r6 = (android.content.Context) r6
            androidx.localbroadcastmanager.a.a r6 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r6)
            r6.a((android.content.Intent) r5)
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.af.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
