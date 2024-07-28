package net.one97.paytm.o2o.movies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.d.g;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.Callable;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieMeta;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieSessionsPageData;
import net.one97.paytm.o2o.movies.common.movies.search.CJRSessionDatesData;
import net.one97.paytm.o2o.movies.entity.SeatMapData;
import net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity;

public final class AJRSeatLayoutDeeplink extends AppBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f74089a;

    private View a(int i2) {
        if (this.f74089a == null) {
            this.f74089a = new HashMap();
        }
        View view = (View) this.f74089a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f74089a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onBackPressed() {
    }

    static final class c<T> implements g<SeatMapData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRSeatLayoutDeeplink f74100a;

        c(AJRSeatLayoutDeeplink aJRSeatLayoutDeeplink) {
            this.f74100a = aJRSeatLayoutDeeplink;
        }

        public final /* synthetic */ void accept(Object obj) {
            SeatSelectionActivity.a aVar = SeatSelectionActivity.f75763a;
            SeatSelectionActivity.a.a(this.f74100a, (SeatMapData) obj);
            this.f74100a.b();
        }
    }

    public final void onCreate(Bundle bundle) {
        MovieSeatLayoutHolder movieSeatLayoutHolder;
        super.onCreate(bundle);
        setContentView(R.layout.activity_seatmap_deeplink);
        try {
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.loader));
        } catch (Exception unused) {
        }
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("extra_home_data") : null;
        if (!(serializableExtra instanceof CJRHomePageItem)) {
            serializableExtra = null;
        }
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) serializableExtra;
        if (cJRHomePageItem != null) {
            String pushCityValue = cJRHomePageItem.getPushCityValue();
            String pushCity = cJRHomePageItem.getPushCity();
            String cinemaMovieCode = cJRHomePageItem.getCinemaMovieCode();
            String movieCode = cJRHomePageItem.getMovieCode();
            k.a((Object) movieCode, "data.movieCode");
            if (movieCode != null) {
                String upperCase = movieCode.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                if (upperCase == null) {
                    upperCase = "";
                }
                movieSeatLayoutHolder = new MovieSeatLayoutHolder(pushCityValue, pushCity, cinemaMovieCode, upperCase, cJRHomePageItem.getMovieSessionId(), cJRHomePageItem.getPushDate());
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            movieSeatLayoutHolder = null;
        }
        if (movieSeatLayoutHolder != null) {
            boolean z = true;
            if (TextUtils.isEmpty(movieSeatLayoutHolder.f74090a) || TextUtils.isEmpty(movieSeatLayoutHolder.f74091b) || TextUtils.isEmpty(movieSeatLayoutHolder.f74092c)) {
                z = false;
            }
            if (z) {
                try {
                    k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
                    net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                    cVar.f42877a = this;
                    cVar.f42879c = a.C0715a.GET;
                    cVar.f42880d = net.one97.paytm.o2o.movies.common.b.c.a("movieMoviesSearchV3", (String) null) + "?city=" + movieSeatLayoutHolder.f74090a + "&date=" + movieSeatLayoutHolder.f74094e + "&movieCode=" + movieSeatLayoutHolder.f74092c + "&cinemaIds=" + movieSeatLayoutHolder.f74091b + "&meta=1";
                    cVar.f42885i = new CJRMovieDataResponse((CJRMovieMeta) null, (CJRSessionDatesData) null, (CJRMovieSessionsPageData) null, 7, (kotlin.g.b.g) null);
                    cVar.f42878b = a.c.MOVIES;
                    cVar.n = a.b.USER_FACING;
                    cVar.o = "movies";
                    cVar.j = new a(this, movieSeatLayoutHolder);
                    cVar.l().a();
                    return;
                } catch (Exception unused2) {
                    b();
                    return;
                }
            }
        }
        b();
    }

    private final void a() {
        try {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.loader));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        a();
        finish();
    }

    static final class b<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRMovieDataResponse f74098a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MovieSeatLayoutHolder f74099b;

        b(CJRMovieDataResponse cJRMovieDataResponse, MovieSeatLayoutHolder movieSeatLayoutHolder) {
            this.f74098a = cJRMovieDataResponse;
            this.f74099b = movieSeatLayoutHolder;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6 A[Catch:{ Exception -> 0x01de }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.one97.paytm.o2o.movies.entity.SeatMapData call() {
            /*
                r28 = this;
                r0 = r28
                net.one97.paytm.o2o.movies.utils.e r1 = net.one97.paytm.o2o.movies.utils.e.f75922a     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse r1 = r0.f74098a     // Catch:{ Exception -> 0x01de }
                com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r2 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r2 = r2.f74094e     // Catch:{ Exception -> 0x01de }
                com.paytm.network.model.IJRPaytmDataModel r1 = net.one97.paytm.o2o.movies.utils.e.a((com.paytm.network.model.IJRPaytmDataModel) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x01de }
                boolean r2 = r1 instanceof net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2     // Catch:{ Exception -> 0x01de }
                r3 = 0
                if (r2 != 0) goto L_0x0016
                r1 = r3
            L_0x0016:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r1 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r1     // Catch:{ Exception -> 0x01de }
                if (r1 == 0) goto L_0x01de
                java.util.LinkedHashMap r1 = r1.getMovies()     // Catch:{ Exception -> 0x01de }
                if (r1 == 0) goto L_0x01de
                java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x01de }
                java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x01de }
                int r4 = r1.size()     // Catch:{ Exception -> 0x01de }
                int r4 = kotlin.a.ae.a((int) r4)     // Catch:{ Exception -> 0x01de }
                r2.<init>(r4)     // Catch:{ Exception -> 0x01de }
                java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x01de }
                java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x01de }
                java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ Exception -> 0x01de }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x01de }
            L_0x003b:
                boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x01de }
                if (r4 == 0) goto L_0x0070
                java.lang.Object r4 = r1.next()     // Catch:{ Exception -> 0x01de }
                r5 = r4
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x01de }
                java.lang.Object r5 = r5.getKey()     // Catch:{ Exception -> 0x01de }
                java.lang.String r6 = "it.key"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01de }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x01de }
                if (r5 == 0) goto L_0x0068
                java.lang.String r5 = r5.toUpperCase()     // Catch:{ Exception -> 0x01de }
                java.lang.String r6 = "(this as java.lang.String).toUpperCase()"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x01de }
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x01de }
                java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x01de }
                r2.put(r5, r4)     // Catch:{ Exception -> 0x01de }
                goto L_0x003b
            L_0x0068:
                kotlin.u r1 = new kotlin.u     // Catch:{ Exception -> 0x01de }
                java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
                r1.<init>(r2)     // Catch:{ Exception -> 0x01de }
                throw r1     // Catch:{ Exception -> 0x01de }
            L_0x0070:
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r1 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r1 = r1.f74092c     // Catch:{ Exception -> 0x01de }
                java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r1 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2) r1     // Catch:{ Exception -> 0x01de }
                if (r1 == 0) goto L_0x01de
                java.util.List r2 = r1.getSessions()     // Catch:{ Exception -> 0x01de }
                java.lang.String r4 = "it"
                r5 = 0
                r6 = 1
                if (r2 == 0) goto L_0x00c7
                java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x01de }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x01de }
            L_0x008c:
                boolean r7 = r2.hasNext()     // Catch:{ Exception -> 0x01de }
                if (r7 == 0) goto L_0x00be
                java.lang.Object r7 = r2.next()     // Catch:{ Exception -> 0x01de }
                r8 = r7
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r8     // Catch:{ Exception -> 0x01de }
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)     // Catch:{ Exception -> 0x01de }
                java.lang.String r9 = r8.getSessionID()     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r10 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r10 = r10.f74093d     // Catch:{ Exception -> 0x01de }
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r6)     // Catch:{ Exception -> 0x01de }
                if (r9 == 0) goto L_0x00ba
                java.lang.String r8 = r8.getCinemaID()     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r9 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r9 = r9.f74091b     // Catch:{ Exception -> 0x01de }
                boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r6)     // Catch:{ Exception -> 0x01de }
                if (r8 == 0) goto L_0x00ba
                r8 = 1
                goto L_0x00bb
            L_0x00ba:
                r8 = 0
            L_0x00bb:
                if (r8 == 0) goto L_0x008c
                goto L_0x00bf
            L_0x00be:
                r7 = r3
            L_0x00bf:
                r2 = r7
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r2 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r2     // Catch:{ Exception -> 0x01de }
                if (r2 != 0) goto L_0x00c5
                goto L_0x00c7
            L_0x00c5:
                r3 = r2
                goto L_0x00f4
            L_0x00c7:
                java.util.List r2 = r1.getSessions()     // Catch:{ Exception -> 0x01de }
                if (r2 == 0) goto L_0x00f4
                java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x01de }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x01de }
            L_0x00d3:
                boolean r7 = r2.hasNext()     // Catch:{ Exception -> 0x01de }
                if (r7 == 0) goto L_0x00f2
                java.lang.Object r7 = r2.next()     // Catch:{ Exception -> 0x01de }
                r8 = r7
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r8 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r8     // Catch:{ Exception -> 0x01de }
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)     // Catch:{ Exception -> 0x01de }
                java.lang.String r8 = r8.getCinemaID()     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r9 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r9 = r9.f74091b     // Catch:{ Exception -> 0x01de }
                boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r6)     // Catch:{ Exception -> 0x01de }
                if (r8 == 0) goto L_0x00d3
                r3 = r7
            L_0x00f2:
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r3 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r3     // Catch:{ Exception -> 0x01de }
            L_0x00f4:
                if (r3 == 0) goto L_0x01de
                net.one97.paytm.o2o.movies.entity.SeatMapData r2 = new net.one97.paytm.o2o.movies.entity.SeatMapData     // Catch:{ Exception -> 0x01de }
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r26 = 262143(0x3ffff, float:3.6734E-40)
                r27 = 0
                r7 = r2
                r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ Exception -> 0x01de }
                r2.setSelectedMovieSession(r3)     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r3.getScreenFormat()     // Catch:{ Exception -> 0x01de }
                if (r7 == 0) goto L_0x012c
                java.lang.String r7 = net.one97.paytm.o2o.movies.common.a.d.b(r7)     // Catch:{ Exception -> 0x01de }
                if (r7 != 0) goto L_0x0130
            L_0x012c:
                java.lang.String r7 = r1.getScreenFormat()     // Catch:{ Exception -> 0x01de }
            L_0x0130:
                r3.setScreenFormat(r7)     // Catch:{ Exception -> 0x01de }
                java.util.List r7 = r1.getSessions()     // Catch:{ Exception -> 0x01de }
                if (r7 != 0) goto L_0x0140
                java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x01de }
                r7.<init>()     // Catch:{ Exception -> 0x01de }
                java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x01de }
            L_0x0140:
                r2.setSessionList(r7)     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r7 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r7.f74090a     // Catch:{ Exception -> 0x01de }
                r2.setSelectedCity(r7)     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = "movie"
                r2.setSelectedCategory(r7)     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r1.getLanguage()     // Catch:{ Exception -> 0x01de }
                r2.setMovieLanguage(r7)     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.utils.h r7 = net.one97.paytm.o2o.movies.utils.h.f75928a     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = net.one97.paytm.o2o.movies.utils.h.a((net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2) r1)     // Catch:{ Exception -> 0x01de }
                r2.setMovieLocalizedLanguage(r7)     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r3.getRealShowDateTime()     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = net.one97.paytm.o2o.movies.utils.n.c((java.lang.String) r7)     // Catch:{ Exception -> 0x01de }
                r2.setTimeSlot(r7)     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r1.getCensor()     // Catch:{ Exception -> 0x01de }
                r2.setMovieCensor(r7)     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r1.getImageUrl()     // Catch:{ Exception -> 0x01de }
                r2.setMovieImageUrl(r7)     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r1.getTitle()     // Catch:{ Exception -> 0x01de }
                r2.setMovieTitle(r7)     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.utils.h r7 = net.one97.paytm.o2o.movies.utils.h.f75928a     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = net.one97.paytm.o2o.movies.utils.h.b((net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2) r1)     // Catch:{ Exception -> 0x01de }
                r2.setMovieLocalizedTitle(r7)     // Catch:{ Exception -> 0x01de }
                java.lang.Integer r7 = r1.getDuration()     // Catch:{ Exception -> 0x01de }
                if (r7 == 0) goto L_0x0193
                int r7 = r7.intValue()     // Catch:{ Exception -> 0x01de }
                goto L_0x0194
            L_0x0193:
                r7 = 0
            L_0x0194:
                r2.setMovieDuration(r7)     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r7 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r7.f74092c     // Catch:{ Exception -> 0x01de }
                r2.setMovieCode(r7)     // Catch:{ Exception -> 0x01de }
                int r7 = r3.getSeatsAvailable()     // Catch:{ Exception -> 0x01de }
                int r3 = r3.getTotalSeats()     // Catch:{ Exception -> 0x01de }
                java.lang.String r3 = net.one97.paytm.o2o.movies.utils.n.b((int) r7, (int) r3)     // Catch:{ Exception -> 0x01de }
                r2.setSeatStatus(r3)     // Catch:{ Exception -> 0x01de }
                java.util.List r1 = r1.getSessions()     // Catch:{ Exception -> 0x01de }
                if (r1 == 0) goto L_0x01da
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x01de }
            L_0x01b7:
                boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x01de }
                if (r3 == 0) goto L_0x01d8
                java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r3 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession) r3     // Catch:{ Exception -> 0x01de }
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x01de }
                java.lang.String r3 = r3.getSessionID()     // Catch:{ Exception -> 0x01de }
                net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink$MovieSeatLayoutHolder r7 = r0.f74099b     // Catch:{ Exception -> 0x01de }
                java.lang.String r7 = r7.f74093d     // Catch:{ Exception -> 0x01de }
                boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r6)     // Catch:{ Exception -> 0x01de }
                if (r3 == 0) goto L_0x01d5
                goto L_0x01da
            L_0x01d5:
                int r5 = r5 + 1
                goto L_0x01b7
            L_0x01d8:
                r1 = -1
                r5 = -1
            L_0x01da:
                r2.setMovieSessionPosition(r5)     // Catch:{ Exception -> 0x01de }
                return r2
            L_0x01de:
                java.lang.Exception r1 = new java.lang.Exception
                r1.<init>()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRSeatLayoutDeeplink.b.call():net.one97.paytm.o2o.movies.entity.SeatMapData");
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRSeatLayoutDeeplink f74096a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MovieSeatLayoutHolder f74097b;

        a(AJRSeatLayoutDeeplink aJRSeatLayoutDeeplink, MovieSeatLayoutHolder movieSeatLayoutHolder) {
            this.f74096a = aJRSeatLayoutDeeplink;
            this.f74097b = movieSeatLayoutHolder;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f74096a.b();
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (!(iJRPaytmDataModel instanceof CJRMovieDataResponse)) {
                iJRPaytmDataModel = null;
            }
            CJRMovieDataResponse cJRMovieDataResponse = (CJRMovieDataResponse) iJRPaytmDataModel;
            if (cJRMovieDataResponse != null) {
                y.a(new b(cJRMovieDataResponse, this.f74097b)).b(io.reactivex.rxjava3.i.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).a(new c(this.f74096a), (g<? super Throwable>) new d(this.f74096a));
            }
        }
    }

    public static final class MovieSeatLayoutHolder implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f74090a;

        /* renamed from: b  reason: collision with root package name */
        String f74091b;

        /* renamed from: c  reason: collision with root package name */
        String f74092c;

        /* renamed from: d  reason: collision with root package name */
        String f74093d;

        /* renamed from: e  reason: collision with root package name */
        String f74094e;

        /* renamed from: f  reason: collision with root package name */
        private String f74095f;

        public static class a implements Parcelable.Creator {
            public final Object createFromParcel(Parcel parcel) {
                k.c(parcel, "in");
                return new MovieSeatLayoutHolder(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Object[] newArray(int i2) {
                return new MovieSeatLayoutHolder[i2];
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MovieSeatLayoutHolder)) {
                return false;
            }
            MovieSeatLayoutHolder movieSeatLayoutHolder = (MovieSeatLayoutHolder) obj;
            return k.a((Object) this.f74090a, (Object) movieSeatLayoutHolder.f74090a) && k.a((Object) this.f74095f, (Object) movieSeatLayoutHolder.f74095f) && k.a((Object) this.f74091b, (Object) movieSeatLayoutHolder.f74091b) && k.a((Object) this.f74092c, (Object) movieSeatLayoutHolder.f74092c) && k.a((Object) this.f74093d, (Object) movieSeatLayoutHolder.f74093d) && k.a((Object) this.f74094e, (Object) movieSeatLayoutHolder.f74094e);
        }

        public final int hashCode() {
            String str = this.f74090a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f74095f;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f74091b;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f74092c;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f74093d;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.f74094e;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            return hashCode5 + i2;
        }

        public final String toString() {
            return "MovieSeatLayoutHolder(cityValue=" + this.f74090a + ", cityName=" + this.f74095f + ", cinemaId=" + this.f74091b + ", movieCode=" + this.f74092c + ", sessionId=" + this.f74093d + ", fromDate=" + this.f74094e + ")";
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            k.c(parcel, "parcel");
            parcel.writeString(this.f74090a);
            parcel.writeString(this.f74095f);
            parcel.writeString(this.f74091b);
            parcel.writeString(this.f74092c);
            parcel.writeString(this.f74093d);
            parcel.writeString(this.f74094e);
        }

        public MovieSeatLayoutHolder(String str, String str2, String str3, String str4, String str5, String str6) {
            this.f74090a = str;
            this.f74095f = str2;
            this.f74091b = str3;
            this.f74092c = str4;
            this.f74093d = str5;
            this.f74094e = str6;
        }
    }

    static final class d<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRSeatLayoutDeeplink f74101a;

        d(AJRSeatLayoutDeeplink aJRSeatLayoutDeeplink) {
            this.f74101a = aJRSeatLayoutDeeplink;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f74101a.b();
        }
    }
}
