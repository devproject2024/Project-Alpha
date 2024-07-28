package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import com.paytm.b.a.a;
import com.paytmmoney.lite.mod.util.PMConstants;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.upi.util.LogUtility;
import net.one97.paytm.upi.util.UpiConstants;

public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static final String f50312a = ag.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static ag f50313b;

    public static ag a() {
        ag agVar = f50313b;
        return agVar == null ? new ag() : agVar;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        String str = f50312a;
        LogUtility.e(str, "canHandleDeeplink getUrlType - " + deepLinkData.f50284b);
        return deepLinkData.f50284b.equals(DeepLinkConstant.PATTERN_PAYTM_MONEY) || deepLinkData.f50284b.equals("paytmmoney.com") || deepLinkData.f50284b.equals("www.paytmmoney.com");
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        if (DynamicModuleManager.getInstance().isInstalled("paytm_finance")) {
            LogUtility.e(f50312a, "openH5PaytmMoneyActivity deepLinkData - ".concat(String.valueOf(deepLinkData)));
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(context, "net.one97.paytm.dynamic.module.paytm_money.PmLiteControllerActivity");
            intent.putExtra("from_deep_link", true);
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.paytm_money.PmLiteControllerActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "paytm_finance");
        context.startActivity(intent2);
    }

    public static void a(Context context) {
        LogUtility.e(f50312a, "Clearing paytm-money shared preferences...");
        a a2 = net.one97.paytm.utils.ag.a(context.getApplicationContext());
        a2.a(PMConstants.USER_CONSENT_COMPLETED_KEY, true);
        a2.a(PMConstants.USER_UPLOADED_PAN_IMAGE_KEY, true);
        a2.a("username", true);
        a2.a(PMConstants.HAS_INVESTED_KEY, true);
        a2.a(PMConstants.IS_INVESTMENT_READY_KEY, true);
        a2.a(PMConstants.KYC_STATUS_KEY, true);
        a2.a(PMConstants.SLEEK_CARD_TIME_STAMP_KEY, true);
    }
}
