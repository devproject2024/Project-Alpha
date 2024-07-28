package net.one97.paytm.dynamic.module.movie;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRYoutubeVideoPlay;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.f.b;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.o2o.events.a;
import net.one97.paytm.utils.ar;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.c.n;

public final class EventsToJarvisHandlerImpl implements a.b {
    public final int getDealContentId() {
        return 0;
    }

    public final int getEntertainmentDealTypeValue() {
        return 234;
    }

    public final void clearRiskInformation() {
        b.a().c();
    }

    public final String createRequestBodyForV2(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel) {
        k.c(context, "context");
        String a2 = net.one97.paytm.deeplink.k.a(context, str, str2, cJRSelectCityModel);
        k.a((Object) a2, "EventDeeplinkHandler.cre…Page, cjrSelectCityModel)");
        return a2;
    }

    public final void fetchPaymentOptions(Context context, CJRRechargePayment cJRRechargePayment, net.one97.paytm.o2o.events.b.b bVar) {
        k.c(context, "context");
        k.c(bVar, "fetchEventPayOptionsListener");
        t.a(context, cJRRechargePayment, (FetchPayOptionsListener) new EventsToJarvisHandlerImpl$fetchPaymentOptions$1(bVar));
    }

    public final Context getAppContext() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public final ContextWrapper getBaseContext(Context context) {
        k.c(context, "context");
        ContextThemeWrapper a2 = e.a(context);
        k.a((Object) a2, "Restring.wrapContext(context)");
        return a2;
    }

    public final String getBuildTypeString() {
        String c2 = net.one97.paytm.deeplink.k.c();
        k.a((Object) c2, "EventDeeplinkHandler.getBuildTypeString()");
        return c2;
    }

    public final Class<? extends Activity> getEmbedWebView() {
        return AJREmbedWebView.class;
    }

    public final int getIntFromGTM(String str) {
        k.c(str, "key");
        c.a();
        return c.b(str);
    }

    public final String getJsonOfRiskExtendedInfo(Context context) {
        k.c(context, "context");
        b.a().c();
        b.a().a(context, (String) null, (String) null, false, (String) null, com.paytm.utility.a.g(context), com.paytm.utility.a.h(context));
        b a2 = b.a();
        k.a((Object) a2, "RiskInformationController.getInstance()");
        return a2.d();
    }

    public final Class<? extends Activity> getLoginActivity() {
        return AJRAuthActivity.class;
    }

    public final Class<? extends Activity> getMainActivity() {
        return AJRMainActivity.class;
    }

    public final String getMainActivityClassName() {
        String name = AJRMainActivity.class.getName();
        k.a((Object) name, "AJRMainActivity::class.java.name");
        return name;
    }

    public final String getNameForAJROrderSummaryActivity() {
        String name = AJROrderSummaryActivity.class.getName();
        k.a((Object) name, "AJROrderSummaryActivity::class.java.name");
        return name;
    }

    public final Class<? extends Activity> getPaymentActivity() {
        return AJRRechargePaymentActivity.class;
    }

