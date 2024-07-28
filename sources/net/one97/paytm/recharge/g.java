package net.one97.paytm.recharge;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.h5.c;
import net.one97.paytm.recharge.di.f;
import net.one97.paytm.recharge.widgets.c.d;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f62773a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f62774b;

    private g() {
    }

    public static final void a(Context context) {
        k.c(context, "context");
        f.f62644a.a(new CJRJarvisCommonComponentImpl(context));
        b(context);
    }

    public static void b(Context context) {
        k.c(context, "context");
        if (!f62774b) {
            try {
                c cVar = c.f50543a;
                c.a("Donation", new c(context, "Donation"));
                c cVar2 = c.f50543a;
                c.a("Fastag", new c(context, "Fastag"));
                c cVar3 = c.f50543a;
                c.a("OTTSubscription", new c(context, "OTTSubscription"));
                c cVar4 = c.f50543a;
                c.a("H5Automatic", new c(context, "H5Automatic"));
                f62774b = true;
            } catch (Exception unused) {
                f62774b = false;
                d dVar = d.f64967a;
                d.a("RechargeAndUtilityDeepLinkHandler -> handleDeepLink -> URL_TYPE_DONATION -> H5DataProvider not initialized.");
            }
        }
    }
}
