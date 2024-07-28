package net.one97.paytm.orders.datamodel;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;

public class CJRMoviesUpcomingItem implements IJRDataModel {
    public CJRUpcomingMovies upcomingMovies;

    public CJRUpcomingMovies getUpcomingMovies() {
        return this.upcomingMovies;
    }

    public void setUpcomingMovies(CJRUpcomingMovies cJRUpcomingMovies) {
        this.upcomingMovies = cJRUpcomingMovies;
    }
}
