package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class ExtendInfo extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "areaCode")
    private String areaCode;
    @b(a = "operator")
    private String operator;
    @b(a = "phoneNumber")
    private String phoneNumber;

    public ExtendInfo() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ ExtendInfo copy$default(ExtendInfo extendInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = extendInfo.phoneNumber;
        }
        if ((i2 & 2) != 0) {
            str2 = extendInfo.areaCode;
        }
        if ((i2 & 4) != 0) {
            str3 = extendInfo.operator;
        }
        return extendInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.phoneNumber;
    }

    public final String component2() {
        return this.areaCode;
    }

    public final String component3() {
        return this.operator;
    }

    public final ExtendInfo copy(String str, String str2, String str3) {
        return new ExtendInfo(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtendInfo)) {
            return false;
        }
        ExtendInfo extendInfo = (ExtendInfo) obj;
        return k.a((Object) this.phoneNumber, (Object) extendInfo.phoneNumber) && k.a((Object) this.areaCode, (Object) extendInfo.areaCode) && k.a((Object) this.operator, (Object) extendInfo.operator);
    }

    public final int hashCode() {
        String str = this.phoneNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.areaCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.operator;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ExtendInfo(phoneNumber=" + this.phoneNumber + ", areaCode=" + this.areaCode + ", operator=" + this.operator + ")";
    }

    public ExtendInfo(String str, String str2, String str3) {
        this.phoneNumber = str;
        this.areaCode = str2;
        this.operator = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExtendInfo(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setAreaCode(String str) {
        this.areaCode = str;
    }

    public final void setOperator(String str) {
        this.operator = str;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }
}
