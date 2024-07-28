package com.paytm.android.chat.bean;

import kotlin.g.b.k;

public final class UiInfo {
    private final TopRightIcon topRightIcon;

    public static /* synthetic */ UiInfo copy$default(UiInfo uiInfo, TopRightIcon topRightIcon2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            topRightIcon2 = uiInfo.topRightIcon;
        }
        return uiInfo.copy(topRightIcon2);
    }

    public final TopRightIcon component1() {
        return this.topRightIcon;
    }

    public final UiInfo copy(TopRightIcon topRightIcon2) {
        k.c(topRightIcon2, "topRightIcon");
        return new UiInfo(topRightIcon2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof UiInfo) && k.a((Object) this.topRightIcon, (Object) ((UiInfo) obj).topRightIcon);
        }
        return true;
    }

    public final int hashCode() {
        TopRightIcon topRightIcon2 = this.topRightIcon;
        if (topRightIcon2 != null) {
            return topRightIcon2.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "UiInfo(topRightIcon=" + this.topRightIcon + ")";
    }

    public UiInfo(TopRightIcon topRightIcon2) {
        k.c(topRightIcon2, "topRightIcon");
        this.topRightIcon = topRightIcon2;
    }

    public final TopRightIcon getTopRightIcon() {
        return this.topRightIcon;
    }
}
