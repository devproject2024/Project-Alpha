package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class RepeatPayment extends IJRDataModel {
    @b(a = "name")
    private String name;
    @b(a = "url")
    private String url;

    public RepeatPayment() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ RepeatPayment copy$default(RepeatPayment repeatPayment, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = repeatPayment.name;
        }
        if ((i2 & 2) != 0) {
            str2 = repeatPayment.url;
        }
        return repeatPayment.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.url;
    }

    public final RepeatPayment copy(String str, String str2) {
        return new RepeatPayment(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RepeatPayment)) {
            return false;
        }
        RepeatPayment repeatPayment = (RepeatPayment) obj;
        return k.a((Object) this.name, (Object) repeatPayment.name) && k.a((Object) this.url, (Object) repeatPayment.url);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "RepeatPayment(name=" + this.name + ", url=" + this.url + ")";
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RepeatPayment(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public RepeatPayment(String str, String str2) {
        this.name = str;
        this.url = str2;
    }
}
