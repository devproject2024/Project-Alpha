package net.one97.paytm.recharge.legacy.ordersummary.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.legacy.ordersummary.a.b;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRFailedOrderSummary;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRMetroTicketCancelledOrderSummary;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRPendingOrderSummary;
import net.one97.paytm.recharge.legacy.ordersummary.widget.CJRProcessingOrderSummaryLayout;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.d.g;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.j;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.ordersummary.g.e;
import net.one97.paytm.recharge.ordersummary.h.c;

public final class a implements c, j, m {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.recharge.ordersummary.b.a f63061a;

    /* renamed from: b  reason: collision with root package name */
    private final c f63062b;

    /* renamed from: c  reason: collision with root package name */
    private final m f63063c;

    public final String A(Context context) {
        k.c(context, "context");
        return this.f63062b.A(context);
    }

    public final String B(Context context) {
        k.c(context, "context");
        return this.f63062b.B(context);
    }

    public final String C(Context context) {
        k.c(context, "context");
        return this.f63062b.C(context);
    }

    public final String D(Context context) {
        k.c(context, "context");
        return this.f63062b.D(context);
    }

    public final String E(Context context) {
        k.c(context, "context");
        return this.f63062b.E(context);
    }

    public final String F(Context context) {
        k.c(context, "context");
        return this.f63062b.F(context);
    }

    public final String G(Context context) {
        k.c(context, "context");
        return this.f63062b.G(context);
    }

    public final String H(Context context) {
        k.c(context, "context");
        return this.f63062b.H(context);
    }

    public final String I(Context context) {
        k.c(context, "context");
        return this.f63062b.I(context);
    }

    public final String J(Context context) {
        k.c(context, "context");
        return this.f63062b.J(context);
    }

    public final String K(Context context) {
        k.c(context, "context");
        return this.f63062b.K(context);
    }

    public final String L(Context context) {
        k.c(context, "context");
        return this.f63062b.L(context);
    }

    public final String M(Context context) {
        k.c(context, "context");
        return this.f63062b.M(context);
    }

    public final String N(Context context) {
        k.c(context, "context");
        return this.f63062b.N(context);
    }

    public final String O(Context context) {
        k.c(context, "context");
        return this.f63062b.O(context);
    }

    public final String P(Context context) {
        k.c(context, "context");
        return this.f63062b.P(context);
    }

    public final String Q(Context context) {
        k.c(context, "context");
        return this.f63062b.Q(context);
    }

    public final String R(Context context) {
        k.c(context, "context");
        return this.f63062b.R(context);
    }

    public final SpannableString S(Context context) {
        k.c(context, "context");
        return this.f63062b.S(context);
    }

    public final String T(Context context) {
        k.c(context, "context");
        return this.f63062b.T(context);
    }

