package com.travel.flight.flightorder.activity;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gsonhtcfix.f;
import com.travel.flight.b;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation;
import org.json.JSONArray;
import org.json.JSONObject;

public class RefundBreakUpActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f24340a;

    /* renamed from: b  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24341b;

    /* renamed from: c  reason: collision with root package name */
    private CJROrderSummaryCancellation f24342c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f24343d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, List<String>> f24344e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Double> f24345f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Double> f24346g;

    /* renamed from: h  reason: collision with root package name */
    private Map<String, Double> f24347h;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f24348i;
    private View j;
    private TextView k;
    private TextView l;
    private RelativeLayout m;
    private TextView n;
    private Map<String, Double> o;
    private HashMap<String, JSONObject> p;
    private JSONArray q;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:18|(3:19|20|(4:26|(2:27|(5:29|(4:32|(2:33|(2:35|(1:40)(2:73|39))(1:74))|(1:42)(1:71)|30)|72|43|(3:70|45|(7:49|50|51|52|53|54|55)(0))(1:58))(1:69))|62|63)(0))|59|61|62|63|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x02ed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.String r1 = " "
            super.onCreate(r24)
            int r2 = com.travel.flight.R.layout.pre_f_refund_breakup_layout
            r0.setContentView((int) r2)
            android.content.Intent r2 = r23.getIntent()
            if (r2 == 0) goto L_0x002e
            java.lang.String r3 = "Order_summary"
            java.io.Serializable r3 = r2.getSerializableExtra(r3)
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r3 = (com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse) r3
            r0.f24341b = r3
            java.lang.String r3 = "order-summary-cancellation"
            java.io.Serializable r3 = r2.getSerializableExtra(r3)
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r3 = (net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation) r3
            r0.f24342c = r3
            java.lang.String r3 = "order_id"
            java.lang.String r2 = r2.getStringExtra(r3)
            r0.f24340a = r2
        L_0x002e:
            int r2 = com.travel.flight.R.id.activity_header
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = com.travel.flight.R.id.toolbar_btn_layout
            android.view.View r3 = r0.findViewById(r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            int r4 = com.travel.flight.R.id.back_btn
            android.view.View r4 = r0.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            int r5 = com.travel.common.R.drawable.travel_res_common_back_button
            r4.setImageResource(r5)
            r5 = 1127481344(0x43340000, float:180.0)
            r4.setRotation(r5)
            com.travel.flight.flightorder.activity.RefundBreakUpActivity$1 r4 = new com.travel.flight.flightorder.activity.RefundBreakUpActivity$1
            r4.<init>()
            r3.setOnClickListener(r4)
            java.lang.String r3 = "Detailed Refund Summary"
            r2.setText(r3)
            int r2 = com.travel.flight.R.id.passenger_desc_container
            android.view.View r2 = r0.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r0.f24343d = r2
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r2 = r0.f24342c     // Catch:{ Exception -> 0x0349 }
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation$CJROrderSummaryCancellationBody r2 = r2.getBody()     // Catch:{ Exception -> 0x0349 }
            java.lang.Object r2 = r2.getItems()     // Catch:{ Exception -> 0x0349 }
            com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0349 }
            r3.<init>()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = r3.a((java.lang.Object) r2)     // Catch:{ Exception -> 0x0349 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0349 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0349 }
            r23.a()     // Catch:{ Exception -> 0x0349 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r0.f24344e     // Catch:{ Exception -> 0x0349 }
            if (r2 == 0) goto L_0x0349
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r0.f24344e     // Catch:{ Exception -> 0x0349 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0349 }
            if (r2 != 0) goto L_0x0349
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r0.f24344e     // Catch:{ Exception -> 0x0349 }
            java.util.Set r2 = r2.keySet()     // Catch:{ Exception -> 0x0349 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x0349 }
            r4 = 2
            if (r2 <= r4) goto L_0x009d
            goto L_0x0349
        L_0x009d:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0349 }
            r2.<init>()     // Catch:{ Exception -> 0x0349 }
            r0.f24346g = r2     // Catch:{ Exception -> 0x0349 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0349 }
            r2.<init>()     // Catch:{ Exception -> 0x0349 }
            r0.f24345f = r2     // Catch:{ Exception -> 0x0349 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2 = r0.f24344e     // Catch:{ Exception -> 0x0349 }
            java.util.Set r2 = r2.keySet()     // Catch:{ Exception -> 0x0349 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0349 }
        L_0x00b5:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x0349 }
            if (r4 == 0) goto L_0x0349
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0349 }
            android.content.Context r5 = r23.getApplicationContext()     // Catch:{ Exception -> 0x0349 }
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)     // Catch:{ Exception -> 0x0349 }
            int r6 = com.travel.flight.R.layout.pre_f_refund_breakup_title_layout     // Catch:{ Exception -> 0x0349 }
            r7 = 0
            r8 = 0
            android.view.View r5 = r5.inflate(r6, r7, r8)     // Catch:{ Exception -> 0x0349 }
            int r6 = com.travel.flight.R.id.layout_src_dest     // Catch:{ Exception -> 0x0349 }
            android.view.View r6 = r5.findViewById(r6)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r9 = r0.f24343d     // Catch:{ Exception -> 0x0349 }
            r9.addView(r5)     // Catch:{ Exception -> 0x0349 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5 = r0.f24344e     // Catch:{ Exception -> 0x0349 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ Exception -> 0x0349 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ Exception -> 0x0349 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0349 }
            r5.<init>()     // Catch:{ Exception -> 0x0349 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0349 }
            r9 = r7
            r10 = r9
        L_0x00f1:
            boolean r11 = r4.hasNext()     // Catch:{ Exception -> 0x0349 }
            if (r11 == 0) goto L_0x0324
            java.lang.Object r9 = r4.next()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r3.getString(r9)     // Catch:{ Exception -> 0x0349 }
            com.google.gsonhtcfix.f r11 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0349 }
            r11.<init>()     // Catch:{ Exception -> 0x0349 }
            java.lang.Class<net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation$CJROrderSummaryCancellationItem> r12 = net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation.CJROrderSummaryCancellationItem.class
            java.lang.Object r10 = r11.a((java.lang.String) r10, r12)     // Catch:{ Exception -> 0x0349 }
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation$CJROrderSummaryCancellationItem r10 = (net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation.CJROrderSummaryCancellationItem) r10     // Catch:{ Exception -> 0x0349 }
            java.lang.String r11 = r0.a((java.lang.String) r9)     // Catch:{ Exception -> 0x0349 }
            r10.getDeparture_date()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r12 = r10.getOrigin()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.getDestination()     // Catch:{ Exception -> 0x0349 }
            r5.add(r11)     // Catch:{ Exception -> 0x0349 }
            android.content.Context r13 = r23.getApplicationContext()     // Catch:{ Exception -> 0x0349 }
            android.view.LayoutInflater r13 = android.view.LayoutInflater.from(r13)     // Catch:{ Exception -> 0x0349 }
            int r14 = com.travel.flight.R.layout.pre_f_refund_breakup_passenger_detail_layout     // Catch:{ Exception -> 0x0349 }
            android.view.View r13 = r13.inflate(r14, r7, r8)     // Catch:{ Exception -> 0x0349 }
            int r14 = com.travel.flight.R.id.refund_passenger_name     // Catch:{ Exception -> 0x0349 }
            android.view.View r14 = r13.findViewById(r14)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r14 = (android.widget.TextView) r14     // Catch:{ Exception -> 0x0349 }
            int r15 = com.travel.flight.R.id.refund_passenger_price     // Catch:{ Exception -> 0x0349 }
            android.view.View r15 = r13.findViewById(r15)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r15 = (android.widget.TextView) r15     // Catch:{ Exception -> 0x0349 }
            int r7 = com.travel.flight.R.id.refund_breakup_arrow_image     // Catch:{ Exception -> 0x0349 }
            android.view.View r7 = r13.findViewById(r7)     // Catch:{ Exception -> 0x0349 }
            android.widget.ImageView r7 = (android.widget.ImageView) r7     // Catch:{ Exception -> 0x0349 }
            int r8 = com.travel.flight.R.id.refund_breakup_per_passenger_layout     // Catch:{ Exception -> 0x0349 }
            android.view.View r8 = r13.findViewById(r8)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8     // Catch:{ Exception -> 0x0349 }
            r16 = r2
            int r2 = com.travel.flight.R.id.refund_passenger_layout     // Catch:{ Exception -> 0x0349 }
            android.view.View r2 = r13.findViewById(r2)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0349 }
            android.content.Context r17 = r23.getApplicationContext()     // Catch:{ Exception -> 0x0349 }
            r18 = r3
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r17)     // Catch:{ Exception -> 0x0349 }
            r17 = r4
            int r4 = com.travel.flight.R.layout.pre_f_flight_refund_summary_card     // Catch:{ Exception -> 0x0349 }
            r19 = r5
            r24 = r10
            r5 = 0
            r10 = 0
            android.view.View r3 = r3.inflate(r4, r5, r10)     // Catch:{ Exception -> 0x0349 }
            r8.addView(r3)     // Catch:{ Exception -> 0x0349 }
            r4 = 8
            r8.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            r14.setText(r11)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r4 = r0.f24343d     // Catch:{ Exception -> 0x0349 }
            r4.addView(r13)     // Catch:{ Exception -> 0x0349 }
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0349 }
            r2.setTag(r4)     // Catch:{ Exception -> 0x0349 }
            com.travel.flight.flightorder.activity.RefundBreakUpActivity$2 r4 = new com.travel.flight.flightorder.activity.RefundBreakUpActivity$2     // Catch:{ Exception -> 0x0349 }
            r4.<init>(r2, r7, r8)     // Catch:{ Exception -> 0x0349 }
            r2.setOnClickListener(r4)     // Catch:{ Exception -> 0x0349 }
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r2 = r0.f24342c     // Catch:{ JSONException -> 0x02e8 }
            if (r2 == 0) goto L_0x02e8
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r2 = r0.f24342c     // Catch:{ JSONException -> 0x02e8 }
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation$CJROrderSummaryCancellationBody r2 = r2.getBody()     // Catch:{ JSONException -> 0x02e8 }
            if (r2 == 0) goto L_0x02e8
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r2 = r0.f24342c     // Catch:{ JSONException -> 0x02e8 }
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation$CJROrderSummaryCancellationBody r2 = r2.getBody()     // Catch:{ JSONException -> 0x02e8 }
            java.lang.Object r2 = r2.getAddOns()     // Catch:{ JSONException -> 0x02e8 }
            if (r2 == 0) goto L_0x02e8
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ JSONException -> 0x02e8 }
            r2.<init>()     // Catch:{ JSONException -> 0x02e8 }
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation r4 = r0.f24342c     // Catch:{ JSONException -> 0x02e8 }
            net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation$CJROrderSummaryCancellationBody r4 = r4.getBody()     // Catch:{ JSONException -> 0x02e8 }
            java.lang.Object r4 = r4.getAddOns()     // Catch:{ JSONException -> 0x02e8 }
            java.lang.String r2 = r2.a((java.lang.Object) r4)     // Catch:{ JSONException -> 0x02e8 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x02e8 }
            r4.<init>(r2)     // Catch:{ JSONException -> 0x02e8 }
            r0.q = r4     // Catch:{ JSONException -> 0x02e8 }
            r2 = 0
            r4 = 0
        L_0x01c1:
            org.json.JSONArray r7 = r0.q     // Catch:{ JSONException -> 0x02e8 }
            int r7 = r7.length()     // Catch:{ JSONException -> 0x02e8 }
            if (r2 >= r7) goto L_0x02e8
            org.json.JSONArray r7 = r0.q     // Catch:{ JSONException -> 0x02e8 }
            org.json.JSONObject r7 = r7.getJSONObject(r2)     // Catch:{ JSONException -> 0x02e8 }
            java.lang.String r8 = "policies"
            org.json.JSONArray r8 = r7.getJSONArray(r8)     // Catch:{ JSONException -> 0x02e8 }
            r10 = r4
            r4 = 0
        L_0x01d7:
            int r11 = r8.length()     // Catch:{ JSONException -> 0x02e8 }
            if (r4 >= r11) goto L_0x0214
            org.json.JSONObject r11 = r8.getJSONObject(r4)     // Catch:{ JSONException -> 0x02e8 }
            java.lang.String r13 = "item_ids"
            org.json.JSONArray r11 = r11.getJSONArray(r13)     // Catch:{ JSONException -> 0x02e8 }
            r13 = 0
        L_0x01e8:
            int r14 = r11.length()     // Catch:{ JSONException -> 0x02e8 }
            if (r13 >= r14) goto L_0x020f
            double r20 = r11.getDouble(r13)     // Catch:{ JSONException -> 0x02e8 }
            java.lang.Double r14 = java.lang.Double.valueOf(r20)     // Catch:{ JSONException -> 0x02e8 }
            long r20 = r14.longValue()     // Catch:{ JSONException -> 0x02e8 }
            java.lang.String r14 = java.lang.String.valueOf(r20)     // Catch:{ JSONException -> 0x02e8 }
            boolean r20 = android.text.TextUtils.isEmpty(r14)     // Catch:{ JSONException -> 0x02e8 }
            if (r20 != 0) goto L_0x020c
            boolean r14 = r9.equalsIgnoreCase(r14)     // Catch:{ JSONException -> 0x02e8 }
            if (r14 == 0) goto L_0x020c
            r10 = 1
            goto L_0x020f
        L_0x020c:
            int r13 = r13 + 1
            goto L_0x01e8
        L_0x020f:
            if (r10 != 0) goto L_0x0214
            int r4 = r4 + 1
            goto L_0x01d7
        L_0x0214:
            r4 = r10
            if (r4 == 0) goto L_0x02dc
            java.lang.String r2 = "total_refund_amount"
            java.lang.String r2 = r7.getString(r2)     // Catch:{ JSONException -> 0x02e8 }
            double r10 = java.lang.Double.parseDouble(r2)     // Catch:{ JSONException -> 0x02e8 }
            java.lang.String r2 = "total_policy_amount"
            java.lang.String r2 = r7.getString(r2)     // Catch:{ JSONException -> 0x02e8 }
            double r13 = java.lang.Double.parseDouble(r2)     // Catch:{ JSONException -> 0x02e8 }
            java.lang.String r2 = "note"
            java.lang.String r2 = r7.getString(r2)     // Catch:{ JSONException -> 0x02e8 }
            java.util.Map<java.lang.String, java.lang.Double> r4 = r0.f24345f     // Catch:{ JSONException -> 0x02e8 }
            java.lang.Double r7 = java.lang.Double.valueOf(r10)     // Catch:{ JSONException -> 0x02e8 }
            r4.put(r9, r7)     // Catch:{ JSONException -> 0x02e8 }
            java.util.Map<java.lang.String, java.lang.Double> r4 = r0.f24346g     // Catch:{ JSONException -> 0x02e8 }
            java.lang.Double r7 = java.lang.Double.valueOf(r13)     // Catch:{ JSONException -> 0x02e8 }
            r4.put(r9, r7)     // Catch:{ JSONException -> 0x02e8 }
            r7 = 0
            int r4 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x02e8
            int r4 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x02e8
            int r4 = com.travel.flight.R.id.flight_order_insurance_amount_refund_layout     // Catch:{ JSONException -> 0x02e8 }
            android.view.View r4 = r3.findViewById(r4)     // Catch:{ JSONException -> 0x02e8 }
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4     // Catch:{ JSONException -> 0x02e8 }
            int r7 = com.travel.flight.R.id.flight_order_insurance_amount_paid_layout     // Catch:{ JSONException -> 0x02e8 }
            android.view.View r7 = r3.findViewById(r7)     // Catch:{ JSONException -> 0x02e8 }
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7     // Catch:{ JSONException -> 0x02e8 }
            int r8 = com.travel.flight.R.id.flight_order_insurance_amount_refund     // Catch:{ JSONException -> 0x02e8 }
            android.view.View r8 = r3.findViewById(r8)     // Catch:{ JSONException -> 0x02e8 }
            android.widget.TextView r8 = (android.widget.TextView) r8     // Catch:{ JSONException -> 0x02e8 }
            int r5 = com.travel.flight.R.id.flight_order_insurance_amount_paid     // Catch:{ JSONException -> 0x02e8 }
            android.view.View r5 = r3.findViewById(r5)     // Catch:{ JSONException -> 0x02e8 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ JSONException -> 0x02e8 }
            r21 = r12
            int r12 = com.travel.flight.R.id.flight_order_insurance_desc     // Catch:{ JSONException -> 0x02d9 }
            android.view.View r12 = r3.findViewById(r12)     // Catch:{ JSONException -> 0x02d9 }
            android.widget.TextView r12 = (android.widget.TextView) r12     // Catch:{ JSONException -> 0x02d9 }
            r22 = r6
            r6 = 0
            r4.setVisibility(r6)     // Catch:{ JSONException -> 0x02ed }
            r7.setVisibility(r6)     // Catch:{ JSONException -> 0x02ed }
            r12.setVisibility(r6)     // Catch:{ JSONException -> 0x02ed }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ed }
            r4.<init>()     // Catch:{ JSONException -> 0x02ed }
            int r7 = com.travel.flight.R.string.rs_symbol     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r7 = r0.getString(r7)     // Catch:{ JSONException -> 0x02ed }
            r4.append(r7)     // Catch:{ JSONException -> 0x02ed }
            r4.append(r1)     // Catch:{ JSONException -> 0x02ed }
            int r7 = (int) r10     // Catch:{ JSONException -> 0x02ed }
            double r10 = (double) r7     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r7 = com.travel.flight.utils.c.a((double) r10)     // Catch:{ JSONException -> 0x02ed }
            r4.append(r7)     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x02ed }
            r8.setText(r4)     // Catch:{ JSONException -> 0x02ed }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02ed }
            r4.<init>()     // Catch:{ JSONException -> 0x02ed }
            int r7 = com.travel.flight.R.string.rs_symbol     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r7 = r0.getString(r7)     // Catch:{ JSONException -> 0x02ed }
            r4.append(r7)     // Catch:{ JSONException -> 0x02ed }
            r4.append(r1)     // Catch:{ JSONException -> 0x02ed }
            int r7 = (int) r13     // Catch:{ JSONException -> 0x02ed }
            double r7 = (double) r7     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r7 = com.travel.flight.utils.c.a((double) r7)     // Catch:{ JSONException -> 0x02ed }
            r4.append(r7)     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x02ed }
            r5.setText(r4)     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r4 = "<b><font color='#3062ad' >Note: </font></b> "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x02ed }
            java.lang.String r2 = r4.concat(r2)     // Catch:{ JSONException -> 0x02ed }
            android.text.Spanned r2 = android.text.Html.fromHtml(r2)     // Catch:{ JSONException -> 0x02ed }
            r12.setText(r2)     // Catch:{ JSONException -> 0x02ed }
            goto L_0x02ed
        L_0x02d9:
            r22 = r6
            goto L_0x02ec
        L_0x02dc:
            r22 = r6
            r21 = r12
            r6 = 0
            int r2 = r2 + 1
            r6 = r22
            r5 = 0
            goto L_0x01c1
        L_0x02e8:
            r22 = r6
            r21 = r12
        L_0x02ec:
            r6 = 0
        L_0x02ed:
            double r2 = r0.a(r3, r9)     // Catch:{ Exception -> 0x0349 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0349 }
            r4.<init>()     // Catch:{ Exception -> 0x0349 }
            int r5 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x0349 }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x0349 }
            r4.append(r5)     // Catch:{ Exception -> 0x0349 }
            r4.append(r1)     // Catch:{ Exception -> 0x0349 }
            int r2 = (int) r2     // Catch:{ Exception -> 0x0349 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = com.travel.flight.utils.c.a((double) r2)     // Catch:{ Exception -> 0x0349 }
            r4.append(r2)     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x0349 }
            r15.setText(r2)     // Catch:{ Exception -> 0x0349 }
            r10 = r24
            r2 = r16
            r4 = r17
            r3 = r18
            r5 = r19
            r9 = r21
            r6 = r22
            r7 = 0
            r8 = 0
            goto L_0x00f1
        L_0x0324:
            r16 = r2
            r18 = r3
            r22 = r6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0349 }
            r2.<init>()     // Catch:{ Exception -> 0x0349 }
            r2.append(r9)     // Catch:{ Exception -> 0x0349 }
            java.lang.String r3 = " - "
            r2.append(r3)     // Catch:{ Exception -> 0x0349 }
            r2.append(r10)     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0349 }
            r6 = r22
            r6.setText(r2)     // Catch:{ Exception -> 0x0349 }
            r2 = r16
            r3 = r18
            goto L_0x00b5
        L_0x0349:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.activity.RefundBreakUpActivity.onCreate(android.os.Bundle):void");
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

    /* JADX WARNING: Removed duplicated region for block: B:29:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01a5 A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01c1 A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01cc A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01dc A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0265 A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x026b A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0453 A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x047f A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x04b3 A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x04bb A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x04c2 A[Catch:{ Exception -> 0x04ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x04c7  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x04ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double a(android.view.View r48, java.lang.String r49) {
        /*
            r47 = this;
            r0 = r47
            r1 = r48
            r2 = r49
            java.lang.String r3 = "-  "
            java.lang.String r4 = "paytm_handling_fee"
            java.lang.String r5 = "paytm_cashback"
            java.util.HashMap<java.lang.String, org.json.JSONObject> r6 = r0.p
            if (r6 == 0) goto L_0x04d1
            java.lang.Object r6 = r6.get(r2)
            if (r6 == 0) goto L_0x04d1
            java.util.HashMap<java.lang.String, org.json.JSONObject> r6 = r0.p
            java.lang.Object r6 = r6.get(r2)
            org.json.JSONObject r6 = (org.json.JSONObject) r6
            int r9 = com.travel.flight.R.id.flight_order_amount_paid
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r10 = com.travel.flight.R.id.flight_order_refund_convenience_fee
            android.view.View r10 = r1.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r11 = com.travel.flight.R.id.flight_order_refund_air_fare
            android.view.View r11 = r1.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = com.travel.flight.R.id.flight_order_refund_cancellation_charges
            android.view.View r12 = r1.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r13 = com.travel.flight.R.id.flight_order_refund_airline_charges
            android.view.View r13 = r1.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            int r14 = com.travel.flight.R.id.flight_order_refund_paytm_charges
            android.view.View r14 = r1.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.travel.flight.R.id.flight_order_refundable_amount
            android.view.View r15 = r1.findViewById(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            int r7 = com.travel.flight.R.id.flight_order_cashback_already_credited
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.travel.flight.R.id.flight_order_refund_processed_value
            android.view.View r8 = r1.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r18 = r8
            int r8 = com.travel.flight.R.id.flight_order_refund_paytm_note
            android.view.View r8 = r1.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r19 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r20 = r15
            java.lang.String r15 = "<b><font color='#3062ad' >Note: </font></b> "
            r7.<init>(r15)
            r21 = r14
            int r14 = com.travel.flight.R.string.flight_order_summary_paytm_note
            java.lang.String r14 = r0.getString(r14)
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            android.text.Spanned r7 = android.text.Html.fromHtml(r7)
            r8.setText(r7)
            int r7 = com.travel.flight.R.id.order_summary_refund_to_wallet
            r1.findViewById(r7)
            int r7 = com.travel.flight.R.id.order_summary_refund_to_wallet_transaction
            r1.findViewById(r7)
            int r7 = com.travel.flight.R.id.order_summary_refund_to_wallet_amount
            r1.findViewById(r7)
            int r7 = com.travel.flight.R.id.order_summary_refund_to_bank
            r1.findViewById(r7)
            int r7 = com.travel.flight.R.id.order_summary_refund_to_bank_transaction
            r1.findViewById(r7)
            int r7 = com.travel.flight.R.id.order_summary_refund_to_bank_amount
            r1.findViewById(r7)
            int r7 = com.travel.flight.R.id.order_summary_link
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r14 = com.travel.flight.R.id.order_summary_link_desc
            android.view.View r14 = r1.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r22 = r13
            int r13 = com.travel.flight.R.id.refundable_amount_layout
            android.view.View r13 = r1.findViewById(r13)
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            r23 = r13
            int r13 = com.travel.flight.R.id.total_refundable_amount_layout
            android.view.View r13 = r1.findViewById(r13)
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            r24 = r13
            int r13 = com.travel.flight.R.id.relative_cashback_credited
            android.view.View r13 = r1.findViewById(r13)
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            r25 = r13
            int r13 = com.travel.flight.R.id.flight_order_ancillary_amount_refund
            android.view.View r13 = r1.findViewById(r13)
            android.widget.TextView r13 = (android.widget.TextView) r13
            r26 = r12
            int r12 = com.travel.flight.R.id.flight_order_ancillary_amount_refund_layout
            android.view.View r12 = r1.findViewById(r12)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r27 = r11
            r11 = 8
            r7.setVisibility(r11)
            r14.setVisibility(r11)
            int r7 = com.travel.flight.R.id.flight_order_cp_note
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0.k = r7
            int r7 = com.travel.flight.R.id.flight_order_refund_cp_cancellation_charges
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0.l = r7
            int r7 = com.travel.flight.R.id.cancel_charge_cross_line
            android.view.View r7 = r1.findViewById(r7)
            r0.j = r7
            int r7 = com.travel.flight.R.id.refundable_ticket_amount_layout
            android.view.View r7 = r1.findViewById(r7)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            r0.m = r7
            int r7 = com.travel.flight.R.id.flight_order_ticket_amount
            android.view.View r1 = r1.findViewById(r7)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r0.n = r1
            java.lang.String r1 = "fare"
            org.json.JSONObject r1 = r6.getJSONObject(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r7 = "total_fare"
            int r7 = r1.optInt(r7)     // Catch:{ Exception -> 0x04ce }
            r14 = r12
            double r11 = (double) r7     // Catch:{ Exception -> 0x04ce }
            r16 = 0
            double r11 = r11 + r16
            java.lang.String r7 = "conv_fee"
            int r7 = r1.optInt(r7)     // Catch:{ Exception -> 0x04ce }
            r28 = r9
            r29 = r10
            double r9 = (double) r7     // Catch:{ Exception -> 0x04ce }
            double r9 = r9 + r16
            java.lang.String r7 = "tax"
            r1.optInt(r7)     // Catch:{ Exception -> 0x04ce }
            boolean r1 = r6.has(r5)     // Catch:{ Exception -> 0x04ce }
            if (r1 == 0) goto L_0x0162
            double r30 = r6.getDouble(r5)     // Catch:{ Exception -> 0x04ce }
            r16 = 0
            double r30 = r30 + r16
            r32 = r30
            goto L_0x0164
        L_0x0162:
            r32 = 0
        L_0x0164:
            java.lang.String r1 = "cancellation_charges"
            org.json.JSONObject r1 = r6.getJSONObject(r1)     // Catch:{ Exception -> 0x0190 }
            java.lang.String r5 = "airline_charge"
            int r5 = r1.optInt(r5)     // Catch:{ Exception -> 0x0190 }
            double r5 = (double) r5
            r16 = 0
            double r5 = r5 + r16
            boolean r7 = r1.has(r4)     // Catch:{ Exception -> 0x018e }
            if (r7 == 0) goto L_0x0184
            int r1 = r1.optInt(r4)     // Catch:{ Exception -> 0x018e }
            r7 = r3
            double r3 = (double) r1
            double r3 = r3 + r16
            goto L_0x0187
        L_0x0184:
            r7 = r3
            r3 = 0
        L_0x0187:
            double r30 = r5 + r3
            r34 = r5
            r5 = r30
            goto L_0x0199
        L_0x018e:
            r7 = r3
            goto L_0x0193
        L_0x0190:
            r7 = r3
            r5 = 0
        L_0x0193:
            r34 = r5
            r3 = 0
            r5 = 0
        L_0x0199:
            r16 = 0
            int r30 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r30 <= 0) goto L_0x01a5
            r1 = 8
            r8.setVisibility(r1)     // Catch:{ Exception -> 0x04ce }
            goto L_0x01a9
        L_0x01a5:
            r1 = 0
            r8.setVisibility(r1)     // Catch:{ Exception -> 0x04ce }
        L_0x01a9:
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24347h     // Catch:{ Exception -> 0x04ce }
            r30 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r1 == 0) goto L_0x01cc
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24347h     // Catch:{ Exception -> 0x04ce }
            int r1 = r1.size()     // Catch:{ Exception -> 0x04ce }
            if (r1 <= 0) goto L_0x01cc
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24347h     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ Exception -> 0x04ce }
            if (r1 == 0) goto L_0x01cc
            double r36 = r1.doubleValue()     // Catch:{ Exception -> 0x04ce }
            r45 = r3
            r3 = r36
            r36 = r45
            goto L_0x01d0
        L_0x01cc:
            r36 = r3
            r3 = r30
        L_0x01d0:
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.o     // Catch:{ Exception -> 0x04ce }
            if (r1 == 0) goto L_0x01f0
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.o     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            if (r1 == 0) goto L_0x01f0
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.o     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ Exception -> 0x04ce }
            double r38 = r1.doubleValue()     // Catch:{ Exception -> 0x04ce }
            r1 = r7
            r7 = r38
            r39 = r14
            r38 = r15
            goto L_0x01f7
        L_0x01f0:
            r1 = r7
            r39 = r14
            r38 = r15
            r7 = 0
        L_0x01f7:
            double r14 = r11 - r9
            int r40 = (r3 > r30 ? 1 : (r3 == r30 ? 0 : -1))
            if (r40 == 0) goto L_0x0200
            double r30 = r14 - r3
            goto L_0x0202
        L_0x0200:
            double r30 = r14 - r5
        L_0x0202:
            r41 = r5
            java.lang.String r5 = " "
            r16 = 0
            int r6 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r6 == 0) goto L_0x0265
            r43 = r9
            double r9 = r30 + r7
            r6 = r39
            r39 = r1
            r1 = 0
            r6.setVisibility(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r1.<init>()     // Catch:{ Exception -> 0x04ce }
            int r6 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r6 = (int) r7     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r6     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r6)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r13.setText(r1)     // Catch:{ Exception -> 0x04ce }
            android.widget.RelativeLayout r1 = r0.m     // Catch:{ Exception -> 0x04ce }
            r6 = 0
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x04ce }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r6.<init>()     // Catch:{ Exception -> 0x04ce }
            int r7 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r7 = r0.getString(r7)     // Catch:{ Exception -> 0x04ce }
            r6.append(r7)     // Catch:{ Exception -> 0x04ce }
            r6.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r7 = (int) r9     // Catch:{ Exception -> 0x04ce }
            double r7 = (double) r7     // Catch:{ Exception -> 0x04ce }
            java.lang.String r7 = com.travel.flight.utils.c.a((double) r7)     // Catch:{ Exception -> 0x04ce }
            r6.append(r7)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x04ce }
            r1.setText(r6)     // Catch:{ Exception -> 0x04ce }
            r30 = r9
            goto L_0x0269
        L_0x0265:
            r39 = r1
            r43 = r9
        L_0x0269:
            if (r40 == 0) goto L_0x02f9
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.f24348i     // Catch:{ Exception -> 0x04ce }
            if (r1 == 0) goto L_0x02a2
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.f24348i     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x04ce }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x04ce }
            if (r1 != 0) goto L_0x02a2
            android.widget.TextView r1 = r0.k     // Catch:{ Exception -> 0x04ce }
            r6 = 0
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x04ce }
            android.widget.TextView r1 = r0.k     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r7 = r38
            r6.<init>(r7)     // Catch:{ Exception -> 0x04ce }
            java.util.Map<java.lang.String, java.lang.String> r7 = r0.f24348i     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x04ce }
            r6.append(r7)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x04ce }
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)     // Catch:{ Exception -> 0x04ce }
            r1.setText(r6)     // Catch:{ Exception -> 0x04ce }
        L_0x02a2:
            android.view.View r1 = r0.j     // Catch:{ Exception -> 0x04ce }
            r6 = 0
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x04ce }
            android.widget.TextView r1 = r0.l     // Catch:{ Exception -> 0x04ce }
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x04ce }
            android.widget.TextView r1 = r0.l     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r6.<init>()     // Catch:{ Exception -> 0x04ce }
            int r7 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r7 = r0.getString(r7)     // Catch:{ Exception -> 0x04ce }
            r6.append(r7)     // Catch:{ Exception -> 0x04ce }
            r6.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r3 = (int) r3     // Catch:{ Exception -> 0x04ce }
            double r3 = (double) r3     // Catch:{ Exception -> 0x04ce }
            java.lang.String r3 = com.travel.flight.utils.c.a((double) r3)     // Catch:{ Exception -> 0x04ce }
            r6.append(r3)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r3 = r6.toString()     // Catch:{ Exception -> 0x04ce }
            r1.setText(r3)     // Catch:{ Exception -> 0x04ce }
            android.widget.RelativeLayout r1 = r0.m     // Catch:{ Exception -> 0x04ce }
            r3 = 0
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x04ce }
            android.widget.TextView r1 = r0.n     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r3.<init>()     // Catch:{ Exception -> 0x04ce }
            int r4 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x04ce }
            r3.append(r4)     // Catch:{ Exception -> 0x04ce }
            r3.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r4 = (int) r14     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r4     // Catch:{ Exception -> 0x04ce }
            java.lang.String r4 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r3.append(r4)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x04ce }
            r1.setText(r3)     // Catch:{ Exception -> 0x04ce }
        L_0x02f9:
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24345f     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            if (r1 == 0) goto L_0x0321
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24345f     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ Exception -> 0x04ce }
            double r3 = r1.doubleValue()     // Catch:{ Exception -> 0x04ce }
            r6 = 0
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0321
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24345f     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ Exception -> 0x04ce }
            double r3 = r1.doubleValue()     // Catch:{ Exception -> 0x04ce }
            double r30 = r30 + r3
        L_0x0321:
            r3 = r30
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24346g     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            if (r1 == 0) goto L_0x034a
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24346g     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ Exception -> 0x04ce }
            double r6 = r1.doubleValue()     // Catch:{ Exception -> 0x04ce }
            r8 = 0
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x034a
            java.util.Map<java.lang.String, java.lang.Double> r1 = r0.f24346g     // Catch:{ Exception -> 0x04ce }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.Double r1 = (java.lang.Double) r1     // Catch:{ Exception -> 0x04ce }
            double r1 = r1.doubleValue()     // Catch:{ Exception -> 0x04ce }
            double r11 = r11 + r1
        L_0x034a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r1.<init>()     // Catch:{ Exception -> 0x04ce }
            int r2 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r2 = (int) r11     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r2     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r9 = r28
            r9.setText(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r2 = r39
            r1.<init>(r2)     // Catch:{ Exception -> 0x04ce }
            int r6 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            r9 = r43
            int r6 = (int) r9     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r6     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r6)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r10 = r29
            r10.setText(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r1.<init>()     // Catch:{ Exception -> 0x04ce }
            int r6 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r6 = (int) r14     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r6     // Catch:{ Exception -> 0x04ce }
            java.lang.String r6 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r6)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r11 = r27
            r11.setText(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r1.<init>(r2)     // Catch:{ Exception -> 0x04ce }
            int r2 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            r6 = r41
            int r2 = (int) r6     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r2     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r12 = r26
            r12.setText(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r1.<init>()     // Catch:{ Exception -> 0x04ce }
            int r2 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            r6 = r34
            int r2 = (int) r6     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r2     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r13 = r22
            r13.setText(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r1.<init>()     // Catch:{ Exception -> 0x04ce }
            int r2 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            r6 = r36
            int r2 = (int) r6     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r2     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r14 = r21
            r14.setText(r1)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r1.<init>()     // Catch:{ Exception -> 0x04ce }
            int r2 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            r1.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r2 = (int) r3     // Catch:{ Exception -> 0x04ce }
            double r6 = (double) r2     // Catch:{ Exception -> 0x04ce }
            java.lang.String r2 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r1.append(r2)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x04ce }
            r15 = r20
            r15.setText(r1)     // Catch:{ Exception -> 0x04ce }
            r1 = r32
            r8 = 0
            int r10 = java.lang.Double.compare(r1, r8)     // Catch:{ Exception -> 0x04ce }
            if (r10 <= 0) goto L_0x047f
            r13 = r25
            r8 = 0
            r13.setVisibility(r8)     // Catch:{ Exception -> 0x04ce }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r8.<init>()     // Catch:{ Exception -> 0x04ce }
            int r9 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r9 = r0.getString(r9)     // Catch:{ Exception -> 0x04ce }
            r8.append(r9)     // Catch:{ Exception -> 0x04ce }
            r8.append(r5)     // Catch:{ Exception -> 0x04ce }
            int r9 = (int) r1     // Catch:{ Exception -> 0x04ce }
            double r9 = (double) r9     // Catch:{ Exception -> 0x04ce }
            java.lang.String r9 = com.travel.flight.utils.c.a((double) r9)     // Catch:{ Exception -> 0x04ce }
            r8.append(r9)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x04ce }
            r9 = r19
            r9.setText(r8)     // Catch:{ Exception -> 0x04ce }
            r13 = r24
            goto L_0x048b
        L_0x047f:
            r13 = r25
            r8 = 8
            r13.setVisibility(r8)     // Catch:{ Exception -> 0x04ce }
            r13 = r24
            r13.setVisibility(r8)     // Catch:{ Exception -> 0x04ce }
        L_0x048b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ce }
            r8.<init>()     // Catch:{ Exception -> 0x04ce }
            int r9 = com.travel.flight.R.string.rs_symbol     // Catch:{ Exception -> 0x04ce }
            java.lang.String r9 = r0.getString(r9)     // Catch:{ Exception -> 0x04ce }
            r8.append(r9)     // Catch:{ Exception -> 0x04ce }
            r8.append(r5)     // Catch:{ Exception -> 0x04ce }
            double r6 = r6 - r1
            java.lang.String r5 = com.travel.flight.utils.c.a((double) r6)     // Catch:{ Exception -> 0x04ce }
            r8.append(r5)     // Catch:{ Exception -> 0x04ce }
            java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x04ce }
            r8 = r18
            r8.setText(r5)     // Catch:{ Exception -> 0x04ce }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x04bb
            r7 = r23
            r8 = 8
            r7.setVisibility(r8)     // Catch:{ Exception -> 0x04ce }
            goto L_0x04bd
        L_0x04bb:
            r8 = 8
        L_0x04bd:
            double r3 = r3 - r1
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x04c5
            r13.setVisibility(r8)     // Catch:{ Exception -> 0x04ce }
        L_0x04c5:
            if (r1 >= 0) goto L_0x04ca
            r7 = 0
            goto L_0x04cb
        L_0x04ca:
            r7 = r3
        L_0x04cb:
            r16 = r7
            goto L_0x04d0
        L_0x04ce:
            r16 = 0
        L_0x04d0:
            return r16
        L_0x04d1:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.activity.RefundBreakUpActivity.a(android.view.View, java.lang.String):double");
    }

    private void a() {
        try {
            this.f24344e = new HashMap();
            if (this.f24342c != null && this.f24342c.getBody() != null && this.f24342c.getBody().getItems() != null) {
                JSONObject jSONObject = new JSONObject(new f().a(this.f24342c.getBody().getItems()));
                this.p = a(jSONObject);
                Iterator<CJROrderSummaryItems> it2 = this.f24341b.getBody().getItems().iterator();
                while (it2.hasNext()) {
                    CJROrderSummaryItems next = it2.next();
                    if (next.getStatus() == 18) {
                        String valueOf = String.valueOf(next.getId());
                        if (jSONObject.has(valueOf)) {
                            CJROrderSummaryCancellation.CJROrderSummaryCancellationItem cJROrderSummaryCancellationItem = (CJROrderSummaryCancellation.CJROrderSummaryCancellationItem) new f().a(jSONObject.getString(valueOf), CJROrderSummaryCancellation.CJROrderSummaryCancellationItem.class);
                            String str = cJROrderSummaryCancellationItem.getOrigin() + " - " + cJROrderSummaryCancellationItem.getDestination();
                            if (this.f24344e.get(str) != null) {
                                this.f24344e.get(str).add(valueOf);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(valueOf);
                                this.f24344e.put(str, arrayList);
                            }
                            try {
                                CJROrderSummaryCancellation.CJROrderSummaryCancellationItem cJROrderSummaryCancellationItem2 = (CJROrderSummaryCancellation.CJROrderSummaryCancellationItem) new f().a(new JSONObject(new f().a(this.f24342c.getBody().getItems())).getString(valueOf), CJROrderSummaryCancellation.CJROrderSummaryCancellationItem.class);
                                if (cJROrderSummaryCancellationItem2 != null) {
                                    if (this.f24347h == null) {
                                        this.f24347h = new HashMap();
                                    }
                                    if (this.f24348i == null) {
                                        this.f24348i = new HashMap();
                                    }
                                    if (!(cJROrderSummaryCancellationItem2.isCancelProtectUsed() == null || !cJROrderSummaryCancellationItem2.isCancelProtectUsed().booleanValue() || cJROrderSummaryCancellationItem2.getCpCancellationCharges() == null)) {
                                        this.f24347h.put(valueOf, Double.valueOf(cJROrderSummaryCancellationItem2.getCpCancellationCharges()));
                                        this.f24348i.put(valueOf, cJROrderSummaryCancellationItem2.getCpNote());
                                    }
                                    if (cJROrderSummaryCancellationItem2.getAncillaryTotalRefund() != null) {
                                        if (this.o == null) {
                                            this.o = new HashMap();
                                        }
                                        this.o.put(valueOf, cJROrderSummaryCancellationItem2.getAncillaryTotalRefund());
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private String a(String str) {
        try {
            return this.p.get(str).getJSONObject("passenger_details").getString("title") + " " + this.p.get(str).getJSONObject("passenger_details").getString("firstname") + " " + this.p.get(str).getJSONObject("passenger_details").getString("lastname");
        } catch (Exception unused) {
            return null;
        }
    }

    private static HashMap<String, JSONObject> a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap<String, JSONObject> hashMap = new HashMap<>();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2.getInt("status") == 18) {
                    hashMap.put(next, jSONObject2);
                }
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }
}
