package net.one97.paytm.dynamic.module.movie;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.paytm.utility.q;
import java.util.ArrayList;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRYoutubeVideoPlay;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.c;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.f.b;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.activity.AmParkOrderSummary;
import net.one97.paytm.o2o.amusementpark.d.f;
import net.one97.paytm.utils.ar;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.c.n;

public class AmparkToJarvisHandlerImpl implements a.b {
    public String getBuildTypeString() {
        return "release";
    }

    public int getDealContentId() {
        return 0;
    }

    public int getEntertainmentDealTypeValue() {
        return 234;
    }

    public Class<? extends Activity> getItemLevelOrderClass() {
        return null;
    }

    public int getPromoScreenCodeValue() {
        return 700;
    }

    public boolean isDebugType() {
        return false;
    }

    public void clearRiskInformation() {
        b.a().c();
    }

    public String createRequestBodyForV2(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel) {
        return net.one97.paytm.deeplink.b.a(context, str, str2, cJRSelectCityModel);
    }

    public void fetchPaymentOptions(Context context, CJRRechargePayment cJRRechargePayment, final f fVar) {
        if (context != null) {
            t.a(context, cJRRechargePayment, (FetchPayOptionsListener) new FetchPayOptionsListener() {
                public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
                }

                public void onRequestStart() {
                }

                public void onVpaReceived(VpaFetch vpaFetch) {
                }

                public void onPaymentOptionsError() {
                    fVar.a();
                }

                public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                    PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                    fVar.b();
                }
            });
        }
    }

    public Class<? extends Activity> getAmParkOrderSummaryClass() {
        return AmParkOrderSummary.class;
    }

    public Context getAppContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public ContextWrapper getBaseContext(Context context) {
        return e.a(context);
    }

    public String getCustomerId(Context context) {
        return com.paytm.utility.a.q(context) != null ? com.paytm.utility.a.a(context) : "";
    }

    public String getJsonOfRiskExtendedInfo(Context context) {
        b.a().c();
        b.a().a(context, (String) null, (String) null, false, (String) null, com.paytm.utility.a.g(context), com.paytm.utility.a.h(context));
        return b.a().d();
    }

    public Class<? extends Activity> getLoginActivity() {
        return AJRAuthActivity.class;
    }

    public Class<? extends Activity> getMainActivity() {
        return AJRMainActivity.class;
    }

    public String getNameForAJROrderSummaryActivity() {
        return AJROrderSummaryActivity.class.getName();
    }

    public Class<? extends Activity> getPaymentActivity() {
        return AJRRechargePaymentActivity.class;
    }

    public boolean getPicassoIsInMemory() {
        return CJRJarvisApplication.f();
    }

    public Fragment getPostPaymentDealsFragment() {
        return new n();
    }

    public String getPostPaymentDealsFragmentTagValue() {
        return n.f70086a;
    }

    public String getShoppingCartActivityClassName() {
        return net.one97.paytm.marketplace.a.j().getName();
    }

    public void handlePlayServicesError(Activity activity) {
        net.one97.paytm.deeplink.b.a(activity);
    }

    public boolean isTokenInCacheValid(Activity activity) {
        return t.j(activity);
    }

    public void loadPage(Context context, String str, CJRItem cJRItem, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        j.a(context, str, (IJRDataModel) cJRItem, str2, i2, arrayList, z, str3, (c) null);
    }

    public void loadpdpBrand(Context context, String str, CJRItem cJRItem, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, String str4, String str5, String str6, String str7, String str8) {
        j.a(context, str, cJRItem, str2, i2, arrayList, z, str3, str4, str5, str6, str7, str8);
    }

    public void sendTransactionBetaOutForWallet(Context context, String str, String str2, String str3, String str4) {
        ar.a(str);
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, Exception exc) {
        net.one97.paytm.deeplink.b.a(activity, str, bundle);
    }

    public Class<? extends Activity> getYoutubeActivityClass() {
        return AJRYoutubeVideoPlay.class;
    }

    public String getApplicationVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
            return null;
        }
    }

    public int getIntFromGTM(String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, 0);
    }

    public String getStringFromGTM(String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, m mVar) {
        mVar.show();
        d.a((Context) activity, bundle, mVar);
    }

    public String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return t.a(cJRPGTokenList);
    }

    public String getSSOToken(Context context) {
        return t.b(context);
    }

    public void getWalletToken(String str, Activity activity, com.paytm.network.listener.b bVar) {
        t.a(activity, bVar, a.c.AM_PARK);
    }

    public void sessionManagerSignOut(Activity activity, boolean z, VolleyError volleyError) {
        try {
            net.one97.paytm.auth.b.b.a(activity, false);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void signOut(Activity activity, boolean z, VolleyError volleyError) {
        net.one97.paytm.auth.b.b.a(activity, false);
    }
}
