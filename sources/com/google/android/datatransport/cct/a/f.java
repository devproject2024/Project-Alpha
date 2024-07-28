package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.l;
import java.util.Arrays;

final class f extends l {

    /* renamed from: a  reason: collision with root package name */
    private final long f7674a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f7675b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7676c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f7677d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7678e;

    /* renamed from: f  reason: collision with root package name */
    private final long f7679f;

    /* renamed from: g  reason: collision with root package name */
    private final o f7680g;

    static final class a extends l.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f7681a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f7682b;

        /* renamed from: c  reason: collision with root package name */
        private Long f7683c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f7684d;

        /* renamed from: e  reason: collision with root package name */
        private String f7685e;

        /* renamed from: f  reason: collision with root package name */
        private Long f7686f;

        /* renamed from: g  reason: collision with root package name */
        private o f7687g;

        a() {
        }

        public final l.a a(long j) {
            this.f7681a = Long.valueOf(j);
            return this;
        }

        public final l.a b(long j) {
            this.f7683c = Long.valueOf(j);
            return this;
        }

        public final l.a c(long j) {
            this.f7686f = Long.valueOf(j);
            return this;
        }

        public final l.a a(Integer num) {
            this.f7682b = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final l.a a(byte[] bArr) {
            this.f7684d = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final l.a a(String str) {
            this.f7685e = str;
            return this;
        }

        public final l.a a(o oVar) {
            this.f7687g = oVar;
            return this;
        }

        public final l a() {
            String str = "";
            if (this.f7681a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f7683c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f7686f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f7681a.longValue(), this.f7682b, this.f7683c.longValue(), this.f7684d, this.f7685e, this.f7686f.longValue(), this.f7687g);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }

    /* synthetic */ f(long j, Integer num, long j2, byte[] bArr, String str, long j3, o oVar) {
        this.f7674a = j;
        this.f7675b = num;
        this.f7676c = j2;
        this.f7677d = bArr;
        this.f7678e = str;
        this.f7679f = j3;
        this.f7680g = oVar;
    }

    public final long a() {
        return this.f7674a;
    }

    public final Integer b() {
        return this.f7675b;
    }

    public final long c() {
        return this.f7676c;
    }

    public final byte[] d() {
        return this.f7677d;
    }

    public final String e() {
        return this.f7678e;
    }

    public final boolean equals(Object obj) {
        Integer num;
        String str;
        o oVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f7674a == lVar.a() && ((num = this.f7675b) != null ? num.equals(((f) lVar).f7675b) : ((f) lVar).f7675b == null) && this.f7676c == lVar.c()) {
                return Arrays.equals(this.f7677d, lVar instanceof f ? ((f) lVar).f7677d : lVar.d()) && ((str = this.f7678e) != null ? str.equals(((f) lVar).f7678e) : ((f) lVar).f7678e == null) && this.f7679f == lVar.f() && ((oVar = this.f7680g) != null ? oVar.equals(((f) lVar).f7680g) : ((f) lVar).f7680g == null);
            }
        }
    }

    public final long f() {
        return this.f7679f;
    }

    public final o g() {
        return this.f7680g;
    }

    public final int hashCode() {
        long j = this.f7674a;
        int i2 = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f7675b;
        int i3 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f7676c;
        int hashCode2 = (((((i2 ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f7677d)) * 1000003;
        String str = this.f7678e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f7679f;
        int i4 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        o oVar = this.f7680g;
        if (oVar != null) {
            i3 = oVar.hashCode();
        }
        return i4 ^ i3;
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f7674a + ", eventCode=" + this.f7675b + ", eventUptimeMs=" + this.f7676c + ", sourceExtension=" + Arrays.toString(this.f7677d) + ", sourceExtensionJsonProto3=" + this.f7678e + ", timezoneOffsetSeconds=" + this.f7679f + ", networkConnectionInfo=" + this.f7680g + "}";
    }
}
