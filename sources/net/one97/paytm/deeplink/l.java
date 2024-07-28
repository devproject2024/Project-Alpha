package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.j.a;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upi.util.UpiConstants;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f50355a = new l();

    private l() {
    }

    private static void a(Context context, DeepLinkData deepLinkData, String str, String str2) {
        if (DynamicModuleManager.getInstance().isInstalled(str2)) {
            Intent intent = new Intent();
            intent.setClassName(context, str);
            intent.setFlags(268435456);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.setFlags(268435456);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, str);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, str2);
        context.startActivity(intent2);
    }

    public static Class<?> a() {
        return AJRCouponsActivityV8.class;
    }

    public static boolean a(Activity activity) {
        k.c(activity, "activity");
        return j.k(activity);
    }

    public static String a(String str) {
        k.c(str, "key");
        c.a();
        String a2 = c.a(str, (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().getString(key)");
        return a2;
    }

    public static void a(String str, String str2, FragmentActivity fragmentActivity) {
        k.c(str, "deliver_to_this_address_clicked");
        k.c(str2, "s");
        k.c(fragmentActivity, "activity");
        a.a(str, str2, (Context) fragmentActivity);
    }

    public static void a(String str, String str2, String str3, String str4, FragmentActivity fragmentActivity) {
        k.c(str, "dlvry_phone_entered");
        k.c(str2, "s");
        k.c(str3, AddEditGstinViewModelKt.BODY_PARAM_PINCODE);
        k.c(str4, "toString");
        k.c(fragmentActivity, "var3");
        a.a(str, str2, str3, str4, (Context) fragmentActivity);
    }

    public static Context b() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public static String a(String str, String str2) {
        k.c(str, "createdAt");
        k.c(str2, "rechargeOrderDateTimeFormat");
        String a2 = ab.a(str, str2);
        k.a((Object) a2, "CJRRechargeUtilityConsta…hargeOrderDateTimeFormat)");
        return a2;
    }

    public static Class<?> c() {
        return AJRMainActivity.class;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, "fastag_toll", false) || p.a(deepLinkData.f50284b, "fastag", true)) {
            return true;
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, "fastag_toll", true)) {
            a(context, deepLinkData, "net.one97.paytm.dynamic.module.fastag.FastagInitActivity", "paytm_finance");
        } else if (p.a(deepLinkData.f50284b, "fastag", true)) {
            a(context, deepLinkData, "net.one97.paytm.dynamic.module.fastag.FastagDDInitActivity", "ddbase");
        }
    }
}
