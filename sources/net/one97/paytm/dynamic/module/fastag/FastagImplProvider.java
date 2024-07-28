package net.one97.paytm.dynamic.module.fastag;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.List;
import java.util.Map;
import net.one97.paytm.AJREmbedWebView;
import net.one97.paytm.AJRSellarRating;
import net.one97.paytm.AJRWebViewActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.l;
import net.one97.paytm.fastag.c.a;
import net.one97.paytm.fastag.c.b;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.fastag.ui.activity.FasTagKYCActivity;
import net.one97.paytm.j.c;
import net.one97.paytm.m;
import net.one97.paytm.utils.t;

public class FastagImplProvider implements b {
    static FastagImplProvider mInstance;

    public boolean checkErrorCodeFromCommonUtility(Activity activity, NetworkCustomError networkCustomError) {
        return false;
    }

    public void getAJRCSTOrderIssuesData(CJROrderedCart cJROrderedCart) {
    }

    public Class<?> getAJRInstallationDetails() {
        return null;
    }

    public Class<?> getAuthActivityClassFromMap() {
        return null;
    }

    public Fragment getNewAddressFragment(FragmentActivity fragmentActivity, Bundle bundle) {
        return null;
    }

    public String getOELeadUrl() {
        return null;
    }

    private FastagImplProvider() {
    }

    public static void init() {
        if (mInstance == null) {
            FastagImplProvider fastagImplProvider = new FastagImplProvider();
            mInstance = fastagImplProvider;
            if (a.f13558a == null) {
                a aVar = new a();
                a.f13558a = aVar;
                aVar.f13559b = fastagImplProvider;
            }
        }
    }

    public Context getApplicationContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public String getStringFromGTM(String str) {
        c.a();
        return c.a(str, (String) null);
    }

    public int getIntFromGTM(String str) {
        c.a();
        return c.a(str, 0);
    }

    public boolean getBooleanFromGTM(String str, boolean z) {
        c.a();
        return c.a(str, z);
    }

    public List<Long> getCSTAutomaticFlowVerticals() {
        c.a();
        return c.D();
    }

    public Class<?> getAuthActivityClass() {
        return AJRAuthActivity.class;
    }

    public Class<?> getPassbookActivityClass() {
        l lVar = l.f50355a;
        return null;
    }

    public Class<?> getAJRCSTOrderIssuesClass() {
        try {
            return Class.forName("net.one97.paytm.cst.activity.AJRCSTOrderIssues");
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public void checkDeepLinking(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public String deeplinkSchemaName() {
        return net.one97.paytm.payments.d.a.a();
    }

    public Class<?> getAJRCoupons() {
        l lVar = l.f50355a;
        return l.a();
    }

    public Map<String, String> getHeader(Context context) {
        return t.e(context);
    }

    public String getSSOToken(Context context) {
        return t.b(context);
    }

    public String getUploadDocuemntUrl() {
        c.a();
        return c.a("fastagUploadDocURL", (String) null);
    }

    public String getAddressUrl() {
        c.a();
        return c.a("addressesV2", (String) null);
    }

    public String getUtilityProdDetailsURL() {
        c.a();
        return c.a("utilityProductDetails", (String) null);
    }

    public String getCartVerify() {
        c.a();
        return c.a("cartVerify", (String) null);
    }

    public String getKYCProfileSaveURL() {
        c.a();
        return c.a("kyc_save_profile_info", (String) null);
    }

    public boolean isMinKycDone(FasTagKYCActivity fasTagKYCActivity) {
        l lVar = l.f50355a;
        return l.a((Activity) fasTagKYCActivity);
    }

    public void sendCustomGTMEventForOrderCancel(Activity activity, Map<String, Object> map) {
        net.one97.paytm.j.a.b((Context) activity, map);
    }

    public Class<?> getAJRCancelItemAcitivityClass() {
        l lVar = l.f50355a;
        return null;
    }

    public Class<?> getAJRCSTOrderIssues() {
        try {
            return Class.forName("net.one97.paytm.cst.activity.AJRCSTOrderIssues");
        } catch (ClassNotFoundException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public Class<?> getAJRWebViewActivity() {
        return AJRWebViewActivity.class;
    }

    public Class<?> getReturnReplaceActivity() {
        l lVar = l.f50355a;
        return null;
    }

    public Class<?> getDetailedItemTrackingClass() {
        l lVar = l.f50355a;
        return null;
    }

    public Class<?> getOrderDetailsActivity() {
        l lVar = l.f50355a;
        return null;
    }

    public Class<?> getAJRSellarRating() {
        return AJRSellarRating.class;
    }

    public void launchDeepLinkedPage(Activity activity, String str, CJRHomePageItem cJRHomePageItem) {
        h.a aVar = h.f50349a;
        h.a.a(activity, str, (Bundle) null);
    }

    public List<String> getCSTAutomaticFlowIssueIds() {
        c.a();
        return c.G();
    }

    public String getSellerRatingUrl() {
        c.a();
        return c.a("sellerRating", (String) null);
    }

    public Class<?> getAJRMainActivity() {
        l lVar = l.f50355a;
        return l.c();
    }

    public CJRRechargeCart getCartResponse(net.one97.paytm.fastag.model.CJRRechargeCart cJRRechargeCart) {
        return (CJRRechargeCart) convertObject(cJRRechargeCart, CJRRechargeCart.class);
    }

    public String getString(String str) {
        l lVar = l.f50355a;
        return l.a(str);
    }

    public void handlePlayServicesError() {
        l lVar = l.f50355a;
    }

    public void sendCustomEventsWithScreenName(String str, String str2, FragmentActivity fragmentActivity) {
        l lVar = l.f50355a;
        l.a(str, str2, fragmentActivity);
    }

    public void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, FragmentActivity fragmentActivity) {
        l lVar = l.f50355a;
        l.a(str, str2, str3, str4, fragmentActivity);
    }

    public Context getMallApplicationContext() {
        l lVar = l.f50355a;
        return l.b();
    }

    public String getLeadAPIOnAppLaunchUrl() {
        c.a();
        return c.a("leadAPIOnAppLaunch", (String) null);
    }

    public Class<?> getAJREmbedWebView() {
        return AJREmbedWebView.class;
    }

    public String getPaytmCashMaxDigitUrl(Context context) {
        c.a();
        return c.a("max_digit_paytmcash", (String) null);
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Activity activity) {
        net.one97.paytm.j.a.b(str, map, (Context) activity);
    }

    public String getFormattedOrderDate(String str, String str2) {
        l lVar = l.f50355a;
        return l.a(str, str2);
    }

    public <T> T convertObject(Object obj, Class<T> cls) {
        f fVar = new f();
        return fVar.a(fVar.a(obj), cls);
    }

    public void startCSTOrderIssuesActivity(Context context, Bundle bundle, m mVar) {
        mVar.show();
        d.a(context, bundle, mVar);
    }

    public void signOut(Activity activity, boolean z) {
        net.one97.paytm.auth.b.b.a(activity, false);
    }
}
