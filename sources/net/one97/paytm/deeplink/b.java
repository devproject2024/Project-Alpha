package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.utility.e;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.r;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f50323a = {"amusement", "amusement", "ap_order_summary"};

    public static void a(Context context, DeepLinkData deepLinkData) {
        if (DynamicModuleManager.getInstance().isInstalled("movie")) {
            Intent intent = new Intent();
            intent.setClassName(context, "net.one97.paytm.dynamic.module.movie.AmParkInitActivity");
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.movie.AmParkInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "movie");
        context.startActivity(intent2);
    }

    public static Intent a(Context context, String str) {
        Intent intent = new Intent();
        if (DynamicModuleManager.getInstance().isInstalled("movie")) {
            intent.setClassName(context, "net.one97.paytm.dynamic.module.movie.AmParkInitActivity");
        } else {
            intent.setClass(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.movie.AmParkInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "movie");
        }
        intent.putExtra("RESULTANT_ACTIVITY_NAME", str);
        return intent;
    }

    public static String a(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel) {
        return r.a(context, str, str2, cJRSelectCityModel);
    }

    public static void a(Activity activity, String str, Bundle bundle) {
        r.a(activity, str, bundle);
    }

    public static void a(Activity activity) {
        e eVar = e.f49603a;
        e.a(activity);
    }

    public static boolean a(DeepLinkData deepLinkData) {
        if (TextUtils.isEmpty(deepLinkData.f50284b)) {
            return false;
        }
        for (String equalsIgnoreCase : f50323a) {
            if (equalsIgnoreCase.equalsIgnoreCase(deepLinkData.f50284b)) {
                return true;
            }
        }
        return false;
    }
}
