package net.one97.paytm.o2o.movies.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.o;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies;
import net.one97.paytm.common.entity.movies.search.CJRUpcomingMoviesInfo;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.dynamic.module.movie.deeplink.MovieDeeplinkFunctions;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.common.movies.CJRMovieUpvoteResponse;
import net.one97.paytm.o2o.movies.common.movies.CJRUpcomingMovieFilterData;
import net.one97.paytm.o2o.movies.common.movies.CJRUpcomingMovieReleaseDate;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieLanguages;
import net.one97.paytm.o2o.movies.common.movies.search.GroupFormatObject;
import net.one97.paytm.o2o.movies.entity.ComingSoonMovie;
import net.one97.paytm.o2o.movies.utils.j;
import net.one97.paytm.o2o.movies.utils.n;

public class AJRUpcomingMoviesGridPage extends AppBaseActivity implements TextWatcher, View.OnClickListener, com.paytm.network.listener.b, aj.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f74137a = AJRUpcomingMoviesGridPage.class.getSimpleName();
    private ProgressBar A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public int D;
    /* access modifiers changed from: private */
    public int E;
    private o F;
    /* access modifiers changed from: private */
    public String G;
    /* access modifiers changed from: private */
    public String H;
    private boolean I;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b f74138b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f74139c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f74140d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public CJRUpcomingMovies f74141e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f74142f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f74143g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f74144h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<CJRMovieLanguages> f74145i;
    /* access modifiers changed from: private */
    public ArrayList<CJRMovieLanguages> j;
    /* access modifiers changed from: private */
    public ArrayList<CJRUpcomingMovieReleaseDate> k;
    /* access modifiers changed from: private */
    public ComingSoonMovie l = new ComingSoonMovie();
    /* access modifiers changed from: private */
    public ArrayList<CJRUpcomingMoviesInfo> m;
    private CJRUpcomingMovieFilterData n;
    /* access modifiers changed from: private */
    public aj o;
    private LinearLayout p;
    private TextView q;
    private String r;
    /* access modifiers changed from: private */
    public LinearLayout s;
    /* access modifiers changed from: private */
    public RelativeLayout t;
    private TextView u;
    private TextView v;
    private TextView w;
    /* access modifiers changed from: private */
    public View x;
    private String[] y = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private HashMap<String, String> z = new HashMap<>();

    public final void a(String str, com.paytm.network.listener.b bVar) {
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    private static WindowManager.LayoutParams a(Dialog dialog) {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            try {
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                return layoutParams;
            } catch (Exception unused) {
                return layoutParams;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.upcoming_movies_grid_page);
        Intent intent = getIntent();
        boolean z2 = false;
        if (intent != null) {
            try {
                if (intent.hasExtra(getString(R.string.upcoming_movies))) {
                    this.f74141e = (CJRUpcomingMovies) intent.getSerializableExtra(getString(R.string.upcoming_movies));
                    if (this.f74141e != null) {
                        this.m = (ArrayList) this.f74141e.getUpcomingMovieData();
                        this.f74139c = new a();
                        this.f74139c.execute(new Void[0]);
                    }
                    a();
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendOpenScreenWithDeviceInfo("/movies/upcoming", "movies", this);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.c(e2.getMessage());
                }
            }
        }
        this.C = true;
        i();
        if (intent != null && intent.hasExtra("extra_home_data")) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data");
            if (cJRHomePageItem.getURL() != null) {
                Uri parse = Uri.parse(cJRHomePageItem.getURL());
                if (parse.getQuery().contains("list")) {
                    this.I = true;
                    this.G = parse.getQueryParameter(MovieDeeplinkFunctions.FILTER_ITEM_1);
                    this.H = parse.getQueryParameter(MovieDeeplinkFunctions.FILTER_ITEM_2);
                    if (TextUtils.isEmpty(d.b((Context) this))) {
                        d();
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        j.b((Context) this, (com.paytm.network.listener.b) this);
                    }
                } else {
                    this.G = parse.getQueryParameter("filter_params");
                    j.a((Context) this, (com.paytm.network.listener.b) this);
                }
            }
        }
        a();
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendOpenScreenWithDeviceInfo("/movies/upcoming", "movies", this);
    }

    public final void a(String str) {
        Intent a2 = AJRUpcomingMoviesActivity.a((Context) this, str, (String) null);
        if (a2 != null) {
            startActivityForResult(a2, 3);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
            return;
        }
        Toast.makeText(this, R.string.error_something_went_wrong, 0).show();
    }

    public void onBackPressed() {
        c();
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f74140d = (RecyclerView) findViewById(R.id.upcoming_movies_grid_recycler);
        this.f74142f = (ImageView) findViewById(R.id.upcoming_movies_back);
        this.f74143g = (LinearLayout) findViewById(R.id.upcoming_movies_filter);
        this.f74144h = (EditText) findViewById(R.id.upcoming_movies_serach);
        this.p = (LinearLayout) findViewById(R.id.no_suggestion_lyt);
        this.q = (TextView) findViewById(R.id.error_text_quote);
        this.s = (LinearLayout) findViewById(R.id.upcoming_movies_container);
        this.t = (RelativeLayout) findViewById(R.id.no_upcoming_movies_lyt);
        this.u = (TextView) findViewById(R.id.upcoming_change_filters);
        this.v = (TextView) findViewById(R.id.upcoming_clear_filters);
        this.x = findViewById(R.id.upcoming_filter_applied);
        this.A = (ProgressBar) findViewById(R.id.movie_grid_page_progress_bar);
        this.w = (TextView) findViewById(R.id.title);
        b();
        this.f74143g.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.f74144h.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                n.b((View) textView);
                return false;
            }
        });
    }

    private void b() {
        if (this.I) {
            this.w.setText(R.string.movie);
        } else {
            this.w.setText(R.string.upcoming_movies);
        }
        this.f74142f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRUpcomingMoviesGridPage.this.c();
            }
        });
        this.f74144h.addTextChangedListener(this);
        ArrayList<CJRUpcomingMoviesInfo> arrayList = this.m;
        if (arrayList != null && arrayList.size() > 0) {
            this.f74140d.setLayoutManager(new GridLayoutManager(this, 2));
            this.f74140d.setHasFixedSize(true);
            this.o = new aj(this.f74141e, this.I ? 4 : 3, this, this);
            o oVar = this.F;
            if (oVar != null) {
                this.o.a(oVar);
            }
            this.f74140d.setAdapter(this.o);
            this.D = com.paytm.utility.b.f((Context) this) / 2;
            this.E = this.D >> 1;
            this.f74140d.addItemDecoration(new RecyclerView.h() {
                public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    super.getItemOffsets(rect, view, recyclerView, sVar);
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    rect.top = AJRUpcomingMoviesGridPage.this.D;
                    if (childAdapterPosition % 2 == 0) {
                        rect.left = AJRUpcomingMoviesGridPage.this.D;
                        rect.right = AJRUpcomingMoviesGridPage.this.E;
                        return;
                    }
                    rect.right = AJRUpcomingMoviesGridPage.this.D;
                    rect.left = AJRUpcomingMoviesGridPage.this.E;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.C) {
            Intent intent = new Intent(this, MoviesHomeActivity.class);
            intent.putExtra("extra_url_type", "movietickets");
            startActivity(intent);
        }
        finish();
    }

    private void d() {
        Intent intent = new Intent(this, AJRMoviesSelectCityActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("sourcename", "movietickets");
        startActivityForResult(intent, 4);
        overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }

    private void a(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        String str;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.O);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.t);
            int i2 = 0;
            String str2 = "";
            if (!arrayList.isEmpty()) {
                Iterator<String> it2 = arrayList.iterator();
                String str3 = str2;
                int i3 = 0;
                while (it2.hasNext()) {
                    str3 = str3 + it2.next();
                    if (i3 < arrayList.size() - 1) {
                        str3 = str3 + AppConstants.COMMA;
                    }
                    i3++;
                }
                str = str2 + "language_" + str3;
            } else {
                str = str2;
            }
            if (!arrayList2.isEmpty()) {
                Iterator<String> it3 = arrayList2.iterator();
                String str4 = str2;
                int i4 = 0;
                while (it3.hasNext()) {
                    str4 = str4 + it3.next();
                    if (i4 < arrayList2.size() - 1) {
                        str4 = str4 + AppConstants.COMMA;
                    }
                    i4++;
                }
                if (!TextUtils.isEmpty(str) && str.length() > 0) {
                    str = str + "/";
                }
                str = str + "genre_" + str4;
            }
            if (!arrayList3.isEmpty()) {
                Iterator<String> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    String str5 = str2 + it4.next();
                    if (i2 < arrayList3.size() - 1) {
                        str5 = str5 + AppConstants.COMMA;
                    }
                    str2 = str5;
                    i2++;
                }
                if (!TextUtils.isEmpty(str) && str.length() > 0) {
                    str = str + "/";
                }
                str = str + "release_date_" + str2;
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "apply_button_clicked");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    public final void c(boolean z2) {
        if (z2) {
            this.p.setVisibility(0);
            this.f74140d.setVisibility(8);
            return;
        }
        this.p.setVisibility(8);
        this.f74140d.setVisibility(0);
    }

    public void onPause() {
        super.onPause();
        b bVar = this.f74138b;
        if (bVar == null || !(bVar.getStatus() == AsyncTask.Status.RUNNING || this.f74138b.getStatus() == AsyncTask.Status.PENDING)) {
            a aVar = this.f74139c;
            if (aVar == null) {
                return;
            }
            if (aVar.getStatus() == AsyncTask.Status.RUNNING || this.f74139c.getStatus() == AsyncTask.Status.PENDING) {
                this.f74139c.cancel(true);
                return;
            }
            return;
        }
        this.f74138b.cancel(true);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            return;
        }
        if (i2 == 1 && intent != null) {
            this.f74144h.setText("");
            if (intent.hasExtra("upcoming_filter_result")) {
                this.n = (CJRUpcomingMovieFilterData) intent.getSerializableExtra("upcoming_filter_result");
            }
            if (intent.getBooleanExtra("clear_all", false)) {
                e();
                f();
                return;
            }
            CJRUpcomingMovieFilterData cJRUpcomingMovieFilterData = this.n;
            if (cJRUpcomingMovieFilterData != null) {
                this.f74138b = new b(cJRUpcomingMovieFilterData.getmLanguageList(), this.n.getmGenreList(), this.n.getmReleaseDateList(), this.n.getComingSoonMovie());
                this.f74138b.execute(new Void[0]);
                return;
            }
            this.x.setVisibility(8);
            this.s.setVisibility(0);
            this.o.a(this.m);
            findViewById(R.id.upcoming_movies_nestedscroll).scrollTo(0, 0);
        } else if (i2 == 101) {
            String str = this.r;
            this.r = str;
            if (com.paytm.utility.b.r((Context) this)) {
                i();
                j.a(this, str, this, "", "");
                return;
            }
            startActivityForResult(new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), 101);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
        } else if (i2 == 3) {
            if (this.C) {
                Intent intent2 = new Intent(this, MoviesHomeActivity.class);
                intent2.putExtra("extra_url_type", "movietickets");
                startActivity(intent2);
            } else {
                setResult(-1);
            }
            finish();
        } else if (i2 == 4) {
            if (intent != null) {
                try {
                    if (intent.hasExtra("userselectedcity")) {
                        CJRSelectCityModel cJRSelectCityModel = (CJRSelectCityModel) intent.getSerializableExtra("userselectedcity");
                        if (!(cJRSelectCityModel == null || cJRSelectCityModel.getValue() == null)) {
                            d.a((Context) this, cJRSelectCityModel, "movies");
                        }
                        j.b((Context) this, (com.paytm.network.listener.b) this);
                        return;
                    }
                } catch (Exception e2) {
                    k.c(e2, "exception");
                    return;
                }
            }
            if (!isFinishing()) {
                h hVar = new h(this);
                hVar.setTitle("Required");
                hVar.a("Please Choose your Location");
                hVar.setCancelable(false);
                WindowManager.LayoutParams a2 = a((Dialog) hVar);
                hVar.a(-3, getString(R.string.ok), new View.OnClickListener(hVar) {
                    private final /* synthetic */ h f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        AJRUpcomingMoviesGridPage.this.b(this.f$1, view);
                    }
                });
                hVar.show();
                if (a2 != null) {
                    hVar.getWindow().setAttributes(a2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(h hVar, View view) {
        hVar.cancel();
        d();
        finish();
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.O);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.t);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "clear_all_button_clicked");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        this.B = false;
        g();
        this.x.setVisibility(8);
        this.t.setVisibility(8);
        this.s.setVisibility(0);
        this.n = null;
        if (this.o != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((ArrayList) this.m.clone());
            this.o.a((ArrayList<CJRUpcomingMoviesInfo>) arrayList);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.upcoming_movies_filter || id == R.id.upcoming_change_filters) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.o2o.movies.common.b.b.O);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.t);
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "filter_icon_clicked");
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
                if (com.paytm.utility.b.r((Context) this)) {
                    hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
                }
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
            } catch (Exception unused) {
            }
            Intent intent = new Intent(this, AJRUpcomingMovieFilter.class);
            if (this.n == null) {
                this.n = new CJRUpcomingMovieFilterData();
                this.n.setmLanguageList(this.f74145i);
                this.n.setmGenreList(this.j);
                this.n.setmReleaseDateList(this.k);
                this.n.setComingSoonMovie(this.l);
            }
            intent.putExtra("upcoming_filter_data", this.n);
            startActivityForResult(intent, 1);
        } else if (id == R.id.upcoming_clear_filters) {
            f();
        }
    }

    private void g() {
        this.x.setVisibility(8);
        ArrayList<CJRMovieLanguages> arrayList = this.f74145i;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.f74145i.size(); i2++) {
                this.f74145i.get(i2).setIsSelected(false);
            }
        }
        ArrayList<CJRMovieLanguages> arrayList2 = this.j;
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                this.j.get(i3).setIsSelected(false);
            }
        }
        ArrayList<CJRUpcomingMovieReleaseDate> arrayList3 = this.k;
        if (arrayList3 != null && arrayList3.size() > 0) {
            for (int i4 = 0; i4 < this.k.size(); i4++) {
                ArrayList<CJRMovieLanguages> releaseMonths = this.k.get(i4).getReleaseMonths();
                for (int i5 = 0; i5 < releaseMonths.size(); i5++) {
                    releaseMonths.get(i5).setIsSelected(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        ProgressBar progressBar = this.A;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        ProgressBar progressBar = this.A;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        h();
        if (iJRPaytmDataModel instanceof CJRMovieUpvoteResponse) {
            CJRMovieUpvoteResponse cJRMovieUpvoteResponse = (CJRMovieUpvoteResponse) iJRPaytmDataModel;
            if (cJRMovieUpvoteResponse == null) {
                return;
            }
            if (cJRMovieUpvoteResponse.getmStatus().equalsIgnoreCase("SUCCESS")) {
                for (int i2 = 0; i2 < this.m.size(); i2++) {
                    if (this.m.get(i2).getPaytmMovieCode().equalsIgnoreCase(this.r)) {
                        this.m.get(i2).setInterested(true);
                    }
                }
                aj ajVar = this.o;
                if (ajVar != null) {
                    ajVar.a(this.m);
                    return;
                }
                return;
            }
            com.paytm.utility.b.b((Context) this, "Error", cJRMovieUpvoteResponse.getmErrorMessage());
        } else if (iJRPaytmDataModel instanceof CJRUpcomingMovies) {
            this.f74141e = (CJRUpcomingMovies) iJRPaytmDataModel;
            CJRUpcomingMovies cJRUpcomingMovies = this.f74141e;
            if (cJRUpcomingMovies == null || cJRUpcomingMovies.getUpcomingMovieData() == null || this.f74141e.getUpcomingMovieData().size() <= 0) {
                j();
                return;
            }
            this.m = (ArrayList) this.f74141e.getUpcomingMovieData();
            this.f74139c = new a();
            this.f74139c.execute(new Void[0]);
            a();
        } else if (iJRPaytmDataModel instanceof CJRMovieHomeDataResponse) {
            CJRMovieHomeDataResponse cJRMovieHomeDataResponse = (CJRMovieHomeDataResponse) iJRPaytmDataModel;
            if (cJRMovieHomeDataResponse.getData().getMovies() == null || cJRMovieHomeDataResponse.getData().getMovies().size() <= 0) {
                j();
                return;
            }
            ArrayList<CJRMovieHomeListItem> movies = cJRMovieHomeDataResponse.getData().getMovies();
            ArrayList arrayList = new ArrayList();
            if (movies != null) {
                Iterator<CJRMovieHomeListItem> it2 = movies.iterator();
                while (it2.hasNext()) {
                    CJRMovieHomeListItem next = it2.next();
                    if (!arrayList.contains(next)) {
                        if (next.getScrnFmtList() == null) {
                            next.setScrnFmtList(new ArrayList());
                            next.getScrnFmtList().add(new GroupFormatObject(next.getId(), next.getScrnFmt()));
                        }
                        arrayList.add(next);
                    } else {
                        CJRMovieHomeListItem cJRMovieHomeListItem = (CJRMovieHomeListItem) arrayList.get(arrayList.indexOf(next));
                        cJRMovieHomeListItem.setTotalSessionCount(cJRMovieHomeListItem.getTotalSessionCount() + next.getTotalSessionCount());
                        GroupFormatObject groupFormatObject = new GroupFormatObject(next.getId(), next.getScrnFmt());
                        if (cJRMovieHomeListItem.getScrnFmtList() != null && !cJRMovieHomeListItem.getScrnFmtList().contains(groupFormatObject)) {
                            cJRMovieHomeListItem.getScrnFmtList().add(groupFormatObject);
                        }
                    }
                }
                cJRMovieHomeDataResponse.getData().setMovies(arrayList);
            }
            p.fromIterable(cJRMovieHomeDataResponse.getData().getMovies()).map(new io.reactivex.rxjava3.d.h() {
                public final Object apply(Object obj) {
                    return AJRUpcomingMoviesGridPage.this.a((CJRMovieHomeListItem) obj);
                }
            }).toList().b(io.reactivex.rxjava3.i.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).a(new aa<List<CJRUpcomingMoviesInfo>>() {
                public final /* synthetic */ void onSuccess(Object obj) {
                    AJRUpcomingMoviesGridPage.this.h();
                    ArrayList unused = AJRUpcomingMoviesGridPage.this.m = (ArrayList) ((List) obj);
                    CJRUpcomingMovies unused2 = AJRUpcomingMoviesGridPage.this.f74141e = new CJRUpcomingMovies();
                    AJRUpcomingMoviesGridPage.this.f74141e.setUpcomingMovieData(AJRUpcomingMoviesGridPage.this.m);
                    AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage = AJRUpcomingMoviesGridPage.this;
                    a unused3 = aJRUpcomingMoviesGridPage.f74139c = new a();
                    AJRUpcomingMoviesGridPage.this.f74139c.execute(new Void[0]);
                    AJRUpcomingMoviesGridPage.this.a();
                }

                public final void onSubscribe(c cVar) {
                    AJRUpcomingMoviesGridPage.this.i();
                }

                public final void onError(Throwable th) {
                    AJRUpcomingMoviesGridPage.this.h();
                    AJRUpcomingMoviesGridPage.this.j();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public CJRUpcomingMoviesInfo a(CJRMovieHomeListItem cJRMovieHomeListItem) {
        CJRUpcomingMoviesInfo cJRUpcomingMoviesInfo = new CJRUpcomingMoviesInfo();
        cJRUpcomingMoviesInfo.setGenre(cJRMovieHomeListItem.getGrn());
        cJRUpcomingMoviesInfo.setLanguage(cJRMovieHomeListItem.getLang());
        cJRUpcomingMoviesInfo.setMovieTitle(cJRMovieHomeListItem.getLabel());
        cJRUpcomingMoviesInfo.setMoviePosterUrl(cJRMovieHomeListItem.getImgPath());
        if (cJRMovieHomeListItem.getId() != null) {
            cJRUpcomingMoviesInfo.setIsContentAvailable(1);
            cJRUpcomingMoviesInfo.setPaytmMovieCode(String.valueOf(cJRMovieHomeListItem.getId()));
        }
        return cJRUpcomingMoviesInfo;
    }

    /* access modifiers changed from: private */
    public void j() {
        if (!isFinishing()) {
            h hVar = new h(this);
            hVar.setTitle(getResources().getString(R.string.error));
            hVar.a(getString(R.string.no_upcoming_movies));
            hVar.setCancelable(false);
            WindowManager.LayoutParams a2 = a((Dialog) hVar);
            hVar.a(-3, getString(R.string.ok), new View.OnClickListener(hVar) {
                private final /* synthetic */ h f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    AJRUpcomingMoviesGridPage.this.a(this.f$1, view);
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(h hVar, View view) {
        hVar.cancel();
        finish();
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        h();
        if (networkCustomError == null || TextUtils.isEmpty(networkCustomError.getAlertTitle()) || TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getString(R.string.something_wrong_try_again));
        } else {
            com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
        }
    }

    class b extends AsyncTask<Void, Void, ArrayList<CJRUpcomingMoviesInfo>> {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<CJRMovieLanguages> f74151a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<CJRMovieLanguages> f74152b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<CJRUpcomingMovieReleaseDate> f74153c;

        /* renamed from: d  reason: collision with root package name */
        ComingSoonMovie f74154d;

        public final /* synthetic */ void onPostExecute(Object obj) {
            ArrayList arrayList = (ArrayList) obj;
            if (!AJRUpcomingMoviesGridPage.this.B) {
                if (arrayList == null || arrayList.size() <= 0) {
                    AJRUpcomingMoviesGridPage.p(AJRUpcomingMoviesGridPage.this);
                } else {
                    AJRUpcomingMoviesGridPage.this.t.setVisibility(8);
                    AJRUpcomingMoviesGridPage.this.s.setVisibility(0);
                    AJRUpcomingMoviesGridPage.this.x.setVisibility(0);
                    AJRUpcomingMoviesGridPage.this.o.a((ArrayList<CJRUpcomingMoviesInfo>) arrayList);
                }
                AJRUpcomingMoviesGridPage.this.x.setVisibility(0);
            } else {
                AJRUpcomingMoviesGridPage.this.e();
                AJRUpcomingMoviesGridPage.this.f();
            }
            AJRUpcomingMoviesGridPage.this.findViewById(R.id.upcoming_movies_nestedscroll).scrollTo(0, 0);
        }

        public b(ArrayList<CJRMovieLanguages> arrayList, ArrayList<CJRMovieLanguages> arrayList2, ArrayList<CJRUpcomingMovieReleaseDate> arrayList3, ComingSoonMovie comingSoonMovie) {
            this.f74151a = arrayList;
            this.f74152b = arrayList2;
            this.f74153c = arrayList3;
            this.f74154d = comingSoonMovie;
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            super.onCancelled();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return AJRUpcomingMoviesGridPage.a(AJRUpcomingMoviesGridPage.this, this.f74151a, this.f74152b, this.f74153c, this.f74154d);
        }
    }

    class a extends AsyncTask<Void, Void, Void> {
        a() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (AJRUpcomingMoviesGridPage.this.C) {
                AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage = AJRUpcomingMoviesGridPage.this;
                AJRUpcomingMoviesGridPage.a(aJRUpcomingMoviesGridPage, aJRUpcomingMoviesGridPage.G);
                AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage2 = AJRUpcomingMoviesGridPage.this;
                AJRUpcomingMoviesGridPage.a(aJRUpcomingMoviesGridPage2, aJRUpcomingMoviesGridPage2.H);
                AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage3 = AJRUpcomingMoviesGridPage.this;
                b unused = aJRUpcomingMoviesGridPage3.f74138b = new b(aJRUpcomingMoviesGridPage3.f74145i, AJRUpcomingMoviesGridPage.this.j, AJRUpcomingMoviesGridPage.this.k, AJRUpcomingMoviesGridPage.this.l);
                AJRUpcomingMoviesGridPage.this.f74138b.execute(new Void[0]);
            }
            AJRUpcomingMoviesGridPage.this.h();
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            AJRUpcomingMoviesGridPage.this.i();
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            super.onCancelled();
            AJRUpcomingMoviesGridPage.this.h();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AJRUpcomingMoviesGridPage.s(AJRUpcomingMoviesGridPage.this);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|(1:5)|6|(1:8)|9|10|11|(2:13|18)(1:19)) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007f, code lost:
        if (com.paytm.utility.b.v != false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
        com.paytm.utility.q.c(r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004a */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0072 A[Catch:{ Exception -> 0x007c }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(java.lang.CharSequence r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = "screenName"
            java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.O     // Catch:{ Exception -> 0x004a }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.t     // Catch:{ Exception -> 0x004a }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = "search_focus_in"
            r3.put(r4, r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x004a }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.d.b((android.content.Context) r1)     // Catch:{ Exception -> 0x004a }
            if (r4 == 0) goto L_0x0032
            boolean r5 = r4.isEmpty()     // Catch:{ Exception -> 0x004a }
            if (r5 != 0) goto L_0x0032
            java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x004a }
            r3.put(r5, r4)     // Catch:{ Exception -> 0x004a }
        L_0x0032:
            boolean r4 = com.paytm.utility.b.r((android.content.Context) r1)     // Catch:{ Exception -> 0x004a }
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r1)     // Catch:{ Exception -> 0x004a }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x004a }
        L_0x0041:
            net.one97.paytm.o2o.movies.common.c.b r4 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x004a }
            net.one97.paytm.o2o.movies.common.c.c r4 = r4.f75033b     // Catch:{ Exception -> 0x004a }
            java.lang.String r5 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x004a }
            r4.sendCustomEventWithMap(r5, r3, r1)     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            java.lang.String r4 = " '"
            r3.<init>(r4)     // Catch:{ Exception -> 0x007c }
            r3.append(r2)     // Catch:{ Exception -> 0x007c }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007c }
            int r4 = net.one97.paytm.o2o.movies.R.string.movies_err_msg     // Catch:{ Exception -> 0x007c }
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x007c }
            r0 = 0
            r5[r0] = r3     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = r1.getString(r4, r5)     // Catch:{ Exception -> 0x007c }
            android.widget.TextView r4 = r1.q     // Catch:{ Exception -> 0x007c }
            r4.setText(r3)     // Catch:{ Exception -> 0x007c }
            net.one97.paytm.o2o.movies.adapter.aj r3 = r1.o     // Catch:{ Exception -> 0x007c }
            if (r3 == 0) goto L_0x007b
            net.one97.paytm.o2o.movies.adapter.aj r3 = r1.o     // Catch:{ Exception -> 0x007c }
            android.widget.Filter r3 = r3.getFilter()     // Catch:{ Exception -> 0x007c }
            r3.filter(r2)     // Catch:{ Exception -> 0x007c }
        L_0x007b:
            return
        L_0x007c:
            r2 = move-exception
            boolean r3 = com.paytm.utility.b.v
            if (r3 == 0) goto L_0x0088
            java.lang.String r2 = r2.getMessage()
            com.paytm.utility.q.c(r2)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRUpcomingMoviesGridPage.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    static /* synthetic */ ArrayList a(AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ComingSoonMovie comingSoonMovie) {
        boolean z2;
        AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage2 = aJRUpcomingMoviesGridPage;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        ArrayList arrayList6 = arrayList3;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList<CJRUpcomingMoviesInfo> arrayList9 = aJRUpcomingMoviesGridPage2.m;
        if (arrayList9 != null) {
            arrayList8.addAll(arrayList9);
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        int i2 = 0;
        if (arrayList4 != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (((CJRMovieLanguages) arrayList4.get(i3)).getIsSelected()) {
                    hashSet.add(((CJRMovieLanguages) arrayList4.get(i3)).getLanguage());
                }
            }
            if (hashSet.size() > 0) {
                for (int i4 = 0; i4 < arrayList8.size(); i4++) {
                    if (hashSet.contains(((CJRUpcomingMoviesInfo) arrayList8.get(i4)).getLanguage())) {
                        arrayList7.add(arrayList8.get(i4));
                    }
                }
                arrayList8.clear();
                arrayList8.addAll(arrayList7);
                arrayList7.clear();
            }
        }
        if (arrayList5 != null && arrayList2.size() > 0) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                if (((CJRMovieLanguages) arrayList5.get(i5)).getIsSelected()) {
                    hashSet2.add(((CJRMovieLanguages) arrayList5.get(i5)).getLanguage());
                }
            }
            if (hashSet2.size() > 0) {
                for (int i6 = 0; i6 < arrayList8.size(); i6++) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= ((CJRUpcomingMoviesInfo) arrayList8.get(i6)).getGenre().size()) {
                            z2 = false;
                            break;
                        } else if (hashSet2.contains(((CJRUpcomingMoviesInfo) arrayList8.get(i6)).getGenre().get(i7))) {
                            z2 = true;
                            break;
                        } else {
                            i7++;
                        }
                    }
                    if (z2) {
                        arrayList7.add(arrayList8.get(i6));
                    }
                }
                arrayList8.clear();
                arrayList8.addAll(arrayList7);
                arrayList7.clear();
            }
        }
        if (arrayList6 != null && arrayList3.size() > 0) {
            for (int i8 = 0; i8 < arrayList3.size(); i8++) {
                String year = ((CJRUpcomingMovieReleaseDate) arrayList6.get(i8)).getYear();
                ArrayList<CJRMovieLanguages> releaseMonths = ((CJRUpcomingMovieReleaseDate) arrayList6.get(i8)).getReleaseMonths();
                for (int i9 = 0; i9 < releaseMonths.size(); i9++) {
                    if (releaseMonths.get(i9).getIsSelected()) {
                        hashSet3.add(year + "-" + aJRUpcomingMoviesGridPage2.z.get(releaseMonths.get(i9).getLanguage()));
                    }
                }
            }
            if (hashSet3.size() > 0) {
                for (int i10 = 0; i10 < arrayList8.size(); i10++) {
                    String releaseDate = ((CJRUpcomingMoviesInfo) arrayList8.get(i10)).getReleaseDate();
                    if (!TextUtils.isEmpty(releaseDate)) {
                        if (hashSet3.contains(releaseDate.substring(0, releaseDate.lastIndexOf("-")))) {
                            arrayList7.add(arrayList8.get(i10));
                        }
                    } else if (comingSoonMovie.isSelected()) {
                        arrayList7.add(arrayList8.get(i10));
                    }
                }
            } else if (comingSoonMovie.isSelected()) {
                while (i2 < arrayList8.size()) {
                    if (TextUtils.isEmpty(((CJRUpcomingMoviesInfo) arrayList8.get(i2)).getReleaseDate())) {
                        arrayList7.add(arrayList8.get(i2));
                    }
                    i2++;
                }
            } else {
                arrayList7.addAll(arrayList8);
            }
        } else if (comingSoonMovie.isSelected()) {
            while (i2 < arrayList8.size()) {
                if (TextUtils.isEmpty(((CJRUpcomingMoviesInfo) arrayList8.get(i2)).getReleaseDate())) {
                    arrayList7.add(arrayList8.get(i2));
                }
                i2++;
            }
        } else {
            arrayList7.addAll(arrayList8);
        }
        if (hashSet2.size() == 0 && hashSet.size() == 0 && hashSet3.size() == 0 && !comingSoonMovie.isSelected()) {
            aJRUpcomingMoviesGridPage2.B = true;
        }
        if (!aJRUpcomingMoviesGridPage2.B) {
            ArrayList arrayList10 = new ArrayList();
            arrayList10.addAll(hashSet);
            ArrayList arrayList11 = new ArrayList();
            arrayList11.addAll(hashSet2);
            ArrayList arrayList12 = new ArrayList();
            arrayList12.addAll(hashSet3);
            aJRUpcomingMoviesGridPage2.a(arrayList10, arrayList11, arrayList12);
        }
        return arrayList7;
    }

    static /* synthetic */ void p(AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage) {
        aJRUpcomingMoviesGridPage.s.setVisibility(8);
        aJRUpcomingMoviesGridPage.t.setVisibility(0);
    }

    static /* synthetic */ void s(AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage) {
        ArrayList<CJRUpcomingMoviesInfo> arrayList;
        ArrayList arrayList2 = (ArrayList) aJRUpcomingMoviesGridPage.f74141e.getLanguageScored();
        if (arrayList2 == null && (arrayList = aJRUpcomingMoviesGridPage.m) != null && arrayList.size() > 0) {
            arrayList2 = new ArrayList();
            Iterator<CJRUpcomingMoviesInfo> it2 = aJRUpcomingMoviesGridPage.m.iterator();
            while (it2.hasNext()) {
                CJRUpcomingMoviesInfo next = it2.next();
                if (!arrayList2.contains(next.getLanguage())) {
                    arrayList2.add(next.getLanguage());
                }
            }
        }
        aJRUpcomingMoviesGridPage.f74145i = new ArrayList<>();
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                CJRMovieLanguages cJRMovieLanguages = new CJRMovieLanguages();
                cJRMovieLanguages.setIsSelected(false);
                cJRMovieLanguages.setLanguage((String) it3.next());
                aJRUpcomingMoviesGridPage.f74145i.add(cJRMovieLanguages);
            }
        }
        aJRUpcomingMoviesGridPage.j = new ArrayList<>();
        HashSet hashSet = new HashSet();
        ArrayList<CJRUpcomingMoviesInfo> arrayList3 = aJRUpcomingMoviesGridPage.m;
        if (arrayList3 != null && arrayList3.size() > 0) {
            Iterator<CJRUpcomingMoviesInfo> it4 = aJRUpcomingMoviesGridPage.m.iterator();
            while (it4.hasNext()) {
                hashSet.addAll(it4.next().getGenre());
            }
            if (hashSet.size() > 0) {
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    CJRMovieLanguages cJRMovieLanguages2 = new CJRMovieLanguages();
                    cJRMovieLanguages2.setLanguage((String) it5.next());
                    cJRMovieLanguages2.setIsSelected(false);
                    aJRUpcomingMoviesGridPage.j.add(cJRMovieLanguages2);
                }
            }
        }
        aJRUpcomingMoviesGridPage.k = new ArrayList<>();
        HashMap hashMap = new HashMap();
        ArrayList<CJRUpcomingMoviesInfo> arrayList4 = aJRUpcomingMoviesGridPage.m;
        if (arrayList4 != null && arrayList4.size() > 0) {
            Iterator<CJRUpcomingMoviesInfo> it6 = aJRUpcomingMoviesGridPage.m.iterator();
            while (it6.hasNext()) {
                String releaseDate = it6.next().getReleaseDate();
                if (!TextUtils.isEmpty(releaseDate)) {
                    String[] split = releaseDate.split("-");
                    String str = split[0];
                    String str2 = split[1];
                    if (hashMap.containsKey(str)) {
                        HashSet hashSet2 = (HashSet) hashMap.get(str);
                        hashSet2.add(str2);
                        hashMap.put(str, hashSet2);
                    } else {
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add(str2);
                        hashMap.put(str, hashSet3);
                    }
                } else {
                    aJRUpcomingMoviesGridPage.l.setHasComingSoonMovie(true);
                }
            }
            if (hashMap.size() > 0) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    CJRUpcomingMovieReleaseDate cJRUpcomingMovieReleaseDate = new CJRUpcomingMovieReleaseDate();
                    cJRUpcomingMovieReleaseDate.setYear((String) entry.getKey());
                    cJRUpcomingMovieReleaseDate.setExpanded(false);
                    ArrayList arrayList5 = new ArrayList();
                    ArrayList arrayList6 = new ArrayList((Collection) entry.getValue());
                    Collections.sort(arrayList6);
                    Iterator it7 = arrayList6.iterator();
                    while (it7.hasNext()) {
                        String str3 = (String) it7.next();
                        CJRMovieLanguages cJRMovieLanguages3 = new CJRMovieLanguages();
                        cJRMovieLanguages3.setLanguage(aJRUpcomingMoviesGridPage.y[Integer.parseInt(str3) - 1]);
                        aJRUpcomingMoviesGridPage.z.put(aJRUpcomingMoviesGridPage.y[Integer.parseInt(str3) - 1], str3);
                        cJRMovieLanguages3.setIsSelected(false);
                        arrayList5.add(cJRMovieLanguages3);
                    }
                    cJRUpcomingMovieReleaseDate.setReleaseMonths(arrayList5);
                    aJRUpcomingMoviesGridPage.k.add(cJRUpcomingMovieReleaseDate);
                }
            }
        }
    }

    static /* synthetic */ void a(AJRUpcomingMoviesGridPage aJRUpcomingMoviesGridPage, String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<CJRMovieLanguages> it2 = aJRUpcomingMoviesGridPage.f74145i.iterator();
            while (it2.hasNext()) {
                CJRMovieLanguages next = it2.next();
                if (str.equalsIgnoreCase(next.getLanguage())) {
                    next.setIsSelected(true);
                    q.d("selectFilterManually" + next.getLanguage());
                    return;
                }
            }
            Iterator<CJRMovieLanguages> it3 = aJRUpcomingMoviesGridPage.j.iterator();
            while (it3.hasNext()) {
                CJRMovieLanguages next2 = it3.next();
                if (str.equalsIgnoreCase(next2.getLanguage())) {
                    next2.setIsSelected(true);
                    q.d("selectFilterManually" + next2.getLanguage());
                    return;
                }
            }
        }
    }
}
