package net.one97.a;

import android.content.Context;
import android.net.Uri;
import com.paytmmall.clpartifact.utils.CLPConstants;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.deeplink.DeepLinkData;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f48002a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f48003b;

    static {
        String name = a.class.getName();
        k.a((Object) name, "DeepLinkUtil::class.java.name");
        f48003b = name;
    }

    private a() {
    }

    public static DeepLinkData a(Context context, String str, DeepLinkData deepLinkData) {
        k.c(context, "context");
        k.c(str, "deepLinkUrl");
        k.c(deepLinkData, "deepLinkData");
        Uri parse = Uri.parse(p.a(str, '$', '&'));
        String str2 = null;
        if (parse == null) {
            return null;
        }
        deepLinkData.f50289g = parse;
        deepLinkData.f50283a = str;
        String str3 = "";
        if (parse != null) {
            String host = parse.getHost();
            CharSequence charSequence = host;
            if (!(charSequence == null || charSequence.length() == 0)) {
                str3 = "homepage_secondary";
                if (!p.a(host, str3, true) && !p.a(host, CLPConstants.GA_CHANNEL_NAME, true)) {
                    str3 = p.a(host, "deals", true) ? "deals" : host;
                }
            }
        }
        if (str3 == null) {
            return null;
        }
        if (parse != null) {
            str2 = parse.getQueryParameter("featuretype");
        }
        deepLinkData.f50284b = str3;
        deepLinkData.f50288f = str2;
        return deepLinkData;
    }
}
