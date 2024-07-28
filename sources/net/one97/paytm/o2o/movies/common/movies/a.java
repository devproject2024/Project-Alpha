package net.one97.paytm.o2o.movies.common.movies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ? extends Map<String, ? extends List<? extends CJRMoviesSession>>> f75130a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, CJRMovieCinemaDetailV2> f75131b;

    /* renamed from: c  reason: collision with root package name */
    public String f75132c;

    /* renamed from: d  reason: collision with root package name */
    public String f75133d;

    /* renamed from: e  reason: collision with root package name */
    public List<? extends CJRMovieDetailsTab> f75134e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f75135f;

    /* renamed from: g  reason: collision with root package name */
    public String f75136g;

    /* renamed from: h  reason: collision with root package name */
    public CJRMoviesSession f75137h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f75138i;
    public List<? extends CJRCinemaV2> j;
    public CJRMovieCinemaV2 k;
    public CJRCinemaV2 l;
    public CJRMovieCinemaDetailV2 m;
    public boolean n;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a((Object) this.f75130a, (Object) aVar.f75130a) && k.a((Object) this.f75131b, (Object) aVar.f75131b) && k.a((Object) this.f75132c, (Object) aVar.f75132c) && k.a((Object) this.f75133d, (Object) aVar.f75133d) && k.a((Object) this.f75134e, (Object) aVar.f75134e) && k.a((Object) this.f75135f, (Object) aVar.f75135f) && k.a((Object) this.f75136g, (Object) aVar.f75136g) && k.a((Object) this.f75137h, (Object) aVar.f75137h) && this.f75138i == aVar.f75138i && k.a((Object) this.j, (Object) aVar.j) && k.a((Object) this.k, (Object) aVar.k) && k.a((Object) this.l, (Object) aVar.l) && k.a((Object) this.m, (Object) aVar.m) && this.n == aVar.n;
    }

    public final int hashCode() {
        Map<String, ? extends Map<String, ? extends List<? extends CJRMoviesSession>>> map = this.f75130a;
        int i2 = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        HashMap<String, CJRMovieCinemaDetailV2> hashMap = this.f75131b;
        int hashCode2 = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        String str = this.f75132c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f75133d;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<? extends CJRMovieDetailsTab> list = this.f75134e;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.f75135f;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f75136g;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        CJRMoviesSession cJRMoviesSession = this.f75137h;
        int hashCode8 = (hashCode7 + (cJRMoviesSession != null ? cJRMoviesSession.hashCode() : 0)) * 31;
        boolean z = this.f75138i;
        if (z) {
            z = true;
        }
        int i3 = (hashCode8 + (z ? 1 : 0)) * 31;
        List<? extends CJRCinemaV2> list2 = this.j;
        int hashCode9 = (i3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        CJRMovieCinemaV2 cJRMovieCinemaV2 = this.k;
        int hashCode10 = (hashCode9 + (cJRMovieCinemaV2 != null ? cJRMovieCinemaV2.hashCode() : 0)) * 31;
        CJRCinemaV2 cJRCinemaV2 = this.l;
        int hashCode11 = (hashCode10 + (cJRCinemaV2 != null ? cJRCinemaV2.hashCode() : 0)) * 31;
        CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2 = this.m;
        if (cJRMovieCinemaDetailV2 != null) {
            i2 = cJRMovieCinemaDetailV2.hashCode();
        }
        int i4 = (hashCode11 + i2) * 31;
        boolean z2 = this.n;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "CJRMovieDetailsFinalModel(mDateWiseMappedMovieSessions=" + this.f75130a + ", mDateWiseMappedResponse=" + this.f75131b + ", selectedCode=" + this.f75132c + ", selectedCategory=" + this.f75133d + ", mDatesTabList=" + this.f75134e + ", selectedDate=" + this.f75135f + ", mDeeplinkSessionId=" + this.f75136g + ", mDeeplinkMovieSessionObj=" + this.f75137h + ", mIsSearchFilterAvailable=" + this.f75138i + ", mCinemaList=" + this.j + ", mMovieItem=" + this.k + ", mCinemaItem=" + this.l + ", mCJRMovieCinemaDetailV2=" + this.m + ", isDataVisible=" + this.n + ")";
    }

    public a(Map<String, ? extends Map<String, ? extends List<? extends CJRMoviesSession>>> map, HashMap<String, CJRMovieCinemaDetailV2> hashMap, String str, String str2, String str3, String str4) {
        this.f75130a = map;
        this.f75131b = hashMap;
        this.f75132c = str;
        this.f75133d = str2;
        this.f75135f = str3;
        this.f75136g = str4;
        this.f75137h = null;
        this.f75138i = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
    }
}
