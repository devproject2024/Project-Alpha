package net.one97.paytm.landingpage.utils;

public final class j {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005f A[SYNTHETIC, Splitter:B:31:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f A[SYNTHETIC, Splitter:B:38:0x006f] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x0046=Splitter:B:21:0x0046, B:28:0x0056=Splitter:B:28:0x0056} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.paytmmall.clpartifact.view.viewmodel.HomeResponse a(android.content.Context r3, com.paytmmall.clpartifact.view.viewmodel.HomeResponse r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x0053, Exception -> 0x0043, all -> 0x003f }
            net.one97.paytm.common.b.e r1 = net.one97.paytm.common.b.d.a()     // Catch:{ IOException -> 0x0053, Exception -> 0x0043, all -> 0x003f }
            boolean r1 = r1.h()     // Catch:{ IOException -> 0x0053, Exception -> 0x0043, all -> 0x003f }
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = "home_bottom_tab_staging_response.json"
            goto L_0x0014
        L_0x0012:
            java.lang.String r1 = "home_page_items.json"
        L_0x0014:
            java.io.InputStream r3 = r3.open(r1)     // Catch:{ IOException -> 0x0053, Exception -> 0x0043, all -> 0x003f }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003d, Exception -> 0x003b }
            r1.<init>(r3)     // Catch:{ IOException -> 0x003d, Exception -> 0x003b }
            com.google.gson.f r2 = new com.google.gson.f     // Catch:{ IOException -> 0x003d, Exception -> 0x003b }
            r2.<init>()     // Catch:{ IOException -> 0x003d, Exception -> 0x003b }
            java.lang.Class r4 = r4.getClass()     // Catch:{ IOException -> 0x003d, Exception -> 0x003b }
            java.lang.Object r4 = r2.a((java.io.Reader) r1, r4)     // Catch:{ IOException -> 0x003d, Exception -> 0x003b }
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r4 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r4     // Catch:{ IOException -> 0x003d, Exception -> 0x003b }
            if (r3 == 0) goto L_0x003a
            r3.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x003a
        L_0x0032:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x003a:
            return r4
        L_0x003b:
            r4 = move-exception
            goto L_0x0046
        L_0x003d:
            r4 = move-exception
            goto L_0x0056
        L_0x003f:
            r3 = move-exception
            r4 = r3
            r3 = r0
            goto L_0x006d
        L_0x0043:
            r3 = move-exception
            r4 = r3
            r3 = r0
        L_0x0046:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x006c }
            com.paytm.utility.q.b(r4)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x006b
            r3.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006b
        L_0x0053:
            r3 = move-exception
            r4 = r3
            r3 = r0
        L_0x0056:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x006c }
            com.paytm.utility.q.b(r4)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x006b
            r3.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x006b
        L_0x0063:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x006b:
            return r0
        L_0x006c:
            r4 = move-exception
        L_0x006d:
            if (r3 == 0) goto L_0x007b
            r3.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x007b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.landingpage.utils.j.a(android.content.Context, com.paytmmall.clpartifact.view.viewmodel.HomeResponse):com.paytmmall.clpartifact.view.viewmodel.HomeResponse");
    }
}
