package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class i extends v.d.c {

    /* renamed from: a  reason: collision with root package name */
    private final int f38464a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38465b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38466c;

    /* renamed from: d  reason: collision with root package name */
    private final long f38467d;

    /* renamed from: e  reason: collision with root package name */
    private final long f38468e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f38469f;

    /* renamed from: g  reason: collision with root package name */
    private final int f38470g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38471h;

    /* renamed from: i  reason: collision with root package name */
    private final String f38472i;

    /* synthetic */ i(int i2, String str, int i3, long j, long j2, boolean z, int i4, String str2, String str3, byte b2) {
        this(i2, str, i3, j, j2, z, i4, str2, str3);
    }

    private i(int i2, String str, int i3, long j, long j2, boolean z, int i4, String str2, String str3) {
        this.f38464a = i2;
        this.f38465b = str;
        this.f38466c = i3;
        this.f38467d = j;
        this.f38468e = j2;
        this.f38469f = z;
        this.f38470g = i4;
        this.f38471h = str2;
        this.f38472i = str3;
    }

    public final int a() {
        return this.f38464a;
    }

    public final String b() {
        return this.f38465b;
    }

    public final int c() {
        return this.f38466c;
    }

    public final long d() {
        return this.f38467d;
    }

    public final long e() {
        return this.f38468e;
    }

    public final boolean f() {
        return this.f38469f;
    }

    public final int g() {
        return this.f38470g;
    }

    public final String h() {
        return this.f38471h;
    }

    public final String i() {
        return this.f38472i;
    }

    public final String toString() {
        return "Device{arch=" + this.f38464a + ", model=" + this.f38465b + ", cores=" + this.f38466c + ", ram=" + this.f38467d + ", diskSpace=" + this.f38468e + ", simulator=" + this.f38469f + ", state=" + this.f38470g + ", manufacturer=" + this.f38471h + ", modelClass=" + this.f38472i + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.c) {
            v.d.c cVar = (v.d.c) obj;
            return this.f38464a == cVar.a() && this.f38465b.equals(cVar.b()) && this.f38466c == cVar.c() && this.f38467d == cVar.d() && this.f38468e == cVar.e() && this.f38469f == cVar.f() && this.f38470g == cVar.g() && this.f38471h.equals(cVar.h()) && this.f38472i.equals(cVar.i());
        }
    }

    public final int hashCode() {
        long j = this.f38467d;
        long j2 = this.f38468e;
        return ((((((((((((((((this.f38464a ^ 1000003) * 1000003) ^ this.f38465b.hashCode()) * 1000003) ^ this.f38466c) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.f38469f ? 1231 : 1237)) * 1000003) ^ this.f38470g) * 1000003) ^ this.f38471h.hashCode()) * 1000003) ^ this.f38472i.hashCode();
    }

    static final class a extends v.d.c.a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f38473a;

        /* renamed from: b  reason: collision with root package name */
        private String f38474b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f38475c;

        /* renamed from: d  reason: collision with root package name */
        private Long f38476d;

        /* renamed from: e  reason: collision with root package name */
        private Long f38477e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f38478f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f38479g;

        /* renamed from: h  reason: collision with root package name */
        private String f38480h;

        /* renamed from: i  reason: collision with root package name */
        private String f38481i;

        a() {
        }

        public final v.d.c.a a(int i2) {
            this.f38473a = Integer.valueOf(i2);
            return this;
        }

        public final v.d.c.a a(String str) {
            if (str != null) {
                this.f38474b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public final v.d.c.a b(int i2) {
            this.f38475c = Integer.valueOf(i2);
            return this;
        }

        public final v.d.c.a a(long j) {
            this.f38476d = Long.valueOf(j);
            return this;
        }

        public final v.d.c.a b(long j) {
            this.f38477e = Long.valueOf(j);
            return this;
        }

        public final v.d.c.a a(boolean z) {
            this.f38478f = Boolean.valueOf(z);
            return this;
        }

        public final v.d.c.a c(int i2) {
            this.f38479g = Integer.valueOf(i2);
            return this;
        }

        public final v.d.c.a b(String str) {
            if (str != null) {
                this.f38480h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public final v.d.c.a c(String str) {
            if (str != null) {
                this.f38481i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public final v.d.c a() {
            String str = "";
            if (this.f38473a == null) {
                str = str + " arch";
            }
            if (this.f38474b == null) {
                str = str + " model";
            }
            if (this.f38475c == null) {
                str = str + " cores";
            }
            if (this.f38476d == null) {
                str = str + " ram";
            }
            if (this.f38477e == null) {
                str = str + " diskSpace";
            }
            if (this.f38478f == null) {
                str = str + " simulator";
            }
            if (this.f38479g == null) {
                str = str + " state";
            }
            if (this.f38480h == null) {
                str = str + " manufacturer";
            }
            if (this.f38481i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new i(this.f38473a.intValue(), this.f38474b, this.f38475c.intValue(), this.f38476d.longValue(), this.f38477e.longValue(), this.f38478f.booleanValue(), this.f38479g.intValue(), this.f38480h, this.f38481i, (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
