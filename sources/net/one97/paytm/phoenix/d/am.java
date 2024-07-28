package net.one97.paytm.phoenix.d;

import net.one97.paytm.phoenix.core.a;

public final class am extends a {
    public am() {
        super("paytmGetAddress");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
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
            if (r11 == 0) goto L_0x0129
            android.app.Activity r11 = r10.getActivity()
            r0 = 0
            if (r11 == 0) goto L_0x0038
            android.app.Activity r11 = r10.getActivity()
            if (r11 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            boolean r11 = r11 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r11 == 0) goto L_0x0038
            android.app.Activity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0030
            net.one97.paytm.phoenix.ui.PhoenixActivity r11 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r11
            goto L_0x0039
        L_0x0030:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r10.<init>(r11)
            throw r10
        L_0x0038:
            r11 = r0
        L_0x0039:
            r1 = 0
            if (r11 != 0) goto L_0x003d
            return r1
        L_0x003d:
            org.json.JSONObject r2 = r10.getParams()
            r3 = 0
            if (r2 == 0) goto L_0x004e
            java.lang.String r5 = "latitude"
            double r5 = r2.getDouble(r5)     // Catch:{ Exception -> 0x004c }
            goto L_0x004f
        L_0x004c:
            r11 = move-exception
            goto L_0x0058
        L_0x004e:
            r5 = r3
        L_0x004f:
            if (r2 == 0) goto L_0x0064
            java.lang.String r7 = "longitude"
            double r7 = r2.getDouble(r7)     // Catch:{ Exception -> 0x004c }
            goto L_0x0065
        L_0x0058:
            r11.printStackTrace()
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            java.lang.String r0 = "invalid parameter!"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r0)
            goto L_0x0129
        L_0x0064:
            r7 = r3
        L_0x0065:
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0122
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x006f
            goto L_0x0122
        L_0x006f:
            net.one97.paytm.phoenix.util.g r2 = net.one97.paytm.phoenix.util.g.f59641a     // Catch:{ Exception -> 0x011a }
            r2 = r11
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x011a }
            boolean r2 = net.one97.paytm.phoenix.util.g.a((android.content.Context) r2)     // Catch:{ Exception -> 0x011a }
            if (r2 == 0) goto L_0x0112
            android.location.Geocoder r2 = new android.location.Geocoder     // Catch:{ Exception -> 0x011a }
            android.content.Context r11 = (android.content.Context) r11     // Catch:{ Exception -> 0x011a }
            java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x011a }
            r2.<init>(r11, r3)     // Catch:{ Exception -> 0x011a }
            r11 = 1
            r3 = r5
            r5 = r7
            r7 = r11
            java.util.List r11 = r2.getFromLocation(r3, r5, r7)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "addresses"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x011a }
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch:{ Exception -> 0x011a }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x011a }
            boolean r2 = r11.hasNext()     // Catch:{ Exception -> 0x011a }
            if (r2 == 0) goto L_0x0129
            java.lang.Object r11 = r11.next()     // Catch:{ Exception -> 0x011a }
            android.location.Address r11 = (android.location.Address) r11     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "address"
            java.lang.String r3 = r11.getAddressLine(r1)     // Catch:{ Exception -> 0x011a }
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x00af
            r3 = r4
        L_0x00af:
            r9.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "locality"
            java.lang.String r3 = "it"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r3 = r11.getLocality()     // Catch:{ Exception -> 0x011a }
            if (r3 != 0) goto L_0x00c0
            r3 = r4
        L_0x00c0:
            r9.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "subLocality"
            java.lang.String r3 = r11.getSubLocality()     // Catch:{ Exception -> 0x011a }
            if (r3 != 0) goto L_0x00cd
            r3 = r4
        L_0x00cd:
            r9.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "admin"
            java.lang.String r3 = r11.getAdminArea()     // Catch:{ Exception -> 0x011a }
            if (r3 != 0) goto L_0x00d9
            r3 = r4
        L_0x00d9:
            r9.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "subAdmin"
            java.lang.String r3 = r11.getSubAdminArea()     // Catch:{ Exception -> 0x011a }
            if (r3 != 0) goto L_0x00e6
            r3 = r4
        L_0x00e6:
            r9.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "postalCode"
            java.lang.String r3 = r11.getPostalCode()     // Catch:{ Exception -> 0x011a }
            if (r3 != 0) goto L_0x00f2
            r3 = r4
        L_0x00f2:
            r9.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "countryCode"
            java.lang.String r3 = r11.getCountryCode()     // Catch:{ Exception -> 0x011a }
            if (r3 != 0) goto L_0x00fe
            r3 = r4
        L_0x00fe:
            r9.a((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r2 = "countryName"
            java.lang.String r11 = r11.getCountryName()     // Catch:{ Exception -> 0x011a }
            if (r11 != 0) goto L_0x010a
            r11 = r4
        L_0x010a:
            r9.a((java.lang.String) r2, (java.lang.Object) r11)     // Catch:{ Exception -> 0x011a }
            r11 = 6
            net.one97.paytm.phoenix.core.a.a(r9, r10, r0, r1, r11)     // Catch:{ Exception -> 0x011a }
            goto L_0x0129
        L_0x0112:
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.FORBIDDEN     // Catch:{ Exception -> 0x011a }
            java.lang.String r0 = "Network Not available"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x011a }
            goto L_0x0129
        L_0x011a:
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r0 = "Service not Available"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r0)
            goto L_0x0129
        L_0x0122:
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r0 = "latitude or longitude cannot be null or 0"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r0)
        L_0x0129:
            r10 = 1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.am.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
