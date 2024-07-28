package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.ej;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class du {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f11065a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f11066b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile du f11067c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile du f11068d;

    /* renamed from: e  reason: collision with root package name */
    private static final du f11069e = new du((byte) 0);

    /* renamed from: f  reason: collision with root package name */
    private final Map<a, ej.f<?, ?>> f11070f;

    public static du a() {
        du duVar = f11067c;
        if (duVar == null) {
            synchronized (du.class) {
                duVar = f11067c;
                if (duVar == null) {
                    duVar = f11069e;
                    f11067c = duVar;
                }
            }
        }
        return duVar;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f11071a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11072b;

        a(Object obj, int i2) {
            this.f11071a = obj;
            this.f11072b = i2;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f11071a) * 65535) + this.f11072b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f11071a == aVar.f11071a && this.f11072b == aVar.f11072b) {
                return true;
            }
            return false;
        }
    }

    public static du b() {
        Class<du> cls = du.class;
        du duVar = f11068d;
        if (duVar != null) {
            return duVar;
        }
        synchronized (cls) {
            du duVar2 = f11068d;
            if (duVar2 != null) {
                return duVar2;
            }
            du a2 = ei.a(cls);
            f11068d = a2;
            return a2;
        }
    }

    public final <ContainingType extends ft> ej.f<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return this.f11070f.get(new a(containingtype, i2));
    }

    du() {
        this.f11070f = new HashMap();
    }

    private du(byte b2) {
        this.f11070f = Collections.emptyMap();
    }
}
