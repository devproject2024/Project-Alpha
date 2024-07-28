package net.one97.paytm.recharge.presentation.g;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.m.p;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderProduct;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticBillCategoriesResponse;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionListModel;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionSavedCardsModel;
import net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse;
import net.one97.paytm.recharge.domain.entities.CJRCreditCardBinModel;
import net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse;
import net.one97.paytm.recharge.domain.entities.CJRMerchantPayOption;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody;
import net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import org.json.JSONObject;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<b<CJRAutomaticSubscriptionListModel>> f64924a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<b<CJRAutomaticBillCategoriesResponse>> f64925b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<b<CJRFrequentOrderList>> f64926c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public final y<b<CJRCreateSubscriptionApiResponse>> f64927d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public final y<b<CJRCreateSubscriptionApiResponse>> f64928e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public final y<b<CJRPaymentOptionResponse>> f64929f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public final y<b<CJRRechargePayment>> f64930g = new y<>();

    /* renamed from: h  reason: collision with root package name */
    public final y<b<CJRAutomaticSubscriptionCheckModel>> f64931h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public final y<b<CJRAutomaticSubscriptionItemModel>> f64932i = new y<>();
    public final y<b<CJROrderSummary>> j = new y<>();
    public final y<b<CJRAutomaticSubscriptionSavedCardsModel>> k = new y<>();
    public final y<b<CJRAutomaticSubscriptionCheckModel>> l = new y<>();
    public io.reactivex.rxjava3.j.c<CJRTaggedObservable<CJRFetchBalanceResponse>> m;
    public final net.one97.paytm.recharge.a.a.a n;
    private final y<b<CJRCreditCardBinModel>> o = new y<>();
    private io.reactivex.rxjava3.j.c<CJRTaggedObservable<?>> p;

    static final class f<T> implements io.reactivex.rxjava3.d.g<CJRTaggedObservable<CJRFetchBalanceResponse>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64938a;

        f(a aVar) {
            this.f64938a = aVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f64938a.m.onNext((CJRTaggedObservable) obj);
        }
    }

    public a(net.one97.paytm.recharge.a.a.a aVar) {
        kotlin.g.b.k.c(aVar, "repository");
        this.n = aVar;
        io.reactivex.rxjava3.j.c<CJRTaggedObservable<CJRFetchBalanceResponse>> a2 = io.reactivex.rxjava3.j.c.a();
        kotlin.g.b.k.a((Object) a2, "ReplaySubject.create()");
        this.m = a2;
        io.reactivex.rxjava3.j.c<CJRTaggedObservable<?>> a3 = io.reactivex.rxjava3.j.c.a();
        kotlin.g.b.k.a((Object) a3, "ReplaySubject.create()");
        this.p = a3;
    }

    public static final class k implements aa<CJRAutomaticBillCategoriesResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64952a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        public k(a aVar) {
            this.f64952a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRAutomaticBillCategoriesResponse cJRAutomaticBillCategoriesResponse = (CJRAutomaticBillCategoriesResponse) obj;
            kotlin.g.b.k.c(cJRAutomaticBillCategoriesResponse, "t");
            this.f64952a.f64925b.postValue(new b((NetworkCustomError) null, cJRAutomaticBillCategoriesResponse, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64952a.f64925b.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public static final class h implements aa<CJRFrequentOrderList> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64948a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CJRAutomaticSubscriptionListModel f64949b;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        h(a aVar, CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel) {
            this.f64948a = aVar;
            this.f64949b = cJRAutomaticSubscriptionListModel;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRFrequentOrderList cJRFrequentOrderList = (CJRFrequentOrderList) obj;
            kotlin.g.b.k.c(cJRFrequentOrderList, "t");
            this.f64948a.f64926c.postValue(new b((NetworkCustomError) null, a.a(cJRFrequentOrderList, this.f64949b), c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64948a.f64926c.postValue(new b(a.a(th), new CJRFrequentOrderList(), c.ERROR, (String) null));
        }
    }

    public final void a(Context context, CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel) {
        kotlin.g.b.k.c(context, "context");
        this.f64926c.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.c(context).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new h(this, cJRAutomaticSubscriptionListModel));
    }

    public final void a(Context context) {
        kotlin.g.b.k.c(context, "context");
        this.f64924a.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.b(context).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new j(this));
    }

    public static final class j implements aa<CJRAutomaticSubscriptionListModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64951a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        j(a aVar) {
            this.f64951a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel = (CJRAutomaticSubscriptionListModel) obj;
            kotlin.g.b.k.c(cJRAutomaticSubscriptionListModel, "t");
            this.f64951a.f64924a.postValue(new b((NetworkCustomError) null, cJRAutomaticSubscriptionListModel, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64951a.f64924a.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public final void a(Context context, Bundle bundle, boolean z) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(bundle, "bundle");
        String a2 = a(context, bundle, z, false);
        this.f64927d.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.b(context, a2).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new c(this));
    }

    public static final class c implements aa<CJRCreateSubscriptionApiResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64935a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        c(a aVar) {
            this.f64935a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse = (CJRCreateSubscriptionApiResponse) obj;
            kotlin.g.b.k.c(cJRCreateSubscriptionApiResponse, "t");
            this.f64935a.f64927d.postValue(new b((NetworkCustomError) null, cJRCreateSubscriptionApiResponse, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64935a.f64927d.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public final void a(Context context, Bundle bundle) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(bundle, "bundle");
        String a2 = a(context, bundle, true, true);
        this.f64928e.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.b(context, a2).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new d(this));
    }

    public static final class d implements aa<CJRCreateSubscriptionApiResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64936a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        d(a aVar) {
            this.f64936a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse = (CJRCreateSubscriptionApiResponse) obj;
            kotlin.g.b.k.c(cJRCreateSubscriptionApiResponse, "t");
            this.f64936a.f64928e.postValue(new b((NetworkCustomError) null, cJRCreateSubscriptionApiResponse, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64936a.f64928e.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r22, android.os.Bundle r23, boolean r24, boolean r25) {
        /*
            r0 = r23
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f
            r2.<init>()
            java.lang.String r3 = "configuraton"
            boolean r4 = r0.containsKey(r3)
            r5 = 0
            if (r4 == 0) goto L_0x0021
            java.io.Serializable r3 = r0.getSerializable(r3)
            boolean r4 = r3 instanceof java.util.HashMap
            if (r4 != 0) goto L_0x001e
            r3 = r5
        L_0x001e:
            java.util.HashMap r3 = (java.util.HashMap) r3
            goto L_0x0022
        L_0x0021:
            r3 = r5
        L_0x0022:
            java.lang.String r4 = "configuration"
            java.lang.String r6 = "1"
            r7 = 1
            if (r3 == 0) goto L_0x004b
            r8 = r3
            java.util.Map r8 = (java.util.Map) r8
            boolean r9 = r8.isEmpty()
            r9 = r9 ^ r7
            if (r9 == 0) goto L_0x004b
            if (r25 == 0) goto L_0x0038
            java.lang.String r9 = "0"
            goto L_0x0039
        L_0x0038:
            r9 = r6
        L_0x0039:
            java.lang.String r10 = "price"
            r8.put(r10, r9)
            org.json.JSONObject r8 = new org.json.JSONObject
            java.lang.String r3 = r2.a((java.lang.Object) r3)
            r8.<init>(r3)
            r1.put(r4, r8)
            goto L_0x00b2
        L_0x004b:
            net.one97.paytm.recharge.domain.entities.CJRConfiguration r3 = new net.one97.paytm.recharge.domain.entities.CJRConfiguration
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 15
            r15 = 0
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15)
            if (r25 == 0) goto L_0x0060
            r8 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x0064
        L_0x0060:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
        L_0x0064:
            r3.setPrice(r8)
            java.lang.String r8 = "recharge_number"
            java.lang.String r8 = r0.getString(r8)
            r3.setRechargeNumber(r8)
            java.lang.String r8 = "recharge_number_2"
            boolean r9 = r0.containsKey(r8)
            if (r9 == 0) goto L_0x008b
            java.lang.String r9 = r0.getString(r8)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x008b
            java.lang.String r8 = r0.getString(r8)
            r3.setRechargeNumber2(r8)
        L_0x008b:
            java.lang.String r8 = "recharge_number_3"
            boolean r9 = r0.containsKey(r8)
            if (r9 == 0) goto L_0x00a6
            java.lang.String r9 = r0.getString(r8)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00a6
            java.lang.String r8 = r0.getString(r8)
            r3.setRechargeNumber3(r8)
        L_0x00a6:
            org.json.JSONObject r8 = new org.json.JSONObject
            java.lang.String r3 = r2.a((java.lang.Object) r3)
            r8.<init>(r3)
            r1.put(r4, r8)
        L_0x00b2:
            java.lang.String r3 = "product_id"
            java.lang.String r4 = r0.getString(r3)
            if (r4 == 0) goto L_0x00c2
            long r4 = java.lang.Long.parseLong(r4)
            java.lang.Long r5 = java.lang.Long.valueOf(r4)
        L_0x00c2:
            r1.put(r3, r5)
            java.lang.String r3 = "qty"
            r1.put(r3, r7)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4 = r3
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r5 = com.paytm.utility.b.l((android.content.Context) r22)
            java.lang.String r8 = "contact_phone"
            r4.put(r8, r5)
            java.lang.String r5 = com.paytm.utility.b.m((android.content.Context) r22)
            java.lang.String r8 = "customer_email"
            r4.put(r8, r5)
            java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r22)
            java.lang.String r8 = "customer_id"
            r4.put(r8, r5)
            java.lang.String r5 = "isSubscription"
            r4.put(r5, r6)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.String r8 = "s2s"
            r4.put(r8, r5)
            java.lang.String r5 = "from"
            boolean r8 = r0.containsKey(r5)
            if (r8 == 0) goto L_0x011d
            java.lang.String r5 = r0.getString(r5)
            java.lang.String r8 = "manage_screen"
            boolean r5 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r5, (boolean) r7)
            if (r5 == 0) goto L_0x011d
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.String r8 = "editable"
            r4.put(r8, r5)
            java.lang.String r5 = "subscription_id"
            java.lang.String r8 = r0.getString(r5)
            r4.put(r5, r8)
        L_0x011d:
            org.json.JSONObject r4 = new org.json.JSONObject
            java.lang.String r3 = r2.a((java.lang.Object) r3)
            r4.<init>(r3)
            java.lang.String r3 = "meta_data"
            r1.put(r3, r4)
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            r3.put(r1)
            net.one97.paytm.recharge.domain.entities.CJRSubscriptionInfo r1 = new net.one97.paytm.recharge.domain.entities.CJRSubscriptionInfo
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 2047(0x7ff, float:2.868E-42)
            r21 = 0
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            java.lang.String r4 = "VARIABLE"
            r1.setSubscriptionAmountType(r4)
            java.lang.String r4 = "is_postpaid"
            boolean r4 = r0.getBoolean(r4, r7)
            java.lang.String r5 = "3"
            java.lang.String r8 = "5"
            if (r4 == 0) goto L_0x0186
            java.lang.String r0 = "99999"
            r1.setSubscriptionMaxAmount(r0)
            r1.setSubscriptionFrequency(r6)
            java.lang.String r0 = "MONTH"
            r1.setSubscriptionFrequencyUnit(r0)
            net.one97.paytm.recharge.automatic.b.a.h$a r0 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            java.lang.String r0 = net.one97.paytm.recharge.automatic.b.a.h.a.a()
            r1.setSubscriptionStartDate(r0)
            net.one97.paytm.recharge.automatic.b.a.h$a r0 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            java.lang.String r0 = net.one97.paytm.recharge.automatic.b.a.h.a.b()
            r1.setSubscriptionExpiryDate(r0)
            r1.setSubscriptionGraceDays(r8)
            r1.setSubscriptionEnableRetry(r6)
            r1.setSubscriptionRetryCount(r5)
            goto L_0x01c9
        L_0x0186:
            java.lang.String r4 = "recharge_amount"
            java.lang.String r4 = r0.getString(r4)
            r1.setSubscriptionMaxAmount(r4)
            java.lang.String r4 = "recharge_days"
            java.lang.String r4 = r0.getString(r4)
            r1.setSubscriptionFrequency(r4)
            java.lang.String r4 = "DAY"
            r1.setSubscriptionFrequencyUnit(r4)
            net.one97.paytm.recharge.automatic.b.a.h$a r4 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            net.one97.paytm.recharge.automatic.b.a.h$a r4 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            java.lang.String r4 = net.one97.paytm.recharge.automatic.b.a.h.a.a()
            java.lang.String r9 = "recharge_date"
            java.lang.String r0 = r0.getString(r9, r4)
            java.lang.String r4 = "bundle.getString(Automat…tSubscriptionStartDate())"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            java.lang.String r0 = net.one97.paytm.recharge.automatic.b.a.h.a.d(r0)
            r1.setSubscriptionStartDate(r0)
            net.one97.paytm.recharge.automatic.b.a.h$a r0 = net.one97.paytm.recharge.automatic.b.a.h.f60252a
            java.lang.String r0 = net.one97.paytm.recharge.automatic.b.a.h.a.b()
            r1.setSubscriptionExpiryDate(r0)
            r1.setSubscriptionGraceDays(r8)
            r1.setSubscriptionEnableRetry(r6)
            r1.setSubscriptionRetryCount(r5)
        L_0x01c9:
            if (r24 == 0) goto L_0x01d5
            java.lang.String r0 = ""
            r1.setSubscriptionPaymentMode(r0)
            java.lang.String r0 = "E_MANDATE"
            r1.setMandateType(r0)
        L_0x01d5:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r4 = "cart_items"
            r0.put(r4, r3)
            java.lang.String r3 = "subscribe"
            r0.put(r3, r7)
            org.json.JSONObject r3 = new org.json.JSONObject
            java.lang.String r1 = r2.a((java.lang.Object) r1)
            r3.<init>(r1)
            java.lang.String r1 = "subscriptionInfo"
            r0.put(r1, r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "createSubscriptionApiRequest.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.g.a.a(android.content.Context, android.os.Bundle, boolean, boolean):java.lang.String");
    }

    public final void a(Context context, String str, String str2, String str3, String str4) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "mid");
        kotlin.g.b.k.c(str2, "orderId");
        kotlin.g.b.k.c(str3, "txnToken");
        kotlin.g.b.k.c(str4, "channelId");
        this.f64929f.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("txnToken", str3);
        jSONObject2.put("channelId", str4);
        jSONObject.put("head", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        kotlin.g.b.k.a((Object) jSONObject3, "reqBody.toString()");
        net.one97.paytm.recharge.a.a.a.a(context, jSONObject3, str, str2).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g(this, context, str, str2, str3, str4));
    }

    public static final class g implements aa<CJRPaymentOptionResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64939a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f64940b = true;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f64941c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f64942d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f64943e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f64944f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f64945g;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, boolean] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        g(net.one97.paytm.recharge.presentation.g.a r1, boolean r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
            /*
                r0 = this;
                r0.f64939a = r1
                r1 = 1
                r0.f64940b = r1
                r0.f64941c = r2
                r0.f64942d = r3
                r0.f64943e = r4
                r0.f64944f = r5
                r0.f64945g = r6
                r0.<init>()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.g.a.g.<init>(net.one97.paytm.recharge.presentation.g.a, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRMerchantPayOption merchantPayOption;
            ArrayList<CJRPaymentModes> paymentModes;
            CJRPaymentOptionResponse cJRPaymentOptionResponse = (CJRPaymentOptionResponse) obj;
            kotlin.g.b.k.c(cJRPaymentOptionResponse, "t");
            CJRPaymentOptionBody body = cJRPaymentOptionResponse.getBody();
            boolean z = true;
            if (!(body == null || (merchantPayOption = body.getMerchantPayOption()) == null || (paymentModes = merchantPayOption.getPaymentModes()) == null)) {
                Collection arrayList = new ArrayList();
                for (Object next : paymentModes) {
                    if (p.a(SDKConstants.AI_KEY_PPBL, ((CJRPaymentModes) next).getPaymentMode(), true)) {
                        arrayList.add(next);
                    }
                }
                if (((List) arrayList).size() == 0) {
                    z = false;
                }
            }
            h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
            h.a.e("fetchPaymentOptions() : onSuccess");
            this.f64939a.f64929f.postValue(new b((NetworkCustomError) null, cJRPaymentOptionResponse, c.SUCCESS, (String) null));
            if (this.f64940b) {
                io.reactivex.rxjava3.a.p.create(new C1283a(this, z)).subscribeOn(io.reactivex.rxjava3.i.a.b()).subscribe();
            }
        }

        /* renamed from: net.one97.paytm.recharge.presentation.g.a$g$a  reason: collision with other inner class name */
        static final class C1283a<T> implements s<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f64946a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f64947b;

            C1283a(g gVar, boolean z) {
                this.f64946a = gVar;
                this.f64947b = z;
            }

            public final void subscribe(r<Object> rVar) {
                if (this.f64947b) {
                    h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                    h.a.e("fetchPaymentOptions() : onSuccess : hasPPBLPayMode");
                    this.f64946a.f64939a.a(this.f64946a.f64941c, this.f64946a.f64942d, this.f64946a.f64943e, this.f64946a.f64944f, this.f64946a.f64945g, true);
                }
            }
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64939a.f64929f.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, boolean z) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "mid");
        kotlin.g.b.k.c(str2, "orderId");
        kotlin.g.b.k.c(str3, "txnToken");
        kotlin.g.b.k.c(str4, "channelId");
        net.one97.paytm.recharge.a.a.a.a(context, str, str2, str3, str4).b(io.reactivex.rxjava3.i.a.b()).a(z ? io.reactivex.rxjava3.i.a.b() : io.reactivex.rxjava3.android.b.a.a()).b(new f(this));
    }

    /* renamed from: net.one97.paytm.recharge.presentation.g.a$a  reason: collision with other inner class name */
    public static final class C1282a implements aa<CJRAutomaticSubscriptionCheckModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64933a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        C1282a(a aVar) {
            this.f64933a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel = (CJRAutomaticSubscriptionCheckModel) obj;
            kotlin.g.b.k.c(cJRAutomaticSubscriptionCheckModel, "t");
            this.f64933a.f64931h.postValue(new b((NetworkCustomError) null, cJRAutomaticSubscriptionCheckModel, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64933a.f64931h.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public final void a(Context context, Long l2, Integer num) {
        kotlin.g.b.k.c(context, "context");
        this.f64931h.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.a(context, l2, num).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new C1282a(this));
    }

    public static final class e implements aa<CJROrderSummary> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64937a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        e(a aVar) {
            this.f64937a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJROrderSummary cJROrderSummary = (CJROrderSummary) obj;
            kotlin.g.b.k.c(cJROrderSummary, "t");
            this.f64937a.j.postValue(new b((NetworkCustomError) null, cJROrderSummary, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64937a.j.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public final void a(Context context, String str, String str2) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "orderId");
        this.j.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.a(context, str, str2).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new e(this));
    }

    public static NetworkCustomError a(Throwable th) {
        kotlin.g.b.k.c(th, "e");
        return th instanceof NetworkCustomError ? (NetworkCustomError) th : new NetworkCustomError(th);
    }

    public static final class i implements aa<CJRAutomaticSubscriptionSavedCardsModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64950a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        i(a aVar) {
            this.f64950a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRAutomaticSubscriptionSavedCardsModel cJRAutomaticSubscriptionSavedCardsModel = (CJRAutomaticSubscriptionSavedCardsModel) obj;
            kotlin.g.b.k.c(cJRAutomaticSubscriptionSavedCardsModel, "t");
            this.f64950a.k.postValue(new b((NetworkCustomError) null, cJRAutomaticSubscriptionSavedCardsModel, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64950a.k.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public final void b(Context context) {
        kotlin.g.b.k.c(context, "context");
        this.k.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.a(context).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new i(this));
    }

    public final void a(Context context, String str) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(str, "number");
        this.l.postValue(new b((NetworkCustomError) null, null, c.LOADING, (String) null));
        net.one97.paytm.recharge.a.a.a.a(context, str).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new b(this));
    }

    public static final class b implements aa<CJRAutomaticSubscriptionCheckModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f64934a;

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            kotlin.g.b.k.c(cVar, "d");
        }

        b(a aVar) {
            this.f64934a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel = (CJRAutomaticSubscriptionCheckModel) obj;
            kotlin.g.b.k.c(cJRAutomaticSubscriptionCheckModel, "t");
            this.f64934a.l.postValue(new b((NetworkCustomError) null, cJRAutomaticSubscriptionCheckModel, c.SUCCESS, (String) null));
        }

        public final void onError(Throwable th) {
            kotlin.g.b.k.c(th, "e");
            this.f64934a.l.postValue(new b(a.a(th), null, c.ERROR, (String) null));
        }
    }

    public static final /* synthetic */ CJRFrequentOrderList a(CJRFrequentOrderList cJRFrequentOrderList, CJRAutomaticSubscriptionListModel cJRAutomaticSubscriptionListModel) {
        ArrayList<CJRAutomaticSubscriptionItemModel> subscriptionModelArrayList;
        Iterator<CJRFrequentOrder> it2 = cJRFrequentOrderList.getOrderList().iterator();
        while (it2.hasNext()) {
            CJRFrequentOrder next = it2.next();
            if (cJRAutomaticSubscriptionListModel == null || (subscriptionModelArrayList = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList()) == null || !(!subscriptionModelArrayList.isEmpty())) {
                kotlin.g.b.k.a((Object) next, "frequentOrder");
                CJRFrequentOrderProduct frequentOrderProduct = next.getFrequentOrderProduct();
                if (frequentOrderProduct != null && !frequentOrderProduct.isSchedulable()) {
                    it2.remove();
                }
            } else {
                Iterator<CJRAutomaticSubscriptionItemModel> it3 = cJRAutomaticSubscriptionListModel.getSubscriptionModelArrayList().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    CJRAutomaticSubscriptionItemModel next2 = it3.next();
                    kotlin.g.b.k.a((Object) next, "frequentOrder");
                    CJRFrequentOrderProduct frequentOrderProduct2 = next.getFrequentOrderProduct();
                    if (frequentOrderProduct2 == null || frequentOrderProduct2.isSchedulable()) {
                        if (p.a(next.getRechargeNumber(), next2.getRechargeNumber(), true)) {
                            if (kotlin.g.b.k.a((Object) next.getProductID(), (Object) String.valueOf(next2.getProductId()))) {
                                break;
                            }
                            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                            kotlin.g.b.k.a((Object) next2, "item");
                            if (net.one97.paytm.recharge.automatic.c.a.a.a(next2, next)) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }
                it2.remove();
            }
        }
        return cJRFrequentOrderList;
    }
}
