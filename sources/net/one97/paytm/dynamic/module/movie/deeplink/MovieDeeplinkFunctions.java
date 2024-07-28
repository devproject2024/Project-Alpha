package net.one97.paytm.dynamic.module.movie.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.j.c;
import net.one97.paytm.o2o.amusementpark.activity.AmParkOrderSummary;
import net.one97.paytm.o2o.events.activity.EventOrderSummary;
import net.one97.paytm.o2o.movies.activity.AJREntertainmentDiscovery;
import net.one97.paytm.o2o.movies.activity.AJRIMAXCinemasPage;
import net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary;
import net.one97.paytm.o2o.movies.activity.AJRPostOrderFoodAndBeverages;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesGridPage;
import net.one97.paytm.o2o.movies.activity.MoviesHomeActivity;

public final class MovieDeeplinkFunctions {
    public static final Companion Companion = new Companion((g) null);
    public static final String FILTER_ITEM_1 = "filter1";
    public static final String FILTER_ITEM_2 = "filter2";
    private final String CINEMA_NAME = "cinema_name";
    private final String ENC_SESSION_ID = "encSessionId";
    private final String FROM_DATE = "fromdate";
    private final String TYPE_CINEMA = "cinema";
    private final String TYPE_MOVIE = "movie";
    private final String URL_TYPE_ENTERTAINMENT_OP = "entertainment_one_pager";
    private final Context context;

    public MovieDeeplinkFunctions(Context context2) {
        k.c(context2, "context");
        this.context = context2;
    }

    public final String getCINEMA_NAME() {
        return this.CINEMA_NAME;
    }

    public final String getTYPE_MOVIE() {
        return this.TYPE_MOVIE;
    }

    public final String getTYPE_CINEMA() {
        return this.TYPE_CINEMA;
    }

    public final String getENC_SESSION_ID() {
        return this.ENC_SESSION_ID;
    }

    public final String getFROM_DATE() {
        return this.FROM_DATE;
    }

    public final String getURL_TYPE_ENTERTAINMENT_OP() {
        return this.URL_TYPE_ENTERTAINMENT_OP;
    }

