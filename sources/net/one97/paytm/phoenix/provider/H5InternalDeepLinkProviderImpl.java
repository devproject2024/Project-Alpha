package net.one97.paytm.phoenix.provider;

import android.content.Context;
import android.os.Bundle;
import kotlin.g.b.k;
import net.one97.paytm.deeplink.h;

public final class H5InternalDeepLinkProviderImpl implements PhoenixDeepLinkHandlerProvider {
    public final boolean handleDeeplink(Context context, String str) {
        k.c(context, "context");
        h.a aVar = h.f50349a;
        return h.a.a(context, str, (Bundle) null);
    }
}
