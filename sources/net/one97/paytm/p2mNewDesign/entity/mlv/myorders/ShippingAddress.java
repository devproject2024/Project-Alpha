package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class ShippingAddress extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "address1")
    private Object address1;
    @b(a = "address2")
    private String address2;
    @b(a = "city")
    private String city;
    @b(a = "country")
    private String country;
    @b(a = "mobile")
    private String mobile;
    @b(a = "name")
    private String name;
    @b(a = "pin")
    private String pin;
    @b(a = "state")
    private String state;

    public ShippingAddress() {
        this((String) null, (Object) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ ShippingAddress copy$default(ShippingAddress shippingAddress, String str, Object obj, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj2) {
        ShippingAddress shippingAddress2 = shippingAddress;
        int i3 = i2;
        return shippingAddress.copy((i3 & 1) != 0 ? shippingAddress2.name : str, (i3 & 2) != 0 ? shippingAddress2.address1 : obj, (i3 & 4) != 0 ? shippingAddress2.address2 : str2, (i3 & 8) != 0 ? shippingAddress2.city : str3, (i3 & 16) != 0 ? shippingAddress2.state : str4, (i3 & 32) != 0 ? shippingAddress2.country : str5, (i3 & 64) != 0 ? shippingAddress2.pin : str6, (i3 & 128) != 0 ? shippingAddress2.mobile : str7);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
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

    public final String component6() {
        return this.country;
    }

    public final String component7() {
        return this.pin;
    }

    public final String component8() {
        return this.mobile;
    }

    public final ShippingAddress copy(String str, Object obj, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new ShippingAddress(str, obj, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShippingAddress)) {
            return false;
        }
        ShippingAddress shippingAddress = (ShippingAddress) obj;
        return k.a((Object) this.name, (Object) shippingAddress.name) && k.a(this.address1, shippingAddress.address1) && k.a((Object) this.address2, (Object) shippingAddress.address2) && k.a((Object) this.city, (Object) shippingAddress.city) && k.a((Object) this.state, (Object) shippingAddress.state) && k.a((Object) this.country, (Object) shippingAddress.country) && k.a((Object) this.pin, (Object) shippingAddress.pin) && k.a((Object) this.mobile, (Object) shippingAddress.mobile);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.address1;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        String str2 = this.address2;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.city;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.state;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.country;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.pin;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mobile;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "ShippingAddress(name=" + this.name + ", address1=" + this.address1 + ", address2=" + this.address2 + ", city=" + this.city + ", state=" + this.state + ", country=" + this.country + ", pin=" + this.pin + ", mobile=" + this.mobile + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Object getAddress1() {
        return this.address1;
    }

    public final void setAddress1(Object obj) {
        this.address1 = obj;
    }

    public final String getAddress2() {
        return this.address2;
    }

    public final void setAddress2(String str) {
        this.address2 = str;
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

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getPin() {
        return this.pin;
    }

    public final void setPin(String str) {
        this.pin = str;
    }

    public ShippingAddress(String str, Object obj, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.name = str;
        this.address1 = obj;
        this.address2 = str2;
        this.city = str3;
        this.state = str4;
        this.country = str5;
        this.pin = str6;
        this.mobile = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShippingAddress(java.lang.String r10, java.lang.Object r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.ShippingAddress.<init>(java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final void setMobile(String str) {
        this.mobile = str;
    }
}
