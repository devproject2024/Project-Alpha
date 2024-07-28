package net.one97.paytm.nativesdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import net.one97.paytm.nativesdk.common.model.CustomVolleyError;
import net.one97.paytm.nativesdk.instruments.upipush.model.UpiProfile;

public interface UpiPushCallbackListener {

    public interface CheckBalanceListener {
        void onError(int i2, String str, boolean z);

        void onFetchBalanceSuccess(String str);

        void onRequestEnd();

        void onRequestStart();
    }

    public interface FetchUpiSeqNoListener {
        void setUpiMetaData(HashMap<String, String> hashMap);
    }

    public interface UpiProfileListener {
        void onError();

        void onSuccess(UpiProfile upiProfile);
    }

    void checkBalance(Activity activity, String str, int i2, CheckBalanceListener checkBalanceListener);

    void fetchNewUpiProfile(UpiProfileListener upiProfileListener);

    void fetchUpiSeqNo(FetchUpiSeqNoListener fetchUpiSeqNoListener);

    void onUpiPushTxnFailure(String str, CustomVolleyError customVolleyError);

    void openMPINScreen(Context context, Bundle bundle);

    void setUpiPin(Activity activity, String str, int i2);

    void startBankVpaCreationActivity(Activity activity, String str, Intent intent, int i2);

    void startUpiOnBoarding(Activity activity, int i2);
}
