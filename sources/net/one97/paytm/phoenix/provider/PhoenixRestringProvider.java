package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.view.ContextThemeWrapper;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.locale.b.e;

public final class PhoenixRestringProvider implements PaytmH5RestringProvider {
    public final Context attachContextThemeWrapper(Context context) {
        k.c(context, "context");
        ContextThemeWrapper a2 = e.a(context);
        if (a2 != null) {
            return a2;
        }
        throw new u("null cannot be cast to non-null type android.content.Context");
    }
}
