package net.one97.paytm.phoenix.provider;

import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;

final class PhoenixGenerateShortLinkProviderImpl$generateShortLink$generateShortUrl$1 extends l implements m<String, Integer, x> {
    final /* synthetic */ PhoenixGenerateShortLinkProviderCallback $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoenixGenerateShortLinkProviderImpl$generateShortLink$generateShortUrl$1(PhoenixGenerateShortLinkProviderCallback phoenixGenerateShortLinkProviderCallback) {
        super(2);
        this.$callback = phoenixGenerateShortLinkProviderCallback;
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, ((Number) obj2).intValue());
        return x.f47997a;
    }

    public final void invoke(String str, int i2) {
        k.c(str, "url");
        this.$callback.onResult(str);
    }
}
