package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    final Set<Class<? super T>> f38084a;

    /* renamed from: b  reason: collision with root package name */
    final Set<n> f38085b;

    /* renamed from: c  reason: collision with root package name */
    final g<T> f38086c;

    /* renamed from: d  reason: collision with root package name */
    final Set<Class<?>> f38087d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38088e;

    /* renamed from: f  reason: collision with root package name */
    private final int f38089f;

    /* synthetic */ b(Set set, Set set2, int i2, int i3, g gVar, Set set3, byte b2) {
        this(set, set2, i2, i3, gVar, set3);
    }

    private b(Set<Class<? super T>> set, Set<n> set2, int i2, int i3, g<T> gVar, Set<Class<?>> set3) {
        this.f38084a = Collections.unmodifiableSet(set);
        this.f38085b = Collections.unmodifiableSet(set2);
        this.f38088e = i2;
        this.f38089f = i3;
        this.f38086c = gVar;
        this.f38087d = Collections.unmodifiableSet(set3);
    }

    public final boolean a() {
        return this.f38088e == 1;
    }

    public final boolean b() {
        return this.f38088e == 2;
    }

    public final boolean c() {
        return this.f38089f == 0;
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f38084a.toArray()) + ">{" + this.f38088e + ", type=" + this.f38089f + ", deps=" + Arrays.toString(this.f38085b.toArray()) + "}";
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls, new Class[0], (byte) 0);
    }

    @SafeVarargs
    private static <T> a<T> a(Class<T> cls, Class<? super T>... clsArr) {
        return new a<>(cls, clsArr, (byte) 0);
    }

    @SafeVarargs
    public static <T> b<T> a(T t, Class<T> cls, Class<? super T>... clsArr) {
        return a(cls, clsArr).a(c.a((Object) t)).a();
    }

    public static <T> a<T> b(Class<T> cls) {
        a<T> a2 = a(cls);
        a2.f38090a = 1;
        return a2;
    }

    public static <T> b<T> a(T t, Class<T> cls) {
        return b(cls).a(new d(t)).a();
    }

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        int f38090a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Class<? super T>> f38091b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<n> f38092c;

        /* renamed from: d  reason: collision with root package name */
        private int f38093d;

        /* renamed from: e  reason: collision with root package name */
        private g<T> f38094e;

        /* renamed from: f  reason: collision with root package name */
        private Set<Class<?>> f38095f;

        /* synthetic */ a(Class cls, Class[] clsArr, byte b2) {
            this(cls, clsArr);
        }

        @SafeVarargs
        private a(Class<T> cls, Class<? super T>... clsArr) {
            this.f38091b = new HashSet();
            this.f38092c = new HashSet();
            this.f38093d = 0;
            this.f38090a = 0;
            this.f38095f = new HashSet();
            v.a(cls, "Null interface");
            this.f38091b.add(cls);
            for (Class<? super T> a2 : clsArr) {
                v.a(a2, "Null interface");
            }
            Collections.addAll(this.f38091b, clsArr);
        }

        public final a<T> a(n nVar) {
            v.a(nVar, "Null dependency");
            a(nVar.f38115a);
            this.f38092c.add(nVar);
            return this;
        }

        public final a<T> a(int i2) {
            v.b(this.f38093d == 0, "Instantiation type has already been set.");
            this.f38093d = i2;
            return this;
        }

        private void a(Class<?> cls) {
            v.a(!this.f38091b.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public final a<T> a(g<T> gVar) {
            this.f38094e = (g) v.a(gVar, "Null factory");
            return this;
        }

        public final b<T> a() {
            v.b(this.f38094e != null, "Missing required property: factory.");
            return new b(new HashSet(this.f38091b), new HashSet(this.f38092c), this.f38093d, this.f38090a, this.f38094e, this.f38095f, (byte) 0);
        }
    }
}
