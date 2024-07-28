package net.one97.paytm.phoenix.d;

import net.one97.paytm.phoenix.core.a;

public final class t extends a {
    public t() {
        super("paytmAnalyticsTracking");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r13, net.one97.paytm.phoenix.api.b r14) {
        /*
            r12 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r14, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r13, (net.one97.paytm.phoenix.api.b) r14)
            boolean r14 = r12.a((net.one97.paytm.phoenix.api.H5Event) r13)
            if (r14 == 0) goto L_0x00e7
            net.one97.paytm.phoenix.core.c r14 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r14 = r14.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixAnalyticsProvider> r0 = net.one97.paytm.phoenix.provider.PhoenixAnalyticsProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "PhoenixAnalyticsProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Object r14 = r14.a(r0)
            r0 = r14
            net.one97.paytm.phoenix.provider.PhoenixAnalyticsProvider r0 = (net.one97.paytm.phoenix.provider.PhoenixAnalyticsProvider) r0
            r14 = 0
            if (r0 != 0) goto L_0x0036
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r1 = "No implementation found for 'AnalyticsProvider'"
            r12.a((net.one97.paytm.phoenix.api.H5Event) r13, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r1)
            return r14
        L_0x0036:
            android.app.Activity r1 = r13.getActivity()
            r7 = 0
            if (r1 == 0) goto L_0x005b
            android.app.Activity r1 = r13.getActivity()
            if (r1 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            boolean r1 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r1 == 0) goto L_0x005b
            android.app.Activity r1 = r13.getActivity()
            if (r1 == 0) goto L_0x0053
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1
            goto L_0x005c
        L_0x0053:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r13.<init>(r14)
            throw r13
        L_0x005b:
            r1 = r7
        L_0x005c:
            if (r1 != 0) goto L_0x005f
            return r14
        L_0x005f:
            org.json.JSONObject r2 = r13.getParams()
            if (r2 == 0) goto L_0x006c
            java.lang.String r3 = "screenName"
            java.lang.String r3 = r2.optString(r3)
            goto L_0x006d
        L_0x006c:
            r3 = r7
        L_0x006d:
            if (r2 == 0) goto L_0x0076
            java.lang.String r4 = "eventName"
            java.lang.String r4 = r2.optString(r4)
            goto L_0x0077
        L_0x0076:
            r4 = r7
        L_0x0077:
            if (r2 == 0) goto L_0x0080
            java.lang.String r5 = "data"
            org.json.JSONObject r2 = r2.optJSONObject(r5)
            goto L_0x0081
        L_0x0080:
            r2 = r7
        L_0x0081:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x009b
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x009b
            net.one97.paytm.phoenix.api.a r14 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r0 = "screenName and eventName is empty!"
            r12.a((net.one97.paytm.phoenix.api.H5Event) r13, (net.one97.paytm.phoenix.api.a) r14, (java.lang.String) r0)
            goto L_0x00e7
        L_0x009b:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            if (r2 == 0) goto L_0x00a7
            java.util.Iterator r6 = r2.keys()
            goto L_0x00a8
        L_0x00a7:
            r6 = r7
        L_0x00a8:
            if (r6 == 0) goto L_0x00cb
        L_0x00aa:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00cb
            java.lang.Object r8 = r6.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.opt(r8)
            r10 = r5
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r11 = "key"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r11)
            java.lang.String r11 = "value"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r11)
            r10.put(r8, r9)
            goto L_0x00aa
        L_0x00cb:
            r2 = r1
            android.content.Context r2 = (android.content.Context) r2
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = r1.f59606d
            r8 = 0
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            r0.sendAnalytics(r1, r2, r3, r4, r5, r6)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r1 = "success"
            r12.a((java.lang.String) r1, (java.lang.Object) r0)
            r0 = 6
            net.one97.paytm.phoenix.core.a.a(r12, r13, r7, r14, r0)
        L_0x00e7:
            r13 = 1
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.t.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
