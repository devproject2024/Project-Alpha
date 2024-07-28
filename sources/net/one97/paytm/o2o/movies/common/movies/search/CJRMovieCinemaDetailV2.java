package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem;

public class CJRMovieCinemaDetailV2 extends IJRPaytmDataModel implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRMovieCinemaDetailV2> CREATOR = new Parcelable.Creator<CJRMovieCinemaDetailV2>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRMovieCinemaDetailV2[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRMovieCinemaDetailV2(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @b(a = "cinemas")
    private LinkedHashMap<String, CJRCinemaV2> cinemas;
    public ArrayList<Integer> cinemasOrder;
    private List<CJRMovieShowTimeSearchFilterItem> filterList;
    private CJRMovieShowTimeFilterDataStorage filteredData;
    @b(a = "message_map")
    private HashMap<String, String> messageMap;
    @b(a = "message_map_translated")
    private HashMap<String, String> messageMapTranslated;
    @b(a = "movie_list")
    private List<CJRMovieDetailList> movieList = null;
    @b(a = "movies")
    private LinkedHashMap<String, CJRMovieCinemaV2> movies;
    private HashMap<String, List<String>> orderedCinemaList;
    @b(a = "ordered_map")
    private OrderedMap orderedMap;
    public int pageSize;
    @b(a = "provider_list")
    private List<CJRProviderDetailList> providerList = null;
    @b(a = "searchFilters")
    private HashMap<String, CJRMovieDateWiseFactor> searchFilters;

    public int describeContents() {
        return 0;
    }

    protected CJRMovieCinemaDetailV2(Parcel parcel) {
        this.pageSize = parcel.readInt();
        this.filterList = parcel.createTypedArrayList(CJRMovieShowTimeSearchFilterItem.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.pageSize);
        parcel.writeTypedList(this.filterList);
    }

    public void setSearchFilters(HashMap<String, CJRMovieDateWiseFactor> hashMap) {
        this.searchFilters = hashMap;
    }

    public HashMap<String, List<String>> getOrderedCinemaList() {
        return this.orderedCinemaList;
    }

    public void setOrderedCinemaList(HashMap<String, List<String>> hashMap) {
        this.orderedCinemaList = hashMap;
    }

    public List<CJRProviderDetailList> getProviderList() {
        return this.providerList;
    }

    public void setProviderList(List<CJRProviderDetailList> list) {
        this.providerList = list;
    }

    public List<CJRMovieDetailList> getMovieList() {
        return this.movieList;
    }

    public void setMovieList(List<CJRMovieDetailList> list) {
        this.movieList = list;
    }

    public LinkedHashMap<String, CJRMovieCinemaV2> getMovies() {
        return this.movies;
    }

    public void setMovies(LinkedHashMap<String, CJRMovieCinemaV2> linkedHashMap) {
        this.movies = linkedHashMap;
    }

    public LinkedHashMap<String, CJRCinemaV2> getCinemas() {
        return this.cinemas;
    }

    public void setCinemas(LinkedHashMap<String, CJRCinemaV2> linkedHashMap) {
        this.cinemas = linkedHashMap;
    }

    public HashMap<String, String> getMessageMap() {
        return this.messageMap;
    }

    public HashMap<String, String> getMessageMapTranslated() {
        return this.messageMapTranslated;
    }

    public OrderedMap getOrderedMap() {
        return this.orderedMap;
    }

    public void setOrderedMap(OrderedMap orderedMap2) {
        this.orderedMap = orderedMap2;
    }

    public HashMap<String, CJRMovieDateWiseFactor> getSearchFilters() {
        return this.searchFilters;
    }

    public CJRMovieShowTimeFilterDataStorage getFilteredData() {
        return this.filteredData;
    }

    public void setFilteredData(CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage) {
        this.filteredData = cJRMovieShowTimeFilterDataStorage;
    }

    public List<CJRMovieShowTimeSearchFilterItem> getFilterList() {
        return this.filterList;
    }

    public void setFilterList(List<CJRMovieShowTimeSearchFilterItem> list) {
        this.filterList = list;
    }

    public CJRMovieCinemaDetailV2() {
    }
}
