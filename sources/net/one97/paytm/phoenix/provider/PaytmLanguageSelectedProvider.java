package net.one97.paytm.phoenix.provider;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.h5.b;

public final class PaytmLanguageSelectedProvider implements PhoenixLanguageSelectedProvider {
    public final String[] getLanguageSelected(Context context) {
        k.c(context, "context");
        b bVar = b.f50536a;
        String[] a2 = b.a(context);
        new StringBuilder("PaytmSelectedlanguageProvider:languageCode:").append(a2);
        return a2;
    }
}
