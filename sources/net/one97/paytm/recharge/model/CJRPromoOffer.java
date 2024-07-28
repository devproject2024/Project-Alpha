package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPromoOffer extends IJRPaytmDataModel {
    @b(a = "icon")
    private String icon;
    @b(a = "pdpIcon")
    private String pdpIcon;
    @b(a = "selectedText")
    private String selectedText;
    @b(a = "text")
    private String text;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;

    public CJRPromoOffer() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ CJRPromoOffer copy$default(CJRPromoOffer cJRPromoOffer, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRPromoOffer.title;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRPromoOffer.text;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = cJRPromoOffer.selectedText;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = cJRPromoOffer.icon;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = cJRPromoOffer.pdpIcon;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = cJRPromoOffer.type;
        }
        return cJRPromoOffer.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.selectedText;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.pdpIcon;
    }

    public final String component6() {
        return this.type;
    }

    public final CJRPromoOffer copy(String str, String str2, String str3, String str4, String str5, String str6) {
        return new CJRPromoOffer(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRPromoOffer)) {
            return false;
        }
        CJRPromoOffer cJRPromoOffer = (CJRPromoOffer) obj;
        return k.a((Object) this.title, (Object) cJRPromoOffer.title) && k.a((Object) this.text, (Object) cJRPromoOffer.text) && k.a((Object) this.selectedText, (Object) cJRPromoOffer.selectedText) && k.a((Object) this.icon, (Object) cJRPromoOffer.icon) && k.a((Object) this.pdpIcon, (Object) cJRPromoOffer.pdpIcon) && k.a((Object) this.type, (Object) cJRPromoOffer.type);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.selectedText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.icon;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.pdpIcon;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.type;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CJRPromoOffer(title=" + this.title + ", text=" + this.text + ", selectedText=" + this.selectedText + ", icon=" + this.icon + ", pdpIcon=" + this.pdpIcon + ", type=" + this.type + ")";
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getSelectedText() {
        return this.selectedText;
    }

    public final void setSelectedText(String str) {
        this.selectedText = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getPdpIcon() {
        return this.pdpIcon;
    }

    public final void setPdpIcon(String str) {
        this.pdpIcon = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRPromoOffer(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.CJRPromoOffer.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public CJRPromoOffer(String str, String str2, String str3, String str4, String str5, String str6) {
        this.title = str;
        this.text = str2;
        this.selectedText = str3;
        this.icon = str4;
        this.pdpIcon = str5;
        this.type = str6;
    }
}
