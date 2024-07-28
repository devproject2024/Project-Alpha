package net.one97.paytm.wifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;

public interface b {
    String getCartCheckoutUrl();

    String getCartVerifyUrl();

    String getDynamicRechargeUrl();

    String getWifiSSIDMap();

    void handleError(Activity activity, NetworkCustomError networkCustomError, String str, Bundle bundle, boolean z);

    String initPreVerifyNativePGFlow(String str);

    boolean reportError(Context context, NetworkCustomError networkCustomError, String str);

    void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError);

    void startMainActivity(Context context, Intent intent);

    void startRechargePaymentActivity(Context context, Intent intent, CJRRechargePayment cJRRechargePayment);
}
