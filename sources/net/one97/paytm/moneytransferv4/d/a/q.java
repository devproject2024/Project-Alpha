package net.one97.paytm.moneytransferv4.d.a;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import java.util.Map;
import javax.a.a;
import kotlin.g.b.k;
import kotlin.u;

public final class q implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends ai>, a<ai>> f55399a;

    public q(Map<Class<? extends ai>, a<ai>> map) {
        k.c(map, "viewModels");
        this.f55399a = map;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        a aVar = this.f55399a.get(cls);
        T t = aVar != null ? (ai) aVar.get() : null;
        if (t != null) {
            return t;
        }
        throw new u("null cannot be cast to non-null type T");
    }
}
