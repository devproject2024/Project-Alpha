package net.one97.paytm.o2o.movies.common.movies.moviepass;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassStorefrontModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error_code")
    private String errorCode;
    private String message;
    @b(a = "data")
    private CJRMoviePassCatalogModel moviePassCatalogModel;

    public CJRMoviePassCatalogModel getMoviePassCatalogModel() {
        return this.moviePassCatalogModel;
    }
}
