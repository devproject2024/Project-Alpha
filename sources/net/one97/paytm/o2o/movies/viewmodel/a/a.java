package net.one97.paytm.o2o.movies.viewmodel.a;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import java.util.Map;
import kotlin.g.b.k;

public final class a implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends ai>, javax.a.a<ai>> f76009a;

    public a(Map<Class<? extends ai>, javax.a.a<ai>> map) {
        k.c(map, "viewModels");
        this.f76009a = map;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        javax.a.a aVar = this.f76009a.get(cls);
        if (aVar != null) {
            return (ai) aVar.get();
        }
        return null;
    }
}
