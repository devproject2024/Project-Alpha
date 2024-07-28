package net.one97.paytm.landingpage.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.n;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.view.fragment.SFHomeFragment;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.cashback.posttxn.e;
import net.one97.paytm.chat.ChatInitFragment;
import net.one97.paytm.common.entity.CJRCatalogSavedState;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.postcard.data.PostcardThemesResponseDataModel;
import net.one97.paytm.deeplink.f;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.m;
import net.one97.paytm.deeplink.w;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.storage.LocaleDBQuery;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.oauth.R;
import net.one97.paytm.packageScanner.PackageScanManager;
import net.one97.paytm.upgradeKyc.f.c;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ai;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;
import net.one97.paytm.utils.u;
import net.one97.paytm.wallet.f.d;
import net.one97.paytm.wallet.newdesign.postcard.d;
import net.one97.paytm.wallet.newdesign.utils.IndependentImageDownloadManager;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements net.one97.paytm.common.b.a {

    /* renamed from: a  reason: collision with root package name */
    private e f52886a;

    /* renamed from: b  reason: collision with root package name */
    private PackageScanManager f52887b;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, boolean z2) {
    }

    public final Context a() {
        return CJRJarvisApplication.getAppContext();
    }

    public final String a(String str) {
        c.a();
        return c.a(str, (String) null);
    }

    public final void a(Context context) {
        d.a().a(context);
    }

    public final boolean b() {
        return CJRJarvisApplication.u();
    }

    public final void c() {
        CJRJarvisApplication.q();
    }

    public final boolean b(Context context) {
        return l.h(context);
    }

    public final boolean a(String str, boolean z) {
        c.a();
        return c.a(str, z);
    }

    public final void a(Activity activity, Intent intent) {
        u.a().a(activity, intent);
    }

    public final boolean d() {
        return u.a().f69793b;
    }

    public final void b(Activity activity, Intent intent) {
        u a2 = u.a();
        if (intent.getBooleanExtra("from_shortcut", false)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("mobile_homescreen_icon_name", "scan");
                net.one97.paytm.j.a.b("mobile_homescreen_paytm_icon_clicked", (Map<String, Object>) hashMap, activity.getApplicationContext());
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
            u.a(activity);
        } else {
            com.paytm.utility.a.c();
            a2.b(activity, intent);
        }
        AsyncTask.SERIAL_EXECUTOR.execute(new u.b(activity, intent));
    }

    public final Intent c(Activity activity, Intent intent) {
        CJRHomePageItem cJRHomePageItem;
        u a2 = u.a();
        Bundle bundle = null;
        if (!TextUtils.isEmpty(intent.getStringExtra("referralSource"))) {
            cJRHomePageItem = a2.f69792a.a();
            if (cJRHomePageItem != null) {
                intent.putExtra("is_referral_data", true);
                intent.putExtra("referral_data", cJRHomePageItem);
            }
        } else {
            cJRHomePageItem = null;
        }
        boolean z = false;
        if (!intent.getBooleanExtra("push_notification", false)) {
            Uri data = intent.getData();
            if (data != null) {
                cJRHomePageItem = net.one97.paytm.utils.c.a((Context) activity, data.toString());
                if (cJRHomePageItem != null && cJRHomePageItem.getURLType() != null && cJRHomePageItem.getURLType().equalsIgnoreCase("merchantpayment")) {
                    if (t.b(activity.getApplicationContext()) == null) {
                        Intent intent2 = new Intent(activity, AJRAuthActivity.class);
                        intent2.putExtra("launchSignUp", false);
                        intent2.putExtra("set_result_required", true);
                        activity.startActivityForResult(intent2, AppConstants.NOT_TIME);
                    } else {
                        h.a aVar = h.f50349a;
                        h.a.a(activity, cJRHomePageItem.getDeeplink(), (Bundle) null);
                    }
                    return null;
                } else if (cJRHomePageItem == null && !TextUtils.isEmpty(data.toString()) && data.toString().startsWith("paytmmp")) {
                    intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
                } else if (cJRHomePageItem != null) {
                    String uRLType = cJRHomePageItem.getURLType();
                    if (uRLType != null && (uRLType.equalsIgnoreCase("homepage_primary") || uRLType.equalsIgnoreCase("open"))) {
                        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
                    } else if (uRLType != null && uRLType.equalsIgnoreCase("jnua.app.link")) {
                        intent.putExtra("extra_open_sherose_feed_tab", "main");
                        intent.putExtra("extra_home_data", cJRHomePageItem);
                    } else if (!TextUtils.isEmpty(data.toString()) && data.toString().startsWith("paytmmp") && "news_details".equals(uRLType)) {
                        intent.putExtra("extra_home_data", cJRHomePageItem);
                        intent.putExtra("isnewsDetails", true);
                    }
                }
            }
            if (cJRHomePageItem != null && cJRHomePageItem.getURLType() != null && cJRHomePageItem.getURLType().equalsIgnoreCase(Utility.VERTICAL_NAME_MALL)) {
                intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, Utility.VERTICAL_NAME_MALL);
            } else if (!(cJRHomePageItem == null || cJRHomePageItem.getURLType() == null || !cJRHomePageItem.getURLType().equalsIgnoreCase("myprofile"))) {
                intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "myprofile");
            }
            if (cJRHomePageItem != null && data != null && !TextUtils.isEmpty(data.toString()) && (data.toString().contains("https") || data.toString().contains("http"))) {
                intent.putExtra("urlToCheck", cJRHomePageItem.getDeeplink());
            } else if (data != null && !TextUtils.isEmpty(data.toString())) {
                intent.putExtra("urlToCheck", data.toString());
            }
        }
        boolean booleanExtra = intent.getBooleanExtra("intent_from_wear", false);
        boolean booleanExtra2 = intent.getBooleanExtra("extra_intent_from_wear_launch_favourites", false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE);
            intent.putExtra("extra_intent_from_wear_launch_favourites", booleanExtra2);
            if (!TextUtils.isEmpty(stringExtra)) {
                intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, stringExtra);
            }
        }
        if (intent.hasExtra("query")) {
            intent.putExtra("query", intent.getStringExtra("query"));
        }
        boolean booleanExtra3 = intent.getBooleanExtra("isFromNotification", false);
        if (intent.getExtras() != null) {
            bundle = intent.getExtras().getBundle("notificationBundle");
        }
        if ((intent.getFlags() & 1048576) == 1048576) {
            z = true;
        }
        intent.putExtra("wasLaunchedFromRecent", z);
        if (booleanExtra3) {
            if (bundle != null) {
                intent.putExtra("deepLinkUrl", bundle.getString("url_type", ""));
            }
            intent.putExtra("isFromNotification", true);
        }
        intent.putExtra("notificationBundle", bundle);
        return intent;
    }

    public final void a(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.b(str, map, context);
    }

    public final Fragment e() {
        return new ChatInitFragment();
    }

    public final void a(Context context, j jVar) {
        net.one97.paytm.locale.a.a.a(context, jVar);
    }

    public final void a(Activity activity) {
        try {
            net.one97.paytm.recharge.legacy.catalog.b.e.a(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final CJRCatalogSavedState f() {
        return ((CJRJarvisApplication) CJRJarvisApplication.getAppContext()).f49006b;
    }

    public final boolean c(Context context) {
        return WalletSharedPrefs.INSTANCE.isOTPCounterCacheNeedRefresh(context);
    }

    public final String d(Context context) {
        return t.g(context);
    }

    public final void e(Context context) {
        IndependentImageDownloadManager independentImageDownloadManager = new IndependentImageDownloadManager(context);
        independentImageDownloadManager.download(net.one97.paytm.wallet.utility.a.b(context), (IndependentImageDownloadManager.ImageDownloadListener) null);
        independentImageDownloadManager.download(net.one97.paytm.wallet.utility.a.c(context), (IndependentImageDownloadManager.ImageDownloadListener) null);
    }

    public final boolean g() {
        return LocaleDBQuery.isToUpdateLangByPush();
    }

    public final void a(Activity activity, j jVar) {
        net.one97.paytm.locale.a aVar = new net.one97.paytm.locale.a(activity, $$Lambda$a$QdMjmGVNwu1uPkBSVgoUZEBtnc.INSTANCE);
        aVar.f53064b = n.a((Context) activity, n.a());
        aVar.f53063a = jVar;
        String a2 = n.a((Context) activity, n.a());
        if (!a2.equalsIgnoreCase(net.one97.paytm.locale.a.f53061d) || LocaleDBQuery.isToUpdateLangByPush()) {
            net.one97.paytm.locale.a.f53061d = a2;
            aVar.f53065c = true;
            aVar.b(a2);
        }
    }

    public final String h() {
        c.a();
        return c.a("localisationDigitalproxyUrl", (String) null);
    }

    public final void i() {
        CJRJarvisApplication.p();
    }

    public final void a(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final boolean b(String str) {
        m mVar = m.f50358c;
        return m.a(str);
    }

    public final String j() {
        return net.one97.paytm.payments.d.a.a();
    }

    public final void k() {
        CJRJarvisApplication.v();
    }

    public final boolean l() {
        return CJRJarvisApplication.w();
    }

    public final String m() {
        c.a();
        return c.a("safety_net_api_key_core", (String) null);
    }

    public final void f(Context context) {
        final net.one97.paytm.wallet.newdesign.postcard.d a2 = net.one97.paytm.wallet.newdesign.postcard.d.a(context);
        a2.a((d.C1447d) new d.C1447d() {
            public final void a(NetworkCustomError networkCustomError) {
            }

            public final void a(String str, String str2) {
            }

            public final void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel) {
                a2.a();
            }

            public final void a() {
                a2.b();
            }
        });
    }

    public final void g(Context context) {
        RecentDataNetworkManager.fetchRecentPaymentsData(context);
    }

    public final boolean a(Context context, String str, Bundle bundle) {
        h.a aVar = h.f50349a;
        return h.a.a(context, str, bundle);
    }

    public final boolean c(String str) {
        c.a();
        return b.a(c.F(), str);
    }

    public final void h(Context context) {
        l.a(context);
    }

    public final String i(Context context) {
        return t.c(context);
    }

    public final View n() {
        return CJRJarvisApplication.x();
    }

    public final void o() {
        CJRJarvisApplication.y();
    }

    public final View p() {
        return CJRJarvisApplication.z();
    }

    public final void q() {
        CJRJarvisApplication.A();
    }

    public final Drawable r() {
        return CJRJarvisApplication.B();
    }

    public final void s() {
        ai.INSTANCE.evictAll();
    }

    public final boolean j(Context context) {
        net.one97.paytm.oauth.utils.a aVar = net.one97.paytm.oauth.utils.a.f56763a;
        return net.one97.paytm.oauth.utils.a.a(context);
    }

    public final boolean t() {
        net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
        return net.one97.paytm.oauth.utils.q.x();
    }

    public final boolean u() {
        c.a();
        return c.a("oauthVerifyLockOnAppLaunch", true);
    }

    public final void v() {
        CJRJarvisApplication.r();
    }

    public final void a(AppCompatActivity appCompatActivity) {
        net.one97.paytm.oauth.utils.a aVar = net.one97.paytm.oauth.utils.a.f56763a;
        if (Build.VERSION.SDK_INT >= 21 && b.r((Context) appCompatActivity)) {
            net.one97.paytm.oauth.utils.q qVar = net.one97.paytm.oauth.utils.q.f56798a;
            if (net.one97.paytm.oauth.utils.q.x()) {
                net.one97.paytm.oauth.utils.a.a(appCompatActivity, true, appCompatActivity.getString(R.string.lbl_unlock_paytm));
            }
        }
    }

    public final boolean w() {
        return ((CJRJarvisApplication) CJRJarvisApplication.getAppContext()).f49007c;
    }

    public final void b(final AppCompatActivity appCompatActivity) {
        if (net.one97.paytm.deeplink.e.a()) {
            this.f52886a = net.one97.paytm.cashback.posttxn.c.a();
            if (this.f52886a != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventType", "APP_OPEN");
                    this.f52886a.a(appCompatActivity, new net.one97.paytm.cashback.posttxn.a() {
                        public final void onAnimationEnd(String str) {
                            a.a(appCompatActivity, str);
                        }

                        public final Point getFloatingWidgetPos(String str) {
                            return a.b(appCompatActivity, str);
                        }
                    }, jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }

    private static SFHomeFragment c(AppCompatActivity appCompatActivity) {
        if (appCompatActivity instanceof AJRMainActivity) {
            AJRMainActivity aJRMainActivity = (AJRMainActivity) appCompatActivity;
            androidx.viewpager.widget.a adapter = aJRMainActivity.f52664b != null ? aJRMainActivity.f52664b.getAdapter() : null;
            if (adapter instanceof net.one97.paytm.landingpage.a.b) {
                return ((net.one97.paytm.landingpage.a.b) adapter).f52655a;
            }
        }
        return null;
    }

    public final void x() {
        if (this.f52886a != null) {
            this.f52886a = null;
        }
    }

    public final void a(Context context, final net.one97.paytm.landingpage.c.b bVar) {
        net.one97.paytm.upgradeKyc.f.c.a().a(context, (c.b) new c.b() {
            public final void onNameInitialize(String str) {
                net.one97.paytm.landingpage.c.b bVar = bVar;
                if (bVar != null) {
                    bVar.a(str);
                }
            }

            public final void onNameInitializationError(String str) {
                net.one97.paytm.landingpage.c.b bVar = bVar;
                if (bVar != null) {
                    bVar.b(str);
                }
            }
        });
    }

    public final boolean k(Context context) {
        return net.one97.paytm.upgradeKyc.utils.j.j(context);
    }

    public final void l(Context context) {
        if (net.one97.paytm.common.b.d.b() != null) {
            boolean b2 = net.one97.paytm.common.b.d.b().b(context);
            if (net.one97.paytm.common.b.d.b().a("should_scan_for_fraud_apps", false) && !b2) {
                if (net.one97.paytm.common.b.d.b().a("should_scan_for_fraud_apps", false)) {
                    this.f52887b = new PackageScanManager(context);
                    this.f52887b.a();
                }
                this.f52887b.a(context, true);
            }
        }
    }

    public final void m(Context context) {
        if (net.one97.paytm.common.b.d.b() != null) {
            boolean b2 = net.one97.paytm.common.b.d.b().b(context);
            if (net.one97.paytm.common.b.d.b().a("should_scan_for_fraud_apps", false) && !b2) {
                this.f52887b = new PackageScanManager(context);
                this.f52887b.a();
            }
        }
    }

    public final void y() {
        PackageScanManager packageScanManager = this.f52887b;
        if (packageScanManager != null) {
            packageScanManager.f57025b.shutdown();
            try {
                if (!packageScanManager.f57025b.awaitTermination(200, TimeUnit.MILLISECONDS)) {
                    packageScanManager.f57025b.shutdownNow();
                }
            } catch (InterruptedException unused) {
                packageScanManager.f57025b.shutdownNow();
            }
            q.d("onDestroy");
            PackageScanManager packageScanManager2 = this.f52887b;
            if (packageScanManager2.f57026c != null && packageScanManager2.f57024a != null) {
                packageScanManager2.f57026c.unregisterReceiver(packageScanManager2.f57024a);
                packageScanManager2.f57024a = null;
            }
        }
    }

    public final void n(Context context) {
        f fVar = f.f50341a;
        f.b(context);
    }

    public final void o(Context context) {
        f fVar = f.f50341a;
        f.c(context);
    }

    public final boolean z() {
        return CJRJarvisApplication.b();
    }

    public final void A() {
        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {
            public final void run() {
                w wVar = w.f50379a;
                w.a();
            }
        });
    }

    public final void B() {
        CJRJarvisApplication.a();
    }

    public final void b(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.b(str, map, context);
    }

    public final void b(Activity activity) {
        Intent intent = new Intent(activity, AJRAuthActivity.class);
        intent.putExtra("launchSignUp", false);
        intent.putExtra("extra_intent_launch_show_dil", true);
        intent.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
        activity.startActivityForResult(intent, UpiPushView.REQUEST_CODE_UPI_CHECK_BALANCE);
    }

    static /* synthetic */ void a(AppCompatActivity appCompatActivity, String str) {
        IStaticWidget floatingWidget;
        SFHomeFragment c2 = c(appCompatActivity);
        if (c2 != null && (floatingWidget = c2.getFloatingWidget()) != null) {
            floatingWidget.AnimateView(str);
        }
    }

    static /* synthetic */ Point b(AppCompatActivity appCompatActivity, String str) {
        IStaticWidget floatingWidget;
        SFHomeFragment c2 = c(appCompatActivity);
        if (c2 == null || (floatingWidget = c2.getFloatingWidget()) == null) {
            return new Point(-1, -1);
        }
        return floatingWidget.getViewPoint(str);
    }
}
