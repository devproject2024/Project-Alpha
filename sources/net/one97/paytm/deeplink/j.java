package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, String> f50352a = new HashMap<String, String>() {
        {
            put("199289", "net.one97.paytm.eduforms.predictor.activities.EduPredictorOrderSummaryActivity");
            put("164035", "net.one97.paytm.eduforms.predictor.activities.EduPredictorOrderSummaryActivity");
        }
    };

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.contains("catalog.paytm.com/v1/mobile/getproductlist/46006") || str.contains("catalog.paytm.com/v1/mobile/getproductlist/46007");
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        Intent intent = new Intent();
        if (DynamicModuleManager.getInstance().isInstalled("paytm_finance")) {
            intent.setClassName(context, "net.one97.paytm.dynamic.module.eduforms.activity.EduformsInitActivity");
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.addFlags(603979776);
        } else {
            intent.setClass(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.eduforms.activity.EduformsInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "paytm_finance");
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "net.one97.paytm.eduforms.activities.EduformOrderSummaryActivity");
        return intent;
    }

    public static Intent b(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "net.one97.paytm.eduforms.predictor.activities.EduPredictorOrderSummaryActivity");
        return intent;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        if (TextUtils.isEmpty(deepLinkData.f50284b)) {
            return false;
        }
        if ("edu-forms".equalsIgnoreCase(deepLinkData.f50284b) || "edu-predictor".equalsIgnoreCase(deepLinkData.f50284b) || "edu-coaching".equalsIgnoreCase(deepLinkData.f50284b) || "edu-explore".equalsIgnoreCase(deepLinkData.f50284b) || "education-forms".equalsIgnoreCase(deepLinkData.f50284b) || "edu-insurance".equalsIgnoreCase(deepLinkData.f50284b) || "edu-deals".equalsIgnoreCase(deepLinkData.f50284b) || "edu-open-h5".equalsIgnoreCase(deepLinkData.f50284b)) {
            return true;
        }
        return false;
    }

    public static void a(Context context, String str) {
        new CJRHomePageItem().setUrl(ag.a(context.getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent();
        intent.setClass(context, AJRMainActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra("Reset_fast_farward", true);
        context.startActivity(intent);
        Intent intent2 = new Intent();
        intent2.setClassName(context, "net.one97.paytm.dynamic.module.eduforms.activity.EduformsInitActivity");
        intent2.putExtra("H5_URL", str);
        context.startActivity(intent2);
    }
}
