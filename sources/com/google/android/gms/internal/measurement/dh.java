package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.dv;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class dh {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f10569a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f10570b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile dh f10571c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile dh f10572d;

    /* renamed from: e  reason: collision with root package name */
    private static final dh f10573e = new dh((byte) 0);

    /* renamed from: f  reason: collision with root package name */
    private final Map<a, dv.e<?, ?>> f10574f;

    public static dh a() {
        dh dhVar = f10571c;
        if (dhVar == null) {
            synchronized (dh.class) {
                dhVar = f10571c;
                if (dhVar == null) {
                    dhVar = f10573e;
                    f10571c = dhVar;
                }
            }
        }
        return dhVar;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f10575a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10576b;

        a(Object obj, int i2) {
            this.f10575a = obj;
            this.f10576b = i2;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f10575a) * 65535) + this.f10576b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f10575a == aVar.f10575a && this.f10576b == aVar.f10576b) {
                return true;
            }
            return false;
        }
    }

    public static dh b() {
        Class<dh> cls = dh.class;
        dh dhVar = f10572d;
        if (dhVar != null) {
            return dhVar;
        }
        synchronized (cls) {
            dh dhVar2 = f10572d;
            if (dhVar2 != null) {
                return dhVar2;
            }
            dh a2 = dt.a(cls);
            f10572d = a2;
            return a2;
        }
    }

    public final <ContainingType extends ff> dv.e<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return this.f10574f.get(new a(containingtype, i2));
    }

    dh() {
        this.f10574f = new HashMap();
    }

    private dh(byte b2) {
        this.f10574f = Collections.emptyMap();
    }
}
