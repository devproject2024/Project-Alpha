package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class UrlParams extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "method")
    private String method;
    @b(a = "url")
    private String url;

    public UrlParams() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ UrlParams copy$default(UrlParams urlParams, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = urlParams.method;
        }
        if ((i2 & 2) != 0) {
            str2 = urlParams.url;
        }
        return urlParams.copy(str, str2);
    }

    public final String component1() {
        return this.method;
    }

    public final String component2() {
        return this.url;
    }

    public final UrlParams copy(String str, String str2) {
        return new UrlParams(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UrlParams)) {
            return false;
        }
        UrlParams urlParams = (UrlParams) obj;
        return k.a((Object) this.method, (Object) urlParams.method) && k.a((Object) this.url, (Object) urlParams.url);
    }

    public final int hashCode() {
        String str = this.method;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "UrlParams(method=" + this.method + ", url=" + this.url + ")";
    }

    public UrlParams(String str, String str2) {
        this.method = str;
        this.url = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UrlParams(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
