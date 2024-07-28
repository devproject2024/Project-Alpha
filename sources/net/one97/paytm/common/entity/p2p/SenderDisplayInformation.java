package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SenderDisplayInformation extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "cta")
    private String cta;
    @b(a = "ctaText")
    private String ctaText;
    @b(a = "deeplinkType")
    private String deeplinkType;
    @b(a = "displayMessage")
    private String displayMessage;
    @b(a = "heading")
    private String heading;

    public SenderDisplayInformation() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ SenderDisplayInformation copy$default(SenderDisplayInformation senderDisplayInformation, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = senderDisplayInformation.heading;
        }
        if ((i2 & 2) != 0) {
            str2 = senderDisplayInformation.displayMessage;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = senderDisplayInformation.ctaText;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = senderDisplayInformation.deeplinkType;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = senderDisplayInformation.cta;
        }
        return senderDisplayInformation.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.heading;
    }

    public final String component2() {
        return this.displayMessage;
    }

    public final String component3() {
        return this.ctaText;
    }

    public final String component4() {
        return this.deeplinkType;
    }

    public final String component5() {
        return this.cta;
    }

    public final SenderDisplayInformation copy(String str, String str2, String str3, String str4, String str5) {
        return new SenderDisplayInformation(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SenderDisplayInformation)) {
            return false;
        }
        SenderDisplayInformation senderDisplayInformation = (SenderDisplayInformation) obj;
        return k.a((Object) this.heading, (Object) senderDisplayInformation.heading) && k.a((Object) this.displayMessage, (Object) senderDisplayInformation.displayMessage) && k.a((Object) this.ctaText, (Object) senderDisplayInformation.ctaText) && k.a((Object) this.deeplinkType, (Object) senderDisplayInformation.deeplinkType) && k.a((Object) this.cta, (Object) senderDisplayInformation.cta);
    }

    public final int hashCode() {
        String str = this.heading;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.displayMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ctaText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.deeplinkType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.cta;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "SenderDisplayInformation(heading=" + this.heading + ", displayMessage=" + this.displayMessage + ", ctaText=" + this.ctaText + ", deeplinkType=" + this.deeplinkType + ", cta=" + this.cta + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getHeading() {
        return this.heading;
    }

    public final void setHeading(String str) {
        this.heading = str;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    public final void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public final String getCtaText() {
        return this.ctaText;
    }

    public final void setCtaText(String str) {
        this.ctaText = str;
    }

    public final String getDeeplinkType() {
        return this.deeplinkType;
    }

    public final void setDeeplinkType(String str) {
        this.deeplinkType = str;
    }

    public SenderDisplayInformation(String str, String str2, String str3, String str4, String str5) {
        this.heading = str;
        this.displayMessage = str2;
        this.ctaText = str3;
        this.deeplinkType = str4;
        this.cta = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SenderDisplayInformation(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.common.entity.p2p.SenderDisplayInformation.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getCta() {
        return this.cta;
    }

    public final void setCta(String str) {
        this.cta = str;
    }
}
