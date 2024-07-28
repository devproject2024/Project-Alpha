package net.one97.paytm.phoenix.manager;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.f;

public final class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f59602a = new ConcurrentHashMap<>();

    public final void a(String str, Object obj) {
        k.c(str, "providerName");
        k.c(obj, "providerClass");
        this.f59602a.put(str, obj);
    }

    public final <T> T a(String str) {
        k.c(str, "providerName");
        return this.f59602a.get(str);
    }

    public final boolean b(String str) {
        k.c(str, "providerName");
        return this.f59602a.remove(str) != null;
    }
}
