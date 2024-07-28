package io.reactivex.rxjava3.e.k;

import io.reactivex.rxjava3.d.r;
import java.util.HashMap;
import java.util.Map;

public enum l implements r<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> r<Map<K, V>> asSupplier() {
        return INSTANCE;
    }

    public final Map<Object, Object> get() {
        return new HashMap();
    }
}
