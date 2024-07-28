package net.one97.paytm.o2o.movies.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity;
import net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity;
import net.one97.paytm.o2o.movies.activity.AJRMoviesShowListFilterActivity;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity;
import net.one97.paytm.o2o.movies.adapter.ah;
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
import net.one97.paytm.o2o.movies.utils.b;
import net.one97.paytm.o2o.movies.utils.h;
import net.one97.paytm.o2o.movies.utils.n;

public class i extends b implements View.OnClickListener, ah.a, b.a {
    private static final Integer t = 1;
    /* access modifiers changed from: private */
    public static final Integer u = 2;
    /* access modifiers changed from: private */
    public static final Integer v = 7;
    /* access modifiers changed from: private */
    public String A;
    private String B;
    private String C;
    /* access modifiers changed from: private */
    public d D;
    private List<CJRMovieShowTimeSearchFilterItem> E;
    /* access modifiers changed from: private */
    public Map<String, Map<String, List<CJRMoviesSession>>> F;
    /* access modifiers changed from: private */
    public HashMap<String, CJRMovieCinemaDetailV2> G;
    /* access modifiers changed from: private */
    public View H;
    /* access modifiers changed from: private */
    public View I;
    /* access modifiers changed from: private */
    public View J;
    private ConstraintLayout K;
    /* access modifiers changed from: private */
    public boolean L;
    /* access modifiers changed from: private */
    public ProgressBar M;
    /* access modifiers changed from: private */
    public HashMap<String, Integer> N;
    private String O;
    private RelativeLayout P;
    /* access modifiers changed from: private */
    public LinearLayoutManager Q;
    /* access modifiers changed from: private */
    public boolean R = false;
    private String S = "1";
    private String T = "1";
    /* access modifiers changed from: private */
    public Handler U;
    private Handler V = new Handler();
    /* access modifiers changed from: private */
    public Runnable W = new Runnable() {
        public final void run() {
            if (!i.this.R && !i.this.p && i.this.f75340d.getVisibility() == 0) {
                i.this.D.a(true, false);
            }
        }
    };
    private Runnable X = new Runnable() {
        public final void run() {
            if (i.this.j != null && i.this.m.get(i.this.j.f75135f) != null && i.this.m.get(i.this.j.f75135f).size() > 0) {
                i iVar = i.this;
                iVar.a(iVar.j.f75135f, (List<Integer>) i.this.m.get(i.this.j.f75135f), false);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    List<CJRMovieSessionDetails> f75337a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f75338b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75339c;

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f75340d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f75341e;

    /* renamed from: f  reason: collision with root package name */
    public String f75342f;

    /* renamed from: g  reason: collision with root package name */
    public String f75343g;

    /* renamed from: h  reason: collision with root package name */
    public String f75344h;

    /* renamed from: i  reason: collision with root package name */
    public ah f75345i;
    public net.one97.paytm.o2o.movies.common.movies.a j;
    public Context k;
    public EditText l;
    public HashMap<String, ArrayList<Integer>> m = new HashMap<>();
    boolean n = false;
    int o = 0;
    /* access modifiers changed from: private */
    public boolean p;
    private boolean q;
    private double r;
    private double s;
    /* access modifiers changed from: private */
    public boolean w;
    private boolean x;
    private TextView y;
    private NestedScrollView z;

    public interface d {
        void a();

        void a(String str);

        void a(CJRCinemaV2 cJRCinemaV2, b bVar);

        void a(CJRMovieCinemaV2 cJRMovieCinemaV2, b bVar);

        void a(boolean z);

        void a(boolean z, boolean z2);

        void b();

        void b(int i2);

        void b(String str);

        void b(boolean z);

        void c(boolean z);

        void e();

        void g();
    }

    public enum e {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public static i a(String str, String str2, String str3, String str4, String str5, boolean z2, boolean z3, String str6, String str7) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString("movie_ticket_city_selected", str);
        bundle.putString("movie_ticket_specific_city_selected", str2);
        bundle.putString("movie_ticket_selected_item_type", str3);
        bundle.putString("movie_ticket_selected_item_value", str4);
        bundle.putString("movie_ticket_selected_format_id", str7);
        bundle.putString("url_type", str5);
        bundle.putString("movie_ticket_booking_date", str6);
        bundle.putBoolean("movie_pass_present", z2);
        bundle.putBoolean("is_selected_movie_exists_in_selected_city", z3);
        iVar.setArguments(bundle);
        return iVar;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.D = (d) context;
        this.k = context;
    }

    public final boolean c() {
        return this.f75339c;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.movie_time_slot_fragment, viewGroup, false);
        Bundle arguments = getArguments();
        this.f75342f = arguments.getString("movie_ticket_city_selected");
        this.A = arguments.getString("movie_ticket_specific_city_selected");
        this.f75343g = arguments.getString("movie_ticket_selected_item_type");
        this.f75344h = arguments.getString("movie_ticket_selected_item_value");
        this.B = arguments.getString("movie_ticket_selected_format_id");
        this.C = arguments.getString("url_type");
        this.x = arguments.getBoolean("movie_pass_present");
        this.O = arguments.getString("movie_ticket_booking_date");
        this.w = arguments.getBoolean("is_selected_movie_exists_in_selected_city", true);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f75340d = (RecyclerView) view.findViewById(R.id.recycler_time_slot_movie);
        this.z = (NestedScrollView) view.findViewById(R.id.root_filter_no_result_found);
        this.y = (TextView) view.findViewById(R.id.btn_clear_filters);
        this.f75341e = (ProgressBar) view.findViewById(R.id.footerProgressBar);
        this.J = view.findViewById(R.id.long_press_hint);
        m();
        ((ImageView) view.findViewById(R.id.cancel_hint)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.a(view);
            }
        });
        this.M = (ProgressBar) view.findViewById(R.id.movie_detail_progress_bar);
        this.P = (RelativeLayout) view.findViewById(R.id.id_movie_time_slot_root);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.movie_detail_search, (ViewGroup) null);
        this.H = inflate.findViewById(R.id.root_filter);
        this.I = inflate.findViewById(R.id.filter_applied);
        this.K = (ConstraintLayout) inflate.findViewById(R.id.search_and_cinema_lin_layout);
        this.l = (EditText) inflate.findViewById(R.id.search);
        this.l.setOnFocusChangeListener(new c(this, (byte) 0));
        this.l.setFocusableInTouchMode(true);
        this.l.setFocusable(true);
        this.l.setOnKeyListener(new View.OnKeyListener() {
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                return i.this.a(view, i2, keyEvent);
            }
        });
        if ("cinema".equalsIgnoreCase(this.f75343g)) {
            this.l.setHint(R.string.search_movies);
        } else {
            this.l.setHint(R.string.search_cinema);
        }
        this.l.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                i.this.f75339c = true;
                if (!(charSequence == null || charSequence == " ")) {
                    charSequence = charSequence.toString().trim();
                }
                if (i.this.f75345i != null) {
                    i.this.f75345i.getFilter().filter(charSequence);
                }
            }
        });
        if (net.one97.paytm.o2o.movies.utils.i.a().f75937g == null || net.one97.paytm.o2o.movies.utils.i.a().f75937g.size() == 0 || net.one97.paytm.o2o.movies.utils.i.a().f75933c == null || net.one97.paytm.o2o.movies.utils.i.a().f75933c.size() == 0 || net.one97.paytm.o2o.movies.utils.i.a().f75935e == null || net.one97.paytm.o2o.movies.utils.i.a().f75935e.size() == 0) {
            this.S = "1";
        } else {
            this.S = "0";
        }
        if (net.one97.paytm.o2o.movies.utils.i.a().f75939i == null || net.one97.paytm.o2o.movies.utils.i.a().f75939i.size() == 0 || net.one97.paytm.o2o.movies.utils.i.a().j == null) {
            this.T = "1";
        } else {
            this.T = "0";
        }
        String str = this.O;
        if (str == null) {
            str = "0";
        }
        a(str, (List<Integer>) null, false);
    }

    public void onResume() {
        super.onResume();
        m();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67) {
            return false;
        }
        ((AJRMovieDetailsV2Activity) getActivity()).a(keyEvent);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ Exception -> 0x0262 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final java.lang.String r13, java.util.List<java.lang.Integer> r14, final boolean r15) {
        /*
            r12 = this;
            r0 = 1
            r12.R = r0     // Catch:{ Exception -> 0x0262 }
            java.lang.String r1 = r12.C     // Catch:{ Exception -> 0x0262 }
            java.lang.String r2 = "movieMoviesSearchV3"
            r3 = 0
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r12.C     // Catch:{ Exception -> 0x0262 }
            java.lang.String r4 = "freemovie"
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0262 }
            if (r1 == 0) goto L_0x002d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r1.<init>()     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.c.a(r2, r3)     // Catch:{ Exception -> 0x0262 }
            r1.append(r2)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r2 = "?filter=freemovie"
            r1.append(r2)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0262 }
            goto L_0x0034
        L_0x002d:
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.c.a(r2, r3)     // Catch:{ Exception -> 0x0262 }
        L_0x0034:
            r2 = 8
            if (r1 == 0) goto L_0x024a
            boolean r4 = r1.isEmpty()     // Catch:{ Exception -> 0x0262 }
            if (r4 == 0) goto L_0x0040
            goto L_0x024a
        L_0x0040:
            boolean r4 = android.webkit.URLUtil.isValidUrl(r1)     // Catch:{ Exception -> 0x0262 }
            if (r4 != 0) goto L_0x0047
            return
        L_0x0047:
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x0262 }
            android.net.Uri$Builder r1 = r1.buildUpon()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r4 = "city"
            java.lang.String r5 = r12.f75342f     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r4, r5)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r4 = r12.f75343g     // Catch:{ Exception -> 0x0262 }
            java.lang.String r5 = "movie"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0262 }
            if (r4 == 0) goto L_0x0076
            java.lang.String r4 = r12.B     // Catch:{ Exception -> 0x0262 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r5 = "movieCode"
            if (r4 == 0) goto L_0x0070
            java.lang.String r4 = r12.f75344h     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r5, r4)     // Catch:{ Exception -> 0x0262 }
            goto L_0x0087
        L_0x0070:
            java.lang.String r4 = r12.B     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r5, r4)     // Catch:{ Exception -> 0x0262 }
            goto L_0x0087
        L_0x0076:
            java.lang.String r4 = r12.f75343g     // Catch:{ Exception -> 0x0262 }
            java.lang.String r5 = "cinema"
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0262 }
            if (r4 == 0) goto L_0x0087
            java.lang.String r4 = "cinemacode"
            java.lang.String r5 = r12.f75344h     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r4, r5)     // Catch:{ Exception -> 0x0262 }
        L_0x0087:
            java.lang.String r4 = "0"
            if (r13 == 0) goto L_0x0096
            boolean r5 = r13.equals(r4)     // Catch:{ Exception -> 0x0262 }
            if (r5 != 0) goto L_0x0096
            java.lang.String r5 = "date"
            r1.appendQueryParameter(r5, r13)     // Catch:{ Exception -> 0x0262 }
        L_0x0096:
            java.lang.String r5 = "meta"
            java.lang.String r6 = r12.S     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r5, r6)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r5 = "reqData"
            java.lang.String r6 = r12.T     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r5, r6)     // Catch:{ Exception -> 0x0262 }
            if (r14 == 0) goto L_0x00af
            java.lang.String r5 = "cinemas"
            java.lang.String r14 = b((java.util.List<java.lang.Integer>) r14)     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r5, r14)     // Catch:{ Exception -> 0x0262 }
        L_0x00af:
            net.one97.paytm.o2o.movies.common.movies.a r14 = r12.j     // Catch:{ Exception -> 0x0262 }
            r5 = 0
            if (r14 == 0) goto L_0x0183
            net.one97.paytm.o2o.movies.common.movies.a r14 = r12.j     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r14 = r14.m     // Catch:{ Exception -> 0x0262 }
            if (r14 == 0) goto L_0x0183
            net.one97.paytm.o2o.movies.common.movies.a r14 = r12.j     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r14 = r14.m     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage r14 = r14.getFilteredData()     // Catch:{ Exception -> 0x0262 }
            if (r14 == 0) goto L_0x0183
            net.one97.paytm.o2o.movies.common.movies.a r14 = r12.j     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaDetailV2 r14 = r14.m     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieShowTimeFilterDataStorage r14 = r14.getFilteredData()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r6 = "premium"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r7.<init>()     // Catch:{ Exception -> 0x0262 }
            int r8 = r14.f75185g     // Catch:{ Exception -> 0x0262 }
            r7.append(r8)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r6, r7)     // Catch:{ Exception -> 0x0262 }
            long r6 = r14.f75182d     // Catch:{ Exception -> 0x0262 }
            r8 = 10
            r9 = 0
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0107
            long r6 = r14.f75182d     // Catch:{ Exception -> 0x0262 }
            java.lang.String r6 = net.one97.paytm.o2o.movies.utils.n.a((long) r6)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r7 = "maxSTime"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r11.<init>()     // Catch:{ Exception -> 0x0262 }
            r11.append(r13)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r6 = r6.substring(r8)     // Catch:{ Exception -> 0x0262 }
            r11.append(r6)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r6 = r11.toString()     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r7, r6)     // Catch:{ Exception -> 0x0262 }
        L_0x0107:
            long r6 = r14.f75181c     // Catch:{ Exception -> 0x0262 }
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x012b
            java.lang.String r6 = "minSTime"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r7.<init>()     // Catch:{ Exception -> 0x0262 }
            r7.append(r13)     // Catch:{ Exception -> 0x0262 }
            long r9 = r14.f75181c     // Catch:{ Exception -> 0x0262 }
            java.lang.String r9 = net.one97.paytm.o2o.movies.utils.n.a((long) r9)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r8 = r9.substring(r8)     // Catch:{ Exception -> 0x0262 }
            r7.append(r8)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r6, r7)     // Catch:{ Exception -> 0x0262 }
        L_0x012b:
            java.lang.String r6 = r14.f75180b     // Catch:{ Exception -> 0x0262 }
            if (r6 == 0) goto L_0x013e
            java.lang.String r6 = r14.f75180b     // Catch:{ Exception -> 0x0262 }
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0262 }
            if (r6 != 0) goto L_0x013e
            java.lang.String r6 = "maxPrice"
            java.lang.String r7 = r14.f75180b     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r6, r7)     // Catch:{ Exception -> 0x0262 }
        L_0x013e:
            java.lang.String r6 = r14.f75179a     // Catch:{ Exception -> 0x0262 }
            if (r6 == 0) goto L_0x0151
            java.lang.String r6 = r14.f75179a     // Catch:{ Exception -> 0x0262 }
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0262 }
            if (r6 != 0) goto L_0x0151
            java.lang.String r6 = "minPrice"
            java.lang.String r7 = r14.f75179a     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r6, r7)     // Catch:{ Exception -> 0x0262 }
        L_0x0151:
            java.util.ArrayList<java.lang.String> r6 = r14.f75183e     // Catch:{ Exception -> 0x0262 }
            if (r6 == 0) goto L_0x0183
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262 }
            r6.<init>()     // Catch:{ Exception -> 0x0262 }
            java.util.ArrayList<java.lang.String> r14 = r14.f75183e     // Catch:{ Exception -> 0x0262 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0262 }
            r7 = 0
        L_0x0161:
            boolean r8 = r14.hasNext()     // Catch:{ Exception -> 0x0262 }
            if (r8 == 0) goto L_0x017a
            java.lang.Object r8 = r14.next()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0262 }
            if (r7 == 0) goto L_0x0174
            java.lang.String r9 = ","
            r6.append(r9)     // Catch:{ Exception -> 0x0262 }
        L_0x0174:
            r6.append(r8)     // Catch:{ Exception -> 0x0262 }
            int r7 = r7 + 1
            goto L_0x0161
        L_0x017a:
            java.lang.String r14 = "scrnFmts"
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0262 }
            r1.appendQueryParameter(r14, r6)     // Catch:{ Exception -> 0x0262 }
        L_0x0183:
            boolean r14 = r12.q     // Catch:{ Exception -> 0x0262 }
            java.lang.String r6 = "sortByDistance"
            if (r14 == 0) goto L_0x018f
            java.lang.String r14 = "1"
            r1.appendQueryParameter(r6, r14)     // Catch:{ Exception -> 0x0262 }
            goto L_0x0192
        L_0x018f:
            r1.appendQueryParameter(r6, r4)     // Catch:{ Exception -> 0x0262 }
        L_0x0192:
            android.net.Uri r14 = r1.build()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0262 }
            android.content.Context r1 = r12.k     // Catch:{ Exception -> 0x0262 }
            java.lang.String r14 = com.paytm.utility.b.d((android.content.Context) r1, (java.lang.String) r14)     // Catch:{ Exception -> 0x0262 }
            if (r14 == 0) goto L_0x01ab
            java.lang.String r1 = "custId"
            java.lang.String r4 = "userId"
            java.lang.String r14 = r14.replace(r1, r4)     // Catch:{ Exception -> 0x0262 }
        L_0x01ab:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0262 }
            r1.<init>()     // Catch:{ Exception -> 0x0262 }
            java.lang.String r4 = "Content-Type"
            java.lang.String r6 = "application/json"
            r1.put(r4, r6)     // Catch:{ Exception -> 0x0262 }
            java.lang.String r4 = "ClientId"
            java.lang.String r6 = "paytm"
            r1.put(r4, r6)     // Catch:{ Exception -> 0x0262 }
            android.content.Context r4 = r12.k     // Catch:{ Exception -> 0x0262 }
            boolean r4 = com.paytm.utility.b.c((android.content.Context) r4)     // Catch:{ Exception -> 0x0262 }
            if (r4 == 0) goto L_0x022b
            net.one97.paytm.o2o.movies.common.movies.a r4 = r12.j     // Catch:{ Exception -> 0x0262 }
            if (r4 == 0) goto L_0x01d9
            r12.L = r0     // Catch:{ Exception -> 0x0262 }
            if (r15 != 0) goto L_0x01de
            android.widget.ProgressBar r4 = r12.M     // Catch:{ Exception -> 0x0262 }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x0262 }
            android.widget.ProgressBar r4 = r12.f75341e     // Catch:{ Exception -> 0x0262 }
            r4.setVisibility(r2)     // Catch:{ Exception -> 0x0262 }
            goto L_0x01de
        L_0x01d9:
            net.one97.paytm.o2o.movies.fragment.i$d r2 = r12.D     // Catch:{ Exception -> 0x0262 }
            r2.a()     // Catch:{ Exception -> 0x0262 }
        L_0x01de:
            net.one97.paytm.o2o.movies.fragment.i$d r2 = r12.D     // Catch:{ Exception -> 0x0262 }
            r2.a((boolean) r5, (boolean) r0)     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.fragment.i$d r2 = r12.D     // Catch:{ Exception -> 0x0262 }
            r2.c(r0)     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.utils.c r0 = new net.one97.paytm.o2o.movies.utils.c     // Catch:{ Exception -> 0x0262 }
            r0.<init>()     // Catch:{ Exception -> 0x0262 }
            android.content.Context r2 = r12.k     // Catch:{ Exception -> 0x0262 }
            r0.f42877a = r2     // Catch:{ Exception -> 0x0262 }
            com.paytm.network.a$c r2 = com.paytm.network.a.c.MOVIES     // Catch:{ Exception -> 0x0262 }
            r0.f42878b = r2     // Catch:{ Exception -> 0x0262 }
            com.paytm.network.a$a r2 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x0262 }
            r0.f42879c = r2     // Catch:{ Exception -> 0x0262 }
            r0.f42880d = r14     // Catch:{ Exception -> 0x0262 }
            r0.f42881e = r3     // Catch:{ Exception -> 0x0262 }
            r0.f42882f = r1     // Catch:{ Exception -> 0x0262 }
            r0.f42883g = r3     // Catch:{ Exception -> 0x0262 }
            r0.f42884h = r3     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse r14 = new net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDataResponse     // Catch:{ Exception -> 0x0262 }
            r14.<init>()     // Catch:{ Exception -> 0x0262 }
            r0.f42885i = r14     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.fragment.i$2 r14 = new net.one97.paytm.o2o.movies.fragment.i$2     // Catch:{ Exception -> 0x0262 }
            r14.<init>(r13, r15)     // Catch:{ Exception -> 0x0262 }
            r0.j = r14     // Catch:{ Exception -> 0x0262 }
            com.paytm.network.a$b r13 = com.paytm.network.a.b.USER_FACING     // Catch:{ Exception -> 0x0262 }
            r0.n = r13     // Catch:{ Exception -> 0x0262 }
            java.lang.String r13 = "movies"
            r0.o = r13     // Catch:{ Exception -> 0x0262 }
            java.lang.String r13 = "FJRMovieShowtimeFragment"
            org.json.JSONObject r13 = net.one97.paytm.o2o.movies.utils.n.h(r13)     // Catch:{ Exception -> 0x0262 }
            r0.t = r13     // Catch:{ Exception -> 0x0262 }
            com.paytm.network.a r13 = r0.l()     // Catch:{ Exception -> 0x0262 }
            r13.f42859c = r5     // Catch:{ Exception -> 0x0262 }
            r13.a()     // Catch:{ Exception -> 0x0262 }
            return
        L_0x022b:
            android.content.Context r13 = r12.k     // Catch:{ Exception -> 0x0262 }
            android.content.res.Resources r14 = r12.getResources()     // Catch:{ Exception -> 0x0262 }
            int r15 = net.one97.paytm.common.assets.R.string.no_connection     // Catch:{ Exception -> 0x0262 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x0262 }
            android.content.res.Resources r15 = r12.getResources()     // Catch:{ Exception -> 0x0262 }
            int r0 = net.one97.paytm.common.assets.R.string.no_internet     // Catch:{ Exception -> 0x0262 }
            java.lang.String r15 = r15.getString(r0)     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.fragment.-$$Lambda$i$HAJK4-IJ1UwdWCUVULR4Sk0AiOE r0 = new net.one97.paytm.o2o.movies.fragment.-$$Lambda$i$HAJK4-IJ1UwdWCUVULR4Sk0AiOE     // Catch:{ Exception -> 0x0262 }
            r0.<init>()     // Catch:{ Exception -> 0x0262 }
            com.paytm.utility.g.b(r13, r14, r15, r0)     // Catch:{ Exception -> 0x0262 }
            return
        L_0x024a:
            android.widget.ProgressBar r13 = r12.M     // Catch:{ Exception -> 0x0262 }
            r13.setVisibility(r2)     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.fragment.i$d r13 = r12.D     // Catch:{ Exception -> 0x0262 }
            r13.b()     // Catch:{ Exception -> 0x0262 }
            net.one97.paytm.o2o.movies.fragment.i$d r13 = r12.D     // Catch:{ Exception -> 0x0262 }
            android.content.res.Resources r14 = r12.getResources()     // Catch:{ Exception -> 0x0262 }
            int r15 = net.one97.paytm.o2o.movies.R.string.movie_error_message     // Catch:{ Exception -> 0x0262 }
            r14.getString(r15)     // Catch:{ Exception -> 0x0262 }
            r13.g()     // Catch:{ Exception -> 0x0262 }
        L_0x0262:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.i.a(java.lang.String, java.util.List, boolean):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public void a(final net.one97.paytm.o2o.movies.common.movies.a aVar) {
        if (!this.L) {
            this.y.setOnClickListener(new View.OnClickListener(aVar) {
                private final /* synthetic */ a f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    i.this.a(this.f$1, view);
                }
            });
            this.Q = new LinearLayoutManager(getActivity());
            this.f75340d.setLayoutManager(this.Q);
            this.f75340d.setHasFixedSize(true);
            this.f75340d.addOnScrollListener(new RecyclerView.l() {
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    int childCount = i.this.Q.getChildCount();
                    int itemCount = i.this.Q.getItemCount();
                    int findFirstVisibleItemPosition = i.this.Q.findFirstVisibleItemPosition();
                    if (!i.this.R) {
                        if (childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0 && itemCount > 5) {
                            i.this.a(aVar.f75135f, true);
                        }
                    } else if (childCount + findFirstVisibleItemPosition < itemCount || i.this.n) {
                        i.this.f75341e.setVisibility(4);
                    } else {
                        i.this.f75341e.setVisibility(0);
                    }
                }

                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    if (i.this.l.getText().toString().isEmpty()) {
                        i.this.f75339c = false;
                        if (Build.VERSION.SDK_INT >= 21 && a.f75362b == e.COLLAPSED && i.this.getActivity() != null && ((AJRMovieDetailsV2Activity) i.this.getActivity()).f74014i.getElevation() == 0.0f) {
                            ((AJRMovieDetailsV2Activity) i.this.getActivity()).a(n.a((int) H5Param.WEBVIEW_FONT_SIZE_LARGER, (Context) i.this.getActivity()));
                        }
                    }
                    super.onScrollStateChanged(recyclerView, i2);
                    if (i2 == 0) {
                        if (i.this.U != null) {
                            i.this.U.removeCallbacks(i.this.W);
                        }
                        Handler unused = i.this.U = new Handler();
                        i.this.U.postDelayed(i.this.W, 200);
                    } else if (i2 == 1) {
                        if (i.this.U != null) {
                            i.this.U.removeCallbacks(i.this.W);
                        }
                        if (!i.this.p) {
                            i.this.D.a(false, false);
                        }
                        n.b((View) recyclerView);
                        i iVar = i.this;
                        if (iVar.l != null) {
                            iVar.l.clearFocus();
                        }
                    }
                }
            });
            k();
            this.f75345i = new ah(this.k, this.f75343g, aVar.j, this, this.K);
            this.f75340d.setAdapter(this.f75345i);
            if (this.f75340d.getItemDecorationCount() == 0) {
                this.f75340d.addItemDecoration(new RecyclerView.h() {
                    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                        super.getItemOffsets(rect, view, recyclerView, sVar);
                        if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == i.this.f75345i.getItemCount() - 1) {
                            rect.bottom = n.a(50, i.this.k);
                        }
                    }
                });
            }
        }
        a(aVar.f75135f, false);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city_name", this.f75342f);
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
            instance.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(this.j.f75135f));
            String valueOf = String.valueOf(instance.get(5));
            String displayName = instance.getDisplayName(7, 0, Locale.getDefault());
            hashMap.put("day_date", displayName + " " + valueOf);
            net.one97.paytm.o2o.movies.b.a.INSTANCE.initMovieTheatreListingImpressionMap(hashMap);
        } catch (Exception unused) {
        }
    }

    private static String b(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer next : list) {
            if (sb.length() > 0) {
                sb.append(AppConstants.COMMA);
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public final void a(String str, boolean z2) {
        if (!z2 || this.f75337a == null) {
            c(str, z2);
        } else {
            b(str, z2);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, boolean z2) {
        int i2 = 0;
        if (this.f75337a == null) {
            if (this.N == null) {
                this.N = new HashMap<>();
            }
            Integer num = this.N.get(str);
            if (num == null) {
                a(str, (List<Integer>) null, false);
                this.N.put(str, t);
            } else if (num == t) {
                this.M.setVisibility(0);
            } else if (num == v) {
                this.z.setVisibility(0);
                this.f75345i.a((List<CJRMovieSessionDetails>) new ArrayList());
                l();
                this.f75340d.setVisibility(0);
                this.M.setVisibility(8);
                this.N.put(str, u);
                return;
            } else if (num.intValue() == 8) {
                this.f75345i.a((List<CJRMovieSessionDetails>) new ArrayList());
                l();
                this.f75340d.setVisibility(0);
                this.M.setVisibility(8);
                this.z.setVisibility(8);
            } else {
                a(str, (List<Integer>) null, false);
            }
            this.z.setVisibility(8);
            this.f75340d.setVisibility(8);
        } else if (z2) {
            CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2 = this.G.get(str);
            if (cJRMovieCinemaDetailV2 != null) {
                if (this.m.get(this.j.f75135f) != null) {
                    i2 = this.m.get(this.j.f75135f).size();
                }
                this.f75337a.size();
                if (cJRMovieCinemaDetailV2.cinemasOrder != null && this.f75337a.size() < cJRMovieCinemaDetailV2.cinemasOrder.size()) {
                    int size = cJRMovieCinemaDetailV2.cinemasOrder.size() - (this.f75337a.size() - i2);
                    if (size > cJRMovieCinemaDetailV2.pageSize) {
                        size = cJRMovieCinemaDetailV2.pageSize;
                    }
                    if (size > 0) {
                        int size2 = this.f75337a.size() - i2;
                        int size3 = (this.f75337a.size() - i2) + size;
                        if (!this.R && size2 > 0 && size3 <= cJRMovieCinemaDetailV2.cinemasOrder.size()) {
                            try {
                                a(str, cJRMovieCinemaDetailV2.cinemasOrder.subList(this.f75337a.size() - i2, (this.f75337a.size() - i2) + size), true);
                            } catch (Exception unused) {
                                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.crashlyticsLogs("Movies: Loading " + this.R + " range from " + size2 + " range to " + size3 + " cinema order size " + cJRMovieCinemaDetailV2.cinemasOrder.size());
                            }
                        }
                    }
                }
            }
        } else {
            this.M.setVisibility(8);
            c(this.f75337a);
            k();
            List<CJRMovieSessionDetails> list = this.f75337a;
            if (list != null && !list.isEmpty()) {
                if (this.q) {
                    double d2 = this.r;
                    if (d2 != 0.0d) {
                        double d3 = this.s;
                        if (d3 != 0.0d) {
                            b(d2, d3);
                            this.f75345i.a(this.f75337a);
                            l();
                            this.f75340d.setVisibility(0);
                            this.z.setVisibility(8);
                            this.D.c(false);
                        }
                    }
                }
                double d4 = this.r;
                if (d4 != 0.0d) {
                    double d5 = this.s;
                    if (d5 != 0.0d) {
                        c(d4, d5);
                        this.f75345i.a(this.f75337a);
                        l();
                        this.f75340d.setVisibility(0);
                        this.z.setVisibility(8);
                        this.D.c(false);
                    }
                }
                Location location = net.one97.paytm.o2o.movies.utils.i.a().f75931a;
                if (location != null) {
                    c(location.getLatitude(), location.getLongitude());
                }
                this.f75345i.a(this.f75337a);
                l();
                this.f75340d.setVisibility(0);
                this.z.setVisibility(8);
                this.D.c(false);
            } else if (this.f75338b) {
                this.z.setVisibility(0);
                List<CJRMovieSessionDetails> list2 = this.f75337a;
                if (list2 == null) {
                    this.f75345i.a((List<CJRMovieSessionDetails>) new ArrayList());
                } else {
                    this.f75345i.a(list2);
                }
                l();
                this.f75340d.setVisibility(0);
            }
        }
    }

    public final boolean g() {
        net.one97.paytm.o2o.movies.common.movies.a aVar = this.j;
        return (aVar == null || aVar.m == null || this.j.m.getSearchFilters() == null || this.j.m.getSearchFilters().get(this.j.f75135f) == null) ? false : true;
    }

    private void c(final String str, final boolean z2) {
        Map<String, Map<String, List<CJRMoviesSession>>> map = this.F;
        final Map map2 = map != null ? map.get(str) : null;
        if (getActivity() != null && !isDetached() && isAdded()) {
            if (map2 == null) {
                this.f75337a = null;
                b(str, z2);
                return;
            }
            new AsyncTask<Void, Void, List<CJRMovieSessionDetails>>() {
                /* access modifiers changed from: protected */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    List<CJRMovieSessionDetails> list = (List) obj;
                    super.onPostExecute(list);
                    i iVar = i.this;
                    iVar.f75337a = list;
                    iVar.b(str, z2);
                }

                /* access modifiers changed from: protected */
                public final void onPreExecute() {
                    super.onPreExecute();
                    if (z2) {
                        i.this.J.setVisibility(8);
                    }
                }

                /* access modifiers changed from: protected */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    CJRMovieCinemaDetailV2 cJRMovieCinemaDetailV2;
                    if ("movie".equals(i.this.f75343g)) {
                        List list = i.this.j.m.getOrderedCinemaList().get(str);
                        h hVar = h.f75928a;
                        return h.a((i.this.j.f75131b == null || i.this.j.f75131b.get(str) == null) ? i.this.j.m : i.this.j.f75131b.get(str), (Map<String, List<CJRMoviesSession>>) map2, (List<String>) list);
                    }
                    h hVar2 = h.f75928a;
                    if (i.this.j.f75131b == null || i.this.j.f75131b.get(str) == null) {
                        cJRMovieCinemaDetailV2 = i.this.j.m;
                    } else {
                        cJRMovieCinemaDetailV2 = i.this.j.f75131b.get(str);
                    }
                    return h.a(cJRMovieCinemaDetailV2.getMovies(), (Map<String, List<CJRMoviesSession>>) map2);
                }
            }.execute(new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        Intent intent = new Intent(this.k, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("mainActivity"));
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public final void a() {
        if (e.EXPANDED != a.f75362b) {
            h();
        }
    }

    public final void h() {
        this.f75340d.post(new Runnable() {
            public final void run() {
                i.this.n();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n() {
        EditText editText = this.l;
        if (editText != null && !editText.hasFocus() && this.l.getText().toString().isEmpty()) {
            this.Q.scrollToPositionWithOffset(1, 0);
        }
    }

    private void c(List<CJRMovieSessionDetails> list) {
        EditText editText = this.l;
        boolean z2 = editText != null && !TextUtils.isEmpty(editText.getText().toString());
        if ((list == null || list.size() <= 3) && !this.f75338b && !z2) {
            this.K.setVisibility(8);
        } else {
            this.K.setVisibility(0);
        }
    }

    public final void b(boolean z2, boolean z3) {
        if (z2) {
            this.H.setVisibility(0);
            this.H.setOnClickListener(this);
            if (z3) {
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(8);
            }
        } else {
            this.H.setVisibility(8);
            this.H.setOnClickListener((View.OnClickListener) null);
            this.I.setVisibility(8);
        }
    }

    private void k() {
        if (!"movie".equalsIgnoreCase(this.f75343g)) {
            return;
        }
        if (!this.j.f75138i) {
            b(false, false);
        } else if (this.f75338b) {
            b(true, true);
        } else {
            b(true, false);
        }
    }

    public final void a(String str) {
        Intent intent = new Intent(getActivity(), AJRCinemaDetailsActivity.class);
        intent.putExtra("movie_ticket_city_selected", this.f75342f);
        intent.putExtra("movie_ticket_selected_item_type", "cinema");
        intent.putExtra("movie_ticket_selected_item_value", str);
        if (getActivity() != null) {
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
        }
    }

    public final void b(String str) {
        Intent b2 = AJRUpcomingMoviesActivity.b(this.k, str, "show_list");
        if (b2 != null) {
            startActivity(b2);
            if (getActivity() != null) {
                getActivity().overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432579);
            } else {
                Toast.makeText(this.k, R.string.error_something_went_wrong, 0).show();
            }
        }
    }

    private void l() {
        ah ahVar = this.f75345i;
        if (ahVar != null) {
            ahVar.getFilter().filter(this.l.getText().toString());
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.root_filter) {
            h hVar = h.f75928a;
            this.E = h.a(this.j.f75135f, this.j.m);
            if (this.j.m == null || this.j.m.getSearchFilters() == null) {
                Toast.makeText(this.k, R.string.filters_not_available, 0).show();
                return;
            }
            this.j.m.setFilterList(this.E);
            String str = this.j.f75135f;
            Intent intent = new Intent(getActivity(), AJRMoviesShowListFilterActivity.class);
            if (this.j.m != null) {
                if (this.j.m.getFilteredData() != null) {
                    intent.putExtra("filter_data", this.j.m.getFilteredData());
                }
                intent.putExtra("filter_list", this.j.m.getSearchFilters());
                intent.putExtra("selected_date", str);
                startActivityForResult(intent, 3);
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        this.R = false;
        this.f75341e.setVisibility(4);
        this.J.setVisibility(0);
        if (isVisible()) {
            this.D.a(false, false);
            this.D.c(false);
            this.M.setVisibility(8);
            this.D.b();
            if (networkCustomError != null) {
                if (this.N != null && !TextUtils.isEmpty(networkCustomError.getFullUrl())) {
                    try {
                        this.N.put(Uri.parse(networkCustomError.getFullUrl()).getQueryParameter(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR), u);
                    } catch (Exception unused) {
                    }
                }
                String message = networkCustomError.getMessage();
                if (message != null && message.equalsIgnoreCase("503")) {
                    String string = getResources().getString(R.string.movie_maintenance_error_title);
                    String string2 = getResources().getString(R.string.movie_maintenance_error_description);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.k);
                    builder.setTitle(string).setMessage(string2).setCancelable(false);
                    builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            i.this.a(dialogInterface, i2);
                        }
                    });
                    builder.show();
                } else if (this.f75338b) {
                    this.z.setVisibility(0);
                    this.f75345i.a((List<CJRMovieSessionDetails>) new ArrayList());
                    l();
                    this.f75340d.setVisibility(0);
                }
            }
        }
    }

    public final void b(int i2) {
        this.P.setPadding(0, 0, 0, i2);
    }

    public final void a(List<CJRCinemaV2> list) {
        if (list == null || list.size() <= 0) {
            this.n = false;
            return;
        }
        this.n = true;
        ArrayList<Integer> arrayList = this.G.get(this.j.f75135f).cinemasOrder;
        if (arrayList != null) {
            for (CJRCinemaV2 next : list) {
                if (!(this.G.get(this.j.f75135f).cinemasOrder == null || !arrayList.contains(Integer.valueOf(next.getId())) || this.j.f75130a == null || this.j.f75130a.get(this.j.f75135f) == null || ((Map) this.j.f75130a.get(this.j.f75135f)).containsKey(next.getId()))) {
                    if (this.m.get(this.j.f75135f) == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(Integer.valueOf(next.getId()));
                        this.m.put(this.j.f75135f, arrayList2);
                    } else {
                        this.m.get(this.j.f75135f).add(Integer.valueOf(next.getId()));
                    }
                }
            }
            this.V.removeCallbacks(this.X);
            this.V.postDelayed(this.X, 150);
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public List<CJRMovieDetailsTab> f75363a;

        /* renamed from: b  reason: collision with root package name */
        public String f75364b;

        public b(List<CJRMovieDetailsTab> list, String str) {
            this.f75363a = list;
            this.f75364b = str;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        net.one97.paytm.o2o.movies.common.movies.a aVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3) {
            int intExtra = intent.getIntExtra("action_code", 2);
            if (intExtra == 0) {
                net.one97.paytm.o2o.movies.common.movies.a aVar2 = this.j;
                if (aVar2 != null && aVar2.m != null) {
                    this.j.m.setFilteredData((CJRMovieShowTimeFilterDataStorage) null);
                    this.f75338b = false;
                    HashMap<String, Integer> hashMap = this.N;
                    if (hashMap != null) {
                        hashMap.clear();
                    }
                    this.F.clear();
                    a(this.j);
                }
            } else if (intExtra == 1) {
                CJRMovieShowTimeFilterDataStorage cJRMovieShowTimeFilterDataStorage = (CJRMovieShowTimeFilterDataStorage) intent.getParcelableExtra("filter_data");
                if (cJRMovieShowTimeFilterDataStorage != null && (aVar = this.j) != null && aVar.m != null) {
                    this.j.m.setFilteredData(cJRMovieShowTimeFilterDataStorage);
                    this.f75338b = true;
                    HashMap<String, Integer> hashMap2 = this.N;
                    if (hashMap2 != null) {
                        hashMap2.clear();
                    }
                    this.F.clear();
                    a(this.j);
                }
            } else if (intExtra == 2) {
            }
        }
    }

    class c implements View.OnFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        InputMethodManager f75366a;

        private c() {
            this.f75366a = (InputMethodManager) i.this.getActivity().getSystemService("input_method");
        }

        /* synthetic */ c(i iVar, byte b2) {
            this();
        }

        public final void onFocusChange(View view, boolean z) {
            if (view.getId() != R.id.search) {
                return;
            }
            if (!z) {
                try {
                    i.this.D.a(false);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
            } else {
                i.this.D.a(true);
                i.this.f75340d.postDelayed(new Runnable() {
                    public final void run() {
                        i.this.D.e();
                    }
                }, 100);
                if (!i.this.f75339c) {
                    this.f75366a.showSoftInput(i.this.l, 1);
                }
                i.this.f75339c = true;
            }
        }
    }

    private void m() {
        try {
            if (com.paytm.utility.b.T(this.k)) {
                this.J.setVisibility(8);
            } else {
                this.J.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    public void onDestroyView() {
        Handler handler = this.U;
        if (handler != null) {
            handler.removeCallbacks(this.W);
        }
        this.V.removeCallbacks(this.X);
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
    }

    public final boolean d() {
        return this.z.getVisibility() == 0;
    }

    public final boolean e() {
        if (this.l.getText() == null || TextUtils.isEmpty(this.l.getText().toString().trim())) {
            return false;
        }
        ArrayList<Integer> arrayList = null;
        HashMap<String, CJRMovieCinemaDetailV2> hashMap = this.G;
        if (!(hashMap == null || hashMap.get(this.j.f75135f) == null)) {
            arrayList = this.G.get(this.j.f75135f).cinemasOrder;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        new net.one97.paytm.o2o.movies.utils.b(this.j.j, arrayList, this.f75337a, this).filter(this.l.getText().toString().trim());
        return false;
    }

    public final boolean f() {
        return this.n;
    }

    public final void a(boolean z2, boolean z3) {
        this.p = z3;
        this.D.a(z2, false);
    }

    public final void a(int i2) {
        this.D.b(i2);
    }

    public final boolean b() {
        return this.f75338b || this.f75339c;
    }

    private void b(double d2, double d3) {
        c(d2, d3);
        Collections.sort(this.f75337a, $$Lambda$i$wvmCWrptZihsKFaDZT50fOT2zKk.INSTANCE);
    }

    private void c(double d2, double d3) {
        if (this.f75337a != null) {
            for (int i2 = 0; i2 < this.f75337a.size(); i2++) {
                this.f75337a.get(i2).setDistanceKm((float) n.a(this.f75337a.get(i2).getmLatitude(), this.f75337a.get(i2).getmLogitude(), d2, d3));
            }
        }
    }

    public final void a(double d2, double d3) {
        if (this.q) {
            this.q = false;
            this.F.clear();
            a(this.j);
            this.D.b(false);
            return;
        }
        this.s = d3;
        this.r = d2;
        this.q = true;
        this.F.clear();
        a(this.j);
        this.D.b(true);
    }

    public static abstract class a implements AppBarLayout.b {

        /* renamed from: b  reason: collision with root package name */
        public static e f75362b = e.EXPANDED;

        public abstract void a(e eVar);

        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            if (i2 == 0) {
                if (f75362b != e.EXPANDED) {
                    a(e.EXPANDED);
                }
                f75362b = e.EXPANDED;
            } else if (Math.abs(i2) >= appBarLayout.getTotalScrollRange()) {
                if (f75362b != e.COLLAPSED) {
                    a(e.COLLAPSED);
                }
                f75362b = e.COLLAPSED;
            } else {
                if (f75362b != e.EXPANDED) {
                    a(e.EXPANDED);
                }
                f75362b = e.EXPANDED;
            }
        }
    }

    public void onPause() {
        super.onPause();
        net.one97.paytm.o2o.movies.b.a.INSTANCE.pushProductImpression(getContext(), false);
    }

    public final void a(int i2, CJRMoviesSession cJRMoviesSession, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, List<CJRMoviesSession> list, int i4) {
        String str10 = str5;
        CJRMovieWidget cJRMovieWidget = null;
        if (cJRMoviesSession != null) {
            try {
                cJRMovieWidget = n.a(cJRMoviesSession.getCinemaID(), (List<CJRCinemaV2>) this.j.j);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        SeatMapData seatMapData = new SeatMapData();
        seatMapData.setSelectedMovieSession(cJRMoviesSession);
        seatMapData.setSelectedCity(this.f75342f);
        seatMapData.setSelectedCategory(this.f75343g);
        String str11 = str;
        seatMapData.setMovieLanguage(str);
        seatMapData.setMovieLocalizedLanguage(str2);
        seatMapData.setTimeSlot(str8);
        seatMapData.setMovieCensor(str3);
        seatMapData.setMovieImageUrl(str4);
        seatMapData.setMovieTitle(str10);
        seatMapData.setMovieLocalizedTitle(str6);
        seatMapData.setMovieDuration(i3);
        seatMapData.setMovieCode(str9);
        seatMapData.setSeatStatus(str7);
        seatMapData.setMoviePassPresent(this.x);
        seatMapData.setSessionList(list);
        seatMapData.setMovieSessionPosition(i4);
        seatMapData.setMovieOfferData(cJRMovieWidget);
        SeatSelectionActivity.a((Context) getActivity(), seatMapData);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("city_name", this.f75342f);
            Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
            instance.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(this.j.f75135f));
            String valueOf = String.valueOf(instance.get(5));
            String displayName = instance.getDisplayName(7, 0, Locale.getDefault());
            hashMap.put("day_date", displayName + " " + valueOf);
            hashMap.put("theatre_name", cJRMoviesSession.getCinemaName());
            hashMap.put("show_time", n.c(cJRMoviesSession.getRealShowDateTime()));
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            hashMap4.put("list", "Theatre Listing");
            ArrayList arrayList = new ArrayList();
            HashMap hashMap5 = new HashMap();
            hashMap5.put("name", cJRMoviesSession.getCinemaName());
            hashMap5.put("id", cJRMoviesSession.getCinemaID());
            hashMap5.put("price", 0);
            hashMap5.put(CLPConstants.BRAND_PARAMS, this.f75342f);
            hashMap5.put("category", str10);
            hashMap5.put("variant", cJRMoviesSession.getScreenFormat());
            hashMap5.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2));
            arrayList.add(hashMap5);
            hashMap4.put("products", arrayList);
            hashMap3.put("actionField", hashMap4);
            hashMap2.put("click", hashMap3);
            hashMap.put("ecommerce", hashMap2);
            hashMap.put("vertical_name", "Entertainment - Movies");
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendEnhancedEcommerceEvent("productClick", hashMap, this.k);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.o2o.movies.common.movies.a aVar, View view) {
        aVar.m.setFilteredData((CJRMovieShowTimeFilterDataStorage) null);
        this.f75338b = false;
        HashMap<String, Integer> hashMap = this.N;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.F.clear();
        a(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        try {
            this.J.setVisibility(8);
            com.paytm.utility.b.S(this.k);
        } catch (Exception unused) {
            q.d("disable text movie detail activity");
        }
    }

    static /* synthetic */ void a(i iVar, final IJRPaytmDataModel iJRPaytmDataModel, final String str) {
        if (iVar.getActivity() != null && !iVar.isDetached() && iVar.isAdded()) {
            if (str != null && str.equals("0")) {
                str = null;
            }
            new AsyncTask<Void, Void, net.one97.paytm.o2o.movies.common.movies.a>() {
                /* access modifiers changed from: protected */
                public final /* synthetic */ Object doInBackground(Object[] objArr) {
                    return a();
                }

                /* access modifiers changed from: protected */
                public final /* synthetic */ void onPostExecute(Object obj) {
                    net.one97.paytm.o2o.movies.common.movies.a aVar = (net.one97.paytm.o2o.movies.common.movies.a) obj;
                    if (i.this.getActivity() != null && i.this.isAdded() && !i.this.isDetached()) {
                        if (aVar == null) {
                            i.this.a((NetworkCustomError) null);
                            return;
                        }
                        String str = str;
                        if (str == null) {
                            str = i.this.j.f75135f;
                        }
                        super.onPostExecute(aVar);
                        if (i.this.N != null) {
                            i.this.N.put(str, i.u);
                        }
                        net.one97.paytm.o2o.movies.common.movies.a unused = i.this.j = aVar;
                        i iVar = i.this;
                        HashMap unused2 = iVar.G = iVar.j.f75131b;
                        if (i.this.j.n) {
                            i iVar2 = i.this;
                            Map unused3 = iVar2.F = iVar2.j.f75130a;
                            if (i.this.N != null && (i.this.F == null || i.this.F.get(str) == null || ((Map) i.this.F.get(str)).size() == 0)) {
                                if (i.this.f75338b) {
                                    i.this.N.put(str, i.v);
                                } else {
                                    i.this.N.put(str, 8);
                                }
                            }
                            if (i.this.j.f75133d.equalsIgnoreCase("movie")) {
                                if (!i.this.w) {
                                    if (!TextUtils.isEmpty(i.this.A)) {
                                        i.this.D.b(i.this.A);
                                    } else {
                                        i.this.D.b(i.this.f75342f);
                                    }
                                }
                                if (i.this.j.f75138i) {
                                    i.this.H.setVisibility(0);
                                    if (i.this.f75338b) {
                                        i.this.I.setVisibility(0);
                                    } else {
                                        i.this.I.setVisibility(8);
                                    }
                                    i.this.H.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            i.this.onClick(view);
                                        }
                                    });
                                }
                                if (!i.this.L) {
                                    d a2 = i.this.D;
                                    CJRMovieCinemaV2 cJRMovieCinemaV2 = i.this.j.k;
                                    i iVar3 = i.this;
                                    a2.a(cJRMovieCinemaV2, new b(iVar3.j.f75134e, str));
                                }
                            } else if (!i.this.L) {
                                d a3 = i.this.D;
                                CJRCinemaV2 cJRCinemaV2 = i.this.j.l;
                                i iVar4 = i.this;
                                a3.a(cJRCinemaV2, new b(iVar4.j.f75134e, str));
                            }
                        } else {
                            i.this.D.a(i.this.getResources().getString(R.string.no_movies_found_at_loc));
                        }
                        i iVar5 = i.this;
                        CJRMovieCinemaV2 cJRMovieCinemaV22 = iVar5.j.k;
                        net.one97.paytm.o2o.movies.common.movies.a unused4 = i.this.j;
                        i.a(iVar5, cJRMovieCinemaV22);
                        i iVar6 = i.this;
                        i.b(iVar6, iVar6.j.k);
                        i.this.M.setVisibility(8);
                        if (i.this.getActivity() != null && ((AJRMovieDetailsV2Activity) i.this.getActivity()).j == 0) {
                            i.this.D.b();
                        }
                        i iVar7 = i.this;
                        iVar7.a(iVar7.j);
                        i.this.f75341e.setVisibility(4);
                        i.this.J.setVisibility(0);
                        boolean unused5 = i.this.R = false;
                    }
                }

                private net.one97.paytm.o2o.movies.common.movies.a a() {
                    if (i.this.j == null) {
                        i iVar = i.this;
                        net.one97.paytm.o2o.movies.common.movies.a unused = iVar.j = new net.one97.paytm.o2o.movies.common.movies.a(iVar.F, i.this.G, i.this.f75344h, i.this.f75343g, str, (String) null);
                    }
                    try {
                        h hVar = h.f75928a;
                        net.one97.paytm.o2o.movies.utils.e eVar = net.one97.paytm.o2o.movies.utils.e.f75922a;
                        return h.a(net.one97.paytm.o2o.movies.utils.e.a(iJRPaytmDataModel, str), i.this.j);
                    } catch (Exception unused2) {
                        return null;
                    }
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:2|3|4|(3:6|7|(12:9|(1:11)(1:12)|13|(1:15)|21|(1:25)|(2:27|28)|29|30|(1:32)|33|35))|16|(1:20)|21|23|25|(0)|29|30|(0)|33|35) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00e5 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cc A[SYNTHETIC, Splitter:B:27:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0100 A[Catch:{ Exception -> 0x0116 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.o2o.movies.fragment.i r6, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r7) {
        /*
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = "/movies/"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = r7.getFinalDisplayName()     // Catch:{ Exception -> 0x0116 }
            r0.append(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0116 }
            android.content.Context r1 = r6.k     // Catch:{ Exception -> 0x0116 }
            net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r0, (android.content.Context) r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.T     // Catch:{ Exception -> 0x0116 }
            android.content.Context r1 = r6.k     // Catch:{ Exception -> 0x0116 }
            net.one97.paytm.o2o.movies.utils.n.b((java.lang.String) r0, (android.content.Context) r1)     // Catch:{ Exception -> 0x0116 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0116 }
            r0.<init>()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = ""
            java.lang.String r2 = r6.f75343g     // Catch:{ Exception -> 0x0116 }
            java.lang.String r3 = "screenName"
            java.lang.String r4 = "|"
            if (r2 == 0) goto L_0x0085
            java.lang.String r2 = r6.f75343g     // Catch:{ Exception -> 0x0116 }
            java.lang.String r5 = "movie"
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0116 }
            if (r2 == 0) goto L_0x0085
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.T     // Catch:{ Exception -> 0x0116 }
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.v     // Catch:{ Exception -> 0x0116 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0116 }
            int r1 = r7.isContentAvailable()     // Catch:{ Exception -> 0x0116 }
            r2 = 1
            if (r1 != r2) goto L_0x0052
            java.lang.String r1 = "yes"
            goto L_0x0054
        L_0x0052:
            java.lang.String r1 = "No"
        L_0x0054:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0116 }
            if (r2 != 0) goto L_0x00b7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r2.<init>()     // Catch:{ Exception -> 0x0116 }
            r2.append(r1)     // Catch:{ Exception -> 0x0116 }
            r2.append(r4)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0116 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r2.<init>()     // Catch:{ Exception -> 0x0116 }
            r2.append(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = r7.getFinalDisplayName()     // Catch:{ Exception -> 0x0116 }
            r2.append(r1)     // Catch:{ Exception -> 0x0116 }
            r2.append(r4)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = r6.f75344h     // Catch:{ Exception -> 0x0116 }
            r2.append(r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0116 }
            goto L_0x00b7
        L_0x0085:
            java.lang.String r2 = r6.f75343g     // Catch:{ Exception -> 0x0116 }
            if (r2 == 0) goto L_0x00b7
            java.lang.String r2 = r6.f75343g     // Catch:{ Exception -> 0x0116 }
            java.lang.String r5 = "cinema"
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0116 }
            if (r2 == 0) goto L_0x00b7
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.S     // Catch:{ Exception -> 0x0116 }
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.z     // Catch:{ Exception -> 0x0116 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0116 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r1.<init>()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = r7.getFinalDisplayName()     // Catch:{ Exception -> 0x0116 }
            r1.append(r2)     // Catch:{ Exception -> 0x0116 }
            r1.append(r4)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = r6.f75344h     // Catch:{ Exception -> 0x0116 }
            r1.append(r2)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0116 }
        L_0x00b7:
            java.lang.String r2 = r6.f75342f     // Catch:{ Exception -> 0x0116 }
            if (r2 == 0) goto L_0x00ca
            java.lang.String r2 = r6.f75342f     // Catch:{ Exception -> 0x0116 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0116 }
            if (r2 != 0) goto L_0x00ca
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x0116 }
            java.lang.String r3 = r6.f75342f     // Catch:{ Exception -> 0x0116 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0116 }
        L_0x00ca:
            if (r7 == 0) goto L_0x00e5
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75014i     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r3 = r7.getFinalDisplayName()     // Catch:{ Exception -> 0x00e5 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.j     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r3 = r6.f75344h     // Catch:{ Exception -> 0x00e5 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.n     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r7 = r7.getLanguage()     // Catch:{ Exception -> 0x00e5 }
            r0.put(r2, r7)     // Catch:{ Exception -> 0x00e5 }
        L_0x00e5:
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x0116 }
            java.lang.String r2 = "Screen Loaded"
            r0.put(r7, r2)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x0116 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x0116 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x0116 }
            android.content.Context r7 = r6.k     // Catch:{ Exception -> 0x0116 }
            boolean r7 = com.paytm.utility.b.r((android.content.Context) r7)     // Catch:{ Exception -> 0x0116 }
            if (r7 == 0) goto L_0x010b
            java.lang.String r7 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x0116 }
            android.content.Context r1 = r6.k     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = com.paytm.utility.b.n((android.content.Context) r1)     // Catch:{ Exception -> 0x0116 }
            r0.put(r7, r1)     // Catch:{ Exception -> 0x0116 }
        L_0x010b:
            net.one97.paytm.o2o.movies.common.c.b r7 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0116 }
            net.one97.paytm.o2o.movies.common.c.c r7 = r7.f75033b     // Catch:{ Exception -> 0x0116 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x0116 }
            android.content.Context r6 = r6.k     // Catch:{ Exception -> 0x0116 }
            r7.sendCustomEventWithMap(r1, r0, r6)     // Catch:{ Exception -> 0x0116 }
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.fragment.i.a(net.one97.paytm.o2o.movies.fragment.i, net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2):void");
    }

    static /* synthetic */ void b(i iVar, CJRMovieCinemaV2 cJRMovieCinemaV2) {
        try {
            HashMap hashMap = new HashMap();
            if (cJRMovieCinemaV2 != null) {
                hashMap.put("movie_name", cJRMovieCinemaV2.getFinalDisplayName());
            }
            hashMap.put(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())));
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap("paytm_view_movie_detail", hashMap, iVar.k);
        } catch (Exception unused) {
        }
    }
}
