package net.one97.paytm.recharge.metro.activity;

import android.content.Intent;
import android.view.View;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.c.d;
import net.one97.paytm.recharge.metro.c.e;

public final class AJRActiveMetroPassActivity extends CJRBaseMetroActivity implements View.OnClickListener, e.a {

    /* renamed from: a  reason: collision with root package name */
    private CJRUtilityVariantV2 f63193a;

    /* renamed from: b  reason: collision with root package name */
    private CJROrderSummaryProductDetail f63194b;

    /* renamed from: c  reason: collision with root package name */
    private CJRActiveMetroTicketModel f63195c;

    /* renamed from: d  reason: collision with root package name */
    private List<? extends CJRActiveMetroTicketModel> f63196d;

    /* renamed from: e  reason: collision with root package name */
    private e f63197e;

    /* renamed from: g  reason: collision with root package name */
    private d f63198g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f63199h;

    /* renamed from: i  reason: collision with root package name */
    private String f63200i;
    private String j = "";
    private HashMap k;

    public final View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            android.view.LayoutInflater r9 = r8.getLayoutInflater()
            int r0 = net.one97.paytm.recharge.R.layout.content_metro_active_pass
            android.widget.FrameLayout r1 = r8.c()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r2 = 1
            r9.inflate(r0, r1, r2)
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "operator_variant"
            java.io.Serializable r9 = r9.getSerializableExtra(r0)
            boolean r0 = r9 instanceof net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2
            r1 = 0
            if (r0 != 0) goto L_0x0023
            r9 = r1
        L_0x0023:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r9 = (net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2) r9
            r8.f63193a = r9
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "activeMetroPasses"
            java.io.Serializable r9 = r9.getSerializableExtra(r0)
            if (r9 == 0) goto L_0x02fe
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r9
            r8.f63195c = r9
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "activeMetroTickets"
            java.io.Serializable r9 = r9.getSerializableExtra(r0)
            if (r9 == 0) goto L_0x004c
            android.content.Intent r9 = r8.getIntent()
            java.io.Serializable r9 = r9.getSerializableExtra(r0)
            goto L_0x004d
        L_0x004c:
            r9 = r1
        L_0x004d:
            if (r9 == 0) goto L_0x0060
            boolean r0 = r9 instanceof java.util.List
            if (r0 == 0) goto L_0x0058
            java.util.List r9 = (java.util.List) r9
            r8.f63196d = r9
            goto L_0x0060
        L_0x0058:
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r9
            java.util.List r9 = kotlin.a.k.a(r9)
            r8.f63196d = r9
        L_0x0060:
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "recharge_product"
            java.io.Serializable r9 = r9.getSerializableExtra(r0)
            boolean r0 = r9 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail
            if (r0 != 0) goto L_0x006f
            r9 = r1
        L_0x006f:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r9 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail) r9
            r8.f63194b = r9
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r9 = r8.f63193a
            if (r9 == 0) goto L_0x0083
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r9 = r9.getAttributes()
            if (r9 == 0) goto L_0x0083
            java.lang.String r9 = r9.getConfig_ticket_type()
            if (r9 != 0) goto L_0x008d
        L_0x0083:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r9 = r8.f63193a
            if (r9 == 0) goto L_0x008c
            java.lang.String r9 = r9.getDisplayName()
            goto L_0x008d
        L_0x008c:
            r9 = r1
        L_0x008d:
            if (r9 != 0) goto L_0x009f
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r9 = r8.f63194b
            if (r9 == 0) goto L_0x009e
            net.one97.paytm.common.entity.recharge.CJRAttributes r9 = r9.getAttributes()
            if (r9 == 0) goto L_0x009e
            java.lang.String r9 = r9.getPayTypeDisplayLabel()
            goto L_0x009f
        L_0x009e:
            r9 = r1
        L_0x009f:
            r8.f63200i = r9
            androidx.appcompat.app.ActionBar r9 = r8.getSupportActionBar()
            if (r9 == 0) goto L_0x00ae
            java.lang.String r0 = r8.f63200i
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.a((java.lang.CharSequence) r0)
        L_0x00ae:
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "vertical_name"
            java.lang.String r9 = r9.getStringExtra(r0)
            java.lang.String r0 = "intent.getStringExtra(CJ…TENT_EXTRA_VERTICAL_NAME)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r8.j = r9
            int r9 = net.one97.paytm.recharge.R.id.txt_heading
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r0 = net.one97.paytm.recharge.R.id.txt_available_balance
            android.view.View r0 = r8.findViewById(r0)
            net.one97.paytm.recharge.common.widget.CJRAmountView r0 = (net.one97.paytm.recharge.common.widget.CJRAmountView) r0
            int r3 = net.one97.paytm.recharge.R.id.generate_divider
            android.view.View r3 = r8.findViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            net.one97.paytm.recharge.metro.f.c$d r4 = net.one97.paytm.recharge.metro.f.c.d.MUMBAI_METRO_SVP
            int r4 = r4.getValue()
            net.one97.paytm.recharge.metro.f.c$d$a r5 = net.one97.paytm.recharge.metro.f.c.d.Companion
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = r8.f63195c
            if (r5 == 0) goto L_0x00e8
            java.lang.String r5 = r5.getProductType()
            goto L_0x00e9
        L_0x00e8:
            r5 = r1
        L_0x00e9:
            int r5 = net.one97.paytm.recharge.metro.f.c.d.a.a((java.lang.String) r5)
            java.lang.String r6 = "txtHeading"
            r7 = 0
            if (r4 != r5) goto L_0x0111
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            int r4 = net.one97.paytm.recharge.R.string.metro_pass_available_balance
            java.lang.String r4 = r8.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r9.setText(r4)
            r0.a((boolean) r2)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = r8.f63195c
            if (r9 == 0) goto L_0x010c
            java.lang.String r9 = r9.getBalanceAmount()
            goto L_0x010d
        L_0x010c:
            r9 = r1
        L_0x010d:
            r0.setText(r9)
            goto L_0x017e
        L_0x0111:
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            int r4 = net.one97.paytm.recharge.R.string.metro_pass_remaining
            java.lang.String r4 = r8.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r9.setText(r4)
            r0.a((boolean) r7)
            r0.a()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = r8.f63195c
            if (r9 == 0) goto L_0x0132
            int r9 = r9.getBalanceTrip_2()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            goto L_0x0133
        L_0x0132:
            r9 = r1
        L_0x0133:
            r0.setText(r9)
            int r9 = net.one97.paytm.recharge.R.id.tv_metro_station
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r0 = "(findViewById<LinearLayo…>(R.id.tv_metro_station))"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r9.setVisibility(r7)
            int r9 = net.one97.paytm.recharge.R.id.source
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r0 = "(findViewById<TextView>(R.id.source))"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.widget.TextView r9 = (android.widget.TextView) r9
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r0 = r8.f63195c
            if (r0 == 0) goto L_0x015c
            java.lang.String r0 = r0.getSource()
            goto L_0x015d
        L_0x015c:
            r0 = r1
        L_0x015d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            int r9 = net.one97.paytm.recharge.R.id.destination
            android.view.View r9 = r8.findViewById(r9)
            java.lang.String r0 = "(findViewById<TextView>(R.id.destination))"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            android.widget.TextView r9 = (android.widget.TextView) r9
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r0 = r8.f63195c
            if (r0 == 0) goto L_0x0178
            java.lang.String r0 = r0.getDestination()
            goto L_0x0179
        L_0x0178:
            r0 = r1
        L_0x0179:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        L_0x017e:
            int r9 = net.one97.paytm.recharge.R.id.txt_validity
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r0 = r8.f63195c
            if (r0 == 0) goto L_0x018f
            java.lang.String r0 = r0.getExpiryTime()
            goto L_0x0190
        L_0x018f:
            r0 = r1
        L_0x0190:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            int r9 = net.one97.paytm.recharge.R.id.txt_reference_id
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_reference_id
            java.lang.Object[] r4 = new java.lang.Object[r2]
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = r8.f63195c
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x01ad
            java.lang.String r5 = r5.getPassId()
            if (r5 != 0) goto L_0x01ae
        L_0x01ad:
            r5 = r6
        L_0x01ae:
            r4[r7] = r5
            java.lang.String r0 = r8.getString(r0, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            int r9 = net.one97.paytm.recharge.R.id.pass_icon
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r0 = r8.f63193a
            r4 = 5
            if (r0 == 0) goto L_0x01eb
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r5 = r8.f63193a
            if (r5 == 0) goto L_0x01d8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityFilterAttributesV2 r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x01d8
            java.lang.String r1 = r5.getIcon()
        L_0x01d8:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r1)
            com.paytm.utility.t$b r1 = new com.paytm.utility.t$b
            r1.<init>(r4, r4, r2)
            com.squareup.picasso.ah r1 = (com.squareup.picasso.ah) r1
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r1)
            r0.a((android.widget.ImageView) r9)
            goto L_0x0213
        L_0x01eb:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r8.f63194b
            if (r0 == 0) goto L_0x0213
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r8.f63194b
            if (r5 == 0) goto L_0x0201
            net.one97.paytm.common.entity.recharge.CJRAttributes r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x0201
            java.lang.String r1 = r5.getIcon()
        L_0x0201:
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r1)
            com.paytm.utility.t$b r1 = new com.paytm.utility.t$b
            r1.<init>(r4, r4, r2)
            com.squareup.picasso.ah r1 = (com.squareup.picasso.ah) r1
            com.squareup.picasso.aa r0 = r0.a((com.squareup.picasso.ah) r1)
            r0.a((android.widget.ImageView) r9)
        L_0x0213:
            net.one97.paytm.recharge.di.helper.c r9 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r9 = net.one97.paytm.recharge.di.helper.c.ae()
            if (r9 == 0) goto L_0x0258
            net.one97.paytm.recharge.metro.f.c$a r9 = net.one97.paytm.recharge.metro.f.c.f63576a
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = r8.f63195c
            if (r9 != 0) goto L_0x0224
            kotlin.g.b.k.a()
        L_0x0224:
            java.util.List r9 = kotlin.a.k.a(r9)
            boolean r9 = net.one97.paytm.recharge.metro.f.c.a.c((java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel>) r9)
            if (r9 == 0) goto L_0x0258
            int r9 = net.one97.paytm.recharge.R.id.cancel_tickets
            android.view.View r9 = r8.findViewById(r9)
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            r9.setVisibility(r7)
            r0 = r8
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            int r9 = net.one97.paytm.recharge.R.id.txt_cancel_ticket
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r0 = net.one97.paytm.recharge.R.string.metro_mumbai_cancel
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r4 = r8.f63200i
            r1[r7] = r4
            java.lang.String r0 = r8.getString(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        L_0x0258:
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r9 = r8.f63196d
            if (r9 == 0) goto L_0x02ac
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r2
            if (r9 != r2) goto L_0x02ac
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r9 = r8.f63196d
            if (r9 != 0) goto L_0x026c
            kotlin.g.b.k.a()
        L_0x026c:
            java.lang.Object r9 = r9.get(r7)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r9 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r9
            java.util.List r9 = r9.getQrCodes()
            if (r9 == 0) goto L_0x02ac
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r0 = r6
        L_0x027f:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x02ad
            java.lang.Object r1 = r9.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r1 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r1
            boolean r4 = r8.f63199h
            if (r4 != 0) goto L_0x027f
            java.lang.String r4 = "qr"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = r1.getStatus()
            java.lang.String r5 = "ACTIVE"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x027f
            java.lang.String r0 = r1.getQrCodeId()
            java.lang.String r1 = "qr.qrCodeId"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r8.f63199h = r2
            goto L_0x027f
        L_0x02ac:
            r0 = r6
        L_0x02ad:
            int r9 = net.one97.paytm.recharge.R.id.txt_trip_id
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            boolean r1 = r8.f63199h
            java.lang.String r4 = "this"
            if (r1 == 0) goto L_0x02d3
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            r9.setVisibility(r7)
            int r1 = net.one97.paytm.recharge.R.string.metro_mumbai_trip_id
            java.lang.Object[] r2 = new java.lang.Object[r2]
            if (r0 != 0) goto L_0x02c8
            r0 = r6
        L_0x02c8:
            r2[r7] = r0
            java.lang.String r0 = r8.getString(r1, r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
        L_0x02d3:
            int r9 = net.one97.paytm.recharge.R.id.txt_generate_ticket
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            boolean r0 = r8.f63199h
            if (r0 == 0) goto L_0x02f7
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            int r0 = net.one97.paytm.recharge.R.string.metro_view_ticket
            java.lang.String r0 = r8.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.setText(r0)
            java.lang.String r0 = "generateDivider"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            r0 = 8
            r3.setVisibility(r0)
        L_0x02f7:
            r0 = r8
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            return
        L_0x02fe:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRActiveMetroPassActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX WARNING: type inference failed for: r0v20, types: [net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x000c
            int r5 = r5.getId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x000d
        L_0x000c:
            r5 = r0
        L_0x000d:
            int r1 = net.one97.paytm.recharge.R.id.txt_generate_ticket
            java.lang.String r2 = "operator"
            if (r5 != 0) goto L_0x0015
            goto L_0x0113
        L_0x0015:
            int r3 = r5.intValue()
            if (r3 != r1) goto L_0x0113
            boolean r5 = r4.f63199h
            java.lang.String r1 = "activeMetroTickets"
            if (r5 == 0) goto L_0x0057
            android.content.Intent r5 = new android.content.Intent
            r5.<init>()
            java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r0 = r4.f63196d
            if (r0 == 0) goto L_0x004f
            java.io.Serializable r0 = (java.io.Serializable) r0
            android.content.Intent r5 = r5.putExtra(r1, r0)
            java.lang.String r0 = r4.j
            java.lang.String r1 = "vertical_name"
            android.content.Intent r5 = r5.putExtra(r1, r0)
            java.lang.String r0 = "Intent()\n               …E, mCategoryVerticalName)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            android.content.Intent r0 = new android.content.Intent
            r1 = r4
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<net.one97.paytm.recharge.metro.activity.AJRActiveMetroTicketListActivity> r2 = net.one97.paytm.recharge.metro.activity.AJRActiveMetroTicketListActivity.class
            r0.<init>(r1, r2)
            android.content.Intent r5 = r0.putExtras(r5)
            r4.startActivity(r5)
            return
        L_0x004f:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.io.Serializable"
            r5.<init>(r0)
            throw r5
        L_0x0057:
            net.one97.paytm.recharge.metro.c.e r5 = r4.f63197e
            if (r5 != 0) goto L_0x00f7
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r3 = r4.f63200i
            r5.putString(r2, r3)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r2 = r4.f63195c
            java.io.Serializable r2 = (java.io.Serializable) r2
            r5.putSerializable(r1, r2)
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = r4.f63193a
            if (r1 == 0) goto L_0x0081
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r1 = r1.getProduct()
            if (r1 == 0) goto L_0x0081
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0081
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2 r1 = r1.getAlert()
            goto L_0x0082
        L_0x0081:
            r1 = r0
        L_0x0082:
            java.lang.String r2 = "extra_home_data"
            if (r1 == 0) goto L_0x00a0
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r1 = r4.f63193a
            if (r1 == 0) goto L_0x009a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r1 = r1.getProduct()
            if (r1 == 0) goto L_0x009a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x009a
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2 r0 = r1.getAlert()
        L_0x009a:
            java.io.Serializable r0 = (java.io.Serializable) r0
            r5.putSerializable(r2, r0)
            goto L_0x00db
        L_0x00a0:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r4.f63194b
            if (r1 == 0) goto L_0x00db
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2 r1 = new net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAlertV2
            r1.<init>()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r4.f63194b
            if (r3 == 0) goto L_0x00b8
            net.one97.paytm.common.entity.recharge.CJRAttributes r3 = r3.getAttributes()
            if (r3 == 0) goto L_0x00b8
            java.lang.String r3 = r3.getAlert_heading()
            goto L_0x00b9
        L_0x00b8:
            r3 = r0
        L_0x00b9:
            r1.setHeading(r3)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r4.f63194b
            if (r3 == 0) goto L_0x00ca
            net.one97.paytm.common.entity.recharge.CJRAttributes r3 = r3.getAttributes()
            if (r3 == 0) goto L_0x00ca
            java.lang.String r0 = r3.getAlert_message()
        L_0x00ca:
            r1.setMessage(r0)
            int r0 = net.one97.paytm.recharge.R.string.confirm
            java.lang.String r0 = r4.getString(r0)
            r1.setPositive_btn_txt(r0)
            java.io.Serializable r1 = (java.io.Serializable) r1
            r5.putSerializable(r2, r1)
        L_0x00db:
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.recharge.metro.c.e> r1 = net.one97.paytm.recharge.metro.c.e.class
            java.lang.String r1 = r1.getName()
            androidx.fragment.app.Fragment r5 = androidx.fragment.app.Fragment.instantiate(r0, r1, r5)
            if (r5 == 0) goto L_0x00ef
            net.one97.paytm.recharge.metro.c.e r5 = (net.one97.paytm.recharge.metro.c.e) r5
            r4.f63197e = r5
            goto L_0x00f7
        L_0x00ef:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRMetroGenerateQrCodeDialogFragment"
            r5.<init>(r0)
            throw r5
        L_0x00f7:
            net.one97.paytm.recharge.metro.c.e r5 = r4.f63197e
            if (r5 == 0) goto L_0x0101
            r0 = r4
            net.one97.paytm.recharge.metro.c.e$a r0 = (net.one97.paytm.recharge.metro.c.e.a) r0
            r5.a((net.one97.paytm.recharge.metro.c.e.a) r0)
        L_0x0101:
            net.one97.paytm.recharge.metro.c.e r5 = r4.f63197e
            if (r5 == 0) goto L_0x0112
            androidx.fragment.app.j r0 = r4.getSupportFragmentManager()
            java.lang.Class<net.one97.paytm.recharge.metro.c.e> r1 = net.one97.paytm.recharge.metro.c.e.class
            java.lang.String r1 = r1.getName()
            r5.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
        L_0x0112:
            return
        L_0x0113:
            int r1 = net.one97.paytm.recharge.R.id.cancel_tickets
            if (r5 != 0) goto L_0x0118
            return
        L_0x0118:
            int r5 = r5.intValue()
            if (r5 != r1) goto L_0x0191
            net.one97.paytm.recharge.metro.c.d r5 = r4.f63198g
            if (r5 != 0) goto L_0x0183
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r1 = r4.f63200i
            r5.putString(r2, r1)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r1 = r4.f63195c
            if (r1 == 0) goto L_0x0135
            java.lang.String r1 = r1.getProductType()
            goto L_0x0136
        L_0x0135:
            r1 = r0
        L_0x0136:
            java.lang.String r2 = "product-type"
            r5.putString(r2, r1)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r1 = r4.f63195c
            if (r1 == 0) goto L_0x0144
            java.lang.String r1 = r1.getOrderId()
            goto L_0x0145
        L_0x0144:
            r1 = r0
        L_0x0145:
            java.lang.String r2 = "order_id"
            r5.putString(r2, r1)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r1 = r4.f63195c
            if (r1 == 0) goto L_0x0153
            long r1 = r1.getProductId()
            goto L_0x0155
        L_0x0153:
            r1 = 0
        L_0x0155:
            java.lang.String r3 = "product_id"
            r5.putLong(r3, r1)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r1 = r4.f63195c
            if (r1 == 0) goto L_0x0162
            java.lang.String r0 = r1.getPassId()
        L_0x0162:
            java.lang.String r1 = "reference_id"
            r5.putString(r1, r0)
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.recharge.metro.c.d> r1 = net.one97.paytm.recharge.metro.c.d.class
            java.lang.String r1 = r1.getName()
            androidx.fragment.app.Fragment r5 = androidx.fragment.app.Fragment.instantiate(r0, r1, r5)
            if (r5 == 0) goto L_0x017b
            net.one97.paytm.recharge.metro.c.d r5 = (net.one97.paytm.recharge.metro.c.d) r5
            r4.f63198g = r5
            goto L_0x0183
        L_0x017b:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJRMetroCancelPassBottomSheetFragment"
            r5.<init>(r0)
            throw r5
        L_0x0183:
            net.one97.paytm.recharge.metro.c.d r5 = r4.f63198g
            if (r5 == 0) goto L_0x0191
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            androidx.fragment.app.j r1 = r4.getSupportFragmentManager()
            r5.a(r0, r1)
        L_0x0191:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRActiveMetroPassActivity.onClick(android.view.View):void");
    }

    public final void a(String str, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
        k.c(str, "productName");
        k.c(cJRActiveMetroTicketModel, "ticket");
        Intent putExtra = new Intent().putExtra(StringSet.operator, str).putExtra("vertical_name", this.j).putExtra("activeMetroTickets", cJRActiveMetroTicketModel);
        k.a((Object) putExtra, "Intent()\n               …VE_METRO_TICKETS, ticket)");
        startActivity(new Intent(this, AJRActiveMetroTicketListActivity.class).putExtras(putExtra));
        setResult(1006, putExtra);
        finish();
    }
}
