package com.google.gson.internal;

import com.google.gson.a.d;
import com.google.gson.a.e;
import com.google.gson.b;
import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class Excluder implements x, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final Excluder f39473a = new Excluder();

    /* renamed from: b  reason: collision with root package name */
    public double f39474b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    public int f39475c = 136;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39476d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39477e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f39478f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<b> f39479g = Collections.emptyList();

    /* renamed from: a */
    public final Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final <T> w<T> create(f fVar, a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean a2 = a((Class<?>) rawType);
        final boolean z = a2 || a((Class<?>) rawType, true);
        final boolean z2 = a2 || a((Class<?>) rawType, false);
        if (!z && !z2) {
            return null;
        }
        final f fVar2 = fVar;
        final a<T> aVar2 = aVar;
        return new w<T>() {

            /* renamed from: f  reason: collision with root package name */
            private w<T> f39485f;

            public final T read(JsonReader jsonReader) throws IOException {
                if (!z2) {
                    return a().read(jsonReader);
                }
                jsonReader.skipValue();
                return null;
            }

            public final void write(JsonWriter jsonWriter, T t) throws IOException {
                if (z) {
                    jsonWriter.nullValue();
                } else {
                    a().write(jsonWriter, t);
                }
            }

            private w<T> a() {
                w<T> wVar = this.f39485f;
                if (wVar != null) {
                    return wVar;
                }
                w<T> a2 = fVar2.a((x) Excluder.this, aVar2);
                this.f39485f = a2;
                return a2;
            }
        };
    }

    public final boolean a(Class<?> cls) {
        if (this.f39474b != -1.0d && !a((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return true;
        }
        if ((this.f39476d || !c(cls)) && !b(cls)) {
            return false;
        }
        return true;
    }

    public final boolean a(Class<?> cls, boolean z) {
        for (b shouldSkipClass : z ? this.f39478f : this.f39479g) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls)) {
            return cls.isAnonymousClass() || cls.isLocalClass();
        }
        return false;
    }

    public static boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private static boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public final boolean a(d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(d dVar) {
        return dVar == null || dVar.a() <= this.f39474b;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.a() > this.f39474b;
    }
}
