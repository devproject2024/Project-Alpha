package net.one97.paytm.o2o.movies.common.movies;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieLanguages;

public class CJRUpcomingMovieReleaseDate implements IJRDataModel {
    private boolean isExpanded;
    private ArrayList<CJRMovieLanguages> releaseMonths;
    private String year;

    public String getYear() {
        return this.year;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public ArrayList<CJRMovieLanguages> getReleaseMonths() {
        return this.releaseMonths;
    }

    public void setReleaseMonths(ArrayList<CJRMovieLanguages> arrayList) {
        this.releaseMonths = arrayList;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean z) {
        this.isExpanded = z;
    }
}
