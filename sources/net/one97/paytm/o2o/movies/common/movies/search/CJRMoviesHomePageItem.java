package net.one97.paytm.o2o.movies.common.movies.search;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.entity.events.Carousel;
import net.one97.paytm.o2o.movies.entity.events.Category;
import net.one97.paytm.o2o.movies.entity.events.DigitalEvent;

public class CJRMoviesHomePageItem extends IJRPaytmDataModel implements IJRDataModel {
    private String categoryTitle;
    private List<CJRCinemas> cinemaListV1;
    private ArrayList<ArrayList<CJRCinemaV2>> cinemaListV2;
    private String digitalEventDescription;
    private String digitalEventTitle;
    private List<DigitalEvent> digitalEvents;
    private Carousel eventCarousel;
    private List<Category> eventCategories;
    private CJRHomePageLayoutV2 mBannerList;
    private String mItemTitle;
    private String mRowType = "";
    private String mSelectedLanguage;
    private String mSelectedLocation;
    private CJRUpcomingMovies mUpcomingMovies;
    private ArrayList<CJRMovieHomeListItem> moviesList;
    private List<CJRProviderList> providerList;

    public void setEventCarousel(Carousel carousel) {
        this.eventCarousel = carousel;
    }

    public void setDigitalEvents(List<DigitalEvent> list) {
        this.digitalEvents = list;
    }

    public void setEventCategories(List<Category> list) {
        this.eventCategories = list;
    }

    public void setCategoryTitle(String str) {
        this.categoryTitle = str;
    }

    public void setDigitalEventTitle(String str) {
        this.digitalEventTitle = str;
    }

    public void setDigitalEventDescription(String str) {
        this.digitalEventDescription = str;
    }

    public Carousel getEventCarousel() {
        return this.eventCarousel;
    }

    public List<DigitalEvent> getDigitalEvents() {
        return this.digitalEvents;
    }

    public List<Category> getEventCategories() {
        return this.eventCategories;
    }

    public String getCategoryTitle() {
        return this.categoryTitle;
    }

    public String getDigitalEventTitle() {
        return this.digitalEventTitle;
    }

    public String getDigitalEventDescription() {
        return this.digitalEventDescription;
    }

    public String getItemTitle() {
        return this.mItemTitle;
    }

    public void setItemTitle(String str) {
        this.mItemTitle = str;
    }

    public String getRowType() {
        return this.mRowType;
    }

    public void setRowType(String str) {
        this.mRowType = str;
    }

    public CJRHomePageLayoutV2 getBannerList() {
        return this.mBannerList;
    }

    public void setBannerList(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        this.mBannerList = cJRHomePageLayoutV2;
    }

    public String getSelectedLanguage() {
        return this.mSelectedLanguage;
    }

    public void setSelectedLanguage(String str) {
        this.mSelectedLanguage = str;
    }

    public String getSelectedLocation() {
        return this.mSelectedLocation;
    }

    public void setSelectedLocation(String str) {
        this.mSelectedLocation = str;
    }

    public ArrayList<CJRMovieHomeListItem> getMoviesListV2() {
        return this.moviesList;
    }

    public void setMoviesListV2(ArrayList<CJRMovieHomeListItem> arrayList) {
        this.moviesList = arrayList;
    }

    public CJRUpcomingMovies getmUpcomingMovies() {
        return this.mUpcomingMovies;
    }

    public void setmUpcomingMovies(CJRUpcomingMovies cJRUpcomingMovies) {
        this.mUpcomingMovies = cJRUpcomingMovies;
    }

    public void setCinemaListV2(ArrayList<ArrayList<CJRCinemaV2>> arrayList) {
        this.cinemaListV2 = arrayList;
    }

    public ArrayList<ArrayList<CJRCinemaV2>> getCinemaListV2() {
        return this.cinemaListV2;
    }

    public List<CJRCinemas> getCinemaListV1() {
        return this.cinemaListV1;
    }

    public void setCinemaListV1(List<CJRCinemas> list) {
        this.cinemaListV1 = list;
    }

    public void setProviderList(List<CJRProviderList> list) {
        this.providerList = list;
    }

    public List<CJRProviderList> getProviderList() {
        return this.providerList;
    }
}
