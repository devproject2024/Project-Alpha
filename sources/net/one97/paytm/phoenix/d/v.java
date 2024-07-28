package net.one97.paytm.phoenix.d;

import net.one97.paytm.phoenix.core.a;

public final class v extends a {
    public v() {
        super("paytmAppsFlyerSendEvent");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r12, net.one97.paytm.phoenix.api.b r13) {
        /*
            r11 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r13, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.b) r13)
            boolean r13 = r11.a((net.one97.paytm.phoenix.api.H5Event) r12)
            if (r13 == 0) goto L_0x00dc
            net.one97.paytm.phoenix.core.c r13 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r13 = r13.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixAppsFlerSendEventProvider> r0 = net.one97.paytm.phoenix.provider.PhoenixAppsFlerSendEventProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "PhoenixAppsFlerSendEventProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Object r13 = r13.a(r0)
            net.one97.paytm.phoenix.provider.PhoenixAppsFlerSendEventProvider r13 = (net.one97.paytm.phoenix.provider.PhoenixAppsFlerSendEventProvider) r13
            r0 = 0
            if (r13 != 0) goto L_0x0035
            net.one97.paytm.phoenix.api.a r13 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r1 = "No implementation found for 'PhoenixGenerateShortLinkProvider'"
            r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.a) r13, (java.lang.String) r1)
            return r0
        L_0x0035:
            android.app.Activity r1 = r12.getActivity()
            r2 = 0
            if (r1 == 0) goto L_0x005a
            android.app.Activity r1 = r12.getActivity()
            if (r1 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            boolean r1 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r1 == 0) goto L_0x005a
            android.app.Activity r1 = r12.getActivity()
            if (r1 == 0) goto L_0x0052
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1
            goto L_0x005b
        L_0x0052:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r12.<init>(r13)
            throw r12
        L_0x005a:
            r1 = r2
        L_0x005b:
            if (r1 != 0) goto L_0x005e
            return r0
        L_0x005e:
            org.json.JSONObject r3 = r12.getParams()
            if (r3 == 0) goto L_0x006b
            java.lang.String r4 = "params"
            org.json.JSONObject r3 = r3.getJSONObject(r4)
            goto L_0x006c
        L_0x006b:
            r3 = r2
        L_0x006c:
            if (r3 == 0) goto L_0x0075
            java.lang.String r4 = "mEventName"
            java.lang.String r4 = r3.getString(r4)
            goto L_0x0076
        L_0x0075:
            r4 = r2
        L_0x0076:
            if (r3 == 0) goto L_0x007f
            java.lang.String r5 = "map"
            org.json.JSONObject r5 = r3.getJSONObject(r5)
            goto L_0x0080
        L_0x007f:
            r5 = r2
        L_0x0080:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            if (r3 == 0) goto L_0x00d7
            int r3 = r3.length()
            if (r3 == 0) goto L_0x00d7
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0097
            goto L_0x00d7
        L_0x0097:
            if (r5 == 0) goto L_0x00c3
            java.util.Iterator r3 = r5.keys()
            java.lang.String r7 = "it.keys()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r7)
        L_0x00a2:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00c3
            java.lang.Object r7 = r3.next()
            java.lang.String r7 = (java.lang.String) r7
            r8 = r6
            java.util.Map r8 = (java.util.Map) r8
            java.lang.String r9 = "key"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.String r9 = r5.getString(r7)
            java.lang.String r10 = "it.getString(key)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            r8.put(r7, r9)
            goto L_0x00a2
        L_0x00c3:
            if (r4 == 0) goto L_0x00ca
            android.content.Context r1 = (android.content.Context) r1
            r13.sendAppsFlyerEvent(r1, r4, r6)
        L_0x00ca:
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            java.lang.String r1 = "success"
            r11.a((java.lang.String) r1, (java.lang.Object) r13)
            r13 = 6
            net.one97.paytm.phoenix.core.a.a(r11, r12, r2, r0, r13)
            goto L_0x00dc
        L_0x00d7:
            net.one97.paytm.phoenix.api.a r13 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r11.a((net.one97.paytm.phoenix.api.H5Event) r12, (net.one97.paytm.phoenix.api.a) r13, "")
        L_0x00dc:
            r12 = 1
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.v.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
