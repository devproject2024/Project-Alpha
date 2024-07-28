package net.one97.paytm.p2mNewDesign.db.b;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51235a;

    /* renamed from: b  reason: collision with root package name */
    public String f51236b;

    /* renamed from: c  reason: collision with root package name */
    public String f51237c;

    /* renamed from: d  reason: collision with root package name */
    public String f51238d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51239e;

    /* renamed from: f  reason: collision with root package name */
    public long f51240f;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if ((this.f51235a == bVar.f51235a) && k.a((Object) this.f51236b, (Object) bVar.f51236b) && k.a((Object) this.f51237c, (Object) bVar.f51237c) && k.a((Object) this.f51238d, (Object) bVar.f51238d)) {
                    if (this.f51239e == bVar.f51239e) {
                        if (this.f51240f == bVar.f51240f) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.f51235a;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.f51236b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f51237c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f51238d;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        int i4 = (hashCode2 + i3) * 31;
        boolean z = this.f51239e;
        if (z) {
            z = true;
        }
        long j2 = this.f51240f;
        return ((i4 + (z ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public b(long j, String str, String str2, String str3, boolean z, long j2) {
        k.c(str, "userId");
        k.c(str2, "mId");
        k.c(str3, "json");
        this.f51235a = j;
        this.f51236b = str;
        this.f51237c = str2;
        this.f51238d = str3;
        this.f51239e = z;
        this.f51240f = j2;
    }

    public /* synthetic */ b(String str, String str2, String str3, long j) {
        this(0, str, str2, str3, false, j);
    }

    public final String toString() {
        return "MappingTable(rowId=" + this.f51235a + ", userId='" + this.f51236b + "', mId='" + this.f51237c + "', json='" + this.f51238d + "', paymentStatus=" + this.f51239e + ", lastUpdated=" + this.f51240f + ')';
    }
}
