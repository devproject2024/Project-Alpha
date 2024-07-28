package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPromoGratification extends IJRPaytmDataModel {
    @b(a = "icon")
    private String icon;
    @b(a = "redemptionType")
    private String redemptionType;
    @b(a = "saving")
    private Integer saving;
    @b(a = "subRedemptionType")
    private String subRedemptionType;
    @b(a = "text")
    private String text;
    @b(a = "title")
    private String title;

    public CJRPromoGratification() {
        this((String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, 63, (g) null);
    }

    public static /* synthetic */ CJRPromoGratification copy$default(CJRPromoGratification cJRPromoGratification, String str, String str2, String str3, Integer num, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRPromoGratification.icon;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRPromoGratification.title;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = cJRPromoGratification.text;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            num = cJRPromoGratification.saving;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            str4 = cJRPromoGratification.redemptionType;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            str5 = cJRPromoGratification.subRedemptionType;
        }
        return cJRPromoGratification.copy(str, str6, str7, num2, str8, str5);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.text;
    }

    public final Integer component4() {
        return this.saving;
    }

    public final String component5() {
        return this.redemptionType;
    }

    public final String component6() {
        return this.subRedemptionType;
    }

    public final CJRPromoGratification copy(String str, String str2, String str3, Integer num, String str4, String str5) {
        return new CJRPromoGratification(str, str2, str3, num, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRPromoGratification)) {
            return false;
        }
        CJRPromoGratification cJRPromoGratification = (CJRPromoGratification) obj;
        return k.a((Object) this.icon, (Object) cJRPromoGratification.icon) && k.a((Object) this.title, (Object) cJRPromoGratification.title) && k.a((Object) this.text, (Object) cJRPromoGratification.text) && k.a((Object) this.saving, (Object) cJRPromoGratification.saving) && k.a((Object) this.redemptionType, (Object) cJRPromoGratification.redemptionType) && k.a((Object) this.subRedemptionType, (Object) cJRPromoGratification.subRedemptionType);
    }

    public final int hashCode() {
        String str = this.icon;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.saving;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.redemptionType;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.subRedemptionType;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CJRPromoGratification(icon=" + this.icon + ", title=" + this.title + ", text=" + this.text + ", saving=" + this.saving + ", redemptionType=" + this.redemptionType + ", subRedemptionType=" + this.subRedemptionType + ")";
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
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

    public final Integer getSaving() {
        return this.saving;
    }

    public final void setSaving(Integer num) {
        this.saving = num;
    }

    public final String getRedemptionType() {
        return this.redemptionType;
    }

    public final void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRPromoGratification(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Integer r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.g.b.g r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.CJRPromoGratification.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getSubRedemptionType() {
        return this.subRedemptionType;
    }

    public final void setSubRedemptionType(String str) {
        this.subRedemptionType = str;
    }

    public CJRPromoGratification(String str, String str2, String str3, Integer num, String str4, String str5) {
        this.icon = str;
        this.title = str2;
        this.text = str3;
        this.saving = num;
        this.redemptionType = str4;
        this.subRedemptionType = str5;
    }
}
