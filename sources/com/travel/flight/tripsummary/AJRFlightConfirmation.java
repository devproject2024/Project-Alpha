package com.travel.flight.tripsummary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.a;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity;
import com.travel.flight.flightticket.c.c;
import com.travel.flight.flightticket.f.d;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPayment;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRFlightVerify;
import com.travel.flight.pojo.flightticket.CJRRepriceFlightFare;
import com.travel.flight.pojo.flightticket.CJRStatus;
import com.travel.flight.pojo.flightticket.CJRTravellerDetails;
import com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.span.TopAlignProportionalSpan;
import com.travel.flight.tripsummary.c;
import com.travel.flight.utils.j;
import com.travel.utils.n;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.emiSubvention.EMIConstants;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;
import org.json.JSONObject;

public class AJRFlightConfirmation extends PaytmActivity implements View.OnClickListener, d {
    private TextView A;
    private boolean B = false;
    private CJRFlightSearchInput C;
    /* access modifiers changed from: private */
    public CountDownTimer D;
    /* access modifiers changed from: private */
    public long E;
    /* access modifiers changed from: private */
    public long F;
    /* access modifiers changed from: private */
    public String G;
    /* access modifiers changed from: private */
    public int H = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public CJRFlightDetails f25525a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f25526b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<CJRTravellerDetails> f25527c = null;

    /* renamed from: d  reason: collision with root package name */
    private Double f25528d;

