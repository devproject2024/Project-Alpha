package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.d.f;
import net.one97.paytm.recharge.ordersummary.d.g;
import net.one97.paytm.recharge.ordersummary.d.s;
import net.one97.paytm.recharge.ordersummary.d.t;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.j;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJRProcessingOrderSummaryLayoutV8;
import org.json.JSONObject;

public class h implements c, j, m {

    /* renamed from: a  reason: collision with root package name */
    a f64304a;

    /* renamed from: b  reason: collision with root package name */
    final c f64305b;

    /* renamed from: c  reason: collision with root package name */
    private final m f64306c;

    public final String A(Context context) {
        k.c(context, "context");
        return this.f64305b.A(context);
    }

    public final String B(Context context) {
        k.c(context, "context");
        return this.f64305b.B(context);
    }

    public final String C(Context context) {
        k.c(context, "context");
        return this.f64305b.C(context);
    }

    public final String D(Context context) {
        k.c(context, "context");
        return this.f64305b.D(context);
    }

    public final String E(Context context) {
        k.c(context, "context");
        return this.f64305b.E(context);
    }

    public final String F(Context context) {
        k.c(context, "context");
        return this.f64305b.F(context);
    }

    public String G(Context context) {
        k.c(context, "context");
        return this.f64305b.G(context);
    }

    public final String H(Context context) {
        k.c(context, "context");
        return this.f64305b.H(context);
    }

    public String I(Context context) {
        k.c(context, "context");
        return this.f64305b.I(context);
    }

    public final String J(Context context) {
        k.c(context, "context");
        return this.f64305b.J(context);
    }

    public final String K(Context context) {
        k.c(context, "context");
        return this.f64305b.K(context);
    }

    public final String L(Context context) {
        k.c(context, "context");
        return this.f64305b.L(context);
    }

    public final String M(Context context) {
        k.c(context, "context");
        return this.f64305b.M(context);
    }

    public final String N(Context context) {
        k.c(context, "context");
        return this.f64305b.N(context);
    }

    public final String O(Context context) {
        k.c(context, "context");
        return this.f64305b.O(context);
    }

    public final String P(Context context) {
        k.c(context, "context");
        return this.f64305b.P(context);
    }

    public String Q(Context context) {
        k.c(context, "context");
        return this.f64305b.Q(context);
    }

    public SpannableString S(Context context) {
        k.c(context, "context");
        return this.f64305b.S(context);
    }

