package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.busticket.e.k;
import com.travel.bus.busticket.e.n;
import com.travel.bus.pojo.busticket.BusEcosystemOfferInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;

public final class w extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    d f21779a;

    /* renamed from: b  reason: collision with root package name */
    c f21780b;

    /* renamed from: c  reason: collision with root package name */
    HashMap<String, Object> f21781c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRBusSearchItem> f21782d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, ArrayList<Integer>> f21783e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<CJRBusSearchItem> f21784f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, CJRBusSearchOperatorTagInfo> f21785g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f21786h;

    /* renamed from: i  reason: collision with root package name */
    private Context f21787i;
    private LayoutInflater j;
    private boolean k = false;
    private HashMap<String, CJRBusSearchAmenitiesInfo> l = new HashMap<>();
    private HashMap<String, ArrayList<BusEcosystemOfferInfo>> m = new HashMap<>();
    private HashMap<String, ArrayList<Integer>> n = new HashMap<>();
    private com.travel.bus.busticket.b.d o;
    private boolean p;
    private int q = -1;

    public interface c {
        void onChildClicked(CJRBusSearchItem cJRBusSearchItem, int i2);

        void onGroupViewClicked(boolean z, int i2);

        void onHorizontalScrollClicked(CJRBusSearchItem cJRBusSearchItem, int i2);

        void onRatingsClick(CJRBusSearchItem cJRBusSearchItem, int i2, int i3);
    }

    public interface d {
    }

    public w(Context context, ArrayList<CJRBusSearchItem> arrayList, HashMap<String, ArrayList<Integer>> hashMap, HashMap<String, Object> hashMap2, ArrayList<CJRBusSearchItem> arrayList2, d dVar, c cVar, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap3, HashMap<String, CJRBusSearchOperatorTagInfo> hashMap4, HashMap<String, ArrayList<BusEcosystemOfferInfo>> hashMap5, com.travel.bus.busticket.b.d dVar2) {
        this.f21787i = context;
        this.f21782d = arrayList;
        this.f21779a = dVar;
        this.f21783e = hashMap;
        this.f21784f.addAll(arrayList2);
        this.f21780b = cVar;
        this.j = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f21781c = hashMap2;
        if (hashMap3 != null) {
            this.l.putAll(hashMap3);
        }
        if (hashMap4 != null) {
            this.f21785g.putAll(hashMap4);
        }
        if (hashMap5 != null) {
            this.m.putAll(hashMap5);
        }
        this.o = dVar2;
    }

    public final int getItemViewType(int i2) {
        if (this.f21782d.get(i2).getmItemType() != null) {
            this.p = false;
            if (this.f21782d.get(i2).getmItemType().equals("bus_item_type_header")) {
                return 0;
            }
            if (this.f21782d.get(i2).getmItemType().equals("bus_item_type_list")) {
            }
            return 1;
        }
        this.p = true;
        return 1;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            View inflate = this.j.inflate(R.layout.pre_b_layout_srp_list_item_bus_operator_info, viewGroup, false);
            n nVar = new n(this.f21787i, inflate, this.f21780b);
            nVar.f22188e = (ImageView) inflate.findViewById(R.id.image_view_bus_group_logo);
            nVar.f22185b = (TextView) inflate.findViewById(R.id.text_view_bus_group_name);
            nVar.f22187d = (TextView) inflate.findViewById(R.id.text_view_bus_group_minimum_price);
            nVar.f22186c = (TextView) inflate.findViewById(R.id.text_view_show_buses_toggle);
            nVar.f22189f = (TextView) inflate.findViewById(R.id.text_start_time);
            nVar.f22190g = (ViewGroup) inflate.findViewById(R.id.bus_srp_item);
            nVar.f22191h = (ViewGroup) inflate.findViewById(R.id.card_view_rtc_header);
            nVar.f22191h.setBackgroundResource(R.drawable.travel_res_bus_uniform_shadow_header);
            nVar.f22192i = (ImageView) inflate.findViewById(R.id.image_view_show_buses_arrow_toggle);
            com.paytm.utility.b.d(nVar.f22185b);
            inflate.setTag(nVar);
            return nVar;
        } else if (i2 != 1) {
            return null;
        } else {
            View inflate2 = this.j.inflate(R.layout.pre_b_bus_srp_item, viewGroup, false);
            k kVar = new k(this.f21787i, inflate2, this.l, this.f21785g, this.m, this.o, this.f21782d, this.f21780b);
            kVar.C = (TextView) inflate2.findViewById(R.id.dealsDisplayText);
            kVar.A = inflate2.findViewById(R.id.dealsLayout);
            kVar.B = (ImageView) inflate2.findViewById(R.id.iv_covid_buses);
            kVar.u = (TextView) inflate2.findViewById(R.id.text_bus_boarding_time);
            kVar.x = (TextView) inflate2.findViewById(R.id.oldCostTextView);
            kVar.v = (TextView) inflate2.findViewById(R.id.text_depart_time);
            kVar.f22166b = (TextView) inflate2.findViewById(R.id.text_cost);
            kVar.f22167c = (TextView) inflate2.findViewById(R.id.text_view_rupee);
            kVar.f22168d = (RoboTextView) inflate2.findViewById(R.id.text_travels_name);
            kVar.f22171g = (RoboTextView) inflate2.findViewById(R.id.text_travels_desc);
            kVar.f22172h = (RoboTextView) inflate2.findViewById(R.id.text_duration);
            kVar.f22173i = (RoboTextView) inflate2.findViewById(R.id.text_no_of_seats);
            kVar.f22170f = (LinearLayout) inflate2.findViewById(R.id.container);
            kVar.j = (RecyclerView) inflate2.findViewById(R.id.amenities_list);
            kVar.k = (RecyclerView) inflate2.findViewById(R.id.operator_type_list);
            kVar.f22169e = (LinearLayout) inflate2.findViewById(R.id.lyt_bus_tags);
            kVar.l = (RoboTextView) inflate2.findViewById(R.id.text_sold_out);
            kVar.w = (TextView) inflate2.findViewById(R.id.text_sold_out_message);
            kVar.n = (TextView) inflate2.findViewById(R.id.text_bus_rating);
            kVar.m = (TextView) inflate2.findViewById(R.id.text_departed);
            kVar.o = (RoboTextView) inflate2.findViewById(R.id.text_no_of_ratings);
            kVar.p = (RoboTextView) inflate2.findViewById(R.id.text_route);
            kVar.q = (RoboTextView) inflate2.findViewById(R.id.text_cancellation_policy);
            kVar.r = inflate2.findViewById(R.id.view_circle1);
            kVar.s = inflate2.findViewById(R.id.sold_out_view);
            kVar.t = inflate2.findViewById(R.id.departed_view);
            kVar.y = (ViewGroup) inflate2.findViewById(R.id.bus_srp_item);
            kVar.y.setBackgroundResource(R.drawable.travel_res_bus_uniform_shadow_normal);
            kVar.z = inflate2;
            kVar.t.setVisibility(8);
            kVar.s.setVisibility(8);
            kVar.l.setVisibility(4);
            kVar.m.setVisibility(8);
            kVar.f22166b.setVisibility(0);
            kVar.f22167c.setVisibility(0);
            kVar.u.setVisibility(0);
            kVar.v.setVisibility(0);
            com.paytm.utility.b.c(kVar.f22168d);
            com.paytm.utility.b.d(kVar.f22166b);
            com.paytm.utility.b.a(kVar.f22171g);
            com.paytm.utility.b.c(kVar.u);
            com.paytm.utility.b.a(kVar.v);
            com.paytm.utility.b.a(kVar.f22172h);
            com.paytm.utility.b.a(kVar.f22173i);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(kVar.f22165a, 0, false);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(kVar.f22165a, 0, false);
            kVar.j.setLayoutManager(linearLayoutManager);
            kVar.k.setLayoutManager(linearLayoutManager2);
            inflate2.setTag(kVar);
            return kVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0245  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r11, int r12) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.travel.bus.busticket.e.k
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0095
            com.travel.bus.busticket.e.k r11 = (com.travel.bus.busticket.e.k) r11
            java.util.HashMap<java.lang.String, com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo> r0 = r10.f21785g
            r11.D = r0
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.travel.bus.pojo.busticket.BusEcosystemOfferInfo>> r0 = r10.m
            r11.E = r0
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r0 = r10.f21782d
            r11.a((java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem>) r0, (int) r12)
            boolean r0 = r10.p
            if (r0 == 0) goto L_0x0027
            r10.p = r2
            int r0 = r10.q
            if (r12 != r0) goto L_0x0023
            r11.a()
            goto L_0x0064
        L_0x0023:
            r11.a()
            goto L_0x0064
        L_0x0027:
            android.content.Context r0 = r11.f22165a
            android.content.res.Resources r0 = r0.getResources()
            int r3 = com.travel.bus.R.dimen.dimen_5dp
            float r0 = r0.getDimension(r3)
            int r0 = (int) r0
            android.content.Context r3 = r11.f22165a
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.travel.bus.R.dimen.dimen_0dp
            float r3 = r3.getDimension(r4)
            int r3 = (int) r3
            android.content.Context r4 = r11.f22165a
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.bus.R.dimen.dimen_1dp
            float r4 = r4.getDimension(r5)
            int r4 = (int) r4
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r6 = -1
            r7 = -2
            r5.<init>(r6, r7)
            r5.setMargins(r0, r4, r0, r3)
            android.view.ViewGroup r0 = r11.y
            r0.setLayoutParams(r5)
            android.view.ViewGroup r0 = r11.y
            int r3 = com.travel.bus.R.drawable.travel_res_bus_uniform_shadow_normal
            r0.setBackgroundResource(r3)
        L_0x0064:
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r0 = r10.f21782d
            java.lang.Object r0 = r0.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r0
            r11.a((com.travel.bus.pojo.busticket.CJRBusSearchItem) r0)
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r0 = r10.f21782d
            if (r0 == 0) goto L_0x0078
            int r0 = r0.size()
            goto L_0x0079
        L_0x0078:
            r0 = 0
        L_0x0079:
            int r0 = r0 - r1
            if (r12 != r0) goto L_0x008f
            android.content.Context r12 = r11.f22165a
            android.content.res.Resources r12 = r12.getResources()
            int r0 = com.travel.bus.R.dimen.dimen_9dp
            float r12 = r12.getDimension(r0)
            int r12 = (int) r12
            android.view.View r11 = r11.z
            r11.setPadding(r2, r2, r2, r12)
            return
        L_0x008f:
            android.view.View r11 = r11.z
            r11.setPadding(r2, r2, r2, r2)
            return
        L_0x0095:
            boolean r0 = r11 instanceof com.travel.bus.busticket.e.n
            if (r0 == 0) goto L_0x029b
            r10.c((int) r12)
            java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.Integer>> r0 = r10.f21783e
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r3 = r10.f21782d
            java.lang.Object r3 = r3.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r3 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r3
            java.lang.String r3 = r3.getOperatorGroupName()
            java.lang.Object r0 = r0.get(r3)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            r10.q = r0
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r0 = r10.f21782d
            java.lang.Object r0 = r0.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r0
            java.lang.String r0 = r0.getOperatorGroupName()
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r3 = r10.f21782d
            java.lang.Object r3 = r3.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r3 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r3
            com.travel.bus.pojo.CJRBusSearchOperatorInfo r3 = r3.getOperatorObj()
            java.lang.String r3 = r3.getLogoUrl()
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r10.f21781c
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x00f8
            if (r0 == 0) goto L_0x00f8
            boolean r4 = r0.equals(r5)
            if (r4 != 0) goto L_0x00f8
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r10.f21781c
            java.lang.Object r4 = r4.get(r0)
            java.util.HashMap r4 = (java.util.HashMap) r4
            if (r4 == 0) goto L_0x00f8
            int r6 = r4.size()
            if (r6 <= 0) goto L_0x00f8
            java.lang.String r3 = "logo_url"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
        L_0x00f8:
            java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.Integer>> r4 = r10.f21783e
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r6 = r10.f21782d
            java.lang.Object r6 = r6.get(r12)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r6 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r6
            java.lang.String r6 = r6.getOperatorGroupName()
            java.lang.Object r4 = r4.get(r6)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.util.ArrayList r6 = r10.b((int) r12)
            java.util.ArrayList r7 = r10.a((int) r12)
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L_0x0141
            com.travel.bus.busticket.a.-$$Lambda$w$WTPIdpPBXaAv6ZXR18fZ0OD52cA r8 = com.travel.bus.busticket.a.$$Lambda$w$WTPIdpPBXaAv6ZXR18fZ0OD52cA.INSTANCE
            java.util.Collections.sort(r7, r8)
            int r8 = r7.size()
            if (r8 <= 0) goto L_0x0141
            java.lang.Object r7 = r7.get(r2)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r7 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r7
            if (r7 == 0) goto L_0x0141
            java.lang.String r8 = r7.getDepartureDatetime()
            if (r8 == 0) goto L_0x0141
            java.lang.String r7 = r7.getDepartureDatetime()
            java.lang.String r8 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r9 = "h:mm a"
            java.lang.String r7 = com.paytm.utility.b.a((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9)
            goto L_0x0142
        L_0x0141:
            r7 = r5
        L_0x0142:
            int r8 = r6.size()
            if (r8 <= 0) goto L_0x0159
            java.lang.Object r6 = r6.get(r2)
            java.lang.Double r6 = (java.lang.Double) r6
            double r8 = r6.doubleValue()
            java.lang.String r6 = "###,###,###.##"
            java.lang.String r6 = com.paytm.utility.b.a((double) r8, (java.lang.String) r6)
            goto L_0x015a
        L_0x0159:
            r6 = r5
        L_0x015a:
            com.travel.bus.busticket.e.n r11 = (com.travel.bus.busticket.e.n) r11
            android.view.ViewGroup r8 = r11.f22190g
            com.travel.bus.busticket.a.-$$Lambda$w$FHKxEURAfF1w2i-fG0sda0iD1G4 r9 = new com.travel.bus.busticket.a.-$$Lambda$w$FHKxEURAfF1w2i-fG0sda0iD1G4
            r9.<init>(r11, r12)
            r8.setOnClickListener(r9)
            boolean r12 = r10.f21786h
            if (r12 == 0) goto L_0x016c
            r11.j = r2
        L_0x016c:
            if (r0 == 0) goto L_0x0173
            android.widget.TextView r12 = r11.f22185b
            r12.setText(r0)
        L_0x0173:
            if (r3 == 0) goto L_0x01a5
            boolean r12 = r3.equals(r5)
            if (r12 != 0) goto L_0x01a5
            android.widget.ImageView r12 = r11.f22188e
            r12.setVisibility(r2)
            android.content.Context r12 = r11.f22184a
            com.paytm.utility.b.b$a$a r12 = com.paytm.utility.b.b.a(r12)
            r12.f43753a = r3
            int r3 = com.travel.bus.R.drawable.travel_res_bus_placeholder_icon
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.paytm.utility.b.b$a$a r12 = r12.a((java.lang.Object) r3)
            int r3 = com.travel.bus.R.drawable.travel_res_bus_placeholder_icon
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.paytm.utility.b.b$a$a r12 = r12.b(r3)
            r12.m = r1
            r12.o = r1
            android.widget.ImageView r1 = r11.f22188e
            r12.a((android.widget.ImageView) r1)
        L_0x01a5:
            if (r4 == 0) goto L_0x01be
            int r12 = r4.size()
            if (r12 <= 0) goto L_0x01be
            android.widget.TextView r12 = r11.f22186c
            if (r12 == 0) goto L_0x01be
            int r12 = r4.size()
            java.lang.String r12 = com.travel.bus.busticket.e.n.a(r0, r12)
            android.widget.TextView r1 = r11.f22186c
            r1.setText(r12)
        L_0x01be:
            if (r6 == 0) goto L_0x01c5
            android.widget.TextView r12 = r11.f22187d
            r12.setText(r6)
        L_0x01c5:
            if (r7 == 0) goto L_0x01e8
            android.widget.TextView r12 = r11.f22189f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r3 = r11.f22184a
            int r5 = com.travel.bus.R.string.starting_from
            java.lang.String r3 = r3.getString(r5)
            r1.append(r3)
            java.lang.String r3 = " "
            r1.append(r3)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r12.setText(r1)
        L_0x01e8:
            boolean r12 = r11.j
            if (r12 == 0) goto L_0x0245
            android.widget.TextView r12 = r11.f22186c
            if (r12 == 0) goto L_0x028d
            if (r4 == 0) goto L_0x028d
            int r12 = r4.size()
            if (r12 <= 0) goto L_0x028d
            android.widget.TextView r12 = r11.f22186c
            android.content.Context r0 = r11.f22184a
            int r1 = com.travel.bus.R.string.show_less
            java.lang.String r0 = r0.getString(r1)
            r12.setText(r0)
            android.widget.TextView r12 = r11.f22189f
            r0 = 8
            r12.setVisibility(r0)
            android.view.ViewGroup r12 = r11.f22190g
            int r0 = com.travel.bus.R.drawable.travel_res_bus_shadow_left_right_normal_curved_top
            r12.setBackgroundResource(r0)
            android.content.Context r12 = r11.f22184a
            android.content.res.Resources r12 = r12.getResources()
            int r0 = com.travel.bus.R.dimen.dimen_12dp
            float r12 = r12.getDimension(r0)
            int r12 = (int) r12
            android.content.Context r0 = r11.f22184a
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.travel.bus.R.dimen.dimen_negative_5dp
            float r0 = r0.getDimension(r1)
            int r0 = (int) r0
            android.view.ViewGroup r1 = r11.f22191h
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r1.setMargins(r0, r0, r0, r12)
            android.view.ViewGroup r12 = r11.f22191h
            r12.setLayoutParams(r1)
            android.widget.ImageView r12 = r11.f22192i
            r0 = 1127481344(0x43340000, float:180.0)
            r12.setRotation(r0)
            goto L_0x028d
        L_0x0245:
            android.widget.TextView r12 = r11.f22186c
            if (r12 == 0) goto L_0x028d
            if (r4 == 0) goto L_0x028d
            int r12 = r4.size()
            if (r12 <= 0) goto L_0x028d
            int r12 = r4.size()
            java.lang.String r12 = com.travel.bus.busticket.e.n.a(r0, r12)
            android.widget.TextView r0 = r11.f22186c
            r0.setText(r12)
            android.widget.TextView r12 = r11.f22189f
            r12.setVisibility(r2)
            android.view.ViewGroup r12 = r11.f22190g
            int r0 = com.travel.bus.R.color.transparent
            r12.setBackgroundResource(r0)
            android.content.Context r12 = r11.f22184a
            android.content.res.Resources r12 = r12.getResources()
            int r0 = com.travel.bus.R.dimen.dimen_12dp
            float r12 = r12.getDimension(r0)
            int r12 = (int) r12
            android.view.ViewGroup r0 = r11.f22191h
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            r0.setMargins(r2, r2, r2, r12)
            android.view.ViewGroup r12 = r11.f22191h
            r12.setLayoutParams(r0)
            android.widget.ImageView r12 = r11.f22192i
            r0 = 0
            r12.setRotation(r0)
        L_0x028d:
            com.travel.bus.busticket.i.b r12 = new com.travel.bus.busticket.i.b
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRBusSearchItem> r0 = r10.f21782d
            java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.Integer>> r1 = r10.f21783e
            r12.<init>(r11, r0, r1)
            com.travel.bus.busticket.i.y r11 = com.travel.bus.busticket.i.y.f22482a
            com.travel.bus.busticket.i.y.a((java.lang.Object) r12)
        L_0x029b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.a.w.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(n nVar, int i2, View view) {
        this.f21786h = false;
        this.f21780b.onGroupViewClicked(nVar.j, i2);
        nVar.a();
    }

    public final int getItemCount() {
        ArrayList<CJRBusSearchItem> arrayList = this.f21782d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void a(ArrayList<CJRBusSearchItem> arrayList) {
        this.p = false;
        this.f21782d = arrayList;
        notifyDataSetChanged();
    }

    public final void b(ArrayList<CJRBusSearchItem> arrayList) {
        new StringBuilder("setData ").append(arrayList.size());
        com.paytm.utility.b.j();
        this.f21784f.clear();
        this.f21784f.addAll(arrayList);
        io.reactivex.rxjava3.a.b.a((Callable<?>) new Callable() {
            public final Object call() {
                return w.this.b();
            }
        }).b(io.reactivex.rxjava3.android.b.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object b() throws Exception {
        notifyDataSetChanged();
        return io.reactivex.rxjava3.a.b.a();
    }

    private ArrayList<Double> b(int i2) {
        ArrayList<Double> arrayList = new ArrayList<>();
        ArrayList<CJRBusSearchItem> a2 = a(i2);
        if (a2.size() > 0) {
            for (int i3 = 0; i3 < a2.size(); i3++) {
                if (!(a2.size() <= 0 || a2.get(i3) == null || a2.get(i3).getFare() == null)) {
                    double[] prices = a2.get(i3).getFare().getPrices();
                    for (double valueOf : prices) {
                        arrayList.add(Double.valueOf(valueOf));
                    }
                }
            }
            if (arrayList.size() > 0) {
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public final ArrayList<CJRBusSearchItem> a(int i2) {
        ArrayList<CJRBusSearchItem> arrayList = new ArrayList<>();
        ArrayList<CJRBusSearchItem> arrayList2 = this.f21782d;
        if (!(arrayList2 == null || arrayList2.size() <= i2 || this.f21782d.get(i2) == null || this.f21782d.get(i2).getOperatorGroupName() == null)) {
            ArrayList arrayList3 = this.f21783e.get(this.f21782d.get(i2).getOperatorGroupName());
            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                ArrayList<CJRBusSearchItem> arrayList4 = this.f21784f;
                if (arrayList4 != null && arrayList4.size() > 0 && ((Integer) arrayList3.get(i3)).intValue() < this.f21784f.size()) {
                    arrayList.add(this.f21784f.get(((Integer) arrayList3.get(i3)).intValue()));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(CJRBusSearchItem cJRBusSearchItem, CJRBusSearchItem cJRBusSearchItem2) {
        if (cJRBusSearchItem == null || cJRBusSearchItem2 == null || cJRBusSearchItem.getDepartureDatetime() == null || cJRBusSearchItem2.getDepartureDatetime() == null) {
            return 0;
        }
        return cJRBusSearchItem.getDepartureDatetime().compareTo(cJRBusSearchItem2.getDepartureDatetime());
    }

    private void c(int i2) {
        if (this.k) {
            ArrayList arrayList = new ArrayList();
            ArrayList<CJRBusSearchItem> arrayList2 = this.f21784f;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (int i3 = 0; i3 < this.f21784f.size(); i3++) {
                    CJRBusSearchItem cJRBusSearchItem = this.f21784f.get(i3);
                    if (!(cJRBusSearchItem == null || cJRBusSearchItem.getOperatorGroupName() == null || this.f21782d.get(i2).getOperatorGroupName() == null || !cJRBusSearchItem.getOperatorGroupName().equalsIgnoreCase(this.f21782d.get(i2).getOperatorGroupName()))) {
                        arrayList.add(Integer.valueOf(i3));
                        this.n.put(cJRBusSearchItem.getOperatorGroupName(), arrayList);
                    }
                }
                this.f21783e = this.n;
            }
        }
    }

    public final void c(ArrayList<CJRBusSearchItem> arrayList) {
        this.f21782d = arrayList;
        this.k = true;
        io.reactivex.rxjava3.a.b.a((Callable<?>) new Callable() {
            public final Object call() {
                return w.this.a();
            }
        }).b(io.reactivex.rxjava3.android.b.a.a()).a(io.reactivex.rxjava3.android.b.a.a()).c();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object a() throws Exception {
        notifyDataSetChanged();
        return io.reactivex.rxjava3.a.b.a();
    }

    public final ArrayList<CJRBusSearchItem> a(ArrayList<CJRBusSearchItem> arrayList, int i2) {
        ArrayList<CJRBusSearchItem> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        Iterator<CJRBusSearchItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRBusSearchItem next = it2.next();
            if (next.getFlag().getDeparted().booleanValue()) {
                if (next.getFlag().getDeparted().booleanValue()) {
                    arrayList4.add(next);
                }
            } else if (next == null || next.getBusRating() == null) {
                arrayList6.add(next);
            } else if (next.getBusRating().getAvgRating() >= 4.0d) {
                arrayList3.add(next);
            } else if (next.getBusRating().getAvgRating() >= 4.0d || next.getBusRating().getAvgRating() <= 0.0d) {
                arrayList6.add(next);
            } else {
                arrayList5.add(next);
            }
        }
        Collections.sort(arrayList3, new b(i2));
        Collections.sort(arrayList5, new b(i2));
        if (i2 == 0) {
            arrayList2.addAll(arrayList6);
            arrayList2.addAll(arrayList5);
            arrayList2.addAll(arrayList3);
            arrayList2.addAll(arrayList4);
        } else {
            arrayList2.addAll(arrayList3);
            arrayList2.addAll(arrayList5);
            arrayList2.addAll(arrayList6);
            arrayList2.addAll(arrayList4);
        }
        return arrayList2;
    }

    public class a implements Comparator<CJRBusSearchItem> {

        /* renamed from: b  reason: collision with root package name */
        private final int f21789b;

        /* renamed from: c  reason: collision with root package name */
        private final String f21790c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<CJRBusSearchItem> f21791d = new ArrayList<>();

        public a(String str, int i2, ArrayList<CJRBusSearchItem> arrayList) {
            this.f21790c = str;
            this.f21789b = i2;
            this.f21791d = arrayList;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public int compare(CJRBusSearchItem cJRBusSearchItem, CJRBusSearchItem cJRBusSearchItem2) {
            String str;
            int parseInt;
            int parseInt2;
            if (!(cJRBusSearchItem == null || cJRBusSearchItem2 == null || (str = this.f21790c) == null)) {
                try {
                    if (!str.equalsIgnoreCase("key_bus_search_sort_by_none")) {
                        if (this.f21790c.equalsIgnoreCase("departureTime")) {
                            if (!(cJRBusSearchItem.getDepartureDatetime() == null || cJRBusSearchItem2.getDepartureDatetime() == null)) {
                                if (this.f21789b == 0) {
                                    return Integer.parseInt(com.paytm.utility.b.a(cJRBusSearchItem.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "HHmm")) - Integer.parseInt(com.paytm.utility.b.a(cJRBusSearchItem2.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "HHmm"));
                                }
                                parseInt = Integer.parseInt(com.paytm.utility.b.a(cJRBusSearchItem.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "HHmm"));
                                parseInt2 = Integer.parseInt(com.paytm.utility.b.a(cJRBusSearchItem2.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "HHmm"));
                            }
                        } else if (this.f21790c.equalsIgnoreCase(AppConstants.DURATION)) {
                            if (!(cJRBusSearchItem.getDuration() == null || cJRBusSearchItem2.getDuration() == null)) {
                                if (this.f21789b == 0) {
                                    return Integer.parseInt(cJRBusSearchItem.getDuration()) - Integer.parseInt(cJRBusSearchItem2.getDuration());
                                }
                                parseInt = Integer.parseInt(cJRBusSearchItem.getDuration());
                                parseInt2 = Integer.parseInt(cJRBusSearchItem2.getDuration());
                            }
                        } else if (this.f21790c.equalsIgnoreCase("fare")) {
                            if (cJRBusSearchItem.getFare() != null && cJRBusSearchItem.getFare().getPrices().length > 0 && cJRBusSearchItem2.getFare() != null && cJRBusSearchItem2.getFare().getPrices().length > 0) {
                                Arrays.sort(cJRBusSearchItem.getFare().getPrices());
                                Arrays.sort(cJRBusSearchItem2.getFare().getPrices());
                                double d2 = cJRBusSearchItem.getFare().getPrices()[0];
                                double d3 = cJRBusSearchItem2.getFare().getPrices()[0];
                                if (this.f21789b == 0) {
                                    return Double.compare(d2, d3);
                                }
                                return -Double.compare(d2, d3);
                            }
                        } else if (!this.f21790c.equalsIgnoreCase("availability")) {
                            this.f21790c.equalsIgnoreCase("topRated");
                        } else if (!(cJRBusSearchItem.getAvalableSeats().intValue() == 0 || cJRBusSearchItem2.getAvalableSeats().intValue() == 0)) {
                            if (this.f21789b == 0) {
                                return Integer.compare(cJRBusSearchItem.getAvalableSeats().intValue(), cJRBusSearchItem2.getAvalableSeats().intValue());
                            }
                            return -Integer.compare(cJRBusSearchItem.getAvalableSeats().intValue(), cJRBusSearchItem2.getAvalableSeats().intValue());
                        }
                        return -(parseInt - parseInt2);
                    }
                } catch (NumberFormatException e2) {
                    q.c(e2.getMessage());
                }
            }
            return 0;
        }
    }

    class b implements Comparator<CJRBusSearchItem> {

        /* renamed from: b  reason: collision with root package name */
        private final int f21793b;

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            CJRBusSearchItem cJRBusSearchItem = (CJRBusSearchItem) obj;
            CJRBusSearchItem cJRBusSearchItem2 = (CJRBusSearchItem) obj2;
            if (this.f21793b == 0) {
                return Double.compare(cJRBusSearchItem.getBusRating().getAvgRating(), cJRBusSearchItem2.getBusRating().getAvgRating());
            }
            return -Double.compare(cJRBusSearchItem.getBusRating().getAvgRating(), cJRBusSearchItem2.getBusRating().getAvgRating());
        }

        b(int i2) {
            this.f21793b = i2;
        }
    }
}
