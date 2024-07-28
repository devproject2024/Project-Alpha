package com.travel.flight.flightorder.j;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails;

public final class m extends a {
    private List<LinearLayout> A;
    private List<TextView> B;
    private List<TextView> C;
    private List<ImageView> D;
    private List<LinearLayout> E;
    private List<TextView> F;
    private List<ViewGroup> G;
    private LinearLayout H;
    private boolean I;
    private TextView J;

    /* renamed from: a  reason: collision with root package name */
    com.travel.flight.flightorder.g.a f24541a;

    /* renamed from: b  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24542b;

    /* renamed from: c  reason: collision with root package name */
    private String f24543c;

    /* renamed from: d  reason: collision with root package name */
    private String f24544d;

    /* renamed from: e  reason: collision with root package name */
    private int f24545e;

    /* renamed from: f  reason: collision with root package name */
    private int f24546f;

    /* renamed from: g  reason: collision with root package name */
    private int f24547g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f24548h = 0;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f24549i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private RelativeLayout p;
    private List<TextView> q;
    private List<ImageView> r;
    private List<TextView> s;
    private List<TextView> t;
    private List<TextView> u;
    private List<TextView> v;
    private List<TextView> w;
    private List<TextView> x;
    private List<TextView> y;
    private List<LinearLayout> z;

