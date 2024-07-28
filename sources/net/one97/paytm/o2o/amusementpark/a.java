package net.one97.paytm.o2o.amusementpark;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.m;
import net.one97.paytm.o2o.amusementpark.d.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f73057a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static b f73058b;

    /* renamed from: c  reason: collision with root package name */
    private static C1469a f73059c;

    /* renamed from: net.one97.paytm.o2o.amusementpark.a$a  reason: collision with other inner class name */
    public interface C1469a {
        void sendCustomEventWithMap(String str, Map<String, ? extends Object> map, Context context);

        void sendDeepLinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context);

        void sendPaytmAssistGAEvents(String str, String str2, Context context);

        void sendPromotionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2);

        void sendPromotionImpression(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str);
    }

    public interface b {
        void clearRiskInformation();

        String createRequestBodyForV2(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel);

        void fetchPaymentOptions(Context context, CJRRechargePayment cJRRechargePayment, f fVar);

        Context getAppContext();

        String getApplicationVersion(Context context);

        ContextWrapper getBaseContext(Context context);

        int getDealContentId();

        int getEntertainmentDealTypeValue();

        int getIntFromGTM(String str);

        Class<? extends Activity> getItemLevelOrderClass();

        String getJsonOfRiskExtendedInfo(Context context);

        Class<? extends Activity> getLoginActivity();

        Class<? extends Activity> getMainActivity();

        String getNameForAJROrderSummaryActivity();

        Class<? extends Activity> getPaymentActivity();

        String getPgToken(CJRPGTokenList cJRPGTokenList);

        boolean getPicassoIsInMemory();

        Fragment getPostPaymentDealsFragment();

        String getPostPaymentDealsFragmentTagValue();

        String getSSOToken(Context context);

        String getStringFromGTM(String str);

        void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, m mVar);

        void getWalletToken(String str, Activity activity, com.paytm.network.listener.b bVar);

        Class<? extends Activity> getYoutubeActivityClass();

        void handlePlayServicesError(Activity activity);

        boolean isDebugType();

        void loadPage(Context context, String str, CJRItem cJRItem, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3);

        void sendTransactionBetaOutForWallet(Context context, String str, String str2, String str3, String str4);

        void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, Exception exc);
    }

    private a() {
    }

    public static final void a(Application application, b bVar, C1469a aVar) {
        k.c(application, "application");
        k.c(bVar, "amparkToJarvisHandler");
        k.c(aVar, "amparkAnalyticsHandler");
        f73058b = bVar;
        f73059c = aVar;
        com.paytm.network.f.a((Context) application);
    }

    public static final b a() {
        return f73058b;
    }

    public static final C1469a b() {
        return f73059c;
    }
}
