package com.google.firebase.abt;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f37947a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37948b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f37949c = null;

    public c(a aVar, String str) {
        this.f37947a = aVar;
        this.f37948b = str;
    }

    public final void a(List<Map<String, String>> list) throws a {
        a();
        if (list != null) {
            b(d(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }

    private void b(List<b> list) throws a {
        if (list.isEmpty()) {
            a();
            a((Collection<a.c>) b());
            return;
        }
        HashSet hashSet = new HashSet();
        for (b bVar : list) {
            hashSet.add(bVar.f37941b);
        }
        List<a.c> b2 = b();
        HashSet hashSet2 = new HashSet();
        for (a.c cVar : b2) {
            hashSet2.add(cVar.f37961b);
        }
        a((Collection<a.c>) a(b2, hashSet));
        c(b(list, hashSet2));
    }

    private static ArrayList<a.c> a(List<a.c> list, Set<String> set) {
        ArrayList<a.c> arrayList = new ArrayList<>();
        for (a.c next : list) {
            if (!set.contains(next.f37961b)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static ArrayList<b> b(List<b> list, Set<String> set) {
        ArrayList<b> arrayList = new ArrayList<>();
        for (b next : list) {
            if (!set.contains(next.f37941b)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private void c(List<b> list) {
        ArrayDeque arrayDeque = new ArrayDeque(b());
        if (this.f37949c == null) {
            this.f37949c = Integer.valueOf(this.f37947a.b(this.f37948b));
        }
        int intValue = this.f37949c.intValue();
        for (b next : list) {
            while (arrayDeque.size() >= intValue) {
                a(((a.c) arrayDeque.pollFirst()).f37961b);
            }
            String str = this.f37948b;
            a.c cVar = new a.c();
            cVar.f37960a = str;
            cVar.m = next.f37944e.getTime();
            cVar.f37961b = next.f37941b;
            cVar.f37962c = next.f37942c;
            cVar.f37963d = TextUtils.isEmpty(next.f37943d) ? null : next.f37943d;
            cVar.f37964e = next.f37945f;
            cVar.j = next.f37946g;
            this.f37947a.a(cVar);
            arrayDeque.offer(cVar);
        }
    }

    private void a(Collection<a.c> collection) {
        for (a.c cVar : collection) {
            a(cVar.f37961b);
        }
    }

    private static List<b> d(List<Map<String, String>> list) throws a {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> a2 : list) {
            arrayList.add(b.a(a2));
        }
        return arrayList;
    }

    private void a() throws a {
        if (this.f37947a == null) {
            throw new a("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    private void a(String str) {
        this.f37947a.a(str);
    }

    private List<a.c> b() {
        return this.f37947a.a(this.f37948b, "");
    }
}
