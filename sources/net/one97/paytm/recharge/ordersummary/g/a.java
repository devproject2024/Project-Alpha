package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.CustomTypefaceSpan;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.d.b;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.ordersummary.h.c;
import org.json.JSONObject;

public final class a extends h {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(c cVar, m mVar) {
        super(cVar, mVar);
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
    }

    public final String h() {
        String name = net.one97.paytm.recharge.ordersummary.d.c.class.getName();
        k.a((Object) name, "FJRCreditCardOrderDetailsFragment::class.java.name");
        return name;
    }

    public final Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", b.class.getName());
        return bundle;
    }

    public final Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", b.class.getName());
        return bundle;
    }

    public final int a(boolean z) {
        if (z) {
            return super.a(z);
        }
        return R.layout.v8_content_os_cc_status_banner;
    }

    public final String r(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_cc_header_title_pending_1);
        k.a((Object) string, "context.getString(R.stri…c_header_title_pending_1)");
        if (string != null) {
            String upperCase = string.toUpperCase();
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            return upperCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String u(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.v8_os_cc_header_title_pending_2);
        k.a((Object) string, "context.getString(R.stri…c_header_title_pending_2)");
        return string;
    }

    public final String b(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        String string = context.getString(R.string.bill_payment);
        k.a((Object) string, "context.getString(R.string.bill_payment)");
        return string;
    }

    public final String g(Context context) {
        k.c(context, "context");
        String string = context.getString(R.string.cancel_paytype, new Object[]{context.getString(R.string.bill_payment)});
        k.a((Object) string, "context.getString(R.stri…g(R.string.bill_payment))");
        return string;
    }

    public final SpannableString S(Context context) {
        k.c(context, "context");
        return new SpannableString(context.getString(R.string.v8_os_pre_processing_operator_received_title, new Object[]{context.getString(R.string.v8_os_bill_payment)}));
    }

    public final SpannableString a(Context context, boolean z, CJROrderedCart cJROrderedCart, boolean z2) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        String string = context.getString(R.string.v8_os_bill_payment);
        k.a((Object) string, "context.getString(R.string.v8_os_bill_payment)");
        if (z) {
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64304a;
            if (aVar == null) {
                k.a();
            }
            CJROrderedCart u = aVar.u();
            if (u == null) {
                k.a();
            }
            String g2 = g(context, u);
            StringBuilder sb = new StringBuilder();
            String string2 = context.getString(R.string.recharge_order_status_success, new Object[]{string});
            k.a((Object) string2, "context.getString(R.stri…             billPayment)");
            if (string2 != null) {
                String upperCase = string2.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                sb.append(upperCase);
                sb.append(" ");
                sb.append(g2);
                return new SpannableString(sb.toString());
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        String string3 = context.getString(R.string.recharge_order_status_success, new Object[]{string});
        k.a((Object) string3, "context.getString(R.stri…             billPayment)");
        if (string3 != null) {
            String upperCase2 = string3.toUpperCase();
            k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
            return new SpannableString(upperCase2);
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    public final String f(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        if (attributes == null) {
            return "";
        }
        String rechargeNumberDisplayLabel = attributes.getRechargeNumberDisplayLabel();
        if (rechargeNumberDisplayLabel == null) {
            rechargeNumberDisplayLabel = "";
        }
        if (TextUtils.isEmpty(rechargeNumberDisplayLabel)) {
            StringBuilder sb = new StringBuilder();
            c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            String a2 = c.a.a(attributes.getOperatorDisplayLabel());
            if (a2 == null) {
                a2 = "";
            }
            sb.append(a2);
            sb.append(' ');
            String string = context.getString(R.string.automatic_payment_mode_cc);
            k.a((Object) string, "context.getString(R.stri…utomatic_payment_mode_cc)");
            if (string != null) {
                String lowerCase = string.toLowerCase();
                k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                return sb.toString();
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        String a3 = c.a.a(attributes.getOperatorDisplayLabel());
        if (a3 == null) {
            return "";
        }
        return a3;
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.a.k(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart):java.lang.String");
    }

    public final String Q(Context context) {
        String str;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64304a;
        CJROrderedCart u = aVar != null ? aVar.u() : null;
        if (u == null || (productDetail = u.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (str = attributes.getRechargeNumberDisplayLabel()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return az.a(p.a(p.a(super.Q(context), " ", "", false), "-", "", false));
        }
        return str + ' ' + az.a(p.a(p.a(super.Q(context), " ", "", false), "-", "", false));
    }

    public final String a(Context context) {
        String str;
        String a2;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            int i2 = R.string.operator_hyphen_number;
            Object[] objArr = new Object[2];
            objArr[0] = eVar.f64291c;
            String str2 = eVar.f64294f;
            if (str2 == null || (a2 = p.a(str2, " ", "", false)) == null || (str = p.a(a2, "-", "", false)) == null) {
                str = "";
            }
            objArr[1] = az.a(str);
            String string = context.getString(i2, objArr);
            k.a((Object) string, "context.getString(R.stri…)?.replace(\"-\", \"\")?:\"\"))");
            return string;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final String G(Context context) {
        String str;
        String a2;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            int i2 = R.string.v8_os_pre_processing_operator_processing_description;
            Object[] objArr = new Object[2];
            objArr[0] = eVar.f64291c;
            String str2 = eVar.f64294f;
            if (str2 == null || (a2 = p.a(str2, " ", "", false)) == null || (str = p.a(a2, "-", "", false)) == null) {
                str = "";
            }
            objArr[1] = az.a(str);
            String string = context.getString(i2, objArr);
            k.a((Object) string, "context.getString(R.stri…)?.replace(\"-\", \"\")?:\"\"))");
            return string;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final String I(Context context) {
        String str;
        String a2;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            int i2 = R.string.v8_os_pre_processing_operator_received_description;
            Object[] objArr = new Object[2];
            objArr[0] = eVar.f64291c;
            String str2 = eVar.f64294f;
            if (str2 == null || (a2 = p.a(str2, " ", "", false)) == null || (str = p.a(a2, "-", "", false)) == null) {
                str = "";
            }
            objArr[1] = az.a(str);
            String string = context.getString(i2, objArr);
            k.a((Object) string, "context.getString(R.stri…)?.replace(\"-\", \"\")?:\"\"))");
            return string;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final String h(Context context, CJROrderedCart cJROrderedCart) {
        String str;
        String str2;
        String a2;
        String str3;
        String a3;
        CJRAttributes attributes;
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            if (productDetail == null || (attributes = productDetail.getAttributes()) == null || (str = attributes.getRechargeNumberDisplayLabel()) == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                String str4 = eVar.f64294f;
                if (str4 == null || (a3 = p.a(str4, " ", "", false)) == null || (str3 = p.a(a3, "-", "", false)) == null) {
                    str3 = "";
                }
                return az.a(str3);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(' ');
            String str5 = eVar.f64294f;
            if (str5 == null || (a2 = p.a(str5, " ", "", false)) == null || (str2 = p.a(a2, "-", "", false)) == null) {
                str2 = "";
            }
            sb.append(az.a(str2));
            return sb.toString();
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final SpannableString z(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        String g2 = g(context, u);
        StringBuilder sb = new StringBuilder(context.getString(R.string.v8_os_order_journey_payment_received_title));
        sb.append(StringUtility.NEW_LINE);
        sb.append(g2);
        SpannableString spannableString = new SpannableString(sb);
        CharSequence charSequence = spannableString;
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), p.a(charSequence, g2, 0, false, 6), spannableString.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(1.5f), p.a(charSequence, g2, 0, false, 6), spannableString.length(), 33);
        return spannableString;
    }

    public final List<String> f(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        String b2 = b(context, u);
        List<String> asList = Arrays.asList(new String[]{context.getString(R.string.v8_os_cancel_bottom_sheet_message, new Object[]{b2})});
        k.a((Object) asList, "Arrays.asList(context.ge…_sheet_message, payType))");
        return asList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r0 == null) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String R(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r7, r0)
            net.one97.paytm.recharge.ordersummary.f.c r0 = r6.f64305b
            if (r0 == 0) goto L_0x0099
            net.one97.paytm.recharge.ordersummary.g.e r0 = (net.one97.paytm.recharge.ordersummary.g.e) r0
            net.one97.paytm.recharge.ordersummary.b.a r1 = r6.f64304a
            if (r1 != 0) goto L_0x0012
            kotlin.g.b.k.a()
        L_0x0012:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r1.u()
            if (r1 != 0) goto L_0x001b
            kotlin.g.b.k.a()
        L_0x001b:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r1.getProductDetail()
            r3 = 0
            if (r2 == 0) goto L_0x0027
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()
            goto L_0x0028
        L_0x0027:
            r2 = r3
        L_0x0028:
            java.lang.String r0 = r0.f64291c
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0044
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String r5 = "(this as java.lang.String).toUpperCase()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            if (r0 != 0) goto L_0x0045
            goto L_0x0044
        L_0x003c:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r0)
            throw r7
        L_0x0044:
            r0 = r4
        L_0x0045:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x0055
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0055
            java.lang.String r3 = r1.getRechargeNumberDisplayLabel()
        L_0x0055:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x007b
            int r1 = net.one97.paytm.recharge.R.string.v8_os_order_storefront_cc_bill_payment_title
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r5 = 0
            r3[r5] = r0
            r0 = 1
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = r2.getCardNetwork()
            if (r2 != 0) goto L_0x006f
        L_0x006e:
            r2 = r4
        L_0x006f:
            r3[r0] = r2
            java.lang.String r7 = r7.getString(r1, r3)
            java.lang.String r0 = "context.getString(R.stri…Attrs?.cardNetwork ?: \"\")"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            return r7
        L_0x007b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r0 = " - "
            r7.append(r0)
            if (r2 == 0) goto L_0x0090
            java.lang.String r0 = r2.getCardNetwork()
            if (r0 != 0) goto L_0x0091
        L_0x0090:
            r0 = r4
        L_0x0091:
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            return r7
        L_0x0099:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.a.R(android.content.Context):java.lang.String");
    }

    public final SpannableString b(Context context, CJROSActionResponseV2 cJROSActionResponseV2) {
        String str;
        String str2;
        String str3;
        CJROSActionResponseV2 itemLevelActions;
        String str4;
        k.c(context, "context");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        try {
            CJRFullFillmentObject fullFillmentOject = u.getFullFillmentOject();
            if (fullFillmentOject == null || (str4 = fullFillmentOject.getFulfillmentResponse()) == null) {
                str4 = "";
            }
            str = net.one97.paytm.recharge.ordersummary.h.c.f64331a.a(new JSONObject(str4), "paymentReferenceNumber");
        } catch (Exception unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            c.a aVar2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            String string = context.getString(R.string.v8_os_cc_payment_ref_number, new Object[]{str});
            k.a((Object) string, "context.getString(R.stri…mber, paymentReferenceNo)");
            return c.a.a(string, str);
        }
        if (cJROSActionResponseV2 == null || (itemLevelActions = cJROSActionResponseV2.getItemLevelActions()) == null || (str2 = itemLevelActions.getMessage()) == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
            if (cVar != null) {
                e eVar = (e) cVar;
                net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f64304a;
                if (aVar3 == null) {
                    k.a();
                }
                CJROrderedCart u2 = aVar3.u();
                if (u2 == null) {
                    k.a();
                }
                CJROrderSummaryProductDetail productDetail = u2.getProductDetail();
                if (productDetail != null) {
                    productDetail.getAttributes();
                }
                int i2 = R.string.v8_os_default_post_action_cc;
                Object[] objArr = new Object[1];
                String str5 = eVar.f64295g;
                if (str5 == null) {
                    str3 = null;
                } else if (str5 != null) {
                    str3 = str5.toLowerCase();
                    k.a((Object) str3, "(this as java.lang.String).toLowerCase()");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
                objArr[0] = str3;
                str2 = context.getString(i2, objArr);
                k.a((Object) str2, "context.getString(R.stri…pitalized?.toLowerCase())");
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
            }
        }
        c.a aVar4 = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        return c.a.a(str2, "");
    }
}
