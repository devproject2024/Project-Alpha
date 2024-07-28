package net.one97.paytm.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.dynamicModule.CommonDynamicLoaderActivity;
import net.one97.paytm.dynamicModule.DynamicModuleManager;
import net.one97.paytm.upi.util.UpiConstants;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f50390a = {"movietickets", "moviepass", "movies-show-time", "movies_group", "movie-details", "movies-seat-layout", "freemovie", "upcoming-movies", "movie_order_summary", "postorder_fb", "imaxpage", "entertainment_one_pager"};

    public static void a(Context context, DeepLinkData deepLinkData) {
        Intent intent;
        if (DynamicModuleManager.getInstance().isInstalled("movie")) {
            intent = new Intent();
            intent.setClassName(context, "net.one97.paytm.dynamic.module.movie.MovieInitActivity");
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
        } else {
            intent = new Intent(context, CommonDynamicLoaderActivity.class);
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.movie.MovieInitActivity");
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_MODULE, "movie");
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static Intent a(Context context, String str, HashMap<String, String> hashMap) {
        Intent intent = new Intent();
        if (DynamicModuleManager.getInstance().isInstalled("movie")) {
            intent.setClassName(context, "net.one97.paytm.dynamic.module.movie.MovieInitActivity");
        } else {
            intent.setClass(context, CommonDynamicLoaderActivity.class);
            intent.putExtra(CommonDynamicLoaderActivity.EXTRA_INIT_ACTIVITY, "net.one97.paytm.dynamic.module.movie.MovieInitActivity");
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

    public static boolean a(DeepLinkData deepLinkData) {
        if (TextUtils.isEmpty(deepLinkData.f50284b)) {
            return false;
        }
        for (String str : f50390a) {
            String str2 = deepLinkData.f50283a;
            if (str.equalsIgnoreCase(deepLinkData.f50284b) || "https://paytm.com/movies".equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }
}
