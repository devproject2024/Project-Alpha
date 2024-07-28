package net.one97.paytm.dynamic.module.movie.deeplink;

import android.content.Intent;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.g.b.l;
import net.one97.paytm.deeplink.DeepLinkData;

final class AmparkDeeplinkConfig$getDeeplinkConfig$1 extends l implements q<Boolean, DeepLinkData, HashMap<String, String>, Intent> {
    final /* synthetic */ AmparkDeeplinkConfig this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmparkDeeplinkConfig$getDeeplinkConfig$1(AmparkDeeplinkConfig amparkDeeplinkConfig) {
        super(3);
        this.this$0 = amparkDeeplinkConfig;
    }

    public final /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (DeepLinkData) obj2, (HashMap<String, String>) (HashMap) obj3);
    }

    public final Intent invoke(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        return this.this$0.deeplinkFunctions.apOrderSummaryPage(z, deepLinkData, hashMap);
    }
}
