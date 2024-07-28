package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRGroupings extends IJRPaytmDataModel {
    @b(a = "aggKey")
    private final String aggKey;
    @b(a = "aggs")
    private final List<CJRAggsItem> aggs;

    public CJRGroupings() {
        this((String) null, (List) null, 3, (g) null);
    }

    public static /* synthetic */ CJRGroupings copy$default(CJRGroupings cJRGroupings, String str, List<CJRAggsItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRGroupings.aggKey;
        }
        if ((i2 & 2) != 0) {
            list = cJRGroupings.aggs;
        }
        return cJRGroupings.copy(str, list);
    }

    public final String component1() {
        return this.aggKey;
    }

    public final List<CJRAggsItem> component2() {
        return this.aggs;
    }

    public final CJRGroupings copy(String str, List<CJRAggsItem> list) {
        return new CJRGroupings(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRGroupings)) {
            return false;
        }
        CJRGroupings cJRGroupings = (CJRGroupings) obj;
        return k.a((Object) this.aggKey, (Object) cJRGroupings.aggKey) && k.a((Object) this.aggs, (Object) cJRGroupings.aggs);
    }

    public final int hashCode() {
        String str = this.aggKey;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<CJRAggsItem> list = this.aggs;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "";
    }

    public final String getAggKey() {
        return this.aggKey;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRGroupings(String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list);
    }

    public final List<CJRAggsItem> getAggs() {
        return this.aggs;
    }

    public CJRGroupings(String str, List<CJRAggsItem> list) {
        this.aggKey = str;
        this.aggs = list;
    }
}
