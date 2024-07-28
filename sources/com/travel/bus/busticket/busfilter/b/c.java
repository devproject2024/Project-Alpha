package com.travel.bus.busticket.busfilter.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.v;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class c extends net.one97.paytm.i.h implements View.OnClickListener, v.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f22074f = new a((byte) 0);
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private LinearLayout E;
    private LinearLayout F;
    private LinearLayout G;
    private LinearLayout H;
    private LinearLayout I;
    private LinearLayout J;
    private LinearLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private ImageView O;
    private ImageView P;
    private ImageView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private ImageView U;
    private ImageView V;
    private ImageView W;
    private ImageView X;
    private ImageView Y;
    private ImageView Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f22075a;
    private RelativeLayout aA;
    private Switch aB;
    private Switch aC;
    private Switch aD;
    private TextView aE;
    private TextView aF;
    private TextView aG;
    private TextView aH;
    private TextView aI;
    private TextView aJ;
    private TextView aK;
    private TextView aL;
    private TextView aM;
    private String aN = "";
    private String aO = "";
    private String aP = "";
    private String aQ = "";
    private String aR = "";
    private String aS = "";
    private String aT = "";
    /* access modifiers changed from: private */
    public String aU = "5 ";
    /* access modifiers changed from: private */
    public String aV = "4+ ";
    /* access modifiers changed from: private */
    public String aW = "3+ ";
    /* access modifiers changed from: private */
    public String aX = "";
    private String aY = "";
    private String aZ = "";
    private ImageView aa;
    private ImageView ab;
    private ImageView ac;
    private ImageView ad;
    private ImageView ae;
    private ImageView af;
    private TextView ag;
    private TextView ah;
    private TextView ai;
    private TextView aj;
    private TextView ak;
    private TextView al;
    private TextView am;
    private TextView an;
    private TextView ao;
    private ConstraintLayout ap;
    private ConstraintLayout aq;
    private ConstraintLayout ar;
    private RoboTextView as;
    private RoboTextView at;
    private RoboTextView au;
    private RoboTextView av;
    private RoboTextView aw;
    private RoboTextView ax;
    private RelativeLayout ay;
    private RelativeLayout az;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CJRBusSearchAmenitiesInfo> f22076b = new ArrayList<>();
    private HashMap<String, CJRBusSearchAmenitiesInfo> ba;
    private HashMap<String, CJRBusSearchOperatorTagInfo> bb;
    private final ArrayList<CJRBusSearchOperatorTagInfo> bc = new ArrayList<>();
    private final ArrayList<CJRBusSearchAmenitiesInfo> bd = new ArrayList<>();
    private CJRBusTicketFilterItem be;
    private v bf;
    private boolean bg;
    /* access modifiers changed from: private */
    public String bh = "";
    private ArrayList<CJRBusSearchItem> bi;
    private com.travel.bus.busticket.busfilter.b bj;
    private final View.OnClickListener bk = new C0436c(this);
    private final View.OnClickListener bl = new d(this);
    private final View.OnClickListener bm = new g(this);
    private final View.OnClickListener bn = new b(this);
    private final View.OnClickListener bo = new e(this);
    private final View.OnClickListener bp = new f(this);
    private final View.OnClickListener bq = new l(this);
    private HashMap br;

    /* renamed from: c  reason: collision with root package name */
    public CJRBusTicketFilters f22077c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRBusSearchOperatorTagInfo> f22078d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f22079e;

    /* renamed from: g  reason: collision with root package name */
    private final String f22080g = "BusHomeFilterFragment";

    /* renamed from: h  reason: collision with root package name */
    private final int f22081h = 1;

    /* renamed from: i  reason: collision with root package name */
    private final int f22082i = 2;
    private final int j = 3;
    /* access modifiers changed from: private */
    public final String k = "0000";
    /* access modifiers changed from: private */
    public final String l = "2400";
    /* access modifiers changed from: private */
    public final String m = "0600";
    /* access modifiers changed from: private */
    public final String n = "1200";
    /* access modifiers changed from: private */
    public final String o = "1800";
    private RelativeLayout p;
    private RelativeLayout q;
    private RelativeLayout r;
    private RelativeLayout s;
    private RelativeLayout t;
    private RecyclerView u;
    private Button v;
    private LinearLayout w;
    private LinearLayout x;
    private LinearLayout y;
    private LinearLayout z;

    static final class h<T> implements z<CJRBusTicketFilters> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22089a;

        h(c cVar) {
            this.f22089a = cVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            CJRBusTicketFilters cJRBusTicketFilters = (CJRBusTicketFilters) obj;
            kotlin.g.b.k.c(cJRBusTicketFilters, "cjrBusTicketFilters");
            this.f22089a.f22077c = cJRBusTicketFilters;
            c cVar = this.f22089a;
            CJRBusTicketFilters a2 = cVar.f22077c;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            ArrayList<CJRBusSearchAmenitiesInfo> arrayList = a2.getmCurrentSelectedAmenityList();
            kotlin.g.b.k.a((Object) arrayList, "mBusTicketFilters!!.getm…rentSelectedAmenityList()");
            cVar.f22076b = arrayList;
            this.f22089a.o();
        }
    }

    public static final /* synthetic */ RoboTextView A(c cVar) {
        RoboTextView roboTextView = cVar.au;
        if (roboTextView == null) {
            kotlin.g.b.k.a("mTvRatingsAbove4");
        }
        return roboTextView;
    }

    public static final /* synthetic */ RoboTextView B(c cVar) {
        RoboTextView roboTextView = cVar.av;
        if (roboTextView == null) {
            kotlin.g.b.k.a("mTvRatingsAbove4Text");
        }
        return roboTextView;
    }

    public static final /* synthetic */ ConstraintLayout C(c cVar) {
        ConstraintLayout constraintLayout = cVar.ar;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mClRatingsAbove3");
        }
        return constraintLayout;
    }

    public static final /* synthetic */ RoboTextView E(c cVar) {
        RoboTextView roboTextView = cVar.aw;
        if (roboTextView == null) {
            kotlin.g.b.k.a("mTvRatingsAbove3");
        }
        return roboTextView;
    }

    public static final /* synthetic */ RoboTextView F(c cVar) {
        RoboTextView roboTextView = cVar.ax;
        if (roboTextView == null) {
            kotlin.g.b.k.a("mTvRatingsAbove3Text");
        }
        return roboTextView;
    }

    public static final /* synthetic */ LinearLayout e(c cVar) {
        LinearLayout linearLayout = cVar.I;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytTypeSingleAxle");
        }
        return linearLayout;
    }

    public static final /* synthetic */ LinearLayout f(c cVar) {
        LinearLayout linearLayout = cVar.J;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytTypeMultiAxle");
        }
        return linearLayout;
    }

    public static final /* synthetic */ LinearLayout o(c cVar) {
        LinearLayout linearLayout = cVar.K;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytSortTopRated");
        }
        return linearLayout;
    }

    public static final /* synthetic */ LinearLayout p(c cVar) {
        LinearLayout linearLayout = cVar.L;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytSortCheapest");
        }
        return linearLayout;
    }

    public static final /* synthetic */ LinearLayout q(c cVar) {
        LinearLayout linearLayout = cVar.M;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytSortLateBoarding");
        }
        return linearLayout;
    }

    public static final /* synthetic */ LinearLayout r(c cVar) {
        LinearLayout linearLayout = cVar.N;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytSortEarlyBoarding");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ConstraintLayout t(c cVar) {
        ConstraintLayout constraintLayout = cVar.ap;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mClRatings5");
        }
        return constraintLayout;
    }

    public static final /* synthetic */ RoboTextView w(c cVar) {
        RoboTextView roboTextView = cVar.as;
        if (roboTextView == null) {
            kotlin.g.b.k.a("mTvRatings5");
        }
        return roboTextView;
    }

    public static final /* synthetic */ RoboTextView x(c cVar) {
        RoboTextView roboTextView = cVar.at;
        if (roboTextView == null) {
            kotlin.g.b.k.a("mTvRatingsText5");
        }
        return roboTextView;
    }

    public static final /* synthetic */ ConstraintLayout y(c cVar) {
        ConstraintLayout constraintLayout = cVar.aq;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mClRatingsAbove4");
        }
        return constraintLayout;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.bus_home_filter_fragment, viewGroup, false);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                kotlin.g.b.k.a();
            }
            if (arguments.containsKey("intent_extra_bus_start_city")) {
                Bundle arguments2 = getArguments();
                if (arguments2 == null) {
                    kotlin.g.b.k.a();
                }
                String string = arguments2.getString("intent_extra_bus_start_city");
                if (string == null) {
                    kotlin.g.b.k.a();
                }
                this.aN = string;
            }
        }
        if (getArguments() != null) {
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments3.containsKey("intent_extra_bus_dest_city")) {
                Bundle arguments4 = getArguments();
                if (arguments4 == null) {
                    kotlin.g.b.k.a();
                }
                String string2 = arguments4.getString("intent_extra_bus_dest_city");
                if (string2 == null) {
                    kotlin.g.b.k.a();
                }
                this.aO = string2;
            }
        }
        if (getArguments() != null) {
            Bundle arguments5 = getArguments();
            if (arguments5 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments5.containsKey("intent_extra_bus_search_filter_items")) {
                Bundle arguments6 = getArguments();
                if (arguments6 == null) {
                    kotlin.g.b.k.a();
                }
                Serializable serializable = arguments6.getSerializable("intent_extra_bus_search_filter_items");
                if (serializable != null) {
                    this.f22077c = (CJRBusTicketFilters) serializable;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
                }
            }
        }
        if (getArguments() != null) {
            Bundle arguments7 = getArguments();
            if (arguments7 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments7.containsKey("amenity_info")) {
                Bundle arguments8 = getArguments();
                if (arguments8 == null) {
                    kotlin.g.b.k.a();
                }
                Serializable serializable2 = arguments8.getSerializable("amenity_info");
                if (serializable2 != null) {
                    this.ba = (HashMap) serializable2;
                } else {
                    throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo>");
                }
            }
        }
        if (getArguments() != null) {
            Bundle arguments9 = getArguments();
            if (arguments9 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments9.containsKey("operatortag_info")) {
                Bundle arguments10 = getArguments();
                if (arguments10 == null) {
                    kotlin.g.b.k.a();
                }
                Serializable serializable3 = arguments10.getSerializable("operatortag_info");
                if (serializable3 != null) {
                    this.bb = (HashMap) serializable3;
                } else {
                    throw new u("null cannot be cast to non-null type java.util.HashMap<kotlin.String, com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo>");
                }
            }
        }
        if (getArguments() != null) {
            Bundle arguments11 = getArguments();
            if (arguments11 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments11.containsKey("intent_extra_bus_search_filter_amenity_items")) {
                Bundle arguments12 = getArguments();
                if (arguments12 == null) {
                    kotlin.g.b.k.a();
                }
                Serializable serializable4 = arguments12.getSerializable("intent_extra_bus_search_filter_amenity_items");
                if (serializable4 != null) {
                    this.f22076b = (ArrayList) serializable4;
                    this.bd.addAll(this.f22076b);
                } else {
                    throw new u("null cannot be cast to non-null type java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo>");
                }
            }
        }
        if (getArguments() != null) {
            Bundle arguments13 = getArguments();
            if (arguments13 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments13.containsKey("intent_extra_bus_search_filter_is_deals_available")) {
                Bundle arguments14 = getArguments();
                if (arguments14 == null) {
                    kotlin.g.b.k.a();
                }
                this.bg = arguments14.getBoolean("intent_extra_bus_search_filter_is_deals_available");
            }
        }
        if (getArguments() != null) {
            Bundle arguments15 = getArguments();
            if (arguments15 == null) {
                kotlin.g.b.k.a();
            }
            if (arguments15.containsKey("intent_extra_bus_search_filter_is_popular_choice")) {
                Bundle arguments16 = getArguments();
                if (arguments16 == null) {
                    kotlin.g.b.k.a();
                }
                String string3 = arguments16.getString("intent_extra_bus_search_filter_is_popular_choice");
                if (string3 == null) {
                    kotlin.g.b.k.a();
                }
                this.bh = string3;
            }
        }
        if (this.f22077c == null) {
            this.f22077c = new CJRBusTicketFilters();
            ArrayList arrayList = new ArrayList();
            CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
            if (cJRBusTicketFilters != null) {
                cJRBusTicketFilters.setBusTicketFilterItems(arrayList);
            }
        }
        CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
        this.be = cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusFilterItemByTitle("Price") : null;
        if (this.be == null) {
            this.be = new CJRBusTicketFilterItem();
            CJRBusTicketFilterItem cJRBusTicketFilterItem = this.be;
            if (cJRBusTicketFilterItem == null) {
                kotlin.g.b.k.a();
            }
            cJRBusTicketFilterItem.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_FARE);
            CJRBusTicketFilterItem cJRBusTicketFilterItem2 = this.be;
            if (cJRBusTicketFilterItem2 == null) {
                kotlin.g.b.k.a();
            }
            cJRBusTicketFilterItem2.setTitle("Price");
            CJRBusTicketFilterItem cJRBusTicketFilterItem3 = this.be;
            if (cJRBusTicketFilterItem3 == null) {
                kotlin.g.b.k.a();
            }
            cJRBusTicketFilterItem3.setType("range_slider");
        }
        this.bi = com.travel.bus.busticket.i.d.a().c();
        kotlin.g.b.k.a((Object) inflate, "view");
        View findViewById = inflate.findViewById(R.id.lyt_operators_container);
        kotlin.g.b.k.a((Object) findViewById, "view.findViewById(R.id.lyt_operators_container)");
        this.p = (RelativeLayout) findViewById;
        RelativeLayout relativeLayout = this.p;
        if (relativeLayout == null) {
            kotlin.g.b.k.a("mOperatorsContainer");
        }
        View.OnClickListener onClickListener = this;
        relativeLayout.setOnClickListener(onClickListener);
        View findViewById2 = inflate.findViewById(R.id.lyt_boarding_points_container);
        kotlin.g.b.k.a((Object) findViewById2, "view.findViewById(R.id.l…oarding_points_container)");
        this.q = (RelativeLayout) findViewById2;
        RelativeLayout relativeLayout2 = this.q;
        if (relativeLayout2 == null) {
            kotlin.g.b.k.a("mBoardingPointsContainer");
        }
        relativeLayout2.setOnClickListener(onClickListener);
        View findViewById3 = inflate.findViewById(R.id.lyt_dropping_points_container);
        kotlin.g.b.k.a((Object) findViewById3, "view.findViewById(R.id.l…ropping_points_container)");
        this.r = (RelativeLayout) findViewById3;
        RelativeLayout relativeLayout3 = this.r;
        if (relativeLayout3 == null) {
            kotlin.g.b.k.a("mDroppingPointsContainer");
        }
        relativeLayout3.setOnClickListener(onClickListener);
        View findViewById4 = inflate.findViewById(R.id.lyt_amenities_container);
        kotlin.g.b.k.a((Object) findViewById4, "view.findViewById(R.id.lyt_amenities_container)");
        this.s = (RelativeLayout) findViewById4;
        RelativeLayout relativeLayout4 = this.s;
        if (relativeLayout4 == null) {
            kotlin.g.b.k.a("mAmenityContainer");
        }
        relativeLayout4.setOnClickListener(onClickListener);
        View findViewById5 = inflate.findViewById(R.id.lyt_operators_tags_container);
        kotlin.g.b.k.a((Object) findViewById5, "view.findViewById(R.id.l…operators_tags_container)");
        this.t = (RelativeLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.recyclerOperatorTagList);
        kotlin.g.b.k.a((Object) findViewById6, "view.findViewById(R.id.recyclerOperatorTagList)");
        this.u = (RecyclerView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.apply_filter_button);
        kotlin.g.b.k.a((Object) findViewById7, "view.findViewById(R.id.apply_filter_button)");
        this.v = (Button) findViewById7;
        Button button = this.v;
        if (button == null) {
            kotlin.g.b.k.a("mApplyFilterButton");
        }
        button.setOnClickListener(onClickListener);
        View findViewById8 = inflate.findViewById(R.id.lyt_time_morning);
        kotlin.g.b.k.a((Object) findViewById8, "view.findViewById(R.id.lyt_time_morning)");
        this.w = (LinearLayout) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.lyt_time_afternoon);
        kotlin.g.b.k.a((Object) findViewById9, "view.findViewById(R.id.lyt_time_afternoon)");
        this.x = (LinearLayout) findViewById9;
        View findViewById10 = inflate.findViewById(R.id.lyt_time_evening);
        kotlin.g.b.k.a((Object) findViewById10, "view.findViewById(R.id.lyt_time_evening)");
        this.y = (LinearLayout) findViewById10;
        View findViewById11 = inflate.findViewById(R.id.lyt_time_night);
        kotlin.g.b.k.a((Object) findViewById11, "view.findViewById(R.id.lyt_time_night)");
        this.z = (LinearLayout) findViewById11;
        LinearLayout linearLayout = this.w;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytTimeMorning");
        }
        linearLayout.setOnClickListener(this.bm);
        LinearLayout linearLayout2 = this.x;
        if (linearLayout2 == null) {
            kotlin.g.b.k.a("mLytTimeAfternoon");
        }
        linearLayout2.setOnClickListener(this.bm);
        LinearLayout linearLayout3 = this.y;
        if (linearLayout3 == null) {
            kotlin.g.b.k.a("mLytTimeEvening");
        }
        linearLayout3.setOnClickListener(this.bm);
        LinearLayout linearLayout4 = this.z;
        if (linearLayout4 == null) {
            kotlin.g.b.k.a("mLytTimeNight");
        }
        linearLayout4.setOnClickListener(this.bm);
        View findViewById12 = inflate.findViewById(R.id.lyt_ac);
        kotlin.g.b.k.a((Object) findViewById12, "view.findViewById(R.id.lyt_ac)");
        this.A = (LinearLayout) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.lyt_non_ac);
        kotlin.g.b.k.a((Object) findViewById13, "view.findViewById(R.id.lyt_non_ac)");
        this.B = (LinearLayout) findViewById13;
        LinearLayout linearLayout5 = this.A;
        if (linearLayout5 == null) {
            kotlin.g.b.k.a("mLytTypeAC");
        }
        linearLayout5.setOnClickListener(this.bn);
        LinearLayout linearLayout6 = this.B;
        if (linearLayout6 == null) {
            kotlin.g.b.k.a("mLytTypeNonAC");
        }
        linearLayout6.setOnClickListener(this.bn);
        View findViewById14 = inflate.findViewById(R.id.lyt_seater);
        kotlin.g.b.k.a((Object) findViewById14, "view.findViewById(R.id.lyt_seater)");
        this.C = (LinearLayout) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.lyt_sleeper);
        kotlin.g.b.k.a((Object) findViewById15, "view.findViewById(R.id.lyt_sleeper)");
        this.D = (LinearLayout) findViewById15;
        View findViewById16 = inflate.findViewById(R.id.lyt_semi_sleeper);
        kotlin.g.b.k.a((Object) findViewById16, "view.findViewById(R.id.lyt_semi_sleeper)");
        this.E = (LinearLayout) findViewById16;
        LinearLayout linearLayout7 = this.C;
        if (linearLayout7 == null) {
            kotlin.g.b.k.a("mLytTypeSeater");
        }
        linearLayout7.setOnClickListener(this.bo);
        LinearLayout linearLayout8 = this.D;
        if (linearLayout8 == null) {
            kotlin.g.b.k.a("mLytTypeSleeper");
        }
        linearLayout8.setOnClickListener(this.bo);
        LinearLayout linearLayout9 = this.E;
        if (linearLayout9 == null) {
            kotlin.g.b.k.a("mLytTypeSemiSleeper");
        }
        linearLayout9.setOnClickListener(this.bo);
        View findViewById17 = inflate.findViewById(R.id.lyt_bus_type_volvo);
        kotlin.g.b.k.a((Object) findViewById17, "view.findViewById(R.id.lyt_bus_type_volvo)");
        this.F = (LinearLayout) findViewById17;
        View findViewById18 = inflate.findViewById(R.id.lyt_bus_type_scania);
        kotlin.g.b.k.a((Object) findViewById18, "view.findViewById(R.id.lyt_bus_type_scania)");
        this.G = (LinearLayout) findViewById18;
        View findViewById19 = inflate.findViewById(R.id.lyt_bus_type_mercedes);
        kotlin.g.b.k.a((Object) findViewById19, "view.findViewById(R.id.lyt_bus_type_mercedes)");
        this.H = (LinearLayout) findViewById19;
        LinearLayout linearLayout10 = this.F;
        if (linearLayout10 == null) {
            kotlin.g.b.k.a("mLytTypeVolvo");
        }
        linearLayout10.setOnClickListener(this.bl);
        LinearLayout linearLayout11 = this.G;
        if (linearLayout11 == null) {
            kotlin.g.b.k.a("mLytTypeScania");
        }
        linearLayout11.setOnClickListener(this.bl);
        LinearLayout linearLayout12 = this.H;
        if (linearLayout12 == null) {
            kotlin.g.b.k.a("mLytTypeMercedes");
        }
        linearLayout12.setOnClickListener(this.bl);
        View findViewById20 = inflate.findViewById(R.id.lyt_bus_single_axle);
        kotlin.g.b.k.a((Object) findViewById20, "view.findViewById(R.id.lyt_bus_single_axle)");
        this.I = (LinearLayout) findViewById20;
        View findViewById21 = inflate.findViewById(R.id.lyt_bus_multi_axle);
        kotlin.g.b.k.a((Object) findViewById21, "view.findViewById(R.id.lyt_bus_multi_axle)");
        this.J = (LinearLayout) findViewById21;
        LinearLayout linearLayout13 = this.I;
        if (linearLayout13 == null) {
            kotlin.g.b.k.a("mLytTypeSingleAxle");
        }
        linearLayout13.setOnClickListener(this.bk);
        LinearLayout linearLayout14 = this.J;
        if (linearLayout14 == null) {
            kotlin.g.b.k.a("mLytTypeMultiAxle");
        }
        linearLayout14.setOnClickListener(this.bk);
        View findViewById22 = inflate.findViewById(R.id.lyt_sort_top_rated);
        kotlin.g.b.k.a((Object) findViewById22, "view.findViewById(R.id.lyt_sort_top_rated)");
        this.K = (LinearLayout) findViewById22;
        View findViewById23 = inflate.findViewById(R.id.lyt_sort_cheapest);
        kotlin.g.b.k.a((Object) findViewById23, "view.findViewById(R.id.lyt_sort_cheapest)");
        this.L = (LinearLayout) findViewById23;
        View findViewById24 = inflate.findViewById(R.id.lyt_sort_late_baording);
        kotlin.g.b.k.a((Object) findViewById24, "view.findViewById(R.id.lyt_sort_late_baording)");
        this.M = (LinearLayout) findViewById24;
        View findViewById25 = inflate.findViewById(R.id.lyt_sort_early_baording);
        kotlin.g.b.k.a((Object) findViewById25, "view.findViewById(R.id.lyt_sort_early_baording)");
        this.N = (LinearLayout) findViewById25;
        LinearLayout linearLayout15 = this.K;
        if (linearLayout15 == null) {
            kotlin.g.b.k.a("mLytSortTopRated");
        }
        linearLayout15.setOnClickListener(this.bp);
        LinearLayout linearLayout16 = this.L;
        if (linearLayout16 == null) {
            kotlin.g.b.k.a("mLytSortCheapest");
        }
        linearLayout16.setOnClickListener(this.bp);
        LinearLayout linearLayout17 = this.M;
        if (linearLayout17 == null) {
            kotlin.g.b.k.a("mLytSortLateBoarding");
        }
        linearLayout17.setOnClickListener(this.bp);
        LinearLayout linearLayout18 = this.N;
        if (linearLayout18 == null) {
            kotlin.g.b.k.a("mLytSortEarlyBoarding");
        }
        linearLayout18.setOnClickListener(this.bp);
        View findViewById26 = inflate.findViewById(R.id.txt_time_morning);
        kotlin.g.b.k.a((Object) findViewById26, "view.findViewById(R.id.txt_time_morning)");
        this.ag = (TextView) findViewById26;
        View findViewById27 = inflate.findViewById(R.id.txt_time_afternoon);
        kotlin.g.b.k.a((Object) findViewById27, "view.findViewById(R.id.txt_time_afternoon)");
        this.ah = (TextView) findViewById27;
        View findViewById28 = inflate.findViewById(R.id.txt_time_evening);
        kotlin.g.b.k.a((Object) findViewById28, "view.findViewById(R.id.txt_time_evening)");
        this.ai = (TextView) findViewById28;
        View findViewById29 = inflate.findViewById(R.id.txt_time_night);
        kotlin.g.b.k.a((Object) findViewById29, "view.findViewById(R.id.txt_time_night)");
        this.aj = (TextView) findViewById29;
        View findViewById30 = inflate.findViewById(R.id.txt_ac);
        kotlin.g.b.k.a((Object) findViewById30, "view.findViewById(R.id.txt_ac)");
        this.ak = (TextView) findViewById30;
        View findViewById31 = inflate.findViewById(R.id.txt_non_ac);
        kotlin.g.b.k.a((Object) findViewById31, "view.findViewById(R.id.txt_non_ac)");
        this.al = (TextView) findViewById31;
        View findViewById32 = inflate.findViewById(R.id.txt_seater);
        kotlin.g.b.k.a((Object) findViewById32, "view.findViewById(R.id.txt_seater)");
        this.am = (TextView) findViewById32;
        View findViewById33 = inflate.findViewById(R.id.txt_sleeper);
        kotlin.g.b.k.a((Object) findViewById33, "view.findViewById(R.id.txt_sleeper)");
        this.an = (TextView) findViewById33;
        View findViewById34 = inflate.findViewById(R.id.txt_semi_sleeper);
        kotlin.g.b.k.a((Object) findViewById34, "view.findViewById(R.id.txt_semi_sleeper)");
        this.ao = (TextView) findViewById34;
        View findViewById35 = inflate.findViewById(R.id.img_time_morning);
        kotlin.g.b.k.a((Object) findViewById35, "view.findViewById(R.id.img_time_morning)");
        this.O = (ImageView) findViewById35;
        View findViewById36 = inflate.findViewById(R.id.img_time_afternoon);
        kotlin.g.b.k.a((Object) findViewById36, "view.findViewById(R.id.img_time_afternoon)");
        this.P = (ImageView) findViewById36;
        View findViewById37 = inflate.findViewById(R.id.img_time_evening);
        kotlin.g.b.k.a((Object) findViewById37, "view.findViewById(R.id.img_time_evening)");
        this.Q = (ImageView) findViewById37;
        View findViewById38 = inflate.findViewById(R.id.img_time_night);
        kotlin.g.b.k.a((Object) findViewById38, "view.findViewById(R.id.img_time_night)");
        this.R = (ImageView) findViewById38;
        View findViewById39 = inflate.findViewById(R.id.img_ac);
        kotlin.g.b.k.a((Object) findViewById39, "view.findViewById(R.id.img_ac)");
        this.S = (ImageView) findViewById39;
        View findViewById40 = inflate.findViewById(R.id.img_non_ac);
        kotlin.g.b.k.a((Object) findViewById40, "view.findViewById(R.id.img_non_ac)");
        this.T = (ImageView) findViewById40;
        View findViewById41 = inflate.findViewById(R.id.img_seater);
        kotlin.g.b.k.a((Object) findViewById41, "view.findViewById(R.id.img_seater)");
        this.U = (ImageView) findViewById41;
        View findViewById42 = inflate.findViewById(R.id.img_sleeper);
        kotlin.g.b.k.a((Object) findViewById42, "view.findViewById(R.id.img_sleeper)");
        this.V = (ImageView) findViewById42;
        View findViewById43 = inflate.findViewById(R.id.img_semi_sleeper);
        kotlin.g.b.k.a((Object) findViewById43, "view.findViewById(R.id.img_semi_sleeper)");
        this.W = (ImageView) findViewById43;
        View findViewById44 = inflate.findViewById(R.id.img_bus_type_volvo);
        kotlin.g.b.k.a((Object) findViewById44, "view.findViewById(R.id.img_bus_type_volvo)");
        this.X = (ImageView) findViewById44;
        View findViewById45 = inflate.findViewById(R.id.img_bus_type_scania);
        kotlin.g.b.k.a((Object) findViewById45, "view.findViewById(R.id.img_bus_type_scania)");
        this.Y = (ImageView) findViewById45;
        View findViewById46 = inflate.findViewById(R.id.img_bus_type_mercedes);
        kotlin.g.b.k.a((Object) findViewById46, "view.findViewById(R.id.img_bus_type_mercedes)");
        this.Z = (ImageView) findViewById46;
        View findViewById47 = inflate.findViewById(R.id.img_bus_single_axle);
        kotlin.g.b.k.a((Object) findViewById47, "view.findViewById(R.id.img_bus_single_axle)");
        this.aa = (ImageView) findViewById47;
        View findViewById48 = inflate.findViewById(R.id.img_bus_multi_axle);
        kotlin.g.b.k.a((Object) findViewById48, "view.findViewById(R.id.img_bus_multi_axle)");
        this.ab = (ImageView) findViewById48;
        View findViewById49 = inflate.findViewById(R.id.img_sort_top_rated);
        kotlin.g.b.k.a((Object) findViewById49, "view.findViewById(R.id.img_sort_top_rated)");
        this.ac = (ImageView) findViewById49;
        View findViewById50 = inflate.findViewById(R.id.img_sort_cheapest);
        kotlin.g.b.k.a((Object) findViewById50, "view.findViewById(R.id.img_sort_cheapest)");
        this.ad = (ImageView) findViewById50;
        View findViewById51 = inflate.findViewById(R.id.img_sort_late_baording);
        kotlin.g.b.k.a((Object) findViewById51, "view.findViewById(R.id.img_sort_late_baording)");
        this.ae = (ImageView) findViewById51;
        View findViewById52 = inflate.findViewById(R.id.img_sort_early_baording);
        kotlin.g.b.k.a((Object) findViewById52, "view.findViewById(R.id.img_sort_early_baording)");
        this.af = (ImageView) findViewById52;
        View findViewById53 = inflate.findViewById(R.id.switch_deals_buses_toggle);
        kotlin.g.b.k.a((Object) findViewById53, "view.findViewById(R.id.switch_deals_buses_toggle)");
        this.aB = (Switch) findViewById53;
        View findViewById54 = inflate.findViewById(R.id.switch_deals_popular_choice);
        kotlin.g.b.k.a((Object) findViewById54, "view.findViewById(R.id.s…tch_deals_popular_choice)");
        this.aC = (Switch) findViewById54;
        View findViewById55 = inflate.findViewById(R.id.sw_covid_buses_toggle);
        kotlin.g.b.k.a((Object) findViewById55, "view.findViewById(R.id.sw_covid_buses_toggle)");
        this.aD = (Switch) findViewById55;
        View findViewById56 = inflate.findViewById(R.id.rl_covid_social_distance);
        kotlin.g.b.k.a((Object) findViewById56, "view.findViewById(R.id.rl_covid_social_distance)");
        this.ay = (RelativeLayout) findViewById56;
        View findViewById57 = inflate.findViewById(R.id.rel_deals);
        kotlin.g.b.k.a((Object) findViewById57, "view.findViewById(R.id.rel_deals)");
        this.az = (RelativeLayout) findViewById57;
        View findViewById58 = inflate.findViewById(R.id.rel_popular_choice);
        kotlin.g.b.k.a((Object) findViewById58, "view.findViewById(R.id.rel_popular_choice)");
        this.aA = (RelativeLayout) findViewById58;
        View findViewById59 = inflate.findViewById(R.id.cl_5_ratings);
        kotlin.g.b.k.a((Object) findViewById59, "view.findViewById(R.id.cl_5_ratings)");
        this.ap = (ConstraintLayout) findViewById59;
        View findViewById60 = inflate.findViewById(R.id.cl_4above_ratings);
        kotlin.g.b.k.a((Object) findViewById60, "view.findViewById(R.id.cl_4above_ratings)");
        this.aq = (ConstraintLayout) findViewById60;
        View findViewById61 = inflate.findViewById(R.id.cl_3above_ratings);
        kotlin.g.b.k.a((Object) findViewById61, "view.findViewById(R.id.cl_3above_ratings)");
        this.ar = (ConstraintLayout) findViewById61;
        View findViewById62 = inflate.findViewById(R.id.tv_3_above_ratings);
        kotlin.g.b.k.a((Object) findViewById62, "view.findViewById(R.id.tv_3_above_ratings)");
        this.aw = (RoboTextView) findViewById62;
        View findViewById63 = inflate.findViewById(R.id.tv_3_above_ratings_text);
        kotlin.g.b.k.a((Object) findViewById63, "view.findViewById(R.id.tv_3_above_ratings_text)");
        this.ax = (RoboTextView) findViewById63;
        View findViewById64 = inflate.findViewById(R.id.tv_4_above_ratings_text);
        kotlin.g.b.k.a((Object) findViewById64, "view.findViewById(R.id.tv_4_above_ratings_text)");
        this.av = (RoboTextView) findViewById64;
        View findViewById65 = inflate.findViewById(R.id.tv_4_above_ratings);
        kotlin.g.b.k.a((Object) findViewById65, "view.findViewById(R.id.tv_4_above_ratings)");
        this.au = (RoboTextView) findViewById65;
        View findViewById66 = inflate.findViewById(R.id.tv_5_star_ratings);
        kotlin.g.b.k.a((Object) findViewById66, "view.findViewById(R.id.tv_5_star_ratings)");
        this.as = (RoboTextView) findViewById66;
        View findViewById67 = inflate.findViewById(R.id.tv_5_star_ratings_text);
        kotlin.g.b.k.a((Object) findViewById67, "view.findViewById(R.id.tv_5_star_ratings_text)");
        this.at = (RoboTextView) findViewById67;
        ConstraintLayout constraintLayout = this.ap;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mClRatings5");
        }
        constraintLayout.setOnClickListener(this.bq);
        ConstraintLayout constraintLayout2 = this.aq;
        if (constraintLayout2 == null) {
            kotlin.g.b.k.a("mClRatingsAbove4");
        }
        constraintLayout2.setOnClickListener(this.bq);
        ConstraintLayout constraintLayout3 = this.ar;
        if (constraintLayout3 == null) {
            kotlin.g.b.k.a("mClRatingsAbove3");
        }
        constraintLayout3.setOnClickListener(this.bq);
        View findViewById68 = inflate.findViewById(R.id.txt_bus_type_label);
        kotlin.g.b.k.a((Object) findViewById68, "view.findViewById(R.id.txt_bus_type_label)");
        this.aE = (TextView) findViewById68;
        View findViewById69 = inflate.findViewById(R.id.txt_departure_time_label);
        kotlin.g.b.k.a((Object) findViewById69, "view.findViewById(R.id.txt_departure_time_label)");
        this.aF = (TextView) findViewById69;
        View findViewById70 = inflate.findViewById(R.id.txt_boardingPoints);
        kotlin.g.b.k.a((Object) findViewById70, "view.findViewById(R.id.txt_boardingPoints)");
        this.aG = (TextView) findViewById70;
        View findViewById71 = inflate.findViewById(R.id.txt_boarding_points_count);
        kotlin.g.b.k.a((Object) findViewById71, "view.findViewById(R.id.txt_boarding_points_count)");
        this.aH = (TextView) findViewById71;
        View findViewById72 = inflate.findViewById(R.id.txt_droppingPoints);
        kotlin.g.b.k.a((Object) findViewById72, "view.findViewById(R.id.txt_droppingPoints)");
        this.aI = (TextView) findViewById72;
        View findViewById73 = inflate.findViewById(R.id.txt_dropping_points_count);
        kotlin.g.b.k.a((Object) findViewById73, "view.findViewById(R.id.txt_dropping_points_count)");
        this.aJ = (TextView) findViewById73;
        View findViewById74 = inflate.findViewById(R.id.txt_operators);
        kotlin.g.b.k.a((Object) findViewById74, "view.findViewById(R.id.txt_operators)");
        this.aK = (TextView) findViewById74;
        View findViewById75 = inflate.findViewById(R.id.txt_operators_count);
        kotlin.g.b.k.a((Object) findViewById75, "view.findViewById(R.id.txt_operators_count)");
        this.aL = (TextView) findViewById75;
        View findViewById76 = inflate.findViewById(R.id.txt_amenities_count);
        kotlin.g.b.k.a((Object) findViewById76, "view.findViewById(R.id.txt_amenities_count)");
        this.aM = (TextView) findViewById76;
        TextView textView = this.aF;
        if (textView == null) {
            kotlin.g.b.k.a("mTextDepartureTimeLabel");
        }
        textView.setText(getResources().getText(R.string.departure).toString() + " " + getString(R.string.from_text) + " " + this.aN);
        getActivity();
        TextView textView2 = this.aE;
        if (textView2 == null) {
            kotlin.g.b.k.a("mTextBusTypeLabel");
        }
        com.paytm.utility.b.a(textView2);
        getActivity();
        TextView textView3 = this.aF;
        if (textView3 == null) {
            kotlin.g.b.k.a("mTextDepartureTimeLabel");
        }
        com.paytm.utility.b.a(textView3);
        getActivity();
        TextView textView4 = this.aG;
        if (textView4 == null) {
            kotlin.g.b.k.a("mTextBoardingPoints");
        }
        com.paytm.utility.b.a(textView4);
        getActivity();
        TextView textView5 = this.aH;
        if (textView5 == null) {
            kotlin.g.b.k.a("mTextBoardingPointsCount");
        }
        com.paytm.utility.b.a(textView5);
        getActivity();
        TextView textView6 = this.aI;
        if (textView6 == null) {
            kotlin.g.b.k.a("mTextDroppingPoints");
        }
        com.paytm.utility.b.a(textView6);
        getActivity();
        TextView textView7 = this.aJ;
        if (textView7 == null) {
            kotlin.g.b.k.a("mTextDroppingPointsCount");
        }
        com.paytm.utility.b.a(textView7);
        getActivity();
        TextView textView8 = this.aK;
        if (textView8 == null) {
            kotlin.g.b.k.a("mTextOperators");
        }
        com.paytm.utility.b.a(textView8);
        getActivity();
        TextView textView9 = this.aL;
        if (textView9 == null) {
            kotlin.g.b.k.a("mTextOperatorsCount");
        }
        com.paytm.utility.b.a(textView9);
        getActivity();
        TextView textView10 = this.aM;
        if (textView10 == null) {
            kotlin.g.b.k.a("mTextAmenitiesCount");
        }
        com.paytm.utility.b.a(textView10);
        RelativeLayout relativeLayout5 = this.az;
        if (relativeLayout5 == null) {
            kotlin.g.b.k.a("mRlDealsView");
        }
        relativeLayout5.setVisibility(0);
        RelativeLayout relativeLayout6 = this.aA;
        if (relativeLayout6 == null) {
            kotlin.g.b.k.a("mRlPopularChoiceView");
        }
        relativeLayout6.setVisibility(8);
        if (!TextUtils.isEmpty(this.bh)) {
            RelativeLayout relativeLayout7 = this.aA;
            if (relativeLayout7 == null) {
                kotlin.g.b.k.a("mRlPopularChoiceView");
            }
            relativeLayout7.setVisibility(0);
        }
        Switch switchR = this.aB;
        if (switchR == null) {
            kotlin.g.b.k.a("mDealsToggleButton");
        }
        switchR.setOnCheckedChangeListener(new i(this));
        Switch switchR2 = this.aD;
        if (switchR2 == null) {
            kotlin.g.b.k.a("mSwCovidBuses");
        }
        switchR2.setOnCheckedChangeListener(new j(this));
        Switch switchR3 = this.aC;
        if (switchR3 == null) {
            kotlin.g.b.k.a("mPopularChoiceToggle");
        }
        switchR3.setOnCheckedChangeListener(new k(this));
        kotlin.g.b.k.a((Object) com.travel.bus.a.a(), "BusController.getInstance()");
        if (!com.travel.bus.a.b().a("isBusSocialDistancingFilterEnable", false)) {
            RelativeLayout relativeLayout8 = this.ay;
            if (relativeLayout8 == null) {
                kotlin.g.b.k.a("mRlSocialDistancing");
            }
            relativeLayout8.setVisibility(8);
        }
        i();
        h();
        o();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        ai a2 = am.a(activity).a(com.travel.bus.busticket.busfilter.c.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProviders.of(ac…terViewModel::class.java)");
        y<CJRBusTicketFilters> yVar = ((com.travel.bus.busticket.busfilter.c) a2).f22105a;
        if (yVar == null) {
            kotlin.g.b.k.a();
        }
        yVar.observe(this, new h(this));
        return inflate;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.bj = (com.travel.bus.busticket.busfilter.b) activity;
            setUserVisibleHint(true);
            CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
            if (cJRBusTicketFilters == null) {
                kotlin.g.b.k.a();
            }
            String sortBy = cJRBusTicketFilters.getSortBy();
            CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
            if (cJRBusTicketFilters2 == null) {
                kotlin.g.b.k.a();
            }
            a(sortBy, cJRBusTicketFilters2.getOrderBy());
            return;
        }
        throw new u("null cannot be cast to non-null type com.travel.bus.busticket.busfilter.BusFilterTabListener");
    }

    public final void setUserVisibleHint(boolean z2) {
        if (z2 && this.bj != null) {
            b();
        }
        super.setUserVisibleHint(z2);
    }

    static final class i implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22090a;

        i(c cVar) {
            this.f22090a = cVar;
        }

        /* JADX WARNING: type inference failed for: r3v4, types: [com.travel.bus.pojo.busticket.CJRBusTicketFilterItem] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCheckedChanged(android.widget.CompoundButton r3, boolean r4) {
            /*
                r2 = this;
                r3 = 0
                java.lang.String r0 = "Deals"
                if (r4 == 0) goto L_0x0053
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r4 = new com.travel.bus.pojo.busticket.CJRBusTicketFilterItem
                r4.<init>()
                com.travel.bus.pojo.busticket.e r1 = com.travel.bus.pojo.busticket.e.BUS_DEALS
                r4.setFilterCategory(r1)
                r4.setTitle(r0)
                java.lang.String r0 = "boolean"
                r4.setType(r0)
                r0 = 1
                r4.setToggleChecked(r0)
                com.travel.bus.busticket.busfilter.b.c r0 = r2.f22090a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r0 = r0.f22077c
                if (r0 == 0) goto L_0x0031
                java.util.ArrayList r0 = r0.getBusTicketFilterItems()
                if (r0 == 0) goto L_0x0031
                boolean r3 = r0.contains(r4)
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            L_0x0031:
                if (r3 != 0) goto L_0x0036
                kotlin.g.b.k.a()
            L_0x0036:
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x004d
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22090a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r3 = r3.f22077c
                if (r3 == 0) goto L_0x004d
                java.util.ArrayList r3 = r3.getBusTicketFilterItems()
                if (r3 == 0) goto L_0x004d
                r3.add(r4)
            L_0x004d:
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22090a
                r3.b()
                return
            L_0x0053:
                com.travel.bus.busticket.busfilter.b.c r4 = r2.f22090a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r4 = r4.f22077c
                if (r4 == 0) goto L_0x0070
                java.util.ArrayList r4 = r4.getBusTicketFilterItems()
                if (r4 == 0) goto L_0x0070
                com.travel.bus.busticket.busfilter.b.c r1 = r2.f22090a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r1 = r1.f22077c
                if (r1 == 0) goto L_0x006d
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r3 = r1.getBusFilterItemByTitle(r0)
            L_0x006d:
                r4.remove(r3)
            L_0x0070:
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22090a
                r3.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.busfilter.b.c.i.onCheckedChanged(android.widget.CompoundButton, boolean):void");
        }
    }

    static final class j implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22091a;

        j(c cVar) {
            this.f22091a = cVar;
        }

        /* JADX WARNING: type inference failed for: r3v4, types: [com.travel.bus.pojo.busticket.CJRBusTicketFilterItem] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCheckedChanged(android.widget.CompoundButton r3, boolean r4) {
            /*
                r2 = this;
                r3 = 0
                java.lang.String r0 = "Social Distancing"
                if (r4 == 0) goto L_0x0053
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r4 = new com.travel.bus.pojo.busticket.CJRBusTicketFilterItem
                r4.<init>()
                com.travel.bus.pojo.busticket.e r1 = com.travel.bus.pojo.busticket.e.BUS_COVID
                r4.setFilterCategory(r1)
                r4.setTitle(r0)
                java.lang.String r0 = "boolean"
                r4.setType(r0)
                r0 = 1
                r4.setToggleChecked(r0)
                com.travel.bus.busticket.busfilter.b.c r0 = r2.f22091a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r0 = r0.f22077c
                if (r0 == 0) goto L_0x0031
                java.util.ArrayList r0 = r0.getBusTicketFilterItems()
                if (r0 == 0) goto L_0x0031
                boolean r3 = r0.contains(r4)
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            L_0x0031:
                if (r3 != 0) goto L_0x0036
                kotlin.g.b.k.a()
            L_0x0036:
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x004d
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22091a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r3 = r3.f22077c
                if (r3 == 0) goto L_0x004d
                java.util.ArrayList r3 = r3.getBusTicketFilterItems()
                if (r3 == 0) goto L_0x004d
                r3.add(r4)
            L_0x004d:
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22091a
                r3.b()
                return
            L_0x0053:
                com.travel.bus.busticket.busfilter.b.c r4 = r2.f22091a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r4 = r4.f22077c
                if (r4 == 0) goto L_0x0070
                java.util.ArrayList r4 = r4.getBusTicketFilterItems()
                if (r4 == 0) goto L_0x0070
                com.travel.bus.busticket.busfilter.b.c r1 = r2.f22091a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r1 = r1.f22077c
                if (r1 == 0) goto L_0x006d
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r3 = r1.getBusFilterItemByTitle(r0)
            L_0x006d:
                r4.remove(r3)
            L_0x0070:
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22091a
                r3.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.busfilter.b.c.j.onCheckedChanged(android.widget.CompoundButton, boolean):void");
        }
    }

    static final class k implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22092a;

        k(c cVar) {
            this.f22092a = cVar;
        }

        /* JADX WARNING: type inference failed for: r3v4, types: [com.travel.bus.pojo.busticket.CJRBusTicketFilterItem] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCheckedChanged(android.widget.CompoundButton r3, boolean r4) {
            /*
                r2 = this;
                r3 = 0
                java.lang.String r0 = "Popular Choice"
                if (r4 == 0) goto L_0x005c
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r4 = new com.travel.bus.pojo.busticket.CJRBusTicketFilterItem
                r4.<init>()
                com.travel.bus.pojo.busticket.e r1 = com.travel.bus.pojo.busticket.e.BUS_POPULAR_CHOICE
                r4.setFilterCategory(r1)
                r4.setTitle(r0)
                java.lang.String r0 = "boolean"
                r4.setType(r0)
                com.travel.bus.busticket.busfilter.b.c r0 = r2.f22092a
                java.lang.String r0 = r0.bh
                r4.setFilterValue(r0)
                r0 = 1
                r4.setToggleChecked(r0)
                com.travel.bus.busticket.busfilter.b.c r0 = r2.f22092a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r0 = r0.f22077c
                if (r0 == 0) goto L_0x003a
                java.util.ArrayList r0 = r0.getBusTicketFilterItems()
                if (r0 == 0) goto L_0x003a
                boolean r3 = r0.contains(r4)
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            L_0x003a:
                if (r3 != 0) goto L_0x003f
                kotlin.g.b.k.a()
            L_0x003f:
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x0056
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22092a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r3 = r3.f22077c
                if (r3 == 0) goto L_0x0056
                java.util.ArrayList r3 = r3.getBusTicketFilterItems()
                if (r3 == 0) goto L_0x0056
                r3.add(r4)
            L_0x0056:
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22092a
                r3.b()
                return
            L_0x005c:
                com.travel.bus.busticket.busfilter.b.c r4 = r2.f22092a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r4 = r4.f22077c
                if (r4 == 0) goto L_0x0079
                java.util.ArrayList r4 = r4.getBusTicketFilterItems()
                if (r4 == 0) goto L_0x0079
                com.travel.bus.busticket.busfilter.b.c r1 = r2.f22092a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r1 = r1.f22077c
                if (r1 == 0) goto L_0x0076
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r3 = r1.getBusFilterItemByTitle(r0)
            L_0x0076:
                r4.remove(r3)
            L_0x0079:
                com.travel.bus.busticket.busfilter.b.c r3 = r2.f22092a
                r3.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.busfilter.b.c.k.onCheckedChanged(android.widget.CompoundButton, boolean):void");
        }
    }

    /* renamed from: com.travel.bus.busticket.busfilter.b.c$c  reason: collision with other inner class name */
    static final class C0436c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22084a;

        C0436c(c cVar) {
            this.f22084a = cVar;
        }

        public final void onClick(View view) {
            CJRBusTicketFilters a2;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems3;
            CJRBusTicketFilters a3;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems4;
            CJRBusTicketFilters a4;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems5;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems6;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems7;
            CJRBusTicketFilters a5;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems8;
            kotlin.g.b.k.a((Object) view, "view");
            Boolean bool = null;
            if (view.getId() == R.id.lyt_bus_multi_axle) {
                CJRBusTicketFilters a6 = this.f22084a.f22077c;
                CJRBusTicketFilterItem busFilterItemByTitle = a6 != null ? a6.getBusFilterItemByTitle("Multi Axle") : null;
                if (!view.isSelected()) {
                    CJRBusTicketFilters a7 = this.f22084a.f22077c;
                    CJRBusTicketFilterItem busFilterItemByTitle2 = a7 != null ? a7.getBusFilterItemByTitle("Single Axle") : null;
                    if (busFilterItemByTitle2 != null) {
                        CJRBusTicketFilters a8 = this.f22084a.f22077c;
                        if (!(a8 == null || (busTicketFilterItems7 = a8.getBusTicketFilterItems()) == null)) {
                            busTicketFilterItems7.remove(busFilterItemByTitle2);
                        }
                        c.e(this.f22084a).setSelected(false);
                    }
                    if (busFilterItemByTitle == null) {
                        busFilterItemByTitle = new CJRBusTicketFilterItem();
                        busFilterItemByTitle.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
                        busFilterItemByTitle.setTitle("Multi Axle");
                        busFilterItemByTitle.setType("boolean");
                        busFilterItemByTitle.setToggleChecked(true);
                    }
                    CJRBusTicketFilters a9 = this.f22084a.f22077c;
                    if (!(a9 == null || (busTicketFilterItems6 = a9.getBusTicketFilterItems()) == null)) {
                        bool = Boolean.valueOf(busTicketFilterItems6.contains(busFilterItemByTitle));
                    }
                    if (bool == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!(bool.booleanValue() || (a4 = this.f22084a.f22077c) == null || (busTicketFilterItems5 = a4.getBusTicketFilterItems()) == null)) {
                        busTicketFilterItems5.add(busFilterItemByTitle);
                    }
                    c.a(this.f22084a, busFilterItemByTitle);
                    c.a(this.f22084a, "MultiAxle");
                    this.f22084a.a("MultiAxle", "brand_filter_selected");
                } else if (!(busFilterItemByTitle == null || (a5 = this.f22084a.f22077c) == null || (busTicketFilterItems8 = a5.getBusTicketFilterItems()) == null)) {
                    busTicketFilterItems8.remove(busFilterItemByTitle);
                }
                view.setSelected(!view.isSelected());
            } else if (view.getId() == R.id.lyt_bus_single_axle) {
                CJRBusTicketFilters a10 = this.f22084a.f22077c;
                CJRBusTicketFilterItem busFilterItemByTitle3 = a10 != null ? a10.getBusFilterItemByTitle("Single Axle") : null;
                if (!view.isSelected()) {
                    CJRBusTicketFilters a11 = this.f22084a.f22077c;
                    CJRBusTicketFilterItem busFilterItemByTitle4 = a11 != null ? a11.getBusFilterItemByTitle("Multi Axle") : null;
                    if (busFilterItemByTitle4 != null) {
                        CJRBusTicketFilters a12 = this.f22084a.f22077c;
                        if (!(a12 == null || (busTicketFilterItems3 = a12.getBusTicketFilterItems()) == null)) {
                            busTicketFilterItems3.remove(busFilterItemByTitle4);
                        }
                        c.f(this.f22084a).setSelected(false);
                    }
                    if (busFilterItemByTitle3 == null) {
                        busFilterItemByTitle3 = new CJRBusTicketFilterItem();
                        busFilterItemByTitle3.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
                        busFilterItemByTitle3.setTitle("Single Axle");
                        busFilterItemByTitle3.setType("boolean");
                        busFilterItemByTitle3.setToggleChecked(true);
                    }
                    CJRBusTicketFilters a13 = this.f22084a.f22077c;
                    if (!(a13 == null || (busTicketFilterItems2 = a13.getBusTicketFilterItems()) == null)) {
                        bool = Boolean.valueOf(busTicketFilterItems2.contains(busFilterItemByTitle3));
                    }
                    if (bool == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!(bool.booleanValue() || (a2 = this.f22084a.f22077c) == null || (busTicketFilterItems = a2.getBusTicketFilterItems()) == null)) {
                        busTicketFilterItems.add(busFilterItemByTitle3);
                    }
                    this.f22084a.a("SingleAxle", "brand_filter_selected");
                } else if (!(busFilterItemByTitle3 == null || (a3 = this.f22084a.f22077c) == null || (busTicketFilterItems4 = a3.getBusTicketFilterItems()) == null)) {
                    busTicketFilterItems4.remove(busFilterItemByTitle3);
                }
                view.setSelected(!view.isSelected());
            }
            this.f22084a.setUserVisibleHint(true);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22085a;

        d(c cVar) {
            this.f22085a = cVar;
        }

        public final void onClick(View view) {
            CJRBusTicketFilters a2;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
            CJRBusTicketFilters a3;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems3;
            CJRBusTicketFilters a4;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems4;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems5;
            CJRBusTicketFilters a5;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems6;
            CJRBusTicketFilters a6;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems7;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems8;
            CJRBusTicketFilters a7;
            ArrayList<CJRBusTicketFilterItem> busTicketFilterItems9;
            kotlin.g.b.k.a((Object) view, "v");
            int id = view.getId();
            Boolean bool = null;
            if (id == R.id.lyt_bus_type_volvo) {
                CJRBusTicketFilters a8 = this.f22085a.f22077c;
                CJRBusTicketFilterItem busFilterItemByTitle = a8 != null ? a8.getBusFilterItemByTitle("Volvo") : null;
                if (!view.isSelected()) {
                    if (busFilterItemByTitle == null) {
                        busFilterItemByTitle = new CJRBusTicketFilterItem();
                        busFilterItemByTitle.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
                        busFilterItemByTitle.setTitle("Volvo");
                        busFilterItemByTitle.setType("boolean");
                        busFilterItemByTitle.setToggleChecked(true);
                    }
                    CJRBusTicketFilters a9 = this.f22085a.f22077c;
                    if (!(a9 == null || (busTicketFilterItems8 = a9.getBusTicketFilterItems()) == null)) {
                        bool = Boolean.valueOf(busTicketFilterItems8.contains(busFilterItemByTitle));
                    }
                    if (bool == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!(bool.booleanValue() || (a6 = this.f22085a.f22077c) == null || (busTicketFilterItems7 = a6.getBusTicketFilterItems()) == null)) {
                        busTicketFilterItems7.add(busFilterItemByTitle);
                    }
                    c.a(this.f22085a, busFilterItemByTitle);
                    c.a(this.f22085a, "Volvo");
                    this.f22085a.a("Volvo", "brand_filter_selected");
                } else if (!(busFilterItemByTitle == null || (a7 = this.f22085a.f22077c) == null || (busTicketFilterItems9 = a7.getBusTicketFilterItems()) == null)) {
                    busTicketFilterItems9.remove(busFilterItemByTitle);
                }
                view.setSelected(!view.isSelected());
            } else if (id == R.id.lyt_bus_type_scania) {
                CJRBusTicketFilters a10 = this.f22085a.f22077c;
                CJRBusTicketFilterItem busFilterItemByTitle2 = a10 != null ? a10.getBusFilterItemByTitle("Scania") : null;
                if (!view.isSelected()) {
                    if (busFilterItemByTitle2 == null) {
                        busFilterItemByTitle2 = new CJRBusTicketFilterItem();
                        busFilterItemByTitle2.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
                        busFilterItemByTitle2.setTitle("Scania");
                        busFilterItemByTitle2.setType("boolean");
                        busFilterItemByTitle2.setToggleChecked(true);
                    }
                    CJRBusTicketFilters a11 = this.f22085a.f22077c;
                    if (!(a11 == null || (busTicketFilterItems5 = a11.getBusTicketFilterItems()) == null)) {
                        bool = Boolean.valueOf(busTicketFilterItems5.contains(busFilterItemByTitle2));
                    }
                    if (bool == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!(bool.booleanValue() || (a4 = this.f22085a.f22077c) == null || (busTicketFilterItems4 = a4.getBusTicketFilterItems()) == null)) {
                        busTicketFilterItems4.add(busFilterItemByTitle2);
                    }
                    c.a(this.f22085a, busFilterItemByTitle2);
                    c.a(this.f22085a, "Scania");
                    this.f22085a.a("Scania", "brand_filter_selected");
                } else if (!(busFilterItemByTitle2 == null || (a5 = this.f22085a.f22077c) == null || (busTicketFilterItems6 = a5.getBusTicketFilterItems()) == null)) {
                    busTicketFilterItems6.remove(busFilterItemByTitle2);
                }
                view.setSelected(!view.isSelected());
            } else if (id == R.id.lyt_bus_type_mercedes) {
                CJRBusTicketFilters a12 = this.f22085a.f22077c;
                CJRBusTicketFilterItem busFilterItemByTitle3 = a12 != null ? a12.getBusFilterItemByTitle("Mercedes") : null;
                if (!view.isSelected()) {
                    if (busFilterItemByTitle3 == null) {
                        busFilterItemByTitle3 = new CJRBusTicketFilterItem();
                        busFilterItemByTitle3.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
                        busFilterItemByTitle3.setTitle("Mercedes");
                        busFilterItemByTitle3.setType("boolean");
                        busFilterItemByTitle3.setToggleChecked(true);
                    }
                    CJRBusTicketFilters a13 = this.f22085a.f22077c;
                    if (!(a13 == null || (busTicketFilterItems2 = a13.getBusTicketFilterItems()) == null)) {
                        bool = Boolean.valueOf(busTicketFilterItems2.contains(busFilterItemByTitle3));
                    }
                    if (bool == null) {
                        kotlin.g.b.k.a();
                    }
                    if (!(bool.booleanValue() || (a2 = this.f22085a.f22077c) == null || (busTicketFilterItems = a2.getBusTicketFilterItems()) == null)) {
                        busTicketFilterItems.add(busFilterItemByTitle3);
                    }
                    c.a(this.f22085a, busFilterItemByTitle3);
                    c.a(this.f22085a, "Mercedes");
                    this.f22085a.a("Mercedes", "brand_filter_selected");
                } else if (!(busFilterItemByTitle3 == null || (a3 = this.f22085a.f22077c) == null || (busTicketFilterItems3 = a3.getBusTicketFilterItems()) == null)) {
                    busTicketFilterItems3.remove(busFilterItemByTitle3);
                }
                view.setSelected(!view.isSelected());
            }
            this.f22085a.setUserVisibleHint(true);
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("event_label", str);
        hashMap.put("event_label2", this.aN + '/' + this.aO);
        CharSequence n2 = com.paytm.utility.b.n((Context) getActivity());
        if (!(n2 == null || n2.length() == 0)) {
            String n3 = com.paytm.utility.b.n((Context) getActivity());
            kotlin.g.b.k.a((Object) n3, "CJRAppCommonUtility.getUserId(activity)");
            hashMap.put("userid", n3);
        }
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", str2, hashMap);
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22088a;

        g(c cVar) {
            this.f22088a = cVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0069  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00c9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r10) {
            /*
                r9 = this;
                java.lang.String r0 = "v"
                kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)
                boolean r0 = r10.isSelected()
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                r1.g()
                int r1 = r10.getId()
                int r2 = com.travel.bus.R.id.lyt_time_morning
                r3 = 0
                r4 = 1
                r5 = 0
                if (r1 != r2) goto L_0x0028
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                java.lang.String r1 = r1.k
                com.travel.bus.busticket.busfilter.b.c r2 = r9.f22088a
                java.lang.String r2 = r2.m
            L_0x0026:
                r6 = 0
                goto L_0x005f
            L_0x0028:
                int r2 = com.travel.bus.R.id.lyt_time_afternoon
                if (r1 != r2) goto L_0x0039
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                java.lang.String r1 = r1.m
                com.travel.bus.busticket.busfilter.b.c r2 = r9.f22088a
                java.lang.String r2 = r2.n
                goto L_0x0026
            L_0x0039:
                int r2 = com.travel.bus.R.id.lyt_time_evening
                if (r1 != r2) goto L_0x004a
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                java.lang.String r1 = r1.n
                com.travel.bus.busticket.busfilter.b.c r2 = r9.f22088a
                java.lang.String r2 = r2.o
                goto L_0x0026
            L_0x004a:
                int r2 = com.travel.bus.R.id.lyt_time_night
                if (r1 != r2) goto L_0x005c
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                java.lang.String r1 = r1.o
                com.travel.bus.busticket.busfilter.b.c r2 = r9.f22088a
                java.lang.String r2 = r2.l
                r6 = 1
                goto L_0x005f
            L_0x005c:
                r1 = r5
                r2 = r1
                goto L_0x0026
            L_0x005f:
                com.travel.bus.busticket.busfilter.b.c r7 = r9.f22088a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r7 = r7.f22077c
                java.lang.String r8 = "Deprture Time"
                if (r7 == 0) goto L_0x006d
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r5 = r7.getBusFilterItemByTitle(r8)
            L_0x006d:
                if (r0 == 0) goto L_0x0083
                if (r5 == 0) goto L_0x00c0
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r1 = r1.f22077c
                if (r1 == 0) goto L_0x00c1
                java.util.ArrayList r1 = r1.getBusTicketFilterItems()
                if (r1 == 0) goto L_0x00c1
                r1.remove(r5)
                goto L_0x00c1
            L_0x0083:
                if (r5 != 0) goto L_0x00b0
                com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r5 = new com.travel.bus.pojo.busticket.CJRBusTicketFilterItem
                r5.<init>()
                com.travel.bus.pojo.busticket.e r3 = com.travel.bus.pojo.busticket.e.BUS_DEPARTURE_TIME
                r5.setFilterCategory(r3)
                r5.setTitle(r8)
                java.lang.String r3 = "time_range_slider"
                r5.setType(r3)
                r5.setTimeMinValue(r1)
                r5.setTimeMaxValue(r2)
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r1 = r1.f22077c
                if (r1 == 0) goto L_0x00bb
                java.util.ArrayList r1 = r1.getBusTicketFilterItems()
                if (r1 == 0) goto L_0x00bb
                r1.add(r5)
                goto L_0x00bb
            L_0x00b0:
                r5.setTimeMinValue(r1)
                r5.setTimeMaxValue(r2)
                com.travel.bus.pojo.busticket.e r1 = com.travel.bus.pojo.busticket.e.BUS_DEPARTURE_TIME
                r5.setFilterCategory(r1)
            L_0x00bb:
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                com.travel.bus.busticket.busfilter.b.c.b((com.travel.bus.busticket.busfilter.b.c) r1, (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r5)
            L_0x00c0:
                r3 = r6
            L_0x00c1:
                com.travel.bus.busticket.busfilter.b.c r1 = r9.f22088a
                com.travel.bus.pojo.busticket.CJRBusTicketFilters r1 = r1.f22077c
                if (r1 == 0) goto L_0x00cc
                r1.setmNightBusesFlag(r3)
            L_0x00cc:
                r0 = r0 ^ r4
                r10.setSelected(r0)
                com.travel.bus.busticket.busfilter.b.c r10 = r9.f22088a
                r10.setUserVisibleHint(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.busfilter.b.c.g.onClick(android.view.View):void");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22083a;

        b(c cVar) {
            this.f22083a = cVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.a((Object) view, "v");
            boolean isSelected = view.isSelected();
            int id = view.getId();
            if (id == R.id.lyt_ac) {
                if (isSelected) {
                    c.a(this.f22083a, view.getId());
                } else {
                    c.a(this.f22083a, R.id.lyt_non_ac);
                }
            } else if (id == R.id.lyt_non_ac) {
                if (isSelected) {
                    c.a(this.f22083a, view.getId());
                } else {
                    c.a(this.f22083a, R.id.lyt_ac);
                }
            }
            view.setSelected(!isSelected);
            c.m(this.f22083a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22086a;

        e(c cVar) {
            this.f22086a = cVar;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.a((Object) view, "v");
            boolean isSelected = view.isSelected();
            int id = view.getId();
            if (id == R.id.lyt_sleeper) {
                if (isSelected) {
                    c.b(this.f22086a, view.getId());
                } else {
                    c.b(this.f22086a, R.id.lyt_seater);
                    c.b(this.f22086a, R.id.lyt_semi_sleeper);
                }
            } else if (id == R.id.lyt_seater) {
                if (isSelected) {
                    c.b(this.f22086a, view.getId());
                } else {
                    c.b(this.f22086a, R.id.lyt_sleeper);
                    c.b(this.f22086a, R.id.lyt_semi_sleeper);
                }
            } else if (id == R.id.lyt_semi_sleeper) {
                if (isSelected) {
                    c.b(this.f22086a, view.getId());
                } else {
                    c.b(this.f22086a, R.id.lyt_seater);
                    c.b(this.f22086a, R.id.lyt_sleeper);
                }
            }
            view.setSelected(!isSelected);
            c.n(this.f22086a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22087a;

        f(c cVar) {
            this.f22087a = cVar;
        }

        public final void onClick(View view) {
            if (kotlin.g.b.k.a((Object) view, (Object) c.o(this.f22087a))) {
                c.b(this.f22087a, "Top Rated");
                c cVar = this.f22087a;
                c.a(cVar, (View) c.o(cVar));
                this.f22087a.a("topRated", 1);
            } else if (kotlin.g.b.k.a((Object) view, (Object) c.p(this.f22087a))) {
                c.b(this.f22087a, "Cheapest");
                c cVar2 = this.f22087a;
                c.a(cVar2, (View) c.p(cVar2));
                this.f22087a.a("fare", 0);
            } else if (kotlin.g.b.k.a((Object) view, (Object) c.q(this.f22087a))) {
                c.b(this.f22087a, "Late Boarding");
                c cVar3 = this.f22087a;
                c.a(cVar3, (View) c.q(cVar3));
                this.f22087a.a("departureTime", 1);
            } else if (kotlin.g.b.k.a((Object) view, (Object) c.r(this.f22087a))) {
                c.b(this.f22087a, "Early Boarding");
                c cVar4 = this.f22087a;
                c.a(cVar4, (View) c.r(cVar4));
                this.f22087a.a("departureTime", 0);
            }
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22093a;

        l(c cVar) {
            this.f22093a = cVar;
        }

        public final void onClick(View view) {
            this.f22093a.a();
            if (kotlin.g.b.k.a((Object) view, (Object) c.t(this.f22093a))) {
                if (p.a(this.f22093a.aX, this.f22093a.aU, true)) {
                    c cVar = this.f22093a;
                    c.d(cVar, this.f22093a.aU + "Rating");
                    return;
                }
                c cVar2 = this.f22093a;
                cVar2.aX = cVar2.aU;
                ConstraintLayout t = c.t(this.f22093a);
                FragmentActivity activity = this.f22093a.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                t.setBackground(activity.getResources().getDrawable(R.drawable.travel_res_bus_ratings_shape_selected));
                c.w(this.f22093a).setTextColor(this.f22093a.getResources().getColor(R.color.color_53b6ef));
                c.x(this.f22093a).setTextColor(this.f22093a.getResources().getColor(R.color.color_53b6ef));
                c.w(this.f22093a).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bus_rating_star_blue, 0);
            } else if (kotlin.g.b.k.a((Object) view, (Object) c.y(this.f22093a))) {
                if (p.a(this.f22093a.aX, this.f22093a.aV, true)) {
                    c cVar3 = this.f22093a;
                    c.d(cVar3, this.f22093a.aV + "Rating");
                    return;
                }
                c cVar4 = this.f22093a;
                cVar4.aX = cVar4.aV;
                ConstraintLayout y = c.y(this.f22093a);
                FragmentActivity activity2 = this.f22093a.getActivity();
                if (activity2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity2, "activity!!");
                y.setBackground(activity2.getResources().getDrawable(R.drawable.travel_res_bus_ratings_shape_selected));
                c.A(this.f22093a).setTextColor(this.f22093a.getResources().getColor(R.color.color_53b6ef));
                c.B(this.f22093a).setTextColor(this.f22093a.getResources().getColor(R.color.color_53b6ef));
                c.A(this.f22093a).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bus_rating_star_blue, 0);
            } else if (kotlin.g.b.k.a((Object) view, (Object) c.C(this.f22093a))) {
                if (p.a(this.f22093a.aX, this.f22093a.aW, true)) {
                    c cVar5 = this.f22093a;
                    c.d(cVar5, this.f22093a.aW + "Rating");
                    return;
                }
                c cVar6 = this.f22093a;
                cVar6.aX = cVar6.aW;
                ConstraintLayout C = c.C(this.f22093a);
                FragmentActivity activity3 = this.f22093a.getActivity();
                if (activity3 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity3, "activity!!");
                C.setBackground(activity3.getResources().getDrawable(R.drawable.travel_res_bus_ratings_shape_selected));
                c.E(this.f22093a).setTextColor(this.f22093a.getResources().getColor(R.color.color_53b6ef));
                c.F(this.f22093a).setTextColor(this.f22093a.getResources().getColor(R.color.color_53b6ef));
                c.E(this.f22093a).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bus_rating_star_blue, 0);
            }
            if (!TextUtils.isEmpty(this.f22093a.aX)) {
                this.f22093a.f();
            }
        }
    }

    public final void a() {
        this.aX = "";
        f();
        ConstraintLayout constraintLayout = this.ap;
        if (constraintLayout == null) {
            kotlin.g.b.k.a("mClRatings5");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity, "activity!!");
        constraintLayout.setBackground(activity.getResources().getDrawable(R.drawable.travel_res_bus_ratings_shape_unselected));
        ConstraintLayout constraintLayout2 = this.aq;
        if (constraintLayout2 == null) {
            kotlin.g.b.k.a("mClRatingsAbove4");
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity2, "activity!!");
        constraintLayout2.setBackground(activity2.getResources().getDrawable(R.drawable.travel_res_bus_ratings_shape_unselected));
        ConstraintLayout constraintLayout3 = this.ar;
        if (constraintLayout3 == null) {
            kotlin.g.b.k.a("mClRatingsAbove3");
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 == null) {
            kotlin.g.b.k.a();
        }
        kotlin.g.b.k.a((Object) activity3, "activity!!");
        constraintLayout3.setBackground(activity3.getResources().getDrawable(R.drawable.travel_res_bus_ratings_shape_unselected));
        RoboTextView roboTextView = this.as;
        if (roboTextView == null) {
            kotlin.g.b.k.a("mTvRatings5");
        }
        roboTextView.setTextColor(getResources().getColor(R.color.color_3d3d3d));
        RoboTextView roboTextView2 = this.au;
        if (roboTextView2 == null) {
            kotlin.g.b.k.a("mTvRatingsAbove4");
        }
        roboTextView2.setTextColor(getResources().getColor(R.color.color_3d3d3d));
        RoboTextView roboTextView3 = this.aw;
        if (roboTextView3 == null) {
            kotlin.g.b.k.a("mTvRatingsAbove3");
        }
        roboTextView3.setTextColor(getResources().getColor(R.color.color_3d3d3d));
        RoboTextView roboTextView4 = this.at;
        if (roboTextView4 == null) {
            kotlin.g.b.k.a("mTvRatingsText5");
        }
        roboTextView4.setTextColor(getResources().getColor(R.color.color_979797));
        RoboTextView roboTextView5 = this.av;
        if (roboTextView5 == null) {
            kotlin.g.b.k.a("mTvRatingsAbove4Text");
        }
        roboTextView5.setTextColor(getResources().getColor(R.color.color_979797));
        RoboTextView roboTextView6 = this.ax;
        if (roboTextView6 == null) {
            kotlin.g.b.k.a("mTvRatingsAbove3Text");
        }
        roboTextView6.setTextColor(getResources().getColor(R.color.color_979797));
        RoboTextView roboTextView7 = this.as;
        if (roboTextView7 == null) {
            kotlin.g.b.k.a("mTvRatings5");
        }
        roboTextView7.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bus_rating_star_normal, 0);
        RoboTextView roboTextView8 = this.au;
        if (roboTextView8 == null) {
            kotlin.g.b.k.a("mTvRatingsAbove4");
        }
        roboTextView8.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bus_rating_star_normal, 0);
        RoboTextView roboTextView9 = this.aw;
        if (roboTextView9 == null) {
            kotlin.g.b.k.a("mTvRatingsAbove3");
        }
        roboTextView9.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.bus_rating_star_normal, 0);
    }

    /* access modifiers changed from: private */
    public final void f() {
        CJRBusTicketFilterItem cJRBusTicketFilterItem;
        CJRBusTicketFilterItem cJRBusTicketFilterItem2;
        CJRBusTicketFilterItem cJRBusTicketFilterItem3;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        CJRBusTicketFilters cJRBusTicketFilters;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
        CJRBusTicketFilters cJRBusTicketFilters2;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems3;
        CJRBusTicketFilters cJRBusTicketFilters3;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems4;
        CJRBusTicketFilters cJRBusTicketFilters4 = this.f22077c;
        CJRBusTicketFilterItem cJRBusTicketFilterItem4 = null;
        if (cJRBusTicketFilters4 != null) {
            cJRBusTicketFilterItem = cJRBusTicketFilters4.getBusFilterItemByTitle(this.aU + "Rating");
        } else {
            cJRBusTicketFilterItem = null;
        }
        CJRBusTicketFilters cJRBusTicketFilters5 = this.f22077c;
        if (cJRBusTicketFilters5 != null) {
            cJRBusTicketFilterItem2 = cJRBusTicketFilters5.getBusFilterItemByTitle(this.aV + "Rating");
        } else {
            cJRBusTicketFilterItem2 = null;
        }
        CJRBusTicketFilters cJRBusTicketFilters6 = this.f22077c;
        if (cJRBusTicketFilters6 != null) {
            cJRBusTicketFilterItem3 = cJRBusTicketFilters6.getBusFilterItemByTitle(this.aW + "Rating");
        } else {
            cJRBusTicketFilterItem3 = null;
        }
        CJRBusTicketFilters cJRBusTicketFilters7 = this.f22077c;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems5 = cJRBusTicketFilters7 != null ? cJRBusTicketFilters7.getBusTicketFilterItems() : null;
        if (busTicketFilterItems5 == null) {
            kotlin.g.b.k.a();
        }
        if (!(!busTicketFilterItems5.contains(cJRBusTicketFilterItem) || (cJRBusTicketFilters3 = this.f22077c) == null || (busTicketFilterItems4 = cJRBusTicketFilters3.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems4.remove(cJRBusTicketFilterItem);
        }
        CJRBusTicketFilters cJRBusTicketFilters8 = this.f22077c;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems6 = cJRBusTicketFilters8 != null ? cJRBusTicketFilters8.getBusTicketFilterItems() : null;
        if (busTicketFilterItems6 == null) {
            kotlin.g.b.k.a();
        }
        if (!(!busTicketFilterItems6.contains(cJRBusTicketFilterItem2) || (cJRBusTicketFilters2 = this.f22077c) == null || (busTicketFilterItems3 = cJRBusTicketFilters2.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems3.remove(cJRBusTicketFilterItem2);
        }
        CJRBusTicketFilters cJRBusTicketFilters9 = this.f22077c;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems7 = cJRBusTicketFilters9 != null ? cJRBusTicketFilters9.getBusTicketFilterItems() : null;
        if (busTicketFilterItems7 == null) {
            kotlin.g.b.k.a();
        }
        if (!(!busTicketFilterItems7.contains(cJRBusTicketFilterItem3) || (cJRBusTicketFilters = this.f22077c) == null || (busTicketFilterItems2 = cJRBusTicketFilters.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems2.remove(cJRBusTicketFilterItem3);
        }
        if (!TextUtils.isEmpty(this.aX)) {
            CJRBusTicketFilters cJRBusTicketFilters10 = this.f22077c;
            if (cJRBusTicketFilters10 != null) {
                cJRBusTicketFilterItem4 = cJRBusTicketFilters10.getBusFilterItemByTitle(this.aX + "Rating");
            }
            if (cJRBusTicketFilterItem4 == null) {
                cJRBusTicketFilterItem4 = new CJRBusTicketFilterItem();
                cJRBusTicketFilterItem4.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_RATING);
            }
            cJRBusTicketFilterItem4.setTitle(this.aX + "Rating");
            cJRBusTicketFilterItem4.setType("boolean");
            cJRBusTicketFilterItem4.setToggleChecked(true);
            CJRBusTicketFilters cJRBusTicketFilters11 = this.f22077c;
            if (!(cJRBusTicketFilters11 == null || (busTicketFilterItems = cJRBusTicketFilters11.getBusTicketFilterItems()) == null)) {
                busTicketFilterItems.add(cJRBusTicketFilterItem4);
            }
        }
        b();
    }

    public final void b() {
        com.travel.bus.busticket.busfilter.b bVar = this.bj;
        if (bVar != null && bVar != null) {
            bVar.a(e(), 0);
        }
    }

    public final void a(String str, int i2) {
        com.travel.bus.busticket.busfilter.b bVar;
        this.f22079e = false;
        if (p.a("topRated", str, true) && 1 == i2) {
            LinearLayout linearLayout = this.K;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mLytSortTopRated");
            }
            if (linearLayout.isSelected()) {
                ImageView imageView = this.ac;
                if (imageView == null) {
                    kotlin.g.b.k.a("mImgTypeSortTopRated");
                }
                if (imageView.isSelected()) {
                    LinearLayout linearLayout2 = this.K;
                    if (linearLayout2 == null) {
                        kotlin.g.b.k.a("mLytSortTopRated");
                    }
                    ImageView imageView2 = this.ac;
                    if (imageView2 == null) {
                        kotlin.g.b.k.a("mImgTypeSortTopRated");
                    }
                    a(linearLayout2, imageView2, false);
                    b("key_bus_search_sort_by_none", 0);
                }
            }
            LinearLayout linearLayout3 = this.K;
            if (linearLayout3 == null) {
                kotlin.g.b.k.a("mLytSortTopRated");
            }
            ImageView imageView3 = this.ac;
            if (imageView3 == null) {
                kotlin.g.b.k.a("mImgTypeSortTopRated");
            }
            a(linearLayout3, imageView3, true);
            if (str == null) {
                kotlin.g.b.k.a();
            }
            b(str, i2);
            this.f22079e = true;
        } else if (p.a("fare", str, true) && i2 == 0) {
            LinearLayout linearLayout4 = this.L;
            if (linearLayout4 == null) {
                kotlin.g.b.k.a("mLytSortCheapest");
            }
            if (linearLayout4.isSelected()) {
                ImageView imageView4 = this.ad;
                if (imageView4 == null) {
                    kotlin.g.b.k.a("mImgTypeSortCheapest");
                }
                if (imageView4.isSelected()) {
                    LinearLayout linearLayout5 = this.L;
                    if (linearLayout5 == null) {
                        kotlin.g.b.k.a("mLytSortCheapest");
                    }
                    ImageView imageView5 = this.ad;
                    if (imageView5 == null) {
                        kotlin.g.b.k.a("mImgTypeSortCheapest");
                    }
                    a(linearLayout5, imageView5, false);
                    b("key_bus_search_sort_by_none", 0);
                }
            }
            LinearLayout linearLayout6 = this.L;
            if (linearLayout6 == null) {
                kotlin.g.b.k.a("mLytSortCheapest");
            }
            ImageView imageView6 = this.ad;
            if (imageView6 == null) {
                kotlin.g.b.k.a("mImgTypeSortCheapest");
            }
            a(linearLayout6, imageView6, true);
            if (str == null) {
                kotlin.g.b.k.a();
            }
            b(str, i2);
            this.f22079e = true;
        } else if (p.a("departureTime", str, true) && 1 == i2) {
            LinearLayout linearLayout7 = this.M;
            if (linearLayout7 == null) {
                kotlin.g.b.k.a("mLytSortLateBoarding");
            }
            if (linearLayout7.isSelected()) {
                ImageView imageView7 = this.ae;
                if (imageView7 == null) {
                    kotlin.g.b.k.a("mImgTypeSortLateBoarding");
                }
                if (imageView7.isSelected()) {
                    LinearLayout linearLayout8 = this.M;
                    if (linearLayout8 == null) {
                        kotlin.g.b.k.a("mLytSortLateBoarding");
                    }
                    ImageView imageView8 = this.ae;
                    if (imageView8 == null) {
                        kotlin.g.b.k.a("mImgTypeSortLateBoarding");
                    }
                    a(linearLayout8, imageView8, false);
                    b("key_bus_search_sort_by_none", 0);
                }
            }
            LinearLayout linearLayout9 = this.M;
            if (linearLayout9 == null) {
                kotlin.g.b.k.a("mLytSortLateBoarding");
            }
            ImageView imageView9 = this.ae;
            if (imageView9 == null) {
                kotlin.g.b.k.a("mImgTypeSortLateBoarding");
            }
            a(linearLayout9, imageView9, true);
            if (str == null) {
                kotlin.g.b.k.a();
            }
            b(str, i2);
            this.f22079e = true;
        } else if (!p.a("departureTime", str, true) || i2 != 0) {
            LinearLayout linearLayout10 = this.K;
            if (linearLayout10 == null) {
                kotlin.g.b.k.a("mLytSortTopRated");
            }
            ImageView imageView10 = this.ac;
            if (imageView10 == null) {
                kotlin.g.b.k.a("mImgTypeSortTopRated");
            }
            a(linearLayout10, imageView10, false);
            LinearLayout linearLayout11 = this.L;
            if (linearLayout11 == null) {
                kotlin.g.b.k.a("mLytSortCheapest");
            }
            ImageView imageView11 = this.ad;
            if (imageView11 == null) {
                kotlin.g.b.k.a("mImgTypeSortCheapest");
            }
            a(linearLayout11, imageView11, false);
            LinearLayout linearLayout12 = this.M;
            if (linearLayout12 == null) {
                kotlin.g.b.k.a("mLytSortLateBoarding");
            }
            ImageView imageView12 = this.ae;
            if (imageView12 == null) {
                kotlin.g.b.k.a("mImgTypeSortLateBoarding");
            }
            a(linearLayout12, imageView12, false);
            LinearLayout linearLayout13 = this.N;
            if (linearLayout13 == null) {
                kotlin.g.b.k.a("mLytSortEarlyBoarding");
            }
            ImageView imageView13 = this.af;
            if (imageView13 == null) {
                kotlin.g.b.k.a("mImgTypeSortEarlyBoarding");
            }
            a(linearLayout13, imageView13, false);
            b("key_bus_search_sort_by_none", 0);
        } else {
            LinearLayout linearLayout14 = this.N;
            if (linearLayout14 == null) {
                kotlin.g.b.k.a("mLytSortEarlyBoarding");
            }
            if (linearLayout14.isSelected()) {
                ImageView imageView14 = this.af;
                if (imageView14 == null) {
                    kotlin.g.b.k.a("mImgTypeSortEarlyBoarding");
                }
                if (imageView14.isSelected()) {
                    LinearLayout linearLayout15 = this.N;
                    if (linearLayout15 == null) {
                        kotlin.g.b.k.a("mLytSortEarlyBoarding");
                    }
                    ImageView imageView15 = this.af;
                    if (imageView15 == null) {
                        kotlin.g.b.k.a("mImgTypeSortEarlyBoarding");
                    }
                    a(linearLayout15, imageView15, false);
                    b("key_bus_search_sort_by_none", 0);
                }
            }
            LinearLayout linearLayout16 = this.N;
            if (linearLayout16 == null) {
                kotlin.g.b.k.a("mLytSortEarlyBoarding");
            }
            ImageView imageView16 = this.af;
            if (imageView16 == null) {
                kotlin.g.b.k.a("mImgTypeSortEarlyBoarding");
            }
            a(linearLayout16, imageView16, true);
            if (str == null) {
                kotlin.g.b.k.a();
            }
            b(str, i2);
            this.f22079e = true;
        }
        if (!this.f22079e || (bVar = this.bj) == null) {
            b();
            return;
        }
        if (bVar == null) {
            kotlin.g.b.k.a();
        }
        bVar.a(true, 0);
    }

    private static void a(LinearLayout linearLayout, ImageView imageView, boolean z2) {
        linearLayout.setSelected(z2);
        imageView.setSelected(z2);
    }

    private final void b(String str, int i2) {
        CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
        if (cJRBusTicketFilters != null) {
            cJRBusTicketFilters.setSortBy(str);
        }
        CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
        if (cJRBusTicketFilters2 != null) {
            cJRBusTicketFilters2.setOrderBy(i2);
        }
    }

    /* access modifiers changed from: private */
    public final void g() {
        TextView textView = this.ag;
        if (textView == null) {
            kotlin.g.b.k.a("mTextTimeMorning");
        }
        textView.setSelected(false);
        TextView textView2 = this.ah;
        if (textView2 == null) {
            kotlin.g.b.k.a("mTextTimeAfternoon");
        }
        textView2.setSelected(false);
        TextView textView3 = this.ai;
        if (textView3 == null) {
            kotlin.g.b.k.a("mTextTimeEvening");
        }
        textView3.setSelected(false);
        TextView textView4 = this.aj;
        if (textView4 == null) {
            kotlin.g.b.k.a("mTextTimeNight");
        }
        textView4.setSelected(false);
        LinearLayout linearLayout = this.w;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytTimeMorning");
        }
        linearLayout.setSelected(false);
        LinearLayout linearLayout2 = this.x;
        if (linearLayout2 == null) {
            kotlin.g.b.k.a("mLytTimeAfternoon");
        }
        linearLayout2.setSelected(false);
        LinearLayout linearLayout3 = this.y;
        if (linearLayout3 == null) {
            kotlin.g.b.k.a("mLytTimeEvening");
        }
        linearLayout3.setSelected(false);
        LinearLayout linearLayout4 = this.z;
        if (linearLayout4 == null) {
            kotlin.g.b.k.a("mLytTimeNight");
        }
        linearLayout4.setSelected(false);
        ImageView imageView = this.O;
        if (imageView == null) {
            kotlin.g.b.k.a("mImgTimeMorning");
        }
        imageView.setSelected(false);
        ImageView imageView2 = this.P;
        if (imageView2 == null) {
            kotlin.g.b.k.a("mImgTimeAfternoon");
        }
        imageView2.setSelected(false);
        ImageView imageView3 = this.Q;
        if (imageView3 == null) {
            kotlin.g.b.k.a("mImgTimeEvening");
        }
        imageView3.setSelected(false);
        ImageView imageView4 = this.R;
        if (imageView4 == null) {
            kotlin.g.b.k.a("mImgTimeNight");
        }
        imageView4.setSelected(false);
    }

    private final void h() {
        CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
        if (cJRBusTicketFilters == null) {
            kotlin.g.b.k.a();
        }
        CJRBusTicketFilterItem busFilterItemByTitle = cJRBusTicketFilters.getBusFilterItemByTitle("Deprture Time");
        g();
        if (busFilterItemByTitle != null) {
            String timeMinValue = busFilterItemByTitle.getTimeMinValue();
            String timeMaxValue = busFilterItemByTitle.getTimeMaxValue();
            if (timeMinValue != null && timeMaxValue != null) {
                if (p.a(timeMinValue, this.k, true) && p.a(timeMaxValue, this.m, true)) {
                    LinearLayout linearLayout = this.w;
                    if (linearLayout == null) {
                        kotlin.g.b.k.a("mLytTimeMorning");
                    }
                    linearLayout.setSelected(true);
                    TextView textView = this.ag;
                    if (textView == null) {
                        kotlin.g.b.k.a("mTextTimeMorning");
                    }
                    textView.setSelected(true);
                    ImageView imageView = this.O;
                    if (imageView == null) {
                        kotlin.g.b.k.a("mImgTimeMorning");
                    }
                    imageView.setSelected(true);
                } else if (p.a(timeMinValue, this.m, true) && p.a(timeMaxValue, this.n, true)) {
                    LinearLayout linearLayout2 = this.x;
                    if (linearLayout2 == null) {
                        kotlin.g.b.k.a("mLytTimeAfternoon");
                    }
                    linearLayout2.setSelected(true);
                    TextView textView2 = this.ah;
                    if (textView2 == null) {
                        kotlin.g.b.k.a("mTextTimeAfternoon");
                    }
                    textView2.setSelected(true);
                    ImageView imageView2 = this.P;
                    if (imageView2 == null) {
                        kotlin.g.b.k.a("mImgTimeAfternoon");
                    }
                    imageView2.setSelected(true);
                } else if (p.a(timeMinValue, this.n, true) && p.a(timeMaxValue, this.o, true)) {
                    LinearLayout linearLayout3 = this.y;
                    if (linearLayout3 == null) {
                        kotlin.g.b.k.a("mLytTimeEvening");
                    }
                    linearLayout3.setSelected(true);
                    TextView textView3 = this.ai;
                    if (textView3 == null) {
                        kotlin.g.b.k.a("mTextTimeEvening");
                    }
                    textView3.setSelected(true);
                    ImageView imageView3 = this.Q;
                    if (imageView3 == null) {
                        kotlin.g.b.k.a("mImgTimeEvening");
                    }
                    imageView3.setSelected(true);
                } else if (p.a(timeMinValue, this.o, true) && p.a(timeMaxValue, this.l, true)) {
                    LinearLayout linearLayout4 = this.z;
                    if (linearLayout4 == null) {
                        kotlin.g.b.k.a("mLytTimeNight");
                    }
                    linearLayout4.setSelected(true);
                    TextView textView4 = this.aj;
                    if (textView4 == null) {
                        kotlin.g.b.k.a("mTextTimeNight");
                    }
                    textView4.setSelected(true);
                    ImageView imageView4 = this.R;
                    if (imageView4 == null) {
                        kotlin.g.b.k.a("mImgTimeNight");
                    }
                    imageView4.setSelected(true);
                }
            }
        }
    }

    private final void i() {
        CJRBusTicketFilterItem cJRBusTicketFilterItem;
        CJRBusTicketFilterItem cJRBusTicketFilterItem2;
        CJRBusTicketFilterItem cJRBusTicketFilterItem3;
        CJRBusTicketFilterItem cJRBusTicketFilterItem4;
        CJRBusTicketFilterItem cJRBusTicketFilterItem5;
        boolean z2;
        CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle = cJRBusTicketFilters != null ? cJRBusTicketFilters.getBusFilterItemByTitle("AC") : null;
        CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle2 = cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusFilterItemByTitle("Non AC") : null;
        CJRBusTicketFilters cJRBusTicketFilters3 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle3 = cJRBusTicketFilters3 != null ? cJRBusTicketFilters3.getBusFilterItemByTitle("Sleeper") : null;
        CJRBusTicketFilters cJRBusTicketFilters4 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle4 = cJRBusTicketFilters4 != null ? cJRBusTicketFilters4.getBusFilterItemByTitle("Seater") : null;
        CJRBusTicketFilters cJRBusTicketFilters5 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle5 = cJRBusTicketFilters5 != null ? cJRBusTicketFilters5.getBusFilterItemByTitle("Semi Sleeper") : null;
        CJRBusTicketFilters cJRBusTicketFilters6 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle6 = cJRBusTicketFilters6 != null ? cJRBusTicketFilters6.getBusFilterItemByTitle("Multi Axle") : null;
        CJRBusTicketFilters cJRBusTicketFilters7 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle7 = cJRBusTicketFilters7 != null ? cJRBusTicketFilters7.getBusFilterItemByTitle("Single Axle") : null;
        CJRBusTicketFilters cJRBusTicketFilters8 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle8 = cJRBusTicketFilters8 != null ? cJRBusTicketFilters8.getBusFilterItemByTitle("Volvo") : null;
        CJRBusTicketFilters cJRBusTicketFilters9 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle9 = cJRBusTicketFilters9 != null ? cJRBusTicketFilters9.getBusFilterItemByTitle("Mercedes") : null;
        CJRBusTicketFilters cJRBusTicketFilters10 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle10 = cJRBusTicketFilters10 != null ? cJRBusTicketFilters10.getBusFilterItemByTitle("Scania") : null;
        CJRBusTicketFilters cJRBusTicketFilters11 = this.f22077c;
        if (cJRBusTicketFilters11 != null) {
            cJRBusTicketFilterItem = cJRBusTicketFilters11.getBusFilterItemByTitle(this.aU + "Rating");
        } else {
            cJRBusTicketFilterItem = null;
        }
        CJRBusTicketFilters cJRBusTicketFilters12 = this.f22077c;
        if (cJRBusTicketFilters12 != null) {
            cJRBusTicketFilterItem2 = cJRBusTicketFilters12.getBusFilterItemByTitle(this.aV + "Rating");
        } else {
            cJRBusTicketFilterItem2 = null;
        }
        CJRBusTicketFilters cJRBusTicketFilters13 = this.f22077c;
        if (cJRBusTicketFilters13 != null) {
            StringBuilder sb = new StringBuilder();
            cJRBusTicketFilterItem3 = busFilterItemByTitle10;
            sb.append(this.aW);
            sb.append("Rating");
            cJRBusTicketFilterItem4 = cJRBusTicketFilters13.getBusFilterItemByTitle(sb.toString());
        } else {
            cJRBusTicketFilterItem3 = busFilterItemByTitle10;
            cJRBusTicketFilterItem4 = null;
        }
        CJRBusTicketFilters cJRBusTicketFilters14 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle11 = cJRBusTicketFilters14 != null ? cJRBusTicketFilters14.getBusFilterItemByTitle("Deals") : null;
        CJRBusTicketFilters cJRBusTicketFilters15 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle12 = cJRBusTicketFilters15 != null ? cJRBusTicketFilters15.getBusFilterItemByTitle("Popular Choice") : null;
        CJRBusTicketFilters cJRBusTicketFilters16 = this.f22077c;
        CJRBusTicketFilterItem cJRBusTicketFilterItem6 = busFilterItemByTitle12;
        CJRBusTicketFilterItem busFilterItemByTitle13 = cJRBusTicketFilters16 != null ? cJRBusTicketFilters16.getBusFilterItemByTitle("Social Distancing") : null;
        k();
        j();
        CJRBusTicketFilterItem cJRBusTicketFilterItem7 = busFilterItemByTitle11;
        if (busFilterItemByTitle != null) {
            TextView textView = this.ak;
            if (textView == null) {
                kotlin.g.b.k.a("mTextTypeAC");
            }
            cJRBusTicketFilterItem5 = busFilterItemByTitle9;
            textView.setSelected(busFilterItemByTitle.isToggleChecked());
            LinearLayout linearLayout = this.A;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mLytTypeAC");
            }
            linearLayout.setSelected(busFilterItemByTitle.isToggleChecked());
            ImageView imageView = this.S;
            if (imageView == null) {
                kotlin.g.b.k.a("mImgTypeAC");
            }
            imageView.setSelected(busFilterItemByTitle.isToggleChecked());
        } else {
            cJRBusTicketFilterItem5 = busFilterItemByTitle9;
            TextView textView2 = this.ak;
            if (textView2 == null) {
                kotlin.g.b.k.a("mTextTypeAC");
            }
            textView2.setSelected(false);
            LinearLayout linearLayout2 = this.A;
            if (linearLayout2 == null) {
                kotlin.g.b.k.a("mLytTypeAC");
            }
            linearLayout2.setSelected(false);
            ImageView imageView2 = this.S;
            if (imageView2 == null) {
                kotlin.g.b.k.a("mImgTypeAC");
            }
            imageView2.setSelected(false);
        }
        if (busFilterItemByTitle2 != null) {
            TextView textView3 = this.al;
            if (textView3 == null) {
                kotlin.g.b.k.a("mTextTypeNonAC");
            }
            textView3.setSelected(busFilterItemByTitle2.isToggleChecked());
            LinearLayout linearLayout3 = this.B;
            if (linearLayout3 == null) {
                kotlin.g.b.k.a("mLytTypeNonAC");
            }
            linearLayout3.setSelected(busFilterItemByTitle2.isToggleChecked());
            ImageView imageView3 = this.T;
            if (imageView3 == null) {
                kotlin.g.b.k.a("mImgTypeNonAC");
            }
            imageView3.setSelected(busFilterItemByTitle2.isToggleChecked());
        } else {
            TextView textView4 = this.al;
            if (textView4 == null) {
                kotlin.g.b.k.a("mTextTypeNonAC");
            }
            textView4.setSelected(false);
            LinearLayout linearLayout4 = this.B;
            if (linearLayout4 == null) {
                kotlin.g.b.k.a("mLytTypeNonAC");
            }
            linearLayout4.setSelected(false);
            ImageView imageView4 = this.T;
            if (imageView4 == null) {
                kotlin.g.b.k.a("mImgTypeNonAC");
            }
            imageView4.setSelected(false);
        }
        if (busFilterItemByTitle3 != null) {
            TextView textView5 = this.an;
            if (textView5 == null) {
                kotlin.g.b.k.a("mTextTypeSleeper");
            }
            textView5.setSelected(busFilterItemByTitle3.isToggleChecked());
            LinearLayout linearLayout5 = this.D;
            if (linearLayout5 == null) {
                kotlin.g.b.k.a("mLytTypeSleeper");
            }
            linearLayout5.setSelected(busFilterItemByTitle3.isToggleChecked());
            ImageView imageView5 = this.V;
            if (imageView5 == null) {
                kotlin.g.b.k.a("mImgTypeSleeper");
            }
            imageView5.setSelected(busFilterItemByTitle3.isToggleChecked());
        } else {
            TextView textView6 = this.an;
            if (textView6 == null) {
                kotlin.g.b.k.a("mTextTypeSleeper");
            }
            textView6.setSelected(false);
            LinearLayout linearLayout6 = this.D;
            if (linearLayout6 == null) {
                kotlin.g.b.k.a("mLytTypeSleeper");
            }
            linearLayout6.setSelected(false);
            ImageView imageView6 = this.V;
            if (imageView6 == null) {
                kotlin.g.b.k.a("mImgTypeSleeper");
            }
            imageView6.setSelected(false);
        }
        if (busFilterItemByTitle5 != null) {
            TextView textView7 = this.ao;
            if (textView7 == null) {
                kotlin.g.b.k.a("mTextTypeSemiSleeper");
            }
            textView7.setSelected(busFilterItemByTitle5.isToggleChecked());
            LinearLayout linearLayout7 = this.E;
            if (linearLayout7 == null) {
                kotlin.g.b.k.a("mLytTypeSemiSleeper");
            }
            linearLayout7.setSelected(busFilterItemByTitle5.isToggleChecked());
            ImageView imageView7 = this.W;
            if (imageView7 == null) {
                kotlin.g.b.k.a("mImgTypeSemiSleeper");
            }
            imageView7.setSelected(busFilterItemByTitle5.isToggleChecked());
        } else {
            TextView textView8 = this.ao;
            if (textView8 == null) {
                kotlin.g.b.k.a("mTextTypeSemiSleeper");
            }
            textView8.setSelected(false);
            LinearLayout linearLayout8 = this.E;
            if (linearLayout8 == null) {
                kotlin.g.b.k.a("mLytTypeSemiSleeper");
            }
            linearLayout8.setSelected(false);
            ImageView imageView8 = this.W;
            if (imageView8 == null) {
                kotlin.g.b.k.a("mImgTypeSemiSleeper");
            }
            imageView8.setSelected(false);
        }
        if (cJRBusTicketFilterItem != null) {
            ConstraintLayout constraintLayout = this.ap;
            if (constraintLayout == null) {
                kotlin.g.b.k.a("mClRatings5");
            }
            constraintLayout.performClick();
        }
        if (cJRBusTicketFilterItem2 != null) {
            ConstraintLayout constraintLayout2 = this.aq;
            if (constraintLayout2 == null) {
                kotlin.g.b.k.a("mClRatingsAbove4");
            }
            constraintLayout2.performClick();
        }
        if (cJRBusTicketFilterItem4 != null) {
            ConstraintLayout constraintLayout3 = this.ar;
            if (constraintLayout3 == null) {
                kotlin.g.b.k.a("mClRatingsAbove3");
            }
            constraintLayout3.performClick();
        }
        if (busFilterItemByTitle4 != null) {
            TextView textView9 = this.am;
            if (textView9 == null) {
                kotlin.g.b.k.a("mTextTypeSeater");
            }
            textView9.setSelected(busFilterItemByTitle4.isToggleChecked());
            LinearLayout linearLayout9 = this.C;
            if (linearLayout9 == null) {
                kotlin.g.b.k.a("mLytTypeSeater");
            }
            linearLayout9.setSelected(busFilterItemByTitle4.isToggleChecked());
            ImageView imageView9 = this.U;
            if (imageView9 == null) {
                kotlin.g.b.k.a("mImgTypeSeater");
            }
            imageView9.setSelected(busFilterItemByTitle4.isToggleChecked());
        } else {
            TextView textView10 = this.am;
            if (textView10 == null) {
                kotlin.g.b.k.a("mTextTypeSeater");
            }
            textView10.setSelected(false);
            LinearLayout linearLayout10 = this.C;
            if (linearLayout10 == null) {
                kotlin.g.b.k.a("mLytTypeSeater");
            }
            linearLayout10.setSelected(false);
            ImageView imageView10 = this.U;
            if (imageView10 == null) {
                kotlin.g.b.k.a("mImgTypeSeater");
            }
            imageView10.setSelected(false);
        }
        if (busFilterItemByTitle6 != null) {
            LinearLayout linearLayout11 = this.J;
            if (linearLayout11 == null) {
                kotlin.g.b.k.a("mLytTypeMultiAxle");
            }
            linearLayout11.setSelected(busFilterItemByTitle6.isToggleChecked());
            ImageView imageView11 = this.ab;
            if (imageView11 == null) {
                kotlin.g.b.k.a("mImgTypeMultiAxle");
            }
            imageView11.setSelected(busFilterItemByTitle6.isToggleChecked());
        } else {
            LinearLayout linearLayout12 = this.J;
            if (linearLayout12 == null) {
                kotlin.g.b.k.a("mLytTypeMultiAxle");
            }
            linearLayout12.setSelected(false);
            ImageView imageView12 = this.ab;
            if (imageView12 == null) {
                kotlin.g.b.k.a("mImgTypeMultiAxle");
            }
            imageView12.setSelected(false);
        }
        if (busFilterItemByTitle7 != null) {
            LinearLayout linearLayout13 = this.I;
            if (linearLayout13 == null) {
                kotlin.g.b.k.a("mLytTypeSingleAxle");
            }
            linearLayout13.setSelected(busFilterItemByTitle7.isToggleChecked());
            ImageView imageView13 = this.aa;
            if (imageView13 == null) {
                kotlin.g.b.k.a("mImgTypeSingleAxle");
            }
            imageView13.setSelected(busFilterItemByTitle7.isToggleChecked());
        } else {
            LinearLayout linearLayout14 = this.I;
            if (linearLayout14 == null) {
                kotlin.g.b.k.a("mLytTypeSingleAxle");
            }
            linearLayout14.setSelected(false);
            ImageView imageView14 = this.aa;
            if (imageView14 == null) {
                kotlin.g.b.k.a("mImgTypeSingleAxle");
            }
            imageView14.setSelected(false);
        }
        if (busFilterItemByTitle8 != null) {
            LinearLayout linearLayout15 = this.F;
            if (linearLayout15 == null) {
                kotlin.g.b.k.a("mLytTypeVolvo");
            }
            linearLayout15.setSelected(busFilterItemByTitle8.isToggleChecked());
            ImageView imageView15 = this.X;
            if (imageView15 == null) {
                kotlin.g.b.k.a("mImgTypeVolvo");
            }
            imageView15.setSelected(busFilterItemByTitle8.isToggleChecked());
        } else {
            LinearLayout linearLayout16 = this.F;
            if (linearLayout16 == null) {
                kotlin.g.b.k.a("mLytTypeVolvo");
            }
            linearLayout16.setSelected(false);
            ImageView imageView16 = this.X;
            if (imageView16 == null) {
                kotlin.g.b.k.a("mImgTypeVolvo");
            }
            imageView16.setSelected(false);
        }
        if (cJRBusTicketFilterItem5 != null) {
            LinearLayout linearLayout17 = this.H;
            if (linearLayout17 == null) {
                kotlin.g.b.k.a("mLytTypeMercedes");
            }
            linearLayout17.setSelected(cJRBusTicketFilterItem5.isToggleChecked());
            ImageView imageView17 = this.Z;
            if (imageView17 == null) {
                kotlin.g.b.k.a("mImgTypeMercedes");
            }
            imageView17.setSelected(cJRBusTicketFilterItem5.isToggleChecked());
        } else {
            LinearLayout linearLayout18 = this.H;
            if (linearLayout18 == null) {
                kotlin.g.b.k.a("mLytTypeMercedes");
            }
            linearLayout18.setSelected(false);
            ImageView imageView18 = this.Z;
            if (imageView18 == null) {
                kotlin.g.b.k.a("mImgTypeMercedes");
            }
            imageView18.setSelected(false);
        }
        if (cJRBusTicketFilterItem3 != null) {
            LinearLayout linearLayout19 = this.G;
            if (linearLayout19 == null) {
                kotlin.g.b.k.a("mLytTypeScania");
            }
            linearLayout19.setSelected(cJRBusTicketFilterItem3.isToggleChecked());
            ImageView imageView19 = this.Y;
            if (imageView19 == null) {
                kotlin.g.b.k.a("mImgTypeScania");
            }
            imageView19.setSelected(cJRBusTicketFilterItem3.isToggleChecked());
            z2 = false;
        } else {
            LinearLayout linearLayout20 = this.G;
            if (linearLayout20 == null) {
                kotlin.g.b.k.a("mLytTypeScania");
            }
            z2 = false;
            linearLayout20.setSelected(false);
            ImageView imageView20 = this.Y;
            if (imageView20 == null) {
                kotlin.g.b.k.a("mImgTypeScania");
            }
            imageView20.setSelected(false);
        }
        Switch switchR = this.aB;
        if (switchR == null) {
            kotlin.g.b.k.a("mDealsToggleButton");
        }
        switchR.setChecked(cJRBusTicketFilterItem7 != null);
        Switch switchR2 = this.aD;
        if (switchR2 == null) {
            kotlin.g.b.k.a("mSwCovidBuses");
        }
        switchR2.setChecked(busFilterItemByTitle13 != null);
        Switch switchR3 = this.aC;
        if (switchR3 == null) {
            kotlin.g.b.k.a("mPopularChoiceToggle");
        }
        if (cJRBusTicketFilterItem6 != null) {
            z2 = true;
        }
        switchR3.setChecked(z2);
    }

    private final void j() {
        ArrayList<CJRBusSearchOperatorTagInfo> arrayList = this.bc;
        if (arrayList == null || arrayList.size() <= 0) {
            RelativeLayout relativeLayout = this.t;
            if (relativeLayout == null) {
                kotlin.g.b.k.a("mOperatorTagContainer");
            }
            relativeLayout.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout2 = this.t;
        if (relativeLayout2 == null) {
            kotlin.g.b.k.a("mOperatorTagContainer");
        }
        relativeLayout2.setVisibility(0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 0, false);
        RecyclerView recyclerView = this.u;
        if (recyclerView == null) {
            kotlin.g.b.k.a("mRecycleOperatorTagsFilterList");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        this.bf = new v(getActivity(), this.bc, this);
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 == null) {
            kotlin.g.b.k.a("mRecycleOperatorTagsFilterList");
        }
        recyclerView2.setAdapter(this.bf);
        v vVar = this.bf;
        if (vVar == null) {
            kotlin.g.b.k.a();
        }
        vVar.notifyDataSetChanged();
    }

    private final void k() {
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        this.bc.clear();
        ArrayList<CJRBusSearchOperatorTagInfo> arrayList = this.bc;
        HashMap<String, CJRBusSearchOperatorTagInfo> hashMap = this.bb;
        if (hashMap == null) {
            kotlin.g.b.k.a();
        }
        arrayList.addAll(new ArrayList(hashMap.values()));
        CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
        if (cJRBusTicketFilters == null || (busTicketFilterItems = cJRBusTicketFilters.getBusTicketFilterItems()) == null || busTicketFilterItems.size() != 0) {
            CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
            if (cJRBusTicketFilters2 != null) {
                ArrayList<CJRBusTicketFilterItem> arrayList2 = null;
                if ((cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusTicketFilterItems() : null) != null) {
                    CJRBusTicketFilters cJRBusTicketFilters3 = this.f22077c;
                    if (cJRBusTicketFilters3 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (cJRBusTicketFilters3.getBusTicketFilterItems().size() > 0) {
                        CJRBusTicketFilters cJRBusTicketFilters4 = this.f22077c;
                        if (cJRBusTicketFilters4 != null) {
                            arrayList2 = cJRBusTicketFilters4.getBusTicketFilterItems();
                        }
                        if (arrayList2 == null) {
                            kotlin.g.b.k.a();
                        }
                        int size = arrayList2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            CJRBusTicketFilters cJRBusTicketFilters5 = this.f22077c;
                            if (cJRBusTicketFilters5 == null) {
                                kotlin.g.b.k.a();
                            }
                            CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters5.getBusTicketFilterItems().get(i2);
                            kotlin.g.b.k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters!!.busTicketFilterItems[i]");
                            if (kotlin.g.b.k.a((Object) cJRBusTicketFilterItem.getType(), (Object) "OperatorTag")) {
                                int size2 = this.bc.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = this.bc.get(i3);
                                    kotlin.g.b.k.a((Object) cJRBusSearchOperatorTagInfo, "mCurrentSelectedOperatorTagsList[j]");
                                    String tagId = cJRBusSearchOperatorTagInfo.getTagId();
                                    CJRBusTicketFilters cJRBusTicketFilters6 = this.f22077c;
                                    if (cJRBusTicketFilters6 == null) {
                                        kotlin.g.b.k.a();
                                    }
                                    CJRBusTicketFilterItem cJRBusTicketFilterItem2 = cJRBusTicketFilters6.getBusTicketFilterItems().get(i2);
                                    kotlin.g.b.k.a((Object) cJRBusTicketFilterItem2, "mBusTicketFilters!!.busTicketFilterItems[i]");
                                    if (kotlin.g.b.k.a((Object) tagId, (Object) cJRBusTicketFilterItem2.getOperatorTagId())) {
                                        CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo2 = this.bc.get(i3);
                                        kotlin.g.b.k.a((Object) cJRBusSearchOperatorTagInfo2, "mCurrentSelectedOperatorTagsList[j]");
                                        cJRBusSearchOperatorTagInfo2.setSelected(true);
                                    }
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        l();
    }

    private final void l() {
        ArrayList<CJRBusSearchOperatorTagInfo> arrayList = this.bc;
        if (arrayList != null && arrayList.size() > 0) {
            int size = this.bc.size();
            for (int i2 = 0; i2 < size; i2++) {
                CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = this.bc.get(i2);
                kotlin.g.b.k.a((Object) cJRBusSearchOperatorTagInfo, "mCurrentSelectedOperatorTagsList[i]");
                cJRBusSearchOperatorTagInfo.setSelected(false);
            }
        }
    }

    public final void onClick(View view) {
        kotlin.g.b.k.c(view, "v");
        int id = view.getId();
        boolean z2 = true;
        if (id == R.id.apply_filter_button) {
            Map hashMap = new HashMap();
            hashMap.put("event_category", "bus_search");
            hashMap.put("event_action", "more_filters_clicked");
            hashMap.put("event_label", this.aZ);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-search");
            hashMap.put("vertical_name", "bus");
            CharSequence n2 = com.paytm.utility.b.n((Context) getActivity());
            if (!(n2 == null || n2.length() == 0)) {
                z2 = false;
            }
            if (!z2) {
                String n3 = com.paytm.utility.b.n((Context) getActivity());
                kotlin.g.b.k.a((Object) n3, "CJRAppCommonUtility.getUserId(activity)");
                hashMap.put("user_id", n3);
            }
            kotlin.g.b.k.a((Object) com.travel.bus.a.a(), "BusController.getInstance()");
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
            m();
            CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
            if (cJRBusTicketFilters == null) {
                kotlin.g.b.k.a();
            }
            a(cJRBusTicketFilters);
            Intent intent = new Intent();
            intent.putExtra("intent_extra_bus_search_filter_items", this.f22077c);
            intent.putExtra("intent_extra_bus_search_filter_amenity_items", this.f22076b);
            if (this.f22075a) {
                intent.putExtra("intent_extra_extra_bp_dp_required", false);
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                kotlin.g.b.k.a();
            }
            activity.setResult(-1, intent);
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                kotlin.g.b.k.a();
            }
            activity2.finish();
        } else if (id == R.id.lyt_boarding_points_container) {
            com.travel.bus.busticket.busfilter.b bVar = this.bj;
            if (bVar != null) {
                bVar.a(1);
            }
        } else if (id == R.id.lyt_operators_container) {
            com.travel.bus.busticket.busfilter.b bVar2 = this.bj;
            if (bVar2 != null) {
                bVar2.a(2);
            }
        } else if (id == R.id.lyt_amenities_container) {
            com.travel.bus.busticket.busfilter.b bVar3 = this.bj;
            if (bVar3 != null) {
                bVar3.a(3);
            }
        } else if (id == R.id.lyt_dropping_points_container) {
            com.travel.bus.busticket.busfilter.b bVar4 = this.bj;
            if (bVar4 != null) {
                bVar4.a(4);
            }
        } else if (id == R.id.img_close_filter) {
            FragmentActivity activity3 = getActivity();
            if (activity3 == null) {
                kotlin.g.b.k.a();
            }
            activity3.finish();
        } else if (id == R.id.text_reset_all_filter) {
            CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
            if (cJRBusTicketFilters2 != null) {
                if ((cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusTicketFilterItems() : null) != null) {
                    CJRBusTicketFilters cJRBusTicketFilters3 = this.f22077c;
                    if (cJRBusTicketFilters3 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (cJRBusTicketFilters3.getBusTicketFilterItems().size() > 0) {
                        CJRBusTicketFilters cJRBusTicketFilters4 = this.f22077c;
                        if (cJRBusTicketFilters4 == null) {
                            kotlin.g.b.k.a();
                        }
                        cJRBusTicketFilters4.getBusTicketFilterItems().clear();
                        ArrayList<CJRBusSearchAmenitiesInfo> arrayList = this.f22076b;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                }
            }
            c();
            d();
        }
    }

    private final void n() {
        v vVar = this.bf;
        if (vVar == null) {
            kotlin.g.b.k.a();
        }
        ArrayList<CJRBusSearchOperatorTagInfo> a2 = vVar.a();
        if (this.bc != null) {
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bc.contains(a2.get(i2))) {
                    ArrayList<CJRBusSearchOperatorTagInfo> arrayList = this.bc;
                    CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = arrayList.get(arrayList.indexOf(a2.get(i2)));
                    kotlin.g.b.k.a((Object) cJRBusSearchOperatorTagInfo, "mCurrentSelectedOperator…agsList.indexOf(list[i])]");
                    cJRBusSearchOperatorTagInfo.setSelected(true);
                }
            }
        }
    }

    public final void c() {
        HashMap hashMap = new HashMap();
        CharSequence n2 = com.paytm.utility.b.n((Context) getActivity());
        if (!(n2 == null || n2.length() == 0)) {
            String n3 = com.paytm.utility.b.n((Context) getActivity());
            kotlin.g.b.k.a((Object) n3, "CJRAppCommonUtility.getUserId(activity)");
            hashMap.put("user_id", n3);
        }
        kotlin.g.b.k.a((Object) com.travel.bus.a.a(), "BusController.getInstance()");
        com.travel.bus.a.b().a("bus_search_reset_all_clicked", (Map<String, Object>) hashMap, (Context) getActivity());
    }

    public final void a(ArrayList<CJRBusSearchOperatorTagInfo> arrayList) {
        kotlin.g.b.k.c(arrayList, "mSelectedList");
        this.f22078d = arrayList;
        b();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f22081h) {
            if (i3 == -1 && intent != null && intent.hasExtra("intent_extra_bus_search_filter_items")) {
                Serializable serializableExtra = intent.getSerializableExtra("intent_extra_bus_search_filter_items");
                if (serializableExtra != null) {
                    this.f22077c = (CJRBusTicketFilters) serializableExtra;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
                }
            }
        } else if (i2 == this.f22082i) {
            if (i3 == -1 && intent != null && intent.hasExtra("intent_extra_bus_search_filter_items")) {
                Serializable serializableExtra2 = intent.getSerializableExtra("intent_extra_bus_search_filter_items");
                if (serializableExtra2 != null) {
                    this.f22077c = (CJRBusTicketFilters) serializableExtra2;
                } else {
                    throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
                }
            }
        } else if (i2 == this.j && i3 == -1 && intent != null && intent.hasExtra("intent_extra_bus_search_filter_items")) {
            Serializable serializableExtra3 = intent.getSerializableExtra("intent_extra_bus_search_filter_items");
            if (serializableExtra3 != null) {
                this.f22077c = (CJRBusTicketFilters) serializableExtra3;
            } else {
                throw new u("null cannot be cast to non-null type com.travel.bus.pojo.busticket.CJRBusTicketFilters");
            }
        }
        o();
    }

    /* access modifiers changed from: private */
    public final void o() {
        TextView textView = this.aH;
        if (textView == null) {
            kotlin.g.b.k.a("mTextBoardingPointsCount");
        }
        textView.setVisibility(8);
        TextView textView2 = this.aJ;
        if (textView2 == null) {
            kotlin.g.b.k.a("mTextDroppingPointsCount");
        }
        textView2.setVisibility(8);
        TextView textView3 = this.aL;
        if (textView3 == null) {
            kotlin.g.b.k.a("mTextOperatorsCount");
        }
        textView3.setVisibility(8);
        TextView textView4 = this.aM;
        if (textView4 == null) {
            kotlin.g.b.k.a("mTextAmenitiesCount");
        }
        textView4.setVisibility(8);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
        if (cJRBusTicketFilters != null) {
            if (cJRBusTicketFilters == null) {
                kotlin.g.b.k.a();
            }
            if (cJRBusTicketFilters.getBusTicketFilterItems() != null) {
                CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
                if (cJRBusTicketFilters2 == null) {
                    kotlin.g.b.k.a();
                }
                Iterator<CJRBusTicketFilterItem> it2 = cJRBusTicketFilters2.getBusTicketFilterItems().iterator();
                while (it2.hasNext()) {
                    CJRBusTicketFilterItem next = it2.next();
                    kotlin.g.b.k.a((Object) next, "busTicketFilterItem");
                    if (p.a(next.getTitle(), "B.Pt", true)) {
                        if (!TextUtils.isEmpty(next.getDisplayValue())) {
                            arrayList.add(next.getDisplayValue());
                        }
                    } else if (p.a(next.getTitle(), "D.Pt", true)) {
                        if (!TextUtils.isEmpty(next.getDisplayValue())) {
                            arrayList2.add(next.getDisplayValue());
                        }
                    } else if (p.a(next.getTitle(), "Opr", true)) {
                        if (!TextUtils.isEmpty(next.getDisplayValue())) {
                            arrayList3.add(next.getDisplayValue());
                        }
                    } else if (p.a(next.getType(), "Amenity", true) && !TextUtils.isEmpty(next.getTitle())) {
                        arrayList4.add(next.getTitle());
                    }
                }
                if (arrayList.size() == 1 && !TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                    TextView textView5 = this.aH;
                    if (textView5 == null) {
                        kotlin.g.b.k.a("mTextBoardingPointsCount");
                    }
                    textView5.setVisibility(0);
                    TextView textView6 = this.aH;
                    if (textView6 == null) {
                        kotlin.g.b.k.a("mTextBoardingPointsCount");
                    }
                    Object obj = arrayList.get(0);
                    kotlin.g.b.k.a(obj, "boardingPoints[0]");
                    String str = (String) obj;
                    if (str != null) {
                        textView6.setText(p.b(str).toString());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else if (arrayList.size() > 1) {
                    TextView textView7 = this.aH;
                    if (textView7 == null) {
                        kotlin.g.b.k.a("mTextBoardingPointsCount");
                    }
                    textView7.setVisibility(0);
                    TextView textView8 = this.aH;
                    if (textView8 == null) {
                        kotlin.g.b.k.a("mTextBoardingPointsCount");
                    }
                    textView8.setText(String.valueOf(arrayList.size()) + " " + getResources().getString(R.string.boarding_points));
                }
                if (arrayList2.size() == 1 && !TextUtils.isEmpty((CharSequence) arrayList2.get(0))) {
                    TextView textView9 = this.aJ;
                    if (textView9 == null) {
                        kotlin.g.b.k.a("mTextDroppingPointsCount");
                    }
                    textView9.setVisibility(0);
                    TextView textView10 = this.aJ;
                    if (textView10 == null) {
                        kotlin.g.b.k.a("mTextDroppingPointsCount");
                    }
                    Object obj2 = arrayList2.get(0);
                    kotlin.g.b.k.a(obj2, "droppingPoints[0]");
                    String str2 = (String) obj2;
                    if (str2 != null) {
                        textView10.setText(p.b(str2).toString());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else if (arrayList2.size() > 1) {
                    TextView textView11 = this.aJ;
                    if (textView11 == null) {
                        kotlin.g.b.k.a("mTextDroppingPointsCount");
                    }
                    textView11.setVisibility(0);
                    TextView textView12 = this.aJ;
                    if (textView12 == null) {
                        kotlin.g.b.k.a("mTextDroppingPointsCount");
                    }
                    textView12.setText(String.valueOf(arrayList2.size()) + " " + getResources().getString(R.string.dropping_points));
                }
                if (arrayList4.size() == 1 && !TextUtils.isEmpty((CharSequence) arrayList4.get(0))) {
                    TextView textView13 = this.aM;
                    if (textView13 == null) {
                        kotlin.g.b.k.a("mTextAmenitiesCount");
                    }
                    textView13.setVisibility(0);
                    TextView textView14 = this.aM;
                    if (textView14 == null) {
                        kotlin.g.b.k.a("mTextAmenitiesCount");
                    }
                    Object obj3 = arrayList4.get(0);
                    kotlin.g.b.k.a(obj3, "amenities[0]");
                    String str3 = (String) obj3;
                    if (str3 != null) {
                        textView14.setText(p.b(str3).toString());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else if (arrayList4.size() > 1) {
                    TextView textView15 = this.aM;
                    if (textView15 == null) {
                        kotlin.g.b.k.a("mTextAmenitiesCount");
                    }
                    textView15.setVisibility(0);
                    TextView textView16 = this.aM;
                    if (textView16 == null) {
                        kotlin.g.b.k.a("mTextAmenitiesCount");
                    }
                    textView16.setText(String.valueOf(arrayList4.size()) + " " + getResources().getString(R.string.title_amenities));
                }
                if (arrayList3.size() == 1 && !TextUtils.isEmpty((CharSequence) arrayList3.get(0))) {
                    TextView textView17 = this.aL;
                    if (textView17 == null) {
                        kotlin.g.b.k.a("mTextOperatorsCount");
                    }
                    textView17.setVisibility(0);
                    TextView textView18 = this.aL;
                    if (textView18 == null) {
                        kotlin.g.b.k.a("mTextOperatorsCount");
                    }
                    Object obj4 = arrayList3.get(0);
                    kotlin.g.b.k.a(obj4, "busOperators[0]");
                    String str4 = (String) obj4;
                    if (str4 != null) {
                        textView18.setText(p.b(str4).toString());
                        return;
                    }
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                } else if (arrayList3.size() > 1) {
                    TextView textView19 = this.aL;
                    if (textView19 == null) {
                        kotlin.g.b.k.a("mTextOperatorsCount");
                    }
                    textView19.setVisibility(0);
                    TextView textView20 = this.aL;
                    if (textView20 == null) {
                        kotlin.g.b.k.a("mTextOperatorsCount");
                    }
                    textView20.setText(String.valueOf(arrayList3.size()) + " " + getResources().getString(R.string.bus_operators));
                }
            }
        }
    }

    public final void d() {
        i();
        h();
        o();
    }

    private final void a(boolean z2) {
        CJRBusTicketFilters cJRBusTicketFilters;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        CJRBusTicketFilters cJRBusTicketFilters2;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems3;
        CJRBusTicketFilters cJRBusTicketFilters3;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems4;
        CJRBusTicketFilters cJRBusTicketFilters4;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems5;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems6;
        CJRBusTicketFilters cJRBusTicketFilters5 = this.f22077c;
        ArrayList<CJRBusTicketFilterItem> arrayList = null;
        CJRBusTicketFilterItem busFilterItemByTitle = cJRBusTicketFilters5 != null ? cJRBusTicketFilters5.getBusFilterItemByTitle("AC") : null;
        if (busFilterItemByTitle == null) {
            busFilterItemByTitle = new CJRBusTicketFilterItem();
            busFilterItemByTitle.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
        }
        busFilterItemByTitle.setTitle("AC");
        busFilterItemByTitle.setType("boolean");
        busFilterItemByTitle.setToggleChecked(true);
        CJRBusTicketFilters cJRBusTicketFilters6 = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle2 = cJRBusTicketFilters6 != null ? cJRBusTicketFilters6.getBusFilterItemByTitle("Non AC") : null;
        if (busFilterItemByTitle2 == null) {
            busFilterItemByTitle2 = new CJRBusTicketFilterItem();
            busFilterItemByTitle2.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
        }
        busFilterItemByTitle2.setTitle("Non AC");
        busFilterItemByTitle2.setType("boolean");
        busFilterItemByTitle2.setToggleChecked(true);
        if (z2) {
            CJRBusTicketFilters cJRBusTicketFilters7 = this.f22077c;
            Boolean valueOf = (cJRBusTicketFilters7 == null || (busTicketFilterItems6 = cJRBusTicketFilters7.getBusTicketFilterItems()) == null) ? null : Boolean.valueOf(busTicketFilterItems6.contains(busFilterItemByTitle));
            if (valueOf == null) {
                kotlin.g.b.k.a();
            }
            if (!(valueOf.booleanValue() || (cJRBusTicketFilters4 = this.f22077c) == null || (busTicketFilterItems5 = cJRBusTicketFilters4.getBusTicketFilterItems()) == null)) {
                busTicketFilterItems5.add(busFilterItemByTitle);
            }
            CJRBusTicketFilters cJRBusTicketFilters8 = this.f22077c;
            if (cJRBusTicketFilters8 != null) {
                arrayList = cJRBusTicketFilters8.getBusTicketFilterItems();
            }
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            if (arrayList.contains(busFilterItemByTitle2) && (cJRBusTicketFilters3 = this.f22077c) != null && (busTicketFilterItems4 = cJRBusTicketFilters3.getBusTicketFilterItems()) != null) {
                busTicketFilterItems4.remove(busFilterItemByTitle2);
                return;
            }
            return;
        }
        CJRBusTicketFilters cJRBusTicketFilters9 = this.f22077c;
        Boolean valueOf2 = (cJRBusTicketFilters9 == null || (busTicketFilterItems3 = cJRBusTicketFilters9.getBusTicketFilterItems()) == null) ? null : Boolean.valueOf(busTicketFilterItems3.contains(busFilterItemByTitle2));
        if (valueOf2 == null) {
            kotlin.g.b.k.a();
        }
        if (!(valueOf2.booleanValue() || (cJRBusTicketFilters2 = this.f22077c) == null || (busTicketFilterItems2 = cJRBusTicketFilters2.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems2.add(busFilterItemByTitle2);
        }
        CJRBusTicketFilters cJRBusTicketFilters10 = this.f22077c;
        if (cJRBusTicketFilters10 != null) {
            arrayList = cJRBusTicketFilters10.getBusTicketFilterItems();
        }
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        if (arrayList.contains(busFilterItemByTitle) && (cJRBusTicketFilters = this.f22077c) != null && (busTicketFilterItems = cJRBusTicketFilters.getBusTicketFilterItems()) != null) {
            busTicketFilterItems.remove(busFilterItemByTitle);
        }
    }

    private final void a(int i2) {
        CJRBusTicketFilters cJRBusTicketFilters;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        CJRBusTicketFilters cJRBusTicketFilters2;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
        CJRBusTicketFilters cJRBusTicketFilters3;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems3;
        CJRBusTicketFilters cJRBusTicketFilters4;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems4;
        CJRBusTicketFilters cJRBusTicketFilters5;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems5;
        CJRBusTicketFilters cJRBusTicketFilters6;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems6;
        CJRBusTicketFilterItem a2 = a("Sleeper");
        CJRBusTicketFilterItem a3 = a("Seater");
        CJRBusTicketFilterItem a4 = a("Semi Sleeper");
        CJRBusTicketFilters cJRBusTicketFilters7 = this.f22077c;
        ArrayList<CJRBusTicketFilterItem> arrayList = null;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems7 = cJRBusTicketFilters7 != null ? cJRBusTicketFilters7.getBusTicketFilterItems() : null;
        if (busTicketFilterItems7 == null) {
            kotlin.g.b.k.a();
        }
        if (!(!busTicketFilterItems7.contains(a3) || (cJRBusTicketFilters6 = this.f22077c) == null || (busTicketFilterItems6 = cJRBusTicketFilters6.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems6.remove(a3);
        }
        CJRBusTicketFilters cJRBusTicketFilters8 = this.f22077c;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems8 = cJRBusTicketFilters8 != null ? cJRBusTicketFilters8.getBusTicketFilterItems() : null;
        if (busTicketFilterItems8 == null) {
            kotlin.g.b.k.a();
        }
        if (!(!busTicketFilterItems8.contains(a2) || (cJRBusTicketFilters5 = this.f22077c) == null || (busTicketFilterItems5 = cJRBusTicketFilters5.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems5.remove(a2);
        }
        CJRBusTicketFilters cJRBusTicketFilters9 = this.f22077c;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems9 = cJRBusTicketFilters9 != null ? cJRBusTicketFilters9.getBusTicketFilterItems() : null;
        if (busTicketFilterItems9 == null) {
            kotlin.g.b.k.a();
        }
        if (!(!busTicketFilterItems9.contains(a4) || (cJRBusTicketFilters4 = this.f22077c) == null || (busTicketFilterItems4 = cJRBusTicketFilters4.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems4.remove(a4);
        }
        if (i2 == 1) {
            CJRBusTicketFilters cJRBusTicketFilters10 = this.f22077c;
            if (cJRBusTicketFilters10 != null) {
                arrayList = cJRBusTicketFilters10.getBusTicketFilterItems();
            }
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            if (!arrayList.contains(a2) && (cJRBusTicketFilters3 = this.f22077c) != null && (busTicketFilterItems3 = cJRBusTicketFilters3.getBusTicketFilterItems()) != null) {
                busTicketFilterItems3.add(a2);
            }
        } else if (i2 == 2) {
            CJRBusTicketFilters cJRBusTicketFilters11 = this.f22077c;
            if (cJRBusTicketFilters11 != null) {
                arrayList = cJRBusTicketFilters11.getBusTicketFilterItems();
            }
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            if (!arrayList.contains(a3) && (cJRBusTicketFilters2 = this.f22077c) != null && (busTicketFilterItems2 = cJRBusTicketFilters2.getBusTicketFilterItems()) != null) {
                busTicketFilterItems2.add(a3);
            }
        } else if (i2 == 3) {
            CJRBusTicketFilters cJRBusTicketFilters12 = this.f22077c;
            if (cJRBusTicketFilters12 != null) {
                arrayList = cJRBusTicketFilters12.getBusTicketFilterItems();
            }
            if (arrayList == null) {
                kotlin.g.b.k.a();
            }
            if (!arrayList.contains(a4) && (cJRBusTicketFilters = this.f22077c) != null && (busTicketFilterItems = cJRBusTicketFilters.getBusTicketFilterItems()) != null) {
                busTicketFilterItems.add(a4);
            }
        }
    }

    private final CJRBusTicketFilterItem a(String str) {
        CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
        CJRBusTicketFilterItem busFilterItemByTitle = cJRBusTicketFilters != null ? cJRBusTicketFilters.getBusFilterItemByTitle(str) : null;
        if (busFilterItemByTitle == null) {
            busFilterItemByTitle = new CJRBusTicketFilterItem();
            busFilterItemByTitle.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_TYPE);
        }
        busFilterItemByTitle.setTitle(str);
        busFilterItemByTitle.setType("boolean");
        busFilterItemByTitle.setToggleChecked(true);
        return busFilterItemByTitle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (kotlin.m.p.a(r2, "single Axle", true) == false) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.travel.bus.pojo.busticket.CJRBusTicketFilters r7) {
        /*
            r6 = this;
            java.util.ArrayList r7 = r7.getBusTicketFilterItems()     // Catch:{ Exception -> 0x02ef }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x02ef }
        L_0x0008:
            boolean r0 = r7.hasNext()     // Catch:{ Exception -> 0x02ef }
            r1 = 1
            if (r0 == 0) goto L_0x0220
            java.lang.Object r0 = r7.next()     // Catch:{ Exception -> 0x02ef }
            com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r0 = (com.travel.bus.pojo.busticket.CJRBusTicketFilterItem) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = "item"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            if (r2 == 0) goto L_0x0008
            java.lang.String r3 = "A/C"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r4 = "|"
            if (r3 != 0) goto L_0x005c
            java.lang.String r3 = "Non AC"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 != 0) goto L_0x005c
            java.lang.String r3 = "Seater"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 != 0) goto L_0x005c
            java.lang.String r3 = "Sleeper"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 != 0) goto L_0x005c
            java.lang.String r3 = "Semi Sleeper"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 != 0) goto L_0x005c
            java.lang.String r3 = "MUlti Axle"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 != 0) goto L_0x005c
            java.lang.String r3 = "single Axle"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x008e
        L_0x005c:
            java.lang.String r3 = r6.aP     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02ef }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x007c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aP     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x008c
        L_0x007c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x008c:
            r6.aP = r3     // Catch:{ Exception -> 0x02ef }
        L_0x008e:
            java.lang.String r3 = "Scania"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 != 0) goto L_0x00a6
            java.lang.String r3 = "Mercedes"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 != 0) goto L_0x00a6
            java.lang.String r3 = "Volvo"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x00d8
        L_0x00a6:
            java.lang.String r3 = r6.aP     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02ef }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x00c6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aP     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x00d6
        L_0x00c6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x00d6:
            r6.aP = r3     // Catch:{ Exception -> 0x02ef }
        L_0x00d8:
            java.lang.String r3 = "Departure Time"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x0112
            java.lang.String r3 = r6.aZ     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02ef }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x0100
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aZ     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x0110
        L_0x0100:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x0110:
            r6.aZ = r3     // Catch:{ Exception -> 0x02ef }
        L_0x0112:
            java.lang.String r3 = "Price"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x014c
            java.lang.String r3 = r6.aY     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02ef }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x013a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aY     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x014a
        L_0x013a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getTitle()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x014a:
            r6.aY = r3     // Catch:{ Exception -> 0x02ef }
        L_0x014c:
            java.lang.String r3 = "B.Pt"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x0192
            java.lang.String r3 = r6.aR     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02ef }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x0174
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aR     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getDisplayValue()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x0190
        L_0x0174:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aR     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getDisplayValue()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x0190:
            r6.aR = r3     // Catch:{ Exception -> 0x02ef }
        L_0x0192:
            java.lang.String r3 = "D.Pt"
            boolean r3 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x01d8
            java.lang.String r3 = r6.aS     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x02ef }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x02ef }
            if (r3 == 0) goto L_0x01ba
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aS     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getDisplayValue()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x01d6
        L_0x01ba:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aS     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r0.getDisplayValue()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x01d6:
            r6.aS = r3     // Catch:{ Exception -> 0x02ef }
        L_0x01d8:
            java.lang.String r3 = "Opr"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)     // Catch:{ Exception -> 0x02ef }
            if (r1 == 0) goto L_0x0008
            java.lang.String r1 = r6.aT     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x02ef }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x02ef }
            if (r1 == 0) goto L_0x0200
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r1.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = r6.aT     // Catch:{ Exception -> 0x02ef }
            r1.append(r2)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r0 = r0.getDisplayValue()     // Catch:{ Exception -> 0x02ef }
            r1.append(r0)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x02ef }
            goto L_0x021c
        L_0x0200:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r1.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = r6.aT     // Catch:{ Exception -> 0x02ef }
            r1.append(r2)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r0 = r0.getDisplayValue()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02ef }
            r1.append(r0)     // Catch:{ Exception -> 0x02ef }
            r1.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x02ef }
        L_0x021c:
            r6.aT = r0     // Catch:{ Exception -> 0x02ef }
            goto L_0x0008
        L_0x0220:
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x02ef }
            r7.<init>()     // Catch:{ Exception -> 0x02ef }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = "event_category"
            java.lang.String r3 = "bus_search"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x02ef }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = "event_action"
            java.lang.String r3 = "apply_clicked"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x02ef }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = "event_label"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r4 = r6.aZ     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            r4 = 38
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aP     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aQ     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aY     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x02ef }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = "event_label2"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ef }
            r3.<init>()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aT     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r5 = r6.aR     // Catch:{ Exception -> 0x02ef }
            r3.append(r5)     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r4 = r6.aS     // Catch:{ Exception -> 0x02ef }
            r3.append(r4)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x02ef }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x02ef }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = "screenName"
            java.lang.String r3 = "/bus-tickets-search"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x02ef }
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = "vertical_name"
            java.lang.String r3 = "bus"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x02ef }
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()     // Catch:{ Exception -> 0x02ef }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r0)     // Catch:{ Exception -> 0x02ef }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02ef }
            if (r0 == 0) goto L_0x02ba
            int r0 = r0.length()     // Catch:{ Exception -> 0x02ef }
            if (r0 != 0) goto L_0x02b9
            goto L_0x02ba
        L_0x02b9:
            r1 = 0
        L_0x02ba:
            if (r1 != 0) goto L_0x02d4
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ef }
            java.lang.String r1 = "user_id"
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()     // Catch:{ Exception -> 0x02ef }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x02ef }
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r2)     // Catch:{ Exception -> 0x02ef }
            java.lang.String r3 = "CJRAppCommonUtility.getUserId(activity)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x02ef }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x02ef }
        L_0x02d4:
            com.travel.bus.a r0 = com.travel.bus.a.a()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r1 = "BusController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x02ef }
            com.travel.g.a r0 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x02ef }
            java.lang.String r1 = "custom_event"
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Exception -> 0x02ef }
            androidx.fragment.app.FragmentActivity r2 = r6.getActivity()     // Catch:{ Exception -> 0x02ef }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x02ef }
            r0.a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r2)     // Catch:{ Exception -> 0x02ef }
            return
        L_0x02ef:
            r7 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x02fb
            java.lang.String r7 = r7.getMessage()
            com.paytm.utility.q.c(r7)
        L_0x02fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.busfilter.b.c.a(com.travel.bus.pojo.busticket.CJRBusTicketFilters):void");
    }

    public final boolean e() {
        CJRBusTicketFilters cJRBusTicketFilters = this.f22077c;
        if (cJRBusTicketFilters != null) {
            if (cJRBusTicketFilters == null) {
                kotlin.g.b.k.a();
            }
            if (cJRBusTicketFilters.getBusTicketFilterItems() != null) {
                CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
                if (cJRBusTicketFilters2 == null) {
                    kotlin.g.b.k.a();
                }
                if (cJRBusTicketFilters2.getBusTicketFilterItems().size() > 0) {
                    return true;
                }
            }
        }
        if (!this.f22079e && this.f22078d.size() <= 0) {
            return false;
        }
        return true;
    }

    private final void m() {
        CJRBusTicketFilters cJRBusTicketFilters;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
        CJRBusTicketFilters cJRBusTicketFilters2 = this.f22077c;
        if (cJRBusTicketFilters2 != null) {
            if ((cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusTicketFilterItems() : null) != null) {
                CJRBusTicketFilters cJRBusTicketFilters3 = this.f22077c;
                if (cJRBusTicketFilters3 == null) {
                    kotlin.g.b.k.a();
                }
                if (cJRBusTicketFilters3.getBusTicketFilterItems().size() > 0) {
                    CJRBusTicketFilters cJRBusTicketFilters4 = this.f22077c;
                    ArrayList<CJRBusTicketFilterItem> busTicketFilterItems3 = cJRBusTicketFilters4 != null ? cJRBusTicketFilters4.getBusTicketFilterItems() : null;
                    if (busTicketFilterItems3 == null) {
                        kotlin.g.b.k.a();
                    }
                    ArrayList arrayList = new ArrayList(busTicketFilterItems3);
                    CJRBusTicketFilters cJRBusTicketFilters5 = this.f22077c;
                    if (cJRBusTicketFilters5 == null) {
                        kotlin.g.b.k.a();
                    }
                    ArrayList<CJRBusTicketFilterItem> busTicketFilterItems4 = cJRBusTicketFilters5.getBusTicketFilterItems();
                    kotlin.g.b.k.a((Object) busTicketFilterItems4, "mBusTicketFilters!!.busTicketFilterItems");
                    int size = busTicketFilterItems4.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        CJRBusTicketFilters cJRBusTicketFilters6 = this.f22077c;
                        if (cJRBusTicketFilters6 == null) {
                            kotlin.g.b.k.a();
                        }
                        CJRBusTicketFilterItem cJRBusTicketFilterItem = cJRBusTicketFilters6.getBusTicketFilterItems().get(i2);
                        kotlin.g.b.k.a((Object) cJRBusTicketFilterItem, "mBusTicketFilters!!.busTicketFilterItems[i]");
                        if (kotlin.g.b.k.a((Object) cJRBusTicketFilterItem.getType(), (Object) "OperatorTag")) {
                            CJRBusTicketFilters cJRBusTicketFilters7 = this.f22077c;
                            if (cJRBusTicketFilters7 == null) {
                                kotlin.g.b.k.a();
                            }
                            arrayList.remove(cJRBusTicketFilters7.getBusTicketFilterItems().get(i2));
                        }
                    }
                    CJRBusTicketFilters cJRBusTicketFilters8 = this.f22077c;
                    if (cJRBusTicketFilters8 == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRBusTicketFilters8.getBusTicketFilterItems().clear();
                    CJRBusTicketFilters cJRBusTicketFilters9 = this.f22077c;
                    if (cJRBusTicketFilters9 == null) {
                        kotlin.g.b.k.a();
                    }
                    cJRBusTicketFilters9.getBusTicketFilterItems().addAll(arrayList);
                }
            }
        }
        v vVar = this.bf;
        if (vVar != null) {
            if (vVar == null) {
                kotlin.g.b.k.a();
            }
            if (vVar.a() != null) {
                n();
                int size2 = this.bc.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = this.bc.get(i3);
                    kotlin.g.b.k.a((Object) cJRBusSearchOperatorTagInfo, "mCurrentSelectedOperatorTagsList[i]");
                    if (cJRBusSearchOperatorTagInfo.isSelected()) {
                        CJRBusTicketFilterItem cJRBusTicketFilterItem2 = new CJRBusTicketFilterItem();
                        cJRBusTicketFilterItem2.setFilterCategory(com.travel.bus.pojo.busticket.e.BUS_OPERATORTAG);
                        CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo2 = this.bc.get(i3);
                        kotlin.g.b.k.a((Object) cJRBusSearchOperatorTagInfo2, "mCurrentSelectedOperatorTagsList[i]");
                        cJRBusTicketFilterItem2.setTitle(cJRBusSearchOperatorTagInfo2.getLabel());
                        cJRBusTicketFilterItem2.setType("OperatorTag");
                        CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo3 = this.bc.get(i3);
                        kotlin.g.b.k.a((Object) cJRBusSearchOperatorTagInfo3, "mCurrentSelectedOperatorTagsList[i]");
                        cJRBusTicketFilterItem2.setOperatorTagId(cJRBusSearchOperatorTagInfo3.getTagId());
                        CJRBusTicketFilters cJRBusTicketFilters10 = this.f22077c;
                        Boolean valueOf = (cJRBusTicketFilters10 == null || (busTicketFilterItems2 = cJRBusTicketFilters10.getBusTicketFilterItems()) == null) ? null : Boolean.valueOf(busTicketFilterItems2.contains(cJRBusTicketFilterItem2));
                        if (valueOf == null) {
                            kotlin.g.b.k.a();
                        }
                        if (!(valueOf.booleanValue() || (cJRBusTicketFilters = this.f22077c) == null || (busTicketFilterItems = cJRBusTicketFilters.getBusTicketFilterItems()) == null)) {
                            busTicketFilterItems.add(cJRBusTicketFilterItem2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042 A[Catch:{ Exception -> 0x0088 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.travel.bus.busticket.busfilter.b.c r4, com.travel.bus.pojo.busticket.CJRBusTicketFilterItem r5) {
        /*
            if (r5 == 0) goto L_0x0094
            java.lang.String r0 = r5.getTitle()     // Catch:{ Exception -> 0x0088 }
            if (r0 == 0) goto L_0x0094
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0088 }
            r0.<init>()     // Catch:{ Exception -> 0x0088 }
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0088 }
            java.lang.String r2 = "bus_type"
            java.lang.String r5 = r5.getTitle()     // Catch:{ Exception -> 0x0088 }
            java.lang.String r3 = "busTicketFilterItem.title"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)     // Catch:{ Exception -> 0x0088 }
            r1.put(r2, r5)     // Catch:{ Exception -> 0x0088 }
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0088 }
            java.lang.String r1 = "screenName"
            java.lang.String r2 = "Bus Select Bus page - Refine section"
            r5.put(r1, r2)     // Catch:{ Exception -> 0x0088 }
            androidx.fragment.app.FragmentActivity r5 = r4.getActivity()     // Catch:{ Exception -> 0x0088 }
            android.content.Context r5 = (android.content.Context) r5     // Catch:{ Exception -> 0x0088 }
            java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r5)     // Catch:{ Exception -> 0x0088 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x0088 }
            if (r5 == 0) goto L_0x003f
            int r5 = r5.length()     // Catch:{ Exception -> 0x0088 }
            if (r5 != 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r5 = 0
            goto L_0x0040
        L_0x003f:
            r5 = 1
        L_0x0040:
            if (r5 != 0) goto L_0x0059
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0088 }
            java.lang.String r1 = "bus_user_id"
            androidx.fragment.app.FragmentActivity r2 = r4.getActivity()     // Catch:{ Exception -> 0x0088 }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ Exception -> 0x0088 }
            java.lang.String r2 = com.paytm.utility.b.n((android.content.Context) r2)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r3 = "CJRAppCommonUtility.getUserId(activity)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0088 }
            r5.put(r1, r2)     // Catch:{ Exception -> 0x0088 }
        L_0x0059:
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0088 }
            java.lang.String r1 = "bus_origin"
            java.lang.String r2 = r4.aN     // Catch:{ Exception -> 0x0088 }
            r5.put(r1, r2)     // Catch:{ Exception -> 0x0088 }
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0088 }
            java.lang.String r1 = "bus_destination"
            java.lang.String r2 = r4.aO     // Catch:{ Exception -> 0x0088 }
            r5.put(r1, r2)     // Catch:{ Exception -> 0x0088 }
            com.travel.bus.a r5 = com.travel.bus.a.a()     // Catch:{ Exception -> 0x0088 }
            java.lang.String r1 = "BusController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x0088 }
            com.travel.g.a r5 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0088 }
            java.lang.String r1 = "bus_refine_bus_type_selected"
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0088 }
            androidx.fragment.app.FragmentActivity r4 = r4.getActivity()     // Catch:{ Exception -> 0x0088 }
            android.content.Context r4 = (android.content.Context) r4     // Catch:{ Exception -> 0x0088 }
            r5.a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r0, (android.content.Context) r4)     // Catch:{ Exception -> 0x0088 }
            return
        L_0x0088:
            r4 = move-exception
            boolean r5 = com.paytm.utility.b.v
            if (r5 == 0) goto L_0x0094
            java.lang.String r4 = r4.getMessage()
            com.paytm.utility.q.c(r4)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.busfilter.b.c.a(com.travel.bus.busticket.busfilter.b.c, com.travel.bus.pojo.busticket.CJRBusTicketFilterItem):void");
    }

    public static final /* synthetic */ void a(c cVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("bus_brand", str);
        CharSequence n2 = com.paytm.utility.b.n((Context) cVar.getActivity());
        if (!(n2 == null || n2.length() == 0)) {
            String n3 = com.paytm.utility.b.n((Context) cVar.getActivity());
            kotlin.g.b.k.a((Object) n3, "CJRAppCommonUtility.getUserId(activity)");
            hashMap.put("user_id", n3);
        }
        kotlin.g.b.k.a((Object) com.travel.bus.a.a(), "BusController.getInstance()");
        com.travel.bus.a.b().a("bus_search_brand_filter_selected", (Map<String, Object>) hashMap, (Context) cVar.getActivity());
    }

    public static final /* synthetic */ void b(c cVar, CJRBusTicketFilterItem cJRBusTicketFilterItem) {
        String a2 = com.paytm.utility.b.a(cJRBusTicketFilterItem.getTimeMinValue(), "HHmm", "h:mm a");
        String a3 = com.paytm.utility.b.a(cJRBusTicketFilterItem.getTimeMaxValue(), "HHmm", "h:mm a");
        cVar.aZ = a2 + " " + cVar.getString(R.string.to) + " " + a3;
    }

    public static final /* synthetic */ void a(c cVar, int i2) {
        if (i2 == R.id.lyt_ac) {
            TextView textView = cVar.ak;
            if (textView == null) {
                kotlin.g.b.k.a("mTextTypeAC");
            }
            textView.setSelected(false);
            LinearLayout linearLayout = cVar.A;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mLytTypeAC");
            }
            linearLayout.setSelected(false);
            ImageView imageView = cVar.S;
            if (imageView == null) {
                kotlin.g.b.k.a("mImgTypeAC");
            }
            imageView.setSelected(false);
        }
        if (i2 == R.id.lyt_non_ac) {
            TextView textView2 = cVar.al;
            if (textView2 == null) {
                kotlin.g.b.k.a("mTextTypeNonAC");
            }
            textView2.setSelected(false);
            LinearLayout linearLayout2 = cVar.B;
            if (linearLayout2 == null) {
                kotlin.g.b.k.a("mLytTypeNonAC");
            }
            linearLayout2.setSelected(false);
            ImageView imageView2 = cVar.T;
            if (imageView2 == null) {
                kotlin.g.b.k.a("mImgTypeNonAC");
            }
            imageView2.setSelected(false);
        }
    }

    public static final /* synthetic */ void m(c cVar) {
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
        TextView textView = cVar.ak;
        if (textView == null) {
            kotlin.g.b.k.a("mTextTypeAC");
        }
        if (textView.isSelected()) {
            cVar.a("AC", "type_selected");
            cVar.a(true);
        } else {
            TextView textView2 = cVar.al;
            if (textView2 == null) {
                kotlin.g.b.k.a("mTextTypeNonAC");
            }
            if (textView2.isSelected()) {
                cVar.a("Non-AC", "type_selected");
                cVar.a(false);
            } else {
                CJRBusTicketFilters cJRBusTicketFilters = cVar.f22077c;
                CJRBusTicketFilterItem cJRBusTicketFilterItem = null;
                if (!(cJRBusTicketFilters == null || (busTicketFilterItems2 = cJRBusTicketFilters.getBusTicketFilterItems()) == null)) {
                    CJRBusTicketFilters cJRBusTicketFilters2 = cVar.f22077c;
                    busTicketFilterItems2.remove(cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusFilterItemByTitle("AC") : null);
                }
                CJRBusTicketFilters cJRBusTicketFilters3 = cVar.f22077c;
                if (!(cJRBusTicketFilters3 == null || (busTicketFilterItems = cJRBusTicketFilters3.getBusTicketFilterItems()) == null)) {
                    CJRBusTicketFilters cJRBusTicketFilters4 = cVar.f22077c;
                    if (cJRBusTicketFilters4 != null) {
                        cJRBusTicketFilterItem = cJRBusTicketFilters4.getBusFilterItemByTitle("Non AC");
                    }
                    busTicketFilterItems.remove(cJRBusTicketFilterItem);
                }
            }
        }
        cVar.setUserVisibleHint(true);
    }

    public static final /* synthetic */ void b(c cVar, int i2) {
        if (i2 == R.id.lyt_sleeper) {
            TextView textView = cVar.an;
            if (textView == null) {
                kotlin.g.b.k.a("mTextTypeSleeper");
            }
            textView.setSelected(false);
            LinearLayout linearLayout = cVar.D;
            if (linearLayout == null) {
                kotlin.g.b.k.a("mLytTypeSleeper");
            }
            linearLayout.setSelected(false);
            ImageView imageView = cVar.V;
            if (imageView == null) {
                kotlin.g.b.k.a("mImgTypeSleeper");
            }
            imageView.setSelected(false);
        }
        if (i2 == R.id.lyt_seater) {
            TextView textView2 = cVar.am;
            if (textView2 == null) {
                kotlin.g.b.k.a("mTextTypeSeater");
            }
            textView2.setSelected(false);
            LinearLayout linearLayout2 = cVar.C;
            if (linearLayout2 == null) {
                kotlin.g.b.k.a("mLytTypeSeater");
            }
            linearLayout2.setSelected(false);
            ImageView imageView2 = cVar.U;
            if (imageView2 == null) {
                kotlin.g.b.k.a("mImgTypeSeater");
            }
            imageView2.setSelected(false);
        }
        if (i2 == R.id.lyt_semi_sleeper) {
            TextView textView3 = cVar.ao;
            if (textView3 == null) {
                kotlin.g.b.k.a("mTextTypeSemiSleeper");
            }
            textView3.setSelected(false);
            LinearLayout linearLayout3 = cVar.E;
            if (linearLayout3 == null) {
                kotlin.g.b.k.a("mLytTypeSemiSleeper");
            }
            linearLayout3.setSelected(false);
            ImageView imageView3 = cVar.W;
            if (imageView3 == null) {
                kotlin.g.b.k.a("mImgTypeSemiSleeper");
            }
            imageView3.setSelected(false);
        }
    }

    public static final /* synthetic */ void n(c cVar) {
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems2;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems3;
        TextView textView = cVar.an;
        if (textView == null) {
            kotlin.g.b.k.a("mTextTypeSleeper");
        }
        if (textView.isSelected()) {
            cVar.a("SLEEPER", "type_selected");
            cVar.a(1);
        } else {
            TextView textView2 = cVar.am;
            if (textView2 == null) {
                kotlin.g.b.k.a("mTextTypeSeater");
            }
            if (textView2.isSelected()) {
                cVar.a("SEATER", "type_selected");
                cVar.a(2);
            } else {
                TextView textView3 = cVar.ao;
                if (textView3 == null) {
                    kotlin.g.b.k.a("mTextTypeSemiSleeper");
                }
                if (textView3.isSelected()) {
                    cVar.a("SEMI-SLEEPER", "type_selected");
                    cVar.a(3);
                } else {
                    CJRBusTicketFilters cJRBusTicketFilters = cVar.f22077c;
                    CJRBusTicketFilterItem cJRBusTicketFilterItem = null;
                    if (!(cJRBusTicketFilters == null || (busTicketFilterItems3 = cJRBusTicketFilters.getBusTicketFilterItems()) == null)) {
                        CJRBusTicketFilters cJRBusTicketFilters2 = cVar.f22077c;
                        busTicketFilterItems3.remove(cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusFilterItemByTitle("Sleeper") : null);
                    }
                    CJRBusTicketFilters cJRBusTicketFilters3 = cVar.f22077c;
                    if (!(cJRBusTicketFilters3 == null || (busTicketFilterItems2 = cJRBusTicketFilters3.getBusTicketFilterItems()) == null)) {
                        CJRBusTicketFilters cJRBusTicketFilters4 = cVar.f22077c;
                        busTicketFilterItems2.remove(cJRBusTicketFilters4 != null ? cJRBusTicketFilters4.getBusFilterItemByTitle("Seater") : null);
                    }
                    CJRBusTicketFilters cJRBusTicketFilters5 = cVar.f22077c;
                    if (!(cJRBusTicketFilters5 == null || (busTicketFilterItems = cJRBusTicketFilters5.getBusTicketFilterItems()) == null)) {
                        CJRBusTicketFilters cJRBusTicketFilters6 = cVar.f22077c;
                        if (cJRBusTicketFilters6 != null) {
                            cJRBusTicketFilterItem = cJRBusTicketFilters6.getBusFilterItemByTitle("Semi Sleeper");
                        }
                        busTicketFilterItems.remove(cJRBusTicketFilterItem);
                    }
                }
            }
        }
        cVar.setUserVisibleHint(true);
    }

    public static final /* synthetic */ void b(c cVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("event_label", str);
        hashMap.put("event_label2", cVar.aN + '/' + cVar.aO);
        CharSequence n2 = com.paytm.utility.b.n((Context) cVar.getActivity());
        if (!(n2 == null || n2.length() == 0)) {
            String n3 = com.paytm.utility.b.n((Context) cVar.getActivity());
            kotlin.g.b.k.a((Object) n3, "CJRAppCommonUtility.getUserId(activity)");
            hashMap.put("userid", n3);
        }
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", "sort_strip_clicked", hashMap);
    }

    public static final /* synthetic */ void a(c cVar, View view) {
        LinearLayout linearLayout = cVar.K;
        if (linearLayout == null) {
            kotlin.g.b.k.a("mLytSortTopRated");
        }
        if (kotlin.g.b.k.a((Object) view, (Object) linearLayout)) {
            LinearLayout linearLayout2 = cVar.L;
            if (linearLayout2 == null) {
                kotlin.g.b.k.a("mLytSortCheapest");
            }
            linearLayout2.setSelected(false);
            LinearLayout linearLayout3 = cVar.N;
            if (linearLayout3 == null) {
                kotlin.g.b.k.a("mLytSortEarlyBoarding");
            }
            linearLayout3.setSelected(false);
            LinearLayout linearLayout4 = cVar.M;
            if (linearLayout4 == null) {
                kotlin.g.b.k.a("mLytSortLateBoarding");
            }
            linearLayout4.setSelected(false);
            ImageView imageView = cVar.ad;
            if (imageView == null) {
                kotlin.g.b.k.a("mImgTypeSortCheapest");
            }
            imageView.setSelected(false);
            ImageView imageView2 = cVar.af;
            if (imageView2 == null) {
                kotlin.g.b.k.a("mImgTypeSortEarlyBoarding");
            }
            imageView2.setSelected(false);
            ImageView imageView3 = cVar.ae;
            if (imageView3 == null) {
                kotlin.g.b.k.a("mImgTypeSortLateBoarding");
            }
            imageView3.setSelected(false);
            return;
        }
        LinearLayout linearLayout5 = cVar.L;
        if (linearLayout5 == null) {
            kotlin.g.b.k.a("mLytSortCheapest");
        }
        if (kotlin.g.b.k.a((Object) view, (Object) linearLayout5)) {
            LinearLayout linearLayout6 = cVar.K;
            if (linearLayout6 == null) {
                kotlin.g.b.k.a("mLytSortTopRated");
            }
            linearLayout6.setSelected(false);
            LinearLayout linearLayout7 = cVar.N;
            if (linearLayout7 == null) {
                kotlin.g.b.k.a("mLytSortEarlyBoarding");
            }
            linearLayout7.setSelected(false);
            LinearLayout linearLayout8 = cVar.M;
            if (linearLayout8 == null) {
                kotlin.g.b.k.a("mLytSortLateBoarding");
            }
            linearLayout8.setSelected(false);
            ImageView imageView4 = cVar.ac;
            if (imageView4 == null) {
                kotlin.g.b.k.a("mImgTypeSortTopRated");
            }
            imageView4.setSelected(false);
            ImageView imageView5 = cVar.af;
            if (imageView5 == null) {
                kotlin.g.b.k.a("mImgTypeSortEarlyBoarding");
            }
            imageView5.setSelected(false);
            ImageView imageView6 = cVar.ae;
            if (imageView6 == null) {
                kotlin.g.b.k.a("mImgTypeSortLateBoarding");
            }
            imageView6.setSelected(false);
            return;
        }
        LinearLayout linearLayout9 = cVar.M;
        if (linearLayout9 == null) {
            kotlin.g.b.k.a("mLytSortLateBoarding");
        }
        if (kotlin.g.b.k.a((Object) view, (Object) linearLayout9)) {
            LinearLayout linearLayout10 = cVar.L;
            if (linearLayout10 == null) {
                kotlin.g.b.k.a("mLytSortCheapest");
            }
            linearLayout10.setSelected(false);
            LinearLayout linearLayout11 = cVar.N;
            if (linearLayout11 == null) {
                kotlin.g.b.k.a("mLytSortEarlyBoarding");
            }
            linearLayout11.setSelected(false);
            LinearLayout linearLayout12 = cVar.K;
            if (linearLayout12 == null) {
                kotlin.g.b.k.a("mLytSortTopRated");
            }
            linearLayout12.setSelected(false);
            ImageView imageView7 = cVar.ad;
            if (imageView7 == null) {
                kotlin.g.b.k.a("mImgTypeSortCheapest");
            }
            imageView7.setSelected(false);
            ImageView imageView8 = cVar.af;
            if (imageView8 == null) {
                kotlin.g.b.k.a("mImgTypeSortEarlyBoarding");
            }
            imageView8.setSelected(false);
            ImageView imageView9 = cVar.ac;
            if (imageView9 == null) {
                kotlin.g.b.k.a("mImgTypeSortTopRated");
            }
            imageView9.setSelected(false);
            return;
        }
        LinearLayout linearLayout13 = cVar.N;
        if (linearLayout13 == null) {
            kotlin.g.b.k.a("mLytSortEarlyBoarding");
        }
        if (kotlin.g.b.k.a((Object) view, (Object) linearLayout13)) {
            LinearLayout linearLayout14 = cVar.L;
            if (linearLayout14 == null) {
                kotlin.g.b.k.a("mLytSortCheapest");
            }
            linearLayout14.setSelected(false);
            LinearLayout linearLayout15 = cVar.K;
            if (linearLayout15 == null) {
                kotlin.g.b.k.a("mLytSortTopRated");
            }
            linearLayout15.setSelected(false);
            LinearLayout linearLayout16 = cVar.M;
            if (linearLayout16 == null) {
                kotlin.g.b.k.a("mLytSortLateBoarding");
            }
            linearLayout16.setSelected(false);
            ImageView imageView10 = cVar.ad;
            if (imageView10 == null) {
                kotlin.g.b.k.a("mImgTypeSortCheapest");
            }
            imageView10.setSelected(false);
            ImageView imageView11 = cVar.ac;
            if (imageView11 == null) {
                kotlin.g.b.k.a("mImgTypeSortTopRated");
            }
            imageView11.setSelected(false);
            ImageView imageView12 = cVar.ae;
            if (imageView12 == null) {
                kotlin.g.b.k.a("mImgTypeSortLateBoarding");
            }
            imageView12.setSelected(false);
        }
    }

    public static final /* synthetic */ void d(c cVar, String str) {
        CJRBusTicketFilters cJRBusTicketFilters;
        ArrayList<CJRBusTicketFilterItem> busTicketFilterItems;
        CJRBusTicketFilters cJRBusTicketFilters2 = cVar.f22077c;
        ArrayList<CJRBusTicketFilterItem> arrayList = null;
        CJRBusTicketFilterItem busFilterItemByTitle = cJRBusTicketFilters2 != null ? cJRBusTicketFilters2.getBusFilterItemByTitle(str) : null;
        CJRBusTicketFilters cJRBusTicketFilters3 = cVar.f22077c;
        if (cJRBusTicketFilters3 != null) {
            arrayList = cJRBusTicketFilters3.getBusTicketFilterItems();
        }
        if (arrayList == null) {
            kotlin.g.b.k.a();
        }
        if (!(!arrayList.contains(busFilterItemByTitle) || (cJRBusTicketFilters = cVar.f22077c) == null || (busTicketFilterItems = cJRBusTicketFilters.getBusTicketFilterItems()) == null)) {
            busTicketFilterItems.remove(busFilterItemByTitle);
        }
        cVar.aX = "";
        cVar.b();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.br;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
