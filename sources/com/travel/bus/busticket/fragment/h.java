package com.travel.bus.busticket.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.google.android.play.core.splitcompat.a;
import com.travel.bus.R;
import com.travel.bus.busticket.a.f;
import com.travel.bus.busticket.activity.AJRBusLocationActivity;
import com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity;
import com.travel.bus.busticket.d.b;
import com.travel.bus.busticket.f.e;
import com.travel.bus.busticket.g.c;
import com.travel.bus.pojo.bussearch.CJRBusBPDPCancellationPolicyItem;
import com.travel.bus.pojo.busticket.BusRecentLocationData;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class h extends net.one97.paytm.i.h implements View.OnClickListener, f.a, e, com.travel.bus.busticket.f.f {
    private com.google.android.gms.common.api.e A;
    private BusRecentLocationData B;
    private BusRecentLocationData C;
    private boolean D = false;
    private List<Address> E;
    private List<Address> F;
    private double G;
    private double H;
    private double I;
    private double J;
    private boolean K;
    private boolean L;
    private CJRBusSearchInput M;
    private String N;
    private boolean O;
    private View P;
    private LottieAnimationView Q;
    private LinearLayout R;
    private TextView S;
    private TextView T;
    private c U;
    private b V;
    private String W = "";
    private ImageView X;
    private boolean Y = false;
    private CardView Z;

    /* renamed from: a  reason: collision with root package name */
    public CJRBusSearchItem f22265a;
    private CardView aa;
    private CardView ab;
    private CardView ac;
    private ImageView ad;
    private ImageView ae;
    private RelativeLayout af;
    private RelativeLayout ag;
    private TextView ah;
    private TextView ai;
    private TextView aj;
    private TextView ak;
    private TextView al;
    private TextView am;
    private TextView an;
    private TextView ao;
    private LinearLayout ap;
    private LinearLayout aq;
    private boolean ar;

    /* renamed from: b  reason: collision with root package name */
    public int f22266b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f22267c = -1;

    /* renamed from: d  reason: collision with root package name */
    public com.travel.bus.busticket.f.b f22268d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TripBusDetailsItem> f22269e;

    /* renamed from: f  reason: collision with root package name */
    private b f22270f;

    /* renamed from: g  reason: collision with root package name */
    private b f22271g;

    /* renamed from: h  reason: collision with root package name */
    private int f22272h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f22273i = -1;
    private int j = 0;
    private int k = 0;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private LinearLayout o;
    private String p;
    private String q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private boolean x = false;
    private RelativeLayout y;
    private RelativeLayout z;

    public final void a(TripBusDetail tripBusDetail) {
    }

    public void setUserVisibleHint(boolean z2) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        a.b(context);
        if (context instanceof com.travel.bus.busticket.f.b) {
            this.f22268d = (com.travel.bus.busticket.f.b) context;
        }
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getSerializable("intent_extra_bus_search_result_item") == null)) {
            this.f22265a = (CJRBusSearchItem) arguments.getSerializable("intent_extra_bus_search_result_item");
        }
        if (!(arguments == null || arguments.getSerializable("intent_extra_bus_search_input") == null)) {
            this.M = (CJRBusSearchInput) arguments.getSerializable("intent_extra_bus_search_input");
        }
        if (!(arguments == null || arguments.getString("intent_extra_bus_search") == null)) {
            this.N = arguments.getString("intent_extra_bus_search");
        }
        if (arguments != null) {
            this.O = arguments.getBoolean("intent_extra_flag_bp_dp_required");
        }
        if (!(arguments == null || arguments.getString("route") == null)) {
            this.W = arguments.getString("route");
        }
        this.U = new c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.P = layoutInflater.inflate(R.layout.pre_b_bus_route_layout, viewGroup, false);
        View view = this.P;
        this.V = new b(getContext(), this);
        Button button = (Button) view.findViewById(R.id.proceed_to_select_seat);
        button.setOnClickListener(this);
        button.setVisibility(8);
        this.X = (ImageView) view.findViewById(R.id.error_image_view);
        this.l = (TextView) view.findViewById(R.id.tv_bp_count);
        this.m = (TextView) view.findViewById(R.id.tv_dp_count);
        this.n = (LinearLayout) view.findViewById(R.id.lyt_drop_point_detail);
        this.o = (LinearLayout) view.findViewById(R.id.lyt_boarding_point_detail);
        this.y = (RelativeLayout) view.findViewById(R.id.find_nearest_boarding_lyt);
        this.z = (RelativeLayout) view.findViewById(R.id.find_nearest_dropping_lyt);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.r = (TextView) view.findViewById(R.id.text_find_nearest);
        this.u = (TextView) view.findViewById(R.id.text_find_nearest_address);
        this.v = (TextView) view.findViewById(R.id.text_find_nearest_dp);
        this.w = (TextView) view.findViewById(R.id.text_find_nearest_address_dp);
        this.s = (TextView) view.findViewById(R.id.tv_change_find_nearest_bp);
        this.s.setOnClickListener(this);
        this.t = (TextView) view.findViewById(R.id.tv_change_find_nearest_dp);
        this.t.setOnClickListener(this);
        this.Q = (LottieAnimationView) view.findViewById(R.id.lottie_progress_bar);
        this.Q.setVisibility(0);
        this.R = (LinearLayout) view.findViewById(R.id.bus_error_container);
        this.S = (TextView) view.findViewById(R.id.bus_seat_error_title);
        this.T = (TextView) view.findViewById(R.id.bus_seat_error_message);
        this.Z = (CardView) view.findViewById(R.id.cvBP);
        this.aa = (CardView) view.findViewById(R.id.cvBPDetails);
        this.ah = (TextView) view.findViewById(R.id.tvCvBpTime);
        this.ai = (TextView) view.findViewById(R.id.tvCvBpDate);
        this.aj = (TextView) view.findViewById(R.id.tvCvBpLocationDetails);
        this.ak = (TextView) view.findViewById(R.id.tvCvBpChange);
        this.ak.setOnClickListener(this);
        this.ab = (CardView) view.findViewById(R.id.cvDP);
        this.ac = (CardView) view.findViewById(R.id.cvDPDetails);
        this.al = (TextView) view.findViewById(R.id.tvCvDpTime);
        this.am = (TextView) view.findViewById(R.id.tvCvDpDate);
        this.an = (TextView) view.findViewById(R.id.tvCvDpLocationDetails);
        this.ao = (TextView) view.findViewById(R.id.tvCvDpChange);
        this.ao.setOnClickListener(this);
        this.ad = (ImageView) view.findViewById(R.id.iv_bp_arrow);
        this.af = (RelativeLayout) view.findViewById(R.id.rlv_bp_arrow);
        this.af.setOnClickListener(this);
        this.ae = (ImageView) view.findViewById(R.id.iv_dp_arrow);
        this.ag = (RelativeLayout) view.findViewById(R.id.rlv_dp_arrow);
        this.ag.setOnClickListener(this);
        this.ap = (LinearLayout) view.findViewById(R.id.frg_container);
        this.aq = (LinearLayout) view.findViewById(R.id.frg_container_dp);
        c();
        return this.P;
    }

    private static boolean b() {
        com.travel.bus.a.a();
        return com.travel.bus.a.b().a("busLocationVisibility", false);
    }

    private void c() {
        if (!(this.y == null || this.z == null)) {
            if (b()) {
                this.y.setVisibility(0);
                this.z.setVisibility(0);
            } else {
                this.y.setVisibility(8);
                this.z.setVisibility(8);
            }
        }
        k();
        b(true);
        a(this.f22265a.getBoardingLocations(), true);
        a(this.f22265a.getDroppingLocations(), false);
    }

    public final void a(boolean z2, boolean z3) {
        if (z2) {
            f();
            if (!z3) {
                a();
            }
        } else {
            e();
            if (this.L && !z3) {
                a();
            }
        }
        this.L = true;
    }

    private void b(boolean z2) {
        if (getActivity() != null && isAdded() && !isDetached()) {
            if (z2) {
                if (this.y != null) {
                    if (b()) {
                        this.y.setVisibility(0);
                    }
                    this.ap.setVisibility(0);
                    this.ad.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_up));
                }
                if (this.x) {
                    BusRecentLocationData busRecentLocationData = this.B;
                    if (busRecentLocationData != null) {
                        this.r.setText(busRecentLocationData.getPrimaryText());
                        this.u.setText(this.B.getSecondaryText());
                        this.s.setVisibility(0);
                    }
                } else if (!this.D) {
                    this.r.setText(getResources().getString(R.string.nearest_boarding_point));
                    this.u.setText(getResources().getString(R.string.your_area_street_landmark));
                    this.s.setVisibility(8);
                } else if (!TextUtils.isEmpty(this.p) && !TextUtils.isEmpty(this.q)) {
                    this.r.setText(this.p);
                    this.u.setText(this.q);
                    this.s.setVisibility(0);
                }
            } else {
                if (this.z != null) {
                    if (b()) {
                        this.z.setVisibility(0);
                    }
                    this.aq.setVisibility(0);
                    this.ae.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_up));
                }
                if (this.x) {
                    BusRecentLocationData busRecentLocationData2 = this.C;
                    if (busRecentLocationData2 != null) {
                        this.v.setText(busRecentLocationData2.getPrimaryText());
                        this.w.setText(this.C.getSecondaryText());
                        this.t.setVisibility(0);
                    }
                } else if (!this.D) {
                    this.v.setText(getResources().getString(R.string.nearest_dropping_point));
                    this.w.setText(getResources().getString(R.string.your_area_street_landmark));
                    this.t.setVisibility(8);
                } else if (!TextUtils.isEmpty(this.p) && !TextUtils.isEmpty(this.q)) {
                    this.v.setText(this.p);
                    this.w.setText(this.q);
                    this.t.setVisibility(0);
                }
            }
        }
    }

    public void onDestroy() {
        if (this.f22270f != null) {
            this.f22270f = null;
        }
        if (this.f22271g != null) {
            this.f22271g = null;
        }
        com.google.android.gms.common.api.e eVar = this.A;
        if (eVar != null) {
            eVar.e();
            this.A = null;
        }
        super.onDestroy();
    }

    private void d() {
        LottieAnimationView lottieAnimationView = this.Q;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.text_boarding_dropping_point) {
            this.Y = false;
            a(this.f22265a.getBoardingLocations(), true);
            b(true);
            i();
        } else if (view.getId() == R.id.lyt_boarding_point_detail) {
            this.Y = false;
            a(this.f22265a.getBoardingLocations(), true);
            b(true);
            i();
        } else if (view.getId() == R.id.text_drop_point) {
            this.Y = true;
            a(this.f22265a.getDroppingLocations(), false);
            b(false);
            j();
        } else if (view.getId() == R.id.lyt_drop_point_detail) {
            this.Y = true;
            a(this.f22265a.getDroppingLocations(), false);
            b(false);
            j();
        } else if (view.getId() == R.id.find_nearest_boarding_lyt || view == this.s) {
            this.ar = true;
            g();
        } else if (view.getId() == R.id.find_nearest_dropping_lyt || view == this.t) {
            this.ar = false;
            g();
        } else if (view == this.ak) {
            this.Z.setVisibility(8);
            this.aa.setVisibility(0);
        } else if (view == this.ao) {
            this.ab.setVisibility(8);
            this.ac.setVisibility(0);
        } else if (view == this.af) {
            if (this.ai.getText().length() > 0 && this.ah.getText().length() > 0 && this.aj.getText().length() > 0) {
                this.Z.setVisibility(0);
                this.aa.setVisibility(8);
            } else if (this.ap.getVisibility() == 8 && this.y.getVisibility() == 8) {
                if (b()) {
                    this.y.setVisibility(0);
                }
                this.ap.setVisibility(0);
                this.ad.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_up));
            } else {
                this.y.setVisibility(8);
                this.ap.setVisibility(8);
                this.ad.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_down));
            }
        } else if (view != this.ag) {
        } else {
            if (this.am.getText().length() > 0 && this.al.getText().length() > 0 && this.an.getText().length() > 0) {
                this.ab.setVisibility(0);
                this.ac.setVisibility(8);
            } else if (this.aq.getVisibility() == 8 && this.z.getVisibility() == 8) {
                if (b()) {
                    this.z.setVisibility(0);
                }
                this.aq.setVisibility(0);
                this.ae.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_up));
            } else {
                this.z.setVisibility(8);
                this.aq.setVisibility(8);
                this.ae.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_down));
            }
        }
    }

    public final void a() {
        if (!this.K && this.f22266b == -1) {
            Toast.makeText(getContext(), R.string.select_board_point, 0).show();
        } else if (!this.K && this.f22267c == -1) {
            Toast.makeText(getContext(), R.string.select_drop_point, 0).show();
        }
        this.K = false;
    }

    private void e() {
        this.Y = false;
        i();
        a(this.f22265a.getBoardingLocations(), true);
        b(true);
    }

    private void f() {
        j();
        h();
    }

    private void g() {
        int i2 = this.ar ? 334 : 335;
        c.a(this.ar);
        Intent intent = new Intent(getContext(), AJRBusLocationActivity.class);
        intent.putExtra("isboardingLocation", this.ar);
        startActivityForResult(intent, i2);
    }

    public final void a(ArrayList<CJRLocation> arrayList, boolean z2) {
        boolean z3 = z2;
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (!this.Y || !z3) {
                b(arrayList, z2);
                if (arrayList == null) {
                    return;
                }
                if (z3) {
                    this.ad.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_up));
                    TextView textView = this.l;
                    textView.setText(arrayList.size() + " " + getString(R.string.boarding_points));
                    BusRecentLocationData busRecentLocationData = this.B;
                    BusRecentLocationData busRecentLocationData2 = this.C;
                    List<Address> list = this.E;
                    double d2 = this.G;
                    double d3 = this.H;
                    List<Address> list2 = this.F;
                    double d4 = this.I;
                    this.f22270f = (b) c.a(busRecentLocationData, busRecentLocationData2, z2, arrayList, this, list, d2, d3, list2, d4, this.J);
                    q a2 = getActivity().getSupportFragmentManager().a();
                    b bVar = this.f22270f;
                    if (bVar != null) {
                        bVar.a(this.f22272h, this.f22273i, z2);
                    }
                    a2.b(R.id.frg_container, this.f22270f, (String) null);
                    a2.c();
                    if (arrayList.size() == 1) {
                        this.ak.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.ae.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.travel_res_bus_ic_bpdp_arrow_up));
                TextView textView2 = this.m;
                textView2.setText(arrayList.size() + " " + getString(R.string.dropping_points));
                BusRecentLocationData busRecentLocationData3 = this.B;
                BusRecentLocationData busRecentLocationData4 = this.C;
                List<Address> list3 = this.E;
                double d5 = this.G;
                double d6 = this.H;
                List<Address> list4 = this.F;
                double d7 = this.I;
                this.f22271g = (b) c.a(busRecentLocationData3, busRecentLocationData4, z2, arrayList, this, list3, d5, d6, list4, d7, this.J);
                q a3 = getActivity().getSupportFragmentManager().a();
                b bVar2 = this.f22271g;
                if (bVar2 != null) {
                    bVar2.a(this.f22272h, this.f22273i, z2);
                }
                a3.b(R.id.frg_container_dp, this.f22271g, (String) null);
                a3.c();
                if (arrayList.size() == 1) {
                    this.ao.setVisibility(8);
                }
            }
        }
    }

    public final void a(CJRLocation cJRLocation, boolean z2, int i2) {
        this.K = false;
        String time = cJRLocation.getTime();
        String time2 = cJRLocation.getTime();
        if (time != null && !time.equals("")) {
            FragmentActivity activity = getActivity();
            com.travel.bus.a.a();
            time = com.paytm.utility.b.a((Activity) activity, time, "yyyy-MM-dd HH:mm:ss", "h:mm a", com.travel.bus.a.b().b());
        }
        if (time2 != null && !time2.equals("")) {
            FragmentActivity activity2 = getActivity();
            com.travel.bus.a.a();
            time2 = com.paytm.utility.b.a((Activity) activity2, time2, "yyyy-MM-dd", "d MMM", com.travel.bus.a.b().b());
        }
        com.travel.bus.busticket.f.b bVar = this.f22268d;
        if (bVar != null) {
            bVar.a(cJRLocation, z2);
        }
        if (z2) {
            this.aa.setVisibility(8);
            this.Z.setVisibility(0);
            if (time == null || time.equals("")) {
                this.ah.setVisibility(8);
            } else {
                this.ah.setText(time + " ");
            }
            if (time2 == null || time2.equals("")) {
                this.ai.setVisibility(8);
            } else {
                this.ai.setText(time2);
            }
            this.aj.setText(cJRLocation.getLocationName());
            this.f22272h = i2;
            this.f22266b = i2;
            com.travel.bus.busticket.f.b bVar2 = this.f22268d;
            if (bVar2 != null) {
                bVar2.a(cJRLocation, (CJRLocation) null);
                return;
            }
            return;
        }
        this.ac.setVisibility(8);
        this.ab.setVisibility(0);
        if (time == null || time.equals("")) {
            this.al.setVisibility(8);
        } else {
            this.al.setText(time + " ");
        }
        if (time2 == null || time2.equals("")) {
            this.am.setVisibility(8);
        } else {
            this.am.setText(time2);
        }
        this.an.setText(cJRLocation.getLocationName());
        this.f22273i = i2;
        this.f22267c = i2;
        com.travel.bus.busticket.f.b bVar3 = this.f22268d;
        if (bVar3 != null) {
            bVar3.a((CJRLocation) null, cJRLocation);
        }
        if (this.f22272h != this.f22266b && this.f22273i != this.f22267c) {
            getActivity();
        }
    }

    private void h() {
        this.Y = true;
        a(this.f22265a.getDroppingLocations(), false);
        b(false);
    }

    private void i() {
        LinearLayout linearLayout = this.o;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.white));
        }
        LinearLayout linearLayout2 = this.n;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_f4f4f4));
        }
    }

    private void j() {
        LinearLayout linearLayout = this.n;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.white));
        }
        LinearLayout linearLayout2 = this.o;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundColor(androidx.core.content.b.c(getContext(), R.color.color_f4f4f4));
        }
    }

    public final void a(int i2) {
        if (i2 == 1 && this.j == 0) {
            this.j = i2;
        } else if (i2 == 1 && this.k == 0) {
            this.k = i2;
        }
    }

    private void b(ArrayList<CJRLocation> arrayList, boolean z2) {
        Iterator<CJRLocation> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRLocation next = it2.next();
            if (next != null && TextUtils.isEmpty(next.getLocationName())) {
                if (z2) {
                    next.setLocationName(this.f22265a.getSource());
                } else {
                    next.setLocationName(this.f22265a.getDestination());
                }
            }
        }
    }

    public final void a(CJRBusSearchItem cJRBusSearchItem) {
        if (getActivity() != null && isAdded()) {
            this.f22265a = cJRBusSearchItem;
            c();
            d();
        }
    }

    public final void a(String str, String str2) {
        if (str == null || !str.toLowerCase().contains("housefull")) {
            this.R.setVisibility(0);
            this.S.setText(getString(R.string.bus_error_title_revamp));
            this.T.setText(getString(R.string.bus_dp_error_message));
            ResourceUtils.loadBusImagesFromCDN(this.X, "no_routes_image_revamp.png", false, false, n.a.V1);
            return;
        }
        this.R.setVisibility(0);
        this.S.setText(str);
        this.T.setText(str2);
        ResourceUtils.loadBusImagesFromCDN(this.X, "sold_out_image_revamp.png", false, false, n.a.V1);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 334) {
            if (i3 == -1 && intent != null && intent.hasExtra("intent_extra_current_location")) {
                if (intent.getBooleanExtra("intent_extra_current_location", false)) {
                    this.B = null;
                    double doubleExtra = intent.getDoubleExtra("intent_extra_current_location_lat", 0.0d);
                    double doubleExtra2 = intent.getDoubleExtra("intent_extra_current_location_lon", 0.0d);
                    this.x = false;
                    double d2 = doubleExtra;
                    double d3 = doubleExtra2;
                    b(d2, d3, true);
                    a(d2, d3, true);
                    this.G = doubleExtra;
                    this.H = doubleExtra2;
                } else if (intent.hasExtra("intent_extra_place")) {
                    this.E = null;
                    a((BusRecentLocationData) intent.getSerializableExtra("intent_extra_place"), true);
                }
            }
        } else if (i2 == 335 && i3 == -1 && intent != null && intent.hasExtra("intent_extra_current_location")) {
            if (intent.getBooleanExtra("intent_extra_current_location", false)) {
                this.C = null;
                double doubleExtra3 = intent.getDoubleExtra("intent_extra_current_location_lat", 0.0d);
                double doubleExtra4 = intent.getDoubleExtra("intent_extra_current_location_lon", 0.0d);
                double d4 = doubleExtra3;
                double d5 = doubleExtra4;
                b(d4, d5, false);
                a(d4, d5, false);
                this.I = doubleExtra3;
                this.J = doubleExtra4;
            } else if (intent.hasExtra("intent_extra_place")) {
                this.F = null;
                a((BusRecentLocationData) intent.getSerializableExtra("intent_extra_place"), false);
            }
        }
    }

    private void k() {
        if (getContext() != null) {
            this.A = new e.a(getContext()).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) com.google.android.gms.location.places.e.f11416a).a((com.google.android.gms.common.api.a<? extends a.d.C0127d>) com.google.android.gms.a.a.f8032a).a();
            com.google.android.gms.common.api.e eVar = this.A;
            if (eVar != null && !eVar.f()) {
                this.A.d();
            }
        }
    }

    private void a(BusRecentLocationData busRecentLocationData, boolean z2) {
        if (busRecentLocationData != null) {
            try {
                b(busRecentLocationData, z2);
            } catch (Exception unused) {
            }
        }
    }

    private void b(BusRecentLocationData busRecentLocationData, boolean z2) {
        BusRecentLocationData busRecentLocationData2 = busRecentLocationData;
        boolean z3 = z2;
        if (busRecentLocationData2 != null) {
            if (z3) {
                this.B = busRecentLocationData2;
                this.x = true;
                this.f22265a = c.b(this.f22265a, busRecentLocationData.getLatitude().doubleValue(), busRecentLocationData.getLongitude().doubleValue(), true);
            } else {
                this.C = busRecentLocationData2;
                this.x = true;
                this.f22265a = c.a(this.f22265a, busRecentLocationData.getLatitude().doubleValue(), busRecentLocationData.getLongitude().doubleValue(), true);
            }
            b(busRecentLocationData.getLatitude().doubleValue(), busRecentLocationData.getLongitude().doubleValue(), z2);
            b(z3);
            if (z3) {
                b bVar = this.f22270f;
                if (bVar != null) {
                    bVar.a(busRecentLocationData.getLatitude().doubleValue(), busRecentLocationData.getLongitude().doubleValue(), z2, this.f22265a.getBoardingLocations());
                    return;
                }
                return;
            }
            b bVar2 = this.f22271g;
            if (bVar2 != null) {
                bVar2.a(busRecentLocationData.getLatitude().doubleValue(), busRecentLocationData.getLongitude().doubleValue(), z2, this.f22265a.getDroppingLocations());
            }
        }
    }

    private void b(double d2, double d3, boolean z2) {
        this.f22265a = c.a(d2, d3, z2, this.f22265a);
    }

    public final void a(CJRBusBPDPCancellationPolicyItem cJRBusBPDPCancellationPolicyItem) {
        d();
        if (getActivity() != null) {
            ((AJRBusSelectSeatsActivity) getActivity()).a(cJRBusBPDPCancellationPolicyItem);
            a(this.f22265a.getDroppingLocations(), false);
            a(this.f22265a.getBoardingLocations(), true);
        }
    }

    private void a(double d2, double d3, boolean z2) {
        boolean z3 = z2;
        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
        boolean z4 = false;
        if (z3) {
            try {
                this.E = geocoder.getFromLocation(d2, d3, 1);
                if (this.E != null && this.E.size() > 0) {
                    this.p = this.E.get(0).getLocality();
                    this.q = this.E.get(0).getFeatureName();
                }
            } catch (IOException e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        } else {
            this.F = geocoder.getFromLocation(d2, d3, 1);
        }
        if (z3) {
            b bVar = this.f22270f;
            if (bVar != null) {
                bVar.a(d2, d3, z2, this.f22265a.getBoardingLocations());
            }
            this.D = true;
            this.f22265a = c.b(this.f22265a, d2, d3, false);
        } else {
            b bVar2 = this.f22271g;
            if (bVar2 != null) {
                bVar2.a(d2, d3, z2, this.f22265a.getDroppingLocations());
            }
            this.D = true;
            this.f22265a = c.a(this.f22265a, d2, d3, false);
        }
        boolean z5 = ((this.E == null && this.F == null) ? false : true) & (this.f22270f != null);
        if (this.f22271g != null) {
            z4 = true;
        }
        if (z5 && z4) {
            b(z3);
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            LottieAnimationView lottieAnimationView = this.Q;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(0);
                return;
            }
            return;
        }
        d();
    }
}
