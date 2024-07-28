package net.one97.paytm.recharge.metro.d;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.metro.d.d;
import net.one97.paytm.recharge.metro.f.c;

public final class b extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, d.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r20, java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r21, android.content.Context r22) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r0 = r22
            java.lang.String r3 = "variant"
            kotlin.g.b.k.c(r2, r3)
            java.lang.String r3 = "context"
            kotlin.g.b.k.c(r0, r3)
            if (r21 == 0) goto L_0x003c
            r4 = r21
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0021:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0038
            java.lang.Object r6 = r4.next()
            r7 = r6
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r7 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r7
            boolean r7 = r7.isPass()
            if (r7 == 0) goto L_0x0021
            r5.add(r6)
            goto L_0x0021
        L_0x0038:
            r4 = r5
            java.util.List r4 = (java.util.List) r4
            goto L_0x003d
        L_0x003c:
            r4 = 0
        L_0x003d:
            r5 = 1
            r6 = 0
            if (r21 == 0) goto L_0x0070
            r7 = r21
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x0050:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x006c
            java.lang.Object r9 = r7.next()
            r10 = r9
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r10 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r10
            java.util.List r10 = r10.getQrCodes()
            if (r10 == 0) goto L_0x0065
            r10 = 1
            goto L_0x0066
        L_0x0065:
            r10 = 0
        L_0x0066:
            if (r10 == 0) goto L_0x0050
            r8.add(r9)
            goto L_0x0050
        L_0x006c:
            r7 = r8
            java.util.List r7 = (java.util.List) r7
            goto L_0x0071
        L_0x0070:
            r7 = 0
        L_0x0071:
            int r8 = net.one97.paytm.recharge.R.drawable.left_right_curved_pink_border
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r8)
            if (r0 == 0) goto L_0x037e
            r8 = r0
            android.graphics.drawable.GradientDrawable r8 = (android.graphics.drawable.GradientDrawable) r8
            boolean r9 = a(r7)
            if (r9 == 0) goto L_0x0094
            android.view.View r0 = r1.itemView
            int r10 = net.one97.paytm.recharge.R.id.penalty_text
            android.view.View r0 = r0.findViewById(r10)
            java.lang.String r10 = "itemView.findViewById<TextView>(R.id.penalty_text)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r10)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r6)
        L_0x0094:
            if (r4 == 0) goto L_0x00aa
            java.lang.Object r0 = r4.get(r6)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r0 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r0
            if (r0 == 0) goto L_0x00aa
            java.lang.String r0 = r0.getBalanceAmount()
            if (r0 == 0) goto L_0x00aa
            int r0 = java.lang.Integer.parseInt(r0)
            r10 = r0
            goto L_0x00ab
        L_0x00aa:
            r10 = 0
        L_0x00ab:
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = r20.getProduct()
            java.lang.String r11 = "itemView.pink_background_view"
            java.lang.String r12 = "itemView"
            if (r0 == 0) goto L_0x00dc
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x00dc
            java.lang.String r0 = r0.getColorCode()
            if (r0 == 0) goto L_0x00dc
            int r0 = android.graphics.Color.parseColor(r0)
            r8.setColor(r0)
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            int r13 = net.one97.paytm.recharge.R.id.pink_background_view
            android.view.View r0 = r0.findViewById(r13)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            r13 = r8
            android.graphics.drawable.Drawable r13 = (android.graphics.drawable.Drawable) r13
            r0.setBackground(r13)
        L_0x00dc:
            if (r4 == 0) goto L_0x0113
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r5
            if (r0 != r5) goto L_0x0113
            java.lang.Object r0 = r4.get(r6)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r0 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r0
            r4 = r21
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00f6:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto L_0x0111
            java.lang.Object r13 = r4.next()
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r13 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r13
            java.lang.String r14 = r0.getBalanceAmount()
            r13.setBalanceAmount(r14)
            java.lang.String r14 = r0.getProductType()
            r13.setProductType(r14)
            goto L_0x00f6
        L_0x0111:
            r4 = r0
            goto L_0x0114
        L_0x0113:
            r4 = 0
        L_0x0114:
            if (r4 == 0) goto L_0x0153
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            int r13 = net.one97.paytm.recharge.R.id.balance_left_value_tv
            android.view.View r0 = r0.findViewById(r13)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r13 = "itemView.balance_left_value_tv"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r13)
            android.view.View r13 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r12)
            android.content.Context r13 = r13.getContext()
            int r14 = net.one97.paytm.recharge.R.string.metro_svp_mumbai_balance
            java.lang.Object[] r15 = new java.lang.Object[r5]
            java.lang.String r16 = java.lang.String.valueOf(r10)
            r15[r6] = r16
            java.lang.String r13 = r13.getString(r14, r15)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r0.setText(r13)
            if (r4 == 0) goto L_0x014b
            java.lang.String r0 = r4.getExpiryDate()
            goto L_0x014c
        L_0x014b:
            r0 = 0
        L_0x014c:
            java.lang.String r13 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            java.lang.String r14 = "dd MMMM yy"
            net.one97.paytm.recharge.common.utils.ab.a(r0, r13, r14)
        L_0x0153:
            r13 = 20
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2 r0 = r20.getProduct()     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0167
            net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2 r0 = r0.getAttributes()     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0167
            java.lang.String r0 = r0.getMin_bal()     // Catch:{ Exception -> 0x016e }
            if (r0 != 0) goto L_0x0169
        L_0x0167:
            java.lang.String r0 = "20"
        L_0x0169:
            int r13 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x016e }
            goto L_0x0176
        L_0x016e:
            r0 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r14 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r14.debugLogExceptions(r0)
        L_0x0176:
            java.lang.String r0 = "itemView.rechargeNow"
            java.lang.String r14 = "itemView.lowBalance"
            java.lang.String r15 = "itemView.balance_left_tv"
            java.lang.String r3 = "itemView.add_money_tv"
            java.lang.String r6 = "itemView.valid_until_tv"
            if (r7 == 0) goto L_0x0292
            boolean r17 = r7.isEmpty()
            if (r17 != 0) goto L_0x0292
            if (r10 < r13) goto L_0x0292
            android.view.View r8 = r1.itemView
            r10 = r7
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r10 = r10.iterator()
        L_0x019a:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x01c0
            java.lang.Object r13 = r10.next()
            r17 = r13
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r17 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r17
            net.one97.paytm.recharge.metro.f.c$e r18 = net.one97.paytm.recharge.metro.f.c.e.PENALTY
            java.lang.String r5 = r18.getValue()
            r22 = r10
            java.lang.String r10 = r17.getType()
            boolean r5 = r5.equals(r10)
            if (r5 == 0) goto L_0x01bd
            r11.add(r13)
        L_0x01bd:
            r10 = r22
            goto L_0x019a
        L_0x01c0:
            java.util.List r11 = (java.util.List) r11
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r5 = r11.isEmpty()
            r10 = 1
            r5 = r5 ^ r10
            if (r5 != r10) goto L_0x01ce
            r5 = 1
            goto L_0x01cf
        L_0x01ce:
            r5 = 0
        L_0x01cf:
            r10 = 0
            android.view.View$OnClickListener r2 = r1.a(r2, r7, r10, r5)
            r8.setOnClickListener(r2)
            if (r9 == 0) goto L_0x0207
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r4 = net.one97.paytm.recharge.R.id.valid_until_tv
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.Object r4 = r7.get(r10)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r4
            if (r4 == 0) goto L_0x01f6
            java.util.List r4 = r4.getQrCodes()
            goto L_0x01f7
        L_0x01f6:
            r4 = 0
        L_0x01f7:
            java.lang.Object r4 = r4.get(r10)
            java.lang.String r5 = "tickets[0]?.qrCodes[0]"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r4
            java.lang.String r4 = r4.getExpiry()
            goto L_0x021f
        L_0x0207:
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r5 = net.one97.paytm.recharge.R.id.valid_until_tv
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            if (r4 == 0) goto L_0x021e
            java.lang.String r4 = r4.getExpiryTime()
            goto L_0x021f
        L_0x021e:
            r4 = 0
        L_0x021f:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r4 = net.one97.paytm.recharge.R.id.add_money_tv
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0241
            r4 = 1
            r2.setClickable(r4)
            net.one97.paytm.recharge.metro.d.b$a r4 = new net.one97.paytm.recharge.metro.d.b$a
            r4.<init>(r1)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r2.setOnClickListener(r4)
        L_0x0241:
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r4 = net.one97.paytm.recharge.R.id.add_money_tv
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 4
            r2.setVisibility(r3)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r3 = net.one97.paytm.recharge.R.id.balance_left_tv
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            r3 = 0
            r2.setVisibility(r3)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r3 = net.one97.paytm.recharge.R.id.lowBalance
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)
            r3 = 8
            r2.setVisibility(r3)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r4 = net.one97.paytm.recharge.R.id.rechargeNow
            android.view.View r2 = r2.findViewById(r4)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            r2.setVisibility(r3)
            return
        L_0x0292:
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r5 = net.one97.paytm.recharge.R.id.add_money_tv
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 4
            r2.setVisibility(r3)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r3 = net.one97.paytm.recharge.R.id.add_money_tv
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 0
            r2.setOnClickListener(r3)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r5 = net.one97.paytm.recharge.R.id.balance_left_tv
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            r5 = 4
            r2.setVisibility(r5)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r5 = net.one97.paytm.recharge.R.id.lowBalance
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r14)
            r5 = 0
            r2.setVisibility(r5)
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            int r7 = net.one97.paytm.recharge.R.id.rechargeNow
            android.view.View r2 = r2.findViewById(r7)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            r2.setVisibility(r5)
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            int r2 = net.one97.paytm.recharge.R.id.valid_until_tv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            if (r4 == 0) goto L_0x0308
            java.lang.String r3 = r4.getExpiryTime()
        L_0x0308:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            int r2 = net.one97.paytm.recharge.R.id.rechargeNow
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.recharge.metro.d.b$b r2 = new net.one97.paytm.recharge.metro.d.b$b
            r2.<init>(r1)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            int r2 = net.one97.paytm.recharge.R.id.ff_svp_iv
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L_0x0339
            r2 = 1050253722(0x3e99999a, float:0.3)
            r0.setAlpha(r2)
        L_0x0339:
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            int r2 = net.one97.paytm.recharge.R.id.ff_tap_to_view_tv_svp
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.view.View r2 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.recharge.R.color.warm_grey
            int r2 = r2.getColor(r3)
            r0.setTextColor(r2)
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            android.content.res.Resources r0 = r0.getResources()
            int r2 = net.one97.paytm.recharge.R.color.warm_grey
            int r0 = r0.getColor(r2)
            r8.setColor(r0)
            android.view.View r0 = r1.itemView
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            int r2 = net.one97.paytm.recharge.R.id.pink_background_view
            android.view.View r0 = r0.findViewById(r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            r0.setBackground(r8)
            return
        L_0x037e:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.d.b.a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2, java.util.List, android.content.Context):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63454a;

        a(b bVar) {
            this.f63454a = bVar;
        }

        public final void onClick(View view) {
            d.a aVar = this.f63454a.f63456a;
            if (aVar != null) {
                aVar.a(this.f63454a.getAdapterPosition());
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.metro.d.b$b  reason: collision with other inner class name */
    static final class C1227b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63455a;

        C1227b(b bVar) {
            this.f63455a = bVar;
        }

        public final void onClick(View view) {
            d.a aVar = this.f63455a.f63456a;
            if (aVar != null) {
                aVar.a(this.f63455a.getAdapterPosition());
            }
            b bVar = this.f63455a;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("event_category", "mumbai_metro_store_value_pass");
                hashMap.put("event_action", "recharge_now_clicked");
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/mumbai-metro-store-value-pass");
                hashMap.put("vertical_name", "recharges_utilities");
                net.one97.paytm.recharge.di.helper.b bVar2 = net.one97.paytm.recharge.di.helper.b.f62652a;
                View view2 = bVar.itemView;
                k.a((Object) view2, "itemView");
                Context context = view2.getContext();
                k.a((Object) context, "itemView.context");
                net.one97.paytm.recharge.di.helper.b.a((HashMap<String, Object>) hashMap, context);
            } catch (Throwable unused) {
            }
        }
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
