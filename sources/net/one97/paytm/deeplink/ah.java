package net.one97.paytm.deeplink;

import android.content.Context;
import kotlin.g.b.k;
import kotlin.m.p;

public final class ah {

    /* renamed from: a  reason: collision with root package name */
    public static final ah f50314a = new ah();

    private ah() {
    }

    public static boolean a(DeepLinkData deepLinkData) {
        k.c(deepLinkData, "deepLinkData");
        k.c(deepLinkData, "deepLinkData");
        if (p.a(deepLinkData.f50284b, "paytmupdate", false) || p.a(deepLinkData.f50284b, "notification", false)) {
            return true;
        }
        return false;
    }

    public static void a(Context context, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50288f;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == 3052376) {
                if (str.equals("chat")) {
                }
            } else if (hashCode == 3138974 && str.equals("feed")) {
                m mVar = m.f50358c;
                m.c(context, deepLinkData);
            }
        }
    }
}
