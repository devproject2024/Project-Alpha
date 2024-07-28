package net.one97.paytm.common.entity.movies.search;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUpcomingMovies extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "keys")
    private List<String> keys;
    @b(a = "languageScored")
    private List<String> languageScored;
    @b(a = "upcomingMovieData")
    private List<CJRUpcomingMoviesInfo> upcomingMovieData;

    public List<CJRUpcomingMoviesInfo> getUpcomingMovieData() {
        return this.upcomingMovieData;
    }

    public void setUpcomingMovieData(List<CJRUpcomingMoviesInfo> list) {
        this.upcomingMovieData = list;
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public void setKeys(List<String> list) {
        this.keys = list;
    }

    public List<String> getLanguageScored() {
        return this.languageScored;
    }

    public void setLanguageScored(List<String> list) {
        this.languageScored = list;
    }
}
