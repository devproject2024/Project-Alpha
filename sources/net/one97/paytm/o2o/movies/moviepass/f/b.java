package net.one97.paytm.o2o.movies.moviepass.f;

import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.o2o.movies.common.a;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassStorefrontModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassWrapperModel;
import net.one97.paytm.o2o.movies.d.e;
import net.one97.paytm.o2o.movies.entity.CJRCinemaV1;
import net.one97.paytm.o2o.movies.moviepass.b.c;
import net.one97.paytm.o2o.movies.utils.n;

public final class b implements e.a, c.a {

    /* renamed from: a  reason: collision with root package name */
    private e.b f75607a = a.f74984b.a();

    /* renamed from: b  reason: collision with root package name */
    private final c.b f75608b;

    public b(c.b bVar) {
        k.c(bVar, "mActivityListener");
        this.f75608b = bVar;
    }

    public final void a() {
        e.b bVar = this.f75607a;
        if (bVar != null) {
            bVar.a(this, (String) null, e.b.a.MOVIEPASS_CITY_LIST_API);
        }
    }

    public final void b(String str) {
        k.c(str, "city");
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        e.b bVar = this.f75607a;
        if (bVar != null) {
            bVar.a(this, (String) null, e.b.a.MOVIEPASS_CATELOG_API, hashMap);
        }
    }

    public final void a(String str) {
        e.b bVar;
        k.c(str, "city");
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        if (n.c(n.c()) && (bVar = this.f75607a) != null) {
            bVar.a(this, (String) null, e.b.a.MOVIEPASS_ACTIVE_EXPIRE, hashMap);
        }
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, HashMap<String, e.b.a> hashMap) {
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        k.c(hashMap, "identifier");
        this.f75608b.a(false);
        if (iJRPaytmDataModel instanceof CJRMoviePassStorefrontModel) {
            this.f75608b.a((CJRMoviePassStorefrontModel) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRUserMoviePassWrapperModel) {
            this.f75608b.a((CJRUserMoviePassWrapperModel) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRSelectCitiesModel) {
            n.a(((CJRSelectCitiesModel) iJRPaytmDataModel).getCities());
            this.f75608b.b();
        } else if (iJRPaytmDataModel instanceof CJRUpcomingMovies) {
            this.f75608b.a((CJRUpcomingMovies) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRCinemaV1) {
            this.f75608b.a((CJRCinemaV1) iJRPaytmDataModel);
        }
    }

    public final void a(boolean z, String str, int i2, e.b.a aVar, String str2, String str3, NetworkCustomError networkCustomError) {
        this.f75608b.a();
        this.f75608b.a(aVar);
        if (z) {
            a.C1484a aVar2 = a.f74984b;
            if (i2 == a.j) {
                this.f75608b.c(str);
                return;
            }
            a.C1484a aVar3 = a.f74984b;
            if (i2 == a.f74986h) {
                if (v.a(str2)) {
                    str2 = "Something went wrong.";
                } else if (str2 == null) {
                    k.a();
                }
                if (v.a(str3)) {
                    str3 = "Please try again after sometime.";
                } else if (str3 == null) {
                    k.a();
                }
                this.f75608b.a(str2, str3);
            }
        }
    }

    public final void c(String str) {
        k.c(str, "city");
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        e.b bVar = this.f75607a;
        if (bVar != null) {
            bVar.a(this, (String) null, e.b.a.UPCOMING_MOVIES, hashMap);
        }
    }

    public final void d(String str) {
        k.c(str, "city");
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        e.b bVar = this.f75607a;
        if (bVar != null) {
            bVar.a(this, (String) null, e.b.a.CINEMA_LIST, hashMap);
        }
    }
}