    public m(View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, com.travel.flight.flightorder.g.a aVar, boolean z2) {
        super(view);
        CJROrderSummaryItems cJROrderSummaryItems;
        CJROrderSummaryJourneyDetails journey_details;
        try {
            this.I = z2;
            this.j = (TextView) view.findViewById(R.id.text_origin_city_code);
            this.k = (TextView) view.findViewById(R.id.text_origin_city_name);
            this.l = (TextView) view.findViewById(R.id.text_destination_city_code);
            this.m = (TextView) view.findViewById(R.id.text_destination_city_name);
            this.o = (LinearLayout) view.findViewById(R.id.passenger_desc_container);
            this.f24549i = (ImageView) view.findViewById(R.id.source_image_view);
            this.H = (LinearLayout) view.findViewById(R.id.passenger_info_layout);
            this.J = (TextView) view.findViewById(R.id.layover_text);
            this.n = (TextView) view.findViewById(R.id.lbl_tkt_id);
            this.p = (RelativeLayout) view.findViewById(R.id.pnr_text_layout);
            this.f24542b = cJRFlightOrderSummaryResponse;
            this.f24541a = aVar;
            if (this.f24542b != null && this.f24542b.getBody() != null) {
                this.f24545e = this.f24542b.getBody().getItems().size();
                if (this.f24545e != 0) {
                    b.a.C0750a a2 = b.a(this.f24549i.getContext());
                    a2.f43753a = "http://assets.paytm.com/travel/flights/iata/v1/order_actions/small/DEFAULT.png";
                    a2.m = true;
                    b.a.C0750a.a(a2, this.f24549i, (com.paytm.utility.b.b.b) null, 2);
                    this.f24546f = 0;
                    this.f24547g = 0;
                    this.f24548h = 0;
                    Iterator<CJROrderSummaryItems> it2 = this.f24542b.getBody().getItems().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            cJROrderSummaryItems = null;
                            break;
                        }
                        cJROrderSummaryItems = it2.next();
                        if (com.travel.flight.flightorder.i.b.a(cJROrderSummaryItems) && !TextUtils.isEmpty(cJROrderSummaryItems.getF_Dir())) {
                            if (this.I) {
                                if (!"O".equalsIgnoreCase(cJROrderSummaryItems.getF_Dir())) {
                                    if ("OR".equalsIgnoreCase(cJROrderSummaryItems.getF_Dir())) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (this.I) {
                                continue;
                            } else if ("R".equalsIgnoreCase(cJROrderSummaryItems.getF_Dir())) {
                                break;
                            } else if ("OR".equalsIgnoreCase(cJROrderSummaryItems.getF_Dir())) {
                                break;
                            }
                        }
                    }
                    if (!(cJROrderSummaryItems == null || (journey_details = cJROrderSummaryItems.getJourney_details()) == null)) {
                        this.f24546f = journey_details.getFlights().size();
                    }
                    this.f24547g = com.travel.flight.flightorder.i.b.a(this.f24542b.getBody().getItems());
                    this.q = new ArrayList();
                    this.r = new ArrayList();
                    this.s = new ArrayList();
                    this.t = new ArrayList();
                    this.u = new ArrayList();
                    this.v = new ArrayList();
                    this.w = new ArrayList();
                    this.z = new ArrayList();
                    this.A = new ArrayList();
                    this.B = new ArrayList();
                    this.C = new ArrayList();
                    this.D = new ArrayList();
                    this.x = new ArrayList();
                    this.y = new ArrayList();
                    this.E = new ArrayList();
                    this.F = new ArrayList();
                    this.G = new ArrayList();
                    for (int i2 = 0; i2 < this.f24546f; i2++) {
                        View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.pre_f_order_summary_passenger_desc_layout_revamp, (ViewGroup) null, false);
                        this.q.add((TextView) inflate.findViewById(R.id.lbl_operator_name));
                        this.r.add((ImageView) inflate.findViewById(R.id.operator_logo));
                        this.s.add(this.n);
                        this.t.add((TextView) inflate.findViewById(R.id.start_date));
                        this.u.add((TextView) inflate.findViewById(R.id.pickup_time));
                        this.v.add((TextView) inflate.findViewById(R.id.end_date));
                        this.w.add((TextView) inflate.findViewById(R.id.drop_time));
                        this.x.add((TextView) inflate.findViewById(R.id.source_airport));
                        this.y.add((TextView) inflate.findViewById(R.id.dest_airport));
                        this.G.add(inflate.findViewById(R.id.pnr_text_layout));
                        this.z.add((LinearLayout) inflate.findViewById(R.id.divider_waiting_layout));
                        this.A.add((LinearLayout) inflate.findViewById(R.id.divider_non_stop_layout));
                        this.B.add((TextView) inflate.findViewById(R.id.divider_waiting_layout_time));
                        this.C.add((TextView) inflate.findViewById(R.id.divider_non_stop_layout_time));
                        this.D.add((ImageView) inflate.findViewById(R.id.divider_waiting_layout_logo));
                        this.E.add((LinearLayout) inflate.findViewById(R.id.layover_text_layout));
                        this.F.add((TextView) inflate.findViewById(R.id.layover_text));
                        this.o.addView(inflate);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0221, code lost:
        if (r0.I == false) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0223, code lost:
        r12 = r3.getFulfillment().getFulfillment_response().getOnward_pnr();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0230, code lost:
        r12 = r3.getFulfillment().getFulfillment_response().getReturn_pnr();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x023d, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x048d, code lost:
        if (r17 == com.travel.flight.flightorder.d.b.C0467b.PAYMENT_FAILED) goto L_0x0735;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x048f, code lost:
        r2 = new android.widget.TextView(r0.itemView.getContext());
        r2.setTextColor(androidx.core.content.b.c(r0.itemView.getContext(), com.travel.flight.R.color.color_222222));
        r2.setTypeface(android.graphics.Typeface.create("sans-serif-medium", 0));
        r2.setTextSize(13.0f);
        r2.setEllipsize(android.text.TextUtils.TruncateAt.END);
        r2.setGravity(3);
        r10 = new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0f);
        r10.setMargins(0, 15, 10, 15);
        r2.setLayoutParams(r10);
        r10 = r3.getPax_info();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x04d7, code lost:
        if (r10 == null) goto L_0x04fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x04d9, code lost:
        r10 = r10.getTitle() + " " + r10.getFirstname() + " " + r10.getLastname();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x04fe, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x04ff, code lost:
        r2.setText(r10);
        r10 = new android.widget.LinearLayout(r0.itemView.getContext());
        r10.addView(r2);
        r2 = new android.widget.TextView(r0.itemView.getContext());
        r2.setTextSize(13.0f);
        r2.setEllipsize(android.text.TextUtils.TruncateAt.END);
        r2.setGravity(17);
        r12 = new android.widget.LinearLayout.LayoutParams(-2, -2, 0.0f);
        r12.setMargins(10, 15, 0, 15);
        r2.setLayoutParams(r12);
        r2.setPadding(com.paytm.utility.b.c(12), com.paytm.utility.b.c((int) r8), com.paytm.utility.b.c(12), com.paytm.utility.b.c(2));
        r2.setTypeface(android.graphics.Typeface.create("sans-serif", 0));
        r5 = r3.getStatus();
        r12 = com.travel.flight.R.color.color_222222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0565, code lost:
        switch(r17) {
            case com.travel.flight.flightorder.d.b.b.PAYMENT_SUCCESS :com.travel.flight.flightorder.d.b$b: goto L_0x0582;
            case com.travel.flight.flightorder.d.b.b.PAYMENT_FAILED :com.travel.flight.flightorder.d.b$b: goto L_0x057d;
            case com.travel.flight.flightorder.d.b.b.PAYMENT_PENDING :com.travel.flight.flightorder.d.b$b: goto L_0x0578;
            case com.travel.flight.flightorder.d.b.b.BOOKING_PENDING :com.travel.flight.flightorder.d.b$b: goto L_0x0573;
            case com.travel.flight.flightorder.d.b.b.BOOKING_SUCCESSFUL :com.travel.flight.flightorder.d.b$b: goto L_0x056e;
            case com.travel.flight.flightorder.d.b.b.BOOKING_FAILED :com.travel.flight.flightorder.d.b$b: goto L_0x0569;
            default: goto L_0x0568;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0569, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border;
        r12 = com.travel.flight.R.color.event_sold_out_color;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x056e, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border;
        r12 = com.travel.flight.R.color.just_tickets_con_fee_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0573, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border;
        r12 = com.travel.flight.R.color.movie_pending_status_background;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0578, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border;
        r12 = com.travel.flight.R.color.movie_pending_status_background;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x057d, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border;
        r12 = com.travel.flight.R.color.event_sold_out_color;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0582, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border;
        r12 = com.travel.flight.R.color.just_tickets_con_fee_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x058c, code lost:
        if (r3.getStatus() == 17) goto L_0x0594;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0592, code lost:
        if (r3.getStatus() != 18) goto L_0x0598;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0594, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border;
        r12 = com.travel.flight.R.color.event_sold_out_color;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0599, code lost:
        if (r5 != 7) goto L_0x059e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x059b, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x05a0, code lost:
        if (r5 != 42) goto L_0x05a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x05a2, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x05a5, code lost:
        if (r5 != 2) goto L_0x05aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x05a7, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x05aa, code lost:
        if (r5 != 18) goto L_0x05af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x05ac, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x05af, code lost:
        if (r5 != 17) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x05b1, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x05b5, code lost:
        if (r5 != 6) goto L_0x05ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x05b7, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x05ba, code lost:
        if (r5 != r8) goto L_0x05bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x05bc, code lost:
        r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x05bf, code lost:
        r12 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x05c1, code lost:
        if (r5 != 7) goto L_0x05c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x05c3, code lost:
        r14 = com.travel.flight.R.color.just_tickets_con_fee_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x05c5, code lost:
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x05c9, code lost:
        if (r5 != 42) goto L_0x05ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x05cb, code lost:
        r14 = com.travel.flight.R.color.just_tickets_con_fee_desc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x05ce, code lost:
        if (r5 != 2) goto L_0x05d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x05d0, code lost:
        r14 = com.travel.flight.R.color.movie_pending_status_background;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x05d3, code lost:
        if (r5 != 18) goto L_0x05d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x05d5, code lost:
        r14 = com.travel.flight.R.color.event_sold_out_color;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x05d8, code lost:
        if (r5 != 17) goto L_0x05dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x05da, code lost:
        r14 = com.travel.flight.R.color.order_failure_color;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x05de, code lost:
        if (r5 != 6) goto L_0x05e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x05e0, code lost:
        r14 = com.travel.flight.R.color.event_sold_out_color;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x05e3, code lost:
        if (r5 != r8) goto L_0x05e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x05e5, code lost:
        r14 = com.travel.flight.R.color.movie_pending_status_background;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x05e8, code lost:
        r5 = -1;
        r14 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x05ea, code lost:
        if (r14 == r5) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x05ec, code lost:
        r2.setTextColor(androidx.core.content.b.c(r0.itemView.getContext(), r14));
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x05fa, code lost:
        if (r12 == r5) goto L_0x0609;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x05fc, code lost:
        r2.setBackground(androidx.core.content.b.a(r0.itemView.getContext(), r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0611, code lost:
        if (android.text.TextUtils.isEmpty(r3.getStatus_text()) != false) goto L_0x061d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0613, code lost:
        r2.setText(r3.getStatus_text());
        r10.addView(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x061d, code lost:
        r0.H.addView(r10);
        r2 = new android.widget.HorizontalScrollView(r0.itemView.getContext());
        r5 = new android.widget.LinearLayout(r0.itemView.getContext());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x063a, code lost:
        if (r3 == null) goto L_0x06e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0640, code lost:
        if (r3.getAction() == null) goto L_0x06e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0642, code lost:
        r3 = r3.getAction().iterator();
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x064f, code lost:
        if (r3.hasNext() == false) goto L_0x06e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0651, code lost:
        r12 = r3.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x065b, code lost:
        if (r12.getOrderLevel() != null) goto L_0x065e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x065d, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0662, code lost:
        if (r12.getLabel() == null) goto L_0x0670;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x066e, code lost:
        if (r12.getLabel().equalsIgnoreCase("Cancel") != false) goto L_0x0682;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0674, code lost:
        if (r12.getLabel() == null) goto L_0x06e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0680, code lost:
        if (r12.getLabel().equalsIgnoreCase("modify") == false) goto L_0x06e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0686, code lost:
        if (r12.getOrderLevel() != null) goto L_0x068a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0688, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x068a, code lost:
        r11 = r12.getOrderLevel().booleanValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0692, code lost:
        r13 = new android.widget.TextView(r0.itemView.getContext());
        r13.setTextColor(androidx.core.content.b.c(r0.itemView.getContext(), com.travel.flight.R.color.color_222222));
        r13.setTextSize(13.0f);
        r13.setGravity(3);
        r15 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        r13.setTextColor(androidx.core.content.b.c(r0.itemView.getContext(), com.travel.flight.R.color.color_33b5e5));
        r15.setMargins(0, 20, 50, 20);
        r13.setLayoutParams(r15);
        r13.setText(r12.getLabel());
        r13.setOnClickListener(new com.travel.flight.flightorder.j.m.AnonymousClass1(r0));
        r5.addView(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x06e8, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x06e9, code lost:
        if (r11 != false) goto L_0x06f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x06eb, code lost:
        r2.addView(r5);
        r0.H.addView(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x06f7, code lost:
        if (r1 == (r0.f24545e - 1)) goto L_0x073e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x06fe, code lost:
        if (r0.f24548h >= (r0.f24547g - 1)) goto L_0x073e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0700, code lost:
        r0.f24548h++;
        r2 = new android.view.View(r0.itemView.getContext());
        r3 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        r3.height = 1;
        r3.setMargins(0, 20, 20, 0);
        r2.setBackgroundColor(androidx.core.content.b.c(r0.itemView.getContext(), com.travel.flight.R.color.color_efefef));
        r2.setLayoutParams(r3);
        r0.H.addView(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0735, code lost:
        r0.H.removeAllViews();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01d4, code lost:
        if ((!android.text.TextUtils.isEmpty(r10) && (r10.equalsIgnoreCase("O") || r10.equalsIgnoreCase("OR"))) == false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01f3, code lost:
        if ((!android.text.TextUtils.isEmpty(r10) && (r10.equalsIgnoreCase("R") || r10.equalsIgnoreCase("OR"))) != false) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f7, code lost:
        if (r0.I != false) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01f9, code lost:
        r10 = r3.getF_Dir();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0201, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0207, code lost:
        if (r10.equalsIgnoreCase("OR") == false) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0209, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x020b, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x020c, code lost:
        if (r10 == false) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x020e, code lost:
        r5 = r4.getFlights();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0212, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0217, code lost:
        if (r4 >= r0.f24546f) goto L_0x0489;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r10 = r5.get(r4);
     */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0279 A[SYNTHETIC, Splitter:B:118:0x0279] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0330 A[Catch:{ Exception -> 0x0744 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.flight.flightorder.d.b.C0467b r17) {
        /*
            r16 = this;
            r0 = r16
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24542b
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            android.widget.LinearLayout r1 = r0.H     // Catch:{ Exception -> 0x0744 }
            r1.removeAllViews()     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r1 = r0.H     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = r0.J     // Catch:{ Exception -> 0x0744 }
            r1.addView(r2)     // Catch:{ Exception -> 0x0744 }
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24542b     // Catch:{ Exception -> 0x0744 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r1 = r1.getItems()     // Catch:{ Exception -> 0x0744 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0744 }
            r3 = 0
            r4 = 0
        L_0x0023:
            boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r6 = "R"
            java.lang.String r7 = "OR"
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0135
            java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems r5 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r5     // Catch:{ Exception -> 0x0744 }
            boolean r10 = com.travel.flight.flightorder.i.b.a((net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r5)     // Catch:{ Exception -> 0x0744 }
            if (r10 == 0) goto L_0x0023
            if (r3 == 0) goto L_0x003f
            if (r4 != 0) goto L_0x0135
        L_0x003f:
            if (r5 == 0) goto L_0x0124
            java.lang.String r3 = r5.getF_Dir()     // Catch:{ Exception -> 0x0744 }
            boolean r4 = r0.I     // Catch:{ Exception -> 0x0744 }
            if (r4 == 0) goto L_0x009a
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0744 }
            if (r4 != 0) goto L_0x0124
            java.lang.String r4 = "O"
            boolean r4 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0744 }
            if (r4 != 0) goto L_0x005d
            boolean r3 = r3.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0744 }
            if (r3 == 0) goto L_0x0124
        L_0x005d:
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r3 = r5.getJourney_details()     // Catch:{ Exception -> 0x0744 }
            if (r3 == 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            if (r4 == 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x0744 }
            if (r4 <= 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r4 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r4     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r4 = r4.getOrigin()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r5 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r3 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0744 }
            int r3 = r3 - r8
            java.lang.Object r3 = r5.get(r3)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r3     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r3 = r3.getDestination()     // Catch:{ Exception -> 0x0744 }
            goto L_0x0126
        L_0x009a:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0744 }
            if (r4 != 0) goto L_0x0124
            boolean r4 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0744 }
            if (r4 == 0) goto L_0x00e2
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r3 = r5.getJourney_details()     // Catch:{ Exception -> 0x0744 }
            if (r3 == 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            if (r4 == 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x0744 }
            if (r4 <= 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r4 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r4     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r4 = r4.getOrigin()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r5 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r3 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0744 }
            int r3 = r3 - r8
            java.lang.Object r3 = r5.get(r3)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r3     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r3 = r3.getDestination()     // Catch:{ Exception -> 0x0744 }
            goto L_0x0126
        L_0x00e2:
            boolean r3 = r3.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0744 }
            if (r3 == 0) goto L_0x0124
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r3 = r5.getJourney_details()     // Catch:{ Exception -> 0x0744 }
            if (r3 == 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            if (r4 == 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x0744 }
            if (r4 <= 0) goto L_0x0124
            java.util.ArrayList r4 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r4 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r4     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r4 = r4.getOrigin()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r5 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r3 = r3.getFlights()     // Catch:{ Exception -> 0x0744 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x0744 }
            int r3 = r3 - r8
            java.lang.Object r3 = r5.get(r3)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r3     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r3 = r3.getDestination()     // Catch:{ Exception -> 0x0744 }
            goto L_0x0126
        L_0x0124:
            r3 = 0
            r4 = 0
        L_0x0126:
            android.util.Pair r5 = new android.util.Pair     // Catch:{ Exception -> 0x0744 }
            r5.<init>(r4, r3)     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r3 = r5.first     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin) r3     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r4 = r5.second     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r4 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination) r4     // Catch:{ Exception -> 0x0744 }
            goto L_0x0023
        L_0x0135:
            if (r3 == 0) goto L_0x014d
            java.lang.String r1 = r3.getIata()     // Catch:{ Exception -> 0x0744 }
            r0.f24543c = r1     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r1 = r0.j     // Catch:{ Exception -> 0x0744 }
            java.lang.String r5 = r0.f24543c     // Catch:{ Exception -> 0x0744 }
            r1.setText(r5)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r1 = r0.k     // Catch:{ Exception -> 0x0744 }
            java.lang.String r3 = r3.getCity()     // Catch:{ Exception -> 0x0744 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0744 }
        L_0x014d:
            if (r4 == 0) goto L_0x0165
            java.lang.String r1 = r4.getIata()     // Catch:{ Exception -> 0x0744 }
            r0.f24544d = r1     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r1 = r0.l     // Catch:{ Exception -> 0x0744 }
            java.lang.String r3 = r0.f24544d     // Catch:{ Exception -> 0x0744 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r1 = r0.m     // Catch:{ Exception -> 0x0744 }
            java.lang.String r3 = r4.getCity()     // Catch:{ Exception -> 0x0744 }
            r1.setText(r3)     // Catch:{ Exception -> 0x0744 }
        L_0x0165:
            com.travel.flight.flightorder.g.a r1 = r0.f24541a     // Catch:{ Exception -> 0x0744 }
            java.lang.String r3 = r0.f24544d     // Catch:{ Exception -> 0x0744 }
            boolean r4 = r0.I     // Catch:{ Exception -> 0x0744 }
            r1.a((java.lang.String) r3, (boolean) r4)     // Catch:{ Exception -> 0x0744 }
            r0.f24548h = r9     // Catch:{ Exception -> 0x0744 }
            r1 = 0
        L_0x0171:
            int r3 = r0.f24545e     // Catch:{ Exception -> 0x0744 }
            if (r1 >= r3) goto L_0x0744
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r3 = r0.f24542b     // Catch:{ Exception -> 0x0744 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r3 = r3.getBody()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r3 = r3.getItems()     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r3     // Catch:{ Exception -> 0x0744 }
            boolean r3 = com.travel.flight.flightorder.i.b.a((net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r3)     // Catch:{ Exception -> 0x0744 }
            if (r3 == 0) goto L_0x073c
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r3 = r0.f24542b     // Catch:{ Exception -> 0x0744 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r3 = r3.getBody()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r3 = r3.getItems()     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r3     // Catch:{ Exception -> 0x0744 }
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r0.f24542b     // Catch:{ Exception -> 0x0744 }
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r4.getBody()     // Catch:{ Exception -> 0x0744 }
            java.util.ArrayList r4 = r4.getItems()     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems r4 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r4     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r4 = r4.getJourney_details()     // Catch:{ Exception -> 0x0744 }
            if (r4 == 0) goto L_0x073c
            java.util.ArrayList r5 = r4.getFlights()     // Catch:{ Exception -> 0x0744 }
            boolean r10 = r0.I     // Catch:{ Exception -> 0x0744 }
            if (r10 == 0) goto L_0x01d6
            java.lang.String r10 = r3.getF_Dir()     // Catch:{ Exception -> 0x0744 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0744 }
            if (r11 != 0) goto L_0x01d3
            java.lang.String r11 = "O"
            boolean r11 = r10.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x0744 }
            if (r11 != 0) goto L_0x01d1
            boolean r10 = r10.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0744 }
            if (r10 == 0) goto L_0x01d3
        L_0x01d1:
            r10 = 1
            goto L_0x01d4
        L_0x01d3:
            r10 = 0
        L_0x01d4:
            if (r10 != 0) goto L_0x01f5
        L_0x01d6:
            boolean r10 = r0.I     // Catch:{ Exception -> 0x0744 }
            if (r10 != 0) goto L_0x073c
            java.lang.String r10 = r3.getF_Dir()     // Catch:{ Exception -> 0x0744 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0744 }
            if (r11 != 0) goto L_0x01f2
            boolean r11 = r10.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0744 }
            if (r11 != 0) goto L_0x01f0
            boolean r10 = r10.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0744 }
            if (r10 == 0) goto L_0x01f2
        L_0x01f0:
            r10 = 1
            goto L_0x01f3
        L_0x01f2:
            r10 = 0
        L_0x01f3:
            if (r10 == 0) goto L_0x073c
        L_0x01f5:
            boolean r10 = r0.I     // Catch:{ Exception -> 0x0744 }
            if (r10 != 0) goto L_0x0212
            java.lang.String r10 = r3.getF_Dir()     // Catch:{ Exception -> 0x0744 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0744 }
            if (r11 != 0) goto L_0x020b
            boolean r10 = r10.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x0744 }
            if (r10 == 0) goto L_0x020b
            r10 = 1
            goto L_0x020c
        L_0x020b:
            r10 = 0
        L_0x020c:
            if (r10 == 0) goto L_0x0212
            java.util.ArrayList r5 = r4.getFlights()     // Catch:{ Exception -> 0x0744 }
        L_0x0212:
            r4 = 0
        L_0x0213:
            int r10 = r0.f24546f     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = " "
            if (r4 >= r10) goto L_0x0489
            java.lang.Object r10 = r5.get(r4)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r10 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r10     // Catch:{ Exception -> 0x0744 }
            boolean r12 = r0.I     // Catch:{ Exception -> 0x023d }
            if (r12 == 0) goto L_0x0230
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFulfillment r12 = r3.getFulfillment()     // Catch:{ Exception -> 0x023d }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFulfillmentResponse r12 = r12.getFulfillment_response()     // Catch:{ Exception -> 0x023d }
            java.lang.String r12 = r12.getOnward_pnr()     // Catch:{ Exception -> 0x023d }
            goto L_0x023e
        L_0x0230:
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFulfillment r12 = r3.getFulfillment()     // Catch:{ Exception -> 0x023d }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFulfillmentResponse r12 = r12.getFulfillment_response()     // Catch:{ Exception -> 0x023d }
            java.lang.String r12 = r12.getReturn_pnr()     // Catch:{ Exception -> 0x023d }
            goto L_0x023e
        L_0x023d:
            r12 = 0
        L_0x023e:
            java.util.List<android.view.ViewGroup> r13 = r0.G     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r13 = r13.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.view.View r13 = (android.view.View) r13     // Catch:{ Exception -> 0x0744 }
            boolean r14 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0744 }
            r15 = 8
            if (r14 != 0) goto L_0x0277
            java.lang.String[] r14 = r12.split(r11)     // Catch:{ Exception -> 0x0276 }
            int r2 = r14.length     // Catch:{ Exception -> 0x0276 }
            if (r2 <= r8) goto L_0x026c
            int r2 = com.travel.flight.R.id.pnr_text_layout     // Catch:{ Exception -> 0x0276 }
            android.view.View r2 = r13.findViewById(r2)     // Catch:{ Exception -> 0x0276 }
            r2.setVisibility(r9)     // Catch:{ Exception -> 0x0276 }
            int r2 = com.travel.flight.R.id.lbl_tkt_id     // Catch:{ Exception -> 0x0276 }
            android.view.View r2 = r13.findViewById(r2)     // Catch:{ Exception -> 0x0276 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0276 }
            r13 = r14[r4]     // Catch:{ Exception -> 0x0276 }
            r2.setText(r13)     // Catch:{ Exception -> 0x0276 }
            goto L_0x0277
        L_0x026c:
            int r2 = com.travel.flight.R.id.pnr_text_layout     // Catch:{ Exception -> 0x0276 }
            android.view.View r2 = r13.findViewById(r2)     // Catch:{ Exception -> 0x0276 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0276 }
            goto L_0x0277
        L_0x0276:
        L_0x0277:
            if (r4 != 0) goto L_0x0330
            boolean r2 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0744 }
            if (r2 != 0) goto L_0x02b3
            java.lang.String[] r2 = r12.split(r11)     // Catch:{ Exception -> 0x0744 }
            int r2 = r2.length     // Catch:{ Exception -> 0x0744 }
            if (r2 != r8) goto L_0x02a2
            android.widget.RelativeLayout r2 = r0.p     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r9)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.s     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            r2.setText(r12)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.s     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r9)     // Catch:{ Exception -> 0x0744 }
            goto L_0x02c3
        L_0x02a2:
            android.widget.RelativeLayout r2 = r0.p     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.s     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
            goto L_0x02c3
        L_0x02b3:
            android.widget.RelativeLayout r2 = r0.p     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.s     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
        L_0x02c3:
            java.util.List<android.widget.LinearLayout> r2 = r0.E     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
            int r2 = r5.size()     // Catch:{ Exception -> 0x0744 }
            if (r2 != r8) goto L_0x02fb
            java.util.List<android.widget.LinearLayout> r2 = r0.A     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r9)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.LinearLayout> r2 = r0.z     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.C     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r12 = r10.getDuration()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r12)     // Catch:{ Exception -> 0x0744 }
            goto L_0x0396
        L_0x02fb:
            java.util.List<android.widget.LinearLayout> r2 = r0.A     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.LinearLayout> r2 = r0.z     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r9)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.B     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r12 = r10.getDuration()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r12)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.ImageView> r2 = r0.D     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r12 = "clock.png"
            com.travel.utils.n$a r13 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x0744 }
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r2, r12, r9, r8, r13)     // Catch:{ Exception -> 0x0744 }
            goto L_0x0396
        L_0x0330:
            java.lang.String r2 = r10.getLayover()     // Catch:{ Exception -> 0x0744 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0744 }
            if (r2 != 0) goto L_0x0396
            java.util.List<android.widget.LinearLayout> r2 = r0.E     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r9)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.F     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0744 }
            java.lang.String r13 = "Layover: "
            r12.<init>(r13)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r13 = r10.getLayover()     // Catch:{ Exception -> 0x0744 }
            r12.append(r13)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r12)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.LinearLayout> r2 = r0.A     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r15)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.LinearLayout> r2 = r0.z     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x0744 }
            r2.setVisibility(r9)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.B     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r12 = r10.getDuration()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r12)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.ImageView> r2 = r0.D     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r12 = "clock.png"
            com.travel.utils.n$a r13 = com.travel.utils.n.a.V1     // Catch:{ Exception -> 0x0744 }
            com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r2, r12, r9, r8, r13)     // Catch:{ Exception -> 0x0744 }
        L_0x0396:
            java.util.List<android.widget.TextView> r2 = r0.q     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0744 }
            r12.<init>()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r13 = r10.getAirline()     // Catch:{ Exception -> 0x0744 }
            r12.append(r13)     // Catch:{ Exception -> 0x0744 }
            r12.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r13 = r10.getAirline_code()     // Catch:{ Exception -> 0x0744 }
            r12.append(r13)     // Catch:{ Exception -> 0x0744 }
            r12.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r10.getFlight_no()     // Catch:{ Exception -> 0x0744 }
            r12.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0744 }
            r2.<init>()     // Catch:{ Exception -> 0x0744 }
            com.travel.flight.b.a()     // Catch:{ Exception -> 0x0744 }
            com.travel.flight.c r11 = com.travel.flight.b.b()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r11.r()     // Catch:{ Exception -> 0x0744 }
            r2.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r10.getAirline_code()     // Catch:{ Exception -> 0x0744 }
            r2.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = ".png"
            r2.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.ImageView> r11 = r0.r     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r11 = r11.get(r4)     // Catch:{ Exception -> 0x0744 }
            if (r11 == 0) goto L_0x0413
            boolean r11 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0744 }
            if (r11 != 0) goto L_0x0413
            java.util.List<android.widget.ImageView> r11 = r0.r     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r11 = r11.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.ImageView r11 = (android.widget.ImageView) r11     // Catch:{ Exception -> 0x0744 }
            android.content.Context r11 = r11.getContext()     // Catch:{ Exception -> 0x0744 }
            com.paytm.utility.b.b$a$a r11 = com.paytm.utility.b.b.a(r11)     // Catch:{ Exception -> 0x0744 }
            r11.f43753a = r2     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.ImageView> r2 = r0.r     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.ImageView r2 = (android.widget.ImageView) r2     // Catch:{ Exception -> 0x0744 }
            r11.a((android.widget.ImageView) r2)     // Catch:{ Exception -> 0x0744 }
        L_0x0413:
            java.util.List<android.widget.TextView> r2 = r0.t     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r10.getDeparture_time_local()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = com.travel.flight.utils.c.c(r11)     // Catch:{ Exception -> 0x0744 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.u     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r10.getDeparture_time_local()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = com.travel.flight.utils.c.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0744 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.v     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r10.getArrival_time_local()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = com.travel.flight.utils.c.c(r11)     // Catch:{ Exception -> 0x0744 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.w     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r10.getArrival_time_local()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = com.travel.flight.utils.c.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0744 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.x     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r11 = r10.getOrigin()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r11 = r11.getAirport()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r11)     // Catch:{ Exception -> 0x0744 }
            java.util.List<android.widget.TextView> r2 = r0.y     // Catch:{ Exception -> 0x0744 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r10 = r10.getDestination()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r10 = r10.getAirport()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r10)     // Catch:{ Exception -> 0x0744 }
            int r4 = r4 + 1
            goto L_0x0213
        L_0x0489:
            com.travel.flight.flightorder.d.b$b r2 = com.travel.flight.flightorder.d.b.C0467b.PAYMENT_FAILED     // Catch:{ Exception -> 0x0744 }
            r4 = r17
            if (r4 == r2) goto L_0x0735
            android.widget.TextView r2 = new android.widget.TextView     // Catch:{ Exception -> 0x0744 }
            android.view.View r5 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0744 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0744 }
            android.view.View r5 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0744 }
            int r10 = com.travel.flight.R.color.color_222222     // Catch:{ Exception -> 0x0744 }
            int r5 = androidx.core.content.b.c(r5, r10)     // Catch:{ Exception -> 0x0744 }
            r2.setTextColor(r5)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r5 = "sans-serif-medium"
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r9)     // Catch:{ Exception -> 0x0744 }
            r2.setTypeface(r5)     // Catch:{ Exception -> 0x0744 }
            r5 = 1095761920(0x41500000, float:13.0)
            r2.setTextSize(r5)     // Catch:{ Exception -> 0x0744 }
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.END     // Catch:{ Exception -> 0x0744 }
            r2.setEllipsize(r10)     // Catch:{ Exception -> 0x0744 }
            r10 = 3
            r2.setGravity(r10)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout$LayoutParams r10 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0744 }
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = -2
            r14 = -1
            r10.<init>(r14, r13, r12)     // Catch:{ Exception -> 0x0744 }
            r12 = 10
            r15 = 15
            r10.setMargins(r9, r15, r12, r15)     // Catch:{ Exception -> 0x0744 }
            r2.setLayoutParams(r10)     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryPaxInfo r10 = r3.getPax_info()     // Catch:{ Exception -> 0x0744 }
            if (r10 == 0) goto L_0x04fe
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0744 }
            r12.<init>()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r14 = r10.getTitle()     // Catch:{ Exception -> 0x0744 }
            r12.append(r14)     // Catch:{ Exception -> 0x0744 }
            r12.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r14 = r10.getFirstname()     // Catch:{ Exception -> 0x0744 }
            r12.append(r14)     // Catch:{ Exception -> 0x0744 }
            r12.append(r11)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r10 = r10.getLastname()     // Catch:{ Exception -> 0x0744 }
            r12.append(r10)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r10 = r12.toString()     // Catch:{ Exception -> 0x0744 }
            goto L_0x04ff
        L_0x04fe:
            r10 = 0
        L_0x04ff:
            r2.setText(r10)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r10 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x0744 }
            android.view.View r11 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r11 = r11.getContext()     // Catch:{ Exception -> 0x0744 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0744 }
            r10.addView(r2)     // Catch:{ Exception -> 0x0744 }
            android.widget.TextView r2 = new android.widget.TextView     // Catch:{ Exception -> 0x0744 }
            android.view.View r11 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r11 = r11.getContext()     // Catch:{ Exception -> 0x0744 }
            r2.<init>(r11)     // Catch:{ Exception -> 0x0744 }
            r2.setTextSize(r5)     // Catch:{ Exception -> 0x0744 }
            android.text.TextUtils$TruncateAt r11 = android.text.TextUtils.TruncateAt.END     // Catch:{ Exception -> 0x0744 }
            r2.setEllipsize(r11)     // Catch:{ Exception -> 0x0744 }
            r11 = 17
            r2.setGravity(r11)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout$LayoutParams r12 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0744 }
            r14 = 0
            r12.<init>(r13, r13, r14)     // Catch:{ Exception -> 0x0744 }
            r14 = 10
            r12.setMargins(r14, r15, r9, r15)     // Catch:{ Exception -> 0x0744 }
            r2.setLayoutParams(r12)     // Catch:{ Exception -> 0x0744 }
            r12 = 12
            int r12 = com.paytm.utility.b.c((int) r12)     // Catch:{ Exception -> 0x0744 }
            int r14 = com.paytm.utility.b.c((int) r8)     // Catch:{ Exception -> 0x0744 }
            r15 = 12
            int r15 = com.paytm.utility.b.c((int) r15)     // Catch:{ Exception -> 0x0744 }
            r13 = 2
            int r5 = com.paytm.utility.b.c((int) r13)     // Catch:{ Exception -> 0x0744 }
            r2.setPadding(r12, r14, r15, r5)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r5 = "sans-serif"
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r5, r9)     // Catch:{ Exception -> 0x0744 }
            r2.setTypeface(r5)     // Catch:{ Exception -> 0x0744 }
            int r5 = r3.getStatus()     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.color_222222     // Catch:{ Exception -> 0x0744 }
            int[] r12 = com.travel.flight.flightorder.j.m.AnonymousClass2.f24552a     // Catch:{ Exception -> 0x0744 }
            int r14 = r17.ordinal()     // Catch:{ Exception -> 0x0744 }
            r12 = r12[r14]     // Catch:{ Exception -> 0x0744 }
            switch(r12) {
                case 1: goto L_0x0582;
                case 2: goto L_0x057d;
                case 3: goto L_0x0578;
                case 4: goto L_0x0573;
                case 5: goto L_0x056e;
                case 6: goto L_0x0569;
                default: goto L_0x0568;
            }     // Catch:{ Exception -> 0x0744 }
        L_0x0568:
            goto L_0x0586
        L_0x0569:
            int r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.event_sold_out_color     // Catch:{ Exception -> 0x0744 }
            goto L_0x0586
        L_0x056e:
            int r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.just_tickets_con_fee_desc     // Catch:{ Exception -> 0x0744 }
            goto L_0x0586
        L_0x0573:
            int r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.movie_pending_status_background     // Catch:{ Exception -> 0x0744 }
            goto L_0x0586
        L_0x0578:
            int r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.movie_pending_status_background     // Catch:{ Exception -> 0x0744 }
            goto L_0x0586
        L_0x057d:
            int r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.event_sold_out_color     // Catch:{ Exception -> 0x0744 }
            goto L_0x0586
        L_0x0582:
            int r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.just_tickets_con_fee_desc     // Catch:{ Exception -> 0x0744 }
        L_0x0586:
            int r12 = r3.getStatus()     // Catch:{ Exception -> 0x0744 }
            r14 = 18
            if (r12 == r11) goto L_0x0594
            int r12 = r3.getStatus()     // Catch:{ Exception -> 0x0744 }
            if (r12 != r14) goto L_0x0598
        L_0x0594:
            int r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            int r12 = com.travel.flight.R.color.event_sold_out_color     // Catch:{ Exception -> 0x0744 }
        L_0x0598:
            r12 = 7
            if (r5 != r12) goto L_0x059e
            int r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c0
        L_0x059e:
            r12 = 42
            if (r5 != r12) goto L_0x05a5
            int r12 = com.travel.flight.R.drawable.pre_f_flight_success_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c0
        L_0x05a5:
            if (r5 != r13) goto L_0x05aa
            int r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c0
        L_0x05aa:
            if (r5 != r14) goto L_0x05af
            int r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c0
        L_0x05af:
            if (r5 != r11) goto L_0x05b4
            int r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c0
        L_0x05b4:
            r12 = 6
            if (r5 != r12) goto L_0x05ba
            int r12 = com.travel.flight.R.drawable.pre_f_flight_failed_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c0
        L_0x05ba:
            if (r5 != r8) goto L_0x05bf
            int r12 = com.travel.flight.R.drawable.pre_f_flight_processing_order_summary_badge_border     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c0
        L_0x05bf:
            r12 = -1
        L_0x05c0:
            r15 = 7
            if (r5 != r15) goto L_0x05c7
            int r14 = com.travel.flight.R.color.just_tickets_con_fee_desc     // Catch:{ Exception -> 0x0744 }
        L_0x05c5:
            r5 = -1
            goto L_0x05ea
        L_0x05c7:
            r15 = 42
            if (r5 != r15) goto L_0x05ce
            int r14 = com.travel.flight.R.color.just_tickets_con_fee_desc     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c5
        L_0x05ce:
            if (r5 != r13) goto L_0x05d3
            int r14 = com.travel.flight.R.color.movie_pending_status_background     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c5
        L_0x05d3:
            if (r5 != r14) goto L_0x05d8
            int r14 = com.travel.flight.R.color.event_sold_out_color     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c5
        L_0x05d8:
            if (r5 != r11) goto L_0x05dd
            int r14 = com.travel.flight.R.color.order_failure_color     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c5
        L_0x05dd:
            r11 = 6
            if (r5 != r11) goto L_0x05e3
            int r14 = com.travel.flight.R.color.event_sold_out_color     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c5
        L_0x05e3:
            if (r5 != r8) goto L_0x05e8
            int r14 = com.travel.flight.R.color.movie_pending_status_background     // Catch:{ Exception -> 0x0744 }
            goto L_0x05c5
        L_0x05e8:
            r5 = -1
            r14 = -1
        L_0x05ea:
            if (r14 == r5) goto L_0x05fa
            android.view.View r5 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0744 }
            int r5 = androidx.core.content.b.c(r5, r14)     // Catch:{ Exception -> 0x0744 }
            r2.setTextColor(r5)     // Catch:{ Exception -> 0x0744 }
            r5 = -1
        L_0x05fa:
            if (r12 == r5) goto L_0x0609
            android.view.View r5 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0744 }
            android.graphics.drawable.Drawable r5 = androidx.core.content.b.a((android.content.Context) r5, (int) r12)     // Catch:{ Exception -> 0x0744 }
            r2.setBackground(r5)     // Catch:{ Exception -> 0x0744 }
        L_0x0609:
            java.lang.String r5 = r3.getStatus_text()     // Catch:{ Exception -> 0x0744 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0744 }
            if (r5 != 0) goto L_0x061d
            java.lang.String r5 = r3.getStatus_text()     // Catch:{ Exception -> 0x0744 }
            r2.setText(r5)     // Catch:{ Exception -> 0x0744 }
            r10.addView(r2)     // Catch:{ Exception -> 0x0744 }
        L_0x061d:
            android.widget.LinearLayout r2 = r0.H     // Catch:{ Exception -> 0x0744 }
            r2.addView(r10)     // Catch:{ Exception -> 0x0744 }
            android.widget.HorizontalScrollView r2 = new android.widget.HorizontalScrollView     // Catch:{ Exception -> 0x0744 }
            android.view.View r5 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0744 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r5 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x0744 }
            android.view.View r10 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r10 = r10.getContext()     // Catch:{ Exception -> 0x0744 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x0744 }
            r10 = 20
            if (r3 == 0) goto L_0x06e8
            java.util.ArrayList r11 = r3.getAction()     // Catch:{ Exception -> 0x0744 }
            if (r11 == 0) goto L_0x06e8
            java.util.ArrayList r3 = r3.getAction()     // Catch:{ Exception -> 0x0744 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0744 }
            r11 = 0
        L_0x064b:
            boolean r12 = r3.hasNext()     // Catch:{ Exception -> 0x0744 }
            if (r12 == 0) goto L_0x06e9
            java.lang.Object r12 = r3.next()     // Catch:{ Exception -> 0x0744 }
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction r12 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction) r12     // Catch:{ Exception -> 0x0744 }
            java.lang.Boolean r13 = r12.getOrderLevel()     // Catch:{ Exception -> 0x0744 }
            if (r13 != 0) goto L_0x065e
            r11 = 0
        L_0x065e:
            java.lang.String r13 = r12.getLabel()     // Catch:{ Exception -> 0x0744 }
            if (r13 == 0) goto L_0x0670
            java.lang.String r13 = r12.getLabel()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r14 = "Cancel"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0744 }
            if (r13 != 0) goto L_0x0682
        L_0x0670:
            java.lang.String r13 = r12.getLabel()     // Catch:{ Exception -> 0x0744 }
            if (r13 == 0) goto L_0x06e5
            java.lang.String r13 = r12.getLabel()     // Catch:{ Exception -> 0x0744 }
            java.lang.String r14 = "modify"
            boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0744 }
            if (r13 == 0) goto L_0x06e5
        L_0x0682:
            java.lang.Boolean r11 = r12.getOrderLevel()     // Catch:{ Exception -> 0x0744 }
            if (r11 != 0) goto L_0x068a
            r11 = 0
            goto L_0x0692
        L_0x068a:
            java.lang.Boolean r11 = r12.getOrderLevel()     // Catch:{ Exception -> 0x0744 }
            boolean r11 = r11.booleanValue()     // Catch:{ Exception -> 0x0744 }
        L_0x0692:
            android.widget.TextView r13 = new android.widget.TextView     // Catch:{ Exception -> 0x0744 }
            android.view.View r14 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r14 = r14.getContext()     // Catch:{ Exception -> 0x0744 }
            r13.<init>(r14)     // Catch:{ Exception -> 0x0744 }
            android.view.View r14 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r14 = r14.getContext()     // Catch:{ Exception -> 0x0744 }
            int r15 = com.travel.flight.R.color.color_222222     // Catch:{ Exception -> 0x0744 }
            int r14 = androidx.core.content.b.c(r14, r15)     // Catch:{ Exception -> 0x0744 }
            r13.setTextColor(r14)     // Catch:{ Exception -> 0x0744 }
            r14 = 1095761920(0x41500000, float:13.0)
            r13.setTextSize(r14)     // Catch:{ Exception -> 0x0744 }
            r15 = 3
            r13.setGravity(r15)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout$LayoutParams r15 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0744 }
            r8 = -1
            r14 = -2
            r15.<init>(r8, r14)     // Catch:{ Exception -> 0x0744 }
            android.view.View r8 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r8 = r8.getContext()     // Catch:{ Exception -> 0x0744 }
            int r14 = com.travel.flight.R.color.color_33b5e5     // Catch:{ Exception -> 0x0744 }
            int r8 = androidx.core.content.b.c(r8, r14)     // Catch:{ Exception -> 0x0744 }
            r13.setTextColor(r8)     // Catch:{ Exception -> 0x0744 }
            r8 = 50
            r15.setMargins(r9, r10, r8, r10)     // Catch:{ Exception -> 0x0744 }
            r13.setLayoutParams(r15)     // Catch:{ Exception -> 0x0744 }
            java.lang.String r8 = r12.getLabel()     // Catch:{ Exception -> 0x0744 }
            r13.setText(r8)     // Catch:{ Exception -> 0x0744 }
            com.travel.flight.flightorder.j.m$1 r8 = new com.travel.flight.flightorder.j.m$1     // Catch:{ Exception -> 0x0744 }
            r8.<init>(r12)     // Catch:{ Exception -> 0x0744 }
            r13.setOnClickListener(r8)     // Catch:{ Exception -> 0x0744 }
            r5.addView(r13)     // Catch:{ Exception -> 0x0744 }
        L_0x06e5:
            r8 = 1
            goto L_0x064b
        L_0x06e8:
            r11 = 0
        L_0x06e9:
            if (r11 != 0) goto L_0x06f3
            r2.addView(r5)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r3 = r0.H     // Catch:{ Exception -> 0x0744 }
            r3.addView(r2)     // Catch:{ Exception -> 0x0744 }
        L_0x06f3:
            int r2 = r0.f24545e     // Catch:{ Exception -> 0x0744 }
            r3 = 1
            int r2 = r2 - r3
            if (r1 == r2) goto L_0x073e
            int r2 = r0.f24548h     // Catch:{ Exception -> 0x0744 }
            int r5 = r0.f24547g     // Catch:{ Exception -> 0x0744 }
            int r5 = r5 - r3
            if (r2 >= r5) goto L_0x073e
            int r2 = r0.f24548h     // Catch:{ Exception -> 0x0744 }
            int r2 = r2 + r3
            r0.f24548h = r2     // Catch:{ Exception -> 0x0744 }
            android.view.View r2 = new android.view.View     // Catch:{ Exception -> 0x0744 }
            android.view.View r3 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0744 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x0744 }
            r5 = -2
            r8 = -1
            r3.<init>(r8, r5)     // Catch:{ Exception -> 0x0744 }
            r5 = 1
            r3.height = r5     // Catch:{ Exception -> 0x0744 }
            r3.setMargins(r9, r10, r10, r9)     // Catch:{ Exception -> 0x0744 }
            android.view.View r8 = r0.itemView     // Catch:{ Exception -> 0x0744 }
            android.content.Context r8 = r8.getContext()     // Catch:{ Exception -> 0x0744 }
            int r10 = com.travel.flight.R.color.color_efefef     // Catch:{ Exception -> 0x0744 }
            int r8 = androidx.core.content.b.c(r8, r10)     // Catch:{ Exception -> 0x0744 }
            r2.setBackgroundColor(r8)     // Catch:{ Exception -> 0x0744 }
            r2.setLayoutParams(r3)     // Catch:{ Exception -> 0x0744 }
            android.widget.LinearLayout r3 = r0.H     // Catch:{ Exception -> 0x0744 }
            r3.addView(r2)     // Catch:{ Exception -> 0x0744 }
            goto L_0x073f
        L_0x0735:
            r5 = 1
            android.widget.LinearLayout r2 = r0.H     // Catch:{ Exception -> 0x0744 }
            r2.removeAllViews()     // Catch:{ Exception -> 0x0744 }
            goto L_0x073f
        L_0x073c:
            r4 = r17
        L_0x073e:
            r5 = 1
        L_0x073f:
            int r1 = r1 + 1
            r8 = 1
            goto L_0x0171
        L_0x0744:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.j.m.a(com.travel.flight.flightorder.d.b$b):void");
    }

    public final void a(String str) {
        if (URLUtil.isValidUrl(str)) {
            b.a.C0750a a2 = b.a(this.f24549i.getContext());
            a2.f43753a = str;
            a2.m = true;
            b.a.C0750a.a(a2, this.f24549i, (com.paytm.utility.b.b.b) null, 2);
        }
    }
}
