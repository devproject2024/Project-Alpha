package net.one97.paytm.dynamic.module.movie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gsonhtcfix.f;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.i.a;
import java.util.concurrent.Callable;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.k;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.dynamic.module.movie.deeplink.EventDeeplinkConfig;
import net.one97.paytm.paytm_finance.R;

public class EventInitActivity extends AppCompatActivity {
    DeepLinkData deepLinkData;
    private c deeplinkHandlerDisposable;
    LottieAnimationView lottieAnimationView;
    private BroadcastReceiver mDataSetupReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(EventsH5Constant.WEEX_SERVICE_REGISTERED)) {
                EventInitActivity.this.hideLoaderView();
                if (intent.getBooleanExtra(EventsH5Constant.WEEX_SERVICE_IS_REGISTERED, false)) {
                    EventInitActivity.this.loadPage();
                }
            }
        }
    };

    public static String getInsiderUrl() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(EventsH5Constant.EVENTS_INSIDER_URL, (String) null);
    }

    public static String getAppUniqueId() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(EventsH5Constant.EVENTS_UNIQUE_APP_ID, (String) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.event_lotttie_view);
        this.lottieAnimationView = (LottieAnimationView) findViewById(R.id.ltv_loading);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.deepLinkData = (DeepLinkData) getIntent().getExtras().getParcelable("EXTRA_DEEP_LINK_DATA");
        }
        loadPage();
    }

    public void checkForDeepLinkIntent(Context context, DeepLinkData deepLinkData2) {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        Uri uri = deepLinkData2.f50289g;
        if (uri != null) {
            if (!TextUtils.isEmpty(uri.toString())) {
                cJRHomePageItem.setUrl(uri.toString());
            }
            cJRHomePageItem.setPushUtmSource(uri.getQueryParameter("utm_source"));
            cJRHomePageItem.setUtmMedium(uri.getQueryParameter("utm_medium"));
            cJRHomePageItem.setUtmTerm(uri.getQueryParameter("utm_term"));
            cJRHomePageItem.setUtmContent(uri.getQueryParameter("utm_content"));
            cJRHomePageItem.setUtmCampaign(uri.getQueryParameter("utm_campaign"));
            cJRHomePageItem.setDeepLinking(true);
            cJRHomePageItem.setQrid(uri.getQueryParameter("qrid"));
            cJRHomePageItem.setEventName(uri.getQueryParameter("events_name"));
            cJRHomePageItem.setmEventId(uri.getQueryParameter("events_id"));
            cJRHomePageItem.setEventCategory(uri.getQueryParameter("category_name"));
            cJRHomePageItem.setEventSubCategory(uri.getQueryParameter("sub_category_name"));
            cJRHomePageItem.setEventProviderId(uri.getQueryParameter("provider_id"));
            cJRHomePageItem.setEventCityName(uri.getQueryParameter("city_name"));
            cJRHomePageItem.setmGroupId(uri.getQueryParameter("groupid"));
        }
        cJRHomePageItem.setDeeplink(deepLinkData2.f50283a);
        cJRHomePageItem.setUrlType(deepLinkData2.f50284b);
        launchDeeplinkPage(context, cJRHomePageItem);
    }

    private void launchDeeplinkPage(Context context, CJRHomePageItem cJRHomePageItem) {
        net.one97.paytm.j.c.a();
        boolean a2 = net.one97.paytm.j.c.a(EventsH5Constant.EVENTS_H5_FLOW_ENABLED, true);
        Bundle bundle = new Bundle();
        bundle.putBoolean("pullRefresh", false);
        bundle.putBoolean("canPullDown", false);
        bundle.putString("buildType", k.c());
        bundle.putString("jsVersion", EventUtility.getJsVersion());
        bundle.putString("fixVersion", EventUtility.getFixVersion());
        String deeplink = cJRHomePageItem.getDeeplink();
        if (deeplink != null && deeplink.contains("insiderH5Url=") && a2) {
            u.a().a(EventsModuleManager.MODULE_NAME, getAppUniqueId(), deeplink.substring(deeplink.indexOf("insiderH5Url=")).replaceFirst("insiderH5Url=", "").trim(), bundle, new f().a((Object) cJRHomePageItem), context);
        } else if ((deeplink == null || !deeplink.contains("event_order_summary")) && a2) {
            u.a().a(EventsModuleManager.MODULE_NAME, getAppUniqueId(), getInsiderUrl(), bundle, new f().a((Object) cJRHomePageItem), context);
        } else {
            handleDeeplink(this.deepLinkData);
        }
    }

    private void launchUsingIntent(Intent intent) {
        net.one97.paytm.j.c.a();
        boolean a2 = net.one97.paytm.j.c.a(EventsH5Constant.EVENTS_H5_FLOW_ENABLED, true);
        if (intent.hasExtra("RESULTANT_ACTIVITY_NAME")) {
            String stringExtra = intent.getStringExtra("RESULTANT_ACTIVITY_NAME");
            if (!"net.one97.paytm.o2o.events.activity.EventsVerticalActivity".equals(stringExtra) || !a2) {
                intent.setClassName(this, stringExtra);
                intent.setFlags(67108864);
                startActivity(intent);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("pullRefresh", false);
            bundle.putBoolean("canPullDown", false);
            bundle.putString("buildType", k.c());
            bundle.putString("jsVersion", EventUtility.getJsVersion());
            bundle.putString("fixVersion", EventUtility.getFixVersion());
            u.a().a(EventsModuleManager.MODULE_NAME, getAppUniqueId(), getInsiderUrl(), bundle, (String) null, (Context) this);
        }
    }

    private void handleDeeplink(DeepLinkData deepLinkData2) {
        c cVar = this.deeplinkHandlerDisposable;
        if (cVar != null) {
            cVar.dispose();
            this.deeplinkHandlerDisposable = null;
        }
        EventDeeplinkConfig eventDeeplinkConfig = new EventDeeplinkConfig(this);
        this.deeplinkHandlerDisposable = y.a(new Callable(deepLinkData2) {
            private final /* synthetic */ DeepLinkData f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return EventDeeplinkConfig.this.resolveDeeplink(this.f$1);
            }
        }).b(a.a()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g() {
            public final void accept(Object obj) {
                EventInitActivity.this.lambda$handleDeeplink$1$EventInitActivity((Intent) obj);
            }
        }, (g<? super Throwable>) new g(eventDeeplinkConfig) {
            private final /* synthetic */ EventDeeplinkConfig f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                EventInitActivity.this.lambda$handleDeeplink$2$EventInitActivity(this.f$1, (Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$handleDeeplink$1$EventInitActivity(Intent intent) throws Throwable {
        startActivity(intent);
        finishActivity();
    }

    public /* synthetic */ void lambda$handleDeeplink$2$EventInitActivity(EventDeeplinkConfig eventDeeplinkConfig, Throwable th) throws Throwable {
        startActivity(eventDeeplinkConfig.getDeeplinkIntent());
        finishActivity();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    private void finishActivity() {
        finish();
    }

    /* access modifiers changed from: private */
    public void loadPage() {
        new EventsModuleManager().init(getApplication());
        net.one97.paytm.o2o.events.a.a(getApplication(), new EventsToJarvisHandlerImpl(), new EventsAnalyticsHandlerImpl());
        if (getIntent() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            checkForDeepLinkIntent(this, this.deepLinkData);
        } else if (getIntent() != null) {
            launchUsingIntent(getIntent());
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.deeplinkHandlerDisposable;
        if (cVar != null) {
            cVar.dispose();
            this.deeplinkHandlerDisposable = null;
        }
    }

    private void showLoaderView() {
        LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(0);
            this.lottieAnimationView.setAnimation("Payments-Loader.json");
            this.lottieAnimationView.loop(true);
            this.lottieAnimationView.playAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void hideLoaderView() {
        LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
            this.lottieAnimationView.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }
}
