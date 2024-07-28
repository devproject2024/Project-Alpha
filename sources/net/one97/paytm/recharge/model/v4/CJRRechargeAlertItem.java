package net.one97.paytm.recharge.model.v4;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRRechargeAlertItem {
    private final String buttonLabel;
    private final String buttonUrl;
    private final String description;
    private final String description1;
    private final String description2;
    private final String message;
    private final String rightImageUrl;
    private final String title;

    public CJRRechargeAlertItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ CJRRechargeAlertItem copy$default(CJRRechargeAlertItem cJRRechargeAlertItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        CJRRechargeAlertItem cJRRechargeAlertItem2 = cJRRechargeAlertItem;
        int i3 = i2;
        return cJRRechargeAlertItem.copy((i3 & 1) != 0 ? cJRRechargeAlertItem2.title : str, (i3 & 2) != 0 ? cJRRechargeAlertItem2.message : str2, (i3 & 4) != 0 ? cJRRechargeAlertItem2.description : str3, (i3 & 8) != 0 ? cJRRechargeAlertItem2.description1 : str4, (i3 & 16) != 0 ? cJRRechargeAlertItem2.description2 : str5, (i3 & 32) != 0 ? cJRRechargeAlertItem2.buttonLabel : str6, (i3 & 64) != 0 ? cJRRechargeAlertItem2.buttonUrl : str7, (i3 & 128) != 0 ? cJRRechargeAlertItem2.rightImageUrl : str8);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.description1;
    }

    public final String component5() {
        return this.description2;
    }

    public final String component6() {
        return this.buttonLabel;
    }

    public final String component7() {
        return this.buttonUrl;
    }

    public final String component8() {
        return this.rightImageUrl;
    }

    public final CJRRechargeAlertItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new CJRRechargeAlertItem(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRRechargeAlertItem)) {
            return false;
        }
        CJRRechargeAlertItem cJRRechargeAlertItem = (CJRRechargeAlertItem) obj;
        return k.a((Object) this.title, (Object) cJRRechargeAlertItem.title) && k.a((Object) this.message, (Object) cJRRechargeAlertItem.message) && k.a((Object) this.description, (Object) cJRRechargeAlertItem.description) && k.a((Object) this.description1, (Object) cJRRechargeAlertItem.description1) && k.a((Object) this.description2, (Object) cJRRechargeAlertItem.description2) && k.a((Object) this.buttonLabel, (Object) cJRRechargeAlertItem.buttonLabel) && k.a((Object) this.buttonUrl, (Object) cJRRechargeAlertItem.buttonUrl) && k.a((Object) this.rightImageUrl, (Object) cJRRechargeAlertItem.rightImageUrl);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.description1;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.description2;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.buttonLabel;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.buttonUrl;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.rightImageUrl;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "CJRRechargeAlertItem(title=" + this.title + ", message=" + this.message + ", description=" + this.description + ", description1=" + this.description1 + ", description2=" + this.description2 + ", buttonLabel=" + this.buttonLabel + ", buttonUrl=" + this.buttonUrl + ", rightImageUrl=" + this.rightImageUrl + ")";
    }

    public CJRRechargeAlertItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.title = str;
        this.message = str2;
        this.description = str3;
        this.description1 = str4;
        this.description2 = str5;
        this.buttonLabel = str6;
        this.buttonUrl = str7;
        this.rightImageUrl = str8;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDescription1() {
        return this.description1;
    }

    public final String getDescription2() {
        return this.description2;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final String getButtonUrl() {
        return this.buttonUrl;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRRechargeAlertItem(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRRechargeAlertItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getRightImageUrl() {
        return this.rightImageUrl;
    }
}