    /* renamed from: e  reason: collision with root package name */
    private CJRGSTPassengerInfo f25529e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public NestedScrollView f25530f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f25531g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f25532h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f25533i;
    private View j;
    /* access modifiers changed from: private */
    public final int[] k = {0};
    private View l;
    private View m;
    /* access modifiers changed from: private */
    public c n;
    /* access modifiers changed from: private */
    public LottieAnimationView o;
    /* access modifiers changed from: private */
    public c p;
    private boolean q = false;
    private String r;
    /* access modifiers changed from: private */
    public View s;
    /* access modifiers changed from: private */
    public View t;
    private View u;
    private TextView v;
    private boolean w = false;
    /* access modifiers changed from: private */
    public View x;
    private boolean y;
    private TextView z;

    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0c1b, code lost:
        if (r0.getHeight() < ((r2.getHeight() + r0.getPaddingTop()) + r0.getPaddingBottom())) goto L_0x0c1f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x083c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0854  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x09e5  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0a2d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0b1c  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0b34  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0594  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x05df  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x06d2  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x06ea  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0702  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x074b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r35) {
        /*
            r34 = this;
            r8 = r34
            super.onCreate(r35)
            int r0 = com.travel.flight.R.layout.pre_f_activity_flight_confirmation
            r8.setContentView((int) r0)
            androidx.lifecycle.al r0 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r34)
            java.lang.Class<com.travel.flight.tripsummary.c> r1 = com.travel.flight.tripsummary.c.class
            androidx.lifecycle.ai r0 = r0.a(r1)
            com.travel.flight.tripsummary.c r0 = (com.travel.flight.tripsummary.c) r0
            r8.p = r0
            com.travel.flight.tripsummary.c$a r0 = com.travel.flight.tripsummary.c.n
            com.travel.flight.tripsummary.c.a.a((android.content.Context) r34)
            androidx.appcompat.app.e.m()
            android.content.Intent r0 = r34.getIntent()
            r1 = 0
            if (r0 == 0) goto L_0x0136
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "intent_extra_review_data"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x0045
            android.content.Intent r0 = r34.getIntent()
            java.io.Serializable r0 = r0.getSerializableExtra(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = (com.travel.flight.pojo.flightticket.CJRFlightDetails) r0
            r8.f25525a = r0
            com.travel.flight.tripsummary.c r0 = r8.p
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            r0.f25560a = r2
        L_0x0045:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "intent_extra_trip_type"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x005b
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r0 = r0.getStringExtra(r2)
            r8.f25526b = r0
        L_0x005b:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "flight_traveller_detail"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x0073
            android.content.Intent r0 = r34.getIntent()
            java.io.Serializable r0 = r0.getSerializableExtra(r2)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r8.f25527c = r0
        L_0x0073:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "flight_confirmation_amount"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x008f
            android.content.Intent r0 = r34.getIntent()
            r3 = 0
            double r2 = r0.getDoubleExtra(r2, r3)
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r8.f25528d = r0
        L_0x008f:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "flight_gst_info"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x00a7
            android.content.Intent r0 = r34.getIntent()
            java.io.Serializable r0 = r0.getSerializableExtra(r2)
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r0 = (com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo) r0
            r8.f25529e = r0
        L_0x00a7:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "acceptType"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x00bd
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r0 = r0.getStringExtra(r2)
            r8.r = r0
        L_0x00bd:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "isShare"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x00d3
            android.content.Intent r0 = r34.getIntent()
            boolean r0 = r0.getBooleanExtra(r2, r1)
            r8.B = r0
        L_0x00d3:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "intent_extra_search_input_data"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x00ed
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "intent_extra_search_input_data"
            java.io.Serializable r0 = r0.getSerializableExtra(r2)
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r0 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r0
            r8.C = r0
        L_0x00ed:
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "booking_segment"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x0130
            android.content.Intent r0 = r34.getIntent()
            r2 = -1
            java.lang.String r3 = "booking_segment"
            int r0 = r0.getIntExtra(r3, r2)
            if (r0 != 0) goto L_0x0130
            android.content.Intent r0 = r34.getIntent()
            java.lang.String r2 = "MODIFY_BOOKING_PASSENGERS"
            java.io.Serializable r0 = r0.getSerializableExtra(r2)
            com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails r0 = (com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails) r0
            java.util.List r0 = r0.getPassenger_details()
            if (r0 == 0) goto L_0x0130
            int r2 = com.travel.flight.R.id.travellerList
            android.view.View r2 = r8.findViewById(r2)
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            r3.<init>(r8)
            r2.setLayoutManager(r3)
            com.travel.flight.flightSRPV2.view.ui.a.h r3 = new com.travel.flight.flightSRPV2.view.ui.a.h
            r3.<init>(r0)
            r2.setAdapter(r3)
        L_0x0130:
            com.travel.flight.tripsummary.c r0 = r8.p
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r2 = r8.C
            r0.f25562c = r2
        L_0x0136:
            java.lang.String r0 = "Yes"
            java.util.HashMap r0 = r8.b((java.lang.String) r0)
            java.lang.String r2 = "final_review_page_load"
            b((java.lang.String) r2, (java.util.HashMap<java.lang.String, java.lang.Object>) r0)
            int r0 = com.travel.flight.R.id.parentContainer
            android.view.View r0 = r8.findViewById(r0)
            r8.u = r0
            android.view.View r0 = r8.u
            r8.x = r0
            int r0 = com.travel.flight.R.id.flight_reprice_dialog
            android.view.View r0 = r8.findViewById(r0)
            r8.t = r0
            int r0 = com.travel.flight.R.id.cashback_reprice
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.v = r0
            int r0 = com.travel.flight.R.id.progress_animation_view
            android.view.View r0 = r8.findViewById(r0)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            r8.o = r0
            com.airbnb.lottie.LottieAnimationView r0 = r8.o
            java.lang.String r2 = "flight_booking_progress_anim.json"
            java.lang.String r2 = com.travel.flight.utils.c.b((android.content.Context) r8, (java.lang.String) r2)
            r3 = 0
            r0.setAnimationFromJson(r2, r3)
            int r0 = com.travel.flight.R.id.animationParent
            android.view.View r0 = r8.findViewById(r0)
            r8.s = r0
            int r0 = com.travel.flight.R.id.scroll_view_container
            android.view.View r0 = r8.findViewById(r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            r8.f25530f = r0
            int r0 = com.travel.flight.R.id.arrow_down_floating_button
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r8.f25531g = r0
            int r0 = com.travel.flight.R.id.selling_package_bundle_type_tv
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.f25532h = r0
            int r0 = com.travel.flight.R.id.selling_package_bundle_type_iv
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r8.f25533i = r0
            int r0 = com.travel.flight.R.id.selling_package_bundle
            android.view.View r0 = r8.findViewById(r0)
            r8.j = r0
            int r0 = com.travel.flight.R.id.close_button
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r2 = com.travel.common.R.drawable.travel_res_common_close
            r0.setImageResource(r2)
            r0.setOnClickListener(r8)
            int r0 = com.travel.flight.R.id.gst_view_more
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r8.f25531g
            r0.setOnClickListener(r8)
            int r0 = com.travel.flight.R.id.proceed_to_pay_button
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.z = r0
            int r0 = com.travel.flight.R.id.cashback_text
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.A = r0
            android.widget.TextView r0 = r8.z
            r0.setOnClickListener(r8)
            r8.a((android.widget.TextView) r3)
            androidx.core.widget.NestedScrollView r0 = r8.f25530f
            com.travel.flight.tripsummary.AJRFlightConfirmation$10 r2 = new com.travel.flight.tripsummary.AJRFlightConfirmation$10
            r2.<init>()
            r0.setOnScrollChangeListener(r2)
            int r0 = com.travel.flight.R.id.progress_two_way_onward_flight_icon
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r2 = com.travel.flight.R.id.progress_img_view_onward_first_hop_logo
            android.view.View r2 = r8.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r4 = com.travel.flight.R.id.progress_img_view_onward_second_hop_logo
            android.view.View r4 = r8.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r8.a((android.widget.ImageView) r0, (android.widget.ImageView) r2, (android.widget.ImageView) r4)
            int r0 = com.travel.flight.R.id.reprice_two_way_onward_flight_icon
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r2 = com.travel.flight.R.id.reprice_img_view_onward_first_hop_logo
            android.view.View r2 = r8.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r4 = com.travel.flight.R.id.reprice_img_view_onward_second_hop_logo
            android.view.View r4 = r8.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r8.a((android.widget.ImageView) r0, (android.widget.ImageView) r2, (android.widget.ImageView) r4)
            com.travel.flight.tripsummary.c r0 = r8.p
            androidx.lifecycle.y<com.travel.flight.utils.f> r2 = r0.f25563d
            com.travel.flight.tripsummary.AJRFlightConfirmation$14 r4 = new com.travel.flight.tripsummary.AJRFlightConfirmation$14
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightSearchResult> r2 = r0.f25564e
            com.travel.flight.tripsummary.AJRFlightConfirmation$15 r4 = new com.travel.flight.tripsummary.AJRFlightConfirmation$15
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightPayment> r2 = r0.f25565f
            com.travel.flight.tripsummary.AJRFlightConfirmation$16 r4 = new com.travel.flight.tripsummary.AJRFlightConfirmation$16
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightPayment> r2 = r0.f25566g
            com.travel.flight.tripsummary.AJRFlightConfirmation$17 r4 = new com.travel.flight.tripsummary.AJRFlightConfirmation$17
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<com.travel.flight.pojo.flightticket.CJRFlightVerify> r2 = r0.f25567h
            com.travel.flight.tripsummary.AJRFlightConfirmation$2 r4 = new com.travel.flight.tripsummary.AJRFlightConfirmation$2
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<java.lang.Boolean> r2 = r0.f25568i
            com.travel.flight.tripsummary.-$$Lambda$AJRFlightConfirmation$qeR5wjg4e7H6Q8QLuHfQu9SYL_w r4 = new com.travel.flight.tripsummary.-$$Lambda$AJRFlightConfirmation$qeR5wjg4e7H6Q8QLuHfQu9SYL_w
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<java.lang.Boolean> r2 = r0.j
            com.travel.flight.tripsummary.AJRFlightConfirmation$3 r4 = new com.travel.flight.tripsummary.AJRFlightConfirmation$3
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<com.travel.flight.utils.f> r2 = r0.k
            com.travel.flight.tripsummary.AJRFlightConfirmation$4 r4 = new com.travel.flight.tripsummary.AJRFlightConfirmation$4
            r4.<init>()
            r2.observe(r8, r4)
            androidx.lifecycle.y<com.travel.flight.utils.f> r0 = r0.l
            com.travel.flight.tripsummary.AJRFlightConfirmation$5 r2 = new com.travel.flight.tripsummary.AJRFlightConfirmation$5
            r2.<init>()
            r0.observe(r8, r2)
            java.lang.String r0 = r8.f25526b
            if (r0 == 0) goto L_0x0bff
            int r0 = com.travel.flight.R.id.lyt_flight_summary_info
            android.view.View r0 = r8.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r5 = r8.f25526b
            java.lang.String r6 = "round_trip"
            boolean r5 = r5.equals(r6)
            java.lang.String r7 = "-"
            if (r5 == 0) goto L_0x0863
            com.travel.flight.pojo.flightticket.CJRFlightDetails r5 = r8.f25525a
            if (r5 == 0) goto L_0x0860
            android.view.LayoutInflater r5 = r34.getLayoutInflater()
            int r11 = com.travel.flight.R.layout.pre_f_lyt_flight_two_way_summary
            android.view.View r3 = r5.inflate(r11, r3, r1)
            int r5 = com.travel.flight.R.id.two_way_summary_lastDivider
            android.view.View r5 = r3.findViewById(r5)
            r8.m = r5
            int r5 = com.travel.flight.R.id.two_way_onward_flight_name
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r11 = com.travel.flight.R.id.two_way_onward_flight_number
            android.view.View r11 = r3.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = com.travel.flight.R.id.two_way_left_onward_date
            android.view.View r12 = r3.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r13 = com.travel.flight.R.id.two_way_left_onward_time
            android.view.View r13 = r3.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            int r14 = com.travel.flight.R.id.two_way_left_onward_place
            android.view.View r14 = r3.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.travel.flight.R.id.two_way_onward_duration
            android.view.View r15 = r3.findViewById(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            int r10 = com.travel.flight.R.id.two_way_onward_stops
            android.view.View r10 = r3.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r6 = com.travel.flight.R.id.twoway_onward_right_date
            android.view.View r6 = r3.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r9 = com.travel.flight.R.id.two_way_onward_right_time
            android.view.View r9 = r3.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r2 = com.travel.flight.R.id.two_way_onward_right_place
            android.view.View r2 = r3.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r4 = com.travel.flight.R.id.two_way_return_flight_name
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r1 = com.travel.flight.R.id.two_way_return_flight_number
            android.view.View r1 = r3.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r17 = r0
            int r0 = com.travel.flight.R.id.two_way_left_return_date
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r18 = r1
            int r1 = com.travel.flight.R.id.two_way_left_return_time
            android.view.View r1 = r3.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r19 = r4
            int r4 = com.travel.flight.R.id.two_way_left_return_place
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r20 = r10
            int r10 = com.travel.flight.R.id.two_way_return_duration
            android.view.View r10 = r3.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r21 = r2
            int r2 = com.travel.flight.R.id.two_way_return_stops
            android.view.View r2 = r3.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r22 = r2
            int r2 = com.travel.flight.R.id.twoway_return_right_date
            android.view.View r2 = r3.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r23 = r11
            int r11 = com.travel.flight.R.id.two_way_return_right_time
            android.view.View r11 = r3.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r24 = r7
            int r7 = com.travel.flight.R.id.two_way_return_right_place
            android.view.View r7 = r3.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r25 = r7
            int r7 = com.travel.flight.R.id.onward_class_txt
            android.view.View r7 = r3.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r26 = r7
            int r7 = com.travel.flight.R.id.return_class_txt
            android.view.View r7 = r3.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r27 = r7
            int r7 = com.travel.flight.R.id.two_way_onward_flight_icon
            android.view.View r7 = r3.findViewById(r7)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r28 = r5
            int r5 = com.travel.flight.R.id.img_view_onward_first_hop_logo
            android.view.View r5 = r3.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r29 = r11
            int r11 = com.travel.flight.R.id.img_view_onward_second_hop_logo
            android.view.View r11 = r3.findViewById(r11)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r30 = r2
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            if (r2 == 0) goto L_0x0410
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            boolean r2 = r2.isStitched()
            if (r2 != 0) goto L_0x03d0
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            boolean r2 = r2.isProviderStitch()
            if (r2 == 0) goto L_0x03b6
            goto L_0x03d0
        L_0x03b6:
            r2 = 0
            r7.setVisibility(r2)
            r2 = 8
            r5.setVisibility(r2)
            r11.setVisibility(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            java.lang.String r2 = r2.getmAirLineCode()
            a((java.lang.String) r2, (android.widget.ImageView) r7)
            goto L_0x0410
        L_0x03d0:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            java.util.ArrayList r2 = r2.getmFlights()
            if (r2 == 0) goto L_0x0410
            r31 = r10
            int r10 = r2.size()
            r32 = r1
            r1 = 1
            if (r10 <= r1) goto L_0x0414
            r10 = 0
            java.lang.Object r16 = r2.get(r10)
            r33 = r16
            com.travel.flight.pojo.flightticket.CJRFlightStops r33 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r33
            java.lang.Object r2 = r2.get(r1)
            com.travel.flight.pojo.flightticket.CJRFlightStops r2 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r2
            r5.setVisibility(r10)
            r11.setVisibility(r10)
            r1 = 8
            r7.setVisibility(r1)
            java.lang.String r1 = r33.getmAirLineCode()
            a((java.lang.String) r1, (android.widget.ImageView) r5)
            java.lang.String r1 = r2.getmAirLineCode()
            a((java.lang.String) r1, (android.widget.ImageView) r11)
            goto L_0x0414
        L_0x0410:
            r32 = r1
            r31 = r10
        L_0x0414:
            int r1 = com.travel.flight.R.id.two_way_return_flight_icon
            android.view.View r1 = r3.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            int r2 = com.travel.flight.R.id.img_view_return_first_hop_logo
            android.view.View r2 = r3.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r5 = com.travel.flight.R.id.img_view_return_second_hop_logo
            android.view.View r5 = r3.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            com.travel.flight.pojo.flightticket.CJRFlightDetails r7 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r7 = r7.getmReturnJourney()
            if (r7 == 0) goto L_0x04a2
            com.travel.flight.pojo.flightticket.CJRFlightDetails r7 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r7 = r7.getmReturnJourney()
            boolean r7 = r7.isStitched()
            if (r7 != 0) goto L_0x0467
            com.travel.flight.pojo.flightticket.CJRFlightDetails r7 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r7 = r7.getmReturnJourney()
            boolean r7 = r7.isProviderStitch()
            if (r7 == 0) goto L_0x044d
            goto L_0x0467
        L_0x044d:
            r7 = 0
            r1.setVisibility(r7)
            r7 = 8
            r2.setVisibility(r7)
            r5.setVisibility(r7)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmReturnJourney()
            java.lang.String r2 = r2.getmAirLineCode()
            a((java.lang.String) r2, (android.widget.ImageView) r1)
            goto L_0x04a2
        L_0x0467:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r7 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r7 = r7.getmReturnJourney()
            java.util.ArrayList r7 = r7.getmFlights()
            if (r7 == 0) goto L_0x04a2
            int r10 = r7.size()
            r11 = 1
            if (r10 <= r11) goto L_0x04a2
            r10 = 0
            java.lang.Object r16 = r7.get(r10)
            r33 = r16
            com.travel.flight.pojo.flightticket.CJRFlightStops r33 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r33
            java.lang.Object r7 = r7.get(r11)
            com.travel.flight.pojo.flightticket.CJRFlightStops r7 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r7
            r2.setVisibility(r10)
            r5.setVisibility(r10)
            r10 = 8
            r1.setVisibility(r10)
            java.lang.String r1 = r33.getmAirLineCode()
            a((java.lang.String) r1, (android.widget.ImageView) r2)
            java.lang.String r1 = r7.getmAirLineCode()
            a((java.lang.String) r1, (android.widget.ImageView) r5)
        L_0x04a2:
            int r1 = com.travel.flight.R.id.one_way_summary_lastDivider
            android.view.View r1 = r3.findViewById(r1)
            r8.l = r1
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
            java.util.ArrayList r1 = r1.getmFlights()
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.travel.flight.pojo.flightticket.CJRFlightStops r1 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r1
            com.travel.flight.pojo.flightticket.CJRFlightDetails r5 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r5 = r5.getmReturnJourney()
            java.util.ArrayList r5 = r5.getmFlights()
            java.lang.Object r5 = r5.get(r2)
            com.travel.flight.pojo.flightticket.CJRFlightStops r5 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r5
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            java.lang.String r2 = r2.getmDepartureTime()
            java.lang.String r2 = com.travel.flight.utils.c.e(r2)
            r12.setText(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            java.lang.String r2 = r2.getmDepartureTime()
            java.lang.String r2 = com.travel.flight.utils.c.b(r2)
            r13.setText(r2)
            java.lang.String r2 = r1.getOriginCity()
            r14.setText(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            java.lang.String r2 = r2.getmDuration()
            r15.setText(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            java.lang.String r2 = r2.getmArrivalTime()
            java.lang.String r2 = com.travel.flight.utils.c.e(r2)
            r6.setText(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
            java.lang.String r2 = r2.getmArrivalTime()
            java.lang.String r2 = com.travel.flight.utils.c.b(r2)
            r9.setText(r2)
            java.lang.String r2 = r5.getOriginCity()
            r4.setText(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmReturnJourney()
            java.lang.String r2 = r2.getmDepartureTime()
            java.lang.String r2 = com.travel.flight.utils.c.e(r2)
            r0.setText(r2)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.lang.String r0 = r0.getmDepartureTime()
            java.lang.String r0 = com.travel.flight.utils.c.b(r0)
            r2 = r32
            r2.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.lang.String r0 = r0.getmDuration()
            r10 = r31
            r10.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.lang.String r0 = r0.getmArrivalTime()
            java.lang.String r0 = com.travel.flight.utils.c.e(r0)
            r2 = r30
            r2.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.lang.String r0 = r0.getmArrivalTime()
            java.lang.String r0 = com.travel.flight.utils.c.b(r0)
            r11 = r29
            r11.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r2 = 1
            if (r0 != r2) goto L_0x05df
            java.lang.String r0 = r1.getmAirLine()
            r2 = r28
            r2.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r1.getmAirLineCode()
            r0.append(r2)
            r4 = r24
            r0.append(r4)
            java.lang.String r2 = r1.getmFlightNumber()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r11 = r23
            r11.setText(r0)
            java.lang.String r0 = r1.getDestinationCity()
            r1 = r21
            r1.setText(r0)
            int r0 = com.travel.flight.R.string.non_stop_flight
            java.lang.String r0 = r8.getString(r0)
            r10 = r20
            r10.setText(r0)
            int r0 = com.travel.flight.R.id.lyt_two_way_onward_stop
            android.view.View r0 = r3.findViewById(r0)
            r1 = 8
            r0.setVisibility(r1)
            goto L_0x06b8
        L_0x05df:
            r10 = r20
            r1 = r21
            r11 = r23
            r4 = r24
            r2 = r28
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r6.getmOnwardJourney()
            java.util.ArrayList r6 = r6.getmFlights()
            int r6 = r6.size()
            r7 = 1
            int r6 = r6 - r7
            java.lang.Object r0 = r0.get(r6)
            com.travel.flight.pojo.flightticket.CJRFlightStops r0 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r0
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r6.getmOnwardJourney()
            java.util.ArrayList r6 = r6.getmFlights()
            java.lang.String r6 = a((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r6)
            r2.setText(r6)
            java.lang.String r0 = r0.getDestinationCity()
            r1.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            java.lang.String r0 = c((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r0)
            r11.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            java.lang.String r0 = r8.b((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r0)
            r10.setText(r0)
            int r0 = com.travel.flight.R.id.lyt_two_way_onward_stop
            android.view.View r0 = r3.findViewById(r0)
            r1 = 0
            r0.setVisibility(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r2 = 2
            if (r0 != r2) goto L_0x0668
            int r0 = com.travel.flight.R.id.two_way_onward_second_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            goto L_0x06b8
        L_0x0668:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r2 = 3
            if (r0 != r2) goto L_0x068c
            int r0 = com.travel.flight.R.id.two_way_onward_first_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.two_way_onward_third_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            goto L_0x06b8
        L_0x068c:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r2 = 4
            if (r0 != r2) goto L_0x06b8
            int r0 = com.travel.flight.R.id.two_way_onward_first_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.two_way_onward_second_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.two_way_onward_third_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
        L_0x06b8:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            if (r0 == 0) goto L_0x06ea
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            if (r0 == 0) goto L_0x06ea
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.lang.String r0 = r0.getmBookingClass()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x06ea
            r7 = r26
            r0 = 0
            r7.setVisibility(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.lang.String r0 = r0.getmBookingClass()
            java.lang.String r0 = r8.a((java.lang.String) r0)
            r7.setText(r0)
            goto L_0x06f1
        L_0x06ea:
            r7 = r26
            r0 = 8
            r7.setVisibility(r0)
        L_0x06f1:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x074b
            java.lang.String r0 = r5.getmAirLine()
            r1 = r19
            r1.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r5.getmAirLineCode()
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = r5.getmFlightNumber()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2 = r18
            r2.setText(r0)
            java.lang.String r0 = r5.getDestinationCity()
            r7 = r25
            r7.setText(r0)
            int r0 = com.travel.flight.R.string.non_stop_flight
            java.lang.String r0 = r8.getString(r0)
            r4 = r22
            r4.setText(r0)
            int r0 = com.travel.flight.R.id.lyt_two_way_return_stop
            android.view.View r0 = r3.findViewById(r0)
            r1 = 8
            r0.setVisibility(r1)
            goto L_0x0822
        L_0x074b:
            r2 = r18
            r1 = r19
            r4 = r22
            r7 = r25
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r5 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r5 = r5.getmReturnJourney()
            java.util.ArrayList r5 = r5.getmFlights()
            int r5 = r5.size()
            r6 = 1
            int r5 = r5 - r6
            java.lang.Object r0 = r0.get(r5)
            com.travel.flight.pojo.flightticket.CJRFlightStops r0 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r0
            com.travel.flight.pojo.flightticket.CJRFlightDetails r5 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r5 = r5.getmReturnJourney()
            java.util.ArrayList r5 = r5.getmFlights()
            java.lang.String r5 = a((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r5)
            r1.setText(r5)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmReturnJourney()
            java.util.ArrayList r1 = r1.getmFlights()
            java.lang.String r1 = c((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r1)
            r2.setText(r1)
            java.lang.String r0 = r0.getDestinationCity()
            r7.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            java.lang.String r0 = r8.b((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r0)
            r4.setText(r0)
            int r0 = com.travel.flight.R.id.lyt_two_way_return_stop
            android.view.View r0 = r3.findViewById(r0)
            r1 = 0
            r0.setVisibility(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r2 = 2
            if (r0 != r2) goto L_0x07d2
            int r0 = com.travel.flight.R.id.two_way_return_second_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            goto L_0x0822
        L_0x07d2:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r2 = 3
            if (r0 != r2) goto L_0x07f6
            int r0 = com.travel.flight.R.id.two_way_return_first_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.two_way_return_third_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            goto L_0x0822
        L_0x07f6:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r2 = 4
            if (r0 != r2) goto L_0x0822
            int r0 = com.travel.flight.R.id.two_way_return_first_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.two_way_return_second_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.two_way_return_third_stop
            android.view.View r0 = r3.findViewById(r0)
            r0.setVisibility(r1)
        L_0x0822:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            if (r0 == 0) goto L_0x0854
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            if (r0 == 0) goto L_0x0854
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.lang.String r0 = r0.getmBookingClass()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0854
            r7 = r27
            r0 = 0
            r7.setVisibility(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmReturnJourney()
            java.lang.String r0 = r0.getmBookingClass()
            java.lang.String r0 = r8.a((java.lang.String) r0)
            r7.setText(r0)
            goto L_0x085b
        L_0x0854:
            r7 = r27
            r0 = 8
            r7.setVisibility(r0)
        L_0x085b:
            r0 = r17
            r0.addView(r3)
        L_0x0860:
            r4 = 1
            goto L_0x0b40
        L_0x0863:
            r4 = r7
            android.view.LayoutInflater r1 = r34.getLayoutInflater()
            int r2 = com.travel.flight.R.layout.pre_f_lyt_flight_one_way_summary
            r5 = 0
            android.view.View r1 = r1.inflate(r2, r3, r5)
            int r2 = com.travel.flight.R.id.one_way_flight_icon
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r3 = com.travel.flight.R.id.img_view_first_hop_logo
            android.view.View r3 = r1.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            int r5 = com.travel.flight.R.id.img_view_second_hop_logo
            android.view.View r5 = r1.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            int r6 = com.travel.flight.R.id.one_way_flight_name
            android.view.View r6 = r1.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.travel.flight.R.id.one_way_flight_number
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r9 = com.travel.flight.R.id.oneway_onward_date
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r10 = com.travel.flight.R.id.one_way_onward_time
            android.view.View r10 = r1.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r11 = com.travel.flight.R.id.one_way_onward_place
            android.view.View r11 = r1.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = com.travel.flight.R.id.one_way_duration
            android.view.View r12 = r1.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r13 = com.travel.flight.R.id.one_way_stops
            android.view.View r13 = r1.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            int r14 = com.travel.flight.R.id.oneway_return_date
            android.view.View r14 = r1.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.travel.flight.R.id.one_way_return_time
            android.view.View r15 = r1.findViewById(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r17 = r0
            int r0 = com.travel.flight.R.id.one_way_return_place
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r18 = r13
            int r13 = com.travel.flight.R.id.one_way_class_txt
            android.view.View r13 = r1.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r19 = r13
            int r13 = com.travel.flight.R.id.one_way_summary_lastDivider
            android.view.View r13 = r1.findViewById(r13)
            r8.l = r13
            com.travel.flight.pojo.flightticket.CJRFlightDetails r13 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r13 = r13.getmOnwardJourney()
            if (r13 == 0) goto L_0x0967
            com.travel.flight.pojo.flightticket.CJRFlightDetails r13 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r13 = r13.getmOnwardJourney()
            boolean r13 = r13.isStitched()
            if (r13 != 0) goto L_0x0928
            com.travel.flight.pojo.flightticket.CJRFlightDetails r13 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r13 = r13.getmOnwardJourney()
            boolean r13 = r13.isProviderStitch()
            if (r13 == 0) goto L_0x090e
            goto L_0x0928
        L_0x090e:
            r13 = 0
            r2.setVisibility(r13)
            r13 = 8
            r3.setVisibility(r13)
            r5.setVisibility(r13)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmOnwardJourney()
            java.lang.String r3 = r3.getmAirLineCode()
            a((java.lang.String) r3, (android.widget.ImageView) r2)
            goto L_0x0967
        L_0x0928:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r13 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r13 = r13.getmOnwardJourney()
            java.util.ArrayList r13 = r13.getmFlights()
            if (r13 == 0) goto L_0x0967
            r20 = r1
            int r1 = r13.size()
            r21 = r0
            r0 = 1
            if (r1 <= r0) goto L_0x096b
            r1 = 0
            java.lang.Object r16 = r13.get(r1)
            r22 = r16
            com.travel.flight.pojo.flightticket.CJRFlightStops r22 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r22
            java.lang.Object r13 = r13.get(r0)
            com.travel.flight.pojo.flightticket.CJRFlightStops r13 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r13
            r3.setVisibility(r1)
            r5.setVisibility(r1)
            r0 = 4
            r2.setVisibility(r0)
            java.lang.String r0 = r22.getmAirLineCode()
            a((java.lang.String) r0, (android.widget.ImageView) r3)
            java.lang.String r0 = r13.getmAirLineCode()
            a((java.lang.String) r0, (android.widget.ImageView) r5)
            goto L_0x096b
        L_0x0967:
            r21 = r0
            r20 = r1
        L_0x096b:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.CJRFlightStops r0 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r0
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
            java.lang.String r1 = r1.getmDepartureTime()
            java.lang.String r1 = com.travel.flight.utils.c.e(r1)
            r9.setText(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
            java.lang.String r1 = r1.getmDepartureTime()
            java.lang.String r1 = com.travel.flight.utils.c.b(r1)
            r10.setText(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
            java.lang.String r1 = r1.getmDuration()
            r12.setText(r1)
            java.lang.String r1 = r0.getOriginCity()
            r11.setText(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
            java.lang.String r1 = r1.getmArrivalTime()
            java.lang.String r1 = com.travel.flight.utils.c.e(r1)
            r14.setText(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
            java.lang.String r1 = r1.getmArrivalTime()
            java.lang.String r1 = com.travel.flight.utils.c.b(r1)
            r15.setText(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
            java.util.ArrayList r1 = r1.getmFlights()
            int r1 = r1.size()
            r2 = 1
            if (r1 != r2) goto L_0x0a2d
            java.lang.String r1 = r0.getmAirLine()
            r6.setText(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getmAirLineCode()
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = r0.getmFlightNumber()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.setText(r1)
            java.lang.String r0 = r0.getDestinationCity()
            r1 = r21
            r1.setText(r0)
            int r0 = com.travel.flight.R.string.non_stop_flight
            java.lang.String r0 = r8.getString(r0)
            r13 = r18
            r13.setText(r0)
            int r0 = com.travel.flight.R.id.lyt_one_way_stop
            r2 = r20
            android.view.View r0 = r2.findViewById(r0)
            r1 = 8
            r0.setVisibility(r1)
            r4 = 1
            goto L_0x0b02
        L_0x0a2d:
            r13 = r18
            r2 = r20
            r1 = r21
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            java.lang.String r0 = a((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r0)
            r6.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            java.lang.String r0 = c((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r0)
            r7.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r3 = r3.getmOnwardJourney()
            java.util.ArrayList r3 = r3.getmFlights()
            int r3 = r3.size()
            r4 = 1
            int r3 = r3 - r4
            java.lang.Object r0 = r0.get(r3)
            com.travel.flight.pojo.flightticket.CJRFlightStops r0 = (com.travel.flight.pojo.flightticket.CJRFlightStops) r0
            java.lang.String r0 = r0.getDestinationCity()
            r1.setText(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            java.lang.String r0 = r8.b((java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRFlightStops>) r0)
            r13.setText(r0)
            int r0 = com.travel.flight.R.id.lyt_one_way_stop
            android.view.View r0 = r2.findViewById(r0)
            r1 = 0
            r0.setVisibility(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r3 = 2
            if (r0 != r3) goto L_0x0ab2
            int r0 = com.travel.flight.R.id.one_way_second_stop
            android.view.View r0 = r2.findViewById(r0)
            r0.setVisibility(r1)
            goto L_0x0b02
        L_0x0ab2:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r3 = 3
            if (r0 != r3) goto L_0x0ad6
            int r0 = com.travel.flight.R.id.one_way_first_stop
            android.view.View r0 = r2.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.one_way_third_stop
            android.view.View r0 = r2.findViewById(r0)
            r0.setVisibility(r1)
            goto L_0x0b02
        L_0x0ad6:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.util.ArrayList r0 = r0.getmFlights()
            int r0 = r0.size()
            r3 = 4
            if (r0 != r3) goto L_0x0b02
            int r0 = com.travel.flight.R.id.one_way_first_stop
            android.view.View r0 = r2.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.one_way_second_stop
            android.view.View r0 = r2.findViewById(r0)
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.one_way_third_stop
            android.view.View r0 = r2.findViewById(r0)
            r0.setVisibility(r1)
        L_0x0b02:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            if (r0 == 0) goto L_0x0b34
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            if (r0 == 0) goto L_0x0b34
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.lang.String r0 = r0.getmBookingClass()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0b34
            r13 = r19
            r0 = 0
            r13.setVisibility(r0)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r0.getmOnwardJourney()
            java.lang.String r0 = r0.getmBookingClass()
            java.lang.String r0 = r8.a((java.lang.String) r0)
            r13.setText(r0)
            goto L_0x0b3b
        L_0x0b34:
            r13 = r19
            r0 = 8
            r13.setVisibility(r0)
        L_0x0b3b:
            r0 = r17
            r0.addView(r2)
        L_0x0b40:
            r34.a()
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r0 = r8.f25529e
            if (r0 == 0) goto L_0x0b68
            java.lang.String r0 = r0.getGSTNumber()
            if (r0 == 0) goto L_0x0b68
            int r0 = com.travel.flight.R.id.gst_container
            android.view.View r0 = r8.findViewById(r0)
            r1 = 0
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.flight_gst_number
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r1 = r8.f25529e
            java.lang.String r1 = r1.getGSTNumber()
            r0.setText(r1)
        L_0x0b68:
            androidx.core.widget.NestedScrollView r0 = r8.f25530f
            com.travel.flight.tripsummary.AJRFlightConfirmation$11 r1 = new com.travel.flight.tripsummary.AJRFlightConfirmation$11
            r1.<init>()
            r0.post(r1)
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            if (r0 == 0) goto L_0x0bf7
            java.util.List r0 = r0.getBundleList()
            if (r0 == 0) goto L_0x0bf7
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            java.util.List r0 = r0.getBundleList()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0bf7
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            java.util.List r0 = r0.getBundleList()
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData r0 = (com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData) r0
            java.lang.String r1 = r0.getTrip_summary_icon_url()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0bd3
            android.widget.ImageView r1 = r8.f25533i
            android.content.Context r1 = r1.getContext()
            com.paytm.utility.b.b$a$a r1 = com.paytm.utility.b.b.a(r1)
            java.lang.String r2 = r0.getTrip_summary_icon_url()
            r1.f43753a = r2
            android.content.res.Resources r2 = r34.getResources()
            int r3 = com.travel.flight.R.drawable.pre_f_defaultcarrier
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            com.paytm.utility.b.b$a$a r1 = r1.a((java.lang.Object) r2)
            android.content.res.Resources r2 = r34.getResources()
            int r3 = com.travel.flight.R.drawable.pre_f_defaultcarrier
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)
            com.paytm.utility.b.b$a$a r1 = r1.b(r2)
            android.widget.ImageView r2 = r8.f25533i
            r1.a((android.widget.ImageView) r2)
        L_0x0bd3:
            java.lang.String r1 = r0.getProduct_title()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0be6
            android.widget.TextView r1 = r8.f25532h
            java.lang.String r0 = r0.getProduct_title()
            r1.setText(r0)
        L_0x0be6:
            android.view.View r0 = r8.l
            r1 = 8
            if (r0 == 0) goto L_0x0bef
            r0.setVisibility(r1)
        L_0x0bef:
            android.view.View r0 = r8.m
            if (r0 == 0) goto L_0x0c00
            r0.setVisibility(r1)
            goto L_0x0c00
        L_0x0bf7:
            r1 = 8
            android.view.View r0 = r8.j
            r0.setVisibility(r1)
            goto L_0x0c00
        L_0x0bff:
            r4 = 1
        L_0x0c00:
            androidx.core.widget.NestedScrollView r0 = r8.f25530f
            r1 = 0
            android.view.View r2 = r0.getChildAt(r1)
            if (r2 == 0) goto L_0x0c1e
            int r1 = r2.getHeight()
            int r2 = r0.getHeight()
            int r3 = r0.getPaddingTop()
            int r1 = r1 + r3
            int r0 = r0.getPaddingBottom()
            int r1 = r1 + r0
            if (r2 >= r1) goto L_0x0c1e
            goto L_0x0c1f
        L_0x0c1e:
            r4 = 0
        L_0x0c1f:
            if (r4 == 0) goto L_0x0c28
            android.widget.ImageView r0 = r8.f25531g
            r1 = 0
            r0.setVisibility(r1)
            goto L_0x0c2f
        L_0x0c28:
            android.widget.ImageView r0 = r8.f25531g
            r1 = 8
            r0.setVisibility(r1)
        L_0x0c2f:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            if (r0 == 0) goto L_0x0ca3
            com.travel.flight.pojo.flightticket.CJRFJRFlightSessionInfo r0 = r0.getSessionInfo()
            if (r0 != 0) goto L_0x0c3a
            goto L_0x0ca3
        L_0x0c3a:
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r8.f25525a
            com.travel.flight.pojo.flightticket.CJRFJRFlightSessionInfo r7 = r0.getSessionInfo()
            int r0 = r7.getSessionTime()
            if (r0 == 0) goto L_0x0ca3
            java.lang.String r0 = r7.getSessionMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0c51
            goto L_0x0ca3
        L_0x0c51:
            int r0 = com.travel.flight.R.string.flight_countdown_timer_count
            java.lang.String r0 = r8.getString(r0)
            r8.G = r0
            android.os.CountDownTimer r0 = r8.D
            if (r0 == 0) goto L_0x0c60
            r0.cancel()
        L_0x0c60:
            int r4 = r7.getSessionTime()
            int r0 = com.travel.flight.R.id.timer_lyt
            android.view.View r0 = r8.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            int r1 = com.travel.flight.R.id.count_down_text
            android.view.View r1 = r8.findViewById(r1)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            r1 = 0
            r0.setVisibility(r1)
            int r0 = com.travel.flight.R.id.timer_bg_view
            android.view.View r0 = r8.findViewById(r0)
            r6 = r0
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            int r0 = com.travel.flight.R.id.timer_session_text
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r7.getSessionMessage()
            r0.setText(r1)
            com.travel.flight.tripsummary.AJRFlightConfirmation$1 r9 = new com.travel.flight.tripsummary.AJRFlightConfirmation$1
            int r0 = r4 * 1000
            long r2 = (long) r0
            r0 = r9
            r1 = r34
            r0.<init>(r2, r4, r5, r6, r7)
            r8.D = r9
            android.os.CountDownTimer r0 = r8.D
            r0.start()
        L_0x0ca3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.AJRFlightConfirmation.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.D;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void attachBaseContext(Context context) {
        b.a();
        super.attachBaseContext(b.b().d(context));
        q.a(this);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }

    private void a(TextView textView) {
        if (this.f25528d != null) {
            String str = getResources().getString(R.string.flight_summary_book_text) + " " + getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(this.f25528d.doubleValue());
            this.z.setText(str);
            if (textView != null) {
                textView.setText(str);
            }
        }
        CJRFlightDetails cJRFlightDetails = this.f25525a;
        if (cJRFlightDetails == null || cJRFlightDetails.getPromoResponse() == null || this.f25525a.getPromoResponse().getBody() == null || this.f25525a.getPromoResponse().getBody().getPaytmDiscount() <= 0) {
            CJRFlightDetails cJRFlightDetails2 = this.f25525a;
            if (cJRFlightDetails2 == null || cJRFlightDetails2.getPromoResponse() == null || this.f25525a.getPromoResponse().getBody() == null || (this.f25525a.getPromoResponse().getBody().getPaytmCashback() <= 0 && this.f25525a.getPromoResponse().getBody().getPaytmPgcashback() <= 0)) {
                CJRFlightDetails cJRFlightDetails3 = this.f25525a;
                if (cJRFlightDetails3 == null || cJRFlightDetails3.getPromoResponse() == null || this.f25525a.getPromoResponse().getBody() == null || this.f25525a.getPromoResponse().getBody().getPaytmGoldback() <= 0) {
                    this.A.setVisibility(8);
                    this.v.setVisibility(8);
                    return;
                }
                double doubleValue = this.f25528d.doubleValue() - ((double) this.f25525a.getPromoResponse().getBody().getPaytmGoldback());
                String string = getString(R.string.flight_summary_gold_cashback, new Object[]{getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a((double) this.f25525a.getPromoResponse().getBody().getPaytmGoldback()), getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(doubleValue)});
                this.A.setText(string);
                this.A.setVisibility(0);
                this.v.setText(string);
                this.v.setVisibility(0);
                return;
            }
            double doubleValue2 = (this.f25528d.doubleValue() - ((double) this.f25525a.getPromoResponse().getBody().getPaytmCashback())) - ((double) this.f25525a.getPromoResponse().getBody().getPaytmPgcashback());
            String string2 = getString(R.string.flight_summary_cashback, new Object[]{getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a((double) (this.f25525a.getPromoResponse().getBody().getPaytmCashback() + this.f25525a.getPromoResponse().getBody().getPaytmPgcashback())), getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(doubleValue2)});
            this.A.setText(string2);
            this.A.setVisibility(0);
            this.v.setText(string2);
            this.v.setVisibility(0);
            return;
        }
        double doubleValue3 = this.f25528d.doubleValue() - ((double) this.f25525a.getPromoResponse().getBody().getPaytmDiscount());
        String format = String.format(getString(R.string.flight_bank_instant_discount), new Object[]{String.valueOf(this.f25525a.getPromoResponse().getBody().getPaytmDiscount())});
        String str2 = getResources().getString(R.string.flight_summary_book_text) + " " + getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(doubleValue3) + " " + getResources().getString(R.string.rupee_plain) + this.f25528d;
        int lastIndexOf = str2.lastIndexOf(getResources().getString(R.string.rupee_plain));
        String h2 = com.travel.flight.utils.c.h(str2);
        SpannableString spannableString = new SpannableString(h2);
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), 1, h2.length(), 33);
        spannableString.setSpan(new TopAlignProportionalSpan(0.6f), lastIndexOf, h2.length(), 33);
        spannableString.setSpan(new StrikethroughSpan(), lastIndexOf + 1, h2.length(), 33);
        this.z.setText(spannableString);
        if (textView != null) {
            textView.setText(spannableString);
        }
        this.A.setText(format);
        this.A.setVisibility(0);
        this.v.setText(format);
        this.v.setVisibility(0);
    }

    private static String a(ArrayList<CJRFlightStops> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        Iterator<CJRFlightStops> it2 = arrayList.iterator();
        String str = "";
        while (it2.hasNext()) {
            CJRFlightStops next = it2.next();
            if (str.equals("")) {
                str = str + next.getmAirLine();
                arrayList2.add(next.getmAirLine());
            } else if (!arrayList2.contains(next.getmAirLine())) {
                str = str + ", " + next.getmAirLine();
            }
        }
        return str;
    }

    private String b(ArrayList<CJRFlightStops> arrayList) {
        if (arrayList == null) {
            return "";
        }
        if (arrayList.size() == 2) {
            return arrayList.get(1).getmOrigin();
        }
        if (arrayList.size() == 3) {
            return arrayList.get(1).getmOrigin() + ", " + arrayList.get(2).getmOrigin();
        } else if (arrayList.size() != 4) {
            return getString(R.string.flight_more_stops);
        } else {
            return arrayList.get(1).getmOrigin() + ", " + arrayList.get(2).getmOrigin() + ", " + arrayList.get(3).getmOrigin();
        }
    }

    private static String c(ArrayList<CJRFlightStops> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        Iterator<CJRFlightStops> it2 = arrayList.iterator();
        String str = "";
        while (it2.hasNext()) {
            CJRFlightStops next = it2.next();
            if (str.equals("")) {
                str = str + next.getmAirLineCode() + "-" + next.getmFlightNumber();
            } else {
                str = str + ", " + next.getmAirLineCode() + "-" + next.getmFlightNumber();
            }
        }
        return str;
    }

    private static void a(String str, ImageView imageView) {
        b.a();
        String r2 = b.b().r();
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = r2 + str + ".png";
                if (URLUtil.isValidUrl(str2)) {
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(imageView.getContext());
                    a2.f43753a = str2;
                    a2.a((Object) Integer.valueOf(R.drawable.pre_f_defaultcarrier)).b(Integer.valueOf(R.drawable.pre_f_defaultcarrier)).a(imageView);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r16 = this;
            r0 = r16
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r1 = r0.f25527c
            if (r1 == 0) goto L_0x021c
            int r1 = r1.size()
            if (r1 == 0) goto L_0x021c
            int r1 = com.travel.flight.R.id.lyt_flight_traveller_info
            android.view.View r1 = r0.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r2 = 0
            r3 = 0
        L_0x0016:
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r4 = r0.f25527c
            int r4 = r4.size()
            if (r3 >= r4) goto L_0x021c
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r4 = r0.f25527c
            java.lang.Object r4 = r4.get(r3)
            if (r4 == 0) goto L_0x0218
            android.view.LayoutInflater r4 = r16.getLayoutInflater()
            int r5 = com.travel.flight.R.layout.pre_f_lyt_flight_trip_summary_traveller_details
            r6 = 0
            android.view.View r4 = r4.inflate(r5, r6, r2)
            int r5 = com.travel.flight.R.id.traveller_type
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            int r6 = com.travel.flight.R.id.traveller_first_name
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.travel.flight.R.id.traveller_last_name
            android.view.View r7 = r4.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.travel.flight.R.id.salutation
            android.view.View r8 = r4.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = com.travel.flight.R.id.flyer_name
            android.view.View r9 = r4.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r10 = com.travel.flight.R.id.flyer_number
            android.view.View r10 = r4.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r11 = com.travel.flight.R.id.traveller_devider
            android.view.View r11 = r4.findViewById(r11)
            int r12 = com.travel.flight.R.id.pax_gender_type
            android.view.View r12 = r4.findViewById(r12)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r13 = r0.f25527c
            java.lang.Object r13 = r13.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r13 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r13
            java.lang.String r13 = r13.getPassengerType()
            r5.setText(r13)
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r5 = r0.f25527c
            java.lang.Object r5 = r5.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r5 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r5
            java.lang.String r5 = r5.getTravellerTitle()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x00b0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r13 = r0.f25527c
            java.lang.Object r13 = r13.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r13 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r13
            java.lang.String r13 = r13.getTravellerTitle()
            r5.append(r13)
            java.lang.String r13 = "."
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r8.setText(r5)
        L_0x00b0:
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r5 = r0.f25527c
            java.lang.Object r5 = r5.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r5 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r5
            java.lang.String r5 = r5.getTravellerTitle()
            if (r5 == 0) goto L_0x015b
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r5 = r0.f25527c
            java.lang.Object r5 = r5.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r5 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r5
            java.lang.String r5 = r5.getmTravellerType_en()
            if (r5 == 0) goto L_0x015b
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r5 = r0.f25527c
            java.lang.Object r5 = r5.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r5 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r5
            java.lang.String r5 = r5.getmTravellerType_en()
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r8 = r0.f25527c
            java.lang.Object r8 = r8.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r8 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r8
            java.lang.String r8 = r8.getTravellerTitle()
            int r13 = com.travel.flight.R.drawable.flight_male_revamp_img
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r0, (int) r13)
            int r15 = r5.hashCode()
            r14 = -1184183706(0xffffffffb96aca66, float:-2.2391378E-4)
            r2 = 1
            if (r15 == r14) goto L_0x0113
            r14 = 92676538(0x58621ba, float:1.2613689E-35)
            if (r15 == r14) goto L_0x0109
            r14 = 94631196(0x5a3f51c, float:1.5418485E-35)
            if (r15 == r14) goto L_0x00ff
            goto L_0x011d
        L_0x00ff:
            java.lang.String r14 = "child"
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L_0x011d
            r5 = 2
            goto L_0x011e
        L_0x0109:
            java.lang.String r14 = "adult"
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L_0x011d
            r5 = 0
            goto L_0x011e
        L_0x0113:
            java.lang.String r14 = "infant"
            boolean r5 = r5.equals(r14)
            if (r5 == 0) goto L_0x011d
            r5 = 1
            goto L_0x011e
        L_0x011d:
            r5 = -1
        L_0x011e:
            if (r5 == 0) goto L_0x0143
            if (r5 == r2) goto L_0x013c
            r2 = 2
            if (r5 == r2) goto L_0x0126
            goto L_0x0158
        L_0x0126:
            java.lang.String r2 = "Mstr"
            boolean r2 = r2.equalsIgnoreCase(r8)
            if (r2 == 0) goto L_0x0135
            int r2 = com.travel.flight.R.drawable.flight_child_male_revamp_img
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r0, (int) r2)
            goto L_0x0158
        L_0x0135:
            int r2 = com.travel.flight.R.drawable.flight_child_female_revamp_img
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r0, (int) r2)
            goto L_0x0158
        L_0x013c:
            int r2 = com.travel.flight.R.drawable.flight_infant_revamp_img
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r0, (int) r2)
            goto L_0x0158
        L_0x0143:
            java.lang.String r2 = "Mr"
            boolean r2 = r2.equalsIgnoreCase(r8)
            if (r2 == 0) goto L_0x0152
            int r2 = com.travel.flight.R.drawable.flight_male_revamp_img
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r0, (int) r2)
            goto L_0x0158
        L_0x0152:
            int r2 = com.travel.flight.R.drawable.flight_female_revamp_img
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r0, (int) r2)
        L_0x0158:
            r12.setImageDrawable(r13)
        L_0x015b:
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r2 = r0.f25527c
            java.lang.Object r2 = r2.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r2 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r2
            java.util.List r2 = r2.getValidations()
            if (r2 == 0) goto L_0x019b
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r2 = r0.f25527c
            java.lang.Object r2 = r2.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r2 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r2
            java.util.List r2 = r2.getValidations()
            java.lang.String r5 = "firstname"
            java.lang.String r2 = a((java.util.List<net.one97.paytmflight.common.entity.travel.CJRDynamicValidation>) r2, (java.lang.String) r5)
            java.lang.String r2 = r2.trim()
            r6.setText(r2)
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r2 = r0.f25527c
            java.lang.Object r2 = r2.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r2 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r2
            java.util.List r2 = r2.getValidations()
            java.lang.String r5 = "lastname"
            java.lang.String r2 = a((java.util.List<net.one97.paytmflight.common.entity.travel.CJRDynamicValidation>) r2, (java.lang.String) r5)
            java.lang.String r2 = r2.trim()
            r7.setText(r2)
        L_0x019b:
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r2 = r0.f25527c
            java.lang.Object r2 = r2.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r2 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r2
            java.lang.String r2 = r2.getFlyerFlightName()
            if (r2 == 0) goto L_0x01dc
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r2 = r0.f25527c
            java.lang.Object r2 = r2.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r2 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r2
            java.lang.String r2 = r2.getMflyerNumber()
            if (r2 == 0) goto L_0x01dc
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r2 = r0.f25527c
            java.lang.Object r2 = r2.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r2 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r2
            java.lang.String r2 = r2.getFlyerFlightName()
            r9.setText(r2)
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r2 = r0.f25527c
            java.lang.Object r2 = r2.get(r3)
            com.travel.flight.pojo.flightticket.CJRTravellerDetails r2 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r2
            java.lang.String r2 = r2.getMflyerNumber()
            r10.setText(r2)
            r2 = 0
            r9.setVisibility(r2)
            r10.setVisibility(r2)
        L_0x01dc:
            int r2 = r3 + 1
            java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r5 = r0.f25527c
            int r5 = r5.size()
            if (r2 != r5) goto L_0x0214
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r2 = r0.f25529e
            if (r2 == 0) goto L_0x020d
            java.lang.String r2 = r2.getGSTNumber()
            if (r2 == 0) goto L_0x020d
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r2 = r0.f25529e
            java.lang.String r2 = r2.getGSTNumber()
            if (r2 == 0) goto L_0x020d
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r2 = r0.f25529e
            java.lang.String r2 = r2.getCompanyAddress()
            if (r2 == 0) goto L_0x020d
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r2 = r0.f25529e
            java.lang.String r2 = r2.getStateOfResidence()
            if (r2 == 0) goto L_0x020d
            r2 = 0
            r11.setVisibility(r2)
            goto L_0x0215
        L_0x020d:
            r2 = 0
            r5 = 8
            r11.setVisibility(r5)
            goto L_0x0215
        L_0x0214:
            r2 = 0
        L_0x0215:
            r1.addView(r4)
        L_0x0218:
            int r3 = r3 + 1
            goto L_0x0016
        L_0x021c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.tripsummary.AJRFlightConfirmation.a():void");
    }

    private String a(String str) {
        if ("E".equalsIgnoreCase(str)) {
            return getString(R.string.economy_flight);
        }
        if ("B".equalsIgnoreCase(str)) {
            return getString(R.string.business);
        }
        return AppConstants.FEED_COMMUNITY_POST.equalsIgnoreCase(str) ? getString(R.string.premium_economy) : "";
    }

    public void onBackPressed() {
        if (!this.w) {
            if (this.y) {
                Intent intent = new Intent();
                intent.putExtra("shouldClearSelectedSeat", true);
                setResult(-1, intent);
            }
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.proceed_to_pay_button) {
            HashMap<String, Object> b2 = b((String) null);
            b2.put("event_label12", Integer.valueOf(this.H));
            b("book_clicked", b2);
            if (com.paytm.utility.b.c((Context) this)) {
                this.p.a((Activity) this);
            } else {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else if (id == R.id.close_button) {
            b("cross_clicked", (HashMap<String, Object>) null);
            f();
        } else if (id == R.id.gst_view_more) {
            findViewById(R.id.gst_view_more).setVisibility(8);
            findViewById(R.id.gst_number_devider).setVisibility(0);
            this.f25531g.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lyt_flight_gst_details);
            if (this.f25529e.getCompanyName() != null) {
                linearLayout.addView(a(getString(R.string.flight_gst_company_name), this.f25529e.getCompanyName()));
            }
            if (this.f25529e.getCompanyAddress() != null) {
                linearLayout.addView(a(getString(R.string.flight_gst_company_address), this.f25529e.getCompanyAddress()));
            }
            if (this.f25529e.getStateOfResidence() != null) {
                linearLayout.addView(a(getString(R.string.flight_gst_residence), this.f25529e.getStateOfResidence()));
            }
            if (this.f25529e.getCompanyGstEmail() != null) {
                linearLayout.addView(a(getString(R.string.flight_gst_email), this.f25529e.getCompanyGstEmail()));
            }
            if (this.f25529e.getCompanyContactNumber() != null) {
                linearLayout.addView(a(getString(R.string.flight_gst_contact_number), this.f25529e.getCompanyContactNumber()));
            }
            this.f25530f.post(new Runnable() {
                public final void run() {
                    AJRFlightConfirmation.this.f25530f.a(130);
                }
            });
        } else if (id == R.id.arrow_down_floating_button) {
            this.f25531g.setVisibility(8);
            this.f25530f.post(new Runnable() {
                public final void run() {
                    AJRFlightConfirmation.this.f25530f.a(130);
                }
            });
        } else if (id == R.id.cancel_action) {
            if (this.y) {
                Intent intent = new Intent();
                intent.putExtra("shouldClearSelectedSeat", true);
                setResult(-1, intent);
            }
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.y) {
            Intent intent = new Intent();
            intent.putExtra("shouldClearSelectedSeat", true);
            setResult(-1, intent);
        }
        finish();
    }

    private static String a(List<CJRDynamicValidation> list, String str) {
        String str2 = "";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).getKey().equals(str)) {
                str2 = list.get(i2).getmValue();
            }
        }
        return str2;
    }

    private View a(String str, String str2) {
        try {
            View inflate = getLayoutInflater().inflate(R.layout.pre_f_flight_gst_details_text, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.txt_gst_detail_title)).setText(str);
            ((TextView) inflate.findViewById(R.id.txt_gst_detail_value)).setText(str2);
            return inflate;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.s.setVisibility(0);
            c(this.o);
            b(false, this.x);
            return;
        }
        d(this.o);
        b(true, this.x);
        this.s.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static void c(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
    }

    /* access modifiers changed from: private */
    public static void d(LottieAnimationView lottieAnimationView) {
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
        }
    }

    public final void b() {
        this.n.dismiss();
        finish();
    }

    public final void c() {
        this.q = true;
        this.p.f25560a.getJourneyDetails().setIslastnameValidationRequiered(true);
        this.p.a(a.q(getApplicationContext()), this.f25525a);
        this.n.dismiss();
    }

    public final void d() {
        this.n.dismiss();
        Intent intent = new Intent();
        intent.putExtra("shouldClearSelectedSeat", true);
        setResult(-1, intent);
        finish();
    }

    public final void e() {
        this.n.dismiss();
        this.p.f25560a.getJourneyDetails().getEmailId();
        this.p.f25560a.getJourneyDetails().getMobileNumber();
        this.f25525a.getJourneyDetails().setTravellerSeatTransitionObj((CJRTravellerSeatTransition) null);
        this.p.a(a.q(getApplicationContext()), this.f25525a);
        this.y = true;
        c.a aVar = c.n;
        CJRFlightDetails cJRFlightDetails = this.f25525a;
        cJRFlightDetails.getJourneyDetails().getTravellerSeatTransitionObj();
        k.c(cJRFlightDetails, "mFlightDetails");
        double a2 = c.a.a(cJRFlightDetails, cJRFlightDetails.isInsuranceApplied());
        if (!(cJRFlightDetails.getPromoResponse() == null || cJRFlightDetails.getPromoResponse().getBody() == null || cJRFlightDetails.getPromoResponse().getBody().getPaytmDiscount() <= 0)) {
            a2 -= (double) cJRFlightDetails.getPromoResponse().getBody().getPaytmDiscount();
        }
        this.f25528d = Double.valueOf(a2);
        TextView textView = this.z;
        TextView textView2 = this.A;
        if (this.f25528d != null) {
            textView.setText(getResources().getString(R.string.flight_summary_book_text) + " " + getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(this.f25528d.doubleValue()));
        }
        CJRFlightDetails cJRFlightDetails2 = this.f25525a;
        if (cJRFlightDetails2 == null || cJRFlightDetails2.getPromoResponse() == null || this.f25525a.getPromoResponse().getBody() == null || this.f25525a.getPromoResponse().getBody().getPaytmDiscount() <= 0) {
            CJRFlightDetails cJRFlightDetails3 = this.f25525a;
            if (cJRFlightDetails3 == null || cJRFlightDetails3.getPromoResponse() == null || this.f25525a.getPromoResponse().getBody() == null || (this.f25525a.getPromoResponse().getBody().getPaytmCashback() <= 0 && this.f25525a.getPromoResponse().getBody().getPaytmPgcashback() <= 0)) {
                CJRFlightDetails cJRFlightDetails4 = this.f25525a;
                if (cJRFlightDetails4 == null || cJRFlightDetails4.getPromoResponse() == null || this.f25525a.getPromoResponse().getBody() == null || this.f25525a.getPromoResponse().getBody().getPaytmGoldback() <= 0) {
                    textView2.setVisibility(8);
                    this.v.setVisibility(8);
                    return;
                }
                double doubleValue = this.f25528d.doubleValue() - ((double) this.f25525a.getPromoResponse().getBody().getPaytmGoldback());
                String string = getString(R.string.flight_summary_gold_cashback, new Object[]{getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a((double) this.f25525a.getPromoResponse().getBody().getPaytmGoldback()), getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(doubleValue)});
                textView2.setText(string);
                this.v.setText(string);
                textView2.setVisibility(0);
                this.v.setVisibility(0);
                return;
            }
            double doubleValue2 = (this.f25528d.doubleValue() - ((double) this.f25525a.getPromoResponse().getBody().getPaytmCashback())) - ((double) this.f25525a.getPromoResponse().getBody().getPaytmPgcashback());
            String string2 = getString(R.string.flight_summary_cashback, new Object[]{getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a((double) (this.f25525a.getPromoResponse().getBody().getPaytmCashback() + this.f25525a.getPromoResponse().getBody().getPaytmPgcashback())), getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(doubleValue2)});
            textView2.setText(string2);
            this.v.setText(string2);
            textView2.setVisibility(0);
            this.v.setVisibility(0);
            return;
        }
        double doubleValue3 = this.f25528d.doubleValue() - ((double) this.f25525a.getPromoResponse().getBody().getPaytmDiscount());
        String format = String.format(getString(R.string.flight_bank_instant_discount), new Object[]{String.valueOf(this.f25525a.getPromoResponse().getBody().getPaytmDiscount())});
        textView2.setText(format);
        this.v.setText(format);
        String str = getResources().getString(R.string.flight_summary_book_text) + " " + getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(doubleValue3) + " " + getResources().getString(R.string.rupee_plain) + this.f25528d;
        int lastIndexOf = str.lastIndexOf(getResources().getString(R.string.rupee_plain));
        String h2 = com.travel.flight.utils.c.h(str);
        SpannableString spannableString = new SpannableString(h2);
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), 1, h2.length(), 33);
        spannableString.setSpan(new TopAlignProportionalSpan(0.6f), lastIndexOf, h2.length(), 33);
        spannableString.setSpan(new StrikethroughSpan(), lastIndexOf + 1, h2.length(), 33);
        textView.setText(spannableString);
        textView2.setVisibility(0);
        this.v.setVisibility(0);
    }

    private boolean g() {
        try {
            double d2 = 0.0d;
            double parseDouble = (this.f25525a.getmRepriceFareDetails().getmTotalFare() == null || TextUtils.isEmpty(this.f25525a.getmRepriceFareDetails().getmTotalFare())) ? 0.0d : Double.parseDouble(this.f25525a.getmRepriceFareDetails().getmTotalFare());
            if (!(this.f25525a.getmFareDetails() == null || this.f25525a.getmFareDetails().getmFlightCost() == null || TextUtils.isEmpty(this.f25525a.getmFareDetails().getmFlightCost()))) {
                d2 = Double.parseDouble(this.f25525a.getmFareDetails().getmFlightCost());
            }
            if (Math.abs(parseDouble) > Math.abs(d2)) {
                return true;
            }
            if (Math.abs(parseDouble) < Math.abs(d2)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }

    private Intent a(Intent intent) {
        intent.putExtra("isShare", true);
        intent.putExtra("intent_extra_search_input_data", this.C);
        return intent;
    }

    /* access modifiers changed from: private */
    public void h() {
        this.u.setVisibility(8);
    }

    private void a(ImageView imageView, ImageView imageView2, ImageView imageView3) {
        if (this.f25525a.getmOnwardJourney() != null) {
            if (this.f25525a.getmOnwardJourney().isStitched() || this.f25525a.getmOnwardJourney().isProviderStitch()) {
                ArrayList<CJRFlightStops> arrayList = this.f25525a.getmOnwardJourney().getmFlights();
                if (arrayList != null && arrayList.size() > 1) {
                    imageView2.setVisibility(0);
                    imageView3.setVisibility(0);
                    imageView.setVisibility(8);
                    a(arrayList.get(0).getmAirLineCode(), imageView2);
                    a(arrayList.get(1).getmAirLineCode(), imageView3);
                }
            } else {
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
                imageView3.setVisibility(8);
                a(this.f25525a.getmOnwardJourney().getmAirLineCode(), imageView);
            }
        }
        if (this.f25525a.getmReturnJourney() != null) {
            if (this.f25525a.getmReturnJourney().isStitched() || this.f25525a.getmReturnJourney().isProviderStitch()) {
                ArrayList<CJRFlightStops> arrayList2 = this.f25525a.getmReturnJourney().getmFlights();
                if (arrayList2 != null && arrayList2.size() > 1) {
                    imageView2.setVisibility(0);
                    imageView3.setVisibility(0);
                    imageView.setVisibility(8);
                    a(arrayList2.get(0).getmAirLineCode(), imageView2);
                    a(arrayList2.get(1).getmAirLineCode(), imageView3);
                }
            } else {
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
                imageView3.setVisibility(8);
                a(this.f25525a.getmReturnJourney().getmAirLineCode(), imageView);
            }
        }
        if (this.f25526b.equalsIgnoreCase("round_trip") && !this.f25525a.getmReturnJourney().getmAirLineCode().equalsIgnoreCase(this.f25525a.getmOnwardJourney().getmAirLineCode())) {
            a(this.f25525a.getmReturnJourney().getmAirLineCode(), imageView2);
            a(this.f25525a.getmOnwardJourney().getmAirLineCode(), imageView3);
            imageView2.setVisibility(0);
            imageView3.setVisibility(0);
            imageView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static void b(boolean z2, View view) {
        if (z2) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> b(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_label", str);
        }
        if (!TextUtils.isEmpty(this.C.getJourneyDetailType())) {
            hashMap.put("event_label2", this.C.getJourneyDetailType());
        }
        hashMap.put("event_label3", this.C.getSource().getCityName());
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.C.getDestination().getCityName());
        j.a aVar = j.f25593a;
        hashMap.put("event_label6", j.a.a(this.C.getClassType(), (Context) this));
        hashMap.put("event_label7", com.paytm.utility.b.h(this.C.getDate(), "yyyy-MM-dd", "dd MMM yy"));
        hashMap.put("event_label8", com.paytm.utility.b.h(this.C.getReturnDate(), "yyyy-MM-dd", "dd MMM yy"));
        hashMap.put("event_label9", this.C.getSourceCityCode());
        hashMap.put("event_label10", this.C.getDestCityCode());
        if (!TextUtils.isEmpty(this.C.getJourneyType())) {
            hashMap.put("event_label11", this.C.getJourneyType());
            if (this.C.getJourneyType().equalsIgnoreCase("one_way")) {
                if (this.f25525a.getmOnwardJourney().getmFlights() != null && this.f25525a.getmOnwardJourney().getmFlights().size() > 0) {
                    hashMap.put("event_label5", this.f25525a.getmOnwardJourney().getmAirLineCode() + " " + this.f25525a.getmOnwardJourney().getmFlights().get(0).getmFlightNumber());
                }
            } else if (this.f25525a.getmOnwardJourney().getmFlights() != null && this.f25525a.getmOnwardJourney().getmFlights().size() > 0 && this.f25525a.getmReturnJourney().getmFlights() != null && this.f25525a.getmReturnJourney().getmFlights().size() > 0) {
                hashMap.put("event_label5", "Onward{" + this.f25525a.getmOnwardJourney().getmAirLineCode() + " " + this.f25525a.getmOnwardJourney().getmFlights().get(0).getmFlightNumber() + "}, Return{" + this.f25525a.getmReturnJourney().getmAirLineCode() + " " + this.f25525a.getmReturnJourney().getmFlights().get(0).getmFlightNumber() + "}");
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static void b(String str, HashMap<String, Object> hashMap) {
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights/trip-summary", "flights_final_review", str, hashMap);
    }

    static /* synthetic */ void a(AJRFlightConfirmation aJRFlightConfirmation, CJRFlightDetails cJRFlightDetails) {
        String str;
        int i2;
        int i3;
        if (aJRFlightConfirmation.g()) {
            aJRFlightConfirmation.w = true;
            aJRFlightConfirmation.t.setVisibility(0);
            aJRFlightConfirmation.x = aJRFlightConfirmation.t;
            aJRFlightConfirmation.h();
            aJRFlightConfirmation.t.setAnimation(AnimationUtils.loadAnimation(aJRFlightConfirmation, R.anim.anim_flight_reprice_bottom_to_top));
            CJRStatus status = cJRFlightDetails.getStatus();
            String str2 = "";
            if (status == null || status.getmFlightMesssgae() == null) {
                str = str2;
            } else {
                str = !TextUtils.isEmpty(status.getmFlightMesssgae().getmTitle()) ? status.getmFlightMesssgae().getmTitle() : str2;
                if (!TextUtils.isEmpty(status.getmFlightMesssgae().getmMessage())) {
                    str2 = status.getmFlightMesssgae().getmMessage();
                }
            }
            ImageView imageView = (ImageView) aJRFlightConfirmation.findViewById(R.id.imageView_fare_status_icon);
            ((TextView) aJRFlightConfirmation.findViewById(R.id.txt_fare_status)).setText(str);
            TextView textView = (TextView) aJRFlightConfirmation.findViewById(R.id.txt_prev_fare);
            TextView textView2 = (TextView) aJRFlightConfirmation.findViewById(R.id.txt_update_fare);
            TextView textView3 = (TextView) aJRFlightConfirmation.findViewById(R.id.proceed_to_book_btn_reprice);
            TextView textView4 = (TextView) aJRFlightConfirmation.findViewById(R.id.choose_another_flight);
            ((TextView) aJRFlightConfirmation.findViewById(R.id.fare_change_message)).setText(str2);
            Double valueOf = Double.valueOf(0.0d);
            Double valueOf2 = Double.valueOf(0.0d);
            if (cJRFlightDetails.getmRepriceFareDetails().getmTotalFare() != null && !TextUtils.isEmpty(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare())) {
                valueOf = Double.valueOf(c.a(Double.parseDouble(cJRFlightDetails.getmRepriceFareDetails().getmTotalFare()), cJRFlightDetails));
                textView2.setText(com.travel.flight.utils.c.a(valueOf.doubleValue()));
            }
            if (!(cJRFlightDetails.getmFareDetails() == null || cJRFlightDetails.getmFareDetails().getmFlightCost() == null || TextUtils.isEmpty(cJRFlightDetails.getmFareDetails().getmFlightCost()))) {
                valueOf2 = Double.valueOf(c.a(Double.parseDouble(cJRFlightDetails.getmFareDetails().getmFlightCost()), cJRFlightDetails));
                textView.setText(com.travel.flight.utils.c.a(valueOf2.doubleValue()));
            }
            if (valueOf.doubleValue() > valueOf2.doubleValue()) {
                ResourceUtils.loadFlightImagesFromCDN(imageView, "reprice_up.png", false, false, n.a.V1);
            } else {
                ResourceUtils.loadFlightImagesFromCDN(imageView, "reprice_down.png", false, false, n.a.V1);
            }
            StringBuilder sb = new StringBuilder();
            if (cJRFlightDetails.getmIsInternational().booleanValue()) {
                i2 = R.string.international_text;
            } else {
                i2 = R.string.domestic_text;
            }
            sb.append(aJRFlightConfirmation.getString(i2));
            sb.append(AppConstants.AND_SIGN);
            if (aJRFlightConfirmation.f25526b.equalsIgnoreCase("round_trip")) {
                i3 = R.string.flight_roundtrip_text;
            } else {
                i3 = R.string.flight_oneway_text;
            }
            sb.append(aJRFlightConfirmation.getString(i3));
            if (Math.abs(valueOf.doubleValue()) < Math.abs(valueOf2.doubleValue())) {
                ResourceUtils.loadFlightImagesFromCDN(imageView, "fare_drop.png", false, false, n.a.V1);
                textView4.setVisibility(8);
            }
            CJRRepriceFlightFare cJRRepriceFlightFare = cJRFlightDetails.getmRepriceFareDetails();
            if (cJRRepriceFlightFare == null || TextUtils.isEmpty(cJRRepriceFlightFare.getmTotalFare())) {
                textView3.setText(aJRFlightConfirmation.getResources().getString(R.string.proceed_to_pay));
            } else {
                c.a aVar = c.n;
                aJRFlightConfirmation.f25528d = Double.valueOf(c.a.a(cJRFlightDetails, cJRFlightDetails.isInsuranceApplied()));
                aJRFlightConfirmation.a(textView3);
            }
            aJRFlightConfirmation.findViewById(R.id.proceed_to_book_btn_reprice_parent).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRFlightConfirmation.c(AJRFlightConfirmation.this.o);
                    AJRFlightConfirmation.b(false, AJRFlightConfirmation.this.x);
                    AJRFlightConfirmation.this.t.setVisibility(8);
                    AJRFlightConfirmation.this.h();
                    AJRFlightConfirmation.this.s.setVisibility(0);
                    AJRFlightConfirmation.this.p.a((Activity) AJRFlightConfirmation.this);
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (AJRFlightConfirmation.this.f25526b == null || !AJRFlightConfirmation.this.f25526b.equalsIgnoreCase("round_trip")) {
                        AJRFlightConfirmation.n(AJRFlightConfirmation.this);
                    } else {
                        AJRFlightConfirmation.m(AJRFlightConfirmation.this);
                    }
                    AJRFlightConfirmation.this.finish();
                }
            });
            ((RoboTextView) aJRFlightConfirmation.findViewById(R.id.btn_continue)).setVisibility(8);
        }
    }

    static /* synthetic */ void b(AJRFlightConfirmation aJRFlightConfirmation, CJRFlightPayment cJRFlightPayment) {
        Intent intent = new Intent();
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRFlightPayment.getPaymentInfo());
        intent.putExtra("is_flight_ticket", true);
        intent.putExtra("vertical_name", a.c.FLIGHT);
        intent.putExtra("price", com.travel.flight.utils.c.a(cJRFlightPayment.getPaymentInfo()));
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(cJRFlightPayment.getPaymentInfo(), intent);
        com.travel.flight.b.a();
        com.travel.flight.b.b().d(aJRFlightConfirmation, intent);
        d(aJRFlightConfirmation.o);
        b(true, aJRFlightConfirmation.x);
        aJRFlightConfirmation.s.setVisibility(8);
        aJRFlightConfirmation.finish();
    }

    static /* synthetic */ void a(AJRFlightConfirmation aJRFlightConfirmation, CJRFlightVerify cJRFlightVerify, CJRFlightDetails cJRFlightDetails) {
        String str;
        String str2;
        int paytmDiscount;
        CJRRechargePayment paymentInfo = cJRFlightVerify.getPaymentInfo();
        Intent intent = new Intent();
        intent.putExtra(SDKConstants.PAYMENT_INFO, paymentInfo);
        intent.putExtra("is_flight_ticket", true);
        String a2 = com.travel.flight.utils.c.a(paymentInfo);
        if (!TextUtils.isEmpty(a2)) {
            intent.putExtra("price", a2);
            com.travel.flight.b.a();
            com.travel.flight.b.b().a(cJRFlightVerify.getPaymentInfo(), intent);
        }
        if (cJRFlightDetails.getJourneyDetails().getmPaymentIntent() != null) {
            CJRRechargePayment paymentInfo2 = cJRFlightVerify.getPaymentInfo();
            if (!(paymentInfo2 == null || paymentInfo2.getTxnAmount() == null || aJRFlightConfirmation.p.f25561b.toString() == null)) {
                try {
                    ((JSONObject) aJRFlightConfirmation.p.f25561b.getJSONArray(EMIConstants.PAYMENT_INTENT).get(0)).put("txnAmount", String.valueOf((int) Double.parseDouble(paymentInfo2.getTxnAmount())));
                } catch (Exception e2) {
                    com.paytm.utility.q.b(e2.getMessage());
                }
            }
            intent.putExtra(SDKConstants.IS_BANK_OFFER, true);
            if (cJRFlightDetails.getPromoResponse() != null && cJRFlightDetails.getPromoResponse().getBody() != null && cJRFlightDetails.getPromoResponse().getBody().getPaytmDiscount() > 0 && cJRFlightVerify.getPaytmDiscount() > 0 && (paytmDiscount = cJRFlightVerify.getPaytmDiscount() - cJRFlightDetails.getPromoResponse().getBody().getPaytmDiscount()) > 0) {
                intent.putExtra("updatedDiscountAmount", paytmDiscount);
                intent.putExtra("finalDiscount", cJRFlightVerify.getPaytmDiscount());
            }
        }
        com.travel.flight.b.a();
        String Y = com.travel.flight.b.b().Y();
        String q2 = com.paytm.utility.a.q(aJRFlightConfirmation.getApplicationContext());
        if (TextUtils.isEmpty(Y)) {
            com.travel.flight.b.a();
            Y = com.travel.flight.b.b().d();
        }
        if (!URLUtil.isValidUrl(Y)) {
            str = "";
        } else {
            String s2 = com.paytm.utility.b.s(aJRFlightConfirmation, Y);
            String str3 = aJRFlightConfirmation.f25526b;
            if (str3 == null || !str3.equalsIgnoreCase("round_trip")) {
                c.a aVar = c.n;
                str2 = c.a.b(s2, cJRFlightDetails);
            } else {
                c.a aVar2 = c.n;
                str2 = c.a.a(s2, cJRFlightDetails);
            }
            Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
            buildUpon.appendQueryParameter("wallet_token", q2);
            if (aJRFlightConfirmation.q) {
                buildUpon.appendQueryParameter("ignore_last_name_validation", "true");
            }
            str = buildUpon.build().toString();
        }
        intent.putExtra("checkoutUrl", str);
        intent.putExtra("jsonCheckoutrequest", aJRFlightConfirmation.p.f25561b.toString());
        intent.putExtra(CJRRechargeCart.KEY_PAYMENT_INSTRUMENT, cJRFlightVerify.getPaymentInstruments());
        intent.putExtra("is_deferred_checkout_flight", aJRFlightConfirmation.p.a());
        intent.putExtra("vertical_name", a.c.FLIGHT);
        if (aJRFlightConfirmation.p.a()) {
            PaytmSDK.parseAndSetInstruments(cJRFlightVerify.getPaymentInstruments());
            intent.putExtra("isDeferredCheckoutEnable", true);
        }
        intent.putExtra("intent_extra_flight_pulse_data", aJRFlightConfirmation.b((String) null));
        com.travel.flight.b.a();
        com.travel.flight.b.b().h(aJRFlightConfirmation, intent);
        d(aJRFlightConfirmation.o);
        b(true, aJRFlightConfirmation.x);
        aJRFlightConfirmation.s.setVisibility(8);
        aJRFlightConfirmation.finish();
    }

    static /* synthetic */ void m(AJRFlightConfirmation aJRFlightConfirmation) {
        Intent intent = new Intent(aJRFlightConfirmation, FlightSRPV2Activity.class);
        intent.addFlags(603979776);
        intent.putExtra(net.one97.paytmflight.common.b.b.f30018h, H5Param.MENU_REFRESH);
        if (aJRFlightConfirmation.B) {
            aJRFlightConfirmation.a(intent);
        }
        aJRFlightConfirmation.startActivity(intent);
    }

    static /* synthetic */ void n(AJRFlightConfirmation aJRFlightConfirmation) {
        Intent intent = new Intent(aJRFlightConfirmation, FlightSRPV2Activity.class);
        intent.addFlags(603979776);
        intent.putExtra(net.one97.paytmflight.common.b.b.f30018h, H5Param.MENU_REFRESH);
        if (aJRFlightConfirmation.B) {
            aJRFlightConfirmation.a(intent);
        }
        aJRFlightConfirmation.startActivity(intent);
    }
}
