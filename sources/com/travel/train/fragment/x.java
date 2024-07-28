package com.travel.train.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.al;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.a.a.b;
import com.travel.train.activity.AJRPNRSearch;
import com.travel.train.activity.AJRPNRStatus;
import com.travel.train.activity.AJRTrainHomeV2Activity;
import com.travel.train.b.am;
import com.travel.train.b.an;
import com.travel.train.i.t;
import com.travel.train.i.v;
import com.travel.train.j.l;
import com.travel.train.j.o;
import com.travel.train.k.d;
import com.travel.train.k.g;
import com.travel.train.model.trainticket.CJRBookings;
import com.travel.train.model.trainticket.CJRTrainRecentBooking;
import com.travel.train.model.trainticket.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class x extends am implements View.OnClickListener, t, v {

    /* renamed from: a  reason: collision with root package name */
    private String f27214a = "TAG_TRAIN_PNR_STATUS";

    /* renamed from: b  reason: collision with root package name */
    private h f27215b;

    /* renamed from: c  reason: collision with root package name */
    private an f27216c;

    /* renamed from: d  reason: collision with root package name */
    private am f27217d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<CJRBookings> f27218e;

    /* renamed from: f  reason: collision with root package name */
    private long f27219f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27220g = false;

    /* renamed from: h  reason: collision with root package name */
    private Fragment f27221h;

    /* renamed from: i  reason: collision with root package name */
    private al f27222i;
    private boolean j = false;
    /* access modifiers changed from: private */
    public TextView k;
    private EditText l;
    private ImageView m;
    private TextView n;
    private LinearLayout o;
    private TextView p;
    private RecyclerView q;
    private TextView r;
    private RecyclerView s;
    private NestedScrollView t;
    private CJRTrainRecentBooking u;
    private ArrayList<h> v;
    private d w;
    private ViewTreeObserver.OnScrollChangedListener x;
    private boolean y;

    public static x a(Bundle bundle) {
        x xVar = new x();
        xVar.setArguments(bundle);
        return xVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.train_pnr_fragment, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null && getArguments().containsKey("train_recent_bookings")) {
            this.u = (CJRTrainRecentBooking) getArguments().get("train_recent_bookings");
        }
        this.l = (EditText) view.findViewById(R.id.pnr_number);
        this.m = (ImageView) view.findViewById(R.id.pnr_close_icon);
        this.k = (TextView) view.findViewById(R.id.pnr_check_txt);
        this.r = (TextView) view.findViewById(R.id.recent_pnr_title);
        this.s = (RecyclerView) view.findViewById(R.id.recent_pnr_list);
        this.p = (TextView) view.findViewById(R.id.upcoming_trip_title);
        this.q = (RecyclerView) view.findViewById(R.id.upcoming_trips_list);
        this.o = (LinearLayout) view.findViewById(R.id.where_is_pnr_container);
        this.n = (TextView) view.findViewById(R.id.where_is_pnr_text);
        this.n.setText(Html.fromHtml(getString(R.string.how_to_find_my_pnr)));
        this.t = (NestedScrollView) view.findViewById(R.id.nested_scroll_view);
        if (!(getActivity() instanceof AJRTrainHomeV2Activity)) {
            this.l.setOnClickListener(this);
        }
        this.k.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.s.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        this.l.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() != 10) {
                    x.this.k.setVisibility(8);
                } else {
                    x.this.k.setVisibility(0);
                }
            }
        });
        d();
        if (getActivity() != null) {
            this.w = (d) androidx.lifecycle.am.a(getActivity(), (al.b) new g(new g.a(g.b.V2_HOME).a(a.a((b) new com.travel.train.a.a.a(getActivity()))))).a(d.class);
        }
        d dVar = this.w;
        if (dVar != null) {
            dVar.j.observe(this, new z() {
                public final void onChanged(Object obj) {
                    x.this.a((CJRTrainRecentBooking) obj);
                }
            });
        }
        CJRTrainRecentBooking cJRTrainRecentBooking = this.u;
        if (cJRTrainRecentBooking != null) {
            this.w.a(cJRTrainRecentBooking);
        }
        b();
        c();
        if (getUserVisibleHint()) {
            f();
            a();
        }
        this.x = new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                x.this.g();
            }
        };
        this.t.getViewTreeObserver().addOnScrollChangedListener(this.x);
        this.f27219f = System.currentTimeMillis();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r0 = getChildFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setUserVisibleHint(boolean r4) {
        /*
            r3 = this;
            super.setUserVisibleHint(r4)
            r3.f27220g = r4
            boolean r0 = r3.f27220g
            if (r0 == 0) goto L_0x000d
            r3.f()
            goto L_0x0029
        L_0x000d:
            boolean r0 = r3.isAdded()
            if (r0 == 0) goto L_0x0029
            androidx.fragment.app.j r0 = r3.getChildFragmentManager()
            java.lang.String r1 = r3.f27214a
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
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.x.setUserVisibleHint(boolean):void");
    }

    private void a() {
        if (!this.j) {
            this.j = true;
            o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "check_pnr_clicked", "/trains", getActivity(), (Map<String, Object>) null);
        }
    }

    private void b() {
        this.v = l.a().f27576a;
    }

    private void c() {
        ArrayList<h> arrayList = this.v;
        if (arrayList == null || arrayList.size() <= 0) {
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.s.setVisibility(0);
        this.f27217d = new am(getActivity(), this.v, this);
        this.s.setAdapter(this.f27217d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRTrainRecentBooking cJRTrainRecentBooking) {
        if (cJRTrainRecentBooking != null) {
            this.u = cJRTrainRecentBooking;
            CJRTrainRecentBooking cJRTrainRecentBooking2 = this.u;
            if (cJRTrainRecentBooking2 != null && cJRTrainRecentBooking2 != null && cJRTrainRecentBooking2.getRecentBookingBody() != null && cJRTrainRecentBooking2.getRecentBookingBody().getmBookingsList().size() > 0) {
                this.f27218e = cJRTrainRecentBooking2.getRecentBookingBody().getmBookingsList();
                ArrayList<CJRBookings> arrayList = this.f27218e;
                if (arrayList == null || arrayList.size() <= 0) {
                    this.p.setVisibility(8);
                    this.q.setVisibility(8);
                    return;
                }
                this.p.setVisibility(0);
                this.q.setVisibility(0);
                this.f27216c = new an(getActivity(), this.f27218e, this);
                this.q.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
                this.q.setAdapter(this.f27216c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        NestedScrollView nestedScrollView = this.t;
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getBottom() - (this.t.getHeight() + this.t.getScrollY()) == 0) {
            if (this.f27221h != null) {
                boolean z = false;
                if (System.currentTimeMillis() - this.f27219f > 1000) {
                    this.f27219f = System.currentTimeMillis();
                    z = true;
                }
                if (z) {
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(this.f27221h);
                }
            }
        } else if (this.f27221h != null) {
            com.travel.train.b.a();
            com.travel.train.b.b().b(this.f27221h);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.x != null && this.t.getViewTreeObserver() != null && this.t.getViewTreeObserver().isAlive()) {
            this.t.getViewTreeObserver().removeOnScrollChangedListener(this.x);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.y = true;
        super.onSaveInstanceState(bundle);
    }

    public void onResume() {
        super.onResume();
        this.y = false;
        if (this.f27220g) {
            d();
        }
    }

    private void d() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("train_home_pnr_no_pref", 0);
        String string = sharedPreferences.getString("pnr", (String) null);
        String string2 = sharedPreferences.getString("from_pnr", (String) null);
        String string3 = sharedPreferences.getString("to_pnr", (String) null);
        String string4 = sharedPreferences.getString("date_pnr", (String) null);
        if (TextUtils.isEmpty(string) || string.trim().length() != 10) {
            this.m.setVisibility(8);
            return;
        }
        this.f27215b = new h();
        this.f27215b.setPNRNumber(string);
        this.f27215b.setFrom(string2);
        this.f27215b.setTo(string3);
        this.f27215b.setDate(string4);
        this.l.setText(string);
        EditText editText = this.l;
        editText.setSelection(editText.getText().length());
        this.m.setVisibility(0);
    }

    public final void a(CJRBookings cJRBookings) {
        if (cJRBookings != null) {
            this.f27215b = new h();
            if (!TextUtils.isEmpty(cJRBookings.getmPNRNumber())) {
                this.l.setText(cJRBookings.getmPNRNumber());
                EditText editText = this.l;
                editText.setSelection(editText.getText().length());
                this.f27215b.setPNRNumber(cJRBookings.getmPNRNumber());
            }
            if (!TextUtils.isEmpty(cJRBookings.getmBoardingStationName())) {
                this.f27215b.setFrom(cJRBookings.getmBoardingStationName());
            }
            if (!TextUtils.isEmpty(cJRBookings.getmReservationUpToStationName())) {
                this.f27215b.setTo(cJRBookings.getmReservationUpToStationName());
            }
            if (!TextUtils.isEmpty(cJRBookings.getmBoardingDate())) {
                this.f27215b.setDate(cJRBookings.getmBoardingDate());
            }
            e();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pnr_check_txt) {
            e();
        } else if (id == R.id.pnr_number) {
            Intent intent = new Intent(getActivity(), AJRPNRSearch.class);
            intent.putExtra("intent_extra_train_upcoming_trips", this.f27218e);
            startActivity(intent);
        } else if (id == R.id.pnr_close_icon) {
            this.l.setText("");
        } else if (id == R.id.where_is_pnr_container) {
            al alVar = this.f27222i;
            if (alVar == null || !alVar.isVisible()) {
                if (this.f27222i == null) {
                    this.f27222i = new al();
                }
                if (!this.f27222i.isVisible()) {
                    this.f27222i.show(getChildFragmentManager(), al.class.getSimpleName());
                }
            }
        }
    }

    private void e() {
        CJRTrainRecentBooking cJRTrainRecentBooking;
        EditText editText = this.l;
        if (editText != null && !TextUtils.isEmpty(editText.getText().toString())) {
            Intent intent = new Intent(getActivity(), AJRPNRStatus.class);
            if (!(!com.paytm.utility.b.r((Context) getActivity()) || (cJRTrainRecentBooking = this.u) == null || cJRTrainRecentBooking.getRecentBookingBody() == null || this.u.getRecentBookingBody().getmBookingsList() == null || this.u.getRecentBookingBody().getmBookingsList().size() <= 0)) {
                intent.putExtra("intent_extra_pnr_list", this.u.getRecentBookingBody().getmBookingsList());
            }
            intent.putExtra("pnr_from_page", "pnr_home");
            intent.putExtra("pnr_number", this.l.getText().toString());
            intent.putExtra("pnr_item_model", this.f27215b);
            startActivityForResult(intent, 570);
        }
    }

    private void f() {
        if (!this.y && isAdded()) {
            this.f27221h = getChildFragmentManager().c(this.f27214a);
            Fragment fragment = this.f27221h;
            if (fragment == null || !fragment.isAdded()) {
                com.travel.train.b.a();
                this.f27221h = com.travel.train.b.b().a((WeakReference<View>) new WeakReference(this.t));
                Bundle bundle = new Bundle();
                bundle.putBoolean("bundle_extra_clp_parallax_animation_required", false);
                bundle.putBoolean("bundle_extra_secondary_home_user_visible", false);
                bundle.putBoolean(CLPConstants.EXTRA_INTENT_TAB_POSITION_FIRST, true);
                bundle.putString("origin", "train");
                bundle.putString("store_front_url_key", "trainPNRStoreFrontURL");
                bundle.putBoolean("trigger-impression-on-visibility", true);
                this.f27221h.setArguments(bundle);
                getChildFragmentManager().a().b(R.id.framelayout_storefront_train_pnr, this.f27221h, this.f27214a).b();
            }
        }
    }

    public final void a(Object obj) {
        if (!(obj instanceof CJRBookings)) {
            h hVar = (h) obj;
            Intent intent = new Intent(getActivity(), AJRPNRStatus.class);
            intent.putExtra("pnr_number", hVar.getPNRNumber());
            intent.putExtra("pnr_from_page", "pnr_home");
            if (hVar != null) {
                intent.putExtra("pnr_item_model", hVar);
            }
            CJRTrainRecentBooking cJRTrainRecentBooking = this.u;
            if (!(cJRTrainRecentBooking == null || cJRTrainRecentBooking.getRecentBookingBody() == null || this.u.getRecentBookingBody().getmBookingsList() == null || this.u.getRecentBookingBody().getmBookingsList().size() <= 0)) {
                intent.putExtra("intent_extra_pnr_list", this.u.getRecentBookingBody().getmBookingsList());
            }
            startActivityForResult(intent, 570);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 570) {
            b();
            c();
        }
    }
}
