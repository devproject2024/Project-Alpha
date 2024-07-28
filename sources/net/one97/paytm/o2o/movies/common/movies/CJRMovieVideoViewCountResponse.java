package net.one97.paytm.o2o.movies.common.movies;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieVideoViewCountResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }
}
