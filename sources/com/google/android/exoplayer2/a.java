package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.z;

public abstract class a implements z {

    /* renamed from: a  reason: collision with root package name */
    protected final ah.b f31070a = new ah.b();

    protected interface b {
        void invokeListener(z.a aVar);
    }

    public final boolean a() {
        return k() == 3 && n() && l() == 0;
    }

    public final boolean b() {
        return e() != -1;
    }

    public final boolean c() {
        return d() != -1;
    }

    public final int d() {
        ah D = D();
        if (D.a()) {
            return -1;
        }
        return D.a(s(), r(), p());
    }

    public final int e() {
        ah D = D();
        if (D.a()) {
            return -1;
        }
        return D.b(s(), r(), p());
    }

    public final boolean f() {
        ah D = D();
        return !D.a() && D.a(s(), this.f31070a).f31132d;
    }

    public final long g() {
        ah D = D();
        if (D.a()) {
            return -9223372036854775807L;
        }
        return c.a(D.a(s(), this.f31070a).f31137i);
    }

    private int r() {
        int o = o();
        if (o == 1) {
            return 0;
        }
        return o;
    }

    /* renamed from: com.google.android.exoplayer2.a$a  reason: collision with other inner class name */
    protected static final class C0528a {

        /* renamed from: a  reason: collision with root package name */
        public final z.a f31071a;

        /* renamed from: b  reason: collision with root package name */
        boolean f31072b;

        public C0528a(z.a aVar) {
            this.f31071a = aVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f31071a.equals(((C0528a) obj).f31071a);
        }

        public final int hashCode() {
            return this.f31071a.hashCode();
        }
    }
}
