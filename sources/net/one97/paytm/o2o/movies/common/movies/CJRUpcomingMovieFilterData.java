package net.one97.paytm.o2o.movies.common.movies;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieLanguages;
import net.one97.paytm.o2o.movies.entity.ComingSoonMovie;

public class CJRUpcomingMovieFilterData implements IJRDataModel {
    private ComingSoonMovie comingSoonMovie;
    private ArrayList<CJRMovieLanguages> mGenreList;
    private ArrayList<CJRMovieLanguages> mLanguageList;
    private ArrayList<CJRUpcomingMovieReleaseDate> mReleaseDateList;

    public ArrayList<CJRMovieLanguages> getmGenreList() {
        return this.mGenreList;
    }

    public ArrayList<CJRMovieLanguages> getmLanguageList() {
        return this.mLanguageList;
    }

    public void setmLanguageList(ArrayList<CJRMovieLanguages> arrayList) {
        this.mLanguageList = arrayList;
    }

    public void setmGenreList(ArrayList<CJRMovieLanguages> arrayList) {
        this.mGenreList = arrayList;
    }

    public ArrayList<CJRUpcomingMovieReleaseDate> getmReleaseDateList() {
        return this.mReleaseDateList;
    }

    public void setmReleaseDateList(ArrayList<CJRUpcomingMovieReleaseDate> arrayList) {
        this.mReleaseDateList = arrayList;
    }

    public ComingSoonMovie getComingSoonMovie() {
        return this.comingSoonMovie;
    }

    public void setComingSoonMovie(ComingSoonMovie comingSoonMovie2) {
        this.comingSoonMovie = comingSoonMovie2;
    }
}
