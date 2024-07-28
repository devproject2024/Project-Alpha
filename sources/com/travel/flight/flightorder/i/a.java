package com.travel.flight.flightorder.i;

import android.content.Context;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.flight.b;
import com.travel.flight.utils.i;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.Server;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f24420a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static int f24421b = 1;

    public static String a(Context context) {
        return i.a(context.getApplicationContext()).b("sso_token=", "", true);
    }

    private static String b(Context context) {
        return i.a(context.getApplicationContext()).b("wallet_sso_token=", "", true);
    }

    private static long c(Context context) {
        return i.a(context.getApplicationContext()).b("wallet_token_expire=", 0, true);
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
        b.a();
        i.a(b.b().a()).a("wallet_token_expire=", j, true);
        b.a();
        i.a(b.b().a()).a("wallet_sso_token=", str, true);
        b.a();
        com.paytm.b.a.a a2 = i.a(b.b().a());
        if (str2 != null) {
            a2.a("resource_owner_id", str2, true);
        } else {
            a2.a("resource_owner_id", true);
        }
        return str;
    }

    public static void a(Context context, String str) {
        i.a(context.getApplicationContext()).a("cart_id", str, true);
    }

    public static void a(Context context, int i2) {
        i.a(context.getApplicationContext()).a("cart_item_qty", i2, true);
    }

    public static void b(Context context, String str) {
        i.a(context.getApplicationContext()).a("order_total", str, true);
    }

    public static void a(Context context, CJRRechargePayment cJRRechargePayment, FetchPayOptionsListener fetchPayOptionsListener) {
        PaytmSDK.setServer(Server.PRODUCTION);
        new FetchOptionsRequest(context, cJRRechargePayment.getMID(), cJRRechargePayment.getOrderId(), cJRRechargePayment.getmTxnToken(), fetchPayOptionsListener).executeRequest();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r6, com.paytm.network.listener.b r7) {
        /*
            android.content.Context r0 = r6.getApplicationContext()
            java.lang.String r0 = b(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            if (r0 != 0) goto L_0x0021
            android.content.Context r0 = r6.getApplicationContext()
            long r2 = c(r0)
            long r4 = java.lang.System.currentTimeMillis()
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0021
            r0 = 1
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x0070
            net.one97.paytm.common.entity.CJRPGToken r0 = new net.one97.paytm.common.entity.CJRPGToken
            r0.<init>()
            android.content.Context r2 = r6.getApplicationContext()
            java.lang.String r2 = b(r2)
            r0.setToken(r2)
            android.content.Context r2 = r6.getApplicationContext()
            long r2 = c(r2)
            r0.setExpires(r2)
            java.lang.String r2 = "wallet"
            r0.setScopes(r2)
            android.content.Context r6 = r6.getApplicationContext()
            android.content.Context r6 = r6.getApplicationContext()
            com.paytm.b.a.a r6 = com.travel.flight.utils.i.a(r6)
            java.lang.String r2 = "resId"
            java.lang.String r3 = ""
            java.lang.String r6 = r6.b((java.lang.String) r2, (java.lang.String) r3, (boolean) r1)
            r0.setResourceOwnerId(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.add(r0)
            net.one97.paytm.common.entity.CJRPGTokenList r0 = new net.one97.paytm.common.entity.CJRPGTokenList
            r0.<init>()
            r0.setPGTokenList(r6)
            r7.onApiSuccess(r0)
            return
        L_0x0070:
            com.travel.flight.b.a()
            com.travel.flight.c r0 = com.travel.flight.b.b()
            com.paytm.network.a$c r1 = com.paytm.network.a.c.FLIGHT
            r0.a((com.paytm.network.a.c) r1, (android.app.Activity) r6, (com.paytm.network.listener.b) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.i.a.a(android.app.Activity, com.paytm.network.listener.b):void");
    }
}
