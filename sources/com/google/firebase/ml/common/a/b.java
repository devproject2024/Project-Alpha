package com.google.firebase.ml.common.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends c>, com.google.firebase.c.a<? extends Object<? extends c>>> f39060a = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Class<? extends c> f39061a;

        /* renamed from: b  reason: collision with root package name */
        final com.google.firebase.c.a<? extends Object<? extends c>> f39062b;

        public <TRemote extends c> a(Class<TRemote> cls, com.google.firebase.c.a<? extends Object<TRemote>> aVar) {
            this.f39061a = cls;
            this.f39062b = aVar;
        }
    }

    public b(Set<a> set) {
        for (a next : set) {
            this.f39060a.put(next.f39061a, next.f39062b);
        }
    }
}
