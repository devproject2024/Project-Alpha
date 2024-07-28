package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRHomePageItemCTA implements IJRDataModel {
    @b(a = "aligned")
    private final String aligned;
    @b(a = "label")
    private final String label;
    @b(a = "url")
    private final String url;
    @b(a = "url_type")
    private final String url_type;

    public static /* synthetic */ CJRHomePageItemCTA copy$default(CJRHomePageItemCTA cJRHomePageItemCTA, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRHomePageItemCTA.label;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRHomePageItemCTA.url;
        }
        if ((i2 & 4) != 0) {
            str3 = cJRHomePageItemCTA.aligned;
        }
        if ((i2 & 8) != 0) {
            str4 = cJRHomePageItemCTA.url_type;
        }
        return cJRHomePageItemCTA.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.label;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.aligned;
    }

    public final String component4() {
        return this.url_type;
    }

    public final CJRHomePageItemCTA copy(String str, String str2, String str3, String str4) {
        k.c(str, "label");
        k.c(str2, "url");
        k.c(str3, "aligned");
        k.c(str4, "url_type");
        return new CJRHomePageItemCTA(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRHomePageItemCTA)) {
            return false;
        }
        CJRHomePageItemCTA cJRHomePageItemCTA = (CJRHomePageItemCTA) obj;
        return k.a((Object) this.label, (Object) cJRHomePageItemCTA.label) && k.a((Object) this.url, (Object) cJRHomePageItemCTA.url) && k.a((Object) this.aligned, (Object) cJRHomePageItemCTA.aligned) && k.a((Object) this.url_type, (Object) cJRHomePageItemCTA.url_type);
    }

    public final int hashCode() {
        String str = this.label;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.aligned;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.url_type;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRHomePageItemCTA(label=" + this.label + ", url=" + this.url + ", aligned=" + this.aligned + ", url_type=" + this.url_type + ")";
    }

    public CJRHomePageItemCTA(String str, String str2, String str3, String str4) {
        k.c(str, "label");
        k.c(str2, "url");
        k.c(str3, "aligned");
        k.c(str4, "url_type");
        this.label = str;
        this.url = str2;
        this.aligned = str3;
        this.url_type = str4;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getAligned() {
        return this.aligned;
    }

    public final String getUrl_type() {
        return this.url_type;
    }
}
