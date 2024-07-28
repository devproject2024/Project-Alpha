package net.one97.paytm.dynamic.module.cashback;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.gsonhtcfix.f;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import net.one97.paytm.AJRWebViewActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.c;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.vipcashback.CashbackDeeplinkItem;
import net.one97.paytm.common.entity.vipcashback.VIPCashBackOffer;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.r;
import net.one97.paytm.vipcashback.c.a;
import net.one97.paytm.vipcashback.c.b;

public class CashbackJarvisHelper implements b {
    private static CashbackJarvisHelper mInstance;

    public HashMap<String, String> getAppCommonHeaders() {
        return null;
    }

    public String getApplicationId() {
        return "net.one97.paytm";
    }

    public String getBuildType() {
        return "release";
    }

    public String get_EXTRA_INTENT_IS_FROM_MESSAGE_TO_HOME_key() {
        return CJRConstants.EXTRA_INTENT_IS_FROM_MESSAGE_TO_HOME;
    }

    public void openPostTxnView(Context context, VIPCashBackOffer vIPCashBackOffer) {
    }

    private CashbackJarvisHelper() {
    }

    public static void init() {
        if (mInstance == null) {
            mInstance = new CashbackJarvisHelper();
        }
        CashbackJarvisHelper cashbackJarvisHelper = mInstance;
        if (a.f20707a == null) {
            a aVar = new a("paytm");
            a.f20707a = aVar;
            aVar.f20708b = cashbackJarvisHelper;
        }
    }

    public Context getApplicationContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public DrawerLayout getDrawerLayout(Activity activity) {
        if (activity instanceof AJRMainActivity) {
            return ((AJRMainActivity) activity).f52708d;
        }
        return null;
    }

    public void openLandingActivity(Activity activity) {
        Intent intent = new Intent(activity, AJRMainActivity.class);
        intent.setFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    public String getLandingActivityClassName() {
        return AJRMainActivity.class.getName();
    }

    public ContextWrapper getBaseContext(Context context) {
        return e.a(context);
    }

    public boolean checkDeepLinking(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
        return true;
    }

    public void loadPage(Context context, String str, IJRDataModel iJRDataModel) {
        j.a(context, ((CJRHomePageItem) iJRDataModel).getURLType(), iJRDataModel, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null, (c) null);
    }

    public void sendNewCustomGTMEventsWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public String getStringFromGTM(String str) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a(str, (String) null);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public boolean getBooleanFromGTM(String str, boolean z) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public int getIntFromGTM(String str) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, 0);
    }

    public void showNetworkDialog(com.paytm.network.a aVar, Context context) {
        r.a(aVar, context);
    }

    public void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        r.a(activity, exc, str, (Bundle) null);
    }

    public CashbackDeeplinkItem getCashbackDeeplinkItem(IJRDataModel iJRDataModel) {
        if (iJRDataModel == null) {
            return null;
        }
        f fVar = new f();
        return (CashbackDeeplinkItem) fVar.a(fVar.a((Object) iJRDataModel, (Type) CJRHomePageItem.class), CashbackDeeplinkItem.class);
    }

    public String getSSOToken() {
        return com.paytm.utility.a.q(getApplicationContext());
    }

    public boolean isMerchantEligibleForCashback() {
        String J = com.paytm.utility.b.J(getApplicationContext());
        String K = com.paytm.utility.b.K(getApplicationContext());
        return !TextUtils.isEmpty(J) && !TextUtils.isEmpty(K) && "SD_MERCHANT".equals(J) && "merchant".equalsIgnoreCase(K);
    }

    public Uri getProfilePic(Context context) {
        if (TextUtils.isEmpty(com.paytm.utility.b.al(context))) {
            return null;
        }
        return Uri.parse(com.paytm.utility.b.al(context));
    }

    public void openWebViewActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, AJRWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("title", str2);
        context.startActivity(intent);
    }

    public String getUserId(Context context) {
        return com.paytm.utility.a.a(context);
    }

    public void generateBrandedLink(Context context, String str, HashMap<String, String> hashMap, m<? super String, ? super Integer, ?> mVar, int i2) {
        net.one97.paytm.utils.m mVar2 = net.one97.paytm.utils.m.f69757a;
        net.one97.paytm.utils.m.a(context, str, hashMap, mVar, i2);
    }

    public void showSessionTimeOutAlert(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2) {
        r.a(activity, str, bundle, z, z2);
    }
}
