package com.paytm.android.chat.bean;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class TopRightIcon {
    private String deepLink;
    private String iconUrl;

    public static /* synthetic */ TopRightIcon copy$default(TopRightIcon topRightIcon, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = topRightIcon.iconUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = topRightIcon.deepLink;
        }
        return topRightIcon.copy(str, str2);
    }

    public final String component1() {
        return this.iconUrl;
    }

    public final String component2() {
        return this.deepLink;
    }

    public final TopRightIcon copy(String str, String str2) {
        k.c(str, SDKConstants.ICON_URL);
        k.c(str2, "deepLink");
        return new TopRightIcon(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopRightIcon)) {
            return false;
        }
        TopRightIcon topRightIcon = (TopRightIcon) obj;
        return k.a((Object) this.iconUrl, (Object) topRightIcon.iconUrl) && k.a((Object) this.deepLink, (Object) topRightIcon.deepLink);
    }

    public final int hashCode() {
        String str = this.iconUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deepLink;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TopRightIcon(iconUrl=" + this.iconUrl + ", deepLink=" + this.deepLink + ")";
    }

    public TopRightIcon(String str, String str2) {
        k.c(str, SDKConstants.ICON_URL);
        k.c(str2, "deepLink");
        this.iconUrl = str;
        this.deepLink = str2;
    }

    public final String getDeepLink() {
        return this.deepLink;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setDeepLink(String str) {
        k.c(str, "<set-?>");
        this.deepLink = str;
    }

    public final void setIconUrl(String str) {
        k.c(str, "<set-?>");
        this.iconUrl = str;
    }
}
