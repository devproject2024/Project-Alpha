package net.one97.paytm.phoenix.d;

import net.one97.paytm.phoenix.core.a;

public final class aq extends a {
    public aq() {
        super("setLandscape", "setPortrait");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r9, net.one97.paytm.phoenix.api.b r10) {
        /*
            r8 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r10, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.b) r10)
            b(r9, r10)
            android.app.Activity r10 = r9.getActivity()
            r0 = 0
            if (r10 == 0) goto L_0x0035
            android.app.Activity r10 = r9.getActivity()
            if (r10 != 0) goto L_0x0020
            kotlin.g.b.k.a()
        L_0x0020:
            boolean r10 = r10 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r10 == 0) goto L_0x0035
            android.app.Activity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x002d
            net.one97.paytm.phoenix.ui.PhoenixActivity r10 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r10
            goto L_0x0036
        L_0x002d:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            r10 = r0
        L_0x0036:
            r1 = 0
            if (r10 != 0) goto L_0x003a
            return r1
        L_0x003a:
            java.lang.String r2 = r9.getAction$phoenix_debug()
            r3 = 1
            if (r2 == 0) goto L_0x007a
            int r4 = r2.hashCode()
            r5 = -1576379875(0xffffffffa20a5a1d, float:-1.8750193E-18)
            r6 = 2
            java.lang.String r7 = "success"
            if (r4 == r5) goto L_0x0067
            r5 = -1324931975(0xffffffffb1072479, float:-1.9665818E-9)
            if (r4 == r5) goto L_0x0053
            goto L_0x007a
        L_0x0053:
            java.lang.String r4 = "setLandscape"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x007a
            r10.setRequestedOrientation(r1)
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r8.a((java.lang.String) r7, (java.lang.Object) r10)
            net.one97.paytm.phoenix.core.a.a(r8, r9, r0, r3, r6)
            goto L_0x007a
        L_0x0067:
            java.lang.String r1 = "setPortrait"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x007a
            r10.setRequestedOrientation(r3)
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r8.a((java.lang.String) r7, (java.lang.Object) r10)
            net.one97.paytm.phoenix.core.a.a(r8, r9, r0, r3, r6)
        L_0x007a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.aq.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
