package com.google.gsonhtcfix.b;

import com.google.gsonhtcfix.b;
import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class d implements z, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final d f39738a = new d();

    /* renamed from: b  reason: collision with root package name */
    public double f39739b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    public int f39740c = 136;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39741d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39742e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f39743f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<b> f39744g = Collections.emptyList();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public final <T> y<T> a(f fVar, a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        final boolean a2 = a((Class<?>) rawType, true);
        final boolean a3 = a((Class<?>) rawType, false);
        if (!a2 && !a3) {
            return null;
        }
        final f fVar2 = fVar;
        final a<T> aVar2 = aVar;
        return new y<T>() {

            /* renamed from: f  reason: collision with root package name */
            private y<T> f39750f;

            public final T a(com.google.gsonhtcfix.d.a aVar) throws IOException {
                if (!a3) {
                    return a().a(aVar);
                }
                aVar.o();
                return null;
            }

            public final void a(c cVar, T t) throws IOException {
                if (a2) {
                    cVar.e();
                } else {
                    a().a(cVar, t);
                }
            }

            private y<T> a() {
                y<T> yVar = this.f39750f;
                if (yVar != null) {
                    return yVar;
                }
                y<T> a2 = fVar2.a((z) d.this, aVar2);
                this.f39750f = a2;
                return a2;
            }
        };
    }

    public final boolean a(Class<?> cls, boolean z) {
        if (this.f39739b != -1.0d && !a((com.google.gsonhtcfix.a.c) cls.getAnnotation(com.google.gsonhtcfix.a.c.class), (com.google.gsonhtcfix.a.d) cls.getAnnotation(com.google.gsonhtcfix.a.d.class))) {
            return true;
        }
        if ((!this.f39741d && b(cls)) || a(cls)) {
            return true;
        }
        for (b b2 : z ? this.f39743f : this.f39744g) {
            if (b2.b()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls)) {
            return cls.isAnonymousClass() || cls.isLocalClass();
        }
        return false;
    }

    public static boolean b(Class<?> cls) {
        return cls.isMemberClass() && !c(cls);
    }

    private static boolean c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final boolean a(com.google.gsonhtcfix.a.c cVar, com.google.gsonhtcfix.a.d dVar) {
        return a(cVar) && a(dVar);
    }

    private boolean a(com.google.gsonhtcfix.a.c cVar) {
        return cVar == null || cVar.a() <= this.f39739b;
    }

    private boolean a(com.google.gsonhtcfix.a.d dVar) {
        return dVar == null || dVar.a() > this.f39739b;
    }
}
