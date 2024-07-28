package com.paytm.signal.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f43593a = new b();

    private b() {
    }

    public final Map<String, Object> a(Map<String, ? extends Object> map, Map<String, String> map2) {
        boolean z;
        k.c(map2, "customDimension");
        if (map == null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(map.keySet());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            k.a(obj, "keyList[i]");
            String str = (String) obj;
            if (p.a((CharSequence) str, (CharSequence) "dimension", true)) {
                hashMap.put(a(str, map2), map.get(str));
                z = true;
            } else {
                z = false;
            }
            Object obj2 = map.get(str);
            if (obj2 != null) {
                if (obj2 instanceof Map) {
                    hashMap.put(a(str, map2), a((Map<String, ? extends Object>) (Map) obj2, map2));
                    z = true;
                } else if (obj2 instanceof List) {
                    a((List<Object>) ab.c(obj2), map2);
                }
            }
            if (!z) {
                hashMap.put(str, map.get(str));
            }
        }
        return hashMap;
    }

    private final void a(List<Object> list, Map<String, String> map) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof Map) {
                list.set(i2, a((Map<String, ? extends Object>) (Map) list.get(i2), map));
            } else if (list.get(i2) instanceof List) {
                Object obj = list.get(i2);
                if (obj != null) {
                    a((List<Object>) ab.c(obj), map);
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
                }
            } else if ((list.get(i2) instanceof String) && i2 % 2 == 0) {
                Object obj2 = list.get(i2);
                if (obj2 == null) {
                    throw new u("null cannot be cast to non-null type kotlin.String");
                } else if (!p.a((CharSequence) (String) obj2, (CharSequence) "dimension", true)) {
                    continue;
                } else {
                    Object obj3 = list.get(i2);
                    if (obj3 != null) {
                        list.set(i2, a((String) obj3, map));
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.Set r1 = r4.keySet()
            java.util.Collection r1 = (java.util.Collection) r1
            r0.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r2)
            if (r2 == 0) goto L_0x000f
            java.lang.Object r0 = r4.get(r1)
            if (r0 == 0) goto L_0x0048
            java.lang.String r3 = "customKey"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.Object r3 = kotlin.a.ae.b(r4, r1)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0040
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.m.p.b(r3)
            java.lang.String r3 = r3.toString()
            return r3
        L_0x0040:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.CharSequence"
            r3.<init>(r4)
            throw r3
        L_0x0048:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.a.b.a(java.lang.String, java.util.Map):java.lang.String");
    }
}
