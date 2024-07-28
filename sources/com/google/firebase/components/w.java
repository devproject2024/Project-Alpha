package com.google.firebase.components;

import com.google.firebase.a.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class w extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Class<?>> f38126a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f38127b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f38128c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Class<?>> f38129d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Class<?>> f38130e;

    /* renamed from: f  reason: collision with root package name */
    private final e f38131f;

    w(b<?> bVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (n next : bVar.f38085b) {
            if (next.b()) {
                if (next.a()) {
                    hashSet3.add(next.f38115a);
                } else {
                    hashSet.add(next.f38115a);
                }
            } else if (next.a()) {
                hashSet4.add(next.f38115a);
            } else {
                hashSet2.add(next.f38115a);
            }
        }
        if (!bVar.f38087d.isEmpty()) {
            hashSet.add(c.class);
        }
        this.f38126a = Collections.unmodifiableSet(hashSet);
        this.f38127b = Collections.unmodifiableSet(hashSet2);
        this.f38128c = Collections.unmodifiableSet(hashSet3);
        this.f38129d = Collections.unmodifiableSet(hashSet4);
        this.f38130e = bVar.f38087d;
        this.f38131f = eVar;
    }

    public final <T> T a(Class<T> cls) {
        if (this.f38126a.contains(cls)) {
            T a2 = this.f38131f.a(cls);
            if (!cls.equals(c.class)) {
                return a2;
            }
            return new a(this.f38130e, (c) a2);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public final <T> com.google.firebase.c.a<T> c(Class<T> cls) {
        if (this.f38127b.contains(cls)) {
            return this.f38131f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public final <T> com.google.firebase.c.a<Set<T>> d(Class<T> cls) {
        if (this.f38129d.contains(cls)) {
            return this.f38131f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }

    public final <T> Set<T> b(Class<T> cls) {
        if (this.f38128c.contains(cls)) {
            return this.f38131f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<?>> f38132a;

        /* renamed from: b  reason: collision with root package name */
        private final c f38133b;

        public a(Set<Class<?>> set, c cVar) {
            this.f38132a = set;
            this.f38133b = cVar;
        }
    }
}
