package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class CardDetailsV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "cardId")
    private String cardId;
    @b(a = "cardType")
    private String cardType;
    @b(a = "expiryDate")
    private String expiryDate;
    @b(a = "firstSixDigit")
    private String firstSixDigit;
    @b(a = "lastFourDigit")
    private String lastFourDigit;
    @b(a = "status")
    private String status;

    public CardDetailsV2() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ CardDetailsV2 copy$default(CardDetailsV2 cardDetailsV2, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cardDetailsV2.cardId;
        }
        if ((i2 & 2) != 0) {
            str2 = cardDetailsV2.status;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = cardDetailsV2.expiryDate;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = cardDetailsV2.lastFourDigit;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = cardDetailsV2.cardType;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = cardDetailsV2.firstSixDigit;
        }
        return cardDetailsV2.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.cardId;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.expiryDate;
    }

    public final String component4() {
        return this.lastFourDigit;
    }

    public final String component5() {
        return this.cardType;
    }

    public final String component6() {
        return this.firstSixDigit;
    }

    public final CardDetailsV2 copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new CardDetailsV2(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardDetailsV2)) {
            return false;
        }
        CardDetailsV2 cardDetailsV2 = (CardDetailsV2) obj;
        return k.a((Object) this.cardId, (Object) cardDetailsV2.cardId) && k.a((Object) this.status, (Object) cardDetailsV2.status) && k.a((Object) this.expiryDate, (Object) cardDetailsV2.expiryDate) && k.a((Object) this.lastFourDigit, (Object) cardDetailsV2.lastFourDigit) && k.a((Object) this.cardType, (Object) cardDetailsV2.cardType) && k.a((Object) this.firstSixDigit, (Object) cardDetailsV2.firstSixDigit);
    }

    public final int hashCode() {
        String str = this.cardId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expiryDate;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.lastFourDigit;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cardType;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.firstSixDigit;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CardDetailsV2(cardId=" + this.cardId + ", status=" + this.status + ", expiryDate=" + this.expiryDate + ", lastFourDigit=" + this.lastFourDigit + ", cardType=" + this.cardType + ", firstSixDigit=" + this.firstSixDigit + ")";
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final void setCardId(String str) {
        this.cardId = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public final String getLastFourDigit() {
        return this.lastFourDigit;
    }

    public final void setLastFourDigit(String str) {
        this.lastFourDigit = str;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public CardDetailsV2(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cardId = str;
        this.status = str2;
        this.expiryDate = str3;
        this.lastFourDigit = str4;
        this.cardType = str5;
        this.firstSixDigit = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardDetailsV2(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.CardDetailsV2.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getFirstSixDigit() {
        return this.firstSixDigit;
    }

    public final void setFirstSixDigit(String str) {
        this.firstSixDigit = str;
    }
}
