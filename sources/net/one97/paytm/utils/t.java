package net.one97.paytm.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.paytm_finance.R;

public final class t {
    public static void a(Activity activity, b bVar, a.c cVar) {
        if (cVar == null) {
            cVar = a.c.OAUTH;
        }
        if (activity != null && !activity.isFinishing()) {
            if (j(activity)) {
                bVar.onApiSuccess(l(activity.getApplicationContext()));
            } else if (com.paytm.utility.a.m(activity.getApplicationContext())) {
                OauthModule.a(bVar, cVar);
            } else {
                com.paytm.utility.b.b((Context) activity, activity.getApplication().getResources().getString(R.string.no_connection), activity.getApplication().getResources().getString(R.string.no_internet));
            }
        }
    }

    public static void a(Context context, b bVar, a.c cVar) {
        if (context instanceof Application) {
            if (cVar == null) {
                cVar = a.c.OAUTH;
            }
            if (j(context)) {
                bVar.onApiSuccess(l(context));
            } else if (com.paytm.utility.a.m(context)) {
                OauthModule.a(bVar, cVar);
            } else {
                bVar.handleErrorCode(-1, new CJRPGTokenList(), new NetworkCustomError());
            }
        } else {
            throw new IllegalArgumentException("Application context not found");
        }
    }

    public static String a(Context context) {
        String b2 = ag.a(context.getApplicationContext()).b("encrypted_sso_token", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void a(String str) {
        ag.a(CJRJarvisApplication.getAppContext()).a("encrypted_sso_token", str, true);
    }

    public static String b(Context context) {
        String b2 = ag.a(context.getApplicationContext()).b("sso_token=", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static String c(Context context) {
        String b2 = ag.a(context.getApplicationContext()).b("wallet_sso_token=", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void b(String str) {
        ag.a(CJRJarvisApplication.getAppContext()).a("wallet_sso_token=", str, true);
    }

    public static void a(long j) {
        ag.a(CJRJarvisApplication.getAppContext()).a("wallet_token_expire=", j, true);
    }

    public static long d(Context context) {
        return ag.a(context.getApplicationContext()).b("wallet_token_expire=", 0, true);
    }

    public static void c(String str) {
        ag.a(CJRJarvisApplication.getAppContext()).a("resource_owner_id", str, true);
    }

    public static Map<String, String> e(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("client_id", com.paytm.utility.b.k());
        hashMap.put("client_secret", com.paytm.utility.b.l());
        hashMap.put("session_token", b(context));
        hashMap.put("Authorization", com.paytm.utility.b.m());
        if (g(context) != null) {
            hashMap.put("cart_id", g(context));
        }
        return hashMap;
    }

    public static Map<String, String> f(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("verification_type", "oauth_token");
        hashMap.put("data", b(context));
        hashMap.put("Authorization", com.paytm.utility.b.m());
        return hashMap;
    }

    public static String a(CJRPGTokenList cJRPGTokenList) {
        boolean z;
        ArrayList<CJRPGToken> pGTokenList = cJRPGTokenList.getPGTokenList();
        String str = null;
        if (pGTokenList == null) {
            return null;
        }
        int size = pGTokenList.size();
        long j = 0;
        String str2 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            CJRPGToken cJRPGToken = pGTokenList.get(i2);
            String[] split = cJRPGToken.getScopes().split(AppConstants.COMMA);
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (!TextUtils.isEmpty(split[i3]) && split[i3].equalsIgnoreCase("wallet")) {
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                str = cJRPGToken.getToken();
                j = cJRPGToken.getExpires();
                break;
            }
            if (str2 == null) {
                str2 = cJRPGToken.getResourceOwnerId();
            }
            i2++;
        }
        a(j);
        b(str);
        c(str2);
        return str;
    }

    public static String g(Context context) {
        String b2 = ag.a(context.getApplicationContext()).b("cart_id", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static void a(Context context, String str) {
        ag.a(context.getApplicationContext()).a("cart_id", str, true);
    }

    public static void h(Context context) {
        ag.a(context.getApplicationContext()).a("recentpromocodemessage", (String) null, true);
    }

    public static void a(Context context, int i2) {
        ag.a(context.getApplicationContext()).a("cart_item_qty", i2, true);
    }

    public static void b(Context context, String str) {
        ag.a(context.getApplicationContext()).a("order_total", str, true);
    }

    public static String b(CJRPGTokenList cJRPGTokenList) {
        ArrayList<CJRPGToken> pGTokenList = cJRPGTokenList.getPGTokenList();
        String str = null;
        if (pGTokenList == null) {
            return null;
        }
        int size = pGTokenList.size();
        for (int i2 = 0; i2 < size; i2++) {
            str = pGTokenList.get(i2).getResourceOwnerId();
        }
        d(str);
        return str;
    }

    public static void d(String str) {
        ag.a(CJRJarvisApplication.getAppContext()).a("resId", str, true);
    }

    public static String i(Context context) {
        String b2 = ag.a(context.getApplicationContext()).b("resId", "", true);
        if (b2.equals("")) {
            return null;
        }
        return b2;
    }

    public static boolean j(Context context) {
        if (TextUtils.isEmpty(c(context))) {
            return false;
        }
        return System.currentTimeMillis() < d(context);
    }

    private static CJRPGTokenList l(Context context) {
        CJRPGToken cJRPGToken = new CJRPGToken();
        cJRPGToken.setToken(c(context));
        cJRPGToken.setExpires(d(context));
        cJRPGToken.setScopes("wallet");
        cJRPGToken.setResourceOwnerId(i(context));
        ArrayList arrayList = new ArrayList();
        arrayList.add(cJRPGToken);
        CJRPGTokenList cJRPGTokenList = new CJRPGTokenList();
        cJRPGTokenList.setPGTokenList(arrayList);
        return cJRPGTokenList;
    }

    public static Map<String, String> a() {
        String b2 = ag.a(CJRJarvisApplication.getAppContext()).b("cart_failed_promo_map", "", true);
        if (!b2.equals("")) {
            return (Map) ak.a(b2, new com.google.gsonhtcfix.c.a<HashMap<String, String>>() {
            }.getType());
        }
        return null;
    }

    public static void b() {
        ag.a(CJRJarvisApplication.getAppContext()).a("cart_failed_promo_map", true);
    }

    public static void a(boolean z) {
        ag.a(CJRJarvisApplication.getAppContext()).a("is_apply_promo_failed", z, true);
    }

    public static void k(Context context) {
        com.paytm.b.a.a a2 = ag.a(context.getApplicationContext());
        a2.a("user_name", "", true);
        a2.a("city_name", "", true);
        a2.a(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, "", true);
        a2.a("delivery_address_id", "", true);
        a2.a("delivery_address_1", "", true);
        a2.a("delivery_address_2", "", true);
        a2.a("delivery_mobile", "", true);
        a2.a("delivery_address_state", "", true);
    }

    public static void a(Context context, CJRRechargePayment cJRRechargePayment, FetchPayOptionsListener fetchPayOptionsListener) {
        PaytmSDK.setServer(Server.PRODUCTION);
        new FetchOptionsRequest(context, cJRRechargePayment.getMID(), cJRRechargePayment.getOrderId(), cJRRechargePayment.getmTxnToken(), fetchPayOptionsListener).executeRequest();
    }
}
