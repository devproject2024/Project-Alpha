package net.one97.paytm.recharge.metro.d;

import android.view.View;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.recharge.metro.d.p;

public final class g extends p {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, p.b bVar) {
        super(view, bVar);
        k.c(view, "itemView");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r14, java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r15) {
        /*
            r13 = this;
            java.lang.String r0 = "tickets"
            kotlin.g.b.k.c(r15, r0)
            r0 = r15
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = kotlin.a.k.a(r0)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r0.iterator()
        L_0x0018:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r2.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3
            java.lang.String r3 = r3.getType()
            r1.add(r3)
            goto L_0x0018
        L_0x002c:
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r0 = r0.iterator()
        L_0x0039:
            boolean r3 = r0.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x0094
            java.lang.Object r3 = r0.next()
            r5 = r3
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            java.lang.String r5 = r5.getType()
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.OUTWARD
            java.lang.String r6 = r6.getValue()
            boolean r6 = r1.contains(r6)
            if (r6 == 0) goto L_0x005e
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.OUTWARD
            java.lang.String r6 = r6.getValue()
            goto L_0x008a
        L_0x005e:
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.RETURN
            java.lang.String r6 = r6.getValue()
            boolean r6 = r1.contains(r6)
            if (r6 == 0) goto L_0x0071
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.RETURN
            java.lang.String r6 = r6.getValue()
            goto L_0x008a
        L_0x0071:
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.PENALTY
            java.lang.String r6 = r6.getValue()
            boolean r6 = r1.contains(r6)
            if (r6 == 0) goto L_0x0084
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.PENALTY
            java.lang.String r6 = r6.getValue()
            goto L_0x008a
        L_0x0084:
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.NONE
            java.lang.String r6 = r6.getValue()
        L_0x008a:
            boolean r4 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r4)
            if (r4 == 0) goto L_0x0039
            r2.add(r3)
            goto L_0x0039
        L_0x0094:
            java.util.List r2 = (java.util.List) r2
            r0 = 0
            java.lang.Object r3 = r15.get(r0)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r4
            if (r5 == 0) goto L_0x00ae
            java.lang.Object r2 = r2.get(r0)
            r3 = r2
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3
        L_0x00ae:
            android.widget.TextView r2 = r13.f63521a
            net.one97.paytm.recharge.metro.f.c$a r5 = net.one97.paytm.recharge.metro.f.c.f63576a
            android.view.View r5 = r13.itemView
            java.lang.String r6 = "itemView"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.content.Context r7 = r5.getContext()
            java.lang.String r5 = "itemView.context"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.OUTWARD
            java.lang.String r8 = r5.getValue()
            java.lang.String r9 = r3.getSource()
            java.lang.String r10 = r3.getDestination()
            r12 = 0
            java.lang.String r11 = ""
            android.text.SpannableString r5 = net.one97.paytm.recharge.metro.f.c.a.a(r7, r8, r9, r10, r11, r12)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            java.lang.String r2 = r3.getValid()
            java.util.List r5 = r3.getQrCodes()     // Catch:{ Exception -> 0x00f4 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r7 = "currentActiveTicket.qrCodes[0]"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x00f4 }
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r5     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r2 = r5.getExpiry()     // Catch:{ Exception -> 0x00f4 }
            goto L_0x00f5
        L_0x00f4:
        L_0x00f5:
            android.widget.TextView r5 = r13.f63522b
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            android.widget.TextView r2 = r13.f63525e
            java.lang.String r5 = r3.getType()
            java.lang.String r7 = "PENALTY"
            boolean r5 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r5, (boolean) r4)
            if (r5 == 0) goto L_0x010c
            r5 = 0
            goto L_0x010e
        L_0x010c:
            r5 = 8
        L_0x010e:
            r2.setVisibility(r5)
            net.one97.paytm.recharge.metro.f.c$e r2 = net.one97.paytm.recharge.metro.f.c.e.RETURN
            java.lang.String r2 = r2.getValue()
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x012d
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.R.string.metro_ticket_type_rjt
            java.lang.String r1 = r1.getString(r2)
            goto L_0x013c
        L_0x012d:
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.R.string.metro_ticket_type_sjt
            java.lang.String r1 = r1.getString(r2)
        L_0x013c:
            java.lang.String r2 = "if (ticketTypeList.conta…pe_sjt)\n                }"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.util.List r2 = r3.getQrCodes()
            if (r2 == 0) goto L_0x014c
            int r2 = r2.size()
            goto L_0x014d
        L_0x014c:
            r2 = 0
        L_0x014d:
            android.widget.TextView r3 = r13.f63524d
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.CharSequence"
            java.lang.String r7 = "itemView.context.getStri…g() else \"\"), ticketType)"
            java.lang.String r8 = ""
            r9 = 2
            if (r2 <= r4) goto L_0x018b
            android.view.View r10 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r6)
            android.content.Context r10 = r10.getContext()
            int r11 = net.one97.paytm.recharge.R.string.metro_count_journey_tickets
            java.lang.Object[] r9 = new java.lang.Object[r9]
            if (r2 == 0) goto L_0x016b
            java.lang.String r8 = java.lang.String.valueOf(r2)
        L_0x016b:
            r9[r0] = r8
            r9[r4] = r1
            java.lang.String r0 = r10.getString(r11, r9)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            if (r0 == 0) goto L_0x0185
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x01b7
        L_0x0185:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r5)
            throw r14
        L_0x018b:
            android.view.View r10 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r6)
            android.content.Context r10 = r10.getContext()
            int r11 = net.one97.paytm.recharge.R.string.metro_count_journey_ticket
            java.lang.Object[] r9 = new java.lang.Object[r9]
            if (r2 == 0) goto L_0x019e
            java.lang.String r8 = java.lang.String.valueOf(r2)
        L_0x019e:
            r9[r0] = r8
            r9[r4] = r1
            java.lang.String r0 = r10.getString(r11, r9)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
            if (r0 == 0) goto L_0x01f5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x01b7:
            r3.setText(r0)
            android.widget.TextView r0 = r13.f63523c
            int r1 = r15.size()
            if (r1 <= r4) goto L_0x01d4
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.R.string.metro_view_all_tickets
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x01e5
        L_0x01d4:
            android.view.View r1 = r13.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            android.content.Context r1 = r1.getContext()
            int r2 = net.one97.paytm.recharge.R.string.metro_view_tickets
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x01e5:
            r0.setText(r1)
            android.view.View r0 = r13.itemView
            net.one97.paytm.recharge.metro.d.g$a r1 = new net.one97.paytm.recharge.metro.d.g$a
            r1.<init>(r13, r14, r15)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            return
        L_0x01f5:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r5)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.d.g.a(net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail, java.util.List):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f63482a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryProductDetail f63483b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f63484c;

        a(g gVar, CJROrderSummaryProductDetail cJROrderSummaryProductDetail, List list) {
            this.f63482a = gVar;
            this.f63483b = cJROrderSummaryProductDetail;
            this.f63484c = list;
        }

        public final void onClick(View view) {
            p.b bVar = this.f63482a.f63526f;
            if (bVar != null) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = this.f63483b;
                if (cJROrderSummaryProductDetail == null) {
                    k.a();
                }
                bVar.a(cJROrderSummaryProductDetail, this.f63484c, false);
            }
        }
    }
}
