package com.google.android.play.core.d;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ag {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Map<String, String>> f37345a;

    /* synthetic */ ag(Map map) {
        this.f37345a = map;
    }

    public final Map<String, Set<String>> a(Collection<String> collection) {
        Set set;
        HashMap hashMap = new HashMap();
        for (String next : this.f37345a.keySet()) {
            if (!this.f37345a.containsKey(next)) {
                set = Collections.emptySet();
            } else {
                HashSet hashSet = new HashSet();
                for (Map.Entry entry : this.f37345a.get(next).entrySet()) {
                    if (collection.contains(entry.getKey())) {
                        hashSet.add((String) entry.getValue());
                    }
                }
                set = Collections.unmodifiableSet(hashSet);
            }
            hashMap.put(next, set);
        }
        return hashMap;
    }
}
