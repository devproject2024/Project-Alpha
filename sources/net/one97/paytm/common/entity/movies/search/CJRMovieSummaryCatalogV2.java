package net.one97.paytm.common.entity.movies.search;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMovieSummaryCatalogV2 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "page")
    private List<CJRMovieSummaryCatalogV2Page> page;

    public final List<CJRMovieSummaryCatalogV2Page> getPage() {
        return this.page;
    }

    public final void setPage(List<CJRMovieSummaryCatalogV2Page> list) {
        this.page = list;
    }
}
