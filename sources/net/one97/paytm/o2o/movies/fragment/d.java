package net.one97.paytm.o2o.movies.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity;
import net.one97.paytm.o2o.movies.activity.AJRMoviesShowListFilterActivity;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity;
import net.one97.paytm.o2o.movies.adapter.d;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieShowTimeSearchFilterItem;
import net.one97.paytm.o2o.movies.common.movies.a;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieSessionDetails;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget;
import net.one97.paytm.o2o.movies.entity.SeatMapData;
import net.one97.paytm.o2o.movies.seat_selection.SeatSelectionActivity;
import net.one97.paytm.o2o.movies.utils.h;
import net.one97.paytm.o2o.movies.utils.i;
import net.one97.paytm.o2o.movies.utils.n;

public class d extends b implements View.OnClickListener, com.paytm.network.listener.b, d.b {

    /* renamed from: f  reason: collision with root package name */
    private static final Integer f75274f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final Integer f75275g = 2;
    /* access modifiers changed from: private */
    public HashMap<String, CJRMovieCinemaDetailV2> A;
    private AsyncTask<Void, Void, net.one97.paytm.o2o.movies.common.movies.a> B = null;

    /* renamed from: a  reason: collision with root package name */
    public boolean f75276a;

    /* renamed from: b  reason: collision with root package name */
    public String f75277b;

    /* renamed from: c  reason: collision with root package name */
    public String f75278c;

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.o2o.movies.common.movies.a f75279d;

    /* renamed from: e  reason: collision with root package name */
    public Context f75280e;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f75281h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f75282i;
    private RecyclerView j;
    private TextView k;
    private NestedScrollView l;
    /* access modifiers changed from: private */
    public String m;
    private String n;
    /* access modifiers changed from: private */
    public b o;
    private List<CJRMovieDetailsTab> p = new ArrayList();
    /* access modifiers changed from: private */
    public String q;
    private List<CJRMovieShowTimeSearchFilterItem> r;
    private net.one97.paytm.o2o.movies.adapter.d s;
    /* access modifiers changed from: private */
    public Map<String, Map<String, List<CJRMoviesSession>>> t;
    private View u;
    /* access modifiers changed from: private */
    public boolean v;
    /* access modifiers changed from: private */
    public ProgressBar w;
    private HashMap<String, Integer> x;
    /* access modifiers changed from: private */
    public String y;
    private String z = "1";

    public interface b {
        void a();

        void a(String str);

        void a(CJRCinemaV2 cJRCinemaV2, a aVar);

        void b();

        void b(String str);
    }

