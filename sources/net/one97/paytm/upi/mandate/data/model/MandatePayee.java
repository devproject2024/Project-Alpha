package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class MandatePayee implements UpiBaseDataModel {
    @c(a = "bankAccount")
    private final String bankAccount;
    @c(a = "ifsc")
    private final String bankIfsc;
    @c(a = "bankName")
    private final String bankName;
    @c(a = "imageUrl")
    private final String imageUrl;
    @c(a = "mcc")
    private final String mcc;
    @c(a = "userId")
    private final String userId;
    @c(a = "name")
    private final String userName;
    @c(a = "vpa")
    private final String vpa;

    public static /* synthetic */ MandatePayee copy$default(MandatePayee mandatePayee, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        MandatePayee mandatePayee2 = mandatePayee;
        int i3 = i2;
        return mandatePayee.copy((i3 & 1) != 0 ? mandatePayee2.userId : str, (i3 & 2) != 0 ? mandatePayee2.userName : str2, (i3 & 4) != 0 ? mandatePayee2.bankAccount : str3, (i3 & 8) != 0 ? mandatePayee2.bankIfsc : str4, (i3 & 16) != 0 ? mandatePayee2.bankName : str5, (i3 & 32) != 0 ? mandatePayee2.vpa : str6, (i3 & 64) != 0 ? mandatePayee2.mcc : str7, (i3 & 128) != 0 ? mandatePayee2.imageUrl : str8);
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

    public final String component8() {
        return this.imageUrl;
    }

    public final MandatePayee copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new MandatePayee(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandatePayee)) {
            return false;
        }
        MandatePayee mandatePayee = (MandatePayee) obj;
        return k.a((Object) this.userId, (Object) mandatePayee.userId) && k.a((Object) this.userName, (Object) mandatePayee.userName) && k.a((Object) this.bankAccount, (Object) mandatePayee.bankAccount) && k.a((Object) this.bankIfsc, (Object) mandatePayee.bankIfsc) && k.a((Object) this.bankName, (Object) mandatePayee.bankName) && k.a((Object) this.vpa, (Object) mandatePayee.vpa) && k.a((Object) this.mcc, (Object) mandatePayee.mcc) && k.a((Object) this.imageUrl, (Object) mandatePayee.imageUrl);
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
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.imageUrl;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "MandatePayee(userId=" + this.userId + ", userName=" + this.userName + ", bankAccount=" + this.bankAccount + ", bankIfsc=" + this.bankIfsc + ", bankName=" + this.bankName + ", vpa=" + this.vpa + ", mcc=" + this.mcc + ", imageUrl=" + this.imageUrl + ")";
    }

    public MandatePayee(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.userId = str;
        this.userName = str2;
        this.bankAccount = str3;
        this.bankIfsc = str4;
        this.bankName = str5;
        this.vpa = str6;
        this.mcc = str7;
        this.imageUrl = str8;
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

    public final String getBankIfsc() {
        return this.bankIfsc;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getVpa() {
        return this.vpa;
    }

    public final String getMcc() {
        return this.mcc;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
