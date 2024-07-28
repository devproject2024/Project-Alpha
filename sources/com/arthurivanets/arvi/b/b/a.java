package com.arthurivanets.arvi.b.b;

import java.util.HashSet;
import java.util.Set;

public final class a {
    public static <T> Set<T> a(T... tArr) {
        c.a((Object) tArr);
        HashSet hashSet = new HashSet(tArr.length);
        for (T add : tArr) {
            hashSet.add(add);
        }
        return hashSet;
    }
}
