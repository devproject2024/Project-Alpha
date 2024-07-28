package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class CbUserAddress extends IJRPaytmDataModel {
    @b(a = "address1")
    private final String address1;
    @b(a = "address2")
    private final String address2;
    @b(a = "city")
    private final String city;
    @b(a = "country")
    private final Integer country;
    @b(a = "countryCode")
    private final String countryCode;
    @b(a = "mobile")
    private final Integer mobile;
    @b(a = "name")
    private final String name;
    @b(a = "pin")
    private final Integer pin;
    @b(a = "state")
    private final String state;

    public static /* synthetic */ CbUserAddress copy$default(CbUserAddress cbUserAddress, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, Integer num3, int i2, Object obj) {
        CbUserAddress cbUserAddress2 = cbUserAddress;
        int i3 = i2;
        return cbUserAddress.copy((i3 & 1) != 0 ? cbUserAddress2.name : str, (i3 & 2) != 0 ? cbUserAddress2.address1 : str2, (i3 & 4) != 0 ? cbUserAddress2.address2 : str3, (i3 & 8) != 0 ? cbUserAddress2.city : str4, (i3 & 16) != 0 ? cbUserAddress2.state : str5, (i3 & 32) != 0 ? cbUserAddress2.pin : num, (i3 & 64) != 0 ? cbUserAddress2.country : num2, (i3 & 128) != 0 ? cbUserAddress2.countryCode : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cbUserAddress2.mobile : num3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.address1;
    }

    public final String component3() {
        return this.address2;
    }

    public final String component4() {
        return this.city;
    }

    public final String component5() {
        return this.state;
    }

    public final Integer component6() {
        return this.pin;
    }

    public final Integer component7() {
        return this.country;
    }

    public final String component8() {
        return this.countryCode;
    }

    public final Integer component9() {
        return this.mobile;
    }

    public final CbUserAddress copy(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, Integer num3) {
        return new CbUserAddress(str, str2, str3, str4, str5, num, num2, str6, num3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbUserAddress)) {
            return false;
        }
        CbUserAddress cbUserAddress = (CbUserAddress) obj;
        return k.a((Object) this.name, (Object) cbUserAddress.name) && k.a((Object) this.address1, (Object) cbUserAddress.address1) && k.a((Object) this.address2, (Object) cbUserAddress.address2) && k.a((Object) this.city, (Object) cbUserAddress.city) && k.a((Object) this.state, (Object) cbUserAddress.state) && k.a((Object) this.pin, (Object) cbUserAddress.pin) && k.a((Object) this.country, (Object) cbUserAddress.country) && k.a((Object) this.countryCode, (Object) cbUserAddress.countryCode) && k.a((Object) this.mobile, (Object) cbUserAddress.mobile);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.address1;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.address2;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.city;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.pin;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.country;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str6 = this.countryCode;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num3 = this.mobile;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "CbUserAddress(name=" + this.name + ", address1=" + this.address1 + ", address2=" + this.address2 + ", city=" + this.city + ", state=" + this.state + ", pin=" + this.pin + ", country=" + this.country + ", countryCode=" + this.countryCode + ", mobile=" + this.mobile + ")";
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress1() {
        return this.address1;
    }

    public final String getAddress2() {
        return this.address2;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getState() {
        return this.state;
    }

    public final Integer getPin() {
        return this.pin;
    }

    public final Integer getCountry() {
        return this.country;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public CbUserAddress(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, Integer num3) {
        this.name = str;
        this.address1 = str2;
        this.address2 = str3;
        this.city = str4;
        this.state = str5;
        this.pin = num;
        this.country = num2;
        this.countryCode = str6;
        this.mobile = num3;
    }

    public final Integer getMobile() {
        return this.mobile;
    }
}
