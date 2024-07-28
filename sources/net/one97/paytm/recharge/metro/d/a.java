package net.one97.paytm.recharge.metro.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityAttributesV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityProductV2;
import net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2;
import net.one97.paytm.recharge.metro.d.d;

public final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private int f63446b;

    /* renamed from: c  reason: collision with root package name */
    private int f63447c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, d.a aVar) {
        super(view, aVar);
        k.c(view, "itemView");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0023 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r22, java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r23, android.content.Context r24) {
        /*
            r21 = this;
            r8 = r21
            java.lang.String r0 = "variant"
            r9 = r22
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "context"
            r10 = r24
            kotlin.g.b.k.c(r10, r0)
            r12 = 0
            r13 = 1
            if (r23 == 0) goto L_0x0065
            r0 = r23
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0023:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3
            java.lang.String r4 = r3.getSource()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0041
            int r4 = r4.length()
            if (r4 != 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r4 = 0
            goto L_0x0042
        L_0x0041:
            r4 = 1
        L_0x0042:
            if (r4 != 0) goto L_0x005a
            java.lang.String r3 = r3.getDestination()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0055
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r3 = 0
            goto L_0x0056
        L_0x0055:
            r3 = 1
        L_0x0056:
            if (r3 != 0) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            if (r3 == 0) goto L_0x0023
            r1.add(r2)
            goto L_0x0023
        L_0x0061:
            r0 = r1
            java.util.List r0 = (java.util.List) r0
            goto L_0x0066
        L_0x0065:
            r0 = 0
        L_0x0066:
            if (r0 == 0) goto L_0x02d7
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r13
            if (r1 != r13) goto L_0x02d7
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x02d7
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r0.iterator()
        L_0x0085:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00a6
            java.lang.Object r3 = r2.next()
            r4 = r3
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r4
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.PENALTY
            java.lang.String r5 = r5.getValue()
            java.lang.String r4 = r4.getType()
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0085
            r1.add(r3)
            goto L_0x0085
        L_0x00a6:
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r13
            if (r1 != r13) goto L_0x00b3
            r14 = 1
            goto L_0x00b4
        L_0x00b3:
            r14 = 0
        L_0x00b4:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r0.iterator()
        L_0x00bf:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00f6
            java.lang.Object r3 = r2.next()
            r4 = r3
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r4
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.OUTWARD
            java.lang.String r5 = r5.getValue()
            java.lang.String r6 = r4.getType()
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00ef
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.SJT
            java.lang.String r5 = r5.getValue()
            java.lang.String r4 = r4.getType()
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00ed
            goto L_0x00ef
        L_0x00ed:
            r4 = 0
            goto L_0x00f0
        L_0x00ef:
            r4 = 1
        L_0x00f0:
            if (r4 == 0) goto L_0x00bf
            r1.add(r3)
            goto L_0x00bf
        L_0x00f6:
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r3 = r0.iterator()
        L_0x0104:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x013b
            java.lang.Object r4 = r3.next()
            r5 = r4
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.OUTWARD
            java.lang.String r6 = r6.getValue()
            java.lang.String r7 = r5.getSubType()
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0134
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.SJT
            java.lang.String r6 = r6.getValue()
            java.lang.String r5 = r5.getSubType()
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0132
            goto L_0x0134
        L_0x0132:
            r5 = 0
            goto L_0x0135
        L_0x0134:
            r5 = 1
        L_0x0135:
            if (r5 == 0) goto L_0x0104
            r1.add(r4)
            goto L_0x0104
        L_0x013b:
            r15 = r1
            java.util.List r15 = (java.util.List) r15
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r3 = r0.iterator()
        L_0x0149:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0180
            java.lang.Object r4 = r3.next()
            r5 = r4
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r5 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r5
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.RETURN
            java.lang.String r6 = r6.getValue()
            java.lang.String r7 = r5.getType()
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0179
            net.one97.paytm.recharge.metro.f.c$e r6 = net.one97.paytm.recharge.metro.f.c.e.RJT
            java.lang.String r6 = r6.getValue()
            java.lang.String r5 = r5.getType()
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0177
            goto L_0x0179
        L_0x0177:
            r5 = 0
            goto L_0x017a
        L_0x0179:
            r5 = 1
        L_0x017a:
            if (r5 == 0) goto L_0x0149
            r1.add(r4)
            goto L_0x0149
        L_0x0180:
            r16 = r1
            java.util.List r16 = (java.util.List) r16
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x018f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01c6
            java.lang.Object r3 = r0.next()
            r4 = r3
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r4 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r4
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.RETURN
            java.lang.String r5 = r5.getValue()
            java.lang.String r6 = r4.getSubType()
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x01bf
            net.one97.paytm.recharge.metro.f.c$e r5 = net.one97.paytm.recharge.metro.f.c.e.RJT
            java.lang.String r5 = r5.getValue()
            java.lang.String r4 = r4.getSubType()
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x01bd
            goto L_0x01bf
        L_0x01bd:
            r4 = 0
            goto L_0x01c0
        L_0x01bf:
            r4 = 1
        L_0x01c0:
            if (r4 == 0) goto L_0x018f
            r1.add(r3)
            goto L_0x018f
        L_0x01c6:
            r17 = r1
            java.util.List r17 = (java.util.List) r17
            r18 = r16
            java.util.Collection r18 = (java.util.Collection) r18
            boolean r0 = r18.isEmpty()
            r0 = r0 ^ r13
            if (r0 == r13) goto L_0x01e3
            r0 = r17
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r13
            if (r0 == r13) goto L_0x01e3
            r19 = 1
            goto L_0x01e5
        L_0x01e3:
            r19 = 0
        L_0x01e5:
            r0 = r2
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r1 = r0.isEmpty()
            r1 = r1 ^ r13
            if (r1 != 0) goto L_0x01fc
            r1 = r15
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r13
            if (r1 != 0) goto L_0x01fc
            r20 = 1
            goto L_0x01fe
        L_0x01fc:
            r20 = 0
        L_0x01fe:
            int r1 = r8.f63446b
            if (r1 < 0) goto L_0x0230
            r3 = 0
        L_0x0203:
            android.view.View r4 = r8.itemView
            if (r4 == 0) goto L_0x022b
            int r5 = net.one97.paytm.recharge.R.id.forward_journey_layouts
            android.view.View r4 = r4.findViewById(r5)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x022b
            android.view.View r5 = r8.itemView
            if (r5 == 0) goto L_0x0227
            int r6 = net.one97.paytm.recharge.R.id.forward_journey_layouts
            android.view.View r5 = r5.findViewById(r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0227
            int r6 = net.one97.paytm.recharge.R.id.fwd_journey_lyt
            int r6 = r6 + r3
            android.view.View r5 = r5.findViewById(r6)
            goto L_0x0228
        L_0x0227:
            r5 = 0
        L_0x0228:
            r4.removeView(r5)
        L_0x022b:
            if (r3 == r1) goto L_0x0230
            int r3 = r3 + 1
            goto L_0x0203
        L_0x0230:
            r8.f63446b = r12
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r13
            java.lang.String r7 = "itemView"
            if (r0 != r13) goto L_0x024f
            android.view.View r1 = r8.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            r4 = 0
            r0 = r21
            r3 = r22
            r5 = r19
            r6 = r14
            r11 = r7
            r7 = r24
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0250
        L_0x024f:
            r11 = r7
        L_0x0250:
            r0 = r15
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r13
            if (r0 != r13) goto L_0x026d
            android.view.View r1 = r8.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r4 = 1
            r0 = r21
            r2 = r15
            r3 = r22
            r5 = r19
            r6 = r14
            r7 = r24
            r0.a(r1, r2, r3, r4, r5, r6, r7)
        L_0x026d:
            int r0 = r8.f63447c
            if (r0 < 0) goto L_0x029f
            r1 = 0
        L_0x0272:
            android.view.View r2 = r8.itemView
            if (r2 == 0) goto L_0x029a
            int r3 = net.one97.paytm.recharge.R.id.return_journey_layouts
            android.view.View r2 = r2.findViewById(r3)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            if (r2 == 0) goto L_0x029a
            android.view.View r3 = r8.itemView
            if (r3 == 0) goto L_0x0296
            int r4 = net.one97.paytm.recharge.R.id.return_journey_layouts
            android.view.View r3 = r3.findViewById(r4)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            if (r3 == 0) goto L_0x0296
            int r4 = net.one97.paytm.recharge.R.id.rev_journey_lyt
            int r4 = r4 + r1
            android.view.View r3 = r3.findViewById(r4)
            goto L_0x0297
        L_0x0296:
            r3 = 0
        L_0x0297:
            r2.removeView(r3)
        L_0x029a:
            if (r1 == r0) goto L_0x029f
            int r1 = r1 + 1
            goto L_0x0272
        L_0x029f:
            r8.f63447c = r12
            boolean r0 = r18.isEmpty()
            r0 = r0 ^ r13
            if (r0 != r13) goto L_0x02ba
            android.view.View r1 = r8.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r5 = 0
            r0 = r21
            r2 = r16
            r3 = r22
            r4 = r20
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
        L_0x02ba:
            r0 = r17
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r13
            if (r0 != r13) goto L_0x02d7
            android.view.View r1 = r8.itemView
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            r5 = 1
            r0 = r21
            r2 = r17
            r3 = r22
            r4 = r20
            r6 = r14
            r0.a(r1, r2, r3, r4, r5, r6)
        L_0x02d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.d.a.a(net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2, java.util.List, android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(android.view.View r10, java.util.List<? extends net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel> r11, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2 r12, boolean r13, boolean r14, boolean r15) {
        /*
            r9 = this;
            java.util.Iterator r11 = r11.iterator()
        L_0x0004:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x01da
            java.lang.Object r0 = r11.next()
            r3 = r0
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel) r3
            android.content.Context r0 = r10.getContext()
            int r1 = net.one97.paytm.recharge.R.layout.metro_ticket_item_rr
            r2 = 0
            android.view.View r0 = android.view.View.inflate(r0, r1, r2)
            if (r0 == 0) goto L_0x01d2
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x002a
            int r1 = net.one97.paytm.recharge.R.id.rev_journey_lyt
            int r4 = r9.f63447c
            int r1 = r1 + r4
            r0.setId(r1)
        L_0x002a:
            net.one97.paytm.recharge.metro.f.c$a r1 = net.one97.paytm.recharge.metro.f.c.f63576a
            android.content.Context r1 = r0.getContext()
            java.lang.String r4 = "wizardView.context"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = "context"
            kotlin.g.b.k.c(r1, r4)
            net.one97.paytm.recharge.common.utils.ax$a r4 = net.one97.paytm.recharge.common.utils.ax.f61521a
            android.content.Context r4 = r1.getApplicationContext()
            java.lang.String r5 = "context.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            com.paytm.utility.f$a r5 = com.paytm.utility.f.a.METRO_PREF
            com.paytm.b.a.a r4 = net.one97.paytm.recharge.common.utils.ax.a.a(r4, r5)
            java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r1)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x0059
            r1 = r2
            goto L_0x005d
        L_0x0059:
            java.lang.String r1 = com.paytm.utility.b.n((android.content.Context) r1)
        L_0x005d:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r5 = 0
            if (r1 != 0) goto L_0x00bb
            java.lang.String r1 = "metro_activate_tickets_"
            java.lang.String r6 = ""
            java.lang.String r1 = r4.b((java.lang.String) r1, (java.lang.String) r6, (boolean) r5)
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00bb
            com.google.gsonhtcfix.f r4 = new com.google.gsonhtcfix.f
            r4.<init>()
            net.one97.paytm.recharge.metro.f.c$a$b r6 = new net.one97.paytm.recharge.metro.f.c$a$b
            r6.<init>()
            java.lang.reflect.Type r6 = r6.getType()
            java.lang.Object r1 = r4.a((java.lang.String) r1, (java.lang.reflect.Type) r6)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r6 = "arrayList"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x009b:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00bc
            java.lang.Object r6 = r1.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.String r7 = "_"
            java.lang.String[] r7 = new java.lang.String[]{r7}
            java.util.List r6 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.String[]) r7)
            java.lang.Object r6 = r6.get(r5)
            r4.add(r6)
            goto L_0x009b
        L_0x00bb:
            r4 = r2
        L_0x00bc:
            r1 = 1
            if (r4 == 0) goto L_0x0123
            r6 = r4
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x0123
            java.util.List r6 = r3.getQrCodes()
            java.lang.Object r6 = r6.get(r5)
            java.lang.String r7 = "returnPenaltyTicket.qrCodes[0]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r6
            java.lang.String r6 = r6.getQrCodeId()
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x00ee
            boolean r6 = r4.contains(r6)
            if (r6 == 0) goto L_0x00ee
            r3.setEnable(r1)
        L_0x00ee:
            if (r15 == 0) goto L_0x0123
            java.util.List r6 = r3.getQrCodes()
            java.lang.Object r6 = r6.get(r5)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r6
            java.lang.String r6 = r6.getPreviousQrCodeId()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0123
            java.util.List r6 = r3.getQrCodes()
            java.lang.Object r6 = r6.get(r5)
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r6 = (net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel) r6
            java.lang.String r6 = r6.getPreviousQrCodeId()
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x0123
            r3.setEnable(r1)
        L_0x0123:
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0143
            r0.setVisibility(r5)
            boolean r6 = r3.isEnable()
            if (r6 == 0) goto L_0x0143
            r6 = r0
            android.view.View r6 = (android.view.View) r6
            int r7 = net.one97.paytm.recharge.R.id.fadedView
            android.view.View r6 = r6.findViewById(r7)
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            java.lang.String r7 = "fadedView"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r6.setAlpha(r4)
        L_0x0143:
            r6 = r0
            android.view.View r6 = (android.view.View) r6
            if (r0 == 0) goto L_0x014c
            android.content.Context r2 = r0.getContext()
        L_0x014c:
            int r7 = net.one97.paytm.recharge.R.string.return_journey
            java.lang.String r2 = r2.getString(r7)
            java.lang.String r7 = "wizardView?.context.getS…(R.string.return_journey)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            java.util.List r7 = r3.getQrCodes()
            int r7 = r7.size()
            a(r3, r6, r2, r7, r14)
            if (r10 == 0) goto L_0x0171
            int r2 = net.one97.paytm.recharge.R.id.return_journey_layouts
            android.view.View r2 = r10.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            if (r2 == 0) goto L_0x0171
            r2.addView(r6)
        L_0x0171:
            int r2 = r9.f63447c
            int r2 = r2 + r1
            r9.f63447c = r2
            kotlin.g.b.x$e r7 = new kotlin.g.b.x$e
            r7.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r7.element = r1
            T r1 = r7.element
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            r1.add(r3)
            if (r13 == 0) goto L_0x01be
            if (r0 == 0) goto L_0x019a
            T r1 = r7.element
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.List r1 = (java.util.List) r1
            android.view.View$OnClickListener r1 = r9.a(r12, r1, r5, r15)
            r0.setOnClickListener(r1)
        L_0x019a:
            boolean r1 = r3.isEnable()
            if (r1 != 0) goto L_0x0004
            if (r0 == 0) goto L_0x01af
            int r0 = net.one97.paytm.recharge.R.id.fadedView
            android.view.View r0 = r6.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            if (r0 == 0) goto L_0x01af
            r0.setAlpha(r4)
        L_0x01af:
            net.one97.paytm.recharge.metro.d.d$a r0 = r9.f63456a
            if (r0 == 0) goto L_0x0004
            T r1 = r7.element
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.List r1 = (java.util.List) r1
            r0.a(r12, r1)
            goto L_0x0004
        L_0x01be:
            if (r0 == 0) goto L_0x0004
            net.one97.paytm.recharge.metro.d.a$a r8 = new net.one97.paytm.recharge.metro.d.a$a
            r1 = r8
            r2 = r9
            r4 = r12
            r5 = r7
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r0.setOnClickListener(r8)
            goto L_0x0004
        L_0x01d2:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type android.widget.LinearLayout"
            r10.<init>(r11)
            throw r10
        L_0x01da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.d.a.a(android.view.View, java.util.List, net.one97.paytm.recharge.legacy.catalog.model.CJRUtilityVariantV2, boolean, boolean, boolean):void");
    }

    /* renamed from: net.one97.paytm.recharge.metro.d.a$a  reason: collision with other inner class name */
    static final class C1226a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f63448a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRActiveMetroTicketModel f63449b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CJRUtilityVariantV2 f63450c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f63451d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f63452e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f63453f;

        C1226a(a aVar, CJRActiveMetroTicketModel cJRActiveMetroTicketModel, CJRUtilityVariantV2 cJRUtilityVariantV2, x.e eVar, boolean z, boolean z2) {
            this.f63448a = aVar;
            this.f63449b = cJRActiveMetroTicketModel;
            this.f63450c = cJRUtilityVariantV2;
            this.f63451d = eVar;
            this.f63452e = z;
            this.f63453f = z2;
        }

        public final void onClick(View view) {
            if (!this.f63449b.isEnable()) {
                d.a aVar = this.f63448a.f63456a;
                if (aVar != null) {
                    aVar.a(this.f63450c, (ArrayList) this.f63451d.element, this.f63453f);
                    return;
                }
                return;
            }
            d.a aVar2 = this.f63448a.f63456a;
            if (aVar2 != null) {
                aVar2.a(this.f63450c, (ArrayList) this.f63451d.element, false, this.f63453f);
            }
        }
    }

    private final void a(View view, List<? extends CJRActiveMetroTicketModel> list, CJRUtilityVariantV2 cJRUtilityVariantV2, boolean z, boolean z2, boolean z3, Context context) {
        LinearLayout linearLayout;
        CJRUtilityProductV2 product;
        CJRUtilityAttributesV2 attributes;
        String colorCode;
        Drawable a2 = b.a(context, R.drawable.left_right_curved_blue_border);
        if (a2 != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) a2;
            for (CJRActiveMetroTicketModel cJRActiveMetroTicketModel : list) {
                View inflate = View.inflate(view.getContext(), R.layout.metro_ticket_item_ff, (ViewGroup) null);
                if (inflate != null) {
                    LinearLayout linearLayout2 = (LinearLayout) inflate;
                    if (linearLayout2 != null) {
                        linearLayout2.setId(R.id.fwd_journey_lyt + this.f63446b);
                    }
                    if (!(cJRUtilityVariantV2 == null || (product = cJRUtilityVariantV2.getProduct()) == null || (attributes = product.getAttributes()) == null || (colorCode = attributes.getColorCode()) == null)) {
                        gradientDrawable.setColor(Color.parseColor(colorCode));
                    }
                    String string = view.getContext().getString(R.string.fwd_journey);
                    k.a((Object) string, "itemView.context.getString(R.string.fwd_journey)");
                    if (z2) {
                        string = view.getContext().getString(R.string.fwd_journey_ticket);
                        k.a((Object) string, "itemView.context.getStri…tring.fwd_journey_ticket)");
                    }
                    View view2 = linearLayout2;
                    a(cJRActiveMetroTicketModel, view2, string, cJRActiveMetroTicketModel.getQrCodes().size(), z);
                    if (!(view == null || (linearLayout = (LinearLayout) view.findViewById(R.id.forward_journey_layouts)) == null)) {
                        linearLayout.addView(view2);
                    }
                    this.f63446b++;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(cJRActiveMetroTicketModel);
                    if (linearLayout2 != null) {
                        linearLayout2.setOnClickListener(a(cJRUtilityVariantV2, arrayList, z2, z3));
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                }
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    private static void a(CJRActiveMetroTicketModel cJRActiveMetroTicketModel, View view, String str, int i2, boolean z) {
        k.c(cJRActiveMetroTicketModel, "values");
        k.c(view, "view");
        k.c(str, "journeyType");
        View findViewById = view.findViewById(R.id.ff_from_value_tv);
        k.a((Object) findViewById, "view.findViewById<TextView>(R.id.ff_from_value_tv)");
        ((TextView) findViewById).setText(cJRActiveMetroTicketModel.getSource());
        View findViewById2 = view.findViewById(R.id.ff_to_value_tv);
        k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.ff_to_value_tv)");
        ((TextView) findViewById2).setText(cJRActiveMetroTicketModel.getDestination());
        View findViewById3 = view.findViewById(R.id.ff_tickets_num_tv);
        k.a((Object) findViewById3, "view.findViewById<TextVi…>(R.id.ff_tickets_num_tv)");
        ((TextView) findViewById3).setText(String.valueOf(i2));
        View findViewById4 = view.findViewById(R.id.ff_valid_until_tv);
        k.a((Object) findViewById4, "view.findViewById<TextVi…>(R.id.ff_valid_until_tv)");
        CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = cJRActiveMetroTicketModel.getQrCodes().get(0);
        k.a((Object) cJRActiveMetroTicketQRItemModel, "values.qrCodes.get(0)");
        ((TextView) findViewById4).setText(cJRActiveMetroTicketQRItemModel.getExpiry());
        View findViewById5 = view.findViewById(R.id.txt_journey_type);
        k.a((Object) findViewById5, "view.findViewById<TextView>(R.id.txt_journey_type)");
        ((TextView) findViewById5).setText(str);
        if (z) {
            View findViewById6 = view.findViewById(R.id.penalty_text);
            k.a((Object) findViewById6, "view.findViewById<TextView>(R.id.penalty_text)");
            ((TextView) findViewById6).setVisibility(0);
        }
        if (cJRActiveMetroTicketModel.getQrCodes().size() > 1) {
            View findViewById7 = view.findViewById(R.id.ff_tickets_label);
            k.a((Object) findViewById7, "view.findViewById<TextView>(R.id.ff_tickets_label)");
            ((TextView) findViewById7).setText(view.getContext().getString(R.string.tickets));
            return;
        }
        View findViewById8 = view.findViewById(R.id.ff_tickets_label);
        k.a((Object) findViewById8, "view.findViewById<TextView>(R.id.ff_tickets_label)");
        ((TextView) findViewById8).setText(view.getContext().getString(R.string.ticket));
    }
}
