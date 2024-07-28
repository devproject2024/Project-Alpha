package net.one97.paytm.deeplink;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.hometabs.HomeTabItem;
import net.one97.paytm.landingpage.hometabs.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.l;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final s f50367a = new s();

    private s() {
    }

    private static void b(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (DynamicModuleManager.getInstance().isInstalled("paytm_finance")) {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.setClassName(context, "net.one97.paytm.dynamic.module.transport.iocl.IoclInitActivity");
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.transport.iocl.IoclInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "paytm_finance");
        context.startActivity(intent2);
    }

    public static Class<?> a() {
        Class<?> cls = Class.forName("net.one97.paytm.cst.activity.AJRCSTOrderIssues");
        k.a((Object) cls, "Class.forName(CSTDeepLin…CSTOrderIssueCalssName())");
        return cls;
    }

    public static Class<PaySendActivityV2> b() {
        return PaySendActivityV2.class;
    }

    public static void a(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        k.c(context, "context");
        k.c(linearLayout, "tabContainer");
        k.c(onClickListener, "viewClickListener");
        a.a();
        HomeTabItem[] b2 = a.b();
        new HashMap();
        k.a((Object) b2, "homeTabItems");
        l.a((ViewGroup) linearLayout);
    }

    public static Class<AJRMainActivity> c() {
        return AJRMainActivity.class;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, "iocl-points", false) || p.a(deepLinkData.f50284b, "iocl-pointsv2", false)) {
            return true;
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50284b;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -117343587) {
                if (hashCode == 956301409 && str.equals("iocl-points")) {
                    b(context, deepLinkData);
                }
            } else if (str.equals("iocl-pointsv2")) {
                b(context, deepLinkData);
            }
        }
    }
}
