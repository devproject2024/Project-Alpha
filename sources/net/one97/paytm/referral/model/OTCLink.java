package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class OTCLink extends IJRPaytmDataModel {
    @b(a = "link")
    private String link;
    @b(a = "short_url")
    private String shortUrl;

    public OTCLink() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ OTCLink copy$default(OTCLink oTCLink, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = oTCLink.link;
        }
        if ((i2 & 2) != 0) {
            str2 = oTCLink.shortUrl;
        }
        return oTCLink.copy(str, str2);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.shortUrl;
    }

    public final OTCLink copy(String str, String str2) {
        k.c(str, "link");
        k.c(str2, "shortUrl");
        return new OTCLink(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OTCLink)) {
            return false;
        }
        OTCLink oTCLink = (OTCLink) obj;
        return k.a((Object) this.link, (Object) oTCLink.link) && k.a((Object) this.shortUrl, (Object) oTCLink.shortUrl);
    }

    public final int hashCode() {
        String str = this.link;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.shortUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "OTCLink(link=" + this.link + ", shortUrl=" + this.shortUrl + ")";
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        k.c(str, "<set-?>");
        this.link = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OTCLink(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getShortUrl() {
        return this.shortUrl;
    }

    public final void setShortUrl(String str) {
        k.c(str, "<set-?>");
        this.shortUrl = str;
    }

    public OTCLink(String str, String str2) {
        k.c(str, "link");
        k.c(str2, "shortUrl");
        this.link = str;
        this.shortUrl = str2;
    }
}
