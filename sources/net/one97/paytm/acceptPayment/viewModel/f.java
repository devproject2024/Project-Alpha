package net.one97.paytm.acceptPayment.viewModel;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class f extends n {

    /* renamed from: a  reason: collision with root package name */
    public final String f52197a;

    /* renamed from: b  reason: collision with root package name */
    public final NetworkCustomError f52198b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return k.a((Object) this.f52197a, (Object) fVar.f52197a) && k.a((Object) this.f52198b, (Object) fVar.f52198b);
    }

    public final int hashCode() {
        String str = this.f52197a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        NetworkCustomError networkCustomError = this.f52198b;
        if (networkCustomError != null) {
            i2 = networkCustomError.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "HandleApiError(clazz=" + this.f52197a + ", error=" + this.f52198b + ")";
    }

    public f(String str, NetworkCustomError networkCustomError) {
        k.d(str, "clazz");
        this.f52197a = str;
        this.f52198b = networkCustomError;
    }
}
