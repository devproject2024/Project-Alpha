package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.upi.util.UpiConstants;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f50333a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static a f50334b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final String f50335c = f50335c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f50336d = f50336d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f50337e = f50337e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f50338f = f50338f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f50339g = f50339g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f50340h = f50340h;

    public interface a {
        void clearCashbackPreferences();
    }

    public static final void b() {
        a aVar = f50334b;
        if (aVar != null) {
            aVar.clearCashbackPreferences();
        }
    }

    private e() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (f50335c.equals(deepLinkData.f50284b) || f50336d.equals(deepLinkData.f50284b) || f50337e.equals(deepLinkData.f50284b) || "referral".equals(deepLinkData.f50284b)) {
            return true;
        }
        if (!p.a(deepLinkData.f50284b, UpiConstants.URL_TYPE_CASH_WALLET, false) || !p.a(deepLinkData.f50288f, "vip", true)) {
            return false;
        }
        return true;
    }

    public static final boolean a() {
        try {
            if (!DynamicModuleManager.getInstance().isInstalled("ddbase")) {
                return false;
            }
            Class.forName("net.one97.paytm.dynamic.module.cashback.JarvisHelperInitializeFragment").newInstance();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void a(Context context, DeepLinkData deepLinkData, String str) {
        if (DynamicModuleManager.getInstance().isInstalled("ddbase")) {
            Intent intent = new Intent();
            intent.setClassName(context, "net.one97.paytm.dynamic.module.cashback.CashbackInitActivity");
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.putExtra("identifier", str);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        if (!(context instanceof Activity)) {
            intent2.setFlags(268435456);
        }
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.cashback.CashbackInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "ddbase");
        intent2.putExtra("identifier", str);
        context.startActivity(intent2);
    }

    public static final void a(a aVar) {
        k.c(aVar, "listener");
        f50334b = aVar;
    }

    public static boolean b(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        if (!p.a(f50335c, deepLinkData.f50284b, true) && !p.a(f50336d, deepLinkData.f50284b, true)) {
            return false;
        }
        return true;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50288f, "vip", true)) {
            a(context, deepLinkData, f50338f);
        } else if (p.a(deepLinkData.f50284b, f50335c, true)) {
            a(context, deepLinkData, f50339g);
        } else if (p.a(deepLinkData.f50284b, f50336d, true)) {
            a(context, deepLinkData, f50340h);
        } else if (p.a(deepLinkData.f50284b, "referral", true)) {
            a(context, deepLinkData, "referral");
        } else if (p.a(deepLinkData.f50284b, f50337e, true)) {
            a(context, deepLinkData, "businessapp");
        }
    }
}
