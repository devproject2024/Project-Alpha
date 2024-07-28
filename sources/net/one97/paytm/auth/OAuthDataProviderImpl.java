package net.one97.paytm.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.google.firebase.appindexing.f;
import com.google.firebase.appindexing.g;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.AJRProfileActivity;
import net.one97.paytm.AuthorizedMerchantActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.c;
import net.one97.paytm.oauth.fragment.ay;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.p;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.as;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;

public final class OAuthDataProviderImpl implements net.one97.paytm.oauth.b {
    public static final a Companion = new a((byte) 0);
    private static final String INTERNAL_SHARING_APP_HASH = INTERNAL_SHARING_APP_HASH;
    /* access modifiers changed from: private */
    public static OAuthDataProviderImpl instance;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final c provideOathModuleConfig() {
        c.a aVar = new c.a();
        aVar.f52585d = com.paytm.utility.b.m();
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        aVar.f52583b = net.one97.paytm.j.c.a("privacyPolicyUrl", (String) null);
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        aVar.f52582a = net.one97.paytm.j.c.a("termsAndConditionsUrl", (String) null);
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        aVar.f52584c = net.one97.paytm.j.c.a("key_forgot_password_ivr", (String) null);
        boolean z = true;
        aVar.f52586e = k.a((Object) "release", (Object) SDKConstants.KEY_STAGING_API) || k.a((Object) "release", (Object) "stagingBank") || k.a((Object) "release", (Object) "stagingMall");
        if (!k.a((Object) "release", (Object) SDKConstants.KEY_STAGING_API) && !k.a((Object) "release", (Object) "stagingBank") && !k.a((Object) "release", (Object) "stagingMall")) {
            z = false;
        }
        aVar.f52587f = z;
        aVar.f52588g = k.a((Object) "release", (Object) "release") ? "asasK/GTt2i" : INTERNAL_SHARING_APP_HASH;
        aVar.f52589h = k.a((Object) "release", (Object) "devicebinding");
        if (c.f52573g == null) {
            c.f52573g = new c(aVar, (byte) 0);
        }
        c cVar = c.f52573g;
        k.a((Object) cVar, "OauthModuleConfigs.Oauth…\n                .build()");
        return cVar;
    }

    public final boolean isPreviewCompleted() {
        ag.a aVar = ag.f69605a;
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return ag.a.a(appContext).b("isPreviewCompleted", false, true);
    }

    public final void markPreviewCompleted() {
        ag.a aVar = ag.f69605a;
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        ag.a.a(appContext).a("isPreviewCompleted", true, true);
    }

    public final String getSSOToken() {
        return com.paytm.utility.a.q(CJRJarvisApplication.getAppContext());
    }

    public final void saveSSOToken(String str) {
        ag.a aVar = ag.f69605a;
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        com.paytm.b.a.a a2 = ag.a.a(appContext);
        a2.a("sso_token=", str, true);
        String str2 = net.one97.paytm.common.utility.b.aP;
        k.a((Object) str2, "CJRConstants.TOKEN_ID_SMS");
        a2.a(str2, str, true);
    }

    public final void sendGAMultipleLabelEvent(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        k.c(str, "category");
        k.c(str2, "action");
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        ArrayList<String> arrayList2 = arrayList;
        ay ayVar = ay.f56391a;
        Context applicationContext = getApplicationContext();
        q qVar = q.f56798a;
        if (ay.a(applicationContext, q.k()) && (k.a((Object) str, (Object) "login_signup") || k.a((Object) str, (Object) "login") || k.a((Object) str, (Object) "signup"))) {
            arrayList2.add("location_flow");
        }
        com.paytm.utility.q.d("{ event_category=" + str + ", event_action=" + str2 + ", event_labels=" + arrayList2 + ", event_value=" + str3 + ", screenName=" + str4 + ", vertical_name=" + str5 + " }");
        if (context == null) {
            context = CJRJarvisApplication.getAppContext();
        }
        net.one97.paytm.j.a.a(context, str, str2, arrayList2, str3, str4, str5);
    }

    public final void sendCustomEventWithMap(String str, Map<String, ? extends Object> map, Context context) {
        k.c(str, "s");
        k.c(map, Item.CTA_URL_TYPE_MAP);
        k.c(context, "context");
        com.paytm.utility.q.d(String.valueOf(map));
        net.one97.paytm.j.a.b(str, (Map<String, Object>) map, context);
    }

