package net.one97.paytm.dynamic.module.movie.deeplink;

import android.content.Intent;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.g.b.l;
import net.one97.paytm.deeplink.DeepLinkData;

final class MoviesDeeplinkConfig$getDeeplinkConfig$13 extends l implements q<Boolean, DeepLinkData, HashMap<String, String>, Intent> {
    final /* synthetic */ MoviesDeeplinkConfig this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MoviesDeeplinkConfig$getDeeplinkConfig$13(MoviesDeeplinkConfig moviesDeeplinkConfig) {
        super(3);
        this.this$0 = moviesDeeplinkConfig;
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (DeepLinkData) obj2, (HashMap<String, String>) (HashMap) obj3);
    }

    public final Intent invoke(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        return this.this$0.deeplinkFunctions.movieOrderSummaryPage(z, deepLinkData, hashMap);
    }
}
