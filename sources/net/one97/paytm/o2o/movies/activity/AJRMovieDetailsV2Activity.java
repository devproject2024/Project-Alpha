package net.one97.paytm.o2o.movies.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.common.widgets.CJRNonSwipableViewPager;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.f;
import net.one97.paytm.o2o.movies.adapter.m;
import net.one97.paytm.o2o.movies.adapter.n;
import net.one97.paytm.o2o.movies.common.CJRBackPressHandledEditText;
import net.one97.paytm.o2o.movies.common.customui.CustomTabLayout;
import net.one97.paytm.o2o.movies.common.customui.b;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieRating;
import net.one97.paytm.o2o.movies.d.b;
import net.one97.paytm.o2o.movies.fragment.i;
import net.one97.paytm.o2o.movies.utils.h;
import net.one97.paytm.o2o.movies.utils.k;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRMovieDetailsV2Activity extends AppBaseActivity implements View.OnClickListener, e.b, e.c, CJRBackPressHandledEditText.a, b, i.d, k.b {
    private static final String z = AJRMovieDetailsV2Activity.class.getSimpleName();
    private View A;
    private ConstraintLayout B = null;
    /* access modifiers changed from: private */
    public ImageView C;
    private e D;
    /* access modifiers changed from: private */
    public CJRNonSwipableViewPager E;
    private RelativeLayout F;
    private String G;
    private String H;
    private String I;
    /* access modifiers changed from: private */
    public String J;
    private String K;
    private String L;
    private RoboTextView M;
    private ImageView N;
    /* access modifiers changed from: private */
    public View O;
    private View P;
    private RoboTextView Q;
    private String R;
    private String S = null;
    private String T;
    private boolean U = true;
    private boolean V = true;
    private ShimmerFrameLayout W;
    private boolean X = false;
    /* access modifiers changed from: private */
    public f Y;
    /* access modifiers changed from: private */
    public RecyclerView Z;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public int f74006a;
    /* access modifiers changed from: private */
    public String aa = "";
    private String ab;
    private TextView ac;
    private TextView ad;
    private ConstraintLayout ae;
    private CoordinatorLayout af;
    private View ag;
    /* access modifiers changed from: private */
    public LinearLayout ah;
    private i.a ai;

    /* renamed from: b  reason: collision with root package name */
    boolean f74007b = true;

    /* renamed from: c  reason: collision with root package name */
    public CustomTabLayout f74008c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74009d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74010e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f74011f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74012g = true;

    /* renamed from: h  reason: collision with root package name */
    RelativeLayout f74013h;

    /* renamed from: i  reason: collision with root package name */
    public AppBarLayout f74014i;
    public int j = 0;
    /* access modifiers changed from: package-private */
    public i k;
    View l;
    TextView m;
    View n;
    ImageView o;
    /* access modifiers changed from: package-private */
    public int p;
    public String q;
    public String r = "";
    private double s;
    private double t;
    private boolean u;
    private Animation v;
    private Animation w;
    private ImageView x;
    private k y;

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onConnectionSuspended(int i2) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT <= 19) {
            setTheme(R.style.MovieDetailPageTheme);
        }
        setContentView(R.layout.moviedetails_parallax);
        if (com.paytm.utility.b.O((Context) this) && com.paytm.utility.b.P((Context) this)) {
            try {
                this.D = new e.a(this).a((e.b) this).a((e.c) this).a((a<? extends a.d.C0127d>) com.google.android.gms.location.f.f11372a).a();
            } catch (Exception unused) {
            }
        }
        this.v = AnimationUtils.loadAnimation(this, R.anim.movie_bottom_up);
        this.w = AnimationUtils.loadAnimation(this, R.anim.bottom_down_movie);
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.dropBreadCrumb(z, "");
        this.f74014i = (AppBarLayout) findViewById(R.id.movie_details_appbar);
        this.ai = new i.a() {
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
                if (r2 == 0) goto L_0x0043;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onOffsetChanged(com.google.android.material.appbar.AppBarLayout r7, int r8) {
                /*
                    r6 = this;
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r0 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    r1 = 0
                    if (r8 != 0) goto L_0x0024
                    int r2 = r0.j
                    if (r2 != 0) goto L_0x0024
                    boolean r2 = r0.f74007b
                    if (r2 != 0) goto L_0x0024
                    int r2 = r0.f74006a
                    r3 = 3
                    if (r2 <= r3) goto L_0x0024
                    net.one97.paytm.o2o.movies.fragment.i r2 = r0.k
                    if (r2 == 0) goto L_0x0024
                    net.one97.paytm.o2o.movies.fragment.i r2 = r0.k
                    android.widget.EditText r2 = r2.l
                    boolean r2 = r2.hasFocus()
                    if (r2 != 0) goto L_0x0024
                    r2 = 1
                    r0.a((boolean) r2, (boolean) r1)
                L_0x0024:
                    int r2 = java.lang.Math.abs(r8)
                    int r3 = r7.getTotalScrollRange()
                    boolean r4 = r0.f74009d
                    if (r4 == 0) goto L_0x0033
                    r0.p = r2
                    goto L_0x0041
                L_0x0033:
                    android.view.View r4 = r0.n
                    int r4 = r4.getMeasuredHeight()
                    int r5 = r2 + r4
                    r0.p = r5
                    int r3 = r3 - r4
                    if (r2 != 0) goto L_0x0041
                    goto L_0x0043
                L_0x0041:
                    int r1 = r0.p
                L_0x0043:
                    float r1 = (float) r1
                    float r2 = (float) r3
                    float r1 = r1 / r2
                    android.view.View r2 = r0.l
                    r2.setAlpha(r1)
                    android.widget.TextView r2 = r0.m
                    r2.setAlpha(r1)
                    double r1 = (double) r1
                    r3 = 4603579539098121011(0x3fe3333333333333, double:0.6)
                    int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r5 <= 0) goto L_0x0061
                    int r1 = net.one97.paytm.o2o.movies.R.drawable.movie_detail_back_black
                    android.graphics.drawable.Drawable r1 = androidx.appcompat.a.a.a.b(r0, r1)
                    goto L_0x0067
                L_0x0061:
                    int r1 = net.one97.paytm.o2o.movies.R.drawable.movie_back_arrow_white
                    android.graphics.drawable.Drawable r1 = androidx.appcompat.a.a.a.b(r0, r1)
                L_0x0067:
                    android.widget.ImageView r0 = r0.o
                    r0.setImageDrawable(r1)
                    super.onOffsetChanged(r7, r8)
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r7 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    r7.a((int) r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.AnonymousClass1.onOffsetChanged(com.google.android.material.appbar.AppBarLayout, int):void");
            }

            public final void a(i.e eVar) {
                if (eVar == i.e.EXPANDED && AJRMovieDetailsV2Activity.this.k != null) {
                    AJRMovieDetailsV2Activity.this.k.f75339c = false;
                }
            }
        };
        this.f74014i.a((AppBarLayout.b) this.ai);
        this.ah = (LinearLayout) findViewById(R.id.sortByDistanceRly);
        this.ah.setOnClickListener(this);
        this.x = (ImageView) findViewById(R.id.sortByDistanceFilterImg);
        this.B = (ConstraintLayout) findViewById(R.id.movie_details_collapse_toolbar);
        this.ad = (TextView) findViewById(R.id.sortByDistanceTv);
        this.f74008c = (CustomTabLayout) findViewById(R.id.movie_details_tabs);
        this.f74008c.setTabGravity(0);
        this.f74008c.setSelectedTabIndicatorWidth(n.a(85, (Context) this));
        this.f74008c.setSelectedTabIndicatorColor(androidx.core.content.b.c(this, R.color.color_00b9f5));
        this.f74008c.setSelectedTabIndicatorHeight((int) (getResources().getDisplayMetrics().density * 2.0f));
        this.f74008c.setTabTextColors(androidx.core.content.b.c(this, net.one97.paytm.common.assets.R.color.color_999999), androidx.core.content.b.c(this, net.one97.paytm.common.assets.R.color.color_000000));
        this.C = (ImageView) findViewById(R.id.header_image);
        this.M = (RoboTextView) findViewById(R.id.movie_banner_subTitle);
        this.N = (ImageView) findViewById(R.id.youtube_play_icon);
        this.F = (RelativeLayout) findViewById(R.id.progress_bar_layout);
        this.E = (CJRNonSwipableViewPager) findViewById(R.id.movie_details_viewpager);
        this.E.setOffscreenPageLimit(3);
        this.f74013h = (RelativeLayout) findViewById(R.id.movie_details);
        this.P = findViewById(R.id.lyt_no_movies);
        this.Q = (RoboTextView) findViewById(R.id.txt_error_description);
        this.A = findViewById(R.id.lyt_error_handling);
        this.O = findViewById(R.id.movie_detail_tab_book);
        this.O.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRMovieDetailsV2Activity.this.c(view);
            }
        });
        this.Z = (RecyclerView) findViewById(R.id.date_tab_recycler_view);
        this.W = (ShimmerFrameLayout) findViewById(R.id.shimmer_movie_detail);
        this.l = findViewById(R.id.id_toolbar_bg);
        this.m = (TextView) findViewById(R.id.id_toolbar_name);
        this.ac = (TextView) findViewById(R.id.movie_banner_title);
        this.n = findViewById(R.id.id_toolbar);
        this.o = (ImageView) findViewById(R.id.id_toolbar_back);
        this.ae = (ConstraintLayout) findViewById(R.id.id_rating_layout);
        this.af = (CoordinatorLayout) findViewById(R.id.id_coord_layout);
        this.ag = findViewById(R.id.bottom_gradientLayout);
        this.o.setOnClickListener(this);
        ((ImageView) findViewById(R.id.retryBtn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRMovieDetailsV2Activity.this.b(view);
            }
        });
        ((ImageView) findViewById(R.id.close_circle_btn)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRMovieDetailsV2Activity.this.a(view);
            }
        });
        try {
            Intent intent = getIntent();
            if (intent != null) {
                this.U = intent.getBooleanExtra("movie_pass_present", true);
                if (intent.hasExtra("movie_ticket_city_selected")) {
                    this.G = intent.getStringExtra("movie_ticket_city_selected");
                }
                if (this.G == null) {
                    this.G = "";
                }
                if (intent.hasExtra("tab")) {
                    this.j = intent.getIntExtra("tab", 0);
                    if (this.j > 0) {
                        this.j--;
                    }
                }
                if (intent.hasExtra("movie_ticket_specific_city_selected")) {
                    this.H = intent.getStringExtra("movie_ticket_specific_city_selected");
                }
                if (intent.hasExtra("movie_ticket_selected_item_type")) {
                    this.J = intent.getStringExtra("movie_ticket_selected_item_type");
                }
                if (intent.hasExtra("movie_ticket_selected_item_value")) {
                    this.I = intent.getStringExtra("movie_ticket_selected_item_value");
                }
                if (intent.hasExtra("movie_ticket_selected_item_value")) {
                    this.K = intent.getStringExtra("movie_ticket_selected_format_id");
                }
                if (intent.hasExtra("url_type")) {
                    this.R = intent.getStringExtra("url_type");
                }
                if (intent.hasExtra("cinema_movie_code")) {
                    this.S = intent.getStringExtra("cinema_movie_code");
                }
                if (intent.hasExtra("intent_movie_session")) {
                    this.T = intent.getStringExtra("intent_movie_session");
                    this.ab = intent.getStringExtra("movie_ticket_booking_date");
                }
                if (intent.hasExtra("is_selected_movie_exists_in_selected_city")) {
                    this.V = intent.getBooleanExtra("is_selected_movie_exists_in_selected_city", true);
                }
            }
        } catch (Exception unused2) {
        }
        final ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R.string.movies_booking_tab));
        String str = this.J;
        if (str != null && str.equalsIgnoreCase("movie")) {
            arrayList.add(getResources().getString(R.string.about_movie));
            arrayList.add(getResources().getString(R.string.reviews));
        }
        String str2 = this.G;
        String str3 = this.H;
        String str4 = this.J;
        String str5 = this.I;
        String str6 = this.R;
        String str7 = this.T;
        String str8 = this.ab;
        String str9 = "url_type";
        ArrayList arrayList2 = arrayList;
        this.E.setAdapter(new net.one97.paytm.o2o.movies.adapter.n(getSupportFragmentManager(), arrayList2, new m(str2, str3, str4, str5, str6, str7, str8, this.U, this.V, this.S, this.L, this.K), new n.a() {
            public final void setFragment(Fragment fragment) {
                AJRMovieDetailsV2Activity.this.a(fragment);
            }
        }, this.I));
        this.f74008c.setupWithViewPager(this.E, true);
        this.E.setPagingEnabled(false);
        this.E.addOnPageChangeListener(new ViewPager.e() {

            /* renamed from: c  reason: collision with root package name */
            private boolean f74018c = false;

            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
                if (i2 == 1) {
                    AJRMovieDetailsV2Activity.this.O.setVisibility(0);
                    AJRMovieDetailsV2Activity.this.ah.setVisibility(8);
                } else {
                    AJRMovieDetailsV2Activity.this.O.setVisibility(8);
                    AJRMovieDetailsV2Activity.this.a(true, false);
                }
                float f3 = 1.0f - f2;
                AJRMovieDetailsV2Activity.this.Z.setAlpha(f3);
                if (((double) f3) <= 0.5d || i2 != 0) {
                    AJRMovieDetailsV2Activity.this.Z.setVisibility(8);
                } else {
                    AJRMovieDetailsV2Activity.this.Z.setVisibility(0);
                }
                if (AJRMovieDetailsV2Activity.this.f74009d) {
                    androidx.localbroadcastmanager.a.a.a((Context) AJRMovieDetailsV2Activity.this).a(new Intent("callAboutMovieAPI"));
                }
                if (AJRMovieDetailsV2Activity.this.f74011f != null && AJRMovieDetailsV2Activity.this.f74010e) {
                    androidx.localbroadcastmanager.a.a.a((Context) AJRMovieDetailsV2Activity.this).a(new Intent("callReviewsListApi"));
                }
            }

            public final void onPageSelected(int i2) {
                if (i2 == 0 && ((String) arrayList.get(i2)).equalsIgnoreCase(AJRMovieDetailsV2Activity.this.getResources().getString(R.string.movies_booking_tab)) && !v.a(AJRMovieDetailsV2Activity.this.J) && AJRMovieDetailsV2Activity.this.J.equalsIgnoreCase("movie") && AJRMovieDetailsV2Activity.this.k != null && AJRMovieDetailsV2Activity.this.k.isAdded()) {
                    AJRMovieDetailsV2Activity.this.k.g();
                    i unused = AJRMovieDetailsV2Activity.this.k;
                }
            }
        });
        ((CoordinatorLayout.d) this.f74014i.getLayoutParams()).a((CoordinatorLayout.Behavior) new AppBarLayout.Behavior() {
            public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
                if (i3 > 0) {
                    i3 = Math.min(AJRMovieDetailsV2Activity.this.f74014i.getTotalScrollRange() - AJRMovieDetailsV2Activity.this.p, i3);
                }
                super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
            }
        });
        Intent intent2 = getIntent();
        CJRHomePageItem cJRHomePageItem = null;
        try {
            cJRHomePageItem = (CJRHomePageItem) intent2.getSerializableExtra("extra_home_data");
        } catch (Exception unused3) {
        }
        if (intent2 != null && "movies-seat-layout".equalsIgnoreCase(intent2.getStringExtra(str9)) && cJRHomePageItem != null) {
            if (d.b(cJRHomePageItem.getPushCity()) && d.b(cJRHomePageItem.getPushCityValue())) {
                cJRHomePageItem.setPushCityValue(this.G);
            }
            Intent intent3 = new Intent(this, AJRSeatLayoutDeeplink.class);
            intent3.putExtra("extra_home_data", cJRHomePageItem);
            startActivity(intent3);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        onBackPressed();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/" + this.L);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.u);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Book Tickets - Content");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            String b2 = d.b((Context) this);
            if (b2 != null && !b2.isEmpty()) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75013h, b2);
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75014i, this.q);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.j, this.I);
            if (this.r != null && !this.r.isEmpty()) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.n, this.r);
            }
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    public final void a(int i2) {
        i iVar;
        if (Build.VERSION.SDK_INT >= 21) {
            int a2 = net.one97.paytm.o2o.movies.utils.n.a(4, (Context) this);
            if (Math.abs(i2) < net.one97.paytm.o2o.movies.utils.n.a((int) H5Param.WEBVIEW_FONT_SIZE_LARGER, (Context) this) || (iVar = this.k) == null || iVar.f75339c) {
                this.f74014i.setElevation(0.0f);
            } else {
                this.f74014i.setElevation((float) a2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Fragment fragment) {
        if (fragment instanceof i) {
            this.k = (i) fragment;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        k kVar;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 115 && i3 == -1 && (kVar = this.y) != null) {
            kVar.a();
        }
    }

    public void onBackPressed() {
        int i2 = this.j;
        if (i2 == 1 || i2 == 2) {
            this.E.setCurrentItem(0, true);
            this.f74008c.a(0).a();
            return;
        }
        super.onBackPressed();
        overridePendingTransition(17432576, net.one97.paytm.common.assets.R.anim.slide_out_right);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void h() {
        this.f74008c.b();
        if (this.f74009d || this.f74010e) {
            CustomTabLayout customTabLayout = this.f74008c;
            customTabLayout.a(customTabLayout.a().a((CharSequence) getResources().getString(R.string.movies_booking_tab)), true);
        }
        if (this.f74009d) {
            CustomTabLayout customTabLayout2 = this.f74008c;
            customTabLayout2.a(customTabLayout2.a().a((CharSequence) getResources().getString(R.string.about_movie)));
        }
        if (this.f74010e) {
            CustomTabLayout customTabLayout3 = this.f74008c;
            customTabLayout3.a(customTabLayout3.a().a((CharSequence) getResources().getString(R.string.reviews)));
        }
        this.E.setCurrentItem(this.j, false);
        this.f74008c.a((CustomTabLayout.b) new CustomTabLayout.b() {
            public final void b(CustomTabLayout.e eVar) {
            }

            public final void a(CustomTabLayout.e eVar) {
                AJRMovieDetailsV2Activity.this.j = eVar.f75077d;
                AJRMovieDetailsV2Activity.this.E.setCurrentItem(AJRMovieDetailsV2Activity.this.j, false);
            }
        });
    }

    public final void a(boolean z2) {
        this.f74012g = z2;
    }

    public final void a() {
        if (this.F != null) {
            try {
                this.W.a();
            } catch (Exception unused) {
            }
            this.X = true;
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRMovieDetailsV2Activity.this.j();
                }
            }, 1500);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.X = false;
    }

    public final void b() {
        if (this.F == null) {
            return;
        }
        if (this.X) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRMovieDetailsV2Activity.this.i();
                }
            }, 1000);
            return;
        }
        try {
            this.W.b();
        } catch (Exception unused) {
        }
        this.F.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        try {
            this.W.b();
        } catch (Exception unused) {
        }
        this.F.setVisibility(8);
    }

    public final void e() {
        AppBarLayout.Behavior behavior;
        if (this.f74009d) {
            i iVar = this.k;
            if (!(iVar == null || iVar.f75340d == null)) {
                this.k.f75340d.stopScroll();
            }
            this.f74014i.setExpanded(false, true);
            return;
        }
        int totalScrollRange = this.f74014i.getTotalScrollRange() - this.p;
        if (totalScrollRange != 0 && (behavior = (AppBarLayout.Behavior) ((CoordinatorLayout.d) this.f74014i.getLayoutParams()).f2603a) != null) {
            behavior.onNestedPreScroll(this.af, this.f74014i, (View) null, 0, totalScrollRange, new int[2], 0);
        }
    }

    private void c(String str) {
        int a2 = com.paytm.utility.b.a((Activity) this);
        int i2 = (int) (((double) a2) / 1.8d);
        this.B.getLayoutParams().height = i2;
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = a2;
        if (str != null) {
            try {
                if (!str.startsWith("https://") && !str.startsWith("http://")) {
                    str = "https://".concat(String.valueOf(str));
                }
            } catch (Exception unused) {
                return;
            }
        }
        this.C.setTag(str);
        net.one97.paytm.o2o.movies.utils.v.INSTANCE.loadImage(str, new ImageLoader.ImageListener() {
            public final void onErrorResponse(VolleyError volleyError) {
                AJRMovieDetailsV2Activity.this.C.setBackgroundColor(androidx.core.content.b.c(AJRMovieDetailsV2Activity.this, net.one97.paytm.common.assets.R.color.color_000000));
            }

            public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                Bitmap bitmap;
                if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null && imageContainer.getRequestUrl() != null && AJRMovieDetailsV2Activity.this.C.getTag() != null && imageContainer.getRequestUrl().equalsIgnoreCase((String) AJRMovieDetailsV2Activity.this.C.getTag())) {
                    AJRMovieDetailsV2Activity.this.C.setScaleType(ImageView.ScaleType.FIT_XY);
                    AJRMovieDetailsV2Activity.this.C.setImageBitmap(bitmap);
                }
            }
        }, a2, i2);
    }

    public final void c() {
        if (!isFinishing()) {
            String string = getResources().getString(R.string.movie_maintenance_error_title);
            String string2 = getResources().getString(R.string.movie_maintenance_error_description);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(string).setMessage(string2).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRMovieDetailsV2Activity.this.a(dialogInterface, i2);
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
        if (this.f74012g) {
            try {
                if (this.f74009d) {
                    this.f74012g = false;
                }
                net.one97.paytm.o2o.movies.utils.n.b((View) this.f74008c);
            } catch (Exception unused) {
                q.d("keyboard movie detail activity");
            }
            i iVar = this.k;
            if (iVar != null && iVar.isAdded()) {
                this.k.l.clearFocus();
                return;
            }
            return;
        }
        onBackPressed();
    }

    public final void a(CJRMovieCinemaV2 cJRMovieCinemaV2, i.b bVar) {
        CJRMovieRating imdb;
        String str;
        String str2;
        if (cJRMovieCinemaV2 != null) {
            StringBuilder sb = new StringBuilder();
            if (cJRMovieCinemaV2.getDuration() != null) {
                sb.append(net.one97.paytm.o2o.movies.utils.n.a(cJRMovieCinemaV2.getDuration().intValue()));
            }
            h hVar = h.f75928a;
            String a2 = h.a(cJRMovieCinemaV2);
            this.r = a2;
            if (!TextUtils.isEmpty(a2)) {
                if (sb.toString().trim().length() > 0) {
                    StringBuilder sb2 = new StringBuilder(" | ");
                    h hVar2 = h.f75928a;
                    sb2.append(h.a(cJRMovieCinemaV2));
                    a2 = sb2.toString();
                }
                sb.append(a2);
            }
            if (!TextUtils.isEmpty(cJRMovieCinemaV2.getGenre())) {
                if (sb.toString().trim().length() > 0) {
                    str2 = " | " + cJRMovieCinemaV2.getGenre();
                } else {
                    str2 = cJRMovieCinemaV2.getGenre();
                }
                sb.append(str2);
            }
            if (!TextUtils.isEmpty(cJRMovieCinemaV2.getCensor())) {
                if (sb.toString().trim().length() > 0) {
                    str = " | (" + cJRMovieCinemaV2.getCensor() + ")";
                } else {
                    str = cJRMovieCinemaV2.getCensor();
                }
                sb.append(str);
            }
            this.ag.setVisibility(0);
            if (!(cJRMovieCinemaV2.getRatings() == null || (imdb = cJRMovieCinemaV2.getRatings().getImdb()) == null)) {
                ((TextView) this.ae.findViewById(R.id.id_rating)).setText(String.valueOf(imdb.getRating()));
                ((TextView) this.ae.findViewById(R.id.id_max_rating)).setText(" /" + imdb.getBase_rating() + " IMDb");
                this.ae.setVisibility(0);
            }
            this.L = cJRMovieCinemaV2.getDisplay();
            h hVar3 = h.f75928a;
            String b2 = h.b(cJRMovieCinemaV2);
            this.m.setText(b2);
            this.ac.setText(b2);
            this.q = b2;
            if (!TextUtils.isEmpty(sb.toString())) {
                this.M.setText(sb.toString());
            } else {
                this.M.setVisibility(8);
            }
            if (cJRMovieCinemaV2.getUrlForTrailer() == null || TextUtils.isEmpty(cJRMovieCinemaV2.getUrlForTrailer())) {
                this.N.setVisibility(8);
            } else {
                this.N.setVisibility(0);
                this.N.setOnClickListener(new View.OnClickListener(cJRMovieCinemaV2) {
                    private final /* synthetic */ CJRMovieCinemaV2 f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        AJRMovieDetailsV2Activity.this.a(this.f$1, view);
                    }
                });
            }
            if (cJRMovieCinemaV2.getAppCoverUrl() == null || TextUtils.isEmpty(cJRMovieCinemaV2.getAppCoverUrl()) || cJRMovieCinemaV2.getAppCoverUrl().equalsIgnoreCase("NA")) {
                c(cJRMovieCinemaV2.getImageUrl());
            } else {
                c(cJRMovieCinemaV2.getAppCoverUrl());
            }
            this.f74009d = cJRMovieCinemaV2.isContentAvailable() == 1;
            this.f74010e = cJRMovieCinemaV2.isReviewAvailable();
            this.f74011f = cJRMovieCinemaV2.getContentId();
            if (this.f74009d || this.f74010e) {
                if (!this.f74009d && this.j == 1) {
                    b();
                    this.j = 0;
                }
                if (!this.f74010e && this.j == 2) {
                    b();
                    this.j = 0;
                }
                this.f74012g = true;
                this.f74008c.setVisibility(0);
                this.E.setPagingEnabled(false);
                h();
                if (!TextUtils.isEmpty(this.R) && this.R.equalsIgnoreCase("movie-details")) {
                    this.j = 1;
                    this.E.setCurrentItem(1, false);
                    this.f74008c.a(1).a();
                }
            } else {
                this.f74008c.setVisibility(8);
                this.E.setPagingEnabled(false);
                i iVar = this.k;
                if (iVar != null && iVar.isAdded()) {
                    this.k.b(this.n.getMeasuredHeight());
                }
                if (this.j != 0) {
                    b();
                    this.j = 0;
                    this.E.setCurrentItem(0);
                }
            }
            a(bVar);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("city_name", this.G);
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                HashMap hashMap4 = new HashMap();
                hashMap4.put("list", "Movie Listing");
                ArrayList arrayList = new ArrayList();
                HashMap hashMap5 = new HashMap();
                hashMap5.put("name", this.L);
                hashMap5.put("id", cJRMovieCinemaV2.getContentId());
                hashMap5.put("price", 0);
                hashMap5.put(CLPConstants.BRAND_PARAMS, this.G);
                hashMap5.put("variant", cJRMovieCinemaV2.getScreenFormat());
                if (net.one97.paytm.o2o.movies.b.a.INSTANCE.getPos() != 0) {
                    hashMap5.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(net.one97.paytm.o2o.movies.b.a.INSTANCE.getPos()));
                    net.one97.paytm.o2o.movies.b.a.INSTANCE.setPos(0);
                } else {
                    hashMap5.put(CLPConstants.ARGUMENT_KEY_POSITION, 0);
                }
                arrayList.add(hashMap5);
                hashMap4.put("products", arrayList);
                hashMap3.put("actionField", hashMap4);
                hashMap2.put("detail", hashMap3);
                hashMap.put("ecommerce", hashMap2);
                hashMap.put("vertical_name", "Entertainment - Movies");
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendEnhancedEcommerceEvent("openScreen", hashMap, this);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMovieCinemaV2 cJRMovieCinemaV2, View view) {
        String urlForTrailer = cJRMovieCinemaV2.getUrlForTrailer();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/movies/" + this.L);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.v);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "Movie Trailer Video Play Click");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            try {
                q.c(e2.getMessage());
            } catch (Exception unused) {
                return;
            }
        }
        String str = null;
        Intent intent = new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("AJRYoutubeVideoPlay"));
        if (urlForTrailer != null && !TextUtils.isEmpty(urlForTrailer)) {
            "URL ------".concat(String.valueOf(urlForTrailer));
            com.paytm.utility.b.j();
            str = com.paytm.utility.b.e(urlForTrailer);
            if (str == null) {
                str = com.paytm.utility.b.f(urlForTrailer);
            }
            "VIDEO ID ------".concat(String.valueOf(str));
            com.paytm.utility.b.j();
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            intent.putExtra(com.paytm.utility.e.aA, str);
            startActivity(intent);
        }
    }

    private void a(final i.b bVar) {
        this.Z.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.Y = new f(bVar, new f.a() {
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0153 A[Catch:{ Exception -> 0x016a }] */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x0197  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(int r9, net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab r10) {
                /*
                    r8 = this;
                    java.lang.String r0 = "|"
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r1 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    net.one97.paytm.o2o.movies.fragment.i r1 = r1.k
                    if (r1 == 0) goto L_0x01a9
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r1 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    androidx.recyclerview.widget.RecyclerView r1 = r1.Z
                    r1.scrollToPosition(r9)
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r9 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    net.one97.paytm.o2o.movies.fragment.i r9 = r9.k
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r1 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    java.lang.String unused = r1.aa
                    android.widget.ProgressBar r1 = r9.f75341e
                    r2 = 8
                    r1.setVisibility(r2)
                    java.lang.String r1 = r10.getmDate()
                    r2 = 0
                    r9.a((java.lang.String) r1, (boolean) r2)
                    net.one97.paytm.o2o.movies.common.movies.a r1 = r9.j
                    java.lang.String r3 = r10.getmDate()
                    r1.f75135f = r3
                    boolean r1 = r9.g()
                    boolean r3 = r9.f75338b
                    r9.b((boolean) r1, (boolean) r3)
                    net.one97.paytm.o2o.movies.common.movies.a r1 = r9.j
                    net.one97.paytm.o2o.movies.common.movies.search.CJRMovieCinemaV2 r1 = r1.k
                    java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x016a }
                    r3.<init>()     // Catch:{ Exception -> 0x016a }
                    if (r10 == 0) goto L_0x004e
                    java.lang.String r4 = r10.getmDate()     // Catch:{ Exception -> 0x016a }
                    goto L_0x0059
                L_0x004e:
                    net.one97.paytm.o2o.movies.common.movies.a r4 = r9.j     // Catch:{ Exception -> 0x016a }
                    if (r4 == 0) goto L_0x0057
                    net.one97.paytm.o2o.movies.common.movies.a r4 = r9.j     // Catch:{ Exception -> 0x016a }
                    java.lang.String r4 = r4.f75135f     // Catch:{ Exception -> 0x016a }
                    goto L_0x0059
                L_0x0057:
                    java.lang.String r4 = ""
                L_0x0059:
                    java.util.Calendar r5 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x016a }
                    r6 = 11
                    r5.set(r6, r2)     // Catch:{ Exception -> 0x016a }
                    r6 = 12
                    r5.set(r6, r2)     // Catch:{ Exception -> 0x016a }
                    r6 = 13
                    r5.set(r6, r2)     // Catch:{ Exception -> 0x016a }
                    java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x016a }
                    java.text.SimpleDateFormat r6 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x016a }
                    java.lang.String r7 = "yyyy-MM-dd"
                    r6.<init>(r7)     // Catch:{ Exception -> 0x016a }
                    java.util.Date r4 = r6.parse(r4)     // Catch:{ Exception -> 0x016a }
                    r2.setTime(r4)     // Catch:{ Exception -> 0x016a }
                    long r6 = r2.getTimeInMillis()     // Catch:{ Exception -> 0x016a }
                    long r4 = r5.getTimeInMillis()     // Catch:{ Exception -> 0x016a }
                    long r6 = r6 - r4
                    long r4 = java.lang.Math.abs(r6)     // Catch:{ Exception -> 0x016a }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
                    r2.<init>()     // Catch:{ Exception -> 0x016a }
                    float r4 = (float) r4     // Catch:{ Exception -> 0x016a }
                    r5 = 1285868416(0x4ca4cb80, float:8.64E7)
                    float r4 = r4 / r5
                    int r4 = java.lang.Math.round(r4)     // Catch:{ Exception -> 0x016a }
                    r2.append(r4)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x016a }
                    java.lang.String r4 = r9.f75343g     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = "screenName"
                    if (r4 == 0) goto L_0x00bd
                    java.lang.String r4 = r9.f75343g     // Catch:{ Exception -> 0x016a }
                    java.lang.String r6 = "movie"
                    boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x016a }
                    if (r4 == 0) goto L_0x00bd
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.T     // Catch:{ Exception -> 0x016a }
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.v     // Catch:{ Exception -> 0x016a }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x016a }
                    goto L_0x00d7
                L_0x00bd:
                    java.lang.String r4 = r9.f75343g     // Catch:{ Exception -> 0x016a }
                    if (r4 == 0) goto L_0x00d7
                    java.lang.String r4 = r9.f75343g     // Catch:{ Exception -> 0x016a }
                    java.lang.String r6 = "cinema"
                    boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x016a }
                    if (r4 == 0) goto L_0x00d7
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.S     // Catch:{ Exception -> 0x016a }
                    r3.put(r5, r4)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.z     // Catch:{ Exception -> 0x016a }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x016a }
                L_0x00d7:
                    java.lang.String r4 = r9.f75342f     // Catch:{ Exception -> 0x016a }
                    if (r4 == 0) goto L_0x00ea
                    java.lang.String r4 = r9.f75342f     // Catch:{ Exception -> 0x016a }
                    boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x016a }
                    if (r4 != 0) goto L_0x00ea
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = r9.f75342f     // Catch:{ Exception -> 0x016a }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x016a }
                L_0x00ea:
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75014i     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = r1.getFinalDisplayName()     // Catch:{ Exception -> 0x016a }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.j     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = r9.f75344h     // Catch:{ Exception -> 0x016a }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.n     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = r1.getLanguage()     // Catch:{ Exception -> 0x016a }
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x016a }
                    java.lang.String r5 = "Date Selected"
                    r3.put(r4, r5)     // Catch:{ Exception -> 0x016a }
                    if (r1 == 0) goto L_0x0135
                    if (r10 == 0) goto L_0x0135
                    java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x016a }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016a }
                    r5.<init>()     // Catch:{ Exception -> 0x016a }
                    java.lang.String r6 = r10.getmDayName()     // Catch:{ Exception -> 0x016a }
                    r5.append(r6)     // Catch:{ Exception -> 0x016a }
                    r5.append(r0)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r1 = r1.getFinalDisplayName()     // Catch:{ Exception -> 0x016a }
                    r5.append(r1)     // Catch:{ Exception -> 0x016a }
                    r5.append(r0)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r0 = r9.f75344h     // Catch:{ Exception -> 0x016a }
                    r5.append(r0)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x016a }
                    r3.put(r4, r0)     // Catch:{ Exception -> 0x016a }
                L_0x0135:
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.o     // Catch:{ Exception -> 0x016a }
                    java.lang.String r1 = "Date Selected - "
                    java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r1 = r1.concat(r2)     // Catch:{ Exception -> 0x016a }
                    r3.put(r0, r1)     // Catch:{ Exception -> 0x016a }
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x016a }
                    java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x016a }
                    r3.put(r0, r1)     // Catch:{ Exception -> 0x016a }
                    android.content.Context r0 = r9.k     // Catch:{ Exception -> 0x016a }
                    boolean r0 = com.paytm.utility.b.r((android.content.Context) r0)     // Catch:{ Exception -> 0x016a }
                    if (r0 == 0) goto L_0x015e
                    java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x016a }
                    android.content.Context r1 = r9.k     // Catch:{ Exception -> 0x016a }
                    java.lang.String r1 = com.paytm.utility.b.n((android.content.Context) r1)     // Catch:{ Exception -> 0x016a }
                    r3.put(r0, r1)     // Catch:{ Exception -> 0x016a }
                L_0x015e:
                    net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x016a }
                    net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x016a }
                    java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x016a }
                    android.content.Context r9 = r9.k     // Catch:{ Exception -> 0x016a }
                    r0.sendCustomEventWithMap(r1, r3, r9)     // Catch:{ Exception -> 0x016a }
                    goto L_0x016b
                L_0x016a:
                L_0x016b:
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r9 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    int unused = r9.f74006a = 0
                    net.one97.paytm.o2o.movies.fragment.i$b r9 = r5
                    java.lang.String r10 = r10.getmDate()
                    r9.f75364b = r10
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r9 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    net.one97.paytm.o2o.movies.adapter.f r9 = r9.Y
                    r9.notifyDataSetChanged()
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r9 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    net.one97.paytm.o2o.movies.fragment.i r9 = r9.k
                    androidx.recyclerview.widget.RecyclerView r9 = r9.f75340d
                    r9.stopScroll()
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r9 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    r9.e()
                    net.one97.paytm.o2o.movies.fragment.i$e r9 = net.one97.paytm.o2o.movies.fragment.i.a.f75362b
                    net.one97.paytm.o2o.movies.fragment.i$e r10 = net.one97.paytm.o2o.movies.fragment.i.e.COLLAPSED
                    if (r9 == r10) goto L_0x01a0
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r9 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    net.one97.paytm.o2o.movies.fragment.i r9 = r9.k
                    r9.h()
                L_0x01a0:
                    net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity r9 = net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.this
                    androidx.recyclerview.widget.RecyclerView r9 = r9.Z
                    net.one97.paytm.o2o.movies.utils.n.b((android.view.View) r9)
                L_0x01a9:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRMovieDetailsV2Activity.AnonymousClass6.a(int, net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieDetailsTab):void");
            }
        });
        this.Z.addItemDecoration(new RecyclerView.h() {
            public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                super.getItemOffsets(rect, view, recyclerView, sVar);
                if (recyclerView.getChildViewHolder(view).getAdapterPosition() == 0) {
                    rect.left = net.one97.paytm.o2o.movies.utils.n.a(AJRMovieDetailsV2Activity.this.getApplicationContext(), 20);
                }
            }
        });
        this.Z.setAdapter(this.Y);
        if (this.E.getCurrentItem() == 0) {
            this.Z.setVisibility(0);
            int i2 = 0;
            while (true) {
                if (i2 >= bVar.f75363a.size()) {
                    i2 = 0;
                    break;
                } else if (bVar.f75363a.get(i2).getmDate().equals(bVar.f75364b)) {
                    break;
                } else {
                    i2++;
                }
            }
            this.Z.scrollToPosition(i2);
            return;
        }
        this.Z.setVisibility(8);
    }

    public final void a(String str) {
        this.Q.setText(str);
        this.P.setVisibility(0);
    }

    public final void d() {
        if (!this.f74010e) {
            this.f74008c.setVisibility(8);
            this.f74012g = false;
            this.E.setPagingEnabled(false);
        } else if (this.f74008c.a(1) != null) {
            CustomTabLayout.e a2 = this.f74008c.a(1);
            if (a2.f75080g != null) {
                a2.f75080g.setVisibility(8);
            }
        } else {
            return;
        }
        this.E.setCurrentItem(0);
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

    public final void a(CJRCinemaV2 cJRCinemaV2, i.b bVar) {
        if (cJRCinemaV2 != null) {
            this.ag.setVisibility(0);
            h hVar = h.f75928a;
            String a2 = h.a(cJRCinemaV2);
            h hVar2 = h.f75928a;
            String b2 = h.b(cJRCinemaV2);
            this.L = cJRCinemaV2.getName();
            this.f74008c.setVisibility(8);
            a(bVar);
            if (!TextUtils.isEmpty(cJRCinemaV2.getAppCoverImageUrl())) {
                c(cJRCinemaV2.getAppCoverImageUrl());
            } else {
                String coverImageUrl = cJRCinemaV2.getCoverImageUrl();
                if (!TextUtils.isEmpty(coverImageUrl) && !coverImageUrl.equalsIgnoreCase("NA")) {
                    c(coverImageUrl);
                }
            }
            if (!TextUtils.isEmpty(b2)) {
                this.M.setText(b2);
            } else {
                this.M.setVisibility(8);
            }
            this.N.setVisibility(8);
            this.m.setText(a2);
            this.ac.setText(a2);
            this.q = a2;
            this.f74012g = false;
            i iVar = this.k;
            if (iVar != null && iVar.isAdded()) {
                this.k.b(this.n.getMeasuredHeight());
            }
        }
    }

    public void onClick(View view) {
        e eVar;
        int id = view.getId();
        if (id == R.id.id_toolbar_back) {
            onBackPressed();
        } else if (id != R.id.sortByDistanceRly) {
        } else {
            if (this.u) {
                double d2 = this.t;
                if (d2 > 0.0d) {
                    double d3 = this.s;
                    if (d3 > 0.0d) {
                        this.k.a(d3, d2);
                    }
                }
            } else if (com.paytm.utility.b.c((Context) this) && (eVar = this.D) != null) {
                this.y = new k(this, this, eVar, this);
                this.y.b();
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k kVar;
        if (i2 == 57) {
            if (!s.a(iArr) || (kVar = this.y) == null) {
                Toast.makeText(this, "Please provide Location permission to use this feature.", 1).show();
            } else {
                kVar.b();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onStop() {
        super.onStop();
        try {
            if (this.D != null && this.D.f()) {
                this.D.e();
            }
        } catch (Exception unused) {
        }
    }

    public void onDestroy() {
        net.one97.paytm.o2o.movies.utils.i.a().f75937g = null;
        net.one97.paytm.o2o.movies.utils.i.a().f75938h = null;
        net.one97.paytm.o2o.movies.utils.i.a().j = null;
        net.one97.paytm.o2o.movies.utils.i.a().f75939i.clear();
        super.onDestroy();
    }

    public void onStart() {
        super.onStart();
        try {
            if (this.D != null) {
                this.D.d();
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.handlePlayServicesError(this);
        } catch (Exception unused) {
        }
    }

    public final void f() {
        i iVar;
        if (this.y != null && (iVar = this.k) != null && iVar.isAdded()) {
            this.s = this.y.f75941a;
            this.t = this.y.f75942b;
            this.k.a(this.y.f75941a, this.y.f75942b);
        }
    }

    public final void a(final boolean z2, final boolean z3) {
        if (!z2 || this.j != 0 || this.f74007b || this.f74006a <= 3) {
            if (this.ah.getVisibility() != 8) {
                if (!z3) {
                    this.ah.startAnimation(this.w);
                }
                this.ah.setVisibility(8);
            }
        } else if (this.F.getVisibility() == 0) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    AJRMovieDetailsV2Activity.this.a(z2, z3);
                }
            }, 200);
        } else if (this.ah.getVisibility() != 0) {
            this.ah.setVisibility(0);
            this.ah.animate().translationX(0.0f).translationY(0.0f);
            if (!z3) {
                this.ah.startAnimation(this.v);
            }
        }
    }

    public final void b(boolean z2) {
        if (z2) {
            this.ad.setTextColor(androidx.core.content.b.c(this, R.color.color_00b9f5_re));
            this.x.setImageResource(R.drawable.ic_direction_blue);
            if (i.a.f75362b != i.e.COLLAPSED) {
                this.k.f75340d.stopScroll();
                e();
                this.k.h();
            }
            this.u = true;
            return;
        }
        this.ad.setTextColor(androidx.core.content.b.c(this, net.one97.paytm.common.assets.R.color.color_444444));
        this.x.setImageResource(R.drawable.ic_direction_black_arrow);
        this.u = false;
    }

    public final void g() {
        this.f74007b = true;
        this.A.setVisibility(0);
    }

    public final void c(boolean z2) {
        this.f74007b = z2;
    }

    public final void b(int i2) {
        this.f74006a = i2;
    }
}
