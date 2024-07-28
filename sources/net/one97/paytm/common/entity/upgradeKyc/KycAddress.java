package net.one97.paytm.common.entity.upgradeKyc;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class KycAddress implements IJRDataModel {
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String pincode;
    private String state;

    public KycAddress() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ KycAddress copy$default(KycAddress kycAddress, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kycAddress.addressLine1;
        }
        if ((i2 & 2) != 0) {
            str2 = kycAddress.addressLine2;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = kycAddress.pincode;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = kycAddress.city;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = kycAddress.state;
        }
        return kycAddress.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.addressLine1;
    }

    public final String component2() {
        return this.addressLine2;
    }

    public final String component3() {
        return this.pincode;
    }

    public final String component4() {
        return this.city;
    }

    public final String component5() {
        return this.state;
    }

    public final KycAddress copy(String str, String str2, String str3, String str4, String str5) {
        return new KycAddress(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KycAddress)) {
            return false;
        }
        KycAddress kycAddress = (KycAddress) obj;
        return k.a((Object) this.addressLine1, (Object) kycAddress.addressLine1) && k.a((Object) this.addressLine2, (Object) kycAddress.addressLine2) && k.a((Object) this.pincode, (Object) kycAddress.pincode) && k.a((Object) this.city, (Object) kycAddress.city) && k.a((Object) this.state, (Object) kycAddress.state);
    }

    public final int hashCode() {
        String str = this.addressLine1;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.addressLine2;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.pincode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.city;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "KycAddress(addressLine1=" + this.addressLine1 + ", addressLine2=" + this.addressLine2 + ", pincode=" + this.pincode + ", city=" + this.city + ", state=" + this.state + ")";
    }

    public KycAddress(String str, String str2, String str3, String str4, String str5) {
        this.addressLine1 = str;
        this.addressLine2 = str2;
        this.pincode = str3;
        this.city = str4;
        this.state = str5;
    }

    public final String getAddressLine1() {
        return this.addressLine1;
    }

    public final void setAddressLine1(String str) {
        this.addressLine1 = str;
    }

    public final String getAddressLine2() {
        return this.addressLine2;
    }

    public final void setAddressLine2(String str) {
        this.addressLine2 = str;
    }

    public final String getPincode() {
        return this.pincode;
    }

    public final void setPincode(String str) {
        this.pincode = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ KycAddress(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.upgradeKyc.KycAddress.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }
}
