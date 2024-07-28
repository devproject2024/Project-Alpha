package net.one97.paytm.phoenix.util;

import android.content.Context;
import java.util.LinkedHashSet;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.provider.PaytmH5AppAnalyticsProvider;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f59637a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static final LinkedHashSet<String> f59638b = new LinkedHashSet<>();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void a(String str, String str2, Context context, String str3) {
        k.c(str2, "appUniqueId");
        k.c(context, "context");
        k.c(str3, "appName");
        if (!kotlin.a.k.a(f59638b, str) && str != null) {
            f59638b.add(str);
            f b2 = net.one97.paytm.phoenix.core.c.f59399a.b();
            String name = PaytmH5AppAnalyticsProvider.class.getName();
            k.a((Object) name, "PaytmH5AppAnalyticsProvider::class.java.name");
            PaytmH5AppAnalyticsProvider paytmH5AppAnalyticsProvider = (PaytmH5AppAnalyticsProvider) b2.a(name);
            if (paytmH5AppAnalyticsProvider != null) {
                paytmH5AppAnalyticsProvider.pushDomainToHawkeye(str, str2, context, str3);
            }
        }
    }
}
