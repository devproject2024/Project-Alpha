package net.one97.paytm.acceptPayment.viewModel;

import net.one97.paytm.acceptPayment.model.Result;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Result f52203a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof k) && kotlin.g.b.k.a((Object) this.f52203a, (Object) ((k) obj).f52203a);
        }
        return true;
    }

    public final int hashCode() {
        Result result = this.f52203a;
        if (result != null) {
            return result.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "ShowForceUpdateDialog(forceUpdateResponse=" + this.f52203a + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(Result result) {
        super((byte) 0);
        kotlin.g.b.k.d(result, "forceUpdateResponse");
        this.f52203a = result;
    }
}
