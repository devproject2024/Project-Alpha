package net.one97.paytm.nativesdk.app;

import android.os.Bundle;
import java.util.Map;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;

public interface PaytmSDKCallbackListener {
    void logCrashAnalytics(String str, String str2);

    void logException(String str, String str2, Throwable th);

    void networkError();

    void onBackPressedCancelTransaction();

    void onSessionExpire(CustomVolleyError customVolleyError);

    void onTransactionCancel(String str);

    void onTransactionResponse(Bundle bundle);

    void performGAOperation(Map<String, Object> map);
}
