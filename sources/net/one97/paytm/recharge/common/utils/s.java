package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.model.CreateOrderResponse;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.k;
import net.one97.paytm.recharge.common.utils.o;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJRCheckoutRequestModel;
import net.one97.paytm.recharge.model.ContactItemModel;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ALERT_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s implements PaytmSDKRequestClient {

    /* renamed from: a  reason: collision with root package name */
    final Context f61730a;

    /* renamed from: b  reason: collision with root package name */
    JSONObject f61731b;

    /* renamed from: c  reason: collision with root package name */
    CJRRechargeCart f61732c;

    /* renamed from: d  reason: collision with root package name */
    private final net.one97.paytm.recharge.common.b.c f61733d = net.one97.paytm.recharge.common.b.d.b(this.f61730a);

    /* renamed from: e  reason: collision with root package name */
    private String f61734e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f61735f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f61736g;

    public s(Context context, JSONObject jSONObject, CJRRechargeCart cJRRechargeCart) {
        k.c(context, "context");
        k.c(jSONObject, "verifyJsonCart");
        k.c(cJRRechargeCart, "rechargeCart");
        this.f61730a = context;
        this.f61731b = jSONObject;
        this.f61732c = cJRRechargeCart;
        az azVar = az.f61525a;
        String a2 = az.a(this.f61731b);
        this.f61736g = a2 != null ? az.d(this.f61730a, a2, this.f61732c) : false;
    }

    public final void a(CJRRechargeCart cJRRechargeCart) {
        k.c(cJRRechargeCart, "<set-?>");
        this.f61732c = cJRRechargeCart;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        r12 = r12.getPaymentIntents();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void verifyCart(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.CallbackData r12, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient.OnVerifyResponse r13) {
        /*
            r11 = this;
            java.lang.String r0 = "verifyListener"
            kotlin.g.b.k.c(r13, r0)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.DEFFER_VERIFY
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r8 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r0 = r8.getFlowName()
            if (r0 == 0) goto L_0x001e
            net.one97.paytm.recharge.widgets.model.ALERT_TYPE r1 = net.one97.paytm.recharge.widgets.model.ALERT_TYPE.PROCEED_TO_PG
            java.lang.String r1 = r1.name()
            r0.setAlertType(r1)
        L_0x001e:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            org.json.JSONObject r0 = r11.f61731b
            java.lang.String r0 = net.one97.paytm.recharge.widgets.c.d.a((org.json.JSONObject) r0)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r8.getFlowName()
            if (r1 == 0) goto L_0x002f
            r1.setRequestBody(r0)
        L_0x002f:
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.DEFFER_VERIFY
            net.one97.paytm.recharge.widgets.c.d.b(r8, r0)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r0 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.DEFFER_VERIFY
            net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r8, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r0)
            r0 = 0
            r11.f61735f = r0
            if (r12 == 0) goto L_0x004e
            org.json.JSONObject r1 = r12.getOfferBody()
            if (r1 == 0) goto L_0x004e
            org.json.JSONObject r1 = r12.getOfferBody()
            r11.f61735f = r1
        L_0x004e:
            if (r12 == 0) goto L_0x0060
            java.util.ArrayList r12 = r12.getPaymentIntents()
            if (r12 == 0) goto L_0x0060
            com.google.gson.f r1 = new com.google.gson.f
            r1.<init>()
            java.lang.String r12 = r1.b(r12)
            goto L_0x0061
        L_0x0060:
            r12 = r0
        L_0x0061:
            java.lang.String r1 = r11.a()
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00a7
            org.json.JSONObject r2 = r11.f61731b
            java.lang.String r3 = "cart_items"
            boolean r2 = r2.has(r3)
            if (r2 == 0) goto L_0x00a7
            org.json.JSONObject r2 = r11.f61731b
            org.json.JSONArray r2 = r2.getJSONArray(r3)
            boolean r3 = r2 instanceof org.json.JSONArray
            if (r3 != 0) goto L_0x0083
            r2 = r0
        L_0x0083:
            if (r2 == 0) goto L_0x00a7
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x00a7
            r3 = 0
            int r4 = r2.length()
        L_0x0090:
            if (r3 >= r4) goto L_0x00a7
            java.lang.Object r5 = r2.get(r3)
            boolean r6 = r5 instanceof org.json.JSONObject
            if (r6 != 0) goto L_0x009b
            r5 = r0
        L_0x009b:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 == 0) goto L_0x00a4
            java.lang.String r6 = "bank_promocode"
            r5.put(r6, r1)
        L_0x00a4:
            int r3 = r3 + 1
            goto L_0x0090
        L_0x00a7:
            if (r12 == 0) goto L_0x00b0
            org.json.JSONObject r0 = r11.f61731b
            java.lang.String r1 = "payment_intent"
            r0.put(r1, r12)
        L_0x00b0:
            org.json.JSONObject r12 = r11.f61735f
            if (r12 == 0) goto L_0x00bb
            org.json.JSONObject r0 = r11.f61731b
            java.lang.String r1 = "payment_offers_applied"
            r0.put(r1, r12)
        L_0x00bb:
            net.one97.paytm.recharge.common.b.c r2 = r11.f61733d
            net.one97.paytm.recharge.common.utils.s$g r12 = new net.one97.paytm.recharge.common.utils.s$g
            r12.<init>(r11, r13)
            r4 = r12
            net.one97.paytm.recharge.common.e.ai r4 = (net.one97.paytm.recharge.common.e.ai) r4
            org.json.JSONObject r5 = r11.f61731b
            android.content.Context r12 = r11.f61730a
            java.lang.Class r12 = r12.getClass()
            java.lang.String r6 = r12.getSimpleName()
            java.lang.String r12 = "context.javaClass.simpleName"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
            com.paytm.network.a$b r7 = com.paytm.network.a.b.USER_FACING
            r9 = 1
            r10 = 0
            java.lang.String r3 = "verify"
            r2.a(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.s.verifyCart(net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$CallbackData, net.one97.paytm.nativesdk.app.PaytmSDKRequestClient$OnVerifyResponse):void");
    }

    public static final class g implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f61757a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmSDKRequestClient.OnVerifyResponse f61758b;

        g(s sVar, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
            this.f61757a = sVar;
            this.f61758b = onVerifyResponse;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            s sVar = this.f61757a;
            sVar.a(sVar.f61731b, 1, this.f61758b);
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            s sVar = this.f61757a;
            if (iJRPaytmDataModel != null) {
                s.a(sVar, (CJRRechargeCart) iJRPaytmDataModel, this.f61758b, obj);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart");
        }
    }

    public final void a(JSONObject jSONObject, int i2, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
        k.c(jSONObject, "verifyJsonCart");
        k.c(onVerifyResponse, "verifyListener");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.DEFFER_VERIFY, ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String a3 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject);
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setRequestBody(a3);
        }
        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.b(a2, ACTION_TYPE.DEFFER_VERIFY);
        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.DEFFER_VERIFY);
        String simpleName = this.f61730a.getClass().getSimpleName();
        k.a((Object) simpleName, "context.javaClass.simpleName");
        this.f61733d.a("verify", new f(this, i2, jSONObject, onVerifyResponse), jSONObject, simpleName, a.b.USER_FACING, a2, 1, false);
    }

    public static final class f implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f61753a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f61754b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONObject f61755c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PaytmSDKRequestClient.OnVerifyResponse f61756d;

        f(s sVar, int i2, JSONObject jSONObject, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse) {
            this.f61753a = sVar;
            this.f61754b = i2;
            this.f61755c = jSONObject;
            this.f61756d = onVerifyResponse;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            int i3 = this.f61754b;
            if (i3 < 3) {
                this.f61753a.a(this.f61755c, i3 + 1, this.f61756d);
                if (obj instanceof CJRRechargeErrorModel) {
                    az azVar = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj);
                }
            } else if (networkCustomError != null) {
                s sVar = this.f61753a;
                PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse = this.f61756d;
                k.c(networkCustomError, "error");
                k.c(onVerifyResponse, "verifyListener");
                kotlin.s<Integer, String, String> a2 = sVar.a(networkCustomError);
                s.a(a2.getFirst(), a2.getSecond(), a2.getThird(), onVerifyResponse, obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            s sVar = this.f61753a;
            if (iJRPaytmDataModel != null) {
                s.a(sVar, (CJRRechargeCart) iJRPaytmDataModel, this.f61756d, obj);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.CJRRechargeCart");
        }
    }

    public final void doCheckout(PaytmSDKRequestClient.CallbackData callbackData, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
        k.c(onCheckoutResponse, "checkoutListener");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.DEFFER_WALLET_TOKEN, ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.b(a2, ACTION_TYPE.DEFFER_WALLET_TOKEN);
        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.DEFFER_WALLET_TOKEN);
        this.f61735f = null;
        if (!(callbackData == null || callbackData.getPaymentIntents() == null)) {
            this.f61734e = new com.google.gson.f().b(callbackData.getPaymentIntents());
        }
        if (!(callbackData == null || callbackData.getOfferBody() == null)) {
            this.f61735f = callbackData.getOfferBody();
        }
        this.f61733d.a_("wallet_token", new a(this, onCheckoutResponse), a2);
    }

    public static final class a implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f61737a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmSDKRequestClient.OnCheckoutResponse f61738b;

        a(s sVar, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
            this.f61737a = sVar;
            this.f61738b = onCheckoutResponse;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (networkCustomError != null) {
                this.f61737a.a(networkCustomError, this.f61738b, obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                s.a(this.f61737a, (CJRPGTokenList) iJRPaytmDataModel, this.f61738b, obj);
            }
        }
    }

    public final void createOrderInfoFragment(PaytmSDKRequestClient.ShowOrderInfoFragment showOrderInfoFragment, Object obj) {
        if (obj instanceof CJRRechargeCart) {
            if (showOrderInfoFragment != null) {
                k.a aVar = k.f61656b;
                showOrderInfoFragment.showFragment(k.a.a((CJRRechargeCart) obj));
            }
        } else if (showOrderInfoFragment != null) {
            k.a aVar2 = k.f61656b;
            showOrderInfoFragment.showFragment(k.a.a(this.f61732c));
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f61739a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f61740b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61741c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f61742d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ PaytmSDKRequestClient.OnCheckoutResponse f61743e;

        b(s sVar, x.e eVar, String str, String str2, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
            this.f61739a = sVar;
            this.f61740b = eVar;
            this.f61741c = str;
            this.f61742d = str2;
            this.f61743e = onCheckoutResponse;
        }

        public final void run() {
            n nVar = n.f61679a;
            String str = (String) this.f61740b.element;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            ContactItemModel a2 = n.a(str);
            String name = a2 != null ? a2.getName() : null;
            if (TextUtils.isEmpty(name)) {
                name = ab.a(this.f61739a.f61730a, (String) this.f61740b.element);
            }
            aw awVar = aw.f61520a;
            final CJRCheckoutRequestModel a3 = aw.a(this.f61739a.f61732c, name, this.f61741c);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            final String a4 = net.one97.paytm.recharge.widgets.c.d.a(this.f61739a.f61730a, name, (String) this.f61740b.element);
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f61744a;

                {
                    this.f61744a = r1;
                }

                public final void run() {
                    this.f61744a.f61739a.a(this.f61744a.f61742d, a3, this.f61744a.f61743e, a4);
                }
            });
        }
    }

    private final String a() {
        String string;
        JSONObject jSONObject = this.f61735f;
        if (jSONObject == null || jSONObject == null || !jSONObject.has("offerBreakup")) {
            return "";
        }
        JSONObject jSONObject2 = this.f61735f;
        JSONArray jSONArray = jSONObject2 != null ? jSONObject2.getJSONArray("offerBreakup") : null;
        if (!(jSONArray instanceof JSONArray)) {
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            return "";
        }
        Object obj = jSONArray.get(0);
        if (!(obj instanceof JSONObject)) {
            obj = null;
        }
        JSONObject jSONObject3 = (JSONObject) obj;
        if (jSONObject3 == null || !jSONObject3.has("promocodeApplied") || (string = jSONObject3.getString("promocodeApplied")) == null) {
            return "";
        }
        return string;
    }

    /* access modifiers changed from: private */
    public final void a(String str, CJRCheckoutRequestModel cJRCheckoutRequestModel, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, String str2) {
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.DEFFER_CHECKOUT, ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String a3 = net.one97.paytm.recharge.widgets.c.d.a(cJRCheckoutRequestModel.getMetaData());
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setRequestBody(a3);
        }
        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.b(a2, ACTION_TYPE.DEFFER_CHECKOUT);
        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.DEFFER_CHECKOUT);
        JSONObject metaData = cJRCheckoutRequestModel.getMetaData();
        String str3 = this.f61734e;
        if (!(str3 == null || metaData == null)) {
            metaData.put("payment_intent", str3);
        }
        JSONObject jSONObject = this.f61735f;
        if (!(jSONObject == null || metaData == null)) {
            metaData.put("payment_offers_applied", jSONObject);
        }
        net.one97.paytm.recharge.common.b.c cVar = this.f61733d;
        ai cVar2 = new c(this, onCheckoutResponse);
        String rechargeNumber = cJRCheckoutRequestModel.getRechargeNumber();
        String rechargeUserName = cJRCheckoutRequestModel.getRechargeUserName();
        if (metaData == null) {
            kotlin.g.b.k.a();
        }
        cVar.a("doCheckout", str, cVar2, rechargeNumber, rechargeUserName, false, metaData, false, str2, a2);
    }

    public static final class c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f61747a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmSDKRequestClient.OnCheckoutResponse f61748b;

        c(s sVar, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse) {
            this.f61747a = sVar;
            this.f61748b = onCheckoutResponse;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (networkCustomError != null) {
                this.f61747a.a(networkCustomError, this.f61748b, obj);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRRechargePayment) {
                s.a((CJRRechargePayment) iJRPaytmDataModel, this.f61748b, obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(NetworkCustomError networkCustomError, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, Object obj) {
        kotlin.s<Integer, String, String> a2 = a(networkCustomError);
        a(a2.getFirst(), a2.getSecond(), a2.getThird(), onCheckoutResponse, obj);
        az azVar = az.f61525a;
        if (az.a() != null) {
            az azVar2 = az.f61525a;
            o a3 = az.a();
            if (a3 != null && a3.e()) {
                az azVar3 = az.f61525a;
                o a4 = az.a();
                if (a4 != null && a4.f61684a) {
                    az azVar4 = az.f61525a;
                    o a5 = az.a();
                    if (a5 != null) {
                        new Handler().postDelayed(new o.f(a5, a2.getFirst(), a2.getThird(), a2.getSecond()), 300);
                    }
                }
            }
        }
    }

    public final kotlin.s<Integer, String, String> a(NetworkCustomError networkCustomError) {
        kotlin.g.b.k.c(networkCustomError, "error");
        if (networkCustomError instanceof ap) {
            return new kotlin.s<>(Integer.valueOf(((ap) networkCustomError).getStatusCode()), this.f61730a.getResources().getString(R.string.msg_invalid_url), this.f61730a.getResources().getString(R.string.error));
        }
        if (networkCustomError instanceof as) {
            return new kotlin.s<>(Integer.valueOf(((as) networkCustomError).getStatusCode()), this.f61730a.getResources().getString(R.string.no_internet), this.f61730a.getResources().getString(R.string.no_connection));
        }
        if (networkCustomError instanceof bc) {
            return new kotlin.s<>(410, null, null);
        }
        if (networkCustomError instanceof c) {
            return new kotlin.s<>(410, null, null);
        }
        return new kotlin.s<>(Integer.valueOf(networkCustomError.getStatusCode()), ai.a(networkCustomError.getAlertMessage(), networkCustomError.getMessage()), networkCustomError.getAlertTitle());
    }

    private static void a(Integer num, String str, String str2, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, Object obj) {
        kotlin.g.b.k.c(onCheckoutResponse, "checkoutListener");
        onCheckoutResponse.onCheckoutError(a(num, str, str2));
        if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    public static void a(Integer num, String str, String str2, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse, Object obj) {
        kotlin.g.b.k.c(onVerifyResponse, "verifyListener");
        onVerifyResponse.onVerifyError(a(num, str, str2));
        if (obj instanceof CJRRechargeErrorModel) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
    }

    private static PaytmSDKRequestClient.ApiResponseError a(Integer num, String str, String str2) {
        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
        apiResponseError.setStatusCode(num != null ? num.intValue() : -1);
        apiResponseError.setErrorMsg(str);
        apiResponseError.setErrorTitle(str2);
        apiResponseError.setShouldClosePG(false);
        return apiResponseError;
    }

    public final boolean isConvFeeEnabled() {
        return this.f61736g;
    }

    public final void applyAnotherOffer(PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
        this.f61731b = a(this.f61731b);
        JSONObject jSONObject = this.f61731b;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.DEFFER_PROMO_VERIFY, ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String a3 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject);
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setRequestBody(a3);
        }
        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.b(a2, ACTION_TYPE.DEFFER_PROMO_VERIFY);
        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.DEFFER_PROMO_VERIFY);
        String simpleName = this.f61730a.getClass().getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "context.javaClass.simpleName");
        this.f61733d.a("promo_apply_another_offer_verify", new e(this, applyAnotherOfferListener), jSONObject, simpleName, a.b.USER_FACING, a2, 1, true);
    }

    public final void onOtherPayModeSelected(boolean z, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
        this.f61731b = a(this.f61731b);
        JSONObject jSONObject = this.f61731b;
        kotlin.g.b.k.c(jSONObject, "verifyJsonCart");
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a(ACTION_TYPE.DEFFER_PROMO_VERIFY, ERROR_TYPE.UNDEFINED);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName != null) {
            flowName.setAlertType(ALERT_TYPE.PROCEED_TO_PG.name());
        }
        net.one97.paytm.recharge.widgets.c.d dVar2 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        String a3 = net.one97.paytm.recharge.widgets.c.d.a(jSONObject);
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setRequestBody(a3);
        }
        net.one97.paytm.recharge.widgets.c.d dVar3 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.b(a2, ACTION_TYPE.DEFFER_PROMO_VERIFY);
        net.one97.paytm.recharge.widgets.c.d dVar4 = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a(a2, ACTION_TYPE.DEFFER_PROMO_VERIFY);
        String simpleName = this.f61730a.getClass().getSimpleName();
        kotlin.g.b.k.a((Object) simpleName, "context.javaClass.simpleName");
        this.f61733d.a("promo_verify_other_paymode_selected", new d(this, otherPayOptionsListener), jSONObject, simpleName, a.b.USER_FACING, a2, 1, true);
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject.has(Utility.EVENT_CATEGORY_PROMOCODE)) {
            jSONObject.put(Utility.EVENT_CATEGORY_PROMOCODE, "");
        }
        if (jSONObject.has("payment_intent")) {
            jSONObject.put("payment_intent", (Object) null);
        }
        if (jSONObject.has("paymentFilters")) {
            jSONObject.put("paymentFilters", (Object) null);
        }
        return jSONObject;
    }

    public static final class d implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f61749a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmSDKRequestClient.OtherPayOptionsListener f61750b;

        d(s sVar, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener) {
            this.f61749a = sVar;
            this.f61750b = otherPayOptionsListener;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            String str2;
            PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener;
            kotlin.g.b.k.c(str, "tag");
            if (networkCustomError != null && CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener2 = this.f61750b;
                if (otherPayOptionsListener2 != null) {
                    PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
                    apiResponseError.setStatusCode(networkCustomError.getStatusCode());
                    apiResponseError.setErrorTitle(networkCustomError.getAlertTitle());
                    apiResponseError.setErrorMsg(networkCustomError.getAlertMessage());
                    apiResponseError.setShouldClosePG(true);
                    apiResponseError.setClosePgWithoutError(true);
                    otherPayOptionsListener2.onError(apiResponseError);
                }
                az azVar = az.f61525a;
                if (az.a() != null) {
                    az azVar2 = az.f61525a;
                    o a2 = az.a();
                    if (a2 != null) {
                        a2.a(networkCustomError);
                    }
                }
            } else if (!(networkCustomError == null || (otherPayOptionsListener = this.f61750b) == null)) {
                PaytmSDKRequestClient.ApiResponseError apiResponseError2 = new PaytmSDKRequestClient.ApiResponseError();
                apiResponseError2.setStatusCode(networkCustomError.getStatusCode());
                apiResponseError2.setErrorTitle(networkCustomError.getAlertTitle());
                apiResponseError2.setErrorMsg(networkCustomError.getAlertMessage());
                otherPayOptionsListener.onError(apiResponseError2);
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                if (networkCustomError == null || (str2 = String.valueOf(networkCustomError.getStatusCode())) == null) {
                    str2 = String.valueOf(i2);
                }
                cJRRechargeErrorModel.setErrorCode(str2);
                cJRRechargeErrorModel.setErrorMsg(networkCustomError != null ? networkCustomError.getAlertMessage() : null);
                az azVar3 = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                CJPayMethodResponse cJPayMethodResponse = null;
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
                CJRCart cart = cJRRechargeCart.getCart();
                kotlin.g.b.k.a((Object) cart, "it.cart");
                if (cart.getPaymentInstruments() != null) {
                    CJRCart cart2 = cJRRechargeCart.getCart();
                    kotlin.g.b.k.a((Object) cart2, "it.cart");
                    if (!TextUtils.isEmpty(cart2.getPaymentInstruments().toString())) {
                        com.google.gson.f fVar = new com.google.gson.f();
                        CJRCart cart3 = cJRRechargeCart.getCart();
                        kotlin.g.b.k.a((Object) cart3, "it.cart");
                        cJPayMethodResponse = (CJPayMethodResponse) fVar.a(cart3.getPaymentInstruments().toString(), CJPayMethodResponse.class);
                    }
                }
                if (cJPayMethodResponse != null) {
                    az azVar = az.f61525a;
                    if (az.a() != null) {
                        az azVar2 = az.f61525a;
                        o a2 = az.a();
                        if (a2 != null) {
                            a2.a(cJRRechargeCart, false);
                        }
                    }
                    PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener = this.f61750b;
                    if (otherPayOptionsListener != null) {
                        CJRCart cart4 = cJRRechargeCart.getCart();
                        kotlin.g.b.k.a((Object) cart4, "it.cart");
                        String finalPrice = cart4.getFinalPrice();
                        otherPayOptionsListener.setFetchPayOptionsResponse(cJPayMethodResponse, finalPrice != null ? Double.parseDouble(finalPrice) : 0.0d);
                    }
                }
                this.f61749a.a(cJRRechargeCart);
            }
        }
    }

    public static final class e implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f61751a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmSDKRequestClient.ApplyAnotherOfferListener f61752b;

        e(s sVar, PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener) {
            this.f61751a = sVar;
            this.f61752b = applyAnotherOfferListener;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            String str2;
            PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener;
            kotlin.g.b.k.c(str, "tag");
            if (networkCustomError != null && CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener2 = this.f61752b;
                if (applyAnotherOfferListener2 != null) {
                    PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
                    apiResponseError.setStatusCode(networkCustomError.getStatusCode());
                    apiResponseError.setErrorTitle(networkCustomError.getAlertTitle());
                    apiResponseError.setErrorMsg(networkCustomError.getAlertMessage());
                    apiResponseError.setShouldClosePG(true);
                    apiResponseError.setClosePgWithoutError(true);
                    applyAnotherOfferListener2.onError(apiResponseError);
                }
                az azVar = az.f61525a;
                if (az.a() != null) {
                    az azVar2 = az.f61525a;
                    o a2 = az.a();
                    if (a2 != null) {
                        a2.a(networkCustomError);
                    }
                }
            } else if (!(networkCustomError == null || (applyAnotherOfferListener = this.f61752b) == null)) {
                PaytmSDKRequestClient.ApiResponseError apiResponseError2 = new PaytmSDKRequestClient.ApiResponseError();
                apiResponseError2.setStatusCode(networkCustomError.getStatusCode());
                apiResponseError2.setErrorTitle(networkCustomError.getAlertTitle());
                apiResponseError2.setErrorMsg(networkCustomError.getAlertMessage());
                applyAnotherOfferListener.onError(apiResponseError2);
            }
            if (obj instanceof CJRRechargeErrorModel) {
                CJRRechargeErrorModel cJRRechargeErrorModel = (CJRRechargeErrorModel) obj;
                if (networkCustomError == null || (str2 = String.valueOf(networkCustomError.getStatusCode())) == null) {
                    str2 = String.valueOf(i2);
                }
                cJRRechargeErrorModel.setErrorCode(str2);
                cJRRechargeErrorModel.setErrorMsg(networkCustomError != null ? networkCustomError.getAlertMessage() : null);
                az azVar3 = az.f61525a;
                az.a(cJRRechargeErrorModel);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            kotlin.g.b.k.c(str, "tag");
            if (iJRPaytmDataModel instanceof CJRRechargeCart) {
                az azVar = az.f61525a;
                CJRRechargeCart cJRRechargeCart = (CJRRechargeCart) iJRPaytmDataModel;
                Bundle a2 = az.a(this.f61751a.f61730a, cJRRechargeCart, false, false);
                boolean z = a2.getBoolean("extra.has.error");
                String string = a2.getString("extra.error.title");
                String string2 = a2.getString("extra.error.msg");
                if (z) {
                    PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener = this.f61752b;
                    if (applyAnotherOfferListener != null) {
                        PaytmSDKRequestClient.ApiResponseError apiResponseError = new PaytmSDKRequestClient.ApiResponseError();
                        apiResponseError.setStatusCode(cJRRechargeCart.getNetworkResponse().statusCode);
                        apiResponseError.setErrorMsg(string2);
                        apiResponseError.setErrorTitle(string);
                        applyAnotherOfferListener.onError(apiResponseError);
                    }
                    if (obj instanceof CJRRechargeErrorModel) {
                        az azVar2 = az.f61525a;
                        az.a((CJRRechargeErrorModel) obj);
                        return;
                    }
                    return;
                }
                az azVar3 = az.f61525a;
                if (az.a() != null) {
                    az azVar4 = az.f61525a;
                    o a3 = az.a();
                    if (a3 != null) {
                        a3.a(cJRRechargeCart, true);
                    }
                }
                this.f61751a.a(cJRRechargeCart);
                PaytmSDKRequestClient.ApplyAnotherOfferListener applyAnotherOfferListener2 = this.f61752b;
                if (applyAnotherOfferListener2 != null) {
                    applyAnotherOfferListener2.onSuccess();
                }
            }
        }
    }

    public static final /* synthetic */ void a(s sVar, CJRRechargeCart cJRRechargeCart, PaytmSDKRequestClient.OnVerifyResponse onVerifyResponse, Object obj) {
        az azVar = az.f61525a;
        Bundle a2 = az.a(sVar.f61730a, cJRRechargeCart, false, false);
        boolean z = a2.getBoolean("extra.has.error");
        String string = a2.getString("extra.error.title");
        String string2 = a2.getString("extra.error.msg");
        if (z) {
            a(Integer.valueOf(cJRRechargeCart.getNetworkResponse().statusCode), string2, string, onVerifyResponse, obj);
            return;
        }
        PaytmSDKRequestClient.ConvFeeResponse convFeeResponse = new PaytmSDKRequestClient.ConvFeeResponse();
        CJRCart cart = cJRRechargeCart.getCart();
        kotlin.g.b.k.a((Object) cart, "response.cart");
        convFeeResponse.setAggregatePGConvFee(cart.getAggregatePGConvFee());
        CJRCart cart2 = cJRRechargeCart.getCart();
        kotlin.g.b.k.a((Object) cart2, "response.cart");
        convFeeResponse.setTotalAmtIncConvFee(cart2.getFinalPrice());
        PaytmSDKRequestClient.VerifyResponseData verifyResponseData = new PaytmSDKRequestClient.VerifyResponseData();
        verifyResponseData.setConvFeeResponse(convFeeResponse);
        verifyResponseData.setVerifyModel(cJRRechargeCart);
        onVerifyResponse.onVerifySuccess(verifyResponseData);
    }

    public static final /* synthetic */ void a(s sVar, CJRPGTokenList cJRPGTokenList, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, Object obj) {
        String pgToken = CJRRechargeUtilities.INSTANCE.getPgToken(cJRPGTokenList);
        CharSequence charSequence = pgToken;
        if (!(charSequence == null || charSequence.length() == 0)) {
            x.e eVar = new x.e();
            eVar.element = null;
            try {
                CJRCart cart = sVar.f61732c.getCart();
                kotlin.g.b.k.a((Object) cart, "rechargeCart.cart");
                CJRCartProduct cJRCartProduct = cart.getCartItems().get(0);
                kotlin.g.b.k.a((Object) cJRCartProduct, "rechargeCart.cart.cartItems[0]");
                eVar.element = (String) cJRCartProduct.getConfigurationList().get("recharge_number");
            } catch (Exception unused) {
            }
            String a2 = sVar.a();
            if (com.paytm.utility.b.c((String) eVar.element)) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new b(sVar, eVar, a2, pgToken, onCheckoutResponse));
                return;
            }
            aw awVar = aw.f61520a;
            CJRCheckoutRequestModel a3 = aw.a(sVar.f61732c, (String) null, a2, 2);
            net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
            sVar.a(pgToken, a3, onCheckoutResponse, net.one97.paytm.recharge.widgets.c.d.a(sVar.f61730a, (String) null, (String) null));
            return;
        }
        sVar.a((NetworkCustomError) new bc(new NetworkCustomError()), onCheckoutResponse, obj);
    }

    public static final /* synthetic */ void a(CJRRechargePayment cJRRechargePayment, PaytmSDKRequestClient.OnCheckoutResponse onCheckoutResponse, Object obj) {
        CJRError error = cJRRechargePayment.getError();
        if (error != null) {
            a(Integer.valueOf(cJRRechargePayment.getNetworkResponse().statusCode), error.getMessage(), error.getTitle(), onCheckoutResponse, obj);
            return;
        }
        CreateOrderResponse createOrderResponse = new CreateOrderResponse();
        createOrderResponse.setORDER_ID(cJRRechargePayment.getOrderId());
        createOrderResponse.setMID(cJRRechargePayment.getMID());
        createOrderResponse.setStatus(cJRRechargePayment.getStatus());
        createOrderResponse.setMessage("");
        createOrderResponse.setTXN_AMOUNT(cJRRechargePayment.getTxnAmount());
        CreateOrderResponse.NativeWithdrawDetails nativeWithdrawDetails = new CreateOrderResponse.NativeWithdrawDetails();
        nativeWithdrawDetails.setTxnToken(cJRRechargePayment.getmTxnToken());
        nativeWithdrawDetails.setAuthenticated(true);
        createOrderResponse.setNative_withdraw_details(nativeWithdrawDetails);
        createOrderResponse.setNative_withdraw(cJRRechargePayment.isNativeEnabled());
        PaytmSDKRequestClient.CheckoutResponseData checkoutResponseData = new PaytmSDKRequestClient.CheckoutResponseData();
        checkoutResponseData.setCreateOrderResponse(createOrderResponse);
        onCheckoutResponse.onCheckoutSuccess(checkoutResponseData);
    }
}
