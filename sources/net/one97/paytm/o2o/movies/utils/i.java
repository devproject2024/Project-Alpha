package net.one97.paytm.o2o.movies.utils;

import android.location.Location;
import com.google.gson.o;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieDateWiseFactor;
import net.one97.paytm.o2o.movies.common.movies.search.CJRFilterData;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.OrderedMap;
import net.one97.paytm.o2o.movies.entity.CJRAmenity;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;

public final class i {
    private static i m;

    /* renamed from: a  reason: collision with root package name */
    public Location f75931a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRMovieHomeListItem> f75932b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CJRCinemas> f75933c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    CJRFilterData f75934d;

    /* renamed from: e  reason: collision with root package name */
    public List<CJRAmenity> f75935e;

    /* renamed from: f  reason: collision with root package name */
    public CJRCinemas f75936f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<CJRMovieHomeListItem> f75937g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, CJRMovieDateWiseFactor> f75938h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, OrderedMap> f75939i = new HashMap<>();
    public ArrayList<String> j;
    public String k;
    public o l;

    private i() {
    }

    public static i a() {
        if (m == null) {
            synchronized ("CJRMovieSearchResponseHolderSingleton") {
                if (m == null) {
                    m = new i();
                }
            }
        }
        return m;
    }

    public final void a(ArrayList<CJRMovieHomeListItem> arrayList) {
        b.j();
        this.f75932b = arrayList;
    }
}
