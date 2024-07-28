package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import com.paytm.utility.CustomTypefaceSpan;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.ordersummary.h.c;

public class c extends d {
    public final String Q(Context context) {
        k.c(context, "context");
        return "";
    }

    public final String h(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        return "";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(net.one97.paytm.recharge.ordersummary.f.c cVar, m mVar) {
        super(cVar, mVar);
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
    }

    public final SpannableString S(Context context) {
        k.c(context, "context");
        SpannableString spannableString = new SpannableString(context.getString(R.string.v8_os_storefront_title_donation));
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 1)), 0, spannableString.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(1.5f), 0, spannableString.length(), 33);
        return spannableString;
    }

    public SpannableString l(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        SpannableString spannableString = new SpannableString(context.getString(R.string.v8_os_storefront_subtitle_donation, new Object[]{super.g(context, cJROrderedCart)}));
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), 0, spannableString.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(0.6f), 0, spannableString.length(), 33);
        return spannableString;
    }

    public final String f(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        if (attributes == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        String a2 = c.a.a(attributes.getOperatorDisplayLabel());
        if (a2 == null) {
            a2 = "";
        }
        sb.append(a2);
        sb.append(' ');
        String payTypeDisplayLabel = attributes.getPayTypeDisplayLabel();
        if (payTypeDisplayLabel == null) {
            payTypeDisplayLabel = "";
        }
        sb.append(payTypeDisplayLabel);
        return sb.toString();
    }

    public final String k(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        if (attributes == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        String a2 = c.a.a(attributes.getOperatorDisplayLabel());
        if (a2 == null) {
            a2 = "";
        }
        sb.append(a2);
        sb.append(' ');
        String payTypeDisplayLabel = attributes.getPayTypeDisplayLabel();
        if (payTypeDisplayLabel == null) {
            payTypeDisplayLabel = "";
        }
        sb.append(payTypeDisplayLabel);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.text.SpannableString b(android.content.Context r11, net.one97.paytm.recharge.model.CJROSActionResponseV2 r12) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = ""
            if (r12 == 0) goto L_0x0015
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r12 = r12.getItemLevelActions()
            if (r12 == 0) goto L_0x0015
            java.lang.String r12 = r12.getMessage()
            if (r12 != 0) goto L_0x0016
        L_0x0015:
            r12 = r0
        L_0x0016:
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00e3
            net.one97.paytm.recharge.ordersummary.f.c r12 = r10.f64305b
            if (r12 == 0) goto L_0x00db
            net.one97.paytm.recharge.ordersummary.g.e r12 = (net.one97.paytm.recharge.ordersummary.g.e) r12
            net.one97.paytm.recharge.ordersummary.b.a r1 = r10.f64304a
            if (r1 != 0) goto L_0x002c
            kotlin.g.b.k.a()
        L_0x002c:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r1.u()
            if (r1 != 0) goto L_0x0035
            kotlin.g.b.k.a()
        L_0x0035:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0075 }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r3 = r1.getFullFillmentOject()     // Catch:{ Exception -> 0x0075 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r3 = r3.getFulfillmentResponse()     // Catch:{ Exception -> 0x0075 }
            if (r3 != 0) goto L_0x0044
        L_0x0043:
            r3 = r0
        L_0x0044:
            r2.<init>(r3)     // Catch:{ Exception -> 0x0075 }
            net.one97.paytm.recharge.ordersummary.h.c$a r3 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0075 }
            java.lang.String r4 = "OPERATOR_REF_NUMBER"
            java.lang.String r3 = r3.a((org.json.JSONObject) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x0075 }
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0073 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0073 }
            if (r4 == 0) goto L_0x0060
            net.one97.paytm.recharge.ordersummary.h.c$a r4 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0073 }
            java.lang.String r5 = "opt_ref_id"
            java.lang.String r3 = r4.a((org.json.JSONObject) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x0073 }
        L_0x0060:
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0073 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0073 }
            if (r4 == 0) goto L_0x007e
            net.one97.paytm.recharge.ordersummary.h.c$a r4 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0073 }
            java.lang.String r5 = "operatorRefNumber"
            java.lang.String r2 = r4.a((org.json.JSONObject) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x0073 }
            r3 = r2
            goto L_0x007e
        L_0x0073:
            r2 = move-exception
            goto L_0x0077
        L_0x0075:
            r2 = move-exception
            r3 = r0
        L_0x0077:
            java.lang.String r2 = r2.getMessage()
            com.paytm.utility.q.d(r2)
        L_0x007e:
            r2 = r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            r8 = 4
            if (r2 != 0) goto L_0x00aa
            int r0 = net.one97.paytm.recharge.R.string.v8_os_ref_num_post_action_donation
            java.lang.Object[] r2 = new java.lang.Object[r8]
            java.lang.String r8 = r12.f64295g
            r2[r7] = r8
            java.lang.String r1 = r10.g(r11, r1)
            r2[r6] = r1
            java.lang.String r12 = r12.f64291c
            r2[r5] = r12
            r2[r4] = r3
            java.lang.String r12 = r11.getString(r0, r2)
            java.lang.String r11 = "context.getString(R.stri…Name, paymentReferenceNo)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r11)
            goto L_0x00e4
        L_0x00aa:
            int r2 = net.one97.paytm.recharge.R.string.v8_os_default_post_action_donation
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r9 = r12.f64295g
            r8[r7] = r9
            java.lang.String r1 = r10.g(r11, r1)
            r8[r6] = r1
            java.lang.String r12 = r12.f64291c
            r8[r5] = r12
            net.one97.paytm.recharge.ordersummary.b.a r12 = r10.f64304a
            if (r12 == 0) goto L_0x00ca
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r12.f63998b
            if (r12 == 0) goto L_0x00ca
            java.lang.String r12 = r12.getCreatedAt()
            if (r12 != 0) goto L_0x00cb
        L_0x00ca:
            r12 = r0
        L_0x00cb:
            java.lang.String r12 = c((java.lang.String) r12)
            r8[r4] = r12
            java.lang.String r12 = r11.getString(r2, r8)
            java.lang.String r11 = "context.getString(R.stri…                  ?: \"\"))"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r11)
            goto L_0x00e4
        L_0x00db:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource"
            r11.<init>(r12)
            throw r11
        L_0x00e3:
            r3 = r0
        L_0x00e4:
            net.one97.paytm.recharge.ordersummary.h.c$a r11 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            android.text.SpannableString r11 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r12, (java.lang.String) r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.c.b(android.content.Context, net.one97.paytm.recharge.model.CJROSActionResponseV2):android.text.SpannableString");
    }
}
