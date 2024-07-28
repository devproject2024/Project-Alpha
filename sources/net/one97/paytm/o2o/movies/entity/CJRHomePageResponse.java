package net.one97.paytm.o2o.movies.entity;

import java.util.ArrayList;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem;

public class CJRHomePageResponse extends ArrayList<CJRMoviesHomePageItem> {
    public ArrayList<CJRBookedMovieTicket> bookedMovieTicketList;
    public ArrayList<ArrayList<CJRCinemaV2>> cinemaList;
    public CJRMovieHomeDataResponse cjrMovieHomeDataResponse;
    public ArrayList<Language> mMovieLanguageList;
    public ArrayList<CJRMovieHomeListItem> mPopularMovieList;

    public CJRHomePageResponse(ArrayList<Language> arrayList, ArrayList<CJRMovieHomeListItem> arrayList2, CJRMovieHomeDataResponse cJRMovieHomeDataResponse, ArrayList<CJRBookedMovieTicket> arrayList3) {
        this.mMovieLanguageList = arrayList;
        this.mPopularMovieList = arrayList2;
        this.cjrMovieHomeDataResponse = cJRMovieHomeDataResponse;
        this.bookedMovieTicketList = arrayList3;
    }

    public static class Language implements Comparable {
        public String languageForOperation;
        public String languageToDisplay;
        public int sessionCount;

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.languageForOperation.equals(((Language) obj).languageForOperation);
        }

        public int hashCode() {
            return this.languageForOperation.hashCode();
        }

        public int compareTo(Object obj) {
            if (obj instanceof Language) {
                return this.sessionCount - ((Language) obj).sessionCount;
            }
            return 0;
        }
    }
}
