package net.one97.paytm.acceptPayment.viewModel;

import java.util.Map;
import kotlin.g.b.k;

public final class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f52205a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f52206b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return k.a((Object) this.f52205a, (Object) mVar.f52205a) && k.a((Object) this.f52206b, (Object) mVar.f52206b);
    }

    public final int hashCode() {
        Class<?> cls = this.f52205a;
        int i2 = 0;
        int hashCode = (cls != null ? cls.hashCode() : 0) * 31;
        Map<String, String> map = this.f52206b;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "StartActivity(clazz=" + this.f52205a + ", data=" + this.f52206b + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Class<?> cls, Map<String, String> map) {
        super((byte) 0);
        k.d(cls, "clazz");
        this.f52205a = cls;
        this.f52206b = map;
    }
}
