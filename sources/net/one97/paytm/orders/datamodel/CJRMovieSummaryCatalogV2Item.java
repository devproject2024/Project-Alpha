package net.one97.paytm.orders.datamodel;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2;

public final class CJRMovieSummaryCatalogV2Item implements IJRDataModel {
    private CJRMovieSummaryCatalogV2 movieSummaryCatalog;

    public final CJRMovieSummaryCatalogV2 getMovieSummaryCatalog() {
        return this.movieSummaryCatalog;
    }

    public final void setMovieSummaryCatalog(CJRMovieSummaryCatalogV2 cJRMovieSummaryCatalogV2) {
        this.movieSummaryCatalog = cJRMovieSummaryCatalogV2;
    }
}
