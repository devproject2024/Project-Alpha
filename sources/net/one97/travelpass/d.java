package net.one97.travelpass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.travel.common.a.c;
import com.travel.utils.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.travelpass.e.i;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    private static d f30316c;

    /* renamed from: a  reason: collision with root package name */
    public e f30317a;

    /* renamed from: b  reason: collision with root package name */
    com.travel.common.a.a f30318b;

    private d() {
    }

    public static e b() {
        return a().f30317a;
    }

    static class a implements e {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final String a() {
            return d.a().f30318b.getAppManagerStringValue("cashbackInfoMessage", "");
        }

        public final void a(String str, Map<String, Object> map, Context context) {
            d.a().f30318b.sendCustomEventWithMap(str, new HashMap(map), context);
        }

        public final void a(Context context, Intent intent) {
            d.a().f30318b.startReachargePaymentActivity(context, intent);
        }

        public final void a(Context context, Intent intent, int i2) {
            d.a().f30318b.startLoginActivityForResult(context, intent, i2);
        }

        public final boolean a(Context context, String str) {
            return d.a().f30318b.handleDeeplink(context, str, (Bundle) null);
        }

        public final void a(Context context, Bundle bundle) {
            d.a().f30318b.startCSTOrderIssuesActivity(context, bundle, (m) null);
        }

        public final String a(String str) {
            return d.a().f30318b.getAppManagerStringValue(str, "");
        }

        public final String a(CJRPGTokenList cJRPGTokenList) {
            return d.a().f30318b.getPgToken(cJRPGTokenList);
        }

        public final void a(Context context, CJRRechargePayment cJRRechargePayment, FetchPayOptionsListener fetchPayOptionsListener) {
            PaytmSDK.setServer(Server.PRODUCTION);
            new FetchOptionsRequest(context, cJRRechargePayment.getMID(), cJRRechargePayment.getOrderId(), cJRRechargePayment.getmTxnToken(), fetchPayOptionsListener).executeRequest();
        }

        public final String b(String str) {
            return "paytmmp://bus_order_summary?order_id=".concat(String.valueOf(str));
        }

        public final String c(String str) {
            return "paytmmp://train_order_summary_v2?url=" + d.a().f30318b.getAppManagerStringValue("URLTrainsNewOrderSummary", "") + str;
        }

        public final String d(String str) {
            return "paytmmp://flight_order_summary?order_id=".concat(String.valueOf(str));
        }

        public final String e(String str) {
            return "paytmmp://hotel_order_summary?order_id=".concat(String.valueOf(str));
        }

        public final String a(Context context) {
            return i.a(context.getApplicationContext()).b("wallet_sso_token=", "", true);
        }

        public final boolean b(Context context) {
            if (!TextUtils.isEmpty(a(context))) {
                if (System.currentTimeMillis() < i.a(context.getApplicationContext()).b("wallet_token_expire=", 0, true)) {
                    return true;
                }
            }
            return false;
        }

        public final void a(String str, String str2, String str3, String str4, Map<String, Object> map) {
            d.a().f30318b.sendPulseEvents(str, str2, str3, str4, c.TRAVELPASS, map);
        }

        public final void a(Activity activity, b bVar) {
            d.a().f30318b.getWalletToken(a.c.TRAVEL_PASS, activity, bVar);
        }

        public final void a(Activity activity, Exception exc) {
            d.a().f30318b.showSessionTimeoutAlert(activity, (String) null, (Bundle) null, exc, false, false);
        }
    }

    public static d a() {
        if (f30316c == null) {
            d dVar = new d();
            f30316c = dVar;
            dVar.f30317a = new a((byte) 0);
            f30316c.f30318b = q.a();
        }
        return f30316c;
    }
}
