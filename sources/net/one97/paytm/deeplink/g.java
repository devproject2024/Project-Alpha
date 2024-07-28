package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.upi.util.UpiConstants;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f50348a = new g();

    public enum a {
        CCPassbookAuthActivity,
        AJRCreditCardLanding,
        AJRApplicationStatus
    }

    private g() {
    }

    private static void a(Context context, String str) {
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            Intent intent = new Intent();
            intent.setClassName(context, "net.one97.paytm.dynamic.module.creditcard.CreditCardInitActivity");
            intent.putExtra("EXTRA_ACTIVITY_FLAG", a.AJRApplicationStatus.name());
            if (str != null && "uat".equals(str)) {
                Bundle bundle = new Bundle();
                bundle.putString("formType", str);
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_ACTIVITY_FLAG", a.AJRApplicationStatus.name());
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.creditcard.CreditCardInitActivity");
        intent2.putExtra("isFromDeeplink", true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false);
        context.startActivity(intent2);
    }

    public static final void a(Intent intent, CJRRechargePayment cJRRechargePayment) {
        k.c(intent, "intent");
        k.c(cJRRechargePayment, "rechargePayment");
        ab.a(cJRRechargePayment, intent);
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        return p.a(deepLinkData.f50284b, "paytmfirstcard", false);
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50288f, "passbook", true)) {
            if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
                Intent intent = new Intent();
                intent.setClassName(context, "net.one97.paytm.dynamic.module.creditcard.CreditCardInitActivity");
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                intent.putExtra("EXTRA_ACTIVITY_FLAG", a.CCPassbookAuthActivity.name());
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
            intent2.putExtra("EXTRA_ACTIVITY_FLAG", a.CCPassbookAuthActivity.name());
            intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.creditcard.CreditCardInitActivity");
            intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
            intent2.putExtra("isFromDeeplink", true);
            if (!(context instanceof Activity)) {
                intent2.setFlags(268435456);
            }
            intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false);
            context.startActivity(intent2);
        } else if (p.a(deepLinkData.f50288f, "offers", true)) {
            if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
                Intent intent3 = new Intent();
                intent3.setClassName(context, "net.one97.paytm.dynamic.module.creditcard.CreditCardInitActivity");
                intent3.putExtra("EXTRA_ACTIVITY_FLAG", a.AJRCreditCardLanding.name());
                context.startActivity(intent3);
                return;
            }
            Intent intent4 = new Intent(context, CommonDynamicLoaderActivity.class);
            intent4.putExtra("EXTRA_ACTIVITY_FLAG", a.AJRCreditCardLanding.name());
            intent4.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.creditcard.CreditCardInitActivity");
            intent4.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
            intent4.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false);
            intent4.putExtra("isFromDeeplink", true);
            context.startActivity(intent4);
        } else if (p.a(deepLinkData.f50288f, "form", true)) {
            a(context, deepLinkData.f50288f);
        } else if (p.a(deepLinkData.f50288f, "uat", true)) {
            a(context, deepLinkData.f50288f);
        }
    }
}
