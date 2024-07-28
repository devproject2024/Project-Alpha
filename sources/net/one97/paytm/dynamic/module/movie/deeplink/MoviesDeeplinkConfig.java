package net.one97.paytm.dynamic.module.movie.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.DeepLinkData;

public final class MoviesDeeplinkConfig {
    /* access modifiers changed from: private */
    public final MovieDeeplinkFunctions deeplinkFunctions;

    public final Intent getDeeplinkIntent() {
        return getDeeplinkIntent$default(this, (CJRHomePageItem) null, 1, (Object) null);
    }

    public MoviesDeeplinkConfig(Context context) {
        k.c(context, "context");
        this.deeplinkFunctions = new MovieDeeplinkFunctions(context);
    }

    private final List<MoviesDeeplink> getDeeplinkConfig() {
        List<MoviesDeeplink> arrayList = new ArrayList<>();
        arrayList.add(new MoviesDeeplink("Upcoming Movie", "https://paytm.com/movies/upcoming-movies/?", "paytmmp://upcoming-movies", new MoviesDeeplinkConfig$getDeeplinkConfig$1(this)));
        arrayList.add(new MoviesDeeplink("Upcoming Movie With Filter", "https://paytm.com/movies/upcoming-movies/{filter_params}/", "paytmmp://upcoming-movies", new MoviesDeeplinkConfig$getDeeplinkConfig$2(this)));
        arrayList.add(new MoviesDeeplink("Movie Landing", "https://paytm.com/movies/", "paytmmp://movietickets", new MoviesDeeplinkConfig$getDeeplinkConfig$3(this)));
        arrayList.add(new MoviesDeeplink("Content Page", "https://paytm.com/movies/{movie_name}-movie-detail-{content_id}/?", "paytmmp://movie-details", new MoviesDeeplinkConfig$getDeeplinkConfig$4(this)));
        arrayList.add(new MoviesDeeplink("Seat Layout 1", "https://paytm.com/movies/{city}/{movie_name}-m/{code}/?", "paytmmp://movies-seat-layout", new MoviesDeeplinkConfig$getDeeplinkConfig$5(this)));
        arrayList.add(new MoviesDeeplink("Seat Layout 2", "https://paytm.com/movies/{city}/{movie_name}-movie-ticket-booking-{code}/?", "paytmmp://movies-seat-layout", new MoviesDeeplinkConfig$getDeeplinkConfig$6(this)));
        arrayList.add(new MoviesDeeplink("Seat Layout 3", "https://paytm.com/movies/{city}/{" + this.deeplinkFunctions.getCINEMA_NAME() + "}-c/{code}/?", "paytmmp://movies-seat-layout", new MoviesDeeplinkConfig$getDeeplinkConfig$7(this)));
        arrayList.add(new MoviesDeeplink("Seat Layout 4", "https://paytm.com/movies/{city}/{" + this.deeplinkFunctions.getCINEMA_NAME() + "}-cinema/{code}/?", "paytmmp://movies-seat-layout", new MoviesDeeplinkConfig$getDeeplinkConfig$8(this)));
        arrayList.add(new MoviesDeeplink("Cinema Listing for Movie", "https://paytm.com/movies/{city}/{movie_name}-m/{code}/?", "paytmmp://movies-show-time", new MoviesDeeplinkConfig$getDeeplinkConfig$9(this)));
        arrayList.add(new MoviesDeeplink("Cinema Listing for Movie 2", "https://paytm.com/movies/{city}/{movie_name}-movie-ticket-booking-{code}/?", "paytmmp://movies-show-time", new MoviesDeeplinkConfig$getDeeplinkConfig$10(this)));
        arrayList.add(new MoviesDeeplink("Movie Listing for Cinema", "https://paytm.com/movies/{city}/{" + this.deeplinkFunctions.getCINEMA_NAME() + "}-c/{code}/?", "paytmmp://movies-show-time", new MoviesDeeplinkConfig$getDeeplinkConfig$11(this)));
        arrayList.add(new MoviesDeeplink("Movie Listing for Cinema 2", "https://paytm.com/movies/{city}/{" + this.deeplinkFunctions.getCINEMA_NAME() + "}-cinema-{code}/?", "paytmmp://movies-show-time", new MoviesDeeplinkConfig$getDeeplinkConfig$12(this)));
        arrayList.add(new MoviesDeeplink("Movie Order Summary Page 1", "https://paytm.com/movies/myorders/{order_id}/?", "paytmmp://movie_order_summary", new MoviesDeeplinkConfig$getDeeplinkConfig$13(this)));
        arrayList.add(new MoviesDeeplink("Movie Order Summary Page 2", "https://paytm.com/movies/shop/summary/{order_id}/?", "paytmmp://movie_order_summary", new MoviesDeeplinkConfig$getDeeplinkConfig$14(this)));
        arrayList.add(new MoviesDeeplink("Movie Critic Reviews", "https://paytm.com/movies/{movie_name}-critic-reviews-{content_id}/?", "paytmmp://movies-show-time", new MoviesDeeplinkConfig$getDeeplinkConfig$15(this)));
        arrayList.add(new MoviesDeeplink("Movie Landing City Specific", "https://paytm.com/movies/{city}/", "paytmmp://movietickets?", new MoviesDeeplinkConfig$getDeeplinkConfig$16(this)));
        arrayList.add(new MoviesDeeplink("Language Movie Ticket Booking", "https://paytm.com/movies/list/{filter1}/{filter2}/", "paytmmp://upcoming-movies/list?", new MoviesDeeplinkConfig$getDeeplinkConfig$17(this)));
        arrayList.add(new MoviesDeeplink("Language Movie Ticket Booking", "https://paytm.com/movies/list/{filter1}/", "paytmmp://upcoming-movies/list?", new MoviesDeeplinkConfig$getDeeplinkConfig$18(this)));
        return arrayList;
    }

