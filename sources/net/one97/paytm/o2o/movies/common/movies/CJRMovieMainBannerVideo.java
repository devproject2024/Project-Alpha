package net.one97.paytm.o2o.movies.common.movies;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieMainBannerVideo implements IJRDataModel {
    @b(a = "url")
    private String url;
    @b(a = "url2")
    private String url2;

    public String getUrl() {
        return this.url;
    }

    public String getUrl2() {
        return this.url2;
    }
}
