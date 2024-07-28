package net.one97.paytm.recharge.ordersummary.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.common.e.q;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.model.CJRPersonalInsurance;
import net.one97.paytm.recharge.ordersummary.b.a.b;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.j;
import net.one97.paytm.recharge.ordersummary.f.k;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class a extends ai implements c, j, k, m {
    private final /* synthetic */ m A;

    /* renamed from: a  reason: collision with root package name */
    public long f63997a = -1;

    /* renamed from: b  reason: collision with root package name */
    public CJROrderSummary f63998b;

    /* renamed from: c  reason: collision with root package name */
    public final io.reactivex.rxjava3.j.b<CJROrderSummary> f63999c = io.reactivex.rxjava3.j.b.a();

    /* renamed from: d  reason: collision with root package name */
    public double f64000d = 1.0d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64001e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64002f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64003g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64004h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<CJROrderedCart> f64005i = new ArrayList<>(3);
    public ArrayList<CJROrderedCart> j = new ArrayList<>(1);
    public ArrayList<CJROrderedCart> k = new ArrayList<>(1);
    public ArrayList<CJROrderedCart> l = new ArrayList<>(0);
    public final HashMap<Long, CJROSActionResponseV2> m = new HashMap<>();
    public CJRAutomaticSubscriptionCheckModel n;
    public boolean o;
    public y<String> p = new y<>();
    public boolean q;
    public y<CJRTaggedObservable<CJRContributionData>> r = new y<>();
    public final boolean s;
    public final CJRRechargeCart t;
    public final j u;
    private CJROrderedCart v;
    private ArrayList<CJROrderedCart> w = new ArrayList<>();
    private ArrayList<CJROrderSummaryPayment> x;
    private final b y;
    private final /* synthetic */ c z;

    public final String A(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.A(context);
    }

    public final String B(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.B(context);
    }

    public final String C(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.C(context);
    }

    public final String D(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.D(context);
    }

    public final String E(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.E(context);
    }

    public final String F(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.F(context);
    }

    public final String G(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.G(context);
    }

    public final String H(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.H(context);
    }

    public final String I(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.I(context);
    }

    public final String J(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.J(context);
    }

    public final String K(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.K(context);
    }

    public final String L(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.L(context);
    }

    public final String M(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.M(context);
    }

    public final String N(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.N(context);
    }

    public final String O(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.O(context);
    }

    public final String P(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.P(context);
    }

    public final String Q(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.Q(context);
    }

    public final String R(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.R(context);
    }

    public final SpannableString S(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.S(context);
    }

    public final String T(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.T(context);
    }

    public final int a(Context context, CJROrderedCart cJROrderedCart, boolean z2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.a(context, cJROrderedCart, z2);
    }

    public final int a(boolean z2) {
        return this.u.a(z2);
    }

    public final SpannableString a(Context context, CJRTransactionDetails cJRTransactionDetails) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJRTransactionDetails, "transactionDetail");
        return this.z.a(context, cJRTransactionDetails);
    }

    public final SpannableString a(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        kotlin.g.b.k.c(context, "context");
        return this.z.a(context, cJROSActionResponseV2);
    }

    public final SpannableString a(Context context, boolean z2, CJROrderedCart cJROrderedCart, boolean z3) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.a(context, z2, cJROrderedCart, z3);
    }

    public final String a(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.a(context);
    }

    public final String a(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.a(context, cJROrderedCart);
    }

    public final String a(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.a(context, cJROrderedCart, cJROSActionResponseV2);
    }

    public final String a(Context context, CJRRefund cJRRefund) {
        kotlin.g.b.k.c(context, "context");
        return this.z.a(context, cJRRefund);
    }

    public final String a(Context context, CJRTransactionDetails cJRTransactionDetails, CJRRefund cJRRefund) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJRTransactionDetails, "transactionDetail");
        kotlin.g.b.k.c(cJRRefund, "refundDetail");
        return this.z.a(context, cJRTransactionDetails, cJRRefund);
    }

    public final String a(Context context, CJRContributionData cJRContributionData, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJRContributionData, "contributionData");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.a(context, cJRContributionData, cJROrderedCart);
    }

    public final String a(Context context, boolean z2) {
        kotlin.g.b.k.c(context, "context");
        return this.z.a(context, z2);
    }

    public final String a(String str, String str2) {
        return this.A.a(str, str2);
    }

    public final String a(String str, String str2, Context context) {
        kotlin.g.b.k.c(str2, "responsePaymentMethod");
        return this.z.a(str, str2, context);
    }

    public final String a(CJROSActionResponseV2 cJROSActionResponseV2) {
        return this.z.a(cJROSActionResponseV2);
    }

    public final void a(Context context, String str) {
        kotlin.g.b.k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.A.a(context, str);
    }

    public final void a(String str) {
        kotlin.g.b.k.c(str, "categoryName");
        this.A.a(str);
    }

    public final void a(String str, String str2, String str3, net.one97.paytm.recharge.common.e.ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "orderId");
        kotlin.g.b.k.c(str3, "extraQueryParams");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.y.a(str, str2, str3, aiVar, obj);
    }

    public final void a(String str, net.one97.paytm.recharge.common.e.ai aiVar, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        this.y.a(str, aiVar, obj);
    }

    public final void a(String str, net.one97.paytm.recharge.common.e.ai aiVar, String str2, String str3, String str4, String str5, CJROrderedCart cJROrderedCart, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(aiVar, "onSuccess");
        kotlin.g.b.k.c(str2, "url");
        kotlin.g.b.k.c(str3, "productMasterNumber");
        kotlin.g.b.k.c(str4, "productMasterId");
        String str6 = str5;
        kotlin.g.b.k.c(str6, "rechargeMasterPrice");
        CJROrderedCart cJROrderedCart2 = cJROrderedCart;
        kotlin.g.b.k.c(cJROrderedCart2, "masterProduct");
        this.y.a(str, aiVar, str2, str3, str4, str6, cJROrderedCart2, obj);
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        kotlin.g.b.k.c(cJROrderSummary, "orderSummary");
        this.z.a(cJROrderSummary);
    }

    public final void a(a aVar) {
        kotlin.g.b.k.c(aVar, "viewModel");
        this.u.a(aVar);
    }

    public final boolean a() {
        return this.u.a();
    }

    public final boolean a(IJRPaytmDataModel iJRPaytmDataModel, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.a(iJRPaytmDataModel, cJROrderedCart);
    }

    public final boolean a(CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(cJROrderedCart, "cjrOrderedCart");
        return this.z.a(cJROrderedCart);
    }

    public final SpannableString b(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        kotlin.g.b.k.c(context, "context");
        return this.z.b(context, cJROSActionResponseV2);
    }

    public final String b(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.b(context, cJROrderedCart);
    }

    public final String b(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.b(context, cJROrderedCart, cJROSActionResponseV2);
    }

    public final String b(Context context, CJRTransactionDetails cJRTransactionDetails) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJRTransactionDetails, "transactionDetail");
        return this.z.b(context, cJRTransactionDetails);
    }

    public final String b(String str, String str2) {
        return this.A.b(str, str2);
    }

    public final String b(CJROSActionResponseV2 cJROSActionResponseV2) {
        return this.z.b(cJROSActionResponseV2);
    }

    public final StringBuilder b(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.b(context);
    }

    public final c.a.C1269a b() {
        return this.u.b();
    }

    public final void b(String str) {
        kotlin.g.b.k.c(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
        this.A.b(str);
    }

    public final void b(CJROrderSummary cJROrderSummary) {
        this.A.b(cJROrderSummary);
    }

    public final void b(a aVar) {
        kotlin.g.b.k.c(aVar, "viewModel");
        this.z.b(aVar);
    }

    public final void b(boolean z2) {
        this.A.b(z2);
    }

    public final boolean b(CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.b(cJROrderedCart);
    }

    public final String c(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.c(context);
    }

    public final String c(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.c(context, cJROrderedCart);
    }

    public final String c(CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.c(cJROrderedCart);
    }

    public final void c(String str, String str2) {
        this.A.c(str, str2);
    }

    public final boolean c() {
        return this.u.c();
    }

    public final SpannableString d(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.d(context);
    }

    public final String d(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.d(context, cJROrderedCart);
    }

    public final boolean d() {
        return this.u.d();
    }

    public final boolean d(CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.d(cJROrderedCart);
    }

    public final String e() {
        return this.u.e();
    }

    public final List<String> e(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.e(context);
    }

    public final o<String, String> e(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.e(context, cJROrderedCart);
    }

    public final String f() {
        return this.u.f();
    }

    public final String f(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.f(context, cJROrderedCart);
    }

    public final List<String> f(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.f(context);
    }

    public final String g() {
        return this.u.g();
    }

    public final String g(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.g(context);
    }

    public final String g(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.g(context, cJROrderedCart);
    }

    public final String h() {
        return this.u.h();
    }

    public final String h(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.h(context);
    }

    public final String h(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.h(context, cJROrderedCart);
    }

    public final String i() {
        return this.u.i();
    }

    public final String i(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.i(context, cJROrderedCart);
    }

    public final List<String> i(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.i(context);
    }

    public final Bundle j() {
        return this.u.j();
    }

    public final String j(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.j(context, cJROrderedCart);
    }

    public final ArrayList<o<String, String>> j(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.j(context);
    }

    public final Bundle k() {
        return this.u.k();
    }

    public final String k(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.k(context);
    }

    public final String k(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.k(context, cJROrderedCart);
    }

    public final Bundle l() {
        return this.u.l();
    }

    public final SpannableString l(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "rechargeItem");
        return this.z.l(context, cJROrderedCart);
    }

    public final String l(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.l(context);
    }

    public final String m() {
        return this.z.m();
    }

    public final String m(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.m(context);
    }

    public final String m(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.m(context, cJROrderedCart);
    }

    public final String n() {
        return this.z.n();
    }

    public final String n(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.n(context);
    }

    public final boolean n(Context context, CJROrderedCart cJROrderedCart) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(cJROrderedCart, "orderedItem");
        return this.z.n(context, cJROrderedCart);
    }

    public final String o() {
        return this.z.o();
    }

    public final String o(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.o(context);
    }

    public final String p() {
        return this.z.p();
    }

    public final String p(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.p(context);
    }

    public final String q(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.q(context);
    }

    public final boolean q() {
        return this.z.q();
    }

    public final String r() {
        return this.A.r();
    }

    public final String r(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.r(context);
    }

    public final String s(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.s(context);
    }

    public final String t(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.t(context);
    }

    public final String u(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.u(context);
    }

    public final String v(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.v(context);
    }

    public final String w(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.w(context);
    }

    public final String x(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.x(context);
    }

    public final String y(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.y(context);
    }

    public final SpannableString z(Context context) {
        kotlin.g.b.k.c(context, "context");
        return this.z.z(context);
    }

    public a(boolean z2, CJRRechargeCart cJRRechargeCart, b bVar, j jVar) {
        kotlin.g.b.k.c(bVar, "mOrderSummaryDataRepo");
        kotlin.g.b.k.c(jVar, "layoutRespository");
        this.z = (net.one97.paytm.recharge.ordersummary.f.c) jVar;
        this.A = (m) jVar;
        this.s = z2;
        this.t = cJRRechargeCart;
        this.y = bVar;
        this.u = jVar;
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        cJRRechargeUtilities.debugLog(a.class.getSimpleName() + " viewModel is instantiated");
        this.u.a(this);
    }

    private void w() {
        this.f64001e = true;
        this.f64002f = true;
        this.f64003g = true;
        this.f64005i.clear();
        this.j.clear();
        this.w.clear();
        this.k.clear();
        ArrayList<CJROrderSummaryPayment> arrayList = this.x;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.x = null;
        this.l.clear();
        this.v = null;
    }

    public final void c(CJROrderSummary cJROrderSummary) {
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        CJROrderSummaryProductDetail productDetail2;
        CJRAttributes attributes2;
        int i2;
        long j2;
        CJROrderSummaryProductDetail productDetail3;
        CJROrderSummary cJROrderSummary2 = cJROrderSummary;
        kotlin.g.b.k.c(cJROrderSummary2, "orderSummary");
        w();
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        if (orderedCartList != null) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            HashMap<String, String> bm = net.one97.paytm.recharge.di.helper.c.bm();
            net.one97.paytm.recharge.di.helper.c cVar2 = net.one97.paytm.recharge.di.helper.c.f62654a;
            HashMap<String, String> bn = net.one97.paytm.recharge.di.helper.c.bn();
            net.one97.paytm.recharge.di.helper.c cVar3 = net.one97.paytm.recharge.di.helper.c.f62654a;
            HashMap<String, String> bo = net.one97.paytm.recharge.di.helper.c.bo();
            x.d dVar = new x.d();
            Context applicationContext = CJRRechargeUtilities.INSTANCE.getApplicationContext();
            int i3 = 0;
            for (Object next : orderedCartList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    kotlin.a.k.a();
                }
                CJROrderedCart cJROrderedCart = (CJROrderedCart) next;
                kotlin.g.b.k.a((Object) cJROrderedCart, "item");
                CJROrderSummaryProductDetail productDetail4 = cJROrderedCart.getProductDetail();
                if (productDetail4 != null) {
                    i2 = i4;
                    j2 = productDetail4.getVerticalId();
                } else {
                    i2 = i4;
                    j2 = 0;
                }
                dVar.element = j2;
                if (dVar.element != 0 && bm != null && bm.containsKey(String.valueOf(dVar.element)) && ba.c(bm.get(String.valueOf(dVar.element)), applicationContext)) {
                    this.f64005i.add(cJROrderedCart);
                } else if (dVar.element != 0 && bn != null && bn.containsKey(String.valueOf(dVar.element)) && ba.c(bn.get(String.valueOf(dVar.element)), applicationContext)) {
                    this.j.add(cJROrderedCart);
                } else if (dVar.element == 0 || bo == null || !bo.containsKey(String.valueOf(dVar.element)) || !ba.c(bo.get(String.valueOf(dVar.element)), applicationContext)) {
                    CJROrderedCart cJROrderedCart2 = this.k.size() > 0 ? this.k.get(0) : null;
                    if (i3 != 0) {
                        Long valueOf = (cJROrderedCart2 == null || (productDetail3 = cJROrderedCart2.getProductDetail()) == null) ? null : Long.valueOf(productDetail3.getCategoryId());
                        CJROrderSummaryProductDetail productDetail5 = cJROrderedCart.getProductDetail();
                        if (!kotlin.g.b.k.a((Object) valueOf, (Object) productDetail5 != null ? Long.valueOf(productDetail5.getCategoryId()) : null)) {
                            this.l.add(cJROrderedCart);
                        }
                    }
                    this.k.add(cJROrderedCart);
                    CJROrderSummaryProductDetail productDetail6 = cJROrderedCart.getProductDetail();
                    long categoryId = productDetail6 != null ? productDetail6.getCategoryId() : -1;
                    if (categoryId != -1) {
                        this.f63997a = categoryId;
                    }
                    if (cJROrderSummary.getOrderStatus() == 2 && kotlin.g.b.k.a((Object) "7", (Object) cJROrderedCart.getItemStatus())) {
                        this.f64001e = false;
                        this.f64003g = false;
                    } else if (a(cJROrderedCart) || b(cJROrderedCart)) {
                        this.f64002f = false;
                        this.f64003g = false;
                    } else {
                        this.f64002f = false;
                        this.f64001e = false;
                    }
                } else {
                    this.w.add(cJROrderedCart);
                }
                i3 = i2;
            }
            CJROrderedCart u2 = u();
            String service = (u2 == null || (productDetail2 = u2.getProductDetail()) == null || (attributes2 = productDetail2.getAttributes()) == null) ? null : attributes2.getService();
            String paytype = (u2 == null || (productDetail = u2.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null) ? null : attributes.getPaytype();
            b(a(service, paytype));
            a(b(service, paytype));
            d dVar2 = d.f64967a;
            CJRRechargeErrorModel b2 = d.b();
            if ((u2 != null ? u2.getProductDetail() : null) != null) {
                CJROrderSummaryProductDetail productDetail7 = u2.getProductDetail();
                kotlin.g.b.k.a((Object) productDetail7, "mainItem.productDetail");
                b2.setCategoryId(String.valueOf(productDetail7.getCategoryId()));
                CJROrderSummaryProductDetail productDetail8 = u2.getProductDetail();
                kotlin.g.b.k.a((Object) productDetail8, "mainItem.productDetail");
                b2.setProductId(String.valueOf(productDetail8.getId()));
            }
            b2.setScreenName(r());
            CRUFlowModel flowName = b2.getFlowName();
            if (flowName == null) {
                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
            }
            flowName.setOrderId(cJROrderSummary.getId());
            b2.setFlowName(flowName);
        }
        this.f63998b = cJROrderSummary2;
        this.f63999c.onNext(cJROrderSummary2);
        CJRRechargeUtilities.INSTANCE.debugLog("ViewModel : initialize");
    }

    public final boolean s() {
        Iterable<CJROrderedCart> iterable = this.k;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (CJROrderedCart itemStatus : iterable) {
            if (kotlin.g.b.k.a((Object) itemStatus.getItemStatus(), (Object) "7")) {
                return true;
            }
        }
        return false;
    }

    public final boolean t() {
        boolean z2;
        Iterable<CJROrderedCart> iterable = this.k;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (CJROrderedCart cJROrderedCart : iterable) {
                if (!(!kotlin.g.b.k.a((Object) cJROrderedCart.getItemStatus(), (Object) "7")) || b(cJROrderedCart) || a(cJROrderedCart)) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: net.one97.paytm.common.entity.shopping.CJROrderedCart} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.common.entity.shopping.CJROrderedCart u() {
        /*
            r8 = this;
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r8.v
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            int r0 = r0.size()
            r1 = 0
            if (r0 != 0) goto L_0x0010
            goto L_0x00d3
        L_0x0010:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            int r0 = r0.size()
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L_0x0025
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            goto L_0x00d3
        L_0x0025:
            boolean r0 = r8.f64002f
            if (r0 == 0) goto L_0x0034
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            goto L_0x00d3
        L_0x0034:
            boolean r0 = r8.t()
            java.lang.String r4 = "7"
            if (r0 == 0) goto L_0x0071
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0044:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x006e
            java.lang.Object r5 = r0.next()
            r6 = r5
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            java.lang.String r7 = r6.getItemStatus()
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r4)
            r7 = r7 ^ r3
            if (r7 == 0) goto L_0x006a
            boolean r7 = r8.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r6)
            if (r7 != 0) goto L_0x006a
            boolean r6 = r8.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r6)
            if (r6 != 0) goto L_0x006a
            r6 = 1
            goto L_0x006b
        L_0x006a:
            r6 = 0
        L_0x006b:
            if (r6 == 0) goto L_0x0044
            r1 = r5
        L_0x006e:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            goto L_0x00d3
        L_0x0071:
            boolean r0 = r8.s()
            if (r0 == 0) goto L_0x009a
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x007f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0097
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3
            java.lang.String r3 = r3.getItemStatus()
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x007f
            r1 = r2
        L_0x0097:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            goto L_0x00d3
        L_0x009a:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00a2:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x00c6
            java.lang.Object r5 = r0.next()
            r6 = r5
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            java.lang.String r7 = r6.getItemStatus()
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r4)
            r7 = r7 ^ r3
            if (r7 == 0) goto L_0x00c2
            boolean r6 = r8.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r6)
            if (r6 != 0) goto L_0x00c2
            r6 = 1
            goto L_0x00c3
        L_0x00c2:
            r6 = 0
        L_0x00c3:
            if (r6 == 0) goto L_0x00a2
            r1 = r5
        L_0x00c6:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            if (r1 != 0) goto L_0x00d3
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart> r0 = r8.k
            java.lang.Object r0 = r0.get(r2)
            r1 = r0
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
        L_0x00d3:
            r8.v = r1
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r8.v
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.b.a.u():net.one97.paytm.common.entity.shopping.CJROrderedCart");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r1 = r1.getPaymentInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment> v() {
        /*
            r4 = this;
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment> r0 = r4.x
            if (r0 != 0) goto L_0x0058
            java.util.ArrayList r0 = new java.util.ArrayList
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r4.f63998b
            if (r1 == 0) goto L_0x0015
            java.util.ArrayList r1 = r1.getPaymentInfo()
            if (r1 == 0) goto L_0x0015
            int r1 = r1.size()
            goto L_0x0016
        L_0x0015:
            r1 = 0
        L_0x0016:
            r0.<init>(r1)
            r4.x = r0
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment> r0 = r4.x
            if (r0 == 0) goto L_0x0050
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r4.f63998b
            if (r1 == 0) goto L_0x0058
            java.util.ArrayList r1 = r1.getPaymentInfo()
            if (r1 == 0) goto L_0x0058
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x002f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r1.next()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r2 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r2
            java.lang.String r3 = "it"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = r2.getPaymentMethod()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x002f
            r0.add(r2)
            goto L_0x002f
        L_0x0050:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment>"
            r0.<init>(r1)
            throw r0
        L_0x0058:
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment> r0 = r4.x
            if (r0 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.b.a.v():java.util.List");
    }

    public final void a(q qVar) {
        kotlin.g.b.k.c(qVar, "listener");
        CJROrderedCart u2 = u();
        if (u2 == null) {
            kotlin.g.b.k.a();
        }
        if (!TextUtils.isEmpty(u2.getRechargeNumber())) {
            CJROrderSummarySubscription subscription = u2.getSubscription();
            if (subscription == null || !subscription.getIsApplicable()) {
                qVar.a(false);
                return;
            }
            qVar.a(true);
            CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel = this.n;
            if (cJRAutomaticSubscriptionCheckModel == null) {
                net.one97.paytm.recharge.common.e.ai aVar = new C1254a(this, qVar);
                String rechargeNumber = u2.getRechargeNumber();
                kotlin.g.b.k.a((Object) rechargeNumber, "orderedCart.rechargeNumber");
                d dVar = d.f64967a;
                CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                kotlin.g.b.k.c("check_subscription", "tag");
                kotlin.g.b.k.c(aVar, "onSuccess");
                kotlin.g.b.k.c(rechargeNumber, "rechargeNumber");
                this.y.c("check_subscription", aVar, rechargeNumber, a2);
                return;
            }
            if (cJRAutomaticSubscriptionCheckModel == null) {
                kotlin.g.b.k.a();
            }
            a(cJRAutomaticSubscriptionCheckModel, qVar);
        }
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.b.a$a  reason: collision with other inner class name */
    public static final class C1254a implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64006a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f64007b;

        C1254a(a aVar, q qVar) {
            this.f64006a = aVar;
            this.f64007b = qVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            this.f64007b.a((CJRAutomaticSubscriptionItemModel) null);
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            a aVar = this.f64006a;
            if (iJRPaytmDataModel != null) {
                aVar.a((CJRAutomaticSubscriptionCheckModel) iJRPaytmDataModel, this.f64007b);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel");
        }
    }

    /* access modifiers changed from: private */
    public final void a(CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel, q qVar) {
        this.n = cJRAutomaticSubscriptionCheckModel;
        Integer status = cJRAutomaticSubscriptionCheckModel.getStatus();
        if (status != null && status.intValue() == 0) {
            qVar.b();
        } else {
            qVar.a((CJRAutomaticSubscriptionItemModel) null);
        }
    }

    public final void a(String str, String str2, Object obj) {
        kotlin.g.b.k.c(str, "tag");
        kotlin.g.b.k.c(str2, "url");
        CJRRechargeUtilities.INSTANCE.debugLog("getpersonalinsurance call");
        CJROrderedCart u2 = u();
        if (u2 == null) {
            kotlin.g.b.k.a();
        }
        this.q = true;
        b bVar = this.y;
        net.one97.paytm.recharge.common.e.ai bVar2 = new b(this);
        String rechargeNumber = u2.getRechargeNumber();
        kotlin.g.b.k.a((Object) rechargeNumber, "orderedCart.rechargeNumber");
        String valueOf = String.valueOf(u2.getProductId());
        CJROrderSummary cJROrderSummary = this.f63998b;
        bVar.a(str, bVar2, str2, rechargeNumber, valueOf, String.valueOf(cJROrderSummary != null ? Double.valueOf(cJROrderSummary.getSubTotal()) : null), u2, obj);
    }

    public static final class b implements net.one97.paytm.recharge.common.e.ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64009a;

        b(a aVar) {
            this.f64009a = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            CJRRechargeUtilities.INSTANCE.debugLog("getpersonalinsurance call fail");
            boolean z = false;
            this.f64009a.q = false;
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                CharSequence errorMsg = cJRRechargeErrorModel.getErrorMsg();
                if (errorMsg == null || p.a(errorMsg)) {
                    z = true;
                }
                if (z) {
                    cJRRechargeErrorModel.setErrorMsg("Error while fetching insurance policy");
                }
                az azVar = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRPersonalInsurance) {
                CJRPersonalInsurance cJRPersonalInsurance = (CJRPersonalInsurance) iJRPaytmDataModel;
                if (cJRPersonalInsurance.getTermsAndConditions() != null) {
                    CJRRechargeUtilities.INSTANCE.debugLog("getpersonalinsurance call success");
                    a aVar = this.f64009a;
                    aVar.q = false;
                    aVar.p.setValue(cJRPersonalInsurance.getTermsAndConditions());
                }
            }
        }
    }

    public final boolean a(CJROSActionItemV2 cJROSActionItemV2, int i2, boolean z2) {
        kotlin.g.b.k.c(cJROSActionItemV2, "action");
        boolean z3 = cJROSActionItemV2.getVisibility() == i2 || cJROSActionItemV2.getVisibility() == 3;
        boolean z4 = this.k.size() != 1 ? !(!z3 || !(cJROSActionItemV2.getVisibilityMultiItem() == 1 || cJROSActionItemV2.getVisibilityMultiItem() == 2)) : !(!z3 || cJROSActionItemV2.getVisibilityMultiItem() == 1);
        return !z2 ? z4 && cJROSActionItemV2.getVisibilityCategoryAction() != 1 : z4 && (cJROSActionItemV2.getVisibilityCategoryAction() == 1 || cJROSActionItemV2.getVisibilityCategoryAction() == 2);
    }
}
