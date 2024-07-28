package com.travel.train.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.travel.train.R;
import com.travel.train.b.s;
import com.travel.train.b.t;
import com.travel.train.helper.d;
import com.travel.train.helper.j;
import com.travel.train.hintsbuilder.c;
import com.travel.train.i.ak;
import com.travel.train.j.g;
import com.travel.train.j.i;
import com.travel.train.j.n;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainFilterModel;
import com.travel.train.model.trainticket.CJRTrainQuota;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAlternateStationData;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.widget.CJRWrapContentViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ap extends RecyclerView.a<a> implements t.a, d.a, j.a, c {

    /* renamed from: a  reason: collision with root package name */
    FragmentActivity f26256a;

    /* renamed from: b  reason: collision with root package name */
    public ak f26257b;

    /* renamed from: c  reason: collision with root package name */
    public List<CJRTrainSearchResultsTrain> f26258c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<CJRTrainQuota> f26259d;

    /* renamed from: e  reason: collision with root package name */
    public t f26260e;

    /* renamed from: f  reason: collision with root package name */
    CJRTrainSearchInput f26261f;

    /* renamed from: g  reason: collision with root package name */
    CJRTrainSearchResults f26262g;

    /* renamed from: h  reason: collision with root package name */
    CJRTrainSearchResultsTrain f26263h;

    /* renamed from: i  reason: collision with root package name */
    String f26264i;
    ArrayList<String> j;
    HashMap<String, Object> k;
    int l;
    String m;
    public a n;
    public boolean o = false;
    private androidx.fragment.app.j p;
    private CJRWrapContentViewPager q;
    private String r;
    private CJRTrainFilterModel s;
    private j t = null;
    private View u;
    private boolean v = false;
    private boolean w = false;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        return i2;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        a aVar = (a) vVar;
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f26258c.get(i2);
        if (i2 == 0) {
            this.u = aVar.q;
        }
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getTrainNumber())) {
            aVar.f26270b.setText(cJRTrainSearchResultsTrain.getTrainNumber());
        }
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getTrainName())) {
            aVar.f26271c.setText(n.a(cJRTrainSearchResultsTrain.getTrainName()));
        }
        if (cJRTrainSearchResultsTrain.getDelayInfo() == null) {
            aVar.D.setVisibility(8);
            aVar.C.setVisibility(8);
        } else if (!cJRTrainSearchResultsTrain.getDelayInfo().getEnabled().booleanValue() || TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDelayInfo().getDisplayText())) {
            aVar.D.setVisibility(8);
            aVar.C.setVisibility(8);
        } else {
            aVar.D.setVisibility(0);
            aVar.C.setVisibility(0);
            aVar.C.setText(cJRTrainSearchResultsTrain.getDelayInfo().getDisplayText());
            aVar.D.setColorFilter(Color.parseColor(cJRTrainSearchResultsTrain.getDelayInfo().getColour()));
        }
        if (cJRTrainSearchResultsTrain.getMAlternateConfirmAvailibility() != null) {
            aVar.u.setVisibility(0);
            aVar.v.setText(cJRTrainSearchResultsTrain.getMAlternateConfirmAvailibility());
            i3 = 15;
        } else {
            aVar.u.setVisibility(8);
            i3 = 3;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, b.a(i3, (Context) this.f26256a), 0, 0);
        aVar.u.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDeparture()) && !TextUtils.isEmpty(cJRTrainSearchResultsTrain.getArrival())) {
            StringBuilder sb = new StringBuilder();
            sb.append(i.f(cJRTrainSearchResultsTrain.getDeparture()));
            String e2 = i.e(cJRTrainSearchResultsTrain.getDeparture());
            aVar.l.setText(sb);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i.f(cJRTrainSearchResultsTrain.getArrival()));
            String e3 = i.e(cJRTrainSearchResultsTrain.getArrival());
            if (!e2.equalsIgnoreCase(e3)) {
                sb2.append(", ");
                sb2.append(e3);
            }
            aVar.m.setText(sb2);
            aVar.p.setText(i.c(cJRTrainSearchResultsTrain.getDeparture(), cJRTrainSearchResultsTrain.getArrival()));
        }
        if (!(cJRTrainSearchResultsTrain.getSourceName() == null || cJRTrainSearchResultsTrain.getDestinationName() == null)) {
            aVar.n.setText(cJRTrainSearchResultsTrain.getSourceName());
            aVar.o.setText(cJRTrainSearchResultsTrain.getDestinationName());
        }
        new d(this.f26256a, aVar, cJRTrainSearchResultsTrain, this.k, this, i2, this.s.getmSelectedFareCalssesList());
        this.t = new j(this.f26256a, aVar, this.f26259d, this);
        if (!cJRTrainSearchResultsTrain.isAlternateStationEnabled() || !cJRTrainSearchResultsTrain.getMIsCollapse()) {
            aVar.f26276h.setVisibility(8);
        } else {
            List<CJRTrainSearchResultsAlternateStationData> alternateStationsData = cJRTrainSearchResultsTrain.getAlternateStationsData();
            if (!cJRTrainSearchResultsTrain.getViewMoreClicked() && alternateStationsData != null && alternateStationsData.size() > 0) {
                aVar.f26276h.setVisibility(0);
                aVar.t.setVisibility(0);
                aVar.B.setVisibility(4);
                if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getAlternateStationsTitle())) {
                    aVar.A.setText(cJRTrainSearchResultsTrain.getAlternateStationsTitle());
                }
                aVar.t.setLayoutManager(new LinearLayoutManager(this.f26256a, 0, false));
                aVar.t.setAdapter(new s(this.f26256a, this.f26257b, cJRTrainSearchResultsTrain, this.k, s.a.SIMPLE_VIEW));
            }
        }
        CJRTrainSearchResults cJRTrainSearchResults = this.f26262g;
        if (cJRTrainSearchResults != null && cJRTrainSearchResults.getBody() != null && this.f26262g.getBody().getTrains() != null && this.f26262g.getBody().getTrains().size() > 0 && this.f26262g.getBody().getTrains().get(0).isSearchByTrainResult()) {
            aVar.itemView.findViewById(R.id.train_name_layout).setVisibility(8);
            aVar.itemView.findViewById(R.id.duration_info_lyt).setVisibility(8);
            aVar.w.setVisibility(8);
        }
    }

    public ap(FragmentActivity fragmentActivity, CJRTrainSearchResults cJRTrainSearchResults, List<CJRTrainSearchResultsTrain> list, ArrayList<CJRTrainQuota> arrayList, HashMap<String, Object> hashMap, String str, androidx.fragment.app.j jVar, CJRTrainSearchInput cJRTrainSearchInput, CJRTrainFilterModel cJRTrainFilterModel) {
        setHasStableIds(true);
        this.f26256a = fragmentActivity;
        this.f26262g = cJRTrainSearchResults;
        this.f26258c = list;
        this.f26259d = arrayList;
        this.k = hashMap;
        this.p = jVar;
        this.f26261f = cJRTrainSearchInput;
        this.r = str;
        this.s = cJRTrainFilterModel;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, int i2) {
        aVar.y.setVisibility(8);
        aVar.f26274f = false;
        CJRTrainSearchResults cJRTrainSearchResults = this.f26262g;
        if (!(cJRTrainSearchResults == null || cJRTrainSearchResults.getBody() == null || this.f26262g.getBody().getTrains() == null || this.f26262g.getBody().getTrains().size() <= 0 || this.f26262g.getBody().getTrains().get(0).isSearchByTrainResult())) {
            aVar.w.setVisibility(0);
        }
        if (this.f26258c.get(this.l).getMAlternateConfirmAvailibility() != null) {
            aVar.u.setVisibility(0);
        }
        aVar.f26277i.setVisibility(8);
        aVar.j.setVisibility(8);
        aVar.k.setVisibility(8);
        if (this.f26258c.get(i2).isAlternateStationEnabled() && this.f26258c.get(i2).getAlternateStationsData().size() > 0) {
            aVar.t.setVisibility(0);
            aVar.B.setVisibility(4);
        }
        if (this.w) {
            new d(this.f26256a, aVar, this.f26258c.get(this.l), this.k, this, this.l, this.s.getmSelectedFareCalssesList());
        }
        aVar.s.setVisibility(0);
        this.o = false;
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar, int i2) {
        if (this.f26258c.get(i2).isAlternateStationEnabled() && this.f26258c.get(i2).getAlternateStationsData().size() > 0) {
            this.f26258c.get(i2).setViewMoreClicked(false);
            aVar.t.setVisibility(0);
            aVar.B.setVisibility(4);
            this.o = false;
        }
    }

    private void a(a aVar) {
        this.f26260e = new t(this.f26256a, this.p, this.j, this.f26264i, this.f26263h, this.f26261f, this.k, this.f26259d, this.q, this.l, aVar, this);
        aVar.j.setAdapter(this.f26260e);
        aVar.k.setSelectedTabIndicatorColor(androidx.core.content.b.c(this.f26256a, R.color.color_00b9f5));
        aVar.k.setSelectedTabIndicatorHeight(0);
        aVar.k.setTabIndicatorFullWidth(false);
        aVar.k.setTabMode(0);
        aVar.k.setupWithViewPager(aVar.j);
        aVar.k.setTabRippleColor((ColorStateList) null);
        if (aVar != null && aVar.k != null && this.j != null) {
            for (int i2 = 0; i2 < aVar.k.getTabCount(); i2++) {
                TabLayout.f a2 = aVar.k.a(i2);
                if (i2 < this.j.size()) {
                    a2.a(this.f26260e.a(this.j.get(i2), this.f26259d.get(this.t.f27320a), a2.e()));
                }
            }
            ArrayList<CJRTrainQuota> arrayList = this.f26259d;
            int size = arrayList != null ? arrayList.size() : 0;
            for (int i3 = 0; i3 < size; i3++) {
                this.t.a(aVar, i3, this.f26259d.get(i3).isIsSelected());
            }
            if (aVar != null && aVar.k != null && aVar.k.getTabCount() > 0) {
                TabLayout.f a3 = aVar.k.a(aVar.j.getCurrentItem());
                if (a3.e()) {
                    this.f26260e.a(a3, false, (CJRTrainDetailsBody) null);
                }
            }
        }
    }

    public final int getItemCount() {
        List<CJRTrainSearchResultsTrain> list = this.f26258c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void a() {
        List<CJRTrainSearchResultsTrain> list = this.f26258c;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.f26258c.size(); i2++) {
                this.f26258c.get(i2).setMIsCollapse(true);
                this.f26258c.get(i2).setViewMoreClicked(false);
            }
            a aVar = this.n;
            if (aVar != null) {
                int intValue = ((Integer) aVar.f26269a.getTag()).intValue();
                int unused = this.n.x = 0;
                a(this.n, intValue);
                b(this.n, intValue);
                ak akVar = this.f26257b;
                if (akVar != null && intValue == 0) {
                    akVar.a(intValue);
                }
            }
        }
    }

    public final void a(RecyclerView.v vVar, String str, int i2, String str2) {
        List<CJRTrainSearchResultsTrain> list;
        int i3;
        if (this.f26257b != null && (list = this.f26258c) != null && i2 < list.size()) {
            a aVar = (a) vVar;
            this.l = i2;
            this.m = str;
            this.j = n.a(this.f26258c, this.k, this.l);
            if (this.m != null) {
                i3 = 0;
                for (int i4 = 0; i4 < this.j.size(); i4++) {
                    String str3 = this.m;
                    if (str3 != null && str3.equalsIgnoreCase(this.j.get(i4))) {
                        i3 = i4;
                    }
                }
            } else {
                i3 = 0;
            }
            int unused = aVar.x = i3;
            int i5 = 0;
            for (int i6 = 0; i6 < this.f26259d.size(); i6++) {
                if (this.f26259d.get(i6).getQuotaCode().equalsIgnoreCase(str2)) {
                    i5 = i6;
                }
            }
            a(i5, aVar, str, true);
        }
    }

    public final void a(CJRTrainDetailsBody cJRTrainDetailsBody, a aVar, int i2) {
        if (aVar != null && aVar.k != null && aVar.k.getTabCount() > 0) {
            this.f26260e.a(aVar.k.a(aVar.j.getCurrentItem()), true, cJRTrainDetailsBody);
            int i3 = 0;
            while (i3 < this.f26258c.get(this.l).getMAvailability().size()) {
                if (i3 != i2 || !TextUtils.isEmpty(this.f26258c.get(this.l).getMAvailability().get(i3).getFare())) {
                    i3++;
                } else {
                    this.f26258c.get(this.l).getMAvailability().get(i3).setFare(cJRTrainDetailsBody.getTrainFare().getTotalCollectable());
                    this.f26258c.get(this.l).getMAvailability().get(i3).setStatus(cJRTrainDetailsBody.getmTrainAvailability().get(0).getmSttaus());
                    this.f26258c.get(this.l).getMAvailability().get(i3).setColour(n.a(cJRTrainDetailsBody.getmTrainAvailability().get(0).getTypeMap().values()));
                    this.w = true;
                    return;
                }
            }
        }
    }

    public final void c(a aVar, int i2) {
        a(i2, aVar, this.f26259d.get(i2).getQuotaName(), false);
        a(aVar);
    }

    private void a(int i2, a aVar, String str, boolean z) {
        if (this.t != null && aVar.f26272d.getChildCount() != 0) {
            this.f26258c.get(this.l).setMIsCollapse(true);
            ArrayList<CJRTrainQuota> arrayList = this.f26259d;
            int size = arrayList != null ? arrayList.size() : 0;
            int i3 = 0;
            while (i3 < size) {
                this.t.a(aVar, i3, i3 == i2);
                i3++;
            }
            if (this.f26259d != null && i2 < size) {
                this.j = n.a(this.f26258c, this.k, this.l);
                if (z) {
                    aVar.a(this.m, true);
                } else {
                    int unused = aVar.x = aVar.j.getCurrentItem();
                    this.m = str;
                    aVar.a((String) null, true);
                }
            }
            ArrayList<String> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i4 = 0; i4 < this.j.size(); i4++) {
                    if (i4 == aVar.x) {
                        this.m = this.j.get(i4);
                    }
                }
            }
        }
    }

    public final void a(View view, boolean z) {
        ak akVar;
        if (z && view == this.u && (akVar = this.f26257b) != null) {
            akVar.a(this.v);
        }
    }

    public final void a(boolean z) {
        this.v = z;
        if (this.u != null) {
            new com.travel.train.hintsbuilder.b(this.f26256a).a(this.u).a(!this.v ? "1/2" : "2/3").b(this.f26256a.getResources().getString(R.string.train_show_tip_view_desc2)).b().c().a(true).c(this.f26256a.getResources().getString(R.string.train_show_tip_view_positive_button1)).d(this.f26256a.getResources().getString(R.string.train_show_tip_view_negative_button1)).a((c) this).a(R.layout.pre_t_train_intro_srp_show_tip_layout).f27479a.a((Activity) this.f26256a);
            return;
        }
        ak akVar = this.f26257b;
        if (akVar != null) {
            akVar.a(this.v);
        }
    }

    public class a extends RecyclerView.v implements View.OnClickListener {
        /* access modifiers changed from: private */
        public TextView A;
        /* access modifiers changed from: private */
        public TextView B;
        /* access modifiers changed from: private */
        public TextView C;
        /* access modifiers changed from: private */
        public ImageView D;

        /* renamed from: a  reason: collision with root package name */
        protected LinearLayout f26269a;

        /* renamed from: b  reason: collision with root package name */
        protected RoboTextView f26270b;

        /* renamed from: c  reason: collision with root package name */
        protected RoboTextView f26271c;

        /* renamed from: d  reason: collision with root package name */
        public LinearLayout f26272d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f26273e = ((LinearLayout) this.s.findViewById(R.id.inner_layout));

        /* renamed from: f  reason: collision with root package name */
        public boolean f26274f;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public ConstraintLayout f26276h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f26277i;
        /* access modifiers changed from: private */
        public CJRWrapContentViewPager j;
        /* access modifiers changed from: private */
        public TabLayout k;
        /* access modifiers changed from: private */
        public TextView l;
        /* access modifiers changed from: private */
        public TextView m;
        /* access modifiers changed from: private */
        public TextView n;
        /* access modifiers changed from: private */
        public TextView o;
        /* access modifiers changed from: private */
        public TextView p;
        /* access modifiers changed from: private */
        public ImageView q;
        private HorizontalScrollView r;
        /* access modifiers changed from: private */
        public HorizontalScrollView s;
        /* access modifiers changed from: private */
        public RecyclerView t;
        /* access modifiers changed from: private */
        public RelativeLayout u;
        /* access modifiers changed from: private */
        public RoboTextView v;
        /* access modifiers changed from: private */
        public RoboTextView w;
        /* access modifiers changed from: private */
        public int x;
        /* access modifiers changed from: private */
        public LinearLayout y;
        /* access modifiers changed from: private */
        public TextView z;

        public a(View view) {
            super(view);
            this.f26269a = (LinearLayout) view.findViewById(R.id.search_list_container);
            this.f26277i = (RelativeLayout) view.findViewById(R.id.quota_select_lyt);
            this.y = (LinearLayout) view.findViewById(R.id.opted_filter_lyt);
            this.z = (RoboTextView) view.findViewById(R.id.opted_filter_txt);
            this.f26269a.setOnClickListener(this);
            this.f26269a.setClickable(true);
            this.l = (TextView) view.findViewById(R.id.departure_time);
            this.m = (TextView) view.findViewById(R.id.arriaval_time);
            this.n = (TextView) view.findViewById(R.id.source_name);
            this.o = (TextView) view.findViewById(R.id.destination_name);
            this.p = (TextView) view.findViewById(R.id.total_hours);
            this.f26270b = (RoboTextView) view.findViewById(R.id.txt_search_train_number);
            this.f26271c = (RoboTextView) view.findViewById(R.id.txt_search_train_name);
            this.q = (ImageView) view.findViewById(R.id.route_icon);
            this.C = (TextView) view.findViewById(R.id.delay_score);
            this.D = (ImageView) view.findViewById(R.id.delay_clock_icon);
            this.q.setOnClickListener(this);
            this.f26271c.setOnClickListener(this);
            this.f26270b.setOnClickListener(this);
            this.j = (CJRWrapContentViewPager) view.findViewById(R.id.train_detail_pager);
            this.j.addOnPageChangeListener(new ViewPager.e(ap.this) {
                public final void onPageScrollStateChanged(int i2) {
                }

                public final void onPageScrolled(int i2, float f2, int i3) {
                }

                public final void onPageSelected(int i2) {
                    int unused = a.this.x = i2;
                    if (ap.this.j != null && ap.this.j.size() > 0 && ap.this.f26263h != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(net.one97.paytm.common.utility.d.k, (Object) null);
                        hashMap.put("train_name", ap.this.f26263h.getTrainName() + " " + ap.this.f26263h.getTrainNumber());
                        String valueOf = (ap.this.f26263h.getMAvailability().size() <= i2 || ap.this.f26263h.getMAvailability().get(i2).getMSearchPNRPrediction() == null) ? null : String.valueOf(ap.this.f26263h.getMAvailability().get(i2).getMSearchPNRPrediction().getValue());
                        String valueOf2 = String.valueOf(ap.this.f26263h.getDelayScore());
                        if (ap.this.f26263h.isSearchByTrainResult()) {
                            o.a("train_search_results", "Train number", "train_class_selected", "/trains", ap.this.f26256a);
                        } else {
                            o.a("train_search_results", valueOf, valueOf2, (String) null, ap.this.f26263h.getSourceName(), ap.this.f26263h.getDestinationName(), ap.this.f26263h.getDeparture(), "class_selected", ap.this.j.get(i2), ap.this.f26256a, hashMap);
                        }
                    }
                }
            });
            this.k = (TabLayout) view.findViewById(R.id.detai_tab);
            this.s = (HorizontalScrollView) view.findViewById(R.id.class_type_layout);
            this.r = (HorizontalScrollView) view.findViewById(R.id.quota_layout);
            this.f26272d = (LinearLayout) this.r.findViewById(R.id.inner_layout);
            this.A = (TextView) view.findViewById(R.id.alternate_heading);
            this.f26276h = (ConstraintLayout) view.findViewById(R.id.alternate_ticket_container);
            this.t = (RecyclerView) view.findViewById(R.id.class_list_recycler);
            this.B = (TextView) view.findViewById(R.id.show_alternate_option_txt);
            this.u = (RelativeLayout) view.findViewById(R.id.bulb_lyt);
            this.v = (RoboTextView) view.findViewById(R.id.bulb_text);
            this.w = (RoboTextView) view.findViewById(R.id.check_future_availibity);
            if (g.f27551a == null || TextUtils.isEmpty(g.f27551a.getFutureAvailability())) {
                this.w.setText(ap.this.f26256a.getString(R.string.check_future_availability));
            } else {
                this.w.setText(g.f27551a.getFutureAvailability());
            }
        }

        public final void onClick(View view) {
            if (view == this.f26269a) {
                if (ap.this.f26257b != null && ap.this.f26258c != null && getAdapterPosition() < ap.this.f26258c.size()) {
                    ap.this.l = getAdapterPosition();
                    ap apVar = ap.this;
                    apVar.j = n.a(apVar.f26258c, ap.this.k, ap.this.l);
                    if (ap.this.j != null && ap.this.j.size() > 0) {
                        ap apVar2 = ap.this;
                        apVar2.m = apVar2.j.get(0);
                    }
                    this.x = 0;
                    a((String) null, false);
                }
            } else if ((view == this.q || view == this.f26270b || view == this.f26271c) && getAdapterPosition() < ap.this.f26258c.size()) {
                ap.this.f26257b.a(ap.this.f26258c.get(getAdapterPosition()));
            }
        }

        public final void a(final String str, final boolean z2) {
            if (!z2) {
                if (ap.this.n != null) {
                    int intValue = ((Integer) ap.this.n.f26269a.getTag()).intValue();
                    ap apVar = ap.this;
                    apVar.a(apVar.n, intValue);
                    ap apVar2 = ap.this;
                    apVar2.b(apVar2.n, intValue);
                    for (int i2 = 0; i2 < ap.this.f26259d.size(); i2++) {
                        if (i2 == 0) {
                            ap.this.f26259d.get(i2).setIsSelected(true);
                        } else {
                            ap.this.f26259d.get(i2).setIsSelected(false);
                        }
                    }
                }
            } else if (!(ap.this.n == null || ap.this.n == this)) {
                int intValue2 = ((Integer) ap.this.n.f26269a.getTag()).intValue();
                ap apVar3 = ap.this;
                apVar3.a(apVar3.n, intValue2);
                ap apVar4 = ap.this;
                apVar4.b(apVar4.n, intValue2);
            }
            ap apVar5 = ap.this;
            ap.a(apVar5, apVar5.l);
            CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = ap.this.f26258c.get(ap.this.l);
            if (!cJRTrainSearchResultsTrain.getMIsCollapse()) {
                if (ap.this.f26258c.get(ap.this.l).getMAlternateConfirmAvailibility() != null) {
                    this.u.setVisibility(0);
                }
                ap.this.f26258c.get(ap.this.l).setMIsCollapse(true);
                ap.this.a(this, getAdapterPosition());
                ap.this.b(this, getAdapterPosition());
            } else if (cJRTrainSearchResultsTrain.isMessageEnable() && !this.f26274f) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ap.this.f26256a);
                builder.setTitle(ap.this.f26256a.getString(R.string.alert_text));
                builder.setMessage(cJRTrainSearchResultsTrain.getMessage());
                builder.setPositiveButton(ap.this.f26256a.getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        a.this.b(str, z2);
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            } else if (g.f27551a == null || !g.f27551a.getShowDifferentStationAlert() || !a(cJRTrainSearchResultsTrain) || this.f26274f) {
                b(str, z2);
            } else {
                a(cJRTrainSearchResultsTrain, str, z2);
            }
        }

        private boolean a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
            if (ap.this.f26261f == null) {
                return false;
            }
            if (ap.this.f26261f.getmSourceCityName().contains(ap.this.f26256a.getString(R.string.trains_all_station_string)) || ap.this.f26261f.getmDestCityName().contains(ap.this.f26256a.getString(R.string.trains_all_station_string))) {
                if (ap.this.f26261f.getmSourceCityName().contains(ap.this.f26256a.getString(R.string.trains_all_station_string)) && ap.this.f26261f.getmDestCityName().contains(ap.this.f26256a.getString(R.string.trains_all_station_string))) {
                    return false;
                }
                if (ap.this.f26261f.getmSourceCityName().contains(ap.this.f26256a.getString(R.string.trains_all_station_string)) && !cJRTrainSearchResultsTrain.getDestination().equalsIgnoreCase(ap.this.f26261f.getmDestCityCode())) {
                    return true;
                }
                if (!ap.this.f26261f.getmDestCityName().contains(ap.this.f26256a.getString(R.string.trains_all_station_string)) || cJRTrainSearchResultsTrain.getSource().equalsIgnoreCase(ap.this.f26261f.getmSourceCityCode())) {
                    return false;
                }
                return true;
            } else if (!cJRTrainSearchResultsTrain.getSource().equalsIgnoreCase(ap.this.f26261f.getmSourceCityCode()) || !cJRTrainSearchResultsTrain.getDestination().equalsIgnoreCase(ap.this.f26261f.getmDestCityCode())) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01a8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(java.lang.String r28, boolean r29) {
            /*
                r27 = this;
                r0 = r27
                r12 = r28
                android.widget.RelativeLayout r1 = r0.f26277i
                r13 = 0
                r1.setVisibility(r13)
                android.widget.LinearLayout r1 = r0.f26272d
                r1.requestLayout()
                android.widget.RelativeLayout r1 = r0.u
                r2 = 8
                r1.setVisibility(r2)
                com.paytm.utility.RoboTextView r1 = r0.w
                r1.setVisibility(r2)
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                r14 = 1
                r1.o = r14
                r1.n = r0
                com.travel.train.b.ap$a r1 = r1.n
                android.widget.LinearLayout r1 = r1.f26269a
                int r2 = r27.getAdapterPosition()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r1.setTag(r2)
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                java.util.List<com.travel.train.model.trainticket.CJRTrainSearchResultsTrain> r1 = r1.f26258c
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                int r2 = r2.l
                java.lang.Object r1 = r1.get(r2)
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = (com.travel.train.model.trainticket.CJRTrainSearchResultsTrain) r1
                r1.setMIsCollapse(r13)
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResults r1 = r1.f26262g
                if (r1 == 0) goto L_0x008a
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResults r1 = r1.f26262g
                com.travel.train.model.trainticket.CJRTrainSearchResultsBody r1 = r1.getBody()
                if (r1 == 0) goto L_0x008a
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResults r1 = r1.f26262g
                com.travel.train.model.trainticket.CJRTrainSearchResultsBody r1 = r1.getBody()
                java.util.List r1 = r1.getTrains()
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L_0x008a
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResults r2 = r1.f26262g
                com.travel.train.model.trainticket.CJRTrainSearchResultsBody r2 = r2.getBody()
                java.util.List r2 = r2.getTrains()
                com.travel.train.b.ap r3 = com.travel.train.b.ap.this
                int r3 = r3.l
                java.lang.Object r2 = r2.get(r3)
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = (com.travel.train.model.trainticket.CJRTrainSearchResultsTrain) r2
                r1.f26263h = r2
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResults r2 = r1.f26262g
                com.travel.train.model.trainticket.CJRTrainSearchResultsMeta r2 = r2.getMeta()
                java.lang.String r2 = r2.getRequestid()
                r1.f26264i = r2
            L_0x008a:
                java.lang.String r15 = " "
                java.lang.String r11 = "train_name"
                if (r12 == 0) goto L_0x01a2
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                java.util.ArrayList<java.lang.String> r1 = r1.j
                if (r1 == 0) goto L_0x01a2
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                if (r1 == 0) goto L_0x01a2
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                if (r1 == 0) goto L_0x01a2
                java.util.HashMap r10 = new java.util.HashMap
                r10.<init>()
                java.lang.Object r1 = net.one97.paytm.common.utility.d.k
                r2 = 0
                r10.put(r1, r2)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                java.lang.String r2 = r2.getTrainName()
                r1.append(r2)
                r1.append(r15)
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                java.lang.String r2 = r2.getTrainNumber()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r10.put(r11, r1)
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                int r1 = r1.getDelayScore()
                java.lang.String r3 = java.lang.String.valueOf(r1)
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                boolean r1 = r1.isSearchByTrainResult()
                if (r1 == 0) goto L_0x00fc
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                androidx.fragment.app.FragmentActivity r1 = r1.f26256a
                java.lang.String r2 = "train_search_results"
                java.lang.String r3 = "Train number"
                java.lang.String r4 = "train_class_selected"
                java.lang.String r5 = "/trains"
                com.travel.train.j.o.a(r2, r3, r4, r5, r1)
                goto L_0x01a2
            L_0x00fc:
                r1 = 0
            L_0x00fd:
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                java.util.ArrayList r2 = r2.getMAvailability()
                int r2 = r2.size()
                if (r1 >= r2) goto L_0x016d
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                java.util.ArrayList r2 = r2.getMAvailability()
                java.lang.Object r2 = r2.get(r1)
                com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject r2 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject) r2
                java.lang.String r2 = r2.getClassName()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x016a
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                java.util.ArrayList r2 = r2.getMAvailability()
                java.lang.Object r2 = r2.get(r1)
                com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject r2 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject) r2
                java.lang.String r2 = r2.getClassName()
                boolean r2 = r2.equalsIgnoreCase(r12)
                if (r2 == 0) goto L_0x016a
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                java.util.ArrayList r2 = r2.getMAvailability()
                java.lang.Object r2 = r2.get(r1)
                com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject r2 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject) r2
                com.travel.train.model.trainticket.CJRTrainSearchResultsPNRPrediction r2 = r2.getMSearchPNRPrediction()
                if (r2 == 0) goto L_0x016a
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                java.util.ArrayList r2 = r2.getMAvailability()
                java.lang.Object r1 = r2.get(r1)
                com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject r1 = (com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject) r1
                com.travel.train.model.trainticket.CJRTrainSearchResultsPNRPrediction r1 = r1.getMSearchPNRPrediction()
                int r1 = r1.getValue()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                goto L_0x016f
            L_0x016a:
                int r1 = r1 + 1
                goto L_0x00fd
            L_0x016d:
                java.lang.String r1 = ""
            L_0x016f:
                r2 = r1
                r4 = 0
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                java.lang.String r5 = r1.getSourceName()
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                java.lang.String r6 = r1.getDestinationName()
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                java.lang.String r7 = r1.getDeparture()
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                androidx.fragment.app.FragmentActivity r9 = r1.f26256a
                java.lang.String r1 = "train_search_results"
                java.lang.String r8 = "class_selected"
                r16 = r9
                r9 = r28
                r17 = r10
                r10 = r16
                r18 = r11
                r11 = r17
                com.travel.train.j.o.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                goto L_0x01a4
            L_0x01a2:
                r18 = r11
            L_0x01a4:
                r0.f26274f = r14
                if (r29 == 0) goto L_0x02a9
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainQuota> r1 = r1.f26259d
                java.lang.String r1 = com.travel.train.j.n.a((java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainQuota>) r1, (boolean) r13)
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r3 = r2.f26263h
                androidx.fragment.app.FragmentActivity r4 = r2.f26256a
                java.lang.String r4 = com.paytm.utility.b.n((android.content.Context) r4)
                java.util.HashMap r5 = new java.util.HashMap
                r5.<init>()
                if (r1 == 0) goto L_0x01c6
                java.lang.Object r6 = net.one97.paytm.common.utility.d.k
                r5.put(r6, r1)
            L_0x01c6:
                if (r3 == 0) goto L_0x01e8
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = r3.getTrainName()
                r6.append(r7)
                r6.append(r15)
                java.lang.String r7 = r3.getTrainNumber()
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                r7 = r18
                r5.put(r7, r6)
                goto L_0x01ea
            L_0x01e8:
                r7 = r18
            L_0x01ea:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r8 = r3.getTrainNumber()
                r6.append(r8)
                r6.append(r15)
                java.lang.String r3 = r3.getTrainName()
                r6.append(r3)
                java.lang.String r3 = r6.toString()
                r5.put(r7, r3)
                if (r4 == 0) goto L_0x0214
                boolean r3 = android.text.TextUtils.isEmpty(r4)
                if (r3 != 0) goto L_0x0214
                java.lang.Object r3 = net.one97.paytm.common.utility.d.f49600g
                r5.put(r3, r4)
            L_0x0214:
                com.travel.train.model.CJRTrainSearchInput r3 = r2.f26261f
                if (r3 == 0) goto L_0x022e
                java.lang.Object r3 = net.one97.paytm.common.utility.d.f49601h
                com.travel.train.model.CJRTrainSearchInput r4 = r2.f26261f
                java.lang.String r4 = r4.getmSourceCityName()
                r5.put(r3, r4)
                java.lang.Object r3 = net.one97.paytm.common.utility.d.f49602i
                com.travel.train.model.CJRTrainSearchInput r4 = r2.f26261f
                java.lang.String r4 = r4.getmDestCityName()
                r5.put(r3, r4)
            L_0x022e:
                java.lang.String r3 = "screenName"
                java.lang.String r4 = "/trains/search-results"
                r5.put(r3, r4)
                com.travel.train.b.a()
                com.travel.common.a r3 = com.travel.train.b.b()
                androidx.fragment.app.FragmentActivity r2 = r2.f26256a
                java.lang.String r4 = "train_search_results_quota_selected"
                r3.a((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r5, (android.content.Context) r2)
                com.travel.train.b.ap r2 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r2 = r2.f26263h
                if (r2 == 0) goto L_0x02a9
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                java.lang.Object r3 = net.one97.paytm.common.utility.d.k
                r2.put(r3, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                com.travel.train.b.ap r3 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r3 = r3.f26263h
                java.lang.String r3 = r3.getTrainName()
                r1.append(r3)
                r1.append(r15)
                com.travel.train.b.ap r3 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r3 = r3.f26263h
                java.lang.String r3 = r3.getTrainNumber()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r2.put(r7, r1)
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                java.lang.String r17 = r1.getSourceName()
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                java.lang.String r18 = r1.getDestinationName()
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r1 = r1.f26263h
                java.lang.String r19 = r1.getDeparture()
                r20 = 0
                r21 = 0
                r22 = 0
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                androidx.fragment.app.FragmentActivity r1 = r1.f26256a
                java.lang.String r16 = "train_search_results"
                java.lang.String r23 = "quota_selected"
                java.lang.String r24 = "/trains/search-results"
                r25 = r1
                r26 = r2
                com.travel.train.j.o.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            L_0x02a9:
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                int r2 = r27.getAdapterPosition()
                com.travel.train.b.ap.a((com.travel.train.b.ap) r1, (com.travel.train.b.ap.a) r0, (int) r2)
                com.travel.train.b.ap r1 = com.travel.train.b.ap.this
                java.util.HashMap<java.lang.String, java.lang.Object> r2 = r1.k
                java.lang.String r2 = com.travel.train.j.n.b((java.lang.String) r12, (java.util.HashMap<java.lang.String, java.lang.Object>) r2)
                com.travel.train.b.ap.a((com.travel.train.b.ap) r1, (com.travel.train.b.ap.a) r0, (java.lang.String) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.b.ap.a.b(java.lang.String, boolean):void");
        }

        private void a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, String str, boolean z2) {
            final Dialog dialog = new Dialog(ap.this.f26256a);
            dialog.requestWindowFeature(1);
            View inflate = ap.this.f26256a.getLayoutInflater().inflate(R.layout.from_to_station_alert_dialog, (ViewGroup) null);
            dialog.setContentView(inflate);
            dialog.show();
            Window window = dialog.getWindow();
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setBackgroundDrawable((Drawable) null);
            int width = window.getWindowManager().getDefaultDisplay().getWidth();
            TextView textView = (TextView) inflate.findViewById(R.id.from_searched_station);
            TextView textView2 = (TextView) inflate.findViewById(R.id.to_searched_station);
            TextView textView3 = (TextView) inflate.findViewById(R.id.to_searched_station_large);
            TextView textView4 = (TextView) inflate.findViewById(R.id.from_selected_station);
            TextView textView5 = (TextView) inflate.findViewById(R.id.to_selected_station);
            TextView textView6 = (TextView) inflate.findViewById(R.id.to_selected_station_large);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.cancel_alert);
            imageView.setBackgroundDrawable((Drawable) null);
            textView.setText(ap.this.f26261f.getmSourceCityName() + " (" + ap.this.f26261f.getmSourceCityCode() + ")");
            textView2.setText(ap.this.f26261f.getmDestCityName() + " (" + ap.this.f26261f.getmDestCityCode() + ")");
            textView3.setText(ap.this.f26261f.getmDestCityName() + " (" + ap.this.f26261f.getmDestCityCode() + ")");
            a(textView, textView2, textView3, width);
            textView4.setText(cJRTrainSearchResultsTrain.getSourceName() + " (" + cJRTrainSearchResultsTrain.getSource() + ")");
            textView5.setText(cJRTrainSearchResultsTrain.getDestinationName() + " (" + cJRTrainSearchResultsTrain.getDestination() + ")");
            textView6.setText(cJRTrainSearchResultsTrain.getDestinationName() + " (" + cJRTrainSearchResultsTrain.getDestination() + ")");
            a(textView4, textView5, textView6, width);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            final String str2 = str;
            final boolean z3 = z2;
            ((TextView) inflate.findViewById(R.id.proceed_alert)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.b(str2, z3);
                    dialog.dismiss();
                }
            });
        }

        private static void a(TextView textView, TextView textView2, TextView textView3, int i2) {
            textView.measure(0, 0);
            textView2.measure(0, 0);
            if (a(textView.getMeasuredWidth() + textView2.getMeasuredWidth(), i2)) {
                textView2.setVisibility(8);
                textView3.setVisibility(0);
            }
        }

        private static boolean a(int i2, int i3) {
            return i2 > ((i3 * 5) / 6) + -68;
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_t_lyt_train_search_result_item, viewGroup, false));
    }

    static /* synthetic */ void a(ap apVar, a aVar, String str) {
        if (aVar != null && str != null && !TextUtils.isEmpty(apVar.r)) {
            if ("NonAcType".equalsIgnoreCase(apVar.r)) {
                if (g.f27551a == null || TextUtils.isEmpty(g.f27551a.getViewingNonAc())) {
                    aVar.z.setText(apVar.f26256a.getString(R.string.opted_for_non_ac));
                } else {
                    aVar.z.setText(g.f27551a.getViewingNonAc());
                }
                if (g.af.equals(str) || g.ag.equals(str) || g.ah.equals(str) || g.ai.equals(str) || g.aj.equals(str) || g.ak.equals(str)) {
                    aVar.y.setVisibility(0);
                } else {
                    aVar.y.setVisibility(8);
                }
            } else {
                if (g.f27551a == null || TextUtils.isEmpty(g.f27551a.getViewingAc())) {
                    aVar.z.setText(apVar.f26256a.getString(R.string.opted_for_ac));
                } else {
                    aVar.z.setText(g.f27551a.getViewingAc());
                }
                if (g.al.equals(str) || g.am.equals(str) || g.an.equals(str)) {
                    aVar.y.setVisibility(0);
                } else {
                    aVar.y.setVisibility(8);
                }
            }
        }
    }

    static /* synthetic */ void a(ap apVar, int i2) {
        List<CJRTrainSearchResultsTrain> list = apVar.f26258c;
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < apVar.f26258c.size(); i3++) {
                if (i3 != i2) {
                    apVar.f26258c.get(i3).setMIsCollapse(true);
                }
            }
        }
    }

    static /* synthetic */ void a(ap apVar, final a aVar, int i2) {
        apVar.f26257b.a(apVar.l);
        apVar.f26257b.e();
        apVar.q = aVar.j;
        aVar.j.setVisibility(0);
        aVar.k.setVisibility(0);
        if (apVar.f26258c.get(i2).isAlternateStationEnabled() && apVar.f26258c.get(i2).getAlternateStationsData().size() > 0) {
            apVar.f26258c.get(i2).setViewMoreClicked(false);
            aVar.t.setVisibility(8);
            aVar.B.setVisibility(0);
        }
        if (apVar.j == null) {
            apVar.j = n.a(apVar.f26258c, apVar.k, apVar.l);
        }
        apVar.a(aVar);
        aVar.k.a((TabLayout.b) new TabLayout.c() {
            public final void onTabSelected(TabLayout.f fVar) {
                if (fVar != null && fVar.f36766f != null) {
                    ap.this.f26260e.a(fVar, false, (CJRTrainDetailsBody) null);
                    ap.a(ap.this, aVar, n.b(ap.this.j.get(fVar.f36765e), ap.this.k));
                }
            }

            public final void onTabUnselected(TabLayout.f fVar) {
                if (fVar != null && fVar.f36766f != null) {
                    ap.this.f26260e.a(fVar, false, (CJRTrainDetailsBody) null);
                }
            }

            public final void onTabReselected(TabLayout.f fVar) {
                if (fVar != null && fVar.f36766f != null) {
                    ap.this.f26258c.get(ap.this.l).setMIsCollapse(true);
                    ap apVar = ap.this;
                    a aVar = aVar;
                    apVar.a(aVar, aVar.getAdapterPosition());
                    ap apVar2 = ap.this;
                    a aVar2 = aVar;
                    apVar2.b(aVar2, aVar2.getAdapterPosition());
                }
            }
        });
        aVar.j.postDelayed(new Runnable() {
            public final void run() {
                aVar.j.setCurrentItem(aVar.x, true);
            }
        }, 50);
        aVar.s.setVisibility(8);
    }
}
