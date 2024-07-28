package net.one97.paytm.nativesdk.transactionsummary.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class SubsPaymentInstDetails implements IJRDataModel {
    private final String cardScheme;
    private final String cardSchemeLogo;
    private final String expiryDate;
    private final String instrumentStatus;
    private final String issuingBank;
    private final String issuingBankLogo;
    private final String maskedCardNumber;
    private final String maskedMobileNumber;
    private final String paymentMode;

    public static /* synthetic */ SubsPaymentInstDetails copy$default(SubsPaymentInstDetails subsPaymentInstDetails, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, Object obj) {
        SubsPaymentInstDetails subsPaymentInstDetails2 = subsPaymentInstDetails;
        int i3 = i2;
        return subsPaymentInstDetails.copy((i3 & 1) != 0 ? subsPaymentInstDetails2.cardScheme : str, (i3 & 2) != 0 ? subsPaymentInstDetails2.cardSchemeLogo : str2, (i3 & 4) != 0 ? subsPaymentInstDetails2.expiryDate : str3, (i3 & 8) != 0 ? subsPaymentInstDetails2.instrumentStatus : str4, (i3 & 16) != 0 ? subsPaymentInstDetails2.issuingBank : str5, (i3 & 32) != 0 ? subsPaymentInstDetails2.issuingBankLogo : str6, (i3 & 64) != 0 ? subsPaymentInstDetails2.maskedCardNumber : str7, (i3 & 128) != 0 ? subsPaymentInstDetails2.maskedMobileNumber : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? subsPaymentInstDetails2.paymentMode : str9);
    }

    public final String component1() {
        return this.cardScheme;
    }

    public final String component2() {
        return this.cardSchemeLogo;
    }

    public final String component3() {
        return this.expiryDate;
    }

    public final String component4() {
        return this.instrumentStatus;
    }

    public final String component5() {
        return this.issuingBank;
    }

    public final String component6() {
        return this.issuingBankLogo;
    }

    public final String component7() {
        return this.maskedCardNumber;
    }

    public final String component8() {
        return this.maskedMobileNumber;
    }

    public final String component9() {
        return this.paymentMode;
    }

    public final SubsPaymentInstDetails copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new SubsPaymentInstDetails(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubsPaymentInstDetails)) {
            return false;
        }
        SubsPaymentInstDetails subsPaymentInstDetails = (SubsPaymentInstDetails) obj;
        return k.a((Object) this.cardScheme, (Object) subsPaymentInstDetails.cardScheme) && k.a((Object) this.cardSchemeLogo, (Object) subsPaymentInstDetails.cardSchemeLogo) && k.a((Object) this.expiryDate, (Object) subsPaymentInstDetails.expiryDate) && k.a((Object) this.instrumentStatus, (Object) subsPaymentInstDetails.instrumentStatus) && k.a((Object) this.issuingBank, (Object) subsPaymentInstDetails.issuingBank) && k.a((Object) this.issuingBankLogo, (Object) subsPaymentInstDetails.issuingBankLogo) && k.a((Object) this.maskedCardNumber, (Object) subsPaymentInstDetails.maskedCardNumber) && k.a((Object) this.maskedMobileNumber, (Object) subsPaymentInstDetails.maskedMobileNumber) && k.a((Object) this.paymentMode, (Object) subsPaymentInstDetails.paymentMode);
    }

    public final int hashCode() {
        String str = this.cardScheme;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cardSchemeLogo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expiryDate;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.instrumentStatus;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.issuingBank;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.issuingBankLogo;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.maskedCardNumber;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.maskedMobileNumber;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.paymentMode;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "SubsPaymentInstDetails(cardScheme=" + this.cardScheme + ", cardSchemeLogo=" + this.cardSchemeLogo + ", expiryDate=" + this.expiryDate + ", instrumentStatus=" + this.instrumentStatus + ", issuingBank=" + this.issuingBank + ", issuingBankLogo=" + this.issuingBankLogo + ", maskedCardNumber=" + this.maskedCardNumber + ", maskedMobileNumber=" + this.maskedMobileNumber + ", paymentMode=" + this.paymentMode + ")";
    }

    public SubsPaymentInstDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.cardScheme = str;
        this.cardSchemeLogo = str2;
        this.expiryDate = str3;
        this.instrumentStatus = str4;
        this.issuingBank = str5;
        this.issuingBankLogo = str6;
        this.maskedCardNumber = str7;
        this.maskedMobileNumber = str8;
        this.paymentMode = str9;
    }

    public final String getCardScheme() {
        return this.cardScheme;
    }

    public final String getCardSchemeLogo() {
        return this.cardSchemeLogo;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final String getInstrumentStatus() {
        return this.instrumentStatus;
    }

    public final String getIssuingBank() {
        return this.issuingBank;
    }

    public final String getIssuingBankLogo() {
        return this.issuingBankLogo;
    }

    public final String getMaskedCardNumber() {
        return this.maskedCardNumber;
    }

    public final String getMaskedMobileNumber() {
        return this.maskedMobileNumber;
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }
}
