package net.one97.paytm.recharge.ordersummary.h;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.insurance.FulFillmentRequest;
import net.one97.paytm.common.entity.shopping.CJROrderItemProduct;
import net.one97.paytm.common.entity.shopping.CJROrderItems;
import net.one97.paytm.common.entity.shopping.CJROrderList;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.h.b;
import net.one97.paytm.recharge.widgets.c.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64331a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static int f64332b = 500;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int f64333c = 409;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int f64334d = 2;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap<String, net.one97.paytm.recharge.ordersummary.b.a> f64335e = new HashMap<>(1);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f64336f = "username";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String f64337g = f64337g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f64338h = f64338h;

    public static final class a {

        /* renamed from: net.one97.paytm.recharge.ordersummary.h.c$a$a  reason: collision with other inner class name */
        public enum C1269a {
            MY_PAYMENTS
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0097 A[SYNTHETIC, Splitter:B:30:0x0097] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00c1 A[SYNTHETIC, Splitter:B:42:0x00c1] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0128 A[Catch:{ Exception -> 0x01db }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0168 A[Catch:{ Exception -> 0x01db }] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x016b A[Catch:{ Exception -> 0x01db }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x016d A[Catch:{ Exception -> 0x01db }] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01d0 A[Catch:{ Exception -> 0x01db }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(android.app.Activity r16, net.one97.paytm.common.entity.shopping.CJROrderSummary r17) {
            /*
                r0 = r16
                r1 = r17
                java.lang.String r2 = "orderSummary"
                java.lang.String r3 = "activity"
                kotlin.g.b.k.c(r0, r3)
                java.lang.String r4 = "dataModel"
                kotlin.g.b.k.c(r1, r4)
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r5 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "handleOnResponse: activity:"
                r6.<init>(r7)
                java.lang.String r7 = r16.getLocalClassName()
                r6.append(r7)
                java.lang.String r7 = " order:"
                r6.append(r7)
                java.lang.String r7 = r17.getId()
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                r5.debugLog(r6)
                net.one97.paytm.recharge.common.utils.y r5 = net.one97.paytm.recharge.common.utils.y.f61814b
                net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r17)
                r5 = 0
                r6 = 0
                java.util.ArrayList r7 = r17.getOrderedCartList()     // Catch:{ Exception -> 0x01db }
                java.lang.Object r7 = r7.get(r6)     // Catch:{ Exception -> 0x01db }
                java.lang.String r8 = "dataModel.orderedCartList[0]"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x01db }
                net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r7     // Catch:{ Exception -> 0x01db }
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r7.getProductDetail()     // Catch:{ Exception -> 0x01db }
                if (r7 == 0) goto L_0x0055
                java.lang.String r8 = r7.getVertical()     // Catch:{ Exception -> 0x01db }
                if (r8 != 0) goto L_0x0057
            L_0x0055:
                java.lang.String r8 = ""
            L_0x0057:
                if (r7 == 0) goto L_0x005c
                r7.getVerticalId()     // Catch:{ Exception -> 0x01db }
            L_0x005c:
                r9 = 0
                if (r7 == 0) goto L_0x0065
                long r11 = r7.getId()     // Catch:{ Exception -> 0x01db }
                goto L_0x0066
            L_0x0065:
                r11 = r9
            L_0x0066:
                if (r7 == 0) goto L_0x006c
                long r9 = r7.getCategoryId()     // Catch:{ Exception -> 0x01db }
            L_0x006c:
                android.content.Intent r7 = r16.getIntent()     // Catch:{ Exception -> 0x01db }
                java.lang.String r13 = "order_id"
                if (r7 == 0) goto L_0x007f
                android.os.Bundle r7 = r7.getExtras()     // Catch:{ Exception -> 0x01db }
                if (r7 == 0) goto L_0x007f
                java.lang.String r7 = r7.getString(r13, r5)     // Catch:{ Exception -> 0x01db }
                goto L_0x0080
            L_0x007f:
                r7 = r5
            L_0x0080:
                if (r7 != 0) goto L_0x008f
                android.content.Intent r7 = r16.getIntent()     // Catch:{ Exception -> 0x01db }
                if (r7 == 0) goto L_0x008f
                java.lang.String r14 = r17.getId()     // Catch:{ Exception -> 0x01db }
                r7.putExtra(r13, r14)     // Catch:{ Exception -> 0x01db }
            L_0x008f:
                android.content.Intent r7 = r16.getIntent()     // Catch:{ Exception -> 0x01db }
                java.lang.String r14 = "From"
                if (r7 == 0) goto L_0x00a2
                android.os.Bundle r7 = r7.getExtras()     // Catch:{ Exception -> 0x01db }
                if (r7 == 0) goto L_0x00a2
                java.lang.String r7 = r7.getString(r14, r5)     // Catch:{ Exception -> 0x01db }
                goto L_0x00a3
            L_0x00a2:
                r7 = r5
            L_0x00a3:
                if (r7 != 0) goto L_0x00b0
                android.content.Intent r7 = r16.getIntent()     // Catch:{ Exception -> 0x01db }
                if (r7 == 0) goto L_0x00b0
                java.lang.String r15 = "Order_history"
                r7.putExtra(r14, r15)     // Catch:{ Exception -> 0x01db }
            L_0x00b0:
                r7 = r0
                android.content.Context r7 = (android.content.Context) r7     // Catch:{ Exception -> 0x01db }
                java.lang.String r14 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x01db }
                boolean r7 = net.one97.paytm.recharge.common.utils.g.a((android.content.Context) r7, (java.lang.String) r14)     // Catch:{ Exception -> 0x01db }
                r14 = 536870912(0x20000000, float:1.0842022E-19)
                java.lang.String r15 = "Order_summary"
                if (r7 != 0) goto L_0x019c
                net.one97.paytm.recharge.di.helper.c r7 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x01db }
                java.util.HashSet r7 = net.one97.paytm.recharge.di.helper.c.n()     // Catch:{ Exception -> 0x01db }
                java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x01db }
                boolean r5 = r7.contains(r5)     // Catch:{ Exception -> 0x01db }
                if (r5 == 0) goto L_0x00d3
                goto L_0x019c
            L_0x00d3:
                net.one97.paytm.recharge.metro.f.c$a r4 = net.one97.paytm.recharge.metro.f.c.f63576a     // Catch:{ Exception -> 0x01db }
                kotlin.g.b.k.c(r0, r3)     // Catch:{ Exception -> 0x01db }
                kotlin.g.b.k.c(r1, r2)     // Catch:{ Exception -> 0x01db }
                net.one97.paytm.recharge.metro.f.c$a r3 = net.one97.paytm.recharge.metro.f.c.f63576a     // Catch:{ Exception -> 0x01db }
                kotlin.g.b.k.c(r1, r2)     // Catch:{ Exception -> 0x01db }
                java.util.ArrayList r2 = r17.getOrderedCartList()     // Catch:{ Exception -> 0x01db }
                if (r2 == 0) goto L_0x00ff
                java.lang.Object r2 = r2.get(r6)     // Catch:{ Exception -> 0x01db }
                net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ Exception -> 0x01db }
                if (r2 == 0) goto L_0x00ff
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()     // Catch:{ Exception -> 0x01db }
                if (r2 == 0) goto L_0x00ff
                net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()     // Catch:{ Exception -> 0x01db }
                if (r2 == 0) goto L_0x00ff
                boolean r2 = r2.isMetroQrTicketFLow()     // Catch:{ Exception -> 0x01db }
                goto L_0x0100
            L_0x00ff:
                r2 = 0
            L_0x0100:
                if (r2 != 0) goto L_0x0125
                net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x01db }
                java.util.HashSet r2 = net.one97.paytm.recharge.di.helper.c.aI()     // Catch:{ Exception -> 0x01db }
                java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x01db }
                boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x01db }
                if (r2 != 0) goto L_0x0125
                net.one97.paytm.recharge.di.helper.c r2 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x01db }
                java.util.HashSet r2 = net.one97.paytm.recharge.di.helper.c.aJ()     // Catch:{ Exception -> 0x01db }
                java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x01db }
                boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x01db }
                if (r2 == 0) goto L_0x0123
                goto L_0x0125
            L_0x0123:
                r2 = 0
                goto L_0x0126
            L_0x0125:
                r2 = 1
            L_0x0126:
                if (r2 == 0) goto L_0x0168
                android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x01db }
                r3 = r0
                android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x01db }
                java.lang.Class<net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity> r4 = net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity.class
                r2.<init>(r3, r4)     // Catch:{ Exception -> 0x01db }
                r3 = r1
                java.io.Serializable r3 = (java.io.Serializable) r3     // Catch:{ Exception -> 0x01db }
                android.content.Intent r2 = r2.putExtra(r15, r3)     // Catch:{ Exception -> 0x01db }
                java.lang.String r3 = "Intent(activity,\n       …ER_SUMMARY, orderSummary)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x01db }
                android.content.Intent r3 = r16.getIntent()     // Catch:{ Exception -> 0x01db }
                if (r3 == 0) goto L_0x0149
                android.os.Bundle r5 = r3.getExtras()     // Catch:{ Exception -> 0x01db }
                goto L_0x014a
            L_0x0149:
                r5 = 0
            L_0x014a:
                if (r5 == 0) goto L_0x0160
                android.content.Intent r3 = r16.getIntent()     // Catch:{ Exception -> 0x01db }
                if (r3 == 0) goto L_0x0157
                android.os.Bundle r5 = r3.getExtras()     // Catch:{ Exception -> 0x01db }
                goto L_0x0158
            L_0x0157:
                r5 = 0
            L_0x0158:
                if (r5 != 0) goto L_0x015d
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01db }
            L_0x015d:
                r2.putExtras(r5)     // Catch:{ Exception -> 0x01db }
            L_0x0160:
                r2.addFlags(r14)     // Catch:{ Exception -> 0x01db }
                r0.startActivity(r2)     // Catch:{ Exception -> 0x01db }
                r2 = 1
                goto L_0x0169
            L_0x0168:
                r2 = 0
            L_0x0169:
                if (r2 == 0) goto L_0x016d
                r2 = 1
                return r2
            L_0x016d:
                r2 = 1
                java.lang.String r3 = "Unreserved Bus Ticketing"
                boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r8, (boolean) r2)     // Catch:{ Exception -> 0x01db }
                if (r3 == 0) goto L_0x0189
                android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x01db }
                r2.<init>()     // Catch:{ Exception -> 0x01db }
                java.lang.String r3 = r17.getId()     // Catch:{ Exception -> 0x01db }
                r2.putExtra(r13, r3)     // Catch:{ Exception -> 0x01db }
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r3 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE     // Catch:{ Exception -> 0x01db }
                r3.startBCLLSuccessBookingActivity(r0, r2, r6)     // Catch:{ Exception -> 0x01db }
                r0 = 1
                return r0
            L_0x0189:
                java.lang.String r2 = "Tourist Bus"
                r3 = 1
                boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r3)     // Catch:{ Exception -> 0x01db }
                if (r2 == 0) goto L_0x01ff
                net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r2 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE     // Catch:{ Exception -> 0x01db }
                java.lang.String r4 = r17.getId()     // Catch:{ Exception -> 0x01db }
                r2.openHoHoPaymentSuccessActivity(r0, r4)     // Catch:{ Exception -> 0x01db }
                return r3
            L_0x019c:
                java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x01db }
                kotlin.g.b.k.c(r0, r3)     // Catch:{ Exception -> 0x01db }
                java.lang.String r3 = "categoryId"
                kotlin.g.b.k.c(r2, r3)     // Catch:{ Exception -> 0x01db }
                kotlin.g.b.k.c(r1, r4)     // Catch:{ Exception -> 0x01db }
                android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x01db }
                r3 = r0
                android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x01db }
                java.lang.Class<net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity> r4 = net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity.class
                r2.<init>(r3, r4)     // Catch:{ Exception -> 0x01db }
                r3 = r1
                java.io.Serializable r3 = (java.io.Serializable) r3     // Catch:{ Exception -> 0x01db }
                android.content.Intent r2 = r2.putExtra(r15, r3)     // Catch:{ Exception -> 0x01db }
                java.lang.String r3 = "Intent(activity, AJRecha…ORDER_SUMMARY, dataModel)"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x01db }
                android.content.Intent r3 = r16.getIntent()     // Catch:{ Exception -> 0x01db }
                java.lang.String r4 = "activity.intent"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x01db }
                android.os.Bundle r3 = r3.getExtras()     // Catch:{ Exception -> 0x01db }
                if (r3 == 0) goto L_0x01d3
                r2.putExtras(r3)     // Catch:{ Exception -> 0x01db }
            L_0x01d3:
                r2.addFlags(r14)     // Catch:{ Exception -> 0x01db }
                r0.startActivity(r2)     // Catch:{ Exception -> 0x01db }
                r0 = 1
                return r0
            L_0x01db:
                r0 = move-exception
                net.one97.paytm.recharge.widgets.c.d r2 = net.one97.paytm.recharge.widgets.c.d.f64967a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "Unable to load order "
                r2.<init>(r3)
                java.lang.String r1 = r17.getId()
                r2.append(r1)
                java.lang.String r1 = " in recharge vertical -> redirected to legacy"
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r1)
                net.one97.paytm.recharge.widgets.c.d r1 = net.one97.paytm.recharge.widgets.c.d.f64967a
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                net.one97.paytm.recharge.widgets.c.d.a((java.lang.Throwable) r0)
            L_0x01ff:
                net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b
                r1 = 0
                net.one97.paytm.recharge.common.utils.y.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.h.c.a.a(android.app.Activity, net.one97.paytm.common.entity.shopping.CJROrderSummary):boolean");
        }

        public static final class b<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                CJRTransactionDetails cJRTransactionDetails = (CJRTransactionDetails) t2;
                k.a((Object) cJRTransactionDetails, "it");
                boolean z = true;
                Comparable valueOf = Boolean.valueOf(p.a(cJRTransactionDetails.getPayment_mode(), "Paytm Wallet", true) || p.a("BALANCE", cJRTransactionDetails.getPayMethod(), true));
                CJRTransactionDetails cJRTransactionDetails2 = (CJRTransactionDetails) t;
                k.a((Object) cJRTransactionDetails2, "it");
                if (!p.a(cJRTransactionDetails2.getPayment_mode(), "Paytm Wallet", true) && !p.a("BALANCE", cJRTransactionDetails2.getPayMethod(), true)) {
                    z = false;
                }
                return kotlin.b.a.a(valueOf, Boolean.valueOf(z));
            }
        }

        public static String a(long j, String str) {
            k.c(str, "itemStatus");
            String str2 = "version_identifier=1&category_id=" + j + "&fulfillment_status=" + str;
            k.a((Object) str2, "StringBuilder()\n        …              .toString()");
            return str2;
        }

        private static String a(int i2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CLPConstants.PRODUCT_ID, "DEFAULT");
                jSONObject.put("in_status", String.valueOf(i2));
            } catch (JSONException e2) {
                q.d(e2.getMessage());
                CJRRechargeUtilities.INSTANCE.debugLog("Unable to create getV2DefaultPostActionsAPIBody");
            }
            String jSONObject2 = jSONObject.toString();
            k.a((Object) jSONObject2, "json.toString()");
            return jSONObject2;
        }

        public static /* synthetic */ void a(String str, Context context, CJROrderSummary cJROrderSummary, boolean z, ai aiVar, Object obj) {
            b.a aVar = b.f64312h;
            a(str, context, cJROrderSummary, aiVar, obj, b.a.a(context, z));
        }

        private static void a(String str, Context context, CJROrderSummary cJROrderSummary, ai aiVar, Object obj, b bVar) {
            k.c(str, "tag");
            k.c(context, "context");
            k.c(cJROrderSummary, "orderSummary");
            k.c(aiVar, "responseListener");
            if (bVar != null) {
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                bVar.a(str, "POST", net.one97.paytm.recharge.di.helper.c.bq(), a(cJROrderSummary.getOrderStatus()), aiVar, new CJROSActionResponseV2(), obj);
            }
        }

        public static String a(String str) {
            d dVar = d.f64967a;
            return d.b(str);
        }

        public final String a(JSONObject jSONObject, String str) {
            k.c(jSONObject, "jsonObject");
            k.c(str, "key");
            try {
                String optString = jSONObject.optString(str, "");
                k.a((Object) optString, "jsonObject.optString(key, \"\")");
                try {
                    if (!TextUtils.isEmpty(optString)) {
                        return optString;
                    }
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                            k.a((Object) jSONObject2, "innerJsonObject");
                            optString = a(jSONObject2, str);
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    return optString;
                } catch (Exception unused) {
                    return optString;
                }
            } catch (Exception unused2) {
                return "";
            }
        }

        public static long a(CJROrderList cJROrderList) {
            k.c(cJROrderList, "orderList");
            try {
                CJROrderItems cJROrderItems = cJROrderList.getOrderItems().get(0);
                k.a((Object) cJROrderItems, "orderList.orderItems[0]");
                CJROrderItemProduct product = cJROrderItems.getProduct();
                k.a((Object) product, "orderItemProduct");
                String verticalLabel = product.getVerticalLabel();
                long verticalId = product.getVerticalId();
                if (p.a("Insurance", verticalLabel, true)) {
                    Iterator<CJROrderItems> it2 = cJROrderList.getOrderItems().iterator();
                    while (it2.hasNext()) {
                        CJROrderItems next = it2.next();
                        k.a((Object) next, "cartItem");
                        CJROrderItemProduct product2 = next.getProduct();
                        k.a((Object) product2, "cartItem.product");
                        String verticalLabel2 = product2.getVerticalLabel();
                        CJROrderItemProduct product3 = next.getProduct();
                        k.a((Object) product3, "cartItem.product");
                        long verticalId2 = product3.getVerticalId();
                        if (!p.a("Insurance", verticalLabel2, true)) {
                            return verticalId2;
                        }
                    }
                }
                return verticalId;
            } catch (Exception e2) {
                q.d(e2.getMessage());
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog("Unable to getVerticalId : " + e2.getMessage());
                return -1;
            }
        }

        public static long b(CJROrderList cJROrderList) {
            k.c(cJROrderList, "orderList");
            try {
                FulFillmentRequest fulFillmentRequest = cJROrderList.getOrderItems().get(0).getmFulFillmentReq();
                k.a((Object) fulFillmentRequest, "fulfillmentReq");
                String categoryId = fulFillmentRequest.getCategoryId();
                if (TextUtils.isEmpty(categoryId)) {
                    return -1;
                }
                k.a((Object) categoryId, "categoryId");
                return Long.parseLong(categoryId);
            } catch (Exception e2) {
                q.d(e2.getMessage());
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog("Unable to getVerticalId : " + e2.getMessage());
                return -1;
            }
        }

        public static SpannableString a(String str, String str2) {
            int a2;
            k.c(str, "postActionMsg");
            k.c(str2, "paymentReferenceNo");
            CharSequence charSequence = str;
            SpannableString spannableString = new SpannableString(charSequence);
            CharSequence charSequence2 = str2;
            if (!TextUtils.isEmpty(charSequence2) && p.a(charSequence, charSequence2, false) && (a2 = p.a(charSequence, str2, 0, false, 6)) != -1) {
                spannableString.setSpan(new StyleSpan(1), a2, str2.length() + a2, 33);
            }
            return spannableString;
        }

        public static void a(CJRRefund cJRRefund) {
            k.c(cJRRefund, "refund");
            ArrayList<CJRTransactionDetails> transactionDetails = cJRRefund.getTransactionDetails();
            k.a((Object) transactionDetails, "transactionDetail");
            List a2 = kotlin.a.k.a(transactionDetails, new b());
            cJRRefund.getTransactionDetails().clear();
            cJRRefund.getTransactionDetails().addAll(a2);
        }
    }
}
