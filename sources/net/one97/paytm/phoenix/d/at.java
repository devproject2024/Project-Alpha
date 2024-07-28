package net.one97.paytm.phoenix.d;

import com.business.merchant_payments.common.utility.AppConstants;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.util.f;
import net.one97.paytm.phoenix.util.j;

public final class at extends a {
    public at() {
        super("paytmCheckPermission");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
        if (a(r10, r3, r4) != -1) goto L_0x00b6;
     */
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
            if (r11 == 0) goto L_0x00f5
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
            org.json.JSONObject r3 = r10.getParams()
            if (r3 == 0) goto L_0x004b
            java.lang.String r4 = "permission"
            java.lang.String r3 = r3.optString(r4)
            goto L_0x004c
        L_0x004b:
            r3 = r1
        L_0x004c:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            if (r3 == 0) goto L_0x00b6
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.String r6 = ","
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r7, false)
            r8 = -1
            if (r7 == 0) goto L_0x00b0
            java.lang.String[] r3 = new java.lang.String[]{r6}
            java.util.List r3 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.String[]) r3)
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0077
            net.one97.paytm.phoenix.api.a r5 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r6 = "invalid params"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r5, (java.lang.String) r6)
        L_0x0077:
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x007d:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00b6
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r7 = r6.length()
            if (r7 <= 0) goto L_0x0094
            r7 = 1
            goto L_0x0095
        L_0x0094:
            r7 = 0
        L_0x0095:
            if (r7 == 0) goto L_0x007d
            if (r5 == 0) goto L_0x00a8
            java.lang.CharSequence r5 = kotlin.m.p.b(r6)
            java.lang.String r5 = r5.toString()
            int r5 = r9.a(r10, r5, r4)
            if (r5 == r8) goto L_0x00f5
            goto L_0x007d
        L_0x00a8:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type kotlin.CharSequence"
            r10.<init>(r11)
            throw r10
        L_0x00b0:
            int r3 = r9.a(r10, r3, r4)
            if (r3 == r8) goto L_0x00f5
        L_0x00b6:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r3 = r4.iterator()
        L_0x00bc:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00f1
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r5 = r11
            android.content.Context r5 = (android.content.Context) r5
            int r5 = androidx.core.content.b.a((android.content.Context) r5, (java.lang.String) r4)
            if (r5 != 0) goto L_0x00e1
            java.lang.String r5 = net.one97.paytm.phoenix.util.f.a((java.lang.String) r4)
            if (r5 != 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r4 = r5
        L_0x00d9:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r9.a((java.lang.String) r4, (java.lang.Object) r5)
            goto L_0x00bc
        L_0x00e1:
            java.lang.String r5 = net.one97.paytm.phoenix.util.f.a((java.lang.String) r4)
            if (r5 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r4 = r5
        L_0x00e9:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r9.a((java.lang.String) r4, (java.lang.Object) r5)
            goto L_0x00bc
        L_0x00f1:
            r11 = 6
            net.one97.paytm.phoenix.core.a.a(r9, r10, r1, r2, r11)
        L_0x00f5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.at.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    private int a(H5Event h5Event, String str, ArrayList<String> arrayList) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(str, "rawPermission");
        k.c(arrayList, "array");
        String[] b2 = f.b(str);
        if (b2 == null) {
            j jVar = j.f59646a;
            j.b("PhoenixPermissionCheckPlugin", "invalid permission name");
            a(h5Event, net.one97.paytm.phoenix.api.a.INVALID_PARAM, "invalid params");
            return -1;
        }
        kotlin.a.k.a(arrayList, (T[]) b2);
        return 0;
    }
}
