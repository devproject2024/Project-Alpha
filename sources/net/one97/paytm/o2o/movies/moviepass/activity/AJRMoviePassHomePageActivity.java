package net.one97.paytm.o2o.movies.moviepass.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.utility.g;
import com.paytm.utility.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassRedeemInstructionModel;
import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassTncInstructionModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRCinemaDetailsActivity;
import net.one97.paytm.o2o.movies.activity.AJRCinemasSearchLanding;
import net.one97.paytm.o2o.movies.activity.AJRMoviesSelectCityActivity;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesActivity;
import net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesGridPage;
import net.one97.paytm.o2o.movies.activity.AppBaseActivity;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassFaqInstructionModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassHomeModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassStorefrontModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel;
import net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassWrapperModel;
import net.one97.paytm.o2o.movies.d.e;
import net.one97.paytm.o2o.movies.entity.CJRCinemaV1;
import net.one97.paytm.o2o.movies.entity.CJRCinemas;
import net.one97.paytm.o2o.movies.moviepass.b.c;
import net.one97.paytm.o2o.movies.moviepass.d.h;
import net.one97.paytm.o2o.movies.moviepass.e.e;
import net.one97.paytm.o2o.movies.utils.n;

public final class AJRMoviePassHomePageActivity extends AppBaseActivity implements aj.a, y.j, net.one97.paytm.o2o.movies.moviepass.b, c.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRSelectCityModel f75456a;

    /* renamed from: b  reason: collision with root package name */
    private CJRMoviePassHomeModel f75457b;

    /* renamed from: c  reason: collision with root package name */
    private c.a f75458c;

    /* renamed from: d  reason: collision with root package name */
    private CJRMoviePassCatalogModel f75459d;

    /* renamed from: e  reason: collision with root package name */
    private String f75460e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f75461f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<CJRUserMoviePassModel> f75462g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRMoviePassModelNew> f75463h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private List<Integer> f75464i = new ArrayList();
    private String j;
    private ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> k = new ArrayList<>();
    private String l = "0";
    private CJRUpcomingMovies m;
    private ArrayList<CJRCinemas> n;
    private boolean o;
    private net.one97.paytm.o2o.movies.moviepass.a.b p;
    private final AJRMoviePassHomePageActivity$mMessageReceiver$1 q = new AJRMoviePassHomePageActivity$mMessageReceiver$1(this);
    private HashMap r;

    private View a(int i2) {
        if (this.r == null) {
            this.r = new HashMap();
        }
        View view = (View) this.r.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.r.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(String str, com.paytm.network.listener.b bVar) {
    }

    public final void c(boolean z) {
    }

    public static final /* synthetic */ c.a b(AJRMoviePassHomePageActivity aJRMoviePassHomePageActivity) {
        c.a aVar = aJRMoviePassHomePageActivity.f75458c;
        if (aVar == null) {
            k.a("mPresenterListener");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ajrmovie_pass_home_page);
        Serializable serializableExtra = getIntent().getSerializableExtra("userselectedcity");
        if (!(serializableExtra instanceof CJRSelectCityModel)) {
            serializableExtra = null;
        }
        this.f75456a = (CJRSelectCityModel) serializableExtra;
        Serializable serializableExtra2 = getIntent().getSerializableExtra("mo_home_data");
        if (!(serializableExtra2 instanceof CJRMoviePassHomeModel)) {
            serializableExtra2 = null;
        }
        this.f75457b = (CJRMoviePassHomeModel) serializableExtra2;
        this.j = getIntent().getStringExtra("mp_code");
        CJRMoviePassHomeModel cJRMoviePassHomeModel = this.f75457b;
        if (cJRMoviePassHomeModel != null) {
            if (cJRMoviePassHomeModel == null) {
                k.a();
            }
            this.f75460e = cJRMoviePassHomeModel.getCurrentDate();
        }
        if (getIntent().getSerializableExtra("upcoming_movies_data") != null) {
            Serializable serializableExtra3 = getIntent().getSerializableExtra("upcoming_movies_data");
            if (serializableExtra3 != null) {
                this.m = (CJRUpcomingMovies) serializableExtra3;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies");
            }
        }
        if (getIntent().getParcelableArrayListExtra("cinemas_data") != null) {
            this.n = getIntent().getParcelableArrayListExtra("cinemas_data");
        }
        this.f75458c = new net.one97.paytm.o2o.movies.moviepass.f.b(this);
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            c();
            if (this.f75456a != null) {
                if (this.m == null) {
                    c.a aVar = this.f75458c;
                    if (aVar == null) {
                        k.a("mPresenterListener");
                    }
                    CJRSelectCityModel cJRSelectCityModel = this.f75456a;
                    if (cJRSelectCityModel == null) {
                        k.a();
                    }
                    String value = cJRSelectCityModel.getValue();
                    k.a((Object) value, "mSelectedCityModel!!.value");
                    aVar.c(value);
                }
                if (this.n == null) {
                    c.a aVar2 = this.f75458c;
                    if (aVar2 == null) {
                        k.a("mPresenterListener");
                    }
                    CJRSelectCityModel cJRSelectCityModel2 = this.f75456a;
                    if (cJRSelectCityModel2 == null) {
                        k.a();
                    }
                    String value2 = cJRSelectCityModel2.getValue();
                    k.a((Object) value2, "mSelectedCityModel!!.value");
                    aVar2.d(value2);
                }
            }
        } else {
            a(true);
        }
        ((ImageButton) a(R.id.back_button)).setOnClickListener(new a(this));
        ((LinearLayout) a(R.id.mp_city_linLay)).setOnClickListener(new b(this));
        this.p = new net.one97.paytm.o2o.movies.moviepass.a.b(this.k, this, context);
        RecyclerView recyclerView = (RecyclerView) a(R.id.passes_recycler_view);
        k.a((Object) recyclerView, "passes_recycler_view");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.passes_recycler_view);
        k.a((Object) recyclerView2, "passes_recycler_view");
        net.one97.paytm.o2o.movies.moviepass.a.b bVar = this.p;
        if (bVar == null) {
            k.a("mHomePageAdapter");
        }
        recyclerView2.setAdapter(bVar);
        androidx.localbroadcastmanager.a.a.a(context).a(this.q, new IntentFilter("login_event"));
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendOpenScreenEvent(context, "/movie_pass");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMoviePassHomePageActivity f75465a;

        a(AJRMoviePassHomePageActivity aJRMoviePassHomePageActivity) {
            this.f75465a = aJRMoviePassHomePageActivity;
        }

        public final void onClick(View view) {
            this.f75465a.onBackPressed();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMoviePassHomePageActivity f75466a;

        b(AJRMoviePassHomePageActivity aJRMoviePassHomePageActivity) {
            this.f75466a = aJRMoviePassHomePageActivity;
        }

        public final void onClick(View view) {
            if (!net.one97.paytm.o2o.movies.common.d.a((List) n.f75967d)) {
                this.f75466a.h();
                this.f75466a.f75461f = false;
                return;
            }
            this.f75466a.f75461f = true;
            AJRMoviePassHomePageActivity.b(this.f75466a).a();
        }
    }

    public final void a(boolean z) {
        View inflate = LayoutInflater.from(this).inflate(net.one97.paytm.common.assets.R.layout.no_network_layout, (ViewGroup) null);
        if (z) {
            View findViewById = inflate.findViewById(net.one97.paytm.common.assets.R.id.no_network);
            k.a((Object) findViewById, "view.findViewById<Linear…n.assets.R.id.no_network)");
            ((LinearLayout) findViewById).setVisibility(0);
            ((Button) inflate.findViewById(net.one97.paytm.common.assets.R.id.network_retry_btn)).setOnClickListener(new d(this));
            return;
        }
        View findViewById2 = inflate.findViewById(net.one97.paytm.common.assets.R.id.no_network);
        k.a((Object) findViewById2, "view.findViewById<Linear…n.assets.R.id.no_network)");
        ((LinearLayout) findViewById2).setVisibility(8);
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMoviePassHomePageActivity f75469a;

        d(AJRMoviePassHomePageActivity aJRMoviePassHomePageActivity) {
            this.f75469a = aJRMoviePassHomePageActivity;
        }

        public final void onClick(View view) {
            if (com.paytm.utility.b.c((Context) this.f75469a)) {
                this.f75469a.c();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        f();
        if (net.one97.paytm.o2o.movies.common.d.a((List) n.f75967d)) {
            c.a aVar = this.f75458c;
            if (aVar == null) {
                k.a("mPresenterListener");
            }
            aVar.a();
        }
        if (this.f75456a != null) {
            if (this.f75457b != null && com.paytm.utility.b.r((Context) this)) {
                CJRMoviePassHomeModel cJRMoviePassHomeModel = this.f75457b;
                if (cJRMoviePassHomeModel == null) {
                    k.a();
                }
                Boolean isSubscribedUser = cJRMoviePassHomeModel.isSubscribedUser();
                if (isSubscribedUser == null) {
                    k.a();
                }
                if (isSubscribedUser.booleanValue()) {
                    this.o = false;
                    c.a aVar2 = this.f75458c;
                    if (aVar2 == null) {
                        k.a("mPresenterListener");
                    }
                    CJRSelectCityModel cJRSelectCityModel = this.f75456a;
                    if (cJRSelectCityModel == null) {
                        k.a();
                    }
                    String value = cJRSelectCityModel.getValue();
                    k.a((Object) value, "mSelectedCityModel!!.value");
                    aVar2.a(value);
                }
            }
            TextView textView = (TextView) a(R.id.city_name_text);
            k.a((Object) textView, "city_name_text");
            CJRSelectCityModel cJRSelectCityModel2 = this.f75456a;
            if (cJRSelectCityModel2 == null) {
                k.a();
            }
            textView.setText(cJRSelectCityModel2.getLabel());
        } else {
            this.o = false;
            c.a aVar3 = this.f75458c;
            if (aVar3 == null) {
                k.a("mPresenterListener");
            }
            aVar3.a("");
        }
        CJRMoviePassHomeModel cJRMoviePassHomeModel2 = this.f75457b;
        if (cJRMoviePassHomeModel2 != null) {
            if (cJRMoviePassHomeModel2 == null) {
                k.a();
            }
            Boolean passAvailableInCity = cJRMoviePassHomeModel2.getPassAvailableInCity();
            if (passAvailableInCity == null) {
                k.a();
            }
            if (passAvailableInCity.booleanValue()) {
                if (this.f75456a != null) {
                    c.a aVar4 = this.f75458c;
                    if (aVar4 == null) {
                        k.a("mPresenterListener");
                    }
                    CJRSelectCityModel cJRSelectCityModel3 = this.f75456a;
                    if (cJRSelectCityModel3 == null) {
                        k.a();
                    }
                    String value2 = cJRSelectCityModel3.getValue();
                    k.a((Object) value2, "mSelectedCityModel!!.value");
                    aVar4.b(value2);
                    return;
                }
                c.a aVar5 = this.f75458c;
                if (aVar5 == null) {
                    k.a("mPresenterListener");
                }
                aVar5.b("");
                return;
            }
        }
        FrameLayout frameLayout = (FrameLayout) a(R.id.mp_not_available_layout);
        k.a((Object) frameLayout, "mp_not_available_layout");
        frameLayout.setVisibility(0);
    }

    public final void a(CJRMoviePassStorefrontModel cJRMoviePassStorefrontModel) {
        k.c(cJRMoviePassStorefrontModel, "moviePassStorefrontModel");
        this.f75459d = cJRMoviePassStorefrontModel.getMoviePassCatalogModel();
        this.l = "0";
        d();
        ((RecyclerView) a(R.id.passes_recycler_view)).smoothScrollToPosition(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02b1, code lost:
        if (r0.getMoviePassFaqInstructionMap().size() <= 0) goto L_0x02b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02cf, code lost:
        if (r0.getMoviePassRedeemInstructionMap().size() > 0) goto L_0x02d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d9, code lost:
        if (net.one97.paytm.o2o.movies.common.d.a((java.util.List) r11.n) != false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02db, code lost:
        b(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02df, code lost:
        b(false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void d() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r0 = r11.k     // Catch:{ all -> 0x0388 }
            r0.clear()     // Catch:{ all -> 0x0388 }
            r0 = 0
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew> r1 = r11.f75463h     // Catch:{ all -> 0x0388 }
            if (r1 != 0) goto L_0x000e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x000e:
            r1.clear()     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r1 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r1 == 0) goto L_0x0047
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x001c
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x001c:
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassStorefrontDataModel r0 = r0.getMoviePassStorefrontData()     // Catch:{ all -> 0x0388 }
            java.lang.String r1 = r11.f75460e     // Catch:{ all -> 0x0388 }
            boolean r1 = com.paytm.utility.v.a((java.lang.String) r1)     // Catch:{ all -> 0x0388 }
            if (r1 == 0) goto L_0x0035
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r1 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r1 != 0) goto L_0x002f
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x002f:
            java.lang.String r1 = r1.getCurrentDate()     // Catch:{ all -> 0x0388 }
            r11.f75460e = r1     // Catch:{ all -> 0x0388 }
        L_0x0035:
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew> r1 = r11.f75463h     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r2 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r2 != 0) goto L_0x003e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x003e:
            java.util.ArrayList r2 = r2.getMoviePassList()     // Catch:{ all -> 0x0388 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x0388 }
            r1.addAll(r2)     // Catch:{ all -> 0x0388 }
        L_0x0047:
            boolean r1 = r11.e()     // Catch:{ all -> 0x0388 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0115
            if (r0 == 0) goto L_0x0115
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBrandPromotionModel r1 = r0.getMoviePassBrandPromotion()     // Catch:{ all -> 0x0388 }
            if (r1 == 0) goto L_0x00a9
            boolean r4 = r1.isEnabled()     // Catch:{ all -> 0x0388 }
            if (r4 == 0) goto L_0x00a9
            net.one97.paytm.o2o.movies.moviepass.e.b r4 = new net.one97.paytm.o2o.movies.moviepass.e.b     // Catch:{ all -> 0x0388 }
            r4.<init>()     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = r1.getImageUrl()     // Catch:{ all -> 0x0388 }
            r4.f75579a = r5     // Catch:{ all -> 0x0388 }
            java.lang.String r1 = r1.getText()     // Catch:{ all -> 0x0388 }
            r4.f75580b = r1     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefitsModel r1 = r0.getMoviePassBenefit()     // Catch:{ all -> 0x0388 }
            if (r1 == 0) goto L_0x009b
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefitsModel r1 = r0.getMoviePassBenefit()     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = "storefrontData.moviePassBenefit"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0388 }
            java.util.List r1 = r1.getMoviePassBenefits()     // Catch:{ all -> 0x0388 }
            boolean r1 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r1)     // Catch:{ all -> 0x0388 }
            if (r1 != 0) goto L_0x009b
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefitsModel r1 = r0.getMoviePassBenefit()     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = "storefrontData.moviePassBenefit"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0388 }
            boolean r1 = r1.isEnabled()     // Catch:{ all -> 0x0388 }
            if (r1 != 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r1 = 0
            goto L_0x009c
        L_0x009b:
            r1 = 1
        L_0x009c:
            r4.f75581c = r1     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.e.a r1 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r1.<init>()     // Catch:{ all -> 0x0388 }
            r1.f75572c = r4     // Catch:{ all -> 0x0388 }
            r4 = 2
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r1, (int) r4)     // Catch:{ all -> 0x0388 }
        L_0x00a9:
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefitsModel r1 = r0.getMoviePassBenefit()     // Catch:{ all -> 0x0388 }
            if (r1 == 0) goto L_0x0115
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefitsModel r1 = r0.getMoviePassBenefit()     // Catch:{ all -> 0x0388 }
            java.lang.String r4 = "storefrontData.moviePassBenefit"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)     // Catch:{ all -> 0x0388 }
            boolean r1 = r1.isEnabled()     // Catch:{ all -> 0x0388 }
            if (r1 == 0) goto L_0x0115
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefitsModel r0 = r0.getMoviePassBenefit()     // Catch:{ all -> 0x0388 }
            java.lang.String r1 = "storefrontData.moviePassBenefit"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0388 }
            java.util.List r0 = r0.getMoviePassBenefits()     // Catch:{ all -> 0x0388 }
            boolean r1 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r1 != 0) goto L_0x0115
            java.lang.String r1 = "benefitsList"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0388 }
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x0388 }
            int r1 = r1.size()     // Catch:{ all -> 0x0388 }
            r4 = 0
        L_0x00e0:
            if (r4 >= r1) goto L_0x0115
            java.lang.Object r5 = r0.get(r4)     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefit r5 = (net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassBenefit) r5     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x0112
            net.one97.paytm.o2o.movies.moviepass.e.b r6 = new net.one97.paytm.o2o.movies.moviepass.e.b     // Catch:{ all -> 0x0388 }
            r6.<init>()     // Catch:{ all -> 0x0388 }
            java.lang.String r7 = r5.getImageUrl()     // Catch:{ all -> 0x0388 }
            r6.f75579a = r7     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = r5.getLabel()     // Catch:{ all -> 0x0388 }
            r6.f75580b = r5     // Catch:{ all -> 0x0388 }
            int r5 = r0.size()     // Catch:{ all -> 0x0388 }
            int r5 = r5 - r2
            if (r4 != r5) goto L_0x0104
            r5 = 1
            goto L_0x0105
        L_0x0104:
            r5 = 0
        L_0x0105:
            r6.f75581c = r5     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.e.a r5 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r5.<init>()     // Catch:{ all -> 0x0388 }
            r5.f75572c = r6     // Catch:{ all -> 0x0388 }
            r6 = 3
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r5, (int) r6)     // Catch:{ all -> 0x0388 }
        L_0x0112:
            int r4 = r4 + 1
            goto L_0x00e0
        L_0x0115:
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel> r0 = r11.f75462g     // Catch:{ all -> 0x0388 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            r1 = 4
            r4 = 8
            if (r0 != 0) goto L_0x0153
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r0 = r11.k     // Catch:{ all -> 0x0388 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x0134
            net.one97.paytm.o2o.movies.moviepass.e.a r0 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r0.<init>()     // Catch:{ all -> 0x0388 }
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r0, (int) r1)     // Catch:{ all -> 0x0388 }
        L_0x0134:
            net.one97.paytm.o2o.movies.moviepass.e.a r0 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r0.<init>()     // Catch:{ all -> 0x0388 }
            r0.f75570a = r4     // Catch:{ all -> 0x0388 }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel> r5 = r11.f75462g     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x0142
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x0142:
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel r5 = (net.one97.paytm.o2o.movies.common.movies.moviepass.CJRUserMoviePassModel) r5     // Catch:{ all -> 0x0388 }
            r0.f75576g = r5     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = r11.f75460e     // Catch:{ all -> 0x0388 }
            r0.j = r5     // Catch:{ all -> 0x0388 }
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r5 = r11.k     // Catch:{ all -> 0x0388 }
            r5.add(r0)     // Catch:{ all -> 0x0388 }
        L_0x0153:
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew> r0 = r11.f75463h     // Catch:{ all -> 0x0388 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x021a
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r0 = r11.k     // Catch:{ all -> 0x0388 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x016f
            net.one97.paytm.o2o.movies.moviepass.e.a r0 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r0.<init>()     // Catch:{ all -> 0x0388 }
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r0, (int) r1)     // Catch:{ all -> 0x0388 }
        L_0x016f:
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r0 = r11.k     // Catch:{ all -> 0x0388 }
            int r0 = r0.size()     // Catch:{ all -> 0x0388 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0388 }
            r5.<init>()     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.e.f r6 = new net.one97.paytm.o2o.movies.moviepass.e.f     // Catch:{ all -> 0x0388 }
            java.lang.String r7 = "0"
            java.lang.String r8 = "All"
            r6.<init>(r7, r8)     // Catch:{ all -> 0x0388 }
            java.lang.String r7 = r11.l     // Catch:{ all -> 0x0388 }
            java.lang.String r8 = r6.f75592a     // Catch:{ all -> 0x0388 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0388 }
            if (r7 == 0) goto L_0x018f
            r6.f75594c = r2     // Catch:{ all -> 0x0388 }
        L_0x018f:
            r5.add(r6)     // Catch:{ all -> 0x0388 }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew> r6 = r11.f75463h     // Catch:{ all -> 0x0388 }
            if (r6 != 0) goto L_0x0199
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x0199:
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0388 }
        L_0x019d:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0388 }
            if (r7 == 0) goto L_0x01fb
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew r7 = (net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassModelNew) r7     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.e.a r8 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r8.<init>()     // Catch:{ all -> 0x0388 }
            r8.f75571b = r7     // Catch:{ all -> 0x0388 }
            java.lang.String r9 = r11.l     // Catch:{ all -> 0x0388 }
            java.lang.String r10 = "pass"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)     // Catch:{ all -> 0x0388 }
            java.lang.String r10 = r7.getGroupId()     // Catch:{ all -> 0x0388 }
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0388 }
            if (r9 != 0) goto L_0x01cb
            java.lang.String r9 = r11.l     // Catch:{ all -> 0x0388 }
            java.lang.String r10 = "0"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0388 }
            if (r9 == 0) goto L_0x01ce
        L_0x01cb:
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r8, (int) r2)     // Catch:{ all -> 0x0388 }
        L_0x01ce:
            java.lang.String r8 = r7.getGroupId()     // Catch:{ all -> 0x0388 }
            boolean r8 = com.paytm.utility.v.a((java.lang.String) r8)     // Catch:{ all -> 0x0388 }
            if (r8 != 0) goto L_0x019d
            net.one97.paytm.o2o.movies.moviepass.e.f r8 = new net.one97.paytm.o2o.movies.moviepass.e.f     // Catch:{ all -> 0x0388 }
            java.lang.String r9 = r7.getGroupId()     // Catch:{ all -> 0x0388 }
            java.lang.String r7 = r7.getGroupName()     // Catch:{ all -> 0x0388 }
            r8.<init>(r9, r7)     // Catch:{ all -> 0x0388 }
            java.lang.String r7 = r11.l     // Catch:{ all -> 0x0388 }
            java.lang.String r9 = r8.f75592a     // Catch:{ all -> 0x0388 }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x0388 }
            if (r7 == 0) goto L_0x01f1
            r8.f75594c = r2     // Catch:{ all -> 0x0388 }
        L_0x01f1:
            boolean r7 = r5.contains(r8)     // Catch:{ all -> 0x0388 }
            if (r7 != 0) goto L_0x019d
            r5.add(r8)     // Catch:{ all -> 0x0388 }
            goto L_0x019d
        L_0x01fb:
            net.one97.paytm.o2o.movies.moviepass.e.a r6 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r6.<init>()     // Catch:{ all -> 0x0388 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0388 }
            r6.f75573d = r5     // Catch:{ all -> 0x0388 }
            r5 = 5
            r6.f75570a = r5     // Catch:{ all -> 0x0388 }
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r5 = r11.k     // Catch:{ all -> 0x0388 }
            int r5 = r5.size()     // Catch:{ all -> 0x0388 }
            if (r0 >= r5) goto L_0x0215
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r5 = r11.k     // Catch:{ all -> 0x0388 }
            r5.add(r0, r6)     // Catch:{ all -> 0x0388 }
            goto L_0x021a
        L_0x0215:
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r0 = r11.k     // Catch:{ all -> 0x0388 }
            r0.add(r6)     // Catch:{ all -> 0x0388 }
        L_0x021a:
            boolean r0 = r11.e()     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x032c
            net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies r0 = r11.m     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x025a
            net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies r0 = r11.m     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x022b
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x022b:
            java.util.List r0 = r0.getUpcomingMovieData()     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x025a
            net.one97.paytm.o2o.movies.moviepass.e.a r0 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r0.<init>()     // Catch:{ all -> 0x0388 }
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r0, (int) r1)     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.e.g r0 = new net.one97.paytm.o2o.movies.moviepass.e.g     // Catch:{ all -> 0x0388 }
            r0.<init>()     // Catch:{ all -> 0x0388 }
            net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies r1 = r11.m     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = "Upcoming Movies"
            r0.f75595a = r5     // Catch:{ all -> 0x0388 }
            r0.f75596b = r1     // Catch:{ all -> 0x0388 }
            r1 = r11
            net.one97.paytm.o2o.movies.adapter.aj$a r1 = (net.one97.paytm.o2o.movies.adapter.aj.a) r1     // Catch:{ all -> 0x0388 }
            r0.f75597c = r1     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.e.a r1 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r1.<init>()     // Catch:{ all -> 0x0388 }
            r1.f75574e = r0     // Catch:{ all -> 0x0388 }
            r0 = 6
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r1, (int) r0)     // Catch:{ all -> 0x0388 }
        L_0x025a:
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRCinemas> r0 = r11.n     // Catch:{ all -> 0x0388 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x0291
            r11.b((boolean) r3)     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.e.a r0 = new net.one97.paytm.o2o.movies.moviepass.e.a     // Catch:{ all -> 0x0388 }
            r0.<init>()     // Catch:{ all -> 0x0388 }
            net.one97.paytm.o2o.movies.moviepass.d.b r1 = new net.one97.paytm.o2o.movies.moviepass.d.b     // Catch:{ all -> 0x0388 }
            r1.<init>()     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = "Browse by Cinema Halls"
            r1.f75507a = r5     // Catch:{ all -> 0x0388 }
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRCinemas> r5 = r11.n     // Catch:{ all -> 0x0388 }
            r1.f75508b = r5     // Catch:{ all -> 0x0388 }
            r5 = r11
            net.one97.paytm.o2o.movies.adapter.y$j r5 = (net.one97.paytm.o2o.movies.adapter.y.j) r5     // Catch:{ all -> 0x0388 }
            r1.f75509c = r5     // Catch:{ all -> 0x0388 }
            net.one97.paytm.common.entity.CJRSelectCityModel r5 = r11.f75456a     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x0285
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x0285:
            java.lang.String r5 = r5.getValue()     // Catch:{ all -> 0x0388 }
            r1.f75510d = r5     // Catch:{ all -> 0x0388 }
            r0.f75575f = r1     // Catch:{ all -> 0x0388 }
            r1 = 7
            r11.a((net.one97.paytm.o2o.movies.moviepass.e.a) r0, (int) r1)     // Catch:{ all -> 0x0388 }
        L_0x0291:
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x032c
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x029c
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x029c:
            java.util.HashMap r0 = r0.getMoviePassFaqInstructionMap()     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x02b3
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x02a9
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x02a9:
            java.util.HashMap r0 = r0.getMoviePassFaqInstructionMap()     // Catch:{ all -> 0x0388 }
            int r0 = r0.size()     // Catch:{ all -> 0x0388 }
            if (r0 > 0) goto L_0x02d1
        L_0x02b3:
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x02ba
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x02ba:
            java.util.HashMap r0 = r0.getMoviePassRedeemInstructionMap()     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x02e2
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x02c7
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x02c7:
            java.util.HashMap r0 = r0.getMoviePassRedeemInstructionMap()     // Catch:{ all -> 0x0388 }
            int r0 = r0.size()     // Catch:{ all -> 0x0388 }
            if (r0 <= 0) goto L_0x02e2
        L_0x02d1:
            java.util.ArrayList<net.one97.paytm.o2o.movies.entity.CJRCinemas> r0 = r11.n     // Catch:{ all -> 0x0388 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x02df
            r11.b((boolean) r2)     // Catch:{ all -> 0x0388 }
            goto L_0x02e2
        L_0x02df:
            r11.b((boolean) r3)     // Catch:{ all -> 0x0388 }
        L_0x02e2:
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x02e9
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x02e9:
            java.util.HashMap r0 = r0.getMoviePassFaqInstructionMap()     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0307
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x02f6
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x02f6:
            java.util.HashMap r0 = r0.getMoviePassFaqInstructionMap()     // Catch:{ all -> 0x0388 }
            int r0 = r0.size()     // Catch:{ all -> 0x0388 }
            if (r0 <= 0) goto L_0x0307
            java.lang.String r0 = "General FAQ’s"
            net.one97.paytm.o2o.movies.moviepass.d.h$a r1 = net.one97.paytm.o2o.movies.moviepass.d.h.a.FAQ     // Catch:{ all -> 0x0388 }
            r11.a(r0, r1, r3)     // Catch:{ all -> 0x0388 }
        L_0x0307:
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x030e
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x030e:
            java.util.HashMap r0 = r0.getMoviePassRedeemInstructionMap()     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x032c
            net.one97.paytm.o2o.movies.common.movies.moviepass.CJRMoviePassCatalogModel r0 = r11.f75459d     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x031b
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0388 }
        L_0x031b:
            java.util.HashMap r0 = r0.getMoviePassRedeemInstructionMap()     // Catch:{ all -> 0x0388 }
            int r0 = r0.size()     // Catch:{ all -> 0x0388 }
            if (r0 <= 0) goto L_0x032c
            java.lang.String r0 = "How to Redeem"
            net.one97.paytm.o2o.movies.moviepass.d.h$a r1 = net.one97.paytm.o2o.movies.moviepass.d.h.a.HTR     // Catch:{ all -> 0x0388 }
            r11.a(r0, r1, r2)     // Catch:{ all -> 0x0388 }
        L_0x032c:
            net.one97.paytm.o2o.movies.moviepass.a.b r0 = r11.p     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x0335
            java.lang.String r1 = "mHomePageAdapter"
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ all -> 0x0388 }
        L_0x0335:
            r0.notifyDataSetChanged()     // Catch:{ all -> 0x0388 }
            java.util.ArrayList<net.one97.paytm.o2o.movies.moviepass.e.a> r0 = r11.k     // Catch:{ all -> 0x0388 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0388 }
            boolean r0 = net.one97.paytm.o2o.movies.common.d.a((java.util.List) r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0363
            int r0 = net.one97.paytm.o2o.movies.R.id.passes_recycler_view     // Catch:{ all -> 0x0388 }
            android.view.View r0 = r11.a((int) r0)     // Catch:{ all -> 0x0388 }
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0     // Catch:{ all -> 0x0388 }
            java.lang.String r1 = "passes_recycler_view"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0388 }
            r0.setVisibility(r4)     // Catch:{ all -> 0x0388 }
            int r0 = net.one97.paytm.o2o.movies.R.id.mp_not_available_layout     // Catch:{ all -> 0x0388 }
            android.view.View r0 = r11.a((int) r0)     // Catch:{ all -> 0x0388 }
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0     // Catch:{ all -> 0x0388 }
            java.lang.String r1 = "mp_not_available_layout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0388 }
            r0.setVisibility(r3)     // Catch:{ all -> 0x0388 }
            goto L_0x0383
        L_0x0363:
            int r0 = net.one97.paytm.o2o.movies.R.id.mp_not_available_layout     // Catch:{ all -> 0x0388 }
            android.view.View r0 = r11.a((int) r0)     // Catch:{ all -> 0x0388 }
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0     // Catch:{ all -> 0x0388 }
            java.lang.String r1 = "mp_not_available_layout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0388 }
            r0.setVisibility(r4)     // Catch:{ all -> 0x0388 }
            int r0 = net.one97.paytm.o2o.movies.R.id.passes_recycler_view     // Catch:{ all -> 0x0388 }
            android.view.View r0 = r11.a((int) r0)     // Catch:{ all -> 0x0388 }
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0     // Catch:{ all -> 0x0388 }
            java.lang.String r1 = "passes_recycler_view"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0388 }
            r0.setVisibility(r3)     // Catch:{ all -> 0x0388 }
        L_0x0383:
            r11.a()     // Catch:{ all -> 0x0388 }
            monitor-exit(r11)
            return
        L_0x0388:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.moviepass.activity.AJRMoviePassHomePageActivity.d():void");
    }

    private final void b(boolean z) {
        net.one97.paytm.o2o.movies.moviepass.e.a aVar = new net.one97.paytm.o2o.movies.moviepass.e.a();
        e eVar = new e();
        eVar.f75589a = true;
        eVar.f75590b = z;
        eVar.f75591c = false;
        aVar.f75578i = eVar;
        a(aVar, 4);
    }

    private final void a(String str, h.a aVar, boolean z) {
        net.one97.paytm.o2o.movies.moviepass.e.a aVar2 = new net.one97.paytm.o2o.movies.moviepass.e.a();
        net.one97.paytm.o2o.movies.moviepass.e.d dVar = new net.one97.paytm.o2o.movies.moviepass.e.d();
        dVar.f75586a = str;
        dVar.f75587b = aVar;
        dVar.f75588c = z;
        aVar2.f75577h = dVar;
        a(aVar2, 9);
    }

    private final void a(net.one97.paytm.o2o.movies.moviepass.e.a aVar, int i2) {
        aVar.f75570a = i2;
        this.k.add(aVar);
    }

    public final void a(CJRUserMoviePassWrapperModel cJRUserMoviePassWrapperModel) {
        k.c(cJRUserMoviePassWrapperModel, Payload.RESPONSE);
        this.o = true;
        a();
        this.f75462g.clear();
        if (!net.one97.paytm.o2o.movies.common.d.a((List) cJRUserMoviePassWrapperModel.getActivePass())) {
            ArrayList<CJRUserMoviePassModel> arrayList = this.f75462g;
            ArrayList<CJRUserMoviePassModel> activePass = cJRUserMoviePassWrapperModel.getActivePass();
            if (activePass == null) {
                k.a();
            }
            arrayList.addAll(activePass);
        }
        this.f75460e = cJRUserMoviePassWrapperModel.getCurrentDate();
        d();
    }

    public final void c(String str) {
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + str);
    }

    private final boolean e() {
        return !net.one97.paytm.o2o.movies.common.d.a((List) this.f75463h);
    }

    private void f() {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.mp_loading_progress);
        k.a((Object) relativeLayout, "mp_loading_progress");
        relativeLayout.setVisibility(0);
    }

    public final void a() {
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.mp_loading_progress);
        k.a((Object) relativeLayout, "mp_loading_progress");
        relativeLayout.setVisibility(8);
    }

    public final void b() {
        if (this.f75461f) {
            h();
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        if (net.one97.paytm.o2o.movies.common.d.a((List) n.f75967d)) {
            Toast.makeText(this, R.string.no_mp_cities_availble, 0).show();
            return;
        }
        Intent intent = new Intent(this, AJRMoviesSelectCityActivity.class);
        CJRSelectCityModel cJRSelectCityModel = this.f75456a;
        if (cJRSelectCityModel != null) {
            intent.putExtra("userselectedcity", cJRSelectCityModel);
            CJRSelectCityModel cJRSelectCityModel2 = this.f75456a;
            if (cJRSelectCityModel2 != null) {
                intent.putExtra("usercurrentcity", cJRSelectCityModel2 != null ? cJRSelectCityModel2.getValue() : null);
            }
            intent.putExtra("sourcename", "moviepass");
            startActivityForResult(intent, 2);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
            return;
        }
        throw new u("null cannot be cast to non-null type android.os.Parcelable");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2 && intent != null && intent.hasExtra("userselectedcity")) {
            Serializable serializableExtra = intent.getSerializableExtra("userselectedcity");
            if (serializableExtra != null) {
                CJRSelectCityModel cJRSelectCityModel = (CJRSelectCityModel) serializableExtra;
                CJRSelectCityModel cJRSelectCityModel2 = this.f75456a;
                if (cJRSelectCityModel2 != null) {
                    if (p.a(cJRSelectCityModel2 != null ? cJRSelectCityModel2.getValue() : null, cJRSelectCityModel.getValue(), false)) {
                        this.f75456a = cJRSelectCityModel;
                        return;
                    }
                }
                this.f75456a = cJRSelectCityModel;
                TextView textView = (TextView) a(R.id.city_name_text);
                k.a((Object) textView, "city_name_text");
                CJRSelectCityModel cJRSelectCityModel3 = this.f75456a;
                if (cJRSelectCityModel3 == null) {
                    k.a();
                }
                textView.setText(cJRSelectCityModel3.getValue());
                c();
                if (this.f75456a != null) {
                    c.a aVar = this.f75458c;
                    if (aVar == null) {
                        k.a("mPresenterListener");
                    }
                    CJRSelectCityModel cJRSelectCityModel4 = this.f75456a;
                    if (cJRSelectCityModel4 == null) {
                        k.a();
                    }
                    String value = cJRSelectCityModel4.getValue();
                    k.a((Object) value, "mSelectedCityModel!!.value");
                    aVar.c(value);
                    c.a aVar2 = this.f75458c;
                    if (aVar2 == null) {
                        k.a("mPresenterListener");
                    }
                    CJRSelectCityModel cJRSelectCityModel5 = this.f75456a;
                    if (cJRSelectCityModel5 == null) {
                        k.a();
                    }
                    String value2 = cJRSelectCityModel5.getValue();
                    k.a((Object) value2, "mSelectedCityModel!!.value");
                    aVar2.d(value2);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRSelectCityModel");
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        androidx.localbroadcastmanager.a.a.a((Context) this).a((BroadcastReceiver) this.q);
    }

    public static final class c implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMoviePassHomePageActivity f75467a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f75468b = true;

        /* JADX WARNING: type inference failed for: r1v0, types: [boolean, net.one97.paytm.o2o.movies.moviepass.activity.AJRMoviePassHomePageActivity] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        c(boolean r1) {
            /*
                r0 = this;
                r0.f75467a = r1
                r1 = 1
                r0.f75468b = r1
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.moviepass.activity.AJRMoviePassHomePageActivity.c.<init>(net.one97.paytm.o2o.movies.moviepass.activity.AJRMoviePassHomePageActivity):void");
        }

        public final void onDialogDismissed() {
            if (this.f75468b) {
                this.f75467a.finish();
            }
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "title");
        k.c(str2, "message");
        g.b(this, str, str2, new c(this));
    }

    public final void b(String str) {
        if (!v.a(str) && !this.l.equals(str)) {
            if (str == null) {
                k.a();
            }
            this.l = str;
            d();
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

    public final void a(View view, CJRUpcomingMovies cJRUpcomingMovies) {
        k.c(view, "view");
        k.c(cJRUpcomingMovies, "cjrUpcomingMovies");
        if (!net.one97.paytm.o2o.movies.utils.y.INSTANCE.validateIsAlreadyClicked(this, view)) {
            Intent intent = new Intent(this, AJRUpcomingMoviesGridPage.class);
            intent.putExtra(getString(R.string.upcoming_movies), cJRUpcomingMovies);
            startActivityForResult(intent, 7);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
        }
    }

    public final void g() {
        Intent intent = new Intent(this, AJRCinemasSearchLanding.class);
        CJRSelectCityModel cJRSelectCityModel = this.f75456a;
        if (cJRSelectCityModel == null) {
            k.a();
        }
        intent.putExtra("intent_city_name", cJRSelectCityModel.getLabel());
        intent.putParcelableArrayListExtra("cinema_list", this.n);
        intent.putExtra("movie_ticket_selected_item_type", "cinema");
        startActivity(intent);
        overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }

    public final void a(CJRCinemas cJRCinemas) {
        CJRSelectCityModel cJRSelectCityModel = this.f75456a;
        if (cJRSelectCityModel == null) {
            k.a();
        }
        String label = cJRSelectCityModel.getLabel();
        Intent intent = new Intent(this, AJRCinemaDetailsActivity.class);
        intent.putExtra("movie_ticket_city_selected", label);
        intent.putExtra("movie_ticket_selected_item_type", "cinema");
        if (cJRCinemas == null) {
            k.a();
        }
        intent.putExtra("movie_ticket_selected_item_value", String.valueOf(cJRCinemas.getPaytmCinemaId()));
        startActivity(intent);
        overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }

    public final void a(h.a aVar) {
        Intent intent = new Intent(this, AJRMpConditionsActivity.class);
        intent.putExtra("conditionType", aVar);
        if (h.a.FAQ.equals(aVar)) {
            CJRMoviePassCatalogModel cJRMoviePassCatalogModel = this.f75459d;
            if (cJRMoviePassCatalogModel == null) {
                k.a();
            }
            intent.putExtra("instructionsMap", cJRMoviePassCatalogModel.getMoviePassFaqInstructionMap());
        } else {
            CJRMoviePassCatalogModel cJRMoviePassCatalogModel2 = this.f75459d;
            if (cJRMoviePassCatalogModel2 == null) {
                k.a();
            }
            intent.putExtra("htrMap", cJRMoviePassCatalogModel2.getMoviePassRedeemInstructionMap());
        }
        startActivity(intent);
    }

    public final void a(e.b.a aVar) {
        if (e.b.a.MOVIEPASS_ACTIVE_EXPIRE.equals(aVar)) {
            this.o = true;
        }
    }

    public final void a(CJRUpcomingMovies cJRUpcomingMovies) {
        k.c(cJRUpcomingMovies, Payload.RESPONSE);
        this.m = cJRUpcomingMovies;
        d();
    }

    public final void a(CJRCinemaV1 cJRCinemaV1) {
        k.c(cJRCinemaV1, Payload.RESPONSE);
        ArrayList<CJRCinemas> arrayList = this.n;
        if (arrayList != null) {
            if (arrayList == null) {
                k.a();
            }
            arrayList.clear();
        }
        this.n = cJRCinemaV1.getCinemas();
        d();
    }

    public final void a(IJRDataModel iJRDataModel, View view) {
        k.c(iJRDataModel, "mDataModel");
        k.c(view, "movieCard");
        Intent intent = new Intent(this, AJRMoviePassDetailActivity.class);
        intent.putExtra("movie_pass_object", iJRDataModel);
        CJRSelectCityModel cJRSelectCityModel = this.f75456a;
        if (cJRSelectCityModel != null) {
            intent.putExtra("userselectedcity", cJRSelectCityModel);
            intent.putExtra("mp_current_date", this.f75460e);
            CJRMoviePassCatalogModel cJRMoviePassCatalogModel = this.f75459d;
            if (cJRMoviePassCatalogModel == null) {
                k.a();
            }
            HashMap<String, CJRMoviePassFaqInstructionModel> moviePassFaqInstructionMap = cJRMoviePassCatalogModel.getMoviePassFaqInstructionMap();
            if (!(moviePassFaqInstructionMap instanceof Serializable)) {
                moviePassFaqInstructionMap = null;
            }
            intent.putExtra("mp_faq_instructions", moviePassFaqInstructionMap);
            CJRMoviePassCatalogModel cJRMoviePassCatalogModel2 = this.f75459d;
            if (cJRMoviePassCatalogModel2 == null) {
                k.a();
            }
            HashMap<String, CJRMoviePassRedeemInstructionModel> moviePassRedeemInstructionMap = cJRMoviePassCatalogModel2.getMoviePassRedeemInstructionMap();
            if (!(moviePassRedeemInstructionMap instanceof Serializable)) {
                moviePassRedeemInstructionMap = null;
            }
            intent.putExtra("mp_redeem_instructions", moviePassRedeemInstructionMap);
            CJRMoviePassCatalogModel cJRMoviePassCatalogModel3 = this.f75459d;
            if (cJRMoviePassCatalogModel3 == null) {
                k.a();
            }
            Map<String, CJRMoviePassTncInstructionModel> moviePassTnCInstructionMap = cJRMoviePassCatalogModel3.getMoviePassTnCInstructionMap();
            if (!(moviePassTnCInstructionMap instanceof Serializable)) {
                moviePassTnCInstructionMap = null;
            }
            intent.putExtra("mp_tnc_instructions", (Serializable) moviePassTnCInstructionMap);
            if (view == null || Build.VERSION.SDK_INT < 21) {
                startActivity(intent);
                return;
            }
            androidx.core.app.b a2 = androidx.core.app.b.a(this, view, getString(R.string.movie_pass_detail_transition_name));
            k.a((Object) a2, "ActivityOptionsCompat.ma…_detail_transition_name))");
            startActivity(intent, a2.a());
            return;
        }
        throw new u("null cannot be cast to non-null type android.os.Parcelable");
    }
}
