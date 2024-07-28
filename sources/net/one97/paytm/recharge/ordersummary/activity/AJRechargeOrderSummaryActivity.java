package net.one97.paytm.recharge.ordersummary.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ac;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.fragment.FJRRechargeUtilBaseFragment;
import net.one97.paytm.recharge.common.utils.CJRRecentsLazyLoader;
import net.one97.paytm.recharge.common.utils.ap;
import net.one97.paytm.recharge.common.utils.as;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.f;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.ordersummary.d.t;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.f.n;
import net.one97.paytm.recharge.ordersummary.f.r;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJRInstantRefundWidget;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRechargeOrderSummaryActivity extends CJRBaseOrderSummaryActivity implements ai, l, n, r, CJRInstantRefundWidget.d {
    private boolean A;
    private HashMap B;

    /* renamed from: a  reason: collision with root package name */
    protected net.one97.paytm.recharge.ordersummary.b.a f63978a;

    /* renamed from: b  reason: collision with root package name */
    String f63979b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63980c;

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.recharge.ordersummary.h.a f63981d;

    /* renamed from: h  reason: collision with root package name */
    private boolean f63982h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f63983i;
    private l j;
    private f k;
    private CJRRechargeCart l;
    private boolean m;
    private int n;
    private boolean o;
    private com.paytm.utility.l u;
    private FJRRechargeUtilBaseFragment.a v = new FJRRechargeUtilBaseFragment.a(-1, -1, (Intent) null);
    private boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private CJROrderSummary y;
    private boolean z;

    public final View c(int i2) {
        if (this.B == null) {
            this.B = new HashMap();
        }
        View view = (View) this.B.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.B.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        r10 = r10.getCartItems();
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0426  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x042f  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0438  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x047f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0482  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04d5  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r43) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r2 = r0
            android.app.Activity r2 = (android.app.Activity) r2
            com.paytm.utility.b.e((android.app.Activity) r2)
            if (r1 == 0) goto L_0x0023
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r3 = "AJRechargeOrderSummaryActivity : onCreate : recreated : start"
            r2.debugLog(r3)
            java.lang.String r2 = "extra_params"
            android.os.Bundle r2 = r1.getBundle(r2)
            if (r2 == 0) goto L_0x002a
            android.content.Intent r3 = r42.getIntent()
            r3.putExtras(r2)
            goto L_0x002a
        L_0x0023:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r3 = "AJRechargeOrderSummaryActivity onCreate start"
            r2.debugLog(r3)
        L_0x002a:
            android.content.Intent r2 = r42.getIntent()
            java.lang.String r3 = "order_id"
            boolean r2 = r2.hasExtra(r3)
            if (r2 == 0) goto L_0x0040
            android.content.Intent r2 = r42.getIntent()
            java.lang.String r2 = r2.getStringExtra(r3)
            r0.f63979b = r2
        L_0x0040:
            android.content.Intent r2 = r42.getIntent()
            java.lang.String r3 = "recharge.component.name"
            boolean r2 = r2.hasExtra(r3)
            if (r2 == 0) goto L_0x005e
            android.content.Intent r2 = r42.getIntent()
            boolean r2 = r0.a((android.content.Intent) r2)
            r0.f63980c = r2
            boolean r2 = r0.f63980c
            if (r2 != 0) goto L_0x005e
            r42.finish()
            return
        L_0x005e:
            boolean r2 = r0.f63980c
            r4 = 1
            java.lang.String r5 = "viewModel"
            if (r2 != 0) goto L_0x059d
            android.content.Intent r2 = r42.getIntent()
            java.lang.String r7 = "recharge cart"
            java.io.Serializable r2 = r2.getSerializableExtra(r7)
            boolean r7 = r2 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            if (r7 != 0) goto L_0x0074
            r2 = 0
        L_0x0074:
            net.one97.paytm.common.entity.CJRRechargeCart r2 = (net.one97.paytm.common.entity.CJRRechargeCart) r2
            java.lang.String r7 = ""
            r8 = -1
            if (r2 == 0) goto L_0x00be
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r2.getCart()
            if (r10 == 0) goto L_0x0091
            java.util.ArrayList r10 = r10.getCartItems()
            if (r10 == 0) goto L_0x0091
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = kotlin.a.k.d(r10)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r10 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r10
            goto L_0x0092
        L_0x0091:
            r10 = 0
        L_0x0092:
            if (r10 == 0) goto L_0x00a6
            java.util.Map r11 = r10.getConfigurationList()
            if (r11 == 0) goto L_0x00a6
            java.lang.String r12 = net.one97.paytm.recharge.common.utils.ab.f61497b
            java.lang.Object r11 = r11.get(r12)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r7 = r11
        L_0x00a6:
            if (r10 == 0) goto L_0x00b1
            java.lang.String r11 = r10.getVerticalId()
            if (r11 == 0) goto L_0x00b1
            java.lang.Long.parseLong(r11)
        L_0x00b1:
            if (r10 == 0) goto L_0x00be
            java.lang.String r10 = r10.getProductId()
            if (r10 == 0) goto L_0x00be
            long r10 = java.lang.Long.parseLong(r10)
            goto L_0x00bf
        L_0x00be:
            r10 = r8
        L_0x00bf:
            android.content.Intent r12 = r42.getIntent()
            java.lang.String r13 = "recharge.os.history.item"
            java.io.Serializable r12 = r12.getSerializableExtra(r13)
            boolean r13 = r12 instanceof net.one97.paytm.common.entity.shopping.CJROrderList
            if (r13 != 0) goto L_0x00ce
            r12 = 0
        L_0x00ce:
            net.one97.paytm.common.entity.shopping.CJROrderList r12 = (net.one97.paytm.common.entity.shopping.CJROrderList) r12
            r13 = 0
            if (r12 == 0) goto L_0x0117
            net.one97.paytm.recharge.ordersummary.h.c$a r7 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            long r10 = net.one97.paytm.recharge.ordersummary.h.c.a.b(r12)
            java.lang.String r7 = java.lang.String.valueOf(r10)
            net.one97.paytm.recharge.ordersummary.h.c$a r10 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            net.one97.paytm.recharge.ordersummary.h.c.a.a((net.one97.paytm.common.entity.shopping.CJROrderList) r12)
            net.one97.paytm.recharge.ordersummary.h.c$a r10 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            if (r12 == 0) goto L_0x0116
            java.util.ArrayList r10 = r12.getOrderItems()
            if (r10 == 0) goto L_0x0116
            java.util.ArrayList r10 = r12.getOrderItems()
            int r10 = r10.size()
            if (r10 <= 0) goto L_0x0116
            java.util.ArrayList r10 = r12.getOrderItems()
            java.lang.Object r10 = r10.get(r13)
            net.one97.paytm.common.entity.shopping.CJROrderItems r10 = (net.one97.paytm.common.entity.shopping.CJROrderItems) r10
            if (r10 == 0) goto L_0x0116
            net.one97.paytm.common.entity.shopping.CJROrderItemProduct r11 = r10.getProduct()
            if (r11 == 0) goto L_0x0116
            net.one97.paytm.common.entity.shopping.CJROrderItemProduct r10 = r10.getProduct()
            java.lang.String r11 = "cart.product"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            long r10 = r10.getProductId()
            goto L_0x0117
        L_0x0116:
            r10 = r8
        L_0x0117:
            java.lang.String r12 = "Order_summary"
            if (r1 == 0) goto L_0x012d
            boolean r14 = r1.containsKey(r12)
            if (r14 != r4) goto L_0x012d
            java.lang.Object r14 = r1.get(r12)
            boolean r15 = r14 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            if (r15 != 0) goto L_0x012a
            r14 = 0
        L_0x012a:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r14
            goto L_0x0148
        L_0x012d:
            android.content.Intent r14 = r42.getIntent()
            boolean r14 = r14.hasExtra(r12)
            if (r14 == 0) goto L_0x0147
            android.content.Intent r14 = r42.getIntent()
            java.io.Serializable r14 = r14.getSerializableExtra(r12)
            boolean r15 = r14 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            if (r15 != 0) goto L_0x0144
            r14 = 0
        L_0x0144:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r14 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r14
            goto L_0x0148
        L_0x0147:
            r14 = 0
        L_0x0148:
            if (r14 == 0) goto L_0x0173
            java.util.ArrayList r7 = r14.getOrderedCartList()
            java.lang.Object r7 = r7.get(r13)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r7
            java.lang.String r10 = "orderedItem"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r7.getProductDetail()
            java.lang.String r10 = "orderedProduct"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)
            long r10 = r7.getCategoryId()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r7.getVerticalId()
            long r15 = r7.getId()
            r7 = r10
            goto L_0x0174
        L_0x0173:
            r15 = r10
        L_0x0174:
            net.one97.paytm.recharge.ordersummary.h.c$a r10 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            r10 = r0
            android.content.Context r10 = (android.content.Context) r10
            java.lang.String r11 = "context"
            kotlin.g.b.k.c(r10, r11)
            java.lang.String r11 = "categoryId"
            kotlin.g.b.k.c(r7, r11)
            boolean r11 = net.one97.paytm.recharge.common.utils.g.a((android.content.Context) r10, (java.lang.String) r7)
            if (r11 == 0) goto L_0x0316
            net.one97.paytm.recharge.di.helper.c r11 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r11 = net.one97.paytm.recharge.di.helper.c.k()
            long r17 = java.lang.Long.parseLong(r7)
            java.lang.Long r13 = java.lang.Long.valueOf(r17)
            boolean r11 = r11.contains(r13)
            if (r11 == 0) goto L_0x01b4
            net.one97.paytm.recharge.ordersummary.g.b r11 = new net.one97.paytm.recharge.ordersummary.g.b
            net.one97.paytm.recharge.ordersummary.g.e r13 = new net.one97.paytm.recharge.ordersummary.g.e
            r13.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r13 = (net.one97.paytm.recharge.ordersummary.f.c) r13
            net.one97.paytm.recharge.ordersummary.h.d r4 = new net.one97.paytm.recharge.ordersummary.h.d
            r4.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r4 = (net.one97.paytm.recharge.ordersummary.f.m) r4
            r11.<init>(r13, r4)
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x01b4:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.l()
            long r20 = java.lang.Long.parseLong(r7)
            java.lang.Long r11 = java.lang.Long.valueOf(r20)
            boolean r4 = r4.contains(r11)
            if (r4 == 0) goto L_0x01e0
            net.one97.paytm.recharge.ordersummary.g.a r4 = new net.one97.paytm.recharge.ordersummary.g.a
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            r4.<init>(r11, r13)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x01e0:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.j()
            long r20 = java.lang.Long.parseLong(r7)
            java.lang.Long r11 = java.lang.Long.valueOf(r20)
            boolean r4 = r4.contains(r11)
            if (r4 == 0) goto L_0x020c
            net.one97.paytm.recharge.ordersummary.g.h r4 = new net.one97.paytm.recharge.ordersummary.g.h
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            r4.<init>(r11, r13)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x020c:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.i()
            long r20 = java.lang.Long.parseLong(r7)
            java.lang.Long r11 = java.lang.Long.valueOf(r20)
            boolean r4 = r4.contains(r11)
            if (r4 == 0) goto L_0x0238
            net.one97.paytm.recharge.ordersummary.g.d r4 = new net.one97.paytm.recharge.ordersummary.g.d
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            r4.<init>(r11, r13)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x0238:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.q()
            java.lang.Long r11 = java.lang.Long.valueOf(r15)
            boolean r4 = r4.contains(r11)
            if (r4 == 0) goto L_0x0260
            net.one97.paytm.recharge.ordersummary.g.j r4 = new net.one97.paytm.recharge.ordersummary.g.j
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            r4.<init>(r11, r13)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x0260:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.m()
            long r20 = java.lang.Long.parseLong(r7)
            java.lang.Long r11 = java.lang.Long.valueOf(r20)
            boolean r4 = r4.contains(r11)
            if (r4 == 0) goto L_0x028c
            net.one97.paytm.recharge.ordersummary.g.c r4 = new net.one97.paytm.recharge.ordersummary.g.c
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            r4.<init>(r11, r13)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x028c:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.n()
            java.lang.Long r11 = java.lang.Long.valueOf(r15)
            boolean r4 = r4.contains(r11)
            if (r4 == 0) goto L_0x02b4
            net.one97.paytm.recharge.ordersummary.g.g r4 = new net.one97.paytm.recharge.ordersummary.g.g
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            r4.<init>(r11, r13)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x02b4:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.o()
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L_0x02d8
            net.one97.paytm.recharge.ordersummary.g.i r4 = new net.one97.paytm.recharge.ordersummary.g.i
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            r4.<init>(r11, r13)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x02d8:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.p()
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L_0x02fe
            net.one97.paytm.recharge.ordersummary.g.d r4 = new net.one97.paytm.recharge.ordersummary.g.d
            net.one97.paytm.recharge.ordersummary.g.e r11 = new net.one97.paytm.recharge.ordersummary.g.e
            r11.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r11 = (net.one97.paytm.recharge.ordersummary.f.c) r11
            net.one97.paytm.recharge.ordersummary.h.d r13 = new net.one97.paytm.recharge.ordersummary.h.d
            r13.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r13 = (net.one97.paytm.recharge.ordersummary.f.m) r13
            net.one97.paytm.recharge.ordersummary.h.c$a$a r6 = net.one97.paytm.recharge.ordersummary.h.c.a.C1269a.MY_PAYMENTS
            r4.<init>(r11, r13, r6)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x02fe:
            net.one97.paytm.recharge.ordersummary.g.d r4 = new net.one97.paytm.recharge.ordersummary.g.d
            net.one97.paytm.recharge.ordersummary.g.e r6 = new net.one97.paytm.recharge.ordersummary.g.e
            r6.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r6 = (net.one97.paytm.recharge.ordersummary.f.c) r6
            net.one97.paytm.recharge.ordersummary.h.d r11 = new net.one97.paytm.recharge.ordersummary.h.d
            r11.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r11 = (net.one97.paytm.recharge.ordersummary.f.m) r11
            r4.<init>(r6, r11)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x0316:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.aI()
            java.lang.Long r6 = java.lang.Long.valueOf(r15)
            boolean r4 = r4.contains(r6)
            net.one97.paytm.recharge.di.helper.c r6 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r6 = net.one97.paytm.recharge.di.helper.c.aJ()
            java.lang.Long r11 = java.lang.Long.valueOf(r15)
            boolean r6 = r6.contains(r11)
            r4 = r4 | r6
            net.one97.paytm.recharge.di.helper.c r6 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r6 = net.one97.paytm.recharge.di.helper.c.aK()
            java.lang.Long r11 = java.lang.Long.valueOf(r15)
            boolean r6 = r6.contains(r11)
            r4 = r4 | r6
            net.one97.paytm.recharge.di.helper.c r6 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r6 = net.one97.paytm.recharge.di.helper.c.aL()
            java.lang.Long r11 = java.lang.Long.valueOf(r15)
            boolean r6 = r6.contains(r11)
            r4 = r4 | r6
            if (r4 == 0) goto L_0x036a
            net.one97.paytm.recharge.legacy.ordersummary.b.a r4 = new net.one97.paytm.recharge.legacy.ordersummary.b.a
            net.one97.paytm.recharge.ordersummary.g.e r6 = new net.one97.paytm.recharge.ordersummary.g.e
            r6.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r6 = (net.one97.paytm.recharge.ordersummary.f.c) r6
            net.one97.paytm.recharge.ordersummary.h.d r11 = new net.one97.paytm.recharge.ordersummary.h.d
            r11.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r11 = (net.one97.paytm.recharge.ordersummary.f.m) r11
            r4.<init>(r6, r11)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x036a:
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.n()
            java.lang.Long r6 = java.lang.Long.valueOf(r15)
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x0391
            net.one97.paytm.recharge.ordersummary.g.g r4 = new net.one97.paytm.recharge.ordersummary.g.g
            net.one97.paytm.recharge.ordersummary.g.e r6 = new net.one97.paytm.recharge.ordersummary.g.e
            r6.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r6 = (net.one97.paytm.recharge.ordersummary.f.c) r6
            net.one97.paytm.recharge.ordersummary.h.d r11 = new net.one97.paytm.recharge.ordersummary.h.d
            r11.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r11 = (net.one97.paytm.recharge.ordersummary.f.m) r11
            r4.<init>(r6, r11)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
            goto L_0x03a7
        L_0x0391:
            net.one97.paytm.recharge.ordersummary.g.d r4 = new net.one97.paytm.recharge.ordersummary.g.d
            net.one97.paytm.recharge.ordersummary.g.e r6 = new net.one97.paytm.recharge.ordersummary.g.e
            r6.<init>()
            net.one97.paytm.recharge.ordersummary.f.c r6 = (net.one97.paytm.recharge.ordersummary.f.c) r6
            net.one97.paytm.recharge.ordersummary.h.d r11 = new net.one97.paytm.recharge.ordersummary.h.d
            r11.<init>(r10)
            net.one97.paytm.recharge.ordersummary.f.m r11 = (net.one97.paytm.recharge.ordersummary.f.m) r11
            r4.<init>(r6, r11)
            r11 = r4
            net.one97.paytm.recharge.ordersummary.f.j r11 = (net.one97.paytm.recharge.ordersummary.f.j) r11
        L_0x03a7:
            net.one97.paytm.recharge.ordersummary.b.b r4 = new net.one97.paytm.recharge.ordersummary.b.b
            boolean r6 = r42.x()
            net.one97.paytm.recharge.ordersummary.b.a.b r13 = net.one97.paytm.recharge.common.b.d.f(r10)
            r4.<init>(r6, r2, r13, r11)
            androidx.lifecycle.al$b r4 = (androidx.lifecycle.al.b) r4
            androidx.lifecycle.al r4 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r0, (androidx.lifecycle.al.b) r4)
            java.lang.Class<net.one97.paytm.recharge.ordersummary.b.a> r6 = net.one97.paytm.recharge.ordersummary.b.a.class
            androidx.lifecycle.ai r4 = r4.a(r6)
            java.lang.String r6 = "ViewModelProviders.of(th…elFactory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            net.one97.paytm.recharge.ordersummary.b.a r4 = (net.one97.paytm.recharge.ordersummary.b.a) r4
            r0.f63978a = r4
            net.one97.paytm.recharge.ordersummary.b.a r4 = r0.f63978a
            if (r4 != 0) goto L_0x03d0
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x03d0:
            r6 = r7
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r11 = android.text.TextUtils.isEmpty(r6)
            if (r11 == 0) goto L_0x03dc
            r13 = r10
            r10 = r8
            goto L_0x03e3
        L_0x03dc:
            long r20 = java.lang.Long.parseLong(r7)
            r13 = r10
            r10 = r20
        L_0x03e3:
            int r20 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r20 == 0) goto L_0x03e9
            r4.f63997a = r10
        L_0x03e9:
            net.one97.paytm.recharge.common.utils.y r4 = net.one97.paytm.recharge.common.utils.y.f61814b
            r8 = 0
            net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r8)
            android.content.Intent r4 = r42.getIntent()
            boolean r4 = r4.hasExtra(r12)
            if (r4 == 0) goto L_0x0400
            android.content.Intent r4 = r42.getIntent()
            r4.removeExtra(r12)
        L_0x0400:
            if (r14 == 0) goto L_0x0418
            if (r1 == 0) goto L_0x0418
            boolean r4 = r1.containsKey(r12)
            r8 = 1
            if (r4 != r8) goto L_0x0418
            r0.f63992e = r14
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f63978a
            if (r2 != 0) goto L_0x0414
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0414:
            r2.c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r14)
            goto L_0x0476
        L_0x0418:
            if (r2 == 0) goto L_0x042f
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r2.getCart()
            if (r2 == 0) goto L_0x042f
            java.util.ArrayList r2 = r2.getCartItems()
            if (r2 == 0) goto L_0x042f
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = kotlin.a.k.d(r2)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2
            goto L_0x0430
        L_0x042f:
            r2 = 0
        L_0x0430:
            if (r2 == 0) goto L_0x043d
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r4 = r2.getmProductAttrubutes()
            if (r4 == 0) goto L_0x043d
            java.lang.String r4 = r4.getService()
            goto L_0x043e
        L_0x043d:
            r4 = 0
        L_0x043e:
            if (r2 == 0) goto L_0x044b
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r2 = r2.getmProductAttrubutes()
            if (r2 == 0) goto L_0x044b
            java.lang.String r2 = r2.getPaytype()
            goto L_0x044c
        L_0x044b:
            r2 = 0
        L_0x044c:
            net.one97.paytm.recharge.ordersummary.b.a r8 = r0.f63978a
            if (r8 != 0) goto L_0x0453
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0453:
            net.one97.paytm.recharge.ordersummary.b.a r9 = r0.f63978a
            if (r9 != 0) goto L_0x045a
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x045a:
            java.lang.String r9 = r9.a((java.lang.String) r4, (java.lang.String) r2)
            r8.b((java.lang.String) r9)
            net.one97.paytm.recharge.ordersummary.b.a r8 = r0.f63978a
            if (r8 != 0) goto L_0x0468
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0468:
            net.one97.paytm.recharge.ordersummary.b.a r9 = r0.f63978a
            if (r9 != 0) goto L_0x046f
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x046f:
            java.lang.String r2 = r9.b((java.lang.String) r4, (java.lang.String) r2)
            r8.a((java.lang.String) r2)
        L_0x0476:
            if (r6 == 0) goto L_0x0482
            int r2 = r6.length()
            if (r2 != 0) goto L_0x047f
            goto L_0x0482
        L_0x047f:
            r19 = 0
            goto L_0x0484
        L_0x0482:
            r19 = 1
        L_0x0484:
            if (r19 != 0) goto L_0x0490
            long r8 = java.lang.Long.parseLong(r7)
            r10 = 0
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 > 0) goto L_0x0497
        L_0x0490:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r4 = "os-activity : default category-id"
            r2.debugLog(r4)
        L_0x0497:
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f63978a
            if (r2 != 0) goto L_0x049e
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x049e:
            net.one97.paytm.recharge.ordersummary.b.a r4 = r0.f63978a
            if (r4 != 0) goto L_0x04a5
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x04a5:
            boolean r4 = r4.s
            r2.b((boolean) r4)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f63978a
            if (r2 != 0) goto L_0x04b1
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x04b1:
            net.one97.paytm.recharge.ordersummary.b.a r4 = r0.f63978a
            if (r4 != 0) goto L_0x04b8
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x04b8:
            java.lang.String r4 = r4.r()
            r2.a((android.content.Context) r13, (java.lang.String) r4)
            net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = net.one97.paytm.recharge.widgets.c.d.b()
            java.lang.String r4 = r2.getCategoryId()
            if (r4 != 0) goto L_0x04cc
            r4 = r7
        L_0x04cc:
            r2.setCategoryId(r4)
            java.lang.String r4 = r2.getProductId()
            if (r4 != 0) goto L_0x04d9
            java.lang.String r4 = java.lang.String.valueOf(r15)
        L_0x04d9:
            r2.setProductId(r4)
            net.one97.paytm.recharge.ordersummary.b.a r4 = r0.f63978a
            if (r4 != 0) goto L_0x04e3
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x04e3:
            java.lang.String r4 = r4.r()
            r2.setScreenName(r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r2.getFlowName()
            if (r4 != 0) goto L_0x0524
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = new net.one97.paytm.recharge.widgets.model.CRUFlowModel
            r19 = r4
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1048575(0xfffff, float:1.469367E-39)
            r41 = 0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
        L_0x0524:
            java.lang.String r6 = r0.f63979b
            r4.setOrderId(r6)
            java.util.LinkedList r6 = r4.getLogs()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "POST_PAYMENT:"
            r7.<init>(r8)
            boolean r8 = r42.x()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.push(r7)
            java.util.LinkedList r6 = r4.getLogs()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "FROM:"
            r7.<init>(r8)
            android.content.Intent r8 = r42.getIntent()
            java.lang.String r9 = "From"
            java.lang.String r8 = r8.getStringExtra(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.push(r7)
            r2.setFlowName(r4)
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r2 = net.one97.paytm.recharge.di.helper.c.q()
            java.lang.Long r4 = java.lang.Long.valueOf(r15)
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L_0x059d
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f63978a
            if (r2 != 0) goto L_0x057b
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x057b:
            androidx.lifecycle.y<net.one97.paytm.recharge.widgets.model.CJRTaggedObservable<net.one97.paytm.recharge.model.CJRContributionData>> r2 = r2.r
            net.one97.paytm.recharge.widgets.model.CJRTaggedObservable r4 = new net.one97.paytm.recharge.widgets.model.CJRTaggedObservable
            java.lang.String r6 = "tag.contribution.data.request.loader"
            r7 = 0
            r4.<init>(r6, r7)
            r2.setValue(r4)
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f63978a
            if (r2 != 0) goto L_0x058f
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x058f:
            r4 = r0
            net.one97.paytm.recharge.common.e.ai r4 = (net.one97.paytm.recharge.common.e.ai) r4
            net.one97.paytm.recharge.widgets.c.d r6 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r6 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r7, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r7)
            java.lang.String r7 = "fetch_total_contribution"
            r2.a((java.lang.String) r7, (net.one97.paytm.recharge.common.e.ai) r4, (java.lang.Object) r6)
        L_0x059d:
            if (r1 == 0) goto L_0x05a2
            r2 = 1
            r0.m = r2
        L_0x05a2:
            super.onCreate(r43)
            int r2 = net.one97.paytm.recharge.R.layout.activity_ajr_recharge_order_summary
            r0.setContentView((int) r2)
            int r2 = net.one97.paytm.recharge.R.id.home
            android.view.View r2 = r0.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity$b r4 = new net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity$b
            r4.<init>(r0)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r2.setOnClickListener(r4)
            boolean r2 = r0.f63980c
            if (r2 != 0) goto L_0x061f
            net.one97.paytm.recharge.ordersummary.b.a r1 = r0.f63978a
            if (r1 != 0) goto L_0x05c7
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x05c7:
            boolean r1 = r1.s
            if (r1 == 0) goto L_0x05d7
            boolean r1 = r0.m
            if (r1 != 0) goto L_0x05e0
            r1 = 1
            r0.w = r1
            r2 = 0
            r0.c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)
            goto L_0x05e0
        L_0x05d7:
            r1 = 1
            r0.f63982h = r1
            r0.a((boolean) r1)
            r42.b()
        L_0x05e0:
            java.lang.String r1 = r0.f63979b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x061a
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            r2 = 0
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r1 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r2, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r2)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x0600
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_LAUNCH
            java.lang.String r3 = r3.name()
            r2.setActionType(r3)
        L_0x0600:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r2 = r1.getFlowName()
            if (r2 == 0) goto L_0x060f
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r3 = r3.name()
            r2.setErrorType(r3)
        L_0x060f:
            java.lang.String r2 = r0.f63979b
            if (r2 != 0) goto L_0x0616
            kotlin.g.b.k.a()
        L_0x0616:
            r0.a((java.lang.String) r2, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r1)
            goto L_0x0641
        L_0x061a:
            r1 = 1
            r0.c((boolean) r1)
            goto L_0x0641
        L_0x061f:
            if (r1 != 0) goto L_0x0641
            android.content.Intent r1 = r42.getIntent()
            java.lang.String r1 = r1.getStringExtra(r3)
            java.lang.String r2 = "intent.getStringExtra(CJ…_RECHARGE_COMPONENT_NAME)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            android.content.Intent r2 = r42.getIntent()
            java.lang.String r3 = "recharge.component.args"
            android.os.Bundle r2 = r2.getBundleExtra(r3)
            java.lang.String r3 = "intent.getBundleExtra(CJ…_RECHARGE_COMPONENT_ARGS)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 1
            r0.a((java.lang.String) r1, (boolean) r3, (android.os.Bundle) r2)
        L_0x0641:
            net.one97.paytm.recharge.common.utils.f$a r1 = net.one97.paytm.recharge.common.utils.f.f61626a
            net.one97.paytm.recharge.common.utils.f r1 = net.one97.paytm.recharge.common.utils.f.a.a()
            r0.k = r1
            net.one97.paytm.recharge.ordersummary.h.a r1 = new net.one97.paytm.recharge.ordersummary.h.a
            net.one97.paytm.recharge.ordersummary.b.a r2 = r0.f63978a
            if (r2 != 0) goto L_0x0652
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0652:
            r1.<init>(r2, r0)
            r0.f63981d = r1
            net.one97.paytm.recharge.di.helper.c r1 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r1 = net.one97.paytm.recharge.di.helper.c.bp()
            android.content.Context r2 = r42.getApplicationContext()
            boolean r1 = com.paytm.utility.b.a((android.content.Context) r2, (boolean) r1)
            if (r1 == 0) goto L_0x066a
            r42.t()
        L_0x066a:
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r1 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r2 = "AJRechargeOrderSummaryActivity onCreate end"
            r1.debugLog(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity.onCreate(android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRechargeOrderSummaryActivity f63986a;

        b(AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity) {
            this.f63986a = aJRechargeOrderSummaryActivity;
        }

        public final void onClick(View view) {
            this.f63986a.onBackPressed();
        }
    }

    private final boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("recharge.component.name");
        String stringExtra2 = intent.getStringExtra("item_id");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = (net.one97.paytm.recharge.ordersummary.b.a) net.one97.paytm.recharge.ordersummary.h.c.f64335e.get(stringExtra2);
            if (aVar2 != null) {
                this.f63978a = aVar2;
                return true;
            }
        }
        CJRRechargeUtilities.INSTANCE.debugLog("AJRechargeOrderSummaryActivity cannot start item-details: ViewModel required");
        return false;
    }

    public void onNewIntent(Intent intent) {
        CJRRechargeUtilities.INSTANCE.debugLog("AJRechargeOrderSummaryActivity onNewIntent start");
        super.onNewIntent(intent);
        this.f63980c = false;
        if (intent != null && intent.hasExtra("recharge.component.name")) {
            this.f63980c = a(intent);
            if (!this.f63980c) {
                finish();
                return;
            }
            String stringExtra = intent.getStringExtra("recharge.component.name");
            k.a((Object) stringExtra, "intent.getStringExtra(CJ…_RECHARGE_COMPONENT_NAME)");
            Bundle bundleExtra = intent.getBundleExtra("recharge.component.args");
            k.a((Object) bundleExtra, "intent.getBundleExtra(CJ…_RECHARGE_COMPONENT_ARGS)");
            a(stringExtra, true, bundleExtra);
        }
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        if (com.paytm.utility.b.a(getApplicationContext(), net.one97.paytm.recharge.di.helper.c.bp())) {
            t();
        }
        CJRRechargeUtilities.INSTANCE.debugLog("AJRechargeOrderSummaryActivity onNewIntent end");
    }

    public void onStart() {
        CJRRechargeUtilities.INSTANCE.debugLog("OS in Foreground State");
        this.A = false;
        super.onStart();
        if (this.z && this.y != null) {
            this.z = false;
            y();
            CJROrderSummary cJROrderSummary = this.y;
            if (cJROrderSummary == null) {
                k.a();
            }
            b(cJROrderSummary);
            this.y = null;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.o) {
            this.o = false;
            int i2 = this.v.f61120b;
            int i3 = this.v.f61119a;
            c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            if (i2 == net.one97.paytm.recharge.ordersummary.h.c.f64333c) {
                if (i3 == -1) {
                    int i4 = this.n;
                    c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                    if (i4 < net.one97.paytm.recharge.ordersummary.h.c.f64334d) {
                        if (!TextUtils.isEmpty(this.f63979b)) {
                            d dVar = d.f64967a;
                            CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                            CRUFlowModel flowName = a2.getFlowName();
                            if (flowName != null) {
                                flowName.setActionType(ACTION_TYPE.OS_LAUNCH_AUTH_RETRY.name());
                            }
                            CRUFlowModel flowName2 = a2.getFlowName();
                            if (flowName2 != null) {
                                flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
                            }
                            String str = this.f63979b;
                            if (str == null) {
                                k.a();
                            }
                            a(str, a2);
                            return;
                        }
                        c(true);
                        return;
                    }
                }
                String string = getString(R.string.message_error_data_display);
                k.a((Object) string, "getString(R.string.message_error_data_display)");
                String string2 = getString(R.string.error_title_auth_failure);
                k.a((Object) string2, "getString(R.string.error_title_auth_failure)");
                if (this.u == null) {
                    this.u = new com.paytm.utility.l();
                    Bundle bundle = new Bundle();
                    if (!TextUtils.isEmpty(string2)) {
                        bundle.putString("error_title", string2);
                    }
                    if (!TextUtils.isEmpty(string)) {
                        bundle.putString("error_desc", string);
                        com.paytm.utility.l lVar = this.u;
                        if (lVar == null) {
                            k.a();
                        }
                        lVar.setArguments(bundle);
                        com.paytm.utility.l lVar2 = this.u;
                        if (lVar2 == null) {
                            k.a();
                        }
                        lVar2.setCancelable(false);
                        com.paytm.utility.l lVar3 = this.u;
                        if (lVar3 == null) {
                            k.a();
                        }
                        lVar3.a((View.OnClickListener) new c(this));
                    }
                }
                try {
                    if (!isFinishing()) {
                        com.paytm.utility.l lVar4 = this.u;
                        if (lVar4 == null) {
                            k.a();
                        }
                        lVar4.show(getSupportFragmentManager(), "Error sheet");
                    }
                } catch (IllegalStateException unused) {
                    CJRRechargeUtilities.INSTANCE.debugLog("MyOrder Auth Error dialog not shown, illegal state");
                    finish();
                }
            }
        }
    }

    public final void a(boolean z2) {
        View findViewById = findViewById(R.id.progress_bar);
        k.a((Object) findViewById, "(findViewById<View>(R.id.progress_bar))");
        findViewById.setVisibility(z2 ? 0 : 8);
    }

    public void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        if (getIntent().getExtras() != null) {
            bundle.putBundle("extra_params", getIntent().getExtras());
        }
        bundle.putSerializable("Order_summary", this.f63992e);
        super.onSaveInstanceState(bundle);
    }

    public final void a(l lVar) {
        k.c(lVar, "onSummaryListener");
        this.j = lVar;
        this.w = false;
        getIntent().removeExtra("Order_summary");
        if (!TextUtils.isEmpty(this.f63979b)) {
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                flowName.setActionType(ACTION_TYPE.OS_POOLING.name());
            }
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            String str = this.f63979b;
            if (str == null) {
                k.a();
            }
            a(str, a2);
            return;
        }
        c(true);
    }

    public final void a(String str, CJRRechargeErrorModel cJRRechargeErrorModel) {
        k.c(str, "orderId");
        k.c(cJRRechargeErrorModel, "hawkEyeModel");
        if (!this.w) {
            CJRRechargeUtilities.INSTANCE.debugLog("Post: fetchOrderSummaryFromNetwork: ".concat(String.valueOf(str)));
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
            if (aVar == null) {
                k.a("viewModel");
            }
            if (aVar.a()) {
                net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63978a;
                if (aVar2 == null) {
                    k.a("viewModel");
                }
                aVar2.a("fetch_order_detail", str, "", this, cJRRechargeErrorModel);
            } else {
                super.a(str, cJRRechargeErrorModel);
            }
            this.x = false;
        }
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, Payload.RESPONSE);
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities.debugLog("onOrderSummaryLoaded: callback at activity " + AJRechargeOrderSummaryActivity.class.getName());
        super.a(cJROrderSummary);
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
        if (aVar == null) {
            k.a("viewModel");
        }
        aVar.c(cJROrderSummary);
        if (this.f63982h || this.f63994g) {
            if (this.f63994g) {
                this.f63994g = false;
            }
            getIntent().putExtra(UpiConstants.FROM, "Order_history");
            if (2 == cJROrderSummary.getOrderStatus()) {
                net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63978a;
                if (aVar2 == null) {
                    k.a("viewModel");
                }
                if (aVar2.f64002f) {
                    net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f63978a;
                    if (aVar3 == null) {
                        k.a("viewModel");
                    }
                    if (!aVar3.a()) {
                        CJROrderSummary cJROrderSummary2 = this.f63992e;
                        net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.f63978a;
                        if (aVar4 == null) {
                            k.a("viewModel");
                        }
                        a(cJROrderSummary2, aVar4.d(), (Map<String, ? extends View>) null);
                    }
                }
            }
            c(cJROrderSummary);
        }
        CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded: passing callback to requesting fragment");
        l lVar = this.j;
        if (lVar != null) {
            lVar.a(cJROrderSummary);
        }
        this.j = null;
    }

    private final boolean x() {
        String stringExtra = getIntent().getStringExtra(UpiConstants.FROM);
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        if (p.a(stringExtra, "paytm_automatic", true) || p.a(stringExtra, "Payment", true)) {
            return true;
        }
        return false;
    }

    public final void a(int i2) {
        View findViewById = findViewById(R.id.textView52);
        if (!(findViewById instanceof View)) {
            findViewById = null;
        }
        if (findViewById != null) {
            findViewById.setVisibility(i2);
        }
    }

    public final void b() {
        View findViewById = findViewById(R.id.home);
        if (!(findViewById instanceof ImageView)) {
            findViewById = null;
        }
        ImageView imageView = (ImageView) findViewById;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRechargeOrderSummaryActivity f63984a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f63985b;

        a(AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity, x.e eVar) {
            this.f63984a = aJRechargeOrderSummaryActivity;
            this.f63985b = eVar;
        }

        public final void onClick(View view) {
            ((net.one97.paytm.recharge.metro.c.p) ((Fragment) this.f63985b.element)).a();
            if (!TextUtils.isEmpty(this.f63984a.f63979b)) {
                this.f63984a.x = true;
                d dVar = d.f64967a;
                CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a2.getFlowName();
                if (flowName != null) {
                    flowName.setActionType(ACTION_TYPE.OS_LAUNCH_NETWORK_RETRY.name());
                }
                CRUFlowModel flowName2 = a2.getFlowName();
                if (flowName2 != null) {
                    flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = this.f63984a;
                String str = aJRechargeOrderSummaryActivity.f63979b;
                if (str == null) {
                    k.a();
                }
                aJRechargeOrderSummaryActivity.a(str, a2);
                return;
            }
            this.f63984a.c(true);
        }
    }

    private final void c(CJROrderSummary cJROrderSummary) {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
        if (aVar == null) {
            k.a("viewModel");
        }
        if (aVar.a()) {
            j supportFragmentManager = getSupportFragmentManager();
            FrameLayout frameLayout = (FrameLayout) c(R.id.container);
            k.a((Object) frameLayout, "container");
            Fragment c2 = supportFragmentManager.c(frameLayout.getId());
            if (c2 != null && !(c2 instanceof net.one97.paytm.recharge.metro.c.p)) {
                CJRRechargeUtilities.INSTANCE.debugLog("AJRechargeOrderSummaryActivity inflatePreSuccess already inflated");
                return;
            }
        }
        CJRRechargeUtilities.INSTANCE.debugLog("AJRechargeOrderSummaryActivity inflatePreSuccess new inflate");
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.FROM, getIntent().getStringExtra(UpiConstants.FROM));
        if (cJROrderSummary != null) {
            bundle.putSerializable("ordered_item", cJROrderSummary);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("recharge cart");
            if (!(serializableExtra instanceof CJRRechargeCart)) {
                serializableExtra = null;
            }
            this.l = (CJRRechargeCart) serializableExtra;
            bundle.putSerializable("recharge cart", this.l);
        }
        j supportFragmentManager2 = getSupportFragmentManager();
        k.a((Object) supportFragmentManager2, "supportFragmentManager");
        for (Fragment a2 : supportFragmentManager2.g()) {
            q a3 = getSupportFragmentManager().a();
            k.a((Object) a3, "supportFragmentManager.beginTransaction()");
            a3.a(a2);
            a3.c();
        }
        q a4 = getSupportFragmentManager().a();
        FrameLayout frameLayout2 = (FrameLayout) c(R.id.container);
        k.a((Object) frameLayout2, "container");
        int id = frameLayout2.getId();
        String name = net.one97.paytm.recharge.ordersummary.d.q.class.getName();
        k.a((Object) name, "FJRPreSuccessRechargeOrd…Fragment::class.java.name");
        a4.a(id, Fragment.instantiate(this, name, bundle)).c();
    }

    public final void a(CJROrderSummary cJROrderSummary, boolean z2, Map<String, ? extends View> map) {
        String str;
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
        if (aVar == null) {
            k.a("viewModel");
        }
        if (aVar.s) {
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63978a;
            if (aVar2 == null) {
                k.a("viewModel");
            }
            if (!aVar2.o) {
                net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f63978a;
                if (aVar3 == null) {
                    k.a("viewModel");
                }
                aVar3.o = true;
                CJRRecentsLazyLoader.a aVar4 = CJRRecentsLazyLoader.f61453a;
                CJRRecentsLazyLoader.a.a();
            }
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.f63978a;
        if (aVar5 == null) {
            k.a("viewModel");
        }
        if (!aVar5.a()) {
            u();
        }
        if (z2) {
            net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.f63978a;
            if (aVar6 == null) {
                k.a("viewModel");
            }
            str = aVar6.e();
        } else {
            net.one97.paytm.recharge.ordersummary.b.a aVar7 = this.f63978a;
            if (aVar7 == null) {
                k.a("viewModel");
            }
            str = aVar7.g();
        }
        if (getSupportFragmentManager().c(str) != null) {
            CJRRechargeUtilities.INSTANCE.debugLog("AJRechargeOrderSummaryActivity inflateSuccess already inflated");
            return;
        }
        CJRRechargeUtilities.INSTANCE.debugLog("AJRechargeOrderSummaryActivity inflateSuccess new inflate");
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.FROM, getIntent().getStringExtra(UpiConstants.FROM));
        bundle.putSerializable("ordered_item", cJROrderSummary);
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        bundle.putString("store_url", net.one97.paytm.recharge.di.helper.c.at());
        Fragment instantiate = Fragment.instantiate(this, str, bundle);
        k.a((Object) instantiate, "Fragment.instantiate(this, fName, args)");
        q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        net.one97.paytm.recharge.ordersummary.b.a aVar8 = this.f63978a;
        if (aVar8 == null) {
            k.a("viewModel");
        }
        if (aVar8.s && !z2 && this.f63978a == null) {
            k.a("viewModel");
        }
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                a2.l();
                try {
                    a2.a((View) next.getValue(), (String) next.getKey());
                } catch (Throwable unused) {
                }
            }
        }
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        for (Fragment a3 : supportFragmentManager.g()) {
            q a4 = getSupportFragmentManager().a();
            k.a((Object) a4, "supportFragmentManager.beginTransaction()");
            a4.a(a3);
            a4.c();
        }
        FrameLayout frameLayout = (FrameLayout) c(R.id.container);
        k.a((Object) frameLayout, "container");
        a2.a(frameLayout.getId(), instantiate, str);
        a2.c();
    }

    public final void a(String str, boolean z2, Bundle bundle) {
        k.c(str, "fName");
        k.c(bundle, "args");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
        if (aVar == null) {
            k.a("viewModel");
        }
        CJROrderedCart u2 = aVar.u();
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append(AJRechargeOrderSummaryActivity.class.getName());
        sb.append(" : inflateFragment : Status ");
        sb.append(u2 != null ? u2.getItemStatus() : null);
        cJRRechargeUtilities.debugLog(sb.toString());
        bundle.putString(UpiConstants.FROM, getIntent().getStringExtra(UpiConstants.FROM));
        q a2 = getSupportFragmentManager().a();
        k.a((Object) a2, "supportFragmentManager.beginTransaction()");
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) c(R.id.container);
            k.a((Object) frameLayout, "container");
            a2.a(frameLayout.getId(), Fragment.instantiate(this, str, bundle), str);
            a2.a(str);
        } else {
            j supportFragmentManager = getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "supportFragmentManager");
            for (Fragment a3 : supportFragmentManager.g()) {
                q a4 = getSupportFragmentManager().a();
                k.a((Object) a4, "supportFragmentManager.beginTransaction()");
                a4.a(a3);
                a4.c();
            }
            FrameLayout frameLayout2 = (FrameLayout) c(R.id.container);
            k.a((Object) frameLayout2, "container");
            a2.a(frameLayout2.getId(), Fragment.instantiate(this, str, bundle), str);
        }
        a2.c();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRechargeOrderSummaryActivity f63987a;

        c(AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity) {
            this.f63987a = aJRechargeOrderSummaryActivity;
        }

        public final void onClick(View view) {
            this.f63987a.finish();
        }
    }

    public final void a(CJROrderedCart cJROrderedCart, boolean z2, boolean z3) {
        k.c(cJROrderedCart, "orderedList");
        net.one97.paytm.recharge.ordersummary.h.a aVar = this.f63981d;
        if (aVar != null) {
            aVar.a(cJROrderedCart, z2, z3);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment fragment;
        super.onActivityResult(i2, i3, intent);
        f.a aVar = f.f61626a;
        if (i2 == f.f61628g) {
            j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                FrameLayout frameLayout = (FrameLayout) c(R.id.container);
                k.a((Object) frameLayout, "container");
                fragment = supportFragmentManager.c(frameLayout.getId());
            } else {
                fragment = null;
            }
            if (fragment instanceof t) {
                ((t) fragment).r();
            }
            dismiss();
        }
        this.v = new FJRRechargeUtilBaseFragment.a(i3, i2, intent);
        this.o = true;
    }

    private void y() {
        try {
            Fragment c2 = getSupportFragmentManager().c(net.one97.paytm.recharge.metro.c.p.f63425a);
            if (c2 != null && c2.isAdded()) {
                CJRRechargeUtilities.INSTANCE.debugLog("removeNoInternetFragment");
                ((net.one97.paytm.recharge.metro.c.p) c2).b();
                getSupportFragmentManager().d();
            }
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog("Remove NoInternetFragment onStart : " + e2.getMessage());
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        if (str != null && str.hashCode() == 1511711440 && str.equals("fetch_total_contribution")) {
            if (iJRPaytmDataModel instanceof CJRContributionData) {
                net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
                if (aVar == null) {
                    k.a("viewModel");
                }
                aVar.r.setValue(new CJRTaggedObservable(str, iJRPaytmDataModel));
                return;
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63978a;
            if (aVar2 == null) {
                k.a("viewModel");
            }
            aVar2.r.setValue(new CJRTaggedObservable(str, null));
        } else if (iJRPaytmDataModel instanceof CJROrderSummary) {
            CJRRechargeUtilities.INSTANCE.debugLog("onApiSuccess");
            if (!this.A) {
                y();
                b((CJROrderSummary) iJRPaytmDataModel);
                return;
            }
            this.y = (CJROrderSummary) iJRPaytmDataModel;
            this.z = true;
        } else if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
            CJRRechargeUtilities.INSTANCE.setFrequentOrderList((CJRFrequentOrderList) iJRPaytmDataModel);
        } else {
            super.a_(str, iJRPaytmDataModel, obj);
        }
    }

    public void onStop() {
        CJRRechargeUtilities.INSTANCE.debugLog("OS in Background State");
        this.A = true;
        super.onStop();
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        if (str.hashCode() == 1511711440 && str.equals("fetch_total_contribution")) {
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
            if (aVar == null) {
                k.a("viewModel");
            }
            aVar.r.setValue(new CJRTaggedObservable(str, null));
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
                return;
            }
            return;
        }
        CJRRechargeUtilities.INSTANCE.debugLog("handleErrorCode: called Tag: " + str + " error: " + networkCustomError);
        if (networkCustomError instanceof ap) {
            y();
            w();
        } else if (networkCustomError instanceof net.one97.paytm.recharge.common.utils.c) {
            y();
            if (!TextUtils.isEmpty(this.f63979b)) {
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                String str2 = this.f63979b;
                if (str2 == null) {
                    k.a();
                }
                String a2 = net.one97.paytm.recharge.di.helper.c.a(str2);
                if (a2 == null) {
                    a2 = "";
                }
                String str3 = this.f63979b;
                if (str3 == null) {
                    k.a();
                }
                a(a2, str3);
                return;
            }
            c(true);
        } else if (!(networkCustomError instanceof as)) {
            y();
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                this.n++;
                CJRRechargeUtilities.INSTANCE.debugLog("CJRRechargeUtilities.handleError: called Tag: " + str + " error: " + networkCustomError);
                c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                CJRRechargeUtilities.INSTANCE.handleError(str, this, (Fragment) null, networkCustomError, true, net.one97.paytm.recharge.ordersummary.h.c.f64333c, (Object) null);
                return;
            }
            CJRRechargeUtilities.INSTANCE.debugLog("super handleErrorCode: called Tag: " + str + " error: " + networkCustomError);
            super.a(str, i2, iJRPaytmDataModel, networkCustomError, obj);
        } else if (!isFinishing()) {
            CJRRechargeUtilities.INSTANCE.debugLog("inflateNoInternetLayout");
            x.e eVar = new x.e();
            eVar.element = getSupportFragmentManager().c(net.one97.paytm.recharge.metro.c.p.f63425a);
            if (((Fragment) eVar.element) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(AppManagerUtil.EXTEND_TYPE, net.one97.paytm.recharge.metro.c.p.f63428d);
                T instantiate = Fragment.instantiate(this, net.one97.paytm.recharge.metro.c.p.class.getName(), bundle);
                if (instantiate != null) {
                    eVar.element = (Fragment) ((net.one97.paytm.recharge.metro.c.p) instantiate);
                    ((net.one97.paytm.recharge.metro.c.p) ((Fragment) eVar.element)).a(new a(this, eVar));
                    CJRRechargeUtilities.INSTANCE.debugLog("inflateNoInternetLayout: beginTransaction");
                    q a3 = getSupportFragmentManager().a();
                    FrameLayout frameLayout = (FrameLayout) c(R.id.container);
                    k.a((Object) frameLayout, "container");
                    a3.a(frameLayout.getId(), (Fragment) eVar.element, net.one97.paytm.recharge.metro.c.p.f63425a).a(net.one97.paytm.recharge.metro.c.p.f63425a).c();
                    CJRRechargeUtilities.INSTANCE.debugLog("inflateNoInternetLayout: commitAllowingStateLoss");
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJROfflineDataDisplayFragment");
            }
            CJRRechargeUtilities.INSTANCE.debugLog("inflateNoInternetLayout: stopProceedAnimation");
            Fragment fragment = (Fragment) eVar.element;
            if (fragment != null) {
                ((net.one97.paytm.recharge.metro.c.p) fragment).b();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.metro.fragment.FJROfflineDataDisplayFragment");
        }
    }

    public final void d() {
        super.o();
        this.f63983i = true;
    }

    public final void a(Context context, String str) {
        if (this.f63983i) {
            super.a(context, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        if (r3 == net.one97.paytm.recharge.common.utils.f.f61628g) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int r3, java.lang.String[] r4, int[] r5) {
        /*
            r2 = this;
            java.lang.String r0 = "permissions"
            kotlin.g.b.k.c(r4, r0)
            java.lang.String r0 = "grantResults"
            kotlin.g.b.k.c(r5, r0)
            net.one97.paytm.recharge.common.utils.f$a r0 = net.one97.paytm.recharge.common.utils.f.f61626a
            int r0 = net.one97.paytm.recharge.common.utils.f.f61627f
            if (r3 == r0) goto L_0x001a
            net.one97.paytm.recharge.common.utils.f$a r0 = net.one97.paytm.recharge.common.utils.f.f61626a
            int r0 = net.one97.paytm.recharge.common.utils.f.f61628g
            if (r3 != r0) goto L_0x0029
        L_0x001a:
            net.one97.paytm.recharge.common.utils.f r0 = r2.k
            if (r0 == 0) goto L_0x0029
            r1 = r2
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r0 = r0.a((android.app.Activity) r1, (int) r3, (java.lang.String[]) r4, (int[]) r5)
            r1 = 1
            if (r0 != r1) goto L_0x0029
            return
        L_0x0029:
            super.onRequestPermissionsResult(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity.onRequestPermissionsResult(int, java.lang.String[], int[]):void");
    }

    public final View a(View.OnClickListener onClickListener) {
        k.c(onClickListener, "clickListener");
        TextView textView = (TextView) findViewById(R.id.share);
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        k.a((Object) textView, "shareView");
        return textView;
    }

    public final void a(String str, View view) {
        f fVar = this.k;
        if (fVar != null) {
            fVar.a(this, str, view);
        }
    }

    public final void a(String str, String str2, String str3) {
        f fVar = this.k;
        if (fVar != null) {
            fVar.a((Activity) this, str, str2, str3);
        }
    }

    public final net.one97.paytm.recharge.ordersummary.b.a l() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public final Class<?> a(CJRRechargeCart cJRRechargeCart) {
        return AJRechargeOrderSummaryActivity.class;
    }

    public final Class<?> b(CJRRechargeCart cJRRechargeCart) {
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        return net.one97.paytm.recharge.di.helper.a.e();
    }

    public void show() {
        View findViewById = findViewById(R.id.lyt_progress_cst);
        k.a((Object) findViewById, "findViewById<FrameLayout>(R.id.lyt_progress_cst)");
        net.one97.paytm.recharge.common.utils.ai.a(findViewById);
    }

    public void dismiss() {
        View findViewById = findViewById(R.id.lyt_progress_cst);
        k.a((Object) findViewById, "findViewById<FrameLayout>(R.id.lyt_progress_cst)");
        net.one97.paytm.recharge.common.utils.ai.b(findViewById);
    }

    public final void u() {
        View findViewById = findViewById(R.id.bottom_navigation);
        k.a((Object) findViewById, "findViewById<View>(R.id.bottom_navigation)");
        findViewById.setVisibility(0);
    }

    public void onBackPressed() {
        j supportFragmentManager = getSupportFragmentManager();
        FrameLayout frameLayout = (FrameLayout) c(R.id.container);
        k.a((Object) frameLayout, "container");
        Fragment c2 = supportFragmentManager.c(frameLayout.getId());
        if (!(c2 instanceof ac) || !((ac) c2).ax_()) {
            if (p.a("ticketCancelledOS", this.f63993f, true)) {
                this.f63993f = "Payment";
            }
            if (!this.f63980c) {
                super.onBackPressed();
                return;
            }
            c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            net.one97.paytm.recharge.ordersummary.h.c.f64335e.remove(getIntent().getStringExtra("item_id"));
            finish();
        }
    }

    public final void v() {
        j supportFragmentManager = getSupportFragmentManager();
        FrameLayout frameLayout = (FrameLayout) c(R.id.container);
        k.a((Object) frameLayout, "container");
        Fragment c2 = supportFragmentManager.c(frameLayout.getId());
        if (c2 != null && (c2 instanceof net.one97.paytm.recharge.ordersummary.d.f)) {
            ((net.one97.paytm.recharge.ordersummary.d.f) c2).v();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (!this.f63980c) {
            d dVar = d.f64967a;
            CRUFlowModel flowName = d.b().getFlowName();
            if (flowName != null) {
                flowName.setOrderId((String) null);
            }
        }
        this.y = null;
    }

    public void onLowMemory() {
        CJRRechargeUtilities.INSTANCE.debugLog("Activity-OS-Recreate : onLowMemory");
        super.onLowMemory();
    }

    public final void c() {
        CJROrderSummary cJROrderSummary = this.f63992e;
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63978a;
        if (aVar == null) {
            k.a("viewModel");
        }
        a(cJROrderSummary, aVar.d(), (Map<String, ? extends View>) null);
    }
}
