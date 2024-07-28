package net.one97.paytm.nearbuy_h5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55773a = new a();

    public static String a() {
        return "release";
    }

    private a() {
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        Intent intent = new Intent();
        if (DynamicModuleManager.getInstance().isInstalled("paytm_finance")) {
            intent.setClassName(context, "net.one97.paytm.nearbuy_h5.NearbuyInitActivity");
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.addFlags(603979776);
        } else {
            intent.setClass(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.nearbuy_h5.NearbuyInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "paytm_finance");
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        Bundle bundle = new Bundle();
        bundle.putBoolean("canPullDown", false);
        bundle.putBoolean("pullRefresh", false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLEBAR, false);
        bundle.putBoolean(H5Param.LONG_SHOW_TITLE_VERTICAL_DIVIDER, false);
        bundle.putString("paytmChangeBackButtonColor", "#000000");
        bundle.putString(H5Param.LONG_SHOW_PROGRESS, H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO);
        bundle.putString(H5Param.LONG_BACK_BEHAVIOR, H5Param.DEFAULT_LONG_BACK_BEHAVIOR);
        u.a().a("nearbuy", "978832f7059a81e7c443187e5967fa4d9ac0b7fc", str, bundle, "", context);
    }

    public static void a(CJRRechargePayment cJRRechargePayment, Intent intent) {
        k.c(cJRRechargePayment, "rechargePayment");
        k.c(intent, "intent");
        ab.a(cJRRechargePayment, intent);
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (TextUtils.isEmpty(deepLinkData.f50284b) || TextUtils.isEmpty(deepLinkData.f50283a)) {
            return false;
        }
        String str = deepLinkData.f50284b;
        if (str == null) {
            k.a();
        }
        return p.a("nearbuy", str, true);
    }
}
