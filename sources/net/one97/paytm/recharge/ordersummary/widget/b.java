package net.one97.paytm.recharge.ordersummary.widget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.z;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.d.a;
import net.one97.paytm.recharge.ordersummary.f.t;
import net.one97.paytm.recharge.ordersummary.g.f;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements DialogInterface.OnClickListener, t.b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f64553e = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public Context f64554a;

    /* renamed from: b  reason: collision with root package name */
    public CJROrderSummary f64555b;

    /* renamed from: c  reason: collision with root package name */
    public String f64556c;

    /* renamed from: d  reason: collision with root package name */
    z f64557d;

    /* renamed from: f  reason: collision with root package name */
    private ProgressDialog f64558f;

    /* renamed from: g  reason: collision with root package name */
    private f f64559g;

    /* renamed from: h  reason: collision with root package name */
    private ai f64560h;

    public final void a(int i2, int i3) {
    }

    public b(Context context, CJROrderSummary cJROrderSummary, String str, ai aiVar, z zVar) {
        k.c(aiVar, "responseListener");
        k.c(zVar, "ijrrechargelistener");
        this.f64554a = context;
        this.f64555b = cJROrderSummary;
        this.f64556c = str;
        this.f64560h = aiVar;
        this.f64557d = zVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
            r1 = r1.getProductDetail();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean a(net.one97.paytm.common.entity.shopping.CJROrderSummary r5) {
            /*
                java.lang.String r0 = "orderSummary"
                kotlin.g.b.k.c(r5, r0)
                r0 = 0
                java.util.ArrayList r1 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x006b }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x006b }
                net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x006b }
                r2 = 0
                if (r1 == 0) goto L_0x001e
                net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()     // Catch:{ Exception -> 0x006b }
                if (r1 == 0) goto L_0x001e
                java.lang.String r1 = r1.getProductType()     // Catch:{ Exception -> 0x006b }
                goto L_0x001f
            L_0x001e:
                r1 = r2
            L_0x001f:
                java.lang.String r3 = "Failed"
                java.util.ArrayList r5 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x006b }
                java.lang.Object r5 = r5.get(r0)     // Catch:{ Exception -> 0x006b }
                net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5     // Catch:{ Exception -> 0x006b }
                if (r5 == 0) goto L_0x0032
                java.lang.String r5 = r5.getStatus()     // Catch:{ Exception -> 0x006b }
                goto L_0x0033
            L_0x0032:
                r5 = r2
            L_0x0033:
                r4 = 1
                boolean r5 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r4)     // Catch:{ Exception -> 0x006b }
                if (r5 == 0) goto L_0x006b
                if (r1 == 0) goto L_0x0047
                java.lang.String r5 = "Recharge"
                boolean r5 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r4)     // Catch:{ Exception -> 0x006b }
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x006b }
                goto L_0x0048
            L_0x0047:
                r5 = r2
            L_0x0048:
                if (r5 != 0) goto L_0x004d
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x006b }
            L_0x004d:
                boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x006b }
                if (r5 != 0) goto L_0x006a
                if (r1 == 0) goto L_0x005f
                java.lang.String r5 = net.one97.paytm.recharge.common.utils.ab.f61496a     // Catch:{ Exception -> 0x006b }
                boolean r5 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r4)     // Catch:{ Exception -> 0x006b }
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x006b }
            L_0x005f:
                if (r2 != 0) goto L_0x0064
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x006b }
            L_0x0064:
                boolean r5 = r2.booleanValue()     // Catch:{ Exception -> 0x006b }
                if (r5 == 0) goto L_0x006b
            L_0x006a:
                return r4
            L_0x006b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.b.a.a(net.one97.paytm.common.entity.shopping.CJROrderSummary):boolean");
        }

        public static boolean b(CJROrderSummary cJROrderSummary) {
            int i2;
            String str;
            CJROrderedCart cJROrderedCart;
            CJRFullFillmentObject fullFillmentOject;
            k.c(cJROrderSummary, "orderSummary");
            try {
                ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
                if (orderedCartList == null || (cJROrderedCart = orderedCartList.get(0)) == null || (fullFillmentOject = cJROrderedCart.getFullFillmentOject()) == null || (str = fullFillmentOject.getFulfillmentResponse()) == null) {
                    str = "";
                }
                String optString = new JSONObject(str).optString("in_code", "0");
                k.a((Object) optString, "fulfillmentJson.optString(\"in_code\", \"0\")");
                i2 = Integer.parseInt(optString);
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (i2 == 10 || i2 == 17 || i2 == 2000 || i2 == 3000) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00fe A[Catch:{ Exception -> 0x0102 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r9, java.lang.Integer r10) {
        /*
            r8 = this;
            r8.a()
            if (r10 != 0) goto L_0x0006
            return
        L_0x0006:
            int r10 = r10.intValue()
            if (r10 != 0) goto L_0x0107
            if (r9 == 0) goto L_0x0107
            boolean r10 = r9 instanceof net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8
            r0 = 0
            if (r10 != 0) goto L_0x0014
            r9 = r0
        L_0x0014:
            net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8 r9 = (net.one97.paytm.recharge.model.imps.CJRImpsRefundConsultViewV8) r9
            r10 = 0
            r1 = 1
            if (r9 == 0) goto L_0x0094
            java.util.List r2 = r9.getOtherRefundConsultView()     // Catch:{ Exception -> 0x0094 }
            if (r2 == 0) goto L_0x0094
            if (r2 == 0) goto L_0x002b
            int r3 = r2.size()     // Catch:{ Exception -> 0x0094 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0094 }
            goto L_0x002c
        L_0x002b:
            r3 = r0
        L_0x002c:
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0094 }
            if (r3 <= 0) goto L_0x0094
            if (r2 == 0) goto L_0x0094
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x0094 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0094 }
            r3 = 0
            r4 = 0
        L_0x003c:
            boolean r5 = r2.hasNext()     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x0092
            java.lang.Object r5 = r2.next()     // Catch:{ Exception -> 0x0092 }
            int r6 = r3 + 1
            if (r3 >= 0) goto L_0x004d
            kotlin.a.k.a()     // Catch:{ Exception -> 0x0092 }
        L_0x004d:
            net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8 r5 = (net.one97.paytm.recharge.model.imps.CJRRefundConsultViewV8) r5     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x0056
            java.lang.String r3 = r5.getDestination()     // Catch:{ Exception -> 0x0092 }
            goto L_0x0057
        L_0x0056:
            r3 = r0
        L_0x0057:
            java.lang.String r7 = "TO_INSTANT"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r1)     // Catch:{ Exception -> 0x0092 }
            if (r3 == 0) goto L_0x0090
            if (r5 == 0) goto L_0x0066
            java.lang.String r3 = r5.getEnableStatus()     // Catch:{ Exception -> 0x0092 }
            goto L_0x0067
        L_0x0066:
            r3 = r0
        L_0x0067:
            java.lang.String r7 = "true"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r1)     // Catch:{ Exception -> 0x0092 }
            if (r3 == 0) goto L_0x0071
            goto L_0x0095
        L_0x0071:
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = r5.getDisableReason()     // Catch:{ Exception -> 0x0092 }
            if (r3 == 0) goto L_0x0090
            java.lang.String r5 = "IMPS_ACCOUNT_NOT_EXIST"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r5, (boolean) r1)     // Catch:{ Exception -> 0x0092 }
            if (r3 == 0) goto L_0x0090
            if (r9 == 0) goto L_0x008f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x008d }
            r9.setStatus(r3)     // Catch:{ Exception -> 0x008d }
            r3 = r6
            r4 = 1
            goto L_0x003c
        L_0x008d:
            goto L_0x0095
        L_0x008f:
            r4 = 1
        L_0x0090:
            r3 = r6
            goto L_0x003c
        L_0x0092:
            r1 = r4
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            if (r1 == 0) goto L_0x00fe
            if (r9 == 0) goto L_0x00b8
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.f64555b     // Catch:{ Exception -> 0x0102 }
            if (r1 == 0) goto L_0x00b4
            java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x0102 }
            if (r1 == 0) goto L_0x00b4
            java.lang.Object r10 = r1.get(r10)     // Catch:{ Exception -> 0x0102 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10     // Catch:{ Exception -> 0x0102 }
            if (r10 == 0) goto L_0x00b4
            double r1 = r10.getSubTotal()     // Catch:{ Exception -> 0x0102 }
            java.lang.Double r10 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x0102 }
            goto L_0x00b5
        L_0x00b4:
            r10 = r0
        L_0x00b5:
            r9.setRefundAmount(r10)     // Catch:{ Exception -> 0x0102 }
        L_0x00b8:
            if (r9 == 0) goto L_0x00bf
            java.lang.String r10 = r8.f64556c     // Catch:{ Exception -> 0x0102 }
            r9.setCancelUrl(r10)     // Catch:{ Exception -> 0x0102 }
        L_0x00bf:
            if (r9 == 0) goto L_0x00ce
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r8.f64555b     // Catch:{ Exception -> 0x0102 }
            if (r10 == 0) goto L_0x00ca
            java.lang.String r10 = r10.getId()     // Catch:{ Exception -> 0x0102 }
            goto L_0x00cb
        L_0x00ca:
            r10 = r0
        L_0x00cb:
            r9.setOrderId(r10)     // Catch:{ Exception -> 0x0102 }
        L_0x00ce:
            if (r9 == 0) goto L_0x00d5
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r8.f64555b     // Catch:{ Exception -> 0x0102 }
            r9.setOrderSummary(r10)     // Catch:{ Exception -> 0x0102 }
        L_0x00d5:
            android.content.Context r10 = r8.f64554a     // Catch:{ Exception -> 0x0102 }
            if (r10 == 0) goto L_0x00f6
            androidx.appcompat.app.AppCompatActivity r10 = (androidx.appcompat.app.AppCompatActivity) r10     // Catch:{ Exception -> 0x0102 }
            androidx.fragment.app.j r10 = r10.getSupportFragmentManager()     // Catch:{ Exception -> 0x0102 }
            java.lang.String r1 = "(context as AppCompatAct…y).supportFragmentManager"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)     // Catch:{ Exception -> 0x0102 }
            net.one97.paytm.recharge.ordersummary.c.f$a r1 = net.one97.paytm.recharge.ordersummary.c.f.f64058b     // Catch:{ Exception -> 0x0102 }
            com.paytm.network.model.IJRPaytmDataModel r9 = (com.paytm.network.model.IJRPaytmDataModel) r9     // Catch:{ Exception -> 0x0102 }
            net.one97.paytm.recharge.ordersummary.c.f r9 = net.one97.paytm.recharge.ordersummary.c.f.a.a(r9, java.lang.Boolean.FALSE)     // Catch:{ Exception -> 0x0102 }
            java.lang.Class<net.one97.paytm.recharge.ordersummary.c.h> r1 = net.one97.paytm.recharge.ordersummary.c.h.class
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x0102 }
            r9.show((androidx.fragment.app.j) r10, (java.lang.String) r1)     // Catch:{ Exception -> 0x0102 }
            return
        L_0x00f6:
            kotlin.u r9 = new kotlin.u     // Catch:{ Exception -> 0x0102 }
            java.lang.String r10 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            r9.<init>(r10)     // Catch:{ Exception -> 0x0102 }
            throw r9     // Catch:{ Exception -> 0x0102 }
        L_0x00fe:
            r8.c()     // Catch:{ Exception -> 0x0102 }
            return
        L_0x0102:
            android.content.Context r9 = r8.f64554a
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r9, (java.lang.String) r0, (java.lang.String) r0)
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.b.a(com.paytm.network.model.IJRPaytmDataModel, java.lang.Integer):void");
    }

    private final void c() {
        String aVar = a.C1258a.C1259a.PROCESSING.toString();
        CJROrderSummary cJROrderSummary = this.f64555b;
        if (!p.a(aVar, cJROrderSummary != null ? cJROrderSummary.getPaymentStatus() : null, true) && this.f64556c != null) {
            d();
            HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), this.f64554a);
            k.a((Object) a2, "CJRAppCommonUtility.addS…nHeader(headers, context)");
            d.a();
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            d.b(new net.one97.paytm.recharge.common.f.b("fetch_hit_cancel_api", this.f64556c, new C1272b(this), new CJRActionResponse(), a2, net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null)));
        }
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.widget.b$b  reason: collision with other inner class name */
    public static final class C1272b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64561a;

        C1272b(b bVar) {
            this.f64561a = bVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            z zVar;
            k.c(str, "tag");
            this.f64561a.a();
            if (networkCustomError != null && (zVar = this.f64561a.f64557d) != null) {
                zVar.e();
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f64561a.a();
            z zVar = this.f64561a.f64557d;
            if (zVar != null) {
                if (iJRPaytmDataModel == null) {
                    k.a();
                }
                zVar.a(iJRPaytmDataModel);
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError, Integer num) {
        k.c(networkCustomError, "error");
        a();
        if (TextUtils.isEmpty(networkCustomError.getMessage()) || !CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError) || this.f64554a == null) {
            z zVar = this.f64557d;
            if (zVar != null) {
                zVar.e();
            }
            if (num != null && num.intValue() == 0) {
                String str = null;
                String alertMessage = !TextUtils.isEmpty(networkCustomError.getAlertMessage()) ? networkCustomError.getAlertMessage() : null;
                if (!TextUtils.isEmpty(networkCustomError.getAlertTitle())) {
                    str = networkCustomError.getAlertTitle();
                }
                ba.a(this.f64554a, alertMessage, str);
                return;
            }
            return;
        }
        CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
        Context context = this.f64554a;
        if (context != null) {
            cJRRechargeUtilities.showSessionTimeoutAlert((Activity) context, (String) null, (Bundle) null, networkCustomError, false, true);
            return;
        }
        throw new u("null cannot be cast to non-null type android.app.Activity");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r2 = r2.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.content.DialogInterface r5, int r6) {
        /*
            r4 = this;
            r5 = -2
            if (r6 == r5) goto L_0x00ae
            android.content.Context r5 = r4.f64554a
            r6 = 0
            if (r5 == 0) goto L_0x003c
            boolean r5 = com.paytm.utility.b.c((android.content.Context) r5)
            if (r5 != 0) goto L_0x003c
            net.one97.paytm.recharge.common.utils.az r5 = net.one97.paytm.recharge.common.utils.az.f61525a
            android.content.Context r5 = r4.f64554a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r0 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r1 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.OS_CTA_CANCEL
            android.content.Context r2 = r4.f64554a
            if (r2 == 0) goto L_0x0027
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L_0x0027
            int r3 = net.one97.paytm.recharge.R.string.no_connection
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0028
        L_0x0027:
            r2 = r6
        L_0x0028:
            android.content.Context r3 = r4.f64554a
            if (r3 == 0) goto L_0x0038
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x0038
            int r6 = net.one97.paytm.recharge.R.string.no_internet
            java.lang.String r6 = r3.getString(r6)
        L_0x0038:
            net.one97.paytm.recharge.common.utils.az.a(r5, r0, r1, r2, r6)
            return
        L_0x003c:
            net.one97.paytm.recharge.ordersummary.d.a$a$a r5 = net.one97.paytm.recharge.ordersummary.d.a.C1258a.C1259a.PROCESSING
            java.lang.String r5 = r5.toString()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r4.f64555b
            if (r0 == 0) goto L_0x004a
            java.lang.String r6 = r0.getPaymentStatus()
        L_0x004a:
            r0 = 1
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r0)
            if (r5 != 0) goto L_0x00ae
            net.one97.paytm.recharge.di.helper.c r5 = net.one97.paytm.recharge.di.helper.c.f62654a
            boolean r5 = net.one97.paytm.recharge.di.helper.c.ba()
            if (r5 == 0) goto L_0x00ab
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r4.f64555b
            if (r5 != 0) goto L_0x0060
            kotlin.g.b.k.a()
        L_0x0060:
            java.util.ArrayList r5 = r5.getOrderedCartList()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5
            if (r5 == 0) goto L_0x00ab
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r5.getProductDetail()
            if (r5 == 0) goto L_0x00ab
            net.one97.paytm.common.entity.recharge.CJRAttributes r5 = r5.getAttributes()
            if (r5 == 0) goto L_0x00ab
            boolean r5 = r5.isImpsEnabled()
            if (r5 != r0) goto L_0x00ab
            r4.d()
            net.one97.paytm.recharge.ordersummary.g.f r5 = r4.f64559g
            if (r5 != 0) goto L_0x00a3
            android.content.Context r5 = r4.f64554a
            if (r5 == 0) goto L_0x00a3
            net.one97.paytm.recharge.ordersummary.g.f r5 = new net.one97.paytm.recharge.ordersummary.g.f
            r6 = r4
            net.one97.paytm.recharge.ordersummary.f.t$b r6 = (net.one97.paytm.recharge.ordersummary.f.t.b) r6
            net.one97.paytm.recharge.common.b.c.e$a r0 = net.one97.paytm.recharge.common.b.c.e.f60936b
            android.content.Context r0 = r4.f64554a
            if (r0 != 0) goto L_0x0098
            kotlin.g.b.k.a()
        L_0x0098:
            net.one97.paytm.recharge.common.b.c.e r0 = net.one97.paytm.recharge.common.b.c.e.a.a(r0)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r4.f64555b
            r5.<init>(r6, r0, r1)
            r4.f64559g = r5
        L_0x00a3:
            net.one97.paytm.recharge.ordersummary.g.f r5 = r4.f64559g
            if (r5 == 0) goto L_0x00aa
            r5.a(0, (java.lang.String) null)
        L_0x00aa:
            return
        L_0x00ab:
            r4.c()
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.b.onClick(android.content.DialogInterface, int):void");
    }

    private void d() {
        if (this.f64558f == null) {
            Context context = this.f64554a;
            this.f64558f = ProgressDialog.show(context, "", context != null ? context.getString(R.string.please_wait) : null);
        }
        ProgressDialog progressDialog = this.f64558f;
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            ProgressDialog progressDialog = this.f64558f;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (IllegalStateException e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r1 = r1.getProductDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b() {
        /*
            r5 = this;
            r0 = 0
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r5.f64555b     // Catch:{ Exception -> 0x006f }
            if (r1 != 0) goto L_0x0008
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x006f }
        L_0x0008:
            java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x006f }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x006f }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x006f }
            r2 = 0
            if (r1 == 0) goto L_0x0024
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()     // Catch:{ Exception -> 0x006f }
            if (r1 == 0) goto L_0x0024
            long r3 = r1.getCategoryId()     // Catch:{ Exception -> 0x006f }
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x006f }
            goto L_0x0025
        L_0x0024:
            r1 = r2
        L_0x0025:
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x006f }
            net.one97.paytm.recharge.di.helper.c r3 = net.one97.paytm.recharge.di.helper.c.f62654a     // Catch:{ Exception -> 0x006f }
            boolean r3 = net.one97.paytm.recharge.di.helper.c.ba()     // Catch:{ Exception -> 0x006f }
            if (r3 == 0) goto L_0x006f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r5.f64555b     // Catch:{ Exception -> 0x006f }
            if (r3 != 0) goto L_0x0038
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x006f }
        L_0x0038:
            java.util.ArrayList r3 = r3.getOrderedCartList()     // Catch:{ Exception -> 0x006f }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ Exception -> 0x006f }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ Exception -> 0x006f }
            if (r3 == 0) goto L_0x006f
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r3.getProductDetail()     // Catch:{ Exception -> 0x006f }
            if (r3 == 0) goto L_0x006f
            net.one97.paytm.common.entity.recharge.CJRAttributes r3 = r3.getAttributes()     // Catch:{ Exception -> 0x006f }
            if (r3 == 0) goto L_0x006f
            boolean r3 = r3.isImpsEnabled()     // Catch:{ Exception -> 0x006f }
            r4 = 1
            if (r3 != r4) goto L_0x006f
            android.content.Context r3 = r5.f64554a     // Catch:{ Exception -> 0x006f }
            if (r3 == 0) goto L_0x0063
            boolean r1 = net.one97.paytm.recharge.common.utils.g.b(r3, r1)     // Catch:{ Exception -> 0x006f }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x006f }
        L_0x0063:
            if (r2 != 0) goto L_0x0068
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x006f }
        L_0x0068:
            boolean r1 = r2.booleanValue()     // Catch:{ Exception -> 0x006f }
            if (r1 == 0) goto L_0x006f
            return r4
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.ordersummary.widget.b.b():boolean");
    }
}
