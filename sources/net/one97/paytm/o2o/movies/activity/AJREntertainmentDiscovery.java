package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.LayoutType;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeDataResponse;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovieHomeListItem;
import net.one97.paytm.o2o.movies.entity.CJRCitiesResponse;
import net.one97.paytm.o2o.movies.entity.CJRInsiderCityModel;
import net.one97.paytm.o2o.movies.entity.CJRInsiderCityResponse;
import net.one97.paytm.o2o.movies.one_pager.OpBrowseCategory;
import net.one97.paytm.o2o.movies.one_pager.OpCategory;
import net.one97.paytm.o2o.movies.one_pager.OpConfigResponse;
import net.one97.paytm.o2o.movies.one_pager.OpDatesModel;
import net.one97.paytm.o2o.movies.one_pager.OpEntertainmentResponse;
import net.one97.paytm.o2o.movies.one_pager.OpFeaturedModel;
import net.one97.paytm.o2o.movies.one_pager.OpSection;
import net.one97.paytm.o2o.movies.one_pager.c;
import net.one97.paytm.o2o.movies.one_pager.d;
import net.one97.paytm.o2o.movies.one_pager.e;
import net.one97.paytm.o2o.movies.utils.n;

public class AJREntertainmentDiscovery extends AppBaseActivity implements c.a {
    private static HashMap<Integer, String> s;
    private TextView A;
    private TextView B;
    private TextView C;
    private OpConfigResponse D;
    private boolean E = true;

    /* renamed from: a  reason: collision with root package name */
    OpEntertainmentResponse f73962a;

    /* renamed from: b  reason: collision with root package name */
    CJRHomePageV2 f73963b;

    /* renamed from: c  reason: collision with root package name */
    CJRMovieHomeDataResponse f73964c;

    /* renamed from: d  reason: collision with root package name */
    List<d> f73965d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    RecyclerView f73966e;

    /* renamed from: f  reason: collision with root package name */
    TextView f73967f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f73968g;

    /* renamed from: h  reason: collision with root package name */
    LinearLayout f73969h;