    private final String transformUriToWebUrl(Uri uri) {
        if (uri == null || !k.a((Object) uri.getQueryParameter("isAppLink"), (Object) "1")) {
            return null;
        }
        Uri.Builder appendPath = Uri.parse("https://paytm.com").buildUpon().appendPath("movies");
        String queryParameter = uri.getQueryParameter("app_link_level_1");
        if (queryParameter != null) {
            appendPath.appendPath(queryParameter);
        }
        String queryParameter2 = uri.getQueryParameter("app_link_level_2");
        if (queryParameter2 != null) {
            appendPath.appendPath(queryParameter2);
        }
        String queryParameter3 = uri.getQueryParameter("app_link_level_3");
        if (queryParameter3 != null) {
            appendPath.appendPath(queryParameter3);
        }
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        k.a((Object) queryParameterNames, "uri.queryParameterNames");
        Collection arrayList = new ArrayList();
        for (Object next : queryParameterNames) {
            String str = (String) next;
            boolean z = true;
            if (p.a(str, "isAppLink", true) || p.a(str, "app_link_level_1", true) || p.a(str, "app_link_level_2", true) || p.a(str, "app_link_level_3", true)) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        for (String str2 : (List) arrayList) {
            appendPath.appendQueryParameter(str2, uri.getQueryParameter(str2));
        }
        Uri build = appendPath.build();
        k.a((Object) build, "newUri");
        if (build.getQueryParameterNames().size() != 0) {
            return build.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(build);
        sb.append('/');
        return sb.toString();
    }

    public static /* synthetic */ Intent getDeeplinkIntent$default(MoviesDeeplinkConfig moviesDeeplinkConfig, CJRHomePageItem cJRHomePageItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRHomePageItem = null;
        }
        return moviesDeeplinkConfig.getDeeplinkIntent(cJRHomePageItem);
    }

    public final Intent getDeeplinkIntent(CJRHomePageItem cJRHomePageItem) {
        return this.deeplinkFunctions.getDeeplinkIntent(cJRHomePageItem);
    }

    public static final class MoviesDeeplink {
        private final String deeplinkPattern;
        private final q<Boolean, DeepLinkData, HashMap<String, String>, Intent> functionToExecute;
        private final String name;
        private final String webUrlPattern;

        public static /* synthetic */ MoviesDeeplink copy$default(MoviesDeeplink moviesDeeplink, String str, String str2, String str3, q<Boolean, DeepLinkData, HashMap<String, String>, Intent> qVar, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = moviesDeeplink.name;
            }
            if ((i2 & 2) != 0) {
                str2 = moviesDeeplink.webUrlPattern;
            }
            if ((i2 & 4) != 0) {
                str3 = moviesDeeplink.deeplinkPattern;
            }
            if ((i2 & 8) != 0) {
                qVar = moviesDeeplink.functionToExecute;
            }
            return moviesDeeplink.copy(str, str2, str3, qVar);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.webUrlPattern;
        }

        public final String component3() {
            return this.deeplinkPattern;
        }

        public final q<Boolean, DeepLinkData, HashMap<String, String>, Intent> component4() {
            return this.functionToExecute;
        }

        public final MoviesDeeplink copy(String str, String str2, String str3, q<? super Boolean, ? super DeepLinkData, ? super HashMap<String, String>, ? extends Intent> qVar) {
            k.c(str, "name");
            k.c(str2, "webUrlPattern");
            k.c(str3, "deeplinkPattern");
            k.c(qVar, "functionToExecute");
            return new MoviesDeeplink(str, str2, str3, qVar);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MoviesDeeplink)) {
                return false;
            }
            MoviesDeeplink moviesDeeplink = (MoviesDeeplink) obj;
            return k.a((Object) this.name, (Object) moviesDeeplink.name) && k.a((Object) this.webUrlPattern, (Object) moviesDeeplink.webUrlPattern) && k.a((Object) this.deeplinkPattern, (Object) moviesDeeplink.deeplinkPattern) && k.a((Object) this.functionToExecute, (Object) moviesDeeplink.functionToExecute);
        }

        public final int hashCode() {
            String str = this.name;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.webUrlPattern;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.deeplinkPattern;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            q<Boolean, DeepLinkData, HashMap<String, String>, Intent> qVar = this.functionToExecute;
            if (qVar != null) {
                i2 = qVar.hashCode();
            }
            return hashCode3 + i2;
        }

        public final String toString() {
            return "MoviesDeeplink(name=" + this.name + ", webUrlPattern=" + this.webUrlPattern + ", deeplinkPattern=" + this.deeplinkPattern + ", functionToExecute=" + this.functionToExecute + ")";
        }

        public MoviesDeeplink(String str, String str2, String str3, q<? super Boolean, ? super DeepLinkData, ? super HashMap<String, String>, ? extends Intent> qVar) {
            k.c(str, "name");
            k.c(str2, "webUrlPattern");
            k.c(str3, "deeplinkPattern");
            k.c(qVar, "functionToExecute");
            this.name = str;
            this.webUrlPattern = str2;
            this.deeplinkPattern = str3;
            this.functionToExecute = qVar;
        }

        public final String getName() {
            return this.name;
        }

        public final String getWebUrlPattern() {
            return this.webUrlPattern;
        }

        public final String getDeeplinkPattern() {
            return this.deeplinkPattern;
        }

        public final q<Boolean, DeepLinkData, HashMap<String, String>, Intent> getFunctionToExecute() {
            return this.functionToExecute;
        }
    }

    public final Intent resolveDeeplink(DeepLinkData deepLinkData) {
        UrlMatcher urlMatcher;
        String str;
        k.c(deepLinkData, "deepLinkData");
        Uri uri = deepLinkData.f50289g;
        if (uri == null) {
            return getDeeplinkIntent$default(this, (CJRHomePageItem) null, 1, (Object) null);
        }
        List<MoviesDeeplink> deeplinkConfig = getDeeplinkConfig();
        boolean a2 = k.a((Object) uri.getQueryParameter("isAppLink"), (Object) "1");
        for (MoviesDeeplink next : deeplinkConfig) {
            if (a2) {
                try {
                    urlMatcher = new UrlMatcher(next.getWebUrlPattern());
                } catch (Exception e2) {
                    com.paytm.utility.q.b(e2.getMessage());
                }
            } else {
                urlMatcher = new UrlMatcher(next.getDeeplinkPattern());
            }
            if (a2) {
                str = transformUriToWebUrl(uri);
            } else {
                str = deepLinkData.f50283a;
            }
            if (urlMatcher.match(str)) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(urlMatcher.getQueryParams());
                hashMap.putAll(urlMatcher.getPathParameters());
                Intent invoke = next.getFunctionToExecute().invoke(Boolean.valueOf(a2), deepLinkData, hashMap);
                if (invoke != null) {
                    return invoke;
                }
            } else {
                continue;
            }
        }
        return getDeeplinkIntent(this.deeplinkFunctions.getIntentData(deepLinkData));
    }
}
