package com.travel.train.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b.h;
import com.travel.train.b.m;
import com.travel.train.b.n;
import com.travel.train.c.b;
import com.travel.train.f.b;
import com.travel.train.j.w;
import com.travel.train.model.metro.CJRMetroRouteAdditionalInfoModel;
import com.travel.train.model.metro.CJRMetroRouteModel;
import com.travel.train.model.metro.CJRMetroRouteSearchResponseModel;
import com.travel.train.model.metro.CJRParcelableMetroStationModel;
import com.travel.train.model.metro.CJRRoute;
import io.reactivex.rxjava3.d.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;

public final class AJRMetroRouteSearchResultActivity extends CJRTrainBaseActivity implements b.a {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f25886a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f25887b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f25888c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f25889d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f25890e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f25891f;

    /* renamed from: g  reason: collision with root package name */
    private RoboTextView f25892g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f25893h;

    /* renamed from: i  reason: collision with root package name */
    private ScrollView f25894i;
    private RelativeLayout j;
    private RoboTextView k;
    private RoboTextView l;
    private String m;
    private String n;
    private String o;
    private LottieAnimationView p;
    private final int q = 15;
    /* access modifiers changed from: private */
    public Handler r = new Handler();

    static final class c<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f25897a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class b<T> implements g<CJRMetroRouteModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMetroRouteSearchResultActivity f25896a;

