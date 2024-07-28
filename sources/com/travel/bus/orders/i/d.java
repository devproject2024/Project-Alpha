package com.travel.bus.orders.i;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.travel.bus.R;
import com.travel.bus.busticket.i.i;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.e.a;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import easypay.manager.Constants;
import java.util.Iterator;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;

public final class d extends a {
    private TextView A;
    private TextView B;
    private TableRow C;
    private View D;
    private View E;
    private TextView F;
    private View G;
    private TextView H;
    private TextView I;
    private View J;
    private View K;
    private TextView L;
    private LinearLayout M;
    private TextView N;
    private LinearLayout O;
    private TextView P;
    private BusOrderSummary.a Q;

    /* renamed from: a  reason: collision with root package name */
    private final TableRow f22663a;

    /* renamed from: b  reason: collision with root package name */
    private final TableRow f22664b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f22665c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f22666d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f22667e = ((TextView) this.itemView.findViewById(R.id.lbl_base_fare));

    /* renamed from: f  reason: collision with root package name */
    private CJRBusOrderSummary f22668f;

    /* renamed from: g  reason: collision with root package name */
    private com.travel.bus.orders.f.a f22669g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22670h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22671i;
    private TextView j;
    private TextView k;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private TableRow o;
    private LinearLayout p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private TableLayout x;
    private TextView y;
    private Resources z;

