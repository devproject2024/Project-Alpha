package net.one97.paytm.phoenix.d;

import net.one97.paytm.phoenix.core.a;

public final class aa extends a {
    public aa() {
        super("paytmOpenDeeplink");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r6, net.one97.paytm.phoenix.api.b r7) {
        /*
            r5 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r7, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r6, (net.one97.paytm.phoenix.api.b) r7)
            boolean r7 = r5.a((net.one97.paytm.phoenix.api.H5Event) r6)
            if (r7 == 0) goto L_0x0098
            net.one97.paytm.phoenix.core.c r7 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r7 = r7.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixDeepLinkHandlerProvider> r0 = net.one97.paytm.phoenix.provider.PhoenixDeepLinkHandlerProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "PhoenixDeepLinkHandlerProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Object r7 = r7.a(r0)
            net.one97.paytm.phoenix.provider.PhoenixDeepLinkHandlerProvider r7 = (net.one97.paytm.phoenix.provider.PhoenixDeepLinkHandlerProvider) r7
            r0 = 0
            if (r7 != 0) goto L_0x0035
            net.one97.paytm.phoenix.api.a r7 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r1 = "No implementation found for 'DeepLinkProvider'"
            r5.a((net.one97.paytm.phoenix.api.H5Event) r6, (net.one97.paytm.phoenix.api.a) r7, (java.lang.String) r1)
            return r0
        L_0x0035:
            android.app.Activity r1 = r6.getActivity()
            r2 = 0
            if (r1 == 0) goto L_0x005a
            android.app.Activity r1 = r6.getActivity()
            if (r1 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            boolean r1 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r1 == 0) goto L_0x005a
            android.app.Activity r1 = r6.getActivity()
            if (r1 == 0) goto L_0x0052
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1
            goto L_0x005b
        L_0x0052:
            kotlin.u r6 = new kotlin.u
            java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r6.<init>(r7)
            throw r6
        L_0x005a:
            r1 = r2
        L_0x005b:
            if (r1 != 0) goto L_0x005e
            return r0
        L_0x005e:
            org.json.JSONObject r3 = r6.getParams()
            if (r3 == 0) goto L_0x006b
            java.lang.String r4 = "deeplink"
            java.lang.String r3 = r3.optString(r4)
            goto L_0x006c
        L_0x006b:
            r3 = r2
        L_0x006c:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0091
            android.content.Context r1 = (android.content.Context) r1
            boolean r7 = r7.handleDeeplink(r1, r3)
            if (r7 == 0) goto L_0x0089
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.String r1 = "success"
            r5.a((java.lang.String) r1, (java.lang.Object) r7)
            r7 = 6
            net.one97.paytm.phoenix.core.a.a(r5, r6, r2, r0, r7)
            goto L_0x0098
        L_0x0089:
            net.one97.paytm.phoenix.api.a r7 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            java.lang.String r0 = "cannot handle deeplink"
            r5.a((net.one97.paytm.phoenix.api.H5Event) r6, (net.one97.paytm.phoenix.api.a) r7, (java.lang.String) r0)
            goto L_0x0098
        L_0x0091:
            net.one97.paytm.phoenix.api.a r7 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r0 = "invalid params"
            r5.a((net.one97.paytm.phoenix.api.H5Event) r6, (net.one97.paytm.phoenix.api.a) r7, (java.lang.String) r0)
        L_0x0098:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.aa.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
