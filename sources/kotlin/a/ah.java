package kotlin.a;

import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;

public class ah extends ag {
    public static final <K, V> Map<K, V> a() {
        x xVar = x.INSTANCE;
        if (xVar != null) {
            return xVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <K, V> Map<K, V> a(o<? extends K, ? extends V>... oVarArr) {
        k.d(oVarArr, "pairs");
        if (oVarArr.length <= 0) {
            return ae.a();
        }
        Map<K, V> linkedHashMap = new LinkedHashMap<>(ae.a(oVarArr.length));
        k.d(oVarArr, "$this$toMap");
        k.d(linkedHashMap, "destination");
        ae.a(linkedHashMap, oVarArr);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> b(o<? extends K, ? extends V>... oVarArr) {
        k.d(oVarArr, "pairs");
        Map<K, V> linkedHashMap = new LinkedHashMap<>(ae.a(oVarArr.length));
        ae.a(linkedHashMap, oVarArr);
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> c(o<? extends K, ? extends V>... oVarArr) {
        k.d(oVarArr, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(ae.a(oVarArr.length));
        ae.a(hashMap, oVarArr);
        return hashMap;
    }

    public static final <K, V> V b(Map<K, ? extends V> map, K k) {
        k.d(map, "$this$getValue");
        return ae.a(map, k);
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, o<? extends K, ? extends V>[] oVarArr) {
        k.d(map, "$this$putAll");
        k.d(oVarArr, "pairs");
        for (o<? extends K, ? extends V> oVar : oVarArr) {
            map.put(oVar.component1(), oVar.component2());
        }
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Iterable<? extends o<? extends K, ? extends V>> iterable) {
        k.d(map, "$this$putAll");
        k.d(iterable, "pairs");
        for (o oVar : iterable) {
            map.put(oVar.component1(), oVar.component2());
        }
    }

    public static final <K, V> Map<K, V> a(Iterable<? extends o<? extends K, ? extends V>> iterable) {
        k.d(iterable, "$this$toMap");
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return ae.a();
        }
        if (size != 1) {
            return ae.a(iterable, new LinkedHashMap(ae.a(collection.size())));
        }
        return ae.a((o) ((List) iterable).get(0));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends o<? extends K, ? extends V>> iterable, M m) {
        k.d(iterable, "$this$toMap");
        k.d(m, "destination");
        ae.a(m, iterable);
        return m;
    }

    public static final <K, V> Map<K, V> a(Map<? extends K, ? extends V> map) {
        k.d(map, "$this$toMap");
        int size = map.size();
        if (size == 0) {
            return ae.a();
        }
        if (size != 1) {
            return ae.b(map);
        }
        k.d(map, "$this$toSingletonMap");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        k.b(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> b(Map<? extends K, ? extends V> map) {
        k.d(map, "$this$toMutableMap");
        return new LinkedHashMap<>(map);
    }

    public static final <K, V> Map<K, V> a(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        k.d(map, "$this$plus");
        k.d(map2, Item.CTA_URL_TYPE_MAP);
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }
}
