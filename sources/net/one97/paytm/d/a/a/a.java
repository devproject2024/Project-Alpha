package net.one97.paytm.d.a.a;

import com.alipay.mobile.h5container.api.H5Event;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16781a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, C0252a> f16782b = new HashMap<>();

    /* renamed from: net.one97.paytm.d.a.a.a$a  reason: collision with other inner class name */
    public interface C0252a {
        void a(String str, b bVar);
    }

    public interface b {
        void a(Object obj);
    }

    private a() {
    }

    public static Object a(String str, String str2, b bVar) {
        k.c(str, "verticalName");
        k.c(str2, "key");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        C0252a aVar = f16782b.get(str);
        if (aVar == null) {
            return null;
        }
        aVar.a(str2, bVar);
        return x.f47997a;
    }

    public static void a(String str, C0252a aVar) {
        k.c(str, "verticalName");
        k.c(aVar, "verticalDataProvider");
        f16782b.put(str, aVar);
    }
}