    /* renamed from: i  reason: collision with root package name */
    AppBarLayout f73970i;
    TextView j;
    RelativeLayout k;
    private CJRSelectCityModel l;
    private net.one97.paytm.o2o.movies.one_pager.a m;
    private ProgressBar n;
    private int o;
    private c p;
    private CJRCitiesResponse q;
    private int r = 10;
    private CJRInsiderCityResponse t;
    private boolean u = true;
    private boolean v = true;
    private boolean w = true;
    private boolean x = true;
    private HashMap<String, CJRInsiderCityModel> y;
    private ImageView z;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        s = hashMap;
        hashMap.put(1, "today");
        s.put(2, "tomorrow");
        s.put(3, "weekend");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_entertainment_discovery_page);
        this.m = (net.one97.paytm.o2o.movies.one_pager.a) am.a((FragmentActivity) this).a(net.one97.paytm.o2o.movies.one_pager.a.class);
        net.one97.paytm.o2o.movies.one_pager.a aVar = this.m;
        if (aVar.f75645a == null) {
            aVar.f75645a = new y<>();
        }
        aVar.f75645a.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJREntertainmentDiscovery.this.a((OpEntertainmentResponse) obj);
            }
        });
        net.one97.paytm.o2o.movies.one_pager.a aVar2 = this.m;
        if (aVar2.f75646b == null) {
            aVar2.f75646b = new y<>();
        }
        aVar2.f75646b.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJREntertainmentDiscovery.this.a((OpConfigResponse) obj);
            }
        });
        net.one97.paytm.o2o.movies.one_pager.a aVar3 = this.m;
        if (aVar3.f75648d == null) {
            aVar3.f75648d = new y<>();
        }
        aVar3.f75648d.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJREntertainmentDiscovery.this.a((CJRMovieHomeDataResponse) obj);
            }
        });
        net.one97.paytm.o2o.movies.one_pager.a aVar4 = this.m;
        if (aVar4.f75647c == null) {
            aVar4.f75647c = new y<>();
        }
        aVar4.f75647c.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJREntertainmentDiscovery.this.a((CJRHomePageV2) obj);
            }
        });
        net.one97.paytm.o2o.movies.one_pager.a aVar5 = this.m;
        if (aVar5.f75649e == null) {
            aVar5.f75649e = new y<>();
        }
        aVar5.f75649e.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJREntertainmentDiscovery.this.a((CJRCitiesResponse) obj);
            }
        });
        net.one97.paytm.o2o.movies.one_pager.a aVar6 = this.m;
        if (aVar6.f75650f == null) {
            aVar6.f75650f = new y<>();
        }
        aVar6.f75650f.observe(this, new z() {
            public final void onChanged(Object obj) {
                AJREntertainmentDiscovery.this.a((CJRInsiderCityResponse) obj);
            }
        });
        net.one97.paytm.o2o.movies.one_pager.a aVar7 = this.m;
        net.one97.paytm.o2o.movies.common.b.c.a();
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesOnePagerConfig", (String) null);
        if (TextUtils.isEmpty(a2)) {
            aVar7.f75646b.setValue(null);
        } else {
            aVar7.a(a2, (IJRPaytmDataModel) new OpConfigResponse());
        }
        this.E = false;
        this.f73966e = (RecyclerView) findViewById(R.id.onePagerRv);
        this.f73969h = (LinearLayout) findViewById(R.id.errorLl);
        this.z = (ImageView) findViewById(R.id.errorIv);
        this.A = (TextView) findViewById(R.id.errorTitleTv);
        this.B = (TextView) findViewById(R.id.errorSubtitleTv);
        this.C = (TextView) findViewById(R.id.errorCtaTv);
        this.f73970i = (AppBarLayout) findViewById(R.id.opAppBarLayout);
        this.f73967f = (TextView) findViewById(R.id.locationSmallTv);
        this.f73968g = (ImageView) findViewById(R.id.downArrowSmallIv);
        this.j = (TextView) findViewById(R.id.locationLargeTv);
        this.k = (RelativeLayout) findViewById(R.id.welcomeContainerRl);
        this.n = (ProgressBar) findViewById(R.id.progress_bar);
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(this);
        customLinearLayoutManager.setOrientation(1);
        this.f73966e.setLayoutManager(customLinearLayoutManager);
        this.p = new c(this.f73965d, this, this);
        this.f73966e.setAdapter(this.p);
        if (this.f73966e.getItemDecorationCount() == 0) {
            this.f73966e.addItemDecoration(new RecyclerView.h() {
                public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    super.getItemOffsets(rect, view, recyclerView, sVar);
                    if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                        rect.top = n.a(20, (Context) AJREntertainmentDiscovery.this);
                    }
                }
            });
        }
        this.f73970i.a((AppBarLayout.b) new AppBarLayout.b() {
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                AJREntertainmentDiscovery.this.a(appBarLayout, i2);
            }
        });
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJREntertainmentDiscovery.this.b(view);
            }
        });
        a();
        b.f75032a.f75033b.sendOpenScreenWithDeviceInfo("/entertainment", "movies", this);
    }

    public void onLocationSelectClick(View view) {
        view.setEnabled(false);
        view.postDelayed(new Runnable(view) {
            private final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                AJREntertainmentDiscovery.c(this.f$0);
            }
        }, 3000);
        if (this.q == null || this.t == null) {
            a(true);
            this.v = false;
            this.u = false;
            this.m.a((Context) this);
            this.m.a();
            return;
        }
        e();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(View view) {
        try {
            view.setEnabled(true);
        } catch (Exception unused) {
        }
    }

    private void a() {
        this.l = net.one97.paytm.o2o.movies.common.d.a((Context) this);
        this.f73969h.setVisibility(8);
        a(true);
        if (this.l == null) {
            this.f73967f.setVisibility(8);
            this.f73968g.setVisibility(8);
            if (this.q == null || this.t == null) {
                this.v = false;
                this.u = false;
                this.m.a((Context) this);
                this.m.a();
                return;
            }
            f();
        } else if (this.E) {
            this.o = 0;
            this.k.setVisibility(0);
            this.f73967f.setVisibility(0);
            this.f73968g.setVisibility(0);
            this.f73967f.setText(this.l.getLabel());
            this.j.setText(this.l.getLabel());
            this.f73965d.clear();
            this.p.notifyDataSetChanged();
            this.w = false;
            this.x = false;
            this.m.a(d());
            this.m.a(c(), (Context) this);
            this.m.b();
        }
    }

    private String b() {
        String label = this.l.getLabel();
        if ("Delhi".equalsIgnoreCase(label)) {
            label = "Delhi/NCR";
        } else if ("Bangalore".equals(label)) {
            label = "Bengaluru";
        } else if ("Dharamshala".equals(label)) {
            label = "Dharamsala";
        } else if ("Cuttak".equals(label)) {
            label = "Cuttack";
        }
        if (TextUtils.isEmpty(label)) {
            return null;
        }
        return label;
    }

    private String c() {
        String value = this.l.getValue();
        if ("Delhi".equalsIgnoreCase(value)) {
            value = "Delhi/NCR";
        } else if ("Bangalore".equals(value)) {
            value = "Bengaluru";
        } else if ("Dharamshala".equals(value)) {
            value = "Dharamsala";
        } else if ("Cuttak".equals(value)) {
            value = "Cuttack";
        }
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return value.toLowerCase();
    }

    private String d() {
        String value = this.l.getValue();
        if ("Delhi/NCR".equalsIgnoreCase(value) || "New Delhi".equalsIgnoreCase(value) || "Delhi-NCR".equalsIgnoreCase(value)) {
            value = "Delhi";
        } else if ("Bengaluru".equals(value)) {
            value = "Bangalore";
        } else if ("Dharamsala".equals(value)) {
            value = "Dharamshala";
        } else if ("Cuttack".equals(value)) {
            value = "Cuttak";
        }
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return value.toLowerCase();
    }

    private static String a(String str) {
        if ("Delhi/NCR".equals(str) || "New Delhi".equalsIgnoreCase(str) || "Delhi-NCR".equalsIgnoreCase(str)) {
            str = "Delhi";
        } else if ("Bengaluru".equals(str)) {
            str = "Bangalore";
        } else if ("Dharamsala".equals(str)) {
            str = "Dharamshala";
        } else if ("Cuttack".equals(str)) {
            str = "Cuttak";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.toLowerCase();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AppBarLayout appBarLayout, int i2) {
        float pow = (float) Math.pow((double) (((float) Math.abs(i2)) / ((float) appBarLayout.getTotalScrollRange())), 2.0d);
        this.f73967f.setAlpha(pow);
        this.f73968g.setAlpha(pow);
        if (pow == 0.0f) {
            this.f73967f.setClickable(false);
            this.f73968g.setClickable(false);
            return;
        }
        this.f73967f.setClickable(true);
        this.f73968g.setClickable(true);
    }

    public final void a(int i2) {
        a(true);
        if (this.o == i2) {
            this.o = 0;
        } else {
            this.o = i2;
        }
        g();
        a(false);
    }

    public class CustomLinearLayoutManager extends LinearLayoutManager {
        public boolean canScrollHorizontally() {
            return false;
        }

        public CustomLinearLayoutManager(Context context) {
            super(context);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(OpEntertainmentResponse opEntertainmentResponse) {
        this.f73962a = opEntertainmentResponse;
        this.w = true;
        g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(OpConfigResponse opConfigResponse) {
        if (opConfigResponse != null) {
            this.D = opConfigResponse;
        } else {
            OpConfigResponse opConfigResponse2 = new OpConfigResponse();
            ArrayList arrayList = new ArrayList();
            arrayList.add(a("featured", ""));
            arrayList.add(a("dateFilter", ""));
            arrayList.add(a("trending", "Trending Movies"));
            arrayList.add(a("Comedy", "Comedy"));
            arrayList.add(a("Sports", "Sports"));
            arrayList.add(a("browse", "Browse by genre"));
            arrayList.add(a("Amusement Parks", "Amusement Parks"));
            arrayList.add(a("Music", "Music"));
            arrayList.add(a("explore", "Explore more"));
            arrayList.add(a("offers", "Offers"));
            opConfigResponse2.category_section = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(b(4));
            arrayList2.add(b(6));
            opConfigResponse2.featured_section = arrayList2;
            this.D = opConfigResponse2;
        }
        this.E = true;
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRMovieHomeDataResponse cJRMovieHomeDataResponse) {
        this.f73964c = cJRMovieHomeDataResponse;
        CJRMovieHomeDataResponse cJRMovieHomeDataResponse2 = this.f73964c;
        if (!(cJRMovieHomeDataResponse2 == null || cJRMovieHomeDataResponse2.getData() == null)) {
            this.f73964c.getData().setMovies(net.one97.paytm.o2o.movies.common.d.a(this.f73964c));
        }
        this.x = true;
        g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRHomePageV2 cJRHomePageV2) {
        this.f73963b = cJRHomePageV2;
        g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRCitiesResponse cJRCitiesResponse) {
        this.u = true;
        this.q = cJRCitiesResponse;
        e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRInsiderCityResponse cJRInsiderCityResponse) {
        this.v = true;
        this.t = cJRInsiderCityResponse;
        e();
    }

    private void e() {
        if (this.v && this.u) {
            a(false);
            CJRSelectCitiesModel a2 = n.a(this.q);
            if (a2 == null || this.t == null) {
                Toast.makeText(this, R.string.no_mp_cities_availble, 0).show();
                return;
            }
            ArrayList arrayList = new ArrayList();
            List<CJRInsiderCityModel> list = this.t.data.cities;
            this.y = new HashMap<>();
            for (CJRInsiderCityModel next : list) {
                this.y.put(next.slug.replace("homescreen-", ""), next);
            }
            Iterator<CJRSelectCityModel> it2 = a2.getCities().iterator();
            while (it2.hasNext()) {
                CJRSelectCityModel next2 = it2.next();
                if (this.y.containsKey(a(next2.getValue()))) {
                    arrayList.add(next2);
                }
            }
            if (!net.one97.paytm.o2o.movies.common.d.a((List) arrayList)) {
                n.b((ArrayList<CJRSelectCityModel>) arrayList);
            }
            f();
        }
    }

    private void f() {
        if (net.one97.paytm.o2o.movies.common.d.a((List) n.f())) {
            Toast.makeText(this, R.string.no_mp_cities_availble, 0).show();
            return;
        }
        Intent intent = new Intent(this, AJRMoviesSelectCityActivity.class);
        CJRSelectCityModel cJRSelectCityModel = this.l;
        if (cJRSelectCityModel != null) {
            intent.putExtra("usercurrentcity", cJRSelectCityModel);
        }
        intent.putExtra("sourcename", "movietickets");
        intent.putExtra("previousScreen", "onepager");
        intent.addFlags(131072);
        startActivityForResult(intent, 1);
        overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
    }

    private void g() {
        HashMap<String, List<String>> hashMap;
        HashMap hashMap2;
        this.f73965d.clear();
        if (this.x && this.w) {
            if (this.f73962a == null && this.f73964c == null) {
                this.f73969h.setVisibility(0);
                this.z.setImageDrawable(getResources().getDrawable(R.drawable.ic_no_event_found));
                this.A.setText(getResources().getString(R.string.error_something_went_wrong));
                this.B.setText(getResources().getString(R.string.movie_op_page_load_error_text));
                this.C.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJREntertainmentDiscovery.this.a(view);
                    }
                });
                this.C.setVisibility(0);
                this.z.setImageDrawable(getResources().getDrawable(R.drawable.ic_op_error_image));
                this.f73966e.setVisibility(8);
            } else {
                OpEntertainmentResponse opEntertainmentResponse = this.f73962a;
                if (opEntertainmentResponse == null) {
                    this.f73969h.setVisibility(0);
                    this.z.setImageDrawable(getResources().getDrawable(R.drawable.ic_no_event_found));
                    this.A.setText(getResources().getString(R.string.movie_op_no_event_error_title));
                    this.B.setText(getResources().getString(R.string.movie_op_no_event_error_text));
                    this.C.setVisibility(8);
                    this.f73966e.setVisibility(8);
                    a(false);
                    return;
                }
                HashMap<String, List<String>> hashMap3 = null;
                if (opEntertainmentResponse == null || opEntertainmentResponse.list == null) {
                    hashMap2 = null;
                    hashMap = null;
                } else {
                    HashMap<String, OpFeaturedModel> hashMap4 = this.f73962a.list.masterList;
                    hashMap2 = hashMap4 != null ? (HashMap) new f().a(n.a((Object) hashMap4), new com.google.gson.b.a<HashMap<String, OpFeaturedModel>>() {
                    }.getType()) : null;
                    hashMap = this.f73962a.list.categorywiseList != null ? this.f73962a.list.categorywiseList : null;
                    if (this.f73962a.list.groupwiseList != null) {
                        hashMap3 = this.f73962a.list.groupwiseList;
                    }
                }
                List<OpSection> list = this.D.category_section;
                if (!net.one97.paytm.o2o.movies.common.d.a((List) list)) {
                    for (OpSection next : list) {
                        String str = next.name;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case -1380604278:
                                if (str.equals("browse")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -1309148525:
                                if (str.equals("explore")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case -1019793001:
                                if (str.equals("offers")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case -290659282:
                                if (str.equals("featured")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 149531846:
                                if (str.equals("dateFilter")) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                            case 1394955557:
                                if (str.equals("trending")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            a(this.D.featured_section);
                        } else if (c2 != 1) {
                            if (c2 != 2) {
                                if (c2 == 3) {
                                    b(next);
                                } else if (c2 == 4) {
                                    a(next);
                                } else if (c2 == 5) {
                                    h();
                                } else if (hashMap2 != null) {
                                    a(next, hashMap, hashMap3, (HashMap<String, OpFeaturedModel>) hashMap2);
                                }
                            } else if (hashMap2 != null) {
                                a(next, (HashMap<String, OpFeaturedModel>) hashMap2);
                            }
                        } else if (!(hashMap == null || hashMap3 == null)) {
                            a(hashMap3, hashMap, next);
                        }
                    }
                }
                if (net.one97.paytm.o2o.movies.common.d.a((List) this.f73965d)) {
                    this.f73969h.setVisibility(0);
                    this.z.setImageDrawable(getResources().getDrawable(R.drawable.ic_no_event_found));
                    this.A.setText(getResources().getString(R.string.movie_op_no_event_error_title));
                    this.B.setText(getResources().getString(R.string.movie_op_no_event_error_text));
                    this.C.setVisibility(8);
                    this.f73966e.setVisibility(8);
                } else {
                    this.f73969h.setVisibility(8);
                    this.f73966e.setVisibility(0);
                    this.p.notifyDataSetChanged();
                }
            }
            a(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private void h() {
        OpEntertainmentResponse opEntertainmentResponse = this.f73962a;
        if (opEntertainmentResponse != null && opEntertainmentResponse.dates != null) {
            OpDatesModel opDatesModel = this.f73962a.dates;
            d dVar = new d();
            boolean z2 = true;
            dVar.f75657a = 1;
            net.one97.paytm.o2o.movies.one_pager.f fVar = new net.one97.paytm.o2o.movies.one_pager.f();
            fVar.f75663a = net.one97.paytm.o2o.movies.one_pager.b.DATE_FILTER;
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(opDatesModel.today_date_string)) {
                arrayList.add(a(1, getResources().getString(R.string.op_today_filter_label), opDatesModel.today_date_string, this.o == 1));
            }
            if (!TextUtils.isEmpty(opDatesModel.tomorrow_date_string)) {
                arrayList.add(a(2, getResources().getString(R.string.op_tomorrow_filter_label), opDatesModel.tomorrow_date_string, this.o == 2));
            }
            if (!TextUtils.isEmpty(opDatesModel.weekend_date_string)) {
                String string = getResources().getString(R.string.op_weekend_filter_label);
                String str = opDatesModel.weekend_date_string;
                if (this.o != 3) {
                    z2 = false;
                }
                arrayList.add(a(3, string, str, z2));
            }
            fVar.f75664b = arrayList;
            dVar.f75658b = fVar;
            this.f73965d.add(dVar);
        }
    }

    private void a(OpSection opSection) {
        CJRMovieHomeDataResponse cJRMovieHomeDataResponse = this.f73964c;
        if (cJRMovieHomeDataResponse != null && cJRMovieHomeDataResponse.getData() != null && !net.one97.paytm.o2o.movies.common.d.a((List) this.f73964c.getData().getMovies())) {
            d dVar = new d();
            dVar.f75657a = 1;
            net.one97.paytm.o2o.movies.one_pager.f fVar = new net.one97.paytm.o2o.movies.one_pager.f();
            fVar.f75667e = opSection.display_name;
            fVar.f75663a = net.one97.paytm.o2o.movies.one_pager.b.MOVIE;
            dVar.f75658b = fVar;
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            Iterator<CJRMovieHomeListItem> it2 = this.f73964c.getData().getMovies().iterator();
            while (it2.hasNext()) {
                CJRMovieHomeListItem next = it2.next();
                c cVar = new c();
                cVar.f74225a = next;
                cVar.f74226b = a(next);
                arrayList.add(cVar);
                i2++;
                if (i2 == this.r) {
                    break;
                }
            }
            fVar.f75666d = "SEE ALL";
            fVar.f75671i = i();
            if (!net.one97.paytm.o2o.movies.common.d.a((List) arrayList)) {
                fVar.f75670h = arrayList;
                this.f73965d.add(dVar);
            }
        }
    }

    private String i() {
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        return "paytmmp://movietickets?city=" + b() + "&city_value=" + c2;
    }

    private void b(OpSection opSection) {
        if (this.f73963b != null) {
            ArrayList arrayList = new ArrayList();
            if (!net.one97.paytm.o2o.movies.common.d.a((List) this.f73963b.mPage)) {
                Iterator<CJRHomePageDetailV2> it2 = this.f73963b.mPage.iterator();
                while (it2.hasNext()) {
                    CJRHomePageDetailV2 next = it2.next();
                    if (!net.one97.paytm.o2o.movies.common.d.a((List) next.getHomePageLayoutList())) {
                        Iterator<CJRHomePageLayoutV2> it3 = next.getHomePageLayoutList().iterator();
                        while (it3.hasNext()) {
                            CJRHomePageLayoutV2 next2 = it3.next();
                            if (LayoutType.LAYOUT_CAROUSEL4.getName().equalsIgnoreCase(next2.getLayout()) || LayoutType.LAYOUT_CAROUSEL_4.getName().equalsIgnoreCase(next2.getLayout())) {
                                arrayList.addAll(next2.getHomePageItemList());
                            }
                        }
                    }
                }
            }
            if (!net.one97.paytm.o2o.movies.common.d.a((List) arrayList)) {
                d dVar = new d();
                dVar.f75657a = 1;
                net.one97.paytm.o2o.movies.one_pager.f fVar = new net.one97.paytm.o2o.movies.one_pager.f();
                fVar.f75663a = net.one97.paytm.o2o.movies.one_pager.b.OFFERS;
                fVar.f75667e = opSection.display_name;
                fVar.f75669g = arrayList;
                dVar.f75658b = fVar;
                this.f73965d.add(dVar);
            }
        }
    }

    private void a(HashMap<String, List<String>> hashMap, HashMap<String, List<String>> hashMap2, OpSection opSection) {
        d dVar = new d();
        net.one97.paytm.o2o.movies.one_pager.f fVar = new net.one97.paytm.o2o.movies.one_pager.f();
        fVar.f75667e = opSection.display_name;
        fVar.f75663a = net.one97.paytm.o2o.movies.one_pager.b.BROWSE;
        List<OpBrowseCategory> a2 = a(hashMap, hashMap2);
        if (!net.one97.paytm.o2o.movies.common.d.a((List) a2)) {
            fVar.f75668f = a2;
            dVar.f75658b = fVar;
            dVar.f75657a = 1;
            this.f73965d.add(dVar);
        }
    }

    private boolean a(List<OpSection> list) {
        CJRMovieHomeDataResponse cJRMovieHomeDataResponse;
        OpEntertainmentResponse opEntertainmentResponse = this.f73962a;
        if (opEntertainmentResponse == null || net.one97.paytm.o2o.movies.common.d.a((List) opEntertainmentResponse.featured)) {
            return false;
        }
        d dVar = new d();
        dVar.f75657a = 1;
        net.one97.paytm.o2o.movies.one_pager.f fVar = new net.one97.paytm.o2o.movies.one_pager.f();
        fVar.f75663a = net.one97.paytm.o2o.movies.one_pager.b.FEATURED;
        ArrayList arrayList = new ArrayList();
        for (OpFeaturedModel next : this.f73962a.featured) {
            if (a(next.applicable_filters, (String) null)) {
                next.deeplink = "paytmmp://events?insiderH5Url=https://h5.insider.in/" + next.slug + "/event";
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new a(this, (byte) 0));
        if (net.one97.paytm.o2o.movies.common.d.a((List) arrayList)) {
            return false;
        }
        if (!net.one97.paytm.o2o.movies.common.d.a((List) list) && (cJRMovieHomeDataResponse = this.f73964c) != null && cJRMovieHomeDataResponse.getData() != null && !net.one97.paytm.o2o.movies.common.d.a((List) this.f73964c.getData().getMovies())) {
            ArrayList<CJRMovieHomeListItem> movies = this.f73964c.getData().getMovies();
            int i2 = 0;
            for (OpSection next2 : list) {
                if (i2 < movies.size()) {
                    CJRMovieHomeListItem cJRMovieHomeListItem = movies.get(i2);
                    if (cJRMovieHomeListItem == null) {
                        break;
                    }
                    OpFeaturedModel opFeaturedModel = new OpFeaturedModel();
                    opFeaturedModel.name = cJRMovieHomeListItem.getLabel();
                    opFeaturedModel.vertical_cover_image = cJRMovieHomeListItem.getAppImgPath();
                    OpCategory opCategory = new OpCategory();
                    opCategory.name = "MOVIE";
                    opFeaturedModel.deeplink = a(cJRMovieHomeListItem);
                    opFeaturedModel.category_id = opCategory;
                    opFeaturedModel.venue_name = n.a(cJRMovieHomeListItem);
                    if (arrayList.size() >= next2.position.intValue()) {
                        arrayList.add(next2.position.intValue() - 1, opFeaturedModel);
                    } else {
                        arrayList.add(opFeaturedModel);
                    }
                }
                i2++;
            }
        }
        int size = arrayList.size();
        int i3 = this.r;
        if (size > i3) {
            fVar.f75665c = arrayList.subList(0, i3);
        } else {
            fVar.f75665c = arrayList;
        }
        dVar.f75658b = fVar;
        this.f73965d.add(dVar);
        return true;
    }

    private String a(CJRMovieHomeListItem cJRMovieHomeListItem) {
        return "paytmmp://movies-show-time?type=movie&code=" + cJRMovieHomeListItem.getId() + "&city=" + b() + "&city_value=" + c() + "&origin=one_pager";
    }

    private List<OpBrowseCategory> a(HashMap<String, List<String>> hashMap, HashMap<String, List<String>> hashMap2) {
        ArrayList<OpBrowseCategory> arrayList = new ArrayList<>();
        arrayList.add(a("Food", R.drawable.ic_op_food, "Food"));
        arrayList.add(a("Travel", R.drawable.ic_op_travel, "Travel"));
        arrayList.add(a("Experiences", R.drawable.ic_op_experiences, "Experiences"));
        arrayList.add(a("Workshops", R.drawable.ic_op_workshop, "Workshops"));
        arrayList.add(a("Activities", R.drawable.ic_op_activities, "Activities"));
        arrayList.add(a("Theatre", R.drawable.ic_op_theatre, "Theatre"));
        arrayList.add(a("Screening", R.drawable.ic_op_screening, "Screening"));
        arrayList.add(a("Art", R.drawable.ic_op_art, "Art"));
        arrayList.add(a("Dance", R.drawable.ic_op_dance, "Dance"));
        arrayList.add(a("Poetry", R.drawable.ic_op_poetry, "Poetry"));
        ArrayList arrayList2 = new ArrayList();
        for (OpBrowseCategory opBrowseCategory : arrayList) {
            String str = opBrowseCategory.type;
            if (hashMap != null && !net.one97.paytm.o2o.movies.common.d.a((List) hashMap.get(str))) {
                opBrowseCategory.deeplink = a(opBrowseCategory.type, d(), true);
                arrayList2.add(opBrowseCategory);
            } else if (hashMap2 != null && !net.one97.paytm.o2o.movies.common.d.a((List) hashMap2.get(str))) {
                opBrowseCategory.deeplink = a(opBrowseCategory.type, d(), false);
                arrayList2.add(opBrowseCategory);
            }
        }
        return arrayList2;
    }

    private static String a(String str, String str2, boolean z2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (z2) {
            return "paytmmp://events?insiderH5Url=https://h5.insider.in/all-" + str + "-in-" + str2;
        }
        return "paytmmp://events?insiderH5Url=https://h5.insider.in/" + str + "-in-" + str2;
    }

    private static OpBrowseCategory a(String str, int i2, String str2) {
        OpBrowseCategory opBrowseCategory = new OpBrowseCategory();
        opBrowseCategory.displayName = str2;
        opBrowseCategory.drawableId = i2;
        opBrowseCategory.type = str;
        return opBrowseCategory;
    }

    private static boolean a(List<String> list, String str) {
        if (list == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return list.contains(str);
        }
        if (list.contains("today") || list.contains("tomorrow") || list.contains("weekend")) {
            return true;
        }
        return false;
    }

    private void a(OpSection opSection, HashMap<String, List<String>> hashMap, HashMap<String, List<String>> hashMap2, HashMap<String, OpFeaturedModel> hashMap3) {
        List<String> list;
        String str = opSection.name;
        if (hashMap2 == null || !hashMap2.containsKey(str)) {
            list = (hashMap == null || !hashMap.containsKey(str)) ? null : hashMap.get(str);
        } else {
            list = hashMap2.get(str);
            opSection.isGroup = true;
        }
        if (!net.one97.paytm.o2o.movies.common.d.a((List) list)) {
            d dVar = new d();
            dVar.f75657a = 1;
            net.one97.paytm.o2o.movies.one_pager.f fVar = new net.one97.paytm.o2o.movies.one_pager.f();
            fVar.f75667e = opSection.display_name;
            fVar.f75663a = net.one97.paytm.o2o.movies.one_pager.b.CATEGORY_ITEMS;
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                if (hashMap3.containsKey(str2)) {
                    OpFeaturedModel opFeaturedModel = hashMap3.get(str2);
                    if (a(opFeaturedModel.applicable_filters, s.get(Integer.valueOf(this.o)))) {
                        arrayList.add(opFeaturedModel);
                        hashMap3.remove(str2);
                    }
                }
            }
            if (arrayList.size() != 0) {
                Collections.sort(arrayList, new a(this, (byte) 0));
                int size = arrayList.size();
                int i2 = this.r;
                if (size > i2) {
                    fVar.f75665c = arrayList.subList(0, i2);
                } else {
                    fVar.f75665c = arrayList;
                }
                fVar.f75666d = "SEE ALL";
                fVar.f75671i = c(opSection);
                dVar.f75658b = fVar;
                this.f73965d.add(dVar);
            }
        }
    }

    private void a(OpSection opSection, HashMap<String, OpFeaturedModel> hashMap) {
        d dVar = new d();
        dVar.f75657a = 1;
        net.one97.paytm.o2o.movies.one_pager.f fVar = new net.one97.paytm.o2o.movies.one_pager.f();
        fVar.f75667e = opSection.display_name;
        fVar.f75663a = net.one97.paytm.o2o.movies.one_pager.b.CATEGORY_ITEMS;
        ArrayList arrayList = new ArrayList();
        for (OpFeaturedModel next : hashMap.values()) {
            if (a(next.applicable_filters, s.get(Integer.valueOf(this.o)))) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new a(this, (byte) 0));
        if (!net.one97.paytm.o2o.movies.common.d.a((List) arrayList)) {
            int size = arrayList.size();
            int i2 = this.r;
            if (size > i2) {
                fVar.f75665c = arrayList.subList(0, i2);
                fVar.f75666d = "SEE ALL";
                String d2 = d();
                if (!TextUtils.isEmpty(d2)) {
                    fVar.f75671i = a(EventsModuleManager.MODULE_NAME, d2, true);
                }
            } else {
                fVar.f75665c = arrayList;
            }
            dVar.f75658b = fVar;
            this.f73965d.add(dVar);
        }
    }

    private String c(OpSection opSection) {
        String d2 = d(opSection);
        String d3 = d();
        if (TextUtils.isEmpty(d3) || TextUtils.isEmpty(d2)) {
            return null;
        }
        return a(d2, d3, false);
    }

    private static String d(OpSection opSection) {
        String[] split = opSection.name.split(" ");
        StringBuilder sb = new StringBuilder();
        if (opSection.isGroup) {
            sb.append(StringSet.all);
        }
        for (String str : split) {
            if (sb.length() > 0) {
                sb.append("-");
            }
            sb.append(str.toLowerCase());
        }
        return sb.toString();
    }

    private static OpSection a(String str, String str2) {
        OpSection opSection = new OpSection();
        opSection.name = str;
        opSection.isEnabled = true;
        opSection.display_name = str2;
        return opSection;
    }

    private static OpSection b(int i2) {
        OpSection opSection = new OpSection();
        opSection.position = Integer.valueOf(i2);
        opSection.isEnabled = true;
        return opSection;
    }

    private static e a(int i2, String str, String str2, boolean z2) {
        e eVar = new e();
        eVar.f75659a = i2;
        eVar.f75660b = str;
        eVar.f75661c = str2;
        eVar.f75662d = z2;
        return eVar;
    }

    private void a(boolean z2) {
        ProgressBar progressBar = this.n;
        if (progressBar != null) {
            if (z2) {
                progressBar.setVisibility(0);
            } else {
                progressBar.setVisibility(8);
            }
        }
    }

    class a implements Comparator<OpFeaturedModel> {
        private a() {
        }

        /* synthetic */ a(AJREntertainmentDiscovery aJREntertainmentDiscovery, byte b2) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            OpFeaturedModel opFeaturedModel = (OpFeaturedModel) obj;
            OpFeaturedModel opFeaturedModel2 = (OpFeaturedModel) obj2;
            if (opFeaturedModel == null || opFeaturedModel2 == null) {
                return 0;
            }
            if (opFeaturedModel2.popularity_score > opFeaturedModel.popularity_score) {
                return 1;
            }
            return opFeaturedModel2.popularity_score != opFeaturedModel.popularity_score ? -1 : 0;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (intent != null) {
                try {
                    if (intent.hasExtra("userselectedcity")) {
                        CJRSelectCityModel cJRSelectCityModel = (CJRSelectCityModel) intent.getSerializableExtra("userselectedcity");
                        if (this.l == null || TextUtils.isEmpty(this.l.getValue()) || !this.l.getValue().equals(cJRSelectCityModel.getValue())) {
                            this.l = cJRSelectCityModel;
                            if (this.l == null || this.l.getValue() == null) {
                                Toast.makeText(this, R.string.error_msg_default, 0).show();
                                return;
                            }
                            net.one97.paytm.o2o.movies.common.d.a((Context) this, this.l);
                            a();
                            return;
                        }
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            if (this.l == null) {
                finish();
            }
        }
    }

    public final void a(CJRHomePageItem cJRHomePageItem) {
        b.f75032a.f75033b.loadPage(this, cJRHomePageItem.mUrlType, cJRHomePageItem, "", 0, (ArrayList<? extends CJRItem>) null, false, "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        super.onBackPressed();
    }
}
