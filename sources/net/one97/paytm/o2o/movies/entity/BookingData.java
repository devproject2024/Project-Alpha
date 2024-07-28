package net.one97.paytm.o2o.movies.entity;

import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.seats.CJRObjSeat;

public final class BookingData {
    private final String mCitySearched;
    private final String mProductId;
    private final String mSeatSelectionSource;
    private final String mSelectSeatTempTransactionId;
    private final CJRMovies mSelectedMovie;
    private final CJRMoviesSession mSelectedMoviesSession;
    private final ArrayList<CJRObjSeat> mSelectedSeatList;
    private final boolean moviePassPresent;
    private final int seatCount;
    private final double seatPrice;

    public BookingData(CJRMoviesSession cJRMoviesSession, CJRMovies cJRMovies, String str, String str2, String str3, ArrayList<CJRObjSeat> arrayList, String str4, boolean z, double d2, int i2) {
        k.c(cJRMoviesSession, "mSelectedMoviesSession");
        k.c(cJRMovies, "mSelectedMovie");
        k.c(str, "mSelectSeatTempTransactionId");
        k.c(str2, "mSeatSelectionSource");
        k.c(str3, "mCitySearched");
        k.c(arrayList, "mSelectedSeatList");
        k.c(str4, "mProductId");
        this.mSelectedMoviesSession = cJRMoviesSession;
        this.mSelectedMovie = cJRMovies;
        this.mSelectSeatTempTransactionId = str;
        this.mSeatSelectionSource = str2;
        this.mCitySearched = str3;
        this.mSelectedSeatList = arrayList;
        this.mProductId = str4;
        this.moviePassPresent = z;
        this.seatPrice = d2;
        this.seatCount = i2;
    }

    public final CJRMoviesSession getMSelectedMoviesSession() {
        return this.mSelectedMoviesSession;
    }

    public final CJRMovies getMSelectedMovie() {
        return this.mSelectedMovie;
    }

    public final String getMSelectSeatTempTransactionId() {
        return this.mSelectSeatTempTransactionId;
    }

    public final String getMSeatSelectionSource() {
        return this.mSeatSelectionSource;
    }

    public final String getMCitySearched() {
        return this.mCitySearched;
    }

    public final ArrayList<CJRObjSeat> getMSelectedSeatList() {
        return this.mSelectedSeatList;
    }

    public final String getMProductId() {
        return this.mProductId;
    }

    public final boolean getMoviePassPresent() {
        return this.moviePassPresent;
    }

    public final double getSeatPrice() {
        return this.seatPrice;
    }

    public final int getSeatCount() {
        return this.seatCount;
    }
}
