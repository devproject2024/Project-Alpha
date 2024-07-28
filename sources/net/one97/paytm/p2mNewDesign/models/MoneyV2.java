package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class MoneyV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "currency")
    private String currency;
    @b(a = "value")
    private String value;

    public MoneyV2() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ MoneyV2 copy$default(MoneyV2 moneyV2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = moneyV2.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = moneyV2.value;
        }
        return moneyV2.copy(str, str2);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component2() {
        return this.value;
    }

    public final MoneyV2 copy(String str, String str2) {
        return new MoneyV2(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MoneyV2)) {
            return false;
        }
        MoneyV2 moneyV2 = (MoneyV2) obj;
        return k.a((Object) this.currency, (Object) moneyV2.currency) && k.a((Object) this.value, (Object) moneyV2.value);
    }

    public final int hashCode() {
        String str = this.currency;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "MoneyV2(currency=" + this.currency + ", value=" + this.value + ")";
    }

    public MoneyV2(String str, String str2) {
        this.currency = str;
        this.value = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MoneyV2(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
