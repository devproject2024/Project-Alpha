package net.one97.paytm.common.entity.movies.search;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMovieSummaryCatalogV2Page implements IJRDataModel {
    @b(a = "id")
    private Integer id;
    @b(a = "layout")
    private String layout;
    @b(a = "views")
    private List<CJRMovieSummaryCatalogV2View> views;

    public CJRMovieSummaryCatalogV2Page(Integer num, String str, List<CJRMovieSummaryCatalogV2View> list) {
        this.id = num;
        this.layout = str;
        this.views = list;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final String getLayout() {
        return this.layout;
    }

    public final void setLayout(String str) {
        this.layout = str;
    }

    public final List<CJRMovieSummaryCatalogV2View> getViews() {
        return this.views;
    }

    public final void setViews(List<CJRMovieSummaryCatalogV2View> list) {
        this.views = list;
    }
}
