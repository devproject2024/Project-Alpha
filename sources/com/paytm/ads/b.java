package com.paytm.ads;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f40876a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40877b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40878c;

    public b(String str, String str2, String str3) {
        this.f40876a = str;
        this.f40877b = str2;
        this.f40878c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f40876a, (Object) bVar.f40876a) && k.a((Object) this.f40877b, (Object) bVar.f40877b) && k.a((Object) this.f40878c, (Object) bVar.f40878c);
    }

    public final int hashCode() {
        String str = this.f40876a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f40877b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f40878c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "VerificationResources(vendorKey=" + this.f40876a + ", parameter=" + this.f40877b + ", url=" + this.f40878c + ")";
    }
}
