package net.one97.paytm.phoenix.d;

import net.one97.paytm.phoenix.core.a;

public final class aw extends a {
    public aw() {
        super("paytmPushWindow", "pushWindow");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r20, net.one97.paytm.phoenix.api.b r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "event"
            kotlin.g.b.k.c(r1, r2)
            java.lang.String r2 = "bridgeContext"
            r3 = r21
            kotlin.g.b.k.c(r3, r2)
            super.a((net.one97.paytm.phoenix.api.H5Event) r20, (net.one97.paytm.phoenix.api.b) r21)
            boolean r2 = r19.a((net.one97.paytm.phoenix.api.H5Event) r20)
            r3 = 1
            if (r2 == 0) goto L_0x0143
            org.json.JSONObject r2 = r20.getParams()
            if (r2 != 0) goto L_0x0029
            net.one97.paytm.phoenix.api.a r2 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r4 = "JSONobject is null"
            r0.a((net.one97.paytm.phoenix.api.H5Event) r1, (net.one97.paytm.phoenix.api.a) r2, (java.lang.String) r4)
            goto L_0x0143
        L_0x0029:
            android.app.Activity r4 = r20.getActivity()
            r5 = 0
            if (r4 == 0) goto L_0x004e
            android.app.Activity r4 = r20.getActivity()
            if (r4 != 0) goto L_0x0039
            kotlin.g.b.k.a()
        L_0x0039:
            boolean r4 = r4 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r4 == 0) goto L_0x004e
            android.app.Activity r4 = r20.getActivity()
            if (r4 == 0) goto L_0x0046
            net.one97.paytm.phoenix.ui.PhoenixActivity r4 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r4
            goto L_0x004f
        L_0x0046:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r1.<init>(r2)
            throw r1
        L_0x004e:
            r4 = r5
        L_0x004f:
            if (r4 != 0) goto L_0x0053
            goto L_0x0143
        L_0x0053:
            java.lang.String r6 = "appId"
            java.lang.Object r6 = r2.opt(r6)
            boolean r7 = r6 instanceof java.lang.String
            if (r7 != 0) goto L_0x005e
            r6 = r5
        L_0x005e:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0064
            java.lang.String r6 = ""
        L_0x0064:
            java.lang.String r7 = "url"
            java.lang.String r9 = r2.optString(r7)
            java.lang.String r8 = "param"
            java.lang.Object r8 = r2.opt(r8)
            boolean r10 = r8 instanceof org.json.JSONObject
            if (r10 != 0) goto L_0x0076
            r8 = r5
        L_0x0076:
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            if (r8 != 0) goto L_0x007f
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
        L_0x007f:
            java.lang.String r10 = "isTransparent"
            java.lang.Object r2 = r2.opt(r10)
            boolean r10 = r2 instanceof java.lang.Boolean
            if (r10 != 0) goto L_0x008a
            r2 = r5
        L_0x008a:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            r15 = 0
            if (r2 == 0) goto L_0x0095
            boolean r2 = r2.booleanValue()
            r13 = r2
            goto L_0x0096
        L_0x0095:
            r13 = 0
        L_0x0096:
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00a8
            net.one97.paytm.phoenix.api.a r2 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r4 = "AppId or Url is null"
            r0.a((net.one97.paytm.phoenix.api.H5Event) r1, (net.one97.paytm.phoenix.api.a) r2, (java.lang.String) r4)
            goto L_0x0143
        L_0x00a8:
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            net.one97.paytm.phoenix.util.g r2 = net.one97.paytm.phoenix.util.g.f59641a
            net.one97.paytm.phoenix.util.g.a((org.json.JSONObject) r8, (android.os.Bundle) r11)
            r2 = r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00c1
            net.one97.paytm.phoenix.PhoenixManager r2 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            java.lang.String r6 = r2.getLastOpenedAppUniqueId()
        L_0x00c1:
            r8 = r6
            boolean r2 = r4.z
            if (r2 == 0) goto L_0x00cb
            java.lang.String r2 = "devModeEnabled"
            r11.putBoolean(r2, r3)
        L_0x00cb:
            boolean r2 = r4.D
            if (r2 == 0) goto L_0x00d6
            java.lang.String r2 = r4.H
            java.lang.String r6 = "appType"
            r11.putString(r6, r2)
        L_0x00d6:
            net.one97.paytm.phoenix.PhoenixManager r2 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            boolean r2 = r2.isFromDeepLinkStatus$phoenix_debug()
            java.lang.String r6 = "isFromDeeplink"
            r11.putBoolean(r6, r2)
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            r10 = 0
            net.one97.paytm.phoenix.PhoenixManager r2 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            java.util.Map r2 = r2.getMapOfTempPlugins()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r4.f59606d
            r6.append(r7)
            r21 = r13
            long r12 = r4.C
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            java.lang.Object r2 = r2.get(r6)
            r14 = r2
            java.util.List r14 = (java.util.List) r14
            net.one97.paytm.phoenix.PhoenixManager r2 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            java.util.Map r2 = r2.getMapOfTempProviders()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r12 = r4.f59606d
            r6.append(r12)
            long r12 = r4.C
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            java.lang.Object r2 = r2.get(r6)
            java.util.List r2 = (java.util.List) r2
            r16 = r4
            android.app.Activity r16 = (android.app.Activity) r16
            r17 = 16
            r18 = 0
            r4 = 0
            r12 = r4
            r13 = r21
            r4 = 0
            r15 = r2
            net.one97.paytm.phoenix.PhoenixManager.loadPage$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r6 = "success"
            r0.a((java.lang.String) r6, (java.lang.Object) r2)
            r2 = 6
            net.one97.paytm.phoenix.core.a.a(r0, r1, r5, r4, r2)
        L_0x0143:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.aw.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