        b(AJRMetroRouteSearchResultActivity aJRMetroRouteSearchResultActivity) {
            this.f25896a = aJRMetroRouteSearchResultActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            CJRMetroRouteModel cJRMetroRouteModel = (CJRMetroRouteModel) obj;
            AJRMetroRouteSearchResultActivity aJRMetroRouteSearchResultActivity = this.f25896a;
            List<CJRMetroRouteAdditionalInfoModel> list = cJRMetroRouteModel.additional_info;
            k.a((Object) list, "selectedRoute.additional_info");
            k.c(list, "infoList");
            RecyclerView recyclerView = aJRMetroRouteSearchResultActivity.f25887b;
            if (recyclerView == null) {
                k.a("routeInfoRecyclerView");
            }
            Context context = aJRMetroRouteSearchResultActivity;
            recyclerView.setAdapter(new n(context, list));
            RecyclerView recyclerView2 = aJRMetroRouteSearchResultActivity.f25887b;
            if (recyclerView2 == null) {
                k.a("routeInfoRecyclerView");
            }
            recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
            RecyclerView recyclerView3 = aJRMetroRouteSearchResultActivity.f25887b;
            if (recyclerView3 == null) {
                k.a("routeInfoRecyclerView");
            }
            recyclerView3.setHasFixedSize(true);
            AJRMetroRouteSearchResultActivity aJRMetroRouteSearchResultActivity2 = this.f25896a;
            List<CJRRoute> list2 = cJRMetroRouteModel.route;
            k.a((Object) list2, "selectedRoute.route");
            k.c(list2, "metroRouteStationList");
            RecyclerView recyclerView4 = aJRMetroRouteSearchResultActivity2.f25886a;
            if (recyclerView4 == null) {
                k.a("stationsRecyclerView");
            }
            Context context2 = aJRMetroRouteSearchResultActivity2;
            recyclerView4.setAdapter(new h(context2, list2));
            RecyclerView recyclerView5 = aJRMetroRouteSearchResultActivity2.f25886a;
            if (recyclerView5 == null) {
                k.a("stationsRecyclerView");
            }
            recyclerView5.setNestedScrollingEnabled(false);
            RecyclerView recyclerView6 = aJRMetroRouteSearchResultActivity2.f25886a;
            if (recyclerView6 == null) {
                k.a("stationsRecyclerView");
            }
            recyclerView6.setLayoutManager(new LinearLayoutManager(context2, 1, false));
            RecyclerView recyclerView7 = aJRMetroRouteSearchResultActivity2.f25886a;
            if (recyclerView7 == null) {
                k.a("stationsRecyclerView");
            }
            recyclerView7.setHasFixedSize(true);
        }
    }

    public static final /* synthetic */ RecyclerView b(AJRMetroRouteSearchResultActivity aJRMetroRouteSearchResultActivity) {
        RecyclerView recyclerView = aJRMetroRouteSearchResultActivity.f25888c;
        if (recyclerView == null) {
            k.a("routeRecyclerView");
        }
        return recyclerView;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_ajrmetro_route_search_result);
        View findViewById = findViewById(R.id.stations_recyclerview_in_metro_route_search_layout);
        k.a((Object) findViewById, "findViewById(R.id.statio…etro_route_search_layout)");
        this.f25886a = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.route_recyclerview_in_metro_route_search_layout);
        k.a((Object) findViewById2, "findViewById(R.id.route_…etro_route_search_layout)");
        this.f25888c = (RecyclerView) findViewById2;
        View findViewById3 = findViewById(R.id.route_info_recyclerview_in_metro_route_search_layout);
        k.a((Object) findViewById3, "findViewById(R.id.route_…etro_route_search_layout)");
        this.f25887b = (RecyclerView) findViewById3;
        View findViewById4 = findViewById(R.id.back_button_layout_metro_search_screen);
        k.a((Object) findViewById4, "findViewById(R.id.back_b…yout_metro_search_screen)");
        this.f25889d = (FrameLayout) findViewById4;
        View findViewById5 = findViewById(R.id.back_button_metro_search_screen);
        k.a((Object) findViewById5, "findViewById(R.id.back_button_metro_search_screen)");
        this.f25890e = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.arrow_between_stations);
        k.a((Object) findViewById6, "findViewById(R.id.arrow_between_stations)");
        this.f25893h = (FrameLayout) findViewById6;
        View findViewById7 = findViewById(R.id.source_station_metro_route_search_activity);
        k.a((Object) findViewById7, "findViewById(R.id.source…ro_route_search_activity)");
        this.f25891f = (RoboTextView) findViewById7;
        View findViewById8 = findViewById(R.id.destination_station_metro_route_search_activity);
        k.a((Object) findViewById8, "findViewById(R.id.destin…ro_route_search_activity)");
        this.f25892g = (RoboTextView) findViewById8;
        View findViewById9 = findViewById(R.id.lottie_in_search_route_page);
        k.a((Object) findViewById9, "findViewById(R.id.lottie_in_search_route_page)");
        this.p = (LottieAnimationView) findViewById9;
        View findViewById10 = findViewById(R.id.data_layout);
        k.a((Object) findViewById10, "findViewById(R.id.data_layout)");
        this.f25894i = (ScrollView) findViewById10;
        View findViewById11 = findViewById(R.id.not_found_layout);
        k.a((Object) findViewById11, "findViewById(R.id.not_found_layout)");
        this.j = (RelativeLayout) findViewById11;
        View findViewById12 = findViewById(R.id.header_textview_not_found);
        k.a((Object) findViewById12, "findViewById(R.id.header_textview_not_found)");
        this.k = (RoboTextView) findViewById12;
        View findViewById13 = findViewById(R.id.extra_textview_not_found);
        k.a((Object) findViewById13, "findViewById(R.id.extra_textview_not_found)");
        this.l = (RoboTextView) findViewById13;
        RoboTextView roboTextView = this.k;
        if (roboTextView == null) {
            k.a("headerNotFoundTextView");
        }
        roboTextView.setText(getResources().getString(R.string.no_route_found_header));
        RoboTextView roboTextView2 = this.l;
        if (roboTextView2 == null) {
            k.a("extraNotFoundTextView");
        }
        roboTextView2.setText(getResources().getString(R.string.no_route_found));
        ImageView imageView = this.f25890e;
        if (imageView == null) {
            k.a("backButton");
        }
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        ImageView imageView2 = this.f25890e;
        if (imageView2 == null) {
            k.a("backButton");
        }
        imageView2.setRotation(180.0f);
        FrameLayout frameLayout = this.f25889d;
        if (frameLayout == null) {
            k.a("backButtonLayout");
        }
        frameLayout.setOnClickListener(new a(this));
        com.travel.train.f.b bVar = new com.travel.train.f.b(this);
        Intent intent = getIntent();
        ArrayList arrayList = null;
        CJRParcelableMetroStationModel cJRParcelableMetroStationModel = (CJRParcelableMetroStationModel) (intent != null ? intent.getSerializableExtra(com.travel.train.j.g.K) : null);
        if (cJRParcelableMetroStationModel != null) {
            if (cJRParcelableMetroStationModel.sourceStation.length() > this.q && cJRParcelableMetroStationModel.destinationStation.length() > this.q) {
                RoboTextView roboTextView3 = this.f25891f;
                if (roboTextView3 == null) {
                    k.a("sourceStation");
                }
                roboTextView3.setTextSize(0, getResources().getDimension(R.dimen.dimen_15sp));
                RoboTextView roboTextView4 = this.f25892g;
                if (roboTextView4 == null) {
                    k.a("destinationStation");
                }
                roboTextView4.setTextSize(0, getResources().getDimension(R.dimen.dimen_15sp));
                RoboTextView roboTextView5 = this.f25892g;
                if (roboTextView5 == null) {
                    k.a("destinationStation");
                }
                roboTextView5.setPadding(5, 0, 0, 0);
            }
            RoboTextView roboTextView6 = this.f25891f;
            if (roboTextView6 == null) {
                k.a("sourceStation");
            }
            roboTextView6.setText(cJRParcelableMetroStationModel.sourceStation);
            RoboTextView roboTextView7 = this.f25892g;
            if (roboTextView7 == null) {
                k.a("destinationStation");
            }
            roboTextView7.setText(cJRParcelableMetroStationModel.destinationStation);
            this.m = cJRParcelableMetroStationModel.sourceStationCode;
            this.n = cJRParcelableMetroStationModel.destinationStationCode;
            this.o = cJRParcelableMetroStationModel.modeId;
            Context context = this;
            k.c(context, "context");
            k.c(cJRParcelableMetroStationModel, "search");
            k.c(context, "context");
            k.c(cJRParcelableMetroStationModel, "search");
            f fVar = new f();
            w.a aVar = w.f27609a;
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            com.paytm.b.a.a a2 = w.a.a(applicationContext);
            k.c(context, "context");
            f fVar2 = new f();
            w.a aVar2 = w.f27609a;
            Context applicationContext2 = context.getApplicationContext();
            k.a((Object) applicationContext2, "context.applicationContext");
            com.paytm.b.a.a a3 = w.a.a(applicationContext2);
            String str = com.travel.train.j.g.L;
            k.a((Object) str, "CJRTrainConstants.METRO_SEARCH_PREF_KEY");
            ArrayList arrayList2 = (ArrayList) fVar2.a(a3.b(str, "", true), new b.a().getType());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            if (arrayList2 != null) {
                if (arrayList2 == null) {
                    k.a();
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                if (arrayList.isEmpty()) {
                    arrayList.add(0, cJRParcelableMetroStationModel);
                } else if (!arrayList.contains(cJRParcelableMetroStationModel)) {
                    arrayList.add(0, cJRParcelableMetroStationModel);
                }
                if (arrayList.size() > bVar.f26658a) {
                    arrayList.remove(arrayList.size() - 1);
                }
                String a4 = fVar.a((Object) arrayList);
                String str2 = com.travel.train.j.g.L;
                k.a((Object) str2, "CJRTrainConstants.METRO_SEARCH_PREF_KEY");
                a2.a(str2, a4, true);
            }
            String str3 = this.o;
            if (str3 == null) {
                k.a();
            }
            String str4 = this.m;
            if (str4 == null) {
                k.a();
            }
            String str5 = this.n;
            if (str5 == null) {
                k.a();
            }
            k.c(context, "context");
            k.c(str3, "modeId");
            k.c(str4, "sourceStationCode");
            k.c(str5, "destinationStationCode");
            bVar.f26659b = str4;
            bVar.f26660c = str5;
            bVar.f26661d.a(true);
            k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
            com.travel.common.a b2 = com.travel.train.b.b();
            k.a((Object) b2, "TrainController.getInstance().trainEventListener");
            Uri.Builder buildUpon = Uri.parse(b2.ah()).buildUpon();
            buildUpon.appendQueryParameter("modeid", str3);
            buildUpon.appendQueryParameter("origin", str4);
            buildUpon.appendQueryParameter("destination", str5);
            com.paytm.network.a l2 = new com.paytm.network.b().a(context).a(a.c.TRAIN).a(a.b.SILENT).c(com.travel.train.j.g.J).a(a.C0715a.GET).a(buildUpon.build().toString()).a((Map<String, String>) com.travel.train.j.n.b(context)).a((IJRPaytmDataModel) new CJRMetroRouteSearchResponseModel()).a((com.paytm.network.listener.b) bVar).l();
            l2.b(true);
            l2.a();
        }
        com.travel.train.g.a aVar3 = com.travel.train.g.a.f27250a;
        com.travel.train.g.a.a(CJRMetroRouteModel.class).subscribe(new b(this), c.f25897a);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMetroRouteSearchResultActivity f25895a;

        a(AJRMetroRouteSearchResultActivity aJRMetroRouteSearchResultActivity) {
            this.f25895a = aJRMetroRouteSearchResultActivity;
        }

        public final void onClick(View view) {
            this.f25895a.onBackPressed();
        }
    }

    public final void a() {
        ScrollView scrollView = this.f25894i;
        if (scrollView == null) {
            k.a("dataLayout");
        }
        scrollView.setVisibility(8);
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout == null) {
            k.a("notFoundLayout");
        }
        relativeLayout.setVisibility(0);
        RoboTextView roboTextView = this.k;
        if (roboTextView == null) {
            k.a("headerNotFoundTextView");
        }
        ViewGroup.LayoutParams layoutParams = roboTextView.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(13);
            RoboTextView roboTextView2 = this.k;
            if (roboTextView2 == null) {
                k.a("headerNotFoundTextView");
            }
            roboTextView2.setLayoutParams(layoutParams2);
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public final void a(List<? extends CJRMetroRouteModel> list) {
        k.c(list, "routeList");
        RecyclerView recyclerView = this.f25888c;
        if (recyclerView == null) {
            k.a("routeRecyclerView");
        }
        Context context = this;
        String str = this.m;
        if (str == null) {
            k.a();
        }
        String str2 = this.n;
        if (str2 == null) {
            k.a();
        }
        recyclerView.setAdapter(new m(context, list, str, str2));
        RecyclerView recyclerView2 = this.f25888c;
        if (recyclerView2 == null) {
            k.a("routeRecyclerView");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(context, 0, false));
        RecyclerView recyclerView3 = this.f25888c;
        if (recyclerView3 == null) {
            k.a("routeRecyclerView");
        }
        recyclerView3.setHasFixedSize(true);
        RecyclerView recyclerView4 = this.f25888c;
        if (recyclerView4 == null) {
            k.a("routeRecyclerView");
        }
        recyclerView4.getViewTreeObserver().addOnPreDrawListener(new d(this));
    }

    public static final class d implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMetroRouteSearchResultActivity f25898a;

        d(AJRMetroRouteSearchResultActivity aJRMetroRouteSearchResultActivity) {
            this.f25898a = aJRMetroRouteSearchResultActivity;
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f25899a;

            a(d dVar) {
                this.f25899a = dVar;
            }

            public final void run() {
                View view;
                RecyclerView.v findViewHolderForAdapterPosition = AJRMetroRouteSearchResultActivity.b(this.f25899a.f25898a).findViewHolderForAdapterPosition(0);
                if (!(findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null)) {
                    view.performClick();
                }
                AJRMetroRouteSearchResultActivity.b(this.f25899a.f25898a).getViewTreeObserver().removeOnPreDrawListener(this.f25899a);
            }
        }

        public final boolean onPreDraw() {
            this.f25898a.r.postDelayed(new a(this), 500);
            return false;
        }
    }

    public final void a(boolean z) {
        if (z) {
            LottieAnimationView lottieAnimationView = this.p;
            if (lottieAnimationView == null) {
                k.a("lottieAnimationView");
            }
            lottieAnimationView.setVisibility(0);
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.p;
        if (lottieAnimationView2 == null) {
            k.a("lottieAnimationView");
        }
        lottieAnimationView2.setVisibility(4);
    }

    public final Context b() {
        return this;
    }
}
