package net.one97.paytm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import com.google.firebase.perf.metrics.Trace;
import com.paytm.notification.g;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.c.a;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.b;
import net.one97.paytm.landingpage.utils.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.c;
import net.one97.paytm.utils.t;
import net.one97.paytm.utils.u;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;

public class AJRJarvisSplash extends Activity implements a.C0882a {

    /* renamed from: a  reason: collision with root package name */
    ViewTreeObserver.OnWindowFocusChangeListener f51368a = new ViewTreeObserver.OnWindowFocusChangeListener() {
        public final void onWindowFocusChanged(boolean z) {
            AJRJarvisSplash.this.a(z);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private e f51369b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Trace a2 = com.google.firebase.perf.a.a("onCreateSplashTrace");
        super.onCreate(bundle);
        d.b().k();
        CJRJarvisApplication.s();
        getWindow().getDecorView().getViewTreeObserver().addOnWindowFocusChangeListener(this.f51368a);
        u.a().a((Activity) this, getIntent());
        u.a().f69793b = false;
        a2.stop();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void a() {
        CJRHomePageItem cJRHomePageItem;
        Bundle bundle;
        if (getIntent().getBooleanExtra("from_shortcut", false)) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("mobile_homescreen_icon_name", "scan");
                net.one97.paytm.j.a.b("mobile_homescreen_paytm_icon_clicked", (Map<String, Object>) hashMap, getApplicationContext());
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
            Intent intent = new Intent(this, PaySendActivityV2.class);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, false);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
            return;
        }
        com.paytm.utility.a.c();
        if (!u.a().b((Activity) this, getIntent())) {
            Intent intent2 = new Intent(this, AJRMainActivity.class);
            if (!TextUtils.isEmpty(getIntent().getStringExtra("referralSource"))) {
                this.f51369b = new e(this);
                cJRHomePageItem = this.f51369b.a();
                if (cJRHomePageItem != null) {
                    intent2.putExtra("is_referral_data", true);
                    intent2.putExtra("referral_data", cJRHomePageItem);
                }
            } else {
                cJRHomePageItem = null;
            }
            if (!getIntent().getBooleanExtra("push_notification", false)) {
                Uri data = getIntent().getData();
                if (data != null) {
                    cJRHomePageItem = c.a((Context) this, data.toString());
                    if (cJRHomePageItem == null || cJRHomePageItem.getURLType() == null || !cJRHomePageItem.getURLType().equalsIgnoreCase("merchantpayment")) {
                        if (cJRHomePageItem == null && !TextUtils.isEmpty(data.toString()) && data.toString().startsWith("paytmmp")) {
                            intent2.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
                        } else if (cJRHomePageItem != null) {
                            String uRLType = cJRHomePageItem.getURLType();
                            if (uRLType != null && (uRLType.equalsIgnoreCase("homepage_primary") || uRLType.equalsIgnoreCase("open"))) {
                                intent2.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
                            } else if (uRLType != null && uRLType.equalsIgnoreCase("jnua.app.link")) {
                                intent2.putExtra("extra_open_sherose_feed_tab", "main");
                                intent2.putExtra("extra_home_data", cJRHomePageItem);
                            } else if (!TextUtils.isEmpty(data.toString()) && data.toString().startsWith("paytmmp") && "news_details".equals(uRLType)) {
                                intent2.putExtra("extra_home_data", cJRHomePageItem);
                                intent2.putExtra("isnewsDetails", true);
                            }
                        }
                    } else if (t.b(getApplicationContext()) == null) {
                        Intent intent3 = new Intent(this, AJRAuthActivity.class);
                        intent3.putExtra("launchSignUp", false);
                        intent3.putExtra("set_result_required", true);
                        startActivityForResult(intent3, AppConstants.NOT_TIME);
                        return;
                    } else {
                        h.a aVar = h.f50349a;
                        h.a.a(this, cJRHomePageItem.getDeeplink(), (Bundle) null);
                        return;
                    }
                }
                if (!(cJRHomePageItem == null || cJRHomePageItem.getURLType() == null || !cJRHomePageItem.getURLType().equalsIgnoreCase("myprofile"))) {
                    intent2.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "myprofile");
                }
                if (cJRHomePageItem != null && data != null && !TextUtils.isEmpty(data.toString()) && (data.toString().contains("https") || data.toString().contains("http"))) {
                    intent2.putExtra("urlToCheck", cJRHomePageItem.getDeeplink());
                } else if (data != null && !TextUtils.isEmpty(data.toString())) {
                    intent2.putExtra("urlToCheck", data.toString());
                }
            }
            boolean booleanExtra = getIntent().getBooleanExtra("intent_from_wear", false);
            boolean booleanExtra2 = getIntent().getBooleanExtra("extra_intent_from_wear_launch_favourites", false);
            if (booleanExtra) {
                String stringExtra = getIntent().getStringExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE);
                intent2.putExtra("extra_intent_from_wear_launch_favourites", booleanExtra2);
                if (!TextUtils.isEmpty(stringExtra)) {
                    intent2.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, stringExtra);
                }
            }
            if (getIntent().hasExtra("query")) {
                intent2.putExtra("query", getIntent().getStringExtra("query"));
            }
            boolean booleanExtra3 = getIntent().getBooleanExtra("isFromNotification", false);
            if (getIntent().getExtras() != null) {
                bundle = getIntent().getExtras().getBundle("notificationBundle");
            } else {
                bundle = null;
            }
            intent2.putExtra("wasLaunchedFromRecent", (getIntent().getFlags() & 1048576) == 1048576);
            if (booleanExtra3) {
                if (bundle != null) {
                    intent2.putExtra("deepLinkUrl", bundle.getString("url_type", ""));
                }
                intent2.putExtra("isFromNotification", true);
            }
            intent2.putExtra("notificationBundle", bundle);
            ((CJRJarvisApplication) getApplication()).f49006b = null;
            if (this.f51369b != null) {
                intent2.addFlags(65536);
            }
            startActivity(intent2);
            overridePendingTransition(0, 0);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 50002) {
            setResult(-1, intent);
            finish();
        } else if (i2 == 50001) {
            if (com.paytm.utility.a.p(getApplicationContext())) {
                if (getIntent() != null) {
                    u.a();
                    u.a(getIntent(), this, SDKConstants.AI_LOGIN_SCREEN);
                }
                u.a().b((Activity) this, getIntent());
                return;
            }
            setResult(-1, intent);
            finish();
        } else if (i2 == 50000) {
            if (com.paytm.utility.a.p(getApplicationContext())) {
                CJRHomePageItem a2 = c.a((Context) this, getIntent().getData().toString());
                h.a aVar = h.f50349a;
                h.a.a(this, a2.getDeeplink(), (Bundle) null);
                return;
            }
            setResult(-1, intent);
            finish();
        } else if (i2 == 50003 && intent != null) {
            Intent intent2 = new Intent();
            intent2.putExtra(SDKConstants.RESPONSE, intent.getStringExtra(SDKConstants.RESPONSE));
            intent2.putExtra("nativeSdkForMerchantMessage", intent.getStringExtra("nativeSdkForMerchantMessage"));
            setResult(i3, intent2);
            finish();
        } else if (i2 == 1) {
            a();
        }
    }

    public final void a(int i2) {
        if (i2 == 1 || i2 == 0 || i2 == 3) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getWindow().getDecorView().getViewTreeObserver().removeOnWindowFocusChangeListener(this.f51368a);
        u.a();
        u.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z && !u.a().f69793b) {
            new b().a(getApplicationContext());
            a();
            AsyncTask.SERIAL_EXECUTOR.execute(new u.b(this, getIntent()));
            try {
                net.one97.paytm.j.c.a();
                if (net.one97.paytm.j.c.a("notification_sdk_enabled", true)) {
                    g.c cVar = g.f43191a;
                    g.c.a(com.paytm.utility.b.n(getApplicationContext()));
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }
}
