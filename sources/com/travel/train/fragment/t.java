package com.travel.train.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.common.a.b;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.activity.AJRLSSearchTrains;
import com.travel.train.activity.AJRSearchByTrainResultActivity;
import com.travel.train.activity.AJRTrainHomeV2Activity;
import com.travel.train.b.ae;
import com.travel.train.i.ag;
import com.travel.train.i.r;
import com.travel.train.j.i;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.k.d;
import com.travel.train.k.g;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.searchResult.CJRSearchByTrainNumberModel;
import com.travel.train.model.trainticket.CJRTrainHolidayList;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainSmartIcons;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.upi.util.UpiConstants;

public class t extends am implements b, r {

    /* renamed from: a  reason: collision with root package name */
    private String f27161a = "TAG_TRAIN_V2_HOME";

    /* renamed from: b  reason: collision with root package name */
    private String f27162b = "search";

    /* renamed from: c  reason: collision with root package name */
    private final String f27163c = t.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CJRTrainSmartIcons> f27164d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f27165e;

    /* renamed from: f  reason: collision with root package name */
    private ae f27166f;

    /* renamed from: g  reason: collision with root package name */
    private Fragment f27167g;

    /* renamed from: h  reason: collision with root package name */
    private NestedScrollView f27168h;

    /* renamed from: i  reason: collision with root package name */
    private long f27169i;
    private ViewTreeObserver.OnScrollChangedListener j;
    private d k;
    private com.travel.train.k.b l;
    private CJRHomePageItem m;
    private String n = "";
    private String o;
    private String p = "";
    private boolean q;
    private boolean r;
    private CJRTrainLSSearchResult.Train s = null;
    private CJRTrainLSSearchResult.Schedule t = null;
    private CJRTrainSearchInput u;
    private CJRTrainHolidayList v = null;
    private String w = null;
    private String x = "FJRTrainHomeV2Fragment";

