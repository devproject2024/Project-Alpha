package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.f;
import com.paytm.b.a.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.i;
import net.one97.paytm.o2o.movies.adapter.k;
import net.one97.paytm.o2o.movies.common.movies.search.CJRCinemaV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRIMAXDifferenceModel;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieDetailsV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesV2;
import net.one97.paytm.o2o.movies.utils.j;
import net.one97.paytm.o2o.movies.utils.x;

public class AJRIMAXCinemasPage extends AppBaseActivity implements View.OnClickListener, b, k.a {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressBar f73993a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f73994b;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public String f73995c;
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f73996d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJRSelectCityModel f73997e = null;

    /* renamed from: f  reason: collision with root package name */
    private CJRMovieDetailsV2 f73998f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f73999g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TabLayout f74000h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f74001i;
    private ViewPager j;
    private CirclePageIndicator k;
    private CirclePageIndicator l;
    private RecyclerView m;
    private ViewPager n;
    private RelativeLayout o;
    private ArrayList<String> p;
    /* access modifiers changed from: private */
    public ImageView q;
    private RelativeLayout r;
    /* access modifiers changed from: private */
    public ArrayList<CJRIMAXDifferenceModel> s;
    private NestedScrollView t;
    private boolean u = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_imax_cinemas);
        this.f73993a = (ProgressBar) findViewById(R.id.imax_progress_bar);
        this.f74001i = (ImageView) findViewById(R.id.imax_back_arrow);
        this.f74000h = (TabLayout) findViewById(R.id.imax_cities_tabs);
        this.f73999g = (LinearLayout) findViewById(R.id.imax_parent_lyt_container);
        this.f73999g.setVisibility(8);
        this.j = (ViewPager) findViewById(R.id.view_pager_imax_movies);
        this.k = (CirclePageIndicator) findViewById(R.id.imax_movies_page_indicator);
        this.m = (RecyclerView) findViewById(R.id.imax_cinema_recycler);
        this.n = (ViewPager) findViewById(R.id.view_pager_imax_difference);
        this.l = (CirclePageIndicator) findViewById(R.id.imax_difference_page_indicator);
        this.o = (RelativeLayout) findViewById(R.id.goto_paytm_movies);
        this.f73994b = (TextView) findViewById(R.id.imax_difference_content);
        this.q = (ImageView) findViewById(R.id.up_down_differences_imax);
        this.r = (RelativeLayout) findViewById(R.id.imax_movies_unavailable);
        this.t = (NestedScrollView) findViewById(R.id.imax_scroll_view);
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (AJRIMAXCinemasPage.this.f73994b != null && !TextUtils.isEmpty(AJRIMAXCinemasPage.this.f73995c)) {
                    if (AJRIMAXCinemasPage.this.f73996d) {
                        boolean unused = AJRIMAXCinemasPage.this.f73996d = false;
                        AJRIMAXCinemasPage.this.f73994b.setText(AJRIMAXCinemasPage.this.f73995c);
                        AJRIMAXCinemasPage.this.q.setImageDrawable(androidx.core.content.b.a((Context) AJRIMAXCinemasPage.this, net.one97.paytm.common.assets.R.drawable.up));
                        return;
                    }
                    boolean unused2 = AJRIMAXCinemasPage.this.f73996d = true;
                    if (AJRIMAXCinemasPage.this.f73995c.length() > 100) {
                        AJRIMAXCinemasPage.this.f73994b.setText(AJRIMAXCinemasPage.this.f73995c.substring(0, 100));
                    }
                    AJRIMAXCinemasPage.this.q.setImageDrawable(androidx.core.content.b.a((Context) AJRIMAXCinemasPage.this, net.one97.paytm.common.assets.R.drawable.down));
                }
            }
        });
        this.f74001i.setOnClickListener(this);
        this.o.setOnClickListener(this);
        a("MUMBAI", "MUMBAI");
        a("MUMBAI");
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.f73997e == null) {
            this.f73997e = new CJRSelectCityModel();
        }
        this.f73997e.setlabel(str);
        this.f73997e.setValue(str2);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        d();
        j.a((Context) this, str, (b) this);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRMovieDetailsV2) {
            try {
                this.f73998f = (CJRMovieDetailsV2) iJRPaytmDataModel;
                if (this.f73998f != null) {
                    e();
                    if (this.f73998f == null || this.f73998f.getIMAXDifference() == null || this.f73998f.getIMAXDifference().size() <= 0) {
                        this.n.setVisibility(8);
                    } else {
                        AnonymousClass2 r5 = new ViewPager.h() {
                            public final void onPageSelected(int i2) {
                                if (AJRIMAXCinemasPage.this.s != null && AJRIMAXCinemasPage.this.s.size() > 0) {
                                    AJRIMAXCinemasPage aJRIMAXCinemasPage = AJRIMAXCinemasPage.this;
                                    String differenceContent = ((CJRIMAXDifferenceModel) aJRIMAXCinemasPage.s.get(i2)).getDifferenceContent();
                                    if (!TextUtils.isEmpty(differenceContent)) {
                                        aJRIMAXCinemasPage.f73995c = differenceContent;
                                        if (!aJRIMAXCinemasPage.f73996d || aJRIMAXCinemasPage.f73995c.length() <= 100) {
                                            aJRIMAXCinemasPage.f73994b.setText(aJRIMAXCinemasPage.f73995c);
                                            return;
                                        }
                                        TextView textView = aJRIMAXCinemasPage.f73994b;
                                        textView.setText(aJRIMAXCinemasPage.f73995c.substring(0, 100) + AppConstants.DOTS);
                                    }
                                }
                            }
                        };
                        if (this.s == null) {
                            this.s = new ArrayList<>();
                        }
                        this.s.clear();
                        this.s.addAll(this.f73998f.getIMAXDifference());
                        this.n.addOnPageChangeListener(r5);
                        this.n.setAdapter(new net.one97.paytm.o2o.movies.adapter.j(this, this.s, this.j));
                        this.l.setViewPager(this.n);
                        r5.onPageSelected(0);
                    }
                    if (!this.u) {
                        this.u = true;
                        c();
                    }
                    b();
                    a();
                    this.f73999g.setVisibility(0);
                    this.t.a(33);
                    return;
                }
                com.paytm.utility.b.b((Context) this, "Error", "Unable to fetch data");
            } catch (Exception unused) {
                e();
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        e();
        if (TextUtils.isEmpty(networkCustomError.getAlertTitle()) || TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
            com.paytm.utility.b.b((Context) this, "Error", "Not able to download IMAX information");
        } else {
            com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    private void a() {
        CJRMovieDetailsV2 cJRMovieDetailsV2 = this.f73998f;
        if (cJRMovieDetailsV2 == null || cJRMovieDetailsV2.getMovies() == null || this.f73998f.getMovies().size() <= 0) {
            this.j.setVisibility(8);
            this.r.setVisibility(0);
            ((TextView) findViewById(R.id.imax_unavailable_City)).setText(String.format(getString(R.string.imax_movie_unavailable), new Object[]{this.f73997e.getLabel()}));
            return;
        }
        this.j.setVisibility(0);
        this.r.setVisibility(8);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, CJRMoviesV2> value : this.f73998f.getMovies().entrySet()) {
            arrayList.add(value.getValue());
        }
        if (arrayList.size() > 0) {
            k kVar = new k(this, arrayList, this.j);
            kVar.f74664c = this;
            this.j.setAdapter(kVar);
            this.k.setViewPager(this.j);
        }
    }

    private void b() {
        CJRMovieDetailsV2 cJRMovieDetailsV2 = this.f73998f;
        if (cJRMovieDetailsV2 == null || cJRMovieDetailsV2.getCinemas() == null || this.f73998f.getCinemas().size() <= 0) {
            this.m.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, CJRCinemaV2> value : this.f73998f.getCinemas().entrySet()) {
            arrayList.add(value.getValue());
        }
        if (arrayList.size() > 0) {
            i iVar = new i(this, arrayList);
            this.m.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.m.setNestedScrollingEnabled(false);
            this.m.setAdapter(iVar);
            iVar.notifyDataSetChanged();
        }
    }

    private void d() {
        ProgressBar progressBar = this.f73993a;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    private void e() {
        ProgressBar progressBar = this.f73993a;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imax_back_arrow) {
            finish();
        } else if (id == R.id.goto_paytm_movies) {
            Intent intent = new Intent(this, MoviesHomeActivity.class);
            intent.putExtra("extra_url_type", "movietickets");
            startActivity(intent);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
        }
    }

    public final void a(IJRDataModel iJRDataModel) {
        if (iJRDataModel instanceof CJRMoviesV2) {
            CJRMoviesV2 cJRMoviesV2 = (CJRMoviesV2) iJRDataModel;
            net.one97.paytm.o2o.movies.utils.i.a().f75937g = null;
            Intent intent = new Intent(this, AJRMovieDetailsV2Activity.class);
            intent.putExtra("movie_ticket_city_selected", this.f73997e.getLabel());
            intent.putExtra("movie_ticket_selected_item_type", "movie");
            intent.putExtra("movie_ticket_selected_item_value", cJRMoviesV2.getCode());
            intent.putExtra("movie_ticket_other_screen_formats", new f().b(cJRMoviesV2.getScreenFormatAndMovieCodeMap()));
            startActivity(intent);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
            new StringBuilder("------Movie Selected----  ").append(cJRMoviesV2.getTitle());
            com.paytm.utility.b.j();
        }
    }

    private void c() {
        a a2 = x.a(getApplicationContext());
        String b2 = a2.b("movies_cached_city_name", "", false);
        String b3 = a2.b("movies_cached_city_value", "", false);
        if (b2 == "" && b3 == "") {
            b3 = "MUMBAI";
            b2 = b3;
        }
        if (b3 != "" && (b3.trim().equalsIgnoreCase("delhi-ncr") || b3.trim().equalsIgnoreCase("noida") || b3.trim().equalsIgnoreCase("gurgaon") || b3.trim().equalsIgnoreCase("delhi"))) {
            b3 = "DELHI/NCR";
        }
        if (this.f73998f.getIMAXCities() != null) {
            Iterator<String> it2 = this.f73998f.getIMAXCities().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (b3 != "") {
                    if (b3.trim().equalsIgnoreCase(next.trim())) {
                        a(b2, b3);
                        break;
                    }
                    a("MUMBAI", "MUMBAI");
                }
            }
        }
        this.p = new ArrayList<>();
        CJRMovieDetailsV2 cJRMovieDetailsV2 = this.f73998f;
        if (cJRMovieDetailsV2 == null || cJRMovieDetailsV2.getIMAXCities() == null || this.f73998f.getIMAXCities().size() <= 0) {
            this.p.add("MUMBAI");
        } else {
            Iterator<String> it3 = this.f73998f.getIMAXCities().iterator();
            while (it3.hasNext()) {
                this.p.add(it3.next().toUpperCase());
            }
        }
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            String str = this.p.get(i2);
            String label = this.f73997e.getLabel();
            if (label.toUpperCase().contains("NOIDA") || label.toUpperCase().contains("GURGAON") || label.toUpperCase().contains("DELHI")) {
                label = "DELHI/NCR";
            }
            if (label.equalsIgnoreCase(str)) {
                TabLayout tabLayout = this.f74000h;
                tabLayout.a(tabLayout.a().a((CharSequence) str), true);
            } else {
                TabLayout tabLayout2 = this.f74000h;
                tabLayout2.a(tabLayout2.a().a((CharSequence) str), false);
            }
        }
        this.f74000h.setSelectedTabIndicatorColor(androidx.core.content.b.c(this, R.color.color_00b9f5));
        this.f74000h.setSelectedTabIndicatorHeight((int) (getResources().getDisplayMetrics().density * 2.0f));
        this.f74000h.setTabTextColors(androidx.core.content.b.c(this, net.one97.paytm.common.assets.R.color.color_666666), androidx.core.content.b.c(this, R.color.color_00b9f5));
        if (this.p.size() >= 4) {
            this.f74000h.setTabMode(0);
        } else {
            this.f74000h.setTabMode(1);
        }
        this.f74000h.setTabGravity(0);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (AJRIMAXCinemasPage.this.f74000h.a(AJRIMAXCinemasPage.this.f74000h.getSelectedTabPosition()) != null) {
                    AJRIMAXCinemasPage.this.f74000h.a(AJRIMAXCinemasPage.this.f74000h.getSelectedTabPosition()).d();
                    if (AJRIMAXCinemasPage.this.f73997e.getValue() != null && !AJRIMAXCinemasPage.this.f73997e.getValue().equalsIgnoreCase("MUMBAI")) {
                        AJRIMAXCinemasPage aJRIMAXCinemasPage = AJRIMAXCinemasPage.this;
                        aJRIMAXCinemasPage.a(aJRIMAXCinemasPage.f73997e.getValue());
                    }
                }
            }
        }, 100);
        this.f74000h.a((TabLayout.b) new TabLayout.c() {
            public final void onTabReselected(TabLayout.f fVar) {
            }

            public final void onTabUnselected(TabLayout.f fVar) {
            }

            public final void onTabSelected(TabLayout.f fVar) {
                AJRIMAXCinemasPage.this.f73999g.setVisibility(8);
                String charSequence = fVar.f36763c.toString();
                AJRIMAXCinemasPage.this.a(charSequence, charSequence);
                AJRIMAXCinemasPage.this.a(charSequence);
            }
        });
    }
}
