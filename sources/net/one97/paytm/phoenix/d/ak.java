package net.one97.paytm.phoenix.d;

import net.one97.paytm.phoenix.core.a;

public final class ak extends a {
    public ak() {
        super("getCurrentLang");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
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
            if (r11 == 0) goto L_0x0108
            net.one97.paytm.phoenix.core.c r11 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r11 = r11.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixLanguageSelectedProvider> r1 = net.one97.paytm.phoenix.provider.PhoenixLanguageSelectedProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "PhoenixLanguageSelectedProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r11 = r11.a(r1)
            net.one97.paytm.phoenix.provider.PhoenixLanguageSelectedProvider r11 = (net.one97.paytm.phoenix.provider.PhoenixLanguageSelectedProvider) r11
            r1 = 0
            if (r11 != 0) goto L_0x0036
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r0 = "No implementation found for 'LanguageSelectedProvider'"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r0)
            return r1
        L_0x0036:
            android.app.Activity r2 = r10.getActivity()
            r3 = 0
            if (r2 == 0) goto L_0x005b
            android.app.Activity r2 = r10.getActivity()
            if (r2 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            boolean r2 = r2 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r2 == 0) goto L_0x005b
            android.app.Activity r2 = r10.getActivity()
            if (r2 == 0) goto L_0x0053
            net.one97.paytm.phoenix.ui.PhoenixActivity r2 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r2
            goto L_0x005c
        L_0x0053:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r10.<init>(r11)
            throw r10
        L_0x005b:
            r2 = r3
        L_0x005c:
            if (r2 != 0) goto L_0x005f
            return r1
        L_0x005f:
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String[] r11 = r11.getLanguageSelected(r2)
            int r2 = r11.length
            r4 = 2
            java.lang.String r5 = "No locale found"
            if (r2 != r4) goto L_0x0103
            r2 = r11[r1]
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r6 = r4
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r7 = "en"
            java.lang.String r8 = "English"
            r6.put(r7, r8)
            java.lang.String r7 = "hi"
            java.lang.String r8 = "Hindi"
            r6.put(r7, r8)
            java.lang.String r7 = "bn"
            java.lang.String r8 = "Bangla"
            r6.put(r7, r8)
            java.lang.String r7 = "or"
            java.lang.String r8 = "Oriya"
            r6.put(r7, r8)
            java.lang.String r7 = "mr"
            java.lang.String r8 = "Marathi"
            r6.put(r7, r8)
            java.lang.String r7 = "ml"
            java.lang.String r8 = "Malyalam"
            r6.put(r7, r8)
            java.lang.String r7 = "kn"
            java.lang.String r8 = "Kannada"
            r6.put(r7, r8)
            java.lang.String r7 = "ta"
            java.lang.String r8 = "Tamil"
            r6.put(r7, r8)
            java.lang.String r7 = "te"
            java.lang.String r8 = "Telugu"
            r6.put(r7, r8)
            java.lang.String r7 = "gu"
            java.lang.String r8 = "Gujarati"
            r6.put(r7, r8)
            java.lang.String r7 = "pa"
            java.lang.String r8 = "Punjabi"
            r6.put(r7, r8)
            boolean r6 = r4.containsKey(r2)
            if (r6 == 0) goto L_0x00d3
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x00d5
        L_0x00d3:
            java.lang.String r2 = ""
        L_0x00d5:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00fd
            java.lang.String r4 = "name"
            r9.a((java.lang.String) r4, (java.lang.Object) r2)
            r2 = r11[r1]
            java.lang.String r4 = "languageCode"
            r9.a((java.lang.String) r4, (java.lang.Object) r2)
            java.lang.String r2 = "countryCode"
            java.lang.String r4 = "IN"
            r9.a((java.lang.String) r2, (java.lang.Object) r4)
            r11 = r11[r0]
            java.lang.String r2 = "languageID"
            r9.a((java.lang.String) r2, (java.lang.Object) r11)
            r11 = 6
            net.one97.paytm.phoenix.core.a.a(r9, r10, r3, r1, r11)
            goto L_0x0108
        L_0x00fd:
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r5)
            goto L_0x0108
        L_0x0103:
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r5)
        L_0x0108:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ak.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }
}
