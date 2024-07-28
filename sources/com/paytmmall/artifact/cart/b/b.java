package com.paytmmall.artifact.cart.b;

import android.content.Context;
import android.content.Intent;
import com.paytm.utility.q;
import com.paytmmall.artifact.cart.entity.CJRParcelTrackingInfo;
import com.paytmmall.artifact.cart.entity.CJRRechargePayment;
import com.paytmmall.artifact.d.d;
import com.paytmmall.artifact.d.t;
import com.paytmmall.artifact.d.w;
import com.paytmmall.artifact.e.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f15515a = "CheckoutHelper";

    public static void a(Context context, HashMap<String, Object> hashMap, w wVar) {
        if (hashMap.containsKey("placeOrderResponse") && hashMap.containsKey("parcelTrackingInfo")) {
            CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
            cJRRechargePayment.parseJSONObject(String.valueOf(hashMap.get("placeOrderResponse")));
            if (hashMap.containsKey("delayedOrderPayload")) {
                cJRRechargePayment.setDelayedOrderPayload(String.valueOf(hashMap.get("delayedOrderPayload")));
            }
            CJRParcelTrackingInfo cJRParcelTrackingInfo = (CJRParcelTrackingInfo) a.a(String.valueOf(hashMap.get("parcelTrackingInfo")), CJRParcelTrackingInfo.class);
            boolean parseBoolean = hashMap.containsKey(CLPConstants.IS_MGV) ? Boolean.parseBoolean(String.valueOf(hashMap.get(CLPConstants.IS_MGV))) : false;
            boolean a2 = a(hashMap);
            String a3 = a(hashMap, "paymentInstruments");
            String a4 = a(hashMap, "is_payment_intent_required");
            String a5 = a(hashMap, "offerApplyUrl");
            String a6 = a(hashMap, "paytm_cashback");
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            d.a(cJRRechargePayment, intent);
            intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
            intent.putExtra(UpiConstants.FROM, "Shopping_cart");
            if (cJRParcelTrackingInfo != null) {
                intent.putExtra("tracking_info", cJRParcelTrackingInfo);
            }
            boolean booleanExtra = intent.getBooleanExtra("nativeSdkEnabled", false);
            intent.putExtra("Cashback", a(a6));
            intent.putExtra(CLPConstants.IS_MGV, parseBoolean);
            intent.putExtra("isPAYTMSTORE", a2);
            boolean z = true;
            if (booleanExtra) {
                z = t.e().setPaymentInstruments(a3, wVar);
                intent.putExtra("key_request_code", 3612);
            }
            if (z) {
                t.a(context, intent, cJRRechargePayment, cJRParcelTrackingInfo, a4, a5, wVar);
            }
        }
    }

    private static boolean a(HashMap<String, Object> hashMap) {
        boolean z = false;
        try {
            JSONObject jSONObject = new JSONObject(hashMap.get("orderSummary").toString());
            if (hashMap.get("orderSummary") != null) {
                if (Boolean.parseBoolean(jSONObject.optString("flag"))) {
                    if (jSONObject.optString("domain").contains("paytmstores.com")) {
                        z = true;
                    }
                }
                if (z) {
                    com.paytmmall.a.a.a(jSONObject.optString("domain"));
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    private static String a(HashMap<String, Object> hashMap, String str) {
        return hashMap != null ? String.valueOf(hashMap.get(str)) : "";
    }

    private static double a(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e2) {
            q.c(e2.getMessage());
            return 0.0d;
        }
    }
}
