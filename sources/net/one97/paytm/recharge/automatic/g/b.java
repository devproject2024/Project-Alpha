package net.one97.paytm.recharge.automatic.g;

import android.net.Uri;
import kotlin.g.b.k;
import kotlin.m.p;

public final class b {
    public static final Uri.Builder a(Uri.Builder builder, String str, String str2) {
        k.c(builder, "$this$appendQueryParameterIfNotNull");
        k.c(str, "key");
        CharSequence charSequence = str2;
        if (charSequence == null || p.a(charSequence)) {
            return builder;
        }
        Uri.Builder appendQueryParameter = builder.appendQueryParameter(str, str2);
        k.a((Object) appendQueryParameter, "this.appendQueryParameter(key, value)");
        return appendQueryParameter;
    }
}
