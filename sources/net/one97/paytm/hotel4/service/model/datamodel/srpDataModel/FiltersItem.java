package net.one97.paytm.hotel4.service.model.datamodel.srpDataModel;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class FiltersItem {
    @b(a = "filter_param")
    private final String filterParam;
    private final String title;
    private final List<o> values;

    public FiltersItem(String str, List<o> list, String str2) {
        k.c(str, "filterParam");
        k.c(str2, "title");
        this.filterParam = str;
        this.values = list;
        this.title = str2;
    }

    public final String getFilterParam() {
        return this.filterParam;
    }

    public final List<o> getValues() {
        return this.values;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FiltersItem(String str, List list, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, list, (i2 & 4) != 0 ? "" : str2);
    }

    public final String getTitle() {
        return this.title;
    }
}
