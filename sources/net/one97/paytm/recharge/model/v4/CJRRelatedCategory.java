package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRRelatedCategory implements IJRDataModel {
    @b(a = "selected")
    private Integer isSelected;
    @b(a = "label")
    private String label;
    @b(a = "type")
    private String type;
    @b(a = "url")
    private String url;
    @b(a = "value")
    private String value;

    public CJRRelatedCategory() {
        this((String) null, (String) null, (Integer) null, (String) null, (String) null, 31, (g) null);
    }

    private final Integer component3() {
        return this.isSelected;
    }

    public static /* synthetic */ CJRRelatedCategory copy$default(CJRRelatedCategory cJRRelatedCategory, String str, String str2, Integer num, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRRelatedCategory.label;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRRelatedCategory.url;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            num = cJRRelatedCategory.isSelected;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str3 = cJRRelatedCategory.type;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = cJRRelatedCategory.value;
        }
        return cJRRelatedCategory.copy(str, str5, num2, str6, str4);
    }

    public final String component1() {
        return this.label;
    }

    public final String component2() {
        return this.url;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.value;
    }

    public final CJRRelatedCategory copy(String str, String str2, Integer num, String str3, String str4) {
        return new CJRRelatedCategory(str, str2, num, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRRelatedCategory)) {
            return false;
        }
        CJRRelatedCategory cJRRelatedCategory = (CJRRelatedCategory) obj;
        return k.a((Object) this.label, (Object) cJRRelatedCategory.label) && k.a((Object) this.url, (Object) cJRRelatedCategory.url) && k.a((Object) this.isSelected, (Object) cJRRelatedCategory.isSelected) && k.a((Object) this.type, (Object) cJRRelatedCategory.type) && k.a((Object) this.value, (Object) cJRRelatedCategory.value);
    }

    public final int hashCode() {
        String str = this.label;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.isSelected;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.type;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.value;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CJRRelatedCategory(label=" + this.label + ", url=" + this.url + ", isSelected=" + this.isSelected + ", type=" + this.type + ", value=" + this.value + ")";
    }

    public CJRRelatedCategory(String str, String str2, Integer num, String str3, String str4) {
        this.label = str;
        this.url = str2;
        this.isSelected = num;
        this.type = str3;
        this.value = str4;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRRelatedCategory(java.lang.String r5, java.lang.String r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRRelatedCategory.<init>(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final boolean isSelected() {
        Integer num = this.isSelected;
        return num != null && num.intValue() == 1;
    }

    public final void setSelected(boolean z) {
        if (z) {
            this.isSelected = 1;
        } else {
            this.isSelected = 0;
        }
    }
}