    public static t a(Bundle bundle) {
        t tVar = new t();
        tVar.setArguments(bundle);
        return tVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.train_home_smart_icon_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        ArrayList<CJRTrainSmartIcons> arrayList;
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            this.k = (d) am.a(getActivity(), (al.b) new g(new g.a(g.b.V2_HOME).a(a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(getActivity().getApplicationContext()))))).a(d.class);
            this.l = (com.travel.train.k.b) am.a((Fragment) this, (al.b) new g(new g.a(g.b.SEARCHBYTRAIN).a(a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(getActivity().getApplicationContext()))))).a(com.travel.train.k.b.class);
        }
        try {
            if (getArguments() != null && getArguments().containsKey("extra_home_data") && (getArguments().getSerializable("extra_home_data") instanceof CJRHomePageItem)) {
                this.m = (CJRHomePageItem) getArguments().getSerializable("extra_home_data");
                if (!TextUtils.isEmpty(this.m.getURL())) {
                    String queryParameter = Uri.parse(this.m.getURL()).buildUpon().build().getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        this.m.setUrl(queryParameter);
                    }
                } else if (this.m instanceof CJRHomePageItem) {
                    String deeplink = this.m.getDeeplink();
                    if (!TextUtils.isEmpty(deeplink)) {
                        this.m.setUrl(deeplink);
                    }
                }
                if (this.m != null) {
                    if (!TextUtils.isEmpty(this.m.getURL())) {
                        Uri parse = Uri.parse(this.m.getURL());
                        if (!TextUtils.isEmpty(parse.getQueryParameter("landing"))) {
                            this.n = parse.getQueryParameter("landing");
                        } else if (parse.getPathSegments() != null && parse.getPathSegments().contains(this.f27162b)) {
                            this.n = "book_tickets";
                        }
                        if (!TextUtils.isEmpty(parse.getQueryParameter("modeid"))) {
                            this.o = parse.getQueryParameter("modeid");
                        }
                    }
                }
                if (getArguments() != null && getArguments().containsKey(UpiConstants.FROM)) {
                    this.p = getArguments().getString(UpiConstants.FROM);
                }
                if (this.p.equalsIgnoreCase("Order_summary")) {
                    this.n = "book_tickets";
                }
            }
            if (getArguments().containsKey("extra_intent_holiday_list")) {
                this.v = (CJRTrainHolidayList) getArguments().get("extra_intent_holiday_list");
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        a();
        this.f27165e = (RecyclerView) view.findViewById(R.id.horizontal_recycler);
        this.f27168h = (NestedScrollView) view.findViewById(R.id.nested_scroll_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        this.f27165e.setHasFixedSize(true);
        this.f27165e.setLayoutManager(gridLayoutManager);
        b();
        this.l.f27621a.observe(this, new z() {
            public final void onChanged(Object obj) {
                t.this.a((CJRSearchByTrainNumberModel) obj);
            }
        });
        this.l.f27626f.observe(this, new z() {
            public final void onChanged(Object obj) {
                t.this.a((Pair) obj);
            }
        });
        this.w = i.a();
        if (!TextUtils.isEmpty(this.n) && (arrayList = this.f27164d) != null && arrayList.size() > 0) {
            Iterator<CJRTrainSmartIcons> it2 = this.f27164d.iterator();
            while (it2.hasNext()) {
                CJRTrainSmartIcons next = it2.next();
                if (!TextUtils.isEmpty(next.getUrlType()) && next.getUrlType().equalsIgnoreCase(this.n)) {
                    a(next, next.getClickActionType());
                }
            }
        }
        this.j = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                t.this.e();
            }
        };
        this.f27168h.getViewTreeObserver().addOnScrollChangedListener(this.j);
        this.f27169i = System.currentTimeMillis();
        if (this.q) {
            d();
            this.q = false;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.r = true;
        super.onSaveInstanceState(bundle);
    }

    public void onResume() {
        this.r = false;
        super.onResume();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public void onVisibleToUser(boolean z) {
        new Handler().post(new Runnable() {
            public final void run() {
                t.this.g();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (!isAdded() || isDetached()) {
            this.q = true;
        } else {
            d();
        }
    }

    public void onVisibilityGone() {
        this.q = false;
        new Handler().post(new Runnable() {
            public final void run() {
                t.this.f();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.f27167g != null && isAdded() && !isDetached()) {
            getChildFragmentManager().a().a(this.f27167g).b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Pair pair) {
        showErrorDialog((String) pair.first, (String) pair.second);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 191 && i3 == -1) {
            if (intent.getSerializableExtra("intent_extra_train_selected") != null) {
                this.s = (CJRTrainLSSearchResult.Train) intent.getSerializableExtra("intent_extra_train_selected");
            }
            if (intent.getSerializableExtra("intent_extra_schedule_selected") != null) {
                this.t = (CJRTrainLSSearchResult.Schedule) intent.getSerializableExtra("intent_extra_schedule_selected");
            }
            if (this.s != null && this.t != null && !TextUtils.isEmpty(this.w)) {
                this.l.a(n.b((Context) getActivity()), n.a(this.s.getTrainNumber(), this.s.getSchedule().get(this.s.getSchedule().get(0).getSourceSelectedPosition()).getStationCode(), this.s.getSchedule().get(this.s.getSchedule().get(0).getDestSelectedPosition()).getStationCode(), this.w, (String) null), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (com.travel.train.j.g.f27551a == null || com.travel.train.j.g.f27551a.getSmartIconList() == null) {
            this.f27164d = o.a();
        } else {
            this.f27164d = com.travel.train.j.g.f27551a.getSmartIconList();
        }
    }

    public final void b() {
        ae aeVar = this.f27166f;
        if (aeVar == null) {
            this.f27166f = new ae(getActivity(), this.f27164d, this);
            this.f27165e.setAdapter(this.f27166f);
            return;
        }
        aeVar.a(this.f27164d);
    }

    public final void a(IJRDataModel iJRDataModel, ag agVar) {
        CJRTrainSmartIcons cJRTrainSmartIcons = (CJRTrainSmartIcons) iJRDataModel;
        switch (agVar) {
            case BOOK_TICKETS:
                a(cJRTrainSmartIcons);
                return;
            case PNR_STATUS:
                b(cJRTrainSmartIcons);
                return;
            case LIVE_TRAIN_STATUS:
                c(cJRTrainSmartIcons);
                return;
            case METRO_RAIL:
                d(cJRTrainSmartIcons);
                return;
            case TRAIN_CALENDAR:
                c();
                return;
            case HANDLE_WITH_DEEPLINK:
                e(cJRTrainSmartIcons);
                return;
            default:
                return;
        }
    }

    private void a(CJRTrainSmartIcons cJRTrainSmartIcons) {
        Intent intent = new Intent(getActivity(), AJRTrainHomeV2Activity.class);
        intent.putExtra("intent_home_v2_icon_selected", cJRTrainSmartIcons);
        intent.putExtra("train_booking_information", (Serializable) this.k.f27645g.getValue());
        intent.putExtra("extra_intent_holiday_list", (Serializable) this.k.f27646h.getValue());
        intent.putExtra("intent_extra_train_fav", (Serializable) this.k.f27647i.getValue());
        intent.putExtra("train_recent_bookings", (Serializable) this.k.j.getValue());
        intent.putExtra(UpiConstants.FROM, this.p);
        intent.putExtra("extra_home_data", this.m);
        intent.setFlags(603979776);
        startActivity(intent);
    }

    private void b(CJRTrainSmartIcons cJRTrainSmartIcons) {
        Intent intent = new Intent(getActivity(), AJRTrainHomeV2Activity.class);
        intent.putExtra("intent_home_v2_icon_selected", cJRTrainSmartIcons);
        intent.putExtra("train_recent_bookings", (Serializable) this.k.j.getValue());
        intent.setFlags(603979776);
        startActivity(intent);
    }

    private void c(CJRTrainSmartIcons cJRTrainSmartIcons) {
        Intent intent = new Intent(getActivity(), AJRTrainHomeV2Activity.class);
        intent.putExtra("intent_home_v2_icon_selected", cJRTrainSmartIcons);
        intent.putExtra("train_recent_bookings", (Serializable) this.k.j.getValue());
        intent.setFlags(603979776);
        startActivity(intent);
    }

    private void d(CJRTrainSmartIcons cJRTrainSmartIcons) {
        Intent intent = new Intent(getActivity(), AJRTrainHomeV2Activity.class);
        intent.putExtra("intent_home_v2_icon_selected", cJRTrainSmartIcons);
        intent.putExtra("metro_list_mode_details", (Serializable) this.k.k.getValue());
        if (this.o != null) {
            intent.putExtra(com.travel.train.j.g.A, this.o);
        }
        intent.setFlags(603979776);
        startActivity(intent);
    }

    private void c() {
        Intent intent = new Intent(getActivity(), AJRLSSearchTrains.class);
        intent.putExtra("intent_extra_from_train_home", true);
        startActivityForResult(intent, 191);
    }

    private void e(CJRTrainSmartIcons cJRTrainSmartIcons) {
        String url = cJRTrainSmartIcons.getUrl();
        if (!TextUtils.isEmpty(url)) {
            Bundle bundle = new Bundle();
            com.travel.train.b.a();
            com.travel.train.b.b().a((Context) getActivity(), url, bundle);
        }
    }

    private void d() {
        if (!this.r) {
            j childFragmentManager = getChildFragmentManager();
            childFragmentManager.b();
            this.f27167g = childFragmentManager.c(this.f27161a);
            Fragment fragment = this.f27167g;
            if (fragment == null || !fragment.isAdded()) {
                com.travel.train.b.a();
                this.f27167g = com.travel.train.b.b().a((WeakReference<View>) new WeakReference(this.f27168h));
                Bundle bundle = new Bundle();
                bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
                bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
                bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
                bundle.putString("origin", "train");
                bundle.putString("store_front_url_key", "trainV2HomeStoreFrontURL");
                bundle.putBoolean("trigger-impression-on-visibility", true);
                this.f27167g.setArguments(bundle);
                getChildFragmentManager().a().b(R.id.framelayout_storefront_train_home, this.f27167g, this.f27161a).c();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        NestedScrollView nestedScrollView = this.f27168h;
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getBottom() - (this.f27168h.getHeight() + this.f27168h.getScrollY()) == 0) {
            if (this.f27167g != null) {
                boolean z = false;
                if (System.currentTimeMillis() - this.f27169i > 1000) {
                    this.f27169i = System.currentTimeMillis();
                    z = true;
                }
                if (z) {
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(this.f27167g);
                }
            }
        } else if (this.f27167g != null) {
            com.travel.train.b.a();
            com.travel.train.b.b().b(this.f27167g);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.j != null && this.f27168h.getViewTreeObserver() != null && this.f27168h.getViewTreeObserver().isAlive()) {
            this.f27168h.getViewTreeObserver().removeOnScrollChangedListener(this.j);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRSearchByTrainNumberModel cJRSearchByTrainNumberModel) {
        this.u = new CJRTrainSearchInput();
        this.u.setmSourceCityCode(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getStationCode());
        this.u.setmSourceCityName(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getStationName());
        this.u.setSourceAirPortName(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getFromStation().getStationName());
        this.u.setmDestCityCode(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getStationCode());
        this.u.setmDestCityName(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getStationName());
        this.u.setDestAirportName(cJRSearchByTrainNumberModel.getBody().getTrainDetails().getToStation().getStationName());
        this.u.setmDate(i.a());
        Intent intent = new Intent(getActivity(), AJRSearchByTrainResultActivity.class);
        intent.putExtra("search_by_train_result", cJRSearchByTrainNumberModel);
        intent.putExtra("intent_extra_train_search_input", this.u);
        intent.putExtra("intent_extra_train_selected", this.s);
        intent.putExtra("intent_extra_schedule_selected", this.t);
        intent.putExtra("extra_intent_holiday_list", this.v);
        startActivityForResult(intent, 123);
    }
}
