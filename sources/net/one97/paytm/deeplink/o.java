package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f50362a = o.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f50363b;

    static {
        ArrayList arrayList = new ArrayList(2);
        f50363b = arrayList;
        arrayList.add("gamepind");
        f50363b.add("gamepind_weex");
        f50363b.add("paytmFirstGamesX");
        f50363b.add("pfgPassbook");
    }

    private static boolean a(Object obj) {
        if (obj != null) {
            return (obj instanceof String) && ((String) obj).trim().length() == 0;
        }
        return true;
    }

    public static Intent a(Context context) {
        return new Intent(context, AJRMainActivity.class);
    }

    public static Context a() {
        return CJRJarvisApplication.getAppContext();
    }

    public static boolean a(Fragment fragment) {
        return fragment != null && "net.one97.paytm.games.fragment.pfg.PFGHomeFragment".equals(fragment.getClass().getCanonicalName());
    }

    public static boolean a(DeepLinkData deepLinkData) {
        if ("rooter".equalsIgnoreCase(deepLinkData.f50284b)) {
            return true;
        }
        c.a();
        if (!c.a("gamesDeeplinkEnabled", false) || deepLinkData == null || a((Object) deepLinkData.f50284b) || !f50363b.contains(deepLinkData.f50284b)) {
            return false;
        }
        return true;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        Uri uri = deepLinkData.f50289g;
        if (uri != null && !a((Object) uri.toString()) && !a((Object) deepLinkData.f50284b)) {
            Intent intent = new Intent();
            intent.putExtra("keyObject", deepLinkData);
            if (DynamicModuleManager.getInstance().isInstalled("feed")) {
                intent.setClassName(context, "net.one97.paytm.dynamic.module.games.GamesInitActivity");
            } else {
                intent.setClassName(context, CommonDynamicLoaderActivity.class.getCanonicalName());
                intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "feed");
                intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.games.GamesInitActivity");
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }
}
