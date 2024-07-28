package net.one97.paytm.recharge.domain.entities;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class CJRCardDetails extends IJRPaytmDataModel {
    @b(a = "cardId")
    private String cardId;
    @b(a = "cardType")
    private String cardType;
    @b(a = "cvvLength")
    private String cvvLength;
    @b(a = "firstSixDigit")
    private String firstSixDigit;
    @b(a = "lastFourDigit")
    private String lastFourDigit;
    @b(a = "status")
    private String status;

    public CJRCardDetails() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ CJRCardDetails copy$default(CJRCardDetails cJRCardDetails, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRCardDetails.cardId;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRCardDetails.cardType;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = cJRCardDetails.firstSixDigit;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = cJRCardDetails.lastFourDigit;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = cJRCardDetails.cvvLength;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = cJRCardDetails.status;
        }
        return cJRCardDetails.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.cardId;
    }

    public final String component2() {
        return this.cardType;
    }

    public final String component3() {
        return this.firstSixDigit;
    }

    public final String component4() {
        return this.lastFourDigit;
    }

    public final String component5() {
        return this.cvvLength;
    }

    public final String component6() {
        return this.status;
    }

    public final CJRCardDetails copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new CJRCardDetails(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCardDetails)) {
            return false;
        }
        CJRCardDetails cJRCardDetails = (CJRCardDetails) obj;
        return k.a((Object) this.cardId, (Object) cJRCardDetails.cardId) && k.a((Object) this.cardType, (Object) cJRCardDetails.cardType) && k.a((Object) this.firstSixDigit, (Object) cJRCardDetails.firstSixDigit) && k.a((Object) this.lastFourDigit, (Object) cJRCardDetails.lastFourDigit) && k.a((Object) this.cvvLength, (Object) cJRCardDetails.cvvLength) && k.a((Object) this.status, (Object) cJRCardDetails.status);
    }

    public final int hashCode() {
        String str = this.cardId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cardType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.firstSixDigit;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lastFourDigit;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cvvLength;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.status;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CJRCardDetails(cardId=" + this.cardId + ", cardType=" + this.cardType + ", firstSixDigit=" + this.firstSixDigit + ", lastFourDigit=" + this.lastFourDigit + ", cvvLength=" + this.cvvLength + ", status=" + this.status + ")";
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final void setCardId(String str) {
        this.cardId = str;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public final String getFirstSixDigit() {
        return this.firstSixDigit;
    }

    public final void setFirstSixDigit(String str) {
        this.firstSixDigit = str;
    }

    public final String getLastFourDigit() {
        return this.lastFourDigit;
    }

    public final void setLastFourDigit(String str) {
        this.lastFourDigit = str;
    }

    public final String getCvvLength() {
        return this.cvvLength;
    }

    public final void setCvvLength(String str) {
        this.cvvLength = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRCardDetails(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRCardDetails.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public CJRCardDetails(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cardId = str;
        this.cardType = str2;
        this.firstSixDigit = str3;
        this.lastFourDigit = str4;
        this.cvvLength = str5;
        this.status = str6;
    }

    public final String getFirstFourDigits() {
        if (TextUtils.isEmpty(this.firstSixDigit)) {
            return "";
        }
        String str = this.firstSixDigit;
        if (str == null) {
            k.a();
        }
        if (str.length() <= 3) {
            return "";
        }
        String str2 = this.firstSixDigit;
        if (str2 != null) {
            if (str2 != null) {
                String substring = str2.substring(0, 4);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                if (substring != null) {
                    return substring;
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        return "";
    }
}
