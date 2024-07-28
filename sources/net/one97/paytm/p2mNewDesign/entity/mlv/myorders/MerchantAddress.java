package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MerchantAddress extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "address")
    private String address;
    @b(a = "city")
    private String city;
    @b(a = "id")
    private String id;
    @b(a = "merchant_id")
    private String merchantId;
    @b(a = "pin_code")
    private String pinCode;
    @b(a = "state")
    private String state;
    @b(a = "type")
    private String type;
    @b(a = "updated_at")
    private String updatedAt;

    public MerchantAddress() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ MerchantAddress copy$default(MerchantAddress merchantAddress, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        MerchantAddress merchantAddress2 = merchantAddress;
        int i3 = i2;
        return merchantAddress.copy((i3 & 1) != 0 ? merchantAddress2.id : str, (i3 & 2) != 0 ? merchantAddress2.merchantId : str2, (i3 & 4) != 0 ? merchantAddress2.address : str3, (i3 & 8) != 0 ? merchantAddress2.city : str4, (i3 & 16) != 0 ? merchantAddress2.state : str5, (i3 & 32) != 0 ? merchantAddress2.pinCode : str6, (i3 & 64) != 0 ? merchantAddress2.updatedAt : str7, (i3 & 128) != 0 ? merchantAddress2.type : str8);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.merchantId;
    }

    public final String component3() {
        return this.address;
    }

    public final String component4() {
        return this.city;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.pinCode;
    }

    public final String component7() {
        return this.updatedAt;
    }

    public final String component8() {
        return this.type;
    }

    public final MerchantAddress copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new MerchantAddress(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MerchantAddress)) {
            return false;
        }
        MerchantAddress merchantAddress = (MerchantAddress) obj;
        return k.a((Object) this.id, (Object) merchantAddress.id) && k.a((Object) this.merchantId, (Object) merchantAddress.merchantId) && k.a((Object) this.address, (Object) merchantAddress.address) && k.a((Object) this.city, (Object) merchantAddress.city) && k.a((Object) this.state, (Object) merchantAddress.state) && k.a((Object) this.pinCode, (Object) merchantAddress.pinCode) && k.a((Object) this.updatedAt, (Object) merchantAddress.updatedAt) && k.a((Object) this.type, (Object) merchantAddress.type);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.address;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.city;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.pinCode;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.updatedAt;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.type;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "MerchantAddress(id=" + this.id + ", merchantId=" + this.merchantId + ", address=" + this.address + ", city=" + this.city + ", state=" + this.state + ", pinCode=" + this.pinCode + ", updatedAt=" + this.updatedAt + ", type=" + this.type + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
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

    public final String getPinCode() {
        return this.pinCode;
    }

    public final void setPinCode(String str) {
        this.pinCode = str;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public MerchantAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.id = str;
        this.merchantId = str2;
        this.address = str3;
        this.city = str4;
        this.state = str5;
        this.pinCode = str6;
        this.updatedAt = str7;
        this.type = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MerchantAddress(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MerchantAddress.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }
}
