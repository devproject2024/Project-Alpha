package net.one97.paytm.recharge.domain.entities;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class AutomaticSubscriptionSavedCard extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cardFirstSixDigits")
    private String cardFirstSixDigits;
    @b(a = "cardLastFourDigits")
    private String cardLastFourDigits;
    @b(a = "cardScheme")
    private String cardScheme;
    @b(a = "cardType")
    private String cardType;
    @b(a = "issuerCode")
    private String issuerCode;
    @b(a = "issuerDisplayName")
    private String issuerDisplayName;
    @b(a = "savedCardId")
    private String savedCardId;

    public AutomaticSubscriptionSavedCard() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (g) null);
    }

    public static /* synthetic */ AutomaticSubscriptionSavedCard copy$default(AutomaticSubscriptionSavedCard automaticSubscriptionSavedCard, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = automaticSubscriptionSavedCard.savedCardId;
        }
        if ((i2 & 2) != 0) {
            str2 = automaticSubscriptionSavedCard.cardFirstSixDigits;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = automaticSubscriptionSavedCard.cardLastFourDigits;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = automaticSubscriptionSavedCard.cardType;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = automaticSubscriptionSavedCard.cardScheme;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = automaticSubscriptionSavedCard.issuerDisplayName;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = automaticSubscriptionSavedCard.issuerCode;
        }
        return automaticSubscriptionSavedCard.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.savedCardId;
    }

    public final String component2() {
        return this.cardFirstSixDigits;
    }

    public final String component3() {
        return this.cardLastFourDigits;
    }

    public final String component4() {
        return this.cardType;
    }

    public final String component5() {
        return this.cardScheme;
    }

    public final String component6() {
        return this.issuerDisplayName;
    }

    public final String component7() {
        return this.issuerCode;
    }

    public final AutomaticSubscriptionSavedCard copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new AutomaticSubscriptionSavedCard(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutomaticSubscriptionSavedCard)) {
            return false;
        }
        AutomaticSubscriptionSavedCard automaticSubscriptionSavedCard = (AutomaticSubscriptionSavedCard) obj;
        return k.a((Object) this.savedCardId, (Object) automaticSubscriptionSavedCard.savedCardId) && k.a((Object) this.cardFirstSixDigits, (Object) automaticSubscriptionSavedCard.cardFirstSixDigits) && k.a((Object) this.cardLastFourDigits, (Object) automaticSubscriptionSavedCard.cardLastFourDigits) && k.a((Object) this.cardType, (Object) automaticSubscriptionSavedCard.cardType) && k.a((Object) this.cardScheme, (Object) automaticSubscriptionSavedCard.cardScheme) && k.a((Object) this.issuerDisplayName, (Object) automaticSubscriptionSavedCard.issuerDisplayName) && k.a((Object) this.issuerCode, (Object) automaticSubscriptionSavedCard.issuerCode);
    }

    public final int hashCode() {
        String str = this.savedCardId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cardFirstSixDigits;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.cardLastFourDigits;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.cardType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cardScheme;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.issuerDisplayName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.issuerCode;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "AutomaticSubscriptionSavedCard(savedCardId=" + this.savedCardId + ", cardFirstSixDigits=" + this.cardFirstSixDigits + ", cardLastFourDigits=" + this.cardLastFourDigits + ", cardType=" + this.cardType + ", cardScheme=" + this.cardScheme + ", issuerDisplayName=" + this.issuerDisplayName + ", issuerCode=" + this.issuerCode + ")";
    }

    public final String getSavedCardId() {
        return this.savedCardId;
    }

    public final void setSavedCardId(String str) {
        this.savedCardId = str;
    }

    public final String getCardFirstSixDigits() {
        return this.cardFirstSixDigits;
    }

    public final void setCardFirstSixDigits(String str) {
        this.cardFirstSixDigits = str;
    }

    public final String getCardLastFourDigits() {
        return this.cardLastFourDigits;
    }

    public final void setCardLastFourDigits(String str) {
        this.cardLastFourDigits = str;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public final String getCardScheme() {
        return this.cardScheme;
    }

    public final void setCardScheme(String str) {
        this.cardScheme = str;
    }

    public final String getIssuerDisplayName() {
        return this.issuerDisplayName;
    }

    public final void setIssuerDisplayName(String str) {
        this.issuerDisplayName = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AutomaticSubscriptionSavedCard(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.AutomaticSubscriptionSavedCard.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getIssuerCode() {
        return this.issuerCode;
    }

    public final void setIssuerCode(String str) {
        this.issuerCode = str;
    }

    public AutomaticSubscriptionSavedCard(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.savedCardId = str;
        this.cardFirstSixDigits = str2;
        this.cardLastFourDigits = str3;
        this.cardType = str4;
        this.cardScheme = str5;
        this.issuerDisplayName = str6;
        this.issuerCode = str7;
    }

    public final String getLastFourDigits() {
        if (TextUtils.isEmpty(this.cardLastFourDigits)) {
            this.cardLastFourDigits = "0000";
            return this.cardLastFourDigits;
        }
        String str = this.cardLastFourDigits;
        if (str != null) {
            if (str == null) {
                k.a();
            }
            if (str.length() < 4) {
                String str2 = this.cardLastFourDigits;
                if (str2 == null) {
                    k.a();
                }
                int length = str2.length();
                if (length < 4) {
                    int i2 = 4 - length;
                    if (i2 == 1) {
                        this.cardLastFourDigits = "0" + this.cardLastFourDigits;
                    } else if (i2 == 2) {
                        this.cardLastFourDigits = "00" + this.cardLastFourDigits;
                    } else if (i2 == 3) {
                        this.cardLastFourDigits = "000" + this.cardLastFourDigits;
                    }
                }
            }
        }
        return this.cardLastFourDigits;
    }
}
