package net.one97.paytm.dynamic.module.games;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.o;
import net.one97.paytm.games.c.a;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.t;

public class GamepindMapperJarvisImpl implements a {
    private static GamepindMapperJarvisImpl sInstance = new GamepindMapperJarvisImpl();

    public String getDeeplinkScheme() {
        return "paytmmp";
    }

    public boolean isStag() {
        return false;
    }

    public static GamepindMapperJarvisImpl getInstance() {
        return sInstance;
    }

    private GamepindMapperJarvisImpl() {
    }

    public Context getApplicationContext() {
        return o.a();
    }

    public Context wrapContext(Context context) {
        return e.a(context);
    }

    public Intent getSplashIntent(Context context) {
        return new Intent(context, AJRMainActivity.class);
    }

    public Intent getLoginScreenIntent(Context context) {
        return new Intent(context, AJRAuthActivity.class);
    }

    public String getSSOToken(Context context) {
        return t.b(context);
    }

    public String getGtmString(String str) {
        c.a();
        return c.a(str, (String) null);
    }

    public boolean getGtmBoolean(String str, boolean z) {
        c.a();
        return c.a(str, z);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Context context) {
        map.put("user_id", net.one97.paytm.j.a.b(context));
        net.one97.paytm.j.a.a(context, map, str);
    }

    public void sendPromotionClickImpression(Context context, int i2, String str, String str2, String str3, String str4) {
        net.one97.paytm.j.a.a(context, i2, str, str2, str3, str4);
    }

    public void sendPromotionImpression(Context context, int i2, String str, String str2, String str3, String str4) {
        net.one97.paytm.j.a.b(context, i2, str, str2, str3, str4);
    }

    public void checkDeepLinking(Activity activity, String str) {
        net.one97.paytm.payments.d.a.a(activity, str);
    }

    public RecyclerView.h getSpaceDecoration(int i2) {
        return new net.one97.paytm.prime.f.c(i2);
    }

    public Intent getAppHomeIntent(Context context) {
        return o.a(context);
    }

    public boolean enableBranch() {
        c.a();
        return c.a("enable_branch_sdk", false);
    }

    public void CJRLoadPage(Context context, String str, CJRHomePageItem cJRHomePageItem, int i2, String str2) {
        j.a(context, str, (IJRDataModel) cJRHomePageItem, (String) null, i2, (ArrayList<? extends CJRItem>) null, false, str2, (net.one97.paytm.c) null);
    }
}
