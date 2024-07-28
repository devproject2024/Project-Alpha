package net.one97.paytm.autoaddmoney.data.source.local;

import kotlin.g.a;
import kotlin.g.b.v;
import kotlin.g.b.y;
import kotlin.k.k;

final class d extends v {
    public static final k INSTANCE = new d();

    d() {
    }

    public final String getName() {
        return "javaClass";
    }

    public final kotlin.k.d getOwner() {
        return y.a(a.class, "addmoney_release");
    }

    public final String getSignature() {
        return "getJavaClass(Ljava/lang/Object;)Ljava/lang/Class;";
    }

    public final Object get(Object obj) {
        return a.a((c) obj);
    }
}
