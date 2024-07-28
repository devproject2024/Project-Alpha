package net.one97.paytm.o2o.movies.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.common.widgets.CJRNonSwipableViewPager;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.a;
import net.one97.paytm.o2o.movies.adapter.at;
import net.one97.paytm.o2o.movies.adapter.c;
import net.one97.paytm.o2o.movies.common.CJRBackPressHandledEditText;
import net.one97.paytm.o2o.movies.common.customui.CustomTabLayout;
import net.one97.paytm.o2o.movies.common.customui.b;
import net.one97.paytm.o2o.movies.common.movies.search.CJRAmenity;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.d.b;
import net.one97.paytm.o2o.movies.fragment.d;
import net.one97.paytm.o2o.movies.utils.h;
import net.one97.paytm.o2o.movies.utils.i;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRCinemaDetailsActivity extends AppBaseActivity implements View.OnClickListener, AppBarLayout.b, CJRBackPressHandledEditText.a, b, d.b {
    private static final String k = AJRCinemaDetailsActivity.class.getSimpleName();
    private String A;
    private String B = null;
    private String C;
    private int D = 0;
    private boolean E = true;
    private boolean F = true;
    private ShimmerFrameLayout G;
    private boolean H = false;
    /* access modifiers changed from: private */
    public a I;
    /* access modifiers changed from: private */
    public RecyclerView J;
    private RecyclerView K;
    /* access modifiers changed from: private */
    public d L;
    private RoboTextView M;
    /* access modifiers changed from: private */
    public String N = "";
    private String O;
    private LinearLayout P;
    private RoboTextView Q;

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f73911a;

    /* renamed from: b  reason: collision with root package name */
    public CustomTabLayout f73912b;

    /* renamed from: c  reason: collision with root package name */
    public int f73913c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73914d = true;

    /* renamed from: e  reason: collision with root package name */
    RelativeLayout f73915e;

    /* renamed from: f  reason: collision with root package name */
    Drawable f73916f;

    /* renamed from: g  reason: collision with root package name */
    double f73917g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    double f73918h = 0.0d;

    /* renamed from: i  reason: collision with root package name */
    double f73919i = 0.0d;
    double j = 0.0d;
    private int l;
    private Toolbar m;
    /* access modifiers changed from: private */
    public CollapsingToolbarLayout n = null;
    private AppBarLayout o;
    private CJRNonSwipableViewPager p;
    private RelativeLayout q;
    private String r;
    private String s;
    /* access modifiers changed from: private */
    public String t;
    private String u;
    private RoboTextView v;
    private ImageView w;
    /* access modifiers changed from: private */
    public View x;
    private View y;
    private RoboTextView z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT <= 19) {
            setTheme(R.style.MovieDetailPageTheme);
        }
        setContentView(R.layout.activity_cinema_details);
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.dropBreadCrumb(k, "");
        try {
            this.m = (Toolbar) findViewById(R.id.movie_details_toolbar);
            setSupportActionBar(this.m);
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.b(true);
            supportActionBar.a((CharSequence) "");
        } catch (Exception unused) {
            q.c("setSupportActionBar issue");
        }
        this.P = (LinearLayout) findViewById(R.id.directionLl);
        this.Q = (RoboTextView) findViewById(R.id.directionDistanceTv);
        this.o = (AppBarLayout) findViewById(R.id.movie_details_appbar);
        this.o.a((AppBarLayout.b) this);
        this.n = (CollapsingToolbarLayout) findViewById(R.id.movie_details_collapse_toolbar);
        this.n.setScrimsShown(false, true);
        this.f73912b = (CustomTabLayout) findViewById(R.id.movie_details_tabs);
        this.f73912b.setTabGravity(0);
        this.f73912b.setSelectedTabIndicatorWidth(n.a(100, (Context) this));
        this.f73912b.setSelectedTabIndicatorColor(androidx.core.content.b.c(this, R.color.color_00b9f5));
        this.f73912b.setSelectedTabIndicatorHeight((int) (getResources().getDisplayMetrics().density * 2.0f));
        this.f73912b.setTabTextColors(androidx.core.content.b.c(this, R.color.color_535353), androidx.core.content.b.c(this, net.one97.paytm.common.assets.R.color.color_012b72));
        this.v = (RoboTextView) findViewById(R.id.movie_banner_subTitle);
        this.w = (ImageView) findViewById(R.id.youtube_play_icon);
        this.q = (RelativeLayout) findViewById(R.id.progress_bar_layout);
        this.p = (CJRNonSwipableViewPager) findViewById(R.id.movie_details_viewpager);
        this.p.setOffscreenPageLimit(1);
        this.f73915e = (RelativeLayout) findViewById(R.id.movie_details);
        this.f73911a = (RelativeLayout) findViewById(R.id.sub_layout);
        this.y = findViewById(R.id.lyt_no_movies);
        this.z = (RoboTextView) findViewById(R.id.txt_error_description);
        ((ImageView) this.y.findViewById(R.id.close_circle_btn)).setOnClickListener(this);
        findViewById(R.id.movie_detail_back_btn).setOnClickListener(this);
        this.M = (RoboTextView) findViewById(R.id.title);
        this.x = findViewById(R.id.movie_detail_tab_book);
        this.x.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRCinemaDetailsActivity.this.b(view);
            }
        });
        this.J = (RecyclerView) findViewById(R.id.date_tab_recycler_view);
        this.G = (ShimmerFrameLayout) findViewById(R.id.shimmer_movie_detail);
        ((ImageView) findViewById(R.id.close_circle_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRCinemaDetailsActivity.this.a(view);
            }
        });
        try {
            Intent intent = getIntent();
            if (intent != null) {
                this.E = intent.getBooleanExtra("movie_pass_present", true);
                if (intent.hasExtra("movie_ticket_city_selected")) {
                    this.r = intent.getStringExtra("movie_ticket_city_selected");
                }
                if (intent.hasExtra("movie_ticket_selected_item_type")) {
                    this.t = intent.getStringExtra("movie_ticket_selected_item_type");
                }
                if (intent.hasExtra("movie_ticket_selected_item_value")) {
                    this.s = intent.getStringExtra("movie_ticket_selected_item_value");
                }
                if (intent.hasExtra("url_type")) {
                    this.A = intent.getStringExtra("url_type");
                }
                if (intent.hasExtra("cinema_movie_code")) {
                    this.B = intent.getStringExtra("cinema_movie_code");
                }
                if (intent.hasExtra("intent_movie_session")) {
                    this.C = intent.getStringExtra("intent_movie_session");
                    this.O = intent.getStringExtra("movie_ticket_booking_date");
                }
                if (intent.hasExtra("is_selected_movie_exists_in_selected_city")) {
                    this.F = intent.getBooleanExtra("is_selected_movie_exists_in_selected_city", true);
                }
            }
        } catch (Exception unused2) {
        }
        this.f73916f = androidx.core.content.b.a((Context) this, net.one97.paytm.common.assets.R.drawable.ic_circular_back_arrow);
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(this.f73916f);
        }
        f();
        f();
        final ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R.string.movies_booking_tab));
        if (this.t.equalsIgnoreCase("movie")) {
            arrayList.add(getResources().getString(R.string.about_movie));
        }
        this.p.setAdapter(new c(getSupportFragmentManager(), arrayList, new net.one97.paytm.o2o.movies.adapter.b(this.r, this.t, this.s, this.A, this.C, this.O, this.E, this.F, this.B, this.u), new c.a() {
            public final void setFragment(Fragment fragment) {
                AJRCinemaDetailsActivity.this.a(fragment);
            }
        }));
        this.f73912b.setupWithViewPager(this.p, true);
        this.p.setPagingEnabled(false);
        this.p.addOnPageChangeListener(new ViewPager.e() {

            /* renamed from: c  reason: collision with root package name */
            private boolean f73922c = false;

            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
                if (i2 == 1) {
                    AJRCinemaDetailsActivity.this.x.setVisibility(0);
                } else {
                    AJRCinemaDetailsActivity.this.x.setVisibility(8);
                }
                float f3 = 1.0f - f2;
                AJRCinemaDetailsActivity.this.J.setAlpha(f3);
                if (((double) f3) <= 0.5d || i2 != 0) {
                    AJRCinemaDetailsActivity.this.J.setVisibility(8);
                } else {
                    AJRCinemaDetailsActivity.this.J.setVisibility(0);
                }
                if (AJRCinemaDetailsActivity.this.f73913c == 1) {
                    androidx.localbroadcastmanager.a.a.a((Context) AJRCinemaDetailsActivity.this).a(new Intent("callAboutMovieAPI"));
                }
            }

            public final void onPageSelected(int i2) {
                if (i2 != 0 || !((String) arrayList.get(i2)).equalsIgnoreCase(AJRCinemaDetailsActivity.this.getResources().getString(R.string.movies_booking_tab))) {
                    this.f73922c = AJRCinemaDetailsActivity.this.N.length() > 0;
                } else if (!v.a(AJRCinemaDetailsActivity.this.t) && AJRCinemaDetailsActivity.this.t.equalsIgnoreCase("movie") && AJRCinemaDetailsActivity.this.L != null && AJRCinemaDetailsActivity.this.L.isAdded()) {
                    AJRCinemaDetailsActivity.this.L.a();
                    d unused = AJRCinemaDetailsActivity.this.L;
                }
            }
        });
        this.K = (RecyclerView) findViewById(R.id.rvCinemaAmenities);
        this.K.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.K.setAdapter(new at());
        Location location = i.a().f75931a;
        if (location != null) {
            this.f73919i = location.getLatitude();
            this.j = location.getLongitude();
        }
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendOpenScreenWithDeviceInfo("/movies/cinema-showtime", "movies", this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        onBackPressed();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/" + this.u);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.u);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Book Tickets - Content");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            String b2 = net.one97.paytm.o2o.movies.common.d.b((Context) this);
            if (b2 != null && !b2.isEmpty()) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75013h, b2);
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75014i, this.u);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.j, this.B);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Fragment fragment) {
        if (fragment instanceof d) {
            this.L = (d) fragment;
        }
    }

    public void onBackPressed() {
        if (this.f73912b.getVisibility() == 8 && this.f73914d && !this.t.equalsIgnoreCase("cinema")) {
            e();
        } else if (this.D == 1) {
            this.p.setCurrentItem(0, true);
            this.f73912b.a(0).a();
        } else {
            super.onBackPressed();
            overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
        }
    }

    private void e() {
        try {
            if (this.f73913c != 1) {
                this.f73912b.setVisibility(8);
                this.f73914d = false;
            } else {
                this.f73912b.setVisibility(0);
            }
            n.b((View) this.m);
        } catch (Exception unused) {
            q.d("keyboard movie detail activity");
        }
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        "onOffsetChanged--------------   ".concat(String.valueOf(i2));
        com.paytm.utility.b.j();
        this.l = i2;
        int totalScrollRange = this.o.getTotalScrollRange();
        Math.abs(this.l);
        if (totalScrollRange == 0 || Math.abs(this.l) != totalScrollRange) {
            this.n.setStatusBarScrimColor(androidx.core.content.b.c(this, 17170445));
        } else {
            this.n.setStatusBarScrimColor(androidx.core.content.b.c(this, net.one97.paytm.common.assets.R.color.app_theme_color));
        }
        this.f73916f = androidx.core.content.b.a((Context) this, net.one97.paytm.common.widgets.R.drawable.back_arrow);
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(this.f73916f);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
            CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.setMargins(0, 15, 0, 0);
            this.m.setLayoutParams(layoutParams);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.movie_detail_back_btn) {
            onBackPressed();
        }
    }

    public final void a() {
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            try {
                this.G.a();
            } catch (Exception unused) {
            }
            this.H = true;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRCinemaDetailsActivity.this.h();
                }
            }, 1500);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.H = false;
    }

    public final void b() {
        if (this.q == null) {
            return;
        }
        if (this.H) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRCinemaDetailsActivity.this.g();
                }
            }, 1000);
            return;
        }
        try {
            this.G.b();
        } catch (Exception unused) {
        }
        this.q.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        try {
            this.G.b();
        } catch (Exception unused) {
        }
        this.q.setVisibility(8);
    }

    public final void c() {
        if (!isFinishing()) {
            String string = getResources().getString(R.string.movie_maintenance_error_title);
            String string2 = getResources().getString(R.string.movie_maintenance_error_description);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(string).setMessage(string2).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRCinemaDetailsActivity.this.a(dialogInterface, i2);
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        Intent intent = new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("mainActivity"));
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    public final void a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return;
        }
        if (this.f73912b.getVisibility() != 8 || !this.f73914d) {
            onBackPressed();
            return;
        }
        e();
        d dVar = this.L;
        if (dVar != null && !dVar.isAdded()) {
        }
    }

    private void a(final d.a aVar) {
        this.J.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.I = new a(aVar, new a.C1481a() {
            /* JADX WARNING: Can't wrap try/catch for region: R(19:3|4|(1:6)(2:7|(1:9)(1:10))|11|12|(3:14|15|(11:17|23|(1:27)|(2:29|30)|(3:33|34|(1:38))|39|40|(1:43)|44|(1:46)|47))|18|(1:22)|23|25|27|(0)|(0)|39|40|43|44|(0)|47) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x012d */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x00e5 A[SYNTHETIC, Splitter:B:29:0x00e5] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0102 A[SYNTHETIC, Splitter:B:33:0x0102] */
            /* JADX WARNING: Removed duplicated region for block: B:46:0x017d A[Catch:{ Exception -> 0x0193 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(int r10, net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab r11) {
                /*
                    r9 = this;
                    java.lang.String r0 = "|"
                    net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity r1 = net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.this
                    net.one97.paytm.o2o.movies.fragment.d r1 = r1.L
                    if (r1 == 0) goto L_0x0193
                    net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity r1 = net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.this
                    androidx.recyclerview.widget.RecyclerView r1 = r1.J
                    r1.scrollToPosition(r10)
                    net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity r10 = net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.this
                    net.one97.paytm.o2o.movies.fragment.d r10 = r10.L
                    net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity r1 = net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.this
                    java.lang.String unused = r1.N
                    java.lang.String r1 = r11.getmDate()
                    r10.c((java.lang.String) r1)
                    net.one97.paytm.o2o.movies.common.movies.a r1 = r10.f75279d
                    java.lang.String r2 = r11.getmDate()
                    r1.f75135f = r2
                    r10.a()
                    net.one97.paytm.o2o.movies.common.movies.a r1 = r10.f75279d
                    net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r1 = r1.k
                    net.one97.paytm.o2o.movies.common.movies.a r2 = r10.f75279d
                    net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2 r2 = r2.l
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0193 }
                    r3.<init>()     // Catch:{ Exception -> 0x0193 }
                    if (r11 == 0) goto L_0x0044
                    java.lang.String r4 = r11.getmDate()     // Catch:{ Exception -> 0x0193 }
                    goto L_0x004f
                L_0x0044:
                    net.one97.paytm.o2o.movies.common.movies.a r4 = r10.f75279d     // Catch:{ Exception -> 0x0193 }
                    if (r4 == 0) goto L_0x004d
                    net.one97.paytm.o2o.movies.common.movies.a r4 = r10.f75279d     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r4 = r4.f75135f     // Catch:{ Exception -> 0x0193 }
                    goto L_0x004f
                L_0x004d:
                    java.lang.String r4 = ""
                L_0x004f:
                    java.util.Calendar r5 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0193 }
                    r6 = 11
                    r7 = 0
                    r5.set(r6, r7)     // Catch:{ Exception -> 0x0193 }
                    r6 = 12
                    r5.set(r6, r7)     // Catch:{ Exception -> 0x0193 }
                    r6 = 13
                    r5.set(r6, r7)     // Catch:{ Exception -> 0x0193 }
                    java.util.Calendar r6 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0193 }
                    java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r8 = "yyyy-MM-dd"
                    r7.<init>(r8)     // Catch:{ Exception -> 0x0193 }
                    java.util.Date r4 = r7.parse(r4)     // Catch:{ Exception -> 0x0193 }
                    r6.setTime(r4)     // Catch:{ Exception -> 0x0193 }
                    long r6 = r6.getTimeInMillis()     // Catch:{ Exception -> 0x0193 }
                    long r4 = r5.getTimeInMillis()     // Catch:{ Exception -> 0x0193 }
                    long r6 = r6 - r4
                    long r4 = java.lang.Math.abs(r6)     // Catch:{ Exception -> 0x0193 }
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
                    r6.<init>()     // Catch:{ Exception -> 0x0193 }
                    float r4 = (float) r4     // Catch:{ Exception -> 0x0193 }
                    r5 = 1285868416(0x4ca4cb80, float:8.64E7)
                    float r4 = r4 / r5
                    int r4 = java.lang.Math.round(r4)     // Catch:{ Exception -> 0x0193 }
                    r6.append(r4)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r5 = r10.f75277b     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r6 = "screenName"
                    if (r5 == 0) goto L_0x00b4
                    java.lang.String r5 = r10.f75277b     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r7 = "movie"
                    boolean r5 = r5.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0193 }
                    if (r5 == 0) goto L_0x00b4
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.T     // Catch:{ Exception -> 0x0193 }
                    r3.put(r6, r5)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.v     // Catch:{ Exception -> 0x0193 }
                    r3.put(r5, r6)     // Catch:{ Exception -> 0x0193 }
                    goto L_0x00ce
                L_0x00b4:
                    java.lang.String r5 = r10.f75277b     // Catch:{ Exception -> 0x0193 }
                    if (r5 == 0) goto L_0x00ce
                    java.lang.String r5 = r10.f75277b     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r7 = "cinema"
                    boolean r5 = r5.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0193 }
                    if (r5 == 0) goto L_0x00ce
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.S     // Catch:{ Exception -> 0x0193 }
                    r3.put(r6, r5)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.z     // Catch:{ Exception -> 0x0193 }
                    r3.put(r5, r6)     // Catch:{ Exception -> 0x0193 }
                L_0x00ce:
                    android.content.Context r5 = r10.getContext()     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.d.b((android.content.Context) r5)     // Catch:{ Exception -> 0x0193 }
                    if (r5 == 0) goto L_0x00e3
                    boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x0193 }
                    if (r6 != 0) goto L_0x00e3
                    java.lang.String r6 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x0193 }
                    r3.put(r6, r5)     // Catch:{ Exception -> 0x0193 }
                L_0x00e3:
                    if (r1 == 0) goto L_0x0100
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.f75014i     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r6 = r1.getFinalDisplayName()     // Catch:{ Exception -> 0x00ff }
                    r3.put(r5, r6)     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.j     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r6 = r10.f75278c     // Catch:{ Exception -> 0x00ff }
                    r3.put(r5, r6)     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.n     // Catch:{ Exception -> 0x00ff }
                    java.lang.String r6 = r1.getLanguage()     // Catch:{ Exception -> 0x00ff }
                    r3.put(r5, r6)     // Catch:{ Exception -> 0x00ff }
                    goto L_0x0100
                L_0x00ff:
                L_0x0100:
                    if (r2 == 0) goto L_0x012d
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.k     // Catch:{ Exception -> 0x012d }
                    java.lang.String r6 = r2.getName()     // Catch:{ Exception -> 0x012d }
                    r3.put(r5, r6)     // Catch:{ Exception -> 0x012d }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.l     // Catch:{ Exception -> 0x012d }
                    java.lang.String r6 = r2.getId()     // Catch:{ Exception -> 0x012d }
                    r3.put(r5, r6)     // Catch:{ Exception -> 0x012d }
                    java.lang.String r5 = r2.getpKey()     // Catch:{ Exception -> 0x012d }
                    if (r5 == 0) goto L_0x012d
                    java.lang.String r5 = r2.getpKey()     // Catch:{ Exception -> 0x012d }
                    boolean r5 = r5.isEmpty()     // Catch:{ Exception -> 0x012d }
                    if (r5 != 0) goto L_0x012d
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.m     // Catch:{ Exception -> 0x012d }
                    java.lang.String r2 = r2.getpKey()     // Catch:{ Exception -> 0x012d }
                    r3.put(r5, r2)     // Catch:{ Exception -> 0x012d }
                L_0x012d:
                    java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r5 = "Date Selected"
                    r3.put(r2, r5)     // Catch:{ Exception -> 0x0193 }
                    if (r1 == 0) goto L_0x015f
                    if (r11 == 0) goto L_0x015f
                    java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x0193 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0193 }
                    r5.<init>()     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r6 = r11.getmDayName()     // Catch:{ Exception -> 0x0193 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0193 }
                    r5.append(r0)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r1 = r1.getFinalDisplayName()     // Catch:{ Exception -> 0x0193 }
                    r5.append(r1)     // Catch:{ Exception -> 0x0193 }
                    r5.append(r0)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r0 = r10.f75278c     // Catch:{ Exception -> 0x0193 }
                    r5.append(r0)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0193 }
                    r3.put(r2, r0)     // Catch:{ Exception -> 0x0193 }
                L_0x015f:
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.o     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r1 = "Date Selected - "
                    java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r1 = r1.concat(r2)     // Catch:{ Exception -> 0x0193 }
                    r3.put(r0, r1)     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x0193 }
                    r3.put(r0, r1)     // Catch:{ Exception -> 0x0193 }
                    android.content.Context r0 = r10.f75280e     // Catch:{ Exception -> 0x0193 }
                    boolean r0 = com.paytm.utility.b.r((android.content.Context) r0)     // Catch:{ Exception -> 0x0193 }
                    if (r0 == 0) goto L_0x0188
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x0193 }
                    android.content.Context r1 = r10.f75280e     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r1 = com.paytm.utility.b.n((android.content.Context) r1)     // Catch:{ Exception -> 0x0193 }
                    r3.put(r0, r1)     // Catch:{ Exception -> 0x0193 }
                L_0x0188:
                    net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0193 }
                    net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x0193 }
                    java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x0193 }
                    android.content.Context r10 = r10.f75280e     // Catch:{ Exception -> 0x0193 }
                    r0.sendCustomEventWithMap(r1, r3, r10)     // Catch:{ Exception -> 0x0193 }
                L_0x0193:
                    net.one97.paytm.o2o.movies.fragment.d$a r10 = r5
                    java.lang.String r11 = r11.getmDate()
                    r10.f75287b = r11
                    net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity r10 = net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.this
                    net.one97.paytm.o2o.movies.adapter.a r10 = r10.I
                    r10.notifyDataSetChanged()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity.AnonymousClass2.a(int, net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab):void");
            }
        });
        this.J.addItemDecoration(new RecyclerView.h() {
            public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                super.getItemOffsets(rect, view, recyclerView, sVar);
                if (recyclerView.getChildViewHolder(view).getAdapterPosition() == 0) {
                    rect.left = n.a(AJRCinemaDetailsActivity.this.getApplicationContext(), 20);
                }
            }
        });
        this.J.setAdapter(this.I);
        if (this.p.getCurrentItem() == 0) {
            this.J.setVisibility(0);
            int i2 = 0;
            while (true) {
                if (i2 >= aVar.f75286a.size()) {
                    i2 = 0;
                    break;
                } else if (aVar.f75286a.get(i2).getmDate().equals(aVar.f75287b)) {
                    break;
                } else {
                    i2++;
                }
            }
            this.J.scrollToPosition(i2);
            return;
        }
        this.J.setVisibility(8);
    }

    public final void a(String str) {
        this.z.setText(str);
        this.y.setVisibility(0);
    }

    public final void d() {
        this.f73912b.setVisibility(8);
        this.f73914d = false;
        this.p.setPagingEnabled(false);
    }

    public final void b(String str) {
        b.a aVar = net.one97.paytm.o2o.movies.common.customui.b.f75096g;
        net.one97.paytm.o2o.movies.common.customui.b a2 = b.a.a(this);
        a2.f75098b = R.layout.custom_snackbar_view;
        a2.a(b.c.INDEFINITE).a(findViewById(R.id.movie_detail_rel_lay), getString(R.string.no_movie_in_selected_city, new Object[]{str}), new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.o2o.movies.common.customui.b.this.c();
            }
        });
        a2.b();
    }

    public final void a(CJRCinemaV2 cJRCinemaV2, d.a aVar) {
        if (cJRCinemaV2 != null) {
            h hVar = h.f75928a;
            String a2 = h.a(cJRCinemaV2);
            h hVar2 = h.f75928a;
            String b2 = h.b(cJRCinemaV2);
            this.u = cJRCinemaV2.getName();
            this.M.setText(a2);
            if (cJRCinemaV2.getLatitude() == 0.0d || cJRCinemaV2.getLongitude() == 0.0d) {
                this.P.setVisibility(8);
            } else {
                this.P.setVisibility(0);
                try {
                    this.f73917g = cJRCinemaV2.getLatitude();
                    this.f73918h = cJRCinemaV2.getLongitude();
                    if (this.f73917g > 0.0d && this.f73918h > 0.0d && this.f73919i > 0.0d && this.j > 0.0d) {
                        float[] fArr = new float[2];
                        Location.distanceBetween(this.f73917g, this.f73918h, this.f73919i, this.j, fArr);
                        new StringBuilder(": ").append(fArr[0]);
                        float f2 = fArr[0] / 1000.0f;
                        if (((double) f2) > 99.0d) {
                            this.Q.setText("99+ km");
                        } else {
                            RoboTextView roboTextView = this.Q;
                            roboTextView.setText(String.format("%.2f", new Object[]{Float.valueOf(f2)}) + " km ");
                        }
                        this.Q.setVisibility(0);
                    }
                } catch (Exception unused) {
                }
            }
            this.P.setOnClickListener(new View.OnClickListener(a2) {
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    AJRCinemaDetailsActivity.this.a(this.f$1, view);
                }
            });
            ArrayList<CJRAmenity> a3 = a(cJRCinemaV2.getAmenities());
            if (a3 == null || a3.size() <= 0) {
                a(false);
                this.K.setVisibility(4);
            } else {
                this.K.setVisibility(0);
                a(true);
                at atVar = (at) this.K.getAdapter();
                k.c(a3, "amenities");
                atVar.f74473a.clear();
                atVar.f74473a.addAll(a3);
                atVar.notifyDataSetChanged();
                this.K.addItemDecoration(new RecyclerView.h() {
                    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                        super.getItemOffsets(rect, view, recyclerView, sVar);
                        rect.right = n.a(AJRCinemaDetailsActivity.this.getApplicationContext(), 20);
                    }
                });
            }
            this.f73912b.setVisibility(8);
            a(aVar);
            if (!TextUtils.isEmpty(b2)) {
                this.v.setText(b2);
                if (this.f73911a.getViewTreeObserver() != null) {
                    this.f73911a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public final void onGlobalLayout() {
                            int height = AJRCinemaDetailsActivity.this.f73911a.getHeight();
                            if (height > 0) {
                                AJRCinemaDetailsActivity.this.n.setExpandedTitleMarginBottom(height + com.paytm.utility.b.c(10));
                                AJRCinemaDetailsActivity.this.f73911a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        }
                    });
                }
            } else {
                this.n.setExpandedTitleMarginBottom(com.paytm.utility.b.c(15));
                this.v.setVisibility(8);
            }
            this.w.setVisibility(8);
            this.n.setTitle(a2);
            this.f73914d = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + this.f73917g + AppConstants.COMMA + this.f73918h + "?q=" + this.f73917g + AppConstants.COMMA + this.f73918h + "(" + Uri.encode(str) + ")"));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    private static ArrayList<CJRAmenity> a(List<CJRAmenity> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        ArrayList<CJRAmenity> arrayList2 = new ArrayList<>();
        Collections.sort(list);
        Collections.reverse(list);
        for (CJRAmenity next : list) {
            if (next.getStatus() != -1) {
                if (next.getStatus() == 0) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
        }
        arrayList2.addAll(arrayList);
        return arrayList2;
    }

    private void a(boolean z2) {
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        if (z2) {
            layoutParams.height = com.paytm.utility.b.c(230);
            return;
        }
        this.f73911a.getLayoutParams().height = com.paytm.utility.b.c(90);
        layoutParams.height = com.paytm.utility.b.c(188);
    }
}
