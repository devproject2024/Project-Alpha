package net.one97.paytm.p2mNewDesign.db.b;

import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f51231a;

    /* renamed from: b  reason: collision with root package name */
    public String f51232b;

    /* renamed from: c  reason: collision with root package name */
    public String f51233c;

    /* renamed from: d  reason: collision with root package name */
    public long f51234d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if ((this.f51231a == aVar.f51231a) && k.a((Object) this.f51232b, (Object) aVar.f51232b) && k.a((Object) this.f51233c, (Object) aVar.f51233c)) {
                    if (this.f51234d == aVar.f51234d) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.f51231a;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.f51232b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f51233c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        long j2 = this.f51234d;
        return ((hashCode + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public a(long j, String str, String str2, long j2) {
        k.c(str, "instrumentType");
        k.c(str2, "instrumentDetail");
        this.f51231a = j;
        this.f51232b = str;
        this.f51233c = str2;
        this.f51234d = j2;
    }

    public /* synthetic */ a(String str, String str2, long j) {
        this(0, str, str2, j);
    }

    public final String toString() {
        return "LastUsedInstrument(rowId=" + this.f51231a + ", instrumentType='" + this.f51232b + "', instrumentDetail='" + this.f51233c + "', lastUsedTime=" + this.f51234d + ')';
    }
}
