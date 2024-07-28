package com.business.merchant_payments.payment.model;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class GridItem {
    public String content;
    public String deeplink;
    public String iconSrc;

    public GridItem() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ GridItem copy$default(GridItem gridItem, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gridItem.iconSrc;
        }
        if ((i2 & 2) != 0) {
            str2 = gridItem.content;
        }
        if ((i2 & 4) != 0) {
            str3 = gridItem.deeplink;
        }
        return gridItem.copy(str, str2, str3);
    }

    public final String component1() {
        return this.iconSrc;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.deeplink;
    }

    public final GridItem copy(String str, String str2, String str3) {
        k.d(str, "iconSrc");
        k.d(str2, "content");
        k.d(str3, "deeplink");
        return new GridItem(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GridItem)) {
            return false;
        }
        GridItem gridItem = (GridItem) obj;
        return k.a((Object) this.iconSrc, (Object) gridItem.iconSrc) && k.a((Object) this.content, (Object) gridItem.content) && k.a((Object) this.deeplink, (Object) gridItem.deeplink);
    }

    public final int hashCode() {
        String str = this.iconSrc;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deeplink;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "GridItem(iconSrc=" + this.iconSrc + ", content=" + this.content + ", deeplink=" + this.deeplink + ")";
    }

    public GridItem(String str, String str2, String str3) {
        k.d(str, "iconSrc");
        k.d(str2, "content");
        k.d(str3, "deeplink");
        this.iconSrc = str;
        this.content = str2;
        this.deeplink = str3;
    }

    public final String getIconSrc() {
        return this.iconSrc;
    }

    public final void setIconSrc(String str) {
        k.d(str, "<set-?>");
        this.iconSrc = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        k.d(str, "<set-?>");
        this.content = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridItem(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3);
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        k.d(str, "<set-?>");
        this.deeplink = str;
    }
}
