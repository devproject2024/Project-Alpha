package net.one97.paytm.acceptPayment.viewModel;

import kotlin.g.b.k;

public final class g extends n {

    /* renamed from: a  reason: collision with root package name */
    public final String f52199a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof g) && k.a((Object) this.f52199a, (Object) ((g) obj).f52199a);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f52199a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "HandleDeepLink(deeplink=" + this.f52199a + ")";
    }

    public g(String str) {
        k.d(str, "deeplink");
        this.f52199a = str;
    }
}
