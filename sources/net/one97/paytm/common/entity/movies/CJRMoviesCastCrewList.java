package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRMoviesCastCrewList {
    @b(a = "data")
    private ArrayList<CJRMoviesCastCrewItem> mCrewList;
    @b(a = "title")
    private String title;

    public ArrayList<CJRMoviesCastCrewItem> getCastCrewList() {
        return this.mCrewList;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
