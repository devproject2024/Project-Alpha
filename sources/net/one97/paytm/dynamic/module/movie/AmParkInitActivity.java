package net.one97.paytm.dynamic.module.movie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.sendbird.android.constant.StringSet;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.g;
import java.util.concurrent.Callable;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.dynamic.module.movie.deeplink.AmparkDeeplinkConfig;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.activity.AmParkVerticalActivity;

public class AmParkInitActivity extends AppCompatActivity {
    DeepLinkData deepLinkData;
    private c deeplinkHandlerDisposable;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.deepLinkData = (DeepLinkData) getIntent().getExtras().getParcelable("EXTRA_DEEP_LINK_DATA");
        }
        a.a(getApplication(), new AmparkToJarvisHandlerImpl(), new AmparkAnalyticsHandlerImpl());
        if (getIntent() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            checkForDeepLinkIntent(this, this.deepLinkData);
        } else if (getIntent() != null) {
            launchUsingIntent(getIntent());
        }
        finish();
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
            cJRHomePageItem.setmParkName(uri.getQueryParameter("park_name"));
            cJRHomePageItem.setmParkId(uri.getQueryParameter("park_id"));
            cJRHomePageItem.setmParkCategory(uri.getQueryParameter("category_name"));
            cJRHomePageItem.setmParkProviderId(uri.getQueryParameter("provider_id"));
            cJRHomePageItem.setmParkCityName(uri.getQueryParameter("city_name"));
            cJRHomePageItem.setmParkcityLabel(uri.getQueryParameter("cityLabel"));
            cJRHomePageItem.setParkcityValue(uri.getQueryParameter("cityValue"));
        }
        cJRHomePageItem.setDeeplink(deepLinkData2.f50283a);
        cJRHomePageItem.setUrlType(deepLinkData2.f50284b);
        launchDeeplinkPage(context, cJRHomePageItem);
    }

    private void launchDeeplinkPage(Context context, CJRHomePageItem cJRHomePageItem) {
        if (cJRHomePageItem.getDeeplink().contains(StringSet.order)) {
            handleDeeplink(this.deepLinkData);
        } else {
            context.startActivity(getIntent(context, cJRHomePageItem));
        }
    }

    private void handleDeeplink(DeepLinkData deepLinkData2) {
        c cVar = this.deeplinkHandlerDisposable;
        if (cVar != null) {
            cVar.dispose();
            this.deeplinkHandlerDisposable = null;
        }
        AmparkDeeplinkConfig amparkDeeplinkConfig = new AmparkDeeplinkConfig(this);
        this.deeplinkHandlerDisposable = y.a(new Callable(deepLinkData2) {
            private final /* synthetic */ DeepLinkData f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return AmparkDeeplinkConfig.this.resolveDeeplink(this.f$1);
            }
        }).b(io.reactivex.rxjava3.i.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g() {
            public final void accept(Object obj) {
                AmParkInitActivity.this.lambda$handleDeeplink$1$AmParkInitActivity((Intent) obj);
            }
        }, (g<? super Throwable>) new g(amparkDeeplinkConfig) {
            private final /* synthetic */ AmparkDeeplinkConfig f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                AmParkInitActivity.this.lambda$handleDeeplink$2$AmParkInitActivity(this.f$1, (Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$handleDeeplink$1$AmParkInitActivity(Intent intent) throws Throwable {
        startActivity(intent);
        finishActivity();
    }

    public /* synthetic */ void lambda$handleDeeplink$2$AmParkInitActivity(AmparkDeeplinkConfig amparkDeeplinkConfig, Throwable th) throws Throwable {
        startActivity(amparkDeeplinkConfig.getDeeplinkIntent());
        finishActivity();
    }

    private void finishActivity() {
        finish();
    }

    private static Intent getIntent(Context context, CJRHomePageItem cJRHomePageItem) {
        Intent intent;
        String uRLType = cJRHomePageItem.getURLType();
        if (((uRLType.hashCode() == 1611065785 && uRLType.equals("amusement")) ? (char) 0 : 65535) != 0) {
            intent = null;
        } else {
            intent = new Intent(context, AmParkVerticalActivity.class);
        }
        intent.putExtra("extra_home_data", cJRHomePageItem);
        intent.putExtra("is_deep_linking_data", cJRHomePageItem.isDeepLinking());
        intent.putExtra("origin", "deeplinking");
        intent.setFlags(67108864);
        return intent;
    }

    private void launchUsingIntent(Intent intent) {
        if (intent.hasExtra("RESULTANT_ACTIVITY_NAME")) {
            intent.setClassName(this, intent.getStringExtra("RESULTANT_ACTIVITY_NAME"));
            intent.setFlags(67108864);
            startActivity(intent);
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void reInitialized() {
        a.a(getApplication(), new AmparkToJarvisHandlerImpl(), new AmparkAnalyticsHandlerImpl());
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }
}
