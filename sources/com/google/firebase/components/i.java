package com.google.firebase.components;

import com.google.firebase.a.c;
import com.google.firebase.a.d;
import com.google.firebase.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Set<Object>> f38101a = l.b();

    /* renamed from: b  reason: collision with root package name */
    private final Map<b<?>, t<?>> f38102b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, t<?>> f38103c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, t<Set<?>>> f38104d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final q f38105e;

    public final /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    public final /* bridge */ /* synthetic */ Set b(Class cls) {
        return super.b(cls);
    }

    public i(Executor executor, Iterable<h> iterable, b<?>... bVarArr) {
        this.f38105e = new q(executor);
        ArrayList<b> arrayList = new ArrayList<>();
        arrayList.add(b.a(this.f38105e, q.class, d.class, c.class));
        for (h components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        for (int i2 = 0; i2 < 8; i2++) {
            b<?> bVar = bVarArr[i2];
            if (bVar != null) {
                arrayList.add(bVar);
            }
        }
        m.a((List<b<?>>) arrayList);
        for (b bVar2 : arrayList) {
            this.f38102b.put(bVar2, new t(new j(this, bVar2)));
        }
        a();
        b();
    }

    private void a() {
        for (Map.Entry next : this.f38102b.entrySet()) {
            b bVar = (b) next.getKey();
            if (bVar.c()) {
                t tVar = (t) next.getValue();
                for (Class<? super T> put : bVar.f38084a) {
                    this.f38103c.put(put, tVar);
                }
            }
        }
        for (b next2 : this.f38102b.keySet()) {
            Iterator<n> it2 = next2.f38085b.iterator();
            while (true) {
                if (it2.hasNext()) {
                    n next3 = it2.next();
                    if ((next3.f38116b == 1) && !this.f38103c.containsKey(next3.f38115a)) {
                        throw new u(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next2, next3.f38115a}));
                    }
                }
            }
        }
    }

    private void b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f38102b.entrySet()) {
            b bVar = (b) next.getKey();
            if (!bVar.c()) {
                t tVar = (t) next.getValue();
                for (Class next2 : bVar.f38084a) {
                    if (!hashMap.containsKey(next2)) {
                        hashMap.put(next2, new HashSet());
                    }
                    ((Set) hashMap.get(next2)).add(tVar);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.f38104d.put((Class) entry.getKey(), new t(new k((Set) entry.getValue())));
        }
    }

    static /* synthetic */ Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            hashSet.add(((t) it2.next()).a());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final <T> a<T> c(Class<T> cls) {
        v.a(cls, "Null interface requested.");
        return this.f38103c.get(cls);
    }

    public final <T> a<Set<T>> d(Class<T> cls) {
        t tVar = this.f38104d.get(cls);
        if (tVar != null) {
            return tVar;
        }
        return f38101a;
    }

    public final void a(boolean z) {
        for (Map.Entry next : this.f38102b.entrySet()) {
            b bVar = (b) next.getKey();
            t tVar = (t) next.getValue();
            if (bVar.a() || (bVar.b() && z)) {
                tVar.a();
            }
        }
        this.f38105e.a();
    }
}
