package com.paytm.android.chat.network.response;

import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class HomeChips {
    private String action;
    private ArrayList<String> filter;
    private final String image_url;
    private final String name;
    private boolean showDot;
    private String url;

    public static /* synthetic */ HomeChips copy$default(HomeChips homeChips, String str, String str2, ArrayList<String> arrayList, String str3, String str4, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = homeChips.image_url;
        }
        if ((i2 & 2) != 0) {
            str2 = homeChips.name;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            arrayList = homeChips.filter;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i2 & 8) != 0) {
            str3 = homeChips.action;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = homeChips.url;
        }
        String str7 = str4;
        if ((i2 & 32) != 0) {
            z = homeChips.showDot;
        }
        return homeChips.copy(str, str5, arrayList2, str6, str7, z);
    }

    public final String component1() {
        return this.image_url;
    }

    public final String component2() {
        return this.name;
    }

    public final ArrayList<String> component3() {
        return this.filter;
    }

    public final String component4() {
        return this.action;
    }

    public final String component5() {
        return this.url;
    }

    public final boolean component6() {
        return this.showDot;
    }

    public final HomeChips copy(String str, String str2, ArrayList<String> arrayList, String str3, String str4, boolean z) {
        k.c(str, "image_url");
        k.c(str2, "name");
        k.c(arrayList, StringSet.filter);
        k.c(str3, "action");
        k.c(str4, "url");
        return new HomeChips(str, str2, arrayList, str3, str4, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeChips)) {
            return false;
        }
        HomeChips homeChips = (HomeChips) obj;
        return k.a((Object) this.image_url, (Object) homeChips.image_url) && k.a((Object) this.name, (Object) homeChips.name) && k.a((Object) this.filter, (Object) homeChips.filter) && k.a((Object) this.action, (Object) homeChips.action) && k.a((Object) this.url, (Object) homeChips.url) && this.showDot == homeChips.showDot;
    }

    public final int hashCode() {
        String str = this.image_url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.filter;
        int hashCode3 = (hashCode2 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str3 = this.action;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = (hashCode4 + i2) * 31;
        boolean z = this.showDot;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "HomeChips(image_url=" + this.image_url + ", name=" + this.name + ", filter=" + this.filter + ", action=" + this.action + ", url=" + this.url + ", showDot=" + this.showDot + ")";
    }

    public HomeChips(String str, String str2, ArrayList<String> arrayList, String str3, String str4, boolean z) {
        k.c(str, "image_url");
        k.c(str2, "name");
        k.c(arrayList, StringSet.filter);
        k.c(str3, "action");
        k.c(str4, "url");
        this.image_url = str;
        this.name = str2;
        this.filter = arrayList;
        this.action = str3;
        this.url = str4;
        this.showDot = z;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<String> getFilter() {
        return this.filter;
    }

    public final void setFilter(ArrayList<String> arrayList) {
        k.c(arrayList, "<set-?>");
        this.filter = arrayList;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        k.c(str, "<set-?>");
        this.action = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        k.c(str, "<set-?>");
        this.url = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeChips(String str, String str2, ArrayList arrayList, String str3, String str4, boolean z, int i2, g gVar) {
        this(str, str2, arrayList, str3, str4, (i2 & 32) != 0 ? false : z);
    }

    public final boolean getShowDot() {
        return this.showDot;
    }

    public final void setShowDot(boolean z) {
        this.showDot = z;
    }
}
