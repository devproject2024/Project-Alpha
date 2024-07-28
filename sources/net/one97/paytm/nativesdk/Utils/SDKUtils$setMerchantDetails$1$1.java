package net.one97.paytm.nativesdk.Utils;

import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.MerchantBL;

final class SDKUtils$setMerchantDetails$1$1 extends l implements b<String, x> {
    public static final SDKUtils$setMerchantDetails$1$1 INSTANCE = new SDKUtils$setMerchantDetails$1$1();

    SDKUtils$setMerchantDetails$1$1() {
        super(1);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f47997a;
    }

    public final void invoke(String str) {
        k.c(str, "it");
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        merchantInstance.setMerchantLogoUrl(str);
    }
}
