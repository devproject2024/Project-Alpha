package c.a.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, List<l>> f5562a;

    /* renamed from: b  reason: collision with root package name */
    private static g f5563b;

    private g() {
        f5562a = new ConcurrentHashMap();
    }

    public static g a() {
        if (f5563b == null) {
            f5563b = new g();
        }
        return f5563b;
    }

    static void a(String str, l lVar) {
        if (f5562a.containsKey(str)) {
            List list = f5562a.get(str);
            list.add(lVar);
            f5562a.put(str, list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(lVar);
        f5562a.put(str, arrayList);
    }

    static boolean a(String str) {
        return f5562a.containsKey(str);
    }
}
