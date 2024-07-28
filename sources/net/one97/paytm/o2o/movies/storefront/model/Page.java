package net.one97.paytm.o2o.movies.storefront.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class Page extends IJRPaytmDataModel {
    @b(a = "views")
    private List<Views> views;

    public final List<Views> getViews() {
        return this.views;
    }

    public final void setViews(List<Views> list) {
        this.views = list;
    }
}
