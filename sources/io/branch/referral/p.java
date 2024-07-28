package io.branch.referral;

final class p {

    /* renamed from: a  reason: collision with root package name */
    static a f46555a = null;

    /* renamed from: b  reason: collision with root package name */
    static boolean f46556b = false;

    /* renamed from: c  reason: collision with root package name */
    static boolean f46557c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f46558d = "bnc_no_value";

    interface a {
        void f();
    }

    p() {
    }

    public static String a() {
        return f46558d;
    }

    /* access modifiers changed from: private */
    public static void d() {
        a aVar = f46555a;
        if (aVar != null) {
            aVar.f();
            f46555a = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056 A[Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0065 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(android.content.Context r5, java.lang.String r6, long r7, long r9) {
        /*
            java.lang.String r0 = "="
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = "onReferrerClientFinished()"
            io.branch.referral.q.h(r2)
            io.branch.referral.q.a((android.content.Context) r5)
            r2 = 0
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0017
            java.lang.String r5 = "bnc_referrer_click_ts"
            io.branch.referral.q.a((java.lang.String) r5, (long) r7)
        L_0x0017:
            int r5 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            java.lang.String r5 = "bnc_install_begin_ts"
            io.branch.referral.q.a((java.lang.String) r5, (long) r9)
        L_0x0020:
            if (r6 == 0) goto L_0x00f6
            java.lang.String r5 = java.net.URLDecoder.decode(r6, r1)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            r6.<init>()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = "&"
            java.lang.String[] r7 = r5.split(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            int r8 = r7.length     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            r9 = 0
            r10 = 0
        L_0x0034:
            if (r10 >= r8) goto L_0x0068
            r2 = r7[r10]     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            if (r3 != 0) goto L_0x0065
            boolean r3 = r2.contains(r0)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r4 = "-"
            if (r3 != 0) goto L_0x004d
            boolean r3 = r2.contains(r4)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            if (r3 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r4 = r0
        L_0x004e:
            java.lang.String[] r2 = r2.split(r4)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            int r3 = r2.length     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            r4 = 1
            if (r3 <= r4) goto L_0x0065
            r3 = r2[r9]     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r3 = java.net.URLDecoder.decode(r3, r1)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            r2 = r2[r4]     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r1)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            r6.put(r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
        L_0x0065:
            int r10 = r10 + 1
            goto L_0x0034
        L_0x0068:
            io.branch.referral.m$a r7 = io.branch.referral.m.a.LinkClickID     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            boolean r7 = r6.containsKey(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            if (r7 == 0) goto L_0x0087
            io.branch.referral.m$a r7 = io.branch.referral.m.a.LinkClickID     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            f46558d = r7     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r8 = "bnc_link_click_identifier"
            io.branch.referral.q.a((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
        L_0x0087:
            io.branch.referral.m$a r7 = io.branch.referral.m.a.IsFullAppConv     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            boolean r7 = r6.containsKey(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            if (r7 == 0) goto L_0x00c3
            io.branch.referral.m$a r7 = io.branch.referral.m.a.ReferringLink     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            boolean r7 = r6.containsKey(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            if (r7 == 0) goto L_0x00c3
            io.branch.referral.m$a r7 = io.branch.referral.m.a.IsFullAppConv     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            io.branch.referral.q.a((boolean) r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            io.branch.referral.m$a r7 = io.branch.referral.m.a.ReferringLink     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r8 = "bnc_app_link"
            io.branch.referral.q.a((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
        L_0x00c3:
            io.branch.referral.m$a r7 = io.branch.referral.m.a.GoogleSearchInstallReferrer     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            boolean r7 = r6.containsKey(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            if (r7 == 0) goto L_0x00f6
            io.branch.referral.m$a r7 = io.branch.referral.m.a.GoogleSearchInstallReferrer     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = r7.getKey()     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r7 = "bnc_google_search_install_identifier"
            io.branch.referral.q.a((java.lang.String) r7, (java.lang.String) r6)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            java.lang.String r6 = "bnc_google_play_install_referrer_extras"
            io.branch.referral.q.a((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ UnsupportedEncodingException -> 0x00e8, IllegalArgumentException -> 0x00e6 }
            goto L_0x00f6
        L_0x00e6:
            r5 = move-exception
            goto L_0x00ea
        L_0x00e8:
            r5 = move-exception
            goto L_0x00f3
        L_0x00ea:
            r5.printStackTrace()
            java.lang.String r5 = "Illegal characters in url encoded string"
            io.branch.referral.q.h(r5)
            goto L_0x00f6
        L_0x00f3:
            r5.printStackTrace()
        L_0x00f6:
            d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.p.a(android.content.Context, java.lang.String, long, long):void");
    }

    static /* synthetic */ void b() {
        q.h("onReferrerClientError()");
        f46557c = true;
        d();
    }
}
