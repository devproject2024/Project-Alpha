package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class MandatePayer implements UpiBaseDataModel {
    @c(a = "bankAccount")
    private String bankAccount;
    @c(a = "ifsc")
    private String bankIfsc;
    @c(a = "bankName")
    private String bankName;
    @c(a = "mcc")
    private final String mcc;
    @c(a = "userId")
    private final String userId;
    @c(a = "name")
    private final String userName;
    @c(a = "vpa")
    private final String vpa;

    public static /* synthetic */ MandatePayer copy$default(MandatePayer mandatePayer, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mandatePayer.userId;
        }
        if ((i2 & 2) != 0) {
            str2 = mandatePayer.userName;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = mandatePayer.bankAccount;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = mandatePayer.bankIfsc;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = mandatePayer.bankName;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = mandatePayer.vpa;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = mandatePayer.mcc;
        }
        return mandatePayer.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.bankAccount;
    }

    public final String component4() {
        return this.bankIfsc;
    }

    public final String component5() {
        return this.bankName;
    }

    public final String component6() {
        return this.vpa;
    }

    public final String component7() {
        return this.mcc;
    }

    public final MandatePayer copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new MandatePayer(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandatePayer)) {
            return false;
        }
        MandatePayer mandatePayer = (MandatePayer) obj;
        return k.a((Object) this.userId, (Object) mandatePayer.userId) && k.a((Object) this.userName, (Object) mandatePayer.userName) && k.a((Object) this.bankAccount, (Object) mandatePayer.bankAccount) && k.a((Object) this.bankIfsc, (Object) mandatePayer.bankIfsc) && k.a((Object) this.bankName, (Object) mandatePayer.bankName) && k.a((Object) this.vpa, (Object) mandatePayer.vpa) && k.a((Object) this.mcc, (Object) mandatePayer.mcc);
    }

    public final int hashCode() {
        String str = this.userId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bankAccount;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bankIfsc;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bankName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.vpa;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mcc;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "MandatePayer(userId=" + this.userId + ", userName=" + this.userName + ", bankAccount=" + this.bankAccount + ", bankIfsc=" + this.bankIfsc + ", bankName=" + this.bankName + ", vpa=" + this.vpa + ", mcc=" + this.mcc + ")";
    }

    public MandatePayer(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.userId = str;
        this.userName = str2;
        this.bankAccount = str3;
        this.bankIfsc = str4;
        this.bankName = str5;
        this.vpa = str6;
        this.mcc = str7;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getBankAccount() {
        return this.bankAccount;
    }

    public final void setBankAccount(String str) {
        this.bankAccount = str;
    }

    public final String getBankIfsc() {
        return this.bankIfsc;
    }

    public final void setBankIfsc(String str) {
        this.bankIfsc = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getVpa() {
        return this.vpa;
    }

    public final String getMcc() {
        return this.mcc;
    }
}
