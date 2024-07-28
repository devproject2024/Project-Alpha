package com.paytm.finance.gold.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.finance.gold.activity.GoldInitActivity;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.DeepLinkData;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Application f13414a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f13415b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static b f13416c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f13417d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f13418e;

    private a() {
    }

    public final synchronized void a(Application application) {
        k.c(application, "application");
        q.d("init");
        if (!f13418e) {
            f13414a = application;
            f13417d = false;
            f13418e = true;
        }
    }

    public final synchronized void a(b bVar) {
        q.d("initListeners genericListener - {" + bVar + '}');
        f13416c = bVar;
    }

    public static void a(Activity activity, String str, DeepLinkData deepLinkData, Bundle bundle) {
        k.c(str, "url");
        q.d("openH5Container url - ".concat(String.valueOf(str)));
        q.d("openH5Container deepLinkUrl - ".concat(String.valueOf(deepLinkData)));
        q.d("openH5Container bundle - ".concat(String.valueOf(bundle)));
        b bVar = f13416c;
        if (bVar != null) {
            bVar.loadPage(activity, str, deepLinkData, bundle);
        }
    }

    public static void a(Activity activity, Intent intent) {
        k.c(activity, "activity");
        k.c(intent, "pageIntent");
        Intent intent2 = new Intent(activity, GoldInitActivity.class);
        intent2.putExtras(intent);
        activity.startActivity(intent2);
    }

    public static String a(Context context) {
        b bVar = f13416c;
        if (bVar != null) {
            return bVar.getBuildType(context);
        }
        return null;
    }
}
