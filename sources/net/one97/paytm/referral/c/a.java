package net.one97.paytm.referral.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20027a = new a();

    private a() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r7, net.one97.paytm.deeplink.DeepLinkData r8) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r8, r0)
            android.os.Bundle r0 = r8.f50290h
            if (r0 != 0) goto L_0x0013
            android.net.Uri r0 = r8.f50289g
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            android.net.Uri r0 = r8.f50289g
            java.lang.String r1 = "utm_source"
            java.lang.String r2 = "tag"
            r3 = 0
            if (r0 == 0) goto L_0x002f
            android.net.Uri r0 = r8.f50289g
            if (r0 == 0) goto L_0x0025
            java.lang.String r4 = r0.getQueryParameter(r2)
            goto L_0x0026
        L_0x0025:
            r4 = r3
        L_0x0026:
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.getQueryParameter(r1)
            goto L_0x0041
        L_0x002d:
            r0 = r3
            goto L_0x0041
        L_0x002f:
            android.os.Bundle r0 = r8.f50290h
            if (r0 == 0) goto L_0x003a
            java.lang.String r4 = ""
            java.lang.String r4 = r0.getString(r2, r4)
            goto L_0x003b
        L_0x003a:
            r4 = r3
        L_0x003b:
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.getString(r1)
        L_0x0041:
            java.lang.String r5 = r8.f50284b
            java.lang.String r6 = "referral"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0058
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<net.one97.paytm.referral.activity.ReferralLandingActivity> r5 = net.one97.paytm.referral.activity.ReferralLandingActivity.class
            r3.<init>(r7, r5)
            r3.putExtra(r2, r4)
            r3.putExtra(r1, r0)
        L_0x0058:
            if (r3 == 0) goto L_0x0072
            android.os.Bundle r8 = r8.f50290h
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            if (r8 == 0) goto L_0x0068
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            r3.addFlags(r8)
            r3.addFlags(r0)
        L_0x0068:
            boolean r8 = r7 instanceof android.app.Activity
            if (r8 != 0) goto L_0x006f
            r3.addFlags(r0)
        L_0x006f:
            r7.startActivity(r3)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.referral.c.a.a(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }
}
