package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class m {

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final boolean f38113a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<?> f38114b;

        /* synthetic */ b(Class cls, boolean z, byte b2) {
            this(cls, z);
        }

        private b(Class<?> cls, boolean z) {
            this.f38114b = cls;
            this.f38113a = z;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (!bVar.f38114b.equals(this.f38114b) || bVar.f38113a != this.f38113a) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return ((this.f38114b.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f38113a).hashCode();
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final b<?> f38110a;

        /* renamed from: b  reason: collision with root package name */
        final Set<a> f38111b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        final Set<a> f38112c = new HashSet();

        a(b<?> bVar) {
            this.f38110a = bVar;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f38112c.isEmpty();
        }
    }

    private static Set<a> a(Set<a> set) {
        HashSet hashSet = new HashSet();
        for (a next : set) {
            if (next.a()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    static void a(List<b<?>> list) {
        Set<a> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<b<?>> it2 = list.iterator();
        while (true) {
            int i2 = 0;
            if (it2.hasNext()) {
                b next = it2.next();
                a aVar = new a(next);
                Iterator<Class<? super T>> it3 = next.f38084a.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Class next2 = it3.next();
                        b bVar = new b(next2, !next.c(), (byte) 0);
                        if (!hashMap.containsKey(bVar)) {
                            hashMap.put(bVar, new HashSet());
                        }
                        Set set2 = (Set) hashMap.get(bVar);
                        if (set2.isEmpty() || bVar.f38113a) {
                            set2.add(aVar);
                        } else {
                            throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{next2}));
                        }
                    }
                }
            } else {
                for (Set<a> it4 : hashMap.values()) {
                    for (a aVar2 : it4) {
                        for (n next3 : aVar2.f38110a.f38085b) {
                            if (next3.b() && (set = (Set) hashMap.get(new b(next3.f38115a, next3.a(), (byte) 0))) != null) {
                                for (a aVar3 : set) {
                                    aVar2.f38111b.add(aVar3);
                                    aVar3.f38112c.add(aVar2);
                                }
                            }
                        }
                    }
                }
                HashSet<a> hashSet = new HashSet<>();
                for (Set addAll : hashMap.values()) {
                    hashSet.addAll(addAll);
                }
                Set<a> a2 = a((Set<a>) hashSet);
                while (!a2.isEmpty()) {
                    a next4 = a2.iterator().next();
                    a2.remove(next4);
                    i2++;
                    for (a next5 : next4.f38111b) {
                        next5.f38112c.remove(next4);
                        if (next5.a()) {
                            a2.add(next5);
                        }
                    }
                }
                if (i2 != list.size()) {
                    ArrayList arrayList = new ArrayList();
                    for (a aVar4 : hashSet) {
                        if (!aVar4.a() && !aVar4.f38111b.isEmpty()) {
                            arrayList.add(aVar4.f38110a);
                        }
                    }
                    throw new o(arrayList);
                }
                return;
            }
        }
    }
}
