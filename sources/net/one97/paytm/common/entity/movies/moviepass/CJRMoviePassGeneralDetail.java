package net.one97.paytm.common.entity.movies.moviepass;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMoviePassGeneralDetail implements IJRDataModel {
    private final String heading;
    private final String synopsis;

    public CJRMoviePassGeneralDetail(String str, String str2) {
        k.c(str, "heading");
        k.c(str2, "synopsis");
        this.heading = str;
        this.synopsis = str2;
    }

    public final String getHeading() {
        return this.heading;
    }

    public final String getSynopsis() {
        return this.synopsis;
    }
}
