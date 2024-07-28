package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class DisplayFields implements Serializable {
    private String amount;
    private String bankLogo;
    private String bankName;
    private String descriptionText;
    private String headerText;
    private String orderId;

    public static /* synthetic */ DisplayFields copy$default(DisplayFields displayFields, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = displayFields.amount;
        }
        if ((i2 & 2) != 0) {
            str2 = displayFields.descriptionText;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = displayFields.headerText;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = displayFields.orderId;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = displayFields.bankName;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = displayFields.bankLogo;
        }
        return displayFields.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.amount;
    }

    public final String component2() {
        return this.descriptionText;
    }

    public final String component3() {
        return this.headerText;
    }

    public final String component4() {
        return this.orderId;
    }

    public final String component5() {
        return this.bankName;
    }

    public final String component6() {
        return this.bankLogo;
    }

    public final DisplayFields copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new DisplayFields(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DisplayFields)) {
            return false;
        }
        DisplayFields displayFields = (DisplayFields) obj;
        return k.a((Object) this.amount, (Object) displayFields.amount) && k.a((Object) this.descriptionText, (Object) displayFields.descriptionText) && k.a((Object) this.headerText, (Object) displayFields.headerText) && k.a((Object) this.orderId, (Object) displayFields.orderId) && k.a((Object) this.bankName, (Object) displayFields.bankName) && k.a((Object) this.bankLogo, (Object) displayFields.bankLogo);
    }

    public final int hashCode() {
        String str = this.amount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.descriptionText;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.headerText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.orderId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bankName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.bankLogo;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "DisplayFields(amount=" + this.amount + ", descriptionText=" + this.descriptionText + ", headerText=" + this.headerText + ", orderId=" + this.orderId + ", bankName=" + this.bankName + ", bankLogo=" + this.bankLogo + ")";
    }

    public DisplayFields(String str, String str2, String str3, String str4, String str5, String str6) {
        this.amount = str;
        this.descriptionText = str2;
        this.headerText = str3;
        this.orderId = str4;
        this.bankName = str5;
        this.bankLogo = str6;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final void setDescriptionText(String str) {
        this.descriptionText = str;
    }

    public final String getHeaderText() {
        return this.headerText;
    }

    public final void setHeaderText(String str) {
        this.headerText = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getBankLogo() {
        return this.bankLogo;
    }

    public final void setBankLogo(String str) {
        this.bankLogo = str;
    }
}
