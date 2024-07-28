package net.one97.paytm.common.entity.movies.search;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRUpcomingMoviesInfo implements IJRDataModel {
    @b(a = "genre")
    private List<String> genre;
    @b(a = "isContentAvailable")
    private int isContentAvailable;
    private boolean isInterested;
    @b(a = "language")
    private String language;
    @b(a = "moviePosterUrl")
    private String moviePosterUrl;
    @b(a = "movieTitle")
    private String movieTitle;
    @b(a = "paytmMovieCode")
    private String paytmMovieCode;
    @b(a = "provider_moviename")
    private String providerMoviename;
    @b(a = "rank")
    private String rank;
    @b(a = "releaseDate")
    private String releaseDate;

    public String getProviderMoviename() {
        return this.providerMoviename;
    }

    public void setProviderMoviename(String str) {
        this.providerMoviename = str;
    }

    public String getMoviePosterUrl() {
        return this.moviePosterUrl;
    }

    public void setMoviePosterUrl(String str) {
        this.moviePosterUrl = str;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }

    public void setMovieTitle(String str) {
        this.movieTitle = str;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String str) {
        this.releaseDate = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public List<String> getGenre() {
        return this.genre;
    }

    public void setGenre(List<String> list) {
        this.genre = list;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String str) {
        this.rank = str;
    }

    public String getPaytmMovieCode() {
        return this.paytmMovieCode;
    }

    public void setPaytmMovieCode(String str) {
        this.paytmMovieCode = str;
    }

    public int getIsContentAvailable() {
        return this.isContentAvailable;
    }

    public void setIsContentAvailable(int i2) {
        this.isContentAvailable = i2;
    }

    public boolean isInterested() {
        return this.isInterested;
    }

    public void setInterested(boolean z) {
        this.isInterested = z;
    }
}
