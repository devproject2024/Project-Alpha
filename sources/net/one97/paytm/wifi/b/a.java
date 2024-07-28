package net.one97.paytm.wifi.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.text.format.Formatter;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.d;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.wifi.a.a;
import net.one97.paytm.wifi.b;
import net.one97.paytm.wifi.models.WifiDataPlansModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0410a f21081a = new C0410a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private final Context f21082c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        k.c(context, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f21082c = context;
    }

    /* renamed from: net.one97.paytm.wifi.b.a$a  reason: collision with other inner class name */
    public static final class C0410a {
        private C0410a() {
        }

        public /* synthetic */ C0410a(byte b2) {
            this();
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, c cVar) {
        k.c(str, ContactColumn.PHONE_NUMBER);
        k.c(str2, "deviceMac");
        k.c(str3, "ssid");
        k.c(str4, "bssid");
        k.c(str5, "pId");
        k.c(cVar, H5Event.TYPE_CALL_BACK);
        k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
        b c2 = net.one97.paytm.wifi.a.c();
        k.a((Object) c2, "WifiController.getInstance().wifiEventListener");
        String cartVerifyUrl = c2.getCartVerifyUrl();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CLPConstants.PRODUCT_ID, str5);
            jSONObject2.put("qty", 1);
            jSONObject2.put(CLConstants.INPUT_KEY_CONFIGURATION, a(str, str2, str3, str4));
            jSONObject.put("cart_items", new JSONArray().put(jSONObject2));
        } catch (JSONException unused) {
            q.c((String) null);
        }
        if (URLUtil.isValidUrl(cartVerifyUrl)) {
            cartVerifyUrl = com.paytm.utility.b.s(this.f21083b, cartVerifyUrl);
            q.d("express cart verify " + cartVerifyUrl + " json cart+ \n " + jSONObject);
        }
        a(cartVerifyUrl, new CJRRechargeCart(), a(), jSONObject.toString(), cVar);
    }

    public final void b(String str, String str2, String str3, String str4, String str5, c cVar) {
        k.c(str, ContactColumn.PHONE_NUMBER);
        k.c(str2, "deviceMac");
        k.c(str3, "ssid");
        k.c(str4, "bssid");
        k.c(str5, "pId");
        k.c(cVar, H5Event.TYPE_CALL_BACK);
        k.a((Object) net.one97.paytm.wifi.a.a(), "WifiController.getInstance()");
        b c2 = net.one97.paytm.wifi.a.c();
        k.a((Object) c2, "WifiController.getInstance().wifiEventListener");
        String dynamicRechargeUrl = c2.getDynamicRechargeUrl();
        JSONObject a2 = a(str, str2, str3, str4);
        try {
            a2.put(CLPConstants.PRODUCT_ID, str5);
        } catch (JSONException unused) {
            q.c((String) null);
        }
        if (URLUtil.isNetworkUrl(dynamicRechargeUrl)) {
            dynamicRechargeUrl = com.paytm.utility.b.s(this.f21083b, dynamicRechargeUrl);
            q.d("express cart " + dynamicRechargeUrl + " json cart+ \n " + a2);
        }
        a(dynamicRechargeUrl, new WifiDataPlansModel(), a(), a2.toString(), cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x012a, code lost:
        if (r13 != false) goto L_0x012c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2 A[Catch:{ JSONException -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3 A[Catch:{ JSONException -> 0x0139 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.common.entity.CJRRechargeCart r18, net.one97.paytm.wifi.models.WifiPlan r19, net.one97.paytm.wifi.b.c r20) {
        /*
            r17 = this;
            r6 = r17
            java.lang.String r0 = "rechargeCart.cart"
            java.lang.String r1 = "rechargeCart"
            r2 = r18
            kotlin.g.b.k.c(r2, r1)
            java.lang.String r1 = "wifiPlan"
            r3 = r19
            kotlin.g.b.k.c(r3, r1)
            java.lang.String r1 = "callback"
            r5 = r20
            kotlin.g.b.k.c(r5, r1)
            net.one97.paytm.wifi.a r1 = net.one97.paytm.wifi.a.a()
            java.lang.String r4 = "WifiController.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            net.one97.paytm.wifi.b r1 = net.one97.paytm.wifi.a.c()
            java.lang.String r7 = "WifiController.getInstance().wifiEventListener"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r7)
            java.lang.String r1 = r1.getCartCheckoutUrl()
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r18.getCart()     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r12 = "free"
            r13 = 1
            if (r10 == 0) goto L_0x0110
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r18.getCart()     // Catch:{ JSONException -> 0x0139 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0139 }
            java.util.ArrayList r10 = r10.getCartItems()     // Catch:{ JSONException -> 0x0139 }
            if (r10 == 0) goto L_0x0110
            net.one97.paytm.common.entity.shopping.CJRCart r10 = r18.getCart()     // Catch:{ JSONException -> 0x0139 }
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0139 }
            java.util.ArrayList r10 = r10.getCartItems()     // Catch:{ JSONException -> 0x0139 }
            int r10 = r10.size()     // Catch:{ JSONException -> 0x0139 }
            if (r10 <= 0) goto L_0x0110
            net.one97.paytm.common.entity.shopping.CJRCart r2 = r18.getCart()     // Catch:{ JSONException -> 0x0139 }
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0139 }
            java.util.ArrayList r0 = r2.getCartItems()     // Catch:{ JSONException -> 0x0139 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x0139 }
        L_0x006f:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x0110
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x0139 }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r2 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r2     // Catch:{ JSONException -> 0x0139 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0139 }
            r10.<init>()     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r14 = "product_id"
            java.lang.String r15 = "cartProduct"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r15 = r2.getProductId()     // Catch:{ JSONException -> 0x0139 }
            r10.put(r14, r15)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r14 = "qty"
            java.lang.String r15 = r2.getQuantity()     // Catch:{ JSONException -> 0x0139 }
            r10.put(r14, r15)     // Catch:{ JSONException -> 0x0139 }
            java.util.Map r2 = r2.getConfigurationList()     // Catch:{ JSONException -> 0x0139 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0139 }
            r14.<init>()     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x00c4
            java.util.Set r15 = r2.keySet()     // Catch:{ JSONException -> 0x0139 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ JSONException -> 0x0139 }
        L_0x00aa:
            boolean r16 = r15.hasNext()     // Catch:{ JSONException -> 0x0139 }
            if (r16 == 0) goto L_0x00c4
            java.lang.Object r16 = r15.next()     // Catch:{ JSONException -> 0x0139 }
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x0139 }
            java.lang.Object r16 = r2.get(r11)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r9 = java.lang.String.valueOf(r16)     // Catch:{ JSONException -> 0x0139 }
            r14.put(r11, r9)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x00aa
        L_0x00c4:
            java.lang.String r2 = r19.getType()     // Catch:{ JSONException -> 0x0139 }
            boolean r2 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r2, (boolean) r13)     // Catch:{ JSONException -> 0x0139 }
            if (r2 != 0) goto L_0x00e8
            java.lang.String r2 = r19.getPrice()     // Catch:{ JSONException -> 0x0139 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x00df
            boolean r2 = kotlin.m.p.a(r2)     // Catch:{ JSONException -> 0x0139 }
            if (r2 == 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r2 = 0
            goto L_0x00e0
        L_0x00df:
            r2 = 1
        L_0x00e0:
            if (r2 == 0) goto L_0x00e3
            goto L_0x00e8
        L_0x00e3:
            java.lang.String r2 = r19.getPrice()     // Catch:{ JSONException -> 0x0139 }
            goto L_0x00ea
        L_0x00e8:
            java.lang.String r2 = "1"
        L_0x00ea:
            java.lang.String r9 = "recharge_number_5"
            java.lang.String r11 = r19.getPlanId()     // Catch:{ JSONException -> 0x0139 }
            r14.put(r9, r11)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r9 = "recharge_number_6"
            java.lang.String r11 = b()     // Catch:{ JSONException -> 0x0139 }
            r14.put(r9, r11)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r9 = "price"
            r14.put(r9, r2)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r9 = "totalamount"
            r14.put(r9, r2)     // Catch:{ JSONException -> 0x0139 }
            java.lang.String r2 = "configuration"
            r10.put(r2, r14)     // Catch:{ JSONException -> 0x0139 }
            r8.put(r10)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x006f
        L_0x0110:
            java.lang.String r0 = r19.getType()     // Catch:{ JSONException -> 0x0139 }
            boolean r0 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r0, (boolean) r13)     // Catch:{ JSONException -> 0x0139 }
            if (r0 != 0) goto L_0x012c
            java.lang.String r0 = r19.getPrice()     // Catch:{ JSONException -> 0x0139 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ JSONException -> 0x0139 }
            if (r0 == 0) goto L_0x012a
            boolean r0 = kotlin.m.p.a(r0)     // Catch:{ JSONException -> 0x0139 }
            if (r0 == 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r13 = 0
        L_0x012a:
            if (r13 == 0) goto L_0x0133
        L_0x012c:
            java.lang.String r0 = "promocode"
            java.lang.String r2 = "WIFIDIS"
            r7.put(r0, r2)     // Catch:{ JSONException -> 0x0139 }
        L_0x0133:
            java.lang.String r0 = "cart_items"
            r7.put(r0, r8)     // Catch:{ JSONException -> 0x0139 }
            goto L_0x013d
        L_0x0139:
            r0 = 0
            com.paytm.utility.q.c(r0)
        L_0x013d:
            java.util.Map r3 = r17.a()
            java.lang.String r0 = "Content-Type"
            java.lang.String r2 = "application/json"
            r3.put(r0, r2)     // Catch:{ JSONException -> 0x0159 }
            java.lang.String r0 = "sso_token"
            android.content.Context r2 = r6.f21083b     // Catch:{ JSONException -> 0x0159 }
            java.lang.String r2 = com.paytm.utility.d.a(r2)     // Catch:{ JSONException -> 0x0159 }
            java.lang.String r8 = "CJRNetUtility.getSSOToken(mContext)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)     // Catch:{ JSONException -> 0x0159 }
            r3.put(r0, r2)     // Catch:{ JSONException -> 0x0159 }
            goto L_0x015d
        L_0x0159:
            r0 = 0
            com.paytm.utility.q.c(r0)
        L_0x015d:
            boolean r0 = android.webkit.URLUtil.isValidUrl(r1)
            if (r0 == 0) goto L_0x01d4
            android.content.Context r0 = r6.f21083b
            java.lang.String r0 = com.paytm.utility.b.s(r0, r1)
            java.lang.String r1 = com.paytm.utility.b.k()
            android.net.Uri r2 = android.net.Uri.parse(r0)
            java.lang.String r8 = "Uri.parse(url)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            java.lang.String r2 = r2.getQuery()
            if (r2 == 0) goto L_0x0191
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "&client_id="
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            goto L_0x01a5
        L_0x0191:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "?client_id="
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
        L_0x01a5:
            java.lang.String r1 = "POST"
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r1)
            net.one97.paytm.wifi.a r1 = net.one97.paytm.wifi.a.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            net.one97.paytm.wifi.b r1 = net.one97.paytm.wifi.a.c()
            java.lang.String r0 = r1.initPreVerifyNativePGFlow(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "express cart "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r2 = " json cart+ \n "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            com.paytm.utility.q.d(r1)
            r1 = r0
        L_0x01d4:
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = new net.one97.paytm.common.entity.recharge.CJRRechargePayment
            r0.<init>()
            r2 = r0
            com.paytm.network.model.IJRPaytmDataModel r2 = (com.paytm.network.model.IJRPaytmDataModel) r2
            java.lang.String r4 = r7.toString()
            r0 = r17
            r5 = r20
            r0.a(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.b.a.a(net.one97.paytm.common.entity.CJRRechargeCart, net.one97.paytm.wifi.models.WifiPlan, net.one97.paytm.wifi.b.c):void");
    }

    private static JSONObject a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("recharge_number", str);
        jSONObject.put("recharge_number_2", str2);
        jSONObject.put("recharge_number_3", str3);
        jSONObject.put("recharge_number_4", str4);
        jSONObject.put("recharge_number_6", b());
        return jSONObject;
    }

    private final Map<String, String> a() {
        Map<String, String> hashMap = new HashMap<>();
        String a2 = d.a(this.f21083b);
        k.a((Object) a2, "CJRNetUtility.getSSOToken(mContext)");
        hashMap.put("ssotoken", a2);
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    private static String b() {
        a.C0409a aVar = net.one97.paytm.wifi.a.a.f21069c;
        WifiInfo connectionInfo = a.C0409a.a().f21070a.a().getConnectionInfo();
        k.a((Object) connectionInfo, "wm.connectionInfo");
        String formatIpAddress = Formatter.formatIpAddress(connectionInfo.getIpAddress());
        k.a((Object) formatIpAddress, "Formatter.formatIpAddres…connectionInfo.ipAddress)");
        return formatIpAddress;
    }
}
