package net.one97.paytm.kych5.a;

import com.alipay.mobile.h5container.api.H5Event;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f51043a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, a> f51044b = new HashMap<>();

    public interface a {
        void a(String str, b bVar);
    }

    public interface b {
        void a(Object obj);
    }

    private c() {
    }

    public static Object a(String str, String str2, b bVar) {
        k.c(str, "verticalName");
        k.c(str2, "key");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        a aVar = f51044b.get(str);
        if (aVar == null) {
            return null;
        }
        aVar.a(str2, bVar);
        return x.f47997a;
    }

    public static void a(String str, a aVar) {
        k.c(str, "verticalName");
        k.c(aVar, "verticalDataProvider");
        f51044b.put(str, aVar);
    }
}
