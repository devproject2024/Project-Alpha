package com.google.firebase.crashlytics.a.e;

import com.google.firebase.crashlytics.a.e.v;

final class r extends v.d.C0634d.c {

    /* renamed from: a  reason: collision with root package name */
    private final Double f38548a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38549b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38550c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38551d;

    /* renamed from: e  reason: collision with root package name */
    private final long f38552e;

    /* renamed from: f  reason: collision with root package name */
    private final long f38553f;

    /* synthetic */ r(Double d2, int i2, boolean z, int i3, long j, long j2, byte b2) {
        this(d2, i2, z, i3, j, j2);
    }

    private r(Double d2, int i2, boolean z, int i3, long j, long j2) {
        this.f38548a = d2;
        this.f38549b = i2;
        this.f38550c = z;
        this.f38551d = i3;
        this.f38552e = j;
        this.f38553f = j2;
    }

    public final Double a() {
        return this.f38548a;
    }

    public final int b() {
        return this.f38549b;
    }

    public final boolean c() {
        return this.f38550c;
    }

    public final int d() {
        return this.f38551d;
    }

    public final long e() {
        return this.f38552e;
    }

    public final long f() {
        return this.f38553f;
    }

    public final String toString() {
        return "Device{batteryLevel=" + this.f38548a + ", batteryVelocity=" + this.f38549b + ", proximityOn=" + this.f38550c + ", orientation=" + this.f38551d + ", ramUsed=" + this.f38552e + ", diskUsed=" + this.f38553f + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.C0634d.c) {
            v.d.C0634d.c cVar = (v.d.C0634d.c) obj;
            Double d2 = this.f38548a;
            if (d2 != null ? d2.equals(cVar.a()) : cVar.a() == null) {
                return this.f38549b == cVar.b() && this.f38550c == cVar.c() && this.f38551d == cVar.d() && this.f38552e == cVar.e() && this.f38553f == cVar.f();
            }
        }
    }

    public final int hashCode() {
        Double d2 = this.f38548a;
        int hashCode = ((((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003) ^ this.f38549b) * 1000003;
        int i2 = this.f38550c ? 1231 : 1237;
        long j = this.f38552e;
        long j2 = this.f38553f;
        return ((((((hashCode ^ i2) * 1000003) ^ this.f38551d) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    static final class a extends v.d.C0634d.c.a {

        /* renamed from: a  reason: collision with root package name */
        private Double f38554a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f38555b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f38556c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f38557d;

        /* renamed from: e  reason: collision with root package name */
        private Long f38558e;

        /* renamed from: f  reason: collision with root package name */
        private Long f38559f;

        a() {
        }

        public final v.d.C0634d.c.a a(Double d2) {
            this.f38554a = d2;
            return this;
        }

        public final v.d.C0634d.c.a a(int i2) {
            this.f38555b = Integer.valueOf(i2);
            return this;
        }

        public final v.d.C0634d.c.a a(boolean z) {
            this.f38556c = Boolean.valueOf(z);
            return this;
        }

        public final v.d.C0634d.c.a b(int i2) {
            this.f38557d = Integer.valueOf(i2);
            return this;
        }

        public final v.d.C0634d.c.a a(long j) {
            this.f38558e = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.c.a b(long j) {
            this.f38559f = Long.valueOf(j);
            return this;
        }

        public final v.d.C0634d.c a() {
            String str = "";
            if (this.f38555b == null) {
                str = str + " batteryVelocity";
            }
            if (this.f38556c == null) {
                str = str + " proximityOn";
            }
            if (this.f38557d == null) {
                str = str + " orientation";
            }
            if (this.f38558e == null) {
                str = str + " ramUsed";
            }
            if (this.f38559f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new r(this.f38554a, this.f38555b.intValue(), this.f38556c.booleanValue(), this.f38557d.intValue(), this.f38558e.longValue(), this.f38559f.longValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
