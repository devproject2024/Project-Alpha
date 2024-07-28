package com.alipay.iap.android.webapp.sdk.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapUtils {
    public static <T> Map<String, T> sortMapByKey(Map<String, T> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new MapKeyComparator());
        treeMap.putAll(map);
        return treeMap;
    }

    static class MapKeyComparator implements Comparator<String> {
        MapKeyComparator() {
        }

        public int compare(String str, String str2) {
            if (str != null && str2 != null) {
                return str.compareTo(str2);
            }
            if (str == null && str2 == null) {
                return 0;
            }
            return str == null ? 1 : -1;
        }
    }
}
