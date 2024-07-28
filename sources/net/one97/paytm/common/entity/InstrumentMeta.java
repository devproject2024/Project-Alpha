package net.one97.paytm.common.entity;

import kotlin.g.b.k;

public final class InstrumentMeta {
    private final String accountNo;
    private final String bankName;
    private final String custId;
    private final String ifsc;
    private final String mobileNo;
    private final String name;
    private final String type;
    private final String vpa;

    public static /* synthetic */ InstrumentMeta copy$default(InstrumentMeta instrumentMeta, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        InstrumentMeta instrumentMeta2 = instrumentMeta;
        int i3 = i2;
        return instrumentMeta.copy((i3 & 1) != 0 ? instrumentMeta2.accountNo : str, (i3 & 2) != 0 ? instrumentMeta2.bankName : str2, (i3 & 4) != 0 ? instrumentMeta2.ifsc : str3, (i3 & 8) != 0 ? instrumentMeta2.name : str4, (i3 & 16) != 0 ? instrumentMeta2.mobileNo : str5, (i3 & 32) != 0 ? instrumentMeta2.vpa : str6, (i3 & 64) != 0 ? instrumentMeta2.custId : str7, (i3 & 128) != 0 ? instrumentMeta2.type : str8);
    }

    public final String component1() {
        return this.accountNo;
    }

    public final String component2() {
        return this.bankName;
    }

    public final String component3() {
        return this.ifsc;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.mobileNo;
    }

    public final String component6() {
        return this.vpa;
    }

    public final String component7() {
        return this.custId;
    }

    public final String component8() {
        return this.type;
    }

    public final InstrumentMeta copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new InstrumentMeta(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstrumentMeta)) {
            return false;
        }
        InstrumentMeta instrumentMeta = (InstrumentMeta) obj;
        return k.a((Object) this.accountNo, (Object) instrumentMeta.accountNo) && k.a((Object) this.bankName, (Object) instrumentMeta.bankName) && k.a((Object) this.ifsc, (Object) instrumentMeta.ifsc) && k.a((Object) this.name, (Object) instrumentMeta.name) && k.a((Object) this.mobileNo, (Object) instrumentMeta.mobileNo) && k.a((Object) this.vpa, (Object) instrumentMeta.vpa) && k.a((Object) this.custId, (Object) instrumentMeta.custId) && k.a((Object) this.type, (Object) instrumentMeta.type);
    }

    public final int hashCode() {
        String str = this.accountNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bankName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ifsc;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mobileNo;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.vpa;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.custId;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.type;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "InstrumentMeta(accountNo=" + this.accountNo + ", bankName=" + this.bankName + ", ifsc=" + this.ifsc + ", name=" + this.name + ", mobileNo=" + this.mobileNo + ", vpa=" + this.vpa + ", custId=" + this.custId + ", type=" + this.type + ")";
    }

    public InstrumentMeta(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.accountNo = str;
        this.bankName = str2;
        this.ifsc = str3;
        this.name = str4;
        this.mobileNo = str5;
        this.vpa = str6;
        this.custId = str7;
        this.type = str8;
    }

    public final String getAccountNo() {
        return this.accountNo;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMobileNo() {
        return this.mobileNo;
    }

    public final String getVpa() {
        return this.vpa;
    }

    public final String getCustId() {
        return this.custId;
    }

    public final String getType() {
        return this.type;
    }
}