    public final int a(Context context, CJROrderedCart cJROrderedCart, boolean z) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.a(context, cJROrderedCart, z);
    }

    public final SpannableString a(Context context, CJRTransactionDetails cJRTransactionDetails) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        return this.f64305b.a(context, cJRTransactionDetails);
    }

    public final SpannableString a(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        k.c(context, "context");
        return this.f64305b.a(context, cJROSActionResponseV2);
    }

    public String a(Context context) {
        k.c(context, "context");
        return this.f64305b.a(context);
    }

    public final String a(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.a(context, cJROrderedCart, cJROSActionResponseV2);
    }

    public final String a(Context context, CJRRefund cJRRefund) {
        k.c(context, "context");
        return this.f64305b.a(context, cJRRefund);
    }

    public final String a(Context context, CJRTransactionDetails cJRTransactionDetails, CJRRefund cJRRefund) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        k.c(cJRRefund, "refundDetail");
        return this.f64305b.a(context, cJRTransactionDetails, cJRRefund);
    }

    public final String a(Context context, CJRContributionData cJRContributionData, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJRContributionData, "contributionData");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.a(context, cJRContributionData, cJROrderedCart);
    }

    public final String a(Context context, boolean z) {
        k.c(context, "context");
        return this.f64305b.a(context, z);
    }

    public final String a(String str, String str2) {
        return this.f64306c.a(str, str2);
    }

    public final String a(String str, String str2, Context context) {
        k.c(str2, "responsePaymentMethod");
        return this.f64305b.a(str, str2, context);
    }

    public final String a(CJROSActionResponseV2 cJROSActionResponseV2) {
        return this.f64305b.a(cJROSActionResponseV2);
    }

    public final void a(Context context, String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.f64306c.a(context, str);
    }

    public final void a(String str) {
        k.c(str, "categoryName");
        this.f64306c.a(str);
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderSummary");
        this.f64305b.a(cJROrderSummary);
    }

    public final boolean a() {
        return true;
    }

    public final boolean a(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "cjrOrderedCart");
        return this.f64305b.a(cJROrderedCart);
    }

    public String b(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.b(context, cJROrderedCart, cJROSActionResponseV2);
    }

    public final String b(Context context, CJRTransactionDetails cJRTransactionDetails) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        return this.f64305b.b(context, cJRTransactionDetails);
    }

    public final String b(String str, String str2) {
        return this.f64306c.b(str, str2);
    }

    public final String b(CJROSActionResponseV2 cJROSActionResponseV2) {
        return this.f64305b.b(cJROSActionResponseV2);
    }

    public final StringBuilder b(Context context) {
        k.c(context, "context");
        return this.f64305b.b(context);
    }

    public c.a.C1269a b() {
        return null;
    }

    public final void b(String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.f64306c.b(str);
    }

    public final void b(CJROrderSummary cJROrderSummary) {
        this.f64306c.b(cJROrderSummary);
    }

    public final void b(a aVar) {
        k.c(aVar, "viewModel");
        this.f64305b.b(aVar);
    }

    public final void b(boolean z) {
        this.f64306c.b(z);
    }

    public boolean b(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.b(cJROrderedCart);
    }

    public final String c(Context context) {
        k.c(context, "context");
        return this.f64305b.c(context);
    }

    public final String c(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.c(context, cJROrderedCart);
    }

    public String c(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        return this.f64305b.c(cJROrderedCart);
    }

    public final void c(String str, String str2) {
        this.f64306c.c(str, str2);
    }

    public boolean c() {
        return false;
    }

    public final SpannableString d(Context context) {
        k.c(context, "context");
        return this.f64305b.d(context);
    }

    public final boolean d(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.d(cJROrderedCart);
    }

    public o<String, String> e(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.e(context, cJROrderedCart);
    }

    public String f(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.f(context, cJROrderedCart);
    }

    public String g(Context context) {
        k.c(context, "context");
        return this.f64305b.g(context);
    }

    public String g(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.g(context, cJROrderedCart);
    }

    public final String h(Context context) {
        k.c(context, "context");
        return this.f64305b.h(context);
    }

    public String h(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.h(context, cJROrderedCart);
    }

    public String i(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.i(context, cJROrderedCart);
    }

    public final List<String> i(Context context) {
        k.c(context, "context");
        return this.f64305b.i(context);
    }

    public final String j(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f64305b.j(context, cJROrderedCart);
    }

    public ArrayList<o<String, String>> j(Context context) {
        k.c(context, "context");
        return this.f64305b.j(context);
    }

    public final String k(Context context) {
        k.c(context, "context");
        return this.f64305b.k(context);
    }

    public String k(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.k(context, cJROrderedCart);
    }

    public SpannableString l(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f64305b.l(context, cJROrderedCart);
    }

    public final String l(Context context) {
        k.c(context, "context");
        return this.f64305b.l(context);
    }

    public final String m() {
        return this.f64305b.m();
    }

    public final String m(Context context) {
        k.c(context, "context");
        return this.f64305b.m(context);
    }

    public final String n() {
        return this.f64305b.n();
    }

    public final String n(Context context) {
        k.c(context, "context");
        return this.f64305b.n(context);
    }

    public final boolean n(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f64305b.n(context, cJROrderedCart);
    }

    public final String o() {
        return this.f64305b.o();
    }

    public final String o(Context context) {
        k.c(context, "context");
        return this.f64305b.o(context);
    }

    public final String p() {
        return this.f64305b.p();
    }

    public final String p(Context context) {
        k.c(context, "context");
        return this.f64305b.p(context);
    }

    public final String q(Context context) {
        k.c(context, "context");
        return this.f64305b.q(context);
    }

    public final boolean q() {
        return this.f64305b.q();
    }

    public final String r() {
        return this.f64306c.r();
    }

    public String r(Context context) {
        k.c(context, "context");
        return this.f64305b.r(context);
    }

    public final String s(Context context) {
        k.c(context, "context");
        return this.f64305b.s(context);
    }

    public final String t(Context context) {
        k.c(context, "context");
        return this.f64305b.t(context);
    }

    public String u(Context context) {
        k.c(context, "context");
        return this.f64305b.u(context);
    }

    public final String v(Context context) {
        k.c(context, "context");
        return this.f64305b.v(context);
    }

    public final String w(Context context) {
        k.c(context, "context");
        return this.f64305b.w(context);
    }

    public final String x(Context context) {
        k.c(context, "context");
        return this.f64305b.x(context);
    }

    public final String y(Context context) {
        k.c(context, "context");
        return this.f64305b.y(context);
    }

    public SpannableString z(Context context) {
        k.c(context, "context");
        return this.f64305b.z(context);
    }

    public h(net.one97.paytm.recharge.ordersummary.f.c cVar, m mVar) {
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
        this.f64305b = cVar;
        this.f64306c = mVar;
    }

    public final void a(a aVar) {
        k.c(aVar, "viewModel");
        this.f64304a = aVar;
        this.f64305b.b(aVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = r4.f64304a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = (r0 = r4.f64304a).k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d() {
        /*
            r4 = this;
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.f64304a
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.s
            if (r0 != r2) goto L_0x0024
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.f64304a
            if (r0 == 0) goto L_0x001a
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r0.k
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x001a
            int r0 = r0.size()
            if (r0 == r2) goto L_0x0022
        L_0x001a:
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.f64304a
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.f64002f
            if (r0 != r2) goto L_0x0024
        L_0x0022:
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            net.one97.paytm.recharge.ordersummary.b.a r3 = r4.f64304a
            if (r3 != 0) goto L_0x002c
            kotlin.g.b.k.a()
        L_0x002c:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r3 = r3.k
            java.util.List r3 = (java.util.List) r3
            int r3 = r3.size()
            if (r3 == r2) goto L_0x0040
            net.one97.paytm.recharge.ordersummary.b.a r3 = r4.f64304a
            if (r3 == 0) goto L_0x003f
            boolean r3 = r3.f64002f
            if (r3 != r2) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            return r0
        L_0x0040:
            if (r0 != 0) goto L_0x004c
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r0 = net.one97.paytm.recharge.di.helper.c.bA()
            if (r0 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            return r1
        L_0x004c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.h.d():boolean");
    }

    public final String e() {
        String name = t.class.getName();
        k.a((Object) name, "FJRSuccessRechargeStorefrontV8::class.java.name");
        return name;
    }

    public String f() {
        String name = net.one97.paytm.recharge.ordersummary.d.k.class.getName();
        k.a((Object) name, "FJRMobileStoreFrontFragment::class.java.name");
        return name;
    }

    public final String g() {
        String name = s.class.getName();
        k.a((Object) name, "FJRSuccessRechargeOrderS…agmentV8::class.java.name");
        return name;
    }

    public String h() {
        String name = net.one97.paytm.recharge.ordersummary.d.j.class.getName();
        k.a((Object) name, "FJRMobileOrderDetailsFragment::class.java.name");
        return name;
    }

    public final String i() {
        String name = CJRProcessingOrderSummaryLayoutV8.class.getName();
        k.a((Object) name, "CJRProcessingOrderSummaryLayoutV8::class.java.name");
        return name;
    }

    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", f.class.getName());
        return bundle;
    }

    public Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", f.class.getName());
        return bundle;
    }

    public final Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", g.class.getName());
        return bundle;
    }

    public int a(boolean z) {
        return R.layout.content_view_banner_status_order;
    }

    public final boolean a(IJRPaytmDataModel iJRPaytmDataModel, CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        return (iJRPaytmDataModel instanceof CJROrderSummary) && cJROrderedCart.getRefund() != null;
    }

    public final String m(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        String string = context.getString(R.string.v8_os_cancel_bottom_sheet_btn_wait);
        k.a((Object) string, "context.getString(R.stri…el_bottom_sheet_btn_wait)");
        return string;
    }

    public final String d(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        String string = context.getString(R.string.v8_os_cancel_bottom_sheet_btn_cancel);
        k.a((Object) string, "context.getString(R.stri…_bottom_sheet_btn_cancel)");
        return string;
    }

    public List<String> f(Context context) {
        k.c(context, "context");
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        String b2 = b(context, u);
        if (TextUtils.isEmpty(b2)) {
            String[] stringArray = context.getResources().getStringArray(R.array.recharge_summary_imps_cancel_messages);
            k.a((Object) stringArray, "context.resources.getStr…ary_imps_cancel_messages)");
            return kotlin.a.f.b(stringArray);
        }
        List<String> asList = Arrays.asList(new String[]{context.getString(R.string.v8_os_cancel_bottom_sheet_message, new Object[]{b2})});
        k.a((Object) asList, "Arrays.asList(context.ge…_sheet_message, payType))");
        return asList;
    }

    public SpannableString b(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        String str;
        String str2;
        CJROSActionResponseV2 itemLevelActions;
        k.c(context, "context");
        String str3 = "";
        if (cJROSActionResponseV2 == null || (itemLevelActions = cJROSActionResponseV2.getItemLevelActions()) == null || (str = itemLevelActions.getMessage()) == null) {
            str = str3;
        }
        if (TextUtils.isEmpty(str)) {
            net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
            if (cVar != null) {
                e eVar = (e) cVar;
                a aVar = this.f64304a;
                if (aVar == null) {
                    k.a();
                }
                CJROrderedCart u = aVar.u();
                if (u == null) {
                    k.a();
                }
                CJROrderSummaryProductDetail productDetail = u.getProductDetail();
                String str4 = null;
                CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
                try {
                    CJRFullFillmentObject fullFillmentOject = u.getFullFillmentOject();
                    if (fullFillmentOject == null || (str2 = fullFillmentOject.getFulfillmentResponse()) == null) {
                        str2 = str3;
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    str3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a.a(jSONObject, "opt_ref_id");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a.a(jSONObject, "operatorRefNumber");
                    }
                } catch (Exception e2) {
                    q.d(e2.getMessage());
                }
                if (p.a(BaseViewModel.PaymentType.POSTPAID, attributes != null ? attributes.getPaytype() : null, true)) {
                    if (!TextUtils.isEmpty(str3)) {
                        int i2 = R.string.v8_os_ref_num_post_action_mobile_postpaid_prepaid_dth;
                        Object[] objArr = new Object[3];
                        String str5 = eVar.f64295g;
                        if (str5 != null) {
                            if (str5 != null) {
                                str4 = str5.toLowerCase();
                                k.a((Object) str4, "(this as java.lang.String).toLowerCase()");
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        objArr[0] = str4;
                        objArr[1] = eVar.f64291c;
                        objArr[2] = str3;
                        str = context.getString(i2, objArr);
                        k.a((Object) str, "context.getString(R.stri…Name, paymentReferenceNo)");
                    } else {
                        int i3 = R.string.v8_os_default_post_action_mobile_postpaid;
                        Object[] objArr2 = new Object[1];
                        String str6 = eVar.f64295g;
                        if (str6 != null) {
                            if (str6 != null) {
                                str4 = str6.toLowerCase();
                                k.a((Object) str4, "(this as java.lang.String).toLowerCase()");
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        }
                        objArr2[0] = str4;
                        str = context.getString(i3, objArr2);
                        k.a((Object) str, "context.getString(R.stri…pitalized?.toLowerCase())");
                    }
                } else if (!TextUtils.isEmpty(str3)) {
                    int i4 = R.string.v8_os_ref_num_post_action_mobile_postpaid_prepaid_dth;
                    Object[] objArr3 = new Object[3];
                    String str7 = eVar.f64295g;
                    if (str7 != null) {
                        if (str7 != null) {
                            str4 = str7.toLowerCase();
                            k.a((Object) str4, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    objArr3[0] = str4;
                    objArr3[1] = eVar.f64291c;
                    objArr3[2] = str3;
                    str = context.getString(i4, objArr3);
                    k.a((Object) str, "context.getString(R.stri…Name, paymentReferenceNo)");
                } else {
                    int i5 = R.string.v8_os_default_post_action_mobile_prepaid;
                    Object[] objArr4 = new Object[1];
                    String str8 = eVar.f64295g;
                    if (str8 != null) {
                        if (str8 != null) {
                            str4 = str8.toLowerCase();
                            k.a((Object) str4, "(this as java.lang.String).toLowerCase()");
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    objArr4[0] = str4;
                    str = context.getString(i5, objArr4);
                    k.a((Object) str, "context.getString(R.stri…pitalized?.toLowerCase())");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
            }
        }
        c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        return c.a.a(str, str3);
    }

    public SpannableString a(Context context, boolean z, CJROrderedCart cJROrderedCart, boolean z2) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            String g2 = g(context, u);
            StringBuilder sb = new StringBuilder();
            int i2 = R.string.recharge_order_status_success;
            Object[] objArr = new Object[1];
            String str = ((e) cVar).f64292d;
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            String string = context.getString(i2, objArr);
            k.a((Object) string, "context.getString(R.stri… repo.payTypeLabel ?: \"\")");
            if (string != null) {
                String upperCase = string.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                sb.append(upperCase);
                sb.append(" ");
                sb.append(g2);
                return new SpannableString(sb.toString());
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public String R(Context context) {
        String f2;
        String str;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            a aVar = this.f64304a;
            String str2 = null;
            CJROrderedCart u = aVar != null ? aVar.u() : null;
            if (!(u == null || (productDetail = u.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null)) {
                str2 = attributes.getRechargeNumberDisplayLabel();
            }
            if (TextUtils.isEmpty(str2)) {
                int i2 = R.string.v8_os_order_storefront_mobile_bill_payment_title;
                Object[] objArr = new Object[1];
                String str3 = eVar.f64291c;
                if (str3 == null || (str = p.f(str3)) == null) {
                    str = "";
                }
                objArr[0] = str;
                String string = context.getString(i2, objArr);
                k.a((Object) string, "context.getString(R.stri…Name?.capitalize() ?: \"\")");
                return string;
            }
            String str4 = eVar.f64291c;
            if (str4 == null || (f2 = p.f(str4)) == null) {
                return "";
            }
            return f2;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public String T(Context context) {
        k.c(context, "context");
        return R(context);
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

    public String b(Context context, CJROrderedCart cJROrderedCart) {
        String str;
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        String str2 = null;
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        CJROrderSummaryProductDetail productDetail2 = cJROrderedCart.getProductDetail();
        CJRAttributes attributes2 = productDetail2 != null ? productDetail2.getAttributes() : null;
        if (attributes != null) {
            str2 = attributes.getPaytype();
        }
        if (p.a(BaseViewModel.PaymentType.POSTPAID, str2, true)) {
            String string = context.getString(R.string.bill_payment);
            k.a((Object) string, "context.getString(R.string.bill_payment)");
            return string;
        }
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        if (attributes2 == null || (str = attributes2.getPayTypeDisplayLabel()) == null) {
            str = "";
        }
        String a2 = c.a.a(str);
        return a2 == null ? "" : a2;
    }

    public final List<String> e(Context context) {
        String str;
        k.c(context, "context");
        boolean z = false;
        try {
            a aVar = this.f64304a;
            if (aVar == null) {
                k.a();
            }
            CJROrderedCart u = aVar.u();
            Object metaDataResponse = u != null ? u.getMetaDataResponse() : null;
            if (!(metaDataResponse instanceof Map)) {
                metaDataResponse = null;
            }
            Map map = (Map) metaDataResponse;
            if (map == null || (str = (String) map.get("pay_mode")) == null) {
                str = "";
            }
            if (p.a(SDKConstants.TYPE_BANK_MANDATE, str, true)) {
                z = true;
            }
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLog("Unable to find e-mandate flag");
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
        if (!z) {
            String[] stringArray = context.getResources().getStringArray(R.array.v8_os_money_deducted_messages);
            k.a((Object) stringArray, "context.resources\n      …_money_deducted_messages)");
            return kotlin.a.f.b(stringArray);
        }
        String[] stringArray2 = context.getResources().getStringArray(R.array.v8_os_money_deducted_messages_emandate);
        k.a((Object) stringArray2, "context.resources\n      …ducted_messages_emandate)");
        return kotlin.a.f.b(stringArray2);
    }
}
