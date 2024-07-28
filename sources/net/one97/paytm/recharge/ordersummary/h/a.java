package net.one97.paytm.recharge.ordersummary.h;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJRCartStatus;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class a implements ai {

    /* renamed from: a  reason: collision with root package name */
    public C1266a f64307a;

    /* renamed from: b  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a f64308b;

    /* renamed from: c  reason: collision with root package name */
    private final AJRechargeOrderSummaryActivity f64309c;

    /* renamed from: net.one97.paytm.recharge.ordersummary.h.a$a  reason: collision with other inner class name */
    public interface C1266a {
        void au_();

        void av_();
    }

    public a(net.one97.paytm.recharge.ordersummary.b.a aVar, AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity) {
        k.c(aVar, "viewModel");
        k.c(aJRechargeOrderSummaryActivity, "mBaseActivity");
        this.f64308b = aVar;
        this.f64309c = aJRechargeOrderSummaryActivity;
    }

    private final void a(String str, String str2, String str3, boolean z, boolean z2, Map<String, String> map) {
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        StringBuilder sb = new StringBuilder("paytmmp://" + str + "?url=" + str2);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("$title=".concat(String.valueOf(str3)));
            k.a((Object) sb, "urlBuilder.append(\"\\$title=$title\")");
        }
        if (z) {
            for (Map.Entry next : map.entrySet()) {
                String str4 = (String) next.getKey();
                String str5 = (String) next.getValue();
                if (!p.a("price", str4, true) || z2) {
                    sb.append(AppConstants.AND_SIGN + str4 + '=' + str5);
                    k.a((Object) sb, "urlBuilder.append(\"&$key=$value\")");
                }
            }
        }
        cJRHomePageItem.setUrlType(str);
        cJRHomePageItem.setUrl(new String(sb));
        a(str, cJRHomePageItem);
    }

    public final void a(String str, CJRHomePageItem cJRHomePageItem) {
        k.c(cJRHomePageItem, "homePageItem");
        C1266a aVar = this.f64307a;
        if (aVar != null) {
            aVar.au_();
        }
        try {
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            Context applicationContext = this.f64309c.getApplicationContext();
            k.a((Object) applicationContext, "mBaseActivity.applicationContext");
            cJRRechargeUtilities.loadPage(applicationContext, str, cJRHomePageItem, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null);
        } catch (Exception e2) {
            CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities2.debugLog("Unable to handle repeat-retry : " + e2.getMessage());
            if (this.f64307a == null) {
                this.f64309c.c(true);
            }
        }
        this.f64309c.o();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0058, code lost:
        if (kotlin.m.p.a(r5, (java.lang.CharSequence) "buyInsuranceEnabled", false) != false) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01eb A[Catch:{ Exception -> 0x01f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0209 A[Catch:{ Exception -> 0x0333 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.shopping.CJROrderedCart r22, boolean r23, boolean r24) {
        /*
            r21 = this;
            r8 = r21
            java.lang.String r0 = "orderedCart"
            r1 = r22
            kotlin.g.b.k.c(r1, r0)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r0 = r8.f64309c
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.recharge.R.string.please_wait
            java.lang.String r3 = r0.getString(r3)
            r0.a((android.content.Context) r2, (java.lang.String) r3)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r22.getProductDetail()
            if (r2 == 0) goto L_0x0382
            long r3 = r2.getCategoryId()
            long r3 = net.one97.paytm.recharge.common.utils.ba.a((long) r3)
            java.lang.String r0 = java.lang.String.valueOf(r3)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r3 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.util.HashMap r3 = r3.getCategoryIdUrl()
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r4 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.util.HashMap r4 = r4.getCategoryIdUrlType()
            java.lang.Object r4 = r4.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x005a
            if (r3 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            java.lang.String r6 = "buyInsuranceEnabled"
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            boolean r5 = kotlin.m.p.a((java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (boolean) r7)
            if (r5 == 0) goto L_0x0066
        L_0x005a:
            net.one97.paytm.recharge.common.utils.y r3 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r3 = net.one97.paytm.recharge.common.utils.y.a()
            java.lang.Object r3 = r3.get(r0)
            java.lang.String r3 = (java.lang.String) r3
        L_0x0066:
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x007c
            net.one97.paytm.recharge.common.utils.y r4 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r4 = net.one97.paytm.recharge.common.utils.y.b()
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x007d
        L_0x007c:
            r0 = r4
        L_0x007d:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r4 = r22.getProductDetail()
            java.lang.String r5 = "orderedCart.productDetail"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.common.entity.recharge.CJRAttributes r4 = r4.getAttributes()
            r6 = 0
            if (r4 == 0) goto L_0x00a2
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r4 = r22.getProductDetail()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.common.entity.recharge.CJRAttributes r4 = r4.getAttributes()
            java.lang.String r5 = "orderedCart.productDetail.attributes"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getService()
            goto L_0x00a3
        L_0x00a2:
            r4 = r6
        L_0x00a3:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r7 = "product_id"
            if (r5 != 0) goto L_0x00f1
            r5 = r0
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x00f1
            long r9 = r2.getId()
            r11 = 0
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 < 0) goto L_0x00f1
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.Map r1 = r22.getRechargeConfiguration()
            r5.putAll(r1)
            r9 = r5
            java.util.Map r9 = (java.util.Map) r9
            long r1 = r2.getId()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r9.put(r7, r1)
            if (r0 != 0) goto L_0x00e0
            kotlin.g.b.k.a()
        L_0x00e0:
            if (r3 != 0) goto L_0x00e5
            kotlin.g.b.k.a()
        L_0x00e5:
            r1 = r21
            r2 = r0
            r5 = r23
            r6 = r24
            r7 = r9
            r1.a(r2, r3, r4, r5, r6, r7)
            return
        L_0x00f1:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r6, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r6)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r0.getFlowName()
            if (r3 == 0) goto L_0x0106
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_RETRY
            java.lang.String r4 = r4.name()
            r3.setActionType(r4)
        L_0x0106:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r0.getFlowName()
            if (r3 == 0) goto L_0x0115
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r4 = r4.name()
            r3.setErrorType(r4)
        L_0x0115:
            java.lang.String r3 = "RepeatRetry deeplink url is not available"
            r0.setErrorMsg(r3)
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
            double r3 = r22.getPrice()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            net.one97.paytm.recharge.widgets.c.d r9 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r20 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r6, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r6)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r20.getFlowName()
            if (r6 == 0) goto L_0x014b
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r9 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_RETRY
            java.lang.String r9 = r9.name()
            r6.setActionType(r9)
        L_0x014b:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r20.getFlowName()
            if (r6 == 0) goto L_0x015a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r9 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r9 = r9.name()
            r6.setErrorType(r9)
        L_0x015a:
            r6 = 1
            long r9 = r2.getId()     // Catch:{ Exception -> 0x0333 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0333 }
            r5.put(r7, r9)     // Catch:{ Exception -> 0x0333 }
            java.lang.String r7 = "qty"
            r5.put(r7, r6)     // Catch:{ Exception -> 0x0333 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0333 }
            r7.<init>()     // Catch:{ Exception -> 0x0333 }
            java.lang.String r9 = "category_id"
            long r10 = r2.getCategoryId()     // Catch:{ Exception -> 0x0333 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x0333 }
            r7.put(r9, r10)     // Catch:{ Exception -> 0x0333 }
            java.util.Map r9 = r22.getRechargeConfiguration()     // Catch:{ Exception -> 0x0333 }
            java.lang.String r10 = "price"
            if (r9 == 0) goto L_0x01d4
            java.lang.String r9 = r22.getRechargeNumber()     // Catch:{ Exception -> 0x0333 }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0333 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0333 }
            if (r9 == 0) goto L_0x019d
            java.lang.String r9 = r22.getRechargePrice()     // Catch:{ Exception -> 0x0333 }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ Exception -> 0x0333 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0333 }
            if (r9 != 0) goto L_0x01d4
        L_0x019d:
            java.util.Map r9 = r22.getRechargeConfiguration()     // Catch:{ Exception -> 0x0333 }
            java.util.Set r9 = r9.keySet()     // Catch:{ Exception -> 0x0333 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0333 }
        L_0x01a9:
            boolean r11 = r9.hasNext()     // Catch:{ Exception -> 0x0333 }
            if (r11 == 0) goto L_0x01dc
            java.lang.Object r11 = r9.next()     // Catch:{ Exception -> 0x0333 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0333 }
            boolean r12 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r10, (boolean) r6)     // Catch:{ Exception -> 0x0333 }
            if (r12 == 0) goto L_0x01c4
            float r11 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x0333 }
            double r11 = (double) r11     // Catch:{ Exception -> 0x0333 }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x0333 }
            goto L_0x01a9
        L_0x01c4:
            java.util.Map r12 = r22.getRechargeConfiguration()     // Catch:{ Exception -> 0x0333 }
            java.lang.Object r12 = r12.get(r11)     // Catch:{ Exception -> 0x0333 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0333 }
            r7.put(r11, r12)     // Catch:{ Exception -> 0x0333 }
            goto L_0x01a9
        L_0x01d4:
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ Exception -> 0x0333 }
            double r11 = (double) r0     // Catch:{ Exception -> 0x0333 }
            r7.put(r10, r11)     // Catch:{ Exception -> 0x0333 }
        L_0x01dc:
            java.lang.Object r0 = r22.getMetaDataResponse()     // Catch:{ Exception -> 0x01f6 }
            com.google.gson.f r1 = new com.google.gson.f     // Catch:{ Exception -> 0x01f6 }
            r1.<init>()     // Catch:{ Exception -> 0x01f6 }
            java.lang.String r0 = r1.b(r0)     // Catch:{ Exception -> 0x01f6 }
            if (r0 == 0) goto L_0x01fe
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x01f6 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x01f6 }
            java.lang.String r0 = "meta_data"
            r5.put(r0, r1)     // Catch:{ Exception -> 0x01f6 }
            goto L_0x01fe
        L_0x01f6:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0333 }
            com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x0333 }
        L_0x01fe:
            java.lang.String r0 = "configuration"
            r5.put(r0, r7)     // Catch:{ Exception -> 0x0333 }
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r20.getFlowName()     // Catch:{ Exception -> 0x0333 }
            if (r0 == 0) goto L_0x0210
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x0333 }
            r0.setRequestBody(r1)     // Catch:{ Exception -> 0x0333 }
        L_0x0210:
            r4.put(r5)     // Catch:{ Exception -> 0x0333 }
            java.lang.String r0 = "cart_items"
            r3.put(r0, r4)     // Catch:{ Exception -> 0x0333 }
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "Content-Type"
            java.lang.String r4 = "application/json"
            r0.put(r1, r4)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            android.content.Context r1 = (android.content.Context) r1
            java.util.HashMap r0 = com.paytm.utility.b.a((java.util.HashMap<java.lang.String, java.lang.String>) r0, (android.content.Context) r1)
            java.lang.String r1 = "CJRAppCommonUtility.addS…r(headers, mBaseActivity)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.recharge.di.helper.c r1 = net.one97.paytm.recharge.di.helper.c.f62654a
            long r4 = r2.getCategoryId()
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r1 = net.one97.paytm.recharge.di.helper.c.c(r1)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r4 = r8.f64309c
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r12 = com.paytm.utility.c.b((java.lang.String) r1, (android.content.Context) r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r20.getFlowName()
            if (r1 == 0) goto L_0x0254
            java.lang.String r4 = r3.toString()
            r1.setRequestBody(r4)
        L_0x0254:
            java.lang.String r1 = r3.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02eb
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            android.content.Context r1 = (android.content.Context) r1
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r1)
            java.lang.String r4 = "rechOrdSum"
            if (r1 == 0) goto L_0x02a6
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.c r1 = new net.one97.paytm.recharge.common.f.c
            r13 = r8
            net.one97.paytm.recharge.common.e.ai r13 = (net.one97.paytm.recharge.common.e.ai) r13
            net.one97.paytm.common.entity.CJRRechargeCart r5 = new net.one97.paytm.common.entity.CJRRechargeCart
            r5.<init>()
            r14 = r5
            com.paytm.network.model.IJRPaytmDataModel r14 = (com.paytm.network.model.IJRPaytmDataModel) r14
            r15 = r0
            java.util.Map r15 = (java.util.Map) r15
            java.lang.String r16 = r3.toString()
            com.paytm.network.a$c r17 = com.paytm.network.a.c.RECHARGES
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            r0.append(r4)
            java.lang.String r19 = r0.toString()
            com.paytm.network.a$b r18 = com.paytm.network.a.b.USER_FACING
            java.lang.String r11 = "repeat_retry"
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            net.one97.paytm.recharge.common.f.a r1 = (net.one97.paytm.recharge.common.f.a) r1
            net.one97.paytm.recharge.common.f.d.b(r1)
            return
        L_0x02a6:
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            net.one97.paytm.recharge.common.f.c r5 = new net.one97.paytm.recharge.common.f.c
            r13 = r8
            net.one97.paytm.recharge.common.e.ai r13 = (net.one97.paytm.recharge.common.e.ai) r13
            net.one97.paytm.common.entity.CJRRechargeCart r6 = new net.one97.paytm.common.entity.CJRRechargeCart
            r6.<init>()
            r14 = r6
            com.paytm.network.model.IJRPaytmDataModel r14 = (com.paytm.network.model.IJRPaytmDataModel) r14
            r15 = r0
            java.util.Map r15 = (java.util.Map) r15
            java.lang.String r16 = r3.toString()
            com.paytm.network.a$c r17 = com.paytm.network.a.c.RECHARGES
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            r0.append(r4)
            java.lang.String r19 = r0.toString()
            com.paytm.network.a$b r18 = com.paytm.network.a.b.USER_FACING
            java.lang.String r11 = "repeat_retry"
            r10 = r5
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            net.one97.paytm.recharge.common.f.a r5 = (net.one97.paytm.recharge.common.f.a) r5
            r1.a((net.one97.paytm.recharge.common.f.a) r5)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r0 = r8.f64309c
            r0.o()
            net.one97.paytm.recharge.ordersummary.h.a$a r0 = r8.f64307a
            if (r0 == 0) goto L_0x02ea
            r0.av_()
        L_0x02ea:
            return
        L_0x02eb:
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            int r2 = net.one97.paytm.recharge.R.string.network_error_heading
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.app.AlertDialog$Builder r1 = r0.setTitle(r1)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r2 = r8.f64309c
            int r3 = net.one97.paytm.recharge.R.string.network_error_message
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setMessage(r2)
            r0.setCancelable(r6)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            int r2 = net.one97.paytm.recharge.R.string.ok
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            net.one97.paytm.recharge.ordersummary.h.a$c r2 = net.one97.paytm.recharge.ordersummary.h.a.c.f64311a
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            r0.setPositiveButton(r1, r2)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            r1.o()
            net.one97.paytm.recharge.ordersummary.h.a$a r1 = r8.f64307a
            if (r1 == 0) goto L_0x032f
            r1.av_()
        L_0x032f:
            r0.show()
            return
        L_0x0333:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            int r2 = net.one97.paytm.recharge.R.string.network_error_heading
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.app.AlertDialog$Builder r1 = r0.setTitle(r1)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r2 = r8.f64309c
            int r3 = net.one97.paytm.recharge.R.string.network_error_message
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setMessage(r2)
            r0.setCancelable(r6)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            int r2 = net.one97.paytm.recharge.R.string.ok
            java.lang.String r1 = r1.getString(r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            net.one97.paytm.recharge.ordersummary.h.a$b r2 = net.one97.paytm.recharge.ordersummary.h.a.b.f64310a
            android.content.DialogInterface$OnClickListener r2 = (android.content.DialogInterface.OnClickListener) r2
            r0.setPositiveButton(r1, r2)
            net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity r1 = r8.f64309c
            r1.o()
            net.one97.paytm.recharge.ordersummary.h.a$a r1 = r8.f64307a
            if (r1 == 0) goto L_0x037f
            r1.av_()
        L_0x037f:
            r0.show()
        L_0x0382:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.h.a.a(net.one97.paytm.common.entity.shopping.CJROrderedCart, boolean, boolean):void");
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final b f64310a = new b();

        b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    static final class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f64311a = new c();

        c() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        boolean z;
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderedCart cJROrderedCart;
        CJROrderSummaryProductDetail productDetail;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        k.c(str, "tag");
        if (iJRPaytmDataModel2 instanceof CJRRechargeCart) {
            CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel2;
            try {
                net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
                CJRCart cart = cJRRechargeCart.getCart();
                k.a((Object) cart, "cart.cart");
                CJRCart cart2 = cJRRechargeCart.getCart();
                k.a((Object) cart2, "cart.cart");
                CJRCartProduct cJRCartProduct = cart2.getCartItems().get(0);
                k.a((Object) cJRCartProduct, "cart.cart.cartItems[0]");
                net.one97.paytm.recharge.di.helper.b.a(cart.getCartItems().get(0), (Context) this.f64309c, cJRCartProduct.getCategoryPathForGTM(), "/cart");
            } catch (Throwable unused) {
            }
            az azVar = az.f61525a;
            Bundle a2 = az.a((Context) this.f64309c, cJRRechargeCart, false, false);
            boolean z2 = a2.getBoolean("extra.has.error");
            CJRCartStatus cartStatus = cJRRechargeCart.getCartStatus();
            Long l = null;
            if (!p.a("SUCCESS", cartStatus != null ? cartStatus.getResult() : null, true) || z2) {
                String string = a2.getString("extra.error.title");
                String string2 = a2.getString("extra.error.msg");
                if (TextUtils.isEmpty(string2)) {
                    string2 = this.f64309c.getString(R.string.network_error_message);
                }
                if (TextUtils.isEmpty(string)) {
                    string = this.f64309c.getString(R.string.network_error_heading);
                }
                az azVar2 = az.f61525a;
                az.a(this.f64309c, ERROR_TYPE.UNDEFINED, ACTION_TYPE.OS_RETRY, string, string2);
                this.f64309c.o();
                C1266a aVar = this.f64307a;
                if (aVar != null) {
                    aVar.av_();
                    return;
                }
                return;
            }
            C1266a aVar2 = this.f64307a;
            if (aVar2 != null) {
                aVar2.au_();
            }
            try {
                CJRCart cart3 = cJRRechargeCart.getCart();
                k.a((Object) cart3, "cart.cart");
                CJRCartProduct cJRCartProduct2 = cart3.getCartItems().get(0);
                k.a((Object) cJRCartProduct2, "cartProduct");
                String str2 = cJRCartProduct2.getProductId().toString();
                net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
                String aU = net.one97.paytm.recharge.di.helper.c.aU();
                Boolean bool = (TextUtils.isEmpty(aU) || TextUtils.isEmpty(str2) || !p.a(aU, str2, true)) ? null : Boolean.TRUE;
                CJROrderSummary cJROrderSummary = this.f64308b.f63998b;
                if (!(cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null || (cJROrderedCart = orderedCartList.get(0)) == null || (productDetail = cJROrderedCart.getProductDetail()) == null)) {
                    l = Long.valueOf(productDetail.getCategoryId());
                }
                String valueOf = String.valueOf(l);
                net.one97.paytm.recharge.common.utils.a aVar3 = net.one97.paytm.recharge.common.utils.a.f61493a;
                z = true;
                try {
                    net.one97.paytm.recharge.common.utils.a.a(this.f64309c, "", cJRRechargeCart, AJRCouponsActivityV8.class, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, valueOf, bool, (Boolean) null, 40944);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                z = true;
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                cJRRechargeUtilities.debugLog("Unable to handle repeat-retry : " + e.getMessage());
                if (this.f64307a == null) {
                    this.f64309c.c(z);
                }
                this.f64309c.o();
            }
            this.f64309c.o();
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        this.f64309c.o();
        C1266a aVar = this.f64307a;
        if (aVar != null) {
            aVar.av_();
        }
        Toast.makeText(this.f64309c, networkCustomError != null ? networkCustomError.getMessage() : null, 1).show();
        if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }
}