    public static d a(String str, String str2, String str3, String str4, String str5, boolean z2, boolean z3, String str6) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString("movie_ticket_city_selected", str);
        bundle.putString("movie_ticket_selected_item_type", str2);
        bundle.putString("movie_ticket_selected_item_value", str3);
        bundle.putString("url_type", str4);
        bundle.putString("movie_ticket_booking_date", str6);
        bundle.putString("intent_movie_session", str5);
        bundle.putBoolean("movie_pass_present", z2);
        bundle.putBoolean("is_selected_movie_exists_in_selected_city", z3);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.o = (b) context;
        this.f75280e = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cinema_time_slot_fragment, viewGroup, false);
        i a2 = i.a();
        com.paytm.utility.b.j();
        if (a2.f75932b == null || i.a().f75933c == null || i.a().f75933c.size() == 0 || i.a().f75935e == null || i.a().f75935e.size() == 0 || i.a().f75936f == null) {
            this.z = "1";
        } else {
            this.z = "0";
        }
        Bundle arguments = getArguments();
        this.m = arguments.getString("movie_ticket_city_selected");
        this.f75277b = arguments.getString("movie_ticket_selected_item_type");
        this.f75278c = arguments.getString("movie_ticket_selected_item_value");
        this.n = arguments.getString("url_type");
        this.q = arguments.getString("intent_movie_session");
        this.f75282i = arguments.getBoolean("movie_pass_present");
        this.y = arguments.getString("movie_ticket_booking_date");
        this.f75281h = arguments.getBoolean("is_selected_movie_exists_in_selected_city", true);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.j = (RecyclerView) view.findViewById(R.id.recycler_time_slot_movie);
        this.l = (NestedScrollView) view.findViewById(R.id.root_filter_no_result_found);
        this.k = (TextView) view.findViewById(R.id.btn_clear_filters);
        this.u = view.findViewById(R.id.long_press_hint);
        c();
        ((ImageView) view.findViewById(R.id.cancel_hint)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d.this.a(view);
            }
        });
        this.w = (ProgressBar) view.findViewById(R.id.movie_detail_progress_bar);
        String str = this.y;
        if (str == null) {
            str = "0";
        }
        d(str);
    }

    public void onResume() {
        super.onResume();
        c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037 A[Catch:{ Exception -> 0x013e }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ Exception -> 0x013e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = r5.n     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = "movieCinemaSearchV3"
            r2 = 0
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r5.n     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = "freemovie"
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x013e }
            if (r0 == 0) goto L_0x002a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e }
            r0.<init>()     // Catch:{ Exception -> 0x013e }
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.c.a(r1, r2)     // Catch:{ Exception -> 0x013e }
            r0.append(r1)     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = "?filter=freemovie"
            r0.append(r1)     // Catch:{ Exception -> 0x013e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x013e }
            goto L_0x0031
        L_0x002a:
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x013e }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.c.a(r1, r2)     // Catch:{ Exception -> 0x013e }
        L_0x0031:
            boolean r1 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x013e }
            if (r1 != 0) goto L_0x0038
            return
        L_0x0038:
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x013e }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = "city"
            java.lang.String r3 = r5.m     // Catch:{ Exception -> 0x013e }
            r0.appendQueryParameter(r1, r3)     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = r5.f75277b     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = "movie"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x013e }
            if (r1 == 0) goto L_0x0059
            java.lang.String r1 = "moviecode"
            java.lang.String r3 = r5.f75278c     // Catch:{ Exception -> 0x013e }
            r0.appendQueryParameter(r1, r3)     // Catch:{ Exception -> 0x013e }
            goto L_0x006a
        L_0x0059:
            java.lang.String r1 = r5.f75277b     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = "cinema"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x013e }
            if (r1 == 0) goto L_0x006a
            java.lang.String r1 = "cinemaId"
            java.lang.String r3 = r5.f75278c     // Catch:{ Exception -> 0x013e }
            r0.appendQueryParameter(r1, r3)     // Catch:{ Exception -> 0x013e }
        L_0x006a:
            if (r6 == 0) goto L_0x0079
            java.lang.String r1 = "0"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x013e }
            if (r1 != 0) goto L_0x0079
            java.lang.String r1 = "date"
            r0.appendQueryParameter(r1, r6)     // Catch:{ Exception -> 0x013e }
        L_0x0079:
            java.lang.String r6 = "lang"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e }
            r1.<init>()     // Catch:{ Exception -> 0x013e }
            android.content.Context r3 = r5.getContext()     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = com.paytm.utility.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x013e }
            r1.append(r3)     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = "-IN"
            r1.append(r3)     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x013e }
            r0.appendQueryParameter(r6, r1)     // Catch:{ Exception -> 0x013e }
            java.lang.String r6 = "meta"
            java.lang.String r1 = r5.z     // Catch:{ Exception -> 0x013e }
            r0.appendQueryParameter(r6, r1)     // Catch:{ Exception -> 0x013e }
            android.net.Uri r6 = r0.build()     // Catch:{ Exception -> 0x013e }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x013e }
            android.content.Context r0 = r5.f75280e     // Catch:{ Exception -> 0x013e }
            java.lang.String r6 = com.paytm.utility.b.d((android.content.Context) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x013e }
            java.lang.String r0 = "custId"
            java.lang.String r1 = "userId"
            java.lang.String r6 = r6.replace(r0, r1)     // Catch:{ Exception -> 0x013e }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x013e }
            r0.<init>()     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = "Content-Type"
            java.lang.String r3 = "application/json"
            r0.put(r1, r3)     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = "ClientId"
            java.lang.String r3 = "paytm"
            r0.put(r1, r3)     // Catch:{ Exception -> 0x013e }
            android.content.Context r1 = r5.f75280e     // Catch:{ Exception -> 0x013e }
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)     // Catch:{ Exception -> 0x013e }
            if (r1 == 0) goto L_0x0120
            net.one97.paytm.o2o.movies.common.movies.a r1 = r5.f75279d     // Catch:{ Exception -> 0x013e }
            r3 = 0
            if (r1 == 0) goto L_0x00dd
            r1 = 1
            r5.v = r1     // Catch:{ Exception -> 0x013e }
            android.widget.ProgressBar r1 = r5.w     // Catch:{ Exception -> 0x013e }
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x013e }
            goto L_0x00e2
        L_0x00dd:
            net.one97.paytm.o2o.movies.fragment.d$b r1 = r5.o     // Catch:{ Exception -> 0x013e }
            r1.a()     // Catch:{ Exception -> 0x013e }
        L_0x00e2:
            net.one97.paytm.o2o.movies.utils.c r1 = new net.one97.paytm.o2o.movies.utils.c     // Catch:{ Exception -> 0x013e }
            r1.<init>()     // Catch:{ Exception -> 0x013e }
            android.content.Context r4 = r5.f75280e     // Catch:{ Exception -> 0x013e }
            r1.f42877a = r4     // Catch:{ Exception -> 0x013e }
            com.paytm.network.a$c r4 = com.paytm.network.a.c.MOVIES     // Catch:{ Exception -> 0x013e }
            r1.f42878b = r4     // Catch:{ Exception -> 0x013e }
            com.paytm.network.a$a r4 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x013e }
            r1.f42879c = r4     // Catch:{ Exception -> 0x013e }
            r1.f42880d = r6     // Catch:{ Exception -> 0x013e }
            r1.f42881e = r2     // Catch:{ Exception -> 0x013e }
            r1.f42882f = r0     // Catch:{ Exception -> 0x013e }
            r1.f42883g = r2     // Catch:{ Exception -> 0x013e }
            r1.f42884h = r2     // Catch:{ Exception -> 0x013e }
            net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse r6 = new net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse     // Catch:{ Exception -> 0x013e }
            r6.<init>()     // Catch:{ Exception -> 0x013e }
            r1.f42885i = r6     // Catch:{ Exception -> 0x013e }
            r1.j = r5     // Catch:{ Exception -> 0x013e }
            com.paytm.network.a$b r6 = com.paytm.network.a.b.USER_FACING     // Catch:{ Exception -> 0x013e }
            r1.n = r6     // Catch:{ Exception -> 0x013e }
            java.lang.String r6 = "movies"
            r1.o = r6     // Catch:{ Exception -> 0x013e }
            java.lang.String r6 = "FJRMovieShowtimeFragment"
            org.json.JSONObject r6 = net.one97.paytm.o2o.movies.utils.n.h(r6)     // Catch:{ Exception -> 0x013e }
            r1.t = r6     // Catch:{ Exception -> 0x013e }
            com.paytm.network.a r6 = r1.l()     // Catch:{ Exception -> 0x013e }
            r6.f42859c = r3     // Catch:{ Exception -> 0x013e }
            r6.a()     // Catch:{ Exception -> 0x013e }
            return
        L_0x0120:
            android.content.Context r6 = r5.f75280e     // Catch:{ Exception -> 0x013e }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ Exception -> 0x013e }
            int r1 = net.one97.paytm.common.assets.R.string.no_connection     // Catch:{ Exception -> 0x013e }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x013e }
            android.content.res.Resources r1 = r5.getResources()     // Catch:{ Exception -> 0x013e }
            int r2 = net.one97.paytm.common.assets.R.string.no_internet     // Catch:{ Exception -> 0x013e }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x013e }
            net.one97.paytm.o2o.movies.fragment.-$$Lambda$d$G222niRZdXWH5yHIP-YCH2L16jw r2 = new net.one97.paytm.o2o.movies.fragment.-$$Lambda$d$G222niRZdXWH5yHIP-YCH2L16jw     // Catch:{ Exception -> 0x013e }
            r2.<init>()     // Catch:{ Exception -> 0x013e }
            com.paytm.utility.g.b(r6, r0, r1, r2)     // Catch:{ Exception -> 0x013e }
        L_0x013e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.d.d(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        if (getActivity() != null || !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public void a(net.one97.paytm.o2o.movies.common.movies.a aVar) {
        if (!this.v) {
            this.k.setOnClickListener(new View.OnClickListener(aVar) {
                private final /* synthetic */ a f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    d.this.a(this.f$1, view);
                }
            });
            this.j.setHasFixedSize(true);
            this.j.addOnScrollListener(new RecyclerView.l() {
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                }

                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    super.onScrollStateChanged(recyclerView, i2);
                    if (i2 == 1) {
                        n.b((View) recyclerView);
                    }
                }
            });
            b();
            this.j.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.s = new net.one97.paytm.o2o.movies.adapter.d(this.f75280e, this.f75277b, aVar.j, this);
            this.j.setAdapter(this.s);
        }
        c(aVar.f75135f);
    }

    public final void c(String str) {
        List<CJRMovieSessionDetails> e2 = e(str);
        if (e2 == null) {
            if (this.x == null) {
                this.x = new HashMap<>();
            }
            Integer num = this.x.get(str);
            if (num == null) {
                d(str);
                this.x.put(str, f75274f);
            } else if (num == f75274f) {
                this.w.setVisibility(0);
            } else {
                d(str);
            }
            this.l.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        this.w.setVisibility(8);
        b();
        if (!e2.isEmpty()) {
            this.s.a(e2);
            this.j.setVisibility(0);
            this.l.setVisibility(8);
        } else if (this.f75276a) {
            this.l.setVisibility(0);
            this.j.setVisibility(8);
        }
    }

    public final boolean a() {
        return (this.f75279d.m.getSearchFilters() == null || this.f75279d.m.getSearchFilters().get(this.f75279d.f75135f) == null) ? false : true;
    }

    private List<CJRMovieSessionDetails> e(String str) {
        Map map;
        CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2;
        CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV22;
        Map<String, Map<String, List<CJRMoviesSession>>> map2 = this.t;
        if (map2 == null || (map = map2.get(str)) == null) {
            return null;
        }
        if ("movie".equals(this.f75277b)) {
            List list = this.f75279d.m.getOrderedCinemaList().get(str);
            h hVar = h.f75928a;
            if (this.f75279d.f75131b == null || this.f75279d.f75131b.get(str) == null) {
                cJRMovieCinemaDetailV22 = this.f75279d.m;
            } else {
                cJRMovieCinemaDetailV22 = this.f75279d.f75131b.get(str);
            }
            return h.a(cJRMovieCinemaDetailV22, (Map<String, List<CJRMoviesSession>>) map, (List<String>) list);
        }
        h hVar2 = h.f75928a;
        if (this.f75279d.f75131b == null || this.f75279d.f75131b.get(str) == null) {
            cJRMovieCinemaDetailV2 = this.f75279d.m;
        } else {
            cJRMovieCinemaDetailV2 = this.f75279d.f75131b.get(str);
        }
        return h.a(cJRMovieCinemaDetailV2.getMovies(), (Map<String, List<CJRMoviesSession>>) map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        Intent intent = new Intent(this.f75280e, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("mainActivity"));
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    private void b() {
        "movie".equalsIgnoreCase(this.f75277b);
    }

    public final void a(CJRMoviesSession cJRMoviesSession, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, List<CJRMoviesSession> list, int i3) {
        b(cJRMoviesSession, str, str2, str3, str4, str5, str6, str7, str8, i2, str9, list, i3);
    }

    public final void a(String str) {
        Intent intent = new Intent(getActivity(), AJRCinemaDetailsActivity.class);
        i.a().f75936f = null;
        intent.putExtra("movie_ticket_city_selected", this.m);
        intent.putExtra("movie_ticket_selected_item_type", "cinema");
        intent.putExtra("movie_ticket_selected_item_value", str);
        if (getActivity() != null) {
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
        }
    }

    public final void b(String str) {
        Intent b2 = AJRUpcomingMoviesActivity.b(this.f75280e, str, "show_list");
        if (b2 != null) {
            startActivity(b2);
            if (getActivity() != null) {
                getActivity().overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432579);
            } else {
                Toast.makeText(this.f75280e, R.string.error_something_went_wrong, 0).show();
            }
        }
    }

    private void b(CJRMoviesSession cJRMoviesSession, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, List<CJRMoviesSession> list, int i3) {
        CJRMovieWidget cJRMovieWidget = null;
        if (cJRMoviesSession != null) {
            try {
                cJRMovieWidget = n.a(cJRMoviesSession.getCinemaID(), (List<CJRCinemaV2>) this.f75279d.j);
            } catch (Exception e2) {
                q.c(e2.getMessage());
                return;
            }
        }
        SeatMapData seatMapData = new SeatMapData();
        seatMapData.setSelectedMovieSession(cJRMoviesSession);
        seatMapData.setSelectedCity(this.m);
        seatMapData.setSelectedCategory(this.f75277b);
        seatMapData.setMovieLanguage(str);
        seatMapData.setMovieLocalizedLanguage(str2);
        seatMapData.setTimeSlot(str8);
        seatMapData.setMovieCensor(str3);
        seatMapData.setMovieImageUrl(str4);
        seatMapData.setMovieTitle(str5);
        seatMapData.setMovieLocalizedTitle(str6);
        seatMapData.setMovieDuration(i2);
        seatMapData.setMovieCode(str9);
        seatMapData.setSeatStatus(str7);
        seatMapData.setMoviePassPresent(this.f75282i);
        seatMapData.setSessionList(list);
        seatMapData.setMovieSessionPosition(i3);
        seatMapData.setMovieOfferData(cJRMovieWidget);
        SeatSelectionActivity.a((Context) getActivity(), seatMapData);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.root_filter) {
            h hVar = h.f75928a;
            this.r = h.a(this.f75279d.f75135f, this.f75279d.m);
            if (this.f75279d.m == null || this.f75279d.m.getSearchFilters() == null) {
                Toast.makeText(this.f75280e, R.string.filters_not_available, 0).show();
                return;
            }
            this.f75279d.m.setFilterList(this.r);
            String str = this.f75279d.f75135f;
            Intent intent = new Intent(getActivity(), AJRMoviesShowListFilterActivity.class);
            intent.putExtra("filter_data", this.f75279d.m.getFilteredData());
            intent.putExtra("filter_list", this.f75279d.m.getSearchFilters());
            intent.putExtra("selected_date", str);
            startActivityForResult(intent, 3);
        }
    }

    public void onDestroy() {
        AsyncTask<Void, Void, net.one97.paytm.o2o.movies.common.movies.a> asyncTask = this.B;
        if (asyncTask != null) {
            asyncTask.cancel(false);
        }
        super.onDestroy();
    }

    public void onApiSuccess(final IJRPaytmDataModel iJRPaytmDataModel) {
        com.paytm.utility.b.j();
        if (getActivity() != null && !isDetached() && isAdded()) {
            AsyncTask<Void, Void, net.one97.paytm.o2o.movies.common.movies.a> asyncTask = this.B;
            if (asyncTask != null) {
                asyncTask.cancel(false);
            }
            this.B = new AsyncTask<Void, Void, net.one97.paytm.o2o.movies.common.movies.a>() {
                /* access modifiers changed from: protected */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    net.one97.paytm.o2o.movies.common.movies.a aVar = (net.one97.paytm.o2o.movies.common.movies.a) obj;
                    super.onPostExecute(aVar);
                    if (d.this.getActivity() != null && !d.this.isDetached() && d.this.isAdded()) {
                        net.one97.paytm.o2o.movies.common.movies.a unused = d.this.f75279d = aVar;
                        d dVar = d.this;
                        HashMap unused2 = dVar.A = dVar.f75279d.f75131b;
                        if (d.this.f75279d.n) {
                            if (!d.this.v || !d.this.f75276a) {
                                d dVar2 = d.this;
                                Map unused3 = dVar2.t = dVar2.f75279d.f75130a;
                            } else {
                                CJRMovieShowTimeFilterDataStorage filteredData = d.this.f75279d.m.getFilteredData();
                                d dVar3 = d.this;
                                h hVar = h.f75928a;
                                Map unused4 = dVar3.t = h.a(filteredData, (Map<String, Map<String, List<CJRMoviesSession>>>) d.this.f75279d.f75130a);
                            }
                            if (d.this.f75279d.f75133d.equalsIgnoreCase("movie")) {
                                if (!(TextUtils.isEmpty(d.this.f75279d.f75136g) || d.this.f75279d.f75137h == null || d.this.f75279d.k == null)) {
                                    d dVar4 = d.this;
                                    d.a(dVar4, dVar4.f75279d.k, d.this.f75279d.f75137h);
                                    d.this.f75279d.f75135f = d.this.y;
                                    d.this.f75279d.f75136g = null;
                                }
                                if (!d.this.f75281h) {
                                    d.this.o.b(d.this.m);
                                }
                                if (!d.this.v) {
                                    b unused5 = d.this.o;
                                    net.one97.paytm.o2o.movies.common.movies.a unused6 = d.this.f75279d;
                                    d dVar5 = d.this;
                                    new a(dVar5.f75279d.f75134e, d.this.f75279d.f75135f);
                                }
                            } else if (!d.this.v) {
                                b j = d.this.o;
                                CJRCinemaV2 cJRCinemaV2 = d.this.f75279d.l;
                                d dVar6 = d.this;
                                j.a(cJRCinemaV2, new a(dVar6.f75279d.f75134e, d.this.f75279d.f75135f));
                            }
                        } else {
                            d.this.o.a(d.this.getResources().getString(R.string.no_movies_found_at_loc));
                        }
                        d dVar7 = d.this;
                        d.a(dVar7, dVar7.f75279d.k, d.this.f75279d.l);
                        d dVar8 = d.this;
                        d.a(dVar8, dVar8.f75279d.k);
                        d.this.w.setVisibility(8);
                        d.this.o.b();
                        d dVar9 = d.this;
                        dVar9.a(dVar9.f75279d);
                    }
                }

                /* JADX WARNING: type inference failed for: r0v8, types: [java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRAmenity>] */
                /* access modifiers changed from: protected */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ java.lang.Object doInBackground(java.lang.Object[] r9) {
                    /*
                        r8 = this;
                        net.one97.paytm.o2o.movies.fragment.d r9 = net.one97.paytm.o2o.movies.fragment.d.this
                        net.one97.paytm.o2o.movies.common.movies.a r9 = r9.f75279d
                        if (r9 != 0) goto L_0x002b
                        net.one97.paytm.o2o.movies.fragment.d r9 = net.one97.paytm.o2o.movies.fragment.d.this
                        net.one97.paytm.o2o.movies.common.movies.a r7 = new net.one97.paytm.o2o.movies.common.movies.a
                        r1 = 0
                        java.util.HashMap r2 = r9.A
                        net.one97.paytm.o2o.movies.fragment.d r0 = net.one97.paytm.o2o.movies.fragment.d.this
                        java.lang.String r3 = r0.f75278c
                        net.one97.paytm.o2o.movies.fragment.d r0 = net.one97.paytm.o2o.movies.fragment.d.this
                        java.lang.String r4 = r0.f75277b
                        r5 = 0
                        net.one97.paytm.o2o.movies.fragment.d r0 = net.one97.paytm.o2o.movies.fragment.d.this
                        java.lang.String r6 = r0.q
                        r0 = r7
                        r0.<init>(r1, r2, r3, r4, r5, r6)
                        net.one97.paytm.o2o.movies.common.movies.a unused = r9.f75279d = r7
                    L_0x002b:
                        net.one97.paytm.o2o.movies.utils.h r9 = net.one97.paytm.o2o.movies.utils.h.f75928a
                        net.one97.paytm.o2o.movies.utils.d r9 = net.one97.paytm.o2o.movies.utils.d.f75921a
                        com.paytm.network.model.IJRPaytmDataModel r9 = r3
                        r0 = 0
                        if (r9 == 0) goto L_0x00be
                        boolean r1 = r9 instanceof net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse
                        if (r1 == 0) goto L_0x00be
                        net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse r9 = (net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse) r9
                        net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
                        if (r1 == 0) goto L_0x0043
                        java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r1 = r1.f75161a
                        goto L_0x0044
                    L_0x0043:
                        r1 = r0
                    L_0x0044:
                        java.lang.String r2 = "CJRMovieSearchResponseHo…erSingleton.getInstance()"
                        if (r1 != 0) goto L_0x0071
                        net.one97.paytm.o2o.movies.utils.i r1 = net.one97.paytm.o2o.movies.utils.i.a()
                        kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                        com.paytm.utility.b.j()
                        java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r1 = r1.f75932b
                        if (r1 == 0) goto L_0x0071
                        net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
                        if (r1 == 0) goto L_0x0071
                        java.util.ArrayList r3 = new java.util.ArrayList
                        net.one97.paytm.o2o.movies.utils.i r4 = net.one97.paytm.o2o.movies.utils.i.a()
                        kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
                        com.paytm.utility.b.j()
                        java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem> r4 = r4.f75932b
                        java.util.Collection r4 = (java.util.Collection) r4
                        r3.<init>(r4)
                        r1.f75161a = r3
                    L_0x0071:
                        net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
                        if (r1 == 0) goto L_0x007a
                        net.one97.paytm.o2o.movies.entity.CJRCinemas r1 = r1.f75162b
                        goto L_0x007b
                    L_0x007a:
                        r1 = r0
                    L_0x007b:
                        if (r1 != 0) goto L_0x008e
                        net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
                        if (r1 == 0) goto L_0x008e
                        net.one97.paytm.o2o.movies.utils.i r3 = net.one97.paytm.o2o.movies.utils.i.a()
                        kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
                        net.one97.paytm.o2o.movies.entity.CJRCinemas r2 = r3.f75936f
                        r1.f75162b = r2
                    L_0x008e:
                        net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r1 = r9.getMeta()
                        if (r1 == 0) goto L_0x0096
                        java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRAmenity> r0 = r1.f75163c
                    L_0x0096:
                        if (r0 != 0) goto L_0x00b0
                        net.one97.paytm.o2o.movies.utils.i r0 = net.one97.paytm.o2o.movies.utils.i.a()
                        java.util.List<net.one97.paytm.o2o.movies.entity.CJRAmenity> r0 = r0.f75935e
                        if (r0 == 0) goto L_0x00b0
                        net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaMeta r0 = r9.getMeta()
                        if (r0 == 0) goto L_0x00b0
                        net.one97.paytm.o2o.movies.utils.i r1 = net.one97.paytm.o2o.movies.utils.i.a()
                        java.util.List<net.one97.paytm.o2o.movies.entity.CJRAmenity> r1 = r1.f75935e
                        java.util.ArrayList r1 = (java.util.ArrayList) r1
                        r0.f75163c = r1
                    L_0x00b0:
                        net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r0 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2
                        r0.<init>()
                        java.util.LinkedHashMap r9 = net.one97.paytm.o2o.movies.utils.d.a((net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaDataResponse) r9, (net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2) r0)
                        r0.setMovies(r9)
                        com.paytm.network.model.IJRPaytmDataModel r0 = (com.paytm.network.model.IJRPaytmDataModel) r0
                    L_0x00be:
                        net.one97.paytm.o2o.movies.fragment.d r9 = net.one97.paytm.o2o.movies.fragment.d.this
                        net.one97.paytm.o2o.movies.common.movies.a r9 = r9.f75279d
                        net.one97.paytm.o2o.movies.common.movies.a r9 = net.one97.paytm.o2o.movies.utils.h.a((com.paytm.network.model.IJRPaytmDataModel) r0, (net.one97.paytm.o2o.movies.common.movies.a) r9)
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.d.AnonymousClass2.doInBackground(java.lang.Object[]):java.lang.Object");
                }
            };
            this.B.execute(new Void[0]);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (isVisible()) {
            if (this.x != null) {
                this.x.put(Uri.parse(networkCustomError.getFullUrl()).getQueryParameter("fromDate"), f75275g);
            }
            this.w.setVisibility(8);
            this.o.b();
            if (networkCustomError != null) {
                String message = networkCustomError.getMessage();
                if (message != null && message.equalsIgnoreCase("503")) {
                    String string = getResources().getString(R.string.movie_maintenance_error_title);
                    String string2 = getResources().getString(R.string.movie_maintenance_error_description);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f75280e);
                    builder.setTitle(string).setMessage(string2).setCancelable(false);
                    builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            d.this.a(dialogInterface, i2);
                        }
                    });
                    builder.show();
                } else if (!TextUtils.isEmpty(this.q)) {
                    getActivity().finish();
                } else {
                    this.o.a(getResources().getString(R.string.no_movies_found_at_loc));
                    String str = this.f75277b;
                    if (str == null) {
                        return;
                    }
                    if (str.equalsIgnoreCase("movie")) {
                        this.o.a(getResources().getString(R.string.no_movies_found_at_loc));
                    } else {
                        this.o.a(getResources().getString(R.string.no_cinema_found_at_loc));
                    }
                }
            }
        }
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public List<CJRMovieDetailsTab> f75286a;

        /* renamed from: b  reason: collision with root package name */
        public String f75287b;

        public a(List<CJRMovieDetailsTab> list, String str) {
            this.f75286a = list;
            this.f75287b = str;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3) {
            int intExtra = intent.getIntExtra("action_code", 2);
            if (intExtra == 0) {
                this.f75279d.m.setFilteredData((CJRMovieShowTimeFilterDataStorage) null);
                this.f75276a = false;
                this.t = this.f75279d.f75130a;
                a(this.f75279d);
                b();
            } else if (intExtra == 1) {
                CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage = (CJRMovieShowTimeFilterDataStorage) intent.getParcelableExtra("filter_data");
                this.f75279d.m.setFilteredData(cJRMovieShowTimeFilterDataStorage);
                this.f75276a = true;
                h hVar = h.f75928a;
                this.t = h.a(cJRMovieShowTimeFilterDataStorage, (Map<String, Map<String, List<CJRMoviesSession>>>) this.f75279d.f75130a);
                a(this.f75279d);
                b();
            } else if (intExtra == 2) {
            }
        }
    }

    private void c() {
        try {
            if (com.paytm.utility.b.T(this.f75280e)) {
                this.u.setVisibility(8);
            } else {
                this.u.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    public void onDetach() {
        super.onDetach();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.o2o.movies.common.movies.a aVar, View view) {
        aVar.m.setFilteredData((CJRMovieShowTimeFilterDataStorage) null);
        this.f75276a = false;
        this.t = aVar.f75130a;
        b();
        a(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        try {
            this.u.setVisibility(8);
            com.paytm.utility.b.S(this.f75280e);
        } catch (Exception unused) {
            q.d("disable text movie detail activity");
        }
    }

    static /* synthetic */ void a(d dVar, CJRMovieCinemaV2 cJRMovieCinemaV2, CJRMoviesSession cJRMoviesSession) {
        CJRMoviesSession cJRMoviesSession2 = cJRMoviesSession;
        List arrayList = new ArrayList();
        if (!(cJRMovieCinemaV2 == null || cJRMoviesSession2 == null)) {
            h hVar = h.f75928a;
            arrayList = h.a(cJRMovieCinemaV2, cJRMoviesSession);
        }
        List list = arrayList;
        Collections.sort(list, new CJRMoviesSession.a());
        String language = cJRMovieCinemaV2.getLanguage();
        h hVar2 = h.f75928a;
        dVar.b(cJRMoviesSession, language, h.a(cJRMovieCinemaV2), cJRMovieCinemaV2.getCensor(), cJRMovieCinemaV2.getImageUrl(), cJRMovieCinemaV2.getFinalDisplayName(), cJRMovieCinemaV2.getLocalizedFinalDisplayName(), n.b(cJRMoviesSession.getSeatsAvailable(), cJRMoviesSession.getTotalSeats()), n.c(cJRMoviesSession.getRealShowDateTime()), cJRMovieCinemaV2.getDuration().intValue(), cJRMoviesSession.getMovieCode(), list, list.indexOf(cJRMoviesSession2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0126 A[Catch:{ Exception -> 0x013c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.o2o.movies.fragment.d r7, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r8, net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2 r9) {
        /*
            java.lang.String r0 = "movies"
            if (r8 != 0) goto L_0x0005
            return
        L_0x0005:
            net.one97.paytm.o2o.movies.common.c.b r1 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x013c }
            net.one97.paytm.o2o.movies.common.c.c r1 = r1.f75033b     // Catch:{ Exception -> 0x013c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            java.lang.String r3 = "/movies/"
            r2.<init>(r3)     // Catch:{ Exception -> 0x013c }
            java.lang.String r3 = r8.getFinalDisplayName()     // Catch:{ Exception -> 0x013c }
            r2.append(r3)     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x013c }
            android.content.Context r3 = r7.f75280e     // Catch:{ Exception -> 0x013c }
            r1.sendOpenScreenWithDeviceInfo(r2, r0, r3)     // Catch:{ Exception -> 0x013c }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x013c }
            r1.<init>()     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = ""
            java.lang.String r3 = r7.f75277b     // Catch:{ Exception -> 0x013c }
            java.lang.String r4 = "screenName"
            java.lang.String r5 = "|"
            if (r3 == 0) goto L_0x008e
            java.lang.String r3 = r7.f75277b     // Catch:{ Exception -> 0x013c }
            java.lang.String r6 = "movie"
            boolean r3 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x013c }
            if (r3 == 0) goto L_0x008e
            net.one97.paytm.o2o.movies.common.c.b r2 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x013c }
            net.one97.paytm.o2o.movies.common.c.c r2 = r2.f75033b     // Catch:{ Exception -> 0x013c }
            java.lang.String r3 = "/movies/showtime-listing"
            android.content.Context r6 = r7.f75280e     // Catch:{ Exception -> 0x013c }
            r2.sendOpenScreenWithDeviceInfo(r3, r0, r6)     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.T     // Catch:{ Exception -> 0x013c }
            r1.put(r4, r0)     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.v     // Catch:{ Exception -> 0x013c }
            r1.put(r0, r2)     // Catch:{ Exception -> 0x013c }
            int r0 = r8.isContentAvailable()     // Catch:{ Exception -> 0x013c }
            r2 = 1
            if (r0 != r2) goto L_0x005a
            java.lang.String r0 = "yes"
            goto L_0x005c
        L_0x005a:
            java.lang.String r0 = "No"
        L_0x005c:
            r2 = r0
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x013c }
            if (r0 != 0) goto L_0x00cb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r0.<init>()     // Catch:{ Exception -> 0x013c }
            r0.append(r2)     // Catch:{ Exception -> 0x013c }
            r0.append(r5)     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x013c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r2.<init>()     // Catch:{ Exception -> 0x013c }
            r2.append(r0)     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = r8.getFinalDisplayName()     // Catch:{ Exception -> 0x013c }
            r2.append(r8)     // Catch:{ Exception -> 0x013c }
            r2.append(r5)     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = r7.f75278c     // Catch:{ Exception -> 0x013c }
            r2.append(r8)     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x013c }
            goto L_0x00cb
        L_0x008e:
            java.lang.String r3 = r7.f75277b     // Catch:{ Exception -> 0x013c }
            if (r3 == 0) goto L_0x00cb
            java.lang.String r3 = r7.f75277b     // Catch:{ Exception -> 0x013c }
            java.lang.String r6 = "cinema"
            boolean r3 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x013c }
            if (r3 == 0) goto L_0x00cb
            net.one97.paytm.o2o.movies.common.c.b r2 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x013c }
            net.one97.paytm.o2o.movies.common.c.c r2 = r2.f75033b     // Catch:{ Exception -> 0x013c }
            java.lang.String r3 = "/movies/cinema-showtime"
            android.content.Context r6 = r7.f75280e     // Catch:{ Exception -> 0x013c }
            r2.sendOpenScreenWithDeviceInfo(r3, r0, r6)     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.S     // Catch:{ Exception -> 0x013c }
            r1.put(r4, r0)     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.z     // Catch:{ Exception -> 0x013c }
            r1.put(r0, r2)     // Catch:{ Exception -> 0x013c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r0.<init>()     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = r8.getFinalDisplayName()     // Catch:{ Exception -> 0x013c }
            r0.append(r8)     // Catch:{ Exception -> 0x013c }
            r0.append(r5)     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = r7.f75278c     // Catch:{ Exception -> 0x013c }
            r0.append(r8)     // Catch:{ Exception -> 0x013c }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x013c }
        L_0x00cb:
            android.content.Context r8 = r7.getContext()     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.d.b((android.content.Context) r8)     // Catch:{ Exception -> 0x013c }
            if (r8 == 0) goto L_0x00e0
            boolean r0 = r8.isEmpty()     // Catch:{ Exception -> 0x013c }
            if (r0 != 0) goto L_0x00e0
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x013c }
            r1.put(r0, r8)     // Catch:{ Exception -> 0x013c }
        L_0x00e0:
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.k     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = r9.getName()     // Catch:{ Exception -> 0x013c }
            r1.put(r8, r0)     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.l     // Catch:{ Exception -> 0x013c }
            java.lang.String r0 = r9.getId()     // Catch:{ Exception -> 0x013c }
            r1.put(r8, r0)     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = r9.getpKey()     // Catch:{ Exception -> 0x013c }
            if (r8 == 0) goto L_0x010b
            java.lang.String r8 = r9.getpKey()     // Catch:{ Exception -> 0x013c }
            boolean r8 = r8.isEmpty()     // Catch:{ Exception -> 0x013c }
            if (r8 != 0) goto L_0x010b
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.m     // Catch:{ Exception -> 0x013c }
            java.lang.String r9 = r9.getpKey()     // Catch:{ Exception -> 0x013c }
            r1.put(r8, r9)     // Catch:{ Exception -> 0x013c }
        L_0x010b:
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x013c }
            java.lang.String r9 = "Screen Loaded"
            r1.put(r8, r9)     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x013c }
            r1.put(r8, r2)     // Catch:{ Exception -> 0x013c }
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x013c }
            java.lang.String r9 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x013c }
            r1.put(r8, r9)     // Catch:{ Exception -> 0x013c }
            android.content.Context r8 = r7.f75280e     // Catch:{ Exception -> 0x013c }
            boolean r8 = com.paytm.utility.b.r((android.content.Context) r8)     // Catch:{ Exception -> 0x013c }
            if (r8 == 0) goto L_0x0131
            java.lang.String r8 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x013c }
            android.content.Context r9 = r7.f75280e     // Catch:{ Exception -> 0x013c }
            java.lang.String r9 = com.paytm.utility.b.n((android.content.Context) r9)     // Catch:{ Exception -> 0x013c }
            r1.put(r8, r9)     // Catch:{ Exception -> 0x013c }
        L_0x0131:
            net.one97.paytm.o2o.movies.common.c.b r8 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x013c }
            net.one97.paytm.o2o.movies.common.c.c r8 = r8.f75033b     // Catch:{ Exception -> 0x013c }
            java.lang.String r9 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x013c }
            android.content.Context r7 = r7.f75280e     // Catch:{ Exception -> 0x013c }
            r8.sendCustomEventWithMap(r9, r1, r7)     // Catch:{ Exception -> 0x013c }
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.d.a(net.one97.paytm.o2o.movies.fragment.d, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2, net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2):void");
    }

    static /* synthetic */ void a(d dVar, CJRMovieCinemaV2 cJRMovieCinemaV2) {
        try {
            HashMap hashMap = new HashMap();
            if (cJRMovieCinemaV2 != null) {
                hashMap.put("movie_name", cJRMovieCinemaV2.getFinalDisplayName());
            }
            hashMap.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())));
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap("paytm_view_movie_detail", hashMap, dVar.f75280e);
        } catch (Exception unused) {
        }
    }
}
