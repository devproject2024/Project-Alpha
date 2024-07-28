package net.one97.paytm.recharge.domain.entities;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class AutomaticProductInfo implements IJRDataModel {
    @b(a = "bank_logo")
    private String bankLogo;
    @b(a = "card_number")
    private String cardNumber;
    @b(a = "masked_account_no")
    private String maskedAccountNumber;
    @b(a = "saved_card_id")
    private String savedCardId;

    public static /* synthetic */ AutomaticProductInfo copy$default(AutomaticProductInfo automaticProductInfo, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = automaticProductInfo.cardNumber;
        }
        if ((i2 & 2) != 0) {
            str2 = automaticProductInfo.savedCardId;
        }
        if ((i2 & 4) != 0) {
            str3 = automaticProductInfo.bankLogo;
        }
        if ((i2 & 8) != 0) {
            str4 = automaticProductInfo.maskedAccountNumber;
        }
        return automaticProductInfo.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.cardNumber;
    }

    public final String component2() {
        return this.savedCardId;
    }

    public final String component3() {
        return this.bankLogo;
    }

    public final String component4() {
        return this.maskedAccountNumber;
    }

    public final AutomaticProductInfo copy(String str, String str2, String str3, String str4) {
        k.c(str, SDKConstants.CARD_NUMBER);
        k.c(str2, "savedCardId");
        k.c(str3, "bankLogo");
        k.c(str4, "maskedAccountNumber");
        return new AutomaticProductInfo(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutomaticProductInfo)) {
            return false;
        }
        AutomaticProductInfo automaticProductInfo = (AutomaticProductInfo) obj;
        return k.a((Object) this.cardNumber, (Object) automaticProductInfo.cardNumber) && k.a((Object) this.savedCardId, (Object) automaticProductInfo.savedCardId) && k.a((Object) this.bankLogo, (Object) automaticProductInfo.bankLogo) && k.a((Object) this.maskedAccountNumber, (Object) automaticProductInfo.maskedAccountNumber);
    }

    public final int hashCode() {
        String str = this.cardNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.savedCardId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bankLogo;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.maskedAccountNumber;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "AutomaticProductInfo(cardNumber=" + this.cardNumber + ", savedCardId=" + this.savedCardId + ", bankLogo=" + this.bankLogo + ", maskedAccountNumber=" + this.maskedAccountNumber + ")";
    }

    public AutomaticProductInfo(String str, String str2, String str3, String str4) {
        k.c(str, SDKConstants.CARD_NUMBER);
        k.c(str2, "savedCardId");
        k.c(str3, "bankLogo");
        k.c(str4, "maskedAccountNumber");
        this.cardNumber = str;
        this.savedCardId = str2;
        this.bankLogo = str3;
        this.maskedAccountNumber = str4;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final void setCardNumber(String str) {
        k.c(str, "<set-?>");
        this.cardNumber = str;
    }

    public final String getSavedCardId() {
        return this.savedCardId;
    }

    public final void setSavedCardId(String str) {
        k.c(str, "<set-?>");
        this.savedCardId = str;
    }

    public final String getBankLogo() {
        return this.bankLogo;
    }

    public final void setBankLogo(String str) {
        k.c(str, "<set-?>");
        this.bankLogo = str;
    }

    public final String getMaskedAccountNumber() {
        return this.maskedAccountNumber;
    }

    public final void setMaskedAccountNumber(String str) {
        k.c(str, "<set-?>");
        this.maskedAccountNumber = str;
    }

    public final String getMaskedCardNumber(CJRSavedInstrument cJRSavedInstrument) {
        if (TextUtils.isEmpty(this.cardNumber)) {
            if ((cJRSavedInstrument != null ? cJRSavedInstrument.getCardDetails() : null) == null) {
                return "";
            }
            if (cJRSavedInstrument == null) {
                k.a();
            }
            CJRCardDetails cardDetails = cJRSavedInstrument.getCardDetails();
            if (cardDetails == null) {
                k.a();
            }
            String lastFourDigit = cardDetails.getLastFourDigit();
            if (TextUtils.isEmpty(lastFourDigit)) {
                return "";
            }
            StringBuilder sb = new StringBuilder("XX ");
            if (lastFourDigit == null) {
                k.a();
            }
            sb.append(lastFourDigit);
            return sb.toString();
        }
        int length = this.cardNumber.length();
        StringBuilder sb2 = new StringBuilder("XX ");
        String str = this.cardNumber;
        int i2 = length - 4;
        if (str != null) {
            String substring = str.substring(i2, length);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb2.append(substring);
            return sb2.toString();
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String getMaskedCardNumber(AutomaticSubscriptionSavedCard automaticSubscriptionSavedCard) {
        k.c(automaticSubscriptionSavedCard, "savedCard");
        return "XX " + automaticSubscriptionSavedCard.getLastFourDigits();
    }

    public final String getFirstFourDigits() {
        if (TextUtils.isEmpty(this.cardNumber)) {
            return "";
        }
        String a2 = p.a(this.cardNumber, " ", "", false);
        if (a2.length() <= 3) {
            return "";
        }
        if (a2 != null) {
            String substring = a2.substring(0, 4);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String getLastFourDigits() {
        if (TextUtils.isEmpty(this.cardNumber)) {
            return "";
        }
        String a2 = p.a(this.cardNumber, " ", "", false);
        if (a2.length() <= 3) {
            return "";
        }
        int length = a2.length() - 4;
        int length2 = a2.length();
        if (a2 != null) {
            String substring = a2.substring(length, length2);
            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }
}
