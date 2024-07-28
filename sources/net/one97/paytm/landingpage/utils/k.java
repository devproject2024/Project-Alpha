package net.one97.paytm.landingpage.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.j.c;
import net.one97.paytm.prime.e.a;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;
import net.one97.paytm.utils.v;

public class k implements a {
    public final String a(Context context) {
        return t.b(context);
    }

    public final void a(String str, String str2, Activity activity) {
        net.one97.paytm.j.a.b(str, str2, (Context) activity);
    }

    public final void b(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("deeplink", "paytmmp://contactus");
        d.a(context, bundle, (DeepLinkData) null);
    }

    public final String a() {
        c.a();
        return c.d();
    }

    public final void c(Context context) {
        l.a(context, true);
    }

    public final void a(Activity activity, Bundle bundle) {
        d.a(activity, bundle);
    }

    public final Context b() {
        return CJRJarvisApplication.getAppContext();
    }

    public final String a(String str) {
        c.a();
        return c.a(str, (String) null);
    }

    public final void a(Context context, String str) {
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final void a(Context context, String str, Map<String, String> map) {
        v.f69802a.a(context, str, map);
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7, str8);
    }
}
