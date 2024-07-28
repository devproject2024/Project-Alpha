package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.core.g.d;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import io.reactivex.rxjava3.d.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.a.f;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.h.c;
import org.json.JSONObject;

public final class e implements net.one97.paytm.recharge.ordersummary.f.c {

    /* renamed from: a  reason: collision with root package name */
    net.one97.paytm.recharge.ordersummary.b.a f64289a;

    /* renamed from: b  reason: collision with root package name */
    CJROrderSummary f64290b;

    /* renamed from: c  reason: collision with root package name */
    public String f64291c;

    /* renamed from: d  reason: collision with root package name */
    public String f64292d;

    /* renamed from: e  reason: collision with root package name */
    String f64293e;

    /* renamed from: f  reason: collision with root package name */
    String f64294f;

    /* renamed from: g  reason: collision with root package name */
    String f64295g;

    /* renamed from: h  reason: collision with root package name */
    Object f64296h;

    /* renamed from: i  reason: collision with root package name */
    private CJRRechargeCart f64297i;

    static final class b<T> implements g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f64299a = new b();

        b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class c implements io.reactivex.rxjava3.d.a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f64300a = new c();

        c() {
        }

        public final void run() {
        }
    }

    public final String R(Context context) {
        k.c(context, "context");
        return "";
    }

    public final String T(Context context) {
        k.c(context, "context");
        return "";
    }

    public final ArrayList<o<String, String>> j(Context context) {
        k.c(context, "context");
        return null;
    }

    static final class a<T> implements g<CJROrderSummary> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f64298a;

        a(e eVar) {
            this.f64298a = eVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            String str;
            String str2;
            String str3;
            Map<String, String> rechargeConfiguration;
            String str4;
            CJROrderSummaryProductDetail productDetail;
            CJRAttributes attributes;
            CJROrderSummaryProductDetail productDetail2;
            CJRAttributes attributes2;
            CJROrderSummaryProductDetail productDetail3;
            CJRAttributes attributes3;
            CJROrderSummary cJROrderSummary = (CJROrderSummary) obj;
            e eVar = this.f64298a;
            eVar.f64290b = cJROrderSummary;
            if (cJROrderSummary != null) {
                net.one97.paytm.recharge.ordersummary.b.a aVar = eVar.f64289a;
                if (aVar == null) {
                    k.a();
                }
                CJROrderedCart u = aVar.u();
                String str5 = "";
                if (u == null || (productDetail3 = u.getProductDetail()) == null || (attributes3 = productDetail3.getAttributes()) == null || (str = attributes3.getOperatorDisplayLabel()) == null) {
                    str = str5;
                }
                eVar.f64291c = str;
                if (u == null || (productDetail2 = u.getProductDetail()) == null || (attributes2 = productDetail2.getAttributes()) == null || (str2 = attributes2.getPayTypeDisplayLabel()) == null) {
                    str2 = str5;
                }
                eVar.f64292d = str2;
                if (u == null || (productDetail = u.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (str3 = attributes.getServiceDisplayLabel()) == null) {
                    str3 = str5;
                }
                eVar.f64293e = str3;
                if (!(u == null || (rechargeConfiguration = u.getRechargeConfiguration()) == null || (str4 = rechargeConfiguration.get("recharge_number")) == null)) {
                    str5 = str4;
                }
                eVar.f64294f = str5;
                eVar.f64296h = u != null ? u.getMetaDataResponse() : null;
                c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
                eVar.f64295g = c.a.a(eVar.f64292d);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c1, code lost:
        r0 = (r0 = (r0 = r0.getCart()).getCartItems()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(net.one97.paytm.recharge.ordersummary.b.a r5) {
        /*
            r4 = this;
            java.lang.String r0 = "viewModel"
            kotlin.g.b.k.c(r5, r0)
            r4.f64289a = r5
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r5.t
            r4.f64297i = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r4.f64297i
            if (r0 == 0) goto L_0x00db
            java.lang.String r1 = ""
            r2 = 0
            if (r0 == 0) goto L_0x0035
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0035
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x0035
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x0035
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r0 = r0.getmProductAttrubutes()
            if (r0 == 0) goto L_0x0035
            java.lang.String r0 = r0.getOperatorDisplayLabel()
            if (r0 != 0) goto L_0x0036
        L_0x0035:
            r0 = r1
        L_0x0036:
            r4.f64291c = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r4.f64297i
            if (r0 == 0) goto L_0x005c
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x005c
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x005c
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r0 = r0.getmProductAttrubutes()
            if (r0 == 0) goto L_0x005c
            java.lang.String r0 = r0.getPaytTypeDisplayLabel()
            if (r0 != 0) goto L_0x005d
        L_0x005c:
            r0 = r1
        L_0x005d:
            r4.f64292d = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r4.f64297i
            if (r0 == 0) goto L_0x0083
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x0083
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x0083
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x0083
            net.one97.paytm.common.entity.recharge.v2.CJRProductAttributes r0 = r0.getmProductAttrubutes()
            if (r0 == 0) goto L_0x0083
            java.lang.String r0 = r0.getServiceDisplayLabel()
            if (r0 != 0) goto L_0x0084
        L_0x0083:
            r0 = r1
        L_0x0084:
            r4.f64293e = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r4.f64297i
            if (r0 == 0) goto L_0x00ae
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x00ae
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x00ae
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x00ae
            java.util.Map r0 = r0.getConfigurationList()
            if (r0 == 0) goto L_0x00ae
            java.lang.String r3 = "recharge_number"
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x00af
        L_0x00ae:
            r0 = r1
        L_0x00af:
            r4.f64294f = r0
            net.one97.paytm.common.entity.CJRRechargeCart r0 = r4.f64297i
            if (r0 == 0) goto L_0x00ce
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r0.getCart()
            if (r0 == 0) goto L_0x00ce
            java.util.ArrayList r0 = r0.getCartItems()
            if (r0 == 0) goto L_0x00ce
            java.lang.Object r0 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            if (r0 == 0) goto L_0x00ce
            java.lang.Object r0 = r0.getMetaDataResponse()
            goto L_0x00cf
        L_0x00ce:
            r0 = 0
        L_0x00cf:
            r4.f64296h = r0
            net.one97.paytm.recharge.ordersummary.h.c$a r0 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r0 = r4.f64292d
            java.lang.String r0 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r0)
            r4.f64295g = r0
        L_0x00db:
            io.reactivex.rxjava3.j.b<net.one97.paytm.common.entity.shopping.CJROrderSummary> r5 = r5.f63999c
            net.one97.paytm.recharge.ordersummary.g.e$a r0 = new net.one97.paytm.recharge.ordersummary.g.e$a
            r0.<init>(r4)
            io.reactivex.rxjava3.d.g r0 = (io.reactivex.rxjava3.d.g) r0
            net.one97.paytm.recharge.ordersummary.g.e$b r1 = net.one97.paytm.recharge.ordersummary.g.e.b.f64299a
            io.reactivex.rxjava3.d.g r1 = (io.reactivex.rxjava3.d.g) r1
            net.one97.paytm.recharge.ordersummary.g.e$c r2 = net.one97.paytm.recharge.ordersummary.g.e.c.f64300a
            io.reactivex.rxjava3.d.a r2 = (io.reactivex.rxjava3.d.a) r2
            r5.subscribe(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.b(net.one97.paytm.recharge.ordersummary.b.a):void");
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderSummary");
        this.f64290b = cJROrderSummary;
    }

    public final String a(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.operator_hyphen_number, new Object[]{this.f64291c, this.f64294f});
        k.a((Object) string, "context.getString(R.stri…atorName, rechargeNumber)");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r1 == null) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.StringBuilder b(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r8, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r7.f64290b
            r2 = 0
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x0047
            java.util.ArrayList r1 = r1.getOrderedCartList()
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            if (r1 == 0) goto L_0x0047
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x0047
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r1.getPaytype()
            if (r1 == 0) goto L_0x0047
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            if (r1 != 0) goto L_0x0048
            goto L_0x0047
        L_0x003f:
            kotlin.u r8 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r0)
            throw r8
        L_0x0047:
            r1 = r3
        L_0x0048:
            int r4 = r1.hashCode()
            r5 = -318370833(0xffffffffed060bef, float:-2.5928386E27)
            java.lang.String r6 = " "
            if (r4 == r5) goto L_0x006e
            r5 = 757836652(0x2d2bab6c, float:9.758288E-12)
            if (r4 == r5) goto L_0x0059
            goto L_0x0082
        L_0x0059:
            java.lang.String r4 = "postpaid"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0082
            int r1 = net.one97.paytm.recharge.R.string.bill
            java.lang.String r1 = r8.getString(r1)
            r0.append(r1)
            r0.append(r6)
            goto L_0x0082
        L_0x006e:
            java.lang.String r4 = "prepaid"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0082
            int r1 = net.one97.paytm.recharge.R.string.recharge
            java.lang.String r1 = r8.getString(r1)
            r0.append(r1)
            r0.append(r6)
        L_0x0082:
            int r1 = net.one97.paytm.recharge.R.string.amount_re
            java.lang.String r8 = r8.getString(r1)
            r0.append(r8)
            java.lang.String r8 = " - ₹"
            r0.append(r8)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r7.f64290b
            if (r8 == 0) goto L_0x00ac
            java.util.ArrayList r8 = r8.getOrderedCartList()
            if (r8 == 0) goto L_0x00ac
            java.lang.Object r8 = r8.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8
            if (r8 == 0) goto L_0x00ac
            double r1 = r8.getSubTotal()
            java.lang.String r8 = java.lang.String.valueOf(r1)
            if (r8 != 0) goto L_0x00ad
        L_0x00ac:
            r8 = r3
        L_0x00ad:
            r1 = 1
            java.lang.String r8 = net.one97.paytm.recharge.common.utils.ba.a((java.lang.String) r8, (boolean) r1)
            r0.append(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.b(android.content.Context):java.lang.StringBuilder");
    }

    public final String o(Context context) {
        String str;
        k.c(context, "context");
        int i2 = R.string.recharge_details_orderid;
        Object[] objArr = new Object[1];
        CJROrderSummary cJROrderSummary = this.f64290b;
        if (cJROrderSummary == null || (str = cJROrderSummary.getId()) == null) {
            str = "";
        }
        objArr[0] = str;
        String string = context.getString(i2, objArr);
        k.a((Object) string, "context.getString(R.stri…(orderSummary?.id ?: \"\"))");
        return string;
    }

    public final String n(Context context) {
        String str;
        k.c(context, "context");
        CJROrderSummary cJROrderSummary = this.f64290b;
        if (cJROrderSummary == null || (str = cJROrderSummary.getCreatedAt()) == null) {
            str = "";
        }
        String a2 = ab.a(str, "hh:mm a, dd MMM yyyy");
        return a2 == null ? "" : a2;
    }

    public final String D(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.confirming_your_payment);
        k.a((Object) string, "context.getString(R.stri….confirming_your_payment)");
        return string;
    }

    public final String k(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.confirming_your_recharge, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String c(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.processing_vertical, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = r3.f64290b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.common.entity.shopping.CJROrderedCart r4) {
        /*
            r3 = this;
            java.lang.String r0 = "cjrOrderedCart"
            kotlin.g.b.k.c(r4, r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r3.f64290b
            r1 = 1
            if (r0 == 0) goto L_0x0011
            int r0 = r0.getOrderStatus()
            r2 = 4
            if (r0 == r2) goto L_0x0038
        L_0x0011:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r3.f64290b
            if (r0 == 0) goto L_0x001d
            int r0 = r0.getOrderStatus()
            r2 = 8
            if (r0 == r2) goto L_0x0038
        L_0x001d:
            java.lang.String r0 = r4.getItemStatus()
            java.lang.String r2 = "6"
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r1)
            if (r0 != 0) goto L_0x0038
            java.lang.String r4 = r4.getItemStatus()
            java.lang.String r0 = "34"
            boolean r4 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r4, (boolean) r1)
            if (r4 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r4 = 0
            return r4
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.a(net.one97.paytm.common.entity.shopping.CJROrderedCart):boolean");
    }

    public final boolean n(Context context, CJROrderedCart cJROrderedCart) {
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        try {
            CJROrderSummaryProductDetail productDetail2 = cJROrderedCart.getProductDetail();
            String valueOf = String.valueOf(productDetail2 != null ? Long.valueOf(productDetail2.getCategoryId()) : null);
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (!net.one97.paytm.recharge.di.helper.c.ba() || (productDetail = cJROrderedCart.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || !attributes.isImpsEnabled() || !net.one97.paytm.recharge.common.utils.g.b(context, valueOf)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public final String m(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        String string = context.getString(R.string.wait_for_paytype, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String d(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        String string = context.getString(R.string.imps_cancel_recharge, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        if (kotlin.m.p.a("storefront_view", r0, true) == true) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean q() {
        /*
            r4 = this;
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.f64289a
            if (r0 != 0) goto L_0x0007
            kotlin.g.b.k.a()
        L_0x0007:
            boolean r0 = r0.s
            r1 = 0
            if (r0 == 0) goto L_0x0060
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.f64289a     // Catch:{ Exception -> 0x0040 }
            if (r0 != 0) goto L_0x0013
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0040 }
        L_0x0013:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()     // Catch:{ Exception -> 0x0040 }
            r2 = 0
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = r0.getMetaDataResponse()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0020
        L_0x001f:
            r0 = r2
        L_0x0020:
            boolean r3 = r0 instanceof java.util.Map     // Catch:{ Exception -> 0x0040 }
            if (r3 != 0) goto L_0x0025
            r0 = r2
        L_0x0025:
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x0040 }
            java.lang.String r2 = "storefront_view"
            if (r0 == 0) goto L_0x0036
            java.lang.String r3 = "post_order_view_type"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0040 }
            if (r0 != 0) goto L_0x0038
        L_0x0036:
            java.lang.String r0 = ""
        L_0x0038:
            r3 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r3)     // Catch:{ Exception -> 0x0040 }
            if (r0 != r3) goto L_0x004f
            goto L_0x0050
        L_0x0040:
            r0 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.String r3 = "Unable to show store-front screen"
            r2.debugLog(r3)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.debugLogExceptions(r0)
        L_0x004f:
            r3 = 0
        L_0x0050:
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r0 = net.one97.paytm.recharge.di.helper.c.at()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r3
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.q():boolean");
    }

    public final String c(CJROrderedCart cJROrderedCart) {
        String str;
        String thumbnail;
        k.c(cJROrderedCart, "orderedItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        if (productDetail == null || (str = productDetail.getImageUrl()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        CJROrderSummaryProductDetail productDetail2 = cJROrderedCart.getProductDetail();
        if (productDetail2 == null || (thumbnail = productDetail2.getThumbnail()) == null) {
            return "";
        }
        return thumbnail;
    }

    public final SpannableString b(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        String str;
        k.c(context, "context");
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        if (cJROSActionResponseV2 == null || (str = cJROSActionResponseV2.getMessage()) == null) {
            str = "";
        }
        return c.a.a(str, "");
    }

    public final SpannableString a(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        String str;
        CJROSActionResponseV2 itemLevelActions;
        k.c(context, "context");
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        if (cJROSActionResponseV2 == null || (itemLevelActions = cJROSActionResponseV2.getItemLevelActions()) == null || (str = itemLevelActions.getCategoryMassage()) == null) {
            str = "";
        }
        return c.a.a(str, "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        if (r6 != null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r4, java.lang.String r5, android.content.Context r6) {
        /*
            r3 = this;
            java.lang.String r0 = "responsePaymentMethod"
            kotlin.g.b.k.c(r5, r0)
            java.util.HashMap r6 = net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r6)
            r0 = 1
            if (r6 == 0) goto L_0x0030
            java.lang.String r1 = r5.toLowerCase()
            java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            boolean r1 = r6.containsKey(r1)
            if (r1 != r0) goto L_0x0030
            java.lang.String r1 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r6 = r6.get(r1)
            androidx.core.g.d r6 = (androidx.core.g.d) r6
            if (r6 == 0) goto L_0x0030
            S r6 = r6.f2965b
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x0031
        L_0x0030:
            r6 = r5
        L_0x0031:
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x003f
            int r1 = r1.length()
            if (r1 != 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r1 = 0
            goto L_0x0040
        L_0x003f:
            r1 = 1
        L_0x0040:
            if (r1 != 0) goto L_0x006b
            java.lang.String r1 = "WALLET"
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r0)
            if (r1 == 0) goto L_0x004b
            goto L_0x006b
        L_0x004b:
            java.lang.String r1 = "paytm_digital_credit"
            boolean r5 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r0)
            if (r5 == 0) goto L_0x0054
            return r6
        L_0x0054:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = " "
            r5.append(r4)
            r5.append(r6)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "StringBuilder(responsePa…paymentMethod).toString()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            return r4
        L_0x006b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.a(java.lang.String, java.lang.String, android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getPaymentSummary();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String n() {
        /*
            r1 = this;
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r1.f64290b
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getPaymentSummary()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.n():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getPaymentText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m() {
        /*
            r1 = this;
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r1.f64290b
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getPaymentText()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.m():java.lang.String");
    }

    public final boolean b(CJROrderedCart cJROrderedCart) {
        int i2;
        String str;
        k.c(cJROrderedCart, "rechargeItem");
        try {
            CJRFullFillmentObject fullFillmentOject = cJROrderedCart.getFullFillmentOject();
            if (fullFillmentOject == null || (str = fullFillmentOject.getFulfillmentResponse()) == null) {
                str = "";
            }
            String optString = new JSONObject(str).optString("in_code", "0");
            k.a((Object) optString, "fulfillmentJson.optString(\"in_code\", \"0\")");
            i2 = Integer.parseInt(optString);
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 == 10 || i2 == 17 || i2 == 2000 || i2 == 3000) {
            return true;
        }
        return false;
    }

    public final boolean d(CJROrderedCart cJROrderedCart) {
        int i2;
        String str;
        k.c(cJROrderedCart, "rechargeItem");
        if (k.a((Object) "34", (Object) cJROrderedCart.getItemStatus())) {
            return true;
        }
        try {
            CJRFullFillmentObject fullFillmentOject = cJROrderedCart.getFullFillmentOject();
            if (fullFillmentOject == null || (str = fullFillmentOject.getFulfillmentResponse()) == null) {
                str = "";
            }
            String optString = new JSONObject(str).optString("in_code", "0");
            k.a((Object) optString, "fulfillmentJson.optString(\"in_code\", \"0\")");
            i2 = Integer.parseInt(optString);
        } catch (Exception unused) {
            i2 = 0;
        }
        return i2 == 3001;
    }

    public final String C(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.brand_paytype_cancelled, new Object[]{this.f64291c, this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String E(Context context) {
        String str;
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderedCart cJROrderedCart;
        CJROrderSummaryProductDetail productDetail;
        k.c(context, "context");
        int i2 = R.string.vertical_declined_by_brand;
        Object[] objArr = new Object[2];
        objArr[0] = this.f64295g;
        CharSequence charSequence = this.f64291c;
        if (!(charSequence == null || charSequence.length() == 0)) {
            str = this.f64291c;
        } else {
            CJROrderSummary cJROrderSummary = this.f64290b;
            str = (cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null || (cJROrderedCart = orderedCartList.get(0)) == null || (productDetail = cJROrderedCart.getProductDetail()) == null) ? null : productDetail.getBrandName();
        }
        objArr[1] = str;
        String string = context.getString(i2, objArr);
        k.a((Object) string, "context.getString(R.stri…productDetail?.brandName)");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(net.one97.paytm.recharge.model.CJROSActionResponseV2 r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0008
            java.lang.String r1 = r1.getMessage()
            if (r1 != 0) goto L_0x000a
        L_0x0008:
            java.lang.String r1 = ""
        L_0x000a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.b(net.one97.paytm.recharge.model.CJROSActionResponseV2):java.lang.String");
    }

    public final boolean a(IJRPaytmDataModel iJRPaytmDataModel, CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        return (iJRPaytmDataModel instanceof CJROrderSummary) && ((CJROrderSummary) iJRPaytmDataModel).getRefund() != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r2 = (r2 = r2.getRefund()).getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String F(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r2, r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r1.f64290b
            if (r2 == 0) goto L_0x0015
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r2 = r2.getRefund()
            if (r2 == 0) goto L_0x0015
            java.lang.String r2 = r2.getMessage()
            if (r2 != 0) goto L_0x0017
        L_0x0015:
            java.lang.String r2 = ""
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.F(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getPaymentSummary();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String p() {
        /*
            r1 = this;
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r1.f64290b
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getPaymentSummary()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.p():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getPaymentText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String o() {
        /*
            r1 = this;
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r1.f64290b
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getPaymentText()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.o():java.lang.String");
    }

    public final String m(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.brand_vertical_is_taking_longer_than_expected, new Object[]{this.f64291c, this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(net.one97.paytm.recharge.model.CJROSActionResponseV2 r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0008
            java.lang.String r1 = r1.getMessage()
            if (r1 != 0) goto L_0x000a
        L_0x0008:
            java.lang.String r1 = ""
        L_0x000a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.a(net.one97.paytm.recharge.model.CJROSActionResponseV2):java.lang.String");
    }

    public final String l(Context context) {
        k.c(context, "context");
        String str = this.f64295g;
        String string = context.getString(R.string.recharge_order_summary_pending_backup_message, new Object[]{str, str, this.f64291c});
        k.a((Object) string, "context.getString(R.stri…e, payType, operatorName)");
        return string;
    }

    public final String g(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.cancel_paytype, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final SpannableString d(Context context) {
        k.c(context, "context");
        String str = this.f64295g;
        return new SpannableString(context.getString(R.string.we_will_notify_once_the_recharge_is_confirmed_you_can_also_check_recharge_status_in_my_orders, new Object[]{str, str}));
    }

    public final List<String> e(Context context) {
        k.c(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.recharge_summary_moeny_deducted_messages);
        k.a((Object) stringArray, "context.resources\n      …_moeny_deducted_messages)");
        return f.b(stringArray);
    }

    public final List<String> i(Context context) {
        k.c(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.recharge_summary_cancel_messages);
        k.a((Object) stringArray, "context.resources.getStr…_summary_cancel_messages)");
        return f.b(stringArray);
    }

    public final String b(Context context, CJROrderedCart cJROrderedCart) {
        String str;
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        if (attributes == null || (str = attributes.getPayTypeDisplayLabel()) == null) {
            str = "";
        }
        String a2 = c.a.a(str);
        return a2 == null ? "" : a2;
    }

    public final String a(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        String b2 = b(context, cJROrderedCart);
        if (TextUtils.isEmpty(b2)) {
            String string = context.getString(R.string.please_note);
            k.a((Object) string, "context.getString(R.string.please_note)");
            return string;
        }
        String string2 = context.getString(R.string.v8_os_cancel_bottom_sheet_title, new Object[]{b2});
        k.a((Object) string2, "context.getString(R.stri…tom_sheet_title, payType)");
        return string2;
    }

    public final List<String> f(Context context) {
        k.c(context, "context");
        String[] stringArray = context.getResources().getStringArray(R.array.recharge_summary_imps_cancel_messages);
        k.a((Object) stringArray, "context.resources.getStr…ary_imps_cancel_messages)");
        return f.b(stringArray);
    }

    public final String P(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_title_text_trimmed, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String O(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_status, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String L(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_payment_processing_title);
        k.a((Object) string, "context.getString(R.stri…payment_processing_title)");
        return string;
    }

    private final String U(Context context) {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64289a;
        List<CJROrderSummaryPayment> v = aVar != null ? aVar.v() : null;
        if (v == null || !(!v.isEmpty())) {
            String string = context.getString(R.string.bank);
            k.a((Object) string, "context.getString(R.string.bank)");
            return string;
        }
        Collection arrayList = new ArrayList();
        Iterator it2 = v.iterator();
        while (true) {
            boolean z = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            CJROrderSummaryPayment cJROrderSummaryPayment = (CJROrderSummaryPayment) next;
            if (!p.a("ppi", cJROrderSummaryPayment.getPaymentMethod(), true) && !p.a("paytm cash", cJROrderSummaryPayment.getPaymentMethod(), true) && !p.a("balance", cJROrderSummaryPayment.getPaymentMethod(), true) && !p.a("wallet", cJROrderSummaryPayment.getPaymentMethod(), true)) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (!list.isEmpty()) {
            String paymentBank = ((CJROrderSummaryPayment) list.get(0)).getPaymentBank();
            String paymentMethod = ((CJROrderSummaryPayment) list.get(0)).getPaymentMethod();
            k.a((Object) paymentMethod, "hasNoWalletPaymentMode[0].paymentMethod");
            return a(paymentBank, paymentMethod, context);
        }
        String paymentBank2 = v.get(0).getPaymentBank();
        String paymentMethod2 = v.get(0).getPaymentMethod();
        k.a((Object) paymentMethod2, "actualPayments[0].paymentMethod");
        return a(paymentBank2, paymentMethod2, context);
    }

    public final String K(Context context) {
        String str;
        CJRCart cart;
        k.c(context, "context");
        String U = U(context);
        int i2 = R.string.v8_os_pre_processing_payment_processing_description_v3;
        Object[] objArr = new Object[2];
        CJRRechargeCart cJRRechargeCart = this.f64297i;
        if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (str = cart.getFinalPrice()) == null) {
            str = "";
        }
        objArr[0] = ba.a(str, true);
        objArr[1] = U;
        String string = context.getString(i2, objArr);
        k.a((Object) string, "context.getString(R.stri…: \"\", true), paymentMode)");
        return string;
    }

    public final String N(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_payment_received_title);
        k.a((Object) string, "context.getString(R.stri…g_payment_received_title)");
        return string;
    }

    public final String M(Context context) {
        String str;
        CJRCart cart;
        k.c(context, "context");
        String U = U(context);
        int i2 = R.string.v8_os_pre_processing_payment_received_description_v3;
        Object[] objArr = new Object[2];
        CJRRechargeCart cJRRechargeCart = this.f64297i;
        if (cJRRechargeCart == null || (cart = cJRRechargeCart.getCart()) == null || (str = cart.getFinalPrice()) == null) {
            str = "";
        }
        objArr[0] = ba.a(str, true);
        objArr[1] = U;
        String string = context.getString(i2, objArr);
        k.a((Object) string, "context.getString(R.stri…: \"\", true), paymentMode)");
        return string;
    }

    public final String H(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_operator_processing_title, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String G(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_operator_processing_description, new Object[]{this.f64291c, this.f64294f});
        k.a((Object) string, "context.getString(R.stri…atorName, rechargeNumber)");
        return string;
    }

    public final String J(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_operator_received_title, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String I(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_pre_processing_operator_received_description, new Object[]{this.f64291c, this.f64294f});
        k.a((Object) string, "context.getString(R.stri…torName,  rechargeNumber)");
        return string;
    }

    public final String w(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_failed_1, new Object[]{this.f64292d});
        k.a((Object) string, "context.getString(R.stri…e_failed_1, payTypeLabel)");
        if (string != null) {
            String upperCase = string.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String x(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_pending_1, new Object[]{this.f64292d});
        k.a((Object) string, "context.getString(R.stri…_pending_1, payTypeLabel)");
        if (string != null) {
            String upperCase = string.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String q(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_failed_1, new Object[]{this.f64292d});
        k.a((Object) string, "context.getString(R.stri…e_failed_1, payTypeLabel)");
        if (string != null) {
            String upperCase = string.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String r(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_pending_1, new Object[]{this.f64292d});
        k.a((Object) string, "context.getString(R.stri…_pending_1, payTypeLabel)");
        if (string != null) {
            String upperCase = string.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String p(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_Canceled_1, new Object[]{this.f64292d});
        k.a((Object) string, "context.getString(R.stri…Canceled_1, payTypeLabel)");
        if (string != null) {
            String upperCase = string.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final SpannableString z(Context context) {
        k.c(context, "context");
        return new SpannableString(context.getString(R.string.v8_os_order_journey_payment_received_title));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String v(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r9, r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.f64290b
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0056
            java.util.ArrayList r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x0056
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0052
            java.lang.Object r5 = r0.next()
            r6 = r5
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r6 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r6
            java.lang.String r7 = "it"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r6.getPaymentMethod()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x004b
            java.lang.String r6 = r6.getPaymentBank()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x004b
            r6 = 1
            goto L_0x004c
        L_0x004b:
            r6 = 0
        L_0x004c:
            if (r6 == 0) goto L_0x001f
            r4.add(r5)
            goto L_0x001f
        L_0x0052:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            if (r0 == 0) goto L_0x00d7
            int r4 = r0.size()
            if (r4 != r3) goto L_0x00d7
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r4 = "paymentInfo[0]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r0
            java.lang.String r0 = r0.getPaymentBank()
            if (r0 == 0) goto L_0x0085
            if (r0 == 0) goto L_0x007d
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r1 = r0.toString()
            goto L_0x0085
        L_0x007d:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r9.<init>(r0)
            throw r9
        L_0x0085:
            int r0 = net.one97.paytm.recharge.R.string.v8_os_bank
            java.lang.String r0 = r9.getString(r0)
            java.lang.String r4 = "context.getString(R.string.v8_os_bank)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00d7
            if (r1 != 0) goto L_0x009e
            kotlin.g.b.k.a()
        L_0x009e:
            boolean r4 = kotlin.m.p.c(r1, r0, r3)
            if (r4 != 0) goto L_0x00c7
            java.lang.String r4 = "WALLET"
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r3)
            if (r4 == 0) goto L_0x00b3
            int r0 = net.one97.paytm.recharge.R.string.paytm_wallet
            java.lang.String r1 = r9.getString(r0)
            goto L_0x00c7
        L_0x00b3:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r1 = 32
            r4.append(r1)
            r4.append(r0)
            java.lang.String r1 = r4.toString()
        L_0x00c7:
            int r0 = net.one97.paytm.recharge.R.string.v8_os_order_journey_payment_declined_by_title
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r1
            java.lang.String r9 = r9.getString(r0, r3)
            java.lang.String r0 = "context.getString(R.stri…lined_by_title, bankName)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            return r9
        L_0x00d7:
            int r0 = net.one97.paytm.recharge.R.string.v8_os_order_journey_payment_declined_only_title
            java.lang.String r9 = r9.getString(r0)
            java.lang.String r0 = "context.getString(R.stri…ment_declined_only_title)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.v(android.content.Context):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String y(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r9, r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.f64290b
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0056
            java.util.ArrayList r0 = r0.getPaymentInfo()
            if (r0 == 0) goto L_0x0056
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0052
            java.lang.Object r5 = r0.next()
            r6 = r5
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r6 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r6
            java.lang.String r7 = "it"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r7 = r6.getPaymentMethod()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x004b
            java.lang.String r6 = r6.getPaymentBank()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x004b
            r6 = 1
            goto L_0x004c
        L_0x004b:
            r6 = 0
        L_0x004c:
            if (r6 == 0) goto L_0x001f
            r4.add(r5)
            goto L_0x001f
        L_0x0052:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            if (r0 == 0) goto L_0x00c8
            int r4 = r0.size()
            if (r4 != r3) goto L_0x00c8
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r4 = "paymentInfo[0]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r0
            java.lang.String r0 = r0.getPaymentBank()
            if (r0 == 0) goto L_0x0085
            if (r0 == 0) goto L_0x007d
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r1 = r0.toString()
            goto L_0x0085
        L_0x007d:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.CharSequence"
            r9.<init>(r0)
            throw r9
        L_0x0085:
            int r0 = net.one97.paytm.recharge.R.string.v8_os_bank
            java.lang.String r0 = r9.getString(r0)
            java.lang.String r4 = "context.getString(R.string.v8_os_bank)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00c8
            if (r1 != 0) goto L_0x009e
            kotlin.g.b.k.a()
        L_0x009e:
            boolean r4 = kotlin.m.p.c(r1, r0, r3)
            if (r4 != 0) goto L_0x00b8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r1 = 32
            r4.append(r1)
            r4.append(r0)
            java.lang.String r1 = r4.toString()
        L_0x00b8:
            int r0 = net.one97.paytm.recharge.R.string.v8_os_order_journey_payment_confirmation_by_title
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r1
            java.lang.String r9 = r9.getString(r0, r3)
            java.lang.String r0 = "context.getString(R.stri…ation_by_title, bankName)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            return r9
        L_0x00c8:
            int r0 = net.one97.paytm.recharge.R.string.v8_os_order_journey_payment_confirmation_only_title
            java.lang.String r9 = r9.getString(r0)
            java.lang.String r0 = "context.getString(R.stri…_confirmation_only_title)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.y(android.content.Context):java.lang.String");
    }

    public final String j(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        String string = context.getString(R.string.v8_os_header_title_pending_1, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String A(Context context) {
        String paymentText;
        String paymentText2;
        String replace;
        k.c(context, "context");
        if (Build.VERSION.SDK_INT >= 19) {
            CJROrderSummary cJROrderSummary = this.f64290b;
            if (cJROrderSummary == null || (paymentText2 = cJROrderSummary.getPaymentText()) == null || (replace = new l("\\s*$").replace((CharSequence) paymentText2, "")) == null) {
                return "";
            }
            return replace;
        }
        CJROrderSummary cJROrderSummary2 = this.f64290b;
        if (cJROrderSummary2 == null || (paymentText = cJROrderSummary2.getPaymentText()) == null) {
            return "";
        }
        return paymentText;
    }

    public final String B(Context context) {
        List list;
        List<CJROrderSummaryPayment> v;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64289a;
        if (aVar == null || (v = aVar.v()) == null) {
            list = null;
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : v) {
                CJROrderSummaryPayment cJROrderSummaryPayment = (CJROrderSummaryPayment) next;
                if (cJROrderSummaryPayment.getKind() == 1 && !TextUtils.isEmpty(cJROrderSummaryPayment.getCreatedAt())) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        }
        if (list == null || !(!list.isEmpty())) {
            return "";
        }
        String a2 = ab.a(((CJROrderSummaryPayment) list.get(0)).getCreatedAt(), "hh:mm a, dd MMM yyyy");
        k.a((Object) a2, "CJRRechargeUtilityConsta…E_ORDER_DATE_TIME_FORMAT)");
        return p.a(p.a(a2, "PM", "pm", false), "AM", "am", false);
    }

    public final String t(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_failed_1, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String u(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_pending_1, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String s(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_header_title_Canceled_1, new Object[]{this.f64295g});
        k.a((Object) string, "context.getString(R.stri…payTypeLabelCatpitalized)");
        return string;
    }

    public final String a(Context context, boolean z) {
        k.c(context, "context");
        if (z) {
            String string = context.getString(R.string.v8_os_header_title_refund_initiate);
            k.a((Object) string, "context.getString(R.stri…er_title_refund_initiate)");
            return string;
        }
        String string2 = context.getString(R.string.v8_os_header_title_refund_processing);
        k.a((Object) string2, "context.getString(R.stri…_title_refund_processing)");
        return string2;
    }

    public final String a(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2) {
        CJROSActionResponseV2 itemLevelActions;
        List<CJROSActionItemV2> actions;
        Object obj;
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        String str = null;
        if (!(cJROSActionResponseV2 == null || (itemLevelActions = cJROSActionResponseV2.getItemLevelActions()) == null || (actions = itemLevelActions.getActions()) == null)) {
            Iterator it2 = actions.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (p.a(CJROSActionItemV2.Companion.getACTION_TYPE_IMPS_REFUND(), ((CJROSActionItemV2) obj).getmType(), true)) {
                    break;
                }
            }
            CJROSActionItemV2 cJROSActionItemV2 = (CJROSActionItemV2) obj;
            if (cJROSActionItemV2 != null) {
                str = cJROSActionItemV2.getMessage();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                k.a();
            }
            return str;
        }
        String string = context.getString(R.string.v8_os_header_summary_merchant_imps_enabled);
        k.a((Object) string, "context.getString(R.stri…ry_merchant_imps_enabled)");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r4.getItemLevelActions();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(android.content.Context r2, net.one97.paytm.common.entity.shopping.CJROrderedCart r3, net.one97.paytm.recharge.model.CJROSActionResponseV2 r4) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r2 = "rechargeItem"
            kotlin.g.b.k.c(r3, r2)
            if (r4 == 0) goto L_0x0017
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r2 = r4.getItemLevelActions()
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = r2.getMessage()
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            r4 = r2
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0027
            if (r2 != 0) goto L_0x0026
            kotlin.g.b.k.a()
        L_0x0026:
            return r2
        L_0x0027:
            java.lang.String r2 = r3.getStatusText()
            java.lang.String r3 = "rechargeItem.statusText"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.b(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart, net.one97.paytm.recharge.model.CJROSActionResponseV2):java.lang.String");
    }

    public final String i(Context context, CJROrderedCart cJROrderedCart) {
        String str;
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        try {
            CJRFullFillmentObject fullFillmentOject = cJROrderedCart.getFullFillmentOject();
            if (fullFillmentOject == null || (str = fullFillmentOject.getFulfillmentResponse()) == null) {
                str = "";
            }
            String a2 = ab.a(new JSONObject(str).optString("in_updation_time", "0"), "hh:mm a, dd MMM yyyy");
            k.a((Object) a2, "CJRRechargeUtilityConsta…E_ORDER_DATE_TIME_FORMAT)");
            return p.a(p.a(a2, "PM", "pm", false), "AM", "am", false);
        } catch (Exception unused) {
            return "";
        }
    }

    public final SpannableString a(Context context, CJRTransactionDetails cJRTransactionDetails) {
        String str;
        String str2;
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        try {
            str = ba.a(String.valueOf(cJRTransactionDetails.getAmount()), true);
            k.a((Object) str, "RechargeUtils.getFormatt….amount.toString(), true)");
        } catch (Exception unused) {
            str = String.valueOf(cJRTransactionDetails.getAmount());
        }
        String concat = FilterPriceSliderFragment.RUPEE_SYMBOL.concat(String.valueOf(str));
        int i2 = R.string.v8_os_header_title_refund_amount;
        Object[] objArr = new Object[2];
        objArr[0] = concat;
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        String payment_mode = cJRTransactionDetails.getPayment_mode();
        if (payment_mode == null) {
            payment_mode = "";
        }
        String payMethod = cJRTransactionDetails.getPayMethod();
        HashMap<String, d<String, String>> a2 = ba.a(context);
        if (!TextUtils.isEmpty(payMethod) && a2 != null) {
            k.a((Object) payMethod, "paymentMethod");
            if (payMethod != null) {
                String lowerCase = payMethod.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (a2.containsKey(lowerCase)) {
                    String lowerCase2 = payMethod.toLowerCase();
                    k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                    d dVar = a2.get(lowerCase2);
                    if (!(dVar == null || (str2 = (String) dVar.f2965b) == null)) {
                        payment_mode = str2;
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        if (!TextUtils.isEmpty(cJRTransactionDetails.getIssuingBankName()) && !TextUtils.isEmpty(cJRTransactionDetails.getMaskedBankAccountNumber())) {
            payment_mode = context.getString(R.string.v8_os_header_title_refund_account_bank, new Object[]{cJRTransactionDetails.getIssuingBankName(), cJRTransactionDetails.getMaskedBankAccountNumber()});
            k.a((Object) payment_mode, "context.getString(R.stri….maskedBankAccountNumber)");
        } else if (!TextUtils.isEmpty(cJRTransactionDetails.getIssuingBankName()) && !TextUtils.isEmpty(cJRTransactionDetails.getMaskedCardNumber())) {
            payment_mode = cJRTransactionDetails.getIssuingBankName() + ' ' + payment_mode + ' ' + cJRTransactionDetails.getMaskedCardNumber();
        } else if ((p.a("BALANCE", cJRTransactionDetails.getPayMethod(), true) || p.a("Paytm Cash", cJRTransactionDetails.getPayMethod(), true) || p.a("ppi", cJRTransactionDetails.getPayMethod(), true)) && !TextUtils.isEmpty(cJRTransactionDetails.getUserMobileNo())) {
            payment_mode = context.getString(R.string.v8_os_header_title_refund_account_mobile, new Object[]{payment_mode, cJRTransactionDetails.getUserMobileNo()});
            k.a((Object) payment_mode, "context.getString(R.stri…ctionDetail.userMobileNo)");
        } else if (!TextUtils.isEmpty(cJRTransactionDetails.getMaskedCardNumber())) {
            payment_mode = payment_mode + ' ' + cJRTransactionDetails.getMaskedCardNumber();
        } else if (!TextUtils.isEmpty(cJRTransactionDetails.getIssuingBankName())) {
            payment_mode = context.getString(R.string.v8_os_header_title_refund_account_bank_only_bank_name, new Object[]{cJRTransactionDetails.getIssuingBankName(), payment_mode});
            k.a((Object) payment_mode, "context.getString(R.stri…ingBankName, paymentMode)");
        }
        objArr[1] = payment_mode;
        SpannableString spannableString = new SpannableString(context.getString(i2, objArr));
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif-medium", 0)), 0, concat.length(), 34);
        return spannableString;
    }

    public final String b(Context context, CJRTransactionDetails cJRTransactionDetails) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        String referenceNumber = cJRTransactionDetails.getReferenceNumber();
        if (referenceNumber == null) {
            referenceNumber = "";
        }
        if (TextUtils.isEmpty(referenceNumber)) {
            return "";
        }
        String string = context.getString(R.string.colon_place_holder, new Object[]{context.getString(R.string.os_refund_ref_number), referenceNumber});
        k.a((Object) string, "context.getString(R.stri…_refund_ref_number), tno)");
        return string;
    }

    public final String a(Context context, CJRTransactionDetails cJRTransactionDetails, CJRRefund cJRRefund) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        k.c(cJRRefund, "refundDetail");
        String userCreditInitiateTimestamp = cJRRefund.getUserCreditInitiateTimestamp();
        if (userCreditInitiateTimestamp == null) {
            userCreditInitiateTimestamp = "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm a, dd MMM yyyy");
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            String format = simpleDateFormat2.format(simpleDateFormat.parse(userCreditInitiateTimestamp));
            k.a((Object) format, "displayFormator.format(a…se(refundInititatedDate))");
            return format;
        } catch (Exception unused) {
            return userCreditInitiateTimestamp;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r2 = r3.getStatus_text();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(android.content.Context r2, net.one97.paytm.common.entity.shopping.CJRRefund r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r2, r0)
            if (r3 == 0) goto L_0x000d
            java.lang.String r2 = r3.getStatus_text()
            if (r2 != 0) goto L_0x000f
        L_0x000d:
            java.lang.String r2 = ""
        L_0x000f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.a(android.content.Context, net.one97.paytm.common.entity.shopping.CJRRefund):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c(android.content.Context r5, net.one97.paytm.common.entity.shopping.CJROrderedCart r6) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            java.lang.String r5 = "rechargeItem"
            kotlin.g.b.k.c(r6, r5)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r6.getProductDetail()
            r0 = 0
            if (r5 == 0) goto L_0x0016
            net.one97.paytm.common.entity.recharge.CJRAttributes r5 = r5.getAttributes()
            goto L_0x0017
        L_0x0016:
            r5 = r0
        L_0x0017:
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r1 = r6.getFullFillmentOject()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = r1.getFulfillmentResponse()
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x004f
            org.json.JSONObject r1 = new org.json.JSONObject
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r2 = r6.getFullFillmentOject()
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = r2.getFulfillmentResponse()
            goto L_0x0039
        L_0x0038:
            r2 = r0
        L_0x0039:
            r1.<init>(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x004f
            java.lang.String r2 = "CHECKBOX_LABEL"
            boolean r3 = r1.has(r2)
            if (r3 == 0) goto L_0x004f
            java.lang.String r1 = r1.getString(r2)
            goto L_0x0050
        L_0x004f:
            r1 = r0
        L_0x0050:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0061
            if (r5 == 0) goto L_0x0060
            java.lang.String r1 = r5.getmFeeType()
            goto L_0x0061
        L_0x0060:
            r1 = r0
        L_0x0061:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0072
            if (r5 == 0) goto L_0x0071
            java.lang.String r1 = r5.getmFeeTypeKey()
            goto L_0x0072
        L_0x0071:
            r1 = r0
        L_0x0072:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0083
            if (r5 == 0) goto L_0x0082
            java.lang.String r1 = r5.getmUtilityType()
            goto L_0x0083
        L_0x0082:
            r1 = r0
        L_0x0083:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0095
            if (r5 == 0) goto L_0x0094
            java.lang.String r5 = r5.getmChallanType()
            r1 = r5
            goto L_0x0095
        L_0x0094:
            r1 = r0
        L_0x0095:
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00a9
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r6.getProductDetail()
            if (r5 == 0) goto L_0x00a8
            java.lang.String r0 = r5.getName()
        L_0x00a8:
            r1 = r0
        L_0x00a9:
            if (r1 != 0) goto L_0x00ad
            java.lang.String r1 = ""
        L_0x00ad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.c(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (r3 == null) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f(android.content.Context r3, net.one97.paytm.common.entity.shopping.CJROrderedCart r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r3 = "rechargeItem"
            kotlin.g.b.k.c(r4, r3)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r4.getProductDetail()
            if (r3 == 0) goto L_0x0015
            net.one97.paytm.common.entity.recharge.CJRAttributes r3 = r3.getAttributes()
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x001b
            return r4
        L_0x001b:
            java.lang.String r0 = r3.getRechargeNumberDisplayLabel()
            if (r0 != 0) goto L_0x0022
            r0 = r4
        L_0x0022:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0069
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.recharge.ordersummary.h.c$a r1 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r1 = r3.getOperatorDisplayLabel()
            java.lang.String r1 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x003c
            r1 = r4
        L_0x003c:
            r0.append(r1)
            r1 = 32
            r0.append(r1)
            java.lang.String r3 = r3.getServiceDisplayLabel()
            if (r3 == 0) goto L_0x0060
            if (r3 == 0) goto L_0x0058
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            if (r3 != 0) goto L_0x0061
            goto L_0x0060
        L_0x0058:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)
            throw r3
        L_0x0060:
            r3 = r4
        L_0x0061:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        L_0x0069:
            net.one97.paytm.recharge.ordersummary.h.c$a r0 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r3 = r3.getOperatorDisplayLabel()
            java.lang.String r3 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r3)
            if (r3 != 0) goto L_0x0076
            r3 = r4
        L_0x0076:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.f(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }

    public final String h(Context context, CJROrderedCart cJROrderedCart) {
        String str;
        CJRAttributes attributes;
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        if (productDetail == null || (attributes = productDetail.getAttributes()) == null || (str = attributes.getRechargeNumberDisplayLabel()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            String rechargeNumber = cJROrderedCart.getRechargeNumber();
            k.a((Object) rechargeNumber, "rechargeItem.rechargeNumber");
            return rechargeNumber;
        }
        return str + ' ' + cJROrderedCart.getRechargeNumber();
    }

    public final String g(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        String string = context.getString(R.string.price_container_re_v8, new Object[]{ba.a(cJROrderedCart.getAggregateItemPrice(), true)});
        k.a((Object) string, "context.getString(R.stri…ggregateItemPrice, true))");
        return string;
    }

    public final String h(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64289a;
        if (aVar == null) {
            k.a();
        }
        if (aVar.k.size() == 1) {
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64289a;
            if (aVar2 == null) {
                k.a();
            }
            CJROrderedCart u = aVar2.u();
            if (u == null) {
                k.a();
            }
            return g(context, u);
        }
        double d2 = 0.0d;
        net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f64289a;
        if (aVar3 == null) {
            k.a();
        }
        for (CJROrderedCart aggregateItemPrice : aVar3.k) {
            String aggregateItemPrice2 = aggregateItemPrice.getAggregateItemPrice();
            k.a((Object) aggregateItemPrice2, "it.aggregateItemPrice");
            d2 += Double.parseDouble(aggregateItemPrice2);
        }
        String string = context.getString(R.string.price_container_re_v8, new Object[]{ba.a(String.valueOf(d2), true)});
        k.a((Object) string, "context.getString(R.stri…Amount.toString(), true))");
        return string;
    }

    public final SpannableString S(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64289a;
        if (aVar == null) {
            k.a();
        }
        if (aVar.k.size() > 1) {
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64289a;
            if (aVar2 == null) {
                k.a();
            }
            if (!aVar2.f64002f) {
                return new SpannableString(context.getString(R.string.v8_os_order_journey_payment_received_title));
            }
        }
        return new SpannableString(context.getString(R.string.v8_os_pre_processing_operator_received_title, new Object[]{this.f64295g}));
    }

    public final SpannableString l(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64289a;
        if (aVar == null) {
            k.a();
        }
        if (aVar.k.size() == 1) {
            return new SpannableString(g(context, cJROrderedCart));
        }
        return new SpannableString(h(context));
    }

    public final SpannableString a(Context context, boolean z, CJROrderedCart cJROrderedCart, boolean z2) {
        String str;
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummary cJROrderSummary = this.f64290b;
        if (cJROrderSummary == null) {
            k.a();
        }
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        if (orderedCartList == null) {
            k.a();
        }
        CJROrderedCart cJROrderedCart2 = orderedCartList.get(0);
        if (cJROrderedCart2 == null) {
            k.a();
        }
        k.a((Object) cJROrderedCart2, "orderSummary!!.orderedCartList!![0]!!");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart2.getProductDetail();
        int i2 = R.string.recharge_order_status_banner;
        Object[] objArr = new Object[2];
        if (productDetail == null || (str = productDetail.getBrandName()) == null) {
            str = "";
        }
        objArr[0] = str;
        String str2 = this.f64295g;
        if (str2 == null) {
            str2 = "";
        }
        objArr[1] = str2;
        return new SpannableString(context.getString(i2, objArr));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(android.content.Context r6, net.one97.paytm.common.entity.shopping.CJROrderedCart r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r6, r0)
            java.lang.String r0 = "rechargeItem"
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r5.f64289a
            r1 = 1
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.t()
            if (r0 != r1) goto L_0x001c
            int r7 = net.one97.paytm.recharge.R.color.recharge_order_pending
            int r6 = androidx.core.content.b.c(r6, r7)
            return r6
        L_0x001c:
            net.one97.paytm.recharge.ordersummary.b.a r0 = r5.f64289a
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.f64002f
            if (r0 == r1) goto L_0x003c
        L_0x0024:
            net.one97.paytm.recharge.ordersummary.b.a r0 = r5.f64289a
            if (r0 == 0) goto L_0x002e
            boolean r0 = r0.s()
            if (r0 == r1) goto L_0x003c
        L_0x002e:
            java.lang.String r0 = "7"
            if (r8 == 0) goto L_0x0043
            java.lang.String r7 = r7.getItemStatus()
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r0)
            if (r7 == 0) goto L_0x0043
        L_0x003c:
            int r7 = net.one97.paytm.recharge.R.color.recharge_order_success
            int r6 = androidx.core.content.b.c(r6, r7)
            return r6
        L_0x0043:
            net.one97.paytm.recharge.ordersummary.b.a r7 = r5.f64289a
            r8 = 0
            if (r7 == 0) goto L_0x007a
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r7 = r7.k
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x007a
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0054:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x0078
            java.lang.Object r2 = r7.next()
            r3 = r2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            java.lang.String r4 = r3.getItemStatus()
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r0)
            r4 = r4 ^ r1
            if (r4 == 0) goto L_0x0074
            boolean r3 = r5.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)
            if (r3 != 0) goto L_0x0074
            r3 = 1
            goto L_0x0075
        L_0x0074:
            r3 = 0
        L_0x0075:
            if (r3 == 0) goto L_0x0054
            r8 = r2
        L_0x0078:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r8 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r8
        L_0x007a:
            if (r8 == 0) goto L_0x0083
            int r7 = net.one97.paytm.recharge.R.color.recharge_order_failed
            int r6 = androidx.core.content.b.c(r6, r7)
            return r6
        L_0x0083:
            int r7 = net.one97.paytm.recharge.R.color.recharge_order_cancelled
            int r6 = androidx.core.content.b.c(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.a(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r2 = (r2 = r2.getProductDetail()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String Q(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r2 = r1.f64294f
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0012
            java.lang.String r2 = ""
            return r2
        L_0x0012:
            net.one97.paytm.recharge.ordersummary.b.a r2 = r1.f64289a
            if (r2 != 0) goto L_0x0019
            kotlin.g.b.k.a()
        L_0x0019:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = r2.u()
            if (r2 == 0) goto L_0x0030
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()
            if (r2 == 0) goto L_0x0030
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()
            if (r2 == 0) goto L_0x0030
            java.lang.String r2 = r2.getRechargeNumberDisplayLabel()
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0042
            java.lang.String r2 = r1.f64294f
            if (r2 != 0) goto L_0x0041
            kotlin.g.b.k.a()
        L_0x0041:
            return r2
        L_0x0042:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r2 = 32
            r0.append(r2)
            java.lang.String r2 = r1.f64294f
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.Q(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r3 == null) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String k(android.content.Context r3, net.one97.paytm.common.entity.shopping.CJROrderedCart r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r3 = "rechargeItem"
            kotlin.g.b.k.c(r4, r3)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r4.getProductDetail()
            if (r3 == 0) goto L_0x0015
            net.one97.paytm.common.entity.recharge.CJRAttributes r3 = r3.getAttributes()
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x001b
            return r4
        L_0x001b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            net.one97.paytm.recharge.ordersummary.h.c$a r1 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            java.lang.String r1 = r3.getOperatorDisplayLabel()
            java.lang.String r1 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r1)
            if (r1 != 0) goto L_0x002d
            r1 = r4
        L_0x002d:
            r0.append(r1)
            r1 = 32
            r0.append(r1)
            java.lang.String r3 = r3.getPayTypeDisplayLabel()
            if (r3 == 0) goto L_0x0051
            if (r3 == 0) goto L_0x0049
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r1 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            if (r3 != 0) goto L_0x0052
            goto L_0x0051
        L_0x0049:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)
            throw r3
        L_0x0051:
            r3 = r4
        L_0x0052:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.e.k(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }

    public final String a(Context context, CJRContributionData cJRContributionData, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJRContributionData, "contributionData");
        k.c(cJROrderedCart, "rechargeItem");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        String h2 = net.one97.paytm.recharge.widgets.c.d.h(cJRContributionData.getTotalContributedAmount(productDetail != null ? String.valueOf(productDetail.getId()) : null));
        if (TextUtils.isEmpty(h2)) {
            return null;
        }
        return context.getString(R.string.price_container_re_v8, new Object[]{h2});
    }

    public final o<String, String> e(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return new o<>("", "");
    }
}
