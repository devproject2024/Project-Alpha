package net.one97.paytm.deeplink;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.cashback.posttxn.c;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.utility.e;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.r;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static a f50353a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f50354b = {EventsModuleManager.MODULE_NAME, "event_order_summary"};

    public interface a {
    }

    public static boolean a() {
        return false;
    }

    public static boolean b() {
        return false;
    }

    public static String c() {
        return "release";
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        if (DynamicModuleManager.getInstance().isInstalled("movie")) {
            Intent intent = new Intent();
            intent.setClassName(context, "net.one97.paytm.dynamic.module.movie.EventInitActivity");
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, CommonDynamicLoaderActivity.class);
        intent2.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
        intent2.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.movie.EventInitActivity");
        intent2.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "movie");
        if (context instanceof Application) {
            intent2.addFlags(268435456);
        }
        context.startActivity(intent2);
    }

    public static Intent a(Context context, String str, HashMap<String, String> hashMap) {
        Intent intent = new Intent();
        if (DynamicModuleManager.getInstance().isInstalled("movie")) {
            intent.setClassName(context, "net.one97.paytm.dynamic.module.movie.EventInitActivity");
            intent.putExtra("extra_url_type", EventsModuleManager.MODULE_NAME);
        } else {
            intent.setClass(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.movie.EventInitActivity");
            intent.putExtra("extra_url_type", EventsModuleManager.MODULE_NAME);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "movie");
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry next : hashMap.entrySet()) {
                intent.putExtra((String) next.getKey(), (String) next.getValue());
            }
        }
        intent.putExtra("RESULTANT_ACTIVITY_NAME", str);
        return intent;
    }

    public static String a(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel) {
        return r.a(context, str, str2, cJRSelectCityModel);
    }

    public static void a(Activity activity, Exception exc, String str, Bundle bundle, Boolean bool) {
        bool.booleanValue();
        r.a(activity, exc, str, bundle);
    }

    public static boolean a(Context context, Exception exc, String str) {
        return r.a(context, exc, str);
    }

    public static void a(Activity activity) {
        e eVar = e.f49603a;
        e.a(activity);
    }

    public static void a(String str, ViewGroup viewGroup, String str2, Context context) {
        if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("Payment")) {
            net.one97.paytm.cashback.posttxn.e a2 = e.a() ? c.a() : null;
            if (a2 != null && a2.a(net.one97.paytm.utils.b.a.EVENT_TICKETS.getId(), 0)) {
                viewGroup.setVisibility(0);
                viewGroup.removeAllViews();
                a2.a((AppCompatActivity) context);
                f.a aVar = new f.a();
                aVar.f49546b = str;
                a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) null);
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.google.firebase.crashlytics.c.a().a(str);
        }
    }

    public static void a(a aVar) {
        f50353a = aVar;
    }

    public static boolean a(DeepLinkData deepLinkData) {
        if (TextUtils.isEmpty(deepLinkData.f50284b)) {
            return false;
        }
        for (String str : f50354b) {
            String str2 = deepLinkData.f50283a;
            if (str.equalsIgnoreCase(deepLinkData.f50284b) || "https://paytm.com/event".equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }
}
