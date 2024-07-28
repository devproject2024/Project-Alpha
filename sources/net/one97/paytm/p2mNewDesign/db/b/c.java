package net.one97.paytm.p2mNewDesign.db.b;

import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public long f51241a;

    /* renamed from: b  reason: collision with root package name */
    public long f51242b;

    /* renamed from: c  reason: collision with root package name */
    public String f51243c;

    /* renamed from: d  reason: collision with root package name */
    public int f51244d;

    /* renamed from: e  reason: collision with root package name */
    public String f51245e;

    /* renamed from: f  reason: collision with root package name */
    public long f51246f;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (this.f51241a == cVar.f51241a) {
                    if ((this.f51242b == cVar.f51242b) && k.a((Object) this.f51243c, (Object) cVar.f51243c)) {
                        if ((this.f51244d == cVar.f51244d) && k.a((Object) this.f51245e, (Object) cVar.f51245e)) {
                            if (this.f51246f == cVar.f51246f) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.f51241a;
        long j2 = this.f51242b;
        int i2 = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str = this.f51243c;
        int i3 = 0;
        int hashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.f51244d) * 31;
        String str2 = this.f51245e;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        long j3 = this.f51246f;
        return ((hashCode + i3) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    private c(long j, String str, int i2, String str2, long j2) {
        k.c(str, "instrumentType");
        k.c(str2, "instrumentDetail");
        this.f51241a = 0;
        this.f51242b = j;
        this.f51243c = str;
        this.f51244d = i2;
        this.f51245e = str2;
        this.f51246f = j2;
    }

    public /* synthetic */ c(long j, String str, int i2, String str2, long j2, byte b2) {
        this(j, str, i2, str2, j2);
    }

    public final String toString() {
        return "PaymentInstrumentCache(rowId=" + this.f51241a + ", mapId=" + this.f51242b + ", instrumentType='" + this.f51243c + "', instrumentPriority=" + this.f51244d + ", instrumentDetail='" + this.f51245e + "', lastUpdated=" + this.f51246f + ')';
    }
}
