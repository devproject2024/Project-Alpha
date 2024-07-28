package net.one97.paytm.passbook.genericPassbook.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.GiftVoucherResponseData;
import net.one97.paytm.passbook.beans.PFGWalletResponse;
import net.one97.paytm.passbook.beans.SubscriptionResponse;
import net.one97.paytm.passbook.beans.UserCheckSubscriptionStatus;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.genericPassbook.b;
import net.one97.paytm.passbook.genericPassbook.c;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.utility.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f57457a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f57458b;

    static final class b<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57460a;

        b(y yVar) {
            this.f57460a = yVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            if (iJRDataModel instanceof PFGWalletResponse) {
                PFGWalletResponse pFGWalletResponse = (PFGWalletResponse) iJRDataModel;
                if (pFGWalletResponse.getData() == null || pFGWalletResponse.getCode() != 2001) {
                    this.f57460a.postValue(new net.one97.paytm.passbook.genericPassbook.b(c.ERROR, iJRDataModel, (Throwable) null));
                    return;
                }
                y yVar = this.f57460a;
                b.a aVar = net.one97.paytm.passbook.genericPassbook.b.f57330d;
                yVar.postValue(new net.one97.paytm.passbook.genericPassbook.b(c.SUCCESS, iJRDataModel, (Throwable) null));
                return;
            }
            this.f57460a.postValue(new net.one97.paytm.passbook.genericPassbook.b(c.ERROR, iJRDataModel, (Throwable) null));
        }
    }

    private e() {
    }

    public final void a(Context context, i.a<IJRDataModel> aVar, g gVar) {
        k.c(context, "context");
        k.c(aVar, "listener");
        k.c(gVar, "errorListener");
        k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        String j = net.one97.paytm.passbook.mapping.e.j();
        try {
            new JSONObject().put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
        } catch (JSONException unused) {
        }
        HashMap hashMap = new HashMap();
        String a2 = net.one97.paytm.passbook.mapping.b.a(context);
        if (a2 == null) {
            a2 = "";
        }
        Map map = hashMap;
        map.put("ssotoken", a2);
        map.put("Accept-Encoding", "gzip");
        map.put("Content-Type", "application/json");
        net.one97.paytm.passbook.mapping.a.a aVar2 = new net.one97.paytm.passbook.mapping.a.a(j, aVar, gVar, (IJRDataModel) new CJRCashWallet(), (Map<String, String>) map, a.c.PASSBOOK, a.b.USER_FACING, getClass().getSimpleName(), Boolean.FALSE);
        net.one97.paytm.passbook.mapping.a.c.a();
        net.one97.paytm.passbook.mapping.a.c.b(aVar2);
    }

    public static void a(Context context, int i2, String str, String str2, i.a<IJRDataModel> aVar, g gVar, int i3) {
        Context context2 = context;
        int i4 = i2;
        String str3 = str;
        String str4 = str2;
        k.c(context2, "context");
        k.c(str3, "subwalletName");
        k.c(str4, "selectedFilter");
        k.c(aVar, "txnSuccessListener");
        k.c(gVar, "errorResponseHandler");
        if (!f57458b) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("userGuid", "");
            jSONObject2.put("startLimit", i3);
            jSONObject2.put("lastLimit", 20);
            JSONObject jSONObject3 = new JSONObject();
            ArrayList arrayList = new ArrayList();
            if (i4 == n.TOLL.getValue()) {
                arrayList.add("TOLL");
                jSONObject3.put("subWalletType", new JSONArray(arrayList));
                jSONObject2.put("subWalletParams", jSONObject3);
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            } else if (i4 == n.GIFT_VOUCHER.getValue()) {
                arrayList.add("GIFT_VOUCHER");
                jSONObject3.put("subWalletType", new JSONArray(arrayList));
                jSONObject2.put("subWalletParams", jSONObject3);
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            } else if (i4 == n.LOYALTY_WALLET_TYPE_7.getValue()) {
                arrayList.add("CLOSED_LOOP_WALLET");
                jSONObject3.put("subWalletType", new JSONArray(arrayList));
                jSONObject2.put("subWalletParams", jSONObject3);
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            } else if (i4 == n.LOYALTY_WALLET.getValue()) {
                arrayList.add("CASHBACK");
                jSONObject3.put("subWalletType", new JSONArray(arrayList));
                jSONObject2.put("subWalletParams", jSONObject3);
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            } else if (i4 == n.ALLOWALANCE_WALLET.getValue()) {
                arrayList.add("CLOSED_LOOP_SUB_WALLET");
                jSONObject3.put("subWalletType", new JSONArray(arrayList));
                jSONObject2.put("subWalletParams", jSONObject3);
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            } else if (i4 == n.FOOD_WALLET.getValue()) {
                arrayList.add(CLPConstants.FOOD);
                jSONObject3.put("subWalletType", new JSONArray(arrayList));
                jSONObject2.put("subWalletParams", jSONObject3);
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            } else {
                if (v.a(str) || p.a("MAIN", str3, true)) {
                    arrayList.add("PAYTM WALLET");
                } else {
                    arrayList.add(str3);
                }
                jSONObject3.put("subWalletType", new JSONArray(arrayList));
                jSONObject2.put("subWalletParams", jSONObject3);
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            }
            jSONObject3.put("subWalletType", new JSONArray(arrayList));
            jSONObject2.put("subWalletParams", jSONObject3);
            if (TextUtils.isEmpty(str4)) {
                jSONObject2.put("walletTransactiontype", SDKConstants.ALL_TYPE);
            } else {
                jSONObject2.put("walletTransactiontype", str4);
            }
            jSONObject.put("request", jSONObject2);
            String jSONObject4 = jSONObject.toString();
            k.a((Object) jSONObject4, "jsonObject.toString()");
            k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
            String i5 = net.one97.paytm.passbook.mapping.e.i();
            if (i5 != null && URLUtil.isValidUrl(i5)) {
                String e2 = com.paytm.utility.b.e(context2, i5);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                hashMap.put("Accept-Encoding", "gzip");
                String a2 = net.one97.paytm.passbook.mapping.b.a(context);
                if (a2 != null) {
                    hashMap.put("ssotoken", a2);
                }
                net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(e2, aVar, gVar, new CJRLedger(), hashMap, jSONObject4, a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, e.class.getSimpleName());
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(bVar);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054 A[Catch:{ all -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0061 A[Catch:{ all -> 0x0107 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.lifecycle.LiveData<net.one97.paytm.passbook.genericPassbook.b<com.paytm.network.model.IJRPaytmDataModel>> a(android.content.Context r13) {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r13, r0)
            androidx.lifecycle.y r0 = new androidx.lifecycle.y
            r0.<init>()
            r1 = 0
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()     // Catch:{ all -> 0x0107 }
            java.lang.String r3 = "games_pfg_wallet_balances_url"
            java.lang.String r2 = r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0107 }
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0107 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0025
            boolean r3 = kotlin.m.p.a(r3)     // Catch:{ all -> 0x0107 }
            if (r3 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r3 = 0
            goto L_0x0026
        L_0x0025:
            r3 = 1
        L_0x0026:
            if (r3 == 0) goto L_0x002a
            java.lang.String r2 = "https://wallet.gamepind.com/api/wallet/getBalance"
        L_0x002a:
            r3 = r2
            java.lang.String r2 = com.paytm.utility.b.A((android.content.Context) r13)     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.utility.m$a r6 = net.one97.paytm.passbook.utility.m.f59265a     // Catch:{ all -> 0x0107 }
            android.content.Context r13 = r13.getApplicationContext()     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "context.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r6)     // Catch:{ all -> 0x0107 }
            com.paytm.b.a.a r13 = net.one97.paytm.passbook.utility.m.a.a(r13)     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "gamepind_cas_access_token"
            java.lang.String r7 = ""
            java.lang.String r13 = r13.b((java.lang.String) r6, (java.lang.String) r7, (boolean) r5)     // Catch:{ all -> 0x0107 }
            r6 = r13
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x0107 }
            if (r6 == 0) goto L_0x0051
            boolean r6 = kotlin.m.p.a(r6)     // Catch:{ all -> 0x0107 }
            if (r6 == 0) goto L_0x0052
        L_0x0051:
            r4 = 1
        L_0x0052:
            if (r4 == 0) goto L_0x0061
            net.one97.paytm.passbook.genericPassbook.b r13 = new net.one97.paytm.passbook.genericPassbook.b     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.genericPassbook.c r2 = net.one97.paytm.passbook.genericPassbook.c.ERROR     // Catch:{ all -> 0x0107 }
            r13.<init>(r2, r1, r1)     // Catch:{ all -> 0x0107 }
            r0.postValue(r13)     // Catch:{ all -> 0x0107 }
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0     // Catch:{ all -> 0x0107 }
            return r0
        L_0x0061:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0107 }
            r4.<init>()     // Catch:{ all -> 0x0107 }
            r7 = r4
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x0107 }
            java.lang.String r4 = "AccessTokenAuthorization"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            r5.<init>()     // Catch:{ all -> 0x0107 }
            r5.append(r13)     // Catch:{ all -> 0x0107 }
            java.lang.String r13 = ":"
            r5.append(r13)     // Catch:{ all -> 0x0107 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0107 }
            r5.append(r8)     // Catch:{ all -> 0x0107 }
            java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x0107 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "Basic "
            r5.<init>(r6)     // Catch:{ all -> 0x0107 }
            java.nio.charset.Charset r6 = kotlin.m.d.f47971a     // Catch:{ all -> 0x0107 }
            if (r13 == 0) goto L_0x00ff
            byte[] r13 = r13.getBytes(r6)     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "(this as java.lang.String).getBytes(charset)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r6)     // Catch:{ all -> 0x0107 }
            r6 = 2
            java.lang.String r13 = android.util.Base64.encodeToString(r13, r6)     // Catch:{ all -> 0x0107 }
            r5.append(r13)     // Catch:{ all -> 0x0107 }
            java.lang.String r13 = r5.toString()     // Catch:{ all -> 0x0107 }
            r7.put(r4, r13)     // Catch:{ all -> 0x0107 }
            java.lang.String r13 = "Platform-CU"
            java.lang.String r4 = "android"
            r7.put(r13, r4)     // Catch:{ all -> 0x0107 }
            java.lang.String r13 = "cache-control"
            java.lang.String r4 = "no-cache"
            r7.put(r13, r4)     // Catch:{ all -> 0x0107 }
            java.lang.String r13 = "device_id"
            java.lang.String r4 = "deviceID"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)     // Catch:{ all -> 0x0107 }
            r7.put(r13, r2)     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.genericPassbook.d.a.e$b r13 = new net.one97.paytm.passbook.genericPassbook.d.a.e$b     // Catch:{ all -> 0x0107 }
            r13.<init>(r0)     // Catch:{ all -> 0x0107 }
            r4 = r13
            net.one97.paytm.passbook.mapping.a.i$a r4 = (net.one97.paytm.passbook.mapping.a.i.a) r4     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.genericPassbook.d.a.e$a r13 = new net.one97.paytm.passbook.genericPassbook.d.a.e$a     // Catch:{ all -> 0x0107 }
            r13.<init>(r0)     // Catch:{ all -> 0x0107 }
            r5 = r13
            net.one97.paytm.passbook.mapping.a.g r5 = (net.one97.paytm.passbook.mapping.a.g) r5     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.mapping.a.a r13 = new net.one97.paytm.passbook.mapping.a.a     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.beans.PFGWalletResponse r2 = new net.one97.paytm.passbook.beans.PFGWalletResponse     // Catch:{ all -> 0x0107 }
            r2.<init>()     // Catch:{ all -> 0x0107 }
            r6 = r2
            net.one97.paytm.passbook.mapping.IJRDataModel r6 = (net.one97.paytm.passbook.mapping.IJRDataModel) r6     // Catch:{ all -> 0x0107 }
            com.paytm.network.a$c r8 = com.paytm.network.a.c.PASSBOOK     // Catch:{ all -> 0x0107 }
            com.paytm.network.a$b r9 = com.paytm.network.a.b.USER_FACING     // Catch:{ all -> 0x0107 }
            java.lang.Class r2 = r12.getClass()     // Catch:{ all -> 0x0107 }
            java.lang.String r10 = r2.getSimpleName()     // Catch:{ all -> 0x0107 }
            java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0107 }
            r2 = r13
            r2.<init>((java.lang.String) r3, (net.one97.paytm.passbook.mapping.a.i.a<net.one97.paytm.passbook.mapping.IJRDataModel>) r4, (net.one97.paytm.passbook.mapping.a.g) r5, (net.one97.paytm.passbook.mapping.IJRDataModel) r6, (java.util.Map<java.lang.String, java.lang.String>) r7, (com.paytm.network.a.c) r8, (com.paytm.network.a.b) r9, (java.lang.String) r10, (java.lang.Boolean) r11)     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.mapping.a.c.a()     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.mapping.a.e r13 = (net.one97.paytm.passbook.mapping.a.e) r13     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.mapping.a.c.b(r13)     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.genericPassbook.b$a r13 = net.one97.paytm.passbook.genericPassbook.b.f57330d     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.genericPassbook.b r13 = new net.one97.paytm.passbook.genericPassbook.b     // Catch:{ all -> 0x0107 }
            net.one97.paytm.passbook.genericPassbook.c r2 = net.one97.paytm.passbook.genericPassbook.c.PROGRESS     // Catch:{ all -> 0x0107 }
            r13.<init>(r2, r1, r1)     // Catch:{ all -> 0x0107 }
            r0.postValue(r13)     // Catch:{ all -> 0x0107 }
            goto L_0x0112
        L_0x00ff:
            kotlin.u r13 = new kotlin.u     // Catch:{ all -> 0x0107 }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r13.<init>(r2)     // Catch:{ all -> 0x0107 }
            throw r13     // Catch:{ all -> 0x0107 }
        L_0x0107:
            r13 = move-exception
            net.one97.paytm.passbook.genericPassbook.b r2 = new net.one97.paytm.passbook.genericPassbook.b
            net.one97.paytm.passbook.genericPassbook.c r3 = net.one97.paytm.passbook.genericPassbook.c.ERROR
            r2.<init>(r3, r1, r13)
            r0.postValue(r2)
        L_0x0112:
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.d.a.e.a(android.content.Context):androidx.lifecycle.LiveData");
    }

    static final class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f57459a;

        a(y yVar) {
            this.f57459a = yVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f57459a.postValue(new net.one97.paytm.passbook.genericPassbook.b(c.ERROR, iJRPaytmDataModel, networkCustomError));
        }
    }

    public static void b(Context context, i.a<IJRDataModel> aVar, g gVar) {
        i.a<IJRDataModel> aVar2 = aVar;
        k.c(aVar, "successListener");
        k.c(gVar, "errorListener");
        f b2 = d.b();
        net.one97.paytm.passbook.utility.k kVar = net.one97.paytm.passbook.utility.k.f59256a;
        String a2 = b2.a(net.one97.paytm.passbook.utility.k.d());
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            String a3 = net.one97.paytm.passbook.mapping.b.a(context);
            if (a3 == null) {
                a3 = "";
            }
            Map map = hashMap;
            map.put("ssotoken", a3);
            map.put("Accept-Encoding", "gzip");
            map.put("Content-Type", "application/json");
            net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(a2, aVar, gVar, new UserCheckSubscriptionStatus((String) null, (String) null, (String) null, (SubscriptionResponse) null, 15, (kotlin.g.b.g) null), map, (String) null, a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, e.class.getSimpleName());
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(bVar);
        }
    }

    public static void c(Context context, i.a<IJRDataModel> aVar, g gVar) {
        k.c(aVar, "successListener");
        k.c(gVar, "errorListener");
        k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        String b2 = net.one97.paytm.passbook.mapping.e.b();
        if (!TextUtils.isEmpty(b2)) {
            HashMap hashMap = new HashMap();
            String a2 = net.one97.paytm.passbook.mapping.b.a(context);
            if (a2 != null) {
                Map map = hashMap;
                map.put("ssotoken", a2);
                map.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ppiType", "GIFT_VOUCHER");
                    jSONObject2.put("ppiStatus", "UNCLAIMED");
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "SALES_TO_USER_CREDIT");
                } catch (JSONException unused) {
                }
                net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(b2, aVar, gVar, new GiftVoucherResponseData(), map, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, e.class.getSimpleName());
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(bVar);
            }
        }
    }
}
