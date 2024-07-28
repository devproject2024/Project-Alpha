package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class CorrespondenceAddress implements IJRDataModel {
    private String action;
    @b(a = "street_1")
    private String addressOne;
    @b(a = "locality")
    private String addressThree;
    @b(a = "street_2")
    private String addressTwo;
    private String addressType;
    @b(a = "city")
    private String city;
    private String country;
    @b(a = "sameAsPermanent")
    private Boolean isSameAsPermanent;
    @b(a = "postal_code")
    private String postalCode;
    @b(a = "state")
    private String state;

    public CorrespondenceAddress() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 1023, (g) null);
    }

    public static /* synthetic */ CorrespondenceAddress copy$default(CorrespondenceAddress correspondenceAddress, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, int i2, Object obj) {
        CorrespondenceAddress correspondenceAddress2 = correspondenceAddress;
        int i3 = i2;
        return correspondenceAddress.copy((i3 & 1) != 0 ? correspondenceAddress2.city : str, (i3 & 2) != 0 ? correspondenceAddress2.addressOne : str2, (i3 & 4) != 0 ? correspondenceAddress2.addressTwo : str3, (i3 & 8) != 0 ? correspondenceAddress2.addressThree : str4, (i3 & 16) != 0 ? correspondenceAddress2.country : str5, (i3 & 32) != 0 ? correspondenceAddress2.action : str6, (i3 & 64) != 0 ? correspondenceAddress2.addressType : str7, (i3 & 128) != 0 ? correspondenceAddress2.state : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? correspondenceAddress2.postalCode : str9, (i3 & 512) != 0 ? correspondenceAddress2.isSameAsPermanent : bool);
    }

    public final String component1() {
        return this.city;
    }

    public final Boolean component10() {
        return this.isSameAsPermanent;
    }

    public final String component2() {
        return this.addressOne;
    }

    public final String component3() {
        return this.addressTwo;
    }

    public final String component4() {
        return this.addressThree;
    }

    public final String component5() {
        return this.country;
    }

    public final String component6() {
        return this.action;
    }

    public final String component7() {
        return this.addressType;
    }

    public final String component8() {
        return this.state;
    }

    public final String component9() {
        return this.postalCode;
    }

    public final CorrespondenceAddress copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool) {
        return new CorrespondenceAddress(str, str2, str3, str4, str5, str6, str7, str8, str9, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CorrespondenceAddress)) {
            return false;
        }
        CorrespondenceAddress correspondenceAddress = (CorrespondenceAddress) obj;
        return k.a((Object) this.city, (Object) correspondenceAddress.city) && k.a((Object) this.addressOne, (Object) correspondenceAddress.addressOne) && k.a((Object) this.addressTwo, (Object) correspondenceAddress.addressTwo) && k.a((Object) this.addressThree, (Object) correspondenceAddress.addressThree) && k.a((Object) this.country, (Object) correspondenceAddress.country) && k.a((Object) this.action, (Object) correspondenceAddress.action) && k.a((Object) this.addressType, (Object) correspondenceAddress.addressType) && k.a((Object) this.state, (Object) correspondenceAddress.state) && k.a((Object) this.postalCode, (Object) correspondenceAddress.postalCode) && k.a((Object) this.isSameAsPermanent, (Object) correspondenceAddress.isSameAsPermanent);
    }

    public final int hashCode() {
        String str = this.city;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.addressOne;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.addressTwo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.addressThree;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.country;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.action;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.addressType;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.state;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.postalCode;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Boolean bool = this.isSameAsPermanent;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "CorrespondenceAddress(city=" + this.city + ", addressOne=" + this.addressOne + ", addressTwo=" + this.addressTwo + ", addressThree=" + this.addressThree + ", country=" + this.country + ", action=" + this.action + ", addressType=" + this.addressType + ", state=" + this.state + ", postalCode=" + this.postalCode + ", isSameAsPermanent=" + this.isSameAsPermanent + ")";
    }

    public CorrespondenceAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool) {
        this.city = str;
        this.addressOne = str2;
        this.addressTwo = str3;
        this.addressThree = str4;
        this.country = str5;
        this.action = str6;
        this.addressType = str7;
        this.state = str8;
        this.postalCode = str9;
        this.isSameAsPermanent = bool;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getAddressOne() {
        return this.addressOne;
    }

    public final void setAddressOne(String str) {
        this.addressOne = str;
    }

    public final String getAddressTwo() {
        return this.addressTwo;
    }

    public final void setAddressTwo(String str) {
        this.addressTwo = str;
    }

    public final String getAddressThree() {
        return this.addressThree;
    }

    public final void setAddressThree(String str) {
        this.addressThree = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final String getAddressType() {
        return this.addressType;
    }

    public final void setAddressType(String str) {
        this.addressType = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final void setPostalCode(String str) {
        this.postalCode = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CorrespondenceAddress(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Boolean r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0026
            java.lang.String r6 = "India"
            goto L_0x0028
        L_0x0026:
            r6 = r16
        L_0x0028:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002e
            r7 = r2
            goto L_0x0030
        L_0x002e:
            r7 = r17
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            java.lang.String r8 = "residential"
            goto L_0x0039
        L_0x0037:
            r8 = r18
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r19
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r2 = r20
        L_0x0048:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004f
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0051
        L_0x004f:
            r0 = r21
        L_0x0051:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r2
            r22 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, int, kotlin.g.b.g):void");
    }

    public final Boolean isSameAsPermanent() {
        return this.isSameAsPermanent;
    }

    public final void setSameAsPermanent(Boolean bool) {
        this.isSameAsPermanent = bool;
    }
}
