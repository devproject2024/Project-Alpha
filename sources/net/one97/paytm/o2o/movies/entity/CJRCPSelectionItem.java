package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRCPSelectionItem implements Serializable {
    @b(a = "cta_text")
    private String ctaText;
    @b(a = "description")
    private String description;
    @b(a = "price")
    private String price;
    @b(a = "rank")
    private Integer rank;
    private boolean selected;
    @b(a = "small_desc")
    private String smallDesc;
    @b(a = "small_lable")
    private String smallLabel;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;
    private boolean userSelected;

    public static /* synthetic */ CJRCPSelectionItem copy$default(CJRCPSelectionItem cJRCPSelectionItem, boolean z, boolean z2, String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        CJRCPSelectionItem cJRCPSelectionItem2 = cJRCPSelectionItem;
        int i3 = i2;
        return cJRCPSelectionItem.copy((i3 & 1) != 0 ? cJRCPSelectionItem2.selected : z, (i3 & 2) != 0 ? cJRCPSelectionItem2.userSelected : z2, (i3 & 4) != 0 ? cJRCPSelectionItem2.type : str, (i3 & 8) != 0 ? cJRCPSelectionItem2.rank : num, (i3 & 16) != 0 ? cJRCPSelectionItem2.title : str2, (i3 & 32) != 0 ? cJRCPSelectionItem2.description : str3, (i3 & 64) != 0 ? cJRCPSelectionItem2.smallLabel : str4, (i3 & 128) != 0 ? cJRCPSelectionItem2.smallDesc : str5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRCPSelectionItem2.price : str6, (i3 & 512) != 0 ? cJRCPSelectionItem2.ctaText : str7);
    }

    public final boolean component1() {
        return this.selected;
    }

    public final String component10() {
        return this.ctaText;
    }

    public final boolean component2() {
        return this.userSelected;
    }

    public final String component3() {
        return this.type;
    }

    public final Integer component4() {
        return this.rank;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.smallLabel;
    }

    public final String component8() {
        return this.smallDesc;
    }

    public final String component9() {
        return this.price;
    }

    public final CJRCPSelectionItem copy(boolean z, boolean z2, String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new CJRCPSelectionItem(z, z2, str, num, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCPSelectionItem)) {
            return false;
        }
        CJRCPSelectionItem cJRCPSelectionItem = (CJRCPSelectionItem) obj;
        return this.selected == cJRCPSelectionItem.selected && this.userSelected == cJRCPSelectionItem.userSelected && k.a((Object) this.type, (Object) cJRCPSelectionItem.type) && k.a((Object) this.rank, (Object) cJRCPSelectionItem.rank) && k.a((Object) this.title, (Object) cJRCPSelectionItem.title) && k.a((Object) this.description, (Object) cJRCPSelectionItem.description) && k.a((Object) this.smallLabel, (Object) cJRCPSelectionItem.smallLabel) && k.a((Object) this.smallDesc, (Object) cJRCPSelectionItem.smallDesc) && k.a((Object) this.price, (Object) cJRCPSelectionItem.price) && k.a((Object) this.ctaText, (Object) cJRCPSelectionItem.ctaText);
    }

    public final int hashCode() {
        boolean z = this.selected;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z3 = this.userSelected;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        String str = this.type;
        int i4 = 0;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.rank;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.smallLabel;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.smallDesc;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.price;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.ctaText;
        if (str7 != null) {
            i4 = str7.hashCode();
        }
        return hashCode7 + i4;
    }

    public final String toString() {
        return "CJRCPSelectionItem(selected=" + this.selected + ", userSelected=" + this.userSelected + ", type=" + this.type + ", rank=" + this.rank + ", title=" + this.title + ", description=" + this.description + ", smallLabel=" + this.smallLabel + ", smallDesc=" + this.smallDesc + ", price=" + this.price + ", ctaText=" + this.ctaText + ")";
    }

    public CJRCPSelectionItem(boolean z, boolean z2, String str, Integer num, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.selected = z;
        this.userSelected = z2;
        this.type = str;
        this.rank = num;
        this.title = str2;
        this.description = str3;
        this.smallLabel = str4;
        this.smallDesc = str5;
        this.price = str6;
        this.ctaText = str7;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final void setSelected(boolean z) {
        this.selected = z;
    }

    public final boolean getUserSelected() {
        return this.userSelected;
    }

    public final void setUserSelected(boolean z) {
        this.userSelected = z;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final Integer getRank() {
        return this.rank;
    }

    public final void setRank(Integer num) {
        this.rank = num;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final String getSmallLabel() {
        return this.smallLabel;
    }

    public final void setSmallLabel(String str) {
        this.smallLabel = str;
    }

    public final String getSmallDesc() {
        return this.smallDesc;
    }

    public final void setSmallDesc(String str) {
        this.smallDesc = str;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final String getCtaText() {
        return this.ctaText;
    }

    public final void setCtaText(String str) {
        this.ctaText = str;
    }
}
