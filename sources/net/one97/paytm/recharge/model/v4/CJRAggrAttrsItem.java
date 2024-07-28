package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRAggrAttrsItem extends IJRPaytmDataModel {
    @b(a = "aggType")
    private final String aggType;
    @b(a = "value")
    private final String value;

    public CJRAggrAttrsItem() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRAggrAttrsItem copy$default(CJRAggrAttrsItem cJRAggrAttrsItem, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRAggrAttrsItem.aggType;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRAggrAttrsItem.value;
        }
        return cJRAggrAttrsItem.copy(str, str2);
    }

    public final String component1() {
        return this.aggType;
    }

    public final String component2() {
        return this.value;
    }

    public final CJRAggrAttrsItem copy(String str, String str2) {
        return new CJRAggrAttrsItem(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRAggrAttrsItem)) {
            return false;
        }
        CJRAggrAttrsItem cJRAggrAttrsItem = (CJRAggrAttrsItem) obj;
        return k.a((Object) this.aggType, (Object) cJRAggrAttrsItem.aggType) && k.a((Object) this.value, (Object) cJRAggrAttrsItem.value);
    }

    public final int hashCode() {
        String str = this.aggType;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRAggrAttrsItem(aggType=" + this.aggType + ", value=" + this.value + ")";
    }

    public final String getAggType() {
        return this.aggType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAggrAttrsItem(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getValue() {
        return this.value;
    }

    public CJRAggrAttrsItem(String str, String str2) {
        this.aggType = str;
        this.value = str2;
    }
}
