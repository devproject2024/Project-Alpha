package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.r;

public final class ak {

    /* renamed from: a  reason: collision with root package name */
    public static final ak f50322a = new ak();

    private ak() {
    }

    private static void b(Context context, DeepLinkData deepLinkData) {
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            Intent intent = new Intent();
            intent.setClassName(context, "net.one97.paytm.dynamic.module.wifi.WifiInitActivity");
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.wifi.WifiInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        context.startActivity(intent2);
    }

    public static Intent a(Context context) {
        k.c(context, "context");
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            Intent intent = new Intent();
            intent.setClassName(context, "net.one97.paytm.dynamic.module.wifi.WifiInitActivity");
            return intent;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.wifi.WifiInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        return intent2;
    }

    public static boolean a(Context context, NetworkCustomError networkCustomError, String str) {
        k.c(context, "inContext");
        k.c(networkCustomError, "error");
        k.c(str, "errorReportingAddress");
        return r.a(context, (Exception) networkCustomError, "error.utilities@paytm.com");
    }

    public static void a(Activity activity, NetworkCustomError networkCustomError) {
        k.c(activity, "activity");
        k.c(networkCustomError, "error");
        k.c((Object) null, "targetClassName");
        k.c((Object) null, "bundle");
        r.a(activity, (Exception) networkCustomError, (String) null, (Bundle) null);
    }

    public static void a(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        k.c(activity, "activity");
        k.c(str, "targetClassName");
        k.c(bundle, "bundle");
        k.c(networkCustomError, "error");
        r.a(activity, str, bundle);
    }

    public static void a(Context context, Intent intent) {
        k.c(context, "context");
        k.c(intent, "intent");
        intent.setClass(context, AJRMainActivity.class);
        context.startActivity(intent);
    }

    public static void a(Context context, Intent intent, CJRRechargePayment cJRRechargePayment) {
        k.c(context, "context");
        k.c(intent, "intent");
        k.c(cJRRechargePayment, "rechargePayment");
        ab.a(cJRRechargePayment, intent);
        intent.setClass(context, AJRRechargePaymentActivity.class);
        context.startActivity(intent);
    }

    public static String a(String str) {
        k.c(str, "url");
        String b2 = ab.b(str);
        k.a((Object) b2, "CJRRechargeUtilityConsta…reVerifyNativePGFlow(url)");
        return b2;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return p.a(deepLinkData.f50284b, "paytm_wifi", false);
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50288f, "launchwifi", true)) {
            b(context, deepLinkData);
        } else if (p.a(deepLinkData.f50288f, "connecthotspot", true)) {
            b(context, deepLinkData);
        } else if (p.a(deepLinkData.f50288f, "hotspotexpire", true)) {
            b(context, deepLinkData);
        }
    }
}
