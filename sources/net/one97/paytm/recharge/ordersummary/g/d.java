package net.one97.paytm.recharge.ordersummary.g;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.CustomTypefaceSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.d.b;
import net.one97.paytm.recharge.ordersummary.d.e;
import net.one97.paytm.recharge.ordersummary.d.l;
import net.one97.paytm.recharge.ordersummary.f.m;
import net.one97.paytm.recharge.ordersummary.h.c;

public class d extends h {

    /* renamed from: c  reason: collision with root package name */
    private final c.a.C1269a f64288c;

    public /* synthetic */ d(net.one97.paytm.recharge.ordersummary.f.c cVar, m mVar) {
        this(cVar, mVar, (c.a.C1269a) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(net.one97.paytm.recharge.ordersummary.f.c cVar, m mVar, c.a.C1269a aVar) {
        super(cVar, mVar);
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
        this.f64288c = aVar;
    }

    public final c.a.C1269a b() {
        return this.f64288c;
    }

    public String h() {
        if (c.a.C1269a.MY_PAYMENTS == this.f64288c) {
            String name = l.class.getName();
            k.a((Object) name, "FJRMyPayOrderDetailsFragment::class.java.name");
            return name;
        }
        String name2 = net.one97.paytm.recharge.ordersummary.d.d.class.getName();
        k.a((Object) name2, "FJRElectricityOrderDetai…Fragment::class.java.name");
        return name2;
    }

    public String f() {
        String name = e.class.getName();
        k.a((Object) name, "FJRElectricityStoreFrontFragment::class.java.name");
        return name;
    }

    public final Bundle j() {
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.j();
        }
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", b.class.getName());
        return bundle;
    }

    public final Bundle k() {
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.k();
        }
        Bundle bundle = new Bundle();
        bundle.putString("recharge.component.name", b.class.getName());
        return bundle;
    }

    public final int a(boolean z) {
        if (c.a.C1269a.MY_PAYMENTS == this.f64288c) {
            return R.layout.v8_content_os_cc_status_banner;
        }
        return super.a(z);
    }

    public final String g(Context context) {
        k.c(context, "context");
        int i2 = R.string.cancel_paytype;
        Object[] objArr = new Object[1];
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        objArr[0] = b(context, u);
        String string = context.getString(i2, objArr);
        k.a((Object) string, "context.getString(R.stri…eredMainOrderedItem()!!))");
        return string;
    }

