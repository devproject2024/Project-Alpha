package net.one97.paytm.phoenix.d;

import com.alipay.mobile.h5container.api.H5Plugin;
import net.one97.paytm.phoenix.core.a;

public final class s extends a {
    public s() {
        super(H5Plugin.CommonEvents.TOAST, "paytmToast");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r8, net.one97.paytm.phoenix.api.b r9) {
        /*
            r7 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r9, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.b) r9)
            boolean r9 = r7.a((net.one97.paytm.phoenix.api.H5Event) r8)
            r0 = 1
            if (r9 == 0) goto L_0x00f9
            android.app.Activity r9 = r8.getActivity()
            r1 = 0
            if (r9 == 0) goto L_0x0039
            android.app.Activity r9 = r8.getActivity()
            if (r9 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            boolean r9 = r9 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r9 == 0) goto L_0x0039
            android.app.Activity r9 = r8.getActivity()
            if (r9 == 0) goto L_0x0031
            net.one97.paytm.phoenix.ui.PhoenixActivity r9 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r9
            goto L_0x003a
        L_0x0031:
            kotlin.u r8 = new kotlin.u
            java.lang.String r9 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            r9 = r1
        L_0x003a:
            r2 = 0
            if (r9 != 0) goto L_0x003e
            return r2
        L_0x003e:
            java.lang.String r3 = r8.getAction$phoenix_debug()
            if (r3 != 0) goto L_0x0046
            goto L_0x00f9
        L_0x0046:
            int r4 = r3.hashCode()
            r5 = -559645306(0xffffffffdea47d86, float:-5.9263886E18)
            r6 = 6
            if (r4 == r5) goto L_0x0081
            r9 = 110532135(0x6969627, float:5.664436E-35)
            if (r4 == r9) goto L_0x0057
            goto L_0x00f9
        L_0x0057:
            java.lang.String r9 = "toast"
            boolean r9 = r3.equals(r9)
            if (r9 == 0) goto L_0x00f9
            net.one97.paytm.phoenix.util.j r9 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r9 = "PhoenixAlertPlugin"
            java.lang.String r3 = "handleEvent"
            net.one97.paytm.phoenix.util.j.a(r9, r3)
            java.lang.String r9 = "key1"
            java.lang.String r3 = "value1"
            r7.a((java.lang.String) r9, (java.lang.Object) r3)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "key2"
            r7.a((java.lang.String) r3, (java.lang.Object) r9)
            net.one97.paytm.phoenix.core.a.a(r7, r8, r1, r2, r6)
            goto L_0x00f9
        L_0x0081:
            java.lang.String r4 = "paytmToast"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00f9
            org.json.JSONObject r3 = r8.getParams()
            if (r3 == 0) goto L_0x0096
            java.lang.String r4 = "message"
            java.lang.String r4 = r3.optString(r4)
            goto L_0x0097
        L_0x0096:
            r4 = r1
        L_0x0097:
            if (r3 == 0) goto L_0x00a0
            java.lang.String r5 = "isShort"
            java.lang.String r3 = r3.optString(r5)
            goto L_0x00a1
        L_0x00a0:
            r3 = r1
        L_0x00a1:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x00af
            net.one97.paytm.phoenix.api.a r9 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r7.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.a) r9, "")
            goto L_0x00f9
        L_0x00af:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00be
            net.one97.paytm.phoenix.api.a r9 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            r7.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.a) r9, "")
            goto L_0x00f9
        L_0x00be:
            if (r3 == 0) goto L_0x00f4
            java.lang.String r5 = "true"
            boolean r5 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r0)
            if (r5 == 0) goto L_0x00d2
            android.content.Context r9 = (android.content.Context) r9
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r4, r2)
            r9.show()
            goto L_0x00e3
        L_0x00d2:
            java.lang.String r5 = "false"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r0)
            if (r3 == 0) goto L_0x00ee
            android.content.Context r9 = (android.content.Context) r9
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r4, r0)
            r9.show()
        L_0x00e3:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            java.lang.String r3 = "success"
            r7.a((java.lang.String) r3, (java.lang.Object) r9)
            net.one97.paytm.phoenix.core.a.a(r7, r8, r1, r2, r6)
            goto L_0x00f9
        L_0x00ee:
            net.one97.paytm.phoenix.api.a r9 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            r7.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.a) r9, "")
            goto L_0x00f9
        L_0x00f4:
            net.one97.paytm.phoenix.api.a r9 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            r7.a((net.one97.paytm.phoenix.api.H5Event) r8, (net.one97.paytm.phoenix.api.a) r9, "")
        L_0x00f9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.s.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
