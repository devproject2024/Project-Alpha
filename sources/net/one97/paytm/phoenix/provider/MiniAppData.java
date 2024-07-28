package net.one97.paytm.phoenix.provider;

import kotlin.g.b.k;

public final class MiniAppData {
    private final String category;
    private final String imgUrl;
    private final String name;
    private final String url;

    public static /* synthetic */ MiniAppData copy$default(MiniAppData miniAppData, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = miniAppData.url;
        }
        if ((i2 & 2) != 0) {
            str2 = miniAppData.name;
        }
        if ((i2 & 4) != 0) {
            str3 = miniAppData.imgUrl;
        }
        if ((i2 & 8) != 0) {
            str4 = miniAppData.category;
        }
        return miniAppData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.imgUrl;
    }

    public final String component4() {
        return this.category;
    }

    public final MiniAppData copy(String str, String str2, String str3, String str4) {
        k.c(str, "url");
        k.c(str2, "name");
        k.c(str3, "imgUrl");
        k.c(str4, "category");
        return new MiniAppData(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniAppData)) {
            return false;
        }
        MiniAppData miniAppData = (MiniAppData) obj;
        return k.a((Object) this.url, (Object) miniAppData.url) && k.a((Object) this.name, (Object) miniAppData.name) && k.a((Object) this.imgUrl, (Object) miniAppData.imgUrl) && k.a((Object) this.category, (Object) miniAppData.category);
    }

    public final int hashCode() {
        String str = this.url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.imgUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.category;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MiniAppData(url=" + this.url + ", name=" + this.name + ", imgUrl=" + this.imgUrl + ", category=" + this.category + ")";
    }

    public MiniAppData(String str, String str2, String str3, String str4) {
        k.c(str, "url");
        k.c(str2, "name");
        k.c(str3, "imgUrl");
        k.c(str4, "category");
        this.url = str;
        this.name = str2;
        this.imgUrl = str3;
        this.category = str4;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }
}