    public final String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return t.a(cJRPGTokenList);
    }

    public final boolean getPicassoIsInMemory() {
        return CJRJarvisApplication.f();
    }

    public final Fragment getPostPaymentDealsFragment() {
        return new n();
    }

    public final String getPostPaymentDealsFragmentTagValue() {
        String str = n.f70086a;
        k.a((Object) str, "PostPaymentDealsFragment.TAG");
        return str;
    }

    public final Class<? extends Activity> getRechargePaymentActivityClass() {
        return AJRRechargePaymentActivity.class;
    }

    public final String getSSOToken(Context context) {
        k.c(context, "context");
        return t.b(context);
    }

    public final String getStringFromGTM(String str) {
        k.c(str, "key");
        c.a();
        String a2 = c.a(str);
        k.a((Object) a2, "GTMLoader.getInstance().getString(key)");
        return a2;
    }

    public final Class<? extends Activity> getYoutubeVideoPlayClass() {
        return AJRYoutubeVideoPlay.class;
    }

    public final void handleDeepLink(Context context, DeepLinkData deepLinkData, Bundle bundle) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        k.c(bundle, "bundle");
        h.a aVar = h.f50349a;
        h.a.a(context, deepLinkData.f50283a, (Bundle) null);
    }

    public final void handleError(Activity activity, Exception exc, String str, Bundle bundle, Boolean bool) {
        k.c(activity, "activity");
        net.one97.paytm.deeplink.k.a(activity, exc, str, bundle, bool);
    }

    public final void handlePlayServicesError(Activity activity) {
        k.c(activity, "activity");
        net.one97.paytm.deeplink.k.a(activity);
    }

    public final boolean isDebugType() {
        return net.one97.paytm.deeplink.k.b();
    }

    public final boolean isStagingType() {
        return net.one97.paytm.deeplink.k.a();
    }

    public final void loadCashBackOffersView(String str, ViewGroup viewGroup, String str2, j jVar, Context context) {
        k.c(context, "context");
        if (!TextUtils.isEmpty(str2) && p.a(str2, "Payment", true)) {
            net.one97.paytm.deeplink.k.a(str, viewGroup, str2, context);
        }
    }

    public final void loadPage(Context context, String str, String str2, HashMap<String, String> hashMap, String str3) {
        k.c(context, "context");
        net.one97.paytm.marketplace.a.a(context, "search", (HashMap<String, Serializable>) new EventsToJarvisHandlerImpl$loadPage$1(str2, hashMap, str3, str));
    }

    public final void loadPage(Context context, String str, CJRItem cJRItem, String str2, Integer num, ArrayList<? extends CJRItem> arrayList, Boolean bool, String str3) {
        Context context2 = context;
        k.c(context, "context");
        IJRDataModel iJRDataModel = cJRItem;
        if (num == null) {
            k.a();
        }
        int intValue = num.intValue();
        if (bool == null) {
            k.a();
        }
        net.one97.paytm.utils.j.a(context, str, iJRDataModel, str2, intValue, arrayList, bool.booleanValue(), str3, (net.one97.paytm.c) null);
    }

    public final void loadpdpBrand(Context context, String str, CJRItem cJRItem, String str2, Integer num, ArrayList<? extends CJRItem> arrayList, Boolean bool, String str3, String str4, String str5, String str6, String str7, String str8) {
        Context context2 = context;
        k.c(context, "context");
        IJRDataModel iJRDataModel = cJRItem;
        if (num == null) {
            k.a();
        }
        int intValue = num.intValue();
        if (bool == null) {
            k.a();
        }
        net.one97.paytm.utils.j.a(context, str, iJRDataModel, str2, intValue, arrayList, bool.booleanValue(), str3, str4, str5, str6, str7, str8);
    }

    public final boolean reportError(Context context, Exception exc, String str) {
        k.c(context, "inContext");
        return net.one97.paytm.deeplink.k.a(context, exc, str);
    }

    public final void sendTransactionBetaOutForWallet(Context context, String str, String str2, String str3, String str4) {
        k.c(context, "context");
        ar.a(str);
    }

    public final void signOut(Activity activity, Boolean bool, VolleyError volleyError) {
        k.c(activity, "activity");
        if (bool == null) {
            k.a();
        }
        bool.booleanValue();
        net.one97.paytm.auth.b.b.c(activity);
    }

    public final void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, m mVar) {
        k.c(bundle, "bundle");
        if (mVar == null) {
            k.a();
        }
        mVar.show();
        d.a((Context) activity, bundle, mVar);
    }

    public final boolean getBooleanFromGTM(String str) {
        k.c(str, "s");
        c.a();
        return c.a(str, false);
    }

    public final String getStringFromGTMContainer4(String str) {
        k.c(str, "str");
        c.a();
        String a2 = c.a(str, "");
        k.a((Object) a2, "GTMLoader.getInstance().getString(str, \"\")");
        return a2;
    }

    public final View onTransactionComplete(SFWidget sFWidget, Context context, String str, net.one97.paytm.utils.b.a aVar) {
        net.one97.paytm.cashback.posttxn.e a2;
        k.c(sFWidget, "sfWidget");
        k.c(context, "context");
        k.c(str, "orderId");
        k.c(aVar, "transactionType");
        if (!net.one97.paytm.deeplink.e.a() || (a2 = net.one97.paytm.cashback.posttxn.c.a()) == null || !a2.a(aVar.getId(), 0)) {
            return null;
        }
        a2.a((AppCompatActivity) context);
        f.a aVar2 = new f.a();
        aVar2.f49546b = str;
        aVar2.f49550f = a.c.EVENT.name();
        a2.a(aVar2.a(), (net.one97.paytm.cashback.posttxn.a) new EventsToJarvisHandlerImpl$onTransactionComplete$$inlined$let$lambda$1(aVar, a2, context, str, sFWidget));
        return null;
    }
}
