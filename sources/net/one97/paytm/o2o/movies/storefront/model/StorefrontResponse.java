package net.one97.paytm.o2o.movies.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class StorefrontResponse extends IJRPaytmDataModel {
    @b(a = "page")
    private List<Page> page;

    public final List<Page> getPage() {
        return this.page;
    }

    public final void setPage(List<Page> list) {
        this.page = list;
    }
}
