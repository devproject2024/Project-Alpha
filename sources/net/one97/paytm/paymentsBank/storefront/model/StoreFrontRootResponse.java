package net.one97.paytm.paymentsBank.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class StoreFrontRootResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "page")
    private final List<StoreFrontPage> page;

    public StoreFrontRootResponse() {
        this((List) null, 1, (g) null);
    }

    public static /* synthetic */ StoreFrontRootResponse copy$default(StoreFrontRootResponse storeFrontRootResponse, List<StoreFrontPage> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = storeFrontRootResponse.page;
        }
        return storeFrontRootResponse.copy(list);
    }

    public final List<StoreFrontPage> component1() {
        return this.page;
    }

    public final StoreFrontRootResponse copy(List<StoreFrontPage> list) {
        return new StoreFrontRootResponse(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof StoreFrontRootResponse) && k.a((Object) this.page, (Object) ((StoreFrontRootResponse) obj).page);
        }
        return true;
    }

    public final int hashCode() {
        List<StoreFrontPage> list = this.page;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "StoreFrontRootResponse(page=" + this.page + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoreFrontRootResponse(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<StoreFrontPage> getPage() {
        return this.page;
    }

    public StoreFrontRootResponse(List<StoreFrontPage> list) {
        this.page = list;
    }
}
