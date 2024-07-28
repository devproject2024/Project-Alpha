package net.one97.paytm.ups;

import kotlin.g.b.n;
import kotlin.g.b.y;
import kotlin.k.d;
import net.one97.paytm.ups.provider.UpsJarvisInterface;

final /* synthetic */ class UpsSdk$isLoggedIn$1 extends n {
    UpsSdk$isLoggedIn$1(UpsSdk upsSdk) {
        super(upsSdk);
    }

    public final String getName() {
        return "upsJarvisProvider";
    }

    public final d getOwner() {
        return y.b(UpsSdk.class);
    }

    public final String getSignature() {
        return "getUpsJarvisProvider()Lnet/one97/paytm/ups/provider/UpsJarvisInterface;";
    }

    public final Object get() {
        return UpsSdk.access$getUpsJarvisProvider$p((UpsSdk) this.receiver);
    }

    public final void set(Object obj) {
        UpsSdk.upsJarvisProvider = (UpsJarvisInterface) obj;
    }
}
