package com.travel.bus.busticket.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.k;
import com.travel.bus.busticket.a.q;
import com.travel.bus.busticket.a.x;
import com.travel.bus.busticket.b.c;
import com.travel.bus.busticket.c.c;
import com.travel.bus.busticket.f.f;
import com.travel.bus.busticket.f.g;
import com.travel.bus.busticket.fragment.h;
import com.travel.bus.busticket.fragment.i;
import com.travel.bus.busticket.fragment.j;
import com.travel.bus.busticket.g.e;
import com.travel.bus.busticket.i.o;
import com.travel.bus.busticket.i.w;
import com.travel.bus.pojo.bussearch.CJRBusBPDPCancellationPolicyItem;
import com.travel.bus.pojo.busticket.CJRBusCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusSearch;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRBusUserProfile;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRNewErrorFormat;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.Events;

public class AJRBusSelectSeatsActivity extends CJRActionBarBaseActivity implements View.OnClickListener, ViewPager.e, b, com.travel.bus.busticket.b.b, c, c.a, com.travel.bus.busticket.f.b, g, j.a {
    private Toast A;
    private TripBusDetail B;
    private RelativeLayout C;
    private Button D;
    private View E;
    private LinearLayout F;
    private LinearLayout G;
    private TextView H;
    private TextView I;
    private TextView J;
    private Button K;
    private e L;
    private CJRBusUserProfile M;
    private com.travel.bus.busticket.d.g N;
    private boolean O;
    private boolean P;
    private Runnable Q = new Runnable() {
        public final void run() {
            try {
                if (AJRBusSelectSeatsActivity.this.o != null) {
                    AJRBusSelectSeatsActivity.this.showInfoPopUp(AJRBusSelectSeatsActivity.this.o);
                    AJRBusSelectSeatsActivity.this.a();
                }
            } catch (Exception unused) {
            }
        }
    };
    private TabLayout.c R = new TabLayout.c() {
        public final void onTabReselected(TabLayout.f fVar) {
        }

        public final void onTabSelected(TabLayout.f fVar) {
            new StringBuilder("onTabSelected: displayed").append(fVar.f36765e);
            ((x) AJRBusSelectSeatsActivity.this.t.getAdapter()).a(fVar);
        }

        public final void onTabUnselected(TabLayout.f fVar) {
            new StringBuilder("onTabUnselected: displayed").append(fVar.f36765e);
            x xVar = (x) AJRBusSelectSeatsActivity.this.t.getAdapter();
            TextView textView = (TextView) fVar.f36766f.findViewById(R.id.tab_title);
            textView.setTextColor(androidx.core.content.b.c(xVar.f21795b, R.color.bus_tab_unselected_text));
            textView.setBackground(androidx.core.content.b.a(xVar.f21795b, R.drawable.travel_res_bus_rating_button_background_unpressed));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f21881a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21882b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21883c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21884d;

    /* renamed from: e  reason: collision with root package name */
    private int f21885e;

    /* renamed from: f  reason: collision with root package name */
    private CJRBusSearchInput f21886f;

    /* renamed from: g  reason: collision with root package name */
    private CJRBusSearchItem f21887g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, CJRBusSearchAmenitiesInfo> f21888h = null;

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, CJRBusSearchOperatorTagInfo> f21889i = null;
    private String j;
    private CJRNewErrorFormat k;
    private ArrayList<CJRPassengerDetails> l;
    private PopupWindow m;
    private q n;
    /* access modifiers changed from: private */
    public RelativeLayout o;
    private Handler p = new Handler();
    private i q;
    private h r;
    private ArrayList<TripBusDetailsItem> s;
    /* access modifiers changed from: private */
    public ViewPager t;
    private TabLayout u;
    private CJRLocation v = null;
    private CJRLocation w = null;
    private CJRBusSearch x;
    private String y;
    private x z;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final void i() {
    }

    public void onPageScrollStateChanged(int i2) {
    }

    public void onPageScrolled(int i2, float f2, int i3) {
    }

    public void attachBaseContext(Context context) {
        com.travel.utils.q.a(context);
        super.attachBaseContext(context);
        a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0149, code lost:
        if (r8 != 2) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016e, code lost:
        if (r8 != 1) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x018b, code lost:
        if (r8 != 1) goto L_0x018d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r19) {
        /*
            r18 = this;
            r11 = r18
            super.onCreate(r19)
            int r0 = com.travel.bus.R.id.content_frame
            android.view.View r0 = r11.findViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r11.mFrameLayout = r0
            android.widget.FrameLayout r0 = r11.mFrameLayout
            android.view.LayoutInflater r1 = r18.getLayoutInflater()
            int r2 = com.travel.bus.R.layout.pre_b_activity_select_seats
            r12 = 0
            android.view.View r1 = r1.inflate(r2, r12)
            r0.addView(r1)
            com.travel.bus.busticket.g.e r0 = new com.travel.bus.busticket.g.e
            r0.<init>(r11, r11)
            r11.L = r0
            com.travel.bus.busticket.d.g r0 = new com.travel.bus.busticket.d.g
            r0.<init>()
            r11.N = r0
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "paytmCommonApiListener"
            kotlin.g.b.k.c(r11, r0)
            com.travel.bus.busticket.i.n.a()
            com.travel.bus.pojo.common.entity.travel.a r0 = com.travel.bus.pojo.common.entity.travel.a.buses
            com.travel.bus.busticket.i.n.a(r11, r0, r11)
            r0 = 0
            r11.setBackButtonEnabled(r0)
            android.content.Intent r1 = r18.getIntent()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r11.s = r2
            r13 = 4
            java.lang.String r14 = "cancellation_policy"
            r10 = 2
            r9 = 1
            if (r1 == 0) goto L_0x01b2
            java.lang.String r2 = "intent_extra_bus_search_result_item"
            boolean r3 = r1.hasExtra(r2)
            if (r3 == 0) goto L_0x0099
            java.io.Serializable r2 = r1.getSerializableExtra(r2)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r2 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r2
            r11.f21887g = r2
            com.travel.bus.pojo.busticket.CJRBusSearchItem r2 = r11.f21887g
            if (r2 == 0) goto L_0x007e
            com.travel.bus.pojo.busticket.BusRatingModel r2 = r2.getBusRating()
            if (r2 == 0) goto L_0x007e
            com.travel.bus.pojo.busticket.CJRBusSearchItem r2 = r11.f21887g
            com.travel.bus.pojo.busticket.BusRatingModel r2 = r2.getBusRating()
            int r2 = r2.getCount()
            if (r2 <= 0) goto L_0x007e
            r11.f21882b = r9
            goto L_0x0080
        L_0x007e:
            r11.f21882b = r0
        L_0x0080:
            com.travel.bus.pojo.busticket.CJRBusSearchItem r2 = r11.f21887g
            java.util.ArrayList r2 = r2.getPhotos()
            if (r2 == 0) goto L_0x0096
            com.travel.bus.pojo.busticket.CJRBusSearchItem r2 = r11.f21887g
            java.util.ArrayList r2 = r2.getPhotos()
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0096
            r2 = 1
            goto L_0x0097
        L_0x0096:
            r2 = 0
        L_0x0097:
            r11.f21883c = r2
        L_0x0099:
            java.lang.String r2 = "amenity_info"
            boolean r3 = r1.hasExtra(r2)
            if (r3 == 0) goto L_0x00a9
            java.io.Serializable r2 = r1.getSerializableExtra(r2)
            java.util.HashMap r2 = (java.util.HashMap) r2
            r11.f21888h = r2
        L_0x00a9:
            java.lang.String r2 = "intent_extra_bus_search"
            boolean r3 = r1.hasExtra(r2)
            if (r3 == 0) goto L_0x00b7
            java.lang.String r2 = r1.getStringExtra(r2)
            r11.j = r2
        L_0x00b7:
            java.lang.String r2 = "intent_extra_bus_search_input"
            boolean r3 = r1.hasExtra(r2)
            if (r3 == 0) goto L_0x00c7
            java.io.Serializable r2 = r1.getSerializableExtra(r2)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r2 = (com.travel.bus.pojo.busticket.CJRBusSearchInput) r2
            r11.f21886f = r2
        L_0x00c7:
            java.lang.String r2 = "intent_extra_bus_search_ratings_key"
            boolean r2 = r1.hasExtra(r2)
            if (r2 == 0) goto L_0x0190
            java.lang.String r2 = "intent_extra_bus_search_ratings_key"
            java.lang.String r2 = r1.getStringExtra(r2)
            r11.y = r2
            java.lang.String r2 = r11.y
            boolean r3 = r11.f21882b
            boolean r4 = r11.f21883c
            java.lang.String r5 = "route"
            r6 = 743735278(0x2c547fee, float:3.0198027E-12)
            r7 = 108704329(0x67ab249, float:4.7150757E-35)
            r8 = -1
            if (r3 == 0) goto L_0x011c
            if (r4 == 0) goto L_0x011c
            int r3 = r2.hashCode()
            if (r3 == r7) goto L_0x010a
            if (r3 == r6) goto L_0x0102
            r4 = 983597686(0x3aa08276, float:0.0012245912)
            if (r3 == r4) goto L_0x00f8
            goto L_0x0111
        L_0x00f8:
            java.lang.String r3 = "ratings"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0111
            r8 = 0
            goto L_0x0111
        L_0x0102:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0111
            r8 = 2
            goto L_0x0111
        L_0x010a:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0111
            r8 = 1
        L_0x0111:
            if (r8 == 0) goto L_0x014e
            if (r8 == r9) goto L_0x014c
            if (r8 == r10) goto L_0x0119
            goto L_0x018d
        L_0x0119:
            r2 = 4
            goto L_0x018e
        L_0x011c:
            if (r3 == 0) goto L_0x0152
            int r3 = r2.hashCode()
            if (r3 == r7) goto L_0x013e
            if (r3 == r6) goto L_0x0136
            r4 = 983597686(0x3aa08276, float:0.0012245912)
            if (r3 == r4) goto L_0x012c
            goto L_0x0145
        L_0x012c:
            java.lang.String r3 = "ratings"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0145
            r8 = 0
            goto L_0x0145
        L_0x0136:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0145
            r8 = 2
            goto L_0x0145
        L_0x013e:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0145
            r8 = 1
        L_0x0145:
            if (r8 == 0) goto L_0x0150
            if (r8 == r9) goto L_0x014e
            if (r8 == r10) goto L_0x014c
            goto L_0x018d
        L_0x014c:
            r2 = 3
            goto L_0x018e
        L_0x014e:
            r2 = 2
            goto L_0x018e
        L_0x0150:
            r2 = 1
            goto L_0x018e
        L_0x0152:
            if (r4 == 0) goto L_0x0171
            int r3 = r2.hashCode()
            if (r3 == r7) goto L_0x0165
            if (r3 == r6) goto L_0x015d
            goto L_0x016c
        L_0x015d:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x016c
            r8 = 1
            goto L_0x016c
        L_0x0165:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x016c
            r8 = 0
        L_0x016c:
            if (r8 == 0) goto L_0x014e
            if (r8 == r9) goto L_0x014c
            goto L_0x018d
        L_0x0171:
            int r3 = r2.hashCode()
            if (r3 == r7) goto L_0x0182
            if (r3 == r6) goto L_0x017a
            goto L_0x0189
        L_0x017a:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0189
            r8 = 1
            goto L_0x0189
        L_0x0182:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0189
            r8 = 0
        L_0x0189:
            if (r8 == 0) goto L_0x0150
            if (r8 == r9) goto L_0x014e
        L_0x018d:
            r2 = 0
        L_0x018e:
            r11.f21885e = r2
        L_0x0190:
            java.lang.String r2 = "intent_extra_bus_search_load_data"
            boolean r2 = r1.hasExtra(r2)
            if (r2 == 0) goto L_0x01a2
            java.lang.String r2 = "intent_extra_bus_search_load_data"
            java.io.Serializable r2 = r1.getSerializableExtra(r2)
            java.util.HashMap r2 = (java.util.HashMap) r2
            r11.f21889i = r2
        L_0x01a2:
            java.lang.String r2 = "intent_extra_flag_bp_dp_required"
            boolean r2 = r1.hasExtra(r2)
            if (r2 == 0) goto L_0x01b2
            java.lang.String r2 = "intent_extra_flag_bp_dp_required"
            boolean r1 = r1.getBooleanExtra(r2, r0)
            r11.O = r1
        L_0x01b2:
            androidx.appcompat.app.ActionBar r1 = r11.mActionBar
            if (r1 != 0) goto L_0x01bc
            androidx.appcompat.app.ActionBar r1 = r18.getSupportActionBar()
            r11.mActionBar = r1
        L_0x01bc:
            androidx.appcompat.app.ActionBar r1 = r11.mActionBar
            r1.a((boolean) r0)
            androidx.appcompat.app.ActionBar r1 = r11.mActionBar
            r1.b((boolean) r0)
            androidx.appcompat.app.ActionBar r1 = r11.mActionBar
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.a((float) r2)
            androidx.appcompat.app.ActionBar r1 = r11.mActionBar
            int r2 = com.travel.bus.R.layout.pre_b_lyt_bus_seat_action_bar
            r1.a((int) r2)
            int r1 = com.travel.bus.R.id.bus_seat_title_text
            android.view.View r1 = r11.findViewById(r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            int r2 = com.travel.bus.R.id.bus_seat_subtitle_text
            android.view.View r2 = r11.findViewById(r2)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            com.travel.bus.pojo.busticket.CJRBusSearchItem r3 = r11.f21887g
            if (r3 == 0) goto L_0x0205
            java.lang.String r3 = r3.getTravelsName()
            if (r3 == 0) goto L_0x0205
            com.travel.bus.pojo.busticket.CJRBusSearchItem r3 = r11.f21887g
            java.lang.String r3 = r3.getTravelsName()
            java.lang.String r3 = r3.trim()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0205
            com.travel.bus.pojo.busticket.CJRBusSearchItem r3 = r11.f21887g
            java.lang.String r3 = r3.getTravelsName()
            goto L_0x020f
        L_0x0205:
            android.content.res.Resources r3 = r18.getResources()
            int r4 = com.travel.bus.R.string.select_seats_title
            java.lang.String r3 = r3.getString(r4)
        L_0x020f:
            r1.setText(r3)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = r11.f21887g
            if (r1 == 0) goto L_0x0244
            com.travel.bus.a.a()
            com.travel.g.a r1 = com.travel.bus.a.b()
            r1.D()
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = r11.f21887g
            java.lang.String r1 = r1.getDepartureDatetime()
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r4 = "HHmm"
            java.lang.String r1 = com.paytm.utility.b.d((java.lang.String) r1, (java.lang.String) r3, (java.lang.String) r4)
            java.lang.String r3 = "HHmm"
            java.lang.String r4 = "hh:mm aa"
            java.lang.String r1 = com.paytm.utility.b.e(r1, r3, r4)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r3 = r11.f21887g
            java.lang.String r1 = r1.trim()
            java.lang.String r1 = com.travel.bus.busticket.g.e.a((com.travel.bus.pojo.busticket.CJRBusSearchItem) r3, (java.lang.String) r1)
            r2.setText(r1)
        L_0x0244:
            int r1 = com.travel.bus.R.id.bus_seat_back_button
            android.view.View r1 = r11.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r2 = com.travel.bus.R.id.bus_seat_info_icon
            android.view.View r2 = r11.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r11.o = r2
            int r2 = r11.f21885e
            if (r2 != 0) goto L_0x0260
            android.widget.RelativeLayout r2 = r11.o
            r2.setVisibility(r0)
            goto L_0x0265
        L_0x0260:
            android.widget.RelativeLayout r2 = r11.o
            r2.setVisibility(r13)
        L_0x0265:
            r1.setOnClickListener(r11)
            android.widget.PopupWindow r1 = new android.widget.PopupWindow
            r1.<init>(r11)
            r11.m = r1
            android.widget.PopupWindow r1 = r11.m
            r1.setFocusable(r0)
            int r1 = com.travel.bus.R.id.proceed_root_layout
            android.view.View r1 = r11.findViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r11.C = r1
            int r1 = com.travel.bus.R.id.ladies_seat_info_layout_divider
            android.view.View r1 = r11.findViewById(r1)
            r11.E = r1
            int r1 = com.travel.bus.R.id.seat_root_layout
            android.view.View r1 = r11.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r11.F = r1
            int r1 = com.travel.bus.R.id.txt_selected_seats
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r11.H = r1
            int r1 = com.travel.bus.R.id.fare_root_layout
            android.view.View r1 = r11.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r11.G = r1
            int r1 = com.travel.bus.R.id.txt_total_fare
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r11.I = r1
            int r1 = com.travel.bus.R.id.btn_proceed
            android.view.View r1 = r11.findViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            r11.K = r1
            int r1 = com.travel.bus.R.id.txt_label_selected_seats
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r11.J = r1
            int r1 = com.travel.bus.R.id.proceed_to_select_seat
            android.view.View r1 = r11.findViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            r11.D = r1
            int r1 = com.travel.bus.R.id.txt_label_selected_seats
            android.view.View r1 = r11.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            int r2 = com.travel.bus.R.id.txt_label_total_fare
            android.view.View r2 = r11.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r18.getApplicationContext()
            android.widget.TextView r3 = r11.H
            com.paytm.utility.b.a((android.widget.TextView) r3)
            r18.getApplicationContext()
            android.widget.TextView r3 = r11.I
            com.paytm.utility.b.a((android.widget.TextView) r3)
            r18.getApplicationContext()
            com.paytm.utility.b.a((android.widget.TextView) r1)
            r18.getApplicationContext()
            com.paytm.utility.b.a((android.widget.TextView) r2)
            android.widget.Button r1 = r11.K
            r1.setClickable(r9)
            android.widget.Button r1 = r11.D
            r2 = 8
            r1.setVisibility(r2)
            int r1 = com.travel.bus.R.id.viewpager_bus_rating
            android.view.View r1 = r11.findViewById(r1)
            androidx.viewpager.widget.ViewPager r1 = (androidx.viewpager.widget.ViewPager) r1
            r11.t = r1
            androidx.viewpager.widget.ViewPager r1 = r11.t
            r1.setOffscreenPageLimit(r13)
            androidx.viewpager.widget.ViewPager r8 = r11.t
            com.travel.bus.busticket.a.x r7 = new com.travel.bus.busticket.a.x
            androidx.fragment.app.j r2 = r18.getSupportFragmentManager()
            com.travel.bus.pojo.busticket.CJRBusSearchItem r4 = r11.f21887g
            java.lang.String r5 = r11.j
            boolean r6 = r11.f21882b
            java.lang.String r3 = r11.y
            com.travel.bus.pojo.busticket.CJRBusSearchInput r1 = r11.f21886f
            java.util.HashMap<java.lang.String, com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo> r9 = r11.f21888h
            boolean r10 = r11.O
            r16 = r1
            r1 = r7
            r17 = r3
            r3 = r18
            r13 = r7
            r7 = r17
            r15 = r8
            r8 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.z = r13
            com.travel.bus.busticket.a.x r1 = r11.z
            r15.setAdapter(r1)
            r15.addOnPageChangeListener(r11)
            int r1 = com.travel.bus.R.id.tab_lyt_bus_rating
            android.view.View r1 = r11.findViewById(r1)
            com.google.android.material.tabs.TabLayout r1 = (com.google.android.material.tabs.TabLayout) r1
            r11.u = r1
            com.google.android.material.tabs.TabLayout r1 = r11.u
            r1.setSelectedTabIndicator((android.graphics.drawable.Drawable) r12)
            com.google.android.material.tabs.TabLayout r1 = r11.u
            androidx.viewpager.widget.ViewPager r2 = r11.t
            r1.setupWithViewPager(r2)
            com.google.android.material.tabs.TabLayout r1 = r11.u
            r1.setTabMode(r0)
            com.google.android.material.tabs.TabLayout r1 = r11.u
            r2 = 10
            int r2 = com.paytm.utility.b.c((int) r2)
            r3 = 10
            int r3 = com.paytm.utility.b.c((int) r3)
            com.travel.bus.busticket.i.e.a((com.google.android.material.tabs.TabLayout) r1, (int) r2, (int) r3)
            com.google.android.material.tabs.TabLayout r1 = r11.u
            r1.setTabGravity(r0)
            com.google.android.material.tabs.TabLayout r1 = r11.u
            r1.setTabRippleColor(r12)
            com.google.android.material.tabs.TabLayout r1 = r11.u
            com.google.android.material.tabs.TabLayout$c r2 = r11.R
            r1.a((com.google.android.material.tabs.TabLayout.b) r2)
            boolean r1 = r11.f21882b
            if (r1 == 0) goto L_0x03a6
            boolean r1 = r11.f21883c
            if (r1 == 0) goto L_0x03a6
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busSelectSeat
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r0)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busPhotos
            r2 = 1
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r2)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busReviews
            r3 = 2
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r3)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busRoute
            r3 = 3
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r3)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busCancellation
            r3 = 4
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r3)
            goto L_0x03eb
        L_0x03a6:
            r2 = 1
            r3 = 2
            boolean r1 = r11.f21882b
            if (r1 == 0) goto L_0x03c2
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busSelectSeat
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r0)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busReviews
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r2)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busRoute
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r3)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busCancellation
            r4 = 3
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r4)
            goto L_0x03eb
        L_0x03c2:
            r4 = 3
            boolean r1 = r11.f21883c
            if (r1 == 0) goto L_0x03dc
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busSelectSeat
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r0)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busPhotos
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r2)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busRoute
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r3)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busCancellation
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r4)
            goto L_0x03eb
        L_0x03dc:
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busSelectSeat
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r0)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busRoute
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r2)
            com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busCancellation
            r11.a((com.travel.bus.busticket.i.w) r1, (int) r3)
        L_0x03eb:
            int r1 = r11.f21885e
            if (r1 != 0) goto L_0x0402
            androidx.viewpager.widget.ViewPager r1 = r11.t
            androidx.viewpager.widget.a r1 = r1.getAdapter()
            com.travel.bus.busticket.a.x r1 = (com.travel.bus.busticket.a.x) r1
            com.google.android.material.tabs.TabLayout r3 = r11.u
            int r4 = r11.f21885e
            com.google.android.material.tabs.TabLayout$f r3 = r3.a((int) r4)
            r1.a((com.google.android.material.tabs.TabLayout.f) r3)
        L_0x0402:
            com.google.android.material.tabs.TabLayout r1 = r11.u
            int r3 = r11.f21885e
            com.google.android.material.tabs.TabLayout$f r1 = r1.a((int) r3)
            r1.d()
            androidx.viewpager.widget.ViewPager r1 = r11.t
            r1.addOnPageChangeListener(r11)
            java.lang.String r1 = r11.y
            if (r1 == 0) goto L_0x0425
            boolean r1 = r1.equalsIgnoreCase(r14)
            if (r1 == 0) goto L_0x0425
            int r1 = com.travel.bus.R.string.proceed_to_select_seat
            java.lang.String r1 = r11.getString(r1)
            r11.b((java.lang.String) r1)
        L_0x0425:
            android.widget.Button r1 = r11.K
            r1.setOnClickListener(r11)
            android.widget.Button r1 = r11.D
            r1.setOnClickListener(r11)
            android.widget.RelativeLayout r1 = r11.o
            r1.setOnClickListener(r11)
            int r1 = com.travel.bus.R.id.txt_ladies_seat_info     // Catch:{ Exception -> 0x045a }
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x045a }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x045a }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x045a }
            com.travel.g.a r3 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x045a }
            java.lang.String r3 = r3.a()     // Catch:{ Exception -> 0x045a }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x045a }
            if (r4 != 0) goto L_0x0454
            r1.setVisibility(r0)     // Catch:{ Exception -> 0x045a }
            r1.setText(r3)     // Catch:{ Exception -> 0x045a }
            goto L_0x0462
        L_0x0454:
            r0 = 8
            r1.setVisibility(r0)     // Catch:{ Exception -> 0x045a }
            goto L_0x0462
        L_0x045a:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0462:
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r11.f21887g
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFeature r0 = r0.getFeature()
            java.lang.Boolean r0 = r0.getCollectLocationPoints()
            if (r0 == 0) goto L_0x053a
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r11.f21887g
            com.travel.bus.pojo.bussearch.CJRBusSearchItemFeature r0 = r0.getFeature()
            java.lang.Boolean r0 = r0.getCollectLocationPoints()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x053a
            com.travel.bus.busticket.g.e r0 = r11.L
            com.travel.bus.pojo.busticket.CJRBusSearchItem r1 = r11.f21887g
            java.lang.String r3 = r11.j
            com.travel.bus.busticket.d.b r4 = r0.f22370a
            if (r4 != 0) goto L_0x048f
            com.travel.bus.busticket.d.b r4 = new com.travel.bus.busticket.d.b
            r4.<init>(r11, r0)
            r0.f22370a = r4
        L_0x048f:
            com.travel.bus.busticket.d.b r0 = r0.f22370a
            com.travel.bus.a.a()
            com.travel.g.a r4 = com.travel.bus.a.b()
            java.lang.String r5 = "travelBusDetailsURL"
            java.lang.String r4 = r4.f(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x04a7
            java.lang.String r4 = "https://travel.paytm.com/bus/v1/bus-details"
        L_0x04a7:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x053a
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = "Content-Type"
            java.lang.String r7 = "application/json"
            r5.put(r6, r7)
            org.json.JSONObject r1 = com.travel.bus.busticket.d.b.a((com.travel.bus.pojo.busticket.CJRBusSearchItem) r1, (java.lang.String) r3)
            boolean r6 = com.paytm.utility.b.c((android.content.Context) r18)
            if (r6 == 0) goto L_0x0523
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7 = 410(0x19a, float:5.75E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.add(r7)
            r7 = 422(0x1a6, float:5.91E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.add(r7)
            r7 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.add(r7)
            com.paytm.network.b r6 = new com.paytm.network.b
            r6.<init>()
            r6.f42877a = r11
            com.paytm.network.a$c r7 = com.paytm.network.a.c.BUS
            r6.f42878b = r7
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.POST
            r6.f42879c = r7
            r6.f42880d = r4
            java.lang.String r1 = r1.toString()
            r6.f42884h = r1
            r6.f42881e = r12
            r6.f42882f = r5
            r6.f42883g = r12
            com.travel.bus.pojo.bussearch.CJRBusBPDPCancellationPolicyItem r1 = new com.travel.bus.pojo.bussearch.CJRBusBPDPCancellationPolicyItem
            r1.<init>()
            r6.f42885i = r1
            r6.j = r0
            org.json.JSONObject r0 = com.travel.bus.busticket.d.b.a(r3)
            r6.t = r0
            com.paytm.network.a$b r0 = com.paytm.network.a.b.USER_FACING
            r6.n = r0
            java.lang.String r0 = "bus-srp-page"
            r6.o = r0
            com.paytm.network.a r0 = r6.l()
            r0.f42859c = r2
            r0.f42860d = r2
            r0.a()
            return
        L_0x0523:
            android.content.res.Resources r0 = r18.getResources()
            int r1 = com.travel.bus.R.string.no_connection
            java.lang.String r0 = r0.getString(r1)
            android.content.res.Resources r1 = r18.getResources()
            int r2 = com.travel.bus.R.string.no_internet
            java.lang.String r1 = r1.getString(r2)
            com.travel.bus.busticket.d.b.a(r11, r0, r1)
        L_0x053a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity.onCreate(android.os.Bundle):void");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Handler handler = this.p;
        if (handler != null && this.f21885e == 0) {
            handler.postDelayed(this.Q, 200);
        }
    }

    public final void a() {
        Handler handler = this.p;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public final void run() {
                    AJRBusSelectSeatsActivity.this.o();
                }
            }, 5000);
        }
    }

    public void showInfoPopUp(View view) {
        PopupWindow popupWindow;
        View view2;
        if (!isFinishing() && (popupWindow = this.m) != null) {
            popupWindow.dismiss();
            this.m.setBackgroundDrawable(new ColorDrawable(androidx.core.content.b.c(getApplicationContext(), 17170445)));
            LayoutInflater from = LayoutInflater.from(this);
            if (this.f21887g.getFlags() == null || !this.f21887g.getFlags().getSocialDistancingGuaranteed()) {
                view2 = from.inflate(R.layout.pre_b_bus_seat_info_layout, (ViewGroup) null);
            } else {
                view2 = from.inflate(R.layout.bus_seat_social_distancing_info, (ViewGroup) null);
            }
            this.m.setWidth(-1);
            this.m.setHeight(-1);
            this.m.setContentView(view2);
            this.m.setFocusable(true);
            this.m.showAsDropDown(view, 0, 15);
            view2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRBusSelectSeatsActivity.this.a(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.m.dismiss();
    }

    public final void b() {
        x xVar = this.z;
        if (xVar != null) {
            xVar.a(true);
        }
    }

    public final void c() {
        x xVar = this.z;
        if (xVar != null) {
            xVar.a(false);
        }
    }

    public final void d() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRBusSelectSeatsActivity.this.c(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i2) {
        String str;
        dialogInterface.cancel();
        CJRBusSearchItem cJRBusSearchItem = this.f21887g;
        if (cJRBusSearchItem != null && this.L != null) {
            String d2 = com.paytm.utility.b.d(cJRBusSearchItem.getDepartureDatetime(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
            e eVar = this.L;
            boolean c2 = com.paytm.utility.b.c((Context) this);
            String tripId = this.f21887g.getTripId();
            String valueOf = String.valueOf(this.f21887g.getOperatorObj().getProviderId());
            boolean z2 = this.f21884d;
            String str2 = this.j;
            com.travel.bus.a.a();
            if (com.travel.bus.a.b() != null) {
                com.travel.bus.a.a();
                if (com.travel.bus.a.b().f("busTripV2") != null) {
                    com.travel.bus.a.a();
                    str = com.travel.bus.a.b().c();
                    eVar.a(c2, this, tripId, valueOf, d2, z2, str2, str);
                }
            }
            str = null;
            eVar.a(c2, this, tripId, valueOf, d2, z2, str2, str);
        }
    }

    public final void e() {
        String string = getResources().getString(R.string.bus_maintenance_error_title);
        String string2 = getResources().getString(R.string.bus_maintenance_error_description);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(string).setMessage(string2).setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJRBusSelectSeatsActivity.this.b(dialogInterface, i2);
            }
        });
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent);
    }

    public final void a(String str, String str2, String str3) {
        o.a(this, str, str2, str3, (Intent) null, getLayoutInflater());
    }

    public final void f() {
        CJRBusSearchItem cJRBusSearchItem = this.f21887g;
        if (cJRBusSearchItem != null && cJRBusSearchItem.getConcessionString() != null && !this.f21887g.getConcessionString().toString().equalsIgnoreCase("undefined")) {
            this.f21887g.setConcessionEnabled(true);
        }
    }

    public final void a(TripBusDetail tripBusDetail) {
        com.travel.bus.busticket.fragment.c cVar = this.z.f21799f;
        h hVar = this.z.f21798e;
        if (tripBusDetail.getMeta() != null) {
            if (tripBusDetail.getMeta().getBoardingPoints() != null) {
                this.f21887g.setBoardingLocations(tripBusDetail.getMeta().getBoardingPoints());
            }
            if (tripBusDetail.getMeta().getDroppingPoints() != null) {
                this.f21887g.setDroppingLocations(tripBusDetail.getMeta().getDroppingPoints());
            }
            if (tripBusDetail.getMeta().getCancellationPolicy() != null) {
                this.f21887g.setCancellationPolicy(tripBusDetail.getMeta().getCancellationPolicy());
            }
            if (tripBusDetail.getMeta().getConcessionString() != null) {
                this.f21887g.setConcessionString(tripBusDetail.getMeta().getConcessionString());
            }
        }
        if (cVar != null) {
            cVar.a(tripBusDetail);
        }
        if (hVar != null) {
            hVar.a(tripBusDetail);
        }
        f();
        x xVar = this.z;
        if (xVar != null) {
            CJRBusSearchItem cJRBusSearchItem = this.f21887g;
            xVar.f21796c = null;
            xVar.f21794a = cJRBusSearchItem;
            xVar.a();
            x xVar2 = this.z;
            CJRBusSearchItem cJRBusSearchItem2 = this.f21887g;
            for (int i2 = 0; i2 < xVar2.f21797d.size(); i2++) {
                if (xVar2.a(i2) != null && (xVar2.a(i2) instanceof i)) {
                    ((f) xVar2.a(i2)).a(tripBusDetail);
                }
                if (xVar2.a(i2) != null && (xVar2.a(i2) instanceof h)) {
                    ((f) xVar2.a(i2)).a(cJRBusSearchItem2);
                }
                if (xVar2.a(i2) != null && (xVar2.a(i2) instanceof com.travel.bus.busticket.fragment.c)) {
                    f fVar = (f) xVar2.a(i2);
                    fVar.a(cJRBusSearchItem2);
                    fVar.a(tripBusDetail);
                }
            }
        }
        this.B = tripBusDetail;
    }

    public final void a(CJRBusBPDPCancellationPolicyItem cJRBusBPDPCancellationPolicyItem) {
        com.travel.bus.busticket.fragment.c cVar = this.z.f21799f;
        h hVar = this.z.f21798e;
        if (cVar != null) {
            List<CJRBusCancellationPolicy> cancellation_policy = cJRBusBPDPCancellationPolicyItem.getBody().getCancellation_policy();
            List<String> cancellation_policy_note_text = cJRBusBPDPCancellationPolicyItem.getBody().getCancellation_policy_note_text();
            if (cVar.f22227b == null || cVar.f22228c == null) {
                com.travel.bus.busticket.fragment.c.class.getSimpleName();
            } else {
                cVar.f22227b.setVisibility(4);
                cVar.f22229d = new k((ArrayList) cancellation_policy);
                cVar.f22226a.setAdapter(cVar.f22229d);
                cVar.f22228c.setVisibility(0);
                if (cancellation_policy_note_text != null && cancellation_policy_note_text.size() > 0) {
                    cVar.f22228c.setText(cancellation_policy_note_text.get(0));
                }
            }
        }
        if (hVar != null) {
            List<CJRLocation> boarding_points = cJRBusBPDPCancellationPolicyItem.getBody().getBoarding_points();
            List<CJRLocation> dropping_points = cJRBusBPDPCancellationPolicyItem.getBody().getDropping_points();
            if (hVar.f22265a != null) {
                hVar.f22265a.setDroppingLocations((ArrayList) dropping_points);
                hVar.f22265a.setBoardingLocations((ArrayList) boarding_points);
            }
            hVar.a((ArrayList<CJRLocation>) (ArrayList) dropping_points, false);
            hVar.a((ArrayList<CJRLocation>) (ArrayList) boarding_points, true);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        setBackButtonEnabled(false);
        return super.onPrepareOptionsMenu(menu);
    }

    public void onBackPressed() {
        PopupWindow popupWindow = this.m;
        if (popupWindow == null || !popupWindow.isShowing()) {
            super.onBackPressed();
        } else {
            o();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void o() {
        PopupWindow popupWindow = this.m;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.m.dismiss();
        }
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        o();
    }

    public final void g() {
        if (!(this.v == null || this.w == null)) {
            k();
            if (this.q != null) {
                this.z.f21796c.putBoolean("bundle_dropping_point", false);
            } else {
                return;
            }
        }
        this.u.a(0).d();
    }

    public final void a(CJRLocation cJRLocation, boolean z2) {
        TripBusDetail tripBusDetail = this.B;
        String name = (tripBusDetail == null || tripBusDetail.getMeta().getProvider() == null || this.B.getMeta().getProvider().getName() == null) ? null : this.B.getMeta().getProvider().getName();
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_boarding");
        if (z2) {
            hashMap.put("event_action", "board_point_selected");
        } else {
            hashMap.put("event_action", "drop_point_selected");
        }
        hashMap.put("event_label", cJRLocation.getLocationName());
        hashMap.put("event_label3", cJRLocation.getDistance());
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Boarding screen");
        hashMap.put("vertical_name", "bus");
        if (name != null) {
            hashMap.put("event_label2", name);
        }
        com.travel.bus.a.a();
        hashMap.put("user_id", com.paytm.utility.b.n(com.travel.bus.a.b().D()));
        com.travel.bus.a.a();
        com.travel.g.a b2 = com.travel.bus.a.b();
        com.travel.bus.a.a();
        b2.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, com.travel.bus.a.b().D());
    }

    public final void a(TripBusDetailsItem tripBusDetailsItem, View view) {
        k();
        i iVar = this.q;
        if (iVar != null && (iVar instanceof i)) {
            if (!(tripBusDetailsItem == null || iVar.m == null)) {
                if (tripBusDetailsItem.getFare() != null) {
                    if (tripBusDetailsItem.detailedFare == null) {
                        iVar.l = tripBusDetailsItem.getFare();
                    } else if (tripBusDetailsItem.detailedFare.bHasDeals()) {
                        iVar.l = String.valueOf(tripBusDetailsItem.detailedFare.getDeal().getRevisedBaseFare());
                    } else {
                        iVar.l = String.valueOf(tripBusDetailsItem.detailedFare.getBaseFare());
                    }
                }
                if (iVar.m.contains(tripBusDetailsItem)) {
                    iVar.m.remove(tripBusDetailsItem);
                } else {
                    if (iVar.m.size() > 1 && iVar.k) {
                        iVar.b();
                    }
                    if (!(iVar.f22274a == null || iVar.f22274a.getBody() == null || iVar.f22274a.getBody().size() <= 0)) {
                        iVar.f22275b = iVar.f22274a.getMeta().getMaxSeatAllowed().intValue();
                    }
                    if (iVar.m.size() >= iVar.f22275b) {
                        iVar.a(iVar.f22275b);
                    } else {
                        iVar.m.add(tripBusDetailsItem);
                        if (tripBusDetailsItem != null) {
                            try {
                                if (!TextUtils.isEmpty(tripBusDetailsItem.getSeatName())) {
                                    com.travel.bus.a.a();
                                    com.travel.bus.a.b().a("bus_seat_selected", "/bus-tickets/seat-selection", "SEAT_NUM", tripBusDetailsItem.getSeatName(), (Context) iVar.getActivity());
                                }
                            } catch (Exception e2) {
                                if (com.paytm.utility.b.v) {
                                    com.paytm.utility.q.c(e2.getMessage());
                                }
                            }
                        }
                    }
                }
            }
            if (!(iVar.f22276c == null || iVar.f22279f == null || iVar.f22276c.a(iVar.f22279f.getCurrentItem()) == null)) {
                ((j) iVar.f22276c.a(iVar.f22279f.getCurrentItem())).a(tripBusDetailsItem, view, "");
            }
            iVar.a();
        }
    }

    public final ArrayList<TripBusDetailsItem> h() {
        k();
        i iVar = this.q;
        if (iVar != null) {
            this.s = iVar.m;
        }
        return this.s;
    }

    public final void a(CJRLocation cJRLocation, CJRLocation cJRLocation2) {
        if (cJRLocation != null) {
            this.v = cJRLocation;
        }
        if (cJRLocation2 != null) {
            this.w = cJRLocation2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6) {
        /*
            r5 = this;
            r5.k()
            com.travel.bus.busticket.fragment.i r0 = r5.q
            if (r0 == 0) goto L_0x00a0
            boolean r1 = r0 instanceof com.travel.bus.busticket.fragment.i
            if (r1 == 0) goto L_0x00a0
            java.lang.String r1 = "All"
            boolean r1 = r6.equalsIgnoreCase(r1)
            java.lang.String r2 = "Lower"
            if (r1 == 0) goto L_0x001b
            android.widget.TextView r1 = r0.f22277d
            r1.setText(r2)
            goto L_0x0074
        L_0x001b:
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r1 = r0.f22280g
            int r1 = com.travel.bus.busticket.g.i.a(r6, r1)
            r0.f22282i = r1
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r1 = r0.f22281h
            int r1 = com.travel.bus.busticket.g.i.a(r6, r1)
            r0.j = r1
            int r1 = r0.f22282i
            java.lang.String r3 = ")"
            if (r1 == 0) goto L_0x004e
            android.widget.TextView r1 = r0.f22277d
            if (r1 == 0) goto L_0x004e
            android.widget.TextView r1 = r0.f22277d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Lower ("
            r2.<init>(r4)
            int r4 = r0.f22282i
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            goto L_0x0053
        L_0x004e:
            android.widget.TextView r1 = r0.f22277d
            r1.setText(r2)
        L_0x0053:
            int r1 = r0.j
            if (r1 == 0) goto L_0x0074
            android.widget.TextView r1 = r0.f22278e
            if (r1 == 0) goto L_0x0074
            android.widget.TextView r1 = r0.f22278e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Upper ("
            r2.<init>(r4)
            int r4 = r0.j
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            goto L_0x007b
        L_0x0074:
            android.widget.TextView r1 = r0.f22278e
            java.lang.String r2 = "Upper"
            r1.setText(r2)
        L_0x007b:
            com.travel.bus.busticket.a.ac r1 = r0.f22276c
            if (r1 == 0) goto L_0x00a0
            r1 = 0
        L_0x0080:
            com.travel.bus.busticket.a.ac r2 = r0.f22276c
            int r2 = r2.getCount()
            if (r1 >= r2) goto L_0x00a0
            com.travel.bus.busticket.a.ac r2 = r0.f22276c
            androidx.fragment.app.Fragment r2 = r2.a(r1)
            if (r2 == 0) goto L_0x009d
            com.travel.bus.busticket.a.ac r2 = r0.f22276c
            androidx.fragment.app.Fragment r2 = r2.a(r1)
            com.travel.bus.busticket.fragment.j r2 = (com.travel.bus.busticket.fragment.j) r2
            if (r2 == 0) goto L_0x009d
            r2.a((java.lang.String) r6)
        L_0x009d:
            int r1 = r1 + 1
            goto L_0x0080
        L_0x00a0:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "event_label"
            r0.put(r1, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            com.travel.bus.pojo.busticket.CJRBusSearchInput r1 = r5.f21886f
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r1 = r1.getSource()
            java.lang.String r1 = r1.getDisplayCityName()
            r6.append(r1)
            java.lang.String r1 = "/"
            r6.append(r1)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r1 = r5.f21886f
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r1 = r1.getDestination()
            java.lang.String r1 = r1.getDisplayCityName()
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r1 = "event_label2"
            r0.put(r1, r6)
            com.travel.bus.pojo.busticket.TripBusDetail r6 = r5.B
            if (r6 == 0) goto L_0x0108
            com.travel.bus.pojo.busticket.TripDetailsMeta r6 = r6.getMeta()
            com.travel.bus.pojo.busticket.TripDetailProvider r6 = r6.getProvider()
            if (r6 == 0) goto L_0x0108
            com.travel.bus.pojo.busticket.TripBusDetail r6 = r5.B
            com.travel.bus.pojo.busticket.TripDetailsMeta r6 = r6.getMeta()
            com.travel.bus.pojo.busticket.TripDetailProvider r6 = r6.getProvider()
            java.lang.String r6 = r6.getName()
            if (r6 == 0) goto L_0x0108
            com.travel.bus.pojo.busticket.TripBusDetail r6 = r5.B
            com.travel.bus.pojo.busticket.TripDetailsMeta r6 = r6.getMeta()
            com.travel.bus.pojo.busticket.TripDetailProvider r6 = r6.getProvider()
            java.lang.String r6 = r6.getName()
            java.lang.String r1 = "event_label3"
            r0.put(r1, r6)
        L_0x0108:
            java.lang.String r6 = com.paytm.utility.b.n((android.content.Context) r5)
            java.lang.String r1 = "userid"
            r0.put(r1, r6)
            com.travel.bus.a.a()
            java.lang.String r6 = "customEvent"
            java.lang.String r1 = "/bus-tickets-seatlayout"
            java.lang.String r2 = "bus_seat"
            java.lang.String r3 = "price_range_clicked"
            com.travel.bus.a.a(r6, r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity.a(java.lang.String):void");
    }

    private void k() {
        List<Fragment> d2 = getSupportFragmentManager().f3424a.d();
        if ((d2 != null || d2.size() <= 0) && d2 != null && d2.size() > 0) {
            for (int i2 = 0; i2 < d2.size(); i2++) {
                if (d2.get(i2) instanceof i) {
                    this.q = (i) d2.get(i2);
                }
                if (d2.get(i2) instanceof h) {
                    this.r = (h) d2.get(i2);
                }
            }
        }
    }

    private void l() {
        if (this.v == null || this.w == null) {
            k();
            h hVar = this.r;
            if (hVar != null && (hVar instanceof h)) {
                hVar.f22269e = this.s;
                if (this.v == null || this.f21881a) {
                    this.f21881a = false;
                    this.r.a(false, this.O);
                } else if (this.w == null) {
                    hVar.a(true, this.O);
                }
                this.u.a(com.travel.bus.busticket.i.e.a(w.busRoute, this.f21882b, this.f21883c)).d();
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a.b((Context) this);
        if (i2 == 2 && (i3 == -1 || i3 == 3)) {
            if (intent != null && intent.hasExtra("intent_extra_passenger_details")) {
                this.l = (ArrayList) intent.getSerializableExtra("intent_extra_passenger_details");
            }
        } else if (i3 == 9) {
            setResult(9);
            finish();
        }
    }

    private boolean m() {
        if (com.travel.bus.b.a.a(getApplicationContext()).b("sso_token=", "", true).length() > 0) {
            return true;
        }
        return false;
    }

    public final void a(ArrayList<Integer> arrayList, HashMap<String, CJRBusSearchAmenitiesInfo> hashMap) {
        com.travel.bus.busticket.fragment.a aVar = new com.travel.bus.busticket.fragment.a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("keyList", arrayList);
        bundle.putSerializable("amenity_info", hashMap);
        aVar.setArguments(bundle);
        aVar.show(getSupportFragmentManager(), "busAmenitiesListBottomDialogFragment");
    }

    public final void a(CJRNewErrorFormat cJRNewErrorFormat) {
        this.k = cJRNewErrorFormat;
        if (this.t != null && this.z != null) {
            o();
            this.D.setVisibility(8);
            x xVar = this.z;
            String str = this.k.getStatus().getMessage().f22819b;
            String str2 = this.k.getStatus().getMessage().f22820c;
            for (int i2 = 0; i2 < xVar.f21797d.size(); i2++) {
                if (xVar.a(i2) != null && !(xVar.a(i2) instanceof com.travel.bus.busticket.fragment.g)) {
                    ((f) xVar.a(i2)).a(str, str2);
                }
            }
        }
    }

    public final void a(String str, String str2, String str3, boolean z2, String str4) {
        String str5;
        if (this.L != null) {
            String d2 = com.paytm.utility.b.d(str3, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
            e eVar = this.L;
            boolean c2 = com.paytm.utility.b.c((Context) this);
            com.travel.bus.a.a();
            if (com.travel.bus.a.b() != null) {
                com.travel.bus.a.a();
                if (com.travel.bus.a.b().c() != null) {
                    com.travel.bus.a.a();
                    str5 = com.travel.bus.a.b().c();
                    eVar.a(c2, this, str, str2, d2, z2, str4, str5);
                }
            }
            str5 = null;
            eVar.a(c2, this, str, str2, d2, z2, str4, str5);
        }
    }

    public final void a(String str, String str2, boolean z2) {
        if (str != null && str2 != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(str).setMessage(str2).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener(z2) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRBusSelectSeatsActivity.this.a(this.f$1, dialogInterface, i2);
                }
            });
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        if (z2) {
            Intent intent = new Intent();
            intent.putExtra("trip_id", this.f21887g.getTripId());
            setResult(2, intent);
        }
        finish();
    }

    private void b(String str) {
        Button button = this.D;
        if (button != null) {
            button.setText(str);
        }
    }

    private void n() {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", "BusTicket");
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent, 1);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_proceed) {
            Toast toast = this.A;
            if (toast != null) {
                toast.cancel();
            }
            ArrayList<TripBusDetailsItem> arrayList = this.s;
            if (arrayList == null || arrayList.size() == 0) {
                this.A = Toast.makeText(getApplicationContext(), getString(R.string.bus_select_seat_message_revamp), 0);
                this.A.show();
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("event_label", this.H.getText().toString() + "&amp;" + this.s.size());
            hashMap.put("event_label2", this.f21886f.getSource().getDisplayCityName() + "/" + this.f21886f.getDestination().getDisplayCityName());
            TripBusDetail tripBusDetail = this.B;
            if (!(tripBusDetail == null || tripBusDetail.getMeta() == null || this.B.getMeta().getProvider() == null)) {
                hashMap.put("event_label3", this.B.getMeta().getProvider().getName());
            }
            hashMap.put("userid", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-seatlayout", "bus_seat", Events.Action.PROCEED_CLICKED, hashMap);
            e.a(this.s, this.B.getMeta().getProvider().getName());
            CJRBusSearchItem cJRBusSearchItem = this.f21887g;
            if (cJRBusSearchItem == null || cJRBusSearchItem.getBoardingLocations() == null || this.f21887g.getBoardingLocations().size() <= 0) {
                if (!m()) {
                    n();
                } else if (this.v != null && this.w != null) {
                    a(this.M);
                }
            } else if (!m()) {
                n();
            } else if (this.v == null || this.w == null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event_category", "bus_boarding");
                hashMap2.put("event_action", "screen_load");
                hashMap2.put("event_label", "seat_layout");
                hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-boarding");
                hashMap2.put("vertical_name", "bus");
                com.travel.bus.a.a();
                hashMap2.put("user_id", com.paytm.utility.b.n(com.travel.bus.a.b().D()));
                com.travel.bus.a.a();
                com.travel.g.a b2 = com.travel.bus.a.b();
                com.travel.bus.a.a();
                b2.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap2, com.travel.bus.a.b().D());
                l();
            } else {
                a(this.M);
            }
        } else if (id == R.id.proceed_to_select_seat) {
            k();
            ViewPager viewPager = this.t;
            if (viewPager != null) {
                int currentItem = viewPager.getCurrentItem();
                int a2 = com.travel.bus.busticket.i.e.a(w.busReviews, this.f21882b, this.f21883c);
                int a3 = com.travel.bus.busticket.i.e.a(w.busRoute, this.f21882b, this.f21883c);
                int a4 = com.travel.bus.busticket.i.e.a(w.busCancellation, this.f21882b, this.f21883c);
                if (currentItem == a2) {
                    a("Ratings &amp; Reviews", "proceed_to_select_seat");
                } else if (currentItem == a3) {
                    a("Boarding &amp; Drop Point", "proceed_to_select_seat");
                } else if (currentItem == a4) {
                    a("Cancellation Policy", "proceed_to_select_seat");
                }
                if (currentItem == a3) {
                    h hVar = this.r;
                    if (hVar != null && (hVar instanceof h)) {
                        hVar.f22269e = this.s;
                        if (hVar.f22265a != null) {
                            if (hVar.f22265a.getmItemType() != null) {
                                if (hVar.f22269e == null || hVar.f22269e.size() == 0) {
                                    if (!(hVar.f22266b == -1 && hVar.f22267c == -1) && (hVar.f22266b == -1 || hVar.f22267c == -1)) {
                                        if (hVar.f22266b != -1 || hVar.f22267c != -1) {
                                            hVar.a();
                                            return;
                                        }
                                        return;
                                    }
                                } else if (hVar.f22266b != -1 || hVar.f22267c != -1) {
                                    hVar.a();
                                    return;
                                } else {
                                    return;
                                }
                            } else if (hVar.f22266b == -1 || hVar.f22267c == -1) {
                                hVar.a();
                                return;
                            }
                            hVar.f22268d.g();
                        }
                    }
                } else if (!this.O || !(this.v == null || this.w == null)) {
                    this.u.a(0).d();
                } else {
                    l();
                }
            }
        } else if (id == R.id.bus_seat_back_button) {
            onBackPressed();
            HashMap hashMap3 = new HashMap();
            hashMap3.put("event_category", "bus_seat");
            hashMap3.put("event_action", "back_clicked");
            hashMap3.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-seatlayout");
            hashMap3.put("vertical_name", "bus");
            com.travel.bus.a.a();
            hashMap3.put("user_id", com.paytm.utility.b.n(com.travel.bus.a.b().D()));
            com.travel.bus.a.a();
            com.travel.g.a b3 = com.travel.bus.a.b();
            com.travel.bus.a.a();
            b3.a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap3, com.travel.bus.a.b().D());
        } else if (id == R.id.bus_seat_info_icon) {
            showInfoPopUp(view);
            HashMap hashMap4 = new HashMap();
            com.travel.bus.a.a();
            hashMap4.put("user_id", com.paytm.utility.b.n(com.travel.bus.a.b().D()));
            com.travel.bus.a.a();
            com.travel.g.a b4 = com.travel.bus.a.b();
            com.travel.bus.a.a();
            b4.a("bus_seat_info_icon_clicked", (Map<String, Object>) hashMap4, com.travel.bus.a.b().D());
            HashMap hashMap5 = new HashMap();
            hashMap5.put("event_label2", this.f21886f.getSource().getDisplayCityName() + "/" + this.f21886f.getDestination().getDisplayCityName());
            TripBusDetail tripBusDetail2 = this.B;
            if (!(tripBusDetail2 == null || tripBusDetail2.getMeta() == null || this.B.getMeta().getProvider() == null)) {
                hashMap5.put("event_label3", this.B.getMeta().getProvider().getName());
            }
            hashMap5.put("userid", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-seatlayout", "bus_seat", "info_icon_clicked", hashMap5);
        }
    }

    private void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", str);
        hashMap.put("event_label2", this.f21886f.getSource().getDisplayCityName() + "/" + this.f21886f.getDestination().getDisplayCityName());
        hashMap.put("event_label3", this.f21887g.getProviderOperatorName());
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-search", "bus_search", str2, hashMap);
    }

    private void a(int i2) {
        while (i2 > 0) {
            CJRPassengerDetails cJRPassengerDetails = new CJRPassengerDetails();
            cJRPassengerDetails.setSeatNumber("");
            cJRPassengerDetails.setPassengerage(0);
            cJRPassengerDetails.setPassengerName("");
            cJRPassengerDetails.setGender("");
            cJRPassengerDetails.setIsFirstPassenger(false);
            this.l.add(cJRPassengerDetails);
            i2--;
        }
    }

    private void a(CJRBusUserProfile cJRBusUserProfile) {
        Intent intent = new Intent(getApplicationContext(), AJRBusTravellerDetailsActivity.class);
        intent.putExtra("intent_extra_bus_search_input", this.f21886f);
        intent.putExtra("intent_extra_bus_search_result_item", this.f21887g);
        intent.putExtra("intent_extra_selected_seats", this.s);
        intent.putExtra("intent_extra_bus_search_load_data", this.x);
        intent.putExtra("intent_extra_bus_trip_detail", this.B);
        intent.putExtra("requestid", this.j);
        intent.putExtra("isSingleLady", this.f21884d);
        intent.putExtra("intent_extra_bus_search_load_data", this.f21889i);
        if (cJRBusUserProfile != null) {
            intent.putExtra("traveller_details_key", cJRBusUserProfile);
        }
        intent.putExtra("intent_extra_selected_boarding_point", this.v);
        intent.putExtra("intent_extra_selected_dropping_point", this.w);
        ArrayList<CJRPassengerDetails> arrayList = this.l;
        if (arrayList != null) {
            int size = arrayList.size();
            int size2 = this.s.size();
            if (size != size2) {
                if (size > size2) {
                    for (int i2 = size - size2; i2 > 0; i2--) {
                        ArrayList<CJRPassengerDetails> arrayList2 = this.l;
                        arrayList2.remove(arrayList2.size() - 1);
                    }
                } else {
                    a(size2 - size);
                }
            }
            intent.putExtra("intent_extra_passenger_details", this.l);
        }
        CJRLocation cJRLocation = this.v;
        if (cJRLocation != null) {
            intent.putExtra("intent_extra_selected_boarding_point", cJRLocation);
        }
        startActivityForResult(intent, 2);
    }

    public void onPageSelected(int i2) {
        x xVar;
        String str;
        k();
        h hVar = this.r;
        if (hVar != null && (hVar instanceof h)) {
            hVar.f22269e = this.s;
        }
        if (!this.P && this.O && (xVar = this.z) != null && (xVar.getItem(i2) instanceof i) && ((this.v == null || this.w == null) && this.k == null)) {
            CJRLocation cJRLocation = this.v;
            CJRLocation cJRLocation2 = this.w;
            if (cJRLocation == null && cJRLocation2 == null) {
                str = getString(R.string.bus_boarding_and_dropping_point_alert_message);
            } else if (cJRLocation == null) {
                str = getString(R.string.bus_boarding_point_alert_message);
            } else {
                str = getString(R.string.bus_dropping_point_alert_message);
            }
            this.P = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRBusSelectSeatsActivity.this.a(dialogInterface, i2);
                }
            });
            builder.show();
        }
        ViewPager viewPager = this.t;
        if (viewPager != null) {
            if (viewPager.getCurrentItem() == 0) {
                this.o.setVisibility(0);
            } else {
                this.o.setVisibility(4);
                ArrayList<TripBusDetailsItem> arrayList = this.s;
                if (arrayList == null || (arrayList.size() == 0 && this.k == null)) {
                    this.D.setVisibility(0);
                }
            }
            this.D.setVisibility(8);
        }
        x xVar2 = this.z;
        if (xVar2 == null || xVar2.a(i2) == null || !(this.z.a(i2) instanceof com.travel.bus.busticket.fragment.c)) {
            x xVar3 = this.z;
            if (xVar3 != null && xVar3.a(i2) != null) {
                b(getString(R.string.proceed_to_select_seat));
                return;
            }
            return;
        }
        b(getString(R.string.proceed_to_select_seat));
    }

    public void onStop() {
        super.onStop();
        o();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.v != null) {
            this.v = null;
        }
        if (this.w != null) {
            this.w = null;
        }
        TabLayout tabLayout = this.u;
        if (tabLayout != null) {
            tabLayout.b();
            this.u = null;
        }
        ViewPager viewPager = this.t;
        if (viewPager != null) {
            viewPager.setAdapter((androidx.viewpager.widget.a) null);
            this.t = null;
        }
        if (this.n != null) {
            this.n = null;
        }
        if (this.x != null) {
            this.x = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        if (this.m != null) {
            this.m = null;
        }
        if (this.q != null) {
            this.q = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        if (this.f21888h != null) {
            this.f21888h = null;
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRBusUserProfile) {
            this.M = (CJRBusUserProfile) iJRPaytmDataModel;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        this.P = false;
        l();
    }

    /* renamed from: com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21892a = new int[w.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.travel.bus.busticket.i.w[] r0 = com.travel.bus.busticket.i.w.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21892a = r0
                int[] r0 = f21892a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busSelectSeat     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f21892a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busPhotos     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f21892a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busReviews     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f21892a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busRoute     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f21892a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.travel.bus.busticket.i.w r1 = com.travel.bus.busticket.i.w.busCancellation     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRBusSelectSeatsActivity.AnonymousClass3.<clinit>():void");
        }
    }

    private void a(w wVar, int i2) {
        int i3 = AnonymousClass3.f21892a[wVar.ordinal()];
        if (i3 == 1) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.pre_b_bus_custom_tab, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tab_title);
            textView.setTextColor(androidx.core.content.b.c(this, R.color.bus_tab_color_select));
            textView.setBackground(androidx.core.content.b.a((Context) this, R.drawable.travel_res_bus_rating_button_background_unpressed));
            textView.setText(getString(R.string.bus_select_seat));
            this.u.a(i2).a(inflate);
        } else if (i3 == 2) {
            View inflate2 = LayoutInflater.from(this).inflate(R.layout.pre_b_bus_custom_tab, (ViewGroup) null);
            TextView textView2 = (TextView) inflate2.findViewById(R.id.tab_title);
            textView2.setTextColor(androidx.core.content.b.c(this, R.color.bus_tab_color_select));
            textView2.setBackground(androidx.core.content.b.a((Context) this, R.drawable.travel_res_bus_rating_button_background_unpressed));
            textView2.setText(getString(R.string.bus_photos));
            this.u.a(i2).a(inflate2);
        } else if (i3 == 3) {
            View inflate3 = LayoutInflater.from(this).inflate(R.layout.pre_b_bus_custom_tab, (ViewGroup) null);
            TextView textView3 = (TextView) inflate3.findViewById(R.id.tab_title);
            textView3.setTextColor(androidx.core.content.b.c(this, R.color.bus_tab_color_select));
            textView3.setBackground(androidx.core.content.b.a((Context) this, R.drawable.travel_res_bus_rating_button_background_unpressed));
            textView3.setText(getString(R.string.bus_review));
            this.u.a(i2).a(inflate3);
        } else if (i3 == 4) {
            View inflate4 = LayoutInflater.from(this).inflate(R.layout.pre_b_bus_custom_tab, (ViewGroup) null);
            TextView textView4 = (TextView) inflate4.findViewById(R.id.tab_title);
            textView4.setTextColor(androidx.core.content.b.c(this, R.color.bus_tab_color_select));
            textView4.setBackground(androidx.core.content.b.a((Context) this, R.drawable.travel_res_bus_rating_button_background_unpressed));
            textView4.setText(getString(R.string.boarding_and_drop_point));
            this.u.a(i2).a(inflate4);
        } else if (i3 == 5) {
            View inflate5 = LayoutInflater.from(this).inflate(R.layout.pre_b_bus_custom_tab, (ViewGroup) null);
            TextView textView5 = (TextView) inflate5.findViewById(R.id.tab_title);
            textView5.setTextColor(androidx.core.content.b.c(this, R.color.bus_tab_color_select));
            textView5.setBackground(androidx.core.content.b.a((Context) this, R.drawable.travel_res_bus_rating_button_background_unpressed));
            textView5.setText(getString(R.string.bus_concellation_policy));
            this.u.a(i2).a(inflate5);
        }
    }

    public final void a(String str, double d2, TripBusDetail tripBusDetail, boolean z2) {
        i iVar = this.q;
        if (iVar != null) {
            this.s = iVar.m;
        }
        ArrayList<TripBusDetailsItem> arrayList = this.s;
        if (arrayList == null || arrayList.size() <= 0) {
            this.C.setVisibility(8);
            q qVar = this.n;
            if (qVar != null) {
                qVar.a(false, "");
            }
            this.E.setVisibility(8);
            this.H.setText("");
            this.J.setText(getResources().getString(R.string.selected_seat));
            this.I.setText("");
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.K.setBackgroundResource(R.drawable.travel_res_bus_proceed_button_unselected);
        } else {
            this.C.setVisibility(0);
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            this.E.setVisibility(0);
            this.K.setBackgroundResource(R.drawable.travel_res_bus_proceed_button_selected);
            this.H.setText(str);
            if (this.s.size() == 1) {
                this.J.setText(getResources().getString(R.string.selected_seat));
            } else {
                this.J.setText(getResources().getString(R.string.selected_seats));
            }
            String a2 = com.paytm.utility.b.a(d2, "###,###,###.##");
            if (!TextUtils.isEmpty(a2)) {
                TextView textView = this.I;
                textView.setText(getResources().getString(R.string.rs) + " " + a2);
            } else {
                this.I.setText("");
            }
        }
        ArrayList<TripBusDetailsItem> arrayList2 = this.s;
        String string = getString((arrayList2 == null || arrayList2.size() <= 0) ? R.string.select_seats_title : R.string.proceed);
        Button button = this.K;
        if (button != null) {
            button.setText(string);
        }
        this.B = tripBusDetail;
        this.f21884d = z2;
    }
}