    public final void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "vertical");
        k.c(context, "context");
        com.paytm.utility.q.d("{ event=openScreen, screenName=" + str + ", vertical_name=" + str2 + " }");
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public final Context getLocalisedContext(Context context) {
        k.c(context, "context");
        ContextThemeWrapper a2 = e.a(context);
        k.a((Object) a2, "Restring.wrapContext(context)");
        return a2;
    }

    public final void openChooseLaguageScreen(Activity activity, int i2) {
        k.c(activity, "activity");
        net.one97.paytm.payments.d.a.a(activity, "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MvcHJlZmVycmVkLWxhbmd1YWdlIiwic3BhcmFtcyI6eyJjYW5QdWxsRG93biI6ZmFsc2UsInB1bGxSZWZyZXNoIjpmYWxzZSwic2hvd1RpdGxlQmFyIjpmYWxzZX19&url=https://paytm.com");
    }

    public final String getStringFromGTM(String str) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public final boolean getBooleanFromGTM(String str, boolean z) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public final void checkDeepLinking(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final void openAuthorizedMerchantActivity(Context context) {
        k.c(context, "context");
        context.startActivity(new Intent(context, AuthorizedMerchantActivity.class));
    }

    public final void openProfileActivity(Context context) {
        k.c(context, "context");
        Intent intent = new Intent(context, AJRProfileActivity.class);
        intent.setFlags(67108864);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public final void openHomePage(Context context, boolean z, String str, boolean z2) {
        k.c(context, "context");
        Intent intent = new Intent(context, AJRMainActivity.class);
        intent.putExtra("intent_extra_start_login", z2);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        intent.putExtra(p.f56797b, str);
        intent.putExtra("is_forgot_password", z);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "featured");
        intent.putExtra("resultant fragment position", 0);
        CJRJarvisApplication.getAppContext().startActivity(intent);
    }

    public final void startFirebaseAction(String str, String str2) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "url");
        net.one97.paytm.common.b.a b2 = d.b();
        getApplicationContext();
        boolean a2 = b2.a("disableAppIndexing", false);
        net.one97.paytm.common.b.a b3 = d.b();
        getApplicationContext();
        boolean a3 = b3.a("disableAppActions", false);
        com.paytm.utility.q.d("index : AuthData::onStart  : " + a2 + " " + a3);
        if (a2) {
            g a4 = ((g.a) ((g.a) ((g.a) new g.a().a(str)).b(str2)).c("Paytm")).a();
            com.google.firebase.appindexing.b.a().a(a4);
        }
        if (a3) {
            f.a().a(com.google.firebase.appindexing.a.a.a(str, str2));
        }
    }

    public final void endFirebaseAction(String str, String str2) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str2, "url");
        net.one97.paytm.common.b.a b2 = d.b();
        getApplicationContext();
        boolean a2 = b2.a("disableAppActions", false);
        com.paytm.utility.q.d("index : AuthData::onStop  :  ".concat(String.valueOf(a2)));
        if (a2) {
            f.a().b(com.google.firebase.appindexing.a.a.a(str, str2));
        }
    }

    public final Context getApplicationContext() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public final int getIntFromGTM(String str, int i2) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, i2);
    }

    public final void checkSignUpReminder(j jVar) {
        OAuthUtils.a(jVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkSimCardChanged(androidx.fragment.app.j r12, android.app.Activity r13) {
        /*
            r11 = this;
            net.one97.paytm.oauth.utils.a.a r0 = net.one97.paytm.oauth.utils.a.a.f56764a
            java.lang.String r0 = net.one97.paytm.oauth.utils.a.a.a(r13)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x01a3
            net.one97.paytm.oauth.utils.q r2 = net.one97.paytm.oauth.utils.q.f56798a
            java.lang.String r2 = net.one97.paytm.oauth.utils.q.f()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0023
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.oauth.utils.q.a((java.lang.String) r0)
            return
        L_0x0023:
            boolean r0 = net.one97.paytm.oauth.utils.a.a.c(r13)
            if (r0 != 0) goto L_0x01a3
            net.one97.paytm.oauth.a r0 = net.one97.paytm.oauth.a.a()
            java.lang.String r2 = "OAuthGTMHelper.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0 = 0
            java.lang.String r3 = "enableSimChangePopUp"
            boolean r3 = net.one97.paytm.oauth.a.a((java.lang.String) r3, (boolean) r0)
            if (r3 == 0) goto L_0x01a3
            android.content.Context r13 = (android.content.Context) r13
            boolean r13 = com.paytm.utility.b.r((android.content.Context) r13)
            if (r13 != 0) goto L_0x0045
            goto L_0x01a3
        L_0x0045:
            java.lang.String r13 = ","
            java.lang.String[] r3 = new java.lang.String[]{r13}
            java.util.List r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.String[]) r3)
            net.one97.paytm.oauth.utils.q r3 = net.one97.paytm.oauth.utils.q.f56798a
            java.lang.String r3 = net.one97.paytm.oauth.utils.q.f()
            if (r3 != 0) goto L_0x0059
            java.lang.String r3 = ""
        L_0x0059:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.String[] r4 = new java.lang.String[]{r13}
            java.util.List r3 = kotlin.m.p.a((java.lang.CharSequence) r3, (java.lang.String[]) r4)
            java.lang.String r4 = "receiver$0"
            kotlin.g.b.k.c(r3, r4)
            java.lang.String r4 = "other"
            kotlin.g.b.k.c(r1, r4)
            int r4 = r3.size()
            int r5 = r1.size()
            r6 = 1
            if (r4 != r5) goto L_0x00d6
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.a.k.a(r3)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
            r5 = 0
        L_0x008a:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00ac
            java.lang.Object r7 = r3.next()
            int r8 = r5 + 1
            if (r5 >= 0) goto L_0x009b
            kotlin.a.k.a()
        L_0x009b:
            java.lang.Object r5 = r1.get(r5)
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.add(r5)
            r5 = r8
            goto L_0x008a
        L_0x00ac:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00d1
            java.util.Iterator r1 = r4.iterator()
        L_0x00bd:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00d1
            java.lang.Object r3 = r1.next()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x00bd
            r1 = 0
            goto L_0x00d2
        L_0x00d1:
            r1 = 1
        L_0x00d2:
            if (r1 == 0) goto L_0x00d6
            r1 = 1
            goto L_0x00d7
        L_0x00d6:
            r1 = 0
        L_0x00d7:
            if (r1 != 0) goto L_0x01a3
            net.one97.paytm.oauth.a r1 = net.one97.paytm.oauth.a.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = "simChangePopUpIntervals"
            java.lang.String r1 = net.one97.paytm.oauth.a.a(r1)
            java.lang.String r3 = "OAuthGTMHelper.getInstan…mChangedReminderIntervals"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String[] r13 = new java.lang.String[]{r13}
            java.util.List r13 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.String[]) r13)
            java.util.Collection r13 = (java.util.Collection) r13
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.Object[] r13 = r13.toArray(r1)
            if (r13 == 0) goto L_0x019b
            java.lang.String[] r13 = (java.lang.String[]) r13
            net.one97.paytm.oauth.utils.q r1 = net.one97.paytm.oauth.utils.q.f56798a
            int r1 = net.one97.paytm.oauth.utils.q.e()
            int r3 = r13.length
            if (r1 < r3) goto L_0x010d
            int r1 = r13.length
            int r1 = r1 - r6
        L_0x010d:
            r13 = r13[r1]
            int r13 = java.lang.Integer.parseInt(r13)
            net.one97.paytm.oauth.a r1 = net.one97.paytm.oauth.a.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r1 = "simChangePopUpCount"
            java.lang.String r1 = net.one97.paytm.oauth.a.a(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x012c
            int r1 = java.lang.Integer.parseInt(r1)
            goto L_0x012d
        L_0x012c:
            r1 = 1
        L_0x012d:
            net.one97.paytm.oauth.utils.q r2 = net.one97.paytm.oauth.utils.q.f56798a
            int r2 = net.one97.paytm.oauth.utils.q.d()
            int r13 = r13 * 24
            int r13 = r13 * 60
            int r13 = r13 * 60
            long r3 = (long) r13
            r7 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r7
            long r7 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q r13 = net.one97.paytm.oauth.utils.q.f56798a
            long r9 = net.one97.paytm.oauth.utils.q.c()
            long r7 = r7 - r9
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0151
            if (r2 > r1) goto L_0x0151
            r13 = 1
            goto L_0x0152
        L_0x0151:
            r13 = 0
        L_0x0152:
            if (r13 == 0) goto L_0x01a3
            if (r12 == 0) goto L_0x01a3
            androidx.fragment.app.q r12 = r12.a()
            java.lang.String r13 = "fragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            net.one97.paytm.oauth.fragment.br$a r13 = net.one97.paytm.oauth.fragment.br.f56514a
            net.one97.paytm.oauth.fragment.br r13 = new net.one97.paytm.oauth.fragment.br
            r13.<init>()
            r13.setCancelable(r0)
            androidx.fragment.app.Fragment r13 = (androidx.fragment.app.Fragment) r13
            java.lang.Class<net.one97.paytm.oauth.fragment.br> r0 = net.one97.paytm.oauth.fragment.br.class
            java.lang.String r0 = r0.getName()
            r12.a((androidx.fragment.app.Fragment) r13, (java.lang.String) r0)
            r12.c()
            if (r2 < r1) goto L_0x0194
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            long r12 = java.lang.System.currentTimeMillis()
            net.one97.paytm.oauth.utils.q.b((long) r12)
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            int r12 = net.one97.paytm.oauth.utils.q.e()
            int r12 = r12 + r6
            net.one97.paytm.oauth.utils.q.c((int) r12)
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            net.one97.paytm.oauth.utils.q.b((int) r6)
            return
        L_0x0194:
            net.one97.paytm.oauth.utils.q r12 = net.one97.paytm.oauth.utils.q.f56798a
            int r2 = r2 + r6
            net.one97.paytm.oauth.utils.q.b((int) r2)
            goto L_0x01a3
        L_0x019b:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type kotlin.Array<T>"
            r12.<init>(r13)
            throw r12
        L_0x01a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.auth.OAuthDataProviderImpl.checkSimCardChanged(androidx.fragment.app.j, android.app.Activity):void");
    }

    public final void resetSimChangedPromptAttributes(Activity activity) {
        net.one97.paytm.oauth.utils.a.a aVar = net.one97.paytm.oauth.utils.a.a.f56764a;
        net.one97.paytm.oauth.utils.a.a.b(activity);
    }

    public final void signOutAndLogin(Activity activity, boolean z, OAuthUtils.b bVar) {
        if (bVar == OAuthUtils.b.SESSION_TIME_OUT) {
            if (activity != null) {
                activity.finish();
            }
            as.a().f69661a = null;
        } else {
            OauthModule.a((HashMap<String, String>) null, (com.paytm.network.listener.b) new b());
            d.a().e(activity);
        }
        if (z) {
            openHomePage(getApplicationContext(), false, "", true);
        }
    }

    public static final class b implements com.paytm.network.listener.b {
        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        }

        b() {
        }
    }

    public final void saveEncryptedSSOToken(String str) {
        t.a(str);
    }

    public final void launchAJRAuthActivity(Context context, Bundle bundle) {
        k.c(bundle, "bundle");
        if (context == null) {
            context = CJRJarvisApplication.getAppContext();
        }
        Intent intent = new Intent(context, AJRAuthActivity.class);
        bundle.putBoolean(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public final String getPasswordStrength() {
        q qVar = q.f56798a;
        return q.l();
    }

    public final void invokeAddEmailFlow(j jVar) {
        OauthModule.b(jVar);
    }

    public final void handleSessionTimeOut(AppCompatActivity appCompatActivity, NetworkCustomError networkCustomError, String str, Bundle bundle, boolean z, boolean z2) {
        r.a(appCompatActivity, str, bundle, z, z2);
    }

    public final String getUserId() {
        return com.paytm.utility.a.a(getApplicationContext());
    }

    public final void saveWalletScopeToken(String str, String str2, long j) {
        t.b(str2);
        t.a(j);
    }

    public final String getWalletScopeToken() {
        return t.c(getApplicationContext());
    }

    public final void logHawEyeEvent(net.one97.paytm.oauth.models.a aVar) {
        if (aVar != null) {
            au.e eVar = new au.e();
            eVar.l = "AUTH";
            eVar.p = aVar.f56745f;
            eVar.m = aVar.f56741b;
            eVar.n = aVar.f56740a;
            eVar.g(aVar.f56742c);
            eVar.u = aVar.f56743d;
            eVar.o = aVar.f56744e;
            com.paytm.utility.q.d("{ flowName = " + aVar.f56740a + ", customMessage = " + aVar.f56742c + ", errorMsg = " + aVar.f56743d + ", uri = " + aVar.f56744e + ", screenName=" + aVar.f56741b + ", responseCode=" + aVar.f56745f + ", verticalName=AUTH }");
            au.a(eVar, au.c.LocalError.stringValue, getApplicationContext());
        }
    }

    public final void onLogout(Activity activity, boolean z, VolleyError volleyError) {
        k.c(activity, "activity");
        net.one97.paytm.auth.b.b.a(activity, false);
    }

    public static final void initOAuthModule() {
        if (instance == null) {
            instance = new OAuthDataProviderImpl();
        }
        OauthModule.a((net.one97.paytm.oauth.b) instance);
    }
}
