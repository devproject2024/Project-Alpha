package net.one97.paytm.acceptPayment.viewModel;

import com.paytm.network.a;
import kotlin.g.b.k;

public final class j extends n {

    /* renamed from: a  reason: collision with root package name */
    public final a f52202a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof j) && k.a((Object) this.f52202a, (Object) ((j) obj).f52202a);
        }
        return true;
    }

    public final int hashCode() {
        a aVar = this.f52202a;
        if (aVar != null) {
            return aVar.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "NoNetwork(cjrCommonNetworkCall=" + this.f52202a + ")";
    }

    public j(a aVar) {
        this.f52202a = aVar;
    }
}
