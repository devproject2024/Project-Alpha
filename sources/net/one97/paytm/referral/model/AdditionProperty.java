package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class AdditionProperty extends IJRPaytmDataModel {
    private String link;
    @b(a = "short_url")
    private String shortUrl;

    public static /* synthetic */ AdditionProperty copy$default(AdditionProperty additionProperty, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = additionProperty.link;
        }
        if ((i2 & 2) != 0) {
            str2 = additionProperty.shortUrl;
        }
        return additionProperty.copy(str, str2);
    }

    public final String component1() {
        return this.link;
    }

    public final String component2() {
        return this.shortUrl;
    }

    public final AdditionProperty copy(String str, String str2) {
        return new AdditionProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdditionProperty)) {
            return false;
        }
        AdditionProperty additionProperty = (AdditionProperty) obj;
        return k.a((Object) this.link, (Object) additionProperty.link) && k.a((Object) this.shortUrl, (Object) additionProperty.shortUrl);
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
        return "AdditionProperty(link=" + this.link + ", shortUrl=" + this.shortUrl + ")";
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        this.link = str;
    }

    public AdditionProperty(String str, String str2) {
        this.link = str;
        this.shortUrl = str2;
    }

    public final String getShortUrl() {
        return this.shortUrl;
    }

    public final void setShortUrl(String str) {
        this.shortUrl = str;
    }
}
