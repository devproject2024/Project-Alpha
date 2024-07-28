package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRDetailProduct;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.b.d;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.h.f;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class j implements ai {

    /* renamed from: a  reason: collision with root package name */
    public final f f61646a;

    /* renamed from: b  reason: collision with root package name */
    private Long f61647b;

    /* renamed from: c  reason: collision with root package name */
    private String f61648c;

    /* renamed from: d  reason: collision with root package name */
    private String f61649d;

    /* renamed from: e  reason: collision with root package name */
    private String f61650e;

    /* renamed from: f  reason: collision with root package name */
    private String f61651f;

    /* renamed from: g  reason: collision with root package name */
    private String f61652g;

    /* renamed from: h  reason: collision with root package name */
    private String f61653h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<Object, Object> f61654i = new HashMap<>();
    private androidx.fragment.app.j j;
    private final FragmentActivity k;

    public j(FragmentActivity fragmentActivity) {
        k.c(fragmentActivity, "activity");
        this.k = fragmentActivity;
        FragmentActivity fragmentActivity2 = this.k;
        androidx.lifecycle.ai a2 = am.a(fragmentActivity2, (al.b) new net.one97.paytm.recharge.common.h.a(d.b(fragmentActivity2), d.d(this.k))).a(f.class);
        k.a((Object) a2, "ViewModelProviders.of(ac…derViewModel::class.java)");
        this.f61646a = (f) a2;
        this.f61646a.f61441d = this;
        this.f61653h = b.n((Context) this.k);
    }

    public final LiveData<Boolean> a(Long l, String str, String str2, String str3, String str4, String str5) {
        this.f61647b = l;
        this.f61648c = str;
        this.f61649d = str2;
        this.f61650e = str3;
        this.f61651f = str4;
        this.f61652g = str5;
        a();
        return this.f61646a.f61442e;
    }

    private void a() {
        try {
            c cVar = c.f62654a;
            String e2 = c.e();
            if (!TextUtils.isEmpty(e2)) {
                String a2 = k.a(e2, (Object) this.f61647b);
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                CJRRechargeErrorModel a3 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
                CRUFlowModel flowName = a3.getFlowName();
                if (flowName != null) {
                    flowName.setActionType(ACTION_TYPE.BILL_CONSENT.name());
                }
                CRUFlowModel flowName2 = a3.getFlowName();
                if (flowName2 != null) {
                    flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("request_Type", "s2s");
                if (b.c((Context) this.k)) {
                    net.one97.paytm.recharge.common.f.d.a();
                    net.one97.paytm.recharge.common.f.d.b(new net.one97.paytm.recharge.common.f.b("getCategory", a2, (ai) this, (IJRPaytmDataModel) new CJRDetailProduct(), (Map<String, String>) hashMap, (Object) a3, (byte) 0));
                    return;
                }
                az azVar = az.f61525a;
                az.a(this.k, ERROR_TYPE.NO_CONNECTION, ACTION_TYPE.BILL_CONSENT, this.k.getString(R.string.no_connection), this.k.getString(R.string.no_internet));
            }
        } catch (NullPointerException e3) {
            this.f61646a.a(false);
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e3);
        }
    }

    public final void a(androidx.fragment.app.j jVar) {
        k.c(jVar, "childFragmentManager");
        this.j = jVar;
        f fVar = this.f61646a;
        ai aiVar = this;
        String str = this.f61653h;
        if (str == null) {
            k.a();
        }
        fVar.a(aiVar, str, this.f61654i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0168, code lost:
        if (r11.intValue() != 204) goto L_0x016a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r11, com.paytm.network.model.IJRPaytmDataModel r12, java.lang.Object r13) {
        /*
            r10 = this;
            java.lang.String r13 = "tag"
            kotlin.g.b.k.c(r11, r13)
            boolean r11 = r12 instanceof net.one97.paytm.common.entity.shopping.CJRDetailProduct
            r0 = 0
            r1 = 0
            if (r11 == 0) goto L_0x0153
            net.one97.paytm.common.entity.shopping.CJRDetailProduct r12 = (net.one97.paytm.common.entity.shopping.CJRDetailProduct) r12
            java.util.Map r11 = r12.getAttributes()
            java.lang.String r2 = "remindable"
            boolean r11 = r11.containsKey(r2)
            if (r11 == 0) goto L_0x014d
            java.util.Map r11 = r12.getAttributes()
            java.lang.Object r11 = r11.get(r2)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "2"
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r12)
            if (r11 == 0) goto L_0x014d
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.String r12 = r10.f61648c
            java.lang.String r1 = "operator"
            r11.put(r1, r12)
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.String r12 = r10.f61649d
            java.lang.String r2 = "rechargeNumber"
            r11.put(r2, r12)
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.Long r12 = r10.f61647b
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r3 = "productId"
            r11.put(r3, r12)
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.String r12 = r10.f61653h
            java.lang.String r4 = "customerId"
            r11.put(r4, r12)
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.String r12 = r10.f61650e
            java.lang.String r5 = "service"
            r11.put(r5, r12)
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.String r12 = r10.f61651f
            java.lang.String r5 = "circle"
            r11.put(r5, r12)
            androidx.fragment.app.FragmentActivity r11 = r10.k
            android.content.Context r11 = (android.content.Context) r11
            java.lang.String r11 = com.paytm.utility.b.l((android.content.Context) r11)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0092
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            androidx.fragment.app.FragmentActivity r12 = r10.k
            android.content.Context r12 = (android.content.Context) r12
            java.lang.String r12 = com.paytm.utility.b.l((android.content.Context) r12)
            java.lang.String r5 = "customerMobile"
            r11.put(r5, r12)
        L_0x0092:
            androidx.fragment.app.FragmentActivity r11 = r10.k
            android.content.Context r11 = (android.content.Context) r11
            java.lang.String r11 = com.paytm.utility.b.m((android.content.Context) r11)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x00b3
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            androidx.fragment.app.FragmentActivity r12 = r10.k
            android.content.Context r12 = (android.content.Context) r12
            java.lang.String r12 = com.paytm.utility.b.m((android.content.Context) r12)
            java.lang.String r5 = "customerEmail"
            r11.put(r5, r12)
        L_0x00b3:
            java.util.HashMap<java.lang.Object, java.lang.Object> r11 = r10.f61654i
            java.util.Map r11 = (java.util.Map) r11
            java.lang.String r12 = r10.f61652g
            java.lang.String r5 = "paytype"
            r11.put(r5, r12)
            net.one97.paytm.recharge.common.h.f r11 = r10.f61646a
            java.util.HashMap<java.lang.Object, java.lang.Object> r12 = r10.f61654i
            r11.a((java.util.HashMap<java.lang.Object, java.lang.Object>) r12)
            java.lang.String r11 = r10.f61653h
            if (r11 != 0) goto L_0x00d3
            androidx.fragment.app.FragmentActivity r11 = r10.k
            android.content.Context r11 = (android.content.Context) r11
            java.lang.String r11 = com.paytm.utility.b.n((android.content.Context) r11)
            r10.f61653h = r11
        L_0x00d3:
            java.lang.String r11 = r10.f61653h
            if (r11 == 0) goto L_0x014c
            net.one97.paytm.recharge.common.h.f r12 = r10.f61646a
            r5 = r10
            net.one97.paytm.recharge.common.e.ai r5 = (net.one97.paytm.recharge.common.e.ai) r5
            if (r11 != 0) goto L_0x00e1
            kotlin.g.b.k.a()
        L_0x00e1:
            java.util.HashMap<java.lang.Object, java.lang.Object> r6 = r10.f61654i
            java.lang.String r7 = "onSuccess"
            kotlin.g.b.k.c(r5, r7)
            kotlin.g.b.k.c(r11, r4)
            java.lang.String r8 = "paramMap"
            kotlin.g.b.k.c(r6, r8)
            net.one97.paytm.recharge.common.utils.w r12 = r12.f61443f
            java.lang.String r8 = "fetch_get_user_consent"
            net.one97.paytm.recharge.widgets.c.d r9 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r0)
            kotlin.g.b.k.c(r8, r13)
            kotlin.g.b.k.c(r5, r7)
            kotlin.g.b.k.c(r11, r4)
            java.lang.String r11 = "paramsMap"
            kotlin.g.b.k.c(r6, r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r13 = "?operator="
            r11.<init>(r13)
            java.lang.Object r13 = r6.get(r1)
            r11.append(r13)
            java.lang.String r13 = "&customerId="
            r11.append(r13)
            java.lang.Object r13 = r6.get(r4)
            r11.append(r13)
            java.lang.String r13 = "&rechargeNumber="
            r11.append(r13)
            java.lang.Object r13 = r6.get(r2)
            r11.append(r13)
            java.lang.String r13 = "&productId="
            r11.append(r13)
            java.lang.Object r13 = r6.get(r3)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            net.one97.paytm.recharge.common.b.c r13 = r12.f61789i
            if (r13 == 0) goto L_0x014c
            net.one97.paytm.recharge.common.utils.w$c r1 = new net.one97.paytm.recharge.common.utils.w$c
            r1.<init>(r12, r5)
            net.one97.paytm.recharge.common.e.ai r1 = (net.one97.paytm.recharge.common.e.ai) r1
            r13.d(r8, r1, r11, r0)
        L_0x014c:
            return
        L_0x014d:
            net.one97.paytm.recharge.common.h.f r11 = r10.f61646a
            r11.a((boolean) r1)
            return
        L_0x0153:
            boolean r11 = r12 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse
            r13 = 1
            if (r11 == 0) goto L_0x01a0
            r11 = r12
            net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse r11 = (net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse) r11     // Catch:{ Exception -> 0x0192 }
            java.lang.Integer r11 = r11.getStatus()     // Catch:{ Exception -> 0x0192 }
            if (r11 != 0) goto L_0x0162
            goto L_0x016a
        L_0x0162:
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x0192 }
            r0 = 204(0xcc, float:2.86E-43)
            if (r11 == r0) goto L_0x018c
        L_0x016a:
            r11 = r12
            net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse r11 = (net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse) r11     // Catch:{ Exception -> 0x0192 }
            net.one97.paytm.recharge.model.rechargeutility.CJRGetBillData r11 = r11.getData()     // Catch:{ Exception -> 0x0192 }
            if (r11 == 0) goto L_0x0186
            net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse r12 = (net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse) r12     // Catch:{ Exception -> 0x0192 }
            net.one97.paytm.recharge.model.rechargeutility.CJRGetBillData r11 = r12.getData()     // Catch:{ Exception -> 0x0192 }
            if (r11 != 0) goto L_0x017e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0192 }
        L_0x017e:
            int r11 = r11.getStatus()     // Catch:{ Exception -> 0x0192 }
            r12 = 7
            if (r11 != r12) goto L_0x0186
            goto L_0x018c
        L_0x0186:
            net.one97.paytm.recharge.common.h.f r11 = r10.f61646a     // Catch:{ Exception -> 0x0192 }
            r11.a((boolean) r1)     // Catch:{ Exception -> 0x0192 }
            return
        L_0x018c:
            net.one97.paytm.recharge.common.h.f r11 = r10.f61646a     // Catch:{ Exception -> 0x0192 }
            r11.a((boolean) r13)     // Catch:{ Exception -> 0x0192 }
            return
        L_0x0192:
            r11 = move-exception
            net.one97.paytm.recharge.common.h.f r12 = r10.f61646a
            r12.a((boolean) r1)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r12 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            r12.debugLogExceptions(r11)
            return
        L_0x01a0:
            boolean r11 = r12 instanceof net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse
            if (r11 == 0) goto L_0x022a
            net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse r12 = (net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse) r12
            java.lang.Integer r11 = r12.getStatus()
            if (r11 != 0) goto L_0x01ad
            goto L_0x0211
        L_0x01ad:
            int r11 = r11.intValue()
            r12 = 200(0xc8, float:2.8E-43)
            if (r11 != r12) goto L_0x0211
            androidx.fragment.app.j r11 = r10.j
            if (r11 != 0) goto L_0x01bc
            kotlin.g.b.k.a()
        L_0x01bc:
            if (r11 == 0) goto L_0x020b
            androidx.fragment.app.FragmentActivity r12 = r10.k
            if (r12 == 0) goto L_0x01d3
            int r0 = net.one97.paytm.recharge.R.string.recharge_order_status_set_bill_reminder
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = r10.f61648c
            r2[r1] = r3
            java.lang.String r3 = r10.f61649d
            r2[r13] = r3
            java.lang.String r0 = r12.getString(r0, r2)
        L_0x01d3:
            java.lang.String r12 = "activity?.getString(R.st…perator, mRechargeNumber)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r12)
            net.one97.paytm.recharge.common.c.a$a r12 = net.one97.paytm.recharge.common.c.a.f60952a
            java.lang.String r12 = "message"
            kotlin.g.b.k.c(r0, r12)
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            java.lang.String r13 = "key_message"
            r12.putString(r13, r0)
            net.one97.paytm.recharge.common.c.a r13 = new net.one97.paytm.recharge.common.c.a
            r13.<init>()
            r13.setArguments(r12)
            android.os.Handler r12 = new android.os.Handler
            r12.<init>()
            net.one97.paytm.recharge.common.utils.j$a r0 = new net.one97.paytm.recharge.common.utils.j$a
            r0.<init>(r13)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r2 = 2000(0x7d0, double:9.88E-321)
            r12.postDelayed(r0, r2)
            java.lang.Class<net.one97.paytm.recharge.common.c.a> r12 = net.one97.paytm.recharge.common.c.a.class
            java.lang.String r12 = r12.getSimpleName()
            r13.show((androidx.fragment.app.j) r11, (java.lang.String) r12)
        L_0x020b:
            net.one97.paytm.recharge.common.h.f r11 = r10.f61646a
            r11.a((boolean) r1)
            return
        L_0x0211:
            net.one97.paytm.recharge.common.utils.az r11 = net.one97.paytm.recharge.common.utils.az.f61525a
            androidx.fragment.app.FragmentActivity r11 = r10.k
            r0 = r11
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r2 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            r3 = 0
            androidx.fragment.app.FragmentActivity r11 = r10.k
            int r12 = net.one97.paytm.recharge.R.string.error_set_bill_reminder
            java.lang.String r4 = r11.getString(r12)
            r5 = 8
            net.one97.paytm.recharge.common.utils.az.a(r0, r1, r2, r3, r4, r5)
        L_0x022a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.j.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
        try {
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.recharge.common.c.a f61655a;

        a(net.one97.paytm.recharge.common.c.a aVar) {
            this.f61655a = aVar;
        }

        public final void run() {
            this.f61655a.dismiss();
        }
    }
}
