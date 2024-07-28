package net.one97.paytm.ups.network;

import kotlin.g.b.n;
import kotlin.g.b.y;
import kotlin.k.d;
import net.one97.paytm.ups.sdk.UpsSdkInterface;

final /* synthetic */ class UpsNetwork$getConsentNetworkCall$1 extends n {
    UpsNetwork$getConsentNetworkCall$1(UpsNetwork upsNetwork) {
        super(upsNetwork);
    }

    public final String getName() {
        return "upsSdkInterface";
    }

    public final d getOwner() {
        return y.b(UpsNetwork.class);
    }

    public final String getSignature() {
        return "getUpsSdkInterface()Lnet/one97/paytm/ups/sdk/UpsSdkInterface;";
    }

    public final Object get() {
        return UpsNetwork.access$getUpsSdkInterface$p((UpsNetwork) this.receiver);
    }

    public final void set(Object obj) {
        UpsNetwork.upsSdkInterface = (UpsSdkInterface) obj;
    }
}
