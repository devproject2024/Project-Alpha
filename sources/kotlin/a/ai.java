package kotlin.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;

public class ai extends ah {
    public static final <K, V> List<o<K, V>> c(Map<? extends K, ? extends V> map) {
        k.d(map, "$this$toList");
        if (map.size() == 0) {
            return w.INSTANCE;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return w.INSTANCE;
        }
        Map.Entry next = it2.next();
        if (!it2.hasNext()) {
            return k.a(new o(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new o(next.getKey(), next.getValue()));
        do {
            Map.Entry next2 = it2.next();
            arrayList.add(new o(next2.getKey(), next2.getValue()));
        } while (it2.hasNext());
        return arrayList;
    }
}
