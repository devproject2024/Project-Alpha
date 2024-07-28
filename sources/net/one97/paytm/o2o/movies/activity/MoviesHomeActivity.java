package net.one97.paytm.o2o.movies.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.al;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.widgets.callback.ActivityListener;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.LayoutType;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity;
import net.one97.paytm.o2o.movies.adapter.ad;
import net.one97.paytm.o2o.movies.adapter.ai;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.adapter.ar;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.common.customui.SlidingViewPager;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem;
import net.one97.paytm.o2o.movies.common.widgets.CJRCustomRecyclerView;
import net.one97.paytm.o2o.movies.entity.CJRAmenity;
import net.one97.paytm.o2o.movies.entity.CJRBookedMovieTicket;
import net.one97.paytm.o2o.movies.entity.CJRCinemaV1;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.entity.CJRGetMetricInfoResponse;
import net.one97.paytm.o2o.movies.entity.CJRHomePageResponse;
import net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem;
import net.one97.paytm.o2o.movies.entity.CJRMetricInfoMeta;
import net.one97.paytm.o2o.movies.entity.Optional;
import net.one97.paytm.o2o.movies.entity.events.Carousel;
import net.one97.paytm.o2o.movies.entity.events.Category;
import net.one97.paytm.o2o.movies.entity.events.DigitalEvent;
import net.one97.paytm.o2o.movies.entity.events.Events;
import net.one97.paytm.o2o.movies.moviepass.activity.AJRMoviePassHomePageActivity;
import net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout;
import net.one97.paytm.o2o.movies.utils.DynamicHeightViewPager;
import net.one97.paytm.o2o.movies.utils.l;
import net.one97.paytm.orders.datamodel.CJRQRImageModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class MoviesHomeActivity extends AppBaseActivity implements ActivityListener, ad.a, ai.a, aj.a, y.i, y.j, l.a {
    private final int A = 101;
    private final BroadcastReceiver B = new MoviesHomeActivity$mLoginEventReceiver$1(this);
    private HashMap C;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public CJRMovieHomeDataResponse f74168a;

    /* renamed from: b  reason: collision with root package name */
    public al.b f74169b;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.o2o.movies.viewmodel.c f74170c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRBookedMovieTicket> f74171d;

    /* renamed from: e  reason: collision with root package name */
    private CJRSelectCityModel f74172e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f74173f;

    /* renamed from: g  reason: collision with root package name */
    private CJRHomePageItem f74174g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f74175h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f74176i = "";
    /* access modifiers changed from: private */
    public ArrayList<CJRCinemas> j;
    /* access modifiers changed from: private */
    public ArrayList<CJRMoviesHomePageItem> k = new ArrayList<>(7);
    /* access modifiers changed from: private */
    public final CJRUpcomingMovies l;
    /* access modifiers changed from: private */
    public List<CJRAmenity> m;
    /* access modifiers changed from: private */
    public net.one97.paytm.o2o.movies.adapter.y n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public boolean q = true;
    /* access modifiers changed from: private */
    public CJRHomePageResponse.Language r;
    /* access modifiers changed from: private */
    public ArrayList<CJRMovieHomeListItem> s;
    /* access modifiers changed from: private */
    public ArrayList<CJRMovieHomeListItem> t;
    private ar u;
    private View v;
    private int[] w = new int[2];
    private io.reactivex.rxjava3.b.c x;
    /* access modifiers changed from: private */
    public int y;
    /* access modifiers changed from: private */
    public net.one97.paytm.o2o.movies.utils.l z;

    static final class g<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f74196a = new g();

        g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    public final View b(int i2) {
        if (this.C == null) {
            this.C = new HashMap();
        }
        View view = (View) this.C.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.C.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void c(boolean z2) {
    }

    static final class f<T> implements io.reactivex.rxjava3.d.g<Bundle> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74195a;

        f(MoviesHomeActivity moviesHomeActivity) {
            this.f74195a = moviesHomeActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            Bundle bundle = (Bundle) obj;
            MoviesHomeActivity moviesHomeActivity = this.f74195a;
            kotlin.g.b.k.a((Object) bundle, "bundle");
            MoviesHomeActivity.a(moviesHomeActivity, bundle);
        }
    }

    static final class h<T> implements androidx.lifecycle.z<com.google.gson.o> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74197a;

        h(MoviesHomeActivity moviesHomeActivity) {
            this.f74197a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            com.google.gson.o oVar = (com.google.gson.o) obj;
            kotlin.g.b.k.c(oVar, "data");
            net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
            kotlin.g.b.k.a((Object) a2, "CJRMovieSearchResponseHo…erSingleton.getInstance()");
            a2.l = oVar;
            net.one97.paytm.o2o.movies.adapter.y c2 = this.f74197a.n;
            if (c2 != null) {
                c2.f74814a = oVar;
                if (!(c2.f74818e == null || c2.f74818e.f74855b == null || c2.f74818e.f74855b.getAdapter() == null)) {
                    ((aj) c2.f74818e.f74855b.getAdapter()).a(oVar);
                }
            }
            net.one97.paytm.o2o.movies.adapter.y c3 = this.f74197a.n;
            if (c3 != null) {
                c3.notifyDataSetChanged();
            }
        }
    }

    static final class i<T> implements androidx.lifecycle.z<Events> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74198a;

        i(MoviesHomeActivity moviesHomeActivity) {
            this.f74198a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            List<Category> categories;
            List<Carousel> carousels;
            List<DigitalEvent> digitalEvents;
            Events events = (Events) obj;
            CJRMoviesHomePageItem cJRMoviesHomePageItem = new CJRMoviesHomePageItem();
            cJRMoviesHomePageItem.setRowType("event_movie_divider");
            this.f74198a.k.add(cJRMoviesHomePageItem);
            if (!(events == null || (digitalEvents = events.getDigitalEvents()) == null || digitalEvents.isEmpty())) {
                CJRMoviesHomePageItem cJRMoviesHomePageItem2 = new CJRMoviesHomePageItem();
                cJRMoviesHomePageItem2.setRowType("digital_event");
                cJRMoviesHomePageItem2.setDigitalEvents(digitalEvents);
                cJRMoviesHomePageItem2.setDigitalEventTitle(events.getDigitalEventsTitleText());
                cJRMoviesHomePageItem2.setDigitalEventDescription(events.getDigitalEventsDescription());
                this.f74198a.k.add(cJRMoviesHomePageItem2);
            }
            if (!(events == null || (carousels = events.getCarousels()) == null || carousels.isEmpty())) {
                for (Carousel eventCarousel : carousels) {
                    CJRMoviesHomePageItem cJRMoviesHomePageItem3 = new CJRMoviesHomePageItem();
                    cJRMoviesHomePageItem3.setEventCarousel(eventCarousel);
                    cJRMoviesHomePageItem3.setRowType("event_carousel");
                    this.f74198a.k.add(cJRMoviesHomePageItem3);
                }
            }
            if (!(events == null || (categories = events.getCategories()) == null || categories.isEmpty())) {
                CJRMoviesHomePageItem cJRMoviesHomePageItem4 = new CJRMoviesHomePageItem();
                cJRMoviesHomePageItem4.setEventCategories(categories);
                cJRMoviesHomePageItem4.setRowType("event_categories");
                cJRMoviesHomePageItem4.setCategoryTitle(events.getCategoryTitleText());
                this.f74198a.k.add(cJRMoviesHomePageItem4);
            }
            net.one97.paytm.o2o.movies.adapter.y c2 = this.f74198a.n;
            if (c2 != null) {
                c2.notifyDataSetChanged();
            }
        }
    }

    static final class j<T> implements androidx.lifecycle.z<CJRHomePageResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74199a;

        j(MoviesHomeActivity moviesHomeActivity) {
            this.f74199a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            ArrayList f2;
            CJRHomePageResponse cJRHomePageResponse = (CJRHomePageResponse) obj;
            kotlin.g.b.k.c(cJRHomePageResponse, "cjrMoviesHomePageItems");
            int i2 = 0;
            ((RelativeLayout) this.f74199a.b(R.id.root_search_lyt)).setVisibility(0);
            this.f74199a.f74171d = cJRHomePageResponse.bookedMovieTicketList;
            if (this.f74199a.f74171d == null || ((f2 = this.f74199a.f74171d) != null && f2.size() == 0)) {
                MoviesHomeActivity.h(this.f74199a);
            } else {
                MoviesHomeActivity.g(this.f74199a);
            }
            MoviesHomeActivity moviesHomeActivity = this.f74199a;
            moviesHomeActivity.k = MoviesHomeActivity.a(moviesHomeActivity, cJRHomePageResponse);
            if (!(this.f74199a.l == null || this.f74199a.l.getUpcomingMovieData() == null || this.f74199a.l.getUpcomingMovieData().size() <= 0)) {
                int size = this.f74199a.k.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i3 = -1;
                        break;
                    } else if (kotlin.m.p.a(((CJRMoviesHomePageItem) this.f74199a.k.get(i3)).getRowType(), "upcoming_movies", true)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 == -1) {
                    CJRMoviesHomePageItem cJRMoviesHomePageItem = new CJRMoviesHomePageItem();
                    cJRMoviesHomePageItem.setItemTitle(this.f74199a.getResources().getString(R.string.upcoming_movies));
                    cJRMoviesHomePageItem.setRowType("upcoming_movies");
                    cJRMoviesHomePageItem.setmUpcomingMovies(this.f74199a.l);
                    this.f74199a.k.add(cJRMoviesHomePageItem);
                }
            }
            if (this.f74199a.j != null) {
                int size2 = this.f74199a.k.size();
                while (true) {
                    if (i2 >= size2) {
                        i2 = -1;
                        break;
                    } else if (kotlin.m.p.a(((CJRMoviesHomePageItem) this.f74199a.k.get(i2)).getRowType(), "cinemas", true)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == -1) {
                    CJRMoviesHomePageItem cJRMoviesHomePageItem2 = new CJRMoviesHomePageItem();
                    cJRMoviesHomePageItem2.setRowType("cinemas");
                    cJRMoviesHomePageItem2.setCinemaListV1(this.f74199a.j);
                    cJRMoviesHomePageItem2.setBannerList((CJRHomePageLayoutV2) null);
                    net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
                    kotlin.g.b.k.a((Object) a2, "instance");
                    a2.f75933c = this.f74199a.j;
                    a2.f75935e = this.f74199a.m;
                    this.f74199a.k.add(cJRMoviesHomePageItem2);
                }
            }
            String e2 = kotlin.m.p.a("movie-details", this.f74199a.f74175h, true) ? "movietickets" : this.f74199a.f74175h;
            this.f74199a.f74168a = cJRHomePageResponse.cjrMovieHomeDataResponse;
            MoviesHomeActivity moviesHomeActivity2 = this.f74199a;
            int m = moviesHomeActivity2.o;
            ArrayList i4 = this.f74199a.k;
            MoviesHomeActivity moviesHomeActivity3 = this.f74199a;
            CJRSelectCityModel cJRSelectCityModel = moviesHomeActivity3.a().u.f75234d;
            MoviesHomeActivity moviesHomeActivity4 = this.f74199a;
            moviesHomeActivity2.n = new net.one97.paytm.o2o.movies.adapter.y(moviesHomeActivity2, m, i4, moviesHomeActivity3, cJRSelectCityModel, e2, moviesHomeActivity4, moviesHomeActivity4);
            ((CJRCustomRecyclerView) this.f74199a.b(R.id.movie_home_page_list)).setAdapter(this.f74199a.n);
            ((CJRCustomRecyclerView) this.f74199a.b(R.id.movie_home_page_list)).postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ j f74200a;

                {
                    this.f74200a = r1;
                }

                public final void run() {
                    try {
                        RecyclerView.LayoutManager layoutManager = ((CJRCustomRecyclerView) this.f74200a.f74199a.b(R.id.movie_home_page_list)).getLayoutManager();
                        if (layoutManager != null) {
                            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
                            return;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    } catch (Exception unused) {
                    }
                }
            }, 250);
            this.f74199a.b(false);
        }
    }

    static final class k<T> implements androidx.lifecycle.z<Optional<CJRHomePageV2>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74201a;

        k(MoviesHomeActivity moviesHomeActivity) {
            this.f74201a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Optional optional = (Optional) obj;
            kotlin.g.b.k.c(optional, "cjrHomePageV2Optional");
            if (!optional.isEmpty()) {
                CJRHomePageV2 cJRHomePageV2 = (CJRHomePageV2) optional.get();
                MoviesHomeActivity moviesHomeActivity = this.f74201a;
                moviesHomeActivity.a();
                kotlin.g.b.k.a((Object) cJRHomePageV2, "cjrHomePageV2");
                MoviesHomeActivity.a(moviesHomeActivity, net.one97.paytm.o2o.movies.viewmodel.c.a(cJRHomePageV2));
                this.f74201a.a();
                ArrayList<CJRHomePageLayoutV2> b2 = net.one97.paytm.o2o.movies.viewmodel.c.b(cJRHomePageV2);
                if (b2.size() > 0) {
                    Iterator<CJRHomePageLayoutV2> it2 = b2.iterator();
                    while (it2.hasNext()) {
                        CJRHomePageLayoutV2 next = it2.next();
                        CJRMoviesHomePageItem cJRMoviesHomePageItem = new CJRMoviesHomePageItem();
                        kotlin.g.b.k.a((Object) next, "banner");
                        cJRMoviesHomePageItem.setItemTitle(next.getName());
                        if (kotlin.m.p.a(next.getLayout(), LayoutType.LAYOUT_CAROUSEL4.getName(), true) || kotlin.m.p.a(next.getLayout(), LayoutType.LAYOUT_CAROUSEL_4.getName(), true)) {
                            cJRMoviesHomePageItem.setRowType("carousel_4");
                        } else if (kotlin.m.p.a(next.getLayout(), LayoutType.LAYOUT_CAROUSEL5.getName(), true) || kotlin.m.p.a(next.getLayout(), LayoutType.LAYOUT_CAROUSEL_5.getName(), true)) {
                            cJRMoviesHomePageItem.setRowType("carousel_5");
                        }
                        cJRMoviesHomePageItem.setBannerList(next);
                        if (this.f74201a.a().u.f75234d != null) {
                            CJRSelectCityModel cJRSelectCityModel = this.f74201a.a().u.f75234d;
                            String str = null;
                            if (!TextUtils.isEmpty(cJRSelectCityModel != null ? cJRSelectCityModel.getLabel() : null)) {
                                CJRSelectCityModel cJRSelectCityModel2 = this.f74201a.a().u.f75234d;
                                if (cJRSelectCityModel2 != null) {
                                    str = cJRSelectCityModel2.getLabel();
                                }
                                cJRMoviesHomePageItem.setSelectedLocation(str);
                                this.f74201a.k.add(cJRMoviesHomePageItem);
                            }
                        }
                        cJRMoviesHomePageItem.setSelectedLocation(this.f74201a.getResources().getString(R.string.movies_location_activity_title));
                        this.f74201a.k.add(cJRMoviesHomePageItem);
                    }
                }
                net.one97.paytm.o2o.movies.adapter.y c2 = this.f74201a.n;
                if (c2 != null) {
                    c2.notifyDataSetChanged();
                }
            }
        }
    }

    static final class l<T> implements androidx.lifecycle.z<SanitizedResponseModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74202a;

        l(MoviesHomeActivity moviesHomeActivity) {
            this.f74202a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SanitizedResponseModel sanitizedResponseModel = (SanitizedResponseModel) obj;
            kotlin.g.b.k.c(sanitizedResponseModel, "sanitizedResponseModel");
            MoviesHomeActivity.a(this.f74202a, sanitizedResponseModel);
        }
    }

    static final class m<T> implements androidx.lifecycle.z<CJRMoviePassHomeModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74203a;

        m(MoviesHomeActivity moviesHomeActivity) {
            this.f74203a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            MoviesHomeActivity.a(this.f74203a, (CJRMoviePassHomeModel) obj);
        }
    }

    static final class n<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74206a;

        n(MoviesHomeActivity moviesHomeActivity) {
            this.f74206a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                if (this.f74206a.z != null) {
                    this.f74206a.p = true;
                    net.one97.paytm.o2o.movies.utils.l o = this.f74206a.z;
                    if (o == null) {
                        kotlin.g.b.k.a();
                    }
                    if (o.f75957d) {
                        try {
                            if ((androidx.core.app.a.a(o.f75959f, "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a(o.f75959f, "android.permission.ACCESS_COARSE_LOCATION") == 0) && o.a()) {
                                o.f75954a.a(o.f75955b, o.f75956c, (Looper) null);
                            } else {
                                o.f75958e.c();
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        o.f75958e.b();
                    }
                }
                this.f74206a.a().f76068h.setValue(Boolean.FALSE);
            }
        }
    }

    static final class o<T> implements androidx.lifecycle.z<Optional<CJRCinemaV1>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74207a;

        o(MoviesHomeActivity moviesHomeActivity) {
            this.f74207a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Optional optional = (Optional) obj;
            if (optional != null && !optional.isEmpty()) {
                MoviesHomeActivity moviesHomeActivity = this.f74207a;
                Object obj2 = optional.get();
                kotlin.g.b.k.a(obj2, "cjrCinemaV1Optional.get()");
                moviesHomeActivity.j = ((CJRCinemaV1) obj2).getCinemas();
                MoviesHomeActivity moviesHomeActivity2 = this.f74207a;
                Object obj3 = optional.get();
                kotlin.g.b.k.a(obj3, "cjrCinemaV1Optional.get()");
                moviesHomeActivity2.m = ((CJRCinemaV1) obj3).getCjrAmenities();
                if (this.f74207a.k != null) {
                    Iterator it2 = this.f74207a.k.iterator();
                    int i2 = -1;
                    while (it2.hasNext()) {
                        CJRMoviesHomePageItem cJRMoviesHomePageItem = (CJRMoviesHomePageItem) it2.next();
                        kotlin.g.b.k.a((Object) cJRMoviesHomePageItem, "cjrMoviesHomePageItem");
                        if (kotlin.m.p.a(cJRMoviesHomePageItem.getRowType(), "upcoming_movies", true)) {
                            i2 = this.f74207a.k.indexOf(cJRMoviesHomePageItem);
                        }
                    }
                    if (i2 != -1) {
                        int i3 = 0;
                        int size = this.f74207a.k.size();
                        while (true) {
                            if (i3 >= size) {
                                i3 = -1;
                                break;
                            } else if (kotlin.m.p.a(((CJRMoviesHomePageItem) this.f74207a.k.get(i3)).getRowType(), "cinemas", true)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (i3 == -1) {
                            CJRMoviesHomePageItem cJRMoviesHomePageItem2 = new CJRMoviesHomePageItem();
                            cJRMoviesHomePageItem2.setRowType("cinemas");
                            cJRMoviesHomePageItem2.setCinemaListV1(this.f74207a.j);
                            cJRMoviesHomePageItem2.setBannerList((CJRHomePageLayoutV2) null);
                            net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
                            kotlin.g.b.k.a((Object) a2, "instance");
                            a2.f75933c = this.f74207a.j;
                            a2.f75935e = this.f74207a.m;
                            this.f74207a.k.add(i2 + 1, cJRMoviesHomePageItem2);
                            net.one97.paytm.o2o.movies.adapter.y c2 = this.f74207a.n;
                            if (c2 != null) {
                                c2.notifyDataSetChanged();
                            }
                        }
                    }
                }
            }
        }
    }

    static final class p<T> implements androidx.lifecycle.z<Optional<CJRGetMetricInfoResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74208a;

        p(MoviesHomeActivity moviesHomeActivity) {
            this.f74208a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            Optional optional = (Optional) obj;
            if (optional != null) {
                try {
                    if (!optional.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        CJRMetricInfoMeta metaData = ((CJRGetMetricInfoResponse) optional.get()).getMetaData();
                        HashMap<String, CJRMetricInfoDataItem> data = ((CJRGetMetricInfoResponse) optional.get()).getData();
                        if (!(data == null || metaData == null || metaData.getMovieMappings() == null)) {
                            HashMap<String, String> movieMappings = metaData.getMovieMappings();
                            if (movieMappings == null) {
                                kotlin.g.b.k.a();
                            }
                            Set<String> keySet = movieMappings.keySet();
                            kotlin.g.b.k.a((Object) keySet, "cjrMetricInfoMeta.movieMappings!!.keys");
                            for (String next : keySet) {
                                Map map = hashMap;
                                Map map2 = data;
                                HashMap<String, String> movieMappings2 = metaData.getMovieMappings();
                                if (movieMappings2 == null) {
                                    kotlin.g.b.k.a();
                                }
                                if (movieMappings2.get(next) != null) {
                                    HashMap<String, String> movieMappings3 = metaData.getMovieMappings();
                                    if (movieMappings3 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    str = String.valueOf(movieMappings3.get(next));
                                } else {
                                    str = null;
                                }
                                map.put(next, map2.get(str));
                            }
                        }
                        Iterator it2 = this.f74208a.k.iterator();
                        while (it2.hasNext()) {
                            CJRMoviesHomePageItem cJRMoviesHomePageItem = (CJRMoviesHomePageItem) it2.next();
                            kotlin.g.b.k.a((Object) cJRMoviesHomePageItem, "cjrMoviesHomePageItem");
                            if (kotlin.m.p.a(cJRMoviesHomePageItem.getRowType(), "top_movies", true)) {
                                if (cJRMoviesHomePageItem.getMoviesListV2() != null) {
                                    Iterator<CJRMovieHomeListItem> it3 = cJRMoviesHomePageItem.getMoviesListV2().iterator();
                                    while (it3.hasNext()) {
                                        CJRMovieHomeListItem next2 = it3.next();
                                        next2.setLikeDislikeInfo((CJRMetricInfoDataItem) hashMap.get(next2.getId()));
                                    }
                                    net.one97.paytm.o2o.movies.adapter.y c2 = this.f74208a.n;
                                    if (c2 != null) {
                                        c2.notifyDataSetChanged();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    kotlin.g.b.k.c(e2, "exception");
                }
            }
        }
    }

    static final class q<T> implements androidx.lifecycle.z<Optional<CJRUpcomingMovies>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74209a;

        q(MoviesHomeActivity moviesHomeActivity) {
            this.f74209a = moviesHomeActivity;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00f8  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x016a  */
        /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r11) {
            /*
                r10 = this;
                net.one97.paytm.o2o.movies.entity.Optional r11 = (net.one97.paytm.o2o.movies.entity.Optional) r11
                java.lang.String r0 = "upcomingMoviesOptional"
                kotlin.g.b.k.c(r11, r0)
                java.lang.Object r11 = r11.get()
                net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies r11 = (net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies) r11
                java.lang.String r0 = "cjrMoviesHomePageItem"
                java.lang.String r1 = "upcoming_movies"
                r2 = 0
                r3 = -1
                r4 = 1
                if (r11 == 0) goto L_0x00b6
                java.util.List r5 = r11.getUpcomingMovieData()
                if (r5 == 0) goto L_0x00b6
                java.util.List r5 = r11.getUpcomingMovieData()
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x00b6
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r5 = r10.f74209a
                java.util.ArrayList r5 = r5.k
                if (r5 == 0) goto L_0x00b6
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r5 = r10.f74209a
                java.util.ArrayList r5 = r5.k
                java.util.Iterator r5 = r5.iterator()
                r6 = -1
            L_0x003b:
                boolean r7 = r5.hasNext()
                if (r7 == 0) goto L_0x0062
                java.lang.Object r7 = r5.next()
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem r7 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem) r7
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
                java.lang.String r8 = r7.getRowType()
                java.lang.String r9 = "top_movies"
                boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r4)
                if (r8 == 0) goto L_0x003b
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r6 = r10.f74209a
                java.util.ArrayList r6 = r6.k
                int r6 = r6.indexOf(r7)
                goto L_0x003b
            L_0x0062:
                if (r6 == r3) goto L_0x00b6
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r5 = r10.f74209a
                java.util.ArrayList r5 = r5.k
                java.util.Collection r5 = (java.util.Collection) r5
                int r5 = r5.size()
                r7 = 0
            L_0x0071:
                if (r7 >= r5) goto L_0x008d
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r8 = r10.f74209a
                java.util.ArrayList r8 = r8.k
                java.lang.Object r8 = r8.get(r7)
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem r8 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem) r8
                java.lang.String r8 = r8.getRowType()
                boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r4)
                if (r8 == 0) goto L_0x008a
                goto L_0x008e
            L_0x008a:
                int r7 = r7 + 1
                goto L_0x0071
            L_0x008d:
                r7 = -1
            L_0x008e:
                if (r7 != r3) goto L_0x00b6
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem r5 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem
                r5.<init>()
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r7 = r10.f74209a
                android.content.res.Resources r7 = r7.getResources()
                int r8 = net.one97.paytm.o2o.movies.R.string.upcoming_movies
                java.lang.String r7 = r7.getString(r8)
                r5.setItemTitle(r7)
                r5.setRowType(r1)
                r5.setmUpcomingMovies(r11)
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r11 = r10.f74209a
                java.util.ArrayList r11 = r11.k
                int r6 = r6 + r4
                r11.add(r6, r5)
                r11 = 1
                goto L_0x00b7
            L_0x00b6:
                r11 = 0
            L_0x00b7:
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r5 = r10.f74209a
                java.util.ArrayList r5 = r5.k
                if (r5 == 0) goto L_0x0160
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r5 = r10.f74209a
                java.util.ArrayList r5 = r5.j
                if (r5 == 0) goto L_0x0160
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r5 = r10.f74209a
                java.util.ArrayList r5 = r5.k
                java.util.Iterator r5 = r5.iterator()
                r6 = -1
            L_0x00d2:
                boolean r7 = r5.hasNext()
                if (r7 == 0) goto L_0x00f6
                java.lang.Object r7 = r5.next()
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem r7 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem) r7
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
                java.lang.String r8 = r7.getRowType()
                boolean r8 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r1, (boolean) r4)
                if (r8 == 0) goto L_0x00d2
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r6 = r10.f74209a
                java.util.ArrayList r6 = r6.k
                int r6 = r6.indexOf(r7)
                goto L_0x00d2
            L_0x00f6:
                if (r6 == r3) goto L_0x0160
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r0 = r10.f74209a
                java.util.ArrayList r0 = r0.k
                java.util.Collection r0 = (java.util.Collection) r0
                int r0 = r0.size()
            L_0x0104:
                java.lang.String r1 = "cinemas"
                if (r2 >= r0) goto L_0x0122
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r5 = r10.f74209a
                java.util.ArrayList r5 = r5.k
                java.lang.Object r5 = r5.get(r2)
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem r5 = (net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem) r5
                java.lang.String r5 = r5.getRowType()
                boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r1, (boolean) r4)
                if (r5 == 0) goto L_0x011f
                goto L_0x0123
            L_0x011f:
                int r2 = r2 + 1
                goto L_0x0104
            L_0x0122:
                r2 = -1
            L_0x0123:
                if (r2 != r3) goto L_0x0160
                net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem r11 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesHomePageItem
                r11.<init>()
                r11.setRowType(r1)
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r0 = r10.f74209a
                java.util.ArrayList r0 = r0.j
                java.util.List r0 = (java.util.List) r0
                r11.setCinemaListV1(r0)
                r0 = 0
                r11.setBannerList(r0)
                net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
                java.lang.String r1 = "instance"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r1 = r10.f74209a
                java.util.ArrayList r1 = r1.j
                r0.f75933c = r1
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r1 = r10.f74209a
                java.util.List r1 = r1.m
                r0.f75935e = r1
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r0 = r10.f74209a
                java.util.ArrayList r0 = r0.k
                int r6 = r6 + r4
                r0.add(r6, r11)
                r11 = 1
            L_0x0160:
                if (r11 == 0) goto L_0x016d
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r11 = r10.f74209a
                net.one97.paytm.o2o.movies.adapter.y r11 = r11.n
                if (r11 == 0) goto L_0x016d
                r11.notifyDataSetChanged()
            L_0x016d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.MoviesHomeActivity.q.onChanged(java.lang.Object):void");
        }
    }

    static final class r<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74210a;

        r(MoviesHomeActivity moviesHomeActivity) {
            this.f74210a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                RelativeLayout relativeLayout = (RelativeLayout) this.f74210a.b(R.id.lyt_progress_bar);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                try {
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.f74210a.b(R.id.movies_home_shimmer);
                    if (shimmerFrameLayout != null && !shimmerFrameLayout.f49623a) {
                        shimmerFrameLayout.a();
                    }
                } catch (Exception e2) {
                    kotlin.g.b.k.c(e2, "exception");
                }
            } else {
                RelativeLayout relativeLayout2 = (RelativeLayout) this.f74210a.b(R.id.lyt_progress_bar);
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
                try {
                    ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) this.f74210a.b(R.id.movies_home_shimmer);
                    if (shimmerFrameLayout2 != null && shimmerFrameLayout2.f49623a) {
                        shimmerFrameLayout2.b();
                    }
                } catch (Exception e3) {
                    kotlin.g.b.k.c(e3, "exception");
                }
            }
        }
    }

    static final class t<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74212a;

        t(MoviesHomeActivity moviesHomeActivity) {
            this.f74212a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                LinearLayout linearLayout = (LinearLayout) this.f74212a.b(R.id.no_network);
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                    return;
                }
                return;
            }
            LinearLayout linearLayout2 = (LinearLayout) this.f74212a.b(R.id.no_network);
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    static final class u<T> implements androidx.lifecycle.z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74213a;

        u(MoviesHomeActivity moviesHomeActivity) {
            this.f74213a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            if (kotlin.m.p.a(str, "gone", true)) {
                RoboTextView roboTextView = (RoboTextView) this.f74213a.b(R.id.movie_location);
                if (roboTextView != null) {
                    net.one97.paytm.o2o.movies.common.a.e.a(roboTextView, false);
                    return;
                }
                return;
            }
            RoboTextView roboTextView2 = (RoboTextView) this.f74213a.b(R.id.movie_location);
            if (roboTextView2 != null) {
                net.one97.paytm.o2o.movies.common.a.e.a(roboTextView2, true);
            }
            RoboTextView roboTextView3 = (RoboTextView) this.f74213a.b(R.id.movie_location);
            if (roboTextView3 != null) {
                roboTextView3.setText(str);
            }
        }
    }

    static final class v<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74214a;

        v(MoviesHomeActivity moviesHomeActivity) {
            this.f74214a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                MoviesHomeActivity.a(this.f74214a);
            }
        }
    }

    static final class w<T> implements androidx.lifecycle.z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74215a;

        w(MoviesHomeActivity moviesHomeActivity) {
            this.f74215a = moviesHomeActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            kotlin.g.b.k.a((Object) bool, "it");
            if (bool.booleanValue()) {
                this.f74215a.h();
            }
        }
    }

    public final net.one97.paytm.o2o.movies.viewmodel.c a() {
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        return cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x042f, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L_0x0433;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x045c  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            super.onCreate(r12)
            int r12 = net.one97.paytm.o2o.movies.R.layout.activity_movies_home
            r11.setContentView((int) r12)
            net.one97.paytm.o2o.movies.a.a.a$a r12 = new net.one97.paytm.o2o.movies.a.a.a$a
            r0 = 0
            r12.<init>(r0)
            net.one97.paytm.o2o.movies.a.b.a r1 = new net.one97.paytm.o2o.movies.a.b.a
            r2 = r11
            android.content.Context r2 = (android.content.Context) r2
            r1.<init>(r2)
            java.lang.Object r1 = dagger.a.g.a(r1)
            net.one97.paytm.o2o.movies.a.b.a r1 = (net.one97.paytm.o2o.movies.a.b.a) r1
            r12.f73877b = r1
            net.one97.paytm.o2o.movies.a.b.c r1 = r12.f73876a
            if (r1 != 0) goto L_0x0029
            net.one97.paytm.o2o.movies.a.b.c r1 = new net.one97.paytm.o2o.movies.a.b.c
            r1.<init>()
            r12.f73876a = r1
        L_0x0029:
            net.one97.paytm.o2o.movies.a.b.a r1 = r12.f73877b
            java.lang.Class<net.one97.paytm.o2o.movies.a.b.a> r3 = net.one97.paytm.o2o.movies.a.b.a.class
            dagger.a.g.a(r1, r3)
            net.one97.paytm.o2o.movies.a.a.a r1 = new net.one97.paytm.o2o.movies.a.a.a
            net.one97.paytm.o2o.movies.a.b.c r3 = r12.f73876a
            net.one97.paytm.o2o.movies.a.b.a r12 = r12.f73877b
            r1.<init>(r3, r12, r0)
            r1.a(r11)
            r12 = r11
            androidx.fragment.app.FragmentActivity r12 = (androidx.fragment.app.FragmentActivity) r12
            androidx.lifecycle.al$b r1 = r11.f74169b
            if (r1 != 0) goto L_0x0049
            java.lang.String r3 = "viewModelFactory"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0049:
            androidx.lifecycle.al r12 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r12, (androidx.lifecycle.al.b) r1)
            java.lang.Class<net.one97.paytm.o2o.movies.viewmodel.c> r1 = net.one97.paytm.o2o.movies.viewmodel.c.class
            androidx.lifecycle.ai r12 = r12.a(r1)
            java.lang.String r1 = "ViewModelProviders.of(th…omeViewModel::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = (net.one97.paytm.o2o.movies.viewmodel.c) r12
            r11.f74170c = r12
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            java.lang.String r1 = "moviesHomeViewModel"
            if (r12 != 0) goto L_0x0065
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0065:
            android.content.Context r3 = r11.getApplicationContext()
            java.lang.String r4 = "applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = "context"
            kotlin.g.b.k.c(r3, r4)
            r12.f76061a = r3
            android.content.Intent r12 = r11.getIntent()
            r11.a((android.content.Intent) r12)
            androidx.localbroadcastmanager.a.a r12 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r2)
            android.content.BroadcastReceiver r3 = r11.B
            android.content.IntentFilter r5 = new android.content.IntentFilter
            java.lang.String r6 = "login_event"
            r5.<init>(r6)
            r12.a(r3, r5)
            net.one97.paytm.o2o.movies.utils.l r12 = new net.one97.paytm.o2o.movies.utils.l
            r3 = r11
            net.one97.paytm.o2o.movies.utils.l$a r3 = (net.one97.paytm.o2o.movies.utils.l.a) r3
            r12.<init>(r2, r3)
            r11.z = r12
            r12 = 16
            int r12 = net.one97.paytm.o2o.movies.utils.n.a((int) r12, (android.content.Context) r2)
            r11.y = r12
            int r12 = net.one97.paytm.o2o.movies.R.id.moviepass_offers_llt
            android.view.View r12 = r11.b((int) r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            java.lang.String r3 = "moviepass_offers_llt"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            r3 = 4
            r12.setVisibility(r3)
            int r12 = net.one97.paytm.o2o.movies.R.id.image_pager
            android.view.View r12 = r11.b((int) r12)
            net.one97.paytm.o2o.movies.common.customui.SlidingViewPager r12 = (net.one97.paytm.o2o.movies.common.customui.SlidingViewPager) r12
            android.content.Context r12 = r12.getContext()
            int r12 = net.one97.paytm.o2o.movies.utils.n.b((android.content.Context) r12)
            int r3 = net.one97.paytm.o2o.movies.R.id.image_pager
            android.view.View r3 = r11.b((int) r3)
            net.one97.paytm.o2o.movies.common.customui.SlidingViewPager r3 = (net.one97.paytm.o2o.movies.common.customui.SlidingViewPager) r3
            android.content.Context r3 = r3.getContext()
            r5 = 20
            int r3 = net.one97.paytm.o2o.movies.utils.n.a((int) r5, (android.content.Context) r3)
            int r3 = r12 - r3
            float r3 = (float) r3
            r6 = 1071141356(0x3fd851ec, float:1.69)
            float r3 = r3 / r6
            int r3 = (int) r3
            android.widget.LinearLayout$LayoutParams r6 = new android.widget.LinearLayout$LayoutParams
            r6.<init>(r12, r3)
            int r12 = net.one97.paytm.o2o.movies.utils.n.a((int) r5, (android.content.Context) r2)
            r6.bottomMargin = r12
            int r12 = net.one97.paytm.o2o.movies.R.id.image_pager
            android.view.View r12 = r11.b((int) r12)
            net.one97.paytm.o2o.movies.common.customui.SlidingViewPager r12 = (net.one97.paytm.o2o.movies.common.customui.SlidingViewPager) r12
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            r12.setLayoutParams(r6)
            int r12 = net.one97.paytm.o2o.movies.R.id.image_pager     // Catch:{ Exception -> 0x010f }
            android.view.View r12 = r11.b((int) r12)     // Catch:{ Exception -> 0x010f }
            net.one97.paytm.o2o.movies.common.customui.SlidingViewPager r12 = (net.one97.paytm.o2o.movies.common.customui.SlidingViewPager) r12     // Catch:{ Exception -> 0x010f }
            int r2 = net.one97.paytm.o2o.movies.R.id.image_pager     // Catch:{ Exception -> 0x010f }
            android.view.View r2 = r11.b((int) r2)     // Catch:{ Exception -> 0x010f }
            net.one97.paytm.o2o.movies.common.customui.SlidingViewPager r2 = (net.one97.paytm.o2o.movies.common.customui.SlidingViewPager) r2     // Catch:{ Exception -> 0x010f }
            android.content.Context r2 = r2.getContext()     // Catch:{ Exception -> 0x010f }
            int r3 = net.one97.paytm.o2o.movies.R.drawable.movie_home_top_banner_placeholder     // Catch:{ Exception -> 0x010f }
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)     // Catch:{ Exception -> 0x010f }
            r12.setBackground(r2)     // Catch:{ Exception -> 0x010f }
            goto L_0x012c
        L_0x010f:
            int r12 = net.one97.paytm.o2o.movies.R.id.image_pager
            android.view.View r12 = r11.b((int) r12)
            net.one97.paytm.o2o.movies.common.customui.SlidingViewPager r12 = (net.one97.paytm.o2o.movies.common.customui.SlidingViewPager) r12
            int r2 = net.one97.paytm.o2o.movies.R.id.image_pager
            android.view.View r2 = r11.b((int) r2)
            net.one97.paytm.o2o.movies.common.customui.SlidingViewPager r2 = (net.one97.paytm.o2o.movies.common.customui.SlidingViewPager) r2
            android.content.Context r2 = r2.getContext()
            int r3 = net.one97.paytm.o2o.movies.R.color.white_smoke
            int r2 = androidx.core.content.b.c(r2, r3)
            r12.setBackgroundColor(r2)
        L_0x012c:
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x0133
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0133:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76062b
            r2 = r11
            androidx.lifecycle.q r2 = (androidx.lifecycle.q) r2
            r12.removeObservers(r2)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x0142
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0142:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76062b
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$r r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$r
            r3.<init>(r11)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r12.observe(r2, r3)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x0155
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0155:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76063c
            r12.removeObservers(r2)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x0161
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0161:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76063c
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$t r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$t
            r3.<init>(r11)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r12.observe(r2, r3)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x0174
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0174:
            androidx.lifecycle.y<java.lang.String> r12 = r12.f76065e
            r12.removeObservers(r2)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x0180
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0180:
            androidx.lifecycle.y<java.lang.String> r12 = r12.f76065e
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$u r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$u
            r3.<init>(r11)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r12.observe(r2, r3)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x0193
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0193:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76066f
            r12.removeObservers(r2)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x019f
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x019f:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76066f
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$v r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$v
            r3.<init>(r11)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r12.observe(r2, r3)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x01b2
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01b2:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76067g
            r12.removeObservers(r2)
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x01be
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x01be:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r12.f76067g
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$w r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$w
            r3.<init>(r11)
            androidx.lifecycle.z r3 = (androidx.lifecycle.z) r3
            r12.observe(r2, r3)
            int r12 = net.one97.paytm.o2o.movies.R.id.offers_btn
            android.view.View r12 = r11.b((int) r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$x r2 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$x
            r2.<init>(r11)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r12.setOnClickListener(r2)
            r12 = 1
            int r2 = net.one97.paytm.o2o.movies.R.id.sliding_layout     // Catch:{ Exception -> 0x0270 }
            android.view.View r2 = r11.b((int) r2)     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout r2 = (net.one97.paytm.o2o.movies.slidingPanel.SlidingUpPanelLayout) r2     // Catch:{ Exception -> 0x0270 }
            r2.setPanelHeight(r0)     // Catch:{ Exception -> 0x0270 }
            r11.q = r12     // Catch:{ Exception -> 0x0270 }
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_search_icon_lyt     // Catch:{ Exception -> 0x0270 }
            android.view.View r2 = r11.b((int) r2)     // Catch:{ Exception -> 0x0270 }
            androidx.appcompat.widget.AppCompatImageView r2 = (androidx.appcompat.widget.AppCompatImageView) r2     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$y r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$y     // Catch:{ Exception -> 0x0270 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x0270 }
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3     // Catch:{ Exception -> 0x0270 }
            r2.setOnClickListener(r3)     // Catch:{ Exception -> 0x0270 }
            int r2 = net.one97.paytm.o2o.movies.R.id.movie_location_lyt     // Catch:{ Exception -> 0x0270 }
            android.view.View r2 = r11.b((int) r2)     // Catch:{ Exception -> 0x0270 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$z r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$z     // Catch:{ Exception -> 0x0270 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x0270 }
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3     // Catch:{ Exception -> 0x0270 }
            r2.setOnClickListener(r3)     // Catch:{ Exception -> 0x0270 }
            int r2 = net.one97.paytm.o2o.movies.R.id.back_button     // Catch:{ Exception -> 0x0270 }
            android.view.View r2 = r11.b((int) r2)     // Catch:{ Exception -> 0x0270 }
            android.widget.ImageButton r2 = (android.widget.ImageButton) r2     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$aa r3 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$aa     // Catch:{ Exception -> 0x0270 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x0270 }
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3     // Catch:{ Exception -> 0x0270 }
            r2.setOnClickListener(r3)     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.common.c.b r2 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.common.c.c r2 = r2.f75033b     // Catch:{ Exception -> 0x0270 }
            r3 = r11
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ Exception -> 0x0270 }
            boolean r2 = r2.isMainActivityInstance(r3)     // Catch:{ Exception -> 0x0270 }
            if (r2 == 0) goto L_0x023f
            int r2 = net.one97.paytm.o2o.movies.R.id.back_button     // Catch:{ Exception -> 0x0270 }
            android.view.View r2 = r11.b((int) r2)     // Catch:{ Exception -> 0x0270 }
            android.widget.ImageButton r2 = (android.widget.ImageButton) r2     // Catch:{ Exception -> 0x0270 }
            java.lang.String r3 = "back_button"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0270 }
            r3 = 8
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0270 }
        L_0x023f:
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x0270 }
            r3 = r11
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x0270 }
            r2.<init>(r3, r12, r0)     // Catch:{ Exception -> 0x0270 }
            int r3 = net.one97.paytm.o2o.movies.R.id.movie_home_page_list     // Catch:{ Exception -> 0x0270 }
            android.view.View r3 = r11.b((int) r3)     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.common.widgets.CJRCustomRecyclerView r3 = (net.one97.paytm.o2o.movies.common.widgets.CJRCustomRecyclerView) r3     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$s r5 = new net.one97.paytm.o2o.movies.activity.MoviesHomeActivity$s     // Catch:{ Exception -> 0x0270 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x0270 }
            androidx.recyclerview.widget.RecyclerView$h r5 = (androidx.recyclerview.widget.RecyclerView.h) r5     // Catch:{ Exception -> 0x0270 }
            r3.addItemDecoration(r5)     // Catch:{ Exception -> 0x0270 }
            int r3 = net.one97.paytm.o2o.movies.R.id.movie_home_page_list     // Catch:{ Exception -> 0x0270 }
            android.view.View r3 = r11.b((int) r3)     // Catch:{ Exception -> 0x0270 }
            net.one97.paytm.o2o.movies.common.widgets.CJRCustomRecyclerView r3 = (net.one97.paytm.o2o.movies.common.widgets.CJRCustomRecyclerView) r3     // Catch:{ Exception -> 0x0270 }
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2     // Catch:{ Exception -> 0x0270 }
            r3.setLayoutManager(r2)     // Catch:{ Exception -> 0x0270 }
            r2 = r11
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x0270 }
            int r2 = com.paytm.utility.b.g((android.content.Context) r2)     // Catch:{ Exception -> 0x0270 }
            r11.o = r2     // Catch:{ Exception -> 0x0270 }
            goto L_0x0276
        L_0x0270:
            r2 = move-exception
            java.lang.String r3 = "exception"
            kotlin.g.b.k.c(r2, r3)
        L_0x0276:
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r11.f74170c
            if (r2 != 0) goto L_0x027d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x027d:
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r3 = r3.f75234d
            r5 = 0
            if (r3 == 0) goto L_0x039f
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r6 = r3.f75234d
            if (r6 == 0) goto L_0x0294
            android.content.Context r3 = r3.f75237g
            boolean r3 = net.one97.paytm.o2o.movies.common.d.c((android.content.Context) r3)
            if (r3 != 0) goto L_0x0294
            r3 = 1
            goto L_0x0295
        L_0x0294:
            r3 = 0
        L_0x0295:
            if (r3 == 0) goto L_0x039f
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            android.content.Context r3 = r3.f75237g
            boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)
            if (r3 == 0) goto L_0x0396
            androidx.lifecycle.y<java.lang.Boolean> r3 = r2.f76062b
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r3.postValue(r6)
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            androidx.lifecycle.y<java.lang.Boolean> r2 = r2.f76064d
            java.lang.String r6 = "loadHomePageData"
            kotlin.g.b.k.c(r2, r6)
            android.content.Context r7 = r3.f75237g
            net.one97.paytm.common.entity.CJRSelectCityModel r3 = r3.f75234d
            kotlin.g.b.k.c(r7, r4)
            kotlin.g.b.k.c(r2, r6)
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = "movieCityListV3"
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.c.a(r4, r5)     // Catch:{ Exception -> 0x0393 }
            boolean r6 = com.paytm.utility.b.c((android.content.Context) r7)     // Catch:{ Exception -> 0x0393 }
            if (r6 == 0) goto L_0x0463
            boolean r6 = com.paytm.utility.b.r((android.content.Context) r7)     // Catch:{ Exception -> 0x0393 }
            if (r6 == 0) goto L_0x0300
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0393 }
            r6.<init>()     // Catch:{ Exception -> 0x0393 }
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = "?customer_id="
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = com.paytm.utility.b.n((android.content.Context) r7)     // Catch:{ Exception -> 0x0393 }
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0393 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0393 }
            r6.<init>()     // Catch:{ Exception -> 0x0393 }
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = "?UserId="
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = com.paytm.utility.b.n((android.content.Context) r7)     // Catch:{ Exception -> 0x0393 }
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0393 }
        L_0x0300:
            java.lang.String r4 = com.paytm.utility.b.s(r7, r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0393 }
            r6.<init>()     // Catch:{ Exception -> 0x0393 }
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = "&lang="
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = com.paytm.utility.b.a((android.content.Context) r7)     // Catch:{ Exception -> 0x0393 }
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = "-IN"
            r6.append(r4)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0393 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0393 }
            r6.<init>()     // Catch:{ Exception -> 0x0393 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0393 }
            java.lang.String r8 = "Content-Type"
            java.lang.String r9 = "application/json"
            r6.put(r8, r9)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r8 = "ClientId"
            java.lang.String r9 = "paytm"
            r6.put(r8, r9)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r8 = "ACCEPTED-LANGUAGE"
            java.lang.String r9 = com.paytm.utility.n.a()     // Catch:{ Exception -> 0x0393 }
            java.lang.String r9 = com.paytm.utility.n.a((android.content.Context) r7, (java.lang.String) r9)     // Catch:{ Exception -> 0x0393 }
            java.lang.String r10 = "LocaleHelper.getLanguage(context)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)     // Catch:{ Exception -> 0x0393 }
            r6.put(r8, r9)     // Catch:{ Exception -> 0x0393 }
            net.one97.paytm.o2o.movies.utils.c r8 = new net.one97.paytm.o2o.movies.utils.c     // Catch:{ Exception -> 0x0393 }
            r8.<init>()     // Catch:{ Exception -> 0x0393 }
            r8.f42877a = r7     // Catch:{ Exception -> 0x0393 }
            com.paytm.network.a$c r9 = com.paytm.network.a.c.MOVIES     // Catch:{ Exception -> 0x0393 }
            r8.f42878b = r9     // Catch:{ Exception -> 0x0393 }
            com.paytm.network.a$a r9 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x0393 }
            r8.f42879c = r9     // Catch:{ Exception -> 0x0393 }
            r8.f42880d = r4     // Catch:{ Exception -> 0x0393 }
            r8.f42881e = r5     // Catch:{ Exception -> 0x0393 }
            r8.f42882f = r6     // Catch:{ Exception -> 0x0393 }
            r8.f42883g = r5     // Catch:{ Exception -> 0x0393 }
            r8.f42884h = r5     // Catch:{ Exception -> 0x0393 }
            net.one97.paytm.o2o.movies.entity.CJRCitiesResponse r4 = new net.one97.paytm.o2o.movies.entity.CJRCitiesResponse     // Catch:{ Exception -> 0x0393 }
            r4.<init>(r5, r12, r5)     // Catch:{ Exception -> 0x0393 }
            com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4     // Catch:{ Exception -> 0x0393 }
            r8.f42885i = r4     // Catch:{ Exception -> 0x0393 }
            net.one97.paytm.o2o.movies.utils.t$a r12 = new net.one97.paytm.o2o.movies.utils.t$a     // Catch:{ Exception -> 0x0393 }
            r12.<init>(r3, r7, r2)     // Catch:{ Exception -> 0x0393 }
            com.paytm.network.listener.b r12 = (com.paytm.network.listener.b) r12     // Catch:{ Exception -> 0x0393 }
            r8.j = r12     // Catch:{ Exception -> 0x0393 }
            com.paytm.network.a$b r12 = com.paytm.network.a.b.USER_FACING     // Catch:{ Exception -> 0x0393 }
            r8.n = r12     // Catch:{ Exception -> 0x0393 }
            java.lang.String r12 = "movies"
            r8.o = r12     // Catch:{ Exception -> 0x0393 }
            org.json.JSONObject r12 = net.one97.paytm.o2o.movies.utils.t.a()     // Catch:{ Exception -> 0x0393 }
            r8.t = r12     // Catch:{ Exception -> 0x0393 }
            com.paytm.network.a r12 = r8.l()     // Catch:{ Exception -> 0x0393 }
            java.lang.String r2 = "networkCall"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)     // Catch:{ Exception -> 0x0393 }
            r12.f42860d = r0     // Catch:{ Exception -> 0x0393 }
            r12.f42859c = r0     // Catch:{ Exception -> 0x0393 }
            r12.a()     // Catch:{ Exception -> 0x0393 }
            goto L_0x0463
        L_0x0393:
            goto L_0x0463
        L_0x0396:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r2.f76063c
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r12.postValue(r0)
            goto L_0x0463
        L_0x039f:
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r3 = r3.f75234d
            if (r3 != 0) goto L_0x03ae
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r4 = new net.one97.paytm.common.entity.CJRSelectCityModel
            r4.<init>()
            r3.f75234d = r4
        L_0x03ae:
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r3.f75231a
            if (r3 == 0) goto L_0x0405
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r3 = r3.f75231a
            if (r3 == 0) goto L_0x03bf
            java.lang.String r3 = r3.getPushCity()
            goto L_0x03c0
        L_0x03bf:
            r3 = r5
        L_0x03c0:
            net.one97.paytm.o2o.movies.e.a r4 = r2.u
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = r4.f75231a
            if (r4 == 0) goto L_0x03cb
            java.lang.String r4 = r4.getPushCityValue()
            goto L_0x03cc
        L_0x03cb:
            r4 = r5
        L_0x03cc:
            r6 = r3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0405
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0405
            net.one97.paytm.o2o.movies.e.a r0 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d
            if (r0 == 0) goto L_0x03e7
            r0.setlabel(r3)
        L_0x03e7:
            net.one97.paytm.o2o.movies.e.a r0 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d
            if (r0 == 0) goto L_0x03f0
            r0.setValue(r4)
        L_0x03f0:
            net.one97.paytm.o2o.movies.e.a r0 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x03fb
            r0.setLatitude(r3)
        L_0x03fb:
            net.one97.paytm.o2o.movies.e.a r0 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d
            if (r0 == 0) goto L_0x0433
            r0.setLongitude(r3)
            goto L_0x0433
        L_0x0405:
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r3 = r3.f75234d
            if (r3 == 0) goto L_0x0432
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r3 = r3.f75234d
            if (r3 == 0) goto L_0x0416
            java.lang.String r3 = r3.getLabel()
            goto L_0x0417
        L_0x0416:
            r3 = r5
        L_0x0417:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0432
            net.one97.paytm.o2o.movies.e.a r3 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r3 = r3.f75234d
            if (r3 == 0) goto L_0x0429
            java.lang.String r5 = r3.getValue()
        L_0x0429:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 != 0) goto L_0x0432
            goto L_0x0433
        L_0x0432:
            r12 = 0
        L_0x0433:
            if (r12 == 0) goto L_0x045c
            net.one97.paytm.o2o.movies.e.a r12 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r12 = r12.f75234d
            if (r12 == 0) goto L_0x0454
            net.one97.paytm.o2o.movies.e.a r12 = r2.u
            net.one97.paytm.common.entity.CJRSelectCityModel r12 = r12.f75234d
            if (r12 == 0) goto L_0x044c
            androidx.lifecycle.y<java.lang.String> r0 = r2.f76065e
            net.one97.paytm.o2o.movies.utils.h r3 = net.one97.paytm.o2o.movies.utils.h.f75928a
            java.lang.String r12 = net.one97.paytm.o2o.movies.utils.h.a((net.one97.paytm.common.entity.CJRSelectCityModel) r12)
            r0.postValue(r12)
        L_0x044c:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r2.f76067g
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r12.postValue(r0)
            goto L_0x0463
        L_0x0454:
            androidx.lifecycle.y<java.lang.String> r12 = r2.f76065e
            java.lang.String r0 = "gone"
            r12.postValue(r0)
            goto L_0x0463
        L_0x045c:
            androidx.lifecycle.y<java.lang.Boolean> r12 = r2.f76066f
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r12.postValue(r0)
        L_0x0463:
            net.one97.paytm.o2o.movies.viewmodel.c r12 = r11.f74170c
            if (r12 != 0) goto L_0x046a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x046a:
            net.one97.paytm.o2o.movies.e.a r0 = r12.u
            net.one97.paytm.o2o.movies.entity.CJRHomePageResponse$Language r0 = r0.f75235e
            if (r0 != 0) goto L_0x0487
            net.one97.paytm.o2o.movies.e.a r12 = r12.u
            net.one97.paytm.o2o.movies.entity.CJRHomePageResponse$Language r0 = new net.one97.paytm.o2o.movies.entity.CJRHomePageResponse$Language
            r0.<init>()
            java.lang.String r1 = "All"
            r0.languageForOperation = r1
            android.content.Context r1 = r12.f75237g
            int r2 = net.one97.paytm.o2o.movies.R.string.all_languages
            java.lang.String r1 = r1.getString(r2)
            r0.languageToDisplay = r1
            r12.f75235e = r0
        L_0x0487:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.MoviesHomeActivity.onCreate(android.os.Bundle):void");
    }

    static final class x implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74216a;

        x(MoviesHomeActivity moviesHomeActivity) {
            this.f74216a = moviesHomeActivity;
        }

        public final void onClick(View view) {
            CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
            kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            String a2 = net.one97.paytm.o2o.movies.common.b.c.a("movies_offers_url", (String) null);
            if (TextUtils.isEmpty(a2)) {
                a2 = "paytmmp://homepage?url=https://storefront.paytm.com/v2/h/movie-offers";
            }
            cJRHomePageItem.mUrl = a2;
            cJRHomePageItem.mUrlInfo = CLPConstants.URL_TYPE_EMBED;
            cJRHomePageItem.mUrlType = CLPConstants.URL_TYPE_EMBED;
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.loadPage(this.f74216a, cJRHomePageItem.mUrlType, cJRHomePageItem, "", 0, (ArrayList<? extends CJRItem>) null, false, "");
        }
    }

    static final class y implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74217a;

        y(MoviesHomeActivity moviesHomeActivity) {
            this.f74217a = moviesHomeActivity;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(15:5|6|(1:8)|9|10|11|(1:13)|14|15|16|(1:18)|19|(1:21)|22|23) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0064 A[Catch:{ Exception -> 0x00d4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[Catch:{ Exception -> 0x00d4 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r7) {
            /*
                r6 = this;
                net.one97.paytm.o2o.movies.activity.MoviesHomeActivity r7 = r6.f74217a
                net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse r0 = r7.f74168a     // Catch:{ Exception -> 0x00d4 }
                r1 = 0
                java.lang.String r2 = "moviesHomeViewModel"
                if (r0 == 0) goto L_0x0078
                net.one97.paytm.o2o.movies.viewmodel.c r0 = r7.f74170c     // Catch:{ Exception -> 0x00d4 }
                if (r0 != 0) goto L_0x0010
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00d4 }
            L_0x0010:
                net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x00d4 }
                android.content.Context r0 = r0.f75237g     // Catch:{ Exception -> 0x00d4 }
                java.lang.String r3 = "context"
                kotlin.g.b.k.c(r0, r3)     // Catch:{ Exception -> 0x00d4 }
                java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0054 }
                r3.<init>()     // Catch:{ Exception -> 0x0054 }
                java.lang.String r4 = "screenName"
                java.lang.String r5 = "/movies"
                r3.put(r4, r5)     // Catch:{ Exception -> 0x0054 }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x0054 }
                java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.s     // Catch:{ Exception -> 0x0054 }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x0054 }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x0054 }
                java.lang.String r5 = "search_tab_clicked"
                r3.put(r4, r5)     // Catch:{ Exception -> 0x0054 }
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x0054 }
                java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x0054 }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x0054 }
                boolean r4 = com.paytm.utility.b.r((android.content.Context) r0)     // Catch:{ Exception -> 0x0054 }
                if (r4 == 0) goto L_0x0049
                java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x0054 }
                java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r0)     // Catch:{ Exception -> 0x0054 }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x0054 }
            L_0x0049:
                net.one97.paytm.o2o.movies.common.c.b r4 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0054 }
                net.one97.paytm.o2o.movies.common.c.c r4 = r4.f75033b     // Catch:{ Exception -> 0x0054 }
                java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x0054 }
                java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x0054 }
                r4.sendCustomEventWithMap(r5, r3, r0)     // Catch:{ Exception -> 0x0054 }
            L_0x0054:
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00d4 }
                r3 = r7
                android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x00d4 }
                java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRMovieSearchLanding> r4 = net.one97.paytm.o2o.movies.activity.AJRMovieSearchLanding.class
                r0.<init>(r3, r4)     // Catch:{ Exception -> 0x00d4 }
                java.lang.String r3 = "intent_city_name"
                net.one97.paytm.o2o.movies.viewmodel.c r4 = r7.f74170c     // Catch:{ Exception -> 0x00d4 }
                if (r4 != 0) goto L_0x0067
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00d4 }
            L_0x0067:
                net.one97.paytm.o2o.movies.e.a r2 = r4.u     // Catch:{ Exception -> 0x00d4 }
                net.one97.paytm.common.entity.CJRSelectCityModel r2 = r2.f75234d     // Catch:{ Exception -> 0x00d4 }
                if (r2 == 0) goto L_0x0071
                java.lang.String r1 = r2.getValue()     // Catch:{ Exception -> 0x00d4 }
            L_0x0071:
                r0.putExtra(r3, r1)     // Catch:{ Exception -> 0x00d4 }
                r7.startActivity(r0)     // Catch:{ Exception -> 0x00d4 }
                return
            L_0x0078:
                net.one97.paytm.o2o.movies.viewmodel.c r0 = r7.f74170c     // Catch:{ Exception -> 0x00d4 }
                if (r0 != 0) goto L_0x007f
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00d4 }
            L_0x007f:
                net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x00d4 }
                net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d     // Catch:{ Exception -> 0x00d4 }
                if (r0 == 0) goto L_0x00b9
                net.one97.paytm.o2o.movies.viewmodel.c r0 = r7.f74170c     // Catch:{ Exception -> 0x00d4 }
                if (r0 != 0) goto L_0x008c
                kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00d4 }
            L_0x008c:
                net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x00d4 }
                net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d     // Catch:{ Exception -> 0x00d4 }
                if (r0 == 0) goto L_0x0096
                java.lang.String r1 = r0.getValue()     // Catch:{ Exception -> 0x00d4 }
            L_0x0096:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x00d4 }
                boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00d4 }
                if (r0 == 0) goto L_0x00b9
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x00d4 }
                android.content.res.Resources r1 = r7.getResources()     // Catch:{ Exception -> 0x00d4 }
                int r2 = net.one97.paytm.o2o.movies.R.string.empty_movie_location_title     // Catch:{ Exception -> 0x00d4 }
                java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x00d4 }
                android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x00d4 }
                int r2 = net.one97.paytm.o2o.movies.R.string.empty_movie_location_desc     // Catch:{ Exception -> 0x00d4 }
                java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x00d4 }
                com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x00d4 }
                return
            L_0x00b9:
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x00d4 }
                android.content.res.Resources r1 = r7.getResources()     // Catch:{ Exception -> 0x00d4 }
                int r2 = net.one97.paytm.o2o.movies.R.string.mo_movies_title     // Catch:{ Exception -> 0x00d4 }
                java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x00d4 }
                android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x00d4 }
                int r2 = net.one97.paytm.o2o.movies.R.string.no_movies_desc     // Catch:{ Exception -> 0x00d4 }
                java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x00d4 }
                com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r7)     // Catch:{ Exception -> 0x00d4 }
                return
            L_0x00d4:
                r7 = move-exception
                java.lang.String r0 = "exception"
                kotlin.g.b.k.c(r7, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.MoviesHomeActivity.y.onClick(android.view.View):void");
        }
    }

    static final class z implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74218a;

        z(MoviesHomeActivity moviesHomeActivity) {
            this.f74218a = moviesHomeActivity;
        }

        public final void onClick(View view) {
            this.f74218a.a(2);
        }
    }

    static final class aa implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74178a;

        aa(MoviesHomeActivity moviesHomeActivity) {
            this.f74178a = moviesHomeActivity;
        }

        public final void onClick(View view) {
            this.f74178a.onBackPressed();
        }
    }

    public static final class s extends RecyclerView.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74211a;

        s(MoviesHomeActivity moviesHomeActivity) {
            this.f74211a = moviesHomeActivity;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            kotlin.g.b.k.c(rect, "outRect");
            kotlin.g.b.k.c(view, "view");
            kotlin.g.b.k.c(recyclerView, "parent");
            kotlin.g.b.k.c(sVar, "state");
            super.getItemOffsets(rect, view, recyclerView, sVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            net.one97.paytm.o2o.movies.adapter.y c2 = this.f74211a.n;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            if (c2.getItemViewType(childAdapterPosition) == 3) {
                rect.left = this.f74211a.y;
                rect.right = this.f74211a.y;
                rect.bottom = this.f74211a.y;
            }
        }
    }

    private final void a(Intent intent) {
        Object obj = null;
        Object serializableExtra = intent != null ? intent.getSerializableExtra("extra_home_data") : null;
        if (serializableExtra instanceof CJRHomePageItem) {
            obj = serializableExtra;
        }
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) obj;
        a(cJRHomePageItem);
        if (cJRHomePageItem != null) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
            if (cVar == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            cVar.u.a(cJRHomePageItem);
            if (cJRHomePageItem.mUrlType != null) {
                String str = cJRHomePageItem.mUrlType;
                kotlin.g.b.k.a((Object) str, "item.mUrlType");
                a(cJRHomePageItem, str);
            }
        }
        if (cJRHomePageItem != null) {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendDeepLinkOpen("movies", cJRHomePageItem, this);
        }
        io.reactivex.rxjava3.b.c cVar2 = this.x;
        if (cVar2 != null) {
            cVar2.dispose();
        }
        this.x = io.reactivex.rxjava3.a.y.a(new e(this, intent, cJRHomePageItem)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new f(this), (io.reactivex.rxjava3.d.g<? super Throwable>) g.f74196a);
    }

    private static void a(CJRHomePageItem cJRHomePageItem) {
        String str;
        if (cJRHomePageItem != null) {
            try {
                Uri parse = Uri.parse(cJRHomePageItem.getDeeplink());
                String queryParameter = parse.getQueryParameter("deviceId");
                if (queryParameter == null || (str = net.one97.paytm.o2o.movies.common.a.d.b(queryParameter)) == null) {
                    String queryParameter2 = parse.getQueryParameter("device_id");
                    str = queryParameter2 != null ? net.one97.paytm.o2o.movies.common.a.d.b(queryParameter2) : null;
                }
                if (str != null) {
                    net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
                    kotlin.g.b.k.a((Object) a2, "CJRMovieSearchResponseHo…erSingleton.getInstance()");
                    a2.k = str;
                    kotlin.x xVar = kotlin.x.f47997a;
                }
            } catch (Exception unused) {
                kotlin.x xVar2 = kotlin.x.f47997a;
            }
        }
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    public final void onBackPressed() {
        try {
            ImageView imageView = (ImageView) b(R.id.zoomed_qr_image);
            if (imageView == null || imageView.getVisibility() != 0) {
                if (m()) {
                    e();
                    return;
                }
                finish();
                return;
            }
            f();
        } catch (Exception unused) {
        }
    }

    public final void b() {
        net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
        kotlin.g.b.k.a((Object) a2, "CJRMovieSearchResponseHo…erSingleton.getInstance()");
        Location location = a2.f75931a;
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        CJRSelectCityModel cJRSelectCityModel = cVar.u.f75234d;
        if (cJRSelectCityModel != null) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar2 = this.f74170c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            cVar2.a(cJRSelectCityModel, location, com.paytm.utility.b.a((Context) this) + "-IN");
        }
    }

    public final void c() {
        net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
        kotlin.g.b.k.a((Object) a2, "CJRMovieSearchResponseHo…erSingleton.getInstance()");
        Location location = a2.f75931a;
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        CJRSelectCityModel cJRSelectCityModel = cVar.u.f75234d;
        if (cJRSelectCityModel != null) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar2 = this.f74170c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            cVar2.a(cJRSelectCityModel, location, com.paytm.utility.b.a((Context) this) + "-IN");
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        super.onActivityResult(i2, i3, intent);
        if (i2 != this.A) {
            String str2 = null;
            if (i2 == 1) {
                if (intent != null) {
                    try {
                        if (intent.hasExtra("userselectedcity")) {
                            try {
                                Serializable serializableExtra = intent.getSerializableExtra("userselectedcity");
                                if (serializableExtra != null) {
                                    this.f74172e = (CJRSelectCityModel) serializableExtra;
                                    if (this.f74172e != null) {
                                        CJRSelectCityModel cJRSelectCityModel = this.f74172e;
                                        if ((cJRSelectCityModel != null ? cJRSelectCityModel.getValue() : null) != null) {
                                            net.one97.paytm.o2o.movies.common.d.a((Context) this, this.f74172e, "movies");
                                            net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
                                            if (cVar == null) {
                                                kotlin.g.b.k.a("moviesHomeViewModel");
                                            }
                                            cVar.u.f75234d = this.f74172e;
                                            net.one97.paytm.o2o.movies.viewmodel.c cVar2 = this.f74170c;
                                            if (cVar2 == null) {
                                                kotlin.g.b.k.a("moviesHomeViewModel");
                                            }
                                            CJRSelectCityModel cJRSelectCityModel2 = cVar2.u.f75234d;
                                            if (cJRSelectCityModel2 != null) {
                                                net.one97.paytm.o2o.movies.utils.h hVar = net.one97.paytm.o2o.movies.utils.h.f75928a;
                                                str2 = net.one97.paytm.o2o.movies.utils.h.a(cJRSelectCityModel2);
                                            }
                                            if (!TextUtils.isEmpty(str2)) {
                                                RoboTextView roboTextView = (RoboTextView) b(R.id.movie_location);
                                                kotlin.g.b.k.a((Object) roboTextView, "movie_location");
                                                roboTextView.setText(str2);
                                            } else {
                                                RoboTextView roboTextView2 = (RoboTextView) b(R.id.movie_location);
                                                kotlin.g.b.k.a((Object) roboTextView2, "movie_location");
                                                roboTextView2.setText(getString(R.string.select_location));
                                            }
                                            h();
                                            i();
                                        }
                                    }
                                } else {
                                    throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRSelectCityModel");
                                }
                            } catch (Exception e2) {
                                kotlin.g.b.k.c(e2, "exception");
                            }
                        }
                    } catch (Exception e3) {
                        kotlin.g.b.k.c(e3, "exception");
                    }
                }
                net.one97.paytm.o2o.movies.viewmodel.c cVar3 = this.f74170c;
                if (cVar3 == null) {
                    kotlin.g.b.k.a("moviesHomeViewModel");
                }
                CJRSelectCityModel cJRSelectCityModel3 = cVar3.u.f75234d;
                if (cJRSelectCityModel3 != null) {
                    net.one97.paytm.o2o.movies.utils.h hVar2 = net.one97.paytm.o2o.movies.utils.h.f75928a;
                    str2 = net.one97.paytm.o2o.movies.utils.h.a(cJRSelectCityModel3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    ((RoboTextView) b(R.id.movie_location)).setText(str2);
                } else {
                    ((RoboTextView) b(R.id.movie_location)).setText(getString(R.string.select_location));
                }
                h();
            } else if (i2 == 54378 || i2 == 2) {
                try {
                    b(false);
                    if (intent != null && intent.hasExtra("userselectedcity")) {
                        CJRHomePageResponse.Language language = this.r;
                        if (language != null) {
                            language.languageToDisplay = getString(R.string.all_languages);
                        }
                        CJRHomePageResponse.Language language2 = this.r;
                        if (language2 != null) {
                            language2.languageForOperation = AppConstants.FOR_ALL;
                        }
                        Serializable serializableExtra2 = intent.getSerializableExtra("userselectedcity");
                        if (serializableExtra2 != null) {
                            this.f74172e = (CJRSelectCityModel) serializableExtra2;
                            if (this.f74172e != null) {
                                CJRSelectCityModel cJRSelectCityModel4 = this.f74172e;
                                if ((cJRSelectCityModel4 != null ? cJRSelectCityModel4.getValue() : null) != null) {
                                    CJRSelectCityModel cJRSelectCityModel5 = this.f74172e;
                                    if ((cJRSelectCityModel5 != null ? cJRSelectCityModel5.getValue() : null) != null) {
                                        net.one97.paytm.o2o.movies.viewmodel.c cVar4 = this.f74170c;
                                        if (cVar4 == null) {
                                            kotlin.g.b.k.a("moviesHomeViewModel");
                                        }
                                        cVar4.u.f75234d = this.f74172e;
                                        net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
                                        kotlin.g.b.k.a((Object) a2, "instance");
                                        a2.a((ArrayList<CJRMovieHomeListItem>) null);
                                        a2.f75933c = null;
                                        a2.f75935e = null;
                                        net.one97.paytm.o2o.movies.viewmodel.c cVar5 = this.f74170c;
                                        if (cVar5 == null) {
                                            kotlin.g.b.k.a("moviesHomeViewModel");
                                        }
                                        CJRSelectCityModel cJRSelectCityModel6 = cVar5.u.f75234d;
                                        if (cJRSelectCityModel6 != null) {
                                            net.one97.paytm.o2o.movies.utils.h hVar3 = net.one97.paytm.o2o.movies.utils.h.f75928a;
                                            str = net.one97.paytm.o2o.movies.utils.h.a(cJRSelectCityModel6);
                                        } else {
                                            str = null;
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            ((RoboTextView) b(R.id.movie_location)).setText(str);
                                        } else {
                                            ((RoboTextView) b(R.id.movie_location)).setText(getString(R.string.select_location));
                                        }
                                        net.one97.paytm.o2o.movies.common.d.a((Context) this, this.f74172e, "movies");
                                        this.f74168a = null;
                                        this.j = null;
                                        ((AppBarLayout) b(R.id.id_movie_home_appbar)).setExpanded(true);
                                        d();
                                        if (com.paytm.utility.b.c((Context) this)) {
                                            b(true);
                                            net.one97.paytm.o2o.movies.viewmodel.c cVar6 = this.f74170c;
                                            if (cVar6 == null) {
                                                kotlin.g.b.k.a("moviesHomeViewModel");
                                            }
                                            cVar6.q = null;
                                            cVar6.n = null;
                                            net.one97.paytm.o2o.movies.viewmodel.c cVar7 = this.f74170c;
                                            if (cVar7 == null) {
                                                kotlin.g.b.k.a("moviesHomeViewModel");
                                            }
                                            CJRSelectCityModel cJRSelectCityModel7 = cVar7.u.f75234d;
                                            if (cJRSelectCityModel7 != null) {
                                                net.one97.paytm.o2o.movies.viewmodel.c cVar8 = this.f74170c;
                                                if (cVar8 == null) {
                                                    kotlin.g.b.k.a("moviesHomeViewModel");
                                                }
                                                cVar8.a(cJRSelectCityModel7, this.f74175h, com.paytm.utility.b.a((Context) this) + "-IN");
                                            }
                                        } else {
                                            a(true);
                                        }
                                    }
                                }
                            }
                            if (i2 == 54378) {
                                i();
                            }
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRSelectCityModel");
                        }
                    } else if (com.paytm.utility.b.c((Context) this)) {
                        a(false);
                    } else {
                        a(true);
                    }
                } catch (Exception e4) {
                    kotlin.g.b.k.c(e4, "exception");
                }
            }
        }
        net.one97.paytm.o2o.movies.viewmodel.c cVar9 = this.f74170c;
        if (cVar9 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        if (cVar9.u.f75234d == null) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar10 = this.f74170c;
            if (cVar10 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            cVar10.u.f75234d = new CJRSelectCityModel();
        }
    }

    private void a(CJRHomePageItem cJRHomePageItem, String str) {
        kotlin.g.b.k.c(cJRHomePageItem, "homePageItem");
        kotlin.g.b.k.c(str, "urlType");
        this.f74173f = true;
        this.f74174g = cJRHomePageItem;
        this.f74175h = str;
        if (!kotlin.m.p.a(str, "freemovie", true)) {
            i();
            return;
        }
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        CJRSelectCityModel cJRSelectCityModel = cVar.u.f75234d;
        if (cJRSelectCityModel != null) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar2 = this.f74170c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            cVar2.a(cJRSelectCityModel, str, com.paytm.utility.b.a((Context) this) + "-IN");
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        if (cVar.o.getValue() == null) {
            Context context = this;
            if (com.paytm.utility.b.c(context)) {
                b(true);
                net.one97.paytm.o2o.movies.viewmodel.c cVar2 = this.f74170c;
                if (cVar2 == null) {
                    kotlin.g.b.k.a("moviesHomeViewModel");
                }
                CJRSelectCityModel cJRSelectCityModel = cVar2.u.f75234d;
                if (cJRSelectCityModel != null) {
                    net.one97.paytm.o2o.movies.viewmodel.c cVar3 = this.f74170c;
                    if (cVar3 == null) {
                        kotlin.g.b.k.a("moviesHomeViewModel");
                    }
                    String str = this.f74175h;
                    cVar3.a(cJRSelectCityModel, str, com.paytm.utility.b.a(context) + "-IN");
                }
            } else {
                a(true);
            }
        }
        net.one97.paytm.o2o.movies.viewmodel.c cVar4 = this.f74170c;
        if (cVar4 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        androidx.lifecycle.q qVar = this;
        cVar4.o.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar5 = this.f74170c;
        if (cVar5 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar5.o.observe(qVar, new j(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar6 = this.f74170c;
        if (cVar6 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar6.f76069i.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar7 = this.f74170c;
        if (cVar7 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar7.f76069i.observe(qVar, new k(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar8 = this.f74170c;
        if (cVar8 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar8.p.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar9 = this.f74170c;
        if (cVar9 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar9.p.observe(qVar, new l(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar10 = this.f74170c;
        if (cVar10 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar10.r.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar11 = this.f74170c;
        if (cVar11 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar11.r.observe(qVar, new m(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar12 = this.f74170c;
        if (cVar12 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar12.f76068h.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar13 = this.f74170c;
        if (cVar13 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar13.f76068h.observe(qVar, new n(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar14 = this.f74170c;
        if (cVar14 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar14.k.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar15 = this.f74170c;
        if (cVar15 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar15.k.observe(qVar, new o(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar16 = this.f74170c;
        if (cVar16 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar16.j.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar17 = this.f74170c;
        if (cVar17 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar17.j.observe(qVar, new p(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar18 = this.f74170c;
        if (cVar18 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar18.l.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar19 = this.f74170c;
        if (cVar19 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar19.l.observe(qVar, new q(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar20 = this.f74170c;
        if (cVar20 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar20.m.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar21 = this.f74170c;
        if (cVar21 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar21.m.observe(qVar, new h(this));
        net.one97.paytm.o2o.movies.viewmodel.c cVar22 = this.f74170c;
        if (cVar22 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar22.t.removeObservers(qVar);
        net.one97.paytm.o2o.movies.viewmodel.c cVar23 = this.f74170c;
        if (cVar23 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        cVar23.t.observe(qVar, new i(this));
        LinearLayout linearLayout = (LinearLayout) b(R.id.moviepass_offers_llt);
        kotlin.g.b.k.a((Object) linearLayout, "moviepass_offers_llt");
        linearLayout.setVisibility(0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(32:176|(1:178)|179|(1:181)(1:182)|183|(6:185|(1:187)|188|(1:190)(1:191)|192|(26:194|(1:196)|197|(1:199)(1:200)|201|210|(1:212)|213|(1:215)(1:216)|217|(1:219)|220|(1:222)(1:223)|224|(1:226)|227|(1:229)(1:230)|(7:232|233|(1:235)|236|(1:238)(1:239)|240|(3:242|(1:244)|245)(1:246))|247|248|249|250|429|(0)|432|(0)(0)))|202|(1:204)|205|(1:207)(1:208)|209|210|(0)|213|(0)(0)|217|(0)|220|(0)(0)|224|(0)|227|(0)(0)|(0)|247|248|249|250|429|(0)|432|(0)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(46:53|(1:55)|56|(1:58)(1:59)|60|(1:62)(1:63)|64|(1:66)|67|(1:69)(1:70)|71|(6:73|(1:75)|76|(1:78)(1:79)|80|(34:82|(1:84)|85|(1:87)(1:88)|89|(1:99)|100|(1:102)|103|(1:105)(1:106)|107|(1:109)|110|(1:112)(1:113)|114|(1:116)|117|(1:119)(1:120)|121|(1:123)|124|(1:126)(1:127)|(7:129|130|(1:132)|133|(1:135)(1:136)|137|(3:139|(1:141)|142)(1:143))|144|145|146|147|(1:149)|150|(6:152|(1:154)|155|(1:157)(1:158)|159|(1:161))|429|(1:431)|432|(4:434|(3:436|(1:438)|439)|440|458)(1:459)))|90|(1:92)|93|(1:95)(1:96)|97|(0)|100|(0)|103|(0)(0)|107|(0)|110|(0)(0)|114|(0)|117|(0)(0)|121|(0)|124|(0)(0)|(0)|144|145|146|147|(0)|150|(0)|429|(0)|432|(0)(0)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:144:0x01c6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:146:0x01cf */
    /* JADX WARNING: Missing exception handler attribute for start block: B:247:0x0312 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:249:0x031b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:386:0x04da */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x013b A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0144 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0149 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0151 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015a A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x015f A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0167 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0170 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0175 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x017d A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0186 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x018e A[SYNTHETIC, Splitter:B:129:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01d6 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01df A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x029d A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x02a6 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x02ab A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x02b3 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x02bc A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x02c1 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x02c9 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x02d2 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x02da A[SYNTHETIC, Splitter:B:232:0x02da] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0448 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x044f A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x0458 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x045d A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0465 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x046e A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x0473 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x047b A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x0484 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0489 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x0491 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x049a A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x04a2 A[SYNTHETIC, Splitter:B:371:0x04a2] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x04e9 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0581 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x058a A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:459:? A[Catch:{ Exception -> 0x05d0 }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0134 A[Catch:{ Exception -> 0x05d0 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:249:0x031b=Splitter:B:249:0x031b, B:146:0x01cf=Splitter:B:146:0x01cf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "movie-details"
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r3 = "moviesHomeViewModel"
            if (r2 != 0) goto L_0x000d
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x000d:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x05a1
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x001a
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x001a:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r2 = r2.f75232b     // Catch:{ Exception -> 0x05d0 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x05d0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x05a1
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x002d
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x002d:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r2 = r2.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x05a1
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x003a
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x003a:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r2 = r2.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0045
            java.lang.String r2 = r2.getValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0046
        L_0x0045:
            r2 = 0
        L_0x0046:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x05d0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x05a1
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0055
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0055:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r2 = r2.f75232b     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r5 = "movies-show-time"
            r6 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r5 = "cinema_movie_code"
            java.lang.String r7 = "Integer.valueOf(uri.getQ…onstants.SELECTED_TAB)!!)"
            java.lang.String r8 = "movie_pass_present"
            java.lang.String r9 = "url_type"
            java.lang.String r10 = "movie_ticket_selected_item_value"
            java.lang.String r11 = "movie_ticket_selected_item_type"
            r12 = 0
            java.lang.String r13 = "movie_ticket_city_selected"
            java.lang.String r14 = "tab"
            if (r2 == 0) goto L_0x01ff
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x007c
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x007c:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0087
            java.lang.String r2 = r2.getPushType()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0088
        L_0x0087:
            r2 = 0
        L_0x0088:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x05d0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x01ff
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0097
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0097:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x00a2
            java.lang.String r2 = r2.getPushCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x00a3
        L_0x00a2:
            r2 = 0
        L_0x00a3:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x05d0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x01ff
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x00b2
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x00b2:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r0.getPushType()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x00be
        L_0x00bd:
            r0 = 0
        L_0x00be:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x05d0 }
            r15 = r1
            android.content.Context r15 = (android.content.Context) r15     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r4 = "cinema"
            boolean r4 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            if (r4 == 0) goto L_0x00ce
            java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity> r4 = net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.class
            goto L_0x00d0
        L_0x00ce:
            java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity> r4 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.class
        L_0x00d0:
            r2.<init>(r15, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r4 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r4 != 0) goto L_0x00da
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x00da:
            net.one97.paytm.o2o.movies.e.a r4 = r4.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = r4.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r4 == 0) goto L_0x00e5
            java.lang.String r4 = r4.getPushCity()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x00e6
        L_0x00e5:
            r4 = 0
        L_0x00e6:
            boolean r4 = net.one97.paytm.o2o.movies.common.d.b((java.lang.String) r4)     // Catch:{ Exception -> 0x05d0 }
            if (r4 != 0) goto L_0x011c
            net.one97.paytm.o2o.movies.viewmodel.c r4 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r4 != 0) goto L_0x00f3
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x00f3:
            net.one97.paytm.o2o.movies.e.a r4 = r4.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = r4.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r4 == 0) goto L_0x00fe
            java.lang.String r4 = r4.getPushCityValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x00ff
        L_0x00fe:
            r4 = 0
        L_0x00ff:
            boolean r4 = net.one97.paytm.o2o.movies.common.d.b((java.lang.String) r4)     // Catch:{ Exception -> 0x05d0 }
            if (r4 != 0) goto L_0x011c
            net.one97.paytm.o2o.movies.viewmodel.c r4 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r4 != 0) goto L_0x010c
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x010c:
            net.one97.paytm.o2o.movies.e.a r4 = r4.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = r4.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r4 == 0) goto L_0x0117
            java.lang.String r4 = r4.getPushCityValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0118
        L_0x0117:
            r4 = 0
        L_0x0118:
            r2.putExtra(r13, r4)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0132
        L_0x011c:
            net.one97.paytm.o2o.movies.viewmodel.c r4 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r4 != 0) goto L_0x0123
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0123:
            net.one97.paytm.o2o.movies.e.a r4 = r4.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r4 = r4.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r4 == 0) goto L_0x012e
            java.lang.String r4 = r4.getValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x012f
        L_0x012e:
            r4 = 0
        L_0x012f:
            r2.putExtra(r13, r4)     // Catch:{ Exception -> 0x05d0 }
        L_0x0132:
            if (r0 == 0) goto L_0x0137
            r2.putExtra(r11, r0)     // Catch:{ Exception -> 0x05d0 }
        L_0x0137:
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x013e
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x013e:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x0149
            java.lang.String r4 = r0.getPushCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x014a
        L_0x0149:
            r4 = 0
        L_0x014a:
            r2.putExtra(r10, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0154
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0154:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x015f
            java.lang.String r4 = r0.getCinemaMovieCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0160
        L_0x015f:
            r4 = 0
        L_0x0160:
            r2.putExtra(r5, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x016a
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x016a:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x0175
            java.lang.String r4 = r0.getURLType()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0176
        L_0x0175:
            r4 = 0
        L_0x0176:
            r2.putExtra(r9, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0180
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0180:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x018b
            java.lang.String r4 = r0.getDeeplink()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x018c
        L_0x018b:
            r4 = 0
        L_0x018c:
            if (r4 == 0) goto L_0x01c6
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x01c6 }
            if (r0 != 0) goto L_0x0195
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x01c6 }
        L_0x0195:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x01c6 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x01c6 }
            if (r0 == 0) goto L_0x01a0
            java.lang.String r4 = r0.getDeeplink()     // Catch:{ Exception -> 0x01c6 }
            goto L_0x01a1
        L_0x01a0:
            r4 = 0
        L_0x01a1:
            android.net.Uri r0 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x01c6 }
            java.lang.String r4 = r0.getQueryParameter(r14)     // Catch:{ Exception -> 0x01c6 }
            if (r4 == 0) goto L_0x01c3
            java.lang.String r0 = r0.getQueryParameter(r14)     // Catch:{ Exception -> 0x01c6 }
            if (r0 != 0) goto L_0x01b4
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01c6 }
        L_0x01b4:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x01c6 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x01c6 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x01c6 }
            r2.putExtra(r14, r0)     // Catch:{ Exception -> 0x01c6 }
            goto L_0x01c6
        L_0x01c3:
            r2.putExtra(r14, r12)     // Catch:{ Exception -> 0x01c6 }
        L_0x01c6:
            java.lang.Boolean r0 = r16.l()     // Catch:{ Exception -> 0x01cf }
            java.io.Serializable r0 = (java.io.Serializable) r0     // Catch:{ Exception -> 0x01cf }
            r2.putExtra(r8, r0)     // Catch:{ Exception -> 0x01cf }
        L_0x01cf:
            r1.startActivity(r2)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x01d9
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x01d9:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x057d
            java.lang.String r0 = "one_pager"
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x01e8
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x01e8:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x01f3
            java.lang.String r4 = r2.getOrigin()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x01f4
        L_0x01f3:
            r4 = 0
        L_0x01f4:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x057d
            r16.finish()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x057d
        L_0x01ff:
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0206
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0206:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r2 = r2.f75232b     // Catch:{ Exception -> 0x05d0 }
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0320
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0217
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0217:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0222
            java.lang.String r4 = r2.getPushCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0223
        L_0x0222:
            r4 = 0
        L_0x0223:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x05d0 }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0320
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x05d0 }
            r2 = r1
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x05d0 }
            java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity> r4 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.class
            r0.<init>(r2, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x023c
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x023c:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0247
            java.lang.String r4 = r2.getPushCity()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0248
        L_0x0247:
            r4 = 0
        L_0x0248:
            boolean r2 = net.one97.paytm.o2o.movies.common.d.b((java.lang.String) r4)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x027e
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0255
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0255:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0260
            java.lang.String r4 = r2.getPushCityValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0261
        L_0x0260:
            r4 = 0
        L_0x0261:
            boolean r2 = net.one97.paytm.o2o.movies.common.d.b((java.lang.String) r4)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x027e
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x026e
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x026e:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0279
            java.lang.String r4 = r2.getPushCityValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x027a
        L_0x0279:
            r4 = 0
        L_0x027a:
            r0.putExtra(r13, r4)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0294
        L_0x027e:
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0285
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0285:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r2 = r2.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0290
            java.lang.String r4 = r2.getValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0291
        L_0x0290:
            r4 = 0
        L_0x0291:
            r0.putExtra(r13, r4)     // Catch:{ Exception -> 0x05d0 }
        L_0x0294:
            java.lang.String r2 = "movie"
            r0.putExtra(r11, r2)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x02a0
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x02a0:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x02ab
            java.lang.String r4 = r2.getPushCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x02ac
        L_0x02ab:
            r4 = 0
        L_0x02ac:
            r0.putExtra(r10, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x02b6
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x02b6:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x02c1
            java.lang.String r4 = r2.getURLType()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x02c2
        L_0x02c1:
            r4 = 0
        L_0x02c2:
            r0.putExtra(r9, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x02cc
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x02cc:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x02d7
            java.lang.String r4 = r2.getDeeplink()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x02d8
        L_0x02d7:
            r4 = 0
        L_0x02d8:
            if (r4 == 0) goto L_0x0312
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x02e1
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0312 }
        L_0x02e1:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x0312 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x0312 }
            if (r2 == 0) goto L_0x02ec
            java.lang.String r4 = r2.getDeeplink()     // Catch:{ Exception -> 0x0312 }
            goto L_0x02ed
        L_0x02ec:
            r4 = 0
        L_0x02ed:
            android.net.Uri r2 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0312 }
            java.lang.String r4 = r2.getQueryParameter(r14)     // Catch:{ Exception -> 0x0312 }
            if (r4 == 0) goto L_0x030f
            java.lang.String r2 = r2.getQueryParameter(r14)     // Catch:{ Exception -> 0x0312 }
            if (r2 != 0) goto L_0x0300
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0312 }
        L_0x0300:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0312 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x0312 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0312 }
            r0.putExtra(r14, r2)     // Catch:{ Exception -> 0x0312 }
            goto L_0x0312
        L_0x030f:
            r0.putExtra(r14, r12)     // Catch:{ Exception -> 0x0312 }
        L_0x0312:
            java.lang.Boolean r2 = r16.l()     // Catch:{ Exception -> 0x031b }
            java.io.Serializable r2 = (java.io.Serializable) r2     // Catch:{ Exception -> 0x031b }
            r0.putExtra(r8, r2)     // Catch:{ Exception -> 0x031b }
        L_0x031b:
            r1.startActivity(r0)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x057d
        L_0x0320:
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0327
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0327:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r2 = r2.f75232b     // Catch:{ Exception -> 0x05d0 }
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x03b7
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0338
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0338:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x0343
            java.lang.String r4 = r0.getContentID()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0344
        L_0x0343:
            r4 = 0
        L_0x0344:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x05d0 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0369
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$a r0 = net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.f74111b     // Catch:{ Exception -> 0x05d0 }
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0358
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0358:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0363
            java.lang.String r4 = r2.getContentID()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0364
        L_0x0363:
            r4 = 0
        L_0x0364:
            android.content.Intent r4 = net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.a.a(r0, r4)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x03a2
        L_0x0369:
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0370
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0370:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x037b
            java.lang.String r4 = r0.getMovieCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x037c
        L_0x037b:
            r4 = 0
        L_0x037c:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x05d0 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x03a1
            net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity$a r0 = net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.f74111b     // Catch:{ Exception -> 0x05d0 }
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0390
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0390:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x039b
            java.lang.String r4 = r2.getMovieCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x039c
        L_0x039b:
            r4 = 0
        L_0x039c:
            android.content.Intent r4 = net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity.a.b(r0, r4)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x03a2
        L_0x03a1:
            r4 = 0
        L_0x03a2:
            if (r4 == 0) goto L_0x03a9
            r1.startActivity(r4)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x057d
        L_0x03a9:
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x05d0 }
            int r2 = net.one97.paytm.o2o.movies.R.string.error_something_went_wrong     // Catch:{ Exception -> 0x05d0 }
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r12)     // Catch:{ Exception -> 0x05d0 }
            r0.show()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x057d
        L_0x03b7:
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x03be
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x03be:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r0 = r0.f75232b     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r2 = "movies-seat-layout"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x04fa
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x03d1
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x03d1:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x03dc
            java.lang.String r4 = r0.getPushType()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x03dd
        L_0x03dc:
            r4 = 0
        L_0x03dd:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x05d0 }
            r2 = r1
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x05d0 }
            java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity> r15 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.class
            r0.<init>(r2, r15)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x03ee
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x03ee:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x03f9
            java.lang.String r2 = r2.getPushCity()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x03fa
        L_0x03f9:
            r2 = 0
        L_0x03fa:
            boolean r2 = net.one97.paytm.o2o.movies.common.d.b((java.lang.String) r2)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0430
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0407
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0407:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0412
            java.lang.String r2 = r2.getPushCityValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0413
        L_0x0412:
            r2 = 0
        L_0x0413:
            boolean r2 = net.one97.paytm.o2o.movies.common.d.b((java.lang.String) r2)     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0430
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0420
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0420:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x042b
            java.lang.String r2 = r2.getPushCityValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x042c
        L_0x042b:
            r2 = 0
        L_0x042c:
            r0.putExtra(r13, r2)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0446
        L_0x0430:
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0437
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0437:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r2 = r2.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0442
            java.lang.String r2 = r2.getValue()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0443
        L_0x0442:
            r2 = 0
        L_0x0443:
            r0.putExtra(r13, r2)     // Catch:{ Exception -> 0x05d0 }
        L_0x0446:
            if (r4 == 0) goto L_0x044b
            r0.putExtra(r11, r4)     // Catch:{ Exception -> 0x05d0 }
        L_0x044b:
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0452
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0452:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x045d
            java.lang.String r4 = r2.getPushCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x045e
        L_0x045d:
            r4 = 0
        L_0x045e:
            r0.putExtra(r10, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0468
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0468:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0473
            java.lang.String r4 = r2.getCinemaMovieCode()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0474
        L_0x0473:
            r4 = 0
        L_0x0474:
            r0.putExtra(r5, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x047e
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x047e:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x0489
            java.lang.String r4 = r2.getURLType()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x048a
        L_0x0489:
            r4 = 0
        L_0x048a:
            r0.putExtra(r9, r4)     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0494
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0494:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r2 == 0) goto L_0x049f
            java.lang.String r4 = r2.getDeeplink()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x04a0
        L_0x049f:
            r4 = 0
        L_0x04a0:
            if (r4 == 0) goto L_0x04da
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x04da }
            if (r2 != 0) goto L_0x04a9
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x04da }
        L_0x04a9:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x04da }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r2 = r2.f75231a     // Catch:{ Exception -> 0x04da }
            if (r2 == 0) goto L_0x04b4
            java.lang.String r4 = r2.getDeeplink()     // Catch:{ Exception -> 0x04da }
            goto L_0x04b5
        L_0x04b4:
            r4 = 0
        L_0x04b5:
            android.net.Uri r2 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x04da }
            java.lang.String r4 = r2.getQueryParameter(r14)     // Catch:{ Exception -> 0x04da }
            if (r4 == 0) goto L_0x04d7
            java.lang.String r2 = r2.getQueryParameter(r14)     // Catch:{ Exception -> 0x04da }
            if (r2 != 0) goto L_0x04c8
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x04da }
        L_0x04c8:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x04da }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x04da }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x04da }
            r0.putExtra(r14, r2)     // Catch:{ Exception -> 0x04da }
            goto L_0x04da
        L_0x04d7:
            r0.putExtra(r14, r12)     // Catch:{ Exception -> 0x04da }
        L_0x04da:
            java.lang.Boolean r2 = r16.l()     // Catch:{ Exception -> 0x04e3 }
            java.io.Serializable r2 = (java.io.Serializable) r2     // Catch:{ Exception -> 0x04e3 }
            r0.putExtra(r8, r2)     // Catch:{ Exception -> 0x04e3 }
        L_0x04e3:
            java.lang.String r2 = "extra_home_data"
            net.one97.paytm.o2o.movies.viewmodel.c r4 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r4 != 0) goto L_0x04ec
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x04ec:
            net.one97.paytm.o2o.movies.e.a r4 = r4.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r4 = r4.f75231a     // Catch:{ Exception -> 0x05d0 }
            java.io.Serializable r4 = (java.io.Serializable) r4     // Catch:{ Exception -> 0x05d0 }
            r0.putExtra(r2, r4)     // Catch:{ Exception -> 0x05d0 }
            r1.startActivity(r0)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x057d
        L_0x04fa:
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0501
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0501:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r0 = r0.f75232b     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x057d
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x050e
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x050e:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r0 = r0.f75232b     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r2 = "moviepass"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x057d
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0521
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0521:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = r0.f75231a     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x052c
            java.lang.String r4 = r0.getPushCity()     // Catch:{ Exception -> 0x05d0 }
            goto L_0x052d
        L_0x052c:
            r4 = 0
        L_0x052d:
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x05d0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0542
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = new net.one97.paytm.common.entity.CJRSelectCityModel     // Catch:{ Exception -> 0x05d0 }
            r0.<init>()     // Catch:{ Exception -> 0x05d0 }
            r0.setValue(r4)     // Catch:{ Exception -> 0x05d0 }
            r0.setlabel(r4)     // Catch:{ Exception -> 0x05d0 }
            goto L_0x0554
        L_0x0542:
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0549
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0549:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r4 = r0.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r4 == 0) goto L_0x0553
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x05d0 }
            r0 = r4
            goto L_0x0554
        L_0x0553:
            r0 = 0
        L_0x0554:
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x055b
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x055b:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel r4 = new net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel     // Catch:{ Exception -> 0x05d0 }
            r8 = 0
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x05d0 }
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x05d0 }
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r7 = r4
            r9 = r10
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x05d0 }
            r2.f75236f = r4     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.viewmodel.c r2 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r2 != 0) goto L_0x0576
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0576:
            net.one97.paytm.o2o.movies.e.a r2 = r2.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel r2 = r2.f75236f     // Catch:{ Exception -> 0x05d0 }
            r1.a((net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel) r2, (net.one97.paytm.common.entity.CJRSelectCityModel) r0)     // Catch:{ Exception -> 0x05d0 }
        L_0x057d:
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0584
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0584:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            java.lang.String r0 = r0.f75232b     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x05a0
            java.lang.String r2 = "movies_group"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r6)     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x059e
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x0599
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x0599:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            r2 = 0
            r0.f75231a = r2     // Catch:{ Exception -> 0x05d0 }
        L_0x059e:
            kotlin.x r0 = kotlin.x.f47997a     // Catch:{ Exception -> 0x05d0 }
        L_0x05a0:
            return
        L_0x05a1:
            r2 = 0
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x05a9
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x05a9:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x05c9
            net.one97.paytm.o2o.movies.viewmodel.c r0 = r1.f74170c     // Catch:{ Exception -> 0x05d0 }
            if (r0 != 0) goto L_0x05b6
            kotlin.g.b.k.a((java.lang.String) r3)     // Catch:{ Exception -> 0x05d0 }
        L_0x05b6:
            net.one97.paytm.o2o.movies.e.a r0 = r0.u     // Catch:{ Exception -> 0x05d0 }
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r0.f75234d     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x05c1
            java.lang.String r4 = r0.getValue()     // Catch:{ Exception -> 0x05d0 }
            r2 = r4
        L_0x05c1:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x05d0 }
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05d0 }
            if (r0 == 0) goto L_0x05cf
        L_0x05c9:
            r0 = 54378(0xd46a, float:7.62E-41)
            r1.a((int) r0)     // Catch:{ Exception -> 0x05d0 }
        L_0x05cf:
            return
        L_0x05d0:
            r0 = move-exception
            java.lang.String r2 = "exception"
            kotlin.g.b.k.c(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.MoviesHomeActivity.i():void");
    }

    public final void a(int i2) {
        try {
            k();
            net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
            if (cVar == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            net.one97.paytm.o2o.movies.utils.r.a(cVar.u.f75237g);
            Intent intent = new Intent(this, AJRMoviesSelectCityActivity.class);
            net.one97.paytm.o2o.movies.viewmodel.c cVar2 = this.f74170c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            intent.putExtra("userselectedcity", cVar2.u.f75234d);
            net.one97.paytm.o2o.movies.viewmodel.c cVar3 = this.f74170c;
            if (cVar3 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            if (cVar3.u.f75234d != null) {
                net.one97.paytm.o2o.movies.viewmodel.c cVar4 = this.f74170c;
                if (cVar4 == null) {
                    kotlin.g.b.k.a("moviesHomeViewModel");
                }
                CJRSelectCityModel cJRSelectCityModel = cVar4.u.f75234d;
                intent.putExtra("usercurrentcity", cJRSelectCityModel != null ? cJRSelectCityModel.getValue() : null);
            }
            intent.putExtra("sourcename", "movietickets");
            intent.addFlags(67108864);
            startActivityForResult(intent, i2);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
            j();
        } catch (Exception e2) {
            kotlin.g.b.k.c(e2, "exception");
        }
    }

    private final void j() {
        ((RelativeLayout) b(R.id.next_page_loading_progress)).setVisibility(8);
    }

    private final void k() {
        ProgressBar progressBar = (ProgressBar) b(R.id.transparent_bg_progressbar);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    static final class ah implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRMoviePassHomeModel f74188b;

        ah(MoviesHomeActivity moviesHomeActivity, CJRMoviePassHomeModel cJRMoviePassHomeModel) {
            this.f74187a = moviesHomeActivity;
            this.f74188b = cJRMoviePassHomeModel;
        }

        public final void onClick(View view) {
            MoviesHomeActivity moviesHomeActivity = this.f74187a;
            moviesHomeActivity.a(this.f74188b, moviesHomeActivity.a().u.f75234d);
            Context context = this.f74187a.a().u.f75237g;
            kotlin.g.b.k.c(context, "context");
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies");
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.H);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "movie_pass_tab_clicked");
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.G);
                if (com.paytm.utility.b.r(context)) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(context));
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, context);
            } catch (Exception unused) {
            }
        }
    }

    private final Boolean l() {
        if (!net.one97.paytm.o2o.movies.utils.n.c(net.one97.paytm.o2o.movies.utils.n.c())) {
            return Boolean.TRUE;
        }
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        CJRMoviePassHomeModel cJRMoviePassHomeModel = cVar.u.f75236f;
        if (cJRMoviePassHomeModel != null) {
            return cJRMoviePassHomeModel.isSubscribedUser();
        }
        return null;
    }

    public final void a(CJRMoviePassHomeModel cJRMoviePassHomeModel, CJRSelectCityModel cJRSelectCityModel) {
        Intent intent = new Intent(this, AJRMoviePassHomePageActivity.class);
        intent.putExtra("mo_home_data", cJRMoviePassHomeModel);
        intent.putExtra("userselectedcity", cJRSelectCityModel);
        CJRUpcomingMovies cJRUpcomingMovies = this.l;
        if (cJRUpcomingMovies != null) {
            intent.putExtra("upcoming_movies_data", cJRUpcomingMovies);
        }
        if (!net.one97.paytm.o2o.movies.common.d.a((List) this.j)) {
            intent.putParcelableArrayListExtra("cinemas_data", this.j);
        }
        CJRHomePageItem cJRHomePageItem = this.f74174g;
        if (cJRHomePageItem != null) {
            String str = null;
            if (!TextUtils.isEmpty(cJRHomePageItem != null ? cJRHomePageItem.getPushCode() : null)) {
                CJRHomePageItem cJRHomePageItem2 = this.f74174g;
                if (cJRHomePageItem2 != null) {
                    str = cJRHomePageItem2.getPushCode();
                }
                intent.putExtra("mp_code", str);
            }
        }
        startActivity(intent);
    }

    private final void a(boolean z2) {
        if (z2) {
            ((LinearLayout) b(R.id.no_network)).setVisibility(0);
        } else {
            ((LinearLayout) b(R.id.no_network)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void b(boolean z2) {
        if (z2) {
            ((RelativeLayout) b(R.id.lyt_progress_bar)).setVisibility(0);
            try {
                if (!((ShimmerFrameLayout) b(R.id.movies_home_shimmer)).f49623a) {
                    ((ShimmerFrameLayout) b(R.id.movies_home_shimmer)).a();
                }
            } catch (Exception unused) {
            }
        } else {
            ((RelativeLayout) b(R.id.lyt_progress_bar)).setVisibility(8);
            try {
                if (((ShimmerFrameLayout) b(R.id.movies_home_shimmer)).f49623a) {
                    ((ShimmerFrameLayout) b(R.id.movies_home_shimmer)).b();
                }
            } catch (Exception unused2) {
            }
        }
    }

    static final class af implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74183a;

        af(MoviesHomeActivity moviesHomeActivity) {
            this.f74183a = moviesHomeActivity;
        }

        public final void run() {
            ((CJRCustomRecyclerView) this.f74183a.b(R.id.movie_home_page_list)).scrollToPosition(0);
        }
    }

    public final void d() {
        ((CJRCustomRecyclerView) b(R.id.movie_home_page_list)).post(new af(this));
    }

    static final class ab implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74179a;

        ab(MoviesHomeActivity moviesHomeActivity) {
            this.f74179a = moviesHomeActivity;
        }

        public final void onClick(View view) {
            if (((ImageView) this.f74179a.b(R.id.zoomed_qr_image)).getVisibility() == 0) {
                this.f74179a.f();
            }
        }
    }

    public static final class ac implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74180a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        ac(MoviesHomeActivity moviesHomeActivity) {
            this.f74180a = moviesHomeActivity;
        }

        public final void onPageSelected(int i2) {
            MoviesHomeActivity moviesHomeActivity = this.f74180a;
            ArrayList f2 = moviesHomeActivity.f74171d;
            if (f2 == null) {
                kotlin.g.b.k.a();
            }
            moviesHomeActivity.a((CJRBookedMovieTicket) f2.get(i2));
        }
    }

    public static final class ad implements SlidingUpPanelLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74181a;

        public final void a(View view, SlidingUpPanelLayout.c cVar, SlidingUpPanelLayout.c cVar2) {
            kotlin.g.b.k.c(view, "panel");
            kotlin.g.b.k.c(cVar, "previousState");
            kotlin.g.b.k.c(cVar2, "newState");
        }

        ad(MoviesHomeActivity moviesHomeActivity) {
            this.f74181a = moviesHomeActivity;
        }

        public final void a(View view, float f2) {
            kotlin.g.b.k.c(view, "panel");
            if (this.f74181a.q) {
                LinearLayout linearLayout = (LinearLayout) this.f74181a.b(R.id.upcommingMovieBottomLayout);
                kotlin.g.b.k.a((Object) linearLayout, "upcommingMovieBottomLayout");
                linearLayout.setVisibility(0);
                RelativeLayout relativeLayout = (RelativeLayout) this.f74181a.b(R.id.parentContainerForUpcommingBooking);
                kotlin.g.b.k.a((Object) relativeLayout, "parentContainerForUpcommingBooking");
                relativeLayout.setAlpha(f2);
                LinearLayout linearLayout2 = (LinearLayout) this.f74181a.b(R.id.upcommingMovieBottomLayout);
                kotlin.g.b.k.a((Object) linearLayout2, "upcommingMovieBottomLayout");
                float f3 = 1.0f - f2;
                linearLayout2.setAlpha(f3);
                if (((double) f2) < 0.5d) {
                    ((SlidingUpPanelLayout) this.f74181a.b(R.id.sliding_layout)).setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
                com.paytm.utility.q.d("isSlidingDown : " + this.f74181a.q + " ->  ViewPager offset value : " + f2 + " -> BottomLayout Offset Value : " + f3 + " Height : " + view.getHeight());
                return;
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) this.f74181a.b(R.id.parentContainerForUpcommingBooking);
            kotlin.g.b.k.a((Object) relativeLayout2, "parentContainerForUpcommingBooking");
            relativeLayout2.setVisibility(0);
            LinearLayout linearLayout3 = (LinearLayout) this.f74181a.b(R.id.upcommingMovieBottomLayout);
            kotlin.g.b.k.a((Object) linearLayout3, "upcommingMovieBottomLayout");
            float f4 = 1.0f - f2;
            linearLayout3.setAlpha(f4);
            RelativeLayout relativeLayout3 = (RelativeLayout) this.f74181a.b(R.id.parentContainerForUpcommingBooking);
            kotlin.g.b.k.a((Object) relativeLayout3, "parentContainerForUpcommingBooking");
            relativeLayout3.setAlpha(f2);
            com.paytm.utility.q.d("isSlidingDown : " + this.f74181a.q + " ->  ViewPager offset value : " + f4 + " -> BottomLayout Offset Value : " + f2 + "Height : " + view.getHeight());
        }

        public final void a(View view) {
            kotlin.g.b.k.c(view, "panel");
            this.f74181a.q = true;
            RelativeLayout relativeLayout = (RelativeLayout) this.f74181a.b(R.id.parentContainerForUpcommingBooking);
            kotlin.g.b.k.a((Object) relativeLayout, "parentContainerForUpcommingBooking");
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.f74181a.b(R.id.parentContainerForUpcommingBooking);
            kotlin.g.b.k.a((Object) relativeLayout2, "parentContainerForUpcommingBooking");
            relativeLayout2.setAlpha(1.0f);
            LinearLayout linearLayout = (LinearLayout) this.f74181a.b(R.id.upcommingMovieBottomLayout);
            kotlin.g.b.k.a((Object) linearLayout, "upcommingMovieBottomLayout");
            linearLayout.setVisibility(4);
            LinearLayout linearLayout2 = (LinearLayout) this.f74181a.b(R.id.upcommingMovieBottomLayout);
            kotlin.g.b.k.a((Object) linearLayout2, "upcommingMovieBottomLayout");
            linearLayout2.setAlpha(1.0f);
            com.paytm.utility.q.d("onPanelOpened");
            MoviesHomeActivity moviesHomeActivity = this.f74181a;
            RelativeLayout relativeLayout3 = (RelativeLayout) moviesHomeActivity.b(R.id.innerRootLayout);
            kotlin.g.b.k.a((Object) relativeLayout3, "innerRootLayout");
            moviesHomeActivity.a((View) relativeLayout3, false);
            ((SlidingUpPanelLayout) this.f74181a.b(R.id.sliding_layout)).setBackgroundColor(Color.parseColor("#99000000"));
        }

        public final void b(View view) {
            kotlin.g.b.k.c(view, "panel");
            this.f74181a.q = false;
            RelativeLayout relativeLayout = (RelativeLayout) this.f74181a.b(R.id.parentContainerForUpcommingBooking);
            kotlin.g.b.k.a((Object) relativeLayout, "parentContainerForUpcommingBooking");
            relativeLayout.setVisibility(4);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.f74181a.b(R.id.parentContainerForUpcommingBooking);
            kotlin.g.b.k.a((Object) relativeLayout2, "parentContainerForUpcommingBooking");
            relativeLayout2.setAlpha(1.0f);
            LinearLayout linearLayout = (LinearLayout) this.f74181a.b(R.id.upcommingMovieBottomLayout);
            kotlin.g.b.k.a((Object) linearLayout, "upcommingMovieBottomLayout");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = (LinearLayout) this.f74181a.b(R.id.upcommingMovieBottomLayout);
            kotlin.g.b.k.a((Object) linearLayout2, "upcommingMovieBottomLayout");
            linearLayout2.setAlpha(1.0f);
            DynamicHeightViewPager dynamicHeightViewPager = (DynamicHeightViewPager) this.f74181a.b(R.id.upcommingBookingViewPager);
            kotlin.g.b.k.a((Object) dynamicHeightViewPager, "upcommingBookingViewPager");
            dynamicHeightViewPager.setCurrentItem(0);
            com.paytm.utility.q.d("onPanelClosed");
            MoviesHomeActivity moviesHomeActivity = this.f74181a;
            RelativeLayout relativeLayout3 = (RelativeLayout) moviesHomeActivity.b(R.id.innerRootLayout);
            kotlin.g.b.k.a((Object) relativeLayout3, "innerRootLayout");
            moviesHomeActivity.a((View) relativeLayout3, true);
            ((SlidingUpPanelLayout) this.f74181a.b(R.id.sliding_layout)).setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }

    static final class ae implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74182a;

        ae(MoviesHomeActivity moviesHomeActivity) {
            this.f74182a = moviesHomeActivity;
        }

        public final void onClick(View view) {
            this.f74182a.e();
        }
    }

    public final void b(String str) {
        e();
        Intent intent = new Intent(this, AJRMovieOrderSummary.class);
        intent.putExtra(UpiConstants.FROM, "Order_history");
        intent.putExtra("order_id", str);
        startActivity(intent);
    }

    public final void a(CJRQRImageModel cJRQRImageModel) {
        kotlin.g.b.k.c(cJRQRImageModel, "dataModel");
        View thumbView = cJRQRImageModel.getThumbView();
        kotlin.g.b.k.a((Object) thumbView, "dataModel.thumbView");
        Bitmap bitmap = cJRQRImageModel.getBitmap();
        kotlin.g.b.k.a((Object) bitmap, "dataModel.bitmap");
        this.v = thumbView;
        this.w = new int[2];
        thumbView.getLocationOnScreen(this.w);
        ((ImageView) b(R.id.zoomed_qr_image)).setX((float) this.w[0]);
        ((ImageView) b(R.id.zoomed_qr_image)).setY((float) this.w[1]);
        ((ImageView) b(R.id.zoomed_qr_image)).setPivotX(0.0f);
        ((ImageView) b(R.id.zoomed_qr_image)).setPivotY(0.0f);
        ((ImageView) b(R.id.zoomed_qr_image)).getLayoutParams().width = thumbView.getWidth();
        ((ImageView) b(R.id.zoomed_qr_image)).getLayoutParams().height = thumbView.getHeight();
        ((ImageView) b(R.id.zoomed_qr_image)).setImageBitmap(bitmap);
        f();
    }

    public final void e() {
        if (((SlidingUpPanelLayout) b(R.id.sliding_layout)).getPanelState() != SlidingUpPanelLayout.c.COLLAPSED) {
            ((SlidingUpPanelLayout) b(R.id.sliding_layout)).setPanelState(SlidingUpPanelLayout.c.COLLAPSED);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74189a;

        b(MoviesHomeActivity moviesHomeActivity) {
            this.f74189a = moviesHomeActivity;
        }

        public final void run() {
            if (((SlidingUpPanelLayout) this.f74189a.b(R.id.sliding_layout)).getPanelState() != SlidingUpPanelLayout.c.EXPANDED) {
                ((SlidingUpPanelLayout) this.f74189a.b(R.id.sliding_layout)).setPanelState(SlidingUpPanelLayout.c.EXPANDED);
            }
        }
    }

    static final class ag implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74184a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRHomePageResponse.Language f74185b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LinearLayout f74186c;

        ag(MoviesHomeActivity moviesHomeActivity, CJRHomePageResponse.Language language, LinearLayout linearLayout) {
            this.f74184a = moviesHomeActivity;
            this.f74185b = language;
            this.f74186c = linearLayout;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "v");
            String str = null;
            if (this.f74184a.r != null) {
                CJRHomePageResponse.Language r = this.f74184a.r;
                if (kotlin.m.p.a(r != null ? r.languageForOperation : null, this.f74185b.languageForOperation, true)) {
                    return;
                }
            }
            this.f74184a.r = this.f74185b;
            if (kotlin.m.p.a(this.f74185b.languageForOperation, AppConstants.FOR_ALL, true)) {
                MoviesHomeActivity moviesHomeActivity = this.f74184a;
                moviesHomeActivity.s = moviesHomeActivity.t;
            } else {
                MoviesHomeActivity moviesHomeActivity2 = this.f74184a;
                CJRHomePageResponse.Language r2 = moviesHomeActivity2.r;
                moviesHomeActivity2.s = net.one97.paytm.o2o.movies.utils.n.a(r2 != null ? r2.languageForOperation : null, (ArrayList<CJRMovieHomeListItem>) this.f74184a.t);
            }
            Object obj = this.f74184a.k.get(0);
            kotlin.g.b.k.a(obj, "mMoviesHomePageItemList[0]");
            ((CJRMoviesHomePageItem) obj).setMoviesListV2(this.f74184a.s);
            net.one97.paytm.o2o.movies.adapter.y c2 = this.f74184a.n;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            c2.notifyDataSetChanged();
            net.one97.paytm.o2o.movies.adapter.y c3 = this.f74184a.n;
            if (c3 == null) {
                kotlin.g.b.k.a();
            }
            CJRHomePageResponse.Language r3 = this.f74184a.r;
            if (r3 != null) {
                str = r3.languageToDisplay;
            }
            c3.f74817d = str.equalsIgnoreCase(c3.f74815b.getResources().getString(R.string.all_languages));
            MoviesHomeActivity.a(this.f74184a, this.f74186c, view);
            int a2 = MoviesHomeActivity.a(this.f74184a, view);
            if (a2 == 0 || a2 == 1) {
                MoviesHomeActivity.a(this.f74184a, (TextView) view, a2);
            }
            ((AppBarLayout) this.f74184a.b(R.id.id_movie_home_appbar)).setExpanded(false);
            this.f74184a.d();
        }
    }

    static final class e<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f74193b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRHomePageItem f74194c;

        e(MoviesHomeActivity moviesHomeActivity, Intent intent, CJRHomePageItem cJRHomePageItem) {
            this.f74192a = moviesHomeActivity;
            this.f74193b = intent;
            this.f74194c = cJRHomePageItem;
        }

        public final /* synthetic */ Object call() {
            Intent intent = this.f74193b;
            String str = null;
            String stringExtra = intent != null ? intent.getStringExtra("extra_url_type") : null;
            if (stringExtra != null) {
                this.f74192a.f74175h = stringExtra;
            }
            Intent intent2 = this.f74193b;
            if (intent2 != null) {
                str = intent2.getStringExtra("origin");
            }
            if (str != null) {
                this.f74192a.a().u.f75233c = str;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_home_data", this.f74194c);
            bundle.putString("url_type", stringExtra);
            bundle.putString("origin", str);
            return bundle;
        }
    }

    private final void a(RoboTextView roboTextView) {
        Context context = this;
        roboTextView.setTextColor(androidx.core.content.b.c(context, R.color.white));
        roboTextView.setBackground(androidx.core.content.b.a(context, R.drawable.movie_lang_bg_selected));
        roboTextView.setFontType(4);
    }

    public final void f() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        Activity activity = this;
        int a2 = com.paytm.utility.b.a(activity);
        int b2 = com.paytm.utility.b.b(activity);
        Integer num = null;
        if (((ImageView) b(R.id.zoomed_qr_image)).getVisibility() == 0) {
            View view = this.v;
            Integer valueOf = view != null ? Integer.valueOf(view.getWidth()) : null;
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            valueAnimator = d(a2, valueOf.intValue());
            View view2 = this.v;
            if (view2 != null) {
                num = Integer.valueOf(view2.getHeight());
            }
            if (num == null) {
                kotlin.g.b.k.a();
            }
            valueAnimator2 = c(b2, num.intValue());
            objectAnimator2 = b(0, this.w[0]);
            objectAnimator = a(0, this.w[1]);
        } else {
            View view3 = this.v;
            Integer valueOf2 = view3 != null ? Integer.valueOf(view3.getWidth()) : null;
            if (valueOf2 == null) {
                kotlin.g.b.k.a();
            }
            valueAnimator = d(valueOf2.intValue(), a2);
            View view4 = this.v;
            if (view4 != null) {
                num = Integer.valueOf(view4.getHeight());
            }
            if (num == null) {
                kotlin.g.b.k.a();
            }
            valueAnimator2 = c(num.intValue(), b2);
            objectAnimator2 = b(this.w[0], 0);
            objectAnimator = a(this.w[1], 0);
        }
        a(valueAnimator, valueAnimator2, objectAnimator2, objectAnimator);
    }

    private final ObjectAnimator a(int i2, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageView) b(R.id.zoomed_qr_image), "y", new float[]{(float) i2, (float) i3});
        kotlin.g.b.k.a((Object) ofFloat, "ObjectAnimator.ofFloat(z….toFloat(), to.toFloat())");
        return ofFloat;
    }

    private final ObjectAnimator b(int i2, int i3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((ImageView) b(R.id.zoomed_qr_image), "x", new float[]{(float) i2, (float) i3});
        kotlin.g.b.k.a((Object) ofFloat, "ObjectAnimator.ofFloat(z….toFloat(), to.toFloat())");
        return ofFloat;
    }

    private final ValueAnimator c(int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.addUpdateListener(new c(this));
        kotlin.g.b.k.a((Object) ofInt, "sizeHeightAnimator");
        return ofInt;
    }

    static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74190a;

        c(MoviesHomeActivity moviesHomeActivity) {
            this.f74190a = moviesHomeActivity;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                ViewGroup.LayoutParams layoutParams = ((ImageView) this.f74190a.b(R.id.zoomed_qr_image)).getLayoutParams();
                kotlin.g.b.k.a((Object) layoutParams, "zoomed_qr_image.getLayoutParams()");
                layoutParams.height = intValue;
                ((ImageView) this.f74190a.b(R.id.zoomed_qr_image)).setLayoutParams(layoutParams);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private final ValueAnimator d(int i2, int i3) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, i3});
        ofInt.addUpdateListener(new d(this));
        kotlin.g.b.k.a((Object) ofInt, "sizeWidthAnimator");
        return ofInt;
    }

    static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74191a;

        d(MoviesHomeActivity moviesHomeActivity) {
            this.f74191a = moviesHomeActivity;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            kotlin.g.b.k.a((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                int intValue = ((Integer) animatedValue).intValue();
                ViewGroup.LayoutParams layoutParams = ((ImageView) this.f74191a.b(R.id.zoomed_qr_image)).getLayoutParams();
                kotlin.g.b.k.a((Object) layoutParams, "zoomed_qr_image.getLayoutParams()");
                layoutParams.width = intValue;
                ((ImageView) this.f74191a.b(R.id.zoomed_qr_image)).setLayoutParams(layoutParams);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private final void a(ValueAnimator valueAnimator, ValueAnimator valueAnimator2, ObjectAnimator objectAnimator, ObjectAnimator objectAnimator2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(new Animator[]{valueAnimator, valueAnimator2, objectAnimator, objectAnimator2});
        animatorSet.addListener(new a(this));
        animatorSet.start();
    }

    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoviesHomeActivity f74177a;

        a(MoviesHomeActivity moviesHomeActivity) {
            this.f74177a = moviesHomeActivity;
        }

        public final void onAnimationStart(Animator animator) {
            kotlin.g.b.k.c(animator, "animation");
            if (((ImageView) this.f74177a.b(R.id.zoomed_qr_image)).getVisibility() == 0) {
                ((ImageView) this.f74177a.b(R.id.zoomed_qr_image)).setVisibility(4);
            } else {
                ((ImageView) this.f74177a.b(R.id.zoomed_qr_image)).setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(CJRBookedMovieTicket cJRBookedMovieTicket) {
        CharSequence charSequence;
        if (cJRBookedMovieTicket != null) {
            TextView textView = (TextView) b(R.id.tv_upcomming_booking_date_time);
            kotlin.g.b.k.a((Object) textView, "tv_upcomming_booking_date_time");
            textView.setText(TextUtils.isEmpty(cJRBookedMovieTicket.getShowTime()) ? "" : net.one97.paytm.o2o.movies.utils.q.a(cJRBookedMovieTicket.getShowTime(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
            TextView textView2 = (TextView) b(R.id.tv_upcomming_booking_movie_name);
            kotlin.g.b.k.a((Object) textView2, "tv_upcomming_booking_movie_name");
            if (!TextUtils.isEmpty(cJRBookedMovieTicket.getMovie())) {
                charSequence = cJRBookedMovieTicket.getMovie();
            }
            textView2.setText(charSequence);
        }
    }

    /* access modifiers changed from: private */
    public final void a(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                kotlin.g.b.k.a((Object) childAt, "child");
                a(childAt, z2);
            }
        }
    }

    private boolean m() {
        return ((SlidingUpPanelLayout) b(R.id.sliding_layout)).getPanelState() == SlidingUpPanelLayout.c.EXPANDED;
    }

    public final void a(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z2, String str3) {
        if (com.paytm.utility.b.c((Context) this) && !m()) {
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.loadPage(this, str, iJRDataModel, str2, i2, arrayList, z2, str3);
        }
    }

    public final void a(String str) {
        AJRUpcomingMoviesActivity.a aVar = AJRUpcomingMoviesActivity.f74111b;
        Context context = this;
        Intent a2 = AJRUpcomingMoviesActivity.a.a(context, str, (String) null);
        if (a2 != null) {
            startActivityForResult(a2, 7);
        } else {
            Toast.makeText(context, R.string.error_something_went_wrong, 0).show();
        }
    }

    public final void a(String str, com.paytm.network.listener.b bVar) {
        Context context = this;
        if (com.paytm.utility.b.r(context)) {
            net.one97.paytm.o2o.movies.utils.j.a(this, str, bVar, "interested", H5AppHandler.CHECK_VALUE);
        } else {
            startActivityForResult(new Intent(context, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), this.A);
        }
    }

    public final void g() {
        Intent intent = new Intent(this, AJRCinemasSearchLanding.class);
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        CJRSelectCityModel cJRSelectCityModel = cVar.u.f75234d;
        intent.putExtra("intent_city_name", cJRSelectCityModel != null ? cJRSelectCityModel.getLabel() : null);
        intent.putParcelableArrayListExtra("cinema_list", this.j);
        List<CJRAmenity> list = this.m;
        if (list != null) {
            intent.putParcelableArrayListExtra("AMENITIES_list", (ArrayList) list);
        }
        intent.putExtra("movie_ticket_selected_item_type", "cinema");
        startActivity(intent);
        overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }

    public final void a(CJRCinemas cJRCinemas) {
        kotlin.g.b.k.c(cJRCinemas, "mCinema");
        net.one97.paytm.o2o.movies.viewmodel.c cVar = this.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        CJRSelectCityModel cJRSelectCityModel = cVar.u.f75234d;
        String str = null;
        String value = cJRSelectCityModel != null ? cJRSelectCityModel.getValue() : null;
        Integer isCurrentCityCinema = cJRCinemas.isCurrentCityCinema();
        if (isCurrentCityCinema != null && isCurrentCityCinema.intValue() == 1) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar2 = this.f74170c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            CJRSelectCityModel cJRSelectCityModel2 = cVar2.u.f75234d;
            if (cJRSelectCityModel2 != null) {
                str = cJRSelectCityModel2.getValue();
            }
            value = str;
        } else if (!TextUtils.isEmpty("")) {
            value = "";
        }
        Intent intent = new Intent(this, AJRCinemaDetailsActivity.class);
        intent.putExtra("movie_ticket_city_selected", value);
        intent.putExtra("movie_ticket_selected_item_type", "cinema");
        intent.putExtra("movie_ticket_selected_item_value", String.valueOf(cJRCinemas.getPaytmCinemaId()));
        net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
        kotlin.g.b.k.a((Object) a2, "CJRMovieSearchResponseHo…erSingleton.getInstance()");
        a2.f75936f = cJRCinemas;
        startActivity(intent);
        overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }

    public final void a(IJRDataModel iJRDataModel) {
        if (iJRDataModel instanceof CJRHomePageItem) {
            a(((CJRHomePageItem) iJRDataModel).getURLType(), iJRDataModel, "", 0, (ArrayList<? extends CJRItem>) null, false, "");
        }
    }

    private final HashMap<String, Object> n() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies");
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.s);
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Home Screen Loaded");
        Context context = this;
        String b2 = net.one97.paytm.o2o.movies.common.d.b(context);
        if (b2 != null) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75013h, b2);
        }
        if (!TextUtils.isEmpty(this.f74176i)) {
            String str = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            String str2 = this.f74176i;
            if (str2 != null) {
                hashMap.put(str, str2);
            } else {
                throw new kotlin.u("null cannot be cast to non-null type kotlin.String");
            }
        }
        Iterator<CJRMoviesHomePageItem> it2 = this.k.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            CJRMoviesHomePageItem next = it2.next();
            kotlin.g.b.k.a((Object) next, "cjrMoviesHomePageItem");
            if (kotlin.m.p.a(next.getRowType(), "top_movies", true) && next.getMoviesListV2() != null && !next.getMoviesListV2().isEmpty()) {
                int size = next.getMoviesListV2().size();
                String str3 = net.one97.paytm.o2o.movies.common.b.b.o;
                if (size > 6) {
                    size = 6;
                }
                hashMap.put(str3, Integer.valueOf(size));
            }
        }
        String str4 = net.one97.paytm.o2o.movies.common.b.b.p;
        kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
        String str5 = net.one97.paytm.o2o.movies.common.b.b.r;
        kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_VALUE_VERTICAL_NAME");
        hashMap.put(str4, str5);
        if (com.paytm.utility.b.r(context)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(context));
        }
        return hashMap;
    }

    public final Activity getHostActivity() {
        return this;
    }

    public final void onDestroy() {
        try {
            androidx.localbroadcastmanager.a.a.a((Context) this).a(this.B);
        } catch (Exception unused) {
        }
        net.one97.paytm.o2o.movies.utils.l lVar = this.z;
        if (lVar != null) {
            lVar.f75959f = null;
            lVar.f75958e = null;
        }
        this.z = null;
        io.reactivex.rxjava3.b.c cVar = this.x;
        if (cVar != null) {
            cVar.dispose();
        }
        net.one97.paytm.o2o.movies.utils.i a2 = net.one97.paytm.o2o.movies.utils.i.a();
        try {
            com.paytm.utility.b.j();
            if (a2.f75932b != null) {
                a2.f75932b.clear();
            }
            if (a2.f75933c != null) {
                a2.f75933c.clear();
            }
            a2.f75931a = null;
        } catch (Exception unused2) {
        }
        net.one97.paytm.o2o.movies.utils.n.d();
        super.onDestroy();
    }

    public static final /* synthetic */ void a(MoviesHomeActivity moviesHomeActivity) {
        Intent intent = new Intent(moviesHomeActivity, AJRMoviesSelectCityActivity.class);
        net.one97.paytm.o2o.movies.viewmodel.c cVar = moviesHomeActivity.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        intent.putExtra("userselectedcity", cVar.u.f75234d);
        net.one97.paytm.o2o.movies.viewmodel.c cVar2 = moviesHomeActivity.f74170c;
        if (cVar2 == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        if (cVar2.u.f75234d != null) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar3 = moviesHomeActivity.f74170c;
            if (cVar3 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            CJRSelectCityModel cJRSelectCityModel = cVar3.u.f75234d;
            intent.putExtra("usercurrentcity", cJRSelectCityModel != null ? cJRSelectCityModel.getValue() : null);
        }
        intent.addFlags(67108864);
        intent.putExtra("sourcename", "movietickets");
        moviesHomeActivity.startActivityForResult(intent, 1);
        moviesHomeActivity.overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }

    public static final /* synthetic */ void a(MoviesHomeActivity moviesHomeActivity, Bundle bundle) {
        if (bundle.containsKey("origin")) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar = moviesHomeActivity.f74170c;
            if (cVar == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            net.one97.paytm.o2o.movies.e.a aVar = cVar.u;
            String string = bundle.getString("origin");
            if (string != null) {
                aVar.f75233c = string;
                Context context = aVar.f75237g;
                kotlin.g.b.k.c(context, "context");
                try {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEvents("mov_home_loaded", context);
                } catch (Exception unused) {
                }
            }
        }
        if (bundle.containsKey("url_type")) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar2 = moviesHomeActivity.f74170c;
            if (cVar2 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            cVar2.u.f75232b = bundle.getString("url_type");
        }
        if (bundle.containsKey("extra_home_data") && (bundle.getSerializable("extra_home_data") instanceof CJRHomePageItem)) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar3 = moviesHomeActivity.f74170c;
            if (cVar3 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            net.one97.paytm.o2o.movies.e.a aVar2 = cVar3.u;
            Serializable serializable = bundle.getSerializable("extra_home_data");
            if (serializable != null) {
                aVar2.a((CJRHomePageItem) serializable);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJRHomePageItem");
        }
    }

    public static final /* synthetic */ void g(MoviesHomeActivity moviesHomeActivity) {
        if (moviesHomeActivity.f74171d != null) {
            if (((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).getPanelState() != SlidingUpPanelLayout.c.EXPANDED) {
                ((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).setPanelState(SlidingUpPanelLayout.c.EXPANDED);
            }
            ((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).setPanelHeight(com.paytm.utility.b.c(80));
            ((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).postDelayed(new b(moviesHomeActivity), 20);
            ((ImageView) moviesHomeActivity.b(R.id.zoomed_qr_image)).setOnClickListener(new ab(moviesHomeActivity));
            ArrayList<CJRBookedMovieTicket> arrayList = moviesHomeActivity.f74171d;
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            moviesHomeActivity.a(arrayList.get(0));
            ai aiVar = new ai(moviesHomeActivity.f74171d, moviesHomeActivity);
            DynamicHeightViewPager dynamicHeightViewPager = (DynamicHeightViewPager) moviesHomeActivity.b(R.id.upcommingBookingViewPager);
            kotlin.g.b.k.a((Object) dynamicHeightViewPager, "upcommingBookingViewPager");
            dynamicHeightViewPager.setAdapter(aiVar);
            DynamicHeightViewPager dynamicHeightViewPager2 = (DynamicHeightViewPager) moviesHomeActivity.b(R.id.upcommingBookingViewPager);
            kotlin.g.b.k.a((Object) dynamicHeightViewPager2, "upcommingBookingViewPager");
            ArrayList<CJRBookedMovieTicket> arrayList2 = moviesHomeActivity.f74171d;
            if (arrayList2 == null) {
                kotlin.g.b.k.a();
            }
            dynamicHeightViewPager2.setOffscreenPageLimit(arrayList2.size());
            ((CirclePageIndicator) moviesHomeActivity.b(R.id.upcomming_booking_indicator)).setViewPager((DynamicHeightViewPager) moviesHomeActivity.b(R.id.upcommingBookingViewPager));
            ((CirclePageIndicator) moviesHomeActivity.b(R.id.upcomming_booking_indicator)).setOnPageChangeListener(new ac(moviesHomeActivity));
            SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout);
            SlidingUpPanelLayout.b adVar = new ad(moviesHomeActivity);
            synchronized (slidingUpPanelLayout.f75849a) {
                slidingUpPanelLayout.f75849a.add(adVar);
            }
            ((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).setFadeOnClickListener(new ae(moviesHomeActivity));
            ArrayList<CJRBookedMovieTicket> arrayList3 = moviesHomeActivity.f74171d;
            if (arrayList3 != null) {
                if (arrayList3 == null) {
                    kotlin.g.b.k.a();
                }
                if (arrayList3.size() > 1) {
                    ((CirclePageIndicator) moviesHomeActivity.b(R.id.upcomming_booking_indicator)).setVisibility(0);
                    return;
                }
            }
            ((CirclePageIndicator) moviesHomeActivity.b(R.id.upcomming_booking_indicator)).setVisibility(8);
        }
    }

    public static final /* synthetic */ void h(MoviesHomeActivity moviesHomeActivity) {
        if (((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).getPanelState() != SlidingUpPanelLayout.c.HIDDEN) {
            ((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).setPanelState(SlidingUpPanelLayout.c.HIDDEN);
        }
        ((SlidingUpPanelLayout) moviesHomeActivity.b(R.id.sliding_layout)).setPanelHeight(0);
    }

    public static final /* synthetic */ ArrayList a(MoviesHomeActivity moviesHomeActivity, CJRHomePageResponse cJRHomePageResponse) {
        ArrayList<CJRMovieHomeListItem> arrayList;
        if (cJRHomePageResponse.mMovieLanguageList != null && cJRHomePageResponse.mMovieLanguageList.size() > 0) {
            CJRHomePageResponse.Language language = new CJRHomePageResponse.Language();
            language.languageForOperation = AppConstants.FOR_ALL;
            language.languageToDisplay = moviesHomeActivity.getString(R.string.all_languages);
            cJRHomePageResponse.mMovieLanguageList.add(0, language);
        }
        ArrayList<CJRHomePageResponse.Language> arrayList2 = cJRHomePageResponse.mMovieLanguageList;
        if (arrayList2 == null || arrayList2.size() == 0) {
            ((HorizontalScrollView) moviesHomeActivity.b(R.id.id_lang_scroll)).setVisibility(8);
            CJRHomePageResponse.Language language2 = new CJRHomePageResponse.Language();
            language2.languageForOperation = AppConstants.FOR_ALL;
            language2.languageToDisplay = moviesHomeActivity.getString(R.string.all_languages);
        } else {
            ((HorizontalScrollView) moviesHomeActivity.b(R.id.id_lang_scroll)).setVisibility(0);
            View findViewById = ((HorizontalScrollView) moviesHomeActivity.b(R.id.id_lang_scroll)).findViewById(R.id.id_language_ll);
            kotlin.g.b.k.a((Object) findViewById, "id_lang_scroll.findViewById(R.id.id_language_ll)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            linearLayout.removeAllViews();
            Context context = moviesHomeActivity;
            Space space = new Space(context);
            space.setLayoutParams(new LinearLayout.LayoutParams(com.paytm.utility.b.c(15), 1));
            linearLayout.addView(space);
            Iterator<CJRHomePageResponse.Language> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                CJRHomePageResponse.Language next = it2.next();
                View inflate = moviesHomeActivity.getLayoutInflater().inflate(R.layout.movie_lang_item, linearLayout, false);
                if (inflate != null) {
                    RoboTextView roboTextView = (RoboTextView) inflate;
                    roboTextView.setText(next.languageToDisplay);
                    linearLayout.addView(roboTextView);
                    Space space2 = new Space(context);
                    space2.setLayoutParams(new LinearLayout.LayoutParams(com.paytm.utility.b.c(10), 1));
                    linearLayout.addView(space2);
                    net.one97.paytm.o2o.movies.viewmodel.c cVar = moviesHomeActivity.f74170c;
                    if (cVar == null) {
                        kotlin.g.b.k.a("moviesHomeViewModel");
                    }
                    if (cVar.u.f75235e != null) {
                        net.one97.paytm.o2o.movies.viewmodel.c cVar2 = moviesHomeActivity.f74170c;
                        if (cVar2 == null) {
                            kotlin.g.b.k.a("moviesHomeViewModel");
                        }
                        CJRHomePageResponse.Language language3 = cVar2.u.f75235e;
                        if (kotlin.m.p.a(language3 != null ? language3.languageForOperation : null, next.languageForOperation, true)) {
                            moviesHomeActivity.a(roboTextView);
                        }
                    }
                    roboTextView.setOnClickListener(new ag(moviesHomeActivity, next, linearLayout));
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        moviesHomeActivity.t = cJRHomePageResponse.mPopularMovieList;
        ArrayList<CJRMovieHomeListItem> arrayList4 = moviesHomeActivity.t;
        if (arrayList4 == null || (arrayList4 != null && arrayList4.size() == 0)) {
            CJRMoviesHomePageItem cJRMoviesHomePageItem = new CJRMoviesHomePageItem();
            cJRMoviesHomePageItem.setRowType("no_movies");
            arrayList3.add(cJRMoviesHomePageItem);
        } else {
            net.one97.paytm.o2o.movies.viewmodel.c cVar3 = moviesHomeActivity.f74170c;
            if (cVar3 == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            net.one97.paytm.o2o.movies.e.a aVar = cVar3.u;
            HashMap<String, Object> n2 = moviesHomeActivity.n();
            kotlin.g.b.k.c(n2, Item.CTA_URL_TYPE_MAP);
            Context context2 = aVar.f75237g;
            kotlin.g.b.k.c(context2, "context");
            kotlin.g.b.k.c(n2, Item.CTA_URL_TYPE_MAP);
            net.one97.paytm.o2o.movies.utils.n.b("/movies", context2);
            try {
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, n2, context2);
            } catch (Exception unused) {
            }
            CJRMoviesHomePageItem cJRMoviesHomePageItem2 = new CJRMoviesHomePageItem();
            cJRMoviesHomePageItem2.setItemTitle(moviesHomeActivity.getResources().getString(R.string.popular_movies));
            cJRMoviesHomePageItem2.setRowType("top_movies");
            CJRHomePageResponse.Language language4 = moviesHomeActivity.r;
            if (language4 != null) {
                if (!kotlin.m.p.a(language4 != null ? language4.languageForOperation : null, AppConstants.FOR_ALL, true)) {
                    CJRHomePageResponse.Language language5 = moviesHomeActivity.r;
                    arrayList = net.one97.paytm.o2o.movies.utils.n.a(language5 != null ? language5.languageForOperation : null, cJRHomePageResponse.mPopularMovieList);
                    kotlin.g.b.k.a((Object) arrayList, "CJRMoviesUtility.filterM…eItems.mPopularMovieList)");
                    cJRMoviesHomePageItem2.setMoviesListV2(arrayList);
                    cJRMoviesHomePageItem2.setBannerList((CJRHomePageLayoutV2) null);
                    cJRMoviesHomePageItem2.setSelectedLanguage(moviesHomeActivity.getResources().getString(R.string.all_languages));
                    arrayList3.add(cJRMoviesHomePageItem2);
                }
            }
            arrayList = moviesHomeActivity.t;
            if (arrayList == null) {
                throw new kotlin.u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem>");
            }
            cJRMoviesHomePageItem2.setMoviesListV2(arrayList);
            cJRMoviesHomePageItem2.setBannerList((CJRHomePageLayoutV2) null);
            cJRMoviesHomePageItem2.setSelectedLanguage(moviesHomeActivity.getResources().getString(R.string.all_languages));
            arrayList3.add(cJRMoviesHomePageItem2);
        }
        return arrayList3;
    }

    public static final /* synthetic */ void a(MoviesHomeActivity moviesHomeActivity, CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        if (cJRHomePageLayoutV2 == null || cJRHomePageLayoutV2.getHomePageItemList().size() <= 0) {
            ((SlidingViewPager) moviesHomeActivity.b(R.id.image_pager)).setVisibility(8);
            return;
        }
        ar arVar = moviesHomeActivity.u;
        String str = null;
        if (arVar != null) {
            if (!(arVar == null || arVar.f74459b == null || arVar.f74460c == null)) {
                arVar.f74459b.removeCallbacks(arVar.f74460c);
            }
            moviesHomeActivity.u = null;
        }
        SlidingViewPager slidingViewPager = (SlidingViewPager) moviesHomeActivity.b(R.id.image_pager);
        Context context = moviesHomeActivity;
        ad.a aVar = moviesHomeActivity;
        net.one97.paytm.o2o.movies.viewmodel.c cVar = moviesHomeActivity.f74170c;
        if (cVar == null) {
            kotlin.g.b.k.a("moviesHomeViewModel");
        }
        CJRSelectCityModel cJRSelectCityModel = cVar.u.f75234d;
        if (cJRSelectCityModel != null) {
            str = cJRSelectCityModel.getValue();
        }
        moviesHomeActivity.u = new ar(slidingViewPager, cJRHomePageLayoutV2, context, aVar, str);
        ((SlidingViewPager) moviesHomeActivity.b(R.id.image_pager)).setVisibility(0);
        ar arVar2 = moviesHomeActivity.u;
        if (arVar2 != null) {
            arVar2.a(arVar2);
        }
    }

    public static final /* synthetic */ void a(MoviesHomeActivity moviesHomeActivity, SanitizedResponseModel sanitizedResponseModel) {
        if (!sanitizedResponseModel.getRvWidgets().isEmpty()) {
            View b2 = moviesHomeActivity.b(R.id.ottLayout);
            kotlin.g.b.k.a((Object) b2, "ottLayout");
            RecyclerView recyclerView = (RecyclerView) b2.findViewById(R.id.movies_horizontal_list);
            kotlin.g.b.k.a((Object) recyclerView, "ottRecyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(moviesHomeActivity, 0, false));
            net.one97.paytm.o2o.movies.adapter.aa aaVar = new net.one97.paytm.o2o.movies.adapter.aa(sanitizedResponseModel.getGaListener(), moviesHomeActivity);
            recyclerView.setAdapter(aaVar);
            List<com.paytmmall.clpartifact.modal.clpCommon.View> rvWidgets = sanitizedResponseModel.getRvWidgets();
            kotlin.g.b.k.c(rvWidgets, "value");
            aaVar.f74244a = rvWidgets;
            aaVar.notifyDataSetChanged();
            View b3 = moviesHomeActivity.b(R.id.ottLayout);
            kotlin.g.b.k.a((Object) b3, "ottLayout");
            net.one97.paytm.o2o.movies.common.a.e.a(b3, true);
            return;
        }
        View b4 = moviesHomeActivity.b(R.id.ottLayout);
        kotlin.g.b.k.a((Object) b4, "ottLayout");
        net.one97.paytm.o2o.movies.common.a.e.a(b4, false);
    }

    public static final /* synthetic */ void a(MoviesHomeActivity moviesHomeActivity, CJRMoviePassHomeModel cJRMoviePassHomeModel) {
        if (cJRMoviePassHomeModel != null) {
            net.one97.paytm.o2o.movies.viewmodel.c cVar = moviesHomeActivity.f74170c;
            if (cVar == null) {
                kotlin.g.b.k.a("moviesHomeViewModel");
            }
            cVar.u.f75236f = cJRMoviePassHomeModel;
        }
        if (cJRMoviePassHomeModel != null) {
            Boolean showMoviePassStrip = cJRMoviePassHomeModel.getShowMoviePassStrip();
            if (showMoviePassStrip == null) {
                kotlin.g.b.k.a();
            }
            if (showMoviePassStrip.booleanValue()) {
                RelativeLayout relativeLayout = (RelativeLayout) moviesHomeActivity.b(R.id.moviepass_btn);
                kotlin.g.b.k.a((Object) relativeLayout, "moviepass_btn");
                relativeLayout.setVisibility(0);
                ((RelativeLayout) moviesHomeActivity.b(R.id.moviepass_btn)).setOnClickListener(new ah(moviesHomeActivity, cJRMoviePassHomeModel));
                return;
            }
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) moviesHomeActivity.b(R.id.moviepass_btn);
        kotlin.g.b.k.a((Object) relativeLayout2, "moviepass_btn");
        relativeLayout2.setVisibility(8);
    }

    public static final /* synthetic */ void a(MoviesHomeActivity moviesHomeActivity, LinearLayout linearLayout, View view) {
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt instanceof RoboTextView) {
                    if (childAt == view) {
                        moviesHomeActivity.a((RoboTextView) childAt);
                    } else {
                        RoboTextView roboTextView = (RoboTextView) childAt;
                        Context context = moviesHomeActivity;
                        roboTextView.setTextColor(androidx.core.content.b.c(context, R.color.paytm_blue));
                        roboTextView.setBackground(androidx.core.content.b.a(context, R.drawable.movie_lang_bg_unselected));
                        roboTextView.setFontType(2);
                    }
                }
            }
        }
    }

    public static final /* synthetic */ int a(MoviesHomeActivity moviesHomeActivity, View view) {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) moviesHomeActivity.b(R.id.id_lang_scroll);
        kotlin.g.b.k.a((Object) horizontalScrollView, "id_lang_scroll");
        Rect rect = new Rect();
        horizontalScrollView.getDrawingRect(rect);
        float x2 = view.getX();
        float width = ((float) view.getWidth()) + x2;
        if (((float) rect.left) > x2) {
            return 0;
        }
        return ((float) rect.right) < width ? 1 : -1;
    }

    public static final /* synthetic */ void a(MoviesHomeActivity moviesHomeActivity, TextView textView, int i2) {
        int i3;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) moviesHomeActivity.b(R.id.id_lang_scroll);
        kotlin.g.b.k.a((Object) horizontalScrollView, "id_lang_scroll");
        int width = textView.getWidth();
        Rect rect = new Rect();
        textView.getGlobalVisibleRect(rect);
        if (i2 == 0) {
            i3 = (rect.right - width) - com.paytm.utility.b.c(5);
        } else {
            i3 = Math.abs((width - (com.paytm.utility.b.a((Activity) moviesHomeActivity) - rect.left)) + com.paytm.utility.b.c(5));
        }
        horizontalScrollView.smoothScrollBy(i3, 0);
    }
}
