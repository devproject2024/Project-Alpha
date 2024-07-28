package com.paytmmall.artifact.common.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.paytmmall.artifact.cart.entity.CJRShoppingCart;
import com.paytmmall.artifact.common.a.b;
import com.paytmmall.artifact.d.aa;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.l;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.order.entity.CJROrderList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15657b = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static boolean f15658c = false;

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<C0211a> f15659d;

    /* renamed from: a  reason: collision with root package name */
    public long f15660a;

    /* renamed from: com.paytmmall.artifact.common.b.a.a$a  reason: collision with other inner class name */
    public interface C0211a {
    }

    public static void a(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
        intent.putExtra("barcode_only", true);
        intent.putExtra("nearex_scan", true);
        intent.putExtra("imei_validate", true);
        t.e().resolveIntentByMainApp(activity, intent, "paySendActivity", 201);
    }

    public static void a(String str, Map map) {
        b.a(str, (Map<String, Object>) map);
    }

    public static void a(HashMap hashMap) {
        b.a((Map<String, Object>) hashMap);
    }

    public static void a(HashMap<String, Object> hashMap, Activity activity) {
        if (hashMap.containsKey("broadcastKey") && activity != null) {
            String valueOf = String.valueOf(hashMap.get("broadcastKey"));
            String str = null;
            if (hashMap.containsKey("broadcastData")) {
                str = String.valueOf(hashMap.get("broadcastData"));
            }
            Intent intent = new Intent("MALL_SEND_BROADCAST");
            intent.putExtra("broadcastKey", valueOf);
            intent.putExtra("broadcastData", str);
            androidx.localbroadcastmanager.a.a.a((Context) activity).a(intent);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r5, java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = -1238034679(0xffffffffb6351709, float:-2.698451E-6)
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L_0x002b
            r1 = -741547321(0xffffffffd3cce2c7, float:-1.75995604E12)
            if (r0 == r1) goto L_0x0021
            r1 = 65904999(0x3eda167, float:1.3966664E-36)
            if (r0 == r1) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "Deals"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 2
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "Recharge"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "Transport"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 1
            goto L_0x0036
        L_0x0035:
            r6 = -1
        L_0x0036:
            if (r6 == 0) goto L_0x003f
            if (r6 == r4) goto L_0x003f
            if (r6 == r2) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r3 = 5
            goto L_0x0040
        L_0x003f:
            r3 = 1
        L_0x0040:
            com.paytmmall.artifact.common.a r6 = com.paytmmall.artifact.d.t.e()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "paytmmp://my_orders?tab="
            java.lang.String r0 = r1.concat(r0)
            r6.redirectToPaytm(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.common.b.a.a.a(android.app.Activity, java.lang.String):void");
    }

    public static String a() {
        Uri parse = Uri.parse(com.paytmmall.a.a.e());
        return String.valueOf(new Uri.Builder().scheme(parse.getScheme()).encodedAuthority(parse.getAuthority()).appendPath("myorders").build().normalizeScheme());
    }

    public static HashMap<String, String> a(String str) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }

    public static Context b() {
        return t.e().getApplicationContext();
    }

    public static String a(CJROrderList cJROrderList) {
        try {
            return String.valueOf(cJROrderList.getOrderItems().get(0).getProduct().getVerticalLabel());
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "0";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (android.text.TextUtils.isEmpty(com.paytmmall.artifact.d.l.b()) != false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.Object> c() {
        /*
            android.content.Context r0 = b()
            if (r0 == 0) goto L_0x0085
            com.paytmmall.artifact.cart.entity.CJRShoppingCart r1 = com.paytmmall.artifact.d.t.d()
            if (r1 == 0) goto L_0x0019
            b()
            java.lang.String r1 = com.paytmmall.artifact.d.l.b()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0085
        L_0x0019:
            java.util.ArrayList<com.paytmmall.artifact.common.b.a.a$a> r1 = f15659d
            if (r1 != 0) goto L_0x0024
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            f15659d = r1
        L_0x0024:
            boolean r1 = f15658c
            if (r1 != 0) goto L_0x0085
            r1 = 1
            f15658c = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/json"
            r1.put(r2, r3)
            java.util.HashMap r4 = com.paytmmall.artifact.d.d.a((java.util.HashMap<java.lang.String, java.lang.String>) r1, (android.content.Context) r0)
            com.paytmmall.artifact.common.a.a.a()
            r1 = 0
            java.lang.String r2 = "cartv2"
            java.lang.String r1 = com.paytmmall.artifact.common.a.a.a((java.lang.String) r2, (java.lang.String) r1)
            b()
            java.lang.String r2 = com.paytmmall.artifact.d.l.b()
            if (r2 == 0) goto L_0x0062
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = "/"
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
        L_0x0062:
            java.lang.String r2 = com.paytmmall.artifact.d.g.a((android.content.Context) r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.paytmmall.b.a$a r1 = com.paytmmall.b.a.C0216a.GET
            r3 = 0
            com.paytmmall.artifact.cart.entity.StringModel r5 = new com.paytmmall.artifact.cart.entity.StringModel
            r5.<init>()
            com.paytmmall.artifact.common.b.a.a$1 r6 = new com.paytmmall.artifact.common.b.a.a$1
            r6.<init>(r0)
            com.paytmmall.b.a.a(r0, r1, r2, r3, r4, r5, r6)
        L_0x0085:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.paytmmall.artifact.d.t r1 = com.paytmmall.artifact.d.t.c()
            java.lang.String r2 = "CHILD_SITE_ID"
            java.lang.String r1 = r1.c((java.lang.String) r2)
            java.lang.String r2 = com.paytmmall.artifact.d.d.d()
            java.lang.String r3 = "child_site_id"
            r0.put(r3, r1)
            java.lang.String r1 = "site_id"
            r0.put(r1, r2)
            b()
            java.lang.String r1 = com.paytmmall.artifact.d.l.b()
            if (r1 == 0) goto L_0x00b0
            java.lang.String r2 = "cart_id"
            r0.put(r2, r1)
        L_0x00b0:
            java.lang.String r1 = com.paytmmall.artifact.d.d.e()
            if (r1 == 0) goto L_0x00bf
            java.lang.String r1 = com.paytmmall.artifact.d.d.e()
            java.lang.String r2 = "user_id"
            r0.put(r2, r1)
        L_0x00bf:
            android.content.Context r1 = b()
            java.lang.String r1 = com.paytm.utility.b.ac(r1)
            android.content.Context r2 = b()
            java.lang.String r2 = com.paytm.utility.b.ad(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x0106
            java.lang.String r3 = r1.trim()
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0106
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0119
            java.lang.String r3 = r2.trim()
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0119
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            goto L_0x0119
        L_0x0106:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0118
            java.lang.String r1 = r2.trim()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0118
            r1 = r2
            goto L_0x0119
        L_0x0118:
            r1 = r4
        L_0x0119:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0167
            android.content.Context r2 = b()
            java.lang.String r2 = com.paytm.utility.b.aa((android.content.Context) r2)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0157
            android.content.Context r2 = b()
            java.lang.String r2 = com.paytm.utility.b.l((android.content.Context) r2)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x014e
            android.content.Context r2 = b()
            java.lang.String r2 = com.paytm.utility.b.ab(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0167
            java.lang.String r1 = r2.trim()
            goto L_0x0167
        L_0x014e:
            android.content.Context r1 = b()
            java.lang.String r1 = com.paytm.utility.b.ab(r1)
            goto L_0x0167
        L_0x0157:
            android.content.Context r1 = b()
            java.lang.String r1 = com.paytm.utility.b.aa((android.content.Context) r1)
            java.lang.String r1 = com.paytm.utility.b.A((java.lang.String) r1)
            java.lang.String r1 = r1.trim()
        L_0x0167:
            android.content.Context r2 = b()
            com.paytm.b.a.a r2 = com.paytmmall.artifact.d.u.a(r2)
            r3 = 0
            java.lang.String r5 = "h5_kyc_display_name"
            java.lang.String r1 = r2.b((java.lang.String) r5, (java.lang.String) r1, (boolean) r3)
            android.content.Context r2 = b()
            boolean r2 = com.paytmmall.artifact.d.d.d((android.content.Context) r2)
            if (r2 == 0) goto L_0x01f6
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x018b
            java.lang.String r2 = "display_name"
            r0.put(r2, r1)
        L_0x018b:
            android.content.Context r1 = b()
            java.lang.String r1 = com.paytm.utility.b.ae(r1)
            android.content.Context r2 = b()
            java.lang.String r2 = com.paytm.utility.b.G((android.content.Context) r2)
            android.content.Context r3 = b()
            java.util.Map r3 = com.paytm.utility.b.M((android.content.Context) r3)
            java.lang.String r5 = "gender"
            java.lang.Object r3 = r3.get(r5)
            java.lang.String r3 = (java.lang.String) r3
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x01b5
            r0.put(r5, r1)
            goto L_0x01c8
        L_0x01b5:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x01bf
            r0.put(r5, r2)
            goto L_0x01c8
        L_0x01bf:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto L_0x01c8
            r0.put(r5, r3)
        L_0x01c8:
            android.content.Context r1 = b()
            java.lang.String r1 = com.paytm.utility.b.al(r1)
            java.lang.String r2 = "user_image_url"
            r0.put(r2, r1)
            android.content.Context r1 = b()
            com.paytmmall.artifact.cart.entity.CJRAddress r1 = com.paytmmall.artifact.d.b.f(r1)
            if (r1 != 0) goto L_0x01e0
            goto L_0x01e4
        L_0x01e0:
            java.lang.String r4 = r1.getCountry()
        L_0x01e4:
            java.lang.String r1 = "country"
            r0.put(r1, r4)
            android.content.Context r1 = b()
            java.lang.String r1 = com.paytmmall.artifact.d.b.c(r1)
            java.lang.String r2 = "city_name"
            r0.put(r2, r1)
        L_0x01f6:
            android.content.res.Resources r1 = android.content.res.Resources.getSystem()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r2 = r1.widthPixels
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "width"
            r0.put(r3, r2)
            int r1 = r1.heightPixels
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "height"
            r0.put(r2, r1)
            java.util.Map r1 = com.paytmmall.artifact.d.g.b()
            r0.putAll(r1)
            java.lang.String r1 = com.paytmmall.artifact.d.d.g()
            java.lang.String r2 = "jsonContext"
            r0.put(r2, r1)
            java.util.Map r1 = com.paytmmall.artifact.d.l.a()
            java.lang.String r2 = "addressApiHeader"
            r0.put(r2, r1)
            com.paytmmall.artifact.common.a.b.a((java.util.Map<java.lang.String, java.lang.Object>) r0)
            android.content.Context r1 = b()
            com.paytmmall.artifact.common.a.b.a((java.util.Map<java.lang.String, java.lang.Object>) r0, (android.content.Context) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.artifact.common.b.a.a.c():java.util.HashMap");
    }

    public static HashMap<String, Object> d() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("payment_info_version", 2);
        hashMap.put("locationBridgeEnabled", Boolean.TRUE);
        return hashMap;
    }

    public static void a(Activity activity, HashMap<String, Object> hashMap, String str) {
        if (activity == null) {
            return;
        }
        if (!d.a((Context) activity)) {
            Toast.makeText(activity, "Please connect to internet!", 0).show();
        } else {
            new aa().a(str, activity, hashMap.get(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX).toString(), hashMap.get("url").toString());
        }
    }

    static /* synthetic */ void a(CJRShoppingCart cJRShoppingCart) {
        if (cJRShoppingCart != null) {
            if (!(cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getCartItems() == null || cJRShoppingCart.getCart().getmCartId() == null)) {
                l.a(cJRShoppingCart.getCart().getmCartId());
            }
            ArrayList<C0211a> arrayList = f15659d;
            if (arrayList != null) {
                Iterator<C0211a> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    C0211a next = it2.next();
                    if ((!(next instanceof Fragment) || !((Fragment) next).isAdded()) && (next instanceof AppCompatActivity)) {
                        ((AppCompatActivity) next).isFinishing();
                    }
                }
            }
            f15658c = false;
            f15659d = null;
        }
    }
}
