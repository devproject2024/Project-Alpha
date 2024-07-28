package net.one97.paytm.dynamic.module.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.deeplink.ak;
import net.one97.paytm.j.c;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.wifi.b;

public class WifiJarvisHelper implements b {
    private static WifiJarvisHelper mInstance;
    private c gtmLoader = c.a();

    private WifiJarvisHelper() {
    }

    public static WifiJarvisHelper getInstance() {
        if (mInstance == null) {
            mInstance = new WifiJarvisHelper();
        }
        return mInstance;
    }

    public void startRechargePaymentActivity(Context context, Intent intent, CJRRechargePayment cJRRechargePayment) {
        ak akVar = ak.f50322a;
        ak.a(context, intent, cJRRechargePayment);
    }

    public String initPreVerifyNativePGFlow(String str) {
        ak akVar = ak.f50322a;
        return ak.a(str);
    }

    public void startMainActivity(Context context, Intent intent) {
        ak akVar = ak.f50322a;
        ak.a(context, intent);
    }

    public boolean reportError(Context context, NetworkCustomError networkCustomError, String str) {
        ak akVar = ak.f50322a;
        return ak.a(context, networkCustomError, str);
    }

    public void handleError(Activity activity, NetworkCustomError networkCustomError, String str, Bundle bundle, boolean z) {
        ak akVar = ak.f50322a;
        ak.a(activity, networkCustomError);
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        ak akVar = ak.f50322a;
        ak.a(activity, str, bundle, networkCustomError);
    }

    public String getCartVerifyUrl() {
        return c.a("cartVerify", (String) null);
    }

    public String getDynamicRechargeUrl() {
        return c.a("dynamicBrowsePlans", (String) null);
    }

    public String getCartCheckoutUrl() {
        return c.a("cartCheckout", (String) null);
    }

    public boolean isIncludeResponse() {
        return c.a(UpiConstantServiceApi.KEY_INCLUDE_RESPONSE_ERROR_ANALYTICS, false);
    }

    public String getWifiSSIDMap() {
        return c.a("paytm_wifi_ssid_map", (String) null);
    }
}
