package net.one97.paytm.o2o.movies.common.movies.search;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieDetailsV2 extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "provider_list")
    private List<CJRProviderList> CJRProviderList = null;
    @b(a = "cinemas")
    private LinkedHashMap<Integer, CJRCinemaV2> cinemas;
    @b(a = "imax_cities")
    private ArrayList<String> mIMAXCities;
    @b(a = "imax_difference")
    private ArrayList<CJRIMAXDifferenceModel> mIMAXDifference;
    @b(a = "message_map")
    private HashMap<String, String> messageMap;
    @b(a = "movie_list")
    private List<String> movieList = null;
    @b(a = "movies")
    private LinkedHashMap<String, CJRMoviesV2> movies;
    @b(a = "virtual_city")
    private ArrayList virtualCity;

    public List<CJRProviderList> getCJRProviderList() {
        return this.CJRProviderList;
    }

    public List<String> getMovieList() {
        return this.movieList;
    }

    public LinkedHashMap<String, CJRMoviesV2> getMovies() {
        return this.movies;
    }

    public LinkedHashMap<Integer, CJRCinemaV2> getCinemas() {
        return this.cinemas;
    }

    public HashMap<String, String> getMessageMap() {
        return this.messageMap;
    }

    public ArrayList<String> getIMAXCities() {
        return this.mIMAXCities;
    }

    public void setIMAXCities(ArrayList<String> arrayList) {
        this.mIMAXCities = arrayList;
    }

    public ArrayList<CJRIMAXDifferenceModel> getIMAXDifference() {
        return this.mIMAXDifference;
    }

    public void setIMAXDifference(ArrayList<CJRIMAXDifferenceModel> arrayList) {
        this.mIMAXDifference = arrayList;
    }

    public ArrayList<String> getVirtualCity() {
        return this.virtualCity;
    }
}
