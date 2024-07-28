package com.travel.flight.flightorder.j;

import android.content.Context;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.flightorder.activity.FlightOrderSummary;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin;

public final class d extends a implements View.OnClickListener {
    private String A;
    private String B;
    private String C;
    private String D;

    /* renamed from: a  reason: collision with root package name */
    CJROrderSummaryOrigin f24465a = null;

    /* renamed from: b  reason: collision with root package name */
    CJROrderSummaryDestination f24466b = null;

    /* renamed from: c  reason: collision with root package name */
    FlightOrderSummary.a f24467c;

    /* renamed from: d  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24468d;

    /* renamed from: e  reason: collision with root package name */
    private com.travel.flight.flightorder.g.a f24469e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f24470f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f24471g;

    /* renamed from: h  reason: collision with root package name */
    private Context f24472h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f24473i;
    private ImageView j;
    /* access modifiers changed from: private */
    public ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private boolean t = false;
    private boolean u = false;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public d(View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, com.travel.flight.flightorder.g.a aVar, FlightOrderSummary.a aVar2) {
        super(view);
        this.f24467c = aVar2;
        this.r = (TextView) view.findViewById(R.id.retry);
        this.s = (TextView) view.findViewById(R.id.retry1);
        this.f24473i = (LinearLayout) view.findViewById(R.id.processing_root_layout);
        this.v = (TextView) view.findViewById(R.id.from_payment_header);
        this.w = (TextView) view.findViewById(R.id.from_payment_description);
        this.j = (ImageView) view.findViewById(R.id.order_state_imageview_1);
        this.k = (ImageView) view.findViewById(R.id.order_state_imageview_2);
        this.l = (ImageView) view.findViewById(R.id.order_state_imageview_3);
        this.o = (TextView) view.findViewById(R.id.order_state_textview_1);
        this.p = (TextView) view.findViewById(R.id.order_state_textview_2);
        this.q = (TextView) view.findViewById(R.id.order_state_textview_3);
        this.m = (ImageView) view.findViewById(R.id.order_state_indicator_image1);
        this.n = (ImageView) view.findViewById(R.id.order_state_indicator_image2);
        this.x = (TextView) view.findViewById(R.id.from_history_status);
        this.z = (TextView) view.findViewById(R.id.from_history_header);
        this.f24470f = (LinearLayout) view.findViewById(R.id.order_header_from_history);
        this.y = (TextView) view.findViewById(R.id.from_history_description);
        this.f24471g = (ImageView) view.findViewById(R.id.status_image_view);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.f24468d = cJRFlightOrderSummaryResponse;
        this.f24469e = aVar;
        this.f24472h = this.f24469e.b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.flight.flightorder.d.b.C0467b r19) {
        /*
            r18 = this;
            r0 = r18
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0383
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            if (r1 == 0) goto L_0x0383
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            java.util.List r1 = r1.getStatusLabelCard()
            if (r1 == 0) goto L_0x0383
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            java.util.List r1 = r1.getStatusLabelCard()
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r4 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r4 = r4.getBody()
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBookingCard r4 = r4.getBookingCard()
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r5 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r5 = r5.getBody()
            net.one97.paytmflight.common.entity.flightticket.OrderSummaryRefundCard r5 = r5.getRefund_card()
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0050
            r0.t = r2
            java.lang.String r7 = r5.getMessage()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0050
            java.lang.String r5 = r5.getMessage()
            goto L_0x0051
        L_0x0050:
            r5 = r6
        L_0x0051:
            if (r4 == 0) goto L_0x0072
            java.lang.String r7 = r4.getHeader()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0062
            java.lang.String r7 = r4.getHeader()
            goto L_0x0063
        L_0x0062:
            r7 = r6
        L_0x0063:
            java.lang.String r8 = r4.getMessage()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0073
            java.lang.String r6 = r4.getMessage()
            goto L_0x0073
        L_0x0072:
            r7 = r6
        L_0x0073:
            int r4 = r1.size()
            r8 = 8
            if (r4 != 0) goto L_0x00b6
            android.widget.LinearLayout r1 = r0.f24473i
            r1.setVisibility(r8)
            android.widget.LinearLayout r1 = r0.f24470f
            r1.setVisibility(r8)
            android.widget.TextView r1 = r0.x
            r1.setVisibility(r8)
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r8)
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r8)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L_0x00a4
            android.widget.TextView r1 = r0.z
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.z
            r1.setText(r7)
        L_0x00a4:
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x0383
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.w
            r1.setText(r6)
            goto L_0x0383
        L_0x00b6:
            int r4 = r1.size()
            r9 = 3
            java.lang.String r10 = "7"
            if (r4 != r9) goto L_0x0292
            android.widget.LinearLayout r4 = r0.f24473i
            r4.setVisibility(r3)
            android.widget.LinearLayout r4 = r0.f24470f
            r4.setVisibility(r8)
            java.lang.Object r4 = r1.get(r3)
            if (r4 == 0) goto L_0x0105
            java.lang.Object r4 = r1.get(r3)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getLebel()
            if (r4 == 0) goto L_0x0105
            android.widget.TextView r4 = r0.o
            java.lang.Object r9 = r1.get(r3)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r9 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r9
            java.lang.String r9 = r9.getLebel()
            r4.setText(r9)
            java.lang.Object r4 = r1.get(r3)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getIcon()
            if (r4 == 0) goto L_0x0105
            java.lang.Object r4 = r1.get(r3)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getIcon()
            android.widget.ImageView r9 = r0.j
            r0.a(r4, r9)
        L_0x0105:
            java.lang.Object r4 = r1.get(r2)
            if (r4 == 0) goto L_0x018a
            java.lang.Object r4 = r1.get(r2)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getLebel()
            if (r4 == 0) goto L_0x018a
            android.widget.TextView r4 = r0.p
            java.lang.Object r9 = r1.get(r2)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r9 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r9
            java.lang.String r9 = r9.getLebel()
            r4.setText(r9)
            java.lang.Object r4 = r1.get(r2)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getIcon()
            if (r4 == 0) goto L_0x016f
            java.lang.Object r4 = r1.get(r2)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getIcon()
            android.widget.ImageView r9 = r0.k
            r0.a(r4, r9)
            java.lang.Object r4 = r1.get(r2)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.Boolean r4 = r4.getAnim()
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x016f
            com.travel.flight.flightorder.g.a r4 = r0.f24469e
            if (r4 == 0) goto L_0x016f
            java.util.concurrent.ScheduledExecutorService r4 = r4.a()
            if (r4 == 0) goto L_0x016f
            com.travel.flight.flightorder.g.a r4 = r0.f24469e
            java.util.concurrent.ScheduledExecutorService r11 = r4.a()
            com.travel.flight.flightorder.j.d$1 r12 = new com.travel.flight.flightorder.j.d$1
            r12.<init>()
            r13 = 100
            r15 = 100
            java.util.concurrent.TimeUnit r17 = java.util.concurrent.TimeUnit.MILLISECONDS
            r11.scheduleAtFixedRate(r12, r13, r15, r17)
        L_0x016f:
            java.lang.Object r4 = r1.get(r2)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getTransitionimage()
            if (r4 == 0) goto L_0x018a
            java.lang.Object r4 = r1.get(r2)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getTransitionimage()
            android.widget.ImageView r9 = r0.m
            r0.a(r4, r9)
        L_0x018a:
            r4 = 2
            java.lang.Object r9 = r1.get(r4)
            if (r9 == 0) goto L_0x01e2
            java.lang.Object r9 = r1.get(r4)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r9 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r9
            java.lang.String r9 = r9.getLebel()
            if (r9 == 0) goto L_0x01e2
            android.widget.TextView r9 = r0.q
            java.lang.Object r11 = r1.get(r4)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r11 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r11
            java.lang.String r11 = r11.getLebel()
            r9.setText(r11)
            java.lang.Object r9 = r1.get(r4)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r9 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r9
            java.lang.String r9 = r9.getIcon()
            if (r9 == 0) goto L_0x01c7
            java.lang.Object r9 = r1.get(r4)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r9 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r9
            java.lang.String r9 = r9.getIcon()
            android.widget.ImageView r11 = r0.l
            r0.a(r9, r11)
        L_0x01c7:
            java.lang.Object r9 = r1.get(r4)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r9 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r9
            java.lang.String r9 = r9.getTransitionimage()
            if (r9 == 0) goto L_0x01e2
            java.lang.Object r1 = r1.get(r4)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r1 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r1
            java.lang.String r1 = r1.getTransitionimage()
            android.widget.ImageView r4 = r0.n
            r0.a(r1, r4)
        L_0x01e2:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            java.lang.String r1 = r1.getOrder_status()
            boolean r1 = r1.equalsIgnoreCase(r10)
            if (r1 == 0) goto L_0x0254
            android.widget.TextView r1 = r0.x
            r1.setVisibility(r8)
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r8)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x020d
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.v
            r1.setText(r6)
            goto L_0x0212
        L_0x020d:
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r8)
        L_0x0212:
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L_0x0223
            android.widget.TextView r1 = r0.z
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.z
            r1.setText(r7)
            goto L_0x0228
        L_0x0223:
            android.widget.TextView r1 = r0.z
            r1.setVisibility(r8)
        L_0x0228:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x024d
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            com.travel.flight.pojo.FlightBookingRefundDetails r1 = r1.getRefundDetails()
            if (r1 != 0) goto L_0x0246
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.w
            r1.setText(r5)
            goto L_0x0383
        L_0x0246:
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r8)
            goto L_0x0383
        L_0x024d:
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r8)
            goto L_0x0383
        L_0x0254:
            android.widget.TextView r1 = r0.x
            r1.setVisibility(r8)
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r8)
            android.widget.TextView r1 = r0.z
            r1.setVisibility(r8)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L_0x0274
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.v
            r1.setText(r7)
            goto L_0x0279
        L_0x0274:
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r8)
        L_0x0279:
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x028b
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.w
            r1.setText(r6)
            goto L_0x0383
        L_0x028b:
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r8)
            goto L_0x0383
        L_0x0292:
            android.widget.LinearLayout r4 = r0.f24473i
            r4.setVisibility(r8)
            android.widget.LinearLayout r4 = r0.f24470f
            r4.setVisibility(r3)
            android.widget.TextView r4 = r0.z
            r4.setVisibility(r8)
            android.widget.TextView r4 = r0.w
            r4.setVisibility(r8)
            java.lang.Object r4 = r1.get(r3)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r4 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r4
            java.lang.String r4 = r4.getIcon()
            android.widget.ImageView r9 = r0.f24471g
            r0.a(r4, r9)
            boolean r4 = android.text.TextUtils.isEmpty(r7)
            if (r4 != 0) goto L_0x02c6
            android.widget.TextView r4 = r0.x
            r4.setVisibility(r3)
            android.widget.TextView r4 = r0.x
            r4.setText(r7)
            goto L_0x02cb
        L_0x02c6:
            android.widget.TextView r4 = r0.x
            r4.setVisibility(r8)
        L_0x02cb:
            java.lang.Object r4 = r1.get(r3)
            if (r4 == 0) goto L_0x0383
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem r1 = (net.one97.paytmflight.common.entity.flightticket.CJRStatusLevelCardItem) r1
            java.lang.String r1 = r1.getIcon()
            if (r1 == 0) goto L_0x0383
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            java.lang.String r1 = r1.getOrder_status()
            boolean r1 = r1.equalsIgnoreCase(r10)
            if (r1 == 0) goto L_0x0340
            boolean r1 = r0.t
            if (r1 == 0) goto L_0x0324
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x0302
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.v
            r1.setText(r6)
            goto L_0x0307
        L_0x0302:
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r8)
        L_0x0307:
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            com.travel.flight.pojo.FlightBookingRefundDetails r1 = r1.getRefundDetails()
            if (r1 != 0) goto L_0x031e
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.y
            r1.setText(r5)
            goto L_0x0383
        L_0x031e:
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r8)
            goto L_0x0383
        L_0x0324:
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r8)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x033a
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.y
            r1.setText(r6)
            goto L_0x0383
        L_0x033a:
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r8)
            goto L_0x0383
        L_0x0340:
            android.widget.TextView r1 = r0.v
            r1.setVisibility(r8)
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x0356
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.y
            r1.setText(r6)
            goto L_0x035b
        L_0x0356:
            android.widget.TextView r1 = r0.y
            r1.setVisibility(r8)
        L_0x035b:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x037e
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r1 = r0.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r1 = r1.getBody()
            com.travel.flight.pojo.FlightBookingRefundDetails r1 = r1.getRefundDetails()
            if (r1 != 0) goto L_0x0378
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.w
            r1.setText(r5)
            goto L_0x0383
        L_0x0378:
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r8)
            goto L_0x0383
        L_0x037e:
            android.widget.TextView r1 = r0.w
            r1.setVisibility(r8)
        L_0x0383:
            int[] r1 = com.travel.flight.flightorder.j.d.AnonymousClass2.f24476a     // Catch:{ Exception -> 0x0393 }
            int r4 = r19.ordinal()     // Catch:{ Exception -> 0x0393 }
            r1 = r1[r4]     // Catch:{ Exception -> 0x0393 }
            if (r1 == r2) goto L_0x038e
            goto L_0x0393
        L_0x038e:
            android.widget.TextView r1 = r0.r     // Catch:{ Exception -> 0x0393 }
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0393 }
        L_0x0393:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.j.d.a(com.travel.flight.flightorder.d.b$b):void");
    }

    /* renamed from: com.travel.flight.flightorder.j.d$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24476a = new int[b.C0467b.values().length];

        static {
            try {
                f24476a[b.C0467b.PAYMENT_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void a(String str, ImageView imageView) {
        try {
            if (URLUtil.isValidUrl(str)) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f24472h);
                a2.f43753a = str;
                b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0114  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r7) {
        /*
            r6 = this;
            int r7 = r7.getId()
            int r0 = com.travel.flight.R.id.retry1
            if (r7 == r0) goto L_0x000c
            int r0 = com.travel.flight.R.id.retry
            if (r7 != r0) goto L_0x01ff
        L_0x000c:
            com.travel.flight.flightorder.activity.FlightOrderSummary$a r7 = r6.f24467c
            com.travel.flight.flightorder.activity.FlightOrderSummary$a r0 = com.travel.flight.flightorder.activity.FlightOrderSummary.a.FLIGHT
            if (r7 != r0) goto L_0x01ff
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r7 = r6.f24468d
            if (r7 == 0) goto L_0x01ff
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r7 = r7.getBody()
            java.util.ArrayList r7 = r7.getItems()
            if (r7 == 0) goto L_0x01ff
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r7 = r6.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r7 = r7.getBody()
            java.util.ArrayList r7 = r7.getItems()
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x01ff
            com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse r7 = r6.f24468d
            net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody r7 = r7.getBody()
            java.util.ArrayList r7 = r7.getItems()
            java.util.Iterator r7 = r7.iterator()
        L_0x003e:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0149
            java.lang.Object r0 = r7.next()
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems r0 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems) r0
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r1 = r6.f24465a
            if (r1 == 0) goto L_0x0052
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r1 = r6.f24466b
            if (r1 != 0) goto L_0x003e
        L_0x0052:
            r1 = 0
            java.lang.String r2 = "OR"
            r3 = 0
            if (r0 == 0) goto L_0x00ad
            java.lang.String r4 = r0.getF_Dir()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x00ad
            java.lang.String r5 = "O"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 != 0) goto L_0x0070
            boolean r4 = r4.equalsIgnoreCase(r2)
            if (r4 == 0) goto L_0x00ad
        L_0x0070:
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r4 = r0.getJourney_details()
            if (r4 == 0) goto L_0x00ad
            java.util.ArrayList r5 = r4.getFlights()
            if (r5 == 0) goto L_0x00ad
            java.util.ArrayList r5 = r4.getFlights()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00ad
            java.util.ArrayList r3 = r4.getFlights()
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r3
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r3 = r3.getOrigin()
            java.util.ArrayList r5 = r4.getFlights()
            java.util.ArrayList r4 = r4.getFlights()
            int r4 = r4.size()
            int r4 = r4 + -1
            java.lang.Object r4 = r5.get(r4)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r4 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r4
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r4 = r4.getDestination()
            goto L_0x00ae
        L_0x00ad:
            r4 = r3
        L_0x00ae:
            android.util.Pair r5 = new android.util.Pair
            r5.<init>(r3, r4)
            java.lang.Object r3 = r5.first
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin) r3
            r6.f24465a = r3
            java.lang.Object r3 = r5.second
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r3 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination) r3
            r6.f24466b = r3
            if (r0 == 0) goto L_0x00cd
            java.lang.String r3 = r0.getBooking_class()
            if (r3 == 0) goto L_0x00cd
            java.lang.String r3 = r0.getBooking_class()
            r6.A = r3
        L_0x00cd:
            if (r0 == 0) goto L_0x003e
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r3 = r0.getJourney_details()
            if (r3 == 0) goto L_0x003e
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryJourneyDetails r3 = r0.getJourney_details()
            if (r3 == 0) goto L_0x003e
            java.util.ArrayList r4 = r3.getFlights()
            if (r4 == 0) goto L_0x003e
            java.util.ArrayList r3 = r3.getFlights()
            java.lang.String r0 = r0.getF_Dir()
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r5 = "round_trip"
            if (r4 != 0) goto L_0x0102
            java.lang.String r4 = "R"
            boolean r4 = r0.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x00ff
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0102
        L_0x00ff:
            r6.B = r5
            goto L_0x0106
        L_0x0102:
            java.lang.String r0 = "one_way"
            r6.B = r0
        L_0x0106:
            if (r3 == 0) goto L_0x003e
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x003e
        L_0x010e:
            int r0 = r3.size()
            if (r1 >= r0) goto L_0x003e
            java.lang.Object r0 = r3.get(r1)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights r0 = (net.one97.paytm.common.entity.flightticket.CJROrderSummaryFlights) r0
            if (r0 == 0) goto L_0x012c
            java.lang.String r2 = r0.getDeparture_time_local()
            if (r2 == 0) goto L_0x012c
            java.lang.String r2 = r0.getDeparture_time_local()
            java.lang.String r2 = com.travel.flight.utils.c.c(r2)
            r6.C = r2
        L_0x012c:
            if (r0 == 0) goto L_0x0146
            java.lang.String r2 = r0.getArrival_time_local()
            if (r2 == 0) goto L_0x0146
            java.lang.String r2 = r6.B
            boolean r2 = r5.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0146
            java.lang.String r0 = r0.getArrival_time_local()
            java.lang.String r0 = com.travel.flight.utils.c.c(r0)
            r6.D = r0
        L_0x0146:
            int r1 = r1 + 1
            goto L_0x010e
        L_0x0149:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r7 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r7.<init>()
            java.lang.String r0 = "flightticket"
            r7.setUrlType(r0)
            java.lang.String r0 = "paytmmp://flightticket"
            r7.setUrl(r0)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r0 = r6.f24465a
            if (r0 == 0) goto L_0x017c
            java.lang.String r0 = r0.getCity()
            if (r0 == 0) goto L_0x016b
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r0 = r6.f24465a
            java.lang.String r0 = r0.getCity()
            r7.setPushSourceCityName(r0)
        L_0x016b:
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r0 = r6.f24465a
            java.lang.String r0 = r0.getIata()
            if (r0 == 0) goto L_0x017c
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r0 = r6.f24465a
            java.lang.String r0 = r0.getIata()
            r7.setPushSourceCityShortName(r0)
        L_0x017c:
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r0 = r6.f24466b
            if (r0 == 0) goto L_0x01a0
            java.lang.String r0 = r0.getCity()
            if (r0 == 0) goto L_0x018f
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r0 = r6.f24466b
            java.lang.String r0 = r0.getCity()
            r7.setPushDestinationCityName(r0)
        L_0x018f:
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r0 = r6.f24466b
            java.lang.String r0 = r0.getIata()
            if (r0 == 0) goto L_0x01a0
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r0 = r6.f24466b
            java.lang.String r0 = r0.getIata()
            r7.setPushDestinationCityShortName(r0)
        L_0x01a0:
            java.lang.String r0 = r6.A
            if (r0 == 0) goto L_0x01a7
            r7.setPushFlightClass(r0)
        L_0x01a7:
            java.lang.String r0 = r6.B
            if (r0 == 0) goto L_0x01ae
            r7.setPushFlightTripType(r0)
        L_0x01ae:
            java.lang.String r0 = r6.C
            java.lang.String r1 = "dd MMM yy"
            java.lang.String r2 = "E, dd MMM yy"
            if (r0 == 0) goto L_0x01bc
            java.lang.String r0 = com.paytm.utility.b.f(r0, r2, r1)
            r6.C = r0
        L_0x01bc:
            java.lang.String r0 = r6.D
            if (r0 == 0) goto L_0x01c7
            java.lang.String r0 = com.paytm.utility.b.f(r0, r2, r1)
            r7.setPushFlightReturnDate(r0)
        L_0x01c7:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "paytmmp://flightticket?url=paytm.com/flight-ticke&source_city_name="
            r7.<init>(r0)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryOrigin r0 = r6.f24465a
            java.lang.String r0 = r0.getCity()
            r7.append(r0)
            java.lang.String r0 = "&destination_city_name="
            r7.append(r0)
            net.one97.paytm.common.entity.flightticket.CJROrderSummaryDestination r0 = r6.f24466b
            java.lang.String r0 = r0.getCity()
            r7.append(r0)
            java.lang.String r0 = "&flight_depart_date="
            r7.append(r0)
            java.lang.String r0 = r6.C
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.travel.flight.b.a()
            com.travel.flight.c r0 = com.travel.flight.b.b()
            android.content.Context r1 = r6.f24472h
            r0.a((android.content.Context) r1, (java.lang.String) r7)
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.j.d.onClick(android.view.View):void");
    }
}
