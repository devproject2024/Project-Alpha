package net.one97.paytm.recharge.metro.d;

import android.view.View;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.recharge.metro.d.d;
import net.one97.paytm.recharge.metro.f.c;

public final class c extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, d.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.List} */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r13, java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r14, android.content.Context r15) {
        /*
            r12 = this;
            java.lang.String r0 = "variant"
            kotlin.g.b.k.c(r13, r0)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r15, r0)
            r0 = 0
            if (r14 == 0) goto L_0x0037
            r1 = r14
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x001c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r1.next()
            r4 = r3
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r4
            boolean r4 = r4.isPass()
            if (r4 == 0) goto L_0x001c
            r2.add(r3)
            goto L_0x001c
        L_0x0033:
            r1 = r2
            java.util.List r1 = (java.util.List) r1
            goto L_0x0038
        L_0x0037:
            r1 = r0
        L_0x0038:
            r2 = 1
            r3 = 0
            if (r14 == 0) goto L_0x006a
            r4 = r14
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x004a:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0066
            java.lang.Object r6 = r4.next()
            r7 = r6
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
            java.util.List r7 = r7.getQrCodes()
            if (r7 == 0) goto L_0x005f
            r7 = 1
            goto L_0x0060
        L_0x005f:
            r7 = 0
        L_0x0060:
            if (r7 == 0) goto L_0x004a
            r5.add(r6)
            goto L_0x004a
        L_0x0066:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
            goto L_0x006b
        L_0x006a:
            r4 = r0
        L_0x006b:
            boolean r5 = a(r4)
            if (r5 == 0) goto L_0x0083
            android.view.View r6 = r12.itemView
            int r7 = net.one97.paytm.recharge.R.id.penalty_text
            android.view.View r6 = r6.findViewById(r7)
            java.lang.String r7 = "itemView.findViewById<TextView>(R.id.penalty_text)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r6.setVisibility(r3)
        L_0x0083:
            int r6 = net.one97.paytm.recharge.R.drawable.left_right_curved_orange
            android.graphics.drawable.Drawable r15 = androidx.core.content.b.a((android.content.Context) r15, (int) r6)
            if (r15 == 0) goto L_0x029a
            android.graphics.drawable.GradientDrawable r15 = (android.graphics.drawable.GradientDrawable) r15
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r6 = r13.getProduct()
            if (r6 == 0) goto L_0x00b8
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r6 = r6.getAttributes()
            if (r6 == 0) goto L_0x00b8
            java.lang.String r6 = r6.getColorCode()
            if (r6 == 0) goto L_0x00b8
            int r6 = android.graphics.Color.parseColor(r6)
            r15.setColor(r6)
            android.view.View r6 = r12.itemView
            int r7 = net.one97.paytm.recharge.R.id.orange_background_view
            android.view.View r6 = r6.findViewById(r7)
            java.lang.String r7 = "itemView.findViewById<Vi…d.orange_background_view)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.graphics.drawable.Drawable r15 = (android.graphics.drawable.Drawable) r15
            r6.setBackground(r15)
        L_0x00b8:
            if (r1 == 0) goto L_0x00eb
            r15 = r1
            java.util.Collection r15 = (java.util.Collection) r15
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r2
            if (r15 != r2) goto L_0x00eb
            java.lang.Object r15 = r1.get(r3)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r15 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r15
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x00d0:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x00ec
            java.lang.Object r1 = r14.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r1 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r1
            int r6 = r15.getBalanceTrip_2()
            r1.setBalanceTrip_2(r6)
            java.lang.String r6 = r15.getProductType()
            r1.setProductType(r6)
            goto L_0x00d0
        L_0x00eb:
            r15 = r0
        L_0x00ec:
            java.lang.String r14 = "itemView.validity"
            java.lang.String r1 = "itemView"
            if (r15 == 0) goto L_0x0208
            java.lang.String r6 = "itemView.destination"
            java.lang.String r7 = "itemView.source"
            if (r4 == 0) goto L_0x013d
            int r8 = r4.size()
            if (r8 <= 0) goto L_0x013d
            android.view.View r8 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            int r9 = net.one97.paytm.recharge.R.id.source
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            java.lang.Object r7 = r4.get(r3)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
            java.lang.String r7 = r7.getSource()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8.setText(r7)
            android.view.View r7 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            int r8 = net.one97.paytm.recharge.R.id.destination
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            java.lang.Object r6 = r4.get(r3)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r6
            java.lang.String r6 = r6.getDestination()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
            goto L_0x016f
        L_0x013d:
            android.view.View r8 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
            int r9 = net.one97.paytm.recharge.R.id.source
            android.view.View r8 = r8.findViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r7)
            java.lang.String r7 = r15.getSource()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8.setText(r7)
            android.view.View r7 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            int r8 = net.one97.paytm.recharge.R.id.destination
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r6)
            java.lang.String r6 = r15.getDestination()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7.setText(r6)
        L_0x016f:
            int r6 = r15.getBalanceTrip_2()
            android.view.View r7 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            int r8 = net.one97.paytm.recharge.R.id.tripsLeft
            android.view.View r7 = r7.findViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            java.lang.String r8 = "itemView.tripsLeft"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r8 = java.lang.String.valueOf(r6)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            java.lang.String r7 = "itemView.tripsLeftLabel"
            if (r6 <= r2) goto L_0x01b7
            android.view.View r6 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            int r8 = net.one97.paytm.recharge.R.id.tripsLeftLabel
            android.view.View r6 = r6.findViewById(r8)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.view.View r7 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            android.content.Context r7 = r7.getContext()
            int r8 = net.one97.paytm.recharge.R.string.trips_left
            java.lang.String r7 = r7.getString(r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            goto L_0x01db
        L_0x01b7:
            android.view.View r6 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            int r8 = net.one97.paytm.recharge.R.id.tripsLeftLabel
            android.view.View r6 = r6.findViewById(r8)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.view.View r7 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            android.content.Context r7 = r7.getContext()
            int r8 = net.one97.paytm.recharge.R.string.trip_left
            java.lang.String r7 = r7.getString(r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
        L_0x01db:
            if (r15 == 0) goto L_0x01e2
            java.lang.String r6 = r15.getExpiryDate()
            goto L_0x01e3
        L_0x01e2:
            r6 = r0
        L_0x01e3:
            java.lang.String r7 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            java.lang.String r8 = "dd MMMM yy"
            net.one97.paytm.recharge.common.utils.ab.a(r6, r7, r8)
            android.view.View r6 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            int r7 = net.one97.paytm.recharge.R.id.validity
            android.view.View r6 = r6.findViewById(r7)
            android.widget.TextView r6 = (android.widget.TextView) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r14)
            if (r15 == 0) goto L_0x0202
            java.lang.String r7 = r15.getExpiryTime()
            goto L_0x0203
        L_0x0202:
            r7 = r0
        L_0x0203:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
        L_0x0208:
            if (r4 == 0) goto L_0x0299
            android.view.View r6 = r12.itemView
            r7 = r4
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x021a:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x023b
            java.lang.Object r9 = r7.next()
            r10 = r9
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
            net.one97.paytm.recharge.metro.f.c$e r11 = net.one97.paytm.recharge.metro.f.c.e.PENALTY
            java.lang.String r11 = r11.getValue()
            java.lang.String r10 = r10.getType()
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x021a
            r8.add(r9)
            goto L_0x021a
        L_0x023b:
            java.util.List r8 = (java.util.List) r8
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r7 = r8.isEmpty()
            r7 = r7 ^ r2
            if (r7 != r2) goto L_0x0247
            goto L_0x0248
        L_0x0247:
            r2 = 0
        L_0x0248:
            android.view.View$OnClickListener r13 = r12.a(r13, r4, r3, r2)
            r6.setOnClickListener(r13)
            if (r5 == 0) goto L_0x027e
            android.view.View r13 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            int r15 = net.one97.paytm.recharge.R.id.validity
            android.view.View r13 = r13.findViewById(r15)
            android.widget.TextView r13 = (android.widget.TextView) r13
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            java.lang.Object r14 = r4.get(r3)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r14 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r14
            if (r14 == 0) goto L_0x026d
            java.util.List r0 = r14.getQrCodes()
        L_0x026d:
            java.lang.Object r14 = r0.get(r3)
            java.lang.String r15 = "tickets[0]?.qrCodes[0]"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r14 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r14
            java.lang.String r0 = r14.getExpiry()
            goto L_0x0294
        L_0x027e:
            android.view.View r13 = r12.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)
            int r1 = net.one97.paytm.recharge.R.id.validity
            android.view.View r13 = r13.findViewById(r1)
            android.widget.TextView r13 = (android.widget.TextView) r13
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            if (r15 == 0) goto L_0x0294
            java.lang.String r0 = r15.getExpiryTime()
        L_0x0294:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r13.setText(r0)
        L_0x0299:
            return
        L_0x029a:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.d.c.a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2, java.util.List, android.content.Context):void");
    }

    private static boolean a(List<? extends CJRActiveMetroTicketModel> list) {
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (CJRActiveMetroTicketModel cJRActiveMetroTicketModel : list) {
                if (z) {
                    break;
                }
                z = p.a(c.e.PENALTY.getValue(), cJRActiveMetroTicketModel.getType(), true);
            }
        }
        return z;
    }
}
