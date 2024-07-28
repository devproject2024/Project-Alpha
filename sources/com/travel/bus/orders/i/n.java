package com.travel.bus.orders.i;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.travel.bus.R;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.e.a;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;

public final class n extends a implements View.OnClickListener {
    private j A;
    private LinearLayout B;

    /* renamed from: a  reason: collision with root package name */
    Context f22766a = this.f22768c.c();

    /* renamed from: b  reason: collision with root package name */
    private CJRBusOrderSummary f22767b;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.bus.orders.f.a f22768c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f22769d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f22770e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22771f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22772g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f22773h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f22774i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private View m;
    private View n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private View w;
    private String x;
    private BusOrderSummary.a y;
    private boolean z;

    public n(View view, CJRBusOrderSummary cJRBusOrderSummary, com.travel.bus.orders.f.a aVar, BusOrderSummary.a aVar2, String str, boolean z2, boolean z3, Activity activity) {
        super(view);
        this.z = z2;
        this.x = str;
        this.y = aVar2;
        this.v = (TextView) view.findViewById(R.id.pnr_text_view);
        this.w = view.findViewById(R.id.pnr_devider_view);
        this.f22769d = (RelativeLayout) view.findViewById(R.id.order_header_from_history);
        this.f22770e = (ImageView) view.findViewById(R.id.status_image_view);
        this.f22771f = (TextView) view.findViewById(R.id.booking_confirmation_text);
        this.f22772g = (TextView) view.findViewById(R.id.booking_confirmation_text_desc);
        this.r = (TextView) view.findViewById(R.id.retry);
        this.s = (TextView) view.findViewById(R.id.retry1);
        this.f22773h = (LinearLayout) view.findViewById(R.id.order_summary_from_payment);
        this.f22774i = (TextView) view.findViewById(R.id.booking_text_after_transaction);
        this.j = (ImageView) view.findViewById(R.id.order_state_imageview_1);
        this.k = (ImageView) view.findViewById(R.id.order_state_imageview_2);
        this.l = (ImageView) view.findViewById(R.id.order_state_imageview_3);
        this.o = (TextView) view.findViewById(R.id.order_state_textview_1);
        this.p = (TextView) view.findViewById(R.id.order_state_textview_2);
        this.q = (TextView) view.findViewById(R.id.order_state_textview_3);
        this.m = view.findViewById(R.id.order_state_indicator_image1);
        this.n = view.findViewById(R.id.order_state_indicator_image2);
        this.t = (TextView) view.findViewById(R.id.booking_text_desc);
        this.B = (LinearLayout) view.findViewById(R.id.action_container);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.f22767b = cJRBusOrderSummary;
        this.f22768c = aVar;
        int g2 = b.g(this.f22772g.getContext()) / 4;
        this.f22772g.setPadding(g2, 0, g2, 0);
        if (this.z) {
            this.A = new j(view, this.f22767b, aVar, activity, z3, this.y);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v10, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01f6 A[SYNTHETIC, Splitter:B:68:0x01f6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.travel.bus.orders.c.c.b r10) {
        /*
            r9 = this;
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r9.x
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r2 = 8
            r3 = 0
            if (r0 != 0) goto L_0x002f
            android.widget.TextView r0 = r9.v
            r0.setVisibility(r3)
            android.view.View r0 = r9.w
            r0.setVisibility(r3)
            android.widget.TextView r0 = r9.v
            android.content.Context r4 = r9.f22766a
            int r5 = com.travel.bus.R.string.bus_order_summary_pnr_number
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = r9.x
            r6[r3] = r7
            java.lang.String r4 = r4.getString(r5, r6)
            r0.setText(r4)
            goto L_0x0039
        L_0x002f:
            android.widget.TextView r0 = r9.v
            r0.setVisibility(r2)
            android.view.View r0 = r9.w
            r0.setVisibility(r2)
        L_0x0039:
            boolean r0 = r9.z
            if (r0 == 0) goto L_0x00a1
            android.widget.LinearLayout r0 = r9.B
            r0.setVisibility(r3)
            com.travel.bus.orders.i.j r0 = r9.A
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = new net.one97.paytm.common.entity.shopping.CJROrderedCart
            r4.<init>()
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r4 = r0.f22734d
            java.util.ArrayList r4 = r4.getOrderedCartList()
            if (r4 == 0) goto L_0x00a6
            java.lang.Object r5 = r4.get(r3)
            if (r5 == 0) goto L_0x00a6
            java.lang.Object r5 = r4.get(r3)
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r5 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r5
            java.util.ArrayList r5 = r5.getAction()
            if (r5 == 0) goto L_0x00a6
            java.lang.Object r5 = r4.get(r3)
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r5 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r5
            java.util.ArrayList r5 = r5.getAction()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00a6
            java.lang.Object r5 = r4.get(r3)
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r5 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r5
            java.util.ArrayList r5 = r5.getAction()
            int r5 = r5.size()
            r0.f22737g = r5
            com.travel.bus.orders.i.j$a r5 = new com.travel.bus.orders.i.j$a
            java.lang.Object r4 = r4.get(r3)
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r4 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r4
            java.util.ArrayList r4 = r4.getAction()
            r5.<init>(r4)
            r0.f22733c = r5
            androidx.recyclerview.widget.RecyclerView r4 = r0.f22732b
            com.travel.bus.orders.i.j$a r5 = r0.f22733c
            r4.setAdapter(r5)
            com.travel.bus.orders.i.j$a r0 = r0.f22733c
            r0.notifyDataSetChanged()
            goto L_0x00a6
        L_0x00a1:
            android.widget.LinearLayout r0 = r9.B
            r0.setVisibility(r2)
        L_0x00a6:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b
            r4 = 17
            r5 = 18
            if (r0 == 0) goto L_0x0102
            java.util.ArrayList r0 = r0.getOrderedCartList()
            if (r0 == 0) goto L_0x0102
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b
            java.util.ArrayList r0 = r0.getOrderedCartList()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0102
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ca:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0102
            java.lang.Object r6 = r0.next()
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r6 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r6
            boolean r7 = com.travel.bus.orders.h.b.a((net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r6)
            if (r7 == 0) goto L_0x00e6
            java.lang.String r7 = r6.getItemStatus()
            int r7 = java.lang.Integer.parseInt(r7)
            if (r7 != r5) goto L_0x0100
        L_0x00e6:
            boolean r7 = com.travel.bus.orders.h.b.b(r6)
            if (r7 == 0) goto L_0x00ca
            java.lang.String r7 = r6.getItemStatus()
            int r7 = java.lang.Integer.parseInt(r7)
            if (r7 == r5) goto L_0x00ca
            java.lang.String r6 = r6.getItemStatus()
            int r6 = java.lang.Integer.parseInt(r6)
            if (r6 == r4) goto L_0x00ca
        L_0x0100:
            r0 = 0
            goto L_0x0103
        L_0x0102:
            r0 = 1
        L_0x0103:
            r6 = 0
            if (r0 == 0) goto L_0x01f6
            android.widget.RelativeLayout r10 = r9.f22769d
            r10.setVisibility(r3)
            android.widget.LinearLayout r10 = r9.f22773h
            r10.setVisibility(r2)
            android.widget.RelativeLayout r10 = r9.f22769d
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r10 = (android.widget.LinearLayout.LayoutParams) r10
            r0 = 1090519040(0x41000000, float:8.0)
            android.content.Context r1 = r9.f22766a
            int r0 = com.paytm.utility.b.a((float) r0, (android.content.Context) r1)
            r1 = 1092616192(0x41200000, float:10.0)
            android.content.Context r7 = r9.f22766a
            int r1 = com.paytm.utility.b.a((float) r1, (android.content.Context) r7)
            r10.setMargins(r3, r0, r3, r1)
            android.widget.RelativeLayout r0 = r9.f22769d
            r0.setLayoutParams(r10)
            android.widget.RelativeLayout r10 = r9.f22769d
            r10.requestLayout()
            android.widget.ImageView r10 = r9.f22770e
            android.content.Context r0 = r10.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.travel.bus.R.drawable.travel_res_bus_ic_failed
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r1)
            r10.setImageBitmap(r0)
            android.widget.TextView r10 = r9.f22771f
            int r0 = com.travel.bus.R.string.train_booking_cancelled
            r10.setText(r0)
            android.widget.TextView r10 = r9.f22772g
            r10.setVisibility(r2)
            com.travel.bus.orders.activity.BusOrderSummary$a r10 = r9.y
            com.travel.bus.orders.activity.BusOrderSummary$a r0 = com.travel.bus.orders.activity.BusOrderSummary.a.BUS
            if (r10 != r0) goto L_0x01f5
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b
            java.util.ArrayList r10 = r10.getOrderedCartList()
            if (r10 == 0) goto L_0x01f5
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b
            java.util.ArrayList r10 = r10.getOrderedCartList()
            int r10 = r10.size()
            if (r10 <= 0) goto L_0x01f5
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b
            java.util.ArrayList r10 = r10.getOrderedCartList()
            java.util.Iterator r10 = r10.iterator()
        L_0x0178:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x018b
            java.lang.Object r0 = r10.next()
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r0 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r0
            boolean r1 = com.travel.bus.orders.h.b.b(r0)
            if (r1 == 0) goto L_0x0178
            goto L_0x018c
        L_0x018b:
            r0 = r6
        L_0x018c:
            if (r0 == 0) goto L_0x01f5
            java.lang.String r10 = r0.getItemStatus()
            int r10 = java.lang.Integer.parseInt(r10)
            r0.getStatusText()
            if (r10 != r4) goto L_0x01b5
            android.widget.TextView r10 = r9.f22771f
            int r0 = com.travel.bus.R.string.processing_cancellation
            r10.setText(r0)
            android.widget.TextView r10 = r9.f22772g
            android.content.Context r0 = r9.f22766a
            int r1 = com.travel.bus.R.string.bus_order_summary_cancellation_message
            java.lang.String r0 = r0.getString(r1)
            r10.setText(r0)
            android.widget.TextView r10 = r9.f22772g
            r10.setVisibility(r3)
            return
        L_0x01b5:
            if (r10 != r5) goto L_0x01f5
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r10 = r10.getRefund()
            if (r10 != 0) goto L_0x01c0
            goto L_0x01ca
        L_0x01c0:
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r10 = r10.getRefund()
            java.lang.String r6 = r10.getMessage()
        L_0x01ca:
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 == 0) goto L_0x01e1
            android.widget.TextView r10 = r9.f22772g
            r10.setVisibility(r3)
            android.widget.TextView r10 = r9.f22772g
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b
            java.lang.String r0 = r0.getRefundSourceText()
            r10.setText(r0)
            return
        L_0x01e1:
            android.widget.TextView r10 = r9.f22772g
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r0 = r0.getRefund()
            java.lang.String r0 = r0.getMessage()
            r10.setText(r0)
            android.widget.TextView r10 = r9.f22772g
            r10.setVisibility(r3)
        L_0x01f5:
            return
        L_0x01f6:
            int[] r0 = com.travel.bus.orders.i.n.AnonymousClass2.f22776a     // Catch:{ Exception -> 0x0544 }
            int r10 = r10.ordinal()     // Catch:{ Exception -> 0x0544 }
            r10 = r0[r10]     // Catch:{ Exception -> 0x0544 }
            r0 = 1056964608(0x3f000000, float:0.5)
            switch(r10) {
                case 1: goto L_0x0468;
                case 2: goto L_0x041c;
                case 3: goto L_0x0380;
                case 4: goto L_0x02d4;
                case 5: goto L_0x02d0;
                case 6: goto L_0x0205;
                default: goto L_0x0203;
            }     // Catch:{ Exception -> 0x0544 }
        L_0x0203:
            goto L_0x0543
        L_0x0205:
            android.widget.RelativeLayout r10 = r9.f22769d     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            android.widget.LinearLayout r10 = r9.f22773h     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.r     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.s     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r10 = r10.getContext()     // Catch:{ Exception -> 0x0544 }
            int r0 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_success     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r10 = androidx.core.content.b.a((android.content.Context) r10, (int) r0)     // Catch:{ Exception -> 0x0544 }
            android.view.View r0 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.drawable.travel_res_bus_flight_booking_failed     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)     // Catch:{ Exception -> 0x0544 }
            android.view.View r1 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r1 = r1.getContext()     // Catch:{ Exception -> 0x0544 }
            int r4 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_success     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r4)     // Catch:{ Exception -> 0x0544 }
            int r4 = com.travel.bus.R.string.payment_confirmed     // Catch:{ Exception -> 0x0544 }
            int r5 = com.travel.bus.R.string.booking_failed     // Catch:{ Exception -> 0x0544 }
            int r6 = com.travel.bus.R.string.refund_processed     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r7 = r9.f22774i     // Catch:{ Exception -> 0x0544 }
            int r8 = com.travel.bus.R.string.booking_failed_after_payment_confirmed     // Catch:{ Exception -> 0x0544 }
            r7.setText(r8)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r7 = r9.j     // Catch:{ Exception -> 0x0544 }
            r7.setImageDrawable(r10)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.k     // Catch:{ Exception -> 0x0544 }
            r10.setImageDrawable(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.l     // Catch:{ Exception -> 0x0544 }
            r10.setImageDrawable(r1)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.m     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.color.red     // Catch:{ Exception -> 0x0544 }
            int r0 = androidx.core.content.b.c(r0, r1)     // Catch:{ Exception -> 0x0544 }
            r10.setBackgroundColor(r0)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.n     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.color.green_train     // Catch:{ Exception -> 0x0544 }
            int r0 = androidx.core.content.b.c(r0, r1)     // Catch:{ Exception -> 0x0544 }
            r10.setBackgroundColor(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.o     // Catch:{ Exception -> 0x0544 }
            r10.setText(r4)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.p     // Catch:{ Exception -> 0x0544 }
            r10.setText(r5)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.q     // Catch:{ Exception -> 0x0544 }
            r10.setText(r6)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.t     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.u     // Catch:{ Exception -> 0x0544 }
            if (r10 == 0) goto L_0x0290
            android.widget.TextView r10 = r9.u     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
        L_0x0290:
            android.widget.TextView r10 = r9.r     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.s     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.activity.BusOrderSummary$a r10 = r9.y     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.activity.BusOrderSummary$a r0 = com.travel.bus.orders.activity.BusOrderSummary.a.BUS     // Catch:{ Exception -> 0x0544 }
            if (r10 != r0) goto L_0x0543
            android.widget.TextView r10 = r9.r     // Catch:{ Exception -> 0x0544 }
            int r0 = com.travel.bus.R.string.retry_booking     // Catch:{ Exception -> 0x0544 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.r     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.t     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.f22774i     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.string.bus_order_failed_message     // Catch:{ Exception -> 0x0544 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0544 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.t     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.t     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b     // Catch:{ Exception -> 0x0544 }
            java.lang.String r0 = r0.getRefundSourceText()     // Catch:{ Exception -> 0x0544 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0544 }
            goto L_0x0543
        L_0x02d0:
            r9.a()     // Catch:{ Exception -> 0x0544 }
            return
        L_0x02d4:
            android.widget.RelativeLayout r10 = r9.f22769d     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            android.widget.LinearLayout r10 = r9.f22773h     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r10 = r10.getContext()     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_success     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r10 = androidx.core.content.b.a((android.content.Context) r10, (int) r1)     // Catch:{ Exception -> 0x0544 }
            android.view.View r1 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r1 = r1.getContext()     // Catch:{ Exception -> 0x0544 }
            int r3 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_processing     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0544 }
            android.view.View r3 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0544 }
            int r4 = com.travel.bus.R.drawable.travel_res_bus_order_summary_idle_state     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)     // Catch:{ Exception -> 0x0544 }
            int r4 = com.travel.bus.R.string.payment_confirmed     // Catch:{ Exception -> 0x0544 }
            int r5 = com.travel.bus.R.string.bus_order_summary_confirming_booking     // Catch:{ Exception -> 0x0544 }
            int r6 = com.travel.bus.R.string.ticket_sent_on_email_or_sms     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r7 = r9.f22774i     // Catch:{ Exception -> 0x0544 }
            int r8 = com.travel.bus.R.string.booking_confirmation_waiting_text     // Catch:{ Exception -> 0x0544 }
            r7.setText(r8)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r7 = r9.j     // Catch:{ Exception -> 0x0544 }
            r7.setImageDrawable(r10)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.k     // Catch:{ Exception -> 0x0544 }
            r10.setImageDrawable(r1)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.l     // Catch:{ Exception -> 0x0544 }
            r10.setImageDrawable(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.l     // Catch:{ Exception -> 0x0544 }
            r10.setScaleX(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.l     // Catch:{ Exception -> 0x0544 }
            r10.setScaleY(r0)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.m     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.color.green_train     // Catch:{ Exception -> 0x0544 }
            int r0 = androidx.core.content.b.c(r0, r1)     // Catch:{ Exception -> 0x0544 }
            r10.setBackgroundColor(r0)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.n     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.color.color_f4f4f4     // Catch:{ Exception -> 0x0544 }
            int r0 = androidx.core.content.b.c(r0, r1)     // Catch:{ Exception -> 0x0544 }
            r10.setBackgroundColor(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.o     // Catch:{ Exception -> 0x0544 }
            r10.setText(r4)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.p     // Catch:{ Exception -> 0x0544 }
            r10.setText(r5)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.q     // Catch:{ Exception -> 0x0544 }
            r10.setText(r6)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.t     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.u     // Catch:{ Exception -> 0x0544 }
            if (r10 == 0) goto L_0x035f
            android.widget.TextView r10 = r9.u     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
        L_0x035f:
            com.travel.bus.orders.f.a r10 = r9.f22768c     // Catch:{ Exception -> 0x0544 }
            if (r10 == 0) goto L_0x037f
            com.travel.bus.orders.f.a r10 = r9.f22768c     // Catch:{ Exception -> 0x0544 }
            java.util.concurrent.ScheduledExecutorService r10 = r10.b()     // Catch:{ Exception -> 0x0544 }
            if (r10 == 0) goto L_0x037f
            com.travel.bus.orders.f.a r10 = r9.f22768c     // Catch:{ Exception -> 0x0544 }
            java.util.concurrent.ScheduledExecutorService r0 = r10.b()     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.i.-$$Lambda$n$4q6prlWKLMJ_45m_FFIzyQh1DXA r1 = new com.travel.bus.orders.i.-$$Lambda$n$4q6prlWKLMJ_45m_FFIzyQh1DXA     // Catch:{ Exception -> 0x0544 }
            r1.<init>()     // Catch:{ Exception -> 0x0544 }
            r2 = 100
            r4 = 100
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0544 }
            r0.scheduleAtFixedRate(r1, r2, r4, r6)     // Catch:{ Exception -> 0x0544 }
        L_0x037f:
            return
        L_0x0380:
            android.widget.RelativeLayout r10 = r9.f22769d     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            android.widget.LinearLayout r10 = r9.f22773h     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r10 = r10.getContext()     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_pending     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r10 = androidx.core.content.b.a((android.content.Context) r10, (int) r1)     // Catch:{ Exception -> 0x0544 }
            android.view.View r1 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r1 = r1.getContext()     // Catch:{ Exception -> 0x0544 }
            int r3 = com.travel.bus.R.drawable.travel_res_bus_order_summary_idle_state     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)     // Catch:{ Exception -> 0x0544 }
            android.view.View r3 = r9.itemView     // Catch:{ Exception -> 0x0544 }
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0544 }
            int r4 = com.travel.bus.R.drawable.travel_res_bus_order_summary_idle_state     // Catch:{ Exception -> 0x0544 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)     // Catch:{ Exception -> 0x0544 }
            int r4 = com.travel.bus.R.string.recharge_payment_pending     // Catch:{ Exception -> 0x0544 }
            int r5 = com.travel.bus.R.string.bus_order_summary_confirming_booking     // Catch:{ Exception -> 0x0544 }
            int r6 = com.travel.bus.R.string.ticket_sent_on_email_or_sms     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r7 = r9.f22774i     // Catch:{ Exception -> 0x0544 }
            int r8 = com.travel.bus.R.string.awaiting_payment_confirmation_from_bank     // Catch:{ Exception -> 0x0544 }
            r7.setText(r8)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r7 = r9.j     // Catch:{ Exception -> 0x0544 }
            r7.setImageDrawable(r10)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.k     // Catch:{ Exception -> 0x0544 }
            r10.setImageDrawable(r1)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.k     // Catch:{ Exception -> 0x0544 }
            r10.setScaleX(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.k     // Catch:{ Exception -> 0x0544 }
            r10.setScaleY(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.l     // Catch:{ Exception -> 0x0544 }
            r10.setScaleX(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.l     // Catch:{ Exception -> 0x0544 }
            r10.setScaleY(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.l     // Catch:{ Exception -> 0x0544 }
            r10.setImageDrawable(r3)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.m     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.color.color_f4f4f4     // Catch:{ Exception -> 0x0544 }
            int r0 = androidx.core.content.b.c(r0, r1)     // Catch:{ Exception -> 0x0544 }
            r10.setBackgroundColor(r0)     // Catch:{ Exception -> 0x0544 }
            android.view.View r10 = r9.n     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.color.color_f4f4f4     // Catch:{ Exception -> 0x0544 }
            int r0 = androidx.core.content.b.c(r0, r1)     // Catch:{ Exception -> 0x0544 }
            r10.setBackgroundColor(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.o     // Catch:{ Exception -> 0x0544 }
            r10.setText(r4)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.p     // Catch:{ Exception -> 0x0544 }
            r10.setText(r5)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.q     // Catch:{ Exception -> 0x0544 }
            r10.setText(r6)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.u     // Catch:{ Exception -> 0x0544 }
            if (r10 == 0) goto L_0x0410
            android.widget.TextView r10 = r9.u     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
        L_0x0410:
            com.travel.bus.orders.activity.BusOrderSummary$a r10 = r9.y     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.activity.BusOrderSummary$a r0 = com.travel.bus.orders.activity.BusOrderSummary.a.BUS     // Catch:{ Exception -> 0x0544 }
            if (r10 != r0) goto L_0x041b
            android.widget.TextView r10 = r9.t     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
        L_0x041b:
            return
        L_0x041c:
            android.widget.RelativeLayout r10 = r9.f22769d     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.LinearLayout r10 = r9.f22773h     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            r9.b()     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.f22770e     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r0 = r9.f22770e     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0544 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0544 }
            int r1 = com.travel.bus.R.drawable.travel_res_bus_ic_failed     // Catch:{ Exception -> 0x0544 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r1)     // Catch:{ Exception -> 0x0544 }
            r10.setImageBitmap(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.f22771f     // Catch:{ Exception -> 0x0544 }
            int r0 = com.travel.bus.R.string.recharge_status_failed     // Catch:{ Exception -> 0x0544 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.activity.BusOrderSummary$a r10 = r9.y     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.activity.BusOrderSummary$a r0 = com.travel.bus.orders.activity.BusOrderSummary.a.BUS     // Catch:{ Exception -> 0x0544 }
            if (r10 != r0) goto L_0x0467
            android.widget.TextView r10 = r9.r     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.s     // Catch:{ Exception -> 0x0544 }
            int r0 = com.travel.bus.R.string.retry_booking     // Catch:{ Exception -> 0x0544 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.s     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.f22772g     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r9.f22767b     // Catch:{ Exception -> 0x0544 }
            java.lang.String r0 = r0.getPaymentText()     // Catch:{ Exception -> 0x0544 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0544 }
        L_0x0467:
            return
        L_0x0468:
            android.widget.RelativeLayout r10 = r9.f22769d     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r3)     // Catch:{ Exception -> 0x0544 }
            android.widget.LinearLayout r10 = r9.f22773h     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
            r9.b()     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r10 = r9.f22770e     // Catch:{ Exception -> 0x0544 }
            android.widget.ImageView r0 = r9.f22770e     // Catch:{ Exception -> 0x0544 }
            android.content.Context r0 = r0.getContext()     // Catch:{ Exception -> 0x0544 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0544 }
            int r4 = com.travel.bus.R.drawable.travel_res_bus_success     // Catch:{ Exception -> 0x0544 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r4)     // Catch:{ Exception -> 0x0544 }
            r10.setImageBitmap(r0)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.f22771f     // Catch:{ Exception -> 0x0544 }
            int r0 = com.travel.bus.R.string.booking_confirmed     // Catch:{ Exception -> 0x0544 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.activity.BusOrderSummary$a r10 = r9.y     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.orders.activity.BusOrderSummary$a r0 = com.travel.bus.orders.activity.BusOrderSummary.a.BUS     // Catch:{ Exception -> 0x0544 }
            if (r10 != r0) goto L_0x0543
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b     // Catch:{ Exception -> 0x0544 }
            java.util.ArrayList r10 = r10.getOrderedCartList()     // Catch:{ Exception -> 0x0544 }
            if (r10 == 0) goto L_0x0543
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b     // Catch:{ Exception -> 0x0544 }
            java.util.ArrayList r10 = r10.getOrderedCartList()     // Catch:{ Exception -> 0x0544 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x0544 }
            if (r10 <= 0) goto L_0x0543
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r10 = r9.f22767b     // Catch:{ Exception -> 0x0544 }
            java.util.ArrayList r10 = r10.getOrderedCartList()     // Catch:{ Exception -> 0x0544 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0544 }
        L_0x04b5:
            boolean r0 = r10.hasNext()     // Catch:{ Exception -> 0x0544 }
            if (r0 == 0) goto L_0x04c8
            java.lang.Object r0 = r10.next()     // Catch:{ Exception -> 0x0544 }
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r0 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r0     // Catch:{ Exception -> 0x0544 }
            boolean r4 = com.travel.bus.orders.h.b.b(r0)     // Catch:{ Exception -> 0x0544 }
            if (r4 == 0) goto L_0x04b5
            goto L_0x04c9
        L_0x04c8:
            r0 = r6
        L_0x04c9:
            if (r0 == 0) goto L_0x04e1
            java.lang.Object r10 = r0.getMetaDataResponse()     // Catch:{ Exception -> 0x0544 }
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0544 }
            r0.<init>()     // Catch:{ Exception -> 0x0544 }
            java.lang.String r10 = r0.a((java.lang.Object) r10)     // Catch:{ Exception -> 0x0544 }
            java.lang.Class<com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse> r4 = com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse.class
            java.lang.Object r10 = r0.a((java.lang.String) r10, r4)     // Catch:{ Exception -> 0x0544 }
            r6 = r10
            com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse r6 = (com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse) r6     // Catch:{ Exception -> 0x0544 }
        L_0x04e1:
            java.util.ArrayList r10 = r6.getPassengerData()     // Catch:{ Exception -> 0x0544 }
            java.lang.Object r10 = r10.get(r3)     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.pojo.busticket.CJRBusPassengerData r10 = (com.travel.bus.pojo.busticket.CJRBusPassengerData) r10     // Catch:{ Exception -> 0x0544 }
            java.lang.String r10 = r10.getEmail()     // Catch:{ Exception -> 0x0544 }
            java.util.ArrayList r0 = r6.getPassengerData()     // Catch:{ Exception -> 0x0544 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0544 }
            com.travel.bus.pojo.busticket.CJRBusPassengerData r0 = (com.travel.bus.pojo.busticket.CJRBusPassengerData) r0     // Catch:{ Exception -> 0x0544 }
            java.lang.String r0 = r0.getMobileNumber()     // Catch:{ Exception -> 0x0544 }
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0544 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0544 }
            boolean r5 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0544 }
            if (r5 != 0) goto L_0x053e
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0544 }
            if (r0 != 0) goto L_0x053e
            android.widget.TextView r0 = r9.f22772g     // Catch:{ Exception -> 0x0544 }
            android.content.Context r2 = r9.f22766a     // Catch:{ Exception -> 0x0544 }
            int r5 = com.travel.bus.R.string.bus_order_confirmation_message     // Catch:{ Exception -> 0x0544 }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0544 }
            r6[r3] = r10     // Catch:{ Exception -> 0x0544 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0544 }
            r10.<init>()     // Catch:{ Exception -> 0x0544 }
            long r3 = r4.longValue()     // Catch:{ Exception -> 0x0544 }
            r10.append(r3)     // Catch:{ Exception -> 0x0544 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0544 }
            r6[r1] = r10     // Catch:{ Exception -> 0x0544 }
            java.lang.String r10 = r2.getString(r5, r6)     // Catch:{ Exception -> 0x0544 }
            r0.setText(r10)     // Catch:{ Exception -> 0x0544 }
            android.widget.TextView r10 = r9.f22772g     // Catch:{ Exception -> 0x0544 }
            java.lang.String r0 = "#666666"
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ Exception -> 0x0544 }
            r10.setTextColor(r0)     // Catch:{ Exception -> 0x0544 }
            return
        L_0x053e:
            android.widget.TextView r10 = r9.f22772g     // Catch:{ Exception -> 0x0544 }
            r10.setVisibility(r2)     // Catch:{ Exception -> 0x0544 }
        L_0x0543:
            return
        L_0x0544:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.c(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.n.a(com.travel.bus.orders.c.c$b):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r10 = this;
            android.widget.TextView r0 = r10.r
            r1 = 8
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r10.f22769d
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r10.f22773h
            r2 = 0
            r0.setVisibility(r2)
            android.view.View r0 = r10.itemView
            android.content.Context r0 = r0.getContext()
            int r3 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_success
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r3)
            android.view.View r3 = r10.itemView
            android.content.Context r3 = r3.getContext()
            int r4 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_success
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            android.view.View r4 = r10.itemView
            android.content.Context r4 = r4.getContext()
            int r5 = com.travel.bus.R.drawable.travel_res_bus_order_summary_payment_success
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            int r5 = com.travel.bus.R.string.payment_confirmed
            int r6 = com.travel.bus.R.string.booking_confirmed
            int r7 = com.travel.bus.R.string.ticket_sent_on_email_or_sms
            android.widget.TextView r8 = r10.f22774i
            int r9 = com.travel.bus.R.string.booking_confirmation_text_flight_title
            r8.setText(r9)
            android.widget.ImageView r8 = r10.j
            r8.setImageDrawable(r0)
            android.widget.ImageView r0 = r10.k
            r0.setImageDrawable(r3)
            android.widget.ImageView r0 = r10.l
            r0.setImageDrawable(r4)
            android.widget.TextView r0 = r10.o
            r0.setText(r5)
            android.widget.TextView r0 = r10.p
            r0.setText(r6)
            android.widget.TextView r0 = r10.q
            r0.setText(r7)
            android.view.View r0 = r10.m
            android.content.Context r3 = r10.f22766a
            int r4 = com.travel.bus.R.color.green_train
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setBackgroundColor(r3)
            android.view.View r0 = r10.n
            android.content.Context r3 = r10.f22766a
            int r4 = com.travel.bus.R.color.green_train
            int r3 = androidx.core.content.b.c(r3, r4)
            r0.setBackgroundColor(r3)
            android.widget.TextView r0 = r10.t
            r0.setVisibility(r1)
            android.widget.TextView r0 = r10.u
            if (r0 == 0) goto L_0x0087
            r0.setVisibility(r1)
        L_0x0087:
            com.travel.bus.orders.activity.BusOrderSummary$a r0 = r10.y
            com.travel.bus.orders.activity.BusOrderSummary$a r1 = com.travel.bus.orders.activity.BusOrderSummary.a.BUS
            if (r0 != r1) goto L_0x0115
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r10.f22767b
            java.util.ArrayList r0 = r0.getOrderedCartList()
            if (r0 == 0) goto L_0x0115
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r10.f22767b
            java.util.ArrayList r0 = r0.getOrderedCartList()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0115
            com.travel.bus.pojo.busticket.CJRBusOrderSummary r0 = r10.f22767b
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ab:
            boolean r1 = r0.hasNext()
            r3 = 0
            if (r1 == 0) goto L_0x00bf
            java.lang.Object r1 = r0.next()
            net.one97.paytm.common.entity.busticket.CJRBusOrderedCart r1 = (net.one97.paytm.common.entity.busticket.CJRBusOrderedCart) r1
            boolean r4 = com.travel.bus.orders.h.b.b(r1)
            if (r4 == 0) goto L_0x00ab
            goto L_0x00c0
        L_0x00bf:
            r1 = r3
        L_0x00c0:
            if (r1 == 0) goto L_0x00d8
            java.lang.Object r0 = r1.getMetaDataResponse()
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f
            r1.<init>()
            java.lang.String r0 = r1.a((java.lang.Object) r0)
            java.lang.Class<com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse> r3 = com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse.class
            java.lang.Object r0 = r1.a((java.lang.String) r0, r3)
            r3 = r0
            com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse r3 = (com.travel.bus.pojo.busticket.CJRBusOrderSummaryMetaDataResponse) r3
        L_0x00d8:
            java.util.ArrayList r0 = r3.getPassengerData()
            java.lang.Object r0 = r0.get(r2)
            com.travel.bus.pojo.busticket.CJRBusPassengerData r0 = (com.travel.bus.pojo.busticket.CJRBusPassengerData) r0
            java.lang.String r0 = r0.getEmail()
            java.util.ArrayList r1 = r3.getPassengerData()
            java.lang.Object r1 = r1.get(r2)
            com.travel.bus.pojo.busticket.CJRBusPassengerData r1 = (com.travel.bus.pojo.busticket.CJRBusPassengerData) r1
            java.lang.String r1 = r1.getMobileNumber()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0115
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0115
            android.widget.TextView r3 = r10.f22774i
            android.content.Context r4 = r10.f22766a
            int r5 = com.travel.bus.R.string.bus_order_confirmation_message
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r0
            r0 = 1
            r6[r0] = r1
            java.lang.String r0 = r4.getString(r5, r6)
            r3.setText(r0)
        L_0x0115:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.n.a():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                n.this.d();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        float rotation = this.k.getRotation() + 30.0f;
        if (rotation == 360.0f) {
            rotation = 0.0f;
        }
        this.k.setRotation(rotation);
    }

    private void b() {
        RelativeLayout relativeLayout;
        if (TextUtils.isEmpty(this.x) && (relativeLayout = this.f22769d) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.setMargins(0, b.a(20.0f, this.f22766a), 0, b.a(14.0f, this.f22766a));
            this.f22769d.setLayoutParams(layoutParams);
            this.f22769d.requestLayout();
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.retry1 || id == R.id.retry) {
            String id2 = this.f22767b.getId();
            com.travel.bus.a.a();
            if (!TextUtils.isEmpty(com.travel.bus.b.a.a(com.travel.bus.a.b().D()).b("sso_token=", "", true))) {
                StringBuilder sb = new StringBuilder();
                com.travel.bus.a.a();
                sb.append(com.travel.bus.a.b().f("orderdetail"));
                sb.append(id2);
                sb.append("?actions=1");
                String sb2 = sb.toString();
                if (b.c(this.f22766a)) {
                    HashMap<String, String> a2 = b.a((HashMap<String, String>) new HashMap(), this.f22766a);
                    AnonymousClass1 r1 = new com.paytm.network.listener.b() {
                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r6) {
                            /*
                                r5 = this;
                                boolean r0 = r6 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
                                if (r0 == 0) goto L_0x00aa
                                net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r6
                                com.travel.bus.orders.i.n r0 = com.travel.bus.orders.i.n.this
                                java.util.ArrayList r6 = r6.getOrderedCartList()     // Catch:{ Exception -> 0x00a2 }
                                r1 = 0
                                java.lang.Object r6 = r6.get(r1)     // Catch:{ Exception -> 0x00a2 }
                                net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6     // Catch:{ Exception -> 0x00a2 }
                                r6.getRechargeConfiguration()     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r1 = ""
                                r2 = 0
                                if (r6 == 0) goto L_0x0045
                                java.lang.Object r3 = r6.mMetaDataResponse     // Catch:{ Exception -> 0x00a2 }
                                if (r3 == 0) goto L_0x0045
                                java.lang.Object r3 = r6.mMetaDataResponse     // Catch:{ Exception -> 0x00a2 }
                                boolean r3 = r3 instanceof com.google.gsonhtcfix.b.g     // Catch:{ Exception -> 0x00a2 }
                                if (r3 == 0) goto L_0x0045
                                java.lang.Object r6 = r6.mMetaDataResponse     // Catch:{ Exception -> 0x00a2 }
                                com.google.gsonhtcfix.b.g r6 = (com.google.gsonhtcfix.b.g) r6     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r1 = "source"
                                java.lang.Object r1 = r6.get(r1)     // Catch:{ Exception -> 0x00a2 }
                                r2 = r1
                                java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r1 = "destination"
                                java.lang.Object r1 = r6.get(r1)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r3 = "travel_date"
                                java.lang.Object r6 = r6.get(r3)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00a2 }
                                goto L_0x0047
                            L_0x0045:
                                r6 = r1
                                r1 = r2
                            L_0x0047:
                                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r4 = "paytmmp://bus-search?source_city_name="
                                r3.<init>(r4)     // Catch:{ Exception -> 0x00a2 }
                                r3.append(r2)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r4 = "&source_city_short_name="
                                r3.append(r4)     // Catch:{ Exception -> 0x00a2 }
                                r3.append(r2)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r4 = "&destination_city_name="
                                r3.append(r4)     // Catch:{ Exception -> 0x00a2 }
                                r3.append(r1)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r4 = "&destination_city_short_name="
                                r3.append(r4)     // Catch:{ Exception -> 0x00a2 }
                                r3.append(r1)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r4 = "&date="
                                r3.append(r4)     // Catch:{ Exception -> 0x00a2 }
                                r3.append(r6)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a2 }
                                android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00a2 }
                                android.net.Uri$Builder r3 = r3.buildUpon()     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r4 = "source_city_name"
                                r3.appendQueryParameter(r4, r2)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r2 = "destination_city_name"
                                r3.appendQueryParameter(r2, r1)     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r1 = "date"
                                r3.appendQueryParameter(r1, r6)     // Catch:{ Exception -> 0x00a2 }
                                android.net.Uri r6 = r3.build()     // Catch:{ Exception -> 0x00a2 }
                                java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00a2 }
                                com.travel.bus.a.a()     // Catch:{ Exception -> 0x00a2 }
                                com.travel.g.a r1 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x00a2 }
                                android.content.Context r0 = r0.f22766a     // Catch:{ Exception -> 0x00a2 }
                                r1.b((java.lang.String) r6, (android.content.Context) r0)     // Catch:{ Exception -> 0x00a2 }
                                return
                            L_0x00a2:
                                r6 = move-exception
                                java.lang.String r6 = r6.getMessage()
                                com.paytm.utility.q.c(r6)
                            L_0x00aa:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.i.n.AnonymousClass1.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
                        }
                    };
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this.f22766a;
                    bVar.f42885i = new CJROrderSummary();
                    bVar.o = "MyBooking";
                    bVar.f42880d = sb2;
                    bVar.f42878b = a.c.BUS;
                    bVar.f42882f = a2;
                    bVar.n = a.b.SILENT;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.j = r1;
                    bVar.l().a();
                }
            }
        }
    }
}
