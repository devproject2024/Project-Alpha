package net.one97.paytm.recharge.ordersummary.f;

import android.content.Context;
import android.text.SpannableString;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.o;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.recharge.model.CJRContributionData;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.b.a;

public interface c {
    String A(Context context);

    String B(Context context);

    String C(Context context);

    String D(Context context);

    String E(Context context);

    String F(Context context);

    String G(Context context);

    String H(Context context);

    String I(Context context);

    String J(Context context);

    String K(Context context);

    String L(Context context);

    String M(Context context);

    String N(Context context);

    String O(Context context);

    String P(Context context);

    String Q(Context context);

    String R(Context context);

    SpannableString S(Context context);

    String T(Context context);

    int a(Context context, CJROrderedCart cJROrderedCart, boolean z);

    SpannableString a(Context context, CJRTransactionDetails cJRTransactionDetails);

    SpannableString a(Context context, CJROSActionResponseV2 cJROSActionResponseV2);

    SpannableString a(Context context, boolean z, CJROrderedCart cJROrderedCart, boolean z2);

    String a(Context context);

    String a(Context context, CJROrderedCart cJROrderedCart);

    String a(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2);

    String a(Context context, CJRRefund cJRRefund);

    String a(Context context, CJRTransactionDetails cJRTransactionDetails, CJRRefund cJRRefund);

    String a(Context context, CJRContributionData cJRContributionData, CJROrderedCart cJROrderedCart);

    String a(Context context, boolean z);

    String a(String str, String str2, Context context);

    String a(CJROSActionResponseV2 cJROSActionResponseV2);

    void a(CJROrderSummary cJROrderSummary);

    boolean a(IJRPaytmDataModel iJRPaytmDataModel, CJROrderedCart cJROrderedCart);

    boolean a(CJROrderedCart cJROrderedCart);

    SpannableString b(Context context, CJROSActionResponseV2 cJROSActionResponseV2);

    String b(Context context, CJROrderedCart cJROrderedCart);

    String b(Context context, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2);

    String b(Context context, CJRTransactionDetails cJRTransactionDetails);

    String b(CJROSActionResponseV2 cJROSActionResponseV2);

    StringBuilder b(Context context);

    void b(a aVar);

    boolean b(CJROrderedCart cJROrderedCart);

    String c(Context context);

    String c(Context context, CJROrderedCart cJROrderedCart);

    String c(CJROrderedCart cJROrderedCart);

    SpannableString d(Context context);

    String d(Context context, CJROrderedCart cJROrderedCart);

    boolean d(CJROrderedCart cJROrderedCart);

    List<String> e(Context context);

    o<String, String> e(Context context, CJROrderedCart cJROrderedCart);

    String f(Context context, CJROrderedCart cJROrderedCart);

    List<String> f(Context context);

    String g(Context context);

    String g(Context context, CJROrderedCart cJROrderedCart);

    String h(Context context);

    String h(Context context, CJROrderedCart cJROrderedCart);

    String i(Context context, CJROrderedCart cJROrderedCart);

    List<String> i(Context context);

    String j(Context context, CJROrderedCart cJROrderedCart);

    ArrayList<o<String, String>> j(Context context);

    String k(Context context);

    String k(Context context, CJROrderedCart cJROrderedCart);

    SpannableString l(Context context, CJROrderedCart cJROrderedCart);

    String l(Context context);

    String m();

    String m(Context context);

    String m(Context context, CJROrderedCart cJROrderedCart);

    String n();

    String n(Context context);

    boolean n(Context context, CJROrderedCart cJROrderedCart);

    String o();

    String o(Context context);

    String p();

    String p(Context context);

    String q(Context context);

    boolean q();

    String r(Context context);

    String s(Context context);

    String t(Context context);

    String u(Context context);

    String v(Context context);

    String w(Context context);

    String x(Context context);

    String y(Context context);

    SpannableString z(Context context);
}
