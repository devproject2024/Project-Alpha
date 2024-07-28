package net.one97.paytm.paymentsBank.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class StoreFrontPage extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "id")
    private final int viewId;
    @b(a = "views")
    private final List<StoreFrontViews> views;

    public static /* synthetic */ StoreFrontPage copy$default(StoreFrontPage storeFrontPage, List<StoreFrontViews> list, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = storeFrontPage.views;
        }
        if ((i3 & 2) != 0) {
            i2 = storeFrontPage.viewId;
        }
        return storeFrontPage.copy(list, i2);
    }

    public final List<StoreFrontViews> component1() {
        return this.views;
    }

    public final int component2() {
        return this.viewId;
    }

    public final StoreFrontPage copy(List<StoreFrontViews> list, int i2) {
        return new StoreFrontPage(list, i2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof StoreFrontPage) {
                StoreFrontPage storeFrontPage = (StoreFrontPage) obj;
                if (k.a((Object) this.views, (Object) storeFrontPage.views)) {
                    if (this.viewId == storeFrontPage.viewId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List<StoreFrontViews> list = this.views;
        return ((list != null ? list.hashCode() : 0) * 31) + this.viewId;
    }

    public final String toString() {
        return "StoreFrontPage(views=" + this.views + ", viewId=" + this.viewId + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoreFrontPage(List list, int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? null : list, i2);
    }

    public final List<StoreFrontViews> getViews() {
        return this.views;
    }

    public final int getViewId() {
        return this.viewId;
    }

    public StoreFrontPage(List<StoreFrontViews> list, int i2) {
        this.views = list;
        this.viewId = i2;
    }
}