    public d(View view, CJRBusOrderSummary cJRBusOrderSummary, com.travel.bus.orders.f.a aVar, BusOrderSummary.a aVar2) {
        super(view);
        this.z = view.getResources();
        this.Q = aVar2;
        this.f22667e.setText(String.format(" %s", new Object[]{this.z.getString(R.string.base_fare)}));
        this.E = view.findViewById(R.id.awesomeTextLayout);
        this.F = (TextView) view.findViewById(R.id.awesomeText);
        this.G = view.findViewById(R.id.dealHolderLayout);
        this.H = (TextView) view.findViewById(R.id.text_deal_amount);
        this.I = (TextView) view.findViewById(R.id.operator_gst_fee_detail);
        this.J = view.findViewById(R.id.tbl_row_gst_fee);
        this.K = view.findViewById(R.id.tbl_row_other_fee);
        this.L = (TextView) view.findViewById(R.id.operator_other_fee_detail);
        this.f22671i = (TextView) this.itemView.findViewById(R.id.text_base_fare);
        this.j = (TextView) this.itemView.findViewById(R.id.text_taxes_fees);
        this.k = (TextView) this.itemView.findViewById(R.id.text_total_fare);
        this.f22670h = (TextView) this.itemView.findViewById(R.id.text_convience_fee);
        this.w = (ImageView) this.itemView.findViewById(R.id.convenience_fee_detail);
        this.w.setVisibility(8);
        this.A = (TextView) this.itemView.findViewById(R.id.label_insurance_fee);
        this.B = (TextView) this.itemView.findViewById(R.id.text_insurance_fee);
        this.C = (TableRow) this.itemView.findViewById(R.id.flight_insurance_row);
        this.l = (RelativeLayout) this.itemView.findViewById(R.id.promocode_layout);
        this.m = (TextView) this.itemView.findViewById(R.id.flight_promocode);
        this.n = (TextView) this.itemView.findViewById(R.id.paytm_cashback_value);
        this.l.setVisibility(8);
        this.o = (TableRow) this.itemView.findViewById(R.id.order_summary_transaction_layout);
        this.o.setVisibility(8);
        this.p = (LinearLayout) this.itemView.findViewById(R.id.payment_type_paytm_cash_layout);
        this.q = (LinearLayout) this.itemView.findViewById(R.id.payment_type_netbanking_layout);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        this.r = (TextView) this.itemView.findViewById(R.id.paytm_cash_amount);
        this.s = (TextView) this.itemView.findViewById(R.id.paytm_cash_transaction_details);
        this.t = (TextView) this.itemView.findViewById(R.id.order_summary_transaction_label);
        this.u = (TextView) this.itemView.findViewById(R.id.paytm_netbanking_amount);
        this.v = (TextView) this.itemView.findViewById(R.id.order_summary_netbanking_transaction);
        this.x = (TableLayout) this.itemView.findViewById(R.id.lyt_fare_details);
        this.x.setVisibility(0);
        this.y = (TextView) this.itemView.findViewById(R.id.text_total_fare_text);
        this.f22663a = (TableRow) this.itemView.findViewById(R.id.tbl_row_tax_fee);
        this.f22664b = (TableRow) this.itemView.findViewById(R.id.tbl_row_conv_fee);
        this.f22665c = (TextView) this.itemView.findViewById(R.id.lbl_total_amount);
        this.f22666d = (TextView) this.itemView.findViewById(R.id.lbl_total_amount_2);
        this.M = (LinearLayout) this.itemView.findViewById(R.id.bank_offer_cashback_layout);
        this.N = (TextView) this.itemView.findViewById(R.id.paytm_bus_bank_offer_cashback_amount);
        this.O = (LinearLayout) this.itemView.findViewById(R.id.tbl_row_bank_discount);
        this.P = (TextView) this.itemView.findViewById(R.id.text_bank_discount);
        this.D = this.itemView.findViewById(R.id.payment_devider);
        this.f22668f = cJRBusOrderSummary;
        this.f22669g = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0140 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014d A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0156 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01e8 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01f0 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0216 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0223 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0249 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0256 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02da A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x030d A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0341 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x037f A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x038b A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x03c8 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x03d4 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x03ff A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0429 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0436 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0460 A[Catch:{ Exception -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x046d A[Catch:{ Exception -> 0x04bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.bus.orders.c.c.b r23) {
        /*
            r22 = this;
            r1 = r22
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x04bb }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x04bb }
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0012:
            boolean r6 = r0.hasNext()     // Catch:{ Exception -> 0x04bb }
            if (r6 == 0) goto L_0x0040
            java.lang.Object r6 = r0.next()     // Catch:{ Exception -> 0x04bb }
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r6 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r6     // Catch:{ Exception -> 0x04bb }
            boolean r7 = com.travel.bus.orders.h.b.b(r6)     // Catch:{ Exception -> 0x04bb }
            if (r7 == 0) goto L_0x0012
            if (r6 == 0) goto L_0x003c
            java.lang.Object r4 = r6.getMetaDataResponse()     // Catch:{ Exception -> 0x04bb }
            com.google.gsonhtcfix.f r6 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x04bb }
            r6.<init>()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r4 = r6.a((java.lang.Object) r4)     // Catch:{ Exception -> 0x04bb }
            java.lang.Class<com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse> r7 = com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse.class
            java.lang.Object r4 = r6.a((java.lang.String) r4, r7)     // Catch:{ Exception -> 0x04bb }
            com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse r4 = (com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse) r4     // Catch:{ Exception -> 0x04bb }
            goto L_0x003d
        L_0x003c:
            r4 = 0
        L_0x003d:
            int r5 = r5 + 1
            goto L_0x0012
        L_0x0040:
            r6 = 0
            if (r4 == 0) goto L_0x0079
            com.travel.bus.pojo.busticket.CJROrdeFare r0 = r4.getCjrOrderData()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.getBaseFare()     // Catch:{ Exception -> 0x04bb }
            double r8 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x04bb }
            double r8 = r8 + r6
            com.travel.bus.pojo.busticket.CJROrdeFare r0 = r4.getCjrOrderData()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.getConvFee()     // Catch:{ Exception -> 0x04bb }
            double r10 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x04bb }
            double r10 = r10 + r6
            com.travel.bus.pojo.busticket.CJROrdeFare r0 = r4.getCjrOrderData()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.getInsuranceFee()     // Catch:{ Exception -> 0x04bb }
            double r12 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x04bb }
            double r12 = r12 + r6
            com.travel.bus.pojo.busticket.CJROrdeFare r0 = r4.getCjrOrderData()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.getTax()     // Catch:{ Exception -> 0x04bb }
            double r14 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x04bb }
            double r14 = r14 + r6
            goto L_0x007d
        L_0x0079:
            r8 = r6
            r10 = r8
            r12 = r10
            r14 = r12
        L_0x007d:
            com.travel.bus.pojo.busticket.CJROrdeFare r0 = r4.cjrOrderFare     // Catch:{ Exception -> 0x04bb }
            java.lang.String r6 = " "
            if (r0 == 0) goto L_0x013c
            java.lang.String r0 = r4.discountText     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x013c
            android.widget.TextView r0 = r1.F     // Catch:{ Exception -> 0x04bb }
            java.lang.String r7 = r4.discountText     // Catch:{ Exception -> 0x04bb }
            r0.setText(r7)     // Catch:{ Exception -> 0x04bb }
            android.view.View r0 = r1.E     // Catch:{ Exception -> 0x04bb }
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x04bb }
            android.view.View r0 = r1.G     // Catch:{ Exception -> 0x04bb }
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.H     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = "- "
            r7.<init>(r3)     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r2 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Exception -> 0x04bb }
            r7.append(r2)     // Catch:{ Exception -> 0x04bb }
            r7.append(r6)     // Catch:{ Exception -> 0x04bb }
            com.travel.bus.pojo.busticket.CJROrdeFare r2 = r4.cjrOrderFare     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.operatorDiscount     // Catch:{ Exception -> 0x04bb }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x04bb }
            int r2 = (int) r2     // Catch:{ Exception -> 0x04bb }
            double r2 = (double) r2     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = com.travel.bus.busticket.i.i.a((double) r2)     // Catch:{ Exception -> 0x04bb }
            r7.append(r2)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            com.travel.bus.pojo.busticket.CJROrdeFare r0 = r4.cjrOrderFare     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.operatorGst     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x013c
            android.widget.TableRow r0 = r1.f22663a     // Catch:{ Exception -> 0x04bb }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
            android.view.View r0 = r1.J     // Catch:{ Exception -> 0x04bb }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
            android.view.View r0 = r1.K     // Catch:{ Exception -> 0x04bb }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.I     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r2.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r7 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r7)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r6)     // Catch:{ Exception -> 0x04bb }
            com.travel.bus.pojo.busticket.CJROrdeFare r3 = r4.cjrOrderFare     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.operatorGst     // Catch:{ Exception -> 0x04bb }
            r18 = r12
            double r12 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x04bb }
            int r3 = (int) r12     // Catch:{ Exception -> 0x04bb }
            double r12 = (double) r3     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = com.travel.bus.busticket.i.i.a((double) r12)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.L     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r2.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r7 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r7)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r6)     // Catch:{ Exception -> 0x04bb }
            com.travel.bus.pojo.busticket.CJROrdeFare r3 = r4.cjrOrderFare     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.otherFee     // Catch:{ Exception -> 0x04bb }
            double r12 = java.lang.Double.parseDouble(r3)     // Catch:{ Exception -> 0x04bb }
            int r3 = (int) r12     // Catch:{ Exception -> 0x04bb }
            double r12 = (double) r3     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = com.travel.bus.busticket.i.i.a((double) r12)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x013e
        L_0x013c:
            r18 = r12
        L_0x013e:
            if (r4 == 0) goto L_0x014d
            com.travel.bus.pojo.busticket.CJROrdeFare r0 = r4.getCjrOrderData()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.getGrandTotal()     // Catch:{ Exception -> 0x04bb }
            double r2 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x04bb }
            goto L_0x014f
        L_0x014d:
            r2 = 0
        L_0x014f:
            r7 = 3
            r16 = 0
            int r13 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r13 == 0) goto L_0x01e8
            java.lang.String r13 = r4.getPassengerCount()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = "1.0"
            boolean r0 = r13.equals(r0)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r13 = "%s (%s %s)"
            if (r0 == 0) goto L_0x0193
            android.widget.TextView r0 = r1.f22667e     // Catch:{ Exception -> 0x04bb }
            java.lang.Object[] r12 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r7 = r1.z     // Catch:{ Exception -> 0x04bb }
            r20 = r2
            int r2 = com.travel.bus.R.string.base_fare     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r7.getString(r2)     // Catch:{ Exception -> 0x04bb }
            r3 = 0
            r12[r3] = r2     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r4.getPassengerCount()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = com.travel.bus.busticket.i.i.a((java.lang.String) r2)     // Catch:{ Exception -> 0x04bb }
            r3 = 1
            r12[r3] = r2     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r3 = com.travel.bus.R.string.traveller     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04bb }
            r3 = 2
            r12[r3] = r2     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = java.lang.String.format(r13, r12)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x01c2
        L_0x0193:
            r20 = r2
            android.widget.TextView r0 = r1.f22667e     // Catch:{ Exception -> 0x04bb }
            r2 = 3
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r7 = com.travel.bus.R.string.base_fare     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r7)     // Catch:{ Exception -> 0x04bb }
            r7 = 0
            r3[r7] = r2     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r4.getPassengerCount()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = com.travel.bus.busticket.i.i.a((java.lang.String) r2)     // Catch:{ Exception -> 0x04bb }
            r4 = 1
            r3[r4] = r2     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r4 = com.travel.bus.R.string.travellers     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ Exception -> 0x04bb }
            r4 = 2
            r3[r4] = r2     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = java.lang.String.format(r13, r3)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x01c2:
            android.widget.TextView r0 = r1.f22671i     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r2.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r4 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r6)     // Catch:{ Exception -> 0x04bb }
            int r3 = (int) r8     // Catch:{ Exception -> 0x04bb }
            double r3 = (double) r3     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = com.travel.bus.busticket.i.i.a((double) r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x01ea
        L_0x01e8:
            r20 = r2
        L_0x01ea:
            r2 = 0
            int r0 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0216
            android.widget.TextView r0 = r1.j     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r2.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r4 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r6)     // Catch:{ Exception -> 0x04bb }
            int r3 = (int) r14     // Catch:{ Exception -> 0x04bb }
            double r3 = (double) r3     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = com.travel.bus.busticket.i.i.a((double) r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x021d
        L_0x0216:
            android.widget.TableRow r0 = r1.f22663a     // Catch:{ Exception -> 0x04bb }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x021d:
            r2 = 0
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0249
            android.widget.TextView r0 = r1.f22670h     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r2.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r4 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r6)     // Catch:{ Exception -> 0x04bb }
            int r3 = (int) r10     // Catch:{ Exception -> 0x04bb }
            double r3 = (double) r3     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = com.travel.bus.busticket.i.i.a((double) r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x0250
        L_0x0249:
            android.widget.TableRow r0 = r1.f22664b     // Catch:{ Exception -> 0x04bb }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x0250:
            r2 = 0
            int r0 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x02da
            android.widget.TableRow r0 = r1.C     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x02e5
            android.widget.TableRow r0 = r1.C     // Catch:{ Exception -> 0x04bb }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
            double r2 = (double) r5     // Catch:{ Exception -> 0x04bb }
            double r12 = r18 / r2
            android.widget.TextView r0 = r1.A     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x02b2
            android.widget.TextView r0 = r1.A     // Catch:{ Exception -> 0x04bb }
            r2 = 10
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r4 = com.travel.bus.R.string.bus_order_summary_bus_free_cancellation     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x04bb }
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x04bb }
            r3 = 1
            r2[r3] = r6     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = "("
            r4 = 2
            r2[r4] = r3     // Catch:{ Exception -> 0x04bb }
            r3 = 3
            r2[r3] = r6     // Catch:{ Exception -> 0x04bb }
            r3 = 4
            java.lang.String r4 = com.travel.bus.busticket.i.i.a((double) r12)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x04bb }
            r2[r3] = r4     // Catch:{ Exception -> 0x04bb }
            r3 = 5
            r2[r3] = r6     // Catch:{ Exception -> 0x04bb }
            r3 = 6
            java.lang.String r4 = "/"
            r2[r3] = r4     // Catch:{ Exception -> 0x04bb }
            r3 = 7
            r2[r3] = r6     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r4 = com.travel.bus.R.string.traveller     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x04bb }
            r4 = 8
            r2[r4] = r3     // Catch:{ Exception -> 0x04bb }
            r3 = 9
            java.lang.String r4 = ")"
            r2[r3] = r4     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = com.paytm.utility.v.a((java.lang.String[]) r2)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x02b2:
            android.widget.TextView r0 = r1.B     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r2.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r4 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r6)     // Catch:{ Exception -> 0x04bb }
            r12 = r18
            int r3 = (int) r12     // Catch:{ Exception -> 0x04bb }
            double r3 = (double) r3     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = com.travel.bus.busticket.i.i.a((double) r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x02e5
        L_0x02da:
            android.widget.TableRow r0 = r1.C     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x02e5
            android.widget.TableRow r0 = r1.C     // Catch:{ Exception -> 0x04bb }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x02e5:
            android.widget.TextView r0 = r1.f22665c     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r3 = com.travel.bus.R.string.total_amount_paid_order_summary     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.f22666d     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r3 = com.travel.bus.R.string.total_amount_paid_order_summary     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.getPaymentStatus()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = "PROCESSING"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x0333
            android.widget.TextView r0 = r1.f22665c     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r3 = com.travel.bus.R.string.total_amount_due_order_summary     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.f22666d     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r3 = com.travel.bus.R.string.total_amount_due_order_summary     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.f22665c     // Catch:{ Exception -> 0x04bb }
            r2 = 0
            r3 = 1
            r0.setTypeface(r2, r3)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.f22666d     // Catch:{ Exception -> 0x04bb }
            r0.setTypeface(r2, r3)     // Catch:{ Exception -> 0x04bb }
        L_0x0333:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.String r0 = r0.getPaymentStatus()     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = "FAILED"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x0367
            android.widget.TextView r0 = r1.f22665c     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r3 = com.travel.bus.R.string.total_amount     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.f22666d     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r2 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r3 = com.travel.bus.R.string.total_amount     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.f22665c     // Catch:{ Exception -> 0x04bb }
            r2 = 0
            r3 = 1
            r0.setTypeface(r2, r3)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.f22666d     // Catch:{ Exception -> 0x04bb }
            r0.setTypeface(r2, r3)     // Catch:{ Exception -> 0x04bb }
        L_0x0367:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getOnwardBankCashback()     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x038b
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getOnwardBankCashback()     // Catch:{ Exception -> 0x04bb }
            double r2 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x038b
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getOnwardBankCashback()     // Catch:{ Exception -> 0x04bb }
            double r2 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            double r2 = r2 + r4
            goto L_0x038d
        L_0x038b:
            r2 = 0
        L_0x038d:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getReturnBankCashback()     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x03b0
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getReturnBankCashback()     // Catch:{ Exception -> 0x04bb }
            double r4 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            r7 = 0
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x03b0
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getReturnBankCashback()     // Catch:{ Exception -> 0x04bb }
            double r4 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            double r2 = r2 + r4
        L_0x03b0:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getOnwardBankDiscount()     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x03d4
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getOnwardBankDiscount()     // Catch:{ Exception -> 0x04bb }
            double r4 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            r7 = 0
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x03d4
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getOnwardBankDiscount()     // Catch:{ Exception -> 0x04bb }
            double r4 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            double r4 = r4 + r7
            goto L_0x03d6
        L_0x03d4:
            r4 = 0
        L_0x03d6:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getReturnBankDiscount()     // Catch:{ Exception -> 0x04bb }
            if (r0 == 0) goto L_0x03f9
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getReturnBankDiscount()     // Catch:{ Exception -> 0x04bb }
            double r7 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            r9 = 0
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x03f9
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r1.f22668f     // Catch:{ Exception -> 0x04bb }
            java.lang.Double r0 = r0.getReturnBankDiscount()     // Catch:{ Exception -> 0x04bb }
            double r7 = r0.doubleValue()     // Catch:{ Exception -> 0x04bb }
            double r4 = r4 + r7
        L_0x03f9:
            r7 = 0
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0429
            android.widget.LinearLayout r0 = r1.M     // Catch:{ Exception -> 0x04bb }
            r7 = 0
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.N     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r7.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r8 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r9 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x04bb }
            r7.append(r8)     // Catch:{ Exception -> 0x04bb }
            r7.append(r6)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = com.travel.bus.busticket.i.i.a((double) r2)     // Catch:{ Exception -> 0x04bb }
            r7.append(r2)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x0430
        L_0x0429:
            android.widget.LinearLayout r0 = r1.M     // Catch:{ Exception -> 0x04bb }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x0430:
            r2 = 0
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0460
            android.widget.LinearLayout r0 = r1.O     // Catch:{ Exception -> 0x04bb }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.P     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r2.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r3 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r7 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = r3.getString(r7)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            r2.append(r6)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r3 = com.travel.bus.busticket.i.i.a((double) r4)     // Catch:{ Exception -> 0x04bb }
            r2.append(r3)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
            goto L_0x0467
        L_0x0460:
            android.widget.LinearLayout r0 = r1.O     // Catch:{ Exception -> 0x04bb }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x0467:
            r2 = 0
            int r0 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x04b7
            double r2 = r20 - r4
            android.widget.TextView r0 = r1.k     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r4.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r5 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r7 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r5 = r5.getString(r7)     // Catch:{ Exception -> 0x04bb }
            r4.append(r5)     // Catch:{ Exception -> 0x04bb }
            r4.append(r6)     // Catch:{ Exception -> 0x04bb }
            int r2 = (int) r2     // Catch:{ Exception -> 0x04bb }
            double r2 = (double) r2     // Catch:{ Exception -> 0x04bb }
            java.lang.String r5 = com.travel.bus.busticket.i.i.a((double) r2)     // Catch:{ Exception -> 0x04bb }
            r4.append(r5)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r4)     // Catch:{ Exception -> 0x04bb }
            android.widget.TextView r0 = r1.y     // Catch:{ Exception -> 0x04bb }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04bb }
            r4.<init>()     // Catch:{ Exception -> 0x04bb }
            android.content.res.Resources r5 = r1.z     // Catch:{ Exception -> 0x04bb }
            int r7 = com.travel.bus.R.string.rs_symbol     // Catch:{ Exception -> 0x04bb }
            java.lang.String r5 = r5.getString(r7)     // Catch:{ Exception -> 0x04bb }
            r4.append(r5)     // Catch:{ Exception -> 0x04bb }
            r4.append(r6)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = com.travel.bus.busticket.i.i.a((double) r2)     // Catch:{ Exception -> 0x04bb }
            r4.append(r2)     // Catch:{ Exception -> 0x04bb }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x04bb }
            r0.setText(r2)     // Catch:{ Exception -> 0x04bb }
        L_0x04b7:
            r22.a()     // Catch:{ Exception -> 0x04bb }
            return
        L_0x04bb:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.d.a(com.travel.bus.orders.c.c$b):void");
    }

    private void a() {
        Iterator<CJROrderSummaryPayment> it2 = this.f22668f.getPaymentInfo().iterator();
        while (it2.hasNext()) {
            CJROrderSummaryPayment next = it2.next();
            this.o.setVisibility(0);
            if (!TextUtils.isEmpty(next.getPaymentMethod())) {
                String str = null;
                if (next.getPaymentMethod().equalsIgnoreCase("NB") || next.getPaymentMethod().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_CREDIT_CARD) || next.getPaymentMethod().equalsIgnoreCase(Constants.EASYPAY_PAYTYPE_DEBIT_CARD)) {
                    this.q.setVisibility(0);
                    this.t.setText(String.format("%s %s", new Object[]{TextUtils.isEmpty(next.getPaymentBank()) ? next.getPaymentMethod() : next.getPaymentBank(), this.z.getString(R.string.net_banking)}));
                    this.u.setText(this.z.getString(R.string.rs_symbol) + " " + i.a(next.getPgAmount()));
                    TextView textView = this.v;
                    if (!TextUtils.isEmpty(next.getBankTransactionId())) {
                        str = this.z.getString(R.string.transaction_id) + " #" + next.getBankTransactionId();
                    }
                    textView.setText(str);
                    this.D.setVisibility(8);
                } else if (next.getPaymentMethod().equalsIgnoreCase("Paytm Cash") || next.getPaymentMethod().equalsIgnoreCase("paytm")) {
                    this.p.setVisibility(8);
                    this.D.setVisibility(8);
                    this.r.setText(this.z.getString(R.string.rs_symbol) + " " + i.a(next.getPgAmount()));
                    TextView textView2 = this.s;
                    if (!TextUtils.isEmpty(next.getBankTransactionId())) {
                        str = this.z.getString(R.string.transaction_id) + " #" + next.getBankTransactionId();
                    }
                    textView2.setText(str);
                    if (TextUtils.isEmpty(this.s.getText())) {
                        this.s.setVisibility(8);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.N.getText())) {
                this.D.setVisibility(0);
            }
        }
        this.q.setVisibility(8);
    }
}