    public final int a(Context context, CJROrderedCart cJROrderedCart, boolean z) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.a(context, cJROrderedCart, z);
    }

    public final SpannableString a(Context context, CJRTransactionDetails cJRTransactionDetails) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        return this.f63062b.a(context, cJRTransactionDetails);
    }

    public final SpannableString a(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        k.c(context, "context");
        return this.f63062b.a(context, cJROSActionResponseV2);
    }

    public final String a(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.a(context, cJROrderedCart);
    }

    public final String a(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.a(context, cJROrderedCart, cJROSActionResponseV2);
    }

    public final String a(Context context, CJRRefund cJRRefund) {
        k.c(context, "context");
        return this.f63062b.a(context, cJRRefund);
    }

    public final String a(Context context, CJRTransactionDetails cJRTransactionDetails, CJRRefund cJRRefund) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        k.c(cJRRefund, "refundDetail");
        return this.f63062b.a(context, cJRTransactionDetails, cJRRefund);
    }

    public final String a(Context context, CJRContributionData cJRContributionData, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJRContributionData, "contributionData");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.a(context, cJRContributionData, cJROrderedCart);
    }

    public final String a(Context context, boolean z) {
        k.c(context, "context");
        return this.f63062b.a(context, z);
    }

    public final String a(String str, String str2, Context context) {
        k.c(str2, "responsePaymentMethod");
        return this.f63062b.a(str, str2, context);
    }

    public final String a(CJROSActionResponseV2 cJROSActionResponseV2) {
        return this.f63062b.a(cJROSActionResponseV2);
    }

    public final void a(Context context, String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.f63063c.a(context, str);
    }

    public final void a(String str) {
        k.c(str, "categoryName");
        this.f63063c.a(str);
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        k.c(cJROrderSummary, "orderSummary");
        this.f63062b.a(cJROrderSummary);
    }

    public final boolean a() {
        return false;
    }

    public final boolean a(IJRPaytmDataModel iJRPaytmDataModel, CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.a(iJRPaytmDataModel, cJROrderedCart);
    }

    public final SpannableString b(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        k.c(context, "context");
        return this.f63062b.b(context, cJROSActionResponseV2);
    }

    public final String b(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.b(context, cJROrderedCart);
    }

    public final String b(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.b(context, cJROrderedCart, cJROSActionResponseV2);
    }

    public final String b(Context context, CJRTransactionDetails cJRTransactionDetails) {
        k.c(context, "context");
        k.c(cJRTransactionDetails, "transactionDetail");
        return this.f63062b.b(context, cJRTransactionDetails);
    }

    public final String b(CJROSActionResponseV2 cJROSActionResponseV2) {
        return this.f63062b.b(cJROSActionResponseV2);
    }

    public final StringBuilder b(Context context) {
        k.c(context, "context");
        return null;
    }

    public final c.a.C1269a b() {
        return null;
    }

    public final void b(String str) {
        k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.f63063c.b(str);
    }

    public final void b(CJROrderSummary cJROrderSummary) {
        this.f63063c.b(cJROrderSummary);
    }

    public final void b(net.one97.paytm.recharge.ordersummary.b.a aVar) {
        k.c(aVar, "viewModel");
        this.f63062b.b(aVar);
    }

    public final void b(boolean z) {
        this.f63063c.b(z);
    }

    public final String c(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.c(context, cJROrderedCart);
    }

    public final String c(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.c(cJROrderedCart);
    }

    public final void c(String str, String str2) {
        this.f63063c.c(str, str2);
    }

    public final boolean c() {
        return false;
    }

    public final String d(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.d(context, cJROrderedCart);
    }

    public final boolean d(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.d(cJROrderedCart);
    }

    public final o<String, String> e(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.e(context, cJROrderedCart);
    }

    public final String f(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.f(context, cJROrderedCart);
    }

    public final List<String> f(Context context) {
        k.c(context, "context");
        return this.f63062b.f(context);
    }

    public final String g(Context context) {
        k.c(context, "context");
        return this.f63062b.g(context);
    }

    public final String g(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.g(context, cJROrderedCart);
    }

    public final String h(Context context) {
        k.c(context, "context");
        return this.f63062b.h(context);
    }

    public final String h(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.h(context, cJROrderedCart);
    }

    public final String i(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.i(context, cJROrderedCart);
    }

    public final List<String> i(Context context) {
        k.c(context, "context");
        return this.f63062b.i(context);
    }

    public final String j(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.j(context, cJROrderedCart);
    }

    public final ArrayList<o<String, String>> j(Context context) {
        k.c(context, "context");
        return this.f63062b.j(context);
    }

    public final String k(Context context) {
        k.c(context, "context");
        return this.f63062b.k(context);
    }

    public final String k(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.k(context, cJROrderedCart);
    }

    public final SpannableString l(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return this.f63062b.l(context, cJROrderedCart);
    }

    public final String l(Context context) {
        k.c(context, "context");
        return this.f63062b.l(context);
    }

    public final String m() {
        return this.f63062b.m();
    }

    public final String m(Context context) {
        k.c(context, "context");
        return this.f63062b.m(context);
    }

    public final String m(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.m(context, cJROrderedCart);
    }

    public final String n() {
        return this.f63062b.n();
    }

    public final String n(Context context) {
        k.c(context, "context");
        return this.f63062b.n(context);
    }

    public final boolean n(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        return this.f63062b.n(context, cJROrderedCart);
    }

    public final String o() {
        return this.f63062b.o();
    }

    public final String o(Context context) {
        k.c(context, "context");
        return this.f63062b.o(context);
    }

    public final String p() {
        return this.f63062b.p();
    }

    public final String p(Context context) {
        k.c(context, "context");
        return this.f63062b.p(context);
    }

    public final String q(Context context) {
        k.c(context, "context");
        return this.f63062b.q(context);
    }

    public final boolean q() {
        return this.f63062b.q();
    }

    public final String r() {
        return this.f63063c.r();
    }

    public final String r(Context context) {
        k.c(context, "context");
        return this.f63062b.r(context);
    }

    public final String s(Context context) {
        k.c(context, "context");
        return this.f63062b.s(context);
    }

    public final String t(Context context) {
        k.c(context, "context");
        return this.f63062b.t(context);
    }

    public final String u(Context context) {
        k.c(context, "context");
        return this.f63062b.u(context);
    }

    public final String v(Context context) {
        k.c(context, "context");
        return this.f63062b.v(context);
    }

    public final String w(Context context) {
        k.c(context, "context");
        return this.f63062b.w(context);
    }

    public final String x(Context context) {
        k.c(context, "context");
        return this.f63062b.x(context);
    }

    public final String y(Context context) {
        k.c(context, "context");
        return this.f63062b.y(context);
    }

    public final SpannableString z(Context context) {
        k.c(context, "context");
        return this.f63062b.z(context);
    }

    public a(net.one97.paytm.recharge.ordersummary.f.c cVar, m mVar) {
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
        this.f63062b = cVar;
        this.f63063c = mVar;
    }

    public final void a(net.one97.paytm.recharge.ordersummary.b.a aVar) {
        k.c(aVar, "viewModel");
        this.f63061a = aVar;
        this.f63062b.b(aVar);
    }

    public final boolean d() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63061a;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar.q();
    }

    public final String e() {
        String name = net.one97.paytm.recharge.legacy.ordersummary.a.c.class.getName();
        k.a((Object) name, "FJRSuccessRechargeStoref…Fragment::class.java.name");
        return name;
    }

    public final String f() {
        String name = net.one97.paytm.recharge.legacy.ordersummary.a.c.class.getName();
        k.a((Object) name, "FJRSuccessRechargeStoref…Fragment::class.java.name");
        return name;
    }

    public final String g() {
        String name = net.one97.paytm.recharge.legacy.ordersummary.a.a.class.getName();
        k.a((Object) name, "FJRMetroSuccessOrderSumm…Fragment::class.java.name");
        return name;
    }

    public final String h() {
        String name = b.class.getName();
        k.a((Object) name, "FJRSuccessRechargeOrderS…Fragment::class.java.name");
        return name;
    }

    public final String i() {
        String name = CJRProcessingOrderSummaryLayout.class.getName();
        k.a((Object) name, "CJRProcessingOrderSummaryLayout::class.java.name");
        return name;
    }

    public final Bundle j() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63061a;
        if (aVar == null) {
            k.a("viewModel");
        }
        CJROrderedCart u = aVar.u();
        if (u != null) {
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f63061a;
            if (aVar2 == null) {
                k.a("viewModel");
            }
            if (aVar2.b(u)) {
                Bundle bundle = new Bundle();
                bundle.putString("recharge.component.name", CJRMetroTicketCancelledOrderSummary.class.getName());
                bundle.putInt("recharge.layout.id", R.layout.content_metro_ticket_cancelled_order_summary);
                bundle.putInt("recharge.logo.id", R.drawable.ic_metro_ticket_status_purchased);
                return bundle;
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("recharge.component.name", CJRFailedOrderSummary.class.getName());
        bundle2.putInt("recharge.layout.id", R.layout.failed_pending_order_summary_base);
        bundle2.putInt("recharge.logo.id", R.drawable.ic_recharge_order_summary_failed);
        return bundle2;
    }

    public final Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", CJRPendingOrderSummary.class.getName());
        bundle.putInt("recharge.layout.id", R.layout.failed_pending_order_summary_base);
        return bundle;
    }

    public final String a(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f63062b;
        if (cVar != null) {
            e eVar = (e) cVar;
            String string = context.getString(R.string.operator_hyphen_number, new Object[]{eVar.f64291c, eVar.f64292d});
            k.a((Object) string, "context.getString(R.stri…rName, repo.payTypeLabel)");
            return string;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final String c(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f63062b;
        if (cVar != null) {
            String string = context.getString(R.string.metro_fetching_vertical, new Object[]{((e) cVar).f64292d});
            k.a((Object) string, "context.getString(R.stri…tical, repo.payTypeLabel)");
            return string;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final boolean a(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "cjrOrderedCart");
        return p.a("235", cJROrderedCart.getItemStatus(), true) | this.f63062b.a(cJROrderedCart) | p.a("18", cJROrderedCart.getItemStatus(), true);
    }

    public final SpannableString a(Context context, boolean z, CJROrderedCart cJROrderedCart, boolean z2) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f63062b;
        if (cVar != null) {
            int i2 = R.string.metro_order_status_banner;
            Object[] objArr = new Object[1];
            String str = ((e) cVar).f64292d;
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            return new SpannableString(context.getString(i2, objArr));
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final boolean b(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "rechargeItem");
        if ("18".equals(cJROrderedCart.getItemStatus()) || "235".equals(cJROrderedCart.getItemStatus())) {
            return true;
        }
        return this.f63062b.b(cJROrderedCart);
    }

    public final SpannableString d(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f63062b;
        if (cVar != null) {
            return new SpannableString(context.getString(R.string.metro_pending_notify_message, new Object[]{((e) cVar).f64292d}));
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final List<String> e(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f63062b;
        if (cVar != null) {
            e eVar = (e) cVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getString(R.string.money_deducted_message_1));
            arrayList.add(context.getString(R.string.money_deducted_message_2));
            arrayList.add(context.getString(R.string.metro_money_deducted_message_3, new Object[]{eVar.f64291c, eVar.f64292d}));
            arrayList.add(context.getString(R.string.money_deducted_message_4));
            return arrayList;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final Bundle l() {
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", g.class.getName());
        return bundle;
    }

    public final int a(boolean z) {
        return R.layout.content_view_banner_status_order;
    }

    public final String a(String str, String str2) {
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        String payTypeLabel;
        CJROrderSummaryProductDetail productDetail2;
        CJRAttributes attributes2;
        String operatorLabel;
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63061a;
        if (aVar == null) {
            k.a("viewModel");
        }
        CJROrderedCart u = aVar.u();
        if (!(u == null || (productDetail2 = u.getProductDetail()) == null || (attributes2 = productDetail2.getAttributes()) == null || (operatorLabel = attributes2.getOperatorLabel()) == null)) {
            str = operatorLabel;
        }
        if (!(u == null || (productDetail = u.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (payTypeLabel = attributes.getPayTypeLabel()) == null)) {
            str2 = payTypeLabel;
        }
        return this.f63063c.a(str, str2);
    }

    public final String b(String str, String str2) {
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        String payTypeLabel;
        CJROrderSummaryProductDetail productDetail2;
        CJRAttributes attributes2;
        String operatorLabel;
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f63061a;
        if (aVar == null) {
            k.a("viewModel");
        }
        CJROrderedCart u = aVar.u();
        if (!(u == null || (productDetail2 = u.getProductDetail()) == null || (attributes2 = productDetail2.getAttributes()) == null || (operatorLabel = attributes2.getOperatorLabel()) == null)) {
            str = operatorLabel;
        }
        if (!(u == null || (productDetail = u.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (payTypeLabel = attributes.getPayTypeLabel()) == null)) {
            str2 = payTypeLabel;
        }
        return this.f63063c.b(str, str2);
    }
}