    public final Intent contentPage(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon;
        Uri.Builder authority;
        Uri.Builder appendQueryParameter;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        if (z) {
            String str = hashMap.get("content_id");
            Uri uri = null;
            if (str == null) {
                return null;
            }
            Uri uri2 = deepLinkData.f50289g;
            if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("movie-details")) == null || (appendQueryParameter = authority.appendQueryParameter("content_id", str)) == null)) {
                uri = appendQueryParameter.build();
            }
            deepLinkData.f50289g = uri;
        }
        return getDeeplinkIntent(getIntentData(deepLinkData));
    }

    public final Intent seatLayout(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon;
        Uri.Builder appendQueryParameter;
        Uri.Builder appendQueryParameter2;
        String str;
        List<String> a2;
        Uri.Builder buildUpon2;
        Uri.Builder authority;
        Uri.Builder appendQueryParameter3;
        Uri.Builder appendQueryParameter4;
        Uri.Builder appendQueryParameter5;
        Uri.Builder appendQueryParameter6;
        Uri.Builder appendQueryParameter7;
        Uri.Builder appendQueryParameter8;
        Uri.Builder appendQueryParameter9;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        Uri uri = null;
        if (z) {
            String str2 = hashMap.get("city");
            if (!(str2 == null || (str = hashMap.get(this.ENC_SESSION_ID)) == null || (a2 = p.a((CharSequence) str, new String[]{"-"})) == null || a2.size() < 3)) {
                String str3 = a2.get(0);
                String str4 = a2.get(1);
                String str5 = a2.get(2);
                String str6 = hashMap.get(this.FROM_DATE);
                Uri uri2 = deepLinkData.f50289g;
                if (!(uri2 == null || (buildUpon2 = uri2.buildUpon()) == null || (authority = buildUpon2.authority("movies-seat-layout")) == null || (appendQueryParameter3 = authority.appendQueryParameter("type", this.TYPE_MOVIE)) == null)) {
                    k.a((Object) str2, "city");
                    Uri.Builder appendQueryParameter10 = appendQueryParameter3.appendQueryParameter("city", getCityName(str2));
                    if (!(appendQueryParameter10 == null || (appendQueryParameter4 = appendQueryParameter10.appendQueryParameter("city_value", str2)) == null || (appendQueryParameter5 = appendQueryParameter4.appendQueryParameter("code", str5)) == null || (appendQueryParameter6 = appendQueryParameter5.appendQueryParameter("movie_code", str5)) == null || (appendQueryParameter7 = appendQueryParameter6.appendQueryParameter("cinema_movie_code", str3)) == null || (appendQueryParameter8 = appendQueryParameter7.appendQueryParameter("session_id", str4)) == null || (appendQueryParameter9 = appendQueryParameter8.appendQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, str6)) == null)) {
                        uri = appendQueryParameter9.build();
                    }
                }
                deepLinkData.f50289g = uri;
                return getDeeplinkIntent(getIntentData(deepLinkData));
            }
        } else {
            String str7 = hashMap.get("movie_code");
            if (str7 != null) {
                Uri uri3 = deepLinkData.f50289g;
                if (!(uri3 == null || (buildUpon = uri3.buildUpon()) == null || (appendQueryParameter = buildUpon.appendQueryParameter("type", this.TYPE_MOVIE)) == null || (appendQueryParameter2 = appendQueryParameter.appendQueryParameter("code", str7)) == null)) {
                    uri = appendQueryParameter2.build();
                }
                deepLinkData.f50289g = uri;
                return getDeeplinkIntent(getIntentData(deepLinkData));
            }
        }
        return null;
    }

    public final Intent cinemaListingForMovie(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        String str;
        Uri.Builder buildUpon;
        Uri.Builder authority;
        Uri.Builder appendQueryParameter;
        Uri.Builder appendQueryParameter2;
        Uri.Builder appendQueryParameter3;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        Uri uri = null;
        if (z) {
            String str2 = hashMap.get("city");
            if (str2 == null || (str = hashMap.get("code")) == null) {
                return null;
            }
            Uri uri2 = deepLinkData.f50289g;
            if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("movies-show-time")) == null || (appendQueryParameter = authority.appendQueryParameter("type", this.TYPE_MOVIE)) == null)) {
                k.a((Object) str2, "city");
                Uri.Builder appendQueryParameter4 = appendQueryParameter.appendQueryParameter("city", getCityName(str2));
                if (!(appendQueryParameter4 == null || (appendQueryParameter2 = appendQueryParameter4.appendQueryParameter("city_value", str2)) == null || (appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("code", str)) == null)) {
                    uri = appendQueryParameter3.build();
                }
            }
            deepLinkData.f50289g = uri;
        } else if (!p.a(this.TYPE_MOVIE, hashMap.get("type"), true) || TextUtils.isEmpty(hashMap.get("code"))) {
            return null;
        }
        return getDeeplinkIntent(getIntentData(deepLinkData));
    }

    public final Intent movieListingForCinema(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        String str;
        Uri.Builder buildUpon;
        Uri.Builder authority;
        Uri.Builder appendQueryParameter;
        Uri.Builder appendQueryParameter2;
        Uri.Builder appendQueryParameter3;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        Uri uri = null;
        if (z) {
            String str2 = hashMap.get("city");
            if (str2 == null || (str = hashMap.get("code")) == null) {
                return null;
            }
            Uri uri2 = deepLinkData.f50289g;
            if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("movies-show-time")) == null || (appendQueryParameter = authority.appendQueryParameter("type", this.TYPE_CINEMA)) == null)) {
                k.a((Object) str2, "city");
                Uri.Builder appendQueryParameter4 = appendQueryParameter.appendQueryParameter("city", getCityName(str2));
                if (!(appendQueryParameter4 == null || (appendQueryParameter2 = appendQueryParameter4.appendQueryParameter("city_value", str2)) == null || (appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("code", str)) == null)) {
                    uri = appendQueryParameter3.build();
                }
            }
            deepLinkData.f50289g = uri;
        } else if (!p.a(this.TYPE_CINEMA, hashMap.get("type"), true) || TextUtils.isEmpty(hashMap.get("code"))) {
            return null;
        }
        return getDeeplinkIntent(getIntentData(deepLinkData));
    }

    public final Intent movieOrderSummaryPage(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon;
        Uri.Builder authority;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        String str = hashMap.get("order_id");
        Uri uri = null;
        if (str == null) {
            return null;
        }
        if (z) {
            Uri uri2 = deepLinkData.f50289g;
            if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("movie_order_summary")) == null)) {
                uri = authority.build();
            }
            deepLinkData.f50289g = uri;
        }
        Intent deeplinkIntent = getDeeplinkIntent(getIntentData(deepLinkData));
        deeplinkIntent.putExtra("order_id", str);
        return deeplinkIntent;
    }

    public final Intent eventOrderSummaryPage(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon;
        Uri.Builder authority;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        String str = hashMap.get("order_id");
        Uri uri = null;
        if (str == null) {
            return null;
        }
        if (z) {
            Uri uri2 = deepLinkData.f50289g;
            if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("event_order_summary")) == null)) {
                uri = authority.build();
            }
            deepLinkData.f50289g = uri;
        }
        Intent deeplinkIntent = getDeeplinkIntent(getIntentData(deepLinkData));
        deeplinkIntent.putExtra("order_id", str);
        return deeplinkIntent;
    }

    public final Intent apOrderSummaryPage(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon;
        Uri.Builder authority;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        String str = hashMap.get("order_id");
        Uri uri = null;
        if (str == null) {
            return null;
        }
        if (z) {
            Uri uri2 = deepLinkData.f50289g;
            if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("ap_order_summary")) == null)) {
                uri = authority.build();
            }
            deepLinkData.f50289g = uri;
        }
        Intent deeplinkIntent = getDeeplinkIntent(getIntentData(deepLinkData));
        deeplinkIntent.putExtra("order_id", str);
        return deeplinkIntent;
    }

    public final Intent movieCriticReview(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon;
        Uri.Builder authority;
        Uri.Builder appendQueryParameter;
        Uri.Builder appendQueryParameter2;
        Uri.Builder appendQueryParameter3;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        Uri uri = null;
        if (z) {
            String str = hashMap.get("content_id");
            if (str != null) {
                Uri uri2 = deepLinkData.f50289g;
                if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("movie-details")) == null || (appendQueryParameter = authority.appendQueryParameter("content_id", str)) == null || (appendQueryParameter2 = appendQueryParameter.appendQueryParameter("type", this.TYPE_MOVIE)) == null || (appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("tab", "3")) == null)) {
                    uri = appendQueryParameter3.build();
                }
                deepLinkData.f50289g = uri;
                return getDeeplinkIntent(getIntentData(deepLinkData));
            }
        } else if (hashMap.get("code") != null && k.a((Object) hashMap.get("tab"), (Object) "3")) {
            return getDeeplinkIntent(getIntentData(deepLinkData));
        }
        return null;
    }

    public final Intent movieLandingCitySpecific(boolean z, DeepLinkData deepLinkData, HashMap<String, String> hashMap) {
        Uri.Builder buildUpon;
        Uri.Builder authority;
        Uri.Builder appendQueryParameter;
        k.c(deepLinkData, "deepLinkData");
        k.c(hashMap, "params");
        String str = hashMap.get("city");
        Uri uri = null;
        if (str == null) {
            return null;
        }
        if (z) {
            Uri uri2 = deepLinkData.f50289g;
            if (!(uri2 == null || (buildUpon = uri2.buildUpon()) == null || (authority = buildUpon.authority("movietickets")) == null)) {
                k.a((Object) str, "city");
                Uri.Builder appendQueryParameter2 = authority.appendQueryParameter("city", getCityName(str));
                if (!(appendQueryParameter2 == null || (appendQueryParameter = appendQueryParameter2.appendQueryParameter("city_value", str)) == null)) {
                    uri = appendQueryParameter.build();
                }
            }
            deepLinkData.f50289g = uri;
        }
        return getDeeplinkIntent(getIntentData(deepLinkData));
    }

    public final CJRHomePageItem getIntentData(DeepLinkData deepLinkData) {
        DeepLinkData deepLinkData2 = deepLinkData;
        k.c(deepLinkData2, "deepLinkData");
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        Uri uri = deepLinkData2.f50289g;
        Bundle bundle = deepLinkData2.f50290h;
        if (uri != null) {
            String str = "content_id";
            if (!TextUtils.isEmpty(uri.toString())) {
                cJRHomePageItem.setUrl(uri.toString());
            }
            cJRHomePageItem.setPushUtmSource(uri.getQueryParameter("utm_source"));
            cJRHomePageItem.setUtmMedium(uri.getQueryParameter("utm_medium"));
            cJRHomePageItem.setUtmTerm(uri.getQueryParameter("utm_term"));
            cJRHomePageItem.setUtmContent(uri.getQueryParameter("utm_content"));
            cJRHomePageItem.setUtmCampaign(uri.getQueryParameter("utm_campaign"));
            cJRHomePageItem.setDeepLinking(true);
            cJRHomePageItem.setQrid(uri.getQueryParameter("qrid"));
            cJRHomePageItem.setPushCity(uri.getQueryParameter("city"));
            cJRHomePageItem.setPushCityValue(uri.getQueryParameter("city_value"));
            cJRHomePageItem.setMovieCode(uri.getQueryParameter("movie_code"));
            cJRHomePageItem.setPushType(uri.getQueryParameter("type"));
            cJRHomePageItem.setPushCode(uri.getQueryParameter("code"));
            cJRHomePageItem.setPushDate(uri.getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR));
            cJRHomePageItem.setMovieSessionId(uri.getQueryParameter("session_id"));
            cJRHomePageItem.setContentID(uri.getQueryParameter(str));
            cJRHomePageItem.setCinemaMovieCode(uri.getQueryParameter("cinema_movie_code"));
            cJRHomePageItem.setOrigin(uri.getQueryParameter("origin"));
            cJRHomePageItem.setPushFilterJson(uri.getQueryParameter("filter_params"));
            cJRHomePageItem.setUrlType(uri.getAuthority());
        } else if (bundle != null) {
            Bundle bundle2 = bundle;
            cJRHomePageItem.setPushUtmSource(bundle2.getString("utm_source"));
            cJRHomePageItem.setUtmMedium(bundle2.getString("utm_medium"));
            cJRHomePageItem.setUtmTerm(bundle2.getString("utm_term"));
            cJRHomePageItem.setUtmContent(bundle2.getString("utm_content"));
            cJRHomePageItem.setUtmCampaign(bundle2.getString("utm_campaign"));
            cJRHomePageItem.setDeepLinking(true);
            cJRHomePageItem.setQrid(bundle2.getString("qrid"));
            cJRHomePageItem.setPushCity(bundle2.getString("city"));
            cJRHomePageItem.setPushCityValue(bundle2.getString("city_value"));
            cJRHomePageItem.setMovieCode(bundle2.getString("movie_code"));
            cJRHomePageItem.setPushType(bundle2.getString("type"));
            cJRHomePageItem.setPushCode(bundle2.getString("code"));
            cJRHomePageItem.setPushDate(bundle2.getString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR));
            cJRHomePageItem.setMovieSessionId(bundle2.getString("session_id"));
            cJRHomePageItem.setContentID(bundle2.getString("content_id"));
            cJRHomePageItem.setCinemaMovieCode(bundle2.getString("cinema_movie_code"));
            cJRHomePageItem.setOrigin(bundle2.getString("origin"));
            cJRHomePageItem.setPushFilterJson(bundle2.getString("filter_params"));
        }
        DeepLinkData deepLinkData3 = deepLinkData;
        cJRHomePageItem.setDeeplink(deepLinkData3.f50283a);
        if (cJRHomePageItem.mUrlType == null) {
            String str2 = deepLinkData3.f50284b;
            if (str2 == null) {
                str2 = "movietickets";
            }
            cJRHomePageItem.mUrlType = str2;
        }
        return cJRHomePageItem;
    }

    private final String getCityName(String str) {
        c.a();
        String a2 = c.a(str);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        return !TextUtils.isEmpty(str) ? b.E(p.a(str, "-", " ", false)) : str;
    }

    static /* synthetic */ Class getDeepLinkActivity$default(MovieDeeplinkFunctions movieDeeplinkFunctions, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return movieDeeplinkFunctions.getDeepLinkActivity(str);
    }

    private final Class<?> getDeepLinkActivity(String str) {
        if (k.a((Object) str, (Object) "movie_order_summary")) {
            return AJRMovieOrderSummary.class;
        }
        if (k.a((Object) str, (Object) "ap_order_summary")) {
            return AmParkOrderSummary.class;
        }
        if (k.a((Object) str, (Object) "event_order_summary")) {
            return EventOrderSummary.class;
        }
        if (k.a((Object) str, (Object) "upcoming-movies")) {
            return AJRUpcomingMoviesGridPage.class;
        }
        if (k.a((Object) str, (Object) "postorder_fb")) {
            return AJRPostOrderFoodAndBeverages.class;
        }
        if (k.a((Object) str, (Object) "imaxpage")) {
            return AJRIMAXCinemasPage.class;
        }
        if (k.a((Object) str, (Object) "movies-seat-layout") || !k.a((Object) str, (Object) this.URL_TYPE_ENTERTAINMENT_OP)) {
            return MoviesHomeActivity.class;
        }
        return AJREntertainmentDiscovery.class;
    }

    public static /* synthetic */ Intent getDeeplinkIntent$default(MovieDeeplinkFunctions movieDeeplinkFunctions, CJRHomePageItem cJRHomePageItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRHomePageItem = null;
        }
        return movieDeeplinkFunctions.getDeeplinkIntent(cJRHomePageItem);
    }

    public final Intent getDeeplinkIntent(CJRHomePageItem cJRHomePageItem) {
        Intent intent = new Intent(this.context, getDeepLinkActivity(cJRHomePageItem != null ? cJRHomePageItem.getURLType() : null));
        if (cJRHomePageItem != null) {
            intent.putExtra("extra_home_data", cJRHomePageItem);
            intent.putExtra("is_deep_linking_data", cJRHomePageItem.isDeepLinking());
            intent.putExtra("origin", "deeplinking");
        }
        intent.setFlags(67108864);
        return intent;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r3 = r3.buildUpon();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent upcomingMovie(boolean r3, net.one97.paytm.deeplink.DeepLinkData r4, java.util.HashMap<java.lang.String, java.lang.String> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "params"
            kotlin.g.b.k.c(r5, r0)
            if (r3 == 0) goto L_0x0037
            android.net.Uri r3 = r4.f50289g
            r0 = 0
            if (r3 == 0) goto L_0x001f
            android.net.Uri$Builder r3 = r3.buildUpon()
            if (r3 == 0) goto L_0x001f
            java.lang.String r1 = "upcoming-movies"
            android.net.Uri$Builder r3 = r3.authority(r1)
            goto L_0x0020
        L_0x001f:
            r3 = r0
        L_0x0020:
            java.lang.String r1 = "filter_params"
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x002f
            if (r3 == 0) goto L_0x002f
            r3.appendQueryParameter(r1, r5)
        L_0x002f:
            if (r3 == 0) goto L_0x0035
            android.net.Uri r0 = r3.build()
        L_0x0035:
            r4.f50289g = r0
        L_0x0037:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r2.getIntentData(r4)
            android.content.Intent r3 = r2.getDeeplinkIntent(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.movie.deeplink.MovieDeeplinkFunctions.upcomingMovie(boolean, net.one97.paytm.deeplink.DeepLinkData, java.util.HashMap):android.content.Intent");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r2 = (r2 = r2.buildUpon()).authority("movietickets");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent movieLanding(boolean r2, net.one97.paytm.deeplink.DeepLinkData r3, java.util.HashMap<java.lang.String, java.lang.String> r4) {
        /*
            r1 = this;
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = "params"
            kotlin.g.b.k.c(r4, r0)
            if (r2 == 0) goto L_0x0026
            android.net.Uri r2 = r3.f50289g
            if (r2 == 0) goto L_0x0023
            android.net.Uri$Builder r2 = r2.buildUpon()
            if (r2 == 0) goto L_0x0023
            java.lang.String r4 = "movietickets"
            android.net.Uri$Builder r2 = r2.authority(r4)
            if (r2 == 0) goto L_0x0023
            android.net.Uri r2 = r2.build()
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            r3.f50289g = r2
        L_0x0026:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r1.getIntentData(r3)
            android.content.Intent r2 = r1.getDeeplinkIntent(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.movie.deeplink.MovieDeeplinkFunctions.movieLanding(boolean, net.one97.paytm.deeplink.DeepLinkData, java.util.HashMap):android.content.Intent");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r4 = r4.buildUpon();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent moviesListing(boolean r4, net.one97.paytm.deeplink.DeepLinkData r5, java.util.HashMap<java.lang.String, java.lang.String> r6) {
        /*
            r3 = this;
            java.lang.String r0 = "deepLinkData"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r0 = "params"
            kotlin.g.b.k.c(r6, r0)
            if (r4 == 0) goto L_0x004c
            android.net.Uri r4 = r5.f50289g
            r0 = 0
            if (r4 == 0) goto L_0x001f
            android.net.Uri$Builder r4 = r4.buildUpon()
            if (r4 == 0) goto L_0x001f
            java.lang.String r1 = "upcoming-movies"
            android.net.Uri$Builder r4 = r4.authority(r1)
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            java.lang.String r1 = "filter1"
            java.lang.Object r2 = r6.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0032
            if (r4 == 0) goto L_0x0031
            android.net.Uri$Builder r4 = r4.appendQueryParameter(r1, r2)
            goto L_0x0032
        L_0x0031:
            r4 = r0
        L_0x0032:
            java.lang.String r1 = "filter2"
            java.lang.Object r6 = r6.get(r1)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0044
            if (r4 == 0) goto L_0x0043
            android.net.Uri$Builder r4 = r4.appendQueryParameter(r1, r6)
            goto L_0x0044
        L_0x0043:
            r4 = r0
        L_0x0044:
            if (r4 == 0) goto L_0x004a
            android.net.Uri r0 = r4.build()
        L_0x004a:
            r5.f50289g = r0
        L_0x004c:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = r3.getIntentData(r5)
            android.content.Intent r4 = r3.getDeeplinkIntent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.movie.deeplink.MovieDeeplinkFunctions.moviesListing(boolean, net.one97.paytm.deeplink.DeepLinkData, java.util.HashMap):android.content.Intent");
    }
}
