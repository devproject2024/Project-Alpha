package com.travel.train.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.a.a.b;
import com.travel.train.activity.AJRLSSearchTrains;
import com.travel.train.activity.AJRTrainLiveStatus;
import com.travel.train.b.ag;
import com.travel.train.i.n;
import com.travel.train.i.s;
import com.travel.train.j.o;
import com.travel.train.k.d;
import com.travel.train.k.e;
import com.travel.train.k.g;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.model.trainticket.CJRTrainLSSearchResult;
import com.travel.train.model.trainticket.CJRTrainLsDateModel;
import com.travel.train.model.trainticket.CJRTrainRecentBooking;
import com.travel.train.viewholder.ay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public class u extends am implements View.OnClickListener, n, s {
    private String A;
    private String B;
    private String C;
    private String D;
    private boolean E;
    private String F = "FJRTrainLiveStatusFragment";

    /* renamed from: a  reason: collision with root package name */
    private String f27171a = "TAG_TRAIN_LIVE_STATUS";

    /* renamed from: b  reason: collision with root package name */
    private TextView f27172b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f27173c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f27174d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f27175e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f27176f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f27177g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f27178h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f27179i;
    private Button j;
    private RecyclerView k;
    private View l;
    private boolean m = false;
    private ag n;
    private CJRTrainLSSearchResult.Train o;
    private CJRTrainLsDateModel p;
    private ArrayList<CJRBookings> q;
    private af r = null;
    private boolean s = false;
    private NestedScrollView t;
    private long u;
    private Fragment v;
    private ViewTreeObserver.OnScrollChangedListener w;
    private e x;
    private d y;
    private CJRTrainRecentBooking z;

    public static u a(Bundle bundle) {
        u uVar = new u();
        uVar.setArguments(bundle);
        return uVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.train_live_status_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null && getArguments().containsKey("train_recent_bookings")) {
            this.z = (CJRTrainRecentBooking) getArguments().get("train_recent_bookings");
        }
        this.j = (Button) view.findViewById(R.id.proceed_btn);
        this.k = (RecyclerView) view.findViewById(R.id.dates_recyler_view);
        this.f27172b = (TextView) view.findViewById(R.id.looking_for_trains_txt);
        this.f27174d = (TextView) view.findViewById(R.id.train_name_txt);
        this.f27173c = (TextView) view.findViewById(R.id.train_no_txt);
        this.f27176f = (TextView) view.findViewById(R.id.tell_us_your_boarding_point_txt);
        this.f27175e = (TextView) view.findViewById(R.id.boarding_point_txt);
        this.f27179i = (LinearLayout) view.findViewById(R.id.dates_lyt);
        this.l = view.findViewById(R.id.view1);
        this.f27177g = (LinearLayout) view.findViewById(R.id.train_info_lyt);
        this.f27178h = (LinearLayout) view.findViewById(R.id.boarding_point_info_lyt);
        this.t = (NestedScrollView) view.findViewById(R.id.nested_scroll_view);
        this.f27178h.setOnClickListener(this);
        this.f27177g.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.j.setText(getActivity().getString(R.string.train_check_live_status));
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("train_ls_home_recent_searched_pref", 0);
        this.A = sharedPreferences.getString("trainName", "");
        this.B = sharedPreferences.getString("trainNumber", "");
        this.C = sharedPreferences.getString("boardingPointStnName", "");
        this.D = sharedPreferences.getString("boardingPointStnCode", "");
        if (!TextUtils.isEmpty(this.A) && !TextUtils.isEmpty(this.A) && !TextUtils.isEmpty(this.C) && !TextUtils.isEmpty(this.D)) {
            this.f27174d.setText(this.A);
            this.f27173c.setText(this.B);
            TextView textView = this.f27175e;
            textView.setText(this.D + " - " + this.C);
        }
        if (getActivity() != null) {
            this.x = (e) am.a((Fragment) this, (al.b) new g(new g.a(g.b.LIVE_STATUS).a(a.a((b) new com.travel.train.a.a.a(getActivity()))))).a(e.class);
            e eVar = this.x;
            String str = this.A;
            String str2 = this.B;
            String str3 = this.C;
            String str4 = this.D;
            k.c(str, "trainName");
            k.c(str2, "trainNumber");
            k.c(str3, "boardingPointStnName");
            k.c(str4, "boardingPointStnCode");
            eVar.f27650a = str;
            eVar.f27651b = str2;
            eVar.f27652c = str3;
            eVar.f27653d = str4;
            this.y = (d) am.a(getActivity(), (al.b) new g(new g.a(g.b.V2_HOME).a(a.a((b) new com.travel.train.a.a.a(getActivity()))))).a(d.class);
            CJRTrainRecentBooking cJRTrainRecentBooking = this.z;
            if (cJRTrainRecentBooking != null) {
                this.y.a(cJRTrainRecentBooking);
            }
        }
        e eVar2 = this.x;
        if (eVar2 != null) {
            eVar2.f27657h.observe(this, new z() {
                public final void onChanged(Object obj) {
                    u.this.a(((Boolean) obj).booleanValue());
                }
            });
            this.x.f27658i.observe(this, new z() {
                public final void onChanged(Object obj) {
                    u.this.a((CJRTrainLSSearchResult.Train) obj);
                }
            });
            this.x.k.observe(this, new z() {
                public final void onChanged(Object obj) {
                    u.this.a((ArrayList<CJRTrainLsDateModel>) (ArrayList) obj);
                }
            });
            this.x.l.observe(this, new z() {
                public final void onChanged(Object obj) {
                    u.this.c(((Boolean) obj).booleanValue());
                }
            });
            this.x.m.observe(this, new z() {
                public final void onChanged(Object obj) {
                    u.this.b(((Boolean) obj).booleanValue());
                }
            });
            e eVar3 = this.x;
            HashMap<String, String> b2 = com.travel.train.j.n.b(getContext());
            k.c(b2, H5Logger.HEADER);
            if (!TextUtils.isEmpty(eVar3.f27651b) && !TextUtils.isEmpty(eVar3.f27651b) && !TextUtils.isEmpty(eVar3.f27652c) && !TextUtils.isEmpty(eVar3.f27653d)) {
                eVar3.f27655f = eVar3.f27653d;
                com.paytm.network.listener.b bVar = eVar3;
                eVar3.n.a(bVar, bVar, b2, eVar3.f27651b);
            }
        }
        d dVar = this.y;
        if (dVar != null) {
            dVar.j.observe(this, new z() {
                public final void onChanged(Object obj) {
                    u.this.a((CJRTrainRecentBooking) obj);
                }
            });
        }
        CJRTrainRecentBooking cJRTrainRecentBooking2 = this.z;
        if (cJRTrainRecentBooking2 != null) {
            this.y.a(cJRTrainRecentBooking2);
        }
        if (getUserVisibleHint()) {
            b();
            a();
        }
        this.w = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                u.this.c();
            }
        };
        this.t.getViewTreeObserver().addOnScrollChangedListener(this.w);
        this.u = System.currentTimeMillis();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.E = true;
        super.onSaveInstanceState(bundle);
    }

    public void onResume() {
        this.E = false;
        super.onResume();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r0 = getChildFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setUserVisibleHint(boolean r4) {
        /*
            r3 = this;
            super.setUserVisibleHint(r4)
            r3.s = r4
            boolean r0 = r3.s
            if (r0 == 0) goto L_0x000d
            r3.b()
            goto L_0x0029
        L_0x000d:
            boolean r0 = r3.isAdded()
            if (r0 == 0) goto L_0x0029
            androidx.fragment.app.j r0 = r3.getChildFragmentManager()
            java.lang.String r1 = r3.f27171a
            androidx.fragment.app.Fragment r1 = r0.c((java.lang.String) r1)
            if (r1 == 0) goto L_0x0029
            androidx.fragment.app.q r2 = r0.a()
            r2.a((androidx.fragment.app.Fragment) r1)
            r0.b()
        L_0x0029:
            if (r4 == 0) goto L_0x0034
            boolean r4 = r3.isAdded()
            if (r4 == 0) goto L_0x0034
            r3.a()
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.u.setUserVisibleHint(boolean):void");
    }

    private void a() {
        if (!this.m) {
            this.m = true;
            o.a("train_live_status", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "live_status_clicked", "/trains", getActivity(), (Map<String, Object>) null);
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRTrainRecentBooking cJRTrainRecentBooking) {
        if (cJRTrainRecentBooking != null && cJRTrainRecentBooking.getRecentBookingBody() != null && cJRTrainRecentBooking.getRecentBookingBody().getmBookingsList().size() > 0) {
            this.q = cJRTrainRecentBooking.getRecentBookingBody().getmBookingsList();
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRTrainLSSearchResult.Train train) {
        this.o = train;
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            this.f27179i.setVisibility(0);
            this.f27172b.setVisibility(8);
            this.f27176f.setVisibility(8);
            this.f27173c.setVisibility(0);
            this.f27174d.setVisibility(0);
            this.f27175e.setVisibility(0);
            this.l.setVisibility(0);
            this.f27178h.setVisibility(0);
            this.j.setVisibility(0);
            return;
        }
        this.f27179i.setVisibility(8);
        this.f27172b.setVisibility(0);
        this.f27176f.setVisibility(0);
        this.f27173c.setVisibility(8);
        this.f27174d.setVisibility(8);
        this.f27175e.setVisibility(8);
        this.l.setVisibility(8);
        this.f27178h.setVisibility(8);
        this.j.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        NestedScrollView nestedScrollView = this.t;
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getBottom() - (this.t.getHeight() + this.t.getScrollY()) == 0) {
            if (this.v != null) {
                boolean z2 = false;
                if (System.currentTimeMillis() - this.u > 1000) {
                    this.u = System.currentTimeMillis();
                    z2 = true;
                }
                if (z2) {
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(this.v);
                }
            }
        } else if (this.v != null) {
            com.travel.train.b.a();
            com.travel.train.b.b().b(this.v);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.w != null && this.t.getViewTreeObserver() != null && this.t.getViewTreeObserver().isAlive()) {
            this.t.getViewTreeObserver().removeOnScrollChangedListener(this.w);
        }
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<CJRTrainLsDateModel> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            int a2 = this.x.a(arrayList);
            this.p = arrayList.get(a2);
            this.n = new ag(getActivity(), arrayList, a2, this);
            this.k.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            this.k.setAdapter(this.n);
        }
    }

    public final void a(CJRTrainLsDateModel cJRTrainLsDateModel, ay ayVar) {
        this.p = cJRTrainLsDateModel;
        ag agVar = this.n;
        if (agVar.f26207b != null) {
            agVar.f26207b.f27893a.setBackground(androidx.core.content.b.a(agVar.f26206a, R.drawable.pre_t_train_train_date_bg_unselect));
            agVar.f26207b.f27896d.setTextColor(agVar.f26206a.getResources().getColor(R.color.color_979797));
            agVar.f26207b.f27897e.setTextColor(agVar.f26206a.getResources().getColor(R.color.color_979797));
        }
        agVar.f26207b = ayVar;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.proceed_btn) {
            if (this.o == null) {
                a(getResources().getString(R.string.train_select_a_train));
            } else if (this.x.j.getValue() == null) {
                a(getResources().getString(R.string.train_select_boarding_station));
            } else if (this.p == null) {
                a(getResources().getString(R.string.train_select_date));
            } else {
                Intent intent = new Intent(getActivity(), AJRTrainLiveStatus.class);
                intent.putExtra("intent_extra_train_selected_number", this.o.getTrainNumber());
                intent.putExtra("intent_extra_train_selected_name", this.o.getTrainName());
                intent.putExtra("intent_extra_bp_selected_stn_name", ((CJRTrainLSSearchResult.Schedule) this.x.j.getValue()).getStationName());
                intent.putExtra("intent_extra_bp_selected_stn_code", ((CJRTrainLSSearchResult.Schedule) this.x.j.getValue()).getStationCode());
                intent.putExtra("intent_extra_selected_ls_date", this.p.getDate_str());
                intent.putExtra("intent_extra_is_upcoming_trip", false);
                startActivity(intent);
            }
        } else if (id == R.id.train_info_lyt) {
            Intent intent2 = new Intent(getActivity(), AJRLSSearchTrains.class);
            intent2.putExtra("intent_extra_from_search_by_train", false);
            intent2.putExtra("intent_extra_train_upcoming_trips", this.q);
            getActivity().startActivityForResult(intent2, 191);
        } else if (id == R.id.boarding_point_info_lyt) {
            b(true);
        }
    }

    private void a(String str) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(str);
            builder.setCancelable(true);
            builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [java.io.Serializable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /*
            r2 = this;
            super.onActivityResult(r3, r4, r5)
            r4 = 191(0xbf, float:2.68E-43)
            if (r3 == r4) goto L_0x0008
            goto L_0x006b
        L_0x0008:
            if (r5 == 0) goto L_0x006b
            java.lang.String r3 = "intent_extra_train_selected"
            java.io.Serializable r4 = r5.getSerializableExtra(r3)
            r0 = 0
            if (r4 == 0) goto L_0x001a
            java.io.Serializable r3 = r5.getSerializableExtra(r3)
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r3 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Train) r3
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            java.lang.String r4 = "intent_extra_bp_selected"
            java.io.Serializable r1 = r5.getSerializableExtra(r4)
            if (r1 == 0) goto L_0x002a
            java.io.Serializable r4 = r5.getSerializableExtra(r4)
            r0 = r4
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule r0 = (com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule) r0
        L_0x002a:
            java.lang.String r4 = "intent_extra_server_ist"
            java.io.Serializable r1 = r5.getSerializableExtra(r4)
            if (r1 == 0) goto L_0x0037
            java.lang.String r4 = r5.getStringExtra(r4)
            goto L_0x0039
        L_0x0037:
            java.lang.String r4 = ""
        L_0x0039:
            com.travel.train.k.e r5 = r2.x
            java.lang.String r1 = "selectedTrain"
            kotlin.g.b.k.c(r3, r1)
            java.lang.String r1 = "schedule"
            kotlin.g.b.k.c(r0, r1)
            java.lang.String r1 = "dateIST"
            kotlin.g.b.k.c(r4, r1)
            r5.f27654e = r3
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train> r3 = r5.f27658i
            com.travel.train.model.trainticket.CJRTrainLSSearchResult$Train r1 = r5.f27654e
            r3.setValue(r1)
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule> r3 = r5.j
            r3.setValue(r0)
            r5.f27656g = r4
            androidx.lifecycle.y<java.lang.Boolean> r3 = r5.l
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r3.setValue(r4)
            androidx.lifecycle.y<java.lang.Boolean> r3 = r5.f27657h
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r3.setValue(r4)
            r5.a()
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.u.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        CJRTrainLSSearchResult.Train train = this.o;
        if (train == null) {
            a(getResources().getString(R.string.train_select_a_train));
            return;
        }
        af afVar = this.r;
        if (afVar == null || !afVar.isVisible()) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("intent_extra_train_selected", train);
            af afVar2 = this.r;
            if (afVar2 == null) {
                this.r = af.a(bundle);
                this.r.a((n) this);
            } else {
                afVar2.setArguments(bundle);
            }
            this.r.show(getChildFragmentManager(), af.class.getName());
        }
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        CJRTrainLSSearchResult.Train train = this.o;
        if (train != null) {
            if (!TextUtils.isEmpty(train.getTrainName())) {
                this.f27174d.setText(this.o.getTrainName());
            }
            if (!TextUtils.isEmpty(this.o.getTrainNumber())) {
                this.f27173c.setText(this.o.getTrainNumber());
            }
        }
        if (this.x.j.getValue() != null && !TextUtils.isEmpty(((CJRTrainLSSearchResult.Schedule) this.x.j.getValue()).getStationName()) && !TextUtils.isEmpty(((CJRTrainLSSearchResult.Schedule) this.x.j.getValue()).getStationCode())) {
            TextView textView = this.f27175e;
            textView.setText(((CJRTrainLSSearchResult.Schedule) this.x.j.getValue()).getStationCode() + " - " + ((CJRTrainLSSearchResult.Schedule) this.x.j.getValue()).getStationName());
        }
    }

    private void b() {
        if (!this.E && isAdded()) {
            this.v = getChildFragmentManager().c(this.f27171a);
            Fragment fragment = this.v;
            if (fragment == null || !fragment.isAdded()) {
                com.travel.train.b.a();
                this.v = com.travel.train.b.b().a((WeakReference<View>) new WeakReference(this.t));
                Bundle bundle = new Bundle();
                bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
                bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
                bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
                bundle.putString("origin", "train");
                bundle.putString("store_front_url_key", "trainLiveStatusStoreFrontURL");
                bundle.putBoolean("trigger-impression-on-visibility", true);
                this.v.setArguments(bundle);
                getChildFragmentManager().a().b(R.id.framelayout_storefront_train_ls, this.v, this.f27171a).b();
            }
        }
    }

    public final void a(CJRTrainLSSearchResult.Schedule schedule) {
        e eVar = this.x;
        k.c(schedule, "schedule");
        eVar.j.setValue(schedule);
        eVar.l.setValue(Boolean.TRUE);
        eVar.f27657h.setValue(Boolean.TRUE);
        eVar.a();
    }
}
