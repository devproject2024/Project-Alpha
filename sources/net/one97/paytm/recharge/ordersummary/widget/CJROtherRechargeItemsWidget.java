package net.one97.paytm.recharge.ordersummary.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.g;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.c.a;
import net.one97.paytm.recharge.ordersummary.c.c;
import net.one97.paytm.recharge.ordersummary.d.f;
import net.one97.paytm.recharge.ordersummary.d.s;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class CJROtherRechargeItemsWidget extends RelativeLayout implements View.OnClickListener, ai, g<a>, b.e {

    /* renamed from: b  reason: collision with root package name */
    public static final b f64459b = new b((byte) 0);
    /* access modifiers changed from: private */
    public static final int k = 0;
    /* access modifiers changed from: private */
    public static final int l = 1;
    /* access modifiers changed from: private */
    public static final int m = 2;
    /* access modifiers changed from: private */
    public static final int n = 3;

    /* renamed from: a  reason: collision with root package name */
    protected RecyclerView f64460a;

    /* renamed from: c  reason: collision with root package name */
    private androidx.fragment.app.b f64461c;

    /* renamed from: d  reason: collision with root package name */
    private io.reactivex.rxjava3.b.c f64462d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f64463e;

    /* renamed from: f  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f64464f;

    /* renamed from: g  reason: collision with root package name */
    private final int f64465g;

    /* renamed from: h  reason: collision with root package name */
    private final int f64466h;

    /* renamed from: i  reason: collision with root package name */
    private final List<CJROrderedCart> f64467i;
    private final net.one97.paytm.recharge.ordersummary.f.b j;

    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(getContext()).inflate(getAdapterResId(), viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…erResId(), parent, false)");
        return new a(this, inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0310, code lost:
        if (r6 == null) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0371, code lost:
        if (r6 == null) goto L_0x037a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x03d1, code lost:
        if (r6 == null) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d3, code lost:
        r10 = r10.getTransactionDetails();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e1, code lost:
        if (r10 != false) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f8, code lost:
        if (r0.f64463e == false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x028a, code lost:
        if (r6 == null) goto L_0x0293;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0416  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0430  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x043f  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(androidx.recyclerview.widget.RecyclerView.v r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r19
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$a r2 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r2
            java.lang.String r3 = "holder"
            kotlin.g.b.k.c(r2, r3)
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r4 = r0.f64467i
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r4.getProductDetail()
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r6 = r2.f64471a
            r7 = 8
            r6.setVisibility(r7)
            android.widget.ImageView r6 = r2.f64472b
            r6.setVisibility(r7)
            android.widget.TextView r6 = r2.f64473c
            r6.setVisibility(r7)
            android.widget.TextView r6 = r2.f64474d
            r6.setVisibility(r7)
            android.widget.TextView r6 = r2.f64475e
            r6.setVisibility(r7)
            net.one97.paytm.recharge.common.widget.CJRAmountView r6 = r2.f64476f
            r6.setVisibility(r7)
            android.widget.ProgressBar r6 = r2.f64477g
            r6.setVisibility(r7)
            android.widget.TextView r6 = r2.f64479i
            r6.setVisibility(r7)
            android.widget.TextView r6 = r2.f64479i
            r8 = 1
            r6.setEnabled(r8)
            r6 = -1
            r2.j = r6
            r6 = 0
            r2.k = r6
            r2.j = r1
            net.one97.paytm.recharge.ordersummary.h.b$a r9 = net.one97.paytm.recharge.ordersummary.h.b.f64312h
            android.view.View r9 = r2.itemView
            java.lang.String r10 = "holder.itemView"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            android.content.Context r9 = r9.getContext()
            java.lang.String r10 = "holder.itemView.context"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
            r10 = r0
            net.one97.paytm.recharge.ordersummary.h.b$e r10 = (net.one97.paytm.recharge.ordersummary.h.b.e) r10
            net.one97.paytm.recharge.ordersummary.b.a r11 = r0.f64464f
            boolean r11 = r11.s
            r12 = 0
            net.one97.paytm.recharge.ordersummary.h.b r9 = net.one97.paytm.recharge.ordersummary.h.b.a.a(r9, r10, r12, r12, r11)
            r2.f64478h = r9
            net.one97.paytm.recharge.ordersummary.h.b r9 = r2.f64478h
            if (r9 != 0) goto L_0x0078
            kotlin.g.b.k.a()
        L_0x0078:
            net.one97.paytm.recharge.ordersummary.h.c$a r10 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r10 = "productDetails"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
            long r10 = r5.getCategoryId()
            java.lang.String r13 = r4.getItemStatus()
            java.lang.String r14 = "orderCart.itemStatus"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            java.lang.String r10 = net.one97.paytm.recharge.ordersummary.h.c.a.a((long) r10, (java.lang.String) r13)
            r9.a((java.lang.String) r10)
            java.lang.String r9 = "orderedCart"
            kotlin.g.b.k.c(r4, r9)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r10 = r4.getTapAction()
            java.lang.String r11 = "7"
            if (r10 == 0) goto L_0x0102
            int r10 = r0.f64465g
            int r13 = n
            if (r10 != r13) goto L_0x00e4
            net.one97.paytm.recharge.ordersummary.b.a r10 = r0.f64464f
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r10 = r10.m
            long r13 = r4.getId()
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            java.lang.Object r10 = r10.get(r13)
            if (r10 == 0) goto L_0x00fd
            boolean r10 = r0.f64463e
            if (r10 == 0) goto L_0x00fb
            java.lang.String r10 = r4.getItemStatus()
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r11)
            r10 = r10 ^ r8
            if (r10 == 0) goto L_0x00fb
            net.one97.paytm.common.entity.shopping.CJRRefund r10 = r4.getRefund()
            if (r10 == 0) goto L_0x00e0
            java.util.ArrayList r10 = r10.getTransactionDetails()
            if (r10 == 0) goto L_0x00e0
            java.util.Collection r10 = (java.util.Collection) r10
            if (r10 == 0) goto L_0x00e0
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x00de
            goto L_0x00e0
        L_0x00de:
            r10 = 0
            goto L_0x00e1
        L_0x00e0:
            r10 = 1
        L_0x00e1:
            if (r10 == 0) goto L_0x00fb
            goto L_0x00fd
        L_0x00e4:
            net.one97.paytm.recharge.ordersummary.b.a r10 = r0.f64464f
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r10 = r10.m
            long r13 = r4.getId()
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            java.lang.Object r10 = r10.get(r13)
            if (r10 == 0) goto L_0x00fd
            boolean r10 = r0.f64463e
            if (r10 == 0) goto L_0x00fb
            goto L_0x00fd
        L_0x00fb:
            r10 = 0
            goto L_0x00fe
        L_0x00fd:
            r10 = 1
        L_0x00fe:
            if (r10 == 0) goto L_0x0102
            r10 = 1
            goto L_0x0103
        L_0x0102:
            r10 = 0
        L_0x0103:
            net.one97.paytm.recharge.widgets.c.d r13 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "OtherItems: isTapActionReqRequired : Required = "
            r13.<init>(r14)
            r13.append(r10)
            java.lang.String r14 = " Status = "
            r13.append(r14)
            java.lang.String r14 = r4.getItemStatus()
            r13.append(r14)
            java.lang.String r14 = " Name = "
            r13.append(r14)
            java.lang.String r14 = r4.getName()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r13)
            r13 = 4
            if (r10 == 0) goto L_0x0189
            android.widget.TextView r10 = r2.f64479i
            r10.setEnabled(r6)
            android.widget.TextView r10 = r2.f64479i
            r10.setVisibility(r13)
            android.widget.ProgressBar r10 = r2.f64477g
            r10.setVisibility(r6)
            net.one97.paytm.recharge.widgets.c.d r10 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r12)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r14 = r10.getFlowName()
            if (r14 == 0) goto L_0x0155
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r15 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r15 = r15.name()
            r14.setErrorType(r15)
        L_0x0155:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r14 = r10.getFlowName()
            if (r14 == 0) goto L_0x0164
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r15 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_TAP_ACTION
            java.lang.String r15 = r15.name()
            r14.setActionType(r15)
        L_0x0164:
            android.os.Bundle r14 = new android.os.Bundle
            r14.<init>()
            java.lang.String r15 = "position"
            r14.putInt(r15, r1)
            r10.setExtras(r14)
            net.one97.paytm.recharge.ordersummary.h.b r14 = r2.f64478h
            if (r14 != 0) goto L_0x0178
            kotlin.g.b.k.a()
        L_0x0178:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r15 = r4.getTapAction()
            java.lang.String r12 = "orderCart.tapAction"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r12)
            r12 = r0
            net.one97.paytm.recharge.common.e.ai r12 = (net.one97.paytm.recharge.common.e.ai) r12
            java.lang.String r13 = "tap_action"
            r14.a(r13, r15, r10, r12)
        L_0x0189:
            int r10 = r0.f64465g
            int r12 = n
            if (r10 == r12) goto L_0x01d0
            net.one97.paytm.recharge.ordersummary.b.a r10 = r0.f64464f
            java.lang.String r10 = r10.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            r12 = r10
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x01c6
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r12 = r2.f64471a
            r12.setVisibility(r6)
            android.widget.ImageView r12 = r2.f64472b
            r12.setVisibility(r7)
            com.squareup.picasso.w r12 = com.squareup.picasso.w.a()     // Catch:{ Exception -> 0x01c4 }
            com.squareup.picasso.aa r10 = r12.a((java.lang.String) r10)     // Catch:{ Exception -> 0x01c4 }
            int r12 = net.one97.paytm.recharge.R.drawable.ic_deals_default     // Catch:{ Exception -> 0x01c4 }
            com.squareup.picasso.aa r10 = r10.a((int) r12)     // Catch:{ Exception -> 0x01c4 }
            int r12 = net.one97.paytm.recharge.R.drawable.ic_deals_default     // Catch:{ Exception -> 0x01c4 }
            com.squareup.picasso.aa r10 = r10.b((int) r12)     // Catch:{ Exception -> 0x01c4 }
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r12 = r2.f64471a     // Catch:{ Exception -> 0x01c4 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x01c4 }
            r10.a((android.widget.ImageView) r12)     // Catch:{ Exception -> 0x01c4 }
            goto L_0x01d0
        L_0x01c4:
            goto L_0x01d0
        L_0x01c6:
            net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8 r10 = r2.f64471a
            r10.setVisibility(r7)
            android.widget.ImageView r10 = r2.f64472b
            r10.setVisibility(r6)
        L_0x01d0:
            android.widget.TextView r10 = r2.f64473c
            java.lang.String r12 = r4.getName()
            java.lang.String r13 = ""
            if (r12 == 0) goto L_0x01dd
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            goto L_0x01e0
        L_0x01dd:
            r12 = r13
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
        L_0x01e0:
            r10.setText(r12)
            android.widget.TextView r10 = r2.f64473c
            r10.setVisibility(r6)
            android.widget.TextView r10 = r2.f64474d
            java.lang.String r5 = r5.getBrandName()
            if (r5 == 0) goto L_0x01f3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            goto L_0x01f6
        L_0x01f3:
            r5 = r13
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
        L_0x01f6:
            r10.setText(r5)
            net.one97.paytm.recharge.widgets.c.d r5 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r5 = r4.getAggregateItemPrice()
            double r14 = net.one97.paytm.recharge.widgets.c.d.c(r5)
            r16 = 0
            int r5 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r5 < 0) goto L_0x022c
            int r5 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r5 != 0) goto L_0x0215
            net.one97.paytm.recharge.common.widget.CJRAmountView r5 = r2.f64476f
            int r10 = net.one97.paytm.recharge.R.string.recharge_deals_free
            r5.setText(r10)
            goto L_0x0234
        L_0x0215:
            net.one97.paytm.recharge.common.widget.CJRAmountView r5 = r2.f64476f
            net.one97.paytm.recharge.ordersummary.b.a r10 = r0.f64464f
            android.content.Context r12 = r18.getContext()
            java.lang.String r14 = "context"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r14)
            java.lang.String r10 = r10.g(r12, r4)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r5.setText(r10)
            goto L_0x0234
        L_0x022c:
            net.one97.paytm.recharge.common.widget.CJRAmountView r5 = r2.f64476f
            r10 = r13
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r5.setText(r10)
        L_0x0234:
            net.one97.paytm.recharge.common.widget.CJRAmountView r5 = r2.f64476f
            r5.setVisibility(r6)
            net.one97.paytm.recharge.ordersummary.b.a r5 = r0.f64464f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r5.f63998b
            if (r5 == 0) goto L_0x0248
            int r5 = r5.getOrderStatus()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
            goto L_0x0249
        L_0x0248:
            r12 = 0
        L_0x0249:
            java.lang.String r5 = "18"
            java.lang.String r10 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r14 = "(this as java.lang.String).toLowerCase()"
            if (r12 != 0) goto L_0x0253
            goto L_0x02c5
        L_0x0253:
            int r15 = r12.intValue()
            r6 = 2
            if (r15 != r6) goto L_0x02c5
            java.lang.String r6 = r4.getItemStatus()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r11)
            if (r6 == 0) goto L_0x02c5
            android.widget.TextView r6 = r2.f64475e
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.color.color_21c17a
            int r12 = androidx.core.content.b.c(r12, r15)
            r6.setTextColor(r12)
            int r6 = r0.f64465g
            int r12 = n
            if (r6 != r12) goto L_0x040a
            net.one97.paytm.recharge.ordersummary.h.c$a r6 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r6 = r4.getStatus()
            if (r6 == 0) goto L_0x0293
            if (r6 == 0) goto L_0x028d
            java.lang.String r6 = r6.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r14)
            if (r6 != 0) goto L_0x0294
            goto L_0x0293
        L_0x028d:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r10)
            throw r1
        L_0x0293:
            r6 = r13
        L_0x0294:
            java.lang.String r6 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r6)
            r12 = r6
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x02ab
            android.content.Context r6 = r18.getContext()
            int r12 = net.one97.paytm.recharge.R.string.v8_os_status_item_success
            java.lang.String r6 = r6.getString(r12)
        L_0x02ab:
            android.widget.TextView r12 = r2.f64475e
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            android.widget.TextView r6 = r2.f64479i
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.string.v8_os_status_item_success_view_details
            java.lang.String r12 = r12.getString(r15)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r6.setText(r12)
            goto L_0x040a
        L_0x02c5:
            if (r12 != 0) goto L_0x02c8
            goto L_0x02ce
        L_0x02c8:
            int r6 = r12.intValue()
            if (r6 == r7) goto L_0x03ab
        L_0x02ce:
            net.one97.paytm.recharge.ordersummary.b.a r6 = r0.f64464f
            boolean r6 = r6.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            if (r6 != 0) goto L_0x03ab
            java.lang.String r6 = r4.getItemStatus()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r5)
            if (r6 == 0) goto L_0x02e2
            goto L_0x03ab
        L_0x02e2:
            net.one97.paytm.recharge.ordersummary.b.a r6 = r0.f64464f
            boolean r6 = r6.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            if (r6 == 0) goto L_0x034b
            android.widget.TextView r6 = r2.f64475e
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.color.color_fd5c5c
            int r12 = androidx.core.content.b.c(r12, r15)
            r6.setTextColor(r12)
            int r6 = r0.f64465g
            int r12 = n
            if (r6 != r12) goto L_0x040a
            net.one97.paytm.recharge.ordersummary.h.c$a r6 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r6 = r4.getStatus()
            if (r6 == 0) goto L_0x0319
            if (r6 == 0) goto L_0x0313
            java.lang.String r6 = r6.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r14)
            if (r6 != 0) goto L_0x031a
            goto L_0x0319
        L_0x0313:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r10)
            throw r1
        L_0x0319:
            r6 = r13
        L_0x031a:
            java.lang.String r6 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r6)
            r12 = r6
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0331
            android.content.Context r6 = r18.getContext()
            int r12 = net.one97.paytm.recharge.R.string.v8_os_status_item_failed
            java.lang.String r6 = r6.getString(r12)
        L_0x0331:
            android.widget.TextView r12 = r2.f64475e
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            android.widget.TextView r6 = r2.f64479i
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.string.v8_os_status_item_failed_view_details
            java.lang.String r12 = r12.getString(r15)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r6.setText(r12)
            goto L_0x040a
        L_0x034b:
            android.widget.TextView r6 = r2.f64475e
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.color.color_ffa400
            int r12 = androidx.core.content.b.c(r12, r15)
            r6.setTextColor(r12)
            int r6 = r0.f64465g
            int r12 = n
            if (r6 != r12) goto L_0x040a
            net.one97.paytm.recharge.ordersummary.h.c$a r6 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r6 = r4.getStatus()
            if (r6 == 0) goto L_0x037a
            if (r6 == 0) goto L_0x0374
            java.lang.String r6 = r6.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r14)
            if (r6 != 0) goto L_0x037b
            goto L_0x037a
        L_0x0374:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r10)
            throw r1
        L_0x037a:
            r6 = r13
        L_0x037b:
            java.lang.String r6 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r6)
            r12 = r6
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x0392
            android.content.Context r6 = r18.getContext()
            int r12 = net.one97.paytm.recharge.R.string.v8_os_status_item_pending
            java.lang.String r6 = r6.getString(r12)
        L_0x0392:
            android.widget.TextView r12 = r2.f64475e
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            android.widget.TextView r6 = r2.f64479i
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.string.v8_os_status_item_pending_view_details
            java.lang.String r12 = r12.getString(r15)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r6.setText(r12)
            goto L_0x040a
        L_0x03ab:
            android.widget.TextView r6 = r2.f64475e
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.color.color_999999
            int r12 = androidx.core.content.b.c(r12, r15)
            r6.setTextColor(r12)
            int r6 = r0.f64465g
            int r12 = n
            if (r6 != r12) goto L_0x040a
            net.one97.paytm.recharge.ordersummary.h.c$a r6 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r6 = r4.getStatus()
            if (r6 == 0) goto L_0x03da
            if (r6 == 0) goto L_0x03d4
            java.lang.String r6 = r6.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r14)
            if (r6 != 0) goto L_0x03db
            goto L_0x03da
        L_0x03d4:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r10)
            throw r1
        L_0x03da:
            r6 = r13
        L_0x03db:
            java.lang.String r6 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r6)
            r12 = r6
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x03f2
            android.content.Context r6 = r18.getContext()
            int r12 = net.one97.paytm.recharge.R.string.v8_os_status_item_cancelled
            java.lang.String r6 = r6.getString(r12)
        L_0x03f2:
            android.widget.TextView r12 = r2.f64475e
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r12.setText(r6)
            android.widget.TextView r6 = r2.f64479i
            android.content.Context r12 = r18.getContext()
            int r15 = net.one97.paytm.recharge.R.string.v8_os_status_item_cancelled_view_details
            java.lang.String r12 = r12.getString(r15)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r6.setText(r12)
        L_0x040a:
            android.view.View r6 = r2.itemView
            int r12 = net.one97.paytm.recharge.R.id.divider
            android.view.View r6 = r6.findViewById(r12)
            androidx.recyclerview.widget.RecyclerView r12 = r0.f64460a
            if (r12 != 0) goto L_0x041b
            java.lang.String r15 = "mRecyclerView"
            kotlin.g.b.k.a((java.lang.String) r15)
        L_0x041b:
            androidx.recyclerview.widget.RecyclerView$a r12 = r12.getAdapter()
            if (r12 != 0) goto L_0x0424
            kotlin.g.b.k.a()
        L_0x0424:
            java.lang.String r15 = "mRecyclerView.adapter!!"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r15)
            int r12 = r12.getItemCount()
            int r12 = r12 - r8
            if (r1 != r12) goto L_0x0439
            java.lang.String r1 = "divider"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            r1 = 4
            r6.setVisibility(r1)
        L_0x0439:
            int r1 = r0.f64465g
            int r6 = l
            if (r1 != r6) goto L_0x0485
            kotlin.g.b.k.c(r2, r3)
            kotlin.g.b.k.c(r4, r9)
            android.widget.TextView r1 = r2.f64475e
            net.one97.paytm.recharge.ordersummary.h.c$a r3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r3 = r4.getStatus()
            if (r3 == 0) goto L_0x0463
            if (r3 == 0) goto L_0x045d
            java.lang.String r3 = r3.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r14)
            if (r3 != 0) goto L_0x045b
            goto L_0x0463
        L_0x045b:
            r13 = r3
            goto L_0x0463
        L_0x045d:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r10)
            throw r1
        L_0x0463:
            java.lang.String r3 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r13)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r2.f64475e
            r3 = 0
            r1.setVisibility(r3)
            java.lang.String r1 = r4.getItemStatus()
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r11)
            if (r1 == 0) goto L_0x0484
            android.widget.TextView r1 = r2.f64479i
            r2 = r0
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
        L_0x0484:
            return
        L_0x0485:
            int r6 = m
            if (r1 != r6) goto L_0x0550
            kotlin.g.b.k.c(r2, r3)
            kotlin.g.b.k.c(r4, r9)
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f64464f
            boolean r1 = r1.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            if (r1 != 0) goto L_0x0503
            java.lang.String r1 = r4.getItemStatus()
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x04a2
            goto L_0x0503
        L_0x04a2:
            android.widget.TextView r1 = r2.f64479i
            r3 = 0
            r1.setVisibility(r3)
            android.widget.ProgressBar r1 = r2.f64477g
            r1.setVisibility(r7)
            android.widget.TextView r1 = r2.f64475e
            net.one97.paytm.recharge.ordersummary.h.c$a r3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r3 = r4.getStatus()
            if (r3 == 0) goto L_0x04cb
            if (r3 == 0) goto L_0x04c5
            java.lang.String r3 = r3.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r14)
            if (r3 != 0) goto L_0x04c3
            goto L_0x04cb
        L_0x04c3:
            r13 = r3
            goto L_0x04cb
        L_0x04c5:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r10)
            throw r1
        L_0x04cb:
            java.lang.String r3 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r13)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r2.f64475e
            r3 = 0
            r1.setVisibility(r3)
            android.widget.TextView r1 = r2.f64479i
            android.content.Context r3 = r18.getContext()
            int r4 = net.one97.paytm.recharge.R.color.color_os_blue
            int r3 = androidx.core.content.b.c(r3, r4)
            r1.setTextColor(r3)
            android.widget.TextView r1 = r2.f64479i
            android.content.Context r3 = r18.getContext()
            int r4 = net.one97.paytm.recharge.R.string.v8_os_other_items_insurance_view_policy_details
            java.lang.String r3 = r3.getString(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r2.f64479i
            r2 = r0
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            return
        L_0x0503:
            android.widget.TextView r1 = r2.f64475e
            int r3 = net.one97.paytm.recharge.R.style.OSInsuranceStatusCancelled
            androidx.core.widget.i.a((android.widget.TextView) r1, (int) r3)
            android.widget.TextView r1 = r2.f64475e
            android.content.Context r3 = r18.getContext()
            if (r3 == 0) goto L_0x0519
            int r4 = net.one97.paytm.recharge.R.string.v8_os_status_item_cancelled
            java.lang.String r12 = r3.getString(r4)
            goto L_0x051a
        L_0x0519:
            r12 = 0
        L_0x051a:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r1.setText(r12)
            android.widget.TextView r1 = r2.f64475e
            r3 = 0
            r1.setVisibility(r3)
            android.widget.TextView r1 = r2.f64479i
            int r4 = net.one97.paytm.recharge.R.style.OSRechargeItemViewRefundDetails
            androidx.core.widget.i.a((android.widget.TextView) r1, (int) r4)
            android.widget.TextView r1 = r2.f64479i
            android.content.Context r4 = r18.getContext()
            int r5 = net.one97.paytm.recharge.R.string.v8_os_status_item_cancelled_view_details
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            android.widget.TextView r1 = r2.f64479i
            r1.setVisibility(r3)
            android.widget.ProgressBar r1 = r2.f64477g
            r1.setVisibility(r7)
            android.widget.TextView r1 = r2.f64479i
            r2 = r0
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            return
        L_0x0550:
            int r5 = n
            if (r1 != r5) goto L_0x0558
            r0.a((net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r2, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            return
        L_0x0558:
            kotlin.g.b.k.c(r2, r3)
            kotlin.g.b.k.c(r4, r9)
            android.widget.TextView r1 = r2.f64475e
            net.one97.paytm.recharge.ordersummary.h.c$a r3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r3 = r4.getStatus()
            if (r3 == 0) goto L_0x057c
            if (r3 == 0) goto L_0x0576
            java.lang.String r3 = r3.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r14)
            if (r3 != 0) goto L_0x0574
            goto L_0x057c
        L_0x0574:
            r13 = r3
            goto L_0x057c
        L_0x0576:
            kotlin.u r1 = new kotlin.u
            r1.<init>(r10)
            throw r1
        L_0x057c:
            java.lang.String r3 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r13)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r2.f64475e
            r3 = 0
            r1.setVisibility(r3)
            android.widget.TextView r1 = r2.f64479i
            r1.setVisibility(r3)
            android.widget.TextView r1 = r2.f64479i
            android.content.Context r3 = r18.getContext()
            int r4 = net.one97.paytm.recharge.R.string.view_details_re
            java.lang.String r3 = r3.getString(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r1 = r2.f64479i
            r2 = r0
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final net.one97.paytm.recharge.ordersummary.b.a getViewModel() {
        return this.f64464f;
    }

    public final int getViewType() {
        return this.f64465g;
    }

    public final int getVisibilityType() {
        return this.f64466h;
    }

    public final List<CJROrderedCart> getOrderedItems() {
        return this.f64467i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJROtherRechargeItemsWidget(android.content.Context r9, net.one97.paytm.recharge.ordersummary.b.a r10, int r11, int r12, net.one97.paytm.recharge.ordersummary.f.b r13) {
        /*
            r8 = this;
            int r0 = l
            if (r11 != r0) goto L_0x000a
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r10.f64005i
            java.util.List r0 = (java.util.List) r0
        L_0x0008:
            r6 = r0
            goto L_0x0021
        L_0x000a:
            int r0 = m
            if (r11 != r0) goto L_0x0013
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r10.j
            java.util.List r0 = (java.util.List) r0
            goto L_0x0008
        L_0x0013:
            int r0 = n
            if (r11 != r0) goto L_0x001c
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r10.k
            java.util.List r0 = (java.util.List) r0
            goto L_0x0008
        L_0x001c:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r10.l
            java.util.List r0 = (java.util.List) r0
            goto L_0x0008
        L_0x0021:
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r7 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.<init>(android.content.Context, net.one97.paytm.recharge.ordersummary.b.a, int, int, net.one97.paytm.recharge.ordersummary.f.b):void");
    }

    public final net.one97.paytm.recharge.ordersummary.f.b getActionListener() {
        return this.j;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private CJROtherRechargeItemsWidget(Context context, net.one97.paytm.recharge.ordersummary.b.a aVar, int i2, int i3, List<? extends CJROrderedCart> list, net.one97.paytm.recharge.ordersummary.f.b bVar) {
        super(context);
        k.c(context, "context");
        k.c(aVar, "viewModel");
        k.c(list, "orderedItems");
        k.c(bVar, "actionListener");
        this.f64464f = aVar;
        this.f64465g = i2;
        this.f64466h = i3;
        this.f64467i = list;
        this.j = bVar;
        e();
        this.f64462d = this.f64464f.f63999c.subscribe(new io.reactivex.rxjava3.d.g<CJROrderSummary>(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJROtherRechargeItemsWidget f64468a;

            {
                this.f64468a = r1;
            }

            public final /* synthetic */ void accept(Object obj) {
                CJROrderSummary cJROrderSummary = (CJROrderSummary) obj;
                CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget = this.f64468a;
                k.a((Object) cJROrderSummary, "it");
                cJROtherRechargeItemsWidget.a(cJROrderSummary);
            }
        }, AnonymousClass2.f64469a, AnonymousClass3.f64470a);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final RecyclerView getMRecyclerView() {
        RecyclerView recyclerView = this.f64460a;
        if (recyclerView == null) {
            k.a("mRecyclerView");
        }
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public final void setMRecyclerView(RecyclerView recyclerView) {
        k.c(recyclerView, "<set-?>");
        this.f64460a = recyclerView;
    }

    /* access modifiers changed from: protected */
    public final androidx.fragment.app.b getDialogFragment() {
        return this.f64461c;
    }

    /* access modifiers changed from: protected */
    public final void setDialogFragment(androidx.fragment.app.b bVar) {
        this.f64461c = bVar;
    }

    /* access modifiers changed from: protected */
    public final io.reactivex.rxjava3.b.c getDisposableOrderSummaryRes() {
        return this.f64462d;
    }

    /* access modifiers changed from: protected */
    public final void setDisposableOrderSummaryRes(io.reactivex.rxjava3.b.c cVar) {
        this.f64462d = cVar;
    }

    /* access modifiers changed from: protected */
    public final boolean getUpdateWithNewTapActionRes() {
        return this.f64463e;
    }

    /* access modifiers changed from: protected */
    public final void setUpdateWithNewTapActionRes(boolean z) {
        this.f64463e = z;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        io.reactivex.rxjava3.b.c cVar = this.f64462d;
        if (cVar != null) {
            if (cVar == null) {
                k.a();
            }
            if (!cVar.isDisposed()) {
                io.reactivex.rxjava3.b.c cVar2 = this.f64462d;
                if (cVar2 == null) {
                    k.a();
                }
                cVar2.dispose();
            }
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r8 = this;
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.f64467i
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0184
            r0 = -1
            r8.setBackgroundColor(r0)
            android.content.Context r0 = r8.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = r8.getLayoutResId()
            r3 = r8
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            r0.inflate(r2, r3, r1)
            int r0 = r8.f64465g
            int r2 = l
            r3 = 0
            java.lang.String r4 = "findViewById<TextView>(R.id.header_deal_details)"
            if (r0 != r2) goto L_0x0044
            int r0 = net.one97.paytm.recharge.R.id.header_deal_details
            android.view.View r0 = r8.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.Context r1 = r8.getContext()
            int r2 = net.one97.paytm.recharge.R.string.deals
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x013c
        L_0x0044:
            int r2 = m
            if (r0 != r2) goto L_0x0061
            int r0 = net.one97.paytm.recharge.R.id.header_deal_details
            android.view.View r0 = r8.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.Context r1 = r8.getContext()
            int r2 = net.one97.paytm.recharge.R.string.v8_os_other_items_insurance_title
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x013c
        L_0x0061:
            int r2 = n
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r6 = "(this as java.lang.String).toLowerCase()"
            r7 = 0
            if (r0 != r2) goto L_0x00d4
            net.one97.paytm.recharge.ordersummary.b.a r0 = r8.f64464f
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
            if (r0 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x0085
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x0085
            java.lang.String r7 = r0.getPayTypeLabel()
        L_0x0085:
            int r0 = net.one97.paytm.recharge.R.id.header_deal_details
            android.view.View r0 = r8.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2 = r7
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00c4
            net.one97.paytm.recharge.ordersummary.h.c$a r2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            if (r7 != 0) goto L_0x00a0
            kotlin.g.b.k.a()
        L_0x00a0:
            if (r7 == 0) goto L_0x00be
            java.lang.String r2 = r7.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.String r2 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r2)
            android.content.Context r4 = r8.getContext()
            int r5 = net.one97.paytm.recharge.R.string.v8_os_recharge_items_title
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r2
            java.lang.String r1 = r4.getString(r5, r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x00d0
        L_0x00be:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r5)
            throw r0
        L_0x00c4:
            android.content.Context r1 = r8.getContext()
            int r2 = net.one97.paytm.recharge.R.string.v8_os_recharge_items_title_default
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x00d0:
            r0.setText(r1)
            goto L_0x013f
        L_0x00d4:
            int r0 = net.one97.paytm.recharge.R.id.header_deal_details
            android.view.View r0 = r8.findViewById(r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r2 = r8.f64467i
            int r2 = r2.size()
            if (r2 != r1) goto L_0x0130
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r1 = r8.f64467i
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x00ff
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x00ff
            java.lang.String r7 = r1.getPayTypeLabel()
        L_0x00ff:
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0123
            net.one97.paytm.recharge.ordersummary.h.c$a r1 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            if (r7 != 0) goto L_0x010f
            kotlin.g.b.k.a()
        L_0x010f:
            if (r7 == 0) goto L_0x011d
            java.lang.String r1 = r7.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r1)
            goto L_0x012d
        L_0x011d:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r5)
            throw r0
        L_0x0123:
            android.content.Context r1 = r8.getContext()
            int r2 = net.one97.paytm.recharge.R.string.v8_os_extra_items_title_default
            java.lang.String r1 = r1.getString(r2)
        L_0x012d:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            goto L_0x013c
        L_0x0130:
            android.content.Context r1 = r8.getContext()
            int r2 = net.one97.paytm.recharge.R.string.v8_os_extra_items_title_default
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x013c:
            r0.setText(r1)
        L_0x013f:
            int r0 = net.one97.paytm.recharge.R.id.recycler_view
            android.view.View r0 = r8.findViewById(r0)
            java.lang.String r1 = "findViewById(R.id.recycler_view)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r8.f64460a = r0
            androidx.recyclerview.widget.RecyclerView r0 = r8.f64460a
            java.lang.String r1 = "mRecyclerView"
            if (r0 != 0) goto L_0x0157
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0157:
            r0.setNestedScrollingEnabled(r3)
            androidx.recyclerview.widget.RecyclerView r0 = r8.f64460a
            if (r0 != 0) goto L_0x0161
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0161:
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r8.getContext()
            r2.<init>(r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r0.setLayoutManager(r2)
            androidx.recyclerview.widget.RecyclerView r0 = r8.f64460a
            if (r0 != 0) goto L_0x0176
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0176:
            net.one97.paytm.recharge.common.a.i r1 = new net.one97.paytm.recharge.common.a.i
            r2 = r8
            net.one97.paytm.recharge.common.e.g r2 = (net.one97.paytm.recharge.common.e.g) r2
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView$a r1 = (androidx.recyclerview.widget.RecyclerView.a) r1
            r0.setAdapter(r1)
            return
        L_0x0184:
            r0 = 8
            r8.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.e():void");
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderSummary");
        if (getContext() != null && this.j.getSupportFragmentManager() != null) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a("OtherItems: Notified order-summary response changed : ViewType = " + this.f64465g);
            this.f64463e = true;
            RecyclerView recyclerView = this.f64460a;
            if (recyclerView == null) {
                k.a("mRecyclerView");
            }
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        int i2 = this.f64465g;
        if (i2 == l || i2 == m) {
            return R.layout.v8_content_os_deal_details;
        }
        if (i2 == n) {
            return R.layout.v8_content_os_deal_details;
        }
        return R.layout.v8_content_os_deal_details;
    }

    /* access modifiers changed from: protected */
    public int getAdapterResId() {
        int i2 = this.f64465g;
        if (i2 == l || i2 == m) {
            return R.layout.v8_content_os_deal_details_item;
        }
        if (i2 == n) {
            return R.layout.v8_content_os_deal_details_item;
        }
        return R.layout.v8_content_os_deal_details_item;
    }

    public int getItemCount() {
        return this.f64467i.size();
    }

    public final long c_(int i2) {
        return this.f64467i.get(i2).getId();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a r9, net.one97.paytm.common.entity.shopping.CJROrderedCart r10) {
        /*
            r8 = this;
            java.lang.String r0 = "holder"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "orderedCart"
            kotlin.g.b.k.c(r10, r0)
            android.view.View r0 = r9.itemView
            int r1 = net.one97.paytm.recharge.R.id.container_img_deal
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "holder.itemView.findView…(R.id.container_img_deal)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r9.f64473c
            net.one97.paytm.recharge.ordersummary.b.a r2 = r8.f64464f
            android.content.Context r3 = r8.getContext()
            java.lang.String r4 = "context"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r2 = r2.c((android.content.Context) r3, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r9.f64479i
            r2 = r8
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r8.f64464f
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r0 = r0.m
            long r2 = r10.getId()
            java.lang.Long r10 = java.lang.Long.valueOf(r2)
            java.lang.Object r10 = r0.get(r10)
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r10 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r10
            r0 = 0
            r2 = 0
            if (r10 == 0) goto L_0x0092
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r10 = r10.getItemLevelActions()
            if (r10 == 0) goto L_0x0092
            java.util.List r10 = r10.getActions()
            if (r10 == 0) goto L_0x0092
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0064:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r10.next()
            r4 = r3
            net.one97.paytm.recharge.model.CJROSActionItemV2 r4 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r4
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r5 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r5 = r5.getACTION_TYPE_VIEW_DETAILS()
            java.lang.String r6 = r4.getmType()
            r7 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r7)
            if (r5 == 0) goto L_0x0089
            int r4 = r4.getVisibilityMultiItem()
            if (r4 != r7) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r7 = 0
        L_0x008a:
            if (r7 == 0) goto L_0x0064
            goto L_0x008e
        L_0x008d:
            r3 = r2
        L_0x008e:
            r10 = r3
            net.one97.paytm.recharge.model.CJROSActionItemV2 r10 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r10
            goto L_0x0093
        L_0x0092:
            r10 = r2
        L_0x0093:
            if (r10 == 0) goto L_0x0099
            java.lang.String r2 = r10.getLabel()
        L_0x0099:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00c1
            android.widget.TextView r2 = r9.f64479i
            if (r10 != 0) goto L_0x00a8
            kotlin.g.b.k.a()
        L_0x00a8:
            java.lang.String r3 = r10.getLabel()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r8.f64464f
            int r3 = r8.f64466h
            boolean r10 = r2.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r10, (int) r3, false)
            if (r10 != 0) goto L_0x00c1
            android.widget.TextView r10 = r9.f64479i
            r10.setVisibility(r1)
            goto L_0x00c6
        L_0x00c1:
            android.widget.TextView r10 = r9.f64479i
            r10.setVisibility(r0)
        L_0x00c6:
            android.widget.TextView r10 = r9.f64475e
            r10.setVisibility(r0)
            android.view.View r10 = r9.itemView
            boolean r10 = r10 instanceof androidx.constraintlayout.widget.ConstraintLayout
            if (r10 == 0) goto L_0x00f3
            android.view.View r9 = r9.itemView
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            androidx.constraintlayout.widget.c r10 = new androidx.constraintlayout.widget.c
            r10.<init>()
            r10.b((androidx.constraintlayout.widget.ConstraintLayout) r9)
            int r0 = net.one97.paytm.recharge.R.id.divider
            int r1 = com.paytm.utility.b.c((int) r1)
            r10.a((int) r0, (int) r1)
            int r3 = net.one97.paytm.recharge.R.id.divider
            r4 = 1
            r5 = 0
            r6 = 1
            r7 = 0
            r2 = r10
            r2.a(r3, r4, r5, r6, r7)
            r10.c((androidx.constraintlayout.widget.ConstraintLayout) r9)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a(net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$a, net.one97.paytm.common.entity.shopping.CJROrderedCart):void");
    }

    private void a(String str, int i2) {
        k.c(str, "tag");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
        }
        Bundle bundle = new Bundle();
        bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
        a2.setExtras(bundle);
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64464f;
        CJROrderSummary cJROrderSummary = aVar.f63998b;
        if (cJROrderSummary == null) {
            k.a();
        }
        String id = cJROrderSummary.getId();
        k.a((Object) id, "viewModel.getOrderSummaryResponse()!!.id");
        aVar.a(str, id, "", this, a2);
    }

    public final void a(Bundle bundle) {
        int i2 = -1;
        if (bundle != null) {
            i2 = bundle.getInt("extra_intent_item_position", -1);
        }
        RecyclerView recyclerView = this.f64460a;
        if (recyclerView == null) {
            k.a("mRecyclerView");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            k.a();
        }
        k.a((Object) adapter, "mRecyclerView.adapter!!");
        int itemCount = adapter.getItemCount();
        if (i2 >= 0 && itemCount >= i2) {
            a("fetch_order_detail", i2);
        }
    }

    public final void b(Bundle bundle) {
        int i2 = -1;
        if (bundle != null) {
            i2 = bundle.getInt("extra_intent_item_position", -1);
        }
        RecyclerView recyclerView = this.f64460a;
        if (recyclerView == null) {
            k.a("mRecyclerView");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            k.a();
        }
        k.a((Object) adapter, "mRecyclerView.adapter!!");
        int itemCount = adapter.getItemCount();
        if (i2 >= 0 && itemCount >= i2) {
            RecyclerView recyclerView2 = this.f64460a;
            if (recyclerView2 == null) {
                k.a("mRecyclerView");
            }
            RecyclerView.a adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyItemChanged(i2);
            }
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJROtherRechargeItemsWidget f64480a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f64481b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.ordersummary.c.c f64482c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f64483d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CJROrderSummaryAction f64484e;

        c(CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget, a aVar, net.one97.paytm.recharge.ordersummary.c.c cVar, int i2, CJROrderSummaryAction cJROrderSummaryAction) {
            this.f64480a = cJROtherRechargeItemsWidget;
            this.f64481b = aVar;
            this.f64482c = cVar;
            this.f64483d = i2;
            this.f64484e = cJROrderSummaryAction;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            androidx.fragment.app.b dialogFragment;
            if (i2 == -2) {
                this.f64481b.f64479i.setEnabled(true);
                this.f64481b.f64479i.setClickable(true);
                this.f64481b.f64477g.setVisibility(8);
                this.f64482c.dismiss();
                androidx.fragment.app.b dialogFragment2 = this.f64480a.getDialogFragment();
                if (dialogFragment2 != null) {
                    dialogFragment2.dismissAllowingStateLoss();
                }
                androidx.fragment.app.b dialogFragment3 = this.f64480a.getDialogFragment();
                boolean z = false;
                if (!(dialogFragment3 != null ? dialogFragment3.isVisible() : false)) {
                    androidx.fragment.app.b dialogFragment4 = this.f64480a.getDialogFragment();
                    if (dialogFragment4 != null) {
                        z = dialogFragment4.isAdded();
                    }
                    if (!z && this.f64480a.getActionListener().getSupportFragmentManager() != null && (dialogFragment = this.f64480a.getDialogFragment()) != null) {
                        j supportFragmentManager = this.f64480a.getActionListener().getSupportFragmentManager();
                        if (supportFragmentManager == null) {
                            k.a();
                        }
                        a.C1256a aVar = net.one97.paytm.recharge.ordersummary.c.a.f64019d;
                        dialogFragment.show(supportFragmentManager, net.one97.paytm.recharge.ordersummary.c.a.k);
                        return;
                    }
                    return;
                }
                return;
            }
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.OS_TAP_ACTION.name());
            }
            Bundle bundle = new Bundle();
            bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, this.f64483d);
            a2.setExtras(bundle);
            net.one97.paytm.recharge.ordersummary.h.b bVar = this.f64481b.f64478h;
            if (bVar != null) {
                bVar.a("fetch_hit_cancel_api", this.f64484e, a2, this.f64480a);
            }
            this.f64482c.dismiss();
            this.f64480a.getActionListener().at_();
            androidx.fragment.app.b dialogFragment5 = this.f64480a.getDialogFragment();
            if (dialogFragment5 != null) {
                dialogFragment5.dismissAllowingStateLoss();
            }
        }
    }

    public void onClick(View view) {
        List<CJROSActionItemV2> actions;
        String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.container_img_deal;
        if (valueOf == null || valueOf.intValue() != i2) {
            int i3 = R.id.txt_action;
            if (valueOf != null && valueOf.intValue() == i3) {
                RecyclerView recyclerView = this.f64460a;
                if (recyclerView == null) {
                    k.a("mRecyclerView");
                }
                RecyclerView.v findContainingViewHolder = recyclerView.findContainingViewHolder(view);
                if (!(findContainingViewHolder instanceof a)) {
                    findContainingViewHolder = null;
                }
                a aVar = (a) findContainingViewHolder;
                if (aVar != null) {
                    int adapterPosition = aVar.getAdapterPosition();
                    CJROrderedCart cJROrderedCart = this.f64467i.get(adapterPosition);
                    CJROSActionResponseV2 cJROSActionResponseV2 = this.f64464f.m.get(Long.valueOf(cJROrderedCart.getId()));
                    CJROSActionItemV2 cJROSActionItemV2 = (cJROSActionResponseV2 == null || (actions = cJROSActionResponseV2.getActions()) == null) ? null : (CJROSActionItemV2) kotlin.a.k.a(actions, 0);
                    if (net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
                        aVar.f64479i.setEnabled(true);
                        aVar.f64479i.setClickable(true);
                        this.j.o();
                        aVar.f64477g.setVisibility(8);
                        return;
                    }
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    net.one97.paytm.recharge.widgets.c.d.a("OtherItems: Action button clicked : ViewType = " + this.f64465g + " item = " + cJROrderedCart.getId() + " Position = " + adapterPosition);
                    int i4 = this.f64465g;
                    if (i4 == l) {
                        aVar.f64479i.setEnabled(false);
                        aVar.f64477g.setVisibility(0);
                        Bundle bundle = new Bundle();
                        bundle.putInt("extra_intent_item_position", adapterPosition);
                        net.one97.paytm.recharge.ordersummary.h.b bVar = aVar.f64478h;
                        if (bVar != null) {
                            if (cJROSActionItemV2 == null) {
                                k.a();
                            }
                            CJROrderSummaryAction cJROrderSummaryAction = cJROSActionItemV2;
                            net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                            CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                            k.c("tab_action_view_or_redeem", "tag");
                            k.c(cJROrderSummaryAction, "action");
                            ai aiVar = bVar;
                            k.c("tab_action_view_or_redeem", "tag");
                            k.c(cJROrderSummaryAction, "action");
                            k.c(aiVar, "responseListener");
                            bVar.f64315c = bundle;
                            bVar.a("tab_action_view_or_redeem", cJROrderSummaryAction, a2, aiVar);
                        }
                    } else if (i4 == m || i4 == k) {
                        if (this.f64464f.a(cJROrderedCart) || !(!k.a((Object) cJROrderedCart.getItemStatus(), (Object) "18"))) {
                            net.one97.paytm.recharge.ordersummary.f.b bVar2 = this.j;
                            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64464f;
                            bVar2.a(aVar2, cJROrderedCart, aVar2.l());
                            return;
                        }
                        aVar.f64479i.setEnabled(false);
                        aVar.f64479i.setClickable(false);
                        this.f64461c = this.j.a(this.f64464f, cJROrderedCart, this.f64465g, new d(this, aVar, adapterPosition), new e(this, aVar));
                    } else if (i4 != n) {
                    } else {
                        if (!k.a((Object) cJROrderedCart.getItemStatus(), (Object) "7")) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("recharge.component.name", f.class.getName());
                            this.j.a(this.f64464f, cJROrderedCart, bundle2);
                            return;
                        }
                        Bundle bundle3 = new Bundle();
                        bundle3.putSerializable("ordered_item", this.f64464f.f63998b);
                        bundle3.putString("recharge.component.name", s.class.getName());
                        this.j.a(this.f64464f, cJROrderedCart, bundle3);
                    }
                }
            }
        } else if (!net.one97.paytm.recharge.widgets.c.e.INSTANCE.validateIsAlreadyClicked(view, net.one97.paytm.recharge.widgets.c.e.INSTANCE.getDELAY_1000_MILLI())) {
            RecyclerView recyclerView2 = this.f64460a;
            if (recyclerView2 == null) {
                k.a("mRecyclerView");
            }
            RecyclerView.v findContainingViewHolder2 = recyclerView2.findContainingViewHolder(view);
            int adapterPosition2 = findContainingViewHolder2 != null ? findContainingViewHolder2.getAdapterPosition() : -1;
            if (adapterPosition2 >= 0) {
                CJROrderSummaryProductDetail productDetail = this.f64467i.get(adapterPosition2).getProductDetail();
                if (productDetail != null) {
                    str = productDetail.getURL();
                }
                if (!TextUtils.isEmpty(str)) {
                    CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                    k.a((Object) productDetail, "productDetails");
                    String url = productDetail.getURL();
                    k.a((Object) url, "productDetails.url");
                    cJRRechargeUtilities.openDetailPage(url);
                }
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJROtherRechargeItemsWidget f64485a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f64486b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f64487c;

        d(CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget, a aVar, int i2) {
            this.f64485a = cJROtherRechargeItemsWidget;
            this.f64486b = aVar;
            this.f64487c = i2;
        }

        public final void onClick(View view) {
            String str;
            androidx.fragment.app.b dialogFragment = this.f64485a.getDialogFragment();
            if (dialogFragment == null) {
                k.a();
            }
            dialogFragment.dismissAllowingStateLoss();
            k.a((Object) view, "it");
            Object tag = view.getTag();
            if (tag != null) {
                CJROrderSummaryAction cJROrderSummaryAction = (CJROrderSummaryAction) tag;
                int viewType = this.f64485a.getViewType();
                b bVar = CJROtherRechargeItemsWidget.f64459b;
                if (viewType == CJROtherRechargeItemsWidget.m) {
                    Context context = this.f64485a.getContext();
                    if (context == null) {
                        k.a();
                    }
                    str = context.getString(R.string.v8_os_other_items_insurance_title);
                } else {
                    Context context2 = this.f64485a.getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    str = context2.getString(R.string.bill_payment);
                }
                k.a((Object) str, "if (viewType == VIEW_TYP…ng(R.string.bill_payment)");
                CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget = this.f64485a;
                a aVar = this.f64486b;
                cJROrderSummaryAction.getAlert();
                CJROtherRechargeItemsWidget.a(cJROtherRechargeItemsWidget, aVar, cJROrderSummaryAction, this.f64487c, str);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderSummaryAction");
        }
    }

    static final class e implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJROtherRechargeItemsWidget f64488a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f64489b;

        e(CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget, a aVar) {
            this.f64488a = cJROtherRechargeItemsWidget;
            this.f64489b = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            this.f64489b.f64479i.setEnabled(true);
            this.f64489b.f64479i.setClickable(true);
            this.f64488a.getActionListener().o();
            this.f64489b.f64477g.setVisibility(8);
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CJRCircleImageViewV8 f64471a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f64472b;

        /* renamed from: c  reason: collision with root package name */
        TextView f64473c;

        /* renamed from: d  reason: collision with root package name */
        TextView f64474d;

        /* renamed from: e  reason: collision with root package name */
        TextView f64475e;

        /* renamed from: f  reason: collision with root package name */
        CJRAmountView f64476f;

        /* renamed from: g  reason: collision with root package name */
        ProgressBar f64477g;

        /* renamed from: h  reason: collision with root package name */
        net.one97.paytm.recharge.ordersummary.h.b f64478h;

        /* renamed from: i  reason: collision with root package name */
        TextView f64479i;
        int j = -1;
        boolean k;
        final /* synthetic */ CJROtherRechargeItemsWidget l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget, View view) {
            super(view);
            k.c(view, "itemView");
            this.l = cJROtherRechargeItemsWidget;
            View findViewById = view.findViewById(R.id.img_deal);
            if (findViewById != null) {
                this.f64471a = (CJRCircleImageViewV8) findViewById;
                View findViewById2 = view.findViewById(R.id.img_default);
                if (findViewById2 != null) {
                    this.f64472b = (ImageView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.txt_deal);
                    if (findViewById3 != null) {
                        this.f64473c = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.txt_merchant);
                        if (findViewById4 != null) {
                            this.f64474d = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.txt_action);
                            if (findViewById5 != null) {
                                this.f64479i = (TextView) findViewById5;
                                View findViewById6 = view.findViewById(R.id.txt_status);
                                if (findViewById6 != null) {
                                    this.f64475e = (TextView) findViewById6;
                                    View findViewById7 = view.findViewById(R.id.txt_amount);
                                    if (findViewById7 != null) {
                                        this.f64476f = (CJRAmountView) findViewById7;
                                        View findViewById8 = view.findViewById(R.id.progress_bar);
                                        if (findViewById8 != null) {
                                            this.f64477g = (ProgressBar) findViewById8;
                                            ((RelativeLayout) view.findViewById(R.id.container_img_deal)).setOnClickListener(cJROtherRechargeItemsWidget);
                                            return;
                                        }
                                        throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
                                    }
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CJRAmountView");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: net.one97.paytm.recharge.model.CJROSActionItemV2} */
    /* JADX WARNING: type inference failed for: r9v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r9v9, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01c0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01c5, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "fetch_hit_cancel_api", (java.lang.Object) r13) == false) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01c7, code lost:
        a("order.detail.after.cancel", r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ca, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01cb, code lost:
        r0.f64479i.setEnabled(true);
        r0.f64479i.setVisibility(0);
        r0.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01da, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        if (getContext() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ee, code lost:
        if (getContext() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01f2, code lost:
        if ((r14 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f6, code lost:
        if ((r15 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01f8, code lost:
        r15 = ((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r15).getExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01fe, code lost:
        if (r15 == null) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0200, code lost:
        r15 = r15.getInt(com.paytmmall.clpartifact.utils.CLPConstants.ARGUMENT_KEY_POSITION);
        r0 = r12.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0206, code lost:
        if (r0 != null) goto L_0x020b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0208, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x020b, code lost:
        r0 = r0.getAdapter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x020f, code lost:
        if (r0 != null) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0211, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0214, code lost:
        kotlin.g.b.k.a((java.lang.Object) r0, "mRecyclerView.adapter!!");
        r0 = r0.getItemCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x021b, code lost:
        if (r15 >= 0) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x021f, code lost:
        if (r0 < r15) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0221, code lost:
        r0 = r12.f64467i.get(r15);
        r1 = r12.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x022b, code lost:
        if (r1 != null) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        if ((r14 instanceof net.one97.paytm.recharge.model.CJROSActionResponseV2) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x022d, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0230, code lost:
        r15 = r1.findViewHolderForAdapterPosition(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0236, code lost:
        if ((r15 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) != false) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0238, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0239, code lost:
        r15 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x023b, code lost:
        if (r15 == null) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x023d, code lost:
        r15.f64479i.setEnabled(true);
        r15.f64479i.setClickable(true);
        r15.f64477g.setVisibility(8);
        r15 = r12.f64465g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0250, code lost:
        if (r15 == m) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0254, code lost:
        if (r15 != k) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x025a, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "order.detail.after.cancel", (java.lang.Object) r13) == false) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x025c, code lost:
        r12.j.o();
        r13 = ((net.one97.paytm.common.entity.shopping.CJROrderSummary) r14).getOrderedCartList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0268, code lost:
        if (r13 == null) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x026a, code lost:
        r13 = r13.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0274, code lost:
        if (r13.hasNext() == false) goto L_0x0294;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0276, code lost:
        r15 = r13.next();
        r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15;
        kotlin.g.b.k.a((java.lang.Object) r1, "it");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x028c, code lost:
        if (r1.getId() != r0.getId()) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x028e, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        if ((r15 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0290, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0291, code lost:
        if (r1 == false) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0294, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0295, code lost:
        r9 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0298, code lost:
        if (r9 == null) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02a0, code lost:
        if (r12.f64464f.a(r9) != false) goto L_0x02ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02ac, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r9.getItemStatus(), (java.lang.Object) "18") == false) goto L_0x02b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02ae, code lost:
        r13 = r12.j;
        r15 = r12.f64464f;
        r13.a(r15, r9, r15.l());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        r15 = ((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r15).getExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02b9, code lost:
        r12.f64464f.c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        if (r15 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        r15 = r15.getInt(com.paytmmall.clpartifact.utils.CLPConstants.ARGUMENT_KEY_POSITION);
        r0 = r12.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (r0 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        r0 = r0.getAdapter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        if (r0 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        kotlin.g.b.k.a((java.lang.Object) r0, "mRecyclerView.adapter!!");
        r0 = r0.getItemCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r15 >= 0) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        if (r0 < r15) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
        r12.f64464f.m.put(java.lang.Long.valueOf(r12.f64467i.get(r15).getId()), r14);
        r0 = r12.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        if (r0 != null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        r0 = r0.findViewHolderForAdapterPosition(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a3, code lost:
        if ((r0 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) != false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a5, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
        r0 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a8, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        r1 = r12.f64465g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        if (r1 != l) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        r13 = ((net.one97.paytm.recharge.model.CJROSActionResponseV2) r14).getActions();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b6, code lost:
        if (r13 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b8, code lost:
        r13 = (net.one97.paytm.recharge.model.CJROSActionItemV2) kotlin.a.k.a(r13, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bf, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c0, code lost:
        if (r13 == null) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c2, code lost:
        r14 = r13.getUiControl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ce, code lost:
        if (kotlin.m.p.a("button", r14, true) == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d0, code lost:
        r14 = r0.f64479i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d2, code lost:
        if (r13 == null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d4, code lost:
        r15 = r13.getLabel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d9, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00da, code lost:
        r14.setText(r15);
        r0.f64479i.setEnabled(true);
        r0.f64479i.setVisibility(0);
        r0.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ee, code lost:
        if (r13 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f0, code lost:
        r13 = r13.getUrlParams();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f4, code lost:
        if (r13 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f6, code lost:
        r9 = r13.getUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0100, code lost:
        if (android.text.TextUtils.isEmpty((java.lang.CharSequence) r9) == false) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0102, code lost:
        r0.f64479i.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0107, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0108, code lost:
        r0.f64479i.setOnClickListener(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0110, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0111, code lost:
        r0.f64479i.setEnabled(false);
        r0.f64479i.setVisibility(4);
        r0.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0121, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0124, code lost:
        if (r1 == m) goto L_0x01c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0128, code lost:
        if (r1 != k) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012e, code lost:
        if (r1 != n) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        r13 = ((net.one97.paytm.recharge.model.CJROSActionResponseV2) r14).getItemLevelActions();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0136, code lost:
        if (r13 == null) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0138, code lost:
        r13 = r13.getActions();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013c, code lost:
        if (r13 == null) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x013e, code lost:
        r13 = r13.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0148, code lost:
        if (r13.hasNext() == false) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014a, code lost:
        r14 = r13.next();
        r15 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015f, code lost:
        if (kotlin.m.p.a(net.one97.paytm.recharge.model.CJROSActionItemV2.Companion.getACTION_TYPE_VIEW_DETAILS(), r15.getmType(), true) == false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0165, code lost:
        if (r15.getVisibilityMultiItem() != 1) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0167, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0169, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x016a, code lost:
        if (r15 == false) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x016d, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x016e, code lost:
        r13 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0172, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0173, code lost:
        if (r13 == null) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0175, code lost:
        r9 = r13.getLabel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017f, code lost:
        if (android.text.TextUtils.isEmpty((java.lang.CharSequence) r9) != false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0181, code lost:
        r14 = r0.f64479i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0183, code lost:
        if (r13 != null) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0185, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0188, code lost:
        r14.setText(r13.getLabel());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0199, code lost:
        if (r12.f64464f.a(r13, r12.f64466h, false) != false) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x019b, code lost:
        r0.f64479i.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01a1, code lost:
        r0.f64479i.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a6, code lost:
        r0.f64479i.setEnabled(true);
        r0.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01b1, code lost:
        r0.f64479i.setEnabled(true);
        r0.f64479i.setVisibility(0);
        r0.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r13, com.paytm.network.model.IJRPaytmDataModel r14, java.lang.Object r15) {
        /*
            r12 = this;
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "OtherItems: onApiSuccess : ViewType = "
            r0.<init>(r1)
            int r1 = r12.f64465g
            r0.append(r1)
            java.lang.String r1 = " tag = "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r0)
            if (r13 != 0) goto L_0x0020
            return
        L_0x0020:
            int r0 = r13.hashCode()
            java.lang.String r1 = "mRecyclerView.adapter!!"
            java.lang.String r2 = "position"
            java.lang.String r3 = "fetch_hit_cancel_api"
            java.lang.String r4 = "order.detail.after.cancel"
            java.lang.String r5 = "mRecyclerView"
            r6 = 8
            r7 = 0
            r8 = 1
            r9 = 0
            switch(r0) {
                case -2088830009: goto L_0x01e2;
                case -1673464151: goto L_0x01db;
                case -1638371758: goto L_0x003f;
                case 1912192806: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x02c0
        L_0x0038:
            boolean r0 = r13.equals(r3)
            if (r0 == 0) goto L_0x02c0
            goto L_0x0047
        L_0x003f:
            java.lang.String r0 = "tap_action"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x02c0
        L_0x0047:
            android.content.Context r0 = r12.getContext()
            if (r0 == 0) goto L_0x02c0
            boolean r0 = r14 instanceof net.one97.paytm.recharge.model.CJROSActionResponseV2
            if (r0 == 0) goto L_0x02c0
            boolean r0 = r15 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x02c0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r15 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r15
            android.os.Bundle r15 = r15.getExtras()
            if (r15 == 0) goto L_0x02c0
            int r15 = r15.getInt(r2)
            androidx.recyclerview.widget.RecyclerView r0 = r12.f64460a
            if (r0 != 0) goto L_0x0068
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0068:
            androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
            if (r0 != 0) goto L_0x0071
            kotlin.g.b.k.a()
        L_0x0071:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.getItemCount()
            if (r15 >= 0) goto L_0x007b
            return
        L_0x007b:
            if (r0 < r15) goto L_0x02c0
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r12.f64467i
            java.lang.Object r0 = r0.get(r15)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            net.one97.paytm.recharge.ordersummary.b.a r1 = r12.f64464f
            java.util.HashMap<java.lang.Long, net.one97.paytm.recharge.model.CJROSActionResponseV2> r1 = r1.m
            java.util.Map r1 = (java.util.Map) r1
            long r10 = r0.getId()
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            r1.put(r0, r14)
            androidx.recyclerview.widget.RecyclerView r0 = r12.f64460a
            if (r0 != 0) goto L_0x009d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x009d:
            androidx.recyclerview.widget.RecyclerView$v r0 = r0.findViewHolderForAdapterPosition(r15)
            boolean r1 = r0 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a
            if (r1 != 0) goto L_0x00a6
            r0 = r9
        L_0x00a6:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$a r0 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r0
            if (r0 == 0) goto L_0x02c0
            int r1 = r12.f64465g
            int r2 = l
            if (r1 != r2) goto L_0x0122
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r14 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r14
            java.util.List r13 = r14.getActions()
            if (r13 == 0) goto L_0x00bf
            java.lang.Object r13 = kotlin.a.k.a(r13, (int) r7)
            net.one97.paytm.recharge.model.CJROSActionItemV2 r13 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r13
            goto L_0x00c0
        L_0x00bf:
            r13 = r9
        L_0x00c0:
            if (r13 == 0) goto L_0x00c7
            java.lang.String r14 = r13.getUiControl()
            goto L_0x00c8
        L_0x00c7:
            r14 = r9
        L_0x00c8:
            java.lang.String r15 = "button"
            boolean r14 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r14, (boolean) r8)
            if (r14 == 0) goto L_0x0111
            android.widget.TextView r14 = r0.f64479i
            if (r13 == 0) goto L_0x00d9
            java.lang.String r15 = r13.getLabel()
            goto L_0x00da
        L_0x00d9:
            r15 = r9
        L_0x00da:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r14.setText(r15)
            android.widget.TextView r14 = r0.f64479i
            r14.setEnabled(r8)
            android.widget.TextView r14 = r0.f64479i
            r14.setVisibility(r7)
            android.widget.ProgressBar r14 = r0.f64477g
            r14.setVisibility(r6)
            if (r13 == 0) goto L_0x00fa
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r13 = r13.getUrlParams()
            if (r13 == 0) goto L_0x00fa
            java.lang.String r9 = r13.getUrl()
        L_0x00fa:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r13 = android.text.TextUtils.isEmpty(r9)
            if (r13 == 0) goto L_0x0108
            android.widget.TextView r13 = r0.f64479i
            r13.setEnabled(r7)
            return
        L_0x0108:
            android.widget.TextView r13 = r0.f64479i
            r14 = r12
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r13.setOnClickListener(r14)
            return
        L_0x0111:
            android.widget.TextView r13 = r0.f64479i
            r13.setEnabled(r7)
            android.widget.TextView r13 = r0.f64479i
            r14 = 4
            r13.setVisibility(r14)
            android.widget.ProgressBar r13 = r0.f64477g
            r13.setVisibility(r6)
            return
        L_0x0122:
            int r2 = m
            if (r1 == r2) goto L_0x01c1
            int r2 = k
            if (r1 != r2) goto L_0x012c
            goto L_0x01c1
        L_0x012c:
            int r13 = n
            if (r1 != r13) goto L_0x01b1
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r14 = (net.one97.paytm.recharge.model.CJROSActionResponseV2) r14
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r13 = r14.getItemLevelActions()
            if (r13 == 0) goto L_0x0172
            java.util.List r13 = r13.getActions()
            if (r13 == 0) goto L_0x0172
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
        L_0x0144:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x016d
            java.lang.Object r14 = r13.next()
            r15 = r14
            net.one97.paytm.recharge.model.CJROSActionItemV2 r15 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r15
            net.one97.paytm.recharge.model.CJROSActionItemV2$Companion r1 = net.one97.paytm.recharge.model.CJROSActionItemV2.Companion
            java.lang.String r1 = r1.getACTION_TYPE_VIEW_DETAILS()
            java.lang.String r2 = r15.getmType()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r8)
            if (r1 == 0) goto L_0x0169
            int r15 = r15.getVisibilityMultiItem()
            if (r15 != r8) goto L_0x0169
            r15 = 1
            goto L_0x016a
        L_0x0169:
            r15 = 0
        L_0x016a:
            if (r15 == 0) goto L_0x0144
            goto L_0x016e
        L_0x016d:
            r14 = r9
        L_0x016e:
            r13 = r14
            net.one97.paytm.recharge.model.CJROSActionItemV2 r13 = (net.one97.paytm.recharge.model.CJROSActionItemV2) r13
            goto L_0x0173
        L_0x0172:
            r13 = r9
        L_0x0173:
            if (r13 == 0) goto L_0x0179
            java.lang.String r9 = r13.getLabel()
        L_0x0179:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r14 = android.text.TextUtils.isEmpty(r9)
            if (r14 != 0) goto L_0x01a1
            android.widget.TextView r14 = r0.f64479i
            if (r13 != 0) goto L_0x0188
            kotlin.g.b.k.a()
        L_0x0188:
            java.lang.String r15 = r13.getLabel()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r14.setText(r15)
            net.one97.paytm.recharge.ordersummary.b.a r14 = r12.f64464f
            int r15 = r12.f64466h
            boolean r13 = r14.a((net.one97.paytm.recharge.model.CJROSActionItemV2) r13, (int) r15, false)
            if (r13 != 0) goto L_0x01a1
            android.widget.TextView r13 = r0.f64479i
            r13.setVisibility(r6)
            goto L_0x01a6
        L_0x01a1:
            android.widget.TextView r13 = r0.f64479i
            r13.setVisibility(r7)
        L_0x01a6:
            android.widget.TextView r13 = r0.f64479i
            r13.setEnabled(r8)
            android.widget.ProgressBar r13 = r0.f64477g
            r13.setVisibility(r6)
            return
        L_0x01b1:
            android.widget.TextView r13 = r0.f64479i
            r13.setEnabled(r8)
            android.widget.TextView r13 = r0.f64479i
            r13.setVisibility(r7)
            android.widget.ProgressBar r13 = r0.f64477g
            r13.setVisibility(r6)
            return
        L_0x01c1:
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x01cb
            r12.a((java.lang.String) r4, (int) r15)
            return
        L_0x01cb:
            android.widget.TextView r13 = r0.f64479i
            r13.setEnabled(r8)
            android.widget.TextView r13 = r0.f64479i
            r13.setVisibility(r7)
            android.widget.ProgressBar r13 = r0.f64477g
            r13.setVisibility(r6)
            return
        L_0x01db:
            boolean r0 = r13.equals(r4)
            if (r0 == 0) goto L_0x02c0
            goto L_0x01ea
        L_0x01e2:
            java.lang.String r0 = "fetch_order_detail"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x02c0
        L_0x01ea:
            android.content.Context r0 = r12.getContext()
            if (r0 == 0) goto L_0x02c0
            boolean r0 = r14 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            if (r0 == 0) goto L_0x02c0
            boolean r0 = r15 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x02b9
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r15 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r15
            android.os.Bundle r15 = r15.getExtras()
            if (r15 == 0) goto L_0x02b9
            int r15 = r15.getInt(r2)
            androidx.recyclerview.widget.RecyclerView r0 = r12.f64460a
            if (r0 != 0) goto L_0x020b
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x020b:
            androidx.recyclerview.widget.RecyclerView$a r0 = r0.getAdapter()
            if (r0 != 0) goto L_0x0214
            kotlin.g.b.k.a()
        L_0x0214:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.getItemCount()
            if (r15 >= 0) goto L_0x021f
            goto L_0x02b9
        L_0x021f:
            if (r0 < r15) goto L_0x02b9
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r12.f64467i
            java.lang.Object r0 = r0.get(r15)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            androidx.recyclerview.widget.RecyclerView r1 = r12.f64460a
            if (r1 != 0) goto L_0x0230
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0230:
            androidx.recyclerview.widget.RecyclerView$v r15 = r1.findViewHolderForAdapterPosition(r15)
            boolean r1 = r15 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a
            if (r1 != 0) goto L_0x0239
            r15 = r9
        L_0x0239:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$a r15 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r15
            if (r15 == 0) goto L_0x02b9
            android.widget.TextView r1 = r15.f64479i
            r1.setEnabled(r8)
            android.widget.TextView r1 = r15.f64479i
            r1.setClickable(r8)
            android.widget.ProgressBar r15 = r15.f64477g
            r15.setVisibility(r6)
            int r15 = r12.f64465g
            int r1 = m
            if (r15 == r1) goto L_0x0256
            int r1 = k
            if (r15 != r1) goto L_0x02b9
        L_0x0256:
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r13)
            if (r13 == 0) goto L_0x02b9
            net.one97.paytm.recharge.ordersummary.f.b r13 = r12.j
            r13.o()
            r13 = r14
            net.one97.paytm.common.entity.shopping.CJROrderSummary r13 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r13
            java.util.ArrayList r13 = r13.getOrderedCartList()
            if (r13 == 0) goto L_0x0298
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.Iterator r13 = r13.iterator()
        L_0x0270:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x0294
            java.lang.Object r15 = r13.next()
            r1 = r15
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            java.lang.String r2 = "it"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            long r1 = r1.getId()
            long r3 = r0.getId()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0290
            r1 = 1
            goto L_0x0291
        L_0x0290:
            r1 = 0
        L_0x0291:
            if (r1 == 0) goto L_0x0270
            goto L_0x0295
        L_0x0294:
            r15 = r9
        L_0x0295:
            r9 = r15
            net.one97.paytm.common.entity.shopping.CJROrderedCart r9 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r9
        L_0x0298:
            if (r9 == 0) goto L_0x02b9
            net.one97.paytm.recharge.ordersummary.b.a r13 = r12.f64464f
            boolean r13 = r13.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r9)
            if (r13 != 0) goto L_0x02ae
            java.lang.String r13 = r9.getItemStatus()
            java.lang.String r15 = "18"
            boolean r13 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r15)
            if (r13 == 0) goto L_0x02b9
        L_0x02ae:
            net.one97.paytm.recharge.ordersummary.f.b r13 = r12.j
            net.one97.paytm.recharge.ordersummary.b.a r15 = r12.f64464f
            android.os.Bundle r0 = r15.l()
            r13.a((net.one97.paytm.recharge.ordersummary.b.a) r15, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r9, (android.os.Bundle) r0)
        L_0x02b9:
            net.one97.paytm.recharge.ordersummary.b.a r13 = r12.f64464f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r14
            r13.c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r14)
        L_0x02c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if ((r10 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        r6 = net.one97.paytm.recharge.common.utils.az.f61525a;
        r10 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r10;
        net.one97.paytm.recharge.common.utils.az.a(r10);
        r6 = r10.getExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        r6 = r6.getInt(com.paytmmall.clpartifact.utils.CLPConstants.ARGUMENT_KEY_POSITION);
        r7 = r5.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (r7 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        r7 = r7.getAdapter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (r7 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        kotlin.g.b.k.a((java.lang.Object) r7, "mRecyclerView.adapter!!");
        r7 = r7.getItemCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        if (r6 >= 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        if (r7 < r6) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        r5.f64467i.get(r6);
        r7 = r5.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007e, code lost:
        if (r7 != null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0080, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r6 = r7.findViewHolderForAdapterPosition(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        if ((r6 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
        r6 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0090, code lost:
        r7 = r5.f64465g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0094, code lost:
        if (r7 == m) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0098, code lost:
        if (r7 != k) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009d, code lost:
        if (r7 != l) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009f, code lost:
        r6.f64479i.setEnabled(false);
        r6.f64479i.setVisibility(8);
        r6.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r6.f64479i.setEnabled(true);
        r6.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ba, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bb, code lost:
        r6.f64479i.setEnabled(true);
        r6.f64479i.setClickable(true);
        r5.j.o();
        r6.f64477g.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cf, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e1, code lost:
        if ((r10 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e3, code lost:
        r7 = ((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r10).getExtras();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e9, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00eb, code lost:
        r7 = r7.getInt(com.paytmmall.clpartifact.utils.CLPConstants.ARGUMENT_KEY_POSITION);
        r10 = r5.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f1, code lost:
        if (r10 != null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f3, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f6, code lost:
        r10 = r10.getAdapter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fa, code lost:
        if (r10 != null) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fc, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ff, code lost:
        kotlin.g.b.k.a((java.lang.Object) r10, "mRecyclerView.adapter!!");
        r9 = r10.getItemCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0106, code lost:
        if (r7 >= 0) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0108, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0109, code lost:
        if (r9 < r7) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010b, code lost:
        r5.f64467i.get(r7);
        r9 = r5.f64460a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0112, code lost:
        if (r9 != null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0114, code lost:
        kotlin.g.b.k.a("mRecyclerView");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0117, code lost:
        r7 = r9.findViewHolderForAdapterPosition(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011d, code lost:
        if ((r7 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) != false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011f, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0120, code lost:
        r7 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0122, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0124, code lost:
        r7.f64479i.setEnabled(true);
        r7.f64479i.setClickable(true);
        r7.f64477g.setVisibility(8);
        r7 = r5.f64465g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0137, code lost:
        if (r7 == m) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013b, code lost:
        if (r7 != k) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0141, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) "order.detail.after.cancel", (java.lang.Object) r6) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0143, code lost:
        r5.j.o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6, int r7, com.paytm.network.model.IJRPaytmDataModel r8, com.paytm.network.model.NetworkCustomError r9, java.lang.Object r10) {
        /*
            r5 = this;
            net.one97.paytm.recharge.widgets.c.d r7 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "OtherItems: handleErrorCode : ViewType = "
            r7.<init>(r8)
            int r8 = r5.f64465g
            r7.append(r8)
            java.lang.String r8 = " tag = "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r7)
            if (r6 != 0) goto L_0x0020
            return
        L_0x0020:
            int r7 = r6.hashCode()
            r8 = 0
            java.lang.String r9 = "mRecyclerView.adapter!!"
            java.lang.String r0 = "position"
            java.lang.String r1 = "order.detail.after.cancel"
            java.lang.String r2 = "mRecyclerView"
            r3 = 8
            r4 = 1
            switch(r7) {
                case -2088830009: goto L_0x00d7;
                case -1673464151: goto L_0x00d0;
                case -1638371758: goto L_0x003e;
                case 1912192806: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x0148
        L_0x0035:
            java.lang.String r7 = "fetch_hit_cancel_api"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0148
            goto L_0x0046
        L_0x003e:
            java.lang.String r7 = "tap_action"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0148
        L_0x0046:
            boolean r6 = r10 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r6 == 0) goto L_0x0148
            net.one97.paytm.recharge.common.utils.az r6 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r10
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r10)
            android.os.Bundle r6 = r10.getExtras()
            if (r6 == 0) goto L_0x0148
            int r6 = r6.getInt(r0)
            androidx.recyclerview.widget.RecyclerView r7 = r5.f64460a
            if (r7 != 0) goto L_0x0062
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0062:
            androidx.recyclerview.widget.RecyclerView$a r7 = r7.getAdapter()
            if (r7 != 0) goto L_0x006b
            kotlin.g.b.k.a()
        L_0x006b:
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            int r7 = r7.getItemCount()
            if (r6 >= 0) goto L_0x0075
            return
        L_0x0075:
            if (r7 < r6) goto L_0x0148
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r7 = r5.f64467i
            r7.get(r6)
            androidx.recyclerview.widget.RecyclerView r7 = r5.f64460a
            if (r7 != 0) goto L_0x0083
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0083:
            androidx.recyclerview.widget.RecyclerView$v r6 = r7.findViewHolderForAdapterPosition(r6)
            boolean r7 = r6 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a
            if (r7 != 0) goto L_0x008c
            r6 = r8
        L_0x008c:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$a r6 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r6
            if (r6 == 0) goto L_0x0148
            int r7 = r5.f64465g
            int r8 = m
            if (r7 == r8) goto L_0x00bb
            int r8 = k
            if (r7 != r8) goto L_0x009b
            goto L_0x00bb
        L_0x009b:
            int r8 = l
            if (r7 != r8) goto L_0x00b0
            android.widget.TextView r7 = r6.f64479i
            r8 = 0
            r7.setEnabled(r8)
            android.widget.TextView r7 = r6.f64479i
            r7.setVisibility(r3)
            android.widget.ProgressBar r6 = r6.f64477g
            r6.setVisibility(r3)
            return
        L_0x00b0:
            android.widget.TextView r7 = r6.f64479i
            r7.setEnabled(r4)
            android.widget.ProgressBar r6 = r6.f64477g
            r6.setVisibility(r3)
            return
        L_0x00bb:
            android.widget.TextView r7 = r6.f64479i
            r7.setEnabled(r4)
            android.widget.TextView r7 = r6.f64479i
            r7.setClickable(r4)
            net.one97.paytm.recharge.ordersummary.f.b r7 = r5.j
            r7.o()
            android.widget.ProgressBar r6 = r6.f64477g
            r6.setVisibility(r3)
            return
        L_0x00d0:
            boolean r7 = r6.equals(r1)
            if (r7 == 0) goto L_0x0148
            goto L_0x00df
        L_0x00d7:
            java.lang.String r7 = "fetch_order_detail"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0148
        L_0x00df:
            boolean r7 = r10 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r7 == 0) goto L_0x0148
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r10 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r10
            android.os.Bundle r7 = r10.getExtras()
            if (r7 == 0) goto L_0x0148
            int r7 = r7.getInt(r0)
            androidx.recyclerview.widget.RecyclerView r10 = r5.f64460a
            if (r10 != 0) goto L_0x00f6
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00f6:
            androidx.recyclerview.widget.RecyclerView$a r10 = r10.getAdapter()
            if (r10 != 0) goto L_0x00ff
            kotlin.g.b.k.a()
        L_0x00ff:
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
            int r9 = r10.getItemCount()
            if (r7 >= 0) goto L_0x0109
            return
        L_0x0109:
            if (r9 < r7) goto L_0x0148
            java.util.List<net.one97.paytm.common.entity.shopping.CJROrderedCart> r9 = r5.f64467i
            r9.get(r7)
            androidx.recyclerview.widget.RecyclerView r9 = r5.f64460a
            if (r9 != 0) goto L_0x0117
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0117:
            androidx.recyclerview.widget.RecyclerView$v r7 = r9.findViewHolderForAdapterPosition(r7)
            boolean r9 = r7 instanceof net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a
            if (r9 != 0) goto L_0x0120
            r7 = r8
        L_0x0120:
            net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget$a r7 = (net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a) r7
            if (r7 == 0) goto L_0x0148
            android.widget.TextView r8 = r7.f64479i
            r8.setEnabled(r4)
            android.widget.TextView r8 = r7.f64479i
            r8.setClickable(r4)
            android.widget.ProgressBar r7 = r7.f64477g
            r7.setVisibility(r3)
            int r7 = r5.f64465g
            int r8 = m
            if (r7 == r8) goto L_0x013d
            int r8 = k
            if (r7 != r8) goto L_0x0148
        L_0x013d:
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x0148
            net.one97.paytm.recharge.ordersummary.f.b r6 = r5.j
            r6.o()
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.CJROtherRechargeItemsWidget.a(java.lang.String, int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError, java.lang.Object):void");
    }

    public static final /* synthetic */ void a(CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget, a aVar, CJROrderSummaryAction cJROrderSummaryAction, int i2, String str) {
        androidx.fragment.app.b bVar;
        CJROtherRechargeItemsWidget cJROtherRechargeItemsWidget2 = cJROtherRechargeItemsWidget;
        a aVar2 = aVar;
        boolean z = false;
        try {
            CJROrderedCart cJROrderedCart = cJROtherRechargeItemsWidget2.f64467i.get(i2);
            c.a aVar3 = net.one97.paytm.recharge.ordersummary.c.c.f64038b;
            Context context = cJROtherRechargeItemsWidget.getContext();
            String str2 = null;
            String string = context != null ? context.getString(R.string.cancel_paytype, new Object[]{str}) : null;
            if (string == null) {
                k.a();
            }
            k.a((Object) string, "context?.getString(R.str…ancel_paytype, paytype)!!");
            Context context2 = cJROtherRechargeItemsWidget.getContext();
            String string2 = context2 != null ? context2.getString(R.string.v8_os_cancel_insurence_pst_btn_txt) : null;
            if (string2 == null) {
                k.a();
            }
            k.a((Object) string2, "context?.getString(R.str…_insurence_pst_btn_txt)!!");
            Context context3 = cJROtherRechargeItemsWidget.getContext();
            String string3 = context3 != null ? context3.getString(R.string.v8_os_cancel_insurence_ngtv_btn_txt) : null;
            if (string3 == null) {
                k.a();
            }
            Context context4 = cJROtherRechargeItemsWidget.getContext();
            String string4 = context4 != null ? context4.getString(R.string.v8_os_cancel_confirmation_msg_to_original_source, new Object[]{str}) : null;
            if (string4 == null) {
                k.a();
            }
            k.a((Object) string4, "context?.getString(R.str…iginal_source, paytype)!!");
            Context context5 = cJROtherRechargeItemsWidget.getContext();
            if (context5 != null) {
                str2 = context5.getString(R.string.v8_os_cancel_unsurence_sub_msg, new Object[]{str});
            }
            String str3 = str2;
            if (str3 == null) {
                k.a();
            }
            k.a((Object) str3, "context?.getString(R.str…rence_sub_msg, paytype)!!");
            net.one97.paytm.recharge.ordersummary.c.c a2 = c.a.a(string, string2, string3, string4, str3, String.valueOf(cJROrderedCart.getSubTotal()));
            a2.f64041a = false;
            a2.f64228c = new c(cJROtherRechargeItemsWidget, aVar, a2, i2, cJROrderSummaryAction);
            if (cJROtherRechargeItemsWidget2.j.getSupportFragmentManager() != null) {
                j supportFragmentManager = cJROtherRechargeItemsWidget2.j.getSupportFragmentManager();
                if (supportFragmentManager == null) {
                    k.a();
                }
                a2.show(supportFragmentManager, net.one97.paytm.recharge.ordersummary.c.c.class.getSimpleName());
            }
        } catch (Exception e2) {
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            net.one97.paytm.recharge.widgets.c.d.a((Throwable) e2);
            aVar2.f64479i.setEnabled(true);
            aVar2.f64479i.setClickable(true);
            aVar2.f64477g.setVisibility(8);
            androidx.fragment.app.b bVar2 = cJROtherRechargeItemsWidget2.f64461c;
            if (bVar2 != null) {
                bVar2.dismissAllowingStateLoss();
            }
            androidx.fragment.app.b bVar3 = cJROtherRechargeItemsWidget2.f64461c;
            if (!(bVar3 != null ? bVar3.isVisible() : false)) {
                androidx.fragment.app.b bVar4 = cJROtherRechargeItemsWidget2.f64461c;
                if (bVar4 != null) {
                    z = bVar4.isAdded();
                }
                if (!z && cJROtherRechargeItemsWidget2.j.getSupportFragmentManager() != null && (bVar = cJROtherRechargeItemsWidget2.f64461c) != null) {
                    j supportFragmentManager2 = cJROtherRechargeItemsWidget2.j.getSupportFragmentManager();
                    if (supportFragmentManager2 == null) {
                        k.a();
                    }
                    a.C1256a aVar4 = net.one97.paytm.recharge.ordersummary.c.a.f64019d;
                    bVar.show(supportFragmentManager2, net.one97.paytm.recharge.ordersummary.c.a.k);
                }
            }
        }
    }
}
