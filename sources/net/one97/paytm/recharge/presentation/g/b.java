package net.one97.paytm.recharge.presentation.g;

import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public NetworkCustomError f64953a;

    /* renamed from: b  reason: collision with root package name */
    public final T f64954b;

    /* renamed from: c  reason: collision with root package name */
    public final c f64955c;

    /* renamed from: d  reason: collision with root package name */
    private final String f64956d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f64953a, (Object) bVar.f64953a) && k.a((Object) this.f64954b, (Object) bVar.f64954b) && k.a((Object) this.f64955c, (Object) bVar.f64955c) && k.a((Object) this.f64956d, (Object) bVar.f64956d);
    }

    public final int hashCode() {
        NetworkCustomError networkCustomError = this.f64953a;
        int i2 = 0;
        int hashCode = (networkCustomError != null ? networkCustomError.hashCode() : 0) * 31;
        T t = this.f64954b;
        int hashCode2 = (hashCode + (t != null ? t.hashCode() : 0)) * 31;
        c cVar = this.f64955c;
        int hashCode3 = (hashCode2 + (cVar != null ? cVar.hashCode() : 0)) * 31;
        String str = this.f64956d;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Data(exception=" + this.f64953a + ", data=" + this.f64954b + ", state=" + this.f64955c + ", message=" + this.f64956d + ")";
    }

    public b(NetworkCustomError networkCustomError, T t, c cVar, String str) {
        k.c(cVar, "state");
        this.f64953a = networkCustomError;
        this.f64954b = t;
        this.f64955c = cVar;
        this.f64956d = str;
    }
}
