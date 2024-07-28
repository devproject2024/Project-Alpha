package net.one97.paytm.recharge.common.utils;

import com.paytm.utility.q;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.recharge.model.CJRCheckoutRequestModel;
import org.json.JSONObject;

public final class aw {

    /* renamed from: a  reason: collision with root package name */
    public static final aw f61520a = new aw();

    private aw() {
    }

    public static /* synthetic */ CJRCheckoutRequestModel a(CJRRechargeCart cJRRechargeCart, String str, String str2, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return a(cJRRechargeCart, str, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: net.one97.paytm.common.entity.shopping.CJRCartProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: net.one97.paytm.common.entity.shopping.CJRCartProduct} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.recharge.model.CJRCheckoutRequestModel a(net.one97.paytm.common.entity.CJRRechargeCart r17, java.lang.String r18, java.lang.String r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "rechargeCart"
            r3 = r17
            kotlin.g.b.k.c(r3, r2)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            net.one97.paytm.common.entity.shopping.CJRCart r6 = r17.getCart()     // Catch:{ Exception -> 0x01aa }
            r7 = 1
            if (r6 == 0) goto L_0x00fa
            java.util.ArrayList r6 = r6.getCartItems()     // Catch:{ Exception -> 0x01aa }
            if (r6 == 0) goto L_0x00fa
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x01aa }
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x01aa }
            r6 = r6 ^ r7
            if (r6 != r7) goto L_0x00fa
            net.one97.paytm.common.entity.shopping.CJRCart r6 = r17.getCart()     // Catch:{ Exception -> 0x01aa }
            if (r6 == 0) goto L_0x0036
            java.util.ArrayList r6 = r6.getCartItems()     // Catch:{ Exception -> 0x01aa }
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            if (r6 != 0) goto L_0x003c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01aa }
        L_0x003c:
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x01aa }
            r8 = 0
            r9 = 0
        L_0x0042:
            boolean r10 = r6.hasNext()     // Catch:{ Exception -> 0x00f6 }
            if (r10 == 0) goto L_0x00f4
            java.lang.Object r10 = r6.next()     // Catch:{ Exception -> 0x00f6 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r10 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r10     // Catch:{ Exception -> 0x00f6 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f6 }
            r11.<init>()     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r12 = "product_id"
            java.lang.String r13 = "cartProduct"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r13)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r13 = r10.getProductId()     // Catch:{ Exception -> 0x00f6 }
            r11.put(r12, r13)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r12 = "qty"
            java.lang.String r13 = r10.getQuantity()     // Catch:{ Exception -> 0x00f6 }
            r11.put(r12, r13)     // Catch:{ Exception -> 0x00f6 }
            java.util.Map r12 = r10.getConfigurationList()     // Catch:{ Exception -> 0x00f6 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f6 }
            r13.<init>()     // Catch:{ Exception -> 0x00f6 }
            if (r12 == 0) goto L_0x00b6
            java.util.Set r14 = r12.keySet()     // Catch:{ Exception -> 0x00f6 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x00f6 }
        L_0x007d:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x00f6 }
            if (r15 == 0) goto L_0x00b6
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x00f6 }
            if (r15 == 0) goto L_0x00aa
            java.lang.String r5 = "recharge_number"
            boolean r5 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r5, (boolean) r7)     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x00aa
            java.lang.Object r5 = r12.get(r15)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f6 }
            r8 = r0
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x01a8 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x01a8 }
            if (r8 != 0) goto L_0x00a9
            java.lang.String r8 = "UTF-8"
            java.lang.String r8 = java.net.URLEncoder.encode(r0, r8)     // Catch:{ Exception -> 0x01a8 }
            r9 = r8
        L_0x00a9:
            r8 = r5
        L_0x00aa:
            java.lang.Object r5 = r12.get(r15)     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00f6 }
            r13.put(r15, r5)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x007d
        L_0x00b6:
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00f6 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x00f6 }
            if (r5 != 0) goto L_0x00c4
            java.lang.String r5 = "bank_promocode"
            r11.put(r5, r1)     // Catch:{ Exception -> 0x00f6 }
        L_0x00c4:
            java.lang.String r5 = "configuration"
            r11.put(r5, r13)     // Catch:{ Exception -> 0x00f6 }
            java.lang.Object r5 = r10.getMetaDataResponse()     // Catch:{ Exception -> 0x00f6 }
            if (r5 == 0) goto L_0x00ef
            com.google.gson.f r5 = new com.google.gson.f     // Catch:{ Exception -> 0x00f6 }
            r5.<init>()     // Catch:{ Exception -> 0x00f6 }
            java.lang.Object r10 = r10.getMetaDataResponse()     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r5 = r5.b(r10)     // Catch:{ Exception -> 0x00f6 }
            r10 = r5
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x00f6 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00f6 }
            if (r10 != 0) goto L_0x00ef
            java.lang.String r10 = "meta_data"
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x00f6 }
            r12.<init>(r5)     // Catch:{ Exception -> 0x00f6 }
            r11.put(r10, r12)     // Catch:{ Exception -> 0x00f6 }
        L_0x00ef:
            r4.put(r11)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x0042
        L_0x00f4:
            r5 = r8
            goto L_0x00fc
        L_0x00f6:
            r0 = move-exception
            r5 = r8
            goto L_0x01ad
        L_0x00fa:
            r5 = 0
            r9 = 0
        L_0x00fc:
            java.lang.String r0 = "cart_items"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r0 = "SUCCESS"
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r17.getCart()     // Catch:{ Exception -> 0x01a8 }
            if (r1 == 0) goto L_0x010e
            java.lang.String r1 = r1.getmPromoStatus()     // Catch:{ Exception -> 0x01a8 }
            goto L_0x010f
        L_0x010e:
            r1 = 0
        L_0x010f:
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r7)     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x0160
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r17.getCart()     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x0154
            java.util.ArrayList r0 = r0.getCartItems()     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x0154
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x01a8 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01a8 }
        L_0x0127:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x01a8 }
            if (r1 == 0) goto L_0x014a
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x01a8 }
            r4 = r1
            net.one97.paytm.common.entity.shopping.CJRCartProduct r4 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r4     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r6 = "it"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r4 = r4.getPromoCode()     // Catch:{ Exception -> 0x01a8 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01a8 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01a8 }
            r4 = r4 ^ r7
            if (r4 == 0) goto L_0x0127
            r0 = r1
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0     // Catch:{ Exception -> 0x01a8 }
            goto L_0x0155
        L_0x014a:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException     // Catch:{ Exception -> 0x01a8 }
            java.lang.String r1 = "Collection contains no element matching the predicate."
            r0.<init>(r1)     // Catch:{ Exception -> 0x01a8 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x01a8 }
            throw r0     // Catch:{ Exception -> 0x01a8 }
        L_0x0154:
            r0 = 0
        L_0x0155:
            if (r0 == 0) goto L_0x0160
            java.lang.String r1 = "promocode"
            java.lang.String r0 = r0.getPromoCode()     // Catch:{ Exception -> 0x01a8 }
            r2.put(r1, r0)     // Catch:{ Exception -> 0x01a8 }
        L_0x0160:
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r17.getCart()     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x018b
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r17.getCart()     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x0171
            java.lang.String r0 = r0.getPaymentMethod()     // Catch:{ Exception -> 0x01a8 }
            goto L_0x0172
        L_0x0171:
            r0 = 0
        L_0x0172:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x01a8 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01a8 }
            if (r0 != 0) goto L_0x018b
            java.lang.String r0 = "payment_method"
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r17.getCart()     // Catch:{ Exception -> 0x01a8 }
            if (r1 == 0) goto L_0x0187
            java.lang.String r1 = r1.getPaymentMethod()     // Catch:{ Exception -> 0x01a8 }
            goto L_0x0188
        L_0x0187:
            r1 = 0
        L_0x0188:
            r2.put(r0, r1)     // Catch:{ Exception -> 0x01a8 }
        L_0x018b:
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r17.getCart()     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x0198
            net.one97.paytm.common.entity.shopping.CJRAddress r0 = r0.getAddress()     // Catch:{ Exception -> 0x01a8 }
            r16 = r0
            goto L_0x019a
        L_0x0198:
            r16 = 0
        L_0x019a:
            if (r16 == 0) goto L_0x01b4
            org.json.JSONObject r0 = a(r16)     // Catch:{ Exception -> 0x01a8 }
            if (r0 == 0) goto L_0x01b4
            java.lang.String r1 = "address"
            r2.put(r1, r0)     // Catch:{ Exception -> 0x01a8 }
            goto L_0x01b4
        L_0x01a8:
            r0 = move-exception
            goto L_0x01ad
        L_0x01aa:
            r0 = move-exception
            r5 = 0
            r9 = 0
        L_0x01ad:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x01b4:
            net.one97.paytm.recharge.model.CJRCheckoutRequestModel r0 = new net.one97.paytm.recharge.model.CJRCheckoutRequestModel
            r0.<init>(r2, r5, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.aw.a(net.one97.paytm.common.entity.CJRRechargeCart, java.lang.String, java.lang.String):net.one97.paytm.recharge.model.CJRCheckoutRequestModel");
    }

    public static JSONObject a(CJRAddress cJRAddress) {
        if (cJRAddress == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", cJRAddress.getName());
            jSONObject.put("city", cJRAddress.getCity());
            jSONObject.put("state", cJRAddress.getState());
            jSONObject.put("pin", cJRAddress.getPin());
            jSONObject.put("mobile", cJRAddress.getMobile());
            jSONObject.put("address1", cJRAddress.getAddress1());
            jSONObject.put("address2", cJRAddress.getAddress2());
            return jSONObject;
        } catch (Exception e2) {
            q.d(e2.getMessage());
            return null;
        }
    }
}
