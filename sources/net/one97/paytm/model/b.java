package net.one97.paytm.model;

import kotlin.g.b.k;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f14191a;

    /* renamed from: b  reason: collision with root package name */
    public String f14192b;

    /* renamed from: c  reason: collision with root package name */
    public String f14193c;

    /* renamed from: d  reason: collision with root package name */
    public String f14194d;

    /* renamed from: e  reason: collision with root package name */
    public String f14195e;

    /* renamed from: f  reason: collision with root package name */
    private String f14196f;

    /* renamed from: g  reason: collision with root package name */
    private String f14197g;

    /* renamed from: h  reason: collision with root package name */
    private String f14198h;

    /* renamed from: i  reason: collision with root package name */
    private a f14199i;
    private String j;
    private String k;
    private String l;
    private String m;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return k.a((Object) this.f14196f, (Object) bVar.f14196f) && k.a((Object) this.f14197g, (Object) bVar.f14197g) && k.a((Object) this.f14198h, (Object) bVar.f14198h) && k.a((Object) this.f14191a, (Object) bVar.f14191a) && k.a((Object) this.f14199i, (Object) bVar.f14199i) && k.a((Object) this.f14192b, (Object) bVar.f14192b) && k.a((Object) this.f14193c, (Object) bVar.f14193c) && k.a((Object) this.f14194d, (Object) bVar.f14194d) && k.a((Object) this.j, (Object) bVar.j) && k.a((Object) this.k, (Object) bVar.k) && k.a((Object) this.l, (Object) bVar.l) && k.a((Object) this.m, (Object) bVar.m) && k.a((Object) this.f14195e, (Object) bVar.f14195e);
    }

    public final int hashCode() {
        String str = this.f14196f;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f14197g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f14198h;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f14191a;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        a aVar = this.f14199i;
        int hashCode5 = (hashCode4 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str5 = this.f14192b;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f14193c;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f14194d;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.j;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.k;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.l;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.m;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.f14195e;
        if (str12 != null) {
            i2 = str12.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "InsuranceFulfillmentResponse(make=" + this.f14196f + ", model=" + this.f14197g + ", variant=" + this.f14198h + ", registrationNo=" + this.f14191a + ", additional_info=" + this.f14199i + ", policyNo=" + this.f14192b + ", policyStartDate=" + this.f14193c + ", policyExipryDate=" + this.f14194d + ", insuredFirstName=" + this.j + ", insuredLastName=" + this.k + ", contact_phone=" + this.l + ", contact_email=" + this.m + ", orderMessage=" + this.f14195e + ")";
    }
}
