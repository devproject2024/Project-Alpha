package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class AddressDetailsDM {
    @c(a = "city")
    private final String city;
    @c(a = "district")
    private final String district;
    @c(a = "line1")
    private final String line1;
    @c(a = "line2")
    private final String line2;
    @c(a = "line3")
    private final String line3;
    @c(a = "state")
    private final String state;
    @c(a = "zipCode")
    private final String zipCode;

    public static /* synthetic */ AddressDetailsDM copy$default(AddressDetailsDM addressDetailsDM, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addressDetailsDM.line1;
        }
        if ((i2 & 2) != 0) {
            str2 = addressDetailsDM.line2;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = addressDetailsDM.line3;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = addressDetailsDM.district;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = addressDetailsDM.city;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = addressDetailsDM.state;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = addressDetailsDM.zipCode;
        }
        return addressDetailsDM.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.line1;
    }

    public final String component2() {
        return this.line2;
    }

    public final String component3() {
        return this.line3;
    }

    public final String component4() {
        return this.district;
    }

    public final String component5() {
        return this.city;
    }

    public final String component6() {
        return this.state;
    }

    public final String component7() {
        return this.zipCode;
    }

    public final AddressDetailsDM copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new AddressDetailsDM(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressDetailsDM)) {
            return false;
        }
        AddressDetailsDM addressDetailsDM = (AddressDetailsDM) obj;
        return k.a((Object) this.line1, (Object) addressDetailsDM.line1) && k.a((Object) this.line2, (Object) addressDetailsDM.line2) && k.a((Object) this.line3, (Object) addressDetailsDM.line3) && k.a((Object) this.district, (Object) addressDetailsDM.district) && k.a((Object) this.city, (Object) addressDetailsDM.city) && k.a((Object) this.state, (Object) addressDetailsDM.state) && k.a((Object) this.zipCode, (Object) addressDetailsDM.zipCode);
    }

    public final int hashCode() {
        String str = this.line1;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.line2;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.line3;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.district;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.city;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.state;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.zipCode;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "AddressDetailsDM(line1=" + this.line1 + ", line2=" + this.line2 + ", line3=" + this.line3 + ", district=" + this.district + ", city=" + this.city + ", state=" + this.state + ", zipCode=" + this.zipCode + ")";
    }

    public AddressDetailsDM(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.line1 = str;
        this.line2 = str2;
        this.line3 = str3;
        this.district = str4;
        this.city = str5;
        this.state = str6;
        this.zipCode = str7;
    }

    public final String getLine1() {
        return this.line1;
    }

    public final String getLine2() {
        return this.line2;
    }

    public final String getLine3() {
        return this.line3;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getState() {
        return this.state;
    }

    public final String getZipCode() {
        return this.zipCode;
    }
}
