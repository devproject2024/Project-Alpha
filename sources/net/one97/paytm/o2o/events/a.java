package net.one97.paytm.o2o.events;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import com.paytm.network.f;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.m;
import net.one97.paytm.y;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f73677a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static b f73678b;

    /* renamed from: c  reason: collision with root package name */
    private static C1478a f73679c;

    /* renamed from: net.one97.paytm.o2o.events.a$a  reason: collision with other inner class name */
    public interface C1478a {
        void sendCustomEventWithMap(String str, Map<String, ? extends Object> map, Context context);

        void sendGTMOrderSummaryTag(Context context, CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str, Boolean bool, String str2, String str3, Long l);

        void sendOpenScreenWithDeviceInfo(String str, String str2, Context context);

        void sendPaytmAssistGAEvents(CJROrderSummary cJROrderSummary, y yVar, Context context);
    }

    public interface b {
        String createRequestBodyForV2(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel);

        Context getAppContext();

        Class<? extends Activity> getEmbedWebView();

        Class<? extends Activity> getLoginActivity();

        Class<? extends Activity> getMainActivity();

        String getMainActivityClassName();

        String getNameForAJROrderSummaryActivity();

        String getStringFromGTM(String str);

        String getStringFromGTMContainer4(String str);

        void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, m mVar);

        void handleError(Activity activity, Exception exc, String str, Bundle bundle, Boolean bool);

        void loadCashBackOffersView(String str, ViewGroup viewGroup, String str2, j jVar, Context context);

        View onTransactionComplete(SFWidget sFWidget, Context context, String str, net.one97.paytm.utils.b.a aVar);

        boolean reportError(Context context, Exception exc, String str);

        void sendTransactionBetaOutForWallet(Context context, String str, String str2, String str3, String str4);
    }

    private a() {
    }

    public static final void a(Application application, b bVar, C1478a aVar) {
        k.c(application, "application");
        k.c(bVar, "amparkToJarvisHandler");
        k.c(aVar, "amparkAnalyticsHandler");
        f73678b = bVar;
        f73679c = aVar;
        f.a((Context) application);
    }

    public static final b a() {
        return f73678b;
    }

    public static final C1478a b() {
        return f73679c;
    }
}
