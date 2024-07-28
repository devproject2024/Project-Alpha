package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class AccountBalanceV2 implements IJRDataModel {
    @b(a = "additionalProperties")
    private HashMap<String, Object> additionalProperties;
    @b(a = "currency")
    private String currency;
    @b(a = "value")
    private String value;

    public static /* synthetic */ AccountBalanceV2 copy$default(AccountBalanceV2 accountBalanceV2, String str, String str2, HashMap<String, Object> hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = accountBalanceV2.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = accountBalanceV2.value;
        }
        if ((i2 & 4) != 0) {
            hashMap = accountBalanceV2.additionalProperties;
        }
        return accountBalanceV2.copy(str, str2, hashMap);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component2() {
        return this.value;
    }

    public final HashMap<String, Object> component3() {
        return this.additionalProperties;
    }

    public final AccountBalanceV2 copy(String str, String str2, HashMap<String, Object> hashMap) {
        return new AccountBalanceV2(str, str2, hashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountBalanceV2)) {
            return false;
        }
        AccountBalanceV2 accountBalanceV2 = (AccountBalanceV2) obj;
        return k.a((Object) this.currency, (Object) accountBalanceV2.currency) && k.a((Object) this.value, (Object) accountBalanceV2.value) && k.a((Object) this.additionalProperties, (Object) accountBalanceV2.additionalProperties);
    }

    public final int hashCode() {
        String str = this.currency;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap = this.additionalProperties;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "AccountBalanceV2(currency=" + this.currency + ", value=" + this.value + ", additionalProperties=" + this.additionalProperties + ")";
    }

    public AccountBalanceV2(String str, String str2, HashMap<String, Object> hashMap) {
        this.currency = str;
        this.value = str2;
        this.additionalProperties = hashMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountBalanceV2(String str, String str2, HashMap hashMap, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, hashMap);
    }

    public final HashMap<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setAdditionalProperties(HashMap<String, Object> hashMap) {
        this.additionalProperties = hashMap;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
