package com.travel.bus.busticket.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.ac;
import com.travel.bus.busticket.a.q;
import com.travel.bus.busticket.c.d;
import com.travel.bus.busticket.d.e;
import com.travel.bus.busticket.f.f;
import com.travel.bus.busticket.f.g;
import com.travel.bus.d.a;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class i extends h implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, d.a, f {
    private CheckBox A;
    private q B;
    private g C;
    private com.travel.bus.busticket.g.i D;
    private LinearLayout E;
    private TextView F;
    private TextView G;
    private View H;
    private boolean I;
    private ImageView J;
    private ImageView K;
    private e L;
    private a M;

    /* renamed from: a  reason: collision with root package name */
    public TripBusDetail f22274a;

    /* renamed from: b  reason: collision with root package name */
    public int f22275b;

    /* renamed from: c  reason: collision with root package name */
    public ac f22276c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22277d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22278e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f22279f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<TripBusDetailsItem> f22280g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<TripBusDetailsItem> f22281h;

    /* renamed from: i  reason: collision with root package name */
    public int f22282i;
    public int j;
    public boolean k = false;
    public String l = "";
    public ArrayList<TripBusDetailsItem> m = new ArrayList<>();
    private CJRBusSearchItem n;
    private String o;
    private TextView p;
    private RelativeLayout q;
    private RelativeLayout r;
    private RelativeLayout s;
    private boolean t = false;
    private RecyclerView u;
    private RelativeLayout v;
    private ArrayList<TripBusDetailsItem> w;
    private boolean x = false;
    private LinearLayout y;
    private LinearLayout z;

    public final void a(CJRBusSearchItem cJRBusSearchItem) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b(context);
        if (context instanceof g) {
            this.C = (g) context;
        }
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.M = (a) am.a((Fragment) this).a(a.class);
        this.M.f22537a.observe(this, new z() {
            public final void onChanged(Object obj) {
                i.this.a((List) obj);
            }
        });
        this.D = new com.travel.bus.busticket.g.i(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.H = layoutInflater.inflate(R.layout.pre_b_bus_select_seat_fragment, viewGroup, false);
        View view = this.H;
        this.K = (ImageView) view.findViewById(R.id.seat_loader_view);
        this.J = (ImageView) view.findViewById(R.id.error_image_view);
        this.q = (RelativeLayout) view.findViewById(R.id.lyt_progress_bar);
        this.E = (LinearLayout) view.findViewById(R.id.bus_error_container);
        this.F = (TextView) view.findViewById(R.id.bus_seat_error_title);
        this.G = (TextView) view.findViewById(R.id.bus_seat_error_message);
        this.p = (TextView) view.findViewById(R.id.txt_bottom_bus_error);
        this.f22279f = (ViewPager) view.findViewById(R.id.view_pager_select_seats);
        this.u = (RecyclerView) view.findViewById(R.id.horizontal_list_view_price_filter);
        this.u.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.f22277d = (TextView) view.findViewById(R.id.lower_birth_selection);
        this.f22278e = (TextView) view.findViewById(R.id.upper_birth_selection);
        this.r = (RelativeLayout) view.findViewById(R.id.bus_price_filter_recycler_layout);
        this.v = (RelativeLayout) view.findViewById(R.id.top_bar_conatiner);
        this.y = (LinearLayout) view.findViewById(R.id.lower_upper_root_layout);
        this.z = (LinearLayout) view.findViewById(R.id.ladies_seat_info_layout);
        this.s = (RelativeLayout) view.findViewById(R.id.single_lady_lyt);
        this.A = (CheckBox) view.findViewById(R.id.check_single_lady);
        if (this.x) {
            this.s.setVisibility(0);
        }
        this.f22277d.setOnClickListener(this);
        this.f22278e.setOnClickListener(this);
        this.A.setOnCheckedChangeListener(this);
        this.L = new e(getContext(), this.K);
        return this.H;
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        boolean z2 = false;
        if (getArguments() != null) {
            if (getArguments().getSerializable("intent_extra_bus_search_result_item") != null) {
                this.n = (CJRBusSearchItem) getArguments().getSerializable("intent_extra_bus_search_result_item");
            }
            if (getArguments().getSerializable("intent_extra_bus_search") != null) {
                this.o = (String) getArguments().getSerializable("intent_extra_bus_search");
            }
            this.I = getArguments().getBoolean("intent_extra_flag_bp_dp_required", false);
        }
        CJRBusSearchItem cJRBusSearchItem = this.n;
        if (!(cJRBusSearchItem == null || cJRBusSearchItem.getFeature() == null || cJRBusSearchItem.getFeature().getSingleLady() == null || !cJRBusSearchItem.getFeature().getSingleLady().booleanValue())) {
            z2 = true;
        }
        this.x = z2;
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
        CJRBusSearchItem cJRBusSearchItem2 = this.n;
        if (cJRBusSearchItem2 != null && this.w == null) {
            this.C.a(cJRBusSearchItem2.getTripId(), String.valueOf(this.n.getOperatorObj().getProviderId()), this.n.getDepartureDatetime(), false, this.o);
        } else if (this.I) {
            this.D.a(this.w);
        }
    }

    public final void a(TripBusDetail tripBusDetail) {
        if (getActivity() != null && isAdded()) {
            this.f22274a = tripBusDetail;
            this.w = this.f22274a.getBody();
            this.D.a(this.w);
            c();
        }
    }

    public final void a(String str, String str2) {
        if (str == null || !str.toLowerCase().contains("housefull")) {
            this.E.setVisibility(0);
            this.F.setText(str);
            this.G.setText(str2);
            ResourceUtils.loadBusImagesFromCDN(this.J, "no_routes_image_revamp.png", false, false, n.a.V1);
            return;
        }
        this.E.setVisibility(0);
        this.F.setText(str);
        this.G.setText(str2);
        ResourceUtils.loadBusImagesFromCDN(this.J, "sold_out_image_revamp.png", false, false, n.a.V1);
    }

    public final void a(ArrayList<TripBusDetailsItem> arrayList, ArrayList<TripBusDetailsItem> arrayList2, int i2, int i3) {
        if (getActivity() != null && !isDetached() && !getActivity().isFinishing() && isAdded()) {
            this.f22280g = arrayList;
            this.f22281h = arrayList2;
            this.v.setVisibility(0);
            if (this.f22281h.size() > 0) {
                this.y.setVisibility(0);
            }
            if (this.f22280g.size() == 0) {
                this.f22277d.setVisibility(8);
                this.f22278e.setBackgroundResource(R.drawable.travel_res_bus_right_selected_upper_only);
                this.f22278e.setTextColor(getResources().getColor(R.color.white));
            }
            a();
            try {
                final ArrayList<TripBusDetailsItem> arrayList3 = this.f22280g;
                ArrayList<TripBusDetailsItem> arrayList4 = this.f22281h;
                long j2 = (long) i2;
                long j3 = (long) i3;
                if (getActivity() != null) {
                    this.f22276c = new ac(getChildFragmentManager(), arrayList3, arrayList4, j2, j3, this.n.getFlags() != null ? this.n.getFlags().getSocialDistancingGuaranteed() : false);
                    this.f22279f.setAdapter(this.f22276c);
                    this.M.a(this.w);
                    this.f22279f.setCurrentItem(0, true);
                    if (this.f22279f != null) {
                        this.f22279f.addOnPageChangeListener(new ViewPager.e() {
                            public final void onPageScrollStateChanged(int i2) {
                            }

                            public final void onPageScrolled(int i2, float f2, int i3) {
                            }

                            public final void onPageSelected(int i2) {
                                if (i.this.f22277d != null && i.this.f22278e != null) {
                                    if (i2 != 0 || arrayList3.size() == 0) {
                                        i.this.f22278e.setBackgroundResource(R.drawable.travel_res_bus_right_selected);
                                        i.this.f22278e.setTextColor(i.this.getResources().getColor(R.color.white));
                                        i.this.f22277d.setBackgroundResource(R.drawable.travel_res_bus_left_default);
                                        i.this.f22277d.setTextColor(i.this.getResources().getColor(R.color.bus_default_color));
                                        return;
                                    }
                                    i.this.f22277d.setBackgroundResource(R.drawable.travel_res_bus_left_selected);
                                    i.this.f22277d.setTextColor(i.this.getResources().getColor(R.color.white));
                                    i.this.f22278e.setBackgroundResource(R.drawable.travel_res_bus_right_default);
                                    i.this.f22278e.setTextColor(i.this.getResources().getColor(R.color.bus_default_color));
                                }
                            }
                        });
                    }
                    try {
                        if (!this.t) {
                            com.travel.bus.a.a();
                            com.travel.bus.a.b().a("/bus-tickets/seat-selection", "BusTicket", (Context) getActivity());
                            this.t = true;
                        }
                    } catch (Exception e2) {
                        if (b.v) {
                            com.paytm.utility.q.c(e2.getMessage());
                        }
                    }
                }
            } catch (IllegalStateException e3) {
                com.paytm.utility.q.c(e3.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (list.size() > 1) {
            this.r.setVisibility(0);
            this.u.setVisibility(0);
            this.B = new q(getActivity(), list);
            this.u.setAdapter(this.B);
            this.B.notifyDataSetChanged();
            return;
        }
        this.u.setVisibility(8);
    }

    public final void a() {
        double d2;
        String str;
        if (getActivity() != null) {
            ArrayList<TripBusDetailsItem> arrayList = this.m;
            String str2 = "";
            if (arrayList == null || arrayList.size() <= 0) {
                q qVar = this.B;
                if (qVar != null) {
                    qVar.a(false, str2);
                }
                this.z.setVisibility(8);
                d2 = 0.0d;
            } else {
                double d3 = 0.0d;
                boolean z2 = false;
                for (int i2 = 0; i2 < this.m.size(); i2++) {
                    TripBusDetailsItem tripBusDetailsItem = this.m.get(i2);
                    tripBusDetailsItem.getFare();
                    if (tripBusDetailsItem.detailedFare == null) {
                        str = tripBusDetailsItem.getFare();
                    } else if (tripBusDetailsItem.detailedFare.bHasDeals()) {
                        str = String.valueOf(tripBusDetailsItem.detailedFare.getDeal().getRevisedBaseFare());
                    } else {
                        str = String.valueOf(tripBusDetailsItem.detailedFare.getBaseFare());
                    }
                    if (!str.equalsIgnoreCase(this.l) && this.m.size() > 1) {
                        z2 = true;
                    }
                    q qVar2 = this.B;
                    if (qVar2 != null) {
                        if (z2) {
                            qVar2.a(false, str);
                        } else {
                            qVar2.a(true, str);
                        }
                    }
                    if (tripBusDetailsItem.getLadiesSeat().booleanValue()) {
                        this.z.setVisibility(0);
                    } else {
                        this.z.setVisibility(8);
                    }
                    if (tripBusDetailsItem != null) {
                        d3 += Double.parseDouble(str);
                        if (i2 == this.m.size() - 1) {
                            str2 = str2 + tripBusDetailsItem.getSeatName();
                        } else {
                            str2 = str2 + tripBusDetailsItem.getSeatName() + ", ";
                        }
                    }
                }
                d2 = d3;
            }
            this.C.a(str2, d2, this.f22274a, this.k);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_proceed) {
            return;
        }
        if (id == R.id.lower_birth_selection) {
            b(false);
            ViewPager viewPager = this.f22279f;
            if (viewPager != null) {
                viewPager.setCurrentItem(0, true);
            }
            this.f22277d.setBackgroundResource(R.drawable.travel_res_bus_left_selected);
            this.f22277d.setTextColor(getResources().getColor(R.color.white));
            this.f22278e.setBackgroundResource(R.drawable.travel_res_bus_right_default);
            this.f22278e.setTextColor(getResources().getColor(R.color.bus_default_color));
            a("LOWER");
        } else if (id == R.id.upper_birth_selection) {
            b(true);
            if (this.f22279f != null) {
                a("UPPER");
                this.f22279f.setCurrentItem(1, true);
                this.f22278e.setBackgroundResource(R.drawable.travel_res_bus_right_selected);
                this.f22278e.setTextColor(getResources().getColor(R.color.white));
                this.f22277d.setBackgroundResource(R.drawable.travel_res_bus_left_default);
                this.f22277d.setTextColor(getResources().getColor(R.color.bus_default_color));
            }
        }
    }

    public final void a(int i2) {
        this.p.setVisibility(0);
        this.p.setText(getString(R.string.bus_pax_error_message_revamp, Integer.valueOf(i2)));
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                i.this.e();
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.p.setVisibility(8);
    }

    public final void b() {
        this.p.setVisibility(0);
        this.p.setText(getString(R.string.bus_lady_pax_seat_message_revamp));
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                i.this.d();
            }
        }, 3000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.p.setVisibility(8);
    }

    private void b(boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_seat");
        if (z2) {
            hashMap.put("event_action", "upper_option_clicked");
        } else {
            hashMap.put("event_action", "lower_option_clicked");
        }
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    private void a(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        if (str.equals("LOWER")) {
            str2 = "bus_seat_lower_option_clicked";
        } else if (str.equals("UPPER")) {
            str2 = "bus_seat_upper_option_clicked";
        } else {
            str2 = str.equals("INFO") ? "bus_seat_info_icon_clicked" : "";
        }
        hashMap.put("user_id", b.n((Context) getActivity()));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(str2, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        ArrayList<TripBusDetailsItem> arrayList = this.m;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.k = z2;
        this.C.a(this.n.getTripId(), String.valueOf(this.n.getOperatorObj().getProviderId()), this.n.getDepartureDatetime(), this.k, this.o);
    }

    private void c() {
        if (this.q != null) {
            this.L.b();
            this.q.setVisibility(8);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f22276c = null;
        ViewPager viewPager = this.f22279f;
        if (viewPager != null) {
            viewPager.setAdapter((androidx.viewpager.widget.a) null);
            this.f22279f = null;
        }
    }

    public final void a(boolean z2) {
        if (!z2) {
            c();
        } else if (this.q != null) {
            this.L.a();
            this.q.setVisibility(0);
        }
    }
}
