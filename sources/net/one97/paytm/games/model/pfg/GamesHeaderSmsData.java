package net.one97.paytm.games.model.pfg;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class GamesHeaderSmsData {
    private String message;
    private String oemLink;
    private String template;
    private String text;

    public GamesHeaderSmsData() {
        this((String) null, (String) null, (String) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ GamesHeaderSmsData copy$default(GamesHeaderSmsData gamesHeaderSmsData, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gamesHeaderSmsData.text;
        }
        if ((i2 & 2) != 0) {
            str2 = gamesHeaderSmsData.template;
        }
        if ((i2 & 4) != 0) {
            str3 = gamesHeaderSmsData.message;
        }
        if ((i2 & 8) != 0) {
            str4 = gamesHeaderSmsData.oemLink;
        }
        return gamesHeaderSmsData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.template;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.oemLink;
    }

    public final GamesHeaderSmsData copy(String str, String str2, String str3, String str4) {
        return new GamesHeaderSmsData(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GamesHeaderSmsData)) {
            return false;
        }
        GamesHeaderSmsData gamesHeaderSmsData = (GamesHeaderSmsData) obj;
        return k.a((Object) this.text, (Object) gamesHeaderSmsData.text) && k.a((Object) this.template, (Object) gamesHeaderSmsData.template) && k.a((Object) this.message, (Object) gamesHeaderSmsData.message) && k.a((Object) this.oemLink, (Object) gamesHeaderSmsData.oemLink);
    }

    public final int hashCode() {
        String str = this.text;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.template;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.message;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oemLink;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "GamesHeaderSmsData(text=" + this.text + ", template=" + this.template + ", message=" + this.message + ", oemLink=" + this.oemLink + ")";
    }

    public GamesHeaderSmsData(String str, String str2, String str3, String str4) {
        this.text = str;
        this.template = str2;
        this.message = str3;
        this.oemLink = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GamesHeaderSmsData(String str, String str2, String str3, String str4, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getOemLink() {
        return this.oemLink;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getText() {
        return this.text;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setOemLink(String str) {
        this.oemLink = str;
    }

    public final void setTemplate(String str) {
        this.template = str;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
