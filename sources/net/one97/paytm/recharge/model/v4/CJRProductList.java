package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRProductList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "metaInfo")
    private final CJRMetaInfo metaInfo;
    @b(a = "products")
    private final List<CJRProductsItem> products;

    public CJRProductList() {
        this((CJRMetaInfo) null, (List) null, 3, (g) null);
    }

    public static /* synthetic */ CJRProductList copy$default(CJRProductList cJRProductList, CJRMetaInfo cJRMetaInfo, List<CJRProductsItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRMetaInfo = cJRProductList.metaInfo;
        }
        if ((i2 & 2) != 0) {
            list = cJRProductList.products;
        }
        return cJRProductList.copy(cJRMetaInfo, list);
    }

    public final CJRMetaInfo component1() {
        return this.metaInfo;
    }

    public final List<CJRProductsItem> component2() {
        return this.products;
    }

    public final CJRProductList copy(CJRMetaInfo cJRMetaInfo, List<CJRProductsItem> list) {
        return new CJRProductList(cJRMetaInfo, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRProductList)) {
            return false;
        }
        CJRProductList cJRProductList = (CJRProductList) obj;
        return k.a((Object) this.metaInfo, (Object) cJRProductList.metaInfo) && k.a((Object) this.products, (Object) cJRProductList.products);
    }

    public final int hashCode() {
        CJRMetaInfo cJRMetaInfo = this.metaInfo;
        int i2 = 0;
        int hashCode = (cJRMetaInfo != null ? cJRMetaInfo.hashCode() : 0) * 31;
        List<CJRProductsItem> list = this.products;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRProductList(metaInfo=" + this.metaInfo + ", products=" + this.products + ")";
    }

    public final CJRMetaInfo getMetaInfo() {
        return this.metaInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRProductList(CJRMetaInfo cJRMetaInfo, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : cJRMetaInfo, (i2 & 2) != 0 ? null : list);
    }

    public final List<CJRProductsItem> getProducts() {
        return this.products;
    }

    public CJRProductList(CJRMetaInfo cJRMetaInfo, List<CJRProductsItem> list) {
        this.metaInfo = cJRMetaInfo;
        this.products = list;
    }
}
