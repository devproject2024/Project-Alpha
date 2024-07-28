package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import com.paytm.utility.CustomTypefaceSpan;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.ordersummary.d.h;
import net.one97.paytm.recharge.ordersummary.d.i;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.m;
import org.json.JSONObject;

public final class g extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(c cVar, m mVar) {
        super(cVar, mVar);
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
    }

    public final String f() {
        String name = i.class.getName();
        k.a((Object) name, "FJRMetroSmartCardStoreFr…Fragment::class.java.name");
        return name;
    }

    public final String h() {
        String name = h.class.getName();
        k.a((Object) name, "FJRMetroSmartCardOrderDe…Fragment::class.java.name");
        return name;
    }

    public final SpannableString l(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        SpannableString l = super.l(context, cJROrderedCart);
        l.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif-medium", 1)), 0, l.length(), 33);
        return l;
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
            int r0 = net.one97.paytm.recharge.R.string.v8_os_ref_num_post_action_smart_card
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
            int r2 = net.one97.paytm.recharge.R.string.v8_os_default_post_action_smart_card
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.g.b(android.content.Context, net.one97.paytm.recharge.model.CJROSActionResponseV2):android.text.SpannableString");
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
        if (i2 != 11) {
            return super.b(cJROrderedCart);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r0 = (r0 = r0.getProductDetail()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.text.SpannableString S(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r6, r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r5.f64304a
            if (r0 != 0) goto L_0x000c
            kotlin.g.b.k.a()
        L_0x000c:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
            net.one97.paytm.recharge.ordersummary.h.c$a r1 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            if (r0 == 0) goto L_0x0025
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x0025
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x0025
            java.lang.String r0 = r0.getTicketType()
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            java.lang.String r0 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r0)
            android.text.SpannableString r1 = new android.text.SpannableString
            int r2 = net.one97.paytm.recharge.R.string.v8_os_pre_processing_operator_received_title
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            if (r0 != 0) goto L_0x0039
            int r0 = net.one97.paytm.recharge.R.string.recharge
            java.lang.String r0 = r6.getString(r0)
        L_0x0039:
            r4 = 0
            r3[r4] = r0
            java.lang.String r6 = r6.getString(r2, r3)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1.<init>(r6)
            java.lang.String r6 = "sans-serif"
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r4)
            com.paytm.utility.CustomTypefaceSpan r0 = new com.paytm.utility.CustomTypefaceSpan
            java.lang.String r2 = ""
            r0.<init>(r2, r6)
            int r6 = r1.length()
            r2 = 33
            r1.setSpan(r0, r4, r6, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.g.S(android.content.Context):android.text.SpannableString");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        r5 = (r5 = r5.getProductDetail()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.text.SpannableString a(android.content.Context r4, boolean r5, net.one97.paytm.common.entity.shopping.CJROrderedCart r6, boolean r7) {
        /*
            r3 = this;
            java.lang.String r5 = "context"
            kotlin.g.b.k.c(r4, r5)
            java.lang.String r5 = "rechargeItem"
            kotlin.g.b.k.c(r6, r5)
            net.one97.paytm.recharge.ordersummary.b.a r5 = r3.f64304a
            if (r5 != 0) goto L_0x0011
            kotlin.g.b.k.a()
        L_0x0011:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = r5.u()
            if (r5 != 0) goto L_0x001a
            kotlin.g.b.k.a()
        L_0x001a:
            java.lang.String r6 = r3.g(r4, r5)
            net.one97.paytm.recharge.ordersummary.h.c$a r7 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            if (r5 == 0) goto L_0x0033
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r5.getProductDetail()
            if (r5 == 0) goto L_0x0033
            net.one97.paytm.common.entity.recharge.CJRAttributes r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x0033
            java.lang.String r5 = r5.getTicketType()
            goto L_0x0034
        L_0x0033:
            r5 = 0
        L_0x0034:
            java.lang.String r5 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r5)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r0 = net.one97.paytm.recharge.R.string.recharge_order_status_success
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            if (r5 != 0) goto L_0x004b
            int r5 = net.one97.paytm.recharge.R.string.recharge
            java.lang.String r5 = r4.getString(r5)
        L_0x004b:
            r1[r2] = r5
            java.lang.String r4 = r4.getString(r0, r1)
            java.lang.String r5 = "context.getString(R.stri…tring(R.string.recharge))"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            if (r4 == 0) goto L_0x0078
            java.lang.String r4 = r4.toUpperCase()
            java.lang.String r5 = "(this as java.lang.String).toUpperCase()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r7.append(r4)
            java.lang.String r4 = " "
            r7.append(r4)
            r7.append(r6)
            java.lang.String r4 = r7.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            android.text.SpannableString r5 = new android.text.SpannableString
            r5.<init>(r4)
            return r5
        L_0x0078:
            kotlin.u r4 = new kotlin.u
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.g.a(android.content.Context, boolean, net.one97.paytm.common.entity.shopping.CJROrderedCart, boolean):android.text.SpannableString");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r0 = (r0 = r0.getProductDetail()).getAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String Q(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r5, r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r4.f64304a
            if (r0 != 0) goto L_0x000c
            kotlin.g.b.k.a()
        L_0x000c:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
            net.one97.paytm.recharge.ordersummary.f.c r1 = r4.f64305b
            if (r1 == 0) goto L_0x0056
            net.one97.paytm.recharge.ordersummary.g.e r1 = (net.one97.paytm.recharge.ordersummary.g.e) r1
            java.lang.String r1 = r1.Q(r5)
            if (r0 == 0) goto L_0x002d
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x002d
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r0.getRechargeNumberDisplayLabel()
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0051
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0051
            int r0 = net.one97.paytm.recharge.R.string.v8_os_recharge_number_smart_card
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            java.lang.String r5 = r5.getString(r0, r2)
            java.lang.String r0 = "context.getString(R.stri…art_card, rechargeNumber)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r0)
            return r5
        L_0x0051:
            java.lang.String r5 = super.Q(r5)
            return r5
        L_0x0056:
            kotlin.u r5 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.g.Q(android.content.Context):java.lang.String");
    }
}
