package net.one97.paytm.recharge.mobile_v3.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.squareup.picasso.w;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.p;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.widget.CJRRechargeLottieAnimationView;

public class c extends p.d {

    /* renamed from: c  reason: collision with root package name */
    final TextView f63893c;

    /* renamed from: d  reason: collision with root package name */
    final TextView f63894d;

    /* renamed from: e  reason: collision with root package name */
    final TextView f63895e;

    /* renamed from: f  reason: collision with root package name */
    final ImageView f63896f;

    /* renamed from: g  reason: collision with root package name */
    final TextView f63897g;

    /* renamed from: h  reason: collision with root package name */
    final TextView f63898h;

    /* renamed from: i  reason: collision with root package name */
    final String f63899i;
    CJRFrequentOrder j;
    private final CJRRechargeLottieAnimationView k;

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ad, code lost:
        if (r10 == null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0193, code lost:
        if (r5 == null) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0197, code lost:
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01bc, code lost:
        if (r5 == null) goto L_0x0195;
     */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r17, net.one97.paytm.common.entity.recharge.CJRFrequentOrder r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            java.lang.String r2 = "recentOrder"
            kotlin.g.b.k.c(r1, r2)
            r0.j = r1
            java.lang.String r3 = r18.getRechargeNumber()
            net.one97.paytm.recharge.common.utils.n r4 = net.one97.paytm.recharge.common.utils.n.f61679a
            java.lang.String r4 = "rechargeNumber"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.recharge.model.ContactItemModel r3 = net.one97.paytm.recharge.common.utils.n.a((java.lang.String) r3)
            r5 = 2
            r6 = 8
            java.lang.String r7 = "itemView"
            r8 = 0
            if (r3 == 0) goto L_0x0026
            r0.a((net.one97.paytm.recharge.model.ContactItemModel) r3, (net.one97.paytm.common.entity.recharge.CJRFrequentOrder) r1)
            goto L_0x008b
        L_0x0026:
            r3 = r0
            net.one97.paytm.recharge.mobile_v3.c.c r3 = (net.one97.paytm.recharge.mobile_v3.c.c) r3
            kotlin.g.b.k.c(r1, r2)
            android.widget.TextView r2 = r3.f63893c
            if (r2 == 0) goto L_0x0033
            r2.setVisibility(r6)
        L_0x0033:
            android.widget.TextView r2 = r3.f63895e
            if (r2 == 0) goto L_0x0049
            android.view.View r9 = r3.itemView
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r7)
            android.content.Context r9 = r9.getContext()
            int r10 = net.one97.paytm.recharge.R.color.v3_status_info_1
            int r9 = androidx.core.content.b.c(r9, r10)
            r2.setTextColor(r9)
        L_0x0049:
            android.widget.TextView r2 = r3.f63895e
            if (r2 == 0) goto L_0x0052
            r9 = 1094713344(0x41400000, float:12.0)
            r2.setTextSize(r5, r9)
        L_0x0052:
            android.widget.ImageView r2 = r3.f63896f
            if (r2 == 0) goto L_0x0059
            r2.setVisibility(r8)
        L_0x0059:
            android.widget.TextView r2 = r3.f63894d
            if (r2 == 0) goto L_0x0060
            r2.setVisibility(r6)
        L_0x0060:
            java.lang.String r2 = r18.getOperatorLogoURL()
            r9 = r2
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0082
            android.widget.ImageView r9 = r3.f63896f
            if (r9 == 0) goto L_0x0074
            r9.setVisibility(r8)
        L_0x0074:
            com.squareup.picasso.w r9 = com.squareup.picasso.w.a()
            com.squareup.picasso.aa r2 = r9.a((java.lang.String) r2)
            android.widget.ImageView r3 = r3.f63896f
            r2.a((android.widget.ImageView) r3)
            goto L_0x008b
        L_0x0082:
            android.widget.ImageView r2 = r3.f63896f
            if (r2 == 0) goto L_0x008b
            int r3 = net.one97.paytm.recharge.R.drawable.v3_default_logo_contact
            r2.setImageResource(r3)
        L_0x008b:
            java.util.List r2 = r18.getmBillDetails()
            java.lang.String r3 = ""
            r9 = 1
            if (r2 == 0) goto L_0x00af
            r10 = r2
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r9
            if (r10 != r9) goto L_0x00af
            java.lang.Object r10 = r2.get(r8)
            java.lang.String r11 = "billsList[0]"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r10 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r10
            java.lang.String r10 = r10.getLabel()
            if (r10 != 0) goto L_0x00b0
        L_0x00af:
            r10 = r3
        L_0x00b0:
            if (r2 == 0) goto L_0x00ca
            r11 = r2
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            r11 = r11 ^ r9
            if (r11 != r9) goto L_0x00ca
            java.lang.Object r11 = r2.get(r8)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r11 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r11
            if (r11 == 0) goto L_0x00ca
            java.lang.String r11 = r11.getBillsLabelColor()
            if (r11 != 0) goto L_0x00cc
        L_0x00ca:
            java.lang.String r11 = r0.f63899i
        L_0x00cc:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 != 0) goto L_0x0103
            java.lang.Object r2 = r2.get(r8)
            net.one97.paytm.common.entity.recharge.CJRBillDetails r2 = (net.one97.paytm.common.entity.recharge.CJRBillDetails) r2
            boolean r2 = net.one97.paytm.recharge.common.utils.ba.c((net.one97.paytm.common.entity.recharge.CJRBillDetails) r2)
            if (r2 == 0) goto L_0x0103
            android.widget.TextView r2 = r0.f63897g
            if (r2 == 0) goto L_0x00e7
            r2.setVisibility(r6)
        L_0x00e7:
            android.widget.TextView r2 = r0.f63898h
            if (r2 == 0) goto L_0x00ee
            r2.setText(r10)
        L_0x00ee:
            android.widget.TextView r2 = r0.f63898h
            if (r2 == 0) goto L_0x00fb
            java.lang.String r6 = r0.f63899i
            int r6 = net.one97.paytm.recharge.common.utils.ba.c((java.lang.String) r11, (java.lang.String) r6)
            r2.setTextColor(r6)
        L_0x00fb:
            android.widget.TextView r2 = r0.f63898h
            if (r2 == 0) goto L_0x0134
            r2.setVisibility(r8)
            goto L_0x0134
        L_0x0103:
            android.widget.TextView r2 = r0.f63897g
            if (r2 == 0) goto L_0x010a
            r2.setVisibility(r6)
        L_0x010a:
            android.widget.TextView r2 = r0.f63898h
            if (r2 == 0) goto L_0x0117
            java.lang.String r6 = r18.getmCreatedAt()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x0117:
            android.widget.TextView r2 = r0.f63898h
            if (r2 == 0) goto L_0x012d
            android.view.View r6 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.content.Context r6 = r6.getContext()
            int r10 = net.one97.paytm.recharge.R.color.v3_status_info_1
            int r6 = androidx.core.content.b.c(r6, r10)
            r2.setTextColor(r6)
        L_0x012d:
            android.widget.TextView r2 = r0.f63898h
            if (r2 == 0) goto L_0x0134
            r2.setVisibility(r8)
        L_0x0134:
            java.lang.String r2 = r0.f60652a
            java.lang.String r6 = r18.getContactName()
            if (r6 == 0) goto L_0x0154
            java.lang.String r6 = r18.getContactName()
            java.lang.String r10 = "recentOrder.contactName"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r10)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x014f
            r6 = 1
            goto L_0x0150
        L_0x014f:
            r6 = 0
        L_0x0150:
            if (r6 == 0) goto L_0x0154
            r6 = 1
            goto L_0x0155
        L_0x0154:
            r6 = 0
        L_0x0155:
            java.lang.String r10 = r18.getRechargeNumber()
            boolean r11 = net.one97.paytm.recharge.common.utils.g.c(r2)
            java.lang.String r13 = "prepaid"
            java.lang.String r14 = "postpaid"
            if (r11 == 0) goto L_0x0368
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r4)
            r4 = r10
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r11 = 6
            int r11 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.String) r2, (int) r8, (boolean) r8, (int) r11)
            if (r6 == 0) goto L_0x01e9
            java.lang.String r15 = r18.getPayType()
            boolean r15 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r15, (boolean) r9)
            if (r15 == 0) goto L_0x0199
            android.view.View r15 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
            android.content.Context r15 = r15.getContext()
            int r12 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_postpaid
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r10
            java.lang.String r10 = r18.getOperatorDisplayLabel()
            r5[r9] = r10
            java.lang.String r5 = r15.getString(r12, r5)
            if (r5 != 0) goto L_0x0197
        L_0x0195:
            r10 = r3
            goto L_0x01e9
        L_0x0197:
            r10 = r5
            goto L_0x01e9
        L_0x0199:
            java.lang.String r12 = r18.getPayType()
            boolean r12 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r12, (boolean) r9)
            if (r12 == 0) goto L_0x01bf
            android.view.View r12 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r7)
            android.content.Context r12 = r12.getContext()
            int r15 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_prepaid
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r8] = r10
            java.lang.String r10 = r18.getOperatorDisplayLabel()
            r5[r9] = r10
            java.lang.String r5 = r12.getString(r15, r5)
            if (r5 != 0) goto L_0x0197
            goto L_0x0195
        L_0x01bf:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r10)
            java.lang.String r10 = ", "
            r5.append(r10)
            java.lang.String r10 = r18.getOperatorDisplayLabel()
            r5.append(r10)
            r10 = 32
            r5.append(r10)
            net.one97.paytm.recharge.widgets.c.d r10 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r10 = r18.getPayType()
            java.lang.String r10 = net.one97.paytm.recharge.widgets.c.d.b(r10)
            r5.append(r10)
            java.lang.String r10 = r5.toString()
        L_0x01e9:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r5 = r10.length()
            if (r5 <= 0) goto L_0x01f3
            r5 = 1
            goto L_0x01f4
        L_0x01f3:
            r5 = 0
        L_0x01f4:
            if (r5 == 0) goto L_0x02c6
            android.text.SpannableString r4 = new android.text.SpannableString
            r4.<init>(r10)
            r5 = -1
            if (r11 == r5) goto L_0x021c
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            android.view.View r10 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r7)
            android.content.Context r10 = r10.getContext()
            int r12 = net.one97.paytm.recharge.R.color.color_00ACED
            int r10 = androidx.core.content.b.c(r10, r12)
            r5.<init>(r10)
            int r2 = r2.length()
            int r2 = r2 + r11
            r10 = 18
            r4.setSpan(r5, r11, r2, r10)
        L_0x021c:
            if (r6 == 0) goto L_0x0228
            android.widget.TextView r1 = r0.f63895e
            if (r1 == 0) goto L_0x0227
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x0227:
            return
        L_0x0228:
            android.widget.TextView r2 = r0.f63893c
            if (r2 == 0) goto L_0x022f
            r2.setVisibility(r8)
        L_0x022f:
            android.widget.TextView r2 = r0.f63893c
            if (r2 == 0) goto L_0x0238
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x0238:
            java.lang.String r2 = r18.getPayType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r9)
            if (r2 == 0) goto L_0x0269
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x0268
            android.view.View r4 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_postpaid_wo_number
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r1 = r18.getOperatorDisplayLabel()
            r6[r8] = r1
            java.lang.String r1 = r4.getString(r5, r6)
            if (r1 == 0) goto L_0x0262
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0265
        L_0x0262:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0265:
            r2.setText(r1)
        L_0x0268:
            return
        L_0x0269:
            java.lang.String r2 = r18.getPayType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r2, (boolean) r9)
            if (r2 == 0) goto L_0x029a
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x0299
            android.view.View r4 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_prepaid_wo_number
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r1 = r18.getOperatorDisplayLabel()
            r6[r8] = r1
            java.lang.String r1 = r4.getString(r5, r6)
            if (r1 == 0) goto L_0x0293
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0296
        L_0x0293:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0296:
            r2.setText(r1)
        L_0x0299:
            return
        L_0x029a:
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x02c5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r18.getOperatorDisplayLabel()
            r3.append(r4)
            r4 = 32
            r3.append(r4)
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r1 = r18.getPayType()
            java.lang.String r1 = net.one97.paytm.recharge.widgets.c.d.b(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
        L_0x02c5:
            return
        L_0x02c6:
            if (r6 == 0) goto L_0x02cc
            r0.c(r1)
            return
        L_0x02cc:
            android.widget.TextView r2 = r0.f63893c
            if (r2 == 0) goto L_0x02d3
            r2.setVisibility(r8)
        L_0x02d3:
            android.widget.TextView r2 = r0.f63893c
            if (r2 == 0) goto L_0x02da
            r2.setText(r4)
        L_0x02da:
            java.lang.String r2 = r18.getPayType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r9)
            if (r2 == 0) goto L_0x030b
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x030a
            android.view.View r4 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_postpaid_wo_number
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r1 = r18.getOperatorDisplayLabel()
            r6[r8] = r1
            java.lang.String r1 = r4.getString(r5, r6)
            if (r1 == 0) goto L_0x0304
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0307
        L_0x0304:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0307:
            r2.setText(r1)
        L_0x030a:
            return
        L_0x030b:
            java.lang.String r2 = r18.getPayType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r2, (boolean) r9)
            if (r2 == 0) goto L_0x033c
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x033b
            android.view.View r4 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_prepaid_wo_number
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r1 = r18.getOperatorDisplayLabel()
            r6[r8] = r1
            java.lang.String r1 = r4.getString(r5, r6)
            if (r1 == 0) goto L_0x0335
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x0338
        L_0x0335:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0338:
            r2.setText(r1)
        L_0x033b:
            return
        L_0x033c:
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x0367
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r18.getOperatorDisplayLabel()
            r3.append(r4)
            r4 = 32
            r3.append(r4)
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r1 = r18.getPayType()
            java.lang.String r1 = net.one97.paytm.recharge.widgets.c.d.b(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
        L_0x0367:
            return
        L_0x0368:
            if (r6 == 0) goto L_0x036e
            r0.c(r1)
            return
        L_0x036e:
            android.widget.TextView r2 = r0.f63893c
            if (r2 == 0) goto L_0x0375
            r2.setVisibility(r8)
        L_0x0375:
            android.widget.TextView r2 = r0.f63893c
            if (r2 == 0) goto L_0x037e
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r2.setText(r10)
        L_0x037e:
            java.lang.String r2 = r18.getPayType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r9)
            if (r2 == 0) goto L_0x03af
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x03ae
            android.view.View r4 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_postpaid_wo_number
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r1 = r18.getOperatorDisplayLabel()
            r6[r8] = r1
            java.lang.String r1 = r4.getString(r5, r6)
            if (r1 == 0) goto L_0x03a8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x03ab
        L_0x03a8:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x03ab:
            r2.setText(r1)
        L_0x03ae:
            return
        L_0x03af:
            java.lang.String r2 = r18.getPayType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r2, (boolean) r9)
            if (r2 == 0) goto L_0x03e0
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x03df
            android.view.View r4 = r0.itemView
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            android.content.Context r4 = r4.getContext()
            int r5 = net.one97.paytm.recharge.R.string.recent_subtitle_suffix_prepaid_wo_number
            java.lang.Object[] r6 = new java.lang.Object[r9]
            java.lang.String r1 = r18.getOperatorDisplayLabel()
            r6[r8] = r1
            java.lang.String r1 = r4.getString(r5, r6)
            if (r1 == 0) goto L_0x03d9
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x03dc
        L_0x03d9:
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x03dc:
            r2.setText(r1)
        L_0x03df:
            return
        L_0x03e0:
            android.widget.TextView r2 = r0.f63895e
            if (r2 == 0) goto L_0x040b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r18.getOperatorDisplayLabel()
            r3.append(r4)
            r4 = 32
            r3.append(r4)
            net.one97.paytm.recharge.widgets.c.d r4 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r1 = r18.getPayType()
            java.lang.String r1 = net.one97.paytm.recharge.widgets.c.d.b(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
        L_0x040b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.mobile_v3.c.c.a(int, net.one97.paytm.common.entity.recharge.CJRFrequentOrder):void");
    }

    private final void c(CJRFrequentOrder cJRFrequentOrder) {
        CharSequence charSequence;
        CharSequence charSequence2;
        String rechargeNumber = cJRFrequentOrder.getRechargeNumber();
        if (rechargeNumber == null) {
            return;
        }
        if (kotlin.m.p.a(BaseViewModel.PaymentType.POSTPAID, cJRFrequentOrder.getPayType(), true)) {
            TextView textView = this.f63895e;
            if (textView != null) {
                View view = this.itemView;
                k.a((Object) view, "itemView");
                String string = view.getContext().getString(R.string.recent_subtitle_suffix_postpaid, new Object[]{rechargeNumber, cJRFrequentOrder.getOperatorDisplayLabel()});
                if (string != null) {
                    charSequence2 = string;
                } else {
                    charSequence2 = "";
                }
                textView.setText(charSequence2);
            }
        } else if (kotlin.m.p.a("prepaid", cJRFrequentOrder.getPayType(), true)) {
            TextView textView2 = this.f63895e;
            if (textView2 != null) {
                View view2 = this.itemView;
                k.a((Object) view2, "itemView");
                String string2 = view2.getContext().getString(R.string.recent_subtitle_suffix_prepaid, new Object[]{rechargeNumber, cJRFrequentOrder.getOperatorDisplayLabel()});
                if (string2 != null) {
                    charSequence = string2;
                } else {
                    charSequence = "";
                }
                textView2.setText(charSequence);
            }
        } else {
            TextView textView3 = this.f63895e;
            if (textView3 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(rechargeNumber);
                sb.append(", ");
                sb.append(cJRFrequentOrder.getOperatorDisplayLabel());
                sb.append(' ');
                d dVar = d.f64967a;
                sb.append(d.b(cJRFrequentOrder.getPayType()));
                textView3.setText(sb.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ContactItemModel contactItemModel, CJRFrequentOrder cJRFrequentOrder) {
        k.c(contactItemModel, "contact");
        k.c(cJRFrequentOrder, "recentOrder");
        String name = contactItemModel.getName();
        if (name == null) {
            name = "";
        }
        CharSequence charSequence = name;
        if (!TextUtils.isEmpty(charSequence)) {
            TextView textView = this.f63893c;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.f63893c;
            if (textView2 != null) {
                textView2.setText(charSequence);
            }
            cJRFrequentOrder.setContactName(name);
            TextView textView3 = this.f63895e;
            if (textView3 != null) {
                View view = this.itemView;
                k.a((Object) view, "itemView");
                textView3.setTextColor(b.c(view.getContext(), R.color.v3_status_info_1));
            }
            TextView textView4 = this.f63895e;
            if (textView4 != null) {
                textView4.setTextSize(2, 12.0f);
            }
        } else {
            TextView textView5 = this.f63893c;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.f63895e;
            if (textView6 != null) {
                View view2 = this.itemView;
                k.a((Object) view2, "itemView");
                textView6.setTextColor(b.c(view2.getContext(), R.color.color_222222));
            }
            TextView textView7 = this.f63895e;
            if (textView7 != null) {
                textView7.setTextSize(2, 15.0f);
            }
        }
        String photoUri = contactItemModel.getPhotoUri();
        if (photoUri == null) {
            photoUri = "";
        }
        if (!TextUtils.isEmpty(photoUri)) {
            ImageView imageView = this.f63896f;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView8 = this.f63894d;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            w.a().a(photoUri).a(R.drawable.v3_default_logo_contact).b(R.drawable.v3_default_logo_contact).a(this.f63896f);
            return;
        }
        TextView textView9 = this.f63895e;
        if (textView9 != null) {
            View view3 = this.itemView;
            k.a((Object) view3, "itemView");
            textView9.setTextColor(b.c(view3.getContext(), R.color.v3_status_info_1));
        }
        TextView textView10 = this.f63895e;
        if (textView10 != null) {
            textView10.setTextSize(2, 12.0f);
        }
        ImageView imageView2 = this.f63896f;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        TextView textView11 = this.f63894d;
        if (textView11 != null) {
            textView11.setVisibility(8);
        }
        String operatorLogoURL = cJRFrequentOrder.getOperatorLogoURL();
        if (!TextUtils.isEmpty(operatorLogoURL)) {
            ImageView imageView3 = this.f63896f;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            w.a().a(operatorLogoURL).a(this.f63896f);
            return;
        }
        ImageView imageView4 = this.f63896f;
        if (imageView4 != null) {
            imageView4.setImageResource(R.drawable.v3_default_logo_contact);
        }
    }

    public final void c() {
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView = this.k;
        if (cJRRechargeLottieAnimationView != null) {
            cJRRechargeLottieAnimationView.cancelAnimation();
        }
        CJRRechargeLottieAnimationView cJRRechargeLottieAnimationView2 = this.k;
        if (cJRRechargeLottieAnimationView2 != null) {
            cJRRechargeLottieAnimationView2.setVisibility(4);
        }
    }
}