    public final String T(Context context) {
        k.c(context, "context");
        return R(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.text.SpannableString b(android.content.Context r20, net.one97.paytm.recharge.model.CJROSActionResponseV2 r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r2, r0)
            java.lang.String r3 = ""
            if (r21 == 0) goto L_0x0019
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r0 = r21.getItemLevelActions()
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x001a
        L_0x0019:
            r0 = r3
        L_0x001a:
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0259
            net.one97.paytm.recharge.ordersummary.f.c r0 = r1.f64305b
            if (r0 == 0) goto L_0x0251
            r4 = r0
            net.one97.paytm.recharge.ordersummary.g.e r4 = (net.one97.paytm.recharge.ordersummary.g.e) r4
            net.one97.paytm.recharge.ordersummary.b.a r0 = r1.f64304a
            if (r0 != 0) goto L_0x0031
            kotlin.g.b.k.a()
        L_0x0031:
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = r0.u()
            if (r5 != 0) goto L_0x003a
            kotlin.g.b.k.a()
        L_0x003a:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r5.getProductDetail()
            if (r0 == 0) goto L_0x0046
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            r7 = r0
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r5.getProductDetail()
            if (r0 == 0) goto L_0x0052
            long r8 = r0.getCategoryId()
            goto L_0x0054
        L_0x0052:
            r8 = -1
        L_0x0054:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0094 }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r10 = r5.getFullFillmentOject()     // Catch:{ Exception -> 0x0094 }
            if (r10 == 0) goto L_0x0062
            java.lang.String r10 = r10.getFulfillmentResponse()     // Catch:{ Exception -> 0x0094 }
            if (r10 != 0) goto L_0x0063
        L_0x0062:
            r10 = r3
        L_0x0063:
            r0.<init>(r10)     // Catch:{ Exception -> 0x0094 }
            net.one97.paytm.recharge.ordersummary.h.c$a r10 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0094 }
            java.lang.String r11 = "OPERATOR_REF_NUMBER"
            java.lang.String r10 = r10.a((org.json.JSONObject) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x0094 }
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x0092 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0092 }
            if (r11 == 0) goto L_0x007f
            net.one97.paytm.recharge.ordersummary.h.c$a r11 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0092 }
            java.lang.String r12 = "opt_ref_id"
            java.lang.String r10 = r11.a((org.json.JSONObject) r0, (java.lang.String) r12)     // Catch:{ Exception -> 0x0092 }
        L_0x007f:
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x0092 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0092 }
            if (r11 == 0) goto L_0x009d
            net.one97.paytm.recharge.ordersummary.h.c$a r11 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x0092 }
            java.lang.String r12 = "operatorRefNumber"
            java.lang.String r0 = r11.a((org.json.JSONObject) r0, (java.lang.String) r12)     // Catch:{ Exception -> 0x0092 }
            r10 = r0
            goto L_0x009d
        L_0x0092:
            r0 = move-exception
            goto L_0x0096
        L_0x0094:
            r0 = move-exception
            r10 = r3
        L_0x0096:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x009d:
            net.one97.paytm.recharge.di.helper.c r0 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r0 = net.one97.paytm.recharge.di.helper.c.h()
            java.lang.Long r11 = java.lang.Long.valueOf(r8)
            boolean r0 = r0.contains(r11)
            java.lang.String r11 = "context.getString(R.stri…Name, paymentReferenceNo)"
            java.lang.String r12 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r13 = "(this as java.lang.String).toLowerCase()"
            r14 = 3
            r15 = 0
            r6 = 1
            if (r0 == 0) goto L_0x0115
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ea
            int r0 = net.one97.paytm.recharge.R.string.recharge_details_operator_contact_referenceid
            java.lang.Object[] r3 = new java.lang.Object[r14]
            java.lang.String r5 = r4.f64295g
            if (r5 == 0) goto L_0x00d7
            if (r5 == 0) goto L_0x00d1
            java.lang.String r5 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)
            goto L_0x00d8
        L_0x00d1:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x00d7:
            r5 = 0
        L_0x00d8:
            r3[r15] = r5
            java.lang.String r4 = r4.f64291c
            r3[r6] = r4
            r5 = 2
            r3[r5] = r10
            java.lang.String r0 = r2.getString(r0, r3)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            goto L_0x025a
        L_0x00ea:
            r5 = 2
            int r0 = net.one97.paytm.recharge.R.string.recharge_details_operator_contact_customer_care
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r5 = r4.f64295g
            if (r5 == 0) goto L_0x0103
            if (r5 == 0) goto L_0x00fd
            java.lang.String r5 = r5.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)
            goto L_0x0104
        L_0x00fd:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0103:
            r5 = 0
        L_0x0104:
            r3[r15] = r5
            java.lang.String r4 = r4.f64291c
            r3[r6] = r4
            java.lang.String r0 = r2.getString(r0, r3)
            java.lang.String r2 = "context.getString(R.stri…ase(), repo.operatorName)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            goto L_0x025a
        L_0x0115:
            long r16 = net.one97.paytm.recharge.common.utils.ba.f61546h
            r0 = 4
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 == 0) goto L_0x0197
            long r16 = net.one97.paytm.recharge.common.utils.ba.f61547i
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 == 0) goto L_0x0197
            long r16 = net.one97.paytm.recharge.common.utils.ba.j
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 != 0) goto L_0x0129
            goto L_0x0197
        L_0x0129:
            net.one97.paytm.recharge.ordersummary.h.c$a$a r7 = net.one97.paytm.recharge.ordersummary.h.c.a.C1269a.MY_PAYMENTS
            net.one97.paytm.recharge.ordersummary.h.c$a$a r8 = r1.f64288c
            if (r7 != r8) goto L_0x013c
            int r0 = net.one97.paytm.recharge.R.string.os_my_pay_default_success_post_action_msg
            java.lang.String r0 = r2.getString(r0)
            java.lang.String r2 = "context.getString(R.stri…_success_post_action_msg)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            goto L_0x025a
        L_0x013c:
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0163
            int r3 = net.one97.paytm.recharge.R.string.v8_os_ref_num_post_action_elec_gas_water
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r7 = r4.f64295g
            r0[r15] = r7
            java.lang.String r5 = r1.g(r2, r5)
            r0[r6] = r5
            java.lang.String r4 = r4.f64291c
            r5 = 2
            r0[r5] = r4
            r0[r14] = r10
            java.lang.String r0 = r2.getString(r3, r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            goto L_0x025a
        L_0x0163:
            int r7 = net.one97.paytm.recharge.R.string.v8_os_default_post_action_elec_gas_water
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r8 = r4.f64295g
            r0[r15] = r8
            java.lang.String r5 = r1.g(r2, r5)
            r0[r6] = r5
            java.lang.String r4 = r4.f64291c
            r5 = 2
            r0[r5] = r4
            net.one97.paytm.recharge.ordersummary.b.a r4 = r1.f64304a
            if (r4 == 0) goto L_0x0186
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r4.f63998b
            if (r4 == 0) goto L_0x0186
            java.lang.String r4 = r4.getCreatedAt()
            if (r4 != 0) goto L_0x0185
            goto L_0x0186
        L_0x0185:
            r3 = r4
        L_0x0186:
            java.lang.String r3 = c((java.lang.String) r3)
            r0[r14] = r3
            java.lang.String r0 = r2.getString(r7, r0)
            java.lang.String r2 = "context.getString(R.stri…onse()?.createdAt ?: \"\"))"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            goto L_0x025a
        L_0x0197:
            if (r7 == 0) goto L_0x019e
            java.lang.String r7 = r7.getPaytype()
            goto L_0x019f
        L_0x019e:
            r7 = 0
        L_0x019f:
            java.lang.String r8 = "prepaid"
            boolean r7 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r7, (boolean) r6)
            if (r7 == 0) goto L_0x01d2
            net.one97.paytm.recharge.ordersummary.b.a r7 = r1.f64304a
            if (r7 == 0) goto L_0x01b8
            kotlin.o r7 = r7.e(r2, r5)
            if (r7 == 0) goto L_0x01b8
            java.lang.Object r7 = r7.getFirst()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x01b9
        L_0x01b8:
            r7 = 0
        L_0x01b9:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x01d2
            int r0 = net.one97.paytm.recharge.R.string.v8_os_default_post_action_elec
            java.lang.String r0 = r2.getString(r0)
            java.lang.String r2 = "context.getString(R.stri…default_post_action_elec)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            goto L_0x025a
        L_0x01d2:
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x020b
            int r3 = net.one97.paytm.recharge.R.string.v8_os_ref_num_post_action_elec_gas_water
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r7 = r4.f64295g
            if (r7 == 0) goto L_0x01f3
            if (r7 == 0) goto L_0x01ed
            java.lang.String r7 = r7.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r13)
            goto L_0x01f4
        L_0x01ed:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x01f3:
            r7 = 0
        L_0x01f4:
            r0[r15] = r7
            java.lang.String r5 = r1.g(r2, r5)
            r0[r6] = r5
            java.lang.String r4 = r4.f64291c
            r5 = 2
            r0[r5] = r4
            r0[r14] = r10
            java.lang.String r0 = r2.getString(r3, r0)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r11)
            goto L_0x025a
        L_0x020b:
            int r7 = net.one97.paytm.recharge.R.string.v8_os_default_post_action_elec_gas_water
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r8 = r4.f64295g
            if (r8 == 0) goto L_0x0223
            if (r8 == 0) goto L_0x021d
            java.lang.String r8 = r8.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r13)
            goto L_0x0224
        L_0x021d:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r12)
            throw r0
        L_0x0223:
            r8 = 0
        L_0x0224:
            r0[r15] = r8
            java.lang.String r5 = r1.g(r2, r5)
            r0[r6] = r5
            java.lang.String r4 = r4.f64291c
            r5 = 2
            r0[r5] = r4
            net.one97.paytm.recharge.ordersummary.b.a r4 = r1.f64304a
            if (r4 == 0) goto L_0x0241
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r4.f63998b
            if (r4 == 0) goto L_0x0241
            java.lang.String r4 = r4.getCreatedAt()
            if (r4 != 0) goto L_0x0240
            goto L_0x0241
        L_0x0240:
            r3 = r4
        L_0x0241:
            java.lang.String r3 = c((java.lang.String) r3)
            r0[r14] = r3
            java.lang.String r0 = r2.getString(r7, r0)
            java.lang.String r2 = "context.getString(R.stri…sponse()?.createdAt?:\"\"))"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            goto L_0x025a
        L_0x0251:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource"
            r0.<init>(r2)
            throw r0
        L_0x0259:
            r10 = r3
        L_0x025a:
            net.one97.paytm.recharge.ordersummary.h.c$a r2 = net.one97.paytm.recharge.ordersummary.h.c.f64331a
            android.text.SpannableString r0 = net.one97.paytm.recharge.ordersummary.h.c.a.a((java.lang.String) r0, (java.lang.String) r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.d.b(android.content.Context, net.one97.paytm.recharge.model.CJROSActionResponseV2):android.text.SpannableString");
    }

    public final String r(Context context) {
        k.c(context, "context");
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.r(context);
        }
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            int i2 = R.string.os_recharge_my_pay_order_status_success;
            Object[] objArr = new Object[1];
            String str = ((e) cVar).f64295g;
            if (str == null) {
                str = context.getString(R.string.v8_os_bill_payment);
            }
            objArr[0] = str;
            String string = context.getString(i2, objArr);
            k.a((Object) string, "context.getString(R.stri…ring.v8_os_bill_payment))");
            if (string != null) {
                String upperCase = string.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                return upperCase;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final SpannableString z(Context context) {
        k.c(context, "context");
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.z(context);
        }
        a aVar = this.f64304a;
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

    public final String u(Context context) {
        k.c(context, "context");
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.u(context);
        }
        String string = context.getString(R.string.os_my_pay_header_title_pending_2);
        k.a((Object) string, "context.getString(R.stri…y_header_title_pending_2)");
        return string;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        r4 = r5.getItemLevelActions();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(android.content.Context r3, net.one97.paytm.common.entity.shopping.CJROrderedCart r4, net.one97.paytm.recharge.model.CJROSActionResponseV2 r5) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = "rechargeItem"
            kotlin.g.b.k.c(r4, r0)
            net.one97.paytm.recharge.ordersummary.h.c$a$a r0 = net.one97.paytm.recharge.ordersummary.h.c.a.C1269a.MY_PAYMENTS
            net.one97.paytm.recharge.ordersummary.h.c$a$a r1 = r2.f64288c
            if (r0 != r1) goto L_0x0065
            net.one97.paytm.recharge.ordersummary.b.a r0 = r2.f64304a
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = r4.getItemStatus()
            java.lang.String r1 = "7"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0065
            net.one97.paytm.recharge.ordersummary.b.a r0 = r2.f64304a
            if (r0 != 0) goto L_0x0029
            kotlin.g.b.k.a()
        L_0x0029:
            boolean r0 = r0.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            if (r0 != 0) goto L_0x0065
            net.one97.paytm.recharge.ordersummary.b.a r0 = r2.f64304a
            if (r0 != 0) goto L_0x0036
            kotlin.g.b.k.a()
        L_0x0036:
            boolean r0 = r0.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            if (r0 != 0) goto L_0x0065
            if (r5 == 0) goto L_0x0049
            net.one97.paytm.recharge.model.CJROSActionResponseV2 r4 = r5.getItemLevelActions()
            if (r4 == 0) goto L_0x0049
            java.lang.String r4 = r4.getMessage()
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0059
            if (r4 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            return r4
        L_0x0059:
            int r4 = net.one97.paytm.recharge.R.string.os_my_pay_default_pseudo_post_action_msg
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "context.getString(R.stri…t_pseudo_post_action_msg)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            return r3
        L_0x0065:
            java.lang.String r3 = super.b(r3, r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.d.b(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart, net.one97.paytm.recharge.model.CJROSActionResponseV2):java.lang.String");
    }

    public final String i(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        if (c.a.C1269a.MY_PAYMENTS == this.f64288c) {
            return "";
        }
        return super.i(context, cJROrderedCart);
    }

    public String f(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        if (attributes == null) {
            return "";
        }
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        CJROrderSummaryProductDetail productDetail2 = u.getProductDetail();
        long categoryId = productDetail2 != null ? productDetail2.getCategoryId() : -1;
        if (!(ba.f61546h == categoryId || ba.f61547i == categoryId || ba.j == categoryId)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (!net.one97.paytm.recharge.di.helper.c.h().contains(Long.valueOf(categoryId))) {
                String rechargeNumberDisplayLabel = attributes.getRechargeNumberDisplayLabel();
                if (rechargeNumberDisplayLabel == null) {
                    rechargeNumberDisplayLabel = "";
                }
                if (TextUtils.isEmpty(rechargeNumberDisplayLabel)) {
                    StringBuilder sb = new StringBuilder();
                    c.a aVar2 = c.f64331a;
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
                c.a aVar3 = c.f64331a;
                String a3 = c.a.a(attributes.getOperatorDisplayLabel());
                if (a3 == null) {
                    return "";
                }
                return a3;
            }
        }
        c.a aVar4 = c.f64331a;
        String a4 = c.a.a(attributes.getOperatorDisplayLabel());
        if (a4 == null) {
            return "";
        }
        return a4;
    }

    public String h(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        if (c.a.C1269a.MY_PAYMENTS == this.f64288c) {
            return Q(context);
        }
        return super.h(context, cJROrderedCart);
    }

    public String k(Context context, CJROrderedCart cJROrderedCart) {
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJRAttributes attributes = productDetail != null ? productDetail.getAttributes() : null;
        if (attributes == null) {
            return "";
        }
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        CJROrderSummaryProductDetail productDetail2 = u.getProductDetail();
        long categoryId = productDetail2 != null ? productDetail2.getCategoryId() : -1;
        if (!(ba.f61546h == categoryId || ba.f61547i == categoryId || ba.j == categoryId)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (!net.one97.paytm.recharge.di.helper.c.h().contains(Long.valueOf(categoryId))) {
                StringBuilder sb = new StringBuilder();
                c.a aVar2 = c.f64331a;
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
        }
        c.a aVar3 = c.f64331a;
        String a3 = c.a.a(attributes.getOperatorDisplayLabel());
        if (a3 == null) {
            return "";
        }
        return a3;
    }

    public final String G(Context context) {
        k.c(context, "context");
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.G(context);
        }
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            String a2 = a(context, eVar.f64296h);
            String string = context.getString(R.string.v8_os_pre_processing_operator_processing_description, new Object[]{eVar.f64291c, a2});
            k.a((Object) string, "context.getString(R.stri…atorName, rechargeNumber)");
            return string;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public final String I(Context context) {
        k.c(context, "context");
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.I(context);
        }
        net.one97.paytm.recharge.ordersummary.f.c cVar = this.f64305b;
        if (cVar != null) {
            e eVar = (e) cVar;
            String a2 = a(context, eVar.f64296h);
            String string = context.getString(R.string.v8_os_pre_processing_operator_received_description, new Object[]{eVar.f64291c, a2});
            k.a((Object) string, "context.getString(R.stri…torName,  rechargeNumber)");
            return string;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
    }

    public static String c(String str) {
        k.c(str, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        String a2 = ab.a(str, "dd.MM.yyyy");
        return a2 == null ? "" : a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.o<java.lang.String, java.lang.String> e(android.content.Context r11, net.one97.paytm.common.entity.shopping.CJROrderedCart r12) {
        /*
            r10 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r11 = "rechargeItem"
            kotlin.g.b.k.c(r12, r11)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r11 = r12.getProductDetail()
            if (r11 == 0) goto L_0x0015
            long r0 = r11.getCategoryId()
            goto L_0x0017
        L_0x0015:
            r0 = -1
        L_0x0017:
            long r2 = net.one97.paytm.recharge.common.utils.ba.f61546h
            java.lang.String r11 = ""
            r4 = 0
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0051
            long r2 = net.one97.paytm.recharge.common.utils.ba.f61547i
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0051
            long r2 = net.one97.paytm.recharge.common.utils.ba.j
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x0051
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r2 = net.one97.paytm.recharge.di.helper.c.h()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L_0x0051
            net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r2 = net.one97.paytm.recharge.di.helper.c.r()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            r12 = r4
            r0 = r12
            goto L_0x0153
        L_0x0051:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r12.getProductDetail()
            if (r2 == 0) goto L_0x005c
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()
            goto L_0x005d
        L_0x005c:
            r2 = r4
        L_0x005d:
            java.lang.String r3 = "prepaid"
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r2.getPaytype()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x0067
        L_0x0066:
            r2 = r4
        L_0x0067:
            r5 = 1
            boolean r2 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r2, (boolean) r5)     // Catch:{ Exception -> 0x00b2 }
            if (r2 == 0) goto L_0x00b2
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b2 }
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r12 = r12.getFullFillmentOject()     // Catch:{ Exception -> 0x00b2 }
            if (r12 == 0) goto L_0x007c
            java.lang.String r12 = r12.getFulfillmentResponse()     // Catch:{ Exception -> 0x00b2 }
            if (r12 != 0) goto L_0x007d
        L_0x007c:
            r12 = r11
        L_0x007d:
            r2.<init>(r12)     // Catch:{ Exception -> 0x00b2 }
            net.one97.paytm.recharge.ordersummary.h.c$a r12 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r3 = "VOUCHER_CODE"
            java.lang.String r12 = r12.a((org.json.JSONObject) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x00b2 }
            r3 = r12
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x00b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00b2 }
            if (r3 == 0) goto L_0x00a9
            net.one97.paytm.recharge.di.helper.c r3 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x00b2 }
            java.util.HashSet r3 = net.one97.paytm.recharge.di.helper.c.s()     // Catch:{ Exception -> 0x00b2 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x00b2 }
            boolean r0 = r3.contains(r0)     // Catch:{ Exception -> 0x00b2 }
            if (r0 != 0) goto L_0x00a9
            net.one97.paytm.recharge.ordersummary.h.c$a r12 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r0 = "operatorRefNumber"
            java.lang.String r12 = r12.a((org.json.JSONObject) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x00b2 }
        L_0x00a9:
            net.one97.paytm.recharge.ordersummary.h.c$a r0 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r1 = "VOUCHER_LABEL"
            java.lang.String r0 = r0.a((org.json.JSONObject) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b4
        L_0x00b2:
            r12 = r4
            r0 = r12
        L_0x00b4:
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0153
            if (r12 == 0) goto L_0x00ca
            java.lang.String r2 = ","
            java.lang.String[] r2 = new java.lang.String[]{r2}
            java.util.List r2 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.String[]) r2)
            goto L_0x00cb
        L_0x00ca:
            r2 = r4
        L_0x00cb:
            if (r2 == 0) goto L_0x00d5
            int r3 = r2.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
        L_0x00d5:
            if (r4 != 0) goto L_0x00da
            kotlin.g.b.k.a()
        L_0x00da:
            int r3 = r4.intValue()
            java.lang.String r4 = "$0 "
            java.lang.String r5 = "(.{4})"
            if (r3 <= 0) goto L_0x013a
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = kotlin.a.k.a(r2)
            r1.<init>(r3)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r2.iterator()
        L_0x00f5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0124
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x011c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.CharSequence r3 = kotlin.m.p.b(r3)
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            kotlin.m.l r6 = new kotlin.m.l
            r6.<init>((java.lang.String) r5)
            java.lang.String r3 = r6.replace((java.lang.CharSequence) r3, (java.lang.String) r4)
            r1.add(r3)
            goto L_0x00f5
        L_0x011c:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.CharSequence"
            r11.<init>(r12)
            throw r11
        L_0x0124:
            java.util.List r1 = (java.util.List) r1
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.String r1 = "\n"
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 62
            java.lang.String r1 = kotlin.a.k.a((java.lang.Iterable) r2, (java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (int) r6, (java.lang.CharSequence) r7, (kotlin.g.a.b) r8, (int) r9)
            goto L_0x0149
        L_0x013a:
            if (r12 != 0) goto L_0x013f
            kotlin.g.b.k.a()
        L_0x013f:
            kotlin.m.l r12 = new kotlin.m.l
            r12.<init>((java.lang.String) r5)
            java.lang.String r12 = r12.replace((java.lang.CharSequence) r1, (java.lang.String) r4)
            r1 = r11
        L_0x0149:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0153
            r12 = r1
        L_0x0153:
            kotlin.o r1 = new kotlin.o
            if (r12 != 0) goto L_0x0158
            r12 = r11
        L_0x0158:
            if (r0 != 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r11 = r0
        L_0x015c:
            r1.<init>(r12, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.d.e(android.content.Context, net.one97.paytm.common.entity.shopping.CJROrderedCart):kotlin.o");
    }

    public final String b(Context context, CJROrderedCart cJROrderedCart) {
        o<String, String> e2;
        k.c(context, "context");
        k.c(cJROrderedCart, "orderedItem");
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        CJROrderedCart u = aVar.u();
        if (u == null) {
            k.a();
        }
        CJROrderSummaryProductDetail productDetail = u.getProductDetail();
        long categoryId = productDetail != null ? productDetail.getCategoryId() : -1;
        if (!(ba.f61546h == categoryId || ba.f61547i == categoryId || ba.j == categoryId)) {
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (!net.one97.paytm.recharge.di.helper.c.h().contains(Long.valueOf(categoryId))) {
                if (c.a.C1269a.MY_PAYMENTS == this.f64288c) {
                    String string = context.getString(R.string.os_my_pay_cancel_postfix);
                    k.a((Object) string, "context.getString(R.stri…os_my_pay_cancel_postfix)");
                    return string;
                }
                net.one97.paytm.recharge.ordersummary.f.c cVar2 = this.f64305b;
                if (cVar2 != null) {
                    String str = ((e) cVar2).f64295g;
                    if (str != null) {
                        return str;
                    }
                    String string2 = context.getString(R.string.bill_payment);
                    k.a((Object) string2, "context.getString(R.string.bill_payment)");
                    return string2;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
            }
        }
        a aVar2 = this.f64304a;
        if (!TextUtils.isEmpty(String.valueOf((aVar2 == null || (e2 = aVar2.e(context, u)) == null) ? null : e2.getFirst()))) {
            String string3 = context.getString(R.string.v8_os_meter_recharge);
            k.a((Object) string3, "context.getString(R.string.v8_os_meter_recharge)");
            return string3;
        }
        String string4 = context.getString(R.string.bill_payment);
        k.a((Object) string4, "context.getString(R.string.bill_payment)");
        return string4;
    }

    public final List<String> f(Context context) {
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
        List<String> asList = Arrays.asList(new String[]{context.getString(R.string.v8_os_cancel_bottom_sheet_message, new Object[]{b2})});
        k.a((Object) asList, "Arrays.asList(context.ge…_sheet_message, payType))");
        return asList;
    }

    public SpannableString S(Context context) {
        o<String, String> e2;
        k.c(context, "context");
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        if (aVar.k.size() > 1) {
            a aVar2 = this.f64304a;
            if (aVar2 == null) {
                k.a();
            }
            if (!aVar2.f64002f) {
                return new SpannableString(context.getString(R.string.v8_os_order_journey_payment_received_title));
            }
        }
        a aVar3 = this.f64304a;
        if (aVar3 == null) {
            k.a();
        }
        CJROrderedCart u = aVar3.u();
        if (u == null) {
            k.a();
        }
        CJROrderSummaryProductDetail productDetail = u.getProductDetail();
        long categoryId = productDetail != null ? productDetail.getCategoryId() : -1;
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        if (net.one97.paytm.recharge.di.helper.c.h().contains(Long.valueOf(categoryId))) {
            return new SpannableString(context.getString(R.string.v8_os_pre_processing_operator_received_title, new Object[]{context.getString(R.string.v8_os_lpg_payment)}));
        } else if (ba.f61546h == categoryId || ba.f61547i == categoryId || ba.j == categoryId) {
            a aVar4 = this.f64304a;
            if (!TextUtils.isEmpty(String.valueOf((aVar4 == null || (e2 = aVar4.e(context, u)) == null) ? null : e2.getFirst()))) {
                return new SpannableString(context.getString(R.string.v8_os_pre_processing_operator_received_title, new Object[]{context.getString(R.string.v8_os_meter_recharge)}));
            }
            return new SpannableString(context.getString(R.string.v8_os_pre_processing_operator_received_title, new Object[]{context.getString(R.string.v8_os_bill_payment)}));
        } else if (c.a.C1269a.MY_PAYMENTS == this.f64288c) {
            net.one97.paytm.recharge.ordersummary.f.c cVar2 = this.f64305b;
            if (cVar2 != null) {
                int i2 = R.string.os_recharge_my_pay_order_status_success;
                Object[] objArr = new Object[1];
                String str = ((e) cVar2).f64295g;
                if (str == null) {
                    str = context.getString(R.string.v8_os_bill_payment);
                }
                objArr[0] = str;
                return new SpannableString(context.getString(i2, objArr));
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
        } else {
            net.one97.paytm.recharge.ordersummary.f.c cVar3 = this.f64305b;
            if (cVar3 != null) {
                int i3 = R.string.v8_os_pre_processing_operator_received_title;
                Object[] objArr2 = new Object[1];
                String str2 = ((e) cVar3).f64295g;
                if (str2 == null) {
                    str2 = context.getString(R.string.v8_os_bill_payment);
                }
                objArr2[0] = str2;
                return new SpannableString(context.getString(i3, objArr2));
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r4 = r1.getProductDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String R(android.content.Context r13) {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r13, r0)
            net.one97.paytm.recharge.ordersummary.f.c r0 = r12.f64305b
            if (r0 == 0) goto L_0x011d
            net.one97.paytm.recharge.ordersummary.g.e r0 = (net.one97.paytm.recharge.ordersummary.g.e) r0
            net.one97.paytm.recharge.ordersummary.b.a r1 = r12.f64304a
            r2 = 0
            if (r1 == 0) goto L_0x0015
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = r1.u()
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            java.lang.String r0 = r0.f64291c
            java.lang.String r3 = ""
            if (r0 != 0) goto L_0x001d
            r0 = r3
        L_0x001d:
            if (r1 == 0) goto L_0x002a
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r4 = r1.getProductDetail()
            if (r4 == 0) goto L_0x002a
            long r4 = r4.getCategoryId()
            goto L_0x002c
        L_0x002a:
            r4 = -1
        L_0x002c:
            long r6 = net.one97.paytm.recharge.common.utils.ba.j
            java.lang.String r8 = "context.getString(R.stri…            operatorName)"
            r9 = 0
            r10 = 1
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x005e
            if (r1 == 0) goto L_0x0048
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x0048
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x0048
            java.lang.String r2 = r1.getRechargeNumberDisplayLabel()
        L_0x0048:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x0101
            int r1 = net.one97.paytm.recharge.R.string.v8_os_water_k_no
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r2[r9] = r0
            java.lang.String r13 = r13.getString(r1, r2)
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r8)
            return r13
        L_0x005e:
            long r6 = net.one97.paytm.recharge.common.utils.ba.f61546h
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00d9
            long r6 = net.one97.paytm.recharge.common.utils.ba.f61547i
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00d9
            net.one97.paytm.recharge.di.helper.c r6 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r6 = net.one97.paytm.recharge.di.helper.c.h()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            boolean r4 = r6.contains(r4)
            if (r4 == 0) goto L_0x007b
            goto L_0x00d9
        L_0x007b:
            net.one97.paytm.recharge.ordersummary.h.c$a$a r4 = net.one97.paytm.recharge.ordersummary.h.c.a.C1269a.MY_PAYMENTS
            net.one97.paytm.recharge.ordersummary.h.c$a$a r5 = r12.f64288c
            if (r4 != r5) goto L_0x0101
            if (r1 == 0) goto L_0x0088
            java.lang.Object r0 = r1.getMetaDataResponse()
            goto L_0x0089
        L_0x0088:
            r0 = r2
        L_0x0089:
            boolean r1 = r0 instanceof java.util.Map
            if (r1 != 0) goto L_0x008e
            r0 = r2
        L_0x008e:
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x00bf
            net.one97.paytm.recharge.ordersummary.h.c$a r1 = net.one97.paytm.recharge.ordersummary.h.c.f64331a     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r1 = net.one97.paytm.recharge.ordersummary.h.c.f64336f     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00a4 }
            if (r0 != 0) goto L_0x00a2
            r2 = r3
            goto L_0x00bf
        L_0x00a2:
            r2 = r0
            goto L_0x00bf
        L_0x00a4:
            r0 = move-exception
            net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "MyPayment: user-name not received: "
            r1.<init>(r4)
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x00b5
            r0 = r3
        L_0x00b5:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r0)
        L_0x00bf:
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00d8
            int r0 = net.one97.paytm.recharge.R.string.os_recharge_number_title_my_pay
            java.lang.Object[] r1 = new java.lang.Object[r10]
            r1[r9] = r2
            java.lang.String r13 = r13.getString(r0, r1)
            java.lang.String r0 = "context.getString(R.stri…mber_title_my_pay, title)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r0)
            return r13
        L_0x00d8:
            return r3
        L_0x00d9:
            if (r1 == 0) goto L_0x00eb
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            if (r1 == 0) goto L_0x00eb
            net.one97.paytm.common.entity.recharge.CJRAttributes r1 = r1.getAttributes()
            if (r1 == 0) goto L_0x00eb
            java.lang.String r2 = r1.getRechargeNumberDisplayLabel()
        L_0x00eb:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x0101
            int r1 = net.one97.paytm.recharge.R.string.v8_os_elec_ca_no
            java.lang.Object[] r2 = new java.lang.Object[r10]
            r2[r9] = r0
            java.lang.String r13 = r13.getString(r1, r2)
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r8)
            return r13
        L_0x0101:
            r13 = r0
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x010b
            return r0
        L_0x010b:
            net.one97.paytm.recharge.ordersummary.b.a r13 = r12.f64304a
            if (r13 == 0) goto L_0x011b
            net.one97.paytm.common.entity.shopping.CJROrderedCart r13 = r13.u()
            if (r13 == 0) goto L_0x011b
            java.lang.String r13 = r13.getTitle()
            if (r13 != 0) goto L_0x011c
        L_0x011b:
            r13 = r3
        L_0x011c:
            return r13
        L_0x011d:
            kotlin.u r13 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.d.R(android.content.Context):java.lang.String");
    }

    private final String a(Context context, Object obj) {
        String str;
        CJROrderSummaryProductDetail productDetail;
        CJRAttributes attributes;
        a aVar = this.f64304a;
        String str2 = null;
        CJROrderedCart u = aVar != null ? aVar.u() : null;
        if (u == null || (productDetail = u.getProductDetail()) == null || (attributes = productDetail.getAttributes()) == null || (str = attributes.getRechargeNumberDisplayLabel()) == null) {
            str = "";
        }
        try {
            if (!(obj instanceof Map)) {
                obj = null;
            }
            Map map = (Map) obj;
            if (map != null) {
                try {
                    c.a aVar2 = c.f64331a;
                    String str3 = (String) map.get(c.f64337g);
                    str2 = str3 == null ? "" : str3;
                } catch (Exception e2) {
                    net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    StringBuilder sb = new StringBuilder("MyPayment: payment-mode not received: ");
                    String message = e2.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    sb.append(message);
                    net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2 == null) {
                    k.a();
                }
                if (p.a((CharSequence) str2, (CharSequence) "@", false)) {
                    if (!TextUtils.isEmpty(str)) {
                        return str + ' ' + str2;
                    }
                    String string = context.getString(R.string.os_recharge_number_my_pay_upi, new Object[]{str2});
                    k.a((Object) string, "context.getString(R.stri…_my_pay_upi, paymentMode)");
                    return string;
                }
            }
            if (map != null) {
                try {
                    c.a aVar3 = c.f64331a;
                    String str4 = (String) map.get(c.f64338h);
                    if (str4 == null) {
                        str2 = "";
                    } else {
                        str2 = str4;
                    }
                } catch (Exception e3) {
                    net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
                    StringBuilder sb2 = new StringBuilder("MyPayment: payment-mode not received: ");
                    String message2 = e3.getMessage();
                    if (message2 == null) {
                        message2 = "";
                    }
                    sb2.append(message2);
                    net.one97.paytm.recharge.widgets.c.d.a(sb2.toString());
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    return str + ' ' + str2;
                }
                String string2 = context.getString(R.string.os_recharge_number_my_pay_account, new Object[]{str2});
                k.a((Object) string2, "context.getString(R.stri…pay_account, paymentMode)");
                return string2;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String Q(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r8, r0)
            net.one97.paytm.recharge.ordersummary.b.a r0 = r7.f64304a
            r1 = 0
            if (r0 == 0) goto L_0x000f
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r0.u()
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            if (r0 == 0) goto L_0x001d
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()
            if (r2 == 0) goto L_0x001d
            long r2 = r2.getCategoryId()
            goto L_0x001f
        L_0x001d:
            r2 = -1
        L_0x001f:
            long r4 = net.one97.paytm.recharge.common.utils.ba.f61546h
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0081
            long r4 = net.one97.paytm.recharge.common.utils.ba.f61547i
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0081
            long r4 = net.one97.paytm.recharge.common.utils.ba.j
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0081
            net.one97.paytm.recharge.di.helper.c r4 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.util.HashSet r4 = net.one97.paytm.recharge.di.helper.c.h()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            boolean r2 = r4.contains(r2)
            if (r2 == 0) goto L_0x0042
            goto L_0x0081
        L_0x0042:
            net.one97.paytm.recharge.ordersummary.h.c$a$a r2 = net.one97.paytm.recharge.ordersummary.h.c.a.C1269a.MY_PAYMENTS
            net.one97.paytm.recharge.ordersummary.h.c$a$a r3 = r7.f64288c
            if (r2 != r3) goto L_0x0053
            if (r0 == 0) goto L_0x004e
            java.lang.Object r1 = r0.getMetaDataResponse()
        L_0x004e:
            java.lang.String r8 = r7.a(r8, r1)
            return r8
        L_0x0053:
            java.lang.String r2 = r7.R(r8)
            java.lang.String r3 = super.Q(r8)
            if (r0 == 0) goto L_0x0061
            java.lang.String r1 = r0.getTitle()
        L_0x0061:
            r0 = 1
            boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r0)
            if (r0 == 0) goto L_0x007c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x007c
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0 = 0
            boolean r0 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (boolean) r0)
            if (r0 == 0) goto L_0x007c
            java.lang.String r8 = ""
            return r8
        L_0x007c:
            java.lang.String r8 = super.Q(r8)
            return r8
        L_0x0081:
            java.lang.String r8 = super.Q(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.g.d.Q(android.content.Context):java.lang.String");
    }

    public final String c(CJROrderedCart cJROrderedCart) {
        k.c(cJROrderedCart, "orderedItem");
        a aVar = this.f64304a;
        String str = null;
        CJROrderedCart u = aVar != null ? aVar.u() : null;
        if (c.a.C1269a.MY_PAYMENTS != this.f64288c) {
            return super.c(cJROrderedCart);
        }
        Object metaDataResponse = u != null ? u.getMetaDataResponse() : null;
        if (!(metaDataResponse instanceof Map)) {
            metaDataResponse = null;
        }
        Map map = (Map) metaDataResponse;
        if (map != null) {
            try {
                c.a aVar2 = c.f64331a;
                String str2 = (String) map.get(c.f64336f);
                str = str2 == null ? "" : str2;
            } catch (Exception e2) {
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                StringBuilder sb = new StringBuilder("MyPayment: user-name not received: ");
                String message = e2.getMessage();
                if (message == null) {
                    message = "";
                }
                sb.append(message);
                net.one97.paytm.recharge.widgets.c.d.a(sb.toString());
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str == null) {
            k.a();
        }
        return str;
    }

    public SpannableString a(Context context, boolean z, CJROrderedCart cJROrderedCart, boolean z2) {
        String str;
        o<String, String> e2;
        k.c(context, "context");
        k.c(cJROrderedCart, "rechargeItem");
        a aVar = this.f64304a;
        if (aVar == null) {
            k.a();
        }
        if (aVar.k.size() <= 1) {
            a aVar2 = this.f64304a;
            if (aVar2 == null) {
                k.a();
            }
            CJROrderedCart u = aVar2.u();
            if (u == null) {
                k.a();
            }
            CJROrderSummaryProductDetail productDetail = u.getProductDetail();
            long categoryId = productDetail != null ? productDetail.getCategoryId() : -1;
            net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
            if (net.one97.paytm.recharge.di.helper.c.h().contains(Long.valueOf(categoryId))) {
                str = context.getString(R.string.v8_os_lpg_payment);
                k.a((Object) str, "context.getString(R.string.v8_os_lpg_payment)");
            } else if (ba.f61546h == categoryId || ba.f61547i == categoryId || ba.j == categoryId) {
                a aVar3 = this.f64304a;
                if (!TextUtils.isEmpty(String.valueOf((aVar3 == null || (e2 = aVar3.e(context, u)) == null) ? null : e2.getFirst()))) {
                    str = context.getString(R.string.recharge);
                    k.a((Object) str, "context.getString(R.string.recharge)");
                } else {
                    str = context.getString(R.string.v8_os_bill_payment);
                    k.a((Object) str, "context.getString(R.string.v8_os_bill_payment)");
                }
            } else if (c.a.C1269a.MY_PAYMENTS == this.f64288c) {
                net.one97.paytm.recharge.ordersummary.f.c cVar2 = this.f64305b;
                if (cVar2 != null) {
                    int i2 = R.string.os_recharge_my_pay_order_status_success;
                    Object[] objArr = new Object[1];
                    String str2 = ((e) cVar2).f64295g;
                    if (str2 == null) {
                        str2 = context.getString(R.string.v8_os_bill_payment);
                    }
                    objArr[0] = str2;
                    String string = context.getString(i2, objArr);
                    k.a((Object) string, "context.getString(R.stri…ring.v8_os_bill_payment))");
                    if (string != null) {
                        String upperCase = string.toUpperCase();
                        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        return new SpannableString(upperCase);
                    }
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
            } else {
                net.one97.paytm.recharge.ordersummary.f.c cVar3 = this.f64305b;
                if (cVar3 != null) {
                    str = ((e) cVar3).f64295g;
                    if (str == null) {
                        str = context.getString(R.string.v8_os_bill_payment);
                        k.a((Object) str, "context.getString(R.string.v8_os_bill_payment)");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
                }
            }
            String g2 = g(context, u);
            StringBuilder sb = new StringBuilder();
            String string2 = context.getString(R.string.recharge_order_status_success, new Object[]{str});
            k.a((Object) string2, "context.getString(R.stri…             paymentType)");
            if (string2 != null) {
                String upperCase2 = string2.toUpperCase();
                k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                sb.append(upperCase2);
                sb.append(" ");
                sb.append(g2);
                return new SpannableString(sb.toString());
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } else if (z2) {
            int i3 = R.string.recharge_order_status_success;
            Object[] objArr2 = new Object[1];
            a aVar4 = this.f64304a;
            if (aVar4 == null) {
                k.a();
            }
            objArr2[0] = aVar4.c(context, cJROrderedCart);
            String string3 = context.getString(i3, objArr2);
            k.a((Object) string3, "context.getString(R.stri…o(context, rechargeItem))");
            if (string3 != null) {
                String upperCase3 = string3.toUpperCase();
                k.a((Object) upperCase3, "(this as java.lang.String).toUpperCase()");
                return new SpannableString(upperCase3);
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } else {
            String h2 = h(context);
            net.one97.paytm.recharge.ordersummary.f.c cVar4 = this.f64305b;
            if (cVar4 != null) {
                String str3 = ((e) cVar4).f64295g;
                if (str3 == null) {
                    str3 = context.getString(R.string.v8_os_bill_payment);
                    k.a((Object) str3, "context.getString(R.string.v8_os_bill_payment)");
                }
                a aVar5 = this.f64304a;
                if (aVar5 == null) {
                    k.a();
                }
                if (aVar5.u() != null) {
                    a aVar6 = this.f64304a;
                    if (aVar6 == null) {
                        k.a();
                    }
                    a aVar7 = this.f64304a;
                    if (aVar7 == null) {
                        k.a();
                    }
                    CJROrderedCart u2 = aVar7.u();
                    if (u2 == null) {
                        k.a();
                    }
                    if (aVar6.b(u2)) {
                        String string4 = context.getString(R.string.v8_os_header_title_Canceled_1, new Object[]{str3});
                        k.a((Object) string4, "context.getString(R.stri…_Canceled_1, paymentType)");
                        if (string4 != null) {
                            String upperCase4 = string4.toUpperCase();
                            k.a((Object) upperCase4, "(this as java.lang.String).toUpperCase()");
                            return new SpannableString(upperCase4);
                        }
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                a aVar8 = this.f64304a;
                if (aVar8 == null) {
                    k.a();
                }
                if (!aVar8.f64002f) {
                    StringBuilder sb2 = new StringBuilder();
                    String string5 = context.getString(R.string.v8_os_order_journey_payment_received_title);
                    k.a((Object) string5, "context.getString(R.stri…y_payment_received_title)");
                    if (string5 != null) {
                        String upperCase5 = string5.toUpperCase();
                        k.a((Object) upperCase5, "(this as java.lang.String).toUpperCase()");
                        sb2.append(upperCase5);
                        sb2.append(" ");
                        sb2.append(h2);
                        return new SpannableString(sb2.toString());
                    }
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
                StringBuilder sb3 = new StringBuilder();
                String string6 = context.getString(R.string.recharge_order_status_success, new Object[]{str3});
                k.a((Object) string6, "context.getString(R.stri…             paymentType)");
                if (string6 != null) {
                    String upperCase6 = string6.toUpperCase();
                    k.a((Object) upperCase6, "(this as java.lang.String).toUpperCase()");
                    sb3.append(upperCase6);
                    sb3.append(" ");
                    sb3.append(h2);
                    return new SpannableString(sb3.toString());
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.presenter.CJRFailedPendingTextSource");
        }
    }

    public final ArrayList<o<String, String>> j(Context context) {
        List<CJROrderedCart> list;
        List list2;
        k.c(context, "context");
        a aVar = this.f64304a;
        ArrayList<o<String, String>> arrayList = null;
        if (aVar == null || (list2 = aVar.k) == null || list2.size() != 1) {
            a aVar2 = this.f64304a;
            if (!(aVar2 == null || (list = aVar2.k) == null)) {
                for (CJROrderedCart cJROrderedCart : list) {
                    if (k.a((Object) cJROrderedCart.getItemStatus(), (Object) "7")) {
                        o<String, String> e2 = e(context, cJROrderedCart);
                        if (!TextUtils.isEmpty(e2.getFirst())) {
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            if (TextUtils.isEmpty(e2.getSecond())) {
                                String first = e2.getFirst();
                                int i2 = R.string.v8_os_purchased_recharge_code;
                                Object[] objArr = new Object[1];
                                a aVar3 = this.f64304a;
                                if (aVar3 == null) {
                                    k.a();
                                }
                                objArr[0] = aVar3.c(context, cJROrderedCart);
                                String string = context.getString(i2, objArr);
                                k.a((Object) string, "context.getString(R.stri…xDetailInfo(context, it))");
                                e2 = e2.copy(first, string);
                            }
                            if (arrayList == null) {
                                k.a();
                            }
                            arrayList.add(e2);
                        }
                    }
                }
            }
            return arrayList;
        }
        a aVar4 = this.f64304a;
        CJROrderedCart u = aVar4 != null ? aVar4.u() : null;
        if (u == null) {
            k.a();
        }
        o<String, String> e3 = e(context, u);
        if (!TextUtils.isEmpty(e3.getFirst())) {
            arrayList = new ArrayList<>();
            if (TextUtils.isEmpty(e3.getSecond())) {
                String first2 = e3.getFirst();
                String string2 = context.getString(R.string.v8_os_meter_recharge_code);
                k.a((Object) string2, "context.getString(R.stri…8_os_meter_recharge_code)");
                e3 = e3.copy(first2, string2);
            }
            arrayList.add(e3);
        }
        return arrayList;
    }
}
