package net.one97.paytm.phoenix.d;

import com.alipay.mobile.h5container.api.H5Plugin;
import net.one97.paytm.phoenix.core.a;

public final class ay extends a {
    public ay() {
        super(H5Plugin.CommonEvents.GET_SESSION_DATA, H5Plugin.CommonEvents.SET_SESSION_DATA);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r10, net.one97.paytm.phoenix.api.b r11) {
        /*
            r9 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r11, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.b) r11)
            boolean r11 = r9.a((net.one97.paytm.phoenix.api.H5Event) r10)
            r0 = 1
            if (r11 == 0) goto L_0x0116
            android.app.Activity r11 = r10.getActivity()
            r1 = 0
            if (r11 == 0) goto L_0x0039
            android.app.Activity r11 = r10.getActivity()
            if (r11 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            boolean r11 = r11 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r11 == 0) goto L_0x0039
            android.app.Activity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0031
            net.one97.paytm.phoenix.ui.PhoenixActivity r11 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r11
            goto L_0x003a
        L_0x0031:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r10.<init>(r11)
            throw r10
        L_0x0039:
            r11 = r1
        L_0x003a:
            r2 = 0
            if (r11 != 0) goto L_0x003e
            return r2
        L_0x003e:
            java.lang.String r11 = r10.getAction$phoenix_debug()
            if (r11 != 0) goto L_0x0046
            goto L_0x0116
        L_0x0046:
            int r3 = r11.hashCode()
            r4 = -663227862(0xffffffffd877f22a, float:-1.09047784E15)
            java.lang.String r5 = "key"
            if (r3 == r4) goto L_0x00aa
            r2 = 1860003230(0x6edd659e, float:3.4259517E28)
            if (r3 == r2) goto L_0x0058
            goto L_0x0116
        L_0x0058:
            java.lang.String r2 = "setSessionData"
            boolean r11 = r11.equals(r2)
            if (r11 == 0) goto L_0x0116
            org.json.JSONObject r11 = r10.getParams()
            if (r11 == 0) goto L_0x006d
            java.lang.String r2 = "data"
            org.json.JSONObject r11 = r11.optJSONObject(r2)
            goto L_0x006e
        L_0x006d:
            r11 = r1
        L_0x006e:
            if (r11 == 0) goto L_0x0075
            java.util.Iterator r2 = r11.keys()
            goto L_0x0076
        L_0x0075:
            r2 = r1
        L_0x0076:
            if (r2 == 0) goto L_0x00a5
        L_0x0078:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00a5
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r11.get(r3)
            net.one97.paytm.phoenix.util.q r6 = net.one97.paytm.phoenix.util.q.f59659b
            java.lang.String r6 = "it"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            kotlin.g.b.k.c(r3, r5)
            java.util.HashMap r6 = net.one97.paytm.phoenix.util.q.a()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.put(r3, r4)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            java.lang.String r4 = "success"
            r9.a((java.lang.String) r4, (java.lang.Object) r3)
            goto L_0x0078
        L_0x00a5:
            r11 = 2
            net.one97.paytm.phoenix.core.a.a(r9, r10, r1, r0, r11)
            goto L_0x0116
        L_0x00aa:
            java.lang.String r3 = "getSessionData"
            boolean r11 = r11.equals(r3)
            if (r11 == 0) goto L_0x0116
            org.json.JSONObject r11 = r10.getParams()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            if (r11 == 0) goto L_0x00c6
            java.lang.String r1 = "keys"
            org.json.JSONArray r1 = r11.optJSONArray(r1)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00c6
        L_0x00c4:
            r11 = move-exception
            goto L_0x010a
        L_0x00c6:
            if (r1 == 0) goto L_0x0112
            int r11 = r1.length()     // Catch:{ Exception -> 0x00c4 }
            if (r11 == 0) goto L_0x0112
            int r11 = r1.length()     // Catch:{ Exception -> 0x00c4 }
            r4 = 0
        L_0x00d3:
            if (r4 >= r11) goto L_0x0112
            java.lang.Object r6 = r1.opt(r4)     // Catch:{ Exception -> 0x00c4 }
            net.one97.paytm.phoenix.util.q r7 = net.one97.paytm.phoenix.util.q.f59659b     // Catch:{ Exception -> 0x00c4 }
            if (r6 == 0) goto L_0x0102
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00c4 }
            kotlin.g.b.k.c(r7, r5)     // Catch:{ Exception -> 0x00c4 }
            java.util.HashMap r8 = net.one97.paytm.phoenix.util.q.a()     // Catch:{ Exception -> 0x00c4 }
            boolean r8 = r8.containsKey(r7)     // Catch:{ Exception -> 0x00c4 }
            if (r8 == 0) goto L_0x00f8
            java.util.HashMap r8 = net.one97.paytm.phoenix.util.q.a()     // Catch:{ Exception -> 0x00c4 }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00fa
        L_0x00f8:
            java.lang.String r7 = ""
        L_0x00fa:
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00c4 }
            r3.put(r6, r7)     // Catch:{ Exception -> 0x00c4 }
            int r4 = r4 + 1
            goto L_0x00d3
        L_0x0102:
            kotlin.u r11 = new kotlin.u     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            r11.<init>(r1)     // Catch:{ Exception -> 0x00c4 }
            throw r11     // Catch:{ Exception -> 0x00c4 }
        L_0x010a:
            r11.printStackTrace()
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, "")
        L_0x0112:
            r11 = 4
            net.one97.paytm.phoenix.core.a.a(r9, r10, r3, r2, r11)
        L_0x0116:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ay.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
