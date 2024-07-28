package net.one97.paytm.common.entity.movies.search;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMovieSummaryCatalogV2View implements IJRDataModel {
    @b(a = "items")
    private List<CJRMovieSummaryCatalogV2Items> items;

    public CJRMovieSummaryCatalogV2View(List<CJRMovieSummaryCatalogV2Items> list) {
        this.items = list;
    }

    public final List<CJRMovieSummaryCatalogV2Items> getItems() {
        return this.items;
    }

    public final void setItems(List<CJRMovieSummaryCatalogV2Items> list) {
        this.items = list;
    }
}
