package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRConfiguration implements IJRDataModel {
    @b(a = "price")
    private Integer price;
    @b(a = "recharge_number")
    private String rechargeNumber;
    @b(a = "recharge_number_2")
    private String rechargeNumber2;
    @b(a = "recharge_number_3")
    private String rechargeNumber3;

    public CJRConfiguration() {
        this((Integer) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ CJRConfiguration copy$default(CJRConfiguration cJRConfiguration, Integer num, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cJRConfiguration.price;
        }
        if ((i2 & 2) != 0) {
            str = cJRConfiguration.rechargeNumber;
        }
        if ((i2 & 4) != 0) {
            str2 = cJRConfiguration.rechargeNumber2;
        }
        if ((i2 & 8) != 0) {
            str3 = cJRConfiguration.rechargeNumber3;
        }
        return cJRConfiguration.copy(num, str, str2, str3);
    }

    public final Integer component1() {
        return this.price;
    }

    public final String component2() {
        return this.rechargeNumber;
    }

    public final String component3() {
        return this.rechargeNumber2;
    }

    public final String component4() {
        return this.rechargeNumber3;
    }

    public final CJRConfiguration copy(Integer num, String str, String str2, String str3) {
        return new CJRConfiguration(num, str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRConfiguration)) {
            return false;
        }
        CJRConfiguration cJRConfiguration = (CJRConfiguration) obj;
        return k.a((Object) this.price, (Object) cJRConfiguration.price) && k.a((Object) this.rechargeNumber, (Object) cJRConfiguration.rechargeNumber) && k.a((Object) this.rechargeNumber2, (Object) cJRConfiguration.rechargeNumber2) && k.a((Object) this.rechargeNumber3, (Object) cJRConfiguration.rechargeNumber3);
    }

    public final int hashCode() {
        Integer num = this.price;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.rechargeNumber;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.rechargeNumber2;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.rechargeNumber3;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRConfiguration(price=" + this.price + ", rechargeNumber=" + this.rechargeNumber + ", rechargeNumber2=" + this.rechargeNumber2 + ", rechargeNumber3=" + this.rechargeNumber3 + ")";
    }

    public CJRConfiguration(Integer num, String str, String str2, String str3) {
        this.price = num;
        this.rechargeNumber = str;
        this.rechargeNumber2 = str2;
        this.rechargeNumber3 = str3;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final void setPrice(Integer num) {
        this.price = num;
    }

    public final String getRechargeNumber() {
        return this.rechargeNumber;
    }

    public final void setRechargeNumber(String str) {
        this.rechargeNumber = str;
    }

    public final String getRechargeNumber2() {
        return this.rechargeNumber2;
    }

    public final void setRechargeNumber2(String str) {
        this.rechargeNumber2 = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRConfiguration(Integer num, String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }

    public final String getRechargeNumber3() {
        return this.rechargeNumber3;
    }

    public final void setRechargeNumber3(String str) {
        this.rechargeNumber3 = str;
    }
}
