package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class PermanentAddress implements IJRDataModel {
    @b(a = "city")
    private String city;
    @b(a = "locality")
    private String locality;
    @b(a = "postal_code")
    private String postalCode;
    @b(a = "state")
    private String state;
    @b(a = "street_1")
    private String street1;
    @b(a = "street_2")
    private String street2;

    public PermanentAddress() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ PermanentAddress copy$default(PermanentAddress permanentAddress, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = permanentAddress.locality;
        }
        if ((i2 & 2) != 0) {
            str2 = permanentAddress.street1;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = permanentAddress.street2;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = permanentAddress.city;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = permanentAddress.state;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = permanentAddress.postalCode;
        }
        return permanentAddress.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.locality;
    }

    public final String component2() {
        return this.street1;
    }

    public final String component3() {
        return this.street2;
    }

    public final String component4() {
        return this.city;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.postalCode;
    }

    public final PermanentAddress copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new PermanentAddress(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermanentAddress)) {
            return false;
        }
        PermanentAddress permanentAddress = (PermanentAddress) obj;
        return k.a((Object) this.locality, (Object) permanentAddress.locality) && k.a((Object) this.street1, (Object) permanentAddress.street1) && k.a((Object) this.street2, (Object) permanentAddress.street2) && k.a((Object) this.city, (Object) permanentAddress.city) && k.a((Object) this.state, (Object) permanentAddress.state) && k.a((Object) this.postalCode, (Object) permanentAddress.postalCode);
    }

    public final int hashCode() {
        String str = this.locality;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.street1;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.street2;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.city;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.postalCode;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "PermanentAddress(locality=" + this.locality + ", street1=" + this.street1 + ", street2=" + this.street2 + ", city=" + this.city + ", state=" + this.state + ", postalCode=" + this.postalCode + ")";
    }

    public PermanentAddress(String str, String str2, String str3, String str4, String str5, String str6) {
        this.locality = str;
        this.street1 = str2;
        this.street2 = str3;
        this.city = str4;
        this.state = str5;
        this.postalCode = str6;
    }

    public final String getLocality() {
        return this.locality;
    }

    public final void setLocality(String str) {
        this.locality = str;
    }

    public final String getStreet1() {
        return this.street1;
    }

    public final void setStreet1(String str) {
        this.street1 = str;
    }

    public final String getStreet2() {
        return this.street2;
    }

    public final void setStreet2(String str) {
        this.street2 = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PermanentAddress(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.upgradeKyc.PermanentAddress.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final void setPostalCode(String str) {
        this.postalCode = str;
    }
}
