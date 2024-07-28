package com.google.c;

import com.google.c.aa;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class r {

    /* renamed from: a  reason: collision with root package name */
    static final r f37904a = new r((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f37905b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f37906c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile r f37907d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<a, aa.f<?, ?>> f37908e;

    public static r a() {
        r rVar = f37907d;
        if (rVar == null) {
            synchronized (r.class) {
                rVar = f37907d;
                if (rVar == null) {
                    rVar = f37906c ? q.a() : f37904a;
                    f37907d = rVar;
                }
            }
        }
        return rVar;
    }

    public final <ContainingType extends at> aa.f<ContainingType, ?> a(ContainingType containingtype, int i2) {
        return this.f37908e.get(new a(containingtype, i2));
    }

    r() {
        this.f37908e = new HashMap();
    }

    private r(byte b2) {
        this.f37908e = Collections.emptyMap();
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f37909a;

        /* renamed from: b  reason: collision with root package name */
        private final int f37910b;

        a(Object obj, int i2) {
            this.f37909a = obj;
            this.f37910b = i2;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f37909a) * 65535) + this.f37910b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f37909a == aVar.f37909a && this.f37910b == aVar.f37910b) {
                return true;
            }
            return false;
        }
    }
}
