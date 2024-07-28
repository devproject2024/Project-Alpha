package net.one97.paytm.recharge.metro.d;

import android.view.View;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.recharge.metro.d.p;

public class l extends p {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(View view, p.b bVar) {
        super(view, bVar);
        k.c(view, "itemView");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x018d, code lost:
        if (net.one97.paytm.recharge.metro.f.c.a.c(r13) != false) goto L_0x018f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r12, java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r13) {
        /*
            r11 = this;
            java.lang.String r0 = "ticketAndPass"
            kotlin.g.b.k.c(r13, r0)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r13.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r1.next()
            r3 = r2
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3
            boolean r3 = r3.isPass()
            if (r3 == 0) goto L_0x0012
            r0.add(r2)
            goto L_0x0012
        L_0x0029:
            java.util.List r0 = (java.util.List) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0032
            return
        L_0x0032:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r13.iterator()
        L_0x003d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0054
            java.lang.Object r2 = r1.next()
            r3 = r2
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3
            boolean r3 = r3.isPass()
            if (r3 == 0) goto L_0x003d
            r0.add(r2)
            goto L_0x003d
        L_0x0054:
            java.util.List r0 = (java.util.List) r0
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r0 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r0
            android.widget.TextView r2 = r11.f63521a
            net.one97.paytm.recharge.metro.f.c$a r3 = net.one97.paytm.recharge.metro.f.c.f63576a
            android.view.View r3 = r11.itemView
            java.lang.String r4 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r5 = r3.getContext()
            java.lang.String r3 = "itemView.context"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            java.lang.String r6 = r0.getProductType()
            java.lang.String r7 = r0.getSource()
            java.lang.String r8 = r0.getDestination()
            java.lang.String r9 = r0.getBalanceAmount()
            r10 = 0
            android.text.SpannableString r3 = net.one97.paytm.recharge.metro.f.c.a.a(r5, r6, r7, r8, r9, r10)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r11.f63522b
            java.lang.String r3 = r0.getExpiryTime()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            android.widget.TextView r2 = r11.f63524d
            android.view.View r3 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.content.Context r3 = r3.getContext()
            int r5 = net.one97.paytm.recharge.R.string.metro_count_journey_trip
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            int r8 = r0.getBalanceTrip_2()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7[r1] = r8
            java.lang.String r3 = r3.getString(r5, r7)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r13 = r13.iterator()
        L_0x00c4:
            boolean r3 = r13.hasNext()
            if (r3 == 0) goto L_0x00e0
            java.lang.Object r3 = r13.next()
            r5 = r3
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            java.util.List r5 = r5.getQrCodes()
            if (r5 == 0) goto L_0x00d9
            r5 = 1
            goto L_0x00da
        L_0x00d9:
            r5 = 0
        L_0x00da:
            if (r5 == 0) goto L_0x00c4
            r2.add(r3)
            goto L_0x00c4
        L_0x00e0:
            java.util.List r2 = (java.util.List) r2
            r13 = r2
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
            r3 = 0
        L_0x00ea:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x0137
            java.lang.Object r5 = r13.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            int r7 = r0.getBalanceTrip_2()
            r5.setBalanceTrip_2(r7)
            java.lang.String r7 = r0.getProductType()
            r5.setProductType(r7)
            java.util.List r7 = r5.getQrCodes()
            if (r7 == 0) goto L_0x010d
            r7.size()
        L_0x010d:
            java.util.List r5 = r5.getQrCodes()
            if (r5 == 0) goto L_0x00ea
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0119:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00ea
            java.lang.Object r7 = r5.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r7
            if (r3 != 0) goto L_0x0119
            java.lang.String r3 = "qr"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            java.lang.String r3 = r7.getStatus()
            java.lang.String r7 = "ACTIVE"
            boolean r3 = r7.equals(r3)
            goto L_0x0119
        L_0x0137:
            if (r3 == 0) goto L_0x0168
            android.widget.TextView r13 = r11.f63523c
            android.view.View r0 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r0 = r0.getContext()
            int r1 = net.one97.paytm.recharge.R.string.metro_view_tickets
            java.lang.String r0 = r0.getString(r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setText(r0)
            android.widget.TextView r13 = r11.f63523c
            net.one97.paytm.recharge.metro.d.l$a r0 = new net.one97.paytm.recharge.metro.d.l$a
            r0.<init>(r11, r12, r2)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
            android.view.View r13 = r11.itemView
            net.one97.paytm.recharge.metro.d.l$b r0 = new net.one97.paytm.recharge.metro.d.l$b
            r0.<init>(r11, r12, r2)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r13.setOnClickListener(r0)
            return
        L_0x0168:
            android.view.View r13 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            r13.setClickable(r1)
            android.view.View r13 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            r13.setEnabled(r1)
            int r13 = r0.getBalanceTrip_2()
            if (r13 == 0) goto L_0x018f
            net.one97.paytm.recharge.metro.f.c$a r13 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r13 = r0.getExpiryDate()
            java.lang.String r2 = "pass.expiryDate"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)
            boolean r13 = net.one97.paytm.recharge.metro.f.c.a.c((java.lang.String) r13)
            if (r13 == 0) goto L_0x0190
        L_0x018f:
            r1 = 1
        L_0x0190:
            if (r1 == 0) goto L_0x01bd
            android.widget.TextView r12 = r11.f63523c
            android.view.View r13 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            android.content.Context r13 = r13.getContext()
            int r0 = net.one97.paytm.recharge.R.string.metro_pass_expired_text
            java.lang.String r13 = r13.getString(r0)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setText(r13)
            android.widget.TextView r12 = r11.f63523c
            android.view.View r13 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
            android.content.Context r13 = r13.getContext()
            int r0 = net.one97.paytm.recharge.R.color.color_bmtc_ff4b55
            int r13 = r13.getColor(r0)
            r12.setTextColor(r13)
            return
        L_0x01bd:
            int r13 = r0.getBalanceTrip_2()
            if (r13 < 0) goto L_0x01e6
            android.widget.TextView r13 = r11.f63523c
            android.view.View r1 = r11.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.R.string.metro_generate_tickets
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.setText(r1)
            android.widget.TextView r13 = r11.f63523c
            net.one97.paytm.recharge.metro.d.l$c r1 = new net.one97.paytm.recharge.metro.d.l$c
            r1.<init>(r11, r12, r0)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r13.setOnClickListener(r1)
            return
        L_0x01e6:
            android.widget.TextView r12 = r11.f63523c
            r13 = 8
            r12.setVisibility(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.d.l.a(net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail, java.util.List):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f63508a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63509b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f63510c;

        a(l lVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List list) {
            this.f63508a = lVar;
            this.f63509b = cJROrderSummaryProductDetail;
            this.f63510c = list;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63508a.f63526f;
            if (bVar != null) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = this.f63509b;
                if (cJROrderSummaryProductDetail == null) {
                    k.a();
                }
                bVar.a(cJROrderSummaryProductDetail, this.f63510c, true);
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f63511a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63512b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f63513c;

        b(l lVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List list) {
            this.f63511a = lVar;
            this.f63512b = cJROrderSummaryProductDetail;
            this.f63513c = list;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63511a.f63526f;
            if (bVar != null) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = this.f63512b;
                if (cJROrderSummaryProductDetail == null) {
                    k.a();
                }
                bVar.a(cJROrderSummaryProductDetail, this.f63513c, true);
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f63514a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63515b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRActiveMetroTicketModel f63516c;

        c(l lVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, CJRActiveMetroTicketModel cJRActiveMetroTicketModel) {
            this.f63514a = lVar;
            this.f63515b = cJROrderSummaryProductDetail;
            this.f63516c = cJRActiveMetroTicketModel;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63514a.f63526f;
            if (bVar != null) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = this.f63515b;
                if (cJROrderSummaryProductDetail == null) {
                    k.a();
                }
                bVar.b(cJROrderSummaryProductDetail, this.f63516c);
            }
        }
    }
}
