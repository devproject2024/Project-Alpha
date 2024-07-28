package net.one97.paytm.paymentsBank.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class StoreFrontViews extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "items")
    private final List<StoreFrontItem> items;
    @b(a = "title")
    private final String title;

    public StoreFrontViews() {
        this((String) null, (List) null, 3, (g) null);
    }

    public static /* synthetic */ StoreFrontViews copy$default(StoreFrontViews storeFrontViews, String str, List<StoreFrontItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = storeFrontViews.title;
        }
        if ((i2 & 2) != 0) {
            list = storeFrontViews.items;
        }
        return storeFrontViews.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<StoreFrontItem> component2() {
        return this.items;
    }

    public final StoreFrontViews copy(String str, List<StoreFrontItem> list) {
        return new StoreFrontViews(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoreFrontViews)) {
            return false;
        }
        StoreFrontViews storeFrontViews = (StoreFrontViews) obj;
        return k.a((Object) this.title, (Object) storeFrontViews.title) && k.a((Object) this.items, (Object) storeFrontViews.items);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<StoreFrontItem> list = this.items;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "StoreFrontViews(title=" + this.title + ", items=" + this.items + ")";
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoreFrontViews(String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list);
    }

    public final List<StoreFrontItem> getItems() {
        return this.items;
    }

    public StoreFrontViews(String str, List<StoreFrontItem> list) {
        this.title = str;
        this.items = list;
    }
}
