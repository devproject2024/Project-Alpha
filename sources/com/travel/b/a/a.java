package com.travel.b.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.travel.R;
import com.travel.d;
import com.travel.f.a;
import com.travel.g.c;
import com.travel.utils.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.flightticket.CJRFlightSummaryMetadataResponse;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderItems;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends h implements b, c {

    /* renamed from: b  reason: collision with root package name */
    private static final String f21446b = a.class.getSimpleName();
    private final String A = "Flights_Insurance";
    private TextView B;
    private TextView C;
    private TextView D;
    /* access modifiers changed from: private */
    public String E = null;
    private LinearLayout F;
    private com.travel.f.a G;
    /* access modifiers changed from: private */
    public boolean H = false;
    private String I = "";
    private ProgressBar J;
    private String K = "";
    private String L = "";
    private CJROrderSummary M = null;
    private boolean N;

    /* renamed from: a  reason: collision with root package name */
    private String f21447a = "TravelCSTFragment";

    /* renamed from: c  reason: collision with root package name */
    private IJRDataModel f21448c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f21449d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21450e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21451f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f21452g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f21453h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f21454i;
    private LinearLayout j;
    private int k;
    private String l = "";
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private RelativeLayout w;
    private TextView x;
    private String y = "";
    private C0424a z;

    /* renamed from: com.travel.b.a.a$a  reason: collision with other inner class name */
    public enum C0424a {
        PAYMENT_SUCCESS,
        PAYMENT_FAILED,
        PAYMENT_PENDING,
        PAYMENT_PENDING_DELAYED,
        BOOKING_PENDING,
        BOOKING_PENDING_DELAYED,
        BOOKING_SUCCESSFUL,
        BOOKING_FAILED,
        BOOKING_FULLY_CANCELLED,
        NO_OP,
        BOOKING_PARTIALLY_CANCELLED,
        BOOKING_CANCELLATION_INPROGRESS
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final void a() {
        c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f21448c = (IJRDataModel) getArguments().getSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM);
            this.k = getArguments().getInt("extra_intent_item_position");
            this.l = getArguments().getString(UpiConstants.FROM);
            int i2 = getArguments().getInt("ordinal");
            if (i2 >= 0) {
                this.z = C0424a.values()[i2];
            }
            this.y = getArguments().getString("pnr");
            this.I = getArguments().getString("orderId");
            this.L = getArguments().getString("downLoadFileName");
            this.N = getArguments().getBoolean("isAllSelected");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (this.l.equalsIgnoreCase("Flights")) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_td_flight_cst_view, viewGroup, false);
            this.n = (TextView) view.findViewById(R.id.text_origin_city_code);
            this.o = (TextView) view.findViewById(R.id.text_origin_city_name);
            this.p = (TextView) view.findViewById(R.id.text_destination_city_code);
            this.q = (TextView) view.findViewById(R.id.text_destination_city_name);
            this.m = (ImageView) view.findViewById(R.id.source_image_view);
            this.r = (TextView) view.findViewById(R.id.txt_flight_cst_passenger_name);
            this.s = (TextView) view.findViewById(R.id.txt_flight_cst_passenger_status);
            this.u = (TextView) view.findViewById(R.id.cashback_desc);
            this.v = (TextView) view.findViewById(R.id.cashback_text);
            this.t = (TextView) view.findViewById(R.id.cashback_value);
            this.w = (RelativeLayout) view.findViewById(R.id.relative_cashback_view);
            this.x = (TextView) view.findViewById(R.id.flight_cst_pnr);
            this.F = (LinearLayout) view.findViewById(R.id.flight_cst_action_item);
            this.J = (ProgressBar) view.findViewById(R.id.progress_bar);
        } else if (this.l.equalsIgnoreCase("Flights_Insurance")) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_td_flight_cst_view, viewGroup, false);
            ((FrameLayout) view.findViewById(R.id.flight_cst_flight_image_lyout)).setVisibility(8);
            ((LinearLayout) view.findViewById(R.id.flight_cst_insurance_header_lyout)).setVisibility(0);
            ((LinearLayout) view.findViewById(R.id.flight_cst_pnr_lyout)).setVisibility(8);
            this.F = (LinearLayout) view.findViewById(R.id.flight_cst_action_item);
            this.F.setVisibility(8);
            this.C = (TextView) view.findViewById(R.id.flight_summary_insurance_sold_by);
            this.D = (TextView) view.findViewById(R.id.flight_insurance_title);
            this.B = (TextView) view.findViewById(R.id.flight_insurance_order_tc);
            TextView textView = this.B;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        a aVar = a.this;
                        a.a(aVar, aVar.E);
                    }
                });
            }
            this.r = (TextView) view.findViewById(R.id.txt_flight_cst_passenger_name);
            this.s = (TextView) view.findViewById(R.id.txt_flight_cst_passenger_status);
            this.u = (TextView) view.findViewById(R.id.cashback_desc);
            this.v = (TextView) view.findViewById(R.id.cashback_text);
            this.t = (TextView) view.findViewById(R.id.cashback_value);
            this.w = (RelativeLayout) view.findViewById(R.id.relative_cashback_view);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_td_travel_cst_view, viewGroup, false);
            this.f21449d = (TextView) view.findViewById(R.id.src_dest);
            this.f21450e = (TextView) view.findViewById(R.id.operator);
            this.f21451f = (TextView) view.findViewById(R.id.bus_type);
            this.f21452g = (TextView) view.findViewById(R.id.paytm_order_id);
            this.r = (TextView) view.findViewById(R.id.bus_passenger_name);
            this.f21453h = (TextView) view.findViewById(R.id.seat_no);
            this.f21454i = (LinearLayout) view.findViewById(R.id.journey_layout);
            this.j = (LinearLayout) view.findViewById(R.id.passenger_layout);
        }
        IJRDataModel iJRDataModel = this.f21448c;
        if (iJRDataModel == null || !(iJRDataModel instanceof CJROrderedCart)) {
            IJRDataModel iJRDataModel2 = this.f21448c;
            if (iJRDataModel2 != null && (iJRDataModel2 instanceof CJROrderItems)) {
                String str = ((CJROrderItems) iJRDataModel2).getmOrderId();
                try {
                    b();
                    StringBuilder sb = new StringBuilder();
                    d.a();
                    sb.append(d.b().a("orderdetail"));
                    sb.append(str);
                    String sb2 = sb.toString();
                    if (sb2 != null && !TextUtils.isEmpty(sb2) && !TextUtils.isEmpty(r.a(getContext().getApplicationContext()).b("sso_token=", "", true))) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(getActivity()));
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = getActivity().getApplicationContext();
                        bVar.f42878b = a.c.FLIGHT;
                        bVar.f42879c = a.C0715a.GET;
                        bVar.n = a.b.SILENT;
                        bVar.o = getActivity().getClass().getSimpleName();
                        bVar.f42880d = com.paytm.utility.c.b(sb2, (Context) getActivity()) + "&actions=1";
                        bVar.f42881e = null;
                        bVar.f42882f = hashMap;
                        bVar.f42883g = null;
                        bVar.f42884h = null;
                        bVar.f42885i = new CJROrderSummary();
                        bVar.j = this;
                        bVar.t = null;
                        com.paytm.network.a l2 = bVar.l();
                        l2.f42860d = true;
                        l2.a();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.c(e2.getMessage());
                    }
                }
            }
        } else if (this.l.equalsIgnoreCase("Flights")) {
            c((CJROrderedCart) this.f21448c);
        } else if (this.l.equalsIgnoreCase("Flights_Insurance")) {
            b((CJROrderedCart) this.f21448c);
        } else {
            a((CJROrderedCart) this.f21448c);
        }
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x016c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(net.one97.paytm.common.entity.shopping.CJROrderedCart r15) {
        /*
            r14 = this;
            java.lang.String r0 = "item"
            java.lang.String r1 = "items"
            java.lang.String r2 = "travel"
            java.lang.String r3 = "to"
            java.lang.String r4 = "from"
            java.lang.String r5 = "order_data"
            boolean r6 = com.travel.utils.c.a(r15)
            if (r6 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.Object r6 = r15.getMetaDataResponse()
            java.util.Map r6 = (java.util.Map) r6
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r7 = r15.getFullFillmentOject()
            r7.getFulfillmentResponse()
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r7 = r15.getFullFillmentOject()
            org.json.JSONObject r7 = r7.getFullFillment()
            r8 = 0
            boolean r9 = r7.has(r4)     // Catch:{ Exception -> 0x010e }
            java.lang.String r10 = ""
            if (r9 == 0) goto L_0x0036
            java.lang.String r4 = r7.getString(r4)     // Catch:{ Exception -> 0x010e }
            goto L_0x0037
        L_0x0036:
            r4 = r10
        L_0x0037:
            boolean r9 = r7.has(r3)     // Catch:{ Exception -> 0x0108 }
            if (r9 == 0) goto L_0x0042
            java.lang.String r3 = r7.getString(r3)     // Catch:{ Exception -> 0x0108 }
            goto L_0x0043
        L_0x0042:
            r3 = r10
        L_0x0043:
            java.lang.String r9 = "busType"
            java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x0103 }
            boolean r11 = r7.has(r5)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r12 = "name"
            if (r11 == 0) goto L_0x00b2
            org.json.JSONObject r2 = r7.getJSONObject(r5)     // Catch:{ Exception -> 0x00fe }
            boolean r2 = r2.has(r1)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r6 = "journey_detail"
            if (r2 == 0) goto L_0x006b
            org.json.JSONObject r0 = r7.getJSONObject(r5)     // Catch:{ Exception -> 0x00fe }
            org.json.JSONArray r0 = r0.getJSONArray(r1)     // Catch:{ Exception -> 0x00fe }
            r1 = 0
            org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x00fe }
            goto L_0x0083
        L_0x006b:
            org.json.JSONObject r1 = r7.getJSONObject(r5)     // Catch:{ Exception -> 0x00fe }
            boolean r1 = r1.has(r0)     // Catch:{ Exception -> 0x00fe }
            if (r1 == 0) goto L_0x0082
            org.json.JSONObject r1 = r7.getJSONObject(r5)     // Catch:{ Exception -> 0x00fe }
            org.json.JSONObject r0 = r1.getJSONObject(r0)     // Catch:{ Exception -> 0x00fe }
            org.json.JSONObject r0 = r0.getJSONObject(r6)     // Catch:{ Exception -> 0x00fe }
            goto L_0x0083
        L_0x0082:
            r0 = r8
        L_0x0083:
            if (r0 == 0) goto L_0x00ad
            org.json.JSONObject r0 = r0.getJSONObject(r6)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r1 = "operator_name"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r2 = r0.getString(r12)     // Catch:{ Exception -> 0x00a9 }
            java.lang.String r5 = "salutation"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r6 = "seat_number"
            java.lang.String r0 = r0.getString(r6)     // Catch:{ Exception -> 0x00a2 }
            r8 = r0
            goto L_0x011c
        L_0x00a2:
            r0 = move-exception
            goto L_0x0115
        L_0x00a5:
            r0 = move-exception
            r5 = r8
            goto L_0x0115
        L_0x00a9:
            r0 = move-exception
            r2 = r8
            goto L_0x0101
        L_0x00ad:
            r1 = r8
            r2 = r1
            r5 = r2
            goto L_0x011c
        L_0x00b2:
            boolean r0 = r7.has(r2)     // Catch:{ Exception -> 0x00fe }
            if (r0 == 0) goto L_0x00bd
            java.lang.String r0 = r7.getString(r2)     // Catch:{ Exception -> 0x00fe }
            goto L_0x00be
        L_0x00bd:
            r0 = r10
        L_0x00be:
            java.lang.String r1 = "passengers"
            java.lang.Object r1 = r6.get(r1)     // Catch:{ Exception -> 0x00f7 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x00f7 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00f7 }
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x00f7 }
            if (r2 == 0) goto L_0x00f3
            java.lang.Object r1 = r1.next()     // Catch:{ Exception -> 0x00f7 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x00f7 }
            java.lang.Object r2 = r1.get(r12)     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00f7 }
            java.lang.String r5 = "title"
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r6 = "seatNumber"
            java.lang.Object r1 = r1.get(r6)     // Catch:{ Exception -> 0x00ee }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00ee }
            r8 = r1
            goto L_0x00f5
        L_0x00ee:
            r1 = move-exception
            goto L_0x00fa
        L_0x00f0:
            r1 = move-exception
            r5 = r8
            goto L_0x00fa
        L_0x00f3:
            r2 = r8
            r5 = r2
        L_0x00f5:
            r1 = r0
            goto L_0x011c
        L_0x00f7:
            r1 = move-exception
            r2 = r8
            r5 = r2
        L_0x00fa:
            r13 = r1
            r1 = r0
            r0 = r13
            goto L_0x0115
        L_0x00fe:
            r0 = move-exception
            r1 = r8
            r2 = r1
        L_0x0101:
            r5 = r2
            goto L_0x0115
        L_0x0103:
            r0 = move-exception
            r1 = r8
            r2 = r1
            r5 = r2
            goto L_0x0114
        L_0x0108:
            r0 = move-exception
            r1 = r8
            r2 = r1
            r3 = r2
            r5 = r3
            goto L_0x0114
        L_0x010e:
            r0 = move-exception
            r1 = r8
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x0114:
            r9 = r5
        L_0x0115:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x011c:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r6 = 8
            if (r0 != 0) goto L_0x015b
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x015b
            android.widget.TextView r0 = r14.f21449d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            java.lang.String r4 = " - "
            r7.append(r4)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r0.setText(r3)
            android.widget.TextView r0 = r14.f21450e
            r0.setText(r1)
            android.widget.TextView r0 = r14.f21451f
            r0.setText(r9)
            android.widget.TextView r0 = r14.f21452g
            long r3 = r15.getId()
            java.lang.String r15 = java.lang.String.valueOf(r3)
            r0.setText(r15)
            goto L_0x0160
        L_0x015b:
            android.widget.LinearLayout r15 = r14.f21454i
            r15.setVisibility(r6)
        L_0x0160:
            boolean r15 = android.text.TextUtils.isEmpty(r5)
            if (r15 != 0) goto L_0x0197
            boolean r15 = android.text.TextUtils.isEmpty(r2)
            if (r15 != 0) goto L_0x0197
            boolean r15 = r14.N
            if (r15 == 0) goto L_0x0178
            android.widget.TextView r15 = r14.r
            int r0 = com.travel.R.string.all_selected
            r15.setText(r0)
            goto L_0x0191
        L_0x0178:
            android.widget.TextView r15 = r14.r
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = " "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r15.setText(r0)
        L_0x0191:
            android.widget.TextView r15 = r14.f21453h
            r15.setText(r8)
            return
        L_0x0197:
            android.widget.LinearLayout r15 = r14.j
            r15.setVisibility(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.b.a.a.a(net.one97.paytm.common.entity.shopping.CJROrderedCart):void");
    }

    private void b(CJROrderedCart cJROrderedCart) {
        String str;
        if (cJROrderedCart != null) {
            try {
                String promoCode = cJROrderedCart.getPromoCode();
                Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
                f fVar = new f();
                CJRFlightSummaryMetadataResponse cJRFlightSummaryMetadataResponse = (CJRFlightSummaryMetadataResponse) fVar.a(fVar.a(metaDataResponse), CJRFlightSummaryMetadataResponse.class);
                String str2 = "";
                if (cJRFlightSummaryMetadataResponse.getAddonType() != null) {
                    TextView textView = this.r;
                    textView.setText(cJRFlightSummaryMetadataResponse.getPassengerTitle() + " " + cJRFlightSummaryMetadataResponse.getPassengerName());
                    a(this.s, cJROrderedCart.getStatus());
                    str = TextUtils.isEmpty(str2) ? cJRFlightSummaryMetadataResponse.getAddonType() : str2;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = cJRFlightSummaryMetadataResponse.getInsuranceProvider();
                    }
                    if (TextUtils.isEmpty(this.E)) {
                        this.E = cJRFlightSummaryMetadataResponse.getInsuranceTnc();
                    }
                } else {
                    str = str2;
                }
                TextView textView2 = this.C;
                textView2.setText("(" + this.C.getContext().getResources().getString(R.string.flight_sold_by) + " " + str2 + ")");
                this.D.setText(str);
                if (TextUtils.isEmpty(cJRFlightSummaryMetadataResponse.getPaytmCashback())) {
                    this.w.setVisibility(8);
                } else if (Double.parseDouble(cJRFlightSummaryMetadataResponse.getPaytmCashback()) <= 0.0d) {
                    this.w.setVisibility(8);
                } else if (this.z != C0424a.PAYMENT_FAILED || TextUtils.isEmpty(promoCode)) {
                    TextView textView3 = this.t;
                    textView3.setText(getActivity().getString(R.string.rs_symbol) + " " + cJRFlightSummaryMetadataResponse.getPaytmCashback());
                } else {
                    TextView textView4 = this.u;
                    textView4.setText(promoCode.toUpperCase() + " promocode is unused. You can try using this again.");
                    TextView textView5 = this.t;
                    textView5.setText(promoCode.toUpperCase() + " Promocode");
                    this.v.setVisibility(8);
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    private void c(CJROrderedCart cJROrderedCart) {
        String str;
        Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
        String promoCode = cJROrderedCart.getPromoCode();
        if (cJROrderedCart.getAction() == null) {
            this.F.setVisibility(8);
        } else {
            this.G = new com.travel.f.a(getActivity(), this);
            a(cJROrderedCart, this.F);
        }
        f fVar = new f();
        CJRFlightSummaryMetadataResponse cJRFlightSummaryMetadataResponse = (CJRFlightSummaryMetadataResponse) fVar.a(fVar.a(metaDataResponse), CJRFlightSummaryMetadataResponse.class);
        this.n.setText(cJRFlightSummaryMetadataResponse.getOriginIata());
        this.K = cJRFlightSummaryMetadataResponse.getDestinationIata();
        this.o.setText(cJRFlightSummaryMetadataResponse.getOriginCity());
        this.p.setText(cJRFlightSummaryMetadataResponse.getDestinationIata());
        this.q.setText(cJRFlightSummaryMetadataResponse.getDestinationCity());
        if (!TextUtils.isEmpty(cJRFlightSummaryMetadataResponse.getPassengerName())) {
            str = cJRFlightSummaryMetadataResponse.getPassengerName();
        } else if (!TextUtils.isEmpty(cJRFlightSummaryMetadataResponse.getPassengerFirstname())) {
            str = cJRFlightSummaryMetadataResponse.getPassengerFirstname();
            if (!TextUtils.isEmpty(cJRFlightSummaryMetadataResponse.getPassengerLastname())) {
                str = str + " " + cJRFlightSummaryMetadataResponse.getPassengerLastname();
            }
        } else {
            str = "";
        }
        if (this.N) {
            this.r.setText(R.string.all_selected);
        } else {
            this.r.setText(cJRFlightSummaryMetadataResponse.getPassengerTitle() + " " + str);
        }
        if (TextUtils.isEmpty(cJRFlightSummaryMetadataResponse.getPaytmCashback())) {
            this.w.setVisibility(8);
        } else if (Double.parseDouble(cJRFlightSummaryMetadataResponse.getPaytmCashback()) > 0.0d) {
            this.w.setVisibility(0);
            if (this.z != C0424a.PAYMENT_FAILED || TextUtils.isEmpty(promoCode)) {
                this.t.setText(getActivity().getString(R.string.rs_symbol) + " " + cJRFlightSummaryMetadataResponse.getPaytmCashback());
            } else {
                this.u.setText(promoCode.toUpperCase() + " promocode is unused. You can try using this again.");
                this.t.setText(promoCode.toUpperCase() + " Promocode");
                this.v.setVisibility(8);
            }
        } else {
            this.w.setVisibility(8);
        }
        if (this.z != null) {
            a(this.s, cJROrderedCart);
        }
        this.y = d(cJROrderedCart);
        if (!TextUtils.isEmpty(this.y)) {
            this.x.append(": " + this.y);
            return;
        }
        this.x.setVisibility(8);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        IJRDataModel iJRDataModel;
        ArrayList<CJROrderedCart> orderedCartList;
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
            if (!(cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || (iJRDataModel = this.f21448c) == null || !(iJRDataModel instanceof CJROrderItems))) {
                this.M = cJROrderSummary;
                C0424a aVar = C0424a.NO_OP;
                String paymentStatus = cJROrderSummary.getPaymentStatus();
                if (paymentStatus.equalsIgnoreCase("success")) {
                    aVar = C0424a.PAYMENT_SUCCESS;
                } else if (paymentStatus.equalsIgnoreCase("failed")) {
                    aVar = C0424a.PAYMENT_FAILED;
                } else if (paymentStatus.equalsIgnoreCase("processing")) {
                    aVar = C0424a.PAYMENT_PENDING;
                }
                if (AnonymousClass6.f21461a[aVar.ordinal()] == 1 && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null) {
                    for (CJROrderedCart next : orderedCartList) {
                        if (!e(next)) {
                            if (aVar != C0424a.PAYMENT_SUCCESS) {
                                break;
                            }
                            int parseInt = Integer.parseInt(next.getItemStatus());
                            if (parseInt == 2 || parseInt == 5) {
                                aVar = C0424a.BOOKING_PENDING;
                            } else if (parseInt == 6) {
                                aVar = C0424a.BOOKING_FAILED;
                            } else if (parseInt == 7) {
                                aVar = C0424a.BOOKING_SUCCESSFUL;
                            }
                        }
                    }
                }
                if (AnonymousClass6.f21461a[aVar.ordinal()] == 5) {
                    aVar = C0424a.PAYMENT_SUCCESS;
                }
                this.z = aVar;
                this.k = ((CJROrderItems) this.f21448c).getOrderItemSelected();
                CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(this.k);
                if (this.l.equalsIgnoreCase("Flights")) {
                    c(cJROrderedCart);
                } else if (this.l.equalsIgnoreCase("Flights_Insurance")) {
                    b(cJROrderedCart);
                } else {
                    a(cJROrderedCart);
                }
            }
        } else if (iJRPaytmDataModel instanceof CJRActionResponse) {
            CJRActionResponse cJRActionResponse = (CJRActionResponse) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(cJRActionResponse.getMessage())) {
                b(cJRActionResponse.getMessage());
            } else if (cJRActionResponse.getActions() != null) {
                ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
                if (actions.size() > 0) {
                    CJROrderSummaryAction cJROrderSummaryAction = actions.get(0);
                    if (cJROrderSummaryAction.getUiControl().equalsIgnoreCase("browser") && cJROrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getUrl())) {
                        TextUtils.isEmpty(this.L);
                        com.travel.f.a aVar2 = this.G;
                        String str = this.I;
                        aVar2.f23435d = this.L;
                        aVar2.f23434c = str;
                        String str2 = com.travel.f.a.f23431i;
                        q.d("handle response - " + cJROrderSummaryAction.getUrlParams().getUrl());
                        String url = cJROrderSummaryAction.getUrlParams().getUrl();
                        String title = cJRActionResponse.getTitle();
                        String str3 = com.travel.f.a.f23431i;
                        q.d("new FileLoader - with title - ".concat(String.valueOf(title)));
                        new a.C0454a(url, title).execute(new Void[0]);
                    }
                }
            } else if (!TextUtils.isEmpty(cJRActionResponse.getError())) {
                b(cJRActionResponse.getError());
            }
        }
        c();
    }

    private void a(TextView textView, CJROrderedCart cJROrderedCart) {
        int i2;
        int i3;
        int i4 = R.color.color_222222;
        switch (this.z) {
            case PAYMENT_SUCCESS:
                i3 = R.drawable.pre_td_success_order_summary_badge_border;
                i2 = R.color.just_tickets_con_fee_desc;
                break;
            case PAYMENT_FAILED:
                i3 = R.drawable.pre_td_failed_order_summary_badge_border;
                i2 = R.color.event_sold_out_color;
                break;
            case PAYMENT_PENDING:
                i3 = R.drawable.pre_td_processing_order_summary_badge_border;
                i2 = R.color.movie_pending_status_background;
                break;
            case BOOKING_PENDING:
                i3 = R.drawable.pre_td_processing_order_summary_badge_border;
                i2 = R.color.movie_pending_status_background;
                break;
            case BOOKING_SUCCESSFUL:
                i3 = R.drawable.pre_td_success_order_summary_badge_border;
                i2 = R.color.just_tickets_con_fee_desc;
                break;
            case BOOKING_FAILED:
                i3 = R.drawable.pre_td_failed_order_summary_badge_border;
                i2 = R.color.event_sold_out_color;
                break;
            default:
                i2 = i4;
                i3 = -1;
                break;
        }
        if (textView != null) {
            if (cJROrderedCart.getItemStatus().equalsIgnoreCase("17") || cJROrderedCart.getItemStatus().equalsIgnoreCase("18")) {
                i3 = R.drawable.pre_td_failed_order_summary_badge_border;
                i2 = R.color.event_sold_out_color;
            }
            String status = cJROrderedCart.getStatus();
            if (i3 != -1) {
                textView.setTextColor(androidx.core.content.b.c(getActivity(), i2));
                textView.setBackground(androidx.core.content.b.a((Context) getActivity(), i3));
                textView.setText(status);
            }
        }
    }

    private static void a(TextView textView, String str) {
        if (str.equalsIgnoreCase("SUCCESS")) {
            textView.setText(str);
        } else if (str.equalsIgnoreCase("PROCESSING")) {
            textView.setBackground(androidx.core.content.b.a(textView.getContext(), R.drawable.pre_td_processing_order_summary_badge_border));
            textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.movie_pending_status_background));
            textView.setText(str);
        } else {
            textView.setBackground(androidx.core.content.b.a(textView.getContext(), R.drawable.pre_td_failed_order_summary_badge_border));
            textView.setTextColor(androidx.core.content.b.c(textView.getContext(), R.color.event_sold_out_color));
            textView.setText(str);
        }
    }

    private void a(CJROrderedCart cJROrderedCart, LinearLayout linearLayout) {
        linearLayout.removeAllViews();
        if (cJROrderedCart != null && cJROrderedCart.getAction() != null) {
            Iterator<CJROrderSummaryAction> it2 = cJROrderedCart.getAction().iterator();
            while (it2.hasNext()) {
                final CJROrderSummaryAction next = it2.next();
                TextView textView = new TextView(linearLayout.getContext());
                textView.setTextColor(androidx.core.content.b.c(linearLayout.getContext(), R.color.color_222222));
                textView.setTextSize(13.0f);
                textView.setGravity(3);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                textView.setTextColor(androidx.core.content.b.c(linearLayout.getContext(), R.color.blue));
                layoutParams.setMargins(0, 20, 50, 20);
                textView.setLayoutParams(layoutParams);
                if (TextUtils.isEmpty(next.getLabel()) || !next.getLabel().toLowerCase().contains("invoice")) {
                    textView.setText(next.getLabel());
                } else {
                    textView.setText("Download Ticket");
                }
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (!TextUtils.isEmpty(next.getConfirmation())) {
                            a.a(a.this, next);
                        } else {
                            a.b(a.this, next);
                        }
                    }
                });
                linearLayout.addView(textView);
            }
        }
    }

    private String a(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        return str2 + "sso_token=" + r.a(getActivity().getApplicationContext()).b("sso_token=", "", true);
    }

    private void b(String str) {
        if (!this.H) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(str).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    boolean unused = a.this.H = false;
                }
            });
            builder.show();
            this.H = true;
        }
    }

    private void b() {
        ProgressBar progressBar = this.J;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    private void c() {
        ProgressBar progressBar = this.J;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private static String d(CJROrderedCart cJROrderedCart) {
        Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
        f fVar = new f();
        CJRFlightSummaryMetadataResponse cJRFlightSummaryMetadataResponse = (CJRFlightSummaryMetadataResponse) fVar.a(fVar.a(metaDataResponse), CJRFlightSummaryMetadataResponse.class);
        boolean z2 = cJRFlightSummaryMetadataResponse == null || TextUtils.isEmpty(cJRFlightSummaryMetadataResponse.getfDir()) || (!cJRFlightSummaryMetadataResponse.getfDir().equalsIgnoreCase("R") && !cJRFlightSummaryMetadataResponse.getfDir().equalsIgnoreCase("OR"));
        try {
            JSONObject jSONObject = new JSONObject(cJROrderedCart.getFullFillmentOject().getFulfillmentResponse());
            if (z2) {
                return jSONObject.getString("onward_pnr");
            }
            return jSONObject.getString("return_pnr");
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static boolean e(CJROrderedCart cJROrderedCart) {
        if (!(cJROrderedCart == null || cJROrderedCart.getMetaDataResponse() == null)) {
            try {
                return new JSONObject(new f().a(cJROrderedCart.getMetaDataResponse())).has("addon_type");
            } catch (JSONException e2) {
                q.c(e2.getMessage());
            }
        }
        return false;
    }

    static /* synthetic */ void a(a aVar, String str) {
        d.a();
        aVar.getActivity().startActivity(d.b().a((Context) aVar.getActivity(), str, "", (String) null, (String) null));
    }

    static /* synthetic */ void a(a aVar, CJROrderSummaryAction cJROrderSummaryAction) {
        try {
            String confirmation = cJROrderSummaryAction.getConfirmation();
            AlertDialog.Builder builder = new AlertDialog.Builder(aVar.getActivity());
            builder.setMessage(confirmation);
            builder.setPositiveButton(aVar.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.setNegativeButton(aVar.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void b(a aVar, CJROrderSummaryAction cJROrderSummaryAction) {
        String str;
        String str2;
        try {
            aVar.b();
            if (cJROrderSummaryAction.getUrlParams() != null) {
                if (cJROrderSummaryAction.getUrlParams().getMethod() != null && cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                    String oVar = cJROrderSummaryAction.getUrlParams().getBody() != null ? cJROrderSummaryAction.getUrlParams().getBody().toString() : null;
                    aVar.G.a(cJROrderSummaryAction.getLabel());
                    String label = cJROrderSummaryAction.getLabel();
                    String url = cJROrderSummaryAction.getUrlParams().getUrl();
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    if (TextUtils.isEmpty(label) || label.equalsIgnoreCase("invoice") || label.equalsIgnoreCase("share ticket")) {
                        str2 = aVar.a(url);
                    } else {
                        hashMap.put("sso_token=", com.travel.utils.b.a(aVar.getActivity()));
                        str2 = com.paytm.utility.b.s(aVar.getActivity(), url);
                    }
                    String replace = str2.replace(" ", "%20");
                    CJRActionResponse cJRActionResponse = new CJRActionResponse();
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = aVar.getActivity().getApplicationContext();
                    bVar.f42878b = a.c.FLIGHT;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = aVar.getActivity().getClass().getSimpleName();
                    bVar.f42880d = replace;
                    bVar.f42881e = null;
                    bVar.f42882f = hashMap;
                    bVar.f42883g = null;
                    bVar.f42884h = oVar;
                    bVar.f42885i = cJRActionResponse;
                    bVar.j = aVar;
                    bVar.t = null;
                    com.paytm.network.a l2 = bVar.l();
                    l2.f42860d = true;
                    l2.a();
                    return;
                }
            }
            aVar.G.a(cJROrderSummaryAction.getLabel());
            String label2 = cJROrderSummaryAction.getLabel();
            String url2 = cJROrderSummaryAction.getUrlParams().getUrl();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("Content-Type", "application/json");
            if (TextUtils.isEmpty(label2) || label2.equalsIgnoreCase("invoice") || label2.equalsIgnoreCase("share ticket")) {
                str = aVar.a(url2);
            } else {
                hashMap2.put("sso_token=", com.travel.utils.b.a(aVar.getActivity()));
                str = com.paytm.utility.b.s(aVar.getActivity(), url2);
            }
            String replace2 = str.replace(" ", "%20");
            q.d("making get request w/o return replace");
            CJRActionResponse cJRActionResponse2 = new CJRActionResponse();
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = aVar.getActivity().getApplicationContext();
            bVar2.f42878b = a.c.FLIGHT;
            bVar2.f42879c = a.C0715a.GET;
            bVar2.n = a.b.SILENT;
            bVar2.o = aVar.getActivity().getClass().getSimpleName();
            bVar2.f42880d = replace2;
            bVar2.f42881e = null;
            bVar2.f42882f = hashMap2;
            bVar2.f42883g = null;
            bVar2.f42884h = null;
            bVar2.f42885i = cJRActionResponse2;
            bVar2.j = aVar;
            bVar2.t = null;
            com.paytm.network.a l3 = bVar2.l();
            l3.f42860d = true;
            l3.a();
        } catch (Exception e2) {
            aVar.c();
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }
}
