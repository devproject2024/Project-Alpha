package com.travel.train.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.common.a;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainSearchActivity;
import com.travel.train.activity.AJRTrainSelectCityActivity;
import com.travel.train.b;
import com.travel.train.fragment.l;
import com.travel.train.j.i;
import com.travel.train.j.m;
import com.travel.train.j.n;
import com.travel.train.j.x;
import com.travel.train.k.c;
import com.travel.train.k.d;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainBookingInformation;
import com.travel.train.model.trainticket.CJRTrainCity;
import com.travel.train.model.trainticket.CJRTrainHolidayList;
import com.travel.train.model.trainticket.CJRTrainOriginCityItem;
import com.travel.train.model.trainticket.CJRTrainQuickBookFavourites;
import com.travel.train.model.trainticket.CJRTrainRecentBooking;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import com.travel.train.model.trainticket.CJRTrainRouteStations;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.g;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class o extends am implements View.OnClickListener, l.a {
    private RoboTextView A;
    private Button B;
    private ImageView C;
    private ImageView D;
    private LinearLayout E;
    private LinearLayout F;
    private View G;
    /* access modifiers changed from: private */
    public CheckBox H;
    private Animation I;
    private Animation J;
    private Animation K;
    private Animation L;
    private Animation M;
    private String N = null;
    private String O;
    private String P;
    private String Q;
    private String R;
    private boolean S = false;
    private boolean T = false;
    private long U = 0;
    private long V;
    private int W;
    private int X;
    private String Y;
    private CJRTrainCity Z = new CJRTrainCity();

    /* renamed from: a  reason: collision with root package name */
    public boolean f27079a = false;
    private ImageView aA;
    private String aB = "FJRTrainBookingFragment";
    /* access modifiers changed from: private */
    public ArrayList<g> aa = new ArrayList<>();
    private CJRTrainSearchInput ab;
    private Handler ac;
    /* access modifiers changed from: private */
    public l ad;
    private CJRTrainSearchResults ae;
    private CJRTrainBookingInformation af;
    private CJRTrainHolidayList ag;
    private CJRTrainQuickBookFavourites ah;
    private CJRTrainRecentBooking ai;
    private String aj = "";
    private boolean ak = false;
    private boolean al = false;
    private CJRHomePageItem am;
    private c an = null;
    private d ao;
    private List<CJRTrainRecentsItemModel> ap = null;
    private CJRTrainRecentsItemModel aq = null;
    private NestedScrollView ar;
    private long as;
    private Fragment at;
    private int au;
    private boolean av = false;
    private boolean aw = false;
    private boolean ax;
    private ViewTreeObserver.OnScrollChangedListener ay;
    private boolean az = false;

    /* renamed from: b  reason: collision with root package name */
    private String f27080b = "TAG_TRAIN_BOOK_TICKETS";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f27081c = "Show Trains with both non-AC and AC coaches";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f27082d = "Show Trains with Non AC coaches";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f27083e = "Show Trains with AC coaches";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f27084f = "train-animation-fragment";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f27085g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f27086h;

    /* renamed from: i  reason: collision with root package name */
    private final int f27087i = 500;
    private final int j = 700;
    private int k = 0;
    private int l = 0;
    private ConstraintLayout m;
    private ConstraintLayout n;
    private ConstraintLayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private RoboTextView v;
    private RoboTextView w;
    private RoboTextView x;
    private RoboTextView y;
    private RoboTextView z;

    public boolean onBackPressed() {
        return false;
    }

    public static o a(Bundle bundle) {
        o oVar = new o();
        oVar.setArguments(bundle);
        return oVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pre_t_train_booking_fragment_viewpager_item, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x046b  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x047e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x04b6  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x04c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r13, android.os.Bundle r14) {
        /*
            r12 = this;
            super.onViewCreated(r13, r14)
            android.os.Bundle r14 = r12.getArguments()
            r0 = 1
            r1 = 0
            if (r14 == 0) goto L_0x00a4
            java.lang.String r2 = "train_booking_from_srp"
            boolean r3 = r14.containsKey(r2)
            if (r3 == 0) goto L_0x001a
            boolean r2 = r14.getBoolean(r2, r1)
            r12.ak = r2
        L_0x001a:
            java.lang.String r2 = "From"
            boolean r3 = r14.containsKey(r2)
            if (r3 == 0) goto L_0x0028
            java.lang.String r2 = r14.getString(r2)
            r12.aj = r2
        L_0x0028:
            java.lang.String r2 = "extra_home_data"
            boolean r3 = r14.containsKey(r2)
            if (r3 == 0) goto L_0x0042
            java.io.Serializable r3 = r14.getSerializable(r2)
            boolean r3 = r3 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem
            if (r3 == 0) goto L_0x0042
            r12.al = r0
            java.io.Serializable r14 = r14.getSerializable(r2)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r14 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r14
            r12.am = r14
        L_0x0042:
            android.os.Bundle r14 = r12.getArguments()
            java.lang.String r2 = "train_booking_information"
            boolean r14 = r14.containsKey(r2)
            if (r14 == 0) goto L_0x005b
            android.os.Bundle r14 = r12.getArguments()
            java.lang.Object r14 = r14.get(r2)
            com.travel.train.model.trainticket.CJRTrainBookingInformation r14 = (com.travel.train.model.trainticket.CJRTrainBookingInformation) r14
            r12.af = r14
        L_0x005b:
            android.os.Bundle r14 = r12.getArguments()
            java.lang.String r2 = "extra_intent_holiday_list"
            boolean r14 = r14.containsKey(r2)
            if (r14 == 0) goto L_0x0073
            android.os.Bundle r14 = r12.getArguments()
            java.lang.Object r14 = r14.get(r2)
            com.travel.train.model.trainticket.CJRTrainHolidayList r14 = (com.travel.train.model.trainticket.CJRTrainHolidayList) r14
            r12.ag = r14
        L_0x0073:
            android.os.Bundle r14 = r12.getArguments()
            java.lang.String r2 = "intent_extra_train_fav"
            boolean r14 = r14.containsKey(r2)
            if (r14 == 0) goto L_0x008b
            android.os.Bundle r14 = r12.getArguments()
            java.lang.Object r14 = r14.get(r2)
            com.travel.train.model.trainticket.CJRTrainQuickBookFavourites r14 = (com.travel.train.model.trainticket.CJRTrainQuickBookFavourites) r14
            r12.ah = r14
        L_0x008b:
            android.os.Bundle r14 = r12.getArguments()
            java.lang.String r2 = "train_recent_bookings"
            boolean r14 = r14.containsKey(r2)
            if (r14 == 0) goto L_0x00a4
            android.os.Bundle r14 = r12.getArguments()
            java.lang.Object r14 = r14.get(r2)
            com.travel.train.model.trainticket.CJRTrainRecentBooking r14 = (com.travel.train.model.trainticket.CJRTrainRecentBooking) r14
            r12.ai = r14
        L_0x00a4:
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            r2 = 0
            if (r14 == 0) goto L_0x0129
            com.travel.train.k.g r14 = new com.travel.train.k.g
            com.travel.train.k.g$a r3 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r4 = com.travel.train.k.g.b.BOOKING
            r3.<init>(r4)
            com.travel.train.a.a.a r4 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r5 = r12.getActivity()
            r4.<init>(r5)
            com.travel.train.a.a r4 = com.travel.train.a.a.a((com.travel.train.a.a.b) r4)
            com.travel.train.k.g$a r3 = r3.a(r4)
            boolean r4 = r12.ak
            r3.f27667b = r4
            r14.<init>(r3)
            androidx.fragment.app.FragmentActivity r3 = r12.getActivity()
            androidx.lifecycle.al r14 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r3, (androidx.lifecycle.al.b) r14)
            java.lang.Class<com.travel.train.k.c> r3 = com.travel.train.k.c.class
            androidx.lifecycle.ai r14 = r14.a(r3)
            com.travel.train.k.c r14 = (com.travel.train.k.c) r14
            r12.an = r14
            com.travel.train.k.c r14 = r12.an
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r14 = r14.f27634e
            r14.postValue(r2)
            com.travel.train.k.c r14 = r12.an
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r14 = r14.f27635f
            r14.postValue(r2)
            com.travel.train.k.c r14 = r12.an
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r14 = r14.f27637h
            r14.postValue(r2)
            com.travel.train.k.c r14 = r12.an
            com.travel.train.l.c r14 = r14.f27636g
            r14.postValue(r2)
            com.travel.train.k.g r14 = new com.travel.train.k.g
            com.travel.train.k.g$a r3 = new com.travel.train.k.g$a
            com.travel.train.k.g$b r4 = com.travel.train.k.g.b.V2_HOME
            r3.<init>(r4)
            com.travel.train.a.a.a r4 = new com.travel.train.a.a.a
            androidx.fragment.app.FragmentActivity r5 = r12.getActivity()
            r4.<init>(r5)
            com.travel.train.a.a r4 = com.travel.train.a.a.a((com.travel.train.a.a.b) r4)
            com.travel.train.k.g$a r3 = r3.a(r4)
            r14.<init>(r3)
            androidx.fragment.app.FragmentActivity r3 = r12.getActivity()
            androidx.lifecycle.al r14 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r3, (androidx.lifecycle.al.b) r14)
            java.lang.Class<com.travel.train.k.d> r3 = com.travel.train.k.d.class
            androidx.lifecycle.ai r14 = r14.a(r3)
            com.travel.train.k.d r14 = (com.travel.train.k.d) r14
            r12.ao = r14
        L_0x0129:
            int r14 = com.travel.train.R.id.search_by_station
            android.view.View r14 = r13.findViewById(r14)
            r14.setVisibility(r1)
            int r14 = com.travel.train.R.id.search_by_train
            android.view.View r14 = r13.findViewById(r14)
            r3 = 8
            r14.setVisibility(r3)
            int r14 = com.travel.train.R.id.trainTypeFilter
            android.view.View r14 = r13.findViewById(r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            r12.F = r14
            int r14 = com.travel.train.R.id.cal_divider
            android.view.View r14 = r13.findViewById(r14)
            r12.G = r14
            int r14 = com.travel.train.R.id.radio_train_type
            android.view.View r14 = r13.findViewById(r14)
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            r12.H = r14
            int r14 = com.travel.train.R.id.source_lyt
            android.view.View r14 = r13.findViewById(r14)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r12.m = r14
            androidx.constraintlayout.widget.ConstraintLayout r14 = r12.m
            int r4 = com.travel.train.R.id.input_city_code
            android.view.View r14 = r14.findViewById(r4)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r12.p = r14
            androidx.constraintlayout.widget.ConstraintLayout r14 = r12.m
            int r4 = com.travel.train.R.id.input_full_name
            android.view.View r14 = r14.findViewById(r4)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r12.r = r14
            androidx.constraintlayout.widget.ConstraintLayout r14 = r12.m
            int r4 = com.travel.train.R.id.input_unselected
            android.view.View r14 = r14.findViewById(r4)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            r12.z = r14
            int r14 = com.travel.train.R.id.destination_lyt
            android.view.View r14 = r13.findViewById(r14)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r12.n = r14
            androidx.constraintlayout.widget.ConstraintLayout r14 = r12.n
            int r4 = com.travel.train.R.id.input_city_code
            android.view.View r14 = r14.findViewById(r4)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r12.q = r14
            androidx.constraintlayout.widget.ConstraintLayout r14 = r12.n
            int r4 = com.travel.train.R.id.input_full_name
            android.view.View r14 = r14.findViewById(r4)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r12.s = r14
            androidx.constraintlayout.widget.ConstraintLayout r14 = r12.n
            int r4 = com.travel.train.R.id.input_unselected
            android.view.View r14 = r14.findViewById(r4)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            r12.A = r14
            com.paytm.utility.RoboTextView r14 = r12.A
            androidx.fragment.app.FragmentActivity r4 = r12.getActivity()
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.travel.train.R.string.destination_metro_station
            java.lang.String r4 = r4.getString(r5)
            r14.setHint(r4)
            int r14 = com.travel.train.R.id.proceed_btn
            android.view.View r14 = r13.findViewById(r14)
            android.widget.Button r14 = (android.widget.Button) r14
            r12.B = r14
            int r14 = com.travel.train.R.id.sep_route
            android.view.View r14 = r13.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r12.C = r14
            android.widget.ImageView r14 = r12.C
            r14.setEnabled(r1)
            int r14 = com.travel.train.R.id.choosed_departure_date
            android.view.View r14 = r13.findViewById(r14)
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r12.o = r14
            int r14 = com.travel.train.R.id.unselected_date_lyt
            android.view.View r14 = r13.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r12.t = r14
            int r14 = com.travel.train.R.id.iv_calender_icon
            android.view.View r14 = r13.findViewById(r14)
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            r12.D = r14
            int r14 = com.travel.train.R.id.seat_type_text
            android.view.View r14 = r13.findViewById(r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            r12.u = r14
            int r14 = com.travel.train.R.id.label_depart_on
            android.view.View r14 = r13.findViewById(r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            r12.w = r14
            int r14 = com.travel.train.R.id.source_date
            android.view.View r14 = r13.findViewById(r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            r12.v = r14
            int r14 = com.travel.train.R.id.source_month
            android.view.View r14 = r13.findViewById(r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            r12.x = r14
            int r14 = com.travel.train.R.id.source_day
            android.view.View r14 = r13.findViewById(r14)
            com.paytm.utility.RoboTextView r14 = (com.paytm.utility.RoboTextView) r14
            r12.y = r14
            int r14 = com.travel.train.R.id.future_dates
            android.view.View r14 = r13.findViewById(r14)
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            r12.E = r14
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            int r4 = com.travel.train.R.anim.pre_t_shake
            android.view.animation.Animation r14 = android.view.animation.AnimationUtils.loadAnimation(r14, r4)
            r12.M = r14
            int r14 = com.travel.train.R.id.nested_scroll_view
            android.view.View r14 = r13.findViewById(r14)
            androidx.core.widget.NestedScrollView r14 = (androidx.core.widget.NestedScrollView) r14
            r12.ar = r14
            int r14 = com.travel.train.R.id.image_to_loadin_cache
            android.view.View r13 = r13.findViewById(r14)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            r12.aA = r13
            android.widget.ImageView r13 = r12.aA
            com.travel.utils.n$a r14 = com.travel.utils.n.a.V1
            java.lang.String r4 = "train_image.png"
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r13, r4, r1, r1, r14)
            android.widget.ImageView r13 = r12.aA
            com.travel.utils.n$a r14 = com.travel.utils.n.a.V1
            java.lang.String r4 = "wheel_image.png"
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r13, r4, r1, r1, r14)
            android.widget.Button r13 = r12.B
            r13.setOnClickListener(r12)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r12.m
            r13.setOnClickListener(r12)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r12.n
            r13.setOnClickListener(r12)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r12.o
            r13.setOnClickListener(r12)
            android.widget.ImageView r13 = r12.D
            r13.setOnClickListener(r12)
            android.widget.Button r13 = r12.B
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            int r4 = com.travel.train.R.string.search_trains
            java.lang.String r14 = r14.getString(r4)
            r13.setText(r14)
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            int r14 = com.travel.train.R.anim.train_rotate
            android.view.animation.Animation r13 = android.view.animation.AnimationUtils.loadAnimation(r13, r14)
            r12.I = r13
            android.view.animation.Animation r13 = r12.I
            r13.setRepeatCount(r0)
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            int r14 = com.travel.train.R.anim.train_rotate360
            android.view.animation.Animation r13 = android.view.animation.AnimationUtils.loadAnimation(r13, r14)
            r12.J = r13
            android.view.animation.Animation r13 = r12.J
            r13.setRepeatCount(r0)
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            int r14 = com.travel.train.R.anim.train_top_bottom
            android.view.animation.Animation r13 = android.view.animation.AnimationUtils.loadAnimation(r13, r14)
            r12.K = r13
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            int r14 = com.travel.train.R.anim.train_move_up
            android.view.animation.Animation r13 = android.view.animation.AnimationUtils.loadAnimation(r13, r14)
            r12.L = r13
            android.widget.ImageView r13 = r12.C
            com.travel.train.fragment.o$1 r14 = new com.travel.train.fragment.o$1
            r14.<init>()
            r13.setOnClickListener(r14)
            android.widget.LinearLayout r13 = r12.F
            com.travel.train.fragment.o$7 r14 = new com.travel.train.fragment.o$7
            r14.<init>()
            r13.setOnClickListener(r14)
            android.widget.CheckBox r13 = r12.H
            com.travel.train.fragment.o$8 r14 = new com.travel.train.fragment.o$8
            r14.<init>()
            r13.setOnCheckedChangeListener(r14)
            int r13 = com.travel.train.R.string.train_bothtype_text
            java.lang.String r13 = r12.getString(r13)
            r12.f27085g = r13
            java.lang.String r13 = r12.f27085g
            r12.f27086h = r13
            java.util.ArrayList<com.travel.train.model.trainticket.g> r13 = r12.aa
            r13.clear()
            java.lang.String r13 = "E MMM dd HH:mm:ss Z yyyy"
            r14 = 0
        L_0x0303:
            r4 = 2
            if (r14 > r4) goto L_0x0374
            com.travel.train.model.trainticket.g r5 = new com.travel.train.model.trainticket.g
            r5.<init>()
            java.util.Calendar r6 = java.util.Calendar.getInstance()
            r7 = 5
            r6.add(r7, r14)
            java.util.Date r7 = new java.util.Date
            long r8 = r6.getTimeInMillis()
            r7.<init>(r8)
            r5.f27729c = r7
            androidx.fragment.app.FragmentActivity r6 = r12.getActivity()
            java.lang.String r8 = "dd MMM"
            java.lang.String r6 = com.travel.train.j.i.a((android.app.Activity) r6, (java.lang.String) r13, (java.lang.String) r8, (java.util.Date) r7)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0338
            androidx.fragment.app.FragmentActivity r6 = r12.getActivity()
            java.lang.String r6 = com.travel.train.j.i.a((android.app.Activity) r6, (java.lang.String) r13, (java.lang.String) r8, (java.util.Date) r7)
            r5.f27727a = r6
        L_0x0338:
            if (r14 != 0) goto L_0x0344
            java.lang.String r6 = "Today"
            r5.f27728b = r6
            java.lang.String r6 = "today"
            r5.f27730d = r6
            goto L_0x035e
        L_0x0344:
            androidx.fragment.app.FragmentActivity r6 = r12.getActivity()
            java.lang.String r8 = "EEE"
            java.lang.String r6 = com.travel.train.j.i.a((android.app.Activity) r6, (java.lang.String) r13, (java.lang.String) r8, (java.util.Date) r7)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x035e
            androidx.fragment.app.FragmentActivity r6 = r12.getActivity()
            java.lang.String r6 = com.travel.train.j.i.a((android.app.Activity) r6, (java.lang.String) r13, (java.lang.String) r8, (java.util.Date) r7)
            r5.f27728b = r6
        L_0x035e:
            if (r14 != r0) goto L_0x0366
            java.lang.String r4 = "tommorow"
            r5.f27730d = r4
            goto L_0x036c
        L_0x0366:
            if (r14 != r4) goto L_0x036c
            java.lang.String r4 = "dayaftertommorow"
            r5.f27730d = r4
        L_0x036c:
            java.util.ArrayList<com.travel.train.model.trainticket.g> r4 = r12.aa
            r4.add(r5)
            int r14 = r14 + 1
            goto L_0x0303
        L_0x0374:
            java.util.ArrayList<com.travel.train.model.trainticket.g> r13 = r12.aa
            if (r13 == 0) goto L_0x03e1
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x03e1
            android.widget.LinearLayout r13 = r12.E
            r13.removeAllViews()
            r13 = 0
        L_0x0384:
            java.util.ArrayList<com.travel.train.model.trainticket.g> r14 = r12.aa
            int r14 = r14.size()
            if (r13 >= r14) goto L_0x03e1
            androidx.fragment.app.FragmentActivity r14 = r12.getActivity()
            android.view.LayoutInflater r14 = r14.getLayoutInflater()
            int r4 = com.travel.train.R.layout.pre_t_train_home_date_item
            android.view.View r14 = r14.inflate(r4, r2)
            int r4 = com.travel.train.R.id.date
            android.view.View r4 = r14.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = com.travel.train.R.id.day
            android.view.View r5 = r14.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = com.travel.train.R.id.parent_lyt
            r14.findViewById(r6)
            java.util.ArrayList<com.travel.train.model.trainticket.g> r6 = r12.aa
            java.lang.Object r6 = r6.get(r13)
            com.travel.train.model.trainticket.g r6 = (com.travel.train.model.trainticket.g) r6
            java.lang.String r7 = r6.f27727a
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x03c4
            java.lang.String r7 = r6.f27727a
            r4.setText(r7)
        L_0x03c4:
            java.lang.String r4 = r6.f27728b
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x03d1
            java.lang.String r4 = r6.f27728b
            r5.setText(r4)
        L_0x03d1:
            com.travel.train.fragment.o$9 r4 = new com.travel.train.fragment.o$9
            r4.<init>(r13)
            r14.setOnClickListener(r4)
            android.widget.LinearLayout r4 = r12.E
            r4.addView(r14)
            int r13 = r13 + 1
            goto L_0x0384
        L_0x03e1:
            r12.a()
            boolean r13 = r12.ak
            if (r13 == 0) goto L_0x03ed
            android.widget.LinearLayout r13 = r12.F
            r13.setVisibility(r3)
        L_0x03ed:
            boolean r13 = r12.al
            if (r13 == 0) goto L_0x0524
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r13 = r12.am
            if (r13 == 0) goto L_0x0520
            java.lang.String r14 = r12.aj
            r12.S = r0
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r2 = r12.c()
            com.travel.train.model.trainticket.CJRTrainRecentsItemModel r3 = new com.travel.train.model.trainticket.CJRTrainRecentsItemModel
            r3.<init>()
            java.lang.String r4 = r13.getTrainSourceCityCode()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0429
            java.lang.String r4 = r13.getTrainSourceCityName()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0429
            java.lang.String r4 = r13.getTrainSourceCityName()
            java.lang.String r4 = com.paytm.utility.v.b(r4)
            r3.setSourceCityName(r4)
            java.lang.String r4 = r13.getTrainSourceCityCode()
            r3.setSourceCityCode(r4)
            goto L_0x0456
        L_0x0429:
            if (r2 == 0) goto L_0x0456
            java.lang.String r4 = r2.getSourceCityName()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0456
            java.lang.String r4 = r2.getSourceCityCode()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0456
            java.lang.String r4 = r2.getSourceCityName()
            r3.setSourceCityName(r4)
            java.lang.String r4 = r2.getSourceCityCode()
            r3.setSourceCityCode(r4)
            java.lang.String r4 = r2.getSourceAirportName()
            r3.setSourceAirportName(r4)
            r4 = 1
            goto L_0x0457
        L_0x0456:
            r4 = 0
        L_0x0457:
            java.lang.String r5 = r13.getTrainDestinationCityName()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x047e
            java.lang.String r5 = r13.getTrainDestinationCityCode()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x047e
            java.lang.String r5 = r13.getTrainDestinationCityName()
            java.lang.String r5 = com.paytm.utility.v.b(r5)
            r3.setDestinationCityName(r5)
            java.lang.String r5 = r13.getTrainDestinationCityCode()
            r3.setDestinationCityCode(r5)
            goto L_0x04aa
        L_0x047e:
            if (r2 == 0) goto L_0x04aa
            java.lang.String r5 = r2.getDestinationCityName()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x04aa
            java.lang.String r5 = r2.getDestinationCityCode()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x04aa
            java.lang.String r4 = r2.getDestinationCityName()
            r3.setDestinationCityName(r4)
            java.lang.String r4 = r2.getDestinationCityCode()
            r3.setDestinationCityCode(r4)
            java.lang.String r4 = r2.getDestinationAirportName()
            r3.setDestinationAirportName(r4)
            r4 = 1
        L_0x04aa:
            java.lang.String r5 = r13.getTrainDepartureDate()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r6 = "dd MMM yy"
            if (r5 != 0) goto L_0x04c5
            java.lang.String r13 = r13.getTrainDepartureDate()
            java.lang.String r14 = "yyyyMMdd"
            java.lang.String r13 = com.travel.train.j.i.c(r13, r14, r6)
            r3.setDateOfTravel(r13)
            goto L_0x04ee
        L_0x04c5:
            boolean r13 = android.text.TextUtils.isEmpty(r14)
            if (r13 == 0) goto L_0x04df
            if (r2 == 0) goto L_0x04df
            java.lang.String r13 = r2.getDateOfTravel()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x04df
            java.lang.String r13 = r2.getDateOfTravel()
            r3.setDateOfTravel(r13)
            goto L_0x04ee
        L_0x04df:
            java.lang.String r13 = "Order_summary"
            boolean r13 = r14.equalsIgnoreCase(r13)
            if (r13 != 0) goto L_0x04ee
            java.lang.String r13 = com.travel.train.j.i.h(r6)
            r3.setDateOfTravel(r13)
        L_0x04ee:
            java.lang.String r13 = r3.getDestinationCityName()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x051c
            java.lang.String r13 = r3.getDestinationCityCode()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x051c
            java.lang.String r13 = r3.getSourceCityName()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x051c
            java.lang.String r13 = r3.getSourceCityCode()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x051c
            if (r4 != 0) goto L_0x051c
            r12.a((com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r3, (boolean) r0)
            goto L_0x0527
        L_0x051c:
            r12.a((com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r3, (boolean) r1)
            goto L_0x0527
        L_0x0520:
            r12.b()
            goto L_0x0527
        L_0x0524:
            r12.b()
        L_0x0527:
            com.travel.train.k.d r13 = r12.ao
            if (r13 == 0) goto L_0x0561
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainBookingInformation> r13 = r13.f27645g
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$OU-SEW1RjNSxwadhCqwKVeMNZLA r14 = new com.travel.train.fragment.-$$Lambda$o$OU-SEW1RjNSxwadhCqwKVeMNZLA
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.d r13 = r12.ao
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainQuickBookFavourites> r13 = r13.f27647i
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$MBlX2sJ2oKbIxitkLLVgEkDemo4 r14 = new com.travel.train.fragment.-$$Lambda$o$MBlX2sJ2oKbIxitkLLVgEkDemo4
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.d r13 = r12.ao
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainHolidayList> r13 = r13.f27646h
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$daRMzS1j_KnKDbOuoQYhumzphRU r14 = new com.travel.train.fragment.-$$Lambda$o$daRMzS1j_KnKDbOuoQYhumzphRU
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.d r13 = r12.ao
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainRecentBooking> r13 = r13.j
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$kIvCQZdKzeRMn6-hutOtL8q3gZQ r14 = new com.travel.train.fragment.-$$Lambda$o$kIvCQZdKzeRMn6-hutOtL8q3gZQ
            r14.<init>()
            r13.observe(r12, r14)
        L_0x0561:
            com.travel.train.k.c r13 = r12.an
            if (r13 == 0) goto L_0x05d1
            androidx.lifecycle.y<java.lang.Integer> r13 = r13.f27632c
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$BZZ51aY4zbgRNch8Mghe_YfB050 r14 = new com.travel.train.fragment.-$$Lambda$o$BZZ51aY4zbgRNch8Mghe_YfB050
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.c r13 = r12.an
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainSearchResults> r13 = r13.f27633d
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$wo6PE5BxHwcTQmfsukrpH0NjCbM r14 = new com.travel.train.fragment.-$$Lambda$o$wo6PE5BxHwcTQmfsukrpH0NjCbM
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.c r13 = r12.an
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.f27638i
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$XsXnk7QKsH-OtWZoVBampHgT_Qs r14 = new com.travel.train.fragment.-$$Lambda$o$XsXnk7QKsH-OtWZoVBampHgT_Qs
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.c r13 = r12.an
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r13 = r13.f27634e
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$O6UaqL9o59aHpzk7cO9AUprSu6g r14 = new com.travel.train.fragment.-$$Lambda$o$O6UaqL9o59aHpzk7cO9AUprSu6g
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.c r13 = r12.an
            androidx.lifecycle.y<java.lang.Boolean> r13 = r13.j
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$A7f5K5wudhBdh0_FuDZm4RP8-EQ r14 = new com.travel.train.fragment.-$$Lambda$o$A7f5K5wudhBdh0_FuDZm4RP8-EQ
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.c r13 = r12.an
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r13 = r13.f27635f
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$CV1AJfcql0wcwhkAtMo_9CBwXuA r14 = new com.travel.train.fragment.-$$Lambda$o$CV1AJfcql0wcwhkAtMo_9CBwXuA
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.c r13 = r12.an
            com.travel.train.l.c r13 = r13.f27636g
            com.travel.train.fragment.-$$Lambda$o$DyE7xWhD9NXNJEdz8Ubtqcr0SAE r14 = new com.travel.train.fragment.-$$Lambda$o$DyE7xWhD9NXNJEdz8Ubtqcr0SAE
            r14.<init>()
            r13.observe(r12, r14)
            com.travel.train.k.c r13 = r12.an
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r13 = r13.f27637h
            androidx.lifecycle.LiveData r13 = (androidx.lifecycle.LiveData) r13
            com.travel.train.fragment.-$$Lambda$o$1OndNMWa53xnhhbj-rCUjEJMWvs r14 = new com.travel.train.fragment.-$$Lambda$o$1OndNMWa53xnhhbj-rCUjEJMWvs
            r14.<init>()
            r13.observe(r12, r14)
        L_0x05d1:
            com.travel.train.model.trainticket.CJRTrainBookingInformation r13 = r12.af
            if (r13 == 0) goto L_0x05e1
            com.travel.train.k.d r14 = r12.ao
            java.lang.String r2 = "bookingInfo"
            kotlin.g.b.k.c(r13, r2)
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainBookingInformation> r14 = r14.f27645g
            r14.postValue(r13)
        L_0x05e1:
            com.travel.train.model.trainticket.CJRTrainHolidayList r13 = r12.ag
            if (r13 == 0) goto L_0x05f1
            com.travel.train.k.d r14 = r12.ao
            java.lang.String r2 = "holidayList"
            kotlin.g.b.k.c(r13, r2)
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainHolidayList> r14 = r14.f27646h
            r14.postValue(r13)
        L_0x05f1:
            com.travel.train.model.trainticket.CJRTrainQuickBookFavourites r13 = r12.ah
            if (r13 == 0) goto L_0x0601
            com.travel.train.k.d r14 = r12.ao
            java.lang.String r2 = "favourites"
            kotlin.g.b.k.c(r13, r2)
            androidx.lifecycle.y<com.travel.train.model.trainticket.CJRTrainQuickBookFavourites> r14 = r14.f27647i
            r14.postValue(r13)
        L_0x0601:
            com.travel.train.model.trainticket.CJRTrainRecentBooking r13 = r12.ai
            if (r13 == 0) goto L_0x060a
            com.travel.train.k.d r14 = r12.ao
            r14.a((com.travel.train.model.trainticket.CJRTrainRecentBooking) r13)
        L_0x060a:
            boolean r13 = r12.ak
            if (r13 != 0) goto L_0x06ab
            boolean r13 = r12.getUserVisibleHint()
            if (r13 == 0) goto L_0x06ab
            boolean r13 = r12.ax
            if (r13 != 0) goto L_0x0690
            boolean r13 = r12.isAdded()
            if (r13 == 0) goto L_0x0690
            androidx.fragment.app.j r13 = r12.getChildFragmentManager()
            r13.b()
            java.lang.String r14 = r12.f27080b
            androidx.fragment.app.Fragment r13 = r13.c((java.lang.String) r14)
            r12.at = r13
            androidx.fragment.app.Fragment r13 = r12.at
            if (r13 == 0) goto L_0x0637
            boolean r13 = r13.isAdded()
            if (r13 != 0) goto L_0x0690
        L_0x0637:
            com.travel.train.b.a()
            com.travel.common.a r13 = com.travel.train.b.b()
            java.lang.ref.WeakReference r14 = new java.lang.ref.WeakReference
            androidx.core.widget.NestedScrollView r2 = r12.ar
            r14.<init>(r2)
            androidx.fragment.app.Fragment r13 = r13.a((java.lang.ref.WeakReference<android.view.View>) r14)
            r12.at = r13
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            java.lang.String r14 = "bundle_extra_clp_parallax_animation_required"
            r13.putBoolean(r14, r1)
            java.lang.String r14 = "bundle_extra_secondary_home_user_visible"
            r13.putBoolean(r14, r1)
            java.lang.String r14 = "first_tab_home"
            r13.putBoolean(r14, r0)
            java.lang.String r14 = "origin"
            java.lang.String r1 = "train"
            r13.putString(r14, r1)
            java.lang.String r14 = "store_front_url_key"
            java.lang.String r1 = "trainStoreFrontNewURL"
            r13.putString(r14, r1)
            java.lang.String r14 = "trigger-impression-on-visibility"
            r13.putBoolean(r14, r0)
            androidx.fragment.app.Fragment r14 = r12.at
            r14.setArguments(r13)
            androidx.fragment.app.j r13 = r12.getChildFragmentManager()
            androidx.fragment.app.q r13 = r13.a()
            int r14 = com.travel.train.R.id.framelayout_storefront_train_home
            androidx.fragment.app.Fragment r1 = r12.at
            java.lang.String r2 = r12.f27080b
            androidx.fragment.app.q r13 = r13.b(r14, r1, r2)
            r13.b()
        L_0x0690:
            boolean r13 = r12.aw
            if (r13 != 0) goto L_0x06ab
            r12.aw = r0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            androidx.fragment.app.FragmentActivity r10 = r12.getActivity()
            r11 = 0
            java.lang.String r1 = "train_homepage"
            java.lang.String r8 = "book_tickets_clicked"
            java.lang.String r9 = "/trains"
            com.travel.train.j.o.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x06ab:
            com.travel.train.fragment.-$$Lambda$o$rlKgbiku4JBYo_PjHMDwCIRi5ds r13 = new com.travel.train.fragment.-$$Lambda$o$rlKgbiku4JBYo_PjHMDwCIRi5ds
            r13.<init>()
            r12.ay = r13
            androidx.core.widget.NestedScrollView r13 = r12.ar
            android.view.ViewTreeObserver r13 = r13.getViewTreeObserver()
            android.view.ViewTreeObserver$OnScrollChangedListener r14 = r12.ay
            r13.addOnScrollChangedListener(r14)
            long r13 = java.lang.System.currentTimeMillis()
            r12.as = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.o.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRTrainBookingInformation cJRTrainBookingInformation) {
        this.af = cJRTrainBookingInformation;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRTrainQuickBookFavourites cJRTrainQuickBookFavourites) {
        this.ah = cJRTrainQuickBookFavourites;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRTrainHolidayList cJRTrainHolidayList) {
        this.ag = cJRTrainHolidayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRTrainRecentBooking cJRTrainRecentBooking) {
        this.ai = cJRTrainRecentBooking;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        this.au = num.intValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRTrainSearchResults cJRTrainSearchResults) {
        this.ae = cJRTrainSearchResults;
        if (this.av) {
            if (this.aq != null) {
                m.a aVar = m.f27577a;
                m.a.a(this.aq, "train_most_visited", 5, getContext());
            }
            if (!this.ak) {
                Intent intent = new Intent(getActivity(), AJRTrainSearchActivity.class);
                intent.addFlags(67239936);
                Bundle bundle = new Bundle();
                int i2 = this.au;
                if (i2 > 0) {
                    bundle.putInt("train_search_status_code", i2);
                }
                bundle.putSerializable("intent_extra_train_search_input", this.ab);
                bundle.putSerializable("boolean_extra_is_contol_from_deep_link", Boolean.valueOf(this.T));
                bundle.putSerializable("intent_extra_train_fav", this.ah);
                bundle.putSerializable("intent_extra_TRAIN_search_load_data", cJRTrainSearchResults);
                bundle.putSerializable("train_recent_search_cities", this.Z);
                if ("NonAcType".equalsIgnoreCase(this.f27085g)) {
                    bundle.putString("alreadyFilterApplied", "NonAcType");
                } else if ("AcType".equalsIgnoreCase(this.f27085g)) {
                    bundle.putString("alreadyFilterApplied", "AcType");
                }
                CJRTrainBookingInformation cJRTrainBookingInformation = this.af;
                if (cJRTrainBookingInformation != null) {
                    bundle.putSerializable("intent_extra_notification", cJRTrainBookingInformation);
                }
                intent.putExtra("train_home_bundle", bundle);
                startActivityForResult(intent, 2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        if (!bool.booleanValue()) {
            i();
        } else if (getActivity() != null && !getActivity().isFinishing()) {
            this.ac = new Handler();
            this.ac.postDelayed(new Runnable() {
                public final void run() {
                    if (o.this.getActivity() != null && !o.this.getActivity().isFinishing()) {
                        j fragmentManager = o.this.getFragmentManager();
                        Fragment c2 = fragmentManager.c(o.this.f27084f);
                        if (c2 != null) {
                            fragmentManager.a().a(c2).c();
                        }
                        if (o.this.ad == null) {
                            o oVar = o.this;
                            l unused = oVar.ad = new l(oVar);
                        }
                        if (o.this.ad.isVisible()) {
                            o.this.ad.show(fragmentManager, o.this.f27084f);
                        }
                    }
                }
            }, 500);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        Handler handler = this.ac;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.ax = true;
        super.onSaveInstanceState(bundle);
    }

    public void onResume() {
        this.ax = false;
        super.onResume();
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        if (z2 && !this.ak) {
            this.az = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        boolean z2 = false;
        if (this.az) {
            this.ar.scrollTo(0, 0);
            this.az = false;
            return;
        }
        NestedScrollView nestedScrollView = this.ar;
        if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getBottom() - (this.ar.getHeight() + this.ar.getScrollY()) == 0) {
            if (this.at != null) {
                if (System.currentTimeMillis() - this.as > 1000) {
                    this.as = System.currentTimeMillis();
                    z2 = true;
                }
                if (z2) {
                    b.a();
                    b.b().a(this.at);
                }
            }
        } else if (this.at != null) {
            b.a();
            b.b().b(this.at);
        }
    }

    public final void a() {
        m.a aVar = m.f27577a;
        this.ap = m.a.a(getContext(), "train_most_visited");
        List<CJRTrainRecentsItemModel> list = this.ap;
        if (list != null) {
            this.Z.setmTrainSearchedCityDetails((ArrayList) list);
        }
    }

    public final void b() {
        CJRTrainRecentsItemModel c2 = c();
        if (c2 != null) {
            a(c2, false);
        } else {
            a(e());
        }
    }

    private CJRTrainRecentsItemModel c() {
        ArrayList<CJRTrainRecentsItemModel> arrayList;
        CJRTrainCity cJRTrainCity = this.Z;
        if (cJRTrainCity == null || cJRTrainCity.getmTrainSearchedCityDetails() == null || this.Z.getmTrainSearchedCityDetails().size() <= 0 || (arrayList = this.Z.getmTrainSearchedCityDetails()) == null || arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(this.Z.getmTrainSearchedCityDetails().size() - 1);
    }

    private void a(CJRTrainRecentsItemModel cJRTrainRecentsItemModel, boolean z2) {
        if (cJRTrainRecentsItemModel != null) {
            a(cJRTrainRecentsItemModel);
            b(cJRTrainRecentsItemModel);
            if (!TextUtils.isEmpty(cJRTrainRecentsItemModel.getDateOfTravel())) {
                if (!i.g(cJRTrainRecentsItemModel.getDateOfTravel())) {
                    a(cJRTrainRecentsItemModel.getDateOfTravel());
                } else if (z2) {
                    g();
                    return;
                } else {
                    a(e());
                }
                if (z2) {
                    this.T = true;
                    f();
                    return;
                }
                return;
            }
            g();
        }
    }

    private void a(CJRTrainRecentsItemModel cJRTrainRecentsItemModel) {
        if (cJRTrainRecentsItemModel != null && cJRTrainRecentsItemModel.getSourceCityName() != null) {
            this.r.setVisibility(0);
            this.r.setText(cJRTrainRecentsItemModel.getSourceCityName());
            this.p.setVisibility(0);
            this.z.setVisibility(8);
            String sourceCityCode = cJRTrainRecentsItemModel.getSourceCityCode();
            this.O = sourceCityCode;
            if (cJRTrainRecentsItemModel.getSourceCityCode() != null) {
                this.p.setText(sourceCityCode.toUpperCase());
            } else {
                this.p.setText("");
            }
            this.p.setTag(cJRTrainRecentsItemModel.getSourceAirportName());
            d();
        }
    }

    private void b(CJRTrainRecentsItemModel cJRTrainRecentsItemModel) {
        if (cJRTrainRecentsItemModel != null && cJRTrainRecentsItemModel.getDestinationCityName() != null) {
            this.s.setVisibility(0);
            this.s.setText(cJRTrainRecentsItemModel.getDestinationCityName());
            this.q.setVisibility(0);
            this.A.setVisibility(8);
            String destinationCityCode = cJRTrainRecentsItemModel.getDestinationCityCode();
            this.P = destinationCityCode;
            if (cJRTrainRecentsItemModel.getDestinationCityCode() != null) {
                this.q.setText(destinationCityCode.toUpperCase());
            } else {
                this.q.setText("");
            }
            this.q.setTag(cJRTrainRecentsItemModel.getDestinationAirportName());
            d();
        }
    }

    private void d() {
        if (!TextUtils.isEmpty(this.r.getText()) && !TextUtils.isEmpty(this.s.getText())) {
            this.C.setEnabled(true);
        }
    }

    private String e() {
        return i.a((Activity) getActivity(), "E MMM dd HH:mm:ss Z yyyy", "dd MMM yy", new Date(System.currentTimeMillis()));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.proceed_btn) {
            if (com.paytm.utility.b.c((Context) getActivity())) {
                f();
            } else {
                showNoNetworkDialog();
            }
        } else if (id == R.id.choosed_departure_date) {
            this.f27079a = false;
            com.travel.train.j.o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "depart_date_clicked", "/trains", getActivity(), (Map<String, Object>) null);
            h();
        } else if (id == R.id.iv_calender_icon) {
            this.f27079a = false;
            com.travel.train.j.o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "depart_date_clicked", "/trains", getActivity(), (Map<String, Object>) null);
            h();
        } else if (id == R.id.source_lyt) {
            com.travel.train.j.o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "from_to_clicked", "/trains", getActivity(), (Map<String, Object>) null);
            a(201, "source");
        } else if (id == R.id.destination_lyt) {
            com.travel.train.j.o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "from_to_clicked", "/trains", getActivity(), (Map<String, Object>) null);
            a(202, "destination");
        }
    }

    /* access modifiers changed from: private */
    public void a(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3) {
        if (!this.f27085g.equalsIgnoreCase(getActivity().getResources().getString(R.string.train_bothtype_text))) {
            if (this.f27085g.equalsIgnoreCase(getActivity().getResources().getString(R.string.train_nonactype_text))) {
                b(radioButton, radioButton2, radioButton3, 1);
                this.u.setText(radioButton2.getText().toString());
                return;
            } else if (this.f27085g.equalsIgnoreCase(getActivity().getResources().getString(R.string.train_actype_text))) {
                b(radioButton, radioButton2, radioButton3, 2);
                this.u.setText(radioButton3.getText().toString());
                return;
            }
        }
        b(radioButton, radioButton2, radioButton3, 0);
        this.u.setText(radioButton.getText().toString());
    }

    /* access modifiers changed from: private */
    public static void b(RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, int i2) {
        radioButton.setChecked(false);
        radioButton2.setChecked(false);
        radioButton3.setChecked(false);
        if (i2 == 0) {
            radioButton.setChecked(true);
        } else if (i2 == 1) {
            radioButton2.setChecked(true);
        } else if (i2 == 2) {
            radioButton3.setChecked(true);
        }
    }

    private void f() {
        String charSequence = this.r.getText().toString();
        String charSequence2 = this.s.getText().toString();
        String charSequence3 = this.p.getText().toString();
        String charSequence4 = this.q.getText().toString();
        String str = "";
        String str2 = this.p.getTag() instanceof String ? (String) this.p.getTag() : str;
        if (this.q.getTag() instanceof String) {
            str = (String) this.q.getTag();
        }
        if (!TextUtils.isEmpty(charSequence3) && !TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence4) && !TextUtils.isEmpty(charSequence2) && !TextUtils.isEmpty(this.N)) {
            this.aq = new CJRTrainRecentsItemModel();
            this.aq.setSourceCityCode(charSequence3);
            this.aq.setSourceCityName(charSequence);
            this.aq.setSourceAirportName(str2);
            this.aq.setDestinationCityCode(charSequence4);
            this.aq.setDestinationCityName(charSequence2);
            this.aq.setDestinationAirportName(str);
            this.aq.setDateOfTravel(this.N);
        }
        Resources resources = getResources();
        if (TextUtils.isEmpty(charSequence) || this.z.getVisibility() == 0) {
            this.r.startAnimation(this.M);
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.train_title_origin_station_missing), resources.getString(R.string.msg_invalid_origin));
        } else if (TextUtils.isEmpty(charSequence2) || this.A.getVisibility() == 0) {
            this.s.startAnimation(this.M);
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.train_title_destination_station_missing), resources.getString(R.string.msg_invalid_destination));
        } else if (charSequence3.equalsIgnoreCase(charSequence4)) {
            int i2 = R.string.same_source__destination_error_message;
            String string = resources.getString(i2, new Object[]{charSequence + "(" + charSequence3 + ")"});
            if (this.ak) {
                this.an.a(string);
            } else {
                com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.train_title_same_origin_destination), string);
            }
        } else if (this.t.getVisibility() == 0 && this.o.getVisibility() == 8) {
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.train_title_travel_date_missing), resources.getString(R.string.msg_invalid_date));
        } else if (TextUtils.isEmpty(this.v.getText().toString())) {
            com.paytm.utility.b.b((Context) getActivity(), resources.getString(R.string.train_title_travel_date_missing), resources.getString(R.string.msg_invalid_date));
        } else {
            this.ab = new CJRTrainSearchInput();
            if (charSequence != null && !TextUtils.isEmpty(charSequence)) {
                this.ab.setmSourceCityName(charSequence);
            }
            if (charSequence2 != null && !TextUtils.isEmpty(charSequence2)) {
                this.ab.setmDestCityName(charSequence2);
            }
            if (charSequence3 != null && !TextUtils.isEmpty(charSequence3)) {
                this.ab.setmSourceCityCode(charSequence3);
            }
            if (charSequence4 != null && !TextUtils.isEmpty(charSequence4)) {
                this.ab.setmDestCityCode(charSequence4);
            }
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                this.ab.setSourceAirPortName(str2);
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                this.ab.setDestAirportName(str);
            }
            String str3 = this.N;
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                this.ab.setmDate(this.N);
            }
            String str4 = this.R;
            if (str4 != null && !TextUtils.isEmpty(str4)) {
                this.ab.setmSourceKeyword(this.R);
            }
            int i3 = this.W;
            if (i3 > 0) {
                this.ab.setmSourceRankPosition(i3);
            }
            String str5 = this.Y;
            if (str5 != null && !TextUtils.isEmpty(str5)) {
                this.ab.setmDestKeyword(this.Y);
            }
            int i4 = this.X;
            if (i4 > 0) {
                this.ab.setmDestRankPosition(i4);
            }
            CJRTrainSearchInput cJRTrainSearchInput = this.ab;
            if (cJRTrainSearchInput != null && cJRTrainSearchInput.getmSourceCityName() != null && this.ab.getmDestCityName() != null && this.ab.getmSourceCityCode() != null && this.ab.getmDestCityCode() != null && this.ab.getmDate() != null) {
                com.travel.train.j.o.a("train_homepage", this.ab.getmSourceCityName(), this.ab.getmDestCityName(), this.ab.getmDate(), (String) null, (String) null, (String) null, "search_trains_clicked", "/trains", getActivity(), (Map<String, Object>) null);
                this.av = true;
                this.an.a(this.ab);
                this.an.a();
                this.an.c();
                this.an.a(n.d(getContext()), n.a(this.ab));
            }
        }
    }

    private void g() {
        a(i.h("dd MMM yy"));
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (o.this.getActivity() != null && !o.this.getActivity().isFinishing()) {
                    o.this.h();
                }
            }
        }, 700);
    }

    private void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                c(str);
                b(str);
                this.Q = str;
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        Date date;
        boolean z2 = getUserVisibleHint() && !this.f27079a;
        if (this.ak) {
            z2 = !this.f27079a;
        }
        if (z2) {
            Locale locale = new Locale(com.paytm.utility.n.a());
            showProgressDialog(getActivity(), getString(R.string.please_wait_progress_msg));
            if (this.t.getVisibility() == 0 && this.o.getVisibility() == 8) {
                this.Q = i.h("dd MMM yy");
            } else {
                String str = this.N;
                if (str != null && !TextUtils.isEmpty(str)) {
                    this.Q = this.N;
                }
            }
            if (!isDetached()) {
                try {
                    date = new SimpleDateFormat("dd MMM yy", locale).parse(this.Q);
                } catch (ParseException unused) {
                    date = Calendar.getInstance().getTime();
                }
                Date date2 = date;
                b.a();
                a b2 = b.b();
                FragmentActivity activity = getActivity();
                long j2 = this.V;
                x xVar = x.f27611a;
                int a2 = x.a();
                b.a();
                startActivityForResult(b2.a((Activity) activity, locale, date2, j2, a2, b.b().a("TrainHolidayList"), getString(R.string.train_calender_activity_name), (String) null), 1);
                this.f27079a = true;
            }
        }
    }

    private void b(String str) {
        boolean c2 = com.paytm.utility.b.c(str, "dd MMM yy");
        getActivity();
        String d2 = com.paytm.utility.b.d(str, "dd MMM yy", "EEE");
        getActivity();
        String d3 = com.paytm.utility.b.d(str, "dd MMM yy", "dd MMMM EEEE");
        if (c2) {
            str = v.a(str, AppConstants.COMMA, " ", d2);
        }
        this.N = str;
        if (!TextUtils.isEmpty(d3)) {
            String[] split = d3.split(" ");
            if (split.length == 3) {
                this.o.setVisibility(0);
                this.t.setVisibility(8);
                this.x.setVisibility(0);
                this.y.setVisibility(0);
                if (!TextUtils.isEmpty(split[0])) {
                    RoboTextView roboTextView = this.v;
                    getActivity();
                    roboTextView.setText(com.paytm.utility.b.c(split[0], "dd", "dd"));
                }
                this.x.setText(split[1]);
                this.y.setText(split[2]);
                this.w.setVisibility(0);
            }
        }
    }

    private void c(String str) {
        Date date;
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            Calendar instance2 = Calendar.getInstance();
            if (str.contains(AppConstants.COMMA)) {
                date = new SimpleDateFormat("dd MMM yy, EEE").parse(str);
            } else {
                date = new SimpleDateFormat("dd MMM yy").parse(str);
            }
            instance2.setTime(date);
            instance2.add(10, 1);
            a((int) TimeUnit.MILLISECONDS.toDays(instance2.getTimeInMillis() - instance.getTimeInMillis()));
        } catch (Exception e2) {
            PrintStream printStream = System.out;
            printStream.println("error :: " + e2.getMessage());
        }
    }

    private void a(int i2) {
        LinearLayout linearLayout = this.E;
        if (linearLayout != null && linearLayout.getChildCount() > 0) {
            for (int i3 = 0; i3 < this.E.getChildCount(); i3++) {
                View childAt = this.E.getChildAt(i3);
                TextView textView = (TextView) childAt.findViewById(R.id.date);
                TextView textView2 = (TextView) childAt.findViewById(R.id.day);
                RelativeLayout relativeLayout = (RelativeLayout) childAt.findViewById(R.id.parent_lyt);
                if (i3 == i2) {
                    relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_alternate_class_bg_selected);
                    textView.setTextColor(getResources().getColor(R.color.color_222222));
                    textView2.setTextColor(getResources().getColor(R.color.color_222222));
                } else {
                    relativeLayout.setBackgroundResource(R.drawable.pre_t_train_train_date_bg_unselect);
                    textView.setTextColor(getResources().getColor(R.color.tab_grey));
                    textView2.setTextColor(getResources().getColor(R.color.tab_grey));
                }
            }
        }
    }

    private void a(CJRTrainOriginCityItem cJRTrainOriginCityItem) {
        this.r.setVisibility(0);
        this.r.setText(cJRTrainOriginCityItem.getCityName());
        this.p.setVisibility(0);
        this.z.setVisibility(8);
        this.p.setTag(cJRTrainOriginCityItem.getAirportName());
        String cityCode = cJRTrainOriginCityItem.getCityCode();
        this.O = cityCode;
        if (cJRTrainOriginCityItem.getCityCode() != null) {
            this.p.setText(cityCode.toUpperCase());
        } else {
            this.p.setText("");
        }
        d();
    }

    private void b(CJRTrainOriginCityItem cJRTrainOriginCityItem) {
        this.s.setVisibility(0);
        this.s.setText(cJRTrainOriginCityItem.getCityName());
        this.q.setVisibility(0);
        this.A.setVisibility(8);
        this.q.setTag(cJRTrainOriginCityItem.getAirportName());
        String cityCode = cJRTrainOriginCityItem.getCityCode();
        this.P = cityCode;
        if (cJRTrainOriginCityItem.getCityCode() != null) {
            this.q.setText(cityCode.toUpperCase());
        } else {
            this.q.setText("");
        }
        d();
    }

    public final void a(int i2, String str) {
        try {
            if (getActivity() != null) {
                if (str.equalsIgnoreCase("source")) {
                    this.k++;
                } else if (str.equalsIgnoreCase("destination")) {
                    this.l++;
                }
                m.a aVar = m.f27577a;
                this.ap = m.a.a(getContext(), "train_most_visited");
                if (this.ap != null) {
                    this.Z.setmTrainSearchedCityDetails((ArrayList) this.ap);
                } else {
                    this.Z.setmTrainSearchedCityDetails((ArrayList<CJRTrainRecentsItemModel>) null);
                }
                Intent intent = new Intent(getActivity(), AJRTrainSelectCityActivity.class);
                intent.addFlags(131072);
                intent.putExtra("option", str);
                intent.putExtra("selected_source_name", this.O);
                intent.putExtra("selected_destination_name", this.P);
                intent.putExtra(com.travel.train.j.g.Q, this.Z);
                startActivityForResult(intent, i2);
            }
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            removeProgressDialog();
            this.f27079a = false;
            if (intent != null) {
                String str = null;
                if (intent != null && intent.hasExtra("intent_extra_selected_train_display_date_depart")) {
                    intent.getStringExtra("intent_extra_selected_train_display_date");
                }
                if (intent != null && intent.hasExtra("intent_extra_selected_depart_date")) {
                    str = intent.getStringExtra("intent_extra_selected_depart_date");
                }
                if (intent != null && intent.hasExtra("intent_extra_selected_date_time")) {
                    this.V = intent.getLongExtra("intent_extra_selected_date_time", 0);
                }
                if (str != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("train_date_source", "calendar");
                    hashMap.put("train_travel_date", str);
                    com.travel.train.j.o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, "/trains", getActivity(), hashMap);
                    a(str);
                }
            }
        } else if (i2 == 2) {
            a();
            if (intent != null) {
                if (intent.hasExtra("intent_extra_train_search_input") && intent.getSerializableExtra("intent_extra_train_search_input") != null) {
                    this.ab = (CJRTrainSearchInput) intent.getSerializableExtra("intent_extra_train_search_input");
                }
                if (intent.hasExtra("alreadyFilterApplied")) {
                    if ("AcType".equalsIgnoreCase(intent.getStringExtra("alreadyFilterApplied"))) {
                        this.f27085g = getString(R.string.train_actype_text);
                        this.f27086h = this.f27085g;
                        if (com.travel.train.j.g.f27551a == null || TextUtils.isEmpty(com.travel.train.j.g.f27551a.getOnlyAcTrains())) {
                            this.u.setText(getActivity().getResources().getString(R.string.train_show_ac_text));
                        } else {
                            this.u.setText(com.travel.train.j.g.f27551a.getOnlyAcTrains());
                        }
                    } else {
                        this.f27085g = getString(R.string.train_bothtype_text);
                        this.f27086h = this.f27085g;
                        if (com.travel.train.j.g.f27551a == null || TextUtils.isEmpty(com.travel.train.j.g.f27551a.getAcNonAcText())) {
                            this.u.setText(getActivity().getResources().getString(R.string.train_show_ac_non_ac_text));
                        } else {
                            this.u.setText(com.travel.train.j.g.f27551a.getAcNonAcText());
                        }
                    }
                }
            }
            b();
        } else if (i2 == 201) {
            if (intent != null && intent.hasExtra("intent_extra_last_known_search_keyword")) {
                this.R = intent.getStringExtra("intent_extra_last_known_search_keyword");
            }
            if (intent != null && intent.hasExtra("intent_extra_selected_city_position")) {
                this.W = intent.getIntExtra("intent_extra_selected_city_position", -1);
            }
            if (intent != null && intent.hasExtra("intent_extra_selected_city_name")) {
                if (intent.getSerializableExtra("intent_extra_selected_city_name") instanceof CJRTrainRouteStations) {
                    CJRTrainRouteStations cJRTrainRouteStations = (CJRTrainRouteStations) intent.getSerializableExtra("intent_extra_selected_city_name");
                    a(cJRTrainRouteStations.getSource());
                    b(cJRTrainRouteStations.getDestination());
                } else {
                    CJRTrainOriginCityItem cJRTrainOriginCityItem = (CJRTrainOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_name");
                    if (!(cJRTrainOriginCityItem == null || cJRTrainOriginCityItem.getCityName() == null)) {
                        a(cJRTrainOriginCityItem);
                    }
                }
            }
            if (this.A.getVisibility() == 0 && this.l <= 0) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        o.this.a(202, "destination");
                    }
                }, 100);
            }
            if (intent != null && intent.hasExtra(com.travel.train.j.g.R) && (intent.getSerializableExtra(com.travel.train.j.g.R) instanceof CJRTrainRecentsItemModel)) {
                CJRTrainRecentsItemModel cJRTrainRecentsItemModel = (CJRTrainRecentsItemModel) intent.getSerializableExtra(com.travel.train.j.g.R);
                CJRTrainOriginCityItem cJRTrainOriginCityItem2 = new CJRTrainOriginCityItem();
                CJRTrainOriginCityItem cJRTrainOriginCityItem3 = new CJRTrainOriginCityItem();
                cJRTrainOriginCityItem2.setAirportName(cJRTrainRecentsItemModel.getSourceAirportName());
                cJRTrainOriginCityItem2.setCityCode(cJRTrainRecentsItemModel.getSourceCityCode());
                cJRTrainOriginCityItem2.setCityName(cJRTrainRecentsItemModel.getSourceCityName());
                cJRTrainOriginCityItem2.setDisplayName(cJRTrainRecentsItemModel.getSourceCityName());
                cJRTrainOriginCityItem3.setAirportName(cJRTrainRecentsItemModel.getDestinationAirportName());
                cJRTrainOriginCityItem3.setCityCode(cJRTrainRecentsItemModel.getDestinationCityCode());
                cJRTrainOriginCityItem3.setCityName(cJRTrainRecentsItemModel.getDestinationCityName());
                cJRTrainOriginCityItem3.setDisplayName(cJRTrainRecentsItemModel.getDestinationCityName());
                a(cJRTrainOriginCityItem2);
                b(cJRTrainOriginCityItem3);
            }
        } else if (i2 == 202) {
            if (intent != null && intent.hasExtra("intent_extra_last_known_search_keyword")) {
                this.Y = intent.getStringExtra("intent_extra_last_known_search_keyword");
            }
            if (intent != null && intent.hasExtra("intent_extra_selected_city_position")) {
                this.X = intent.getIntExtra("intent_extra_selected_city_position", -1);
            }
            if (intent != null && intent.hasExtra("intent_extra_selected_city_name")) {
                if (intent.getSerializableExtra("intent_extra_selected_city_name") instanceof CJRTrainRouteStations) {
                    CJRTrainRouteStations cJRTrainRouteStations2 = (CJRTrainRouteStations) intent.getSerializableExtra("intent_extra_selected_city_name");
                    a(cJRTrainRouteStations2.getSource());
                    b(cJRTrainRouteStations2.getDestination());
                } else {
                    CJRTrainOriginCityItem cJRTrainOriginCityItem4 = (CJRTrainOriginCityItem) intent.getSerializableExtra("intent_extra_selected_city_name");
                    if (!(cJRTrainOriginCityItem4 == null || cJRTrainOriginCityItem4.getCityName() == null)) {
                        b(cJRTrainOriginCityItem4);
                    }
                }
            }
            if (this.z.getVisibility() == 0 && this.k <= 0) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        o.this.a(201, "source");
                    }
                }, 500);
            }
            if (intent != null && intent.hasExtra(com.travel.train.j.g.R) && (intent.getSerializableExtra(com.travel.train.j.g.R) instanceof CJRTrainRecentsItemModel)) {
                CJRTrainRecentsItemModel cJRTrainRecentsItemModel2 = (CJRTrainRecentsItemModel) intent.getSerializableExtra(com.travel.train.j.g.R);
                CJRTrainOriginCityItem cJRTrainOriginCityItem5 = new CJRTrainOriginCityItem();
                CJRTrainOriginCityItem cJRTrainOriginCityItem6 = new CJRTrainOriginCityItem();
                cJRTrainOriginCityItem5.setAirportName(cJRTrainRecentsItemModel2.getSourceAirportName());
                cJRTrainOriginCityItem5.setCityCode(cJRTrainRecentsItemModel2.getSourceCityCode());
                cJRTrainOriginCityItem5.setCityName(cJRTrainRecentsItemModel2.getSourceCityName());
                cJRTrainOriginCityItem5.setDisplayName(cJRTrainRecentsItemModel2.getSourceCityName());
                cJRTrainOriginCityItem6.setAirportName(cJRTrainRecentsItemModel2.getDestinationAirportName());
                cJRTrainOriginCityItem6.setCityCode(cJRTrainRecentsItemModel2.getDestinationCityCode());
                cJRTrainOriginCityItem6.setCityName(cJRTrainRecentsItemModel2.getDestinationCityName());
                cJRTrainOriginCityItem6.setDisplayName(cJRTrainRecentsItemModel2.getDestinationCityName());
                a(cJRTrainOriginCityItem5);
                b(cJRTrainOriginCityItem6);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(NetworkCustomError networkCustomError) {
        if (networkCustomError != null && !this.ak) {
            com.paytm.utility.b.f((Context) getActivity(), networkCustomError.getUrl());
        }
    }

    /* access modifiers changed from: private */
    public void a(Pair<String, String> pair) {
        if (pair != null && !this.ak) {
            showErrorDialog((String) pair.first, (String) pair.second);
            CJRTrainSearchInput cJRTrainSearchInput = this.ab;
            String str = "";
            String str2 = cJRTrainSearchInput != null ? cJRTrainSearchInput.getmSourceCityName() : str;
            CJRTrainSearchInput cJRTrainSearchInput2 = this.ab;
            String str3 = cJRTrainSearchInput2 != null ? cJRTrainSearchInput2.getmDestCityName() : str;
            String n2 = com.paytm.utility.b.n((Context) getActivity());
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("train_origin_city", str2);
                hashMap.put("train_destination_city", str3);
                if (n2 != null) {
                    str = n2;
                }
                hashMap.put("train_user_id", str);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains");
                b.a();
                b.b().a("train_home_warning_no_direct_trains", (Map<String, Object>) hashMap, (Context) getActivity());
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(NetworkCustomError networkCustomError) {
        if (networkCustomError != null && !this.ak) {
            String alertTitle = networkCustomError.getAlertTitle();
            String alertMessage = networkCustomError.getAlertMessage();
            if (!TextUtils.isEmpty(alertTitle)) {
                alertTitle = getResources().getString(R.string.network_error_heading);
            }
            if (!TextUtils.isEmpty(alertMessage)) {
                alertMessage = getResources().getString(R.string.network_error_message_train);
            }
            showErrorDialog(alertTitle, alertMessage);
        }
    }

    /* access modifiers changed from: private */
    public void c(NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing() && networkCustomError != null && !this.ak) {
            String string = getResources().getString(R.string.train_maintenance_error_title);
            String string2 = getResources().getString(R.string.train_maintenance_error_description);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(string).setMessage(string2).setCancelable(false);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    o.m(o.this);
                }
            });
            builder.show();
        }
    }

    private void i() {
        l lVar = this.ad;
        if (lVar != null && lVar.isVisible()) {
            this.ad.dismissAllowingStateLoss();
            this.ad = null;
        }
    }

    public void onStop() {
        super.onStop();
        i();
    }

    public void onPause() {
        super.onPause();
        i();
    }

    public void onDestroy() {
        super.onDestroy();
        i();
        removeProgressDialog();
        if (this.ay != null && this.ar.getViewTreeObserver() != null && this.ar.getViewTreeObserver().isAlive()) {
            this.ar.getViewTreeObserver().removeOnScrollChangedListener(this.ay);
        }
    }

    static /* synthetic */ void a(o oVar) {
        String str;
        String charSequence = oVar.r.getText().toString();
        String charSequence2 = oVar.s.getText().toString();
        String charSequence3 = oVar.p.getText().toString();
        String charSequence4 = oVar.q.getText().toString();
        Object tag = oVar.p.getTag();
        Object tag2 = oVar.q.getTag();
        if (!TextUtils.isEmpty(oVar.p.getText().toString()) && !TextUtils.isEmpty(oVar.q.getText().toString())) {
            if (com.paytm.utility.b.n((Context) oVar.getActivity()) != null) {
                str = com.paytm.utility.b.n((Context) oVar.getActivity());
            } else {
                str = "";
            }
            try {
                HashMap hashMap = new HashMap();
                if (str == null) {
                    str = "";
                }
                hashMap.put("train_user_id", str);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains");
                b.a();
                b.b().a("train_home_swap_cities_clicked", (Map<String, Object>) hashMap, (Context) oVar.getActivity());
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
            oVar.r.setText(charSequence2);
            oVar.s.setText(charSequence);
            oVar.p.setText(charSequence4);
            oVar.q.setText(charSequence3);
            oVar.p.setTag(tag2);
            oVar.q.setTag(tag);
            oVar.r.setTag(tag2);
            oVar.s.setTag(tag);
            oVar.C.startAnimation(oVar.J);
            oVar.I.setFillAfter(true);
            oVar.m.startAnimation(oVar.L);
            oVar.n.startAnimation(oVar.K);
        }
    }

    static /* synthetic */ void b(o oVar) {
        TextView textView;
        TextView textView2;
        o oVar2 = oVar;
        AlertDialog create = new AlertDialog.Builder(oVar.getContext()).create();
        View inflate = LayoutInflater.from(oVar.getContext()).inflate(R.layout.pre_t_seat_type_dialog_layout, (ViewGroup) null);
        create.setView(inflate);
        create.show();
        final RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radio_both_type);
        final RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radio_non_ac);
        final RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.radio_ac);
        RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.text_done);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.img_close);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.linear_radio1);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.linear_radio2);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.linear_radio3);
        if (com.travel.train.j.g.f27551a != null) {
            if (!TextUtils.isEmpty(com.travel.train.j.g.f27551a.getAcNonAcText())) {
                radioButton.setText(com.travel.train.j.g.f27551a.getAcNonAcText());
            }
            if (!TextUtils.isEmpty(com.travel.train.j.g.f27551a.getOnlyNonAcTrains())) {
                radioButton2.setText(com.travel.train.j.g.f27551a.getOnlyNonAcTrains());
            }
            if (!TextUtils.isEmpty(com.travel.train.j.g.f27551a.getOnlyAcTrains())) {
                radioButton3.setText(com.travel.train.j.g.f27551a.getOnlyAcTrains());
            }
            if (!TextUtils.isEmpty(com.travel.train.j.g.f27551a.getAcClassesText()) && (textView2 = (TextView) linearLayout3.findViewById(R.id.ac_class_text)) != null) {
                textView2.setText(com.travel.train.j.g.f27551a.getAcClassesText());
            }
            if (!TextUtils.isEmpty(com.travel.train.j.g.f27551a.getNonAcClassesText()) && (textView = (TextView) linearLayout2.findViewById(R.id.non_ac_class_text)) != null) {
                textView.setText(com.travel.train.j.g.f27551a.getNonAcClassesText());
            }
        }
        oVar2.a(radioButton, radioButton2, radioButton3);
        o oVar3 = oVar;
        final RadioButton radioButton4 = radioButton;
        final RadioButton radioButton5 = radioButton2;
        final RadioButton radioButton6 = radioButton3;
        LinearLayout linearLayout4 = linearLayout3;
        AnonymousClass11 r15 = r0;
        final AlertDialog alertDialog = create;
        AnonymousClass11 r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                o oVar = o.this;
                String unused = oVar.f27086h = oVar.f27085g;
                o.this.a(radioButton4, radioButton5, radioButton6);
                alertDialog.dismiss();
            }
        };
        roboTextView.setOnClickListener(r15);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o oVar = o.this;
                String unused = oVar.f27085g = oVar.f27086h;
                o.this.a(radioButton4, radioButton5, radioButton6);
                alertDialog.dismiss();
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.a(o.this, net.one97.paytm.common.utility.d.dw, o.this.f27081c);
                o.b(radioButton, radioButton2, radioButton3, 0);
                o oVar = o.this;
                String unused = oVar.f27086h = oVar.f27085g;
                o oVar2 = o.this;
                String unused2 = oVar2.f27085g = oVar2.getActivity().getResources().getString(R.string.train_bothtype_text);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.a(o.this, net.one97.paytm.common.utility.d.dw, o.this.f27082d);
                o.b(radioButton, radioButton2, radioButton3, 1);
                o oVar = o.this;
                String unused = oVar.f27086h = oVar.f27085g;
                o oVar2 = o.this;
                String unused2 = oVar2.f27085g = oVar2.getActivity().getResources().getString(R.string.train_nonactype_text);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.a(o.this, net.one97.paytm.common.utility.d.dw, o.this.f27083e);
                o.b(radioButton, radioButton2, radioButton3, 2);
                o oVar = o.this;
                String unused = oVar.f27086h = oVar.f27085g;
                o oVar2 = o.this;
                String unused2 = oVar2.f27085g = oVar2.getActivity().getResources().getString(R.string.train_actype_text);
            }
        });
    }

    static /* synthetic */ void a(o oVar, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n((Context) oVar.getActivity()) != null ? com.paytm.utility.b.n((Context) oVar.getActivity()) : "");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains");
            b.a();
            b.b().a(str, (Map<String, Object>) hashMap, (Context) oVar.getActivity());
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    static /* synthetic */ void a(o oVar, Date date, String str) {
        String a2 = i.a((Activity) oVar.getActivity(), "E MMM dd HH:mm:ss Z yyyy", "dd MMM yy", date);
        oVar.V = date.getTime();
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("train_date_source", str);
            hashMap.put("train_travel_date", a2);
            com.travel.train.j.o.a("train_homepage", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "date_selected", "/trains", oVar.getActivity(), (Map<String, Object>) null);
            oVar.a(a2);
        }
    }

    static /* synthetic */ void a(o oVar, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n((Context) oVar.getActivity()) != null ? com.paytm.utility.b.n((Context) oVar.getActivity()) : "");
            hashMap.put(net.one97.paytm.common.utility.d.dd, str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains");
            b.a();
            b.b().a(str, (Map<String, Object>) hashMap, (Context) oVar.getActivity());
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    static /* synthetic */ void m(o oVar) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        b.a();
        b.b().a((Context) oVar.getActivity(), intent);
    }
}
