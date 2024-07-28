package com.google.android.datatransport.runtime.scheduling.a;

import com.alipay.mobile.nebula.filecache.FileCache;
import com.google.android.datatransport.runtime.scheduling.a.d;
import com.paytm.business.merchantprofile.common.utility.AppConstants;

final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private final long f7811b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7812c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7813d;

    /* renamed from: e  reason: collision with root package name */
    private final long f7814e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7815f;

    /* synthetic */ a(long j, int i2, int i3, long j2, int i4, byte b2) {
        this(j, i2, i3, j2, i4);
    }

    private a(long j, int i2, int i3, long j2, int i4) {
        this.f7811b = j;
        this.f7812c = i2;
        this.f7813d = i3;
        this.f7814e = j2;
        this.f7815f = i4;
    }

    /* access modifiers changed from: package-private */
    public final long a() {
        return this.f7811b;
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f7812c;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.f7813d;
    }

    /* access modifiers changed from: package-private */
    public final long d() {
        return this.f7814e;
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.f7815f;
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f7811b + ", loadBatchSize=" + this.f7812c + ", criticalSectionEnterTimeoutMs=" + this.f7813d + ", eventCleanUpAge=" + this.f7814e + ", maxBlobByteSizePerRow=" + this.f7815f + "}";
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f7811b == dVar.a() && this.f7812c == dVar.b() && this.f7813d == dVar.c() && this.f7814e == dVar.d() && this.f7815f == dVar.e();
        }
    }

    public final int hashCode() {
        long j = this.f7811b;
        long j2 = this.f7814e;
        return this.f7815f ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f7812c) * 1000003) ^ this.f7813d) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    /* renamed from: com.google.android.datatransport.runtime.scheduling.a.a$a  reason: collision with other inner class name */
    static final class C0116a extends d.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f7816a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f7817b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f7818c;

        /* renamed from: d  reason: collision with root package name */
        private Long f7819d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f7820e;

        C0116a() {
        }

        /* access modifiers changed from: package-private */
        public final d.a a() {
            this.f7816a = 10485760L;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final d.a b() {
            this.f7817b = 200;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final d.a c() {
            this.f7818c = Integer.valueOf(AppConstants.START_OTP_FLOW);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final d.a d() {
            this.f7819d = Long.valueOf(FileCache.EXPIRE_TIME);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final d.a e() {
            this.f7820e = 81920;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final d f() {
            String str = "";
            if (this.f7816a == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.f7817b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f7818c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f7819d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f7820e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f7816a.longValue(), this.f7817b.intValue(), this.f7818c.intValue(), this.f7819d.longValue(), this.f7820e.intValue(), (byte) 0);
            }
            throw new IllegalStateException("Missing required properties:".concat(String.valueOf(str)));
        }
    }
}
