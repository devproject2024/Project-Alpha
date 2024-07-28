package net.one97.paytm.o2o.movies.common.movies.search;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class OrderedMap implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "cinema_ids")
    private List<String> mCinemaIds;

    public List<String> getCinemaIds() {
        return this.mCinemaIds;
    }

    public void setCinemaIds(List<String> list) {
        this.mCinemaIds = list;
    }
}
