package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.business.merchant_payments.deeplinkUtil.DeepLinkConstant;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.j.c;
import net.one97.paytm.m;

public final class d {
    public static void a(Context context, Bundle bundle, m mVar) {
        if (mVar != null) {
            mVar.dismiss();
        }
        a(context, bundle, (DeepLinkData) null);
    }

    public static void a(Context context, Bundle bundle, DeepLinkData deepLinkData) {
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.setClassName(context, "net.one97.paytm.CSTInitActivity");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        if (bundle != null) {
            intent2.putExtras(bundle);
        }
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.CSTInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        context.startActivity(intent2);
    }

    private static void c(Context context, Bundle bundle) {
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(context, "net.one97.paytm.CSTInitActivity");
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        if (bundle != null) {
            intent2.putExtras(bundle);
        }
        intent2.setFlags(268435456);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.CSTInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        context.startActivity(intent2);
    }

    public static void a(Context context, Bundle bundle) {
        bundle.putString("EXTRA_ACTION_ACTIVITY", "net.one97.paytm.cst.activity.AJRCSTOrderIssues");
        c(context, bundle);
    }

    public static void b(Context context, Bundle bundle) {
        c.a();
        if (c.af()) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("is_from_upi", true);
            bundle2.putBoolean("isH5FromHome", true);
            c(context, bundle2);
            return;
        }
        bundle.putString("EXTRA_ACTION_ACTIVITY", "net.one97.paytm.cst.cstWidgetization.view.AJRCSTWidgetLanding");
        c(context, bundle);
    }

    public static boolean a(DeepLinkData deepLinkData) {
        return deepLinkData.f50284b.equals("csttree") || deepLinkData.f50284b.equals("cst") || deepLinkData.f50284b.equals("cstadhaar") || deepLinkData.f50284b.equals(DeepLinkConstant.CIR_CONTACT_US) || deepLinkData.f50284b.equals("contactus");
    }
}
