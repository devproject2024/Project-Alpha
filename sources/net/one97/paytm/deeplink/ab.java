package net.one97.paytm.deeplink;

import android.net.Uri;
import android.os.Bundle;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.oauth.e.h;
import net.one97.paytm.oauth.e.i;

public final class ab {

    /* renamed from: a  reason: collision with root package name */
    public static final ab f50295a = new ab();

    /* renamed from: b  reason: collision with root package name */
    private static final String f50296b = f50296b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f50297c = f50297c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f50298d = f50298d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f50299e = f50299e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f50300f = f50300f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f50301g = f50301g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f50302h = f50302h;

    /* renamed from: i  reason: collision with root package name */
    private static final String f50303i = f50303i;
    private static final String j = j;
    private static final String k = k;
    private static final String l = l;
    private static final String m = m;
    private static final String n = n;
    private static final String o = o;
    private static final String p = "mobileNumber";
    private static final String q = "title";
    private static final String r = "description";
    private static final String s = s;
    private static final String t = t;
    private static final String u = u;

    static final class a implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final a f50304a = new a();

        a() {
        }

        public final void a() {
        }
    }

    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        public static final b f50305a = new b();

        b() {
        }
    }

    private ab() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return p.a("login", deepLinkData.f50284b, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, net.one97.paytm.deeplink.DeepLinkData r9) {
        /*
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r9, r0)
            android.os.Bundle r0 = r9.f50290h
            if (r0 != 0) goto L_0x0012
            android.net.Uri r0 = r9.f50289g
            if (r0 == 0) goto L_0x0279
        L_0x0012:
            android.net.Uri r0 = r9.f50289g
            java.lang.String r1 = ""
            r2 = 0
            if (r0 == 0) goto L_0x002e
            android.net.Uri r0 = r9.f50289g
            if (r0 == 0) goto L_0x0024
            java.lang.String r3 = f50296b
            java.lang.String r3 = r0.getQueryParameter(r3)
            goto L_0x0025
        L_0x0024:
            r3 = r2
        L_0x0025:
            if (r0 == 0) goto L_0x003b
            java.lang.String r4 = p
            java.lang.String r0 = r0.getQueryParameter(r4)
            goto L_0x003c
        L_0x002e:
            android.os.Bundle r0 = r9.f50290h
            if (r0 == 0) goto L_0x003a
            java.lang.String r3 = f50296b
            java.lang.String r0 = r0.getString(r3, r1)
            r3 = r0
            goto L_0x003b
        L_0x003a:
            r3 = r2
        L_0x003b:
            r0 = r2
        L_0x003c:
            java.lang.String r4 = f50299e
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)
            if (r4 == 0) goto L_0x004d
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.oauth.activity.AJRChangePassword> r0 = net.one97.paytm.oauth.activity.AJRChangePassword.class
            r2.<init>(r8, r0)
            goto L_0x0266
        L_0x004d:
            java.lang.String r4 = f50297c
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)
            if (r4 == 0) goto L_0x005c
            java.lang.String r0 = "paytmmp://cst_flow?featuretype=vertical_detail&verticalId=15"
            net.one97.paytm.payments.d.a.a((android.content.Context) r8, (java.lang.String) r0)
            goto L_0x0266
        L_0x005c:
            java.lang.String r4 = f50298d
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)
            if (r4 == 0) goto L_0x006d
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.oauth.activity.ForgotPasswordContainerActivity> r0 = net.one97.paytm.oauth.activity.ForgotPasswordContainerActivity.class
            r2.<init>(r8, r0)
            goto L_0x0266
        L_0x006d:
            java.lang.String r4 = u
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)
            if (r4 == 0) goto L_0x007e
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.oauth.activity.UpgradePasswordActivity> r0 = net.one97.paytm.oauth.activity.UpgradePasswordActivity.class
            r2.<init>(r8, r0)
            goto L_0x0266
        L_0x007e:
            java.lang.String r4 = f50300f
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r3)
            java.lang.String r5 = "intent.putExtra(\"urlToCh…eepLinkData.mDeepLinkUrl)"
            java.lang.String r6 = "urlToCheck"
            r7 = 0
            if (r4 == 0) goto L_0x0107
            android.net.Uri r0 = r9.f50289g
            if (r0 == 0) goto L_0x00a2
            java.lang.String r1 = q
            java.lang.String r1 = r0.getQueryParameter(r1)
            java.lang.String r3 = r
            java.lang.String r3 = r0.getQueryParameter(r3)
            java.lang.String r4 = s
            java.lang.String r0 = r0.getQueryParameter(r4)
            goto L_0x00a4
        L_0x00a2:
            r0 = r1
            r3 = r0
        L_0x00a4:
            boolean r4 = r8 instanceof androidx.fragment.app.FragmentActivity
            if (r4 == 0) goto L_0x00f5
            boolean r4 = r8 instanceof net.one97.paytm.auth.activity.AJRAuthActivity
            if (r4 != 0) goto L_0x00f5
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            net.one97.paytm.oauth.fragment.s$a r5 = net.one97.paytm.oauth.fragment.s.f56612b
            java.lang.String r5 = net.one97.paytm.oauth.fragment.s.f56613f
            r4.putString(r5, r1)
            net.one97.paytm.oauth.fragment.s$a r1 = net.one97.paytm.oauth.fragment.s.f56612b
            java.lang.String r1 = net.one97.paytm.oauth.fragment.s.f56614g
            r4.putString(r1, r3)
            net.one97.paytm.oauth.fragment.s$a r1 = net.one97.paytm.oauth.fragment.s.f56612b
            java.lang.String r1 = net.one97.paytm.oauth.fragment.s.f56615h
            r4.putString(r1, r0)
            net.one97.paytm.oauth.fragment.s$a r0 = net.one97.paytm.oauth.fragment.s.f56612b
            net.one97.paytm.oauth.fragment.s r0 = net.one97.paytm.oauth.fragment.s.a.a(r4)
            r0.setCancelable(r7)
            r1 = r8
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            androidx.fragment.app.j r1 = r1.getSupportFragmentManager()
            androidx.fragment.app.q r1 = r1.a()
            java.lang.String r3 = "context.supportFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            java.lang.Class<net.one97.paytm.oauth.fragment.s> r3 = net.one97.paytm.oauth.fragment.s.class
            java.lang.String r3 = r3.getName()
            r1.a((androidx.fragment.app.Fragment) r0, (java.lang.String) r3)
            r1.c()
            goto L_0x0266
        L_0x00f5:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r0 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r2.<init>(r8, r0)
            java.lang.String r0 = r9.f50283a
            android.content.Intent r0 = r2.putExtra(r6, r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            goto L_0x0266
        L_0x0107:
            java.lang.String r1 = o
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            r4 = 1
            if (r1 == 0) goto L_0x014c
            boolean r0 = com.paytm.utility.b.r((android.content.Context) r8)
            if (r0 == 0) goto L_0x0266
            net.one97.paytm.oauth.utils.q r0 = net.one97.paytm.oauth.utils.q.f56798a
            boolean r0 = net.one97.paytm.oauth.utils.q.j()
            if (r0 != 0) goto L_0x0266
            boolean r0 = r8 instanceof androidx.fragment.app.FragmentActivity
            if (r0 == 0) goto L_0x013a
            boolean r0 = r8 instanceof net.one97.paytm.auth.activity.AJRAuthActivity
            if (r0 != 0) goto L_0x013a
            r0 = r8
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            net.one97.paytm.deeplink.ab$a r1 = net.one97.paytm.deeplink.ab.a.f50304a
            net.one97.paytm.oauth.e.h r1 = (net.one97.paytm.oauth.e.h) r1
            net.one97.paytm.deeplink.ab$b r3 = net.one97.paytm.deeplink.ab.b.f50305a
            net.one97.paytm.oauth.e.i r3 = (net.one97.paytm.oauth.e.i) r3
            net.one97.paytm.oauth.OauthModule.a(r0, r1, r3, r4, r7)
            goto L_0x0266
        L_0x013a:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.landingpage.activity.AJRMainActivity> r0 = net.one97.paytm.landingpage.activity.AJRMainActivity.class
            r2.<init>(r8, r0)
            java.lang.String r0 = r9.f50283a
            android.content.Intent r0 = r2.putExtra(r6, r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            goto L_0x0266
        L_0x014c:
            java.lang.String r1 = f50302h
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x017c
            android.net.Uri r0 = r9.f50289g
            if (r0 == 0) goto L_0x0165
            java.lang.String r1 = l
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 == 0) goto L_0x0165
            int r0 = java.lang.Integer.parseInt(r0)
            r7 = r0
        L_0x0165:
            boolean r0 = r8 instanceof androidx.fragment.app.FragmentActivity
            if (r0 == 0) goto L_0x0266
            net.one97.paytm.oauth.utils.a r0 = net.one97.paytm.oauth.utils.a.f56763a
            r0 = r8
            androidx.fragment.app.FragmentActivity r0 = (androidx.fragment.app.FragmentActivity) r0
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            java.lang.String r1 = "context.supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.oauth.utils.a.a((androidx.fragment.app.j) r0, (int) r7)
            goto L_0x0266
        L_0x017c:
            java.lang.String r1 = f50303i
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            r5 = 21
            if (r1 == 0) goto L_0x01b0
            android.net.Uri r0 = r9.f50289g
            if (r0 == 0) goto L_0x0197
            java.lang.String r1 = l
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 == 0) goto L_0x0197
            int r0 = java.lang.Integer.parseInt(r0)
            r7 = r0
        L_0x0197:
            boolean r0 = r8 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0266
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x0266
            net.one97.paytm.oauth.utils.a r0 = net.one97.paytm.oauth.utils.a.f56763a
            r0 = r8
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2131957265(0x7f131611, float:1.955111E38)
            java.lang.String r1 = r8.getString(r1)
            net.one97.paytm.oauth.utils.a.a((android.app.Activity) r0, (int) r7, (java.lang.String) r1)
            goto L_0x0266
        L_0x01b0:
            java.lang.String r1 = j
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x01e2
            android.net.Uri r0 = r9.f50289g
            if (r0 == 0) goto L_0x01c9
            java.lang.String r1 = l
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 == 0) goto L_0x01c9
            int r0 = java.lang.Integer.parseInt(r0)
            r7 = r0
        L_0x01c9:
            boolean r0 = r8 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0266
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x0266
            net.one97.paytm.oauth.utils.a r0 = net.one97.paytm.oauth.utils.a.f56763a
            r0 = r8
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2131951857(0x7f1300f1, float:1.954014E38)
            java.lang.String r1 = r8.getString(r1)
            net.one97.paytm.oauth.utils.a.a((android.app.Activity) r0, (int) r7, (java.lang.String) r1)
            goto L_0x0266
        L_0x01e2:
            java.lang.String r1 = k
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x0213
            android.net.Uri r0 = r9.f50289g
            if (r0 == 0) goto L_0x01fb
            java.lang.String r1 = l
            java.lang.String r0 = r0.getQueryParameter(r1)
            if (r0 == 0) goto L_0x01fb
            int r0 = java.lang.Integer.parseInt(r0)
            r7 = r0
        L_0x01fb:
            boolean r0 = r8 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0266
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L_0x0266
            net.one97.paytm.oauth.utils.a r0 = net.one97.paytm.oauth.utils.a.f56763a
            r0 = r8
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2131954101(0x7f1309b5, float:1.9544692E38)
            java.lang.String r1 = r8.getString(r1)
            net.one97.paytm.oauth.utils.a.a((android.app.Activity) r0, (int) r7, (java.lang.String) r1)
            goto L_0x0266
        L_0x0213:
            java.lang.String r1 = m
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x0221
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            net.one97.paytm.oauth.OauthModule.a((android.content.Context) r8, (java.lang.Boolean) r0, (java.lang.String) r2)
            goto L_0x0266
        L_0x0221:
            java.lang.String r1 = n
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x022f
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            net.one97.paytm.oauth.OauthModule.a((android.content.Context) r8, (java.lang.Boolean) r1, (java.lang.String) r0)
            goto L_0x0266
        L_0x022f:
            java.lang.String r1 = t
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x023b
            net.one97.paytm.oauth.OauthModule.a((android.content.Context) r8, (java.lang.String) r0)
            goto L_0x0266
        L_0x023b:
            java.lang.String r0 = f50301g
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0254
            boolean r0 = r8 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0266
            net.one97.paytm.oauth.b r0 = net.one97.paytm.oauth.OauthModule.b()
            r1 = r8
            android.app.Activity r1 = (android.app.Activity) r1
            net.one97.paytm.oauth.utils.OAuthUtils$b r3 = net.one97.paytm.oauth.utils.OAuthUtils.b.DEFAULT
            r0.signOutAndLogin(r1, r4, r3)
            goto L_0x0266
        L_0x0254:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.auth.activity.AJRAuthActivity> r0 = net.one97.paytm.auth.activity.AJRAuthActivity.class
            r2.<init>(r8, r0)
            java.lang.String r0 = "show_full_screen"
            android.content.Intent r0 = r2.putExtra(r0, r4)
            java.lang.String r1 = "intent.putExtra(OAUTH_EX…A_SHOW_FULL_SCREEN, true)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
        L_0x0266:
            if (r2 == 0) goto L_0x0279
            android.os.Bundle r9 = r9.f50290h
            if (r9 == 0) goto L_0x0276
            r9 = 67108864(0x4000000, float:1.5046328E-36)
            r2.addFlags(r9)
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r9)
        L_0x0276:
            r8.startActivity(r2)
        L_0x0279:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.deeplink.ab.a(android.content.Context, net.one97.paytm.deeplink.DeepLinkData):void");
    }

    public static boolean b(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (!p.a("login", deepLinkData.f50284b, true)) {
            return false;
        }
        String str = null;
        if (deepLinkData.f50289g != null) {
            Uri uri = deepLinkData.f50289g;
            if (uri != null) {
                str = uri.getQueryParameter(f50296b);
            }
        } else {
            Bundle bundle = deepLinkData.f50290h;
            if (bundle != null) {
                str = bundle.getString(f50296b, "");
            }
        }
        if (k.a((Object) f50299e, (Object) str) || k.a((Object) f50300f, (Object) str) || k.a((Object) m, (Object) str) || k.a((Object) u, (Object) str)) {
            return true;
        }
        return false;
    }
}
